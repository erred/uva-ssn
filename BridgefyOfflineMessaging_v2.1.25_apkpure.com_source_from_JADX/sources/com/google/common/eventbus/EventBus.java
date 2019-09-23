package com.google.common.eventbus;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import com.google.common.reflect.TypeToken;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

@Beta
public class EventBus {
    private static final LoadingCache<Class<?>, Set<Class<?>>> flattenHierarchyCache = CacheBuilder.newBuilder().weakKeys().build(new CacheLoader<Class<?>, Set<Class<?>>>() {
        public Set<Class<?>> load(Class<?> cls) {
            return TypeToken.m8761of(cls).getTypes().rawTypes();
        }
    });
    private final ThreadLocal<Queue<EventWithSubscriber>> eventsToDispatch;
    private final SubscriberFindingStrategy finder;
    private final ThreadLocal<Boolean> isDispatching;
    private SubscriberExceptionHandler subscriberExceptionHandler;
    private final SetMultimap<Class<?>, EventSubscriber> subscribersByType;
    private final ReadWriteLock subscribersByTypeLock;

    static class EventWithSubscriber {
        final Object event;
        final EventSubscriber subscriber;

        public EventWithSubscriber(Object obj, EventSubscriber eventSubscriber) {
            this.event = Preconditions.checkNotNull(obj);
            this.subscriber = (EventSubscriber) Preconditions.checkNotNull(eventSubscriber);
        }
    }

    private static final class LoggingSubscriberExceptionHandler implements SubscriberExceptionHandler {
        private final Logger logger;

        public LoggingSubscriberExceptionHandler(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(EventBus.class.getName());
            sb.append(".");
            sb.append((String) Preconditions.checkNotNull(str));
            this.logger = Logger.getLogger(sb.toString());
        }

        public void handleException(Throwable th, SubscriberExceptionContext subscriberExceptionContext) {
            // Logger logger2 = this.logger;
            Level level = Level.SEVERE;
            StringBuilder sb = new StringBuilder();
            sb.append("Could not dispatch event: ");
            sb.append(subscriberExceptionContext.getSubscriber());
            sb.append(" to ");
            sb.append(subscriberExceptionContext.getSubscriberMethod());
            logger2.log(level, sb.toString(), th.getCause());
        }
    }

    public EventBus() {
        this("default");
    }

    public EventBus(String str) {
        this((SubscriberExceptionHandler) new LoggingSubscriberExceptionHandler(str));
    }

    public EventBus(SubscriberExceptionHandler subscriberExceptionHandler2) {
        this.subscribersByType = HashMultimap.create();
        this.subscribersByTypeLock = new ReentrantReadWriteLock();
        this.finder = new AnnotatedSubscriberFinder();
        this.eventsToDispatch = new ThreadLocal<Queue<EventWithSubscriber>>() {
            /* access modifiers changed from: protected */
            public Queue<EventWithSubscriber> initialValue() {
                return new LinkedList();
            }
        };
        this.isDispatching = new ThreadLocal<Boolean>() {
            /* access modifiers changed from: protected */
            public Boolean initialValue() {
                return Boolean.valueOf(false);
            }
        };
        this.subscriberExceptionHandler = (SubscriberExceptionHandler) Preconditions.checkNotNull(subscriberExceptionHandler2);
    }

    public void register(Object obj) {
        Multimap findAllSubscribers = this.finder.findAllSubscribers(obj);
        this.subscribersByTypeLock.writeLock().lock();
        try {
            this.subscribersByType.putAll(findAllSubscribers);
        } finally {
            this.subscribersByTypeLock.writeLock().unlock();
        }
    }

    public void unregister(Object obj) {
        for (Entry entry : this.finder.findAllSubscribers(obj).asMap().entrySet()) {
            Class cls = (Class) entry.getKey();
            Collection collection = (Collection) entry.getValue();
            this.subscribersByTypeLock.writeLock().lock();
            try {
                Set set = this.subscribersByType.get(cls);
                if (set.containsAll(collection)) {
                    set.removeAll(collection);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("missing event subscriber for an annotated method. Is ");
                    sb.append(obj);
                    sb.append(" registered?");
                    throw new IllegalArgumentException(sb.toString());
                }
            } finally {
                this.subscribersByTypeLock.writeLock().unlock();
            }
        }
    }

    public void post(Object obj) {
        boolean z = false;
        for (Class cls : flattenHierarchy(obj.getClass())) {
            this.subscribersByTypeLock.readLock().lock();
            try {
                Set<EventSubscriber> set = this.subscribersByType.get(cls);
                if (!set.isEmpty()) {
                    z = true;
                    for (EventSubscriber enqueueEvent : set) {
                        enqueueEvent(obj, enqueueEvent);
                    }
                }
            } finally {
                this.subscribersByTypeLock.readLock().unlock();
            }
        }
        if (!z && !(obj instanceof DeadEvent)) {
            post(new DeadEvent(this, obj));
        }
        dispatchQueuedEvents();
    }

    /* access modifiers changed from: 0000 */
    public void enqueueEvent(Object obj, EventSubscriber eventSubscriber) {
        ((Queue) this.eventsToDispatch.get()).offer(new EventWithSubscriber(obj, eventSubscriber));
    }

    /* access modifiers changed from: 0000 */
    public void dispatchQueuedEvents() {
        if (!((Boolean) this.isDispatching.get()).booleanValue()) {
            this.isDispatching.set(Boolean.valueOf(true));
            try {
                Queue queue = (Queue) this.eventsToDispatch.get();
                while (true) {
                    EventWithSubscriber eventWithSubscriber = (EventWithSubscriber) queue.poll();
                    if (eventWithSubscriber != null) {
                        dispatch(eventWithSubscriber.event, eventWithSubscriber.subscriber);
                    } else {
                        return;
                    }
                }
            } finally {
                this.isDispatching.remove();
                this.eventsToDispatch.remove();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void dispatch(Object obj, EventSubscriber eventSubscriber) {
        try {
            eventSubscriber.handleEvent(obj);
        } catch (InvocationTargetException e) {
            this.subscriberExceptionHandler.handleException(e.getCause(), new SubscriberExceptionContext(this, obj, eventSubscriber.getSubscriber(), eventSubscriber.getMethod()));
        } catch (Throwable th) {
            // Logger.getLogger(EventBus.class.getName()).log(Level.SEVERE, String.format("Exception %s thrown while handling exception: %s", new Object[]{th, e.getCause()}), th);
        }
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    public Set<Class<?>> flattenHierarchy(Class<?> cls) {
        try {
            return (Set) flattenHierarchyCache.getUnchecked(cls);
        } catch (UncheckedExecutionException e) {
            throw Throwables.propagate(e.getCause());
        }
    }
}

package p000a.p001a.p002a.p003a.p004a.p007c;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import p000a.p001a.p002a.p003a.p004a.p007c.C0060b;
import p000a.p001a.p002a.p003a.p004a.p007c.C0069i;
import p000a.p001a.p002a.p003a.p004a.p007c.C0073l;

/* renamed from: a.a.a.a.a.c.c */
/* compiled from: DependencyPriorityBlockingQueue */
public class C0061c<E extends C0060b & C0073l & C0069i> extends PriorityBlockingQueue<E> {

    /* renamed from: a */
    final Queue<E> f138a = new LinkedList();

    /* renamed from: b */
    private final ReentrantLock f139b = new ReentrantLock();

    /* renamed from: a */
    public E take() throws InterruptedException {
        return mo115b(0, null, null);
    }

    /* renamed from: b */
    public E peek() {
        try {
            return mo115b(1, null, null);
        } catch (InterruptedException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
        return mo115b(3, Long.valueOf(j), timeUnit);
    }

    /* renamed from: c */
    public E poll() {
        try {
            return mo115b(2, null, null);
        } catch (InterruptedException unused) {
            return null;
        }
    }

    public int size() {
        try {
            this.f139b.lock();
            return this.f138a.size() + super.size();
        } finally {
            this.f139b.unlock();
        }
    }

    public <T> T[] toArray(T[] tArr) {
        try {
            this.f139b.lock();
            return mo113a((T[]) super.toArray(tArr), (T[]) this.f138a.toArray(tArr));
        } finally {
            this.f139b.unlock();
        }
    }

    public Object[] toArray() {
        try {
            this.f139b.lock();
            return mo113a((T[]) super.toArray(), (T[]) this.f138a.toArray());
        } finally {
            this.f139b.unlock();
        }
    }

    public int drainTo(Collection<? super E> collection) {
        try {
            this.f139b.lock();
            int drainTo = super.drainTo(collection) + this.f138a.size();
            while (!this.f138a.isEmpty()) {
                collection.add(this.f138a.poll());
            }
            return drainTo;
        } finally {
            this.f139b.unlock();
        }
    }

    public int drainTo(Collection<? super E> collection, int i) {
        try {
            this.f139b.lock();
            int drainTo = super.drainTo(collection, i);
            while (!this.f138a.isEmpty() && drainTo <= i) {
                collection.add(this.f138a.poll());
                drainTo++;
            }
            return drainTo;
        } finally {
            this.f139b.unlock();
        }
    }

    public boolean contains(Object obj) {
        try {
            this.f139b.lock();
            return super.contains(obj) || this.f138a.contains(obj);
        } finally {
            this.f139b.unlock();
        }
    }

    public void clear() {
        try {
            this.f139b.lock();
            this.f138a.clear();
            super.clear();
        } finally {
            this.f139b.unlock();
        }
    }

    public boolean remove(Object obj) {
        try {
            this.f139b.lock();
            return super.remove(obj) || this.f138a.remove(obj);
        } finally {
            this.f139b.unlock();
        }
    }

    public boolean removeAll(Collection<?> collection) {
        try {
            this.f139b.lock();
            return this.f138a.removeAll(collection) | super.removeAll(collection);
        } finally {
            this.f139b.unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public E mo109a(int i, Long l, TimeUnit timeUnit) throws InterruptedException {
        E e;
        switch (i) {
            case 0:
                e = (C0060b) super.take();
                break;
            case 1:
                e = (C0060b) super.peek();
                break;
            case 2:
                e = (C0060b) super.poll();
                break;
            case 3:
                e = (C0060b) super.poll(l.longValue(), timeUnit);
                break;
            default:
                return null;
        }
        return e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo111a(int i, E e) {
        try {
            this.f139b.lock();
            if (i == 1) {
                super.remove(e);
            }
            boolean offer = this.f138a.offer(e);
            return offer;
        } finally {
            this.f139b.unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public E mo115b(int i, Long l, TimeUnit timeUnit) throws InterruptedException {
        E a;
        while (true) {
            a = mo109a(i, l, timeUnit);
            if (a == null || mo112a(a)) {
                return a;
            }
            mo111a(i, a);
        }
        return a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo112a(E e) {
        return e.mo107d();
    }

    /* renamed from: d */
    public void mo119d() {
        try {
            this.f139b.lock();
            Iterator it = this.f138a.iterator();
            while (it.hasNext()) {
                C0060b bVar = (C0060b) it.next();
                if (mo112a(bVar)) {
                    super.offer(bVar);
                    it.remove();
                }
            }
        } finally {
            this.f139b.unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public <T> T[] mo113a(T[] tArr, T[] tArr2) {
        int length = tArr.length;
        int length2 = tArr2.length;
        T[] tArr3 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), length + length2);
        System.arraycopy(tArr, 0, tArr3, 0, length);
        System.arraycopy(tArr2, 0, tArr3, length, length2);
        return tArr3;
    }
}

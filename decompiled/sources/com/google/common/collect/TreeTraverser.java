package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

@GwtCompatible(emulated = true)
@Beta
public abstract class TreeTraverser<T> {

    private final class BreadthFirstIterator extends UnmodifiableIterator<T> implements PeekingIterator<T> {
        private final Queue<T> queue = new LinkedList();

        BreadthFirstIterator(T t) {
            this.queue.add(t);
        }

        public boolean hasNext() {
            return !this.queue.isEmpty();
        }

        public T peek() {
            return this.queue.element();
        }

        public T next() {
            T remove = this.queue.remove();
            Iterables.addAll(this.queue, TreeTraverser.this.children(remove));
            return remove;
        }
    }

    private final class PostOrderIterator extends AbstractIterator<T> {
        private final LinkedList<PostOrderNode<T>> stack = new LinkedList<>();

        PostOrderIterator(T t) {
            this.stack.addLast(expand(t));
        }

        /* access modifiers changed from: protected */
        public T computeNext() {
            while (!this.stack.isEmpty()) {
                PostOrderNode postOrderNode = (PostOrderNode) this.stack.getLast();
                if (postOrderNode.childIterator.hasNext()) {
                    this.stack.addLast(expand(postOrderNode.childIterator.next()));
                } else {
                    this.stack.removeLast();
                    return postOrderNode.root;
                }
            }
            return endOfData();
        }

        private PostOrderNode<T> expand(T t) {
            return new PostOrderNode<>(t, TreeTraverser.this.children(t).iterator());
        }
    }

    private static final class PostOrderNode<T> {
        final Iterator<T> childIterator;
        final T root;

        PostOrderNode(T t, Iterator<T> it) {
            this.root = Preconditions.checkNotNull(t);
            this.childIterator = (Iterator) Preconditions.checkNotNull(it);
        }
    }

    private final class PreOrderIterator extends UnmodifiableIterator<T> {
        private final LinkedList<Iterator<T>> stack = new LinkedList<>();

        PreOrderIterator(T t) {
            this.stack.addLast(Iterators.singletonIterator(Preconditions.checkNotNull(t)));
        }

        public boolean hasNext() {
            return !this.stack.isEmpty();
        }

        public T next() {
            Iterator it = (Iterator) this.stack.getLast();
            T checkNotNull = Preconditions.checkNotNull(it.next());
            if (!it.hasNext()) {
                this.stack.removeLast();
            }
            Iterator it2 = TreeTraverser.this.children(checkNotNull).iterator();
            if (it2.hasNext()) {
                this.stack.addLast(it2);
            }
            return checkNotNull;
        }
    }

    public abstract Iterable<T> children(T t);

    public final FluentIterable<T> preOrderTraversal(final T t) {
        Preconditions.checkNotNull(t);
        return new FluentIterable<T>() {
            public UnmodifiableIterator<T> iterator() {
                return TreeTraverser.this.preOrderIterator(t);
            }
        };
    }

    /* access modifiers changed from: 0000 */
    public UnmodifiableIterator<T> preOrderIterator(T t) {
        return new PreOrderIterator(t);
    }

    public final FluentIterable<T> postOrderTraversal(final T t) {
        Preconditions.checkNotNull(t);
        return new FluentIterable<T>() {
            public UnmodifiableIterator<T> iterator() {
                return TreeTraverser.this.postOrderIterator(t);
            }
        };
    }

    /* access modifiers changed from: 0000 */
    public UnmodifiableIterator<T> postOrderIterator(T t) {
        return new PostOrderIterator(t);
    }

    public final FluentIterable<T> breadthFirstTraversal(final T t) {
        Preconditions.checkNotNull(t);
        return new FluentIterable<T>() {
            public UnmodifiableIterator<T> iterator() {
                return new BreadthFirstIterator(t);
            }
        };
    }
}

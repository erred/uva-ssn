package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Iterator;

@GwtCompatible
@Beta
public abstract class Converter<A, B> implements Function<A, B> {
    private final boolean handleNullAutomatically;
    private transient Converter<B, A> reverse;

    private static final class ConverterComposition<A, B, C> extends Converter<A, C> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> first;
        final Converter<B, C> second;

        ConverterComposition(Converter<A, B> converter, Converter<B, C> converter2) {
            this.first = converter;
            this.second = converter2;
        }

        /* access modifiers changed from: protected */
        public C doForward(A a) {
            throw new AssertionError();
        }

        /* access modifiers changed from: protected */
        public A doBackward(C c) {
            throw new AssertionError();
        }

        /* access modifiers changed from: 0000 */
        public C correctedDoForward(A a) {
            return this.second.correctedDoForward(this.first.correctedDoForward(a));
        }

        /* access modifiers changed from: 0000 */
        public A correctedDoBackward(C c) {
            return this.first.correctedDoBackward(this.second.correctedDoBackward(c));
        }

        public boolean equals(Object obj) {
            boolean z = false;
            if (!(obj instanceof ConverterComposition)) {
                return false;
            }
            ConverterComposition converterComposition = (ConverterComposition) obj;
            if (this.first.equals(converterComposition.first) && this.second.equals(converterComposition.second)) {
                z = true;
            }
            return z;
        }

        public int hashCode() {
            return (this.first.hashCode() * 31) + this.second.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.first);
            sb.append(".andThen(");
            sb.append(this.second);
            sb.append(")");
            return sb.toString();
        }
    }

    private static final class FunctionBasedConverter<A, B> extends Converter<A, B> implements Serializable {
        private final Function<? super B, ? extends A> backwardFunction;
        private final Function<? super A, ? extends B> forwardFunction;

        private FunctionBasedConverter(Function<? super A, ? extends B> function, Function<? super B, ? extends A> function2) {
            this.forwardFunction = (Function) Preconditions.checkNotNull(function);
            this.backwardFunction = (Function) Preconditions.checkNotNull(function2);
        }

        /* access modifiers changed from: protected */
        public B doForward(A a) {
            return this.forwardFunction.apply(a);
        }

        /* access modifiers changed from: protected */
        public A doBackward(B b) {
            return this.backwardFunction.apply(b);
        }

        public boolean equals(Object obj) {
            boolean z = false;
            if (!(obj instanceof FunctionBasedConverter)) {
                return false;
            }
            FunctionBasedConverter functionBasedConverter = (FunctionBasedConverter) obj;
            if (this.forwardFunction.equals(functionBasedConverter.forwardFunction) && this.backwardFunction.equals(functionBasedConverter.backwardFunction)) {
                z = true;
            }
            return z;
        }

        public int hashCode() {
            return (this.forwardFunction.hashCode() * 31) + this.backwardFunction.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Converter.from(");
            sb.append(this.forwardFunction);
            sb.append(", ");
            sb.append(this.backwardFunction);
            sb.append(")");
            return sb.toString();
        }
    }

    private static final class IdentityConverter<T> extends Converter<T, T> implements Serializable {
        static final IdentityConverter INSTANCE = new IdentityConverter();
        private static final long serialVersionUID = 0;

        /* access modifiers changed from: protected */
        public T doBackward(T t) {
            return t;
        }

        /* access modifiers changed from: protected */
        public T doForward(T t) {
            return t;
        }

        public IdentityConverter<T> reverse() {
            return this;
        }

        public String toString() {
            return "Converter.identity()";
        }

        private IdentityConverter() {
        }

        public <S> Converter<T, S> andThen(Converter<T, S> converter) {
            return (Converter) Preconditions.checkNotNull(converter, "otherConverter");
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    private static final class ReverseConverter<A, B> extends Converter<B, A> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> original;

        ReverseConverter(Converter<A, B> converter) {
            this.original = converter;
        }

        /* access modifiers changed from: protected */
        public A doForward(B b) {
            throw new AssertionError();
        }

        /* access modifiers changed from: protected */
        public B doBackward(A a) {
            throw new AssertionError();
        }

        /* access modifiers changed from: 0000 */
        public A correctedDoForward(B b) {
            return this.original.correctedDoBackward(b);
        }

        /* access modifiers changed from: 0000 */
        public B correctedDoBackward(A a) {
            return this.original.correctedDoForward(a);
        }

        public Converter<A, B> reverse() {
            return this.original;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ReverseConverter)) {
                return false;
            }
            return this.original.equals(((ReverseConverter) obj).original);
        }

        public int hashCode() {
            return ~this.original.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.original);
            sb.append(".reverse()");
            return sb.toString();
        }
    }

    /* access modifiers changed from: protected */
    public abstract A doBackward(B b);

    /* access modifiers changed from: protected */
    public abstract B doForward(A a);

    protected Converter() {
        this(true);
    }

    Converter(boolean z) {
        this.handleNullAutomatically = z;
    }

    public final B convert(A a) {
        return correctedDoForward(a);
    }

    /* access modifiers changed from: 0000 */
    public B correctedDoForward(A a) {
        B b;
        if (!this.handleNullAutomatically) {
            return doForward(a);
        }
        if (a == null) {
            b = null;
        } else {
            b = Preconditions.checkNotNull(doForward(a));
        }
        return b;
    }

    /* access modifiers changed from: 0000 */
    public A correctedDoBackward(B b) {
        A a;
        if (!this.handleNullAutomatically) {
            return doBackward(b);
        }
        if (b == null) {
            a = null;
        } else {
            a = Preconditions.checkNotNull(doBackward(b));
        }
        return a;
    }

    public Iterable<B> convertAll(final Iterable<? extends A> iterable) {
        Preconditions.checkNotNull(iterable, "fromIterable");
        return new Iterable<B>() {
            public Iterator<B> iterator() {
                return new Iterator<B>() {
                    private final Iterator<? extends A> fromIterator = iterable.iterator();

                    public boolean hasNext() {
                        return this.fromIterator.hasNext();
                    }

                    public B next() {
                        return Converter.this.convert(this.fromIterator.next());
                    }

                    public void remove() {
                        this.fromIterator.remove();
                    }
                };
            }
        };
    }

    public Converter<B, A> reverse() {
        Converter<B, A> converter = this.reverse;
        if (converter != null) {
            return converter;
        }
        ReverseConverter reverseConverter = new ReverseConverter(this);
        this.reverse = reverseConverter;
        return reverseConverter;
    }

    public <C> Converter<A, C> andThen(Converter<B, C> converter) {
        return new ConverterComposition(this, (Converter) Preconditions.checkNotNull(converter));
    }

    @Deprecated
    public final B apply(A a) {
        return convert(a);
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static <A, B> Converter<A, B> from(Function<? super A, ? extends B> function, Function<? super B, ? extends A> function2) {
        return new FunctionBasedConverter(function, function2);
    }

    public static <T> Converter<T, T> identity() {
        return IdentityConverter.INSTANCE;
    }
}

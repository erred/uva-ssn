package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Primitives;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Beta
public abstract class TypeToken<T> extends TypeCapture<T> implements Serializable {
    /* access modifiers changed from: private */
    public final Type runtimeType;
    private transient TypeResolver typeResolver;

    private final class ClassSet extends TypeSet {
        private static final long serialVersionUID = 0;
        private transient ImmutableSet<TypeToken<? super T>> classes;

        public TypeSet classes() {
            return this;
        }

        private ClassSet() {
            super();
        }

        /* access modifiers changed from: protected */
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.classes;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<? super T>> set = FluentIterable.from((Iterable<E>) TypeCollector.FOR_GENERIC_TYPE.classesOnly().collectTypes(TypeToken.this)).filter((Predicate<? super E>) TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).toSet();
            this.classes = set;
            return set;
        }

        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf((Collection<? extends E>) TypeCollector.FOR_RAW_TYPE.classesOnly().collectTypes((Iterable<? extends K>) TypeToken.this.getImmediateRawTypes()));
        }

        public TypeSet interfaces() {
            throw new UnsupportedOperationException("classes().interfaces() not supported.");
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().classes();
        }
    }

    private final class InterfaceSet extends TypeSet {
        private static final long serialVersionUID = 0;
        private final transient TypeSet allTypes;
        private transient ImmutableSet<TypeToken<? super T>> interfaces;

        public TypeSet interfaces() {
            return this;
        }

        InterfaceSet(TypeSet typeSet) {
            super();
            this.allTypes = typeSet;
        }

        /* access modifiers changed from: protected */
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.interfaces;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<? super T>> set = FluentIterable.from((Iterable<E>) this.allTypes).filter((Predicate<? super E>) TypeFilter.INTERFACE_ONLY).toSet();
            this.interfaces = set;
            return set;
        }

        public Set<Class<? super T>> rawTypes() {
            return FluentIterable.from((Iterable<E>) TypeCollector.FOR_RAW_TYPE.collectTypes((Iterable<? extends K>) TypeToken.this.getImmediateRawTypes())).filter((Predicate<? super E>) new Predicate<Class<?>>() {
                public boolean apply(Class<?> cls) {
                    return cls.isInterface();
                }
            }).toSet();
        }

        public TypeSet classes() {
            throw new UnsupportedOperationException("interfaces().classes() not supported.");
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().interfaces();
        }
    }

    private static final class SimpleTypeToken<T> extends TypeToken<T> {
        private static final long serialVersionUID = 0;

        SimpleTypeToken(Type type) {
            super(type);
        }
    }

    private static abstract class TypeCollector<K> {
        static final TypeCollector<TypeToken<?>> FOR_GENERIC_TYPE = new TypeCollector<TypeToken<?>>() {
            /* access modifiers changed from: 0000 */
            public Class<?> getRawType(TypeToken<?> typeToken) {
                return typeToken.getRawType();
            }

            /* access modifiers changed from: 0000 */
            public Iterable<? extends TypeToken<?>> getInterfaces(TypeToken<?> typeToken) {
                return typeToken.getGenericInterfaces();
            }

            /* access modifiers changed from: 0000 */
            public TypeToken<?> getSuperclass(TypeToken<?> typeToken) {
                return typeToken.getGenericSuperclass();
            }
        };
        static final TypeCollector<Class<?>> FOR_RAW_TYPE = new TypeCollector<Class<?>>() {
            /* access modifiers changed from: 0000 */
            public Class<?> getRawType(Class<?> cls) {
                return cls;
            }

            /* access modifiers changed from: 0000 */
            public Iterable<? extends Class<?>> getInterfaces(Class<?> cls) {
                return Arrays.asList(cls.getInterfaces());
            }

            /* access modifiers changed from: 0000 */
            public Class<?> getSuperclass(Class<?> cls) {
                return cls.getSuperclass();
            }
        };

        private static class ForwardingTypeCollector<K> extends TypeCollector<K> {
            private final TypeCollector<K> delegate;

            ForwardingTypeCollector(TypeCollector<K> typeCollector) {
                super();
                this.delegate = typeCollector;
            }

            /* access modifiers changed from: 0000 */
            public Class<?> getRawType(K k) {
                return this.delegate.getRawType(k);
            }

            /* access modifiers changed from: 0000 */
            public Iterable<? extends K> getInterfaces(K k) {
                return this.delegate.getInterfaces(k);
            }

            /* access modifiers changed from: 0000 */
            public K getSuperclass(K k) {
                return this.delegate.getSuperclass(k);
            }
        }

        /* access modifiers changed from: 0000 */
        public abstract Iterable<? extends K> getInterfaces(K k);

        /* access modifiers changed from: 0000 */
        public abstract Class<?> getRawType(K k);

        /* access modifiers changed from: 0000 */
        public abstract K getSuperclass(K k);

        private TypeCollector() {
        }

        /* access modifiers changed from: 0000 */
        public final TypeCollector<K> classesOnly() {
            return new ForwardingTypeCollector<K>(this) {
                /* access modifiers changed from: 0000 */
                public Iterable<? extends K> getInterfaces(K k) {
                    return ImmutableSet.m8706of();
                }

                /* access modifiers changed from: 0000 */
                public ImmutableList<K> collectTypes(Iterable<? extends K> iterable) {
                    Builder builder = ImmutableList.builder();
                    for (Object next : iterable) {
                        if (!getRawType(next).isInterface()) {
                            builder.add(next);
                        }
                    }
                    return super.collectTypes((Iterable<? extends K>) builder.build());
                }
            };
        }

        /* access modifiers changed from: 0000 */
        public final ImmutableList<K> collectTypes(K k) {
            return collectTypes((Iterable<? extends K>) ImmutableList.m8669of(k));
        }

        /* access modifiers changed from: 0000 */
        public ImmutableList<K> collectTypes(Iterable<? extends K> iterable) {
            HashMap newHashMap = Maps.newHashMap();
            for (Object collectTypes : iterable) {
                collectTypes(collectTypes, newHashMap);
            }
            return sortKeysByValue(newHashMap, Ordering.natural().reverse());
        }

        private int collectTypes(K k, Map<? super K, Integer> map) {
            Integer num = (Integer) map.get(this);
            if (num != null) {
                return num.intValue();
            }
            int isInterface = getRawType(k).isInterface();
            for (Object collectTypes : getInterfaces(k)) {
                isInterface = Math.max(isInterface, collectTypes(collectTypes, map));
            }
            Object superclass = getSuperclass(k);
            if (superclass != null) {
                isInterface = Math.max(isInterface, collectTypes(superclass, map));
            }
            int i = isInterface + 1;
            map.put(k, Integer.valueOf(i));
            return i;
        }

        private static <K, V> ImmutableList<K> sortKeysByValue(final Map<K, V> map, final Comparator<? super V> comparator) {
            return new Ordering<K>() {
                public int compare(K k, K k2) {
                    return comparator.compare(map.get(k), map.get(k2));
                }
            }.immutableSortedCopy(map.keySet());
        }
    }

    private enum TypeFilter implements Predicate<TypeToken<?>> {
        IGNORE_TYPE_VARIABLE_OR_WILDCARD {
            public boolean apply(TypeToken<?> typeToken) {
                return !(typeToken.runtimeType instanceof TypeVariable) && !(typeToken.runtimeType instanceof WildcardType);
            }
        },
        INTERFACE_ONLY {
            public boolean apply(TypeToken<?> typeToken) {
                return typeToken.getRawType().isInterface();
            }
        }
    }

    public class TypeSet extends ForwardingSet<TypeToken<? super T>> implements Serializable {
        private static final long serialVersionUID = 0;
        private transient ImmutableSet<TypeToken<? super T>> types;

        TypeSet() {
        }

        public TypeSet interfaces() {
            return new InterfaceSet(this);
        }

        public TypeSet classes() {
            return new ClassSet();
        }

        /* access modifiers changed from: protected */
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.types;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<? super T>> set = FluentIterable.from((Iterable<E>) TypeCollector.FOR_GENERIC_TYPE.collectTypes(TypeToken.this)).filter((Predicate<? super E>) TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).toSet();
            this.types = set;
            return set;
        }

        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf((Collection<? extends E>) TypeCollector.FOR_RAW_TYPE.collectTypes((Iterable<? extends K>) TypeToken.this.getImmediateRawTypes()));
        }
    }

    protected TypeToken() {
        this.runtimeType = capture();
        Preconditions.checkState(!(this.runtimeType instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", this.runtimeType);
    }

    protected TypeToken(Class<?> cls) {
        Type capture = super.capture();
        if (capture instanceof Class) {
            this.runtimeType = capture;
        } else {
            this.runtimeType = m8761of(cls).resolveType(capture).runtimeType;
        }
    }

    private TypeToken(Type type) {
        this.runtimeType = (Type) Preconditions.checkNotNull(type);
    }

    /* renamed from: of */
    public static <T> TypeToken<T> m8761of(Class<T> cls) {
        return new SimpleTypeToken(cls);
    }

    /* renamed from: of */
    public static TypeToken<?> m8762of(Type type) {
        return new SimpleTypeToken(type);
    }

    public final Class<? super T> getRawType() {
        return getRawType(this.runtimeType);
    }

    /* access modifiers changed from: private */
    public ImmutableSet<Class<? super T>> getImmediateRawTypes() {
        return getRawTypes(this.runtimeType);
    }

    public final Type getType() {
        return this.runtimeType;
    }

    public final <X> TypeToken<T> where(TypeParameter<X> typeParameter, TypeToken<X> typeToken) {
        return new SimpleTypeToken(new TypeResolver().where(ImmutableMap.m8688of(new TypeVariableKey(typeParameter.typeVariable), typeToken.runtimeType)).resolveType(this.runtimeType));
    }

    public final <X> TypeToken<T> where(TypeParameter<X> typeParameter, Class<X> cls) {
        return where(typeParameter, m8761of(cls));
    }

    public final TypeToken<?> resolveType(Type type) {
        Preconditions.checkNotNull(type);
        TypeResolver typeResolver2 = this.typeResolver;
        if (typeResolver2 == null) {
            typeResolver2 = TypeResolver.accordingTo(this.runtimeType);
            this.typeResolver = typeResolver2;
        }
        return m8762of(typeResolver2.resolveType(type));
    }

    /* access modifiers changed from: private */
    public Type[] resolveInPlace(Type[] typeArr) {
        for (int i = 0; i < typeArr.length; i++) {
            typeArr[i] = resolveType(typeArr[i]).getType();
        }
        return typeArr;
    }

    private TypeToken<?> resolveSupertype(Type type) {
        TypeToken<?> resolveType = resolveType(type);
        resolveType.typeResolver = this.typeResolver;
        return resolveType;
    }

    /* access modifiers changed from: 0000 */
    public final TypeToken<? super T> getGenericSuperclass() {
        if (this.runtimeType instanceof TypeVariable) {
            return boundAsSuperclass(((TypeVariable) this.runtimeType).getBounds()[0]);
        }
        if (this.runtimeType instanceof WildcardType) {
            return boundAsSuperclass(((WildcardType) this.runtimeType).getUpperBounds()[0]);
        }
        Type genericSuperclass = getRawType().getGenericSuperclass();
        if (genericSuperclass == null) {
            return null;
        }
        return resolveSupertype(genericSuperclass);
    }

    private TypeToken<? super T> boundAsSuperclass(Type type) {
        TypeToken<? super T> of = m8762of(type);
        if (of.getRawType().isInterface()) {
            return null;
        }
        return of;
    }

    /* access modifiers changed from: 0000 */
    public final ImmutableList<TypeToken<? super T>> getGenericInterfaces() {
        if (this.runtimeType instanceof TypeVariable) {
            return boundsAsInterfaces(((TypeVariable) this.runtimeType).getBounds());
        }
        if (this.runtimeType instanceof WildcardType) {
            return boundsAsInterfaces(((WildcardType) this.runtimeType).getUpperBounds());
        }
        Builder builder = ImmutableList.builder();
        for (Type resolveSupertype : getRawType().getGenericInterfaces()) {
            builder.add((Object) resolveSupertype(resolveSupertype));
        }
        return builder.build();
    }

    private ImmutableList<TypeToken<? super T>> boundsAsInterfaces(Type[] typeArr) {
        Builder builder = ImmutableList.builder();
        for (Type of : typeArr) {
            TypeToken of2 = m8762of(of);
            if (of2.getRawType().isInterface()) {
                builder.add((Object) of2);
            }
        }
        return builder.build();
    }

    public final TypeSet getTypes() {
        return new TypeSet<>();
    }

    public final TypeToken<? super T> getSupertype(Class<? super T> cls) {
        Preconditions.checkArgument(cls.isAssignableFrom(getRawType()), "%s is not a super class of %s", cls, this);
        if (this.runtimeType instanceof TypeVariable) {
            return getSupertypeFromUpperBounds(cls, ((TypeVariable) this.runtimeType).getBounds());
        }
        if (this.runtimeType instanceof WildcardType) {
            return getSupertypeFromUpperBounds(cls, ((WildcardType) this.runtimeType).getUpperBounds());
        }
        if (cls.isArray()) {
            return getArraySupertype(cls);
        }
        return resolveSupertype(toGenericType(cls).runtimeType);
    }

    public final TypeToken<? extends T> getSubtype(Class<?> cls) {
        Preconditions.checkArgument(!(this.runtimeType instanceof TypeVariable), "Cannot get subtype of type variable <%s>", this);
        if (this.runtimeType instanceof WildcardType) {
            return getSubtypeFromLowerBounds(cls, ((WildcardType) this.runtimeType).getLowerBounds());
        }
        Preconditions.checkArgument(getRawType().isAssignableFrom(cls), "%s isn't a subclass of %s", cls, this);
        if (isArray()) {
            return getArraySubtype(cls);
        }
        return m8762of(resolveTypeArgsForSubclass(cls));
    }

    public final boolean isAssignableFrom(TypeToken<?> typeToken) {
        return isAssignableFrom(typeToken.runtimeType);
    }

    public final boolean isAssignableFrom(Type type) {
        return isAssignable((Type) Preconditions.checkNotNull(type), this.runtimeType);
    }

    public final boolean isArray() {
        return getComponentType() != null;
    }

    public final boolean isPrimitive() {
        return (this.runtimeType instanceof Class) && ((Class) this.runtimeType).isPrimitive();
    }

    public final TypeToken<T> wrap() {
        return isPrimitive() ? m8761of(Primitives.wrap((Class) this.runtimeType)) : this;
    }

    private boolean isWrapper() {
        return Primitives.allWrapperTypes().contains(this.runtimeType);
    }

    public final TypeToken<T> unwrap() {
        return isWrapper() ? m8761of(Primitives.unwrap((Class) this.runtimeType)) : this;
    }

    public final TypeToken<?> getComponentType() {
        Type componentType = Types.getComponentType(this.runtimeType);
        if (componentType == null) {
            return null;
        }
        return m8762of(componentType);
    }

    public final Invokable<T, Object> method(Method method) {
        Preconditions.checkArgument(m8761of(method.getDeclaringClass()).isAssignableFrom(this), "%s not declared by %s", method, this);
        return new MethodInvokable<T>(method) {
            /* access modifiers changed from: 0000 */
            public Type getGenericReturnType() {
                return TypeToken.this.resolveType(super.getGenericReturnType()).getType();
            }

            /* access modifiers changed from: 0000 */
            public Type[] getGenericParameterTypes() {
                return TypeToken.this.resolveInPlace(super.getGenericParameterTypes());
            }

            /* access modifiers changed from: 0000 */
            public Type[] getGenericExceptionTypes() {
                return TypeToken.this.resolveInPlace(super.getGenericExceptionTypes());
            }

            public TypeToken<T> getOwnerType() {
                return TypeToken.this;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append(getOwnerType());
                sb.append(".");
                sb.append(super.toString());
                return sb.toString();
            }
        };
    }

    public final Invokable<T, T> constructor(Constructor<?> constructor) {
        Preconditions.checkArgument(constructor.getDeclaringClass() == getRawType(), "%s not declared by %s", constructor, getRawType());
        return new ConstructorInvokable<T>(constructor) {
            /* access modifiers changed from: 0000 */
            public Type getGenericReturnType() {
                return TypeToken.this.resolveType(super.getGenericReturnType()).getType();
            }

            /* access modifiers changed from: 0000 */
            public Type[] getGenericParameterTypes() {
                return TypeToken.this.resolveInPlace(super.getGenericParameterTypes());
            }

            /* access modifiers changed from: 0000 */
            public Type[] getGenericExceptionTypes() {
                return TypeToken.this.resolveInPlace(super.getGenericExceptionTypes());
            }

            public TypeToken<T> getOwnerType() {
                return TypeToken.this;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append(getOwnerType());
                sb.append("(");
                sb.append(Joiner.m8643on(", ").join((Object[]) getGenericParameterTypes()));
                sb.append(")");
                return sb.toString();
            }
        };
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TypeToken)) {
            return false;
        }
        return this.runtimeType.equals(((TypeToken) obj).runtimeType);
    }

    public int hashCode() {
        return this.runtimeType.hashCode();
    }

    public String toString() {
        return Types.toString(this.runtimeType);
    }

    /* access modifiers changed from: protected */
    public Object writeReplace() {
        return m8762of(new TypeResolver().resolveType(this.runtimeType));
    }

    /* access modifiers changed from: 0000 */
    public final TypeToken<T> rejectTypeVariables() {
        new TypeVisitor() {
            /* access modifiers changed from: 0000 */
            public void visitTypeVariable(TypeVariable<?> typeVariable) {
                StringBuilder sb = new StringBuilder();
                sb.append(TypeToken.this.runtimeType);
                sb.append("contains a type variable and is not safe for the operation");
                throw new IllegalArgumentException(sb.toString());
            }

            /* access modifiers changed from: 0000 */
            public void visitWildcardType(WildcardType wildcardType) {
                visit(wildcardType.getLowerBounds());
                visit(wildcardType.getUpperBounds());
            }

            /* access modifiers changed from: 0000 */
            public void visitParameterizedType(ParameterizedType parameterizedType) {
                visit(parameterizedType.getActualTypeArguments());
                visit(parameterizedType.getOwnerType());
            }

            /* access modifiers changed from: 0000 */
            public void visitGenericArrayType(GenericArrayType genericArrayType) {
                visit(genericArrayType.getGenericComponentType());
            }
        }.visit(this.runtimeType);
        return this;
    }

    private static boolean isAssignable(Type type, Type type2) {
        if (type2.equals(type)) {
            return true;
        }
        if (type2 instanceof WildcardType) {
            return isAssignableToWildcardType(type, (WildcardType) type2);
        }
        if (type instanceof TypeVariable) {
            return isAssignableFromAny(((TypeVariable) type).getBounds(), type2);
        }
        if (type instanceof WildcardType) {
            return isAssignableFromAny(((WildcardType) type).getUpperBounds(), type2);
        }
        if (type instanceof GenericArrayType) {
            return isAssignableFromGenericArrayType((GenericArrayType) type, type2);
        }
        if (type2 instanceof Class) {
            return isAssignableToClass(type, (Class) type2);
        }
        if (type2 instanceof ParameterizedType) {
            return isAssignableToParameterizedType(type, (ParameterizedType) type2);
        }
        if (type2 instanceof GenericArrayType) {
            return isAssignableToGenericArrayType(type, (GenericArrayType) type2);
        }
        return false;
    }

    private static boolean isAssignableFromAny(Type[] typeArr, Type type) {
        for (Type isAssignable : typeArr) {
            if (isAssignable(isAssignable, type)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isAssignableToClass(Type type, Class<?> cls) {
        return cls.isAssignableFrom(getRawType(type));
    }

    private static boolean isAssignableToWildcardType(Type type, WildcardType wildcardType) {
        return isAssignable(type, supertypeBound(wildcardType)) && isAssignableBySubtypeBound(type, wildcardType);
    }

    private static boolean isAssignableBySubtypeBound(Type type, WildcardType wildcardType) {
        Type subtypeBound = subtypeBound(wildcardType);
        if (subtypeBound == null) {
            return true;
        }
        Type subtypeBound2 = subtypeBound(type);
        if (subtypeBound2 == null) {
            return false;
        }
        return isAssignable(subtypeBound, subtypeBound2);
    }

    private static boolean isAssignableToParameterizedType(Type type, ParameterizedType parameterizedType) {
        Class rawType = getRawType(parameterizedType);
        if (!rawType.isAssignableFrom(getRawType(type))) {
            return false;
        }
        TypeVariable[] typeParameters = rawType.getTypeParameters();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        TypeToken of = m8762of(type);
        for (int i = 0; i < typeParameters.length; i++) {
            if (!matchTypeArgument(of.resolveType(typeParameters[i]).runtimeType, actualTypeArguments[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAssignableToGenericArrayType(Type type, GenericArrayType genericArrayType) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (!cls.isArray()) {
                return false;
            }
            return isAssignable(cls.getComponentType(), genericArrayType.getGenericComponentType());
        } else if (type instanceof GenericArrayType) {
            return isAssignable(((GenericArrayType) type).getGenericComponentType(), genericArrayType.getGenericComponentType());
        } else {
            return false;
        }
    }

    private static boolean isAssignableFromGenericArrayType(GenericArrayType genericArrayType, Type type) {
        boolean z = false;
        if (type instanceof Class) {
            Class<Object> cls = (Class) type;
            if (cls.isArray()) {
                return isAssignable(genericArrayType.getGenericComponentType(), cls.getComponentType());
            }
            if (cls == Object.class) {
                z = true;
            }
            return z;
        } else if (!(type instanceof GenericArrayType)) {
            return false;
        } else {
            return isAssignable(genericArrayType.getGenericComponentType(), ((GenericArrayType) type).getGenericComponentType());
        }
    }

    private static boolean matchTypeArgument(Type type, Type type2) {
        if (type.equals(type2)) {
            return true;
        }
        if (type2 instanceof WildcardType) {
            return isAssignableToWildcardType(type, (WildcardType) type2);
        }
        return false;
    }

    private static Type supertypeBound(Type type) {
        return type instanceof WildcardType ? supertypeBound((WildcardType) type) : type;
    }

    private static Type supertypeBound(WildcardType wildcardType) {
        Type[] upperBounds = wildcardType.getUpperBounds();
        if (upperBounds.length == 1) {
            return supertypeBound(upperBounds[0]);
        }
        if (upperBounds.length == 0) {
            return Object.class;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("There should be at most one upper bound for wildcard type: ");
        sb.append(wildcardType);
        throw new AssertionError(sb.toString());
    }

    private static Type subtypeBound(Type type) {
        return type instanceof WildcardType ? subtypeBound((WildcardType) type) : type;
    }

    private static Type subtypeBound(WildcardType wildcardType) {
        Type[] lowerBounds = wildcardType.getLowerBounds();
        if (lowerBounds.length == 1) {
            return subtypeBound(lowerBounds[0]);
        }
        if (lowerBounds.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Wildcard should have at most one lower bound: ");
        sb.append(wildcardType);
        throw new AssertionError(sb.toString());
    }

    @VisibleForTesting
    static Class<?> getRawType(Type type) {
        return (Class) getRawTypes(type).iterator().next();
    }

    @VisibleForTesting
    static ImmutableSet<Class<?>> getRawTypes(Type type) {
        Preconditions.checkNotNull(type);
        final ImmutableSet.Builder builder = ImmutableSet.builder();
        new TypeVisitor() {
            /* access modifiers changed from: 0000 */
            public void visitTypeVariable(TypeVariable<?> typeVariable) {
                visit(typeVariable.getBounds());
            }

            /* access modifiers changed from: 0000 */
            public void visitWildcardType(WildcardType wildcardType) {
                visit(wildcardType.getUpperBounds());
            }

            /* access modifiers changed from: 0000 */
            public void visitParameterizedType(ParameterizedType parameterizedType) {
                builder.add((Object) (Class) parameterizedType.getRawType());
            }

            /* access modifiers changed from: 0000 */
            public void visitClass(Class<?> cls) {
                builder.add((Object) cls);
            }

            /* access modifiers changed from: 0000 */
            public void visitGenericArrayType(GenericArrayType genericArrayType) {
                builder.add((Object) Types.getArrayClass(TypeToken.getRawType(genericArrayType.getGenericComponentType())));
            }
        }.visit(type);
        return builder.build();
    }

    @VisibleForTesting
    static <T> TypeToken<? extends T> toGenericType(Class<T> cls) {
        if (cls.isArray()) {
            return m8762of(Types.newArrayType(toGenericType(cls.getComponentType()).runtimeType));
        }
        TypeVariable[] typeParameters = cls.getTypeParameters();
        if (typeParameters.length > 0) {
            return m8762of((Type) Types.newParameterizedType(cls, typeParameters));
        }
        return m8761of(cls);
    }

    private TypeToken<? super T> getSupertypeFromUpperBounds(Class<? super T> cls, Type[] typeArr) {
        for (Type of : typeArr) {
            TypeToken of2 = m8762of(of);
            if (m8761of(cls).isAssignableFrom(of2)) {
                return of2.getSupertype(cls);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cls);
        sb.append(" isn't a super type of ");
        sb.append(this);
        throw new IllegalArgumentException(sb.toString());
    }

    private TypeToken<? extends T> getSubtypeFromLowerBounds(Class<?> cls, Type[] typeArr) {
        if (typeArr.length > 0) {
            return m8762of(typeArr[0]).getSubtype(cls);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cls);
        sb.append(" isn't a subclass of ");
        sb.append(this);
        throw new IllegalArgumentException(sb.toString());
    }

    private TypeToken<? super T> getArraySupertype(Class<? super T> cls) {
        return m8762of(newArrayClassOrGenericArrayType(((TypeToken) Preconditions.checkNotNull(getComponentType(), "%s isn't a super type of %s", cls, this)).getSupertype(cls.getComponentType()).runtimeType));
    }

    private TypeToken<? extends T> getArraySubtype(Class<?> cls) {
        return m8762of(newArrayClassOrGenericArrayType(getComponentType().getSubtype(cls.getComponentType()).runtimeType));
    }

    private Type resolveTypeArgsForSubclass(Class<?> cls) {
        if (this.runtimeType instanceof Class) {
            return cls;
        }
        TypeToken genericType = toGenericType(cls);
        return new TypeResolver().where(genericType.getSupertype(getRawType()).runtimeType, this.runtimeType).resolveType(genericType.runtimeType);
    }

    private static Type newArrayClassOrGenericArrayType(Type type) {
        return JavaVersion.JAVA7.newArrayType(type);
    }
}

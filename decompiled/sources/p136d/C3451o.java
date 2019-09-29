package p136d;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import p091b.C1598ad;
import p102c.C1672c;
import p102c.C1694r;

/* renamed from: d.o */
/* compiled from: Utils */
final class C3451o {

    /* renamed from: a */
    static final Type[] f8946a = new Type[0];

    /* renamed from: d.o$a */
    /* compiled from: Utils */
    private static final class C3452a implements GenericArrayType {

        /* renamed from: a */
        private final Type f8947a;

        public C3452a(Type type) {
            this.f8947a = type;
        }

        public Type getGenericComponentType() {
            return this.f8947a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && C3451o.m10035a((Type) this, (Type) (GenericArrayType) obj);
        }

        public int hashCode() {
            return this.f8947a.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(C3451o.m10037b(this.f8947a));
            sb.append("[]");
            return sb.toString();
        }
    }

    /* renamed from: d.o$b */
    /* compiled from: Utils */
    private static final class C3453b implements ParameterizedType {

        /* renamed from: a */
        private final Type f8948a;

        /* renamed from: b */
        private final Type f8949b;

        /* renamed from: c */
        private final Type[] f8950c;

        public C3453b(Type type, Type type2, Type... typeArr) {
            int i = 0;
            if (type2 instanceof Class) {
                boolean z = true;
                boolean z2 = type == null;
                if (((Class) type2).getEnclosingClass() != null) {
                    z = false;
                }
                if (z2 != z) {
                    throw new IllegalArgumentException();
                }
            }
            this.f8948a = type;
            this.f8949b = type2;
            this.f8950c = (Type[]) typeArr.clone();
            Type[] typeArr2 = this.f8950c;
            int length = typeArr2.length;
            while (i < length) {
                Type type3 = typeArr2[i];
                if (type3 != null) {
                    C3451o.m10039c(type3);
                    i++;
                } else {
                    throw new NullPointerException();
                }
            }
        }

        public Type[] getActualTypeArguments() {
            return (Type[]) this.f8950c.clone();
        }

        public Type getRawType() {
            return this.f8949b;
        }

        public Type getOwnerType() {
            return this.f8948a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && C3451o.m10035a((Type) this, (Type) (ParameterizedType) obj);
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f8950c) ^ this.f8949b.hashCode()) ^ C3451o.m10023a((Object) this.f8948a);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((this.f8950c.length + 1) * 30);
            sb.append(C3451o.m10037b(this.f8949b));
            if (this.f8950c.length == 0) {
                return sb.toString();
            }
            sb.append(SimpleComparison.LESS_THAN_OPERATION);
            sb.append(C3451o.m10037b(this.f8950c[0]));
            for (int i = 1; i < this.f8950c.length; i++) {
                sb.append(", ");
                sb.append(C3451o.m10037b(this.f8950c[i]));
            }
            sb.append(SimpleComparison.GREATER_THAN_OPERATION);
            return sb.toString();
        }
    }

    /* renamed from: d.o$c */
    /* compiled from: Utils */
    private static final class C3454c implements WildcardType {

        /* renamed from: a */
        private final Type f8951a;

        /* renamed from: b */
        private final Type f8952b;

        public C3454c(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length > 1) {
                throw new IllegalArgumentException();
            } else if (typeArr.length != 1) {
                throw new IllegalArgumentException();
            } else if (typeArr2.length == 1) {
                if (typeArr2[0] != null) {
                    C3451o.m10039c(typeArr2[0]);
                    if (typeArr[0] == Object.class) {
                        this.f8952b = typeArr2[0];
                        this.f8951a = Object.class;
                        return;
                    }
                    throw new IllegalArgumentException();
                }
                throw new NullPointerException();
            } else if (typeArr[0] != null) {
                C3451o.m10039c(typeArr[0]);
                this.f8952b = null;
                this.f8951a = typeArr[0];
            } else {
                throw new NullPointerException();
            }
        }

        public Type[] getUpperBounds() {
            return new Type[]{this.f8951a};
        }

        public Type[] getLowerBounds() {
            if (this.f8952b == null) {
                return C3451o.f8946a;
            }
            return new Type[]{this.f8952b};
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && C3451o.m10035a((Type) this, (Type) (WildcardType) obj);
        }

        public int hashCode() {
            return (this.f8952b != null ? this.f8952b.hashCode() + 31 : 1) ^ (this.f8951a.hashCode() + 31);
        }

        public String toString() {
            if (this.f8952b != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("? super ");
                sb.append(C3451o.m10037b(this.f8952b));
                return sb.toString();
            } else if (this.f8951a == Object.class) {
                return "?";
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("? extends ");
                sb2.append(C3451o.m10037b(this.f8951a));
                return sb2.toString();
            }
        }
    }

    /* renamed from: a */
    static Class<?> m10026a(Type type) {
        if (type == null) {
            throw new NullPointerException("type == null");
        } else if (type instanceof Class) {
            return (Class) type;
        } else {
            if (type instanceof ParameterizedType) {
                Type rawType = ((ParameterizedType) type).getRawType();
                if (rawType instanceof Class) {
                    return (Class) rawType;
                }
                throw new IllegalArgumentException();
            } else if (type instanceof GenericArrayType) {
                return Array.newInstance(m10026a(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
            } else {
                if (type instanceof TypeVariable) {
                    return Object.class;
                }
                if (type instanceof WildcardType) {
                    return m10026a(((WildcardType) type).getUpperBounds()[0]);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Expected a Class, ParameterizedType, or GenericArrayType, but <");
                sb.append(type);
                sb.append("> is of type ");
                sb.append(type.getClass().getName());
                throw new IllegalArgumentException(sb.toString());
            }
        }
    }

    /* renamed from: a */
    static boolean m10035a(Type type, Type type2) {
        boolean z = true;
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            if (!m10034a((Object) parameterizedType.getOwnerType(), (Object) parameterizedType2.getOwnerType()) || !parameterizedType.getRawType().equals(parameterizedType2.getRawType()) || !Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments())) {
                z = false;
            }
            return z;
        } else if (type instanceof GenericArrayType) {
            if (!(type2 instanceof GenericArrayType)) {
                return false;
            }
            return m10035a(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
        } else if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            if (!Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) || !Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds())) {
                z = false;
            }
            return z;
        } else if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        } else {
            TypeVariable typeVariable = (TypeVariable) type;
            TypeVariable typeVariable2 = (TypeVariable) type2;
            if (typeVariable.getGenericDeclaration() != typeVariable2.getGenericDeclaration() || !typeVariable.getName().equals(typeVariable2.getName())) {
                z = false;
            }
            return z;
        }
    }

    /* renamed from: a */
    static Type m10030a(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i = 0; i < length; i++) {
                if (interfaces[i] == cls2) {
                    return cls.getGenericInterfaces()[i];
                }
                if (cls2.isAssignableFrom(interfaces[i])) {
                    return m10030a(cls.getGenericInterfaces()[i], interfaces[i], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<?> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return m10030a(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    /* renamed from: a */
    private static int m10024a(Object[] objArr, Object obj) {
        for (int i = 0; i < objArr.length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    /* renamed from: a */
    private static boolean m10034a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    static int m10023a(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* renamed from: b */
    static String m10037b(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    /* renamed from: b */
    static Type m10038b(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return m10031a(type, cls, m10030a(type, cls, cls2));
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARNING: type inference failed for: r0v22, types: [java.lang.reflect.Type] */
    /* JADX WARNING: type inference failed for: r0v23, types: [d.o$a] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.reflect.Type m10031a(java.lang.reflect.Type r8, java.lang.Class<?> r9, java.lang.reflect.Type r10) {
        /*
        L_0x0000:
            boolean r0 = r10 instanceof java.lang.reflect.TypeVariable
            if (r0 == 0) goto L_0x000f
            java.lang.reflect.TypeVariable r10 = (java.lang.reflect.TypeVariable) r10
            java.lang.reflect.Type r0 = m10032a(r8, r9, r10)
            if (r0 != r10) goto L_0x000d
            return r0
        L_0x000d:
            r10 = r0
            goto L_0x0000
        L_0x000f:
            boolean r0 = r10 instanceof java.lang.Class
            if (r0 == 0) goto L_0x002d
            r0 = r10
            java.lang.Class r0 = (java.lang.Class) r0
            boolean r1 = r0.isArray()
            if (r1 == 0) goto L_0x002d
            java.lang.Class r10 = r0.getComponentType()
            java.lang.reflect.Type r8 = m10031a(r8, r9, r10)
            if (r10 != r8) goto L_0x0027
            goto L_0x002c
        L_0x0027:
            d.o$a r0 = new d.o$a
            r0.<init>(r8)
        L_0x002c:
            return r0
        L_0x002d:
            boolean r0 = r10 instanceof java.lang.reflect.GenericArrayType
            if (r0 == 0) goto L_0x0044
            java.lang.reflect.GenericArrayType r10 = (java.lang.reflect.GenericArrayType) r10
            java.lang.reflect.Type r0 = r10.getGenericComponentType()
            java.lang.reflect.Type r8 = m10031a(r8, r9, r0)
            if (r0 != r8) goto L_0x003e
            goto L_0x0043
        L_0x003e:
            d.o$a r10 = new d.o$a
            r10.<init>(r8)
        L_0x0043:
            return r10
        L_0x0044:
            boolean r0 = r10 instanceof java.lang.reflect.ParameterizedType
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0087
            java.lang.reflect.ParameterizedType r10 = (java.lang.reflect.ParameterizedType) r10
            java.lang.reflect.Type r0 = r10.getOwnerType()
            java.lang.reflect.Type r3 = m10031a(r8, r9, r0)
            if (r3 == r0) goto L_0x0058
            r0 = 1
            goto L_0x0059
        L_0x0058:
            r0 = 0
        L_0x0059:
            java.lang.reflect.Type[] r4 = r10.getActualTypeArguments()
            int r5 = r4.length
        L_0x005e:
            if (r2 >= r5) goto L_0x0079
            r6 = r4[r2]
            java.lang.reflect.Type r6 = m10031a(r8, r9, r6)
            r7 = r4[r2]
            if (r6 == r7) goto L_0x0076
            if (r0 != 0) goto L_0x0074
            java.lang.Object r0 = r4.clone()
            r4 = r0
            java.lang.reflect.Type[] r4 = (java.lang.reflect.Type[]) r4
            r0 = 1
        L_0x0074:
            r4[r2] = r6
        L_0x0076:
            int r2 = r2 + 1
            goto L_0x005e
        L_0x0079:
            if (r0 == 0) goto L_0x0085
            d.o$b r8 = new d.o$b
            java.lang.reflect.Type r9 = r10.getRawType()
            r8.<init>(r3, r9, r4)
            goto L_0x0086
        L_0x0085:
            r8 = r10
        L_0x0086:
            return r8
        L_0x0087:
            boolean r0 = r10 instanceof java.lang.reflect.WildcardType
            if (r0 == 0) goto L_0x00cc
            java.lang.reflect.WildcardType r10 = (java.lang.reflect.WildcardType) r10
            java.lang.reflect.Type[] r0 = r10.getLowerBounds()
            java.lang.reflect.Type[] r3 = r10.getUpperBounds()
            int r4 = r0.length
            if (r4 != r1) goto L_0x00b2
            r3 = r0[r2]
            java.lang.reflect.Type r8 = m10031a(r8, r9, r3)
            r9 = r0[r2]
            if (r8 == r9) goto L_0x00cb
            d.o$c r9 = new d.o$c
            java.lang.reflect.Type[] r10 = new java.lang.reflect.Type[r1]
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            r10[r2] = r0
            java.lang.reflect.Type[] r0 = new java.lang.reflect.Type[r1]
            r0[r2] = r8
            r9.<init>(r10, r0)
            return r9
        L_0x00b2:
            int r0 = r3.length
            if (r0 != r1) goto L_0x00cb
            r0 = r3[r2]
            java.lang.reflect.Type r8 = m10031a(r8, r9, r0)     // Catch:{ Throwable -> 0x00cd }
            r9 = r3[r2]
            if (r8 == r9) goto L_0x00cb
            d.o$c r9 = new d.o$c
            java.lang.reflect.Type[] r10 = new java.lang.reflect.Type[r1]
            r10[r2] = r8
            java.lang.reflect.Type[] r8 = f8946a
            r9.<init>(r10, r8)
            return r9
        L_0x00cb:
            return r10
        L_0x00cc:
            return r10
        L_0x00cd:
            r8 = move-exception
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p136d.C3451o.m10031a(java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type):java.lang.reflect.Type");
    }

    /* renamed from: a */
    private static Type m10032a(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class a = m10027a(typeVariable);
        if (a == null) {
            return typeVariable;
        }
        Type a2 = m10030a(type, cls, a);
        if (!(a2 instanceof ParameterizedType)) {
            return typeVariable;
        }
        return ((ParameterizedType) a2).getActualTypeArguments()[m10024a((Object[]) a.getTypeParameters(), (Object) typeVariable)];
    }

    /* renamed from: a */
    private static Class<?> m10027a(TypeVariable<?> typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    /* renamed from: c */
    static void m10039c(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: a */
    static <T> T m10028a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* renamed from: a */
    static boolean m10036a(Annotation[] annotationArr, Class<? extends Annotation> cls) {
        for (Annotation isInstance : annotationArr) {
            if (cls.isInstance(isInstance)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    static C1598ad m10025a(C1598ad adVar) throws IOException {
        C1672c cVar = new C1672c();
        adVar.mo6292c().mo6808a((C1694r) cVar);
        return C1598ad.m6543a(adVar.mo6290a(), adVar.mo6291b(), cVar);
    }

    /* renamed from: a */
    static <T> void m10033a(Class<T> cls) {
        if (!cls.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        } else if (cls.getInterfaces().length > 0) {
            throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
        }
    }

    /* renamed from: a */
    static Type m10029a(int i, ParameterizedType parameterizedType) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (i < 0 || i >= actualTypeArguments.length) {
            StringBuilder sb = new StringBuilder();
            sb.append("Index ");
            sb.append(i);
            sb.append(" not in range [0,");
            sb.append(actualTypeArguments.length);
            sb.append(") for ");
            sb.append(parameterizedType);
            throw new IllegalArgumentException(sb.toString());
        }
        Type type = actualTypeArguments[i];
        return type instanceof WildcardType ? ((WildcardType) type).getUpperBounds()[0] : type;
    }

    /* renamed from: d */
    static boolean m10040d(Type type) {
        String str;
        if (type instanceof Class) {
            return false;
        }
        if (type instanceof ParameterizedType) {
            for (Type d : ((ParameterizedType) type).getActualTypeArguments()) {
                if (m10040d(d)) {
                    return true;
                }
            }
            return false;
        } else if (type instanceof GenericArrayType) {
            return m10040d(((GenericArrayType) type).getGenericComponentType());
        } else {
            if ((type instanceof TypeVariable) || (type instanceof WildcardType)) {
                return true;
            }
            if (type == null) {
                str = "null";
            } else {
                str = type.getClass().getName();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Expected a Class, ParameterizedType, or GenericArrayType, but <");
            sb.append(type);
            sb.append("> is of type ");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: e */
    static Type m10041e(Type type) {
        if (type instanceof ParameterizedType) {
            return m10029a(0, (ParameterizedType) type);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}

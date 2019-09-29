package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

public final class AnnotatedConstructor extends AnnotatedWithParams {
    private static final long serialVersionUID = 1;
    protected final Constructor<?> _constructor;
    protected Serialization _serialization;

    private static final class Serialization implements Serializable {
        private static final long serialVersionUID = 1;
        protected Class<?>[] args;
        protected Class<?> clazz;

        public Serialization(Constructor<?> constructor) {
            this.clazz = constructor.getDeclaringClass();
            this.args = constructor.getParameterTypes();
        }
    }

    public AnnotatedConstructor(TypeResolutionContext typeResolutionContext, Constructor<?> constructor, AnnotationMap annotationMap, AnnotationMap[] annotationMapArr) {
        super(typeResolutionContext, annotationMap, annotationMapArr);
        if (constructor != null) {
            this._constructor = constructor;
            return;
        }
        throw new IllegalArgumentException("Null constructor not allowed");
    }

    protected AnnotatedConstructor(Serialization serialization) {
        super(null, null, null);
        this._constructor = null;
        this._serialization = serialization;
    }

    public AnnotatedConstructor withAnnotations(AnnotationMap annotationMap) {
        return new AnnotatedConstructor(this._typeContext, this._constructor, annotationMap, this._paramAnnotations);
    }

    public Constructor<?> getAnnotated() {
        return this._constructor;
    }

    public int getModifiers() {
        return this._constructor.getModifiers();
    }

    public String getName() {
        return this._constructor.getName();
    }

    public JavaType getType() {
        return this._typeContext.resolveType(getRawType());
    }

    public Class<?> getRawType() {
        return this._constructor.getDeclaringClass();
    }

    public int getParameterCount() {
        return this._constructor.getParameterTypes().length;
    }

    public Class<?> getRawParameterType(int i) {
        Class<?>[] parameterTypes = this._constructor.getParameterTypes();
        if (i >= parameterTypes.length) {
            return null;
        }
        return parameterTypes[i];
    }

    public JavaType getParameterType(int i) {
        Type[] genericParameterTypes = this._constructor.getGenericParameterTypes();
        if (i >= genericParameterTypes.length) {
            return null;
        }
        return this._typeContext.resolveType(genericParameterTypes[i]);
    }

    @Deprecated
    public Type getGenericParameterType(int i) {
        Type[] genericParameterTypes = this._constructor.getGenericParameterTypes();
        if (i >= genericParameterTypes.length) {
            return null;
        }
        return genericParameterTypes[i];
    }

    public final Object call() throws Exception {
        return this._constructor.newInstance(new Object[0]);
    }

    public final Object call(Object[] objArr) throws Exception {
        return this._constructor.newInstance(objArr);
    }

    public final Object call1(Object obj) throws Exception {
        return this._constructor.newInstance(new Object[]{obj});
    }

    public Class<?> getDeclaringClass() {
        return this._constructor.getDeclaringClass();
    }

    public Member getMember() {
        return this._constructor;
    }

    public void setValue(Object obj, Object obj2) throws UnsupportedOperationException {
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot call setValue() on constructor of ");
        sb.append(getDeclaringClass().getName());
        throw new UnsupportedOperationException(sb.toString());
    }

    public Object getValue(Object obj) throws UnsupportedOperationException {
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot call getValue() on constructor of ");
        sb.append(getDeclaringClass().getName());
        throw new UnsupportedOperationException(sb.toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[constructor for ");
        sb.append(getName());
        sb.append(", annotations: ");
        sb.append(this._annotations);
        sb.append("]");
        return sb.toString();
    }

    public int hashCode() {
        return this._constructor.getName().hashCode();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (((AnnotatedConstructor) obj)._constructor != this._constructor) {
            z = false;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    public Object writeReplace() {
        return new AnnotatedConstructor(new Serialization(this._constructor));
    }

    /* access modifiers changed from: 0000 */
    public Object readResolve() {
        Class<?> cls = this._serialization.clazz;
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(this._serialization.args);
            if (!declaredConstructor.isAccessible()) {
                ClassUtil.checkAndFixAccess(declaredConstructor, false);
            }
            return new AnnotatedConstructor(null, declaredConstructor, null, null);
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not find constructor with ");
            sb.append(this._serialization.args.length);
            sb.append(" args from Class '");
            sb.append(cls.getName());
            throw new IllegalArgumentException(sb.toString());
        }
    }
}

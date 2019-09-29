package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Member;

public class VirtualAnnotatedMember extends AnnotatedMember implements Serializable {
    private static final long serialVersionUID = 1;
    protected final Class<?> _declaringClass;
    protected final String _name;
    protected final JavaType _type;

    public Field getAnnotated() {
        return null;
    }

    public int getAnnotationCount() {
        return 0;
    }

    public Member getMember() {
        return null;
    }

    public int getModifiers() {
        return 0;
    }

    public Annotated withAnnotations(AnnotationMap annotationMap) {
        return this;
    }

    public VirtualAnnotatedMember(TypeResolutionContext typeResolutionContext, Class<?> cls, String str, JavaType javaType) {
        super(typeResolutionContext, null);
        this._declaringClass = cls;
        this._type = javaType;
        this._name = str;
    }

    @Deprecated
    public VirtualAnnotatedMember(TypeResolutionContext typeResolutionContext, Class<?> cls, String str, Class<?> cls2) {
        this(typeResolutionContext, cls, str, typeResolutionContext.resolveType(cls2));
    }

    public String getName() {
        return this._name;
    }

    public Class<?> getRawType() {
        return this._type.getRawClass();
    }

    public JavaType getType() {
        return this._type;
    }

    public Class<?> getDeclaringClass() {
        return this._declaringClass;
    }

    public void setValue(Object obj, Object obj2) throws IllegalArgumentException {
        StringBuilder sb = new StringBuilder();
        sb.append("Can not set virtual property '");
        sb.append(this._name);
        sb.append("'");
        throw new IllegalArgumentException(sb.toString());
    }

    public Object getValue(Object obj) throws IllegalArgumentException {
        StringBuilder sb = new StringBuilder();
        sb.append("Can not get virtual property '");
        sb.append(this._name);
        sb.append("'");
        throw new IllegalArgumentException(sb.toString());
    }

    public String getFullName() {
        StringBuilder sb = new StringBuilder();
        sb.append(getDeclaringClass().getName());
        sb.append("#");
        sb.append(getName());
        return sb.toString();
    }

    public int hashCode() {
        return this._name.hashCode();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        VirtualAnnotatedMember virtualAnnotatedMember = (VirtualAnnotatedMember) obj;
        if (virtualAnnotatedMember._declaringClass != this._declaringClass || !virtualAnnotatedMember._name.equals(this._name)) {
            z = false;
        }
        return z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[field ");
        sb.append(getFullName());
        sb.append("]");
        return sb.toString();
    }
}

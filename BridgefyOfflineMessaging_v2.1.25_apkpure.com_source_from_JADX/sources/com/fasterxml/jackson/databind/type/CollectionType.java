package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import java.lang.reflect.TypeVariable;

public final class CollectionType extends CollectionLikeType {
    private static final long serialVersionUID = 1;

    private CollectionType(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr, JavaType javaType2, Object obj, Object obj2, boolean z) {
        super(cls, typeBindings, javaType, javaTypeArr, javaType2, obj, obj2, z);
    }

    protected CollectionType(TypeBase typeBase, JavaType javaType) {
        super(typeBase, javaType);
    }

    public static CollectionType construct(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr, JavaType javaType2) {
        CollectionType collectionType = new CollectionType(cls, typeBindings, javaType, javaTypeArr, javaType2, null, null, false);
        return collectionType;
    }

    @Deprecated
    public static CollectionType construct(Class<?> cls, JavaType javaType) {
        TypeBindings typeBindings;
        TypeVariable[] typeParameters = cls.getTypeParameters();
        if (typeParameters == null || typeParameters.length != 1) {
            typeBindings = TypeBindings.emptyBindings();
        } else {
            typeBindings = TypeBindings.create(cls, javaType);
        }
        CollectionType collectionType = new CollectionType(cls, typeBindings, _bogusSuperClass(cls), null, javaType, null, null, false);
        return collectionType;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public JavaType _narrow(Class<?> cls) {
        CollectionType collectionType = new CollectionType(cls, this._bindings, this._superClass, this._superInterfaces, this._elementType, null, null, this._asStatic);
        return collectionType;
    }

    public JavaType withContentType(JavaType javaType) {
        if (this._elementType == javaType) {
            return this;
        }
        CollectionType collectionType = new CollectionType(this._class, this._bindings, this._superClass, this._superInterfaces, javaType, this._valueHandler, this._typeHandler, this._asStatic);
        return collectionType;
    }

    public CollectionType withTypeHandler(Object obj) {
        CollectionType collectionType = new CollectionType(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType, this._valueHandler, obj, this._asStatic);
        return collectionType;
    }

    public CollectionType withContentTypeHandler(Object obj) {
        CollectionType collectionType = new CollectionType(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType.withTypeHandler(obj), this._valueHandler, this._typeHandler, this._asStatic);
        return collectionType;
    }

    public CollectionType withValueHandler(Object obj) {
        CollectionType collectionType = new CollectionType(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType, obj, this._typeHandler, this._asStatic);
        return collectionType;
    }

    public CollectionType withContentValueHandler(Object obj) {
        CollectionType collectionType = new CollectionType(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType.withValueHandler(obj), this._valueHandler, this._typeHandler, this._asStatic);
        return collectionType;
    }

    public CollectionType withStaticTyping() {
        if (this._asStatic) {
            return this;
        }
        CollectionType collectionType = new CollectionType(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType.withStaticTyping(), this._valueHandler, this._typeHandler, true);
        return collectionType;
    }

    public JavaType refine(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        CollectionType collectionType = new CollectionType(cls, typeBindings, javaType, javaTypeArr, this._elementType, this._valueHandler, this._typeHandler, this._asStatic);
        return collectionType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[collection type; class ");
        sb.append(this._class.getName());
        sb.append(", contains ");
        sb.append(this._elementType);
        sb.append("]");
        return sb.toString();
    }
}

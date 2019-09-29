package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;

public class ReferenceType extends SimpleType {
    private static final long serialVersionUID = 1;
    protected final JavaType _anchorType;
    protected final JavaType _referencedType;

    public boolean hasContentType() {
        return true;
    }

    public boolean isReferenceType() {
        return true;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [com.fasterxml.jackson.databind.JavaType] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected ReferenceType(java.lang.Class<?> r11, com.fasterxml.jackson.databind.type.TypeBindings r12, com.fasterxml.jackson.databind.JavaType r13, com.fasterxml.jackson.databind.JavaType[] r14, com.fasterxml.jackson.databind.JavaType r15, com.fasterxml.jackson.databind.JavaType r16, java.lang.Object r17, java.lang.Object r18, boolean r19) {
        /*
            r10 = this;
            r9 = r10
            int r5 = r15.hashCode()
            r0 = r10
            r1 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r6 = r17
            r7 = r18
            r8 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = r15
            r9._referencedType = r0
            if (r16 != 0) goto L_0x001a
            r0 = r9
            goto L_0x001c
        L_0x001a:
            r0 = r16
        L_0x001c:
            r9._anchorType = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.type.ReferenceType.<init>(java.lang.Class, com.fasterxml.jackson.databind.type.TypeBindings, com.fasterxml.jackson.databind.JavaType, com.fasterxml.jackson.databind.JavaType[], com.fasterxml.jackson.databind.JavaType, com.fasterxml.jackson.databind.JavaType, java.lang.Object, java.lang.Object, boolean):void");
    }

    protected ReferenceType(TypeBase typeBase, JavaType javaType) {
        super(typeBase);
        this._referencedType = javaType;
        this._anchorType = this;
    }

    public static ReferenceType upgradeFrom(JavaType javaType, JavaType javaType2) {
        if (javaType2 == null) {
            throw new IllegalArgumentException("Missing referencedType");
        } else if (javaType instanceof TypeBase) {
            return new ReferenceType((TypeBase) javaType, javaType2);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Can not upgrade from an instance of ");
            sb.append(javaType.getClass());
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static ReferenceType construct(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr, JavaType javaType2) {
        ReferenceType referenceType = new ReferenceType(cls, typeBindings, javaType, javaTypeArr, javaType2, null, null, null, false);
        return referenceType;
    }

    @Deprecated
    public static ReferenceType construct(Class<?> cls, JavaType javaType) {
        ReferenceType referenceType = new ReferenceType(cls, TypeBindings.emptyBindings(), null, null, null, javaType, null, null, false);
        return referenceType;
    }

    public JavaType withContentType(JavaType javaType) {
        if (this._referencedType == javaType) {
            return this;
        }
        ReferenceType referenceType = new ReferenceType(this._class, this._bindings, this._superClass, this._superInterfaces, javaType, this._anchorType, this._valueHandler, this._typeHandler, this._asStatic);
        return referenceType;
    }

    public ReferenceType withTypeHandler(Object obj) {
        if (obj == this._typeHandler) {
            return this;
        }
        ReferenceType referenceType = new ReferenceType(this._class, this._bindings, this._superClass, this._superInterfaces, this._referencedType, this._anchorType, this._valueHandler, obj, this._asStatic);
        return referenceType;
    }

    public ReferenceType withContentTypeHandler(Object obj) {
        if (obj == this._referencedType.getTypeHandler()) {
            return this;
        }
        ReferenceType referenceType = new ReferenceType(this._class, this._bindings, this._superClass, this._superInterfaces, this._referencedType.withTypeHandler(obj), this._anchorType, this._valueHandler, this._typeHandler, this._asStatic);
        return referenceType;
    }

    public ReferenceType withValueHandler(Object obj) {
        if (obj == this._valueHandler) {
            return this;
        }
        ReferenceType referenceType = new ReferenceType(this._class, this._bindings, this._superClass, this._superInterfaces, this._referencedType, this._anchorType, obj, this._typeHandler, this._asStatic);
        return referenceType;
    }

    public ReferenceType withContentValueHandler(Object obj) {
        if (obj == this._referencedType.getValueHandler()) {
            return this;
        }
        ReferenceType referenceType = new ReferenceType(this._class, this._bindings, this._superClass, this._superInterfaces, this._referencedType.withValueHandler(obj), this._anchorType, this._valueHandler, this._typeHandler, this._asStatic);
        return referenceType;
    }

    public ReferenceType withStaticTyping() {
        if (this._asStatic) {
            return this;
        }
        ReferenceType referenceType = new ReferenceType(this._class, this._bindings, this._superClass, this._superInterfaces, this._referencedType.withStaticTyping(), this._anchorType, this._valueHandler, this._typeHandler, true);
        return referenceType;
    }

    public JavaType refine(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        ReferenceType referenceType = new ReferenceType(cls, this._bindings, javaType, javaTypeArr, this._referencedType, this._anchorType, this._valueHandler, this._typeHandler, this._asStatic);
        return referenceType;
    }

    /* access modifiers changed from: protected */
    public String buildCanonicalName() {
        StringBuilder sb = new StringBuilder();
        sb.append(this._class.getName());
        sb.append('<');
        sb.append(this._referencedType.toCanonical());
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public JavaType _narrow(Class<?> cls) {
        ReferenceType referenceType = new ReferenceType(cls, this._bindings, this._superClass, this._superInterfaces, this._referencedType, this._anchorType, this._valueHandler, this._typeHandler, this._asStatic);
        return referenceType;
    }

    public JavaType getContentType() {
        return this._referencedType;
    }

    public JavaType getReferencedType() {
        return this._referencedType;
    }

    public StringBuilder getErasedSignature(StringBuilder sb) {
        return _classSignature(this._class, sb, true);
    }

    public StringBuilder getGenericSignature(StringBuilder sb) {
        _classSignature(this._class, sb, false);
        sb.append('<');
        StringBuilder genericSignature = this._referencedType.getGenericSignature(sb);
        genericSignature.append(">;");
        return genericSignature;
    }

    public JavaType getAnchorType() {
        return this._anchorType;
    }

    public boolean isAnchorType() {
        return this._anchorType == this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("[reference type, class ");
        sb.append(buildCanonicalName());
        sb.append('<');
        sb.append(this._referencedType);
        sb.append('>');
        sb.append(']');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        ReferenceType referenceType = (ReferenceType) obj;
        if (referenceType._class != this._class) {
            return false;
        }
        return this._referencedType.equals(referenceType._referencedType);
    }
}

package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude.Value;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Typing;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.util.Annotations;
import com.fasterxml.jackson.databind.util.ClassUtil;

public class PropertyBuilder {
    private static final Object NO_DEFAULT_MARKER = Boolean.FALSE;
    protected final AnnotationIntrospector _annotationIntrospector;
    protected final BeanDescription _beanDesc;
    protected final SerializationConfig _config;
    protected Object _defaultBean;
    protected final Value _defaultInclusion;
    protected final boolean _useRealPropertyDefaults;

    public PropertyBuilder(SerializationConfig serializationConfig, BeanDescription beanDescription) {
        this._config = serializationConfig;
        this._beanDesc = beanDescription;
        Value merge = Value.merge(beanDescription.findPropertyInclusion(Value.empty()), serializationConfig.getDefaultPropertyInclusion(beanDescription.getBeanClass(), Value.empty()));
        this._defaultInclusion = Value.merge(serializationConfig.getDefaultPropertyInclusion(), merge);
        this._useRealPropertyDefaults = merge.getValueInclusion() == Include.NON_DEFAULT;
        this._annotationIntrospector = this._config.getAnnotationIntrospector();
    }

    public Annotations getClassAnnotations() {
        return this._beanDesc.getClassAnnotations();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0078, code lost:
        r12 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0083, code lost:
        r12 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0084, code lost:
        r11 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d4, code lost:
        if (r0.isContainerType() == false) goto L_0x00e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00de, code lost:
        if (r1._config.isEnabled(com.fasterxml.jackson.databind.SerializationFeature.WRITE_EMPTY_JSON_ARRAYS) != false) goto L_0x00e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e0, code lost:
        r12 = com.fasterxml.jackson.databind.ser.BeanPropertyWriter.MARKER_FOR_EMPTY;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e4, code lost:
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e5, code lost:
        r11 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e6, code lost:
        r3 = new com.fasterxml.jackson.databind.ser.BeanPropertyWriter(r16, r21, r1._beanDesc.getClassAnnotations(), r17, r18, r19, r10, r11, r12);
        r3 = r1._annotationIntrospector.findNullSerializer(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0102, code lost:
        if (r3 == null) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0104, code lost:
        r3.assignNullSerializer(r15.serializerInstance(r13, r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x010b, code lost:
        r2 = r1._annotationIntrospector.findUnwrappingNameTransformer(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0111, code lost:
        if (r2 == null) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0113, code lost:
        r0 = r3.unwrappingWriter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0117, code lost:
        return r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00bc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.ser.BeanPropertyWriter buildWriter(com.fasterxml.jackson.databind.SerializerProvider r15, com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition r16, com.fasterxml.jackson.databind.JavaType r17, com.fasterxml.jackson.databind.JsonSerializer<?> r18, com.fasterxml.jackson.databind.jsontype.TypeSerializer r19, com.fasterxml.jackson.databind.jsontype.TypeSerializer r20, com.fasterxml.jackson.databind.introspect.AnnotatedMember r21, boolean r22) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            r14 = this;
            r1 = r14
            r2 = r15
            r4 = r16
            r0 = r20
            r13 = r21
            r3 = 0
            r7 = r17
            r5 = r22
            com.fasterxml.jackson.databind.JavaType r5 = r14.findSerializationType(r13, r5, r7)     // Catch:{ JsonMappingException -> 0x0118 }
            if (r0 == 0) goto L_0x0042
            if (r5 != 0) goto L_0x0016
            r5 = r7
        L_0x0016:
            com.fasterxml.jackson.databind.JavaType r6 = r5.getContentType()
            if (r6 != 0) goto L_0x0039
            com.fasterxml.jackson.databind.BeanDescription r6 = r1._beanDesc
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "serialization type "
            r8.append(r9)
            r8.append(r5)
            java.lang.String r9 = " has no content"
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.Object[] r9 = new java.lang.Object[r3]
            r15.reportBadPropertyDefinition(r6, r4, r8, r9)
        L_0x0039:
            com.fasterxml.jackson.databind.JavaType r0 = r5.withContentTypeHandler(r0)
            r0.getContentType()
            r10 = r0
            goto L_0x0043
        L_0x0042:
            r10 = r5
        L_0x0043:
            r5 = 0
            if (r10 != 0) goto L_0x0048
            r0 = r7
            goto L_0x0049
        L_0x0048:
            r0 = r10
        L_0x0049:
            com.fasterxml.jackson.databind.SerializationConfig r6 = r1._config
            java.lang.Class r8 = r0.getRawClass()
            com.fasterxml.jackson.annotation.JsonInclude$Value r9 = r1._defaultInclusion
            com.fasterxml.jackson.annotation.JsonInclude$Value r6 = r6.getDefaultPropertyInclusion(r8, r9)
            com.fasterxml.jackson.annotation.JsonInclude$Value r8 = r16.findInclusion()
            com.fasterxml.jackson.annotation.JsonInclude$Value r6 = r6.withOverrides(r8)
            com.fasterxml.jackson.annotation.JsonInclude$Include r6 = r6.getValueInclusion()
            com.fasterxml.jackson.annotation.JsonInclude$Include r8 = com.fasterxml.jackson.annotation.JsonInclude.Include.USE_DEFAULTS
            if (r6 != r8) goto L_0x0067
            com.fasterxml.jackson.annotation.JsonInclude$Include r6 = com.fasterxml.jackson.annotation.JsonInclude.Include.ALWAYS
        L_0x0067:
            int[] r8 = com.fasterxml.jackson.databind.ser.PropertyBuilder.C19781.$SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include
            int r6 = r6.ordinal()
            r6 = r8[r6]
            r8 = 1
            switch(r6) {
                case 1: goto L_0x0087;
                case 2: goto L_0x007a;
                case 3: goto L_0x0076;
                case 4: goto L_0x00d0;
                default: goto L_0x0073;
            }
        L_0x0073:
            r8 = 0
            goto L_0x00d0
        L_0x0076:
            java.lang.Object r0 = com.fasterxml.jackson.databind.ser.BeanPropertyWriter.MARKER_FOR_EMPTY
        L_0x0078:
            r12 = r0
            goto L_0x0084
        L_0x007a:
            boolean r0 = r0.isReferenceType()
            if (r0 == 0) goto L_0x0083
            java.lang.Object r0 = com.fasterxml.jackson.databind.ser.BeanPropertyWriter.MARKER_FOR_EMPTY
            goto L_0x0078
        L_0x0083:
            r12 = r5
        L_0x0084:
            r11 = 1
            goto L_0x00e6
        L_0x0087:
            boolean r6 = r1._useRealPropertyDefaults
            if (r6 == 0) goto L_0x00b4
            java.lang.Object r6 = r14.getDefaultBean()
            if (r6 == 0) goto L_0x00b4
            com.fasterxml.jackson.databind.MapperFeature r0 = com.fasterxml.jackson.databind.MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS
            boolean r0 = r15.isEnabled(r0)
            if (r0 == 0) goto L_0x00a4
            com.fasterxml.jackson.databind.SerializationConfig r0 = r1._config
            com.fasterxml.jackson.databind.MapperFeature r9 = com.fasterxml.jackson.databind.MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS
            boolean r0 = r0.isEnabled(r9)
            r13.fixAccess(r0)
        L_0x00a4:
            java.lang.Object r0 = r13.getValue(r6)     // Catch:{ Exception -> 0x00aa }
            r5 = r0
            goto L_0x00b9
        L_0x00aa:
            r0 = move-exception
            r9 = r0
            java.lang.String r0 = r16.getName()
            r14._throwWrapped(r9, r0, r6)
            goto L_0x00b9
        L_0x00b4:
            java.lang.Object r5 = r14.getDefaultValue(r0)
            r3 = 1
        L_0x00b9:
            if (r5 != 0) goto L_0x00bc
            goto L_0x0083
        L_0x00bc:
            java.lang.Class r0 = r5.getClass()
            boolean r0 = r0.isArray()
            if (r0 == 0) goto L_0x00cd
            java.lang.Object r0 = com.fasterxml.jackson.databind.util.ArrayBuilders.getArrayComparator(r5)
            r12 = r0
            r11 = r3
            goto L_0x00e6
        L_0x00cd:
            r11 = r3
            r12 = r5
            goto L_0x00e6
        L_0x00d0:
            boolean r0 = r0.isContainerType()
            if (r0 == 0) goto L_0x00e4
            com.fasterxml.jackson.databind.SerializationConfig r0 = r1._config
            com.fasterxml.jackson.databind.SerializationFeature r3 = com.fasterxml.jackson.databind.SerializationFeature.WRITE_EMPTY_JSON_ARRAYS
            boolean r0 = r0.isEnabled(r3)
            if (r0 != 0) goto L_0x00e4
            java.lang.Object r0 = com.fasterxml.jackson.databind.ser.BeanPropertyWriter.MARKER_FOR_EMPTY
            r12 = r0
            goto L_0x00e5
        L_0x00e4:
            r12 = r5
        L_0x00e5:
            r11 = r8
        L_0x00e6:
            com.fasterxml.jackson.databind.ser.BeanPropertyWriter r0 = new com.fasterxml.jackson.databind.ser.BeanPropertyWriter
            com.fasterxml.jackson.databind.BeanDescription r3 = r1._beanDesc
            com.fasterxml.jackson.databind.util.Annotations r6 = r3.getClassAnnotations()
            r3 = r0
            r4 = r16
            r5 = r21
            r7 = r17
            r8 = r18
            r9 = r19
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            com.fasterxml.jackson.databind.AnnotationIntrospector r3 = r1._annotationIntrospector
            java.lang.Object r3 = r3.findNullSerializer(r13)
            if (r3 == 0) goto L_0x010b
            com.fasterxml.jackson.databind.JsonSerializer r2 = r15.serializerInstance(r13, r3)
            r0.assignNullSerializer(r2)
        L_0x010b:
            com.fasterxml.jackson.databind.AnnotationIntrospector r2 = r1._annotationIntrospector
            com.fasterxml.jackson.databind.util.NameTransformer r2 = r2.findUnwrappingNameTransformer(r13)
            if (r2 == 0) goto L_0x0117
            com.fasterxml.jackson.databind.ser.BeanPropertyWriter r0 = r0.unwrappingWriter(r2)
        L_0x0117:
            return r0
        L_0x0118:
            r0 = move-exception
            r5 = r0
            com.fasterxml.jackson.databind.BeanDescription r0 = r1._beanDesc
            java.lang.String r5 = r5.getMessage()
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Object r0 = r15.reportBadPropertyDefinition(r0, r4, r5, r3)
            com.fasterxml.jackson.databind.ser.BeanPropertyWriter r0 = (com.fasterxml.jackson.databind.ser.BeanPropertyWriter) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.PropertyBuilder.buildWriter(com.fasterxml.jackson.databind.SerializerProvider, com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition, com.fasterxml.jackson.databind.JavaType, com.fasterxml.jackson.databind.JsonSerializer, com.fasterxml.jackson.databind.jsontype.TypeSerializer, com.fasterxml.jackson.databind.jsontype.TypeSerializer, com.fasterxml.jackson.databind.introspect.AnnotatedMember, boolean):com.fasterxml.jackson.databind.ser.BeanPropertyWriter");
    }

    /* access modifiers changed from: protected */
    public JavaType findSerializationType(Annotated annotated, boolean z, JavaType javaType) throws JsonMappingException {
        JavaType refineSerializationType = this._annotationIntrospector.refineSerializationType(this._config, annotated, javaType);
        if (refineSerializationType != javaType) {
            Class rawClass = refineSerializationType.getRawClass();
            Class rawClass2 = javaType.getRawClass();
            if (!rawClass.isAssignableFrom(rawClass2) && !rawClass2.isAssignableFrom(rawClass)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Illegal concrete-type annotation for method '");
                sb.append(annotated.getName());
                sb.append("': class ");
                sb.append(rawClass.getName());
                sb.append(" not a super-type of (declared) class ");
                sb.append(rawClass2.getName());
                throw new IllegalArgumentException(sb.toString());
            }
            javaType = refineSerializationType;
            z = true;
        }
        Typing findSerializationTyping = this._annotationIntrospector.findSerializationTyping(annotated);
        if (!(findSerializationTyping == null || findSerializationTyping == Typing.DEFAULT_TYPING)) {
            z = findSerializationTyping == Typing.STATIC;
        }
        if (z) {
            return javaType.withStaticTyping();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public Object getDefaultBean() {
        Object obj = this._defaultBean;
        if (obj == null) {
            obj = this._beanDesc.instantiateBean(this._config.canOverrideAccessModifiers());
            if (obj == null) {
                obj = NO_DEFAULT_MARKER;
            }
            this._defaultBean = obj;
        }
        if (obj == NO_DEFAULT_MARKER) {
            return null;
        }
        return this._defaultBean;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public Object getPropertyDefaultValue(String str, AnnotatedMember annotatedMember, JavaType javaType) {
        Object defaultBean = getDefaultBean();
        if (defaultBean == null) {
            return getDefaultValue(javaType);
        }
        try {
            return annotatedMember.getValue(defaultBean);
        } catch (Exception e) {
            return _throwWrapped(e, str, defaultBean);
        }
    }

    /* access modifiers changed from: protected */
    public Object getDefaultValue(JavaType javaType) {
        Class<String> rawClass = javaType.getRawClass();
        Class primitiveType = ClassUtil.primitiveType(rawClass);
        if (primitiveType != null) {
            return ClassUtil.defaultValue(primitiveType);
        }
        if (javaType.isContainerType() || javaType.isReferenceType()) {
            return Include.NON_EMPTY;
        }
        if (rawClass == String.class) {
            return "";
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Exception, code=java.lang.Throwable, for r3v0, types: [java.lang.Throwable, java.lang.Exception] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object _throwWrapped(java.lang.Throwable r3, java.lang.String r4, java.lang.Object r5) {
        /*
            r2 = this;
        L_0x0000:
            java.lang.Throwable r0 = r3.getCause()
            if (r0 == 0) goto L_0x000b
            java.lang.Throwable r3 = r3.getCause()
            goto L_0x0000
        L_0x000b:
            boolean r0 = r3 instanceof java.lang.Error
            if (r0 != 0) goto L_0x0042
            boolean r0 = r3 instanceof java.lang.RuntimeException
            if (r0 == 0) goto L_0x0016
            java.lang.RuntimeException r3 = (java.lang.RuntimeException) r3
            throw r3
        L_0x0016:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Failed to get property '"
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = "' of default "
            r0.append(r4)
            java.lang.Class r4 = r5.getClass()
            java.lang.String r4 = r4.getName()
            r0.append(r4)
            java.lang.String r4 = " instance"
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r3.<init>(r4)
            throw r3
        L_0x0042:
            java.lang.Error r3 = (java.lang.Error) r3
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.PropertyBuilder._throwWrapped(java.lang.Exception, java.lang.String, java.lang.Object):java.lang.Object");
    }
}

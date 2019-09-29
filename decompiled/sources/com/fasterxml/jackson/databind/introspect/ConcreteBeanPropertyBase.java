package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import java.io.Serializable;

public abstract class ConcreteBeanPropertyBase implements BeanProperty, Serializable {
    private static final long serialVersionUID = 1;
    protected final PropertyMetadata _metadata;
    protected transient Value _propertyFormat;

    public boolean isVirtual() {
        return false;
    }

    protected ConcreteBeanPropertyBase(PropertyMetadata propertyMetadata) {
        if (propertyMetadata == null) {
            propertyMetadata = PropertyMetadata.STD_REQUIRED_OR_OPTIONAL;
        }
        this._metadata = propertyMetadata;
    }

    protected ConcreteBeanPropertyBase(ConcreteBeanPropertyBase concreteBeanPropertyBase) {
        this._metadata = concreteBeanPropertyBase._metadata;
        this._propertyFormat = concreteBeanPropertyBase._propertyFormat;
    }

    public boolean isRequired() {
        return this._metadata.isRequired();
    }

    public PropertyMetadata getMetadata() {
        return this._metadata;
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0010  */
    /* JADX WARNING: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.fasterxml.jackson.annotation.JsonFormat.Value findFormatOverrides(com.fasterxml.jackson.databind.AnnotationIntrospector r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x000d
            com.fasterxml.jackson.databind.introspect.AnnotatedMember r0 = r1.getMember()
            if (r0 == 0) goto L_0x000d
            com.fasterxml.jackson.annotation.JsonFormat$Value r2 = r2.findFormat(r0)
            goto L_0x000e
        L_0x000d:
            r2 = 0
        L_0x000e:
            if (r2 != 0) goto L_0x0012
            com.fasterxml.jackson.annotation.JsonFormat$Value r2 = EMPTY_FORMAT
        L_0x0012:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase.findFormatOverrides(com.fasterxml.jackson.databind.AnnotationIntrospector):com.fasterxml.jackson.annotation.JsonFormat$Value");
    }

    public Value findPropertyFormat(MapperConfig<?> mapperConfig, Class<?> cls) {
        Value value = this._propertyFormat;
        if (value == null) {
            Value defaultPropertyFormat = mapperConfig.getDefaultPropertyFormat(cls);
            value = null;
            AnnotationIntrospector annotationIntrospector = mapperConfig.getAnnotationIntrospector();
            if (annotationIntrospector != null) {
                AnnotatedMember member = getMember();
                if (member != null) {
                    value = annotationIntrospector.findFormat(member);
                }
            }
            if (defaultPropertyFormat != null) {
                if (value != null) {
                    defaultPropertyFormat = defaultPropertyFormat.withOverrides(value);
                }
                value = defaultPropertyFormat;
            } else if (value == null) {
                value = EMPTY_FORMAT;
            }
            this._propertyFormat = value;
        }
        return value;
    }

    public JsonInclude.Value findPropertyInclusion(MapperConfig<?> mapperConfig, Class<?> cls) {
        JsonInclude.Value defaultPropertyInclusion = mapperConfig.getDefaultPropertyInclusion(cls);
        AnnotationIntrospector annotationIntrospector = mapperConfig.getAnnotationIntrospector();
        AnnotatedMember member = getMember();
        if (annotationIntrospector == null || member == null) {
            return defaultPropertyInclusion;
        }
        JsonInclude.Value findPropertyInclusion = annotationIntrospector.findPropertyInclusion(member);
        if (findPropertyInclusion == null) {
            return defaultPropertyInclusion;
        }
        return defaultPropertyInclusion.withOverrides(findPropertyInclusion);
    }
}

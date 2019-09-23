package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.util.Annotations;
import com.fasterxml.jackson.databind.util.Named;
import java.lang.annotation.Annotation;

public interface BeanProperty extends Named {
    public static final Value EMPTY_FORMAT = new Value();
    public static final JsonInclude.Value EMPTY_INCLUDE = JsonInclude.Value.empty();

    public static class Std implements BeanProperty {
        protected final Annotations _contextAnnotations;
        protected final AnnotatedMember _member;
        protected final PropertyMetadata _metadata;
        protected final PropertyName _name;
        protected final JavaType _type;
        protected final PropertyName _wrapperName;

        public boolean isVirtual() {
            return false;
        }

        public Std(PropertyName propertyName, JavaType javaType, PropertyName propertyName2, Annotations annotations, AnnotatedMember annotatedMember, PropertyMetadata propertyMetadata) {
            this._name = propertyName;
            this._type = javaType;
            this._wrapperName = propertyName2;
            this._metadata = propertyMetadata;
            this._member = annotatedMember;
            this._contextAnnotations = annotations;
        }

        public Std(Std std, JavaType javaType) {
            this(std._name, javaType, std._wrapperName, std._contextAnnotations, std._member, std._metadata);
        }

        public Std withType(JavaType javaType) {
            return new Std(this, javaType);
        }

        public <A extends Annotation> A getAnnotation(Class<A> cls) {
            if (this._member == null) {
                return null;
            }
            return this._member.getAnnotation(cls);
        }

        public <A extends Annotation> A getContextAnnotation(Class<A> cls) {
            if (this._contextAnnotations == null) {
                return null;
            }
            return this._contextAnnotations.get(cls);
        }

        @Deprecated
        public Value findFormatOverrides(AnnotationIntrospector annotationIntrospector) {
            if (!(this._member == null || annotationIntrospector == null)) {
                Value findFormat = annotationIntrospector.findFormat(this._member);
                if (findFormat != null) {
                    return findFormat;
                }
            }
            return EMPTY_FORMAT;
        }

        public Value findPropertyFormat(MapperConfig<?> mapperConfig, Class<?> cls) {
            Value defaultPropertyFormat = mapperConfig.getDefaultPropertyFormat(cls);
            AnnotationIntrospector annotationIntrospector = mapperConfig.getAnnotationIntrospector();
            if (annotationIntrospector == null || this._member == null) {
                return defaultPropertyFormat;
            }
            Value findFormat = annotationIntrospector.findFormat(this._member);
            if (findFormat == null) {
                return defaultPropertyFormat;
            }
            return defaultPropertyFormat.withOverrides(findFormat);
        }

        public JsonInclude.Value findPropertyInclusion(MapperConfig<?> mapperConfig, Class<?> cls) {
            JsonInclude.Value defaultPropertyInclusion = mapperConfig.getDefaultPropertyInclusion(cls);
            AnnotationIntrospector annotationIntrospector = mapperConfig.getAnnotationIntrospector();
            if (annotationIntrospector == null || this._member == null) {
                return defaultPropertyInclusion;
            }
            JsonInclude.Value findPropertyInclusion = annotationIntrospector.findPropertyInclusion(this._member);
            if (findPropertyInclusion == null) {
                return defaultPropertyInclusion;
            }
            return defaultPropertyInclusion.withOverrides(findPropertyInclusion);
        }

        public String getName() {
            return this._name.getSimpleName();
        }

        public PropertyName getFullName() {
            return this._name;
        }

        public JavaType getType() {
            return this._type;
        }

        public PropertyName getWrapperName() {
            return this._wrapperName;
        }

        public boolean isRequired() {
            return this._metadata.isRequired();
        }

        public PropertyMetadata getMetadata() {
            return this._metadata;
        }

        public AnnotatedMember getMember() {
            return this._member;
        }

        public void depositSchemaProperty(JsonObjectFormatVisitor jsonObjectFormatVisitor, SerializerProvider serializerProvider) {
            StringBuilder sb = new StringBuilder();
            sb.append("Instances of ");
            sb.append(getClass().getName());
            sb.append(" should not get visited");
            throw new UnsupportedOperationException(sb.toString());
        }
    }

    void depositSchemaProperty(JsonObjectFormatVisitor jsonObjectFormatVisitor, SerializerProvider serializerProvider) throws JsonMappingException;

    @Deprecated
    Value findFormatOverrides(AnnotationIntrospector annotationIntrospector);

    Value findPropertyFormat(MapperConfig<?> mapperConfig, Class<?> cls);

    JsonInclude.Value findPropertyInclusion(MapperConfig<?> mapperConfig, Class<?> cls);

    <A extends Annotation> A getAnnotation(Class<A> cls);

    <A extends Annotation> A getContextAnnotation(Class<A> cls);

    PropertyName getFullName();

    AnnotatedMember getMember();

    PropertyMetadata getMetadata();

    String getName();

    JavaType getType();

    PropertyName getWrapperName();

    boolean isRequired();

    boolean isVirtual();
}

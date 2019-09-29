package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.Versioned;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Typing;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.Closeable;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class AnnotationIntrospector implements Versioned, Serializable {

    public static class ReferenceProperty {
        private final String _name;
        private final Type _type;

        public enum Type {
            MANAGED_REFERENCE,
            BACK_REFERENCE
        }

        public ReferenceProperty(Type type, String str) {
            this._type = type;
            this._name = str;
        }

        public static ReferenceProperty managed(String str) {
            return new ReferenceProperty(Type.MANAGED_REFERENCE, str);
        }

        public static ReferenceProperty back(String str) {
            return new ReferenceProperty(Type.BACK_REFERENCE, str);
        }

        public Type getType() {
            return this._type;
        }

        public String getName() {
            return this._name;
        }

        public boolean isManagedReference() {
            return this._type == Type.MANAGED_REFERENCE;
        }

        public boolean isBackReference() {
            return this._type == Type.BACK_REFERENCE;
        }
    }

    public void findAndAddVirtualProperties(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, List<BeanPropertyWriter> list) {
    }

    public VisibilityChecker<?> findAutoDetectVisibility(AnnotatedClass annotatedClass, VisibilityChecker<?> visibilityChecker) {
        return visibilityChecker;
    }

    public String findClassDescription(AnnotatedClass annotatedClass) {
        return null;
    }

    public Object findContentDeserializer(Annotated annotated) {
        return null;
    }

    public Object findContentSerializer(Annotated annotated) {
        return null;
    }

    public Mode findCreatorBinding(Annotated annotated) {
        return null;
    }

    public Enum<?> findDefaultEnumValue(Class<Enum<?>> cls) {
        return null;
    }

    public Object findDeserializationContentConverter(AnnotatedMember annotatedMember) {
        return null;
    }

    @Deprecated
    public Class<?> findDeserializationContentType(Annotated annotated, JavaType javaType) {
        return null;
    }

    public Object findDeserializationConverter(Annotated annotated) {
        return null;
    }

    @Deprecated
    public Class<?> findDeserializationKeyType(Annotated annotated, JavaType javaType) {
        return null;
    }

    @Deprecated
    public Class<?> findDeserializationType(Annotated annotated, JavaType javaType) {
        return null;
    }

    public Object findDeserializer(Annotated annotated) {
        return null;
    }

    public Object findFilterId(Annotated annotated) {
        return null;
    }

    public Value findFormat(Annotated annotated) {
        return null;
    }

    @Deprecated
    public Boolean findIgnoreUnknownProperties(AnnotatedClass annotatedClass) {
        return null;
    }

    public String findImplicitPropertyName(AnnotatedMember annotatedMember) {
        return null;
    }

    public Object findInjectableValueId(AnnotatedMember annotatedMember) {
        return null;
    }

    public Object findKeyDeserializer(Annotated annotated) {
        return null;
    }

    public Object findKeySerializer(Annotated annotated) {
        return null;
    }

    public PropertyName findNameForDeserialization(Annotated annotated) {
        return null;
    }

    public PropertyName findNameForSerialization(Annotated annotated) {
        return null;
    }

    public Object findNamingStrategy(AnnotatedClass annotatedClass) {
        return null;
    }

    public Object findNullSerializer(Annotated annotated) {
        return null;
    }

    public ObjectIdInfo findObjectIdInfo(Annotated annotated) {
        return null;
    }

    public ObjectIdInfo findObjectReferenceInfo(Annotated annotated, ObjectIdInfo objectIdInfo) {
        return objectIdInfo;
    }

    public Class<?> findPOJOBuilder(AnnotatedClass annotatedClass) {
        return null;
    }

    public JsonPOJOBuilder.Value findPOJOBuilderConfig(AnnotatedClass annotatedClass) {
        return null;
    }

    @Deprecated
    public String[] findPropertiesToIgnore(Annotated annotated) {
        return null;
    }

    @Deprecated
    public String[] findPropertiesToIgnore(Annotated annotated, boolean z) {
        return null;
    }

    public Access findPropertyAccess(Annotated annotated) {
        return null;
    }

    public TypeResolverBuilder<?> findPropertyContentTypeResolver(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        return null;
    }

    public String findPropertyDefaultValue(Annotated annotated) {
        return null;
    }

    public String findPropertyDescription(Annotated annotated) {
        return null;
    }

    public Integer findPropertyIndex(Annotated annotated) {
        return null;
    }

    public TypeResolverBuilder<?> findPropertyTypeResolver(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        return null;
    }

    public ReferenceProperty findReferenceType(AnnotatedMember annotatedMember) {
        return null;
    }

    public PropertyName findRootName(AnnotatedClass annotatedClass) {
        return null;
    }

    public Object findSerializationContentConverter(AnnotatedMember annotatedMember) {
        return null;
    }

    @Deprecated
    public Class<?> findSerializationContentType(Annotated annotated, JavaType javaType) {
        return null;
    }

    public Object findSerializationConverter(Annotated annotated) {
        return null;
    }

    @Deprecated
    public Include findSerializationInclusion(Annotated annotated, Include include) {
        return include;
    }

    @Deprecated
    public Include findSerializationInclusionForContent(Annotated annotated, Include include) {
        return include;
    }

    @Deprecated
    public Class<?> findSerializationKeyType(Annotated annotated, JavaType javaType) {
        return null;
    }

    public String[] findSerializationPropertyOrder(AnnotatedClass annotatedClass) {
        return null;
    }

    public Boolean findSerializationSortAlphabetically(Annotated annotated) {
        return null;
    }

    @Deprecated
    public Class<?> findSerializationType(Annotated annotated) {
        return null;
    }

    public Typing findSerializationTyping(Annotated annotated) {
        return null;
    }

    public Object findSerializer(Annotated annotated) {
        return null;
    }

    public List<NamedType> findSubtypes(Annotated annotated) {
        return null;
    }

    public String findTypeName(AnnotatedClass annotatedClass) {
        return null;
    }

    public TypeResolverBuilder<?> findTypeResolver(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, JavaType javaType) {
        return null;
    }

    public NameTransformer findUnwrappingNameTransformer(AnnotatedMember annotatedMember) {
        return null;
    }

    public Object findValueInstantiator(AnnotatedClass annotatedClass) {
        return null;
    }

    public Class<?>[] findViews(Annotated annotated) {
        return null;
    }

    public PropertyName findWrapperName(Annotated annotated) {
        return null;
    }

    public boolean hasAnyGetterAnnotation(AnnotatedMethod annotatedMethod) {
        return false;
    }

    public boolean hasAnySetterAnnotation(AnnotatedMethod annotatedMethod) {
        return false;
    }

    public boolean hasAsValueAnnotation(AnnotatedMethod annotatedMethod) {
        return false;
    }

    public boolean hasCreatorAnnotation(Annotated annotated) {
        return false;
    }

    public boolean hasIgnoreMarker(AnnotatedMember annotatedMember) {
        return false;
    }

    public Boolean hasRequiredMarker(AnnotatedMember annotatedMember) {
        return null;
    }

    public boolean isAnnotationBundle(Annotation annotation) {
        return false;
    }

    public Boolean isIgnorableType(AnnotatedClass annotatedClass) {
        return null;
    }

    public Boolean isTypeId(AnnotatedMember annotatedMember) {
        return null;
    }

    public AnnotatedMethod resolveSetterConflict(MapperConfig<?> mapperConfig, AnnotatedMethod annotatedMethod, AnnotatedMethod annotatedMethod2) {
        return null;
    }

    public abstract Version version();

    public static AnnotationIntrospector nopInstance() {
        return NopAnnotationIntrospector.instance;
    }

    public static AnnotationIntrospector pair(AnnotationIntrospector annotationIntrospector, AnnotationIntrospector annotationIntrospector2) {
        return new AnnotationIntrospectorPair(annotationIntrospector, annotationIntrospector2);
    }

    public Collection<AnnotationIntrospector> allIntrospectors() {
        return Collections.singletonList(this);
    }

    public Collection<AnnotationIntrospector> allIntrospectors(Collection<AnnotationIntrospector> collection) {
        collection.add(this);
        return collection;
    }

    public JsonIgnoreProperties.Value findPropertyIgnorals(Annotated annotated) {
        JsonIgnoreProperties.Value value;
        String[] findPropertiesToIgnore = findPropertiesToIgnore(annotated, true);
        Boolean findIgnoreUnknownProperties = annotated instanceof AnnotatedClass ? findIgnoreUnknownProperties((AnnotatedClass) annotated) : null;
        if (findPropertiesToIgnore != null) {
            value = JsonIgnoreProperties.Value.forIgnoredProperties(findPropertiesToIgnore);
        } else if (findIgnoreUnknownProperties == null) {
            return null;
        } else {
            value = JsonIgnoreProperties.Value.empty();
        }
        if (findIgnoreUnknownProperties != null) {
            value = findIgnoreUnknownProperties.booleanValue() ? value.withIgnoreUnknown() : value.withoutIgnoreUnknown();
        }
        return value;
    }

    public JsonInclude.Value findPropertyInclusion(Annotated annotated) {
        return JsonInclude.Value.empty();
    }

    public JavaType refineSerializationType(MapperConfig<?> mapperConfig, Annotated annotated, JavaType javaType) throws JsonMappingException {
        JavaType javaType2;
        JavaType javaType3;
        JavaType constructSpecializedType;
        TypeFactory typeFactory = mapperConfig.getTypeFactory();
        Class findSerializationType = findSerializationType(annotated);
        if (findSerializationType != null) {
            if (javaType.hasRawClass(findSerializationType)) {
                javaType = javaType.withStaticTyping();
            } else {
                Class rawClass = javaType.getRawClass();
                try {
                    if (findSerializationType.isAssignableFrom(rawClass)) {
                        constructSpecializedType = typeFactory.constructGeneralizedType(javaType, findSerializationType);
                    } else if (rawClass.isAssignableFrom(findSerializationType)) {
                        constructSpecializedType = typeFactory.constructSpecializedType(javaType, findSerializationType);
                    } else {
                        throw new JsonMappingException((Closeable) null, String.format("Can not refine serialization type %s into %s; types not related", new Object[]{javaType, findSerializationType.getName()}));
                    }
                    javaType = constructSpecializedType;
                } catch (IllegalArgumentException e) {
                    throw new JsonMappingException((Closeable) null, String.format("Failed to widen type %s with annotation (value %s), from '%s': %s", new Object[]{javaType, findSerializationType.getName(), annotated.getName(), e.getMessage()}), (Throwable) e);
                }
            }
        }
        if (javaType.isMapLikeType()) {
            JavaType keyType = javaType.getKeyType();
            Class findSerializationKeyType = findSerializationKeyType(annotated, keyType);
            if (findSerializationKeyType != null) {
                if (keyType.hasRawClass(findSerializationKeyType)) {
                    javaType3 = keyType.withStaticTyping();
                } else {
                    Class rawClass2 = keyType.getRawClass();
                    try {
                        if (findSerializationKeyType.isAssignableFrom(rawClass2)) {
                            javaType3 = typeFactory.constructGeneralizedType(keyType, findSerializationKeyType);
                        } else if (rawClass2.isAssignableFrom(findSerializationKeyType)) {
                            javaType3 = typeFactory.constructSpecializedType(keyType, findSerializationKeyType);
                        } else {
                            throw new JsonMappingException((Closeable) null, String.format("Can not refine serialization key type %s into %s; types not related", new Object[]{keyType, findSerializationKeyType.getName()}));
                        }
                    } catch (IllegalArgumentException e2) {
                        throw new JsonMappingException((Closeable) null, String.format("Failed to widen key type of %s with concrete-type annotation (value %s), from '%s': %s", new Object[]{javaType, findSerializationKeyType.getName(), annotated.getName(), e2.getMessage()}), (Throwable) e2);
                    }
                }
                javaType = ((MapLikeType) javaType).withKeyType(javaType3);
            }
        }
        JavaType contentType = javaType.getContentType();
        if (contentType == null) {
            return javaType;
        }
        Class findSerializationContentType = findSerializationContentType(annotated, contentType);
        if (findSerializationContentType == null) {
            return javaType;
        }
        if (contentType.hasRawClass(findSerializationContentType)) {
            javaType2 = contentType.withStaticTyping();
        } else {
            Class rawClass3 = contentType.getRawClass();
            try {
                if (findSerializationContentType.isAssignableFrom(rawClass3)) {
                    javaType2 = typeFactory.constructGeneralizedType(contentType, findSerializationContentType);
                } else if (rawClass3.isAssignableFrom(findSerializationContentType)) {
                    javaType2 = typeFactory.constructSpecializedType(contentType, findSerializationContentType);
                } else {
                    throw new JsonMappingException((Closeable) null, String.format("Can not refine serialization content type %s into %s; types not related", new Object[]{contentType, findSerializationContentType.getName()}));
                }
            } catch (IllegalArgumentException e3) {
                throw new JsonMappingException((Closeable) null, String.format("Internal error: failed to refine value type of %s with concrete-type annotation (value %s), from '%s': %s", new Object[]{javaType, findSerializationContentType.getName(), annotated.getName(), e3.getMessage()}), (Throwable) e3);
            }
        }
        return javaType.withContentType(javaType2);
    }

    @Deprecated
    public String findEnumValue(Enum<?> enumR) {
        return enumR.name();
    }

    public String[] findEnumValues(Class<?> cls, Enum<?>[] enumArr, String[] strArr) {
        int length = enumArr.length;
        for (int i = 0; i < length; i++) {
            if (strArr[i] == null) {
                strArr[i] = findEnumValue(enumArr[i]);
            }
        }
        return strArr;
    }

    public JavaType refineDeserializationType(MapperConfig<?> mapperConfig, Annotated annotated, JavaType javaType) throws JsonMappingException {
        TypeFactory typeFactory = mapperConfig.getTypeFactory();
        Class findDeserializationType = findDeserializationType(annotated, javaType);
        if (findDeserializationType != null && !javaType.hasRawClass(findDeserializationType)) {
            try {
                javaType = typeFactory.constructSpecializedType(javaType, findDeserializationType);
            } catch (IllegalArgumentException e) {
                throw new JsonMappingException((Closeable) null, String.format("Failed to narrow type %s with annotation (value %s), from '%s': %s", new Object[]{javaType, findDeserializationType.getName(), annotated.getName(), e.getMessage()}), (Throwable) e);
            }
        }
        if (javaType.isMapLikeType()) {
            JavaType keyType = javaType.getKeyType();
            Class findDeserializationKeyType = findDeserializationKeyType(annotated, keyType);
            if (findDeserializationKeyType != null) {
                try {
                    javaType = ((MapLikeType) javaType).withKeyType(typeFactory.constructSpecializedType(keyType, findDeserializationKeyType));
                } catch (IllegalArgumentException e2) {
                    throw new JsonMappingException((Closeable) null, String.format("Failed to narrow key type of %s with concrete-type annotation (value %s), from '%s': %s", new Object[]{javaType, findDeserializationKeyType.getName(), annotated.getName(), e2.getMessage()}), (Throwable) e2);
                }
            }
        }
        JavaType contentType = javaType.getContentType();
        if (contentType != null) {
            Class findDeserializationContentType = findDeserializationContentType(annotated, contentType);
            if (findDeserializationContentType != null) {
                try {
                    return javaType.withContentType(typeFactory.constructSpecializedType(contentType, findDeserializationContentType));
                } catch (IllegalArgumentException e3) {
                    throw new JsonMappingException((Closeable) null, String.format("Failed to narrow value type of %s with concrete-type annotation (value %s), from '%s': %s", new Object[]{javaType, findDeserializationContentType.getName(), annotated.getName(), e3.getMessage()}), (Throwable) e3);
                }
            }
        }
        return javaType;
    }

    /* access modifiers changed from: protected */
    public <A extends Annotation> A _findAnnotation(Annotated annotated, Class<A> cls) {
        return annotated.getAnnotation(cls);
    }

    /* access modifiers changed from: protected */
    public boolean _hasAnnotation(Annotated annotated, Class<? extends Annotation> cls) {
        return annotated.hasAnnotation(cls);
    }

    /* access modifiers changed from: protected */
    public boolean _hasOneOf(Annotated annotated, Class<? extends Annotation>[] clsArr) {
        return annotated.hasOneOf(clsArr);
    }
}
package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder.Value;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector.MixInResolver;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.LRUMap;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

public class BasicClassIntrospector extends ClassIntrospector implements Serializable {
    protected static final BasicBeanDescription BOOLEAN_DESC = BasicBeanDescription.forOtherUse(null, SimpleType.constructUnsafe(Boolean.TYPE), AnnotatedClass.constructWithoutSuperTypes(Boolean.TYPE, null));
    protected static final BasicBeanDescription INT_DESC = BasicBeanDescription.forOtherUse(null, SimpleType.constructUnsafe(Integer.TYPE), AnnotatedClass.constructWithoutSuperTypes(Integer.TYPE, null));
    protected static final BasicBeanDescription LONG_DESC = BasicBeanDescription.forOtherUse(null, SimpleType.constructUnsafe(Long.TYPE), AnnotatedClass.constructWithoutSuperTypes(Long.TYPE, null));
    protected static final BasicBeanDescription STRING_DESC = BasicBeanDescription.forOtherUse(null, SimpleType.constructUnsafe(String.class), AnnotatedClass.constructWithoutSuperTypes(String.class, null));
    @Deprecated
    public static final BasicClassIntrospector instance = new BasicClassIntrospector();
    private static final long serialVersionUID = 1;
    protected final LRUMap<JavaType, BasicBeanDescription> _cachedFCA = new LRUMap<>(16, 64);

    public BasicBeanDescription forSerialization(SerializationConfig serializationConfig, JavaType javaType, MixInResolver mixInResolver) {
        BasicBeanDescription _findStdTypeDesc = _findStdTypeDesc(javaType);
        if (_findStdTypeDesc == null) {
            _findStdTypeDesc = _findStdJdkCollectionDesc(serializationConfig, javaType);
            if (_findStdTypeDesc == null) {
                _findStdTypeDesc = BasicBeanDescription.forSerialization(collectProperties(serializationConfig, javaType, mixInResolver, true, "set"));
            }
            this._cachedFCA.putIfAbsent(javaType, _findStdTypeDesc);
        }
        return _findStdTypeDesc;
    }

    public BasicBeanDescription forDeserialization(DeserializationConfig deserializationConfig, JavaType javaType, MixInResolver mixInResolver) {
        BasicBeanDescription _findStdTypeDesc = _findStdTypeDesc(javaType);
        if (_findStdTypeDesc == null) {
            _findStdTypeDesc = _findStdJdkCollectionDesc(deserializationConfig, javaType);
            if (_findStdTypeDesc == null) {
                _findStdTypeDesc = BasicBeanDescription.forDeserialization(collectProperties(deserializationConfig, javaType, mixInResolver, false, "set"));
            }
            this._cachedFCA.putIfAbsent(javaType, _findStdTypeDesc);
        }
        return _findStdTypeDesc;
    }

    public BasicBeanDescription forDeserializationWithBuilder(DeserializationConfig deserializationConfig, JavaType javaType, MixInResolver mixInResolver) {
        BasicBeanDescription forDeserialization = BasicBeanDescription.forDeserialization(collectPropertiesWithBuilder(deserializationConfig, javaType, mixInResolver, false));
        this._cachedFCA.putIfAbsent(javaType, forDeserialization);
        return forDeserialization;
    }

    public BasicBeanDescription forCreation(DeserializationConfig deserializationConfig, JavaType javaType, MixInResolver mixInResolver) {
        BasicBeanDescription _findStdTypeDesc = _findStdTypeDesc(javaType);
        if (_findStdTypeDesc != null) {
            return _findStdTypeDesc;
        }
        BasicBeanDescription _findStdJdkCollectionDesc = _findStdJdkCollectionDesc(deserializationConfig, javaType);
        if (_findStdJdkCollectionDesc != null) {
            return _findStdJdkCollectionDesc;
        }
        return BasicBeanDescription.forDeserialization(collectProperties(deserializationConfig, javaType, mixInResolver, false, "set"));
    }

    public BasicBeanDescription forClassAnnotations(MapperConfig<?> mapperConfig, JavaType javaType, MixInResolver mixInResolver) {
        BasicBeanDescription _findStdTypeDesc = _findStdTypeDesc(javaType);
        if (_findStdTypeDesc != null) {
            return _findStdTypeDesc;
        }
        BasicBeanDescription basicBeanDescription = (BasicBeanDescription) this._cachedFCA.get(javaType);
        if (basicBeanDescription != null) {
            return basicBeanDescription;
        }
        BasicBeanDescription forOtherUse = BasicBeanDescription.forOtherUse(mapperConfig, javaType, AnnotatedClass.construct(javaType, mapperConfig, mixInResolver));
        this._cachedFCA.put(javaType, forOtherUse);
        return forOtherUse;
    }

    public BasicBeanDescription forDirectClassAnnotations(MapperConfig<?> mapperConfig, JavaType javaType, MixInResolver mixInResolver) {
        BasicBeanDescription _findStdTypeDesc = _findStdTypeDesc(javaType);
        return _findStdTypeDesc == null ? BasicBeanDescription.forOtherUse(mapperConfig, javaType, AnnotatedClass.constructWithoutSuperTypes(javaType.getRawClass(), mapperConfig, mixInResolver)) : _findStdTypeDesc;
    }

    /* access modifiers changed from: protected */
    public POJOPropertiesCollector collectProperties(MapperConfig<?> mapperConfig, JavaType javaType, MixInResolver mixInResolver, boolean z, String str) {
        return constructPropertyCollector(mapperConfig, AnnotatedClass.construct(javaType, mapperConfig, mixInResolver), javaType, z, str);
    }

    /* access modifiers changed from: protected */
    public POJOPropertiesCollector collectPropertiesWithBuilder(MapperConfig<?> mapperConfig, JavaType javaType, MixInResolver mixInResolver, boolean z) {
        String str;
        Value value = null;
        AnnotationIntrospector annotationIntrospector = mapperConfig.isAnnotationProcessingEnabled() ? mapperConfig.getAnnotationIntrospector() : null;
        AnnotatedClass construct = AnnotatedClass.construct(javaType, mapperConfig, mixInResolver);
        if (annotationIntrospector != null) {
            value = annotationIntrospector.findPOJOBuilderConfig(construct);
        }
        if (value == null) {
            str = "with";
        } else {
            str = value.withPrefix;
        }
        return constructPropertyCollector(mapperConfig, construct, javaType, z, str);
    }

    /* access modifiers changed from: protected */
    public POJOPropertiesCollector constructPropertyCollector(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, JavaType javaType, boolean z, String str) {
        POJOPropertiesCollector pOJOPropertiesCollector = new POJOPropertiesCollector(mapperConfig, z, javaType, annotatedClass, str);
        return pOJOPropertiesCollector;
    }

    /* access modifiers changed from: protected */
    public BasicBeanDescription _findStdTypeDesc(JavaType javaType) {
        Class<String> rawClass = javaType.getRawClass();
        if (rawClass.isPrimitive()) {
            if (rawClass == Boolean.TYPE) {
                return BOOLEAN_DESC;
            }
            if (rawClass == Integer.TYPE) {
                return INT_DESC;
            }
            if (rawClass == Long.TYPE) {
                return LONG_DESC;
            }
        } else if (rawClass == String.class) {
            return STRING_DESC;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean _isStdJDKCollection(JavaType javaType) {
        if (!javaType.isContainerType() || javaType.isArrayType()) {
            return false;
        }
        Class rawClass = javaType.getRawClass();
        String packageName = ClassUtil.getPackageName(rawClass);
        if (packageName == null || ((!packageName.startsWith("java.lang") && !packageName.startsWith("java.util")) || (!Collection.class.isAssignableFrom(rawClass) && !Map.class.isAssignableFrom(rawClass)))) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public BasicBeanDescription _findStdJdkCollectionDesc(MapperConfig<?> mapperConfig, JavaType javaType) {
        if (_isStdJDKCollection(javaType)) {
            return BasicBeanDescription.forOtherUse(mapperConfig, javaType, AnnotatedClass.construct(javaType, mapperConfig));
        }
        return null;
    }
}

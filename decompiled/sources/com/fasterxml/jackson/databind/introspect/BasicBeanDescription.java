package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.util.Annotations;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.Converter;
import com.fasterxml.jackson.databind.util.Converter.None;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BasicBeanDescription extends BeanDescription {
    protected final AnnotationIntrospector _annotationIntrospector;
    protected final AnnotatedClass _classInfo;
    protected final MapperConfig<?> _config;
    protected ObjectIdInfo _objectIdInfo;
    protected final POJOPropertiesCollector _propCollector;
    protected List<BeanPropertyDefinition> _properties;

    protected BasicBeanDescription(POJOPropertiesCollector pOJOPropertiesCollector, JavaType javaType, AnnotatedClass annotatedClass) {
        super(javaType);
        this._propCollector = pOJOPropertiesCollector;
        this._config = pOJOPropertiesCollector.getConfig();
        if (this._config == null) {
            this._annotationIntrospector = null;
        } else {
            this._annotationIntrospector = this._config.getAnnotationIntrospector();
        }
        this._classInfo = annotatedClass;
    }

    protected BasicBeanDescription(MapperConfig<?> mapperConfig, JavaType javaType, AnnotatedClass annotatedClass, List<BeanPropertyDefinition> list) {
        super(javaType);
        this._propCollector = null;
        this._config = mapperConfig;
        if (this._config == null) {
            this._annotationIntrospector = null;
        } else {
            this._annotationIntrospector = this._config.getAnnotationIntrospector();
        }
        this._classInfo = annotatedClass;
        this._properties = list;
    }

    protected BasicBeanDescription(POJOPropertiesCollector pOJOPropertiesCollector) {
        this(pOJOPropertiesCollector, pOJOPropertiesCollector.getType(), pOJOPropertiesCollector.getClassDef());
        this._objectIdInfo = pOJOPropertiesCollector.getObjectIdInfo();
    }

    public static BasicBeanDescription forDeserialization(POJOPropertiesCollector pOJOPropertiesCollector) {
        return new BasicBeanDescription(pOJOPropertiesCollector);
    }

    public static BasicBeanDescription forSerialization(POJOPropertiesCollector pOJOPropertiesCollector) {
        return new BasicBeanDescription(pOJOPropertiesCollector);
    }

    public static BasicBeanDescription forOtherUse(MapperConfig<?> mapperConfig, JavaType javaType, AnnotatedClass annotatedClass) {
        return new BasicBeanDescription(mapperConfig, javaType, annotatedClass, Collections.emptyList());
    }

    /* access modifiers changed from: protected */
    public List<BeanPropertyDefinition> _properties() {
        if (this._properties == null) {
            this._properties = this._propCollector.getProperties();
        }
        return this._properties;
    }

    public boolean removeProperty(String str) {
        Iterator it = _properties().iterator();
        while (it.hasNext()) {
            if (((BeanPropertyDefinition) it.next()).getName().equals(str)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public boolean addProperty(BeanPropertyDefinition beanPropertyDefinition) {
        if (hasProperty(beanPropertyDefinition.getFullName())) {
            return false;
        }
        _properties().add(beanPropertyDefinition);
        return true;
    }

    public boolean hasProperty(PropertyName propertyName) {
        return findProperty(propertyName) != null;
    }

    public BeanPropertyDefinition findProperty(PropertyName propertyName) {
        for (BeanPropertyDefinition beanPropertyDefinition : _properties()) {
            if (beanPropertyDefinition.hasName(propertyName)) {
                return beanPropertyDefinition;
            }
        }
        return null;
    }

    public AnnotatedClass getClassInfo() {
        return this._classInfo;
    }

    public ObjectIdInfo getObjectIdInfo() {
        return this._objectIdInfo;
    }

    public List<BeanPropertyDefinition> findProperties() {
        return _properties();
    }

    public AnnotatedMethod findJsonValueMethod() {
        if (this._propCollector == null) {
            return null;
        }
        return this._propCollector.getJsonValueMethod();
    }

    public Set<String> getIgnoredPropertyNames() {
        Set<String> ignoredPropertyNames = this._propCollector == null ? null : this._propCollector.getIgnoredPropertyNames();
        return ignoredPropertyNames == null ? Collections.emptySet() : ignoredPropertyNames;
    }

    public boolean hasKnownClassAnnotations() {
        return this._classInfo.hasAnnotations();
    }

    public Annotations getClassAnnotations() {
        return this._classInfo.getAnnotations();
    }

    @Deprecated
    public TypeBindings bindingsForBeanType() {
        return this._type.getBindings();
    }

    @Deprecated
    public JavaType resolveType(Type type) {
        if (type == null) {
            return null;
        }
        return this._config.getTypeFactory().constructType(type, this._type.getBindings());
    }

    public AnnotatedConstructor findDefaultConstructor() {
        return this._classInfo.getDefaultConstructor();
    }

    public AnnotatedMethod findAnySetter() throws IllegalArgumentException {
        AnnotatedMethod anySetterMethod = this._propCollector == null ? null : this._propCollector.getAnySetterMethod();
        if (anySetterMethod != null) {
            Class<Object> rawParameterType = anySetterMethod.getRawParameterType(0);
            if (!(rawParameterType == String.class || rawParameterType == Object.class)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid 'any-setter' annotation on method ");
                sb.append(anySetterMethod.getName());
                sb.append("(): first argument not of type String or Object, but ");
                sb.append(rawParameterType.getName());
                throw new IllegalArgumentException(sb.toString());
            }
        }
        return anySetterMethod;
    }

    public Map<Object, AnnotatedMember> findInjectables() {
        if (this._propCollector != null) {
            return this._propCollector.getInjectables();
        }
        return Collections.emptyMap();
    }

    public List<AnnotatedConstructor> getConstructors() {
        return this._classInfo.getConstructors();
    }

    public Object instantiateBean(boolean z) {
        AnnotatedConstructor defaultConstructor = this._classInfo.getDefaultConstructor();
        if (defaultConstructor == null) {
            return null;
        }
        if (z) {
            defaultConstructor.fixAccess(this._config.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        try {
            return defaultConstructor.getAnnotated().newInstance(new Object[0]);
        } catch (Exception e) {
            e = e;
            while (e.getCause() != null) {
                e = e.getCause();
            }
            if (e instanceof Error) {
                throw ((Error) e);
            } else if (e instanceof RuntimeException) {
                throw ((RuntimeException) e);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to instantiate bean of type ");
                sb.append(this._classInfo.getAnnotated().getName());
                sb.append(": (");
                sb.append(e.getClass().getName());
                sb.append(") ");
                sb.append(e.getMessage());
                throw new IllegalArgumentException(sb.toString(), e);
            }
        }
    }

    public AnnotatedMethod findMethod(String str, Class<?>[] clsArr) {
        return this._classInfo.findMethod(str, clsArr);
    }

    public Value findExpectedFormat(Value value) {
        if (this._annotationIntrospector != null) {
            Value findFormat = this._annotationIntrospector.findFormat(this._classInfo);
            if (findFormat != null) {
                if (value == null) {
                    value = findFormat;
                } else {
                    value = value.withOverrides(findFormat);
                }
            }
        }
        Value defaultPropertyFormat = this._config.getDefaultPropertyFormat(this._classInfo.getRawType());
        if (defaultPropertyFormat == null) {
            return value;
        }
        if (value == null) {
            return defaultPropertyFormat;
        }
        return value.withOverrides(defaultPropertyFormat);
    }

    public Converter<Object, Object> findSerializationConverter() {
        if (this._annotationIntrospector == null) {
            return null;
        }
        return _createConverter(this._annotationIntrospector.findSerializationConverter(this._classInfo));
    }

    public JsonInclude.Value findPropertyInclusion(JsonInclude.Value value) {
        if (this._annotationIntrospector != null) {
            JsonInclude.Value findPropertyInclusion = this._annotationIntrospector.findPropertyInclusion(this._classInfo);
            if (findPropertyInclusion != null) {
                if (value != null) {
                    findPropertyInclusion = value.withOverrides(findPropertyInclusion);
                }
                return findPropertyInclusion;
            }
        }
        return value;
    }

    public AnnotatedMember findAnyGetter() throws IllegalArgumentException {
        AnnotatedMember anyGetter = this._propCollector == null ? null : this._propCollector.getAnyGetter();
        if (anyGetter != null) {
            if (!Map.class.isAssignableFrom(anyGetter.getRawType())) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid 'any-getter' annotation on method ");
                sb.append(anyGetter.getName());
                sb.append("(): return type is not instance of java.util.Map");
                throw new IllegalArgumentException(sb.toString());
            }
        }
        return anyGetter;
    }

    public AnnotatedMember findAnySetterField() throws IllegalArgumentException {
        AnnotatedMember anySetterField = this._propCollector == null ? null : this._propCollector.getAnySetterField();
        if (anySetterField != null) {
            if (!Map.class.isAssignableFrom(anySetterField.getRawType())) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid 'any-setter' annotation on field ");
                sb.append(anySetterField.getName());
                sb.append("(): type is not instance of java.util.Map");
                throw new IllegalArgumentException(sb.toString());
            }
        }
        return anySetterField;
    }

    public Map<String, AnnotatedMember> findBackReferenceProperties() {
        HashMap hashMap = null;
        for (BeanPropertyDefinition mutator : _properties()) {
            AnnotatedMember mutator2 = mutator.getMutator();
            if (mutator2 != null) {
                ReferenceProperty findReferenceType = this._annotationIntrospector.findReferenceType(mutator2);
                if (findReferenceType != null && findReferenceType.isBackReference()) {
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    String name = findReferenceType.getName();
                    if (hashMap.put(name, mutator2) != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Multiple back-reference properties with name '");
                        sb.append(name);
                        sb.append("'");
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
            }
        }
        return hashMap;
    }

    public List<AnnotatedMethod> getFactoryMethods() {
        List<AnnotatedMethod> staticMethods = this._classInfo.getStaticMethods();
        if (staticMethods.isEmpty()) {
            return staticMethods;
        }
        ArrayList arrayList = new ArrayList();
        for (AnnotatedMethod annotatedMethod : staticMethods) {
            if (isFactoryMethod(annotatedMethod)) {
                arrayList.add(annotatedMethod);
            }
        }
        return arrayList;
    }

    public Constructor<?> findSingleArgConstructor(Class<?>... clsArr) {
        for (AnnotatedConstructor annotatedConstructor : this._classInfo.getConstructors()) {
            if (annotatedConstructor.getParameterCount() == 1) {
                Class<?> rawParameterType = annotatedConstructor.getRawParameterType(0);
                for (Class<?> cls : clsArr) {
                    if (cls == rawParameterType) {
                        return annotatedConstructor.getAnnotated();
                    }
                }
                continue;
            }
        }
        return null;
    }

    public Method findFactoryMethod(Class<?>... clsArr) {
        for (AnnotatedMethod annotatedMethod : this._classInfo.getStaticMethods()) {
            if (isFactoryMethod(annotatedMethod) && annotatedMethod.getParameterCount() == 1) {
                Class rawParameterType = annotatedMethod.getRawParameterType(0);
                for (Class<?> isAssignableFrom : clsArr) {
                    if (rawParameterType.isAssignableFrom(isAssignableFrom)) {
                        return annotatedMethod.getAnnotated();
                    }
                }
                continue;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean isFactoryMethod(AnnotatedMethod annotatedMethod) {
        if (!getBeanClass().isAssignableFrom(annotatedMethod.getRawReturnType())) {
            return false;
        }
        if (this._annotationIntrospector.hasCreatorAnnotation(annotatedMethod)) {
            return true;
        }
        String name = annotatedMethod.getName();
        if ("valueOf".equals(name) && annotatedMethod.getParameterCount() == 1) {
            return true;
        }
        if ("fromString".equals(name) && annotatedMethod.getParameterCount() == 1) {
            Class<String> rawParameterType = annotatedMethod.getRawParameterType(0);
            if (rawParameterType == String.class || CharSequence.class.isAssignableFrom(rawParameterType)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public PropertyName _findCreatorPropertyName(AnnotatedParameter annotatedParameter) {
        PropertyName findNameForDeserialization = this._annotationIntrospector.findNameForDeserialization(annotatedParameter);
        if (findNameForDeserialization != null && !findNameForDeserialization.isEmpty()) {
            return findNameForDeserialization;
        }
        String findImplicitPropertyName = this._annotationIntrospector.findImplicitPropertyName(annotatedParameter);
        return (findImplicitPropertyName == null || findImplicitPropertyName.isEmpty()) ? findNameForDeserialization : PropertyName.construct(findImplicitPropertyName);
    }

    public Class<?> findPOJOBuilder() {
        if (this._annotationIntrospector == null) {
            return null;
        }
        return this._annotationIntrospector.findPOJOBuilder(this._classInfo);
    }

    public JsonPOJOBuilder.Value findPOJOBuilderConfig() {
        if (this._annotationIntrospector == null) {
            return null;
        }
        return this._annotationIntrospector.findPOJOBuilderConfig(this._classInfo);
    }

    public Converter<Object, Object> findDeserializationConverter() {
        if (this._annotationIntrospector == null) {
            return null;
        }
        return _createConverter(this._annotationIntrospector.findDeserializationConverter(this._classInfo));
    }

    public String findClassDescription() {
        if (this._annotationIntrospector == null) {
            return null;
        }
        return this._annotationIntrospector.findClassDescription(this._classInfo);
    }

    @Deprecated
    public LinkedHashMap<String, AnnotatedField> _findPropertyFields(Collection<String> collection, boolean z) {
        LinkedHashMap<String, AnnotatedField> linkedHashMap = new LinkedHashMap<>();
        for (BeanPropertyDefinition beanPropertyDefinition : _properties()) {
            AnnotatedField field = beanPropertyDefinition.getField();
            if (field != null) {
                String name = beanPropertyDefinition.getName();
                if (collection == null || !collection.contains(name)) {
                    linkedHashMap.put(name, field);
                }
            }
        }
        return linkedHashMap;
    }

    public Converter<Object, Object> _createConverter(Object obj) {
        Converter<Object, Object> converter = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Converter) {
            return (Converter) obj;
        }
        if (obj instanceof Class) {
            Class<None> cls = (Class) obj;
            if (cls == None.class || ClassUtil.isBogusClass(cls)) {
                return null;
            }
            if (Converter.class.isAssignableFrom(cls)) {
                HandlerInstantiator handlerInstantiator = this._config.getHandlerInstantiator();
                if (handlerInstantiator != null) {
                    converter = handlerInstantiator.converterInstance(this._config, this._classInfo, cls);
                }
                if (converter == null) {
                    converter = (Converter) ClassUtil.createInstance(cls, this._config.canOverrideAccessModifiers());
                }
                return converter;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("AnnotationIntrospector returned Class ");
            sb.append(cls.getName());
            sb.append("; expected Class<Converter>");
            throw new IllegalStateException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("AnnotationIntrospector returned Converter definition of type ");
        sb2.append(obj.getClass().getName());
        sb2.append("; expected type Converter or Class<Converter> instead");
        throw new IllegalStateException(sb2.toString());
    }
}

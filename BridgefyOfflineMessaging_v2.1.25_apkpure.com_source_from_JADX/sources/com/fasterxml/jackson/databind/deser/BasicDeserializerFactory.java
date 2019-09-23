package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.AbstractTypeResolver;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty.Std;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.deser.impl.CreatorCollector;
import com.fasterxml.jackson.databind.deser.std.ArrayBlockingQueueDeserializer;
import com.fasterxml.jackson.databind.deser.std.AtomicReferenceDeserializer;
import com.fasterxml.jackson.databind.deser.std.CollectionDeserializer;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.deser.std.EnumSetDeserializer;
import com.fasterxml.jackson.databind.deser.std.JdkDeserializers;
import com.fasterxml.jackson.databind.deser.std.JsonLocationInstantiator;
import com.fasterxml.jackson.databind.deser.std.JsonNodeDeserializer;
import com.fasterxml.jackson.databind.deser.std.MapEntryDeserializer;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import com.fasterxml.jackson.databind.deser.std.ObjectArrayDeserializer;
import com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializers;
import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringCollectionDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.deser.std.TokenBufferDeserializer;
import com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer;
import com.fasterxml.jackson.databind.ext.OptionalHandlerFactory;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fasterxml.jackson.databind.introspect.BasicBeanDescription;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.EnumResolver;
import com.fasterxml.jackson.databind.util.SimpleBeanPropertyDefinition;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicReference;

public abstract class BasicDeserializerFactory extends DeserializerFactory implements Serializable {
    private static final Class<?> CLASS_CHAR_BUFFER = CharSequence.class;
    private static final Class<?> CLASS_ITERABLE = Iterable.class;
    private static final Class<?> CLASS_MAP_ENTRY = Entry.class;
    private static final Class<?> CLASS_OBJECT = Object.class;
    private static final Class<?> CLASS_STRING = String.class;
    protected static final PropertyName UNWRAPPED_CREATOR_PARAM_NAME = new PropertyName("@JsonUnwrapped");
    static final HashMap<String, Class<? extends Collection>> _collectionFallbacks = new HashMap<>();
    static final HashMap<String, Class<? extends Map>> _mapFallbacks = new HashMap<>();
    protected final DeserializerFactoryConfig _factoryConfig;

    /* access modifiers changed from: protected */
    public abstract DeserializerFactory withConfig(DeserializerFactoryConfig deserializerFactoryConfig);

    static {
        _mapFallbacks.put(Map.class.getName(), LinkedHashMap.class);
        _mapFallbacks.put(ConcurrentMap.class.getName(), ConcurrentHashMap.class);
        _mapFallbacks.put(SortedMap.class.getName(), TreeMap.class);
        _mapFallbacks.put(NavigableMap.class.getName(), TreeMap.class);
        _mapFallbacks.put(ConcurrentNavigableMap.class.getName(), ConcurrentSkipListMap.class);
        _collectionFallbacks.put(Collection.class.getName(), ArrayList.class);
        _collectionFallbacks.put(List.class.getName(), ArrayList.class);
        _collectionFallbacks.put(Set.class.getName(), HashSet.class);
        _collectionFallbacks.put(SortedSet.class.getName(), TreeSet.class);
        _collectionFallbacks.put(Queue.class.getName(), LinkedList.class);
        _collectionFallbacks.put("java.util.Deque", LinkedList.class);
        _collectionFallbacks.put("java.util.NavigableSet", TreeSet.class);
    }

    protected BasicDeserializerFactory(DeserializerFactoryConfig deserializerFactoryConfig) {
        this._factoryConfig = deserializerFactoryConfig;
    }

    public DeserializerFactoryConfig getFactoryConfig() {
        return this._factoryConfig;
    }

    public final DeserializerFactory withAdditionalDeserializers(Deserializers deserializers) {
        return withConfig(this._factoryConfig.withAdditionalDeserializers(deserializers));
    }

    public final DeserializerFactory withAdditionalKeyDeserializers(KeyDeserializers keyDeserializers) {
        return withConfig(this._factoryConfig.withAdditionalKeyDeserializers(keyDeserializers));
    }

    public final DeserializerFactory withDeserializerModifier(BeanDeserializerModifier beanDeserializerModifier) {
        return withConfig(this._factoryConfig.withDeserializerModifier(beanDeserializerModifier));
    }

    public final DeserializerFactory withAbstractTypeResolver(AbstractTypeResolver abstractTypeResolver) {
        return withConfig(this._factoryConfig.withAbstractTypeResolver(abstractTypeResolver));
    }

    public final DeserializerFactory withValueInstantiators(ValueInstantiators valueInstantiators) {
        return withConfig(this._factoryConfig.withValueInstantiators(valueInstantiators));
    }

    public JavaType mapAbstractType(DeserializationConfig deserializationConfig, JavaType javaType) throws JsonMappingException {
        JavaType _mapAbstractType2;
        while (true) {
            _mapAbstractType2 = _mapAbstractType2(deserializationConfig, javaType);
            if (_mapAbstractType2 == null) {
                return javaType;
            }
            Class rawClass = javaType.getRawClass();
            Class rawClass2 = _mapAbstractType2.getRawClass();
            if (rawClass == rawClass2 || !rawClass.isAssignableFrom(rawClass2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid abstract type resolution from ");
                sb.append(javaType);
                sb.append(" to ");
                sb.append(_mapAbstractType2);
                sb.append(": latter is not a subtype of former");
            } else {
                javaType = _mapAbstractType2;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Invalid abstract type resolution from ");
        sb2.append(javaType);
        sb2.append(" to ");
        sb2.append(_mapAbstractType2);
        sb2.append(": latter is not a subtype of former");
        throw new IllegalArgumentException(sb2.toString());
    }

    private JavaType _mapAbstractType2(DeserializationConfig deserializationConfig, JavaType javaType) throws JsonMappingException {
        Class rawClass = javaType.getRawClass();
        if (this._factoryConfig.hasAbstractTypeResolvers()) {
            for (AbstractTypeResolver findTypeMapping : this._factoryConfig.abstractTypeResolvers()) {
                JavaType findTypeMapping2 = findTypeMapping.findTypeMapping(deserializationConfig, javaType);
                if (findTypeMapping2 != null && findTypeMapping2.getRawClass() != rawClass) {
                    return findTypeMapping2;
                }
            }
        }
        return null;
    }

    public ValueInstantiator findValueInstantiator(DeserializationContext deserializationContext, BeanDescription beanDescription) throws JsonMappingException {
        DeserializationConfig config = deserializationContext.getConfig();
        AnnotatedClass classInfo = beanDescription.getClassInfo();
        Object findValueInstantiator = deserializationContext.getAnnotationIntrospector().findValueInstantiator(classInfo);
        ValueInstantiator _valueInstantiatorInstance = findValueInstantiator != null ? _valueInstantiatorInstance(config, classInfo, findValueInstantiator) : null;
        if (_valueInstantiatorInstance == null) {
            _valueInstantiatorInstance = _findStdValueInstantiator(config, beanDescription);
            if (_valueInstantiatorInstance == null) {
                _valueInstantiatorInstance = _constructDefaultValueInstantiator(deserializationContext, beanDescription);
            }
        }
        if (this._factoryConfig.hasValueInstantiators()) {
            for (ValueInstantiators valueInstantiators : this._factoryConfig.valueInstantiators()) {
                _valueInstantiatorInstance = valueInstantiators.findValueInstantiator(config, beanDescription, _valueInstantiatorInstance);
                if (_valueInstantiatorInstance == null) {
                    deserializationContext.reportMappingException("Broken registered ValueInstantiators (of type %s): returned null ValueInstantiator", valueInstantiators.getClass().getName());
                }
            }
        }
        if (_valueInstantiatorInstance.getIncompleteParameter() == null) {
            return _valueInstantiatorInstance;
        }
        AnnotatedParameter incompleteParameter = _valueInstantiatorInstance.getIncompleteParameter();
        AnnotatedWithParams owner = incompleteParameter.getOwner();
        StringBuilder sb = new StringBuilder();
        sb.append("Argument #");
        sb.append(incompleteParameter.getIndex());
        sb.append(" of constructor ");
        sb.append(owner);
        sb.append(" has no property name annotation; must have name when multiple-parameter constructor annotated as Creator");
        throw new IllegalArgumentException(sb.toString());
    }

    private ValueInstantiator _findStdValueInstantiator(DeserializationConfig deserializationConfig, BeanDescription beanDescription) throws JsonMappingException {
        if (beanDescription.getBeanClass() == JsonLocation.class) {
            return new JsonLocationInstantiator();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public ValueInstantiator _constructDefaultValueInstantiator(DeserializationContext deserializationContext, BeanDescription beanDescription) throws JsonMappingException {
        CreatorCollector creatorCollector = new CreatorCollector(beanDescription, deserializationContext.getConfig());
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        DeserializationConfig config = deserializationContext.getConfig();
        VisibilityChecker findAutoDetectVisibility = annotationIntrospector.findAutoDetectVisibility(beanDescription.getClassInfo(), config.getDefaultVisibilityChecker());
        Map _findCreatorsFromProperties = _findCreatorsFromProperties(deserializationContext, beanDescription);
        _addDeserializerFactoryMethods(deserializationContext, beanDescription, findAutoDetectVisibility, annotationIntrospector, creatorCollector, _findCreatorsFromProperties);
        if (beanDescription.getType().isConcrete()) {
            _addDeserializerConstructors(deserializationContext, beanDescription, findAutoDetectVisibility, annotationIntrospector, creatorCollector, _findCreatorsFromProperties);
        }
        return creatorCollector.constructValueInstantiator(config);
    }

    /* access modifiers changed from: protected */
    public Map<AnnotatedWithParams, BeanPropertyDefinition[]> _findCreatorsFromProperties(DeserializationContext deserializationContext, BeanDescription beanDescription) throws JsonMappingException {
        Map<AnnotatedWithParams, BeanPropertyDefinition[]> emptyMap = Collections.emptyMap();
        for (BeanPropertyDefinition beanPropertyDefinition : beanDescription.findProperties()) {
            Iterator constructorParameters = beanPropertyDefinition.getConstructorParameters();
            while (true) {
                if (constructorParameters.hasNext()) {
                    AnnotatedParameter annotatedParameter = (AnnotatedParameter) constructorParameters.next();
                    AnnotatedWithParams owner = annotatedParameter.getOwner();
                    BeanPropertyDefinition[] beanPropertyDefinitionArr = (BeanPropertyDefinition[]) emptyMap.get(owner);
                    int index = annotatedParameter.getIndex();
                    if (beanPropertyDefinitionArr == null) {
                        if (emptyMap.isEmpty()) {
                            emptyMap = new LinkedHashMap<>();
                        }
                        beanPropertyDefinitionArr = new BeanPropertyDefinition[owner.getParameterCount()];
                        emptyMap.put(owner, beanPropertyDefinitionArr);
                    } else if (beanPropertyDefinitionArr[index] != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Conflict: parameter #");
                        sb.append(index);
                        sb.append(" of ");
                        sb.append(owner);
                        sb.append(" bound to more than one property; ");
                        sb.append(beanPropertyDefinitionArr[index]);
                        sb.append(" vs ");
                        sb.append(beanPropertyDefinition);
                        throw new IllegalStateException(sb.toString());
                    }
                    beanPropertyDefinitionArr[index] = beanPropertyDefinition;
                }
            }
        }
        return emptyMap;
    }

    public ValueInstantiator _valueInstantiatorInstance(DeserializationConfig deserializationConfig, Annotated annotated, Object obj) throws JsonMappingException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof ValueInstantiator) {
            return (ValueInstantiator) obj;
        }
        if (obj instanceof Class) {
            Class cls = (Class) obj;
            if (ClassUtil.isBogusClass(cls)) {
                return null;
            }
            if (ValueInstantiator.class.isAssignableFrom(cls)) {
                HandlerInstantiator handlerInstantiator = deserializationConfig.getHandlerInstantiator();
                if (handlerInstantiator != null) {
                    ValueInstantiator valueInstantiatorInstance = handlerInstantiator.valueInstantiatorInstance(deserializationConfig, annotated, cls);
                    if (valueInstantiatorInstance != null) {
                        return valueInstantiatorInstance;
                    }
                }
                return (ValueInstantiator) ClassUtil.createInstance(cls, deserializationConfig.canOverrideAccessModifiers());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("AnnotationIntrospector returned Class ");
            sb.append(cls.getName());
            sb.append("; expected Class<ValueInstantiator>");
            throw new IllegalStateException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("AnnotationIntrospector returned key deserializer definition of type ");
        sb2.append(obj.getClass().getName());
        sb2.append("; expected type KeyDeserializer or Class<KeyDeserializer> instead");
        throw new IllegalStateException(sb2.toString());
    }

    /* access modifiers changed from: protected */
    public void _addDeserializerConstructors(DeserializationContext deserializationContext, BeanDescription beanDescription, VisibilityChecker<?> visibilityChecker, AnnotationIntrospector annotationIntrospector, CreatorCollector creatorCollector, Map<AnnotatedWithParams, BeanPropertyDefinition[]> map) throws JsonMappingException {
        Iterator it;
        BeanPropertyDefinition beanPropertyDefinition;
        PropertyName propertyName;
        int i;
        Iterator it2;
        int i2;
        SettableBeanProperty[] settableBeanPropertyArr;
        AnnotatedParameter annotatedParameter;
        BeanPropertyDefinition beanPropertyDefinition2;
        PropertyName propertyName2;
        AnnotationIntrospector annotationIntrospector2 = annotationIntrospector;
        CreatorCollector creatorCollector2 = creatorCollector;
        AnnotatedConstructor findDefaultConstructor = beanDescription.findDefaultConstructor();
        if (findDefaultConstructor != null && (!creatorCollector.hasDefaultCreator() || annotationIntrospector2.hasCreatorAnnotation(findDefaultConstructor))) {
            creatorCollector2.setDefaultCreator(findDefaultConstructor);
        }
        if (!beanDescription.isNonStaticInnerClass()) {
            Iterator it3 = beanDescription.getConstructors().iterator();
            LinkedList linkedList = null;
            while (it3.hasNext()) {
                AnnotatedConstructor annotatedConstructor = (AnnotatedConstructor) it3.next();
                boolean hasCreatorAnnotation = annotationIntrospector2.hasCreatorAnnotation(annotatedConstructor);
                BeanPropertyDefinition[] beanPropertyDefinitionArr = (BeanPropertyDefinition[]) map.get(annotatedConstructor);
                int parameterCount = annotatedConstructor.getParameterCount();
                if (parameterCount == 1) {
                    if (beanPropertyDefinitionArr == null) {
                        beanPropertyDefinition2 = null;
                    } else {
                        beanPropertyDefinition2 = beanPropertyDefinitionArr[0];
                    }
                    if (_checkIfCreatorPropertyBased(annotationIntrospector2, annotatedConstructor, beanPropertyDefinition2)) {
                        SettableBeanProperty[] settableBeanPropertyArr2 = new SettableBeanProperty[1];
                        if (beanPropertyDefinition2 == null) {
                            propertyName2 = null;
                        } else {
                            propertyName2 = beanPropertyDefinition2.getFullName();
                        }
                        AnnotatedParameter parameter = annotatedConstructor.getParameter(0);
                        SettableBeanProperty[] settableBeanPropertyArr3 = settableBeanPropertyArr2;
                        settableBeanPropertyArr3[0] = constructCreatorProperty(deserializationContext, beanDescription, propertyName2, 0, parameter, annotationIntrospector2.findInjectableValueId(parameter));
                        creatorCollector2.addPropertyCreator(annotatedConstructor, hasCreatorAnnotation, settableBeanPropertyArr3);
                    } else {
                        BeanPropertyDefinition beanPropertyDefinition3 = beanPropertyDefinition2;
                        _handleSingleArgumentConstructor(deserializationContext, beanDescription, visibilityChecker, annotationIntrospector, creatorCollector, annotatedConstructor, hasCreatorAnnotation, visibilityChecker.isCreatorVisible((AnnotatedMember) annotatedConstructor));
                        if (beanPropertyDefinition3 != null) {
                            ((POJOPropertyBuilder) beanPropertyDefinition3).removeConstructors();
                        }
                    }
                    it = it3;
                } else {
                    VisibilityChecker<?> visibilityChecker2 = visibilityChecker;
                    int i3 = 0;
                    SettableBeanProperty[] settableBeanPropertyArr4 = new SettableBeanProperty[parameterCount];
                    AnnotatedParameter annotatedParameter2 = null;
                    int i4 = 0;
                    int i5 = 0;
                    int i6 = 0;
                    while (i4 < parameterCount) {
                        AnnotatedParameter parameter2 = annotatedConstructor.getParameter(i4);
                        if (beanPropertyDefinitionArr == null) {
                            beanPropertyDefinition = null;
                        } else {
                            beanPropertyDefinition = beanPropertyDefinitionArr[i4];
                        }
                        Object findInjectableValueId = annotationIntrospector2.findInjectableValueId(parameter2);
                        if (beanPropertyDefinition == null) {
                            propertyName = null;
                        } else {
                            propertyName = beanPropertyDefinition.getFullName();
                        }
                        if (beanPropertyDefinition == null || !beanPropertyDefinition.isExplicitlyNamed()) {
                            AnnotatedParameter annotatedParameter3 = parameter2;
                            i = i4;
                            settableBeanPropertyArr = settableBeanPropertyArr4;
                            i2 = parameterCount;
                            it2 = it3;
                            annotatedParameter = annotatedParameter2;
                            if (findInjectableValueId != null) {
                                i6++;
                                settableBeanPropertyArr[i] = constructCreatorProperty(deserializationContext, beanDescription, propertyName, i, annotatedParameter3, findInjectableValueId);
                            } else {
                                AnnotatedParameter annotatedParameter4 = annotatedParameter3;
                                if (annotationIntrospector2.findUnwrappingNameTransformer(annotatedParameter4) != null) {
                                    settableBeanPropertyArr[i] = constructCreatorProperty(deserializationContext, beanDescription, UNWRAPPED_CREATOR_PARAM_NAME, i, annotatedParameter4, null);
                                    i3++;
                                } else if (hasCreatorAnnotation && propertyName != null && !propertyName.isEmpty()) {
                                    i5++;
                                    settableBeanPropertyArr[i] = constructCreatorProperty(deserializationContext, beanDescription, propertyName, i, annotatedParameter4, findInjectableValueId);
                                } else if (annotatedParameter == null) {
                                    annotatedParameter2 = annotatedParameter4;
                                    i4 = i + 1;
                                    settableBeanPropertyArr4 = settableBeanPropertyArr;
                                    parameterCount = i2;
                                    it3 = it2;
                                    VisibilityChecker<?> visibilityChecker3 = visibilityChecker;
                                    Map<AnnotatedWithParams, BeanPropertyDefinition[]> map2 = map;
                                }
                            }
                        } else {
                            i3++;
                            it2 = it3;
                            annotatedParameter = annotatedParameter2;
                            i = i4;
                            settableBeanPropertyArr = settableBeanPropertyArr4;
                            i2 = parameterCount;
                            settableBeanPropertyArr[i] = constructCreatorProperty(deserializationContext, beanDescription, propertyName, i4, parameter2, findInjectableValueId);
                        }
                        annotatedParameter2 = annotatedParameter;
                        i4 = i + 1;
                        settableBeanPropertyArr4 = settableBeanPropertyArr;
                        parameterCount = i2;
                        it3 = it2;
                        VisibilityChecker<?> visibilityChecker32 = visibilityChecker;
                        Map<AnnotatedWithParams, BeanPropertyDefinition[]> map22 = map;
                    }
                    SettableBeanProperty[] settableBeanPropertyArr5 = settableBeanPropertyArr4;
                    int i7 = parameterCount;
                    it = it3;
                    AnnotatedParameter annotatedParameter5 = annotatedParameter2;
                    int i8 = i3 + i5;
                    if (hasCreatorAnnotation || i3 > 0 || i6 > 0) {
                        if (i8 + i6 == i7) {
                            creatorCollector2.addPropertyCreator(annotatedConstructor, hasCreatorAnnotation, settableBeanPropertyArr5);
                        } else if (i3 == 0 && i6 + 1 == i7) {
                            creatorCollector2.addDelegatingCreator(annotatedConstructor, hasCreatorAnnotation, settableBeanPropertyArr5);
                        } else {
                            PropertyName _findImplicitParamName = _findImplicitParamName(annotatedParameter5, annotationIntrospector2);
                            if (_findImplicitParamName == null || _findImplicitParamName.isEmpty()) {
                                int index = annotatedParameter5.getIndex();
                                StringBuilder sb = new StringBuilder();
                                sb.append("Argument #");
                                sb.append(index);
                                sb.append(" of constructor ");
                                sb.append(annotatedConstructor);
                                sb.append(" has no property name annotation; must have name when multiple-parameter constructor annotated as Creator");
                                throw new IllegalArgumentException(sb.toString());
                            }
                        }
                    }
                    if (!creatorCollector.hasDefaultCreator()) {
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                        }
                        linkedList.add(annotatedConstructor);
                    }
                }
                it3 = it;
            }
            if (linkedList != null && !creatorCollector.hasDelegatingCreator() && !creatorCollector.hasPropertyBasedCreator()) {
                _checkImplicitlyNamedConstructors(deserializationContext, beanDescription, visibilityChecker, annotationIntrospector, creatorCollector, linkedList);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void _checkImplicitlyNamedConstructors(DeserializationContext deserializationContext, BeanDescription beanDescription, VisibilityChecker<?> visibilityChecker, AnnotationIntrospector annotationIntrospector, CreatorCollector creatorCollector, List<AnnotatedConstructor> list) throws JsonMappingException {
        int i;
        Iterator it = list.iterator();
        AnnotatedConstructor annotatedConstructor = null;
        AnnotatedConstructor annotatedConstructor2 = null;
        SettableBeanProperty[] settableBeanPropertyArr = null;
        while (true) {
            if (!it.hasNext()) {
                annotatedConstructor = annotatedConstructor2;
                break;
            }
            AnnotatedConstructor annotatedConstructor3 = (AnnotatedConstructor) it.next();
            if (visibilityChecker.isCreatorVisible((AnnotatedMember) annotatedConstructor3)) {
                int parameterCount = annotatedConstructor3.getParameterCount();
                SettableBeanProperty[] settableBeanPropertyArr2 = new SettableBeanProperty[parameterCount];
                int i2 = 0;
                while (true) {
                    if (i2 < parameterCount) {
                        AnnotatedParameter parameter = annotatedConstructor3.getParameter(i2);
                        PropertyName _findParamName = _findParamName(parameter, annotationIntrospector);
                        if (_findParamName == null || _findParamName.isEmpty()) {
                            break;
                        }
                        settableBeanPropertyArr2[i2] = constructCreatorProperty(deserializationContext, beanDescription, _findParamName, parameter.getIndex(), parameter, null);
                        i2++;
                    } else if (annotatedConstructor2 != null) {
                        break;
                    } else {
                        annotatedConstructor2 = annotatedConstructor3;
                        settableBeanPropertyArr = settableBeanPropertyArr2;
                    }
                }
            }
        }
        if (annotatedConstructor != null) {
            creatorCollector.addPropertyCreator(annotatedConstructor, false, settableBeanPropertyArr);
            BasicBeanDescription basicBeanDescription = (BasicBeanDescription) beanDescription;
            for (SettableBeanProperty settableBeanProperty : settableBeanPropertyArr) {
                PropertyName fullName = settableBeanProperty.getFullName();
                if (!basicBeanDescription.hasProperty(fullName)) {
                    basicBeanDescription.addProperty(SimpleBeanPropertyDefinition.construct((MapperConfig<?>) deserializationContext.getConfig(), settableBeanProperty.getMember(), fullName));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean _checkIfCreatorPropertyBased(AnnotationIntrospector annotationIntrospector, AnnotatedWithParams annotatedWithParams, BeanPropertyDefinition beanPropertyDefinition) {
        Mode findCreatorBinding = annotationIntrospector.findCreatorBinding(annotatedWithParams);
        if (findCreatorBinding == Mode.PROPERTIES) {
            return true;
        }
        if (findCreatorBinding == Mode.DELEGATING) {
            return false;
        }
        if ((beanPropertyDefinition != null && beanPropertyDefinition.isExplicitlyNamed()) || annotationIntrospector.findInjectableValueId(annotatedWithParams.getParameter(0)) != null) {
            return true;
        }
        if (beanPropertyDefinition != null) {
            String name = beanPropertyDefinition.getName();
            if (name == null || name.isEmpty() || !beanPropertyDefinition.couldSerialize()) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean _handleSingleArgumentConstructor(DeserializationContext deserializationContext, BeanDescription beanDescription, VisibilityChecker<?> visibilityChecker, AnnotationIntrospector annotationIntrospector, CreatorCollector creatorCollector, AnnotatedConstructor annotatedConstructor, boolean z, boolean z2) throws JsonMappingException {
        Class<Boolean> rawParameterType = annotatedConstructor.getRawParameterType(0);
        if (rawParameterType == String.class || rawParameterType == CharSequence.class) {
            if (z || z2) {
                creatorCollector.addStringCreator(annotatedConstructor, z);
            }
            return true;
        } else if (rawParameterType == Integer.TYPE || rawParameterType == Integer.class) {
            if (z || z2) {
                creatorCollector.addIntCreator(annotatedConstructor, z);
            }
            return true;
        } else if (rawParameterType == Long.TYPE || rawParameterType == Long.class) {
            if (z || z2) {
                creatorCollector.addLongCreator(annotatedConstructor, z);
            }
            return true;
        } else if (rawParameterType == Double.TYPE || rawParameterType == Double.class) {
            if (z || z2) {
                creatorCollector.addDoubleCreator(annotatedConstructor, z);
            }
            return true;
        } else if (rawParameterType == Boolean.TYPE || rawParameterType == Boolean.class) {
            if (z || z2) {
                creatorCollector.addBooleanCreator(annotatedConstructor, z);
            }
            return true;
        } else if (!z) {
            return false;
        } else {
            creatorCollector.addDelegatingCreator(annotatedConstructor, z, null);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void _addDeserializerFactoryMethods(DeserializationContext deserializationContext, BeanDescription beanDescription, VisibilityChecker<?> visibilityChecker, AnnotationIntrospector annotationIntrospector, CreatorCollector creatorCollector, Map<AnnotatedWithParams, BeanPropertyDefinition[]> map) throws JsonMappingException {
        BeanPropertyDefinition beanPropertyDefinition;
        PropertyName propertyName;
        BasicDeserializerFactory basicDeserializerFactory;
        BeanPropertyDefinition beanPropertyDefinition2;
        AnnotationIntrospector annotationIntrospector2 = annotationIntrospector;
        CreatorCollector creatorCollector2 = creatorCollector;
        DeserializationConfig config = deserializationContext.getConfig();
        for (AnnotatedMethod annotatedMethod : beanDescription.getFactoryMethods()) {
            boolean hasCreatorAnnotation = annotationIntrospector2.hasCreatorAnnotation(annotatedMethod);
            int parameterCount = annotatedMethod.getParameterCount();
            if (parameterCount != 0) {
                BeanPropertyDefinition[] beanPropertyDefinitionArr = (BeanPropertyDefinition[]) map.get(annotatedMethod);
                int i = 0;
                if (parameterCount == 1) {
                    if (beanPropertyDefinitionArr == null) {
                        basicDeserializerFactory = this;
                        beanPropertyDefinition2 = null;
                    } else {
                        basicDeserializerFactory = this;
                        beanPropertyDefinition2 = beanPropertyDefinitionArr[0];
                    }
                    if (!basicDeserializerFactory._checkIfCreatorPropertyBased(annotationIntrospector2, annotatedMethod, beanPropertyDefinition2)) {
                        _handleSingleArgumentFactory(config, beanDescription, visibilityChecker, annotationIntrospector, creatorCollector, annotatedMethod, hasCreatorAnnotation);
                        if (beanPropertyDefinition2 != null) {
                            ((POJOPropertyBuilder) beanPropertyDefinition2).removeConstructors();
                        }
                    }
                } else {
                    if (!hasCreatorAnnotation) {
                        continue;
                    }
                }
                SettableBeanProperty[] settableBeanPropertyArr = new SettableBeanProperty[parameterCount];
                AnnotatedParameter annotatedParameter = null;
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                while (i < parameterCount) {
                    AnnotatedParameter parameter = annotatedMethod.getParameter(i);
                    if (beanPropertyDefinitionArr == null) {
                        beanPropertyDefinition = null;
                    } else {
                        beanPropertyDefinition = beanPropertyDefinitionArr[i];
                    }
                    Object findInjectableValueId = annotationIntrospector2.findInjectableValueId(parameter);
                    if (beanPropertyDefinition == null) {
                        propertyName = null;
                    } else {
                        propertyName = beanPropertyDefinition.getFullName();
                    }
                    if (beanPropertyDefinition == null || !beanPropertyDefinition.isExplicitlyNamed()) {
                        AnnotatedParameter annotatedParameter2 = parameter;
                        if (findInjectableValueId != null) {
                            i4++;
                            settableBeanPropertyArr[i] = constructCreatorProperty(deserializationContext, beanDescription, propertyName, i, annotatedParameter2, findInjectableValueId);
                        } else {
                            AnnotatedParameter annotatedParameter3 = annotatedParameter2;
                            if (annotationIntrospector2.findUnwrappingNameTransformer(annotatedParameter3) != null) {
                                AnnotatedParameter annotatedParameter4 = annotatedParameter3;
                                settableBeanPropertyArr[i] = constructCreatorProperty(deserializationContext, beanDescription, UNWRAPPED_CREATOR_PARAM_NAME, i, annotatedParameter4, null);
                                i3++;
                            } else {
                                AnnotatedParameter annotatedParameter5 = annotatedParameter3;
                                if (hasCreatorAnnotation && propertyName != null && !propertyName.isEmpty()) {
                                    i3++;
                                    settableBeanPropertyArr[i] = constructCreatorProperty(deserializationContext, beanDescription, propertyName, i, annotatedParameter5, findInjectableValueId);
                                } else if (annotatedParameter == null) {
                                    annotatedParameter = annotatedParameter5;
                                }
                            }
                        }
                    } else {
                        i2++;
                        settableBeanPropertyArr[i] = constructCreatorProperty(deserializationContext, beanDescription, propertyName, i, parameter, findInjectableValueId);
                    }
                    i++;
                }
                int i5 = i2 + i3;
                if (hasCreatorAnnotation || i2 > 0 || i4 > 0) {
                    if (i5 + i4 == parameterCount) {
                        creatorCollector2.addPropertyCreator(annotatedMethod, hasCreatorAnnotation, settableBeanPropertyArr);
                    } else if (i2 == 0 && i4 + 1 == parameterCount) {
                        creatorCollector2.addDelegatingCreator(annotatedMethod, hasCreatorAnnotation, settableBeanPropertyArr);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Argument #");
                        sb.append(annotatedParameter.getIndex());
                        sb.append(" of factory method ");
                        sb.append(annotatedMethod);
                        sb.append(" has no property name annotation; must have name when multiple-parameter constructor annotated as Creator");
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
            } else if (hasCreatorAnnotation) {
                creatorCollector2.setDefaultCreator(annotatedMethod);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean _handleSingleArgumentFactory(DeserializationConfig deserializationConfig, BeanDescription beanDescription, VisibilityChecker<?> visibilityChecker, AnnotationIntrospector annotationIntrospector, CreatorCollector creatorCollector, AnnotatedMethod annotatedMethod, boolean z) throws JsonMappingException {
        Class<Boolean> rawParameterType = annotatedMethod.getRawParameterType(0);
        if (rawParameterType == String.class || rawParameterType == CharSequence.class) {
            if (z || visibilityChecker.isCreatorVisible((AnnotatedMember) annotatedMethod)) {
                creatorCollector.addStringCreator(annotatedMethod, z);
            }
            return true;
        } else if (rawParameterType == Integer.TYPE || rawParameterType == Integer.class) {
            if (z || visibilityChecker.isCreatorVisible((AnnotatedMember) annotatedMethod)) {
                creatorCollector.addIntCreator(annotatedMethod, z);
            }
            return true;
        } else if (rawParameterType == Long.TYPE || rawParameterType == Long.class) {
            if (z || visibilityChecker.isCreatorVisible((AnnotatedMember) annotatedMethod)) {
                creatorCollector.addLongCreator(annotatedMethod, z);
            }
            return true;
        } else if (rawParameterType == Double.TYPE || rawParameterType == Double.class) {
            if (z || visibilityChecker.isCreatorVisible((AnnotatedMember) annotatedMethod)) {
                creatorCollector.addDoubleCreator(annotatedMethod, z);
            }
            return true;
        } else if (rawParameterType == Boolean.TYPE || rawParameterType == Boolean.class) {
            if (z || visibilityChecker.isCreatorVisible((AnnotatedMember) annotatedMethod)) {
                creatorCollector.addBooleanCreator(annotatedMethod, z);
            }
            return true;
        } else if (!z) {
            return false;
        } else {
            creatorCollector.addDelegatingCreator(annotatedMethod, z, null);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public SettableBeanProperty constructCreatorProperty(DeserializationContext deserializationContext, BeanDescription beanDescription, PropertyName propertyName, int i, AnnotatedParameter annotatedParameter, Object obj) throws JsonMappingException {
        PropertyMetadata construct;
        DeserializationContext deserializationContext2 = deserializationContext;
        AnnotatedParameter annotatedParameter2 = annotatedParameter;
        DeserializationConfig config = deserializationContext.getConfig();
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        if (annotationIntrospector == null) {
            construct = PropertyMetadata.STD_REQUIRED_OR_OPTIONAL;
        } else {
            construct = PropertyMetadata.construct(annotationIntrospector.hasRequiredMarker(annotatedParameter2), annotationIntrospector.findPropertyDescription(annotatedParameter2), annotationIntrospector.findPropertyIndex(annotatedParameter2), annotationIntrospector.findPropertyDefaultValue(annotatedParameter2));
        }
        PropertyMetadata propertyMetadata = construct;
        JavaType resolveMemberAndTypeAnnotations = resolveMemberAndTypeAnnotations(deserializationContext2, annotatedParameter2, annotatedParameter.getType());
        Std std = new Std(propertyName, resolveMemberAndTypeAnnotations, annotationIntrospector.findWrapperName(annotatedParameter2), beanDescription.getClassAnnotations(), annotatedParameter, propertyMetadata);
        TypeDeserializer typeDeserializer = (TypeDeserializer) resolveMemberAndTypeAnnotations.getTypeHandler();
        if (typeDeserializer == null) {
            typeDeserializer = findTypeDeserializer(config, resolveMemberAndTypeAnnotations);
        }
        CreatorProperty creatorProperty = new CreatorProperty(propertyName, resolveMemberAndTypeAnnotations, std.getWrapperName(), typeDeserializer, beanDescription.getClassAnnotations(), annotatedParameter, i, obj, propertyMetadata);
        JsonDeserializer findDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationContext2, annotatedParameter2);
        if (findDeserializerFromAnnotation == null) {
            findDeserializerFromAnnotation = (JsonDeserializer) resolveMemberAndTypeAnnotations.getValueHandler();
        }
        return findDeserializerFromAnnotation != null ? creatorProperty.withValueDeserializer(deserializationContext2.handlePrimaryContextualization(findDeserializerFromAnnotation, creatorProperty, resolveMemberAndTypeAnnotations)) : creatorProperty;
    }

    /* access modifiers changed from: protected */
    public PropertyName _findParamName(AnnotatedParameter annotatedParameter, AnnotationIntrospector annotationIntrospector) {
        if (!(annotatedParameter == null || annotationIntrospector == null)) {
            PropertyName findNameForDeserialization = annotationIntrospector.findNameForDeserialization(annotatedParameter);
            if (findNameForDeserialization != null) {
                return findNameForDeserialization;
            }
            String findImplicitPropertyName = annotationIntrospector.findImplicitPropertyName(annotatedParameter);
            if (findImplicitPropertyName != null && !findImplicitPropertyName.isEmpty()) {
                return PropertyName.construct(findImplicitPropertyName);
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public PropertyName _findImplicitParamName(AnnotatedParameter annotatedParameter, AnnotationIntrospector annotationIntrospector) {
        String findImplicitPropertyName = annotationIntrospector.findImplicitPropertyName(annotatedParameter);
        if (findImplicitPropertyName == null || findImplicitPropertyName.isEmpty()) {
            return null;
        }
        return PropertyName.construct(findImplicitPropertyName);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public PropertyName _findExplicitParamName(AnnotatedParameter annotatedParameter, AnnotationIntrospector annotationIntrospector) {
        if (annotatedParameter == null || annotationIntrospector == null) {
            return null;
        }
        return annotationIntrospector.findNameForDeserialization(annotatedParameter);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public boolean _hasExplicitParamName(AnnotatedParameter annotatedParameter, AnnotationIntrospector annotationIntrospector) {
        boolean z = false;
        if (annotatedParameter == null || annotationIntrospector == null) {
            return false;
        }
        PropertyName findNameForDeserialization = annotationIntrospector.findNameForDeserialization(annotatedParameter);
        if (findNameForDeserialization != null && findNameForDeserialization.hasSimpleName()) {
            z = true;
        }
        return z;
    }

    public JsonDeserializer<?> createArrayDeserializer(DeserializationContext deserializationContext, ArrayType arrayType, BeanDescription beanDescription) throws JsonMappingException {
        DeserializationConfig config = deserializationContext.getConfig();
        JavaType contentType = arrayType.getContentType();
        JsonDeserializer jsonDeserializer = (JsonDeserializer) contentType.getValueHandler();
        TypeDeserializer typeDeserializer = (TypeDeserializer) contentType.getTypeHandler();
        if (typeDeserializer == null) {
            typeDeserializer = findTypeDeserializer(config, contentType);
        }
        TypeDeserializer typeDeserializer2 = typeDeserializer;
        JsonDeserializer<?> _findCustomArrayDeserializer = _findCustomArrayDeserializer(arrayType, config, beanDescription, typeDeserializer2, jsonDeserializer);
        if (_findCustomArrayDeserializer == null) {
            if (jsonDeserializer == null) {
                Class<String> rawClass = contentType.getRawClass();
                if (contentType.isPrimitive()) {
                    return PrimitiveArrayDeserializers.forType(rawClass);
                }
                if (rawClass == String.class) {
                    return StringArrayDeserializer.instance;
                }
            }
            _findCustomArrayDeserializer = new ObjectArrayDeserializer<>(arrayType, jsonDeserializer, typeDeserializer2);
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier modifyArrayDeserializer : this._factoryConfig.deserializerModifiers()) {
                _findCustomArrayDeserializer = modifyArrayDeserializer.modifyArrayDeserializer(config, arrayType, beanDescription, _findCustomArrayDeserializer);
            }
        }
        return _findCustomArrayDeserializer;
    }

    public JsonDeserializer<?> createCollectionDeserializer(DeserializationContext deserializationContext, CollectionType collectionType, BeanDescription beanDescription) throws JsonMappingException {
        JavaType contentType = collectionType.getContentType();
        JsonDeserializer jsonDeserializer = (JsonDeserializer) contentType.getValueHandler();
        DeserializationConfig config = deserializationContext.getConfig();
        TypeDeserializer typeDeserializer = (TypeDeserializer) contentType.getTypeHandler();
        if (typeDeserializer == null) {
            typeDeserializer = findTypeDeserializer(config, contentType);
        }
        TypeDeserializer typeDeserializer2 = typeDeserializer;
        JsonDeserializer<?> _findCustomCollectionDeserializer = _findCustomCollectionDeserializer(collectionType, config, beanDescription, typeDeserializer2, jsonDeserializer);
        if (_findCustomCollectionDeserializer == null) {
            Class rawClass = collectionType.getRawClass();
            if (jsonDeserializer == null && EnumSet.class.isAssignableFrom(rawClass)) {
                _findCustomCollectionDeserializer = new EnumSetDeserializer<>(contentType, null);
            }
        }
        if (_findCustomCollectionDeserializer == null) {
            if (collectionType.isInterface() || collectionType.isAbstract()) {
                CollectionType _mapAbstractCollectionType = _mapAbstractCollectionType(collectionType, config);
                if (_mapAbstractCollectionType != null) {
                    beanDescription = config.introspectForCreation(_mapAbstractCollectionType);
                    collectionType = _mapAbstractCollectionType;
                } else if (collectionType.getTypeHandler() != null) {
                    _findCustomCollectionDeserializer = AbstractDeserializer.constructForNonPOJO(beanDescription);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Can not find a deserializer for non-concrete Collection type ");
                    sb.append(collectionType);
                    throw new IllegalArgumentException(sb.toString());
                }
            }
            if (_findCustomCollectionDeserializer == null) {
                ValueInstantiator findValueInstantiator = findValueInstantiator(deserializationContext, beanDescription);
                if (!findValueInstantiator.canCreateUsingDefault() && collectionType.getRawClass() == ArrayBlockingQueue.class) {
                    return new ArrayBlockingQueueDeserializer(collectionType, jsonDeserializer, typeDeserializer2, findValueInstantiator);
                }
                if (contentType.getRawClass() == String.class) {
                    _findCustomCollectionDeserializer = new StringCollectionDeserializer<>(collectionType, jsonDeserializer, findValueInstantiator);
                } else {
                    _findCustomCollectionDeserializer = new CollectionDeserializer<>(collectionType, jsonDeserializer, typeDeserializer2, findValueInstantiator);
                }
            }
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier modifyCollectionDeserializer : this._factoryConfig.deserializerModifiers()) {
                _findCustomCollectionDeserializer = modifyCollectionDeserializer.modifyCollectionDeserializer(config, collectionType, beanDescription, _findCustomCollectionDeserializer);
            }
        }
        return _findCustomCollectionDeserializer;
    }

    /* access modifiers changed from: protected */
    public CollectionType _mapAbstractCollectionType(JavaType javaType, DeserializationConfig deserializationConfig) {
        Class cls = (Class) _collectionFallbacks.get(javaType.getRawClass().getName());
        if (cls == null) {
            return null;
        }
        return (CollectionType) deserializationConfig.constructSpecializedType(javaType, cls);
    }

    public JsonDeserializer<?> createCollectionLikeDeserializer(DeserializationContext deserializationContext, CollectionLikeType collectionLikeType, BeanDescription beanDescription) throws JsonMappingException {
        JavaType contentType = collectionLikeType.getContentType();
        JsonDeserializer jsonDeserializer = (JsonDeserializer) contentType.getValueHandler();
        DeserializationConfig config = deserializationContext.getConfig();
        TypeDeserializer typeDeserializer = (TypeDeserializer) contentType.getTypeHandler();
        JsonDeserializer<?> _findCustomCollectionLikeDeserializer = _findCustomCollectionLikeDeserializer(collectionLikeType, config, beanDescription, typeDeserializer == null ? findTypeDeserializer(config, contentType) : typeDeserializer, jsonDeserializer);
        if (_findCustomCollectionLikeDeserializer != null && this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier modifyCollectionLikeDeserializer : this._factoryConfig.deserializerModifiers()) {
                _findCustomCollectionLikeDeserializer = modifyCollectionLikeDeserializer.modifyCollectionLikeDeserializer(config, collectionLikeType, beanDescription, _findCustomCollectionLikeDeserializer);
            }
        }
        return _findCustomCollectionLikeDeserializer;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [com.fasterxml.jackson.databind.JsonDeserializer] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4, types: [com.fasterxml.jackson.databind.JsonDeserializer<?>] */
    /* JADX WARNING: type inference failed for: r0v5, types: [com.fasterxml.jackson.databind.JsonDeserializer] */
    /* JADX WARNING: type inference failed for: r0v6, types: [com.fasterxml.jackson.databind.JsonDeserializer] */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r11v0, types: [com.fasterxml.jackson.databind.deser.std.MapDeserializer] */
    /* JADX WARNING: type inference failed for: r0v13 */
    /* JADX WARNING: type inference failed for: r0v16, types: [com.fasterxml.jackson.databind.deser.AbstractDeserializer] */
    /* JADX WARNING: type inference failed for: r0v17 */
    /* JADX WARNING: type inference failed for: r0v21, types: [com.fasterxml.jackson.databind.deser.std.EnumMapDeserializer] */
    /* JADX WARNING: type inference failed for: r0v23 */
    /* JADX WARNING: type inference failed for: r0v24 */
    /* JADX WARNING: type inference failed for: r0v25 */
    /* JADX WARNING: type inference failed for: r0v26 */
    /* JADX WARNING: type inference failed for: r0v27 */
    /* JADX WARNING: type inference failed for: r0v28 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v7
      assigns: []
      uses: []
      mth insns count: 98
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e5  */
    /* JADX WARNING: Unknown variable types count: 5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.JsonDeserializer<?> createMapDeserializer(com.fasterxml.jackson.databind.DeserializationContext r18, com.fasterxml.jackson.databind.type.MapType r19, com.fasterxml.jackson.databind.BeanDescription r20) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            r17 = this;
            r7 = r17
            r8 = r19
            com.fasterxml.jackson.databind.DeserializationConfig r9 = r18.getConfig()
            com.fasterxml.jackson.databind.JavaType r10 = r19.getKeyType()
            com.fasterxml.jackson.databind.JavaType r0 = r19.getContentType()
            java.lang.Object r1 = r0.getValueHandler()
            r15 = r1
            com.fasterxml.jackson.databind.JsonDeserializer r15 = (com.fasterxml.jackson.databind.JsonDeserializer) r15
            java.lang.Object r1 = r10.getValueHandler()
            r14 = r1
            com.fasterxml.jackson.databind.KeyDeserializer r14 = (com.fasterxml.jackson.databind.KeyDeserializer) r14
            java.lang.Object r1 = r0.getTypeHandler()
            com.fasterxml.jackson.databind.jsontype.TypeDeserializer r1 = (com.fasterxml.jackson.databind.jsontype.TypeDeserializer) r1
            if (r1 != 0) goto L_0x002c
            com.fasterxml.jackson.databind.jsontype.TypeDeserializer r0 = r7.findTypeDeserializer(r9, r0)
            r13 = r0
            goto L_0x002d
        L_0x002c:
            r13 = r1
        L_0x002d:
            r0 = r17
            r1 = r19
            r2 = r9
            r3 = r20
            r4 = r14
            r5 = r13
            r6 = r15
            com.fasterxml.jackson.databind.JsonDeserializer r0 = r0._findCustomMapDeserializer(r1, r2, r3, r4, r5, r6)
            if (r0 != 0) goto L_0x00db
            java.lang.Class r1 = r19.getRawClass()
            java.lang.Class<java.util.EnumMap> r2 = java.util.EnumMap.class
            boolean r2 = r2.isAssignableFrom(r1)
            r3 = 0
            if (r2 == 0) goto L_0x0064
            java.lang.Class r0 = r10.getRawClass()
            if (r0 == 0) goto L_0x005c
            boolean r0 = r0.isEnum()
            if (r0 == 0) goto L_0x005c
            com.fasterxml.jackson.databind.deser.std.EnumMapDeserializer r0 = new com.fasterxml.jackson.databind.deser.std.EnumMapDeserializer
            r0.<init>(r8, r3, r15, r13)
            goto L_0x0064
        L_0x005c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Can not construct EnumMap; generic (key) type not available"
            r0.<init>(r1)
            throw r0
        L_0x0064:
            if (r0 != 0) goto L_0x00db
            boolean r2 = r19.isInterface()
            if (r2 != 0) goto L_0x0076
            boolean r2 = r19.isAbstract()
            if (r2 == 0) goto L_0x0073
            goto L_0x0076
        L_0x0073:
            r2 = r20
            goto L_0x009b
        L_0x0076:
            java.util.HashMap<java.lang.String, java.lang.Class<? extends java.util.Map>> r2 = _mapFallbacks
            java.lang.String r1 = r1.getName()
            java.lang.Object r1 = r2.get(r1)
            java.lang.Class r1 = (java.lang.Class) r1
            if (r1 == 0) goto L_0x0090
            com.fasterxml.jackson.databind.JavaType r1 = r9.constructSpecializedType(r8, r1)
            com.fasterxml.jackson.databind.type.MapType r1 = (com.fasterxml.jackson.databind.type.MapType) r1
            com.fasterxml.jackson.databind.BeanDescription r2 = r9.introspectForCreation(r1)
            r8 = r1
            goto L_0x009b
        L_0x0090:
            java.lang.Object r0 = r19.getTypeHandler()
            if (r0 == 0) goto L_0x00c4
            com.fasterxml.jackson.databind.deser.AbstractDeserializer r0 = com.fasterxml.jackson.databind.deser.AbstractDeserializer.constructForNonPOJO(r20)
            goto L_0x0073
        L_0x009b:
            if (r0 != 0) goto L_0x00dd
            r1 = r18
            com.fasterxml.jackson.databind.deser.ValueInstantiator r0 = r7.findValueInstantiator(r1, r2)
            com.fasterxml.jackson.databind.deser.std.MapDeserializer r1 = new com.fasterxml.jackson.databind.deser.std.MapDeserializer
            r11 = r1
            r12 = r8
            r4 = r13
            r13 = r0
            r16 = r4
            r11.<init>(r12, r13, r14, r15, r16)
            java.lang.Class<java.util.Map> r0 = java.util.Map.class
            com.fasterxml.jackson.databind.introspect.AnnotatedClass r4 = r2.getClassInfo()
            com.fasterxml.jackson.annotation.JsonIgnoreProperties$Value r0 = r9.getDefaultPropertyIgnorals(r0, r4)
            if (r0 != 0) goto L_0x00bb
            goto L_0x00bf
        L_0x00bb:
            java.util.Set r3 = r0.findIgnoredForDeserialization()
        L_0x00bf:
            r1.setIgnorableProperties(r3)
            r0 = r1
            goto L_0x00dd
        L_0x00c4:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Can not find a deserializer for non-concrete Map type "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00db:
            r2 = r20
        L_0x00dd:
            com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig r1 = r7._factoryConfig
            boolean r1 = r1.hasDeserializerModifiers()
            if (r1 == 0) goto L_0x0100
            com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig r1 = r7._factoryConfig
            java.lang.Iterable r1 = r1.deserializerModifiers()
            java.util.Iterator r1 = r1.iterator()
        L_0x00ef:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0100
            java.lang.Object r3 = r1.next()
            com.fasterxml.jackson.databind.deser.BeanDeserializerModifier r3 = (com.fasterxml.jackson.databind.deser.BeanDeserializerModifier) r3
            com.fasterxml.jackson.databind.JsonDeserializer r0 = r3.modifyMapDeserializer(r9, r8, r2, r0)
            goto L_0x00ef
        L_0x0100:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.BasicDeserializerFactory.createMapDeserializer(com.fasterxml.jackson.databind.DeserializationContext, com.fasterxml.jackson.databind.type.MapType, com.fasterxml.jackson.databind.BeanDescription):com.fasterxml.jackson.databind.JsonDeserializer");
    }

    public JsonDeserializer<?> createMapLikeDeserializer(DeserializationContext deserializationContext, MapLikeType mapLikeType, BeanDescription beanDescription) throws JsonMappingException {
        JavaType keyType = mapLikeType.getKeyType();
        JavaType contentType = mapLikeType.getContentType();
        DeserializationConfig config = deserializationContext.getConfig();
        JsonDeserializer jsonDeserializer = (JsonDeserializer) contentType.getValueHandler();
        KeyDeserializer keyDeserializer = (KeyDeserializer) keyType.getValueHandler();
        TypeDeserializer typeDeserializer = (TypeDeserializer) contentType.getTypeHandler();
        if (typeDeserializer == null) {
            typeDeserializer = findTypeDeserializer(config, contentType);
        }
        JsonDeserializer<?> _findCustomMapLikeDeserializer = _findCustomMapLikeDeserializer(mapLikeType, config, beanDescription, keyDeserializer, typeDeserializer, jsonDeserializer);
        if (_findCustomMapLikeDeserializer != null && this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier modifyMapLikeDeserializer : this._factoryConfig.deserializerModifiers()) {
                _findCustomMapLikeDeserializer = modifyMapLikeDeserializer.modifyMapLikeDeserializer(config, mapLikeType, beanDescription, _findCustomMapLikeDeserializer);
            }
        }
        return _findCustomMapLikeDeserializer;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0046, code lost:
        r2 = r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.JsonDeserializer<?> createEnumDeserializer(com.fasterxml.jackson.databind.DeserializationContext r9, com.fasterxml.jackson.databind.JavaType r10, com.fasterxml.jackson.databind.BeanDescription r11) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            r8 = this;
            com.fasterxml.jackson.databind.DeserializationConfig r0 = r9.getConfig()
            java.lang.Class r1 = r10.getRawClass()
            com.fasterxml.jackson.databind.JsonDeserializer r2 = r8._findCustomEnumDeserializer(r1, r0, r11)
            if (r2 != 0) goto L_0x0066
            com.fasterxml.jackson.databind.deser.ValueInstantiator r3 = r8._constructDefaultValueInstantiator(r9, r11)
            if (r3 != 0) goto L_0x0016
            r4 = 0
            goto L_0x001e
        L_0x0016:
            com.fasterxml.jackson.databind.DeserializationConfig r4 = r9.getConfig()
            com.fasterxml.jackson.databind.deser.SettableBeanProperty[] r4 = r3.getFromObjectArguments(r4)
        L_0x001e:
            java.util.List r5 = r11.getFactoryMethods()
            java.util.Iterator r5 = r5.iterator()
        L_0x0026:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0057
            java.lang.Object r6 = r5.next()
            com.fasterxml.jackson.databind.introspect.AnnotatedMethod r6 = (com.fasterxml.jackson.databind.introspect.AnnotatedMethod) r6
            com.fasterxml.jackson.databind.AnnotationIntrospector r7 = r9.getAnnotationIntrospector()
            boolean r7 = r7.hasCreatorAnnotation(r6)
            if (r7 == 0) goto L_0x0026
            int r7 = r6.getParameterCount()
            if (r7 != 0) goto L_0x0048
            com.fasterxml.jackson.databind.JsonDeserializer r9 = com.fasterxml.jackson.databind.deser.std.EnumDeserializer.deserializerForNoArgsCreator(r0, r1, r6)
        L_0x0046:
            r2 = r9
            goto L_0x0057
        L_0x0048:
            java.lang.Class r7 = r6.getRawReturnType()
            boolean r7 = r7.isAssignableFrom(r1)
            if (r7 == 0) goto L_0x0026
            com.fasterxml.jackson.databind.JsonDeserializer r9 = com.fasterxml.jackson.databind.deser.std.EnumDeserializer.deserializerForCreator(r0, r1, r6, r3, r4)
            goto L_0x0046
        L_0x0057:
            if (r2 != 0) goto L_0x0066
            com.fasterxml.jackson.databind.deser.std.EnumDeserializer r2 = new com.fasterxml.jackson.databind.deser.std.EnumDeserializer
            com.fasterxml.jackson.databind.introspect.AnnotatedMethod r9 = r11.findJsonValueMethod()
            com.fasterxml.jackson.databind.util.EnumResolver r9 = r8.constructEnumResolver(r1, r0, r9)
            r2.<init>(r9)
        L_0x0066:
            com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig r9 = r8._factoryConfig
            boolean r9 = r9.hasDeserializerModifiers()
            if (r9 == 0) goto L_0x0089
            com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig r9 = r8._factoryConfig
            java.lang.Iterable r9 = r9.deserializerModifiers()
            java.util.Iterator r9 = r9.iterator()
        L_0x0078:
            boolean r1 = r9.hasNext()
            if (r1 == 0) goto L_0x0089
            java.lang.Object r1 = r9.next()
            com.fasterxml.jackson.databind.deser.BeanDeserializerModifier r1 = (com.fasterxml.jackson.databind.deser.BeanDeserializerModifier) r1
            com.fasterxml.jackson.databind.JsonDeserializer r2 = r1.modifyEnumDeserializer(r0, r10, r11, r2)
            goto L_0x0078
        L_0x0089:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.BasicDeserializerFactory.createEnumDeserializer(com.fasterxml.jackson.databind.DeserializationContext, com.fasterxml.jackson.databind.JavaType, com.fasterxml.jackson.databind.BeanDescription):com.fasterxml.jackson.databind.JsonDeserializer");
    }

    public JsonDeserializer<?> createTreeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, BeanDescription beanDescription) throws JsonMappingException {
        Class rawClass = javaType.getRawClass();
        JsonDeserializer<?> _findCustomTreeNodeDeserializer = _findCustomTreeNodeDeserializer(rawClass, deserializationConfig, beanDescription);
        if (_findCustomTreeNodeDeserializer != null) {
            return _findCustomTreeNodeDeserializer;
        }
        return JsonNodeDeserializer.getDeserializer(rawClass);
    }

    public JsonDeserializer<?> createReferenceDeserializer(DeserializationContext deserializationContext, ReferenceType referenceType, BeanDescription beanDescription) throws JsonMappingException {
        JavaType contentType = referenceType.getContentType();
        JsonDeserializer jsonDeserializer = (JsonDeserializer) contentType.getValueHandler();
        DeserializationConfig config = deserializationContext.getConfig();
        TypeDeserializer typeDeserializer = (TypeDeserializer) contentType.getTypeHandler();
        TypeDeserializer findTypeDeserializer = typeDeserializer == null ? findTypeDeserializer(config, contentType) : typeDeserializer;
        JsonDeserializer<?> _findCustomReferenceDeserializer = _findCustomReferenceDeserializer(referenceType, config, beanDescription, findTypeDeserializer, jsonDeserializer);
        if (_findCustomReferenceDeserializer == null && AtomicReference.class.isAssignableFrom(referenceType.getRawClass())) {
            return new AtomicReferenceDeserializer(referenceType, findTypeDeserializer, jsonDeserializer);
        }
        if (_findCustomReferenceDeserializer != null && this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier modifyReferenceDeserializer : this._factoryConfig.deserializerModifiers()) {
                _findCustomReferenceDeserializer = modifyReferenceDeserializer.modifyReferenceDeserializer(config, referenceType, beanDescription, _findCustomReferenceDeserializer);
            }
        }
        return _findCustomReferenceDeserializer;
    }

    public TypeDeserializer findTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType) throws JsonMappingException {
        AnnotatedClass classInfo = deserializationConfig.introspectClassAnnotations(javaType.getRawClass()).getClassInfo();
        TypeResolverBuilder findTypeResolver = deserializationConfig.getAnnotationIntrospector().findTypeResolver(deserializationConfig, classInfo, javaType);
        Collection collection = null;
        if (findTypeResolver == null) {
            findTypeResolver = deserializationConfig.getDefaultTyper(javaType);
            if (findTypeResolver == null) {
                return null;
            }
        } else {
            collection = deserializationConfig.getSubtypeResolver().collectAndResolveSubtypesByTypeId(deserializationConfig, classInfo);
        }
        if (findTypeResolver.getDefaultImpl() == null && javaType.isAbstract()) {
            JavaType mapAbstractType = mapAbstractType(deserializationConfig, javaType);
            if (!(mapAbstractType == null || mapAbstractType.getRawClass() == javaType.getRawClass())) {
                findTypeResolver = findTypeResolver.defaultImpl(mapAbstractType.getRawClass());
            }
        }
        return findTypeResolver.buildTypeDeserializer(deserializationConfig, javaType, collection);
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<?> findOptionalStdDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) throws JsonMappingException {
        return OptionalHandlerFactory.instance.findDeserializer(javaType, deserializationContext.getConfig(), beanDescription);
    }

    public KeyDeserializer createKeyDeserializer(DeserializationContext deserializationContext, JavaType javaType) throws JsonMappingException {
        DeserializationConfig config = deserializationContext.getConfig();
        KeyDeserializer keyDeserializer = null;
        if (this._factoryConfig.hasKeyDeserializers()) {
            BeanDescription introspectClassAnnotations = config.introspectClassAnnotations(javaType.getRawClass());
            for (KeyDeserializers findKeyDeserializer : this._factoryConfig.keyDeserializers()) {
                keyDeserializer = findKeyDeserializer.findKeyDeserializer(javaType, config, introspectClassAnnotations);
                if (keyDeserializer != null) {
                    break;
                }
            }
        }
        if (keyDeserializer == null) {
            if (javaType.isEnumType()) {
                keyDeserializer = _createEnumKeyDeserializer(deserializationContext, javaType);
            } else {
                keyDeserializer = StdKeyDeserializers.findStringBasedKeyDeserializer(config, javaType);
            }
        }
        if (keyDeserializer != null && this._factoryConfig.hasDeserializerModifiers()) {
            for (BeanDeserializerModifier modifyKeyDeserializer : this._factoryConfig.deserializerModifiers()) {
                keyDeserializer = modifyKeyDeserializer.modifyKeyDeserializer(config, javaType, keyDeserializer);
            }
        }
        return keyDeserializer;
    }

    private KeyDeserializer _createEnumKeyDeserializer(DeserializationContext deserializationContext, JavaType javaType) throws JsonMappingException {
        DeserializationConfig config = deserializationContext.getConfig();
        Class rawClass = javaType.getRawClass();
        BeanDescription introspect = config.introspect(javaType);
        KeyDeserializer findKeyDeserializerFromAnnotation = findKeyDeserializerFromAnnotation(deserializationContext, introspect.getClassInfo());
        if (findKeyDeserializerFromAnnotation != null) {
            return findKeyDeserializerFromAnnotation;
        }
        JsonDeserializer _findCustomEnumDeserializer = _findCustomEnumDeserializer(rawClass, config, introspect);
        if (_findCustomEnumDeserializer != null) {
            return StdKeyDeserializers.constructDelegatingKeyDeserializer(config, javaType, _findCustomEnumDeserializer);
        }
        JsonDeserializer findDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationContext, introspect.getClassInfo());
        if (findDeserializerFromAnnotation != null) {
            return StdKeyDeserializers.constructDelegatingKeyDeserializer(config, javaType, findDeserializerFromAnnotation);
        }
        EnumResolver constructEnumResolver = constructEnumResolver(rawClass, config, introspect.findJsonValueMethod());
        AnnotationIntrospector annotationIntrospector = config.getAnnotationIntrospector();
        for (AnnotatedMethod annotatedMethod : introspect.getFactoryMethods()) {
            if (annotationIntrospector.hasCreatorAnnotation(annotatedMethod)) {
                if (annotatedMethod.getParameterCount() != 1 || !annotatedMethod.getRawReturnType().isAssignableFrom(rawClass)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unsuitable method (");
                    sb.append(annotatedMethod);
                    sb.append(") decorated with @JsonCreator (for Enum type ");
                    sb.append(rawClass.getName());
                    sb.append(")");
                    throw new IllegalArgumentException(sb.toString());
                } else if (annotatedMethod.getRawParameterType(0) == String.class) {
                    if (config.canOverrideAccessModifiers()) {
                        ClassUtil.checkAndFixAccess(annotatedMethod.getMember(), deserializationContext.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                    }
                    return StdKeyDeserializers.constructEnumKeyDeserializer(constructEnumResolver, annotatedMethod);
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Parameter #0 type for factory method (");
                    sb2.append(annotatedMethod);
                    sb2.append(") not suitable, must be java.lang.String");
                    throw new IllegalArgumentException(sb2.toString());
                }
            }
        }
        return StdKeyDeserializers.constructEnumKeyDeserializer(constructEnumResolver);
    }

    public TypeDeserializer findPropertyTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, AnnotatedMember annotatedMember) throws JsonMappingException {
        TypeResolverBuilder findPropertyTypeResolver = deserializationConfig.getAnnotationIntrospector().findPropertyTypeResolver(deserializationConfig, annotatedMember, javaType);
        if (findPropertyTypeResolver == null) {
            return findTypeDeserializer(deserializationConfig, javaType);
        }
        return findPropertyTypeResolver.buildTypeDeserializer(deserializationConfig, javaType, deserializationConfig.getSubtypeResolver().collectAndResolveSubtypesByTypeId(deserializationConfig, annotatedMember, javaType));
    }

    public TypeDeserializer findPropertyContentTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, AnnotatedMember annotatedMember) throws JsonMappingException {
        TypeResolverBuilder findPropertyContentTypeResolver = deserializationConfig.getAnnotationIntrospector().findPropertyContentTypeResolver(deserializationConfig, annotatedMember, javaType);
        JavaType contentType = javaType.getContentType();
        if (findPropertyContentTypeResolver == null) {
            return findTypeDeserializer(deserializationConfig, contentType);
        }
        return findPropertyContentTypeResolver.buildTypeDeserializer(deserializationConfig, contentType, deserializationConfig.getSubtypeResolver().collectAndResolveSubtypesByTypeId(deserializationConfig, annotatedMember, contentType));
    }

    public JsonDeserializer<?> findDefaultDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) throws JsonMappingException {
        JavaType javaType2;
        JavaType javaType3;
        Class<TokenBuffer> rawClass = javaType.getRawClass();
        if (rawClass == CLASS_OBJECT) {
            DeserializationConfig config = deserializationContext.getConfig();
            if (this._factoryConfig.hasAbstractTypeResolvers()) {
                javaType2 = _findRemappedType(config, List.class);
                javaType3 = _findRemappedType(config, Map.class);
            } else {
                javaType2 = null;
                javaType3 = null;
            }
            return new UntypedObjectDeserializer(javaType2, javaType3);
        } else if (rawClass == CLASS_STRING || rawClass == CLASS_CHAR_BUFFER) {
            return StringDeserializer.instance;
        } else {
            if (rawClass == CLASS_ITERABLE) {
                TypeFactory typeFactory = deserializationContext.getTypeFactory();
                JavaType[] findTypeParameters = typeFactory.findTypeParameters(javaType, CLASS_ITERABLE);
                return createCollectionDeserializer(deserializationContext, typeFactory.constructCollectionType(Collection.class, (findTypeParameters == null || findTypeParameters.length != 1) ? TypeFactory.unknownType() : findTypeParameters[0]), beanDescription);
            } else if (rawClass == CLASS_MAP_ENTRY) {
                JavaType containedType = javaType.containedType(0);
                if (containedType == null) {
                    containedType = TypeFactory.unknownType();
                }
                JavaType containedType2 = javaType.containedType(1);
                if (containedType2 == null) {
                    containedType2 = TypeFactory.unknownType();
                }
                TypeDeserializer typeDeserializer = (TypeDeserializer) containedType2.getTypeHandler();
                if (typeDeserializer == null) {
                    typeDeserializer = findTypeDeserializer(deserializationContext.getConfig(), containedType2);
                }
                return new MapEntryDeserializer(javaType, (KeyDeserializer) containedType.getValueHandler(), (JsonDeserializer) containedType2.getValueHandler(), typeDeserializer);
            } else {
                String name = rawClass.getName();
                if (rawClass.isPrimitive() || name.startsWith("java.")) {
                    JsonDeserializer<?> find = NumberDeserializers.find(rawClass, name);
                    if (find == null) {
                        find = DateDeserializers.find(rawClass, name);
                    }
                    if (find != null) {
                        return find;
                    }
                }
                if (rawClass == TokenBuffer.class) {
                    return new TokenBufferDeserializer();
                }
                JsonDeserializer<?> findOptionalStdDeserializer = findOptionalStdDeserializer(deserializationContext, javaType, beanDescription);
                if (findOptionalStdDeserializer != null) {
                    return findOptionalStdDeserializer;
                }
                return JdkDeserializers.find(rawClass, name);
            }
        }
    }

    /* access modifiers changed from: protected */
    public JavaType _findRemappedType(DeserializationConfig deserializationConfig, Class<?> cls) throws JsonMappingException {
        JavaType mapAbstractType = mapAbstractType(deserializationConfig, deserializationConfig.constructType(cls));
        if (mapAbstractType == null || mapAbstractType.hasRawClass(cls)) {
            return null;
        }
        return mapAbstractType;
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<?> _findCustomTreeNodeDeserializer(Class<? extends JsonNode> cls, DeserializationConfig deserializationConfig, BeanDescription beanDescription) throws JsonMappingException {
        for (Deserializers findTreeNodeDeserializer : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> findTreeNodeDeserializer2 = findTreeNodeDeserializer.findTreeNodeDeserializer(cls, deserializationConfig, beanDescription);
            if (findTreeNodeDeserializer2 != null) {
                return findTreeNodeDeserializer2;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<?> _findCustomReferenceDeserializer(ReferenceType referenceType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) throws JsonMappingException {
        for (Deserializers findReferenceDeserializer : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> findReferenceDeserializer2 = findReferenceDeserializer.findReferenceDeserializer(referenceType, deserializationConfig, beanDescription, typeDeserializer, jsonDeserializer);
            if (findReferenceDeserializer2 != null) {
                return findReferenceDeserializer2;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<Object> _findCustomBeanDeserializer(JavaType javaType, DeserializationConfig deserializationConfig, BeanDescription beanDescription) throws JsonMappingException {
        for (Deserializers findBeanDeserializer : this._factoryConfig.deserializers()) {
            JsonDeserializer<Object> findBeanDeserializer2 = findBeanDeserializer.findBeanDeserializer(javaType, deserializationConfig, beanDescription);
            if (findBeanDeserializer2 != null) {
                return findBeanDeserializer2;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<?> _findCustomArrayDeserializer(ArrayType arrayType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) throws JsonMappingException {
        for (Deserializers findArrayDeserializer : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> findArrayDeserializer2 = findArrayDeserializer.findArrayDeserializer(arrayType, deserializationConfig, beanDescription, typeDeserializer, jsonDeserializer);
            if (findArrayDeserializer2 != null) {
                return findArrayDeserializer2;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<?> _findCustomCollectionDeserializer(CollectionType collectionType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) throws JsonMappingException {
        for (Deserializers findCollectionDeserializer : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> findCollectionDeserializer2 = findCollectionDeserializer.findCollectionDeserializer(collectionType, deserializationConfig, beanDescription, typeDeserializer, jsonDeserializer);
            if (findCollectionDeserializer2 != null) {
                return findCollectionDeserializer2;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<?> _findCustomCollectionLikeDeserializer(CollectionLikeType collectionLikeType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) throws JsonMappingException {
        for (Deserializers findCollectionLikeDeserializer : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> findCollectionLikeDeserializer2 = findCollectionLikeDeserializer.findCollectionLikeDeserializer(collectionLikeType, deserializationConfig, beanDescription, typeDeserializer, jsonDeserializer);
            if (findCollectionLikeDeserializer2 != null) {
                return findCollectionLikeDeserializer2;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<?> _findCustomEnumDeserializer(Class<?> cls, DeserializationConfig deserializationConfig, BeanDescription beanDescription) throws JsonMappingException {
        for (Deserializers findEnumDeserializer : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> findEnumDeserializer2 = findEnumDeserializer.findEnumDeserializer(cls, deserializationConfig, beanDescription);
            if (findEnumDeserializer2 != null) {
                return findEnumDeserializer2;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<?> _findCustomMapDeserializer(MapType mapType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) throws JsonMappingException {
        for (Deserializers findMapDeserializer : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> findMapDeserializer2 = findMapDeserializer.findMapDeserializer(mapType, deserializationConfig, beanDescription, keyDeserializer, typeDeserializer, jsonDeserializer);
            if (findMapDeserializer2 != null) {
                return findMapDeserializer2;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<?> _findCustomMapLikeDeserializer(MapLikeType mapLikeType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) throws JsonMappingException {
        for (Deserializers findMapLikeDeserializer : this._factoryConfig.deserializers()) {
            JsonDeserializer<?> findMapLikeDeserializer2 = findMapLikeDeserializer.findMapLikeDeserializer(mapLikeType, deserializationConfig, beanDescription, keyDeserializer, typeDeserializer, jsonDeserializer);
            if (findMapLikeDeserializer2 != null) {
                return findMapLikeDeserializer2;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<Object> findDeserializerFromAnnotation(DeserializationContext deserializationContext, Annotated annotated) throws JsonMappingException {
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        if (annotationIntrospector != null) {
            Object findDeserializer = annotationIntrospector.findDeserializer(annotated);
            if (findDeserializer != null) {
                return deserializationContext.deserializerInstance(annotated, findDeserializer);
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public KeyDeserializer findKeyDeserializerFromAnnotation(DeserializationContext deserializationContext, Annotated annotated) throws JsonMappingException {
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        if (annotationIntrospector != null) {
            Object findKeyDeserializer = annotationIntrospector.findKeyDeserializer(annotated);
            if (findKeyDeserializer != null) {
                return deserializationContext.keyDeserializerInstance(annotated, findKeyDeserializer);
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JavaType resolveMemberAndTypeAnnotations(DeserializationContext deserializationContext, AnnotatedMember annotatedMember, JavaType javaType) throws JsonMappingException {
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        if (annotationIntrospector == null) {
            return javaType;
        }
        if (javaType.isMapLikeType() && javaType.getKeyType() != null) {
            KeyDeserializer keyDeserializerInstance = deserializationContext.keyDeserializerInstance(annotatedMember, annotationIntrospector.findKeyDeserializer(annotatedMember));
            if (keyDeserializerInstance != null) {
                javaType = ((MapLikeType) javaType).withKeyValueHandler(keyDeserializerInstance);
                javaType.getKeyType();
            }
        }
        if (javaType.hasContentType()) {
            JsonDeserializer deserializerInstance = deserializationContext.deserializerInstance(annotatedMember, annotationIntrospector.findContentDeserializer(annotatedMember));
            if (deserializerInstance != null) {
                javaType = javaType.withContentValueHandler(deserializerInstance);
            }
            TypeDeserializer findPropertyContentTypeDeserializer = findPropertyContentTypeDeserializer(deserializationContext.getConfig(), javaType, annotatedMember);
            if (findPropertyContentTypeDeserializer != null) {
                javaType = javaType.withContentTypeHandler(findPropertyContentTypeDeserializer);
            }
        }
        TypeDeserializer findPropertyTypeDeserializer = findPropertyTypeDeserializer(deserializationContext.getConfig(), javaType, annotatedMember);
        if (findPropertyTypeDeserializer != null) {
            javaType = javaType.withTypeHandler(findPropertyTypeDeserializer);
        }
        return annotationIntrospector.refineDeserializationType(deserializationContext.getConfig(), annotatedMember, javaType);
    }

    /* access modifiers changed from: protected */
    public EnumResolver constructEnumResolver(Class<?> cls, DeserializationConfig deserializationConfig, AnnotatedMethod annotatedMethod) {
        if (annotatedMethod == null) {
            return EnumResolver.constructUnsafe(cls, deserializationConfig.getAnnotationIntrospector());
        }
        Method annotated = annotatedMethod.getAnnotated();
        if (deserializationConfig.canOverrideAccessModifiers()) {
            ClassUtil.checkAndFixAccess(annotated, deserializationConfig.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        return EnumResolver.constructUnsafeUsingMethod(cls, annotated, deserializationConfig.getAnnotationIntrospector());
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public JavaType modifyTypeByAnnotation(DeserializationContext deserializationContext, Annotated annotated, JavaType javaType) throws JsonMappingException {
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        return annotationIntrospector == null ? javaType : annotationIntrospector.refineDeserializationType(deserializationContext.getConfig(), annotated, javaType);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public JavaType resolveType(DeserializationContext deserializationContext, BeanDescription beanDescription, JavaType javaType, AnnotatedMember annotatedMember) throws JsonMappingException {
        return resolveMemberAndTypeAnnotations(deserializationContext, annotatedMember, javaType);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public AnnotatedMethod _findJsonValueFor(DeserializationConfig deserializationConfig, JavaType javaType) {
        if (javaType == null) {
            return null;
        }
        return deserializationConfig.introspect(javaType).findJsonValueMethod();
    }
}

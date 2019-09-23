package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder.Value;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdValueProperty;
import com.fasterxml.jackson.databind.deser.impl.ValueInjector;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.Annotations;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BeanDeserializerBuilder {
    protected SettableAnyProperty _anySetter;
    protected HashMap<String, SettableBeanProperty> _backRefProperties;
    protected final BeanDescription _beanDesc;
    protected AnnotatedMethod _buildMethod;
    protected Value _builderConfig;
    protected final DeserializationConfig _config;
    protected HashSet<String> _ignorableProps;
    protected boolean _ignoreAllUnknown;
    protected List<ValueInjector> _injectables;
    protected ObjectIdReader _objectIdReader;
    protected final Map<String, SettableBeanProperty> _properties = new LinkedHashMap();
    protected ValueInstantiator _valueInstantiator;

    public BeanDeserializerBuilder(BeanDescription beanDescription, DeserializationConfig deserializationConfig) {
        this._beanDesc = beanDescription;
        this._config = deserializationConfig;
    }

    protected BeanDeserializerBuilder(BeanDeserializerBuilder beanDeserializerBuilder) {
        this._beanDesc = beanDeserializerBuilder._beanDesc;
        this._config = beanDeserializerBuilder._config;
        this._properties.putAll(beanDeserializerBuilder._properties);
        this._injectables = _copy(beanDeserializerBuilder._injectables);
        this._backRefProperties = _copy(beanDeserializerBuilder._backRefProperties);
        this._ignorableProps = beanDeserializerBuilder._ignorableProps;
        this._valueInstantiator = beanDeserializerBuilder._valueInstantiator;
        this._objectIdReader = beanDeserializerBuilder._objectIdReader;
        this._anySetter = beanDeserializerBuilder._anySetter;
        this._ignoreAllUnknown = beanDeserializerBuilder._ignoreAllUnknown;
        this._buildMethod = beanDeserializerBuilder._buildMethod;
        this._builderConfig = beanDeserializerBuilder._builderConfig;
    }

    private static HashMap<String, SettableBeanProperty> _copy(HashMap<String, SettableBeanProperty> hashMap) {
        if (hashMap == null) {
            return null;
        }
        return new HashMap(hashMap);
    }

    private static <T> List<T> _copy(List<T> list) {
        if (list == null) {
            return null;
        }
        return new ArrayList(list);
    }

    public void addOrReplaceProperty(SettableBeanProperty settableBeanProperty, boolean z) {
        this._properties.put(settableBeanProperty.getName(), settableBeanProperty);
    }

    public void addProperty(SettableBeanProperty settableBeanProperty) {
        SettableBeanProperty settableBeanProperty2 = (SettableBeanProperty) this._properties.put(settableBeanProperty.getName(), settableBeanProperty);
        if (settableBeanProperty2 != null && settableBeanProperty2 != settableBeanProperty) {
            StringBuilder sb = new StringBuilder();
            sb.append("Duplicate property '");
            sb.append(settableBeanProperty.getName());
            sb.append("' for ");
            sb.append(this._beanDesc.getType());
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public void addBackReferenceProperty(String str, SettableBeanProperty settableBeanProperty) {
        if (this._backRefProperties == null) {
            this._backRefProperties = new HashMap<>(4);
        }
        settableBeanProperty.fixAccess(this._config);
        this._backRefProperties.put(str, settableBeanProperty);
        if (this._properties != null) {
            this._properties.remove(settableBeanProperty.getName());
        }
    }

    public void addInjectable(PropertyName propertyName, JavaType javaType, Annotations annotations, AnnotatedMember annotatedMember, Object obj) {
        if (this._injectables == null) {
            this._injectables = new ArrayList();
        }
        boolean canOverrideAccessModifiers = this._config.canOverrideAccessModifiers();
        boolean z = canOverrideAccessModifiers && this._config.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS);
        if (canOverrideAccessModifiers) {
            annotatedMember.fixAccess(z);
        }
        List<ValueInjector> list = this._injectables;
        ValueInjector valueInjector = new ValueInjector(propertyName, javaType, annotations, annotatedMember, obj);
        list.add(valueInjector);
    }

    public void addIgnorable(String str) {
        if (this._ignorableProps == null) {
            this._ignorableProps = new HashSet<>();
        }
        this._ignorableProps.add(str);
    }

    public void addCreatorProperty(SettableBeanProperty settableBeanProperty) {
        addProperty(settableBeanProperty);
    }

    public void setAnySetter(SettableAnyProperty settableAnyProperty) {
        if (this._anySetter == null || settableAnyProperty == null) {
            this._anySetter = settableAnyProperty;
            return;
        }
        throw new IllegalStateException("_anySetter already set to non-null");
    }

    public void setIgnoreUnknownProperties(boolean z) {
        this._ignoreAllUnknown = z;
    }

    public void setValueInstantiator(ValueInstantiator valueInstantiator) {
        this._valueInstantiator = valueInstantiator;
    }

    public void setObjectIdReader(ObjectIdReader objectIdReader) {
        this._objectIdReader = objectIdReader;
    }

    public void setPOJOBuilder(AnnotatedMethod annotatedMethod, Value value) {
        this._buildMethod = annotatedMethod;
        this._builderConfig = value;
    }

    public Iterator<SettableBeanProperty> getProperties() {
        return this._properties.values().iterator();
    }

    public SettableBeanProperty findProperty(PropertyName propertyName) {
        return (SettableBeanProperty) this._properties.get(propertyName.getSimpleName());
    }

    public boolean hasProperty(PropertyName propertyName) {
        return findProperty(propertyName) != null;
    }

    public SettableBeanProperty removeProperty(PropertyName propertyName) {
        return (SettableBeanProperty) this._properties.remove(propertyName.getSimpleName());
    }

    public SettableAnyProperty getAnySetter() {
        return this._anySetter;
    }

    public ValueInstantiator getValueInstantiator() {
        return this._valueInstantiator;
    }

    public List<ValueInjector> getInjectables() {
        return this._injectables;
    }

    public ObjectIdReader getObjectIdReader() {
        return this._objectIdReader;
    }

    public AnnotatedMethod getBuildMethod() {
        return this._buildMethod;
    }

    public Value getBuilderConfig() {
        return this._builderConfig;
    }

    public JsonDeserializer<?> build() {
        boolean z;
        Collection values = this._properties.values();
        _fixAccess(values);
        BeanPropertyMap construct = BeanPropertyMap.construct(values, this._config.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES));
        construct.assignIndexes();
        boolean z2 = !this._config.isEnabled(MapperFeature.DEFAULT_VIEW_INCLUSION);
        if (!z2) {
            Iterator it = values.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((SettableBeanProperty) it.next()).hasViews()) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z = z2;
        if (this._objectIdReader != null) {
            construct = construct.withProperty(new ObjectIdValueProperty(this._objectIdReader, PropertyMetadata.STD_REQUIRED));
        }
        BeanDeserializer beanDeserializer = new BeanDeserializer(this, this._beanDesc, construct, this._backRefProperties, this._ignorableProps, this._ignoreAllUnknown, z);
        return beanDeserializer;
    }

    public AbstractDeserializer buildAbstract() {
        return new AbstractDeserializer(this, this._beanDesc, this._backRefProperties);
    }

    public JsonDeserializer<?> buildBuilderBased(JavaType javaType, String str) {
        boolean z;
        if (this._buildMethod != null) {
            Class rawReturnType = this._buildMethod.getRawReturnType();
            Class rawClass = javaType.getRawClass();
            if (rawReturnType != rawClass && !rawReturnType.isAssignableFrom(rawClass) && !rawClass.isAssignableFrom(rawReturnType)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Build method '");
                sb.append(this._buildMethod.getFullName());
                sb.append(" has bad return type (");
                sb.append(rawReturnType.getName());
                sb.append("), not compatible with POJO type (");
                sb.append(javaType.getRawClass().getName());
                sb.append(")");
                throw new IllegalArgumentException(sb.toString());
            }
        } else if (!str.isEmpty()) {
            throw new IllegalArgumentException(String.format("Builder class %s does not have build method (name: '%s')", new Object[]{this._beanDesc.getBeanClass().getName(), str}));
        }
        Collection values = this._properties.values();
        _fixAccess(values);
        BeanPropertyMap construct = BeanPropertyMap.construct(values, this._config.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES));
        construct.assignIndexes();
        boolean z2 = !this._config.isEnabled(MapperFeature.DEFAULT_VIEW_INCLUSION);
        if (!z2) {
            Iterator it = values.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((SettableBeanProperty) it.next()).hasViews()) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z = z2;
        if (this._objectIdReader != null) {
            construct = construct.withProperty(new ObjectIdValueProperty(this._objectIdReader, PropertyMetadata.STD_REQUIRED));
        }
        BuilderBasedDeserializer builderBasedDeserializer = new BuilderBasedDeserializer(this, this._beanDesc, construct, this._backRefProperties, this._ignorableProps, this._ignoreAllUnknown, z);
        return builderBasedDeserializer;
    }

    private void _fixAccess(Collection<SettableBeanProperty> collection) {
        for (SettableBeanProperty fixAccess : collection) {
            fixAccess.fixAccess(this._config);
        }
        if (this._anySetter != null) {
            this._anySetter.fixAccess(this._config);
        }
        if (this._buildMethod != null) {
            this._buildMethod.fixAccess(this._config.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
    }
}

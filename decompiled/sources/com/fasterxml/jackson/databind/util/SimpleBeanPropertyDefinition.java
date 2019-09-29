package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude.Value;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import java.util.Collections;
import java.util.Iterator;

public class SimpleBeanPropertyDefinition extends BeanPropertyDefinition {
    protected final PropertyName _fullName;
    protected final Value _inclusion;
    protected final AnnotationIntrospector _introspector;
    protected final AnnotatedMember _member;
    protected final PropertyMetadata _metadata;
    @Deprecated
    protected final String _name;

    public boolean isExplicitlyIncluded() {
        return false;
    }

    public boolean isExplicitlyNamed() {
        return false;
    }

    protected SimpleBeanPropertyDefinition(AnnotatedMember annotatedMember, PropertyName propertyName, AnnotationIntrospector annotationIntrospector, PropertyMetadata propertyMetadata, Include include) {
        this(annotatedMember, propertyName, annotationIntrospector, propertyMetadata, (include == null || include == Include.USE_DEFAULTS) ? EMPTY_INCLUDE : Value.construct(include, null));
    }

    protected SimpleBeanPropertyDefinition(AnnotatedMember annotatedMember, PropertyName propertyName, AnnotationIntrospector annotationIntrospector, PropertyMetadata propertyMetadata, Value value) {
        this._introspector = annotationIntrospector;
        this._member = annotatedMember;
        this._fullName = propertyName;
        this._name = propertyName.getSimpleName();
        if (propertyMetadata == null) {
            propertyMetadata = PropertyMetadata.STD_OPTIONAL;
        }
        this._metadata = propertyMetadata;
        this._inclusion = value;
    }

    @Deprecated
    protected SimpleBeanPropertyDefinition(AnnotatedMember annotatedMember, String str, AnnotationIntrospector annotationIntrospector) {
        this(annotatedMember, new PropertyName(str), annotationIntrospector, (PropertyMetadata) null, EMPTY_INCLUDE);
    }

    public static SimpleBeanPropertyDefinition construct(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember) {
        SimpleBeanPropertyDefinition simpleBeanPropertyDefinition = new SimpleBeanPropertyDefinition(annotatedMember, PropertyName.construct(annotatedMember.getName()), mapperConfig == null ? null : mapperConfig.getAnnotationIntrospector(), (PropertyMetadata) null, EMPTY_INCLUDE);
        return simpleBeanPropertyDefinition;
    }

    @Deprecated
    public static SimpleBeanPropertyDefinition construct(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, String str) {
        SimpleBeanPropertyDefinition simpleBeanPropertyDefinition = new SimpleBeanPropertyDefinition(annotatedMember, PropertyName.construct(str), mapperConfig == null ? null : mapperConfig.getAnnotationIntrospector(), (PropertyMetadata) null, EMPTY_INCLUDE);
        return simpleBeanPropertyDefinition;
    }

    public static SimpleBeanPropertyDefinition construct(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, PropertyName propertyName) {
        return construct(mapperConfig, annotatedMember, propertyName, (PropertyMetadata) null, EMPTY_INCLUDE);
    }

    public static SimpleBeanPropertyDefinition construct(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, PropertyName propertyName, PropertyMetadata propertyMetadata, Include include) {
        SimpleBeanPropertyDefinition simpleBeanPropertyDefinition = new SimpleBeanPropertyDefinition(annotatedMember, propertyName, mapperConfig == null ? null : mapperConfig.getAnnotationIntrospector(), propertyMetadata, include);
        return simpleBeanPropertyDefinition;
    }

    public static SimpleBeanPropertyDefinition construct(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, PropertyName propertyName, PropertyMetadata propertyMetadata, Value value) {
        SimpleBeanPropertyDefinition simpleBeanPropertyDefinition = new SimpleBeanPropertyDefinition(annotatedMember, propertyName, mapperConfig == null ? null : mapperConfig.getAnnotationIntrospector(), propertyMetadata, value);
        return simpleBeanPropertyDefinition;
    }

    @Deprecated
    public BeanPropertyDefinition withName(String str) {
        return withSimpleName(str);
    }

    public BeanPropertyDefinition withSimpleName(String str) {
        if (this._fullName.hasSimpleName(str) && !this._fullName.hasNamespace()) {
            return this;
        }
        SimpleBeanPropertyDefinition simpleBeanPropertyDefinition = new SimpleBeanPropertyDefinition(this._member, new PropertyName(str), this._introspector, this._metadata, this._inclusion);
        return simpleBeanPropertyDefinition;
    }

    public BeanPropertyDefinition withName(PropertyName propertyName) {
        if (this._fullName.equals(propertyName)) {
            return this;
        }
        SimpleBeanPropertyDefinition simpleBeanPropertyDefinition = new SimpleBeanPropertyDefinition(this._member, propertyName, this._introspector, this._metadata, this._inclusion);
        return simpleBeanPropertyDefinition;
    }

    public BeanPropertyDefinition withMetadata(PropertyMetadata propertyMetadata) {
        if (propertyMetadata.equals(this._metadata)) {
            return this;
        }
        SimpleBeanPropertyDefinition simpleBeanPropertyDefinition = new SimpleBeanPropertyDefinition(this._member, this._fullName, this._introspector, propertyMetadata, this._inclusion);
        return simpleBeanPropertyDefinition;
    }

    public BeanPropertyDefinition withInclusion(Value value) {
        if (this._inclusion == value) {
            return this;
        }
        SimpleBeanPropertyDefinition simpleBeanPropertyDefinition = new SimpleBeanPropertyDefinition(this._member, this._fullName, this._introspector, this._metadata, value);
        return simpleBeanPropertyDefinition;
    }

    public String getName() {
        return this._fullName.getSimpleName();
    }

    public PropertyName getFullName() {
        return this._fullName;
    }

    public boolean hasName(PropertyName propertyName) {
        return this._fullName.equals(propertyName);
    }

    public String getInternalName() {
        return getName();
    }

    public PropertyName getWrapperName() {
        if (this._introspector != null || this._member == null) {
            return this._introspector.findWrapperName(this._member);
        }
        return null;
    }

    public PropertyMetadata getMetadata() {
        return this._metadata;
    }

    public Value findInclusion() {
        return this._inclusion;
    }

    public boolean hasGetter() {
        return getGetter() != null;
    }

    public boolean hasSetter() {
        return getSetter() != null;
    }

    public boolean hasField() {
        return this._member instanceof AnnotatedField;
    }

    public boolean hasConstructorParameter() {
        return this._member instanceof AnnotatedParameter;
    }

    public AnnotatedMethod getGetter() {
        if (!(this._member instanceof AnnotatedMethod) || ((AnnotatedMethod) this._member).getParameterCount() != 0) {
            return null;
        }
        return (AnnotatedMethod) this._member;
    }

    public AnnotatedMethod getSetter() {
        if (!(this._member instanceof AnnotatedMethod) || ((AnnotatedMethod) this._member).getParameterCount() != 1) {
            return null;
        }
        return (AnnotatedMethod) this._member;
    }

    public AnnotatedField getField() {
        if (this._member instanceof AnnotatedField) {
            return (AnnotatedField) this._member;
        }
        return null;
    }

    public AnnotatedParameter getConstructorParameter() {
        if (this._member instanceof AnnotatedParameter) {
            return (AnnotatedParameter) this._member;
        }
        return null;
    }

    public Iterator<AnnotatedParameter> getConstructorParameters() {
        AnnotatedParameter constructorParameter = getConstructorParameter();
        if (constructorParameter == null) {
            return ClassUtil.emptyIterator();
        }
        return Collections.singleton(constructorParameter).iterator();
    }

    public AnnotatedMember getAccessor() {
        AnnotatedMethod getter = getGetter();
        return getter == null ? getField() : getter;
    }

    public AnnotatedMember getMutator() {
        AnnotatedParameter constructorParameter = getConstructorParameter();
        if (constructorParameter != null) {
            return constructorParameter;
        }
        AnnotatedMethod setter = getSetter();
        return setter == null ? getField() : setter;
    }

    public AnnotatedMember getNonConstructorMutator() {
        AnnotatedMethod setter = getSetter();
        return setter == null ? getField() : setter;
    }

    public AnnotatedMember getPrimaryMember() {
        return this._member;
    }
}

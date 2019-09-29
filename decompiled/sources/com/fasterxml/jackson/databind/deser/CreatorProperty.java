package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.Annotations;
import java.io.IOException;
import java.lang.annotation.Annotation;

public class CreatorProperty extends SettableBeanProperty {
    private static final long serialVersionUID = 1;
    protected final AnnotatedParameter _annotated;
    protected final int _creatorIndex;
    protected SettableBeanProperty _fallbackSetter;
    protected final Object _injectableValueId;

    public CreatorProperty(PropertyName propertyName, JavaType javaType, PropertyName propertyName2, TypeDeserializer typeDeserializer, Annotations annotations, AnnotatedParameter annotatedParameter, int i, Object obj, PropertyMetadata propertyMetadata) {
        super(propertyName, javaType, propertyName2, typeDeserializer, annotations, propertyMetadata);
        this._annotated = annotatedParameter;
        this._creatorIndex = i;
        this._injectableValueId = obj;
        this._fallbackSetter = null;
    }

    protected CreatorProperty(CreatorProperty creatorProperty, PropertyName propertyName) {
        super((SettableBeanProperty) creatorProperty, propertyName);
        this._annotated = creatorProperty._annotated;
        this._creatorIndex = creatorProperty._creatorIndex;
        this._injectableValueId = creatorProperty._injectableValueId;
        this._fallbackSetter = creatorProperty._fallbackSetter;
    }

    protected CreatorProperty(CreatorProperty creatorProperty, JsonDeserializer<?> jsonDeserializer) {
        super((SettableBeanProperty) creatorProperty, jsonDeserializer);
        this._annotated = creatorProperty._annotated;
        this._creatorIndex = creatorProperty._creatorIndex;
        this._injectableValueId = creatorProperty._injectableValueId;
        this._fallbackSetter = creatorProperty._fallbackSetter;
    }

    public CreatorProperty withName(PropertyName propertyName) {
        return new CreatorProperty(this, propertyName);
    }

    public CreatorProperty withValueDeserializer(JsonDeserializer<?> jsonDeserializer) {
        if (this._valueDeserializer == jsonDeserializer) {
            return this;
        }
        return new CreatorProperty(this, jsonDeserializer);
    }

    public void fixAccess(DeserializationConfig deserializationConfig) {
        if (this._fallbackSetter != null) {
            this._fallbackSetter.fixAccess(deserializationConfig);
        }
    }

    public void setFallbackSetter(SettableBeanProperty settableBeanProperty) {
        this._fallbackSetter = settableBeanProperty;
    }

    public Object findInjectableValue(DeserializationContext deserializationContext, Object obj) {
        if (this._injectableValueId != null) {
            return deserializationContext.findInjectableValue(this._injectableValueId, this, obj);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Property '");
        sb.append(getName());
        sb.append("' (type ");
        sb.append(getClass().getName());
        sb.append(") has no injectable value id configured");
        throw new IllegalStateException(sb.toString());
    }

    public void inject(DeserializationContext deserializationContext, Object obj) throws IOException {
        set(obj, findInjectableValue(deserializationContext, obj));
    }

    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        if (this._annotated == null) {
            return null;
        }
        return this._annotated.getAnnotation(cls);
    }

    public AnnotatedMember getMember() {
        return this._annotated;
    }

    public int getCreatorIndex() {
        return this._creatorIndex;
    }

    public void deserializeAndSet(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        set(obj, deserialize(jsonParser, deserializationContext));
    }

    public Object deserializeSetAndReturn(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        return setAndReturn(obj, deserialize(jsonParser, deserializationContext));
    }

    public void set(Object obj, Object obj2) throws IOException {
        if (this._fallbackSetter != null) {
            this._fallbackSetter.set(obj, obj2);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No fallback setter/field defined: can not use creator property for ");
        sb.append(getClass().getName());
        throw new IllegalStateException(sb.toString());
    }

    public Object setAndReturn(Object obj, Object obj2) throws IOException {
        if (this._fallbackSetter != null) {
            return this._fallbackSetter.setAndReturn(obj, obj2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No fallback setter/field defined: can not use creator property for ");
        sb.append(getClass().getName());
        throw new IllegalStateException(sb.toString());
    }

    public Object getInjectableValueId() {
        return this._injectableValueId;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[creator property, name '");
        sb.append(getName());
        sb.append("'; inject id '");
        sb.append(this._injectableValueId);
        sb.append("']");
        return sb.toString();
    }
}

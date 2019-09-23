package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.impl.BeanAsArrayDeserializer;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId.Referring;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BeanDeserializer extends BeanDeserializerBase implements Serializable {
    private static final long serialVersionUID = 1;
    protected transient Exception _nullFromCreator;

    static class BeanReferring extends Referring {
        private Object _bean;
        private final DeserializationContext _context;
        private final SettableBeanProperty _prop;

        BeanReferring(DeserializationContext deserializationContext, UnresolvedForwardReference unresolvedForwardReference, JavaType javaType, PropertyValueBuffer propertyValueBuffer, SettableBeanProperty settableBeanProperty) {
            super(unresolvedForwardReference, javaType);
            this._context = deserializationContext;
            this._prop = settableBeanProperty;
        }

        public void setBean(Object obj) {
            this._bean = obj;
        }

        public void handleResolvedForwardReference(Object obj, Object obj2) throws IOException {
            if (this._bean == null) {
                this._context.reportMappingException("Can not resolve ObjectId forward reference using property '%s' (of type %s): Bean not yet resolved", this._prop.getName(), this._prop.getDeclaringClass().getName());
            }
            this._prop.set(this._bean, obj2);
        }
    }

    public BeanDeserializer(BeanDeserializerBuilder beanDeserializerBuilder, BeanDescription beanDescription, BeanPropertyMap beanPropertyMap, Map<String, SettableBeanProperty> map, HashSet<String> hashSet, boolean z, boolean z2) {
        super(beanDeserializerBuilder, beanDescription, beanPropertyMap, map, hashSet, z, z2);
    }

    protected BeanDeserializer(BeanDeserializerBase beanDeserializerBase) {
        super(beanDeserializerBase, beanDeserializerBase._ignoreAllUnknown);
    }

    protected BeanDeserializer(BeanDeserializerBase beanDeserializerBase, boolean z) {
        super(beanDeserializerBase, z);
    }

    protected BeanDeserializer(BeanDeserializerBase beanDeserializerBase, NameTransformer nameTransformer) {
        super(beanDeserializerBase, nameTransformer);
    }

    public BeanDeserializer(BeanDeserializerBase beanDeserializerBase, ObjectIdReader objectIdReader) {
        super(beanDeserializerBase, objectIdReader);
    }

    public BeanDeserializer(BeanDeserializerBase beanDeserializerBase, Set<String> set) {
        super(beanDeserializerBase, set);
    }

    public BeanDeserializer(BeanDeserializerBase beanDeserializerBase, BeanPropertyMap beanPropertyMap) {
        super(beanDeserializerBase, beanPropertyMap);
    }

    public JsonDeserializer<Object> unwrappingDeserializer(NameTransformer nameTransformer) {
        if (getClass() != BeanDeserializer.class) {
            return this;
        }
        return new BeanDeserializer((BeanDeserializerBase) this, nameTransformer);
    }

    public BeanDeserializer withObjectIdReader(ObjectIdReader objectIdReader) {
        return new BeanDeserializer((BeanDeserializerBase) this, objectIdReader);
    }

    public BeanDeserializer withIgnorableProperties(Set<String> set) {
        return new BeanDeserializer((BeanDeserializerBase) this, set);
    }

    public BeanDeserializerBase withBeanProperties(BeanPropertyMap beanPropertyMap) {
        return new BeanDeserializer((BeanDeserializerBase) this, beanPropertyMap);
    }

    /* access modifiers changed from: protected */
    public BeanDeserializerBase asArrayDeserializer() {
        return new BeanAsArrayDeserializer(this, this._beanProperties.getPropertiesInInsertionOrder());
    }

    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (!jsonParser.isExpectedStartObjectToken()) {
            return _deserializeOther(jsonParser, deserializationContext, jsonParser.getCurrentToken());
        }
        if (this._vanillaProcessing) {
            return vanillaDeserialize(jsonParser, deserializationContext, jsonParser.nextToken());
        }
        jsonParser.nextToken();
        if (this._objectIdReader != null) {
            return deserializeWithObjectId(jsonParser, deserializationContext);
        }
        return deserializeFromObject(jsonParser, deserializationContext);
    }

    /* access modifiers changed from: protected */
    public final Object _deserializeOther(JsonParser jsonParser, DeserializationContext deserializationContext, JsonToken jsonToken) throws IOException {
        switch (jsonToken) {
            case VALUE_STRING:
                return deserializeFromString(jsonParser, deserializationContext);
            case VALUE_NUMBER_INT:
                return deserializeFromNumber(jsonParser, deserializationContext);
            case VALUE_NUMBER_FLOAT:
                return deserializeFromDouble(jsonParser, deserializationContext);
            case VALUE_EMBEDDED_OBJECT:
                return deserializeFromEmbedded(jsonParser, deserializationContext);
            case VALUE_TRUE:
            case VALUE_FALSE:
                return deserializeFromBoolean(jsonParser, deserializationContext);
            case VALUE_NULL:
                return deserializeFromNull(jsonParser, deserializationContext);
            case START_ARRAY:
                return deserializeFromArray(jsonParser, deserializationContext);
            case FIELD_NAME:
            case END_OBJECT:
                if (this._vanillaProcessing) {
                    return vanillaDeserialize(jsonParser, deserializationContext, jsonToken);
                }
                if (this._objectIdReader != null) {
                    return deserializeWithObjectId(jsonParser, deserializationContext);
                }
                return deserializeFromObject(jsonParser, deserializationContext);
            default:
                return deserializationContext.handleUnexpectedToken(handledType(), jsonParser);
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public Object _missingToken(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        throw deserializationContext.endOfInputException(handledType());
    }

    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        String str;
        jsonParser.setCurrentValue(obj);
        if (this._injectables != null) {
            injectValues(deserializationContext, obj);
        }
        if (this._unwrappedPropertyHandler != null) {
            return deserializeWithUnwrapped(jsonParser, deserializationContext, obj);
        }
        if (this._externalTypeIdHandler != null) {
            return deserializeWithExternalTypeId(jsonParser, deserializationContext, obj);
        }
        if (jsonParser.isExpectedStartObjectToken()) {
            str = jsonParser.nextFieldName();
            if (str == null) {
                return obj;
            }
        } else if (!jsonParser.hasTokenId(5)) {
            return obj;
        } else {
            str = jsonParser.getCurrentName();
        }
        if (this._needViewProcesing) {
            Class activeView = deserializationContext.getActiveView();
            if (activeView != null) {
                return deserializeWithView(jsonParser, deserializationContext, obj, activeView);
            }
        }
        do {
            jsonParser.nextToken();
            SettableBeanProperty find = this._beanProperties.find(str);
            if (find != null) {
                try {
                    find.deserializeAndSet(jsonParser, deserializationContext, obj);
                } catch (Exception e) {
                    wrapAndThrow((Throwable) e, obj, str, deserializationContext);
                }
            } else {
                handleUnknownVanilla(jsonParser, deserializationContext, obj, str);
            }
            str = jsonParser.nextFieldName();
        } while (str != null);
        return obj;
    }

    private final Object vanillaDeserialize(JsonParser jsonParser, DeserializationContext deserializationContext, JsonToken jsonToken) throws IOException {
        Object createUsingDefault = this._valueInstantiator.createUsingDefault(deserializationContext);
        jsonParser.setCurrentValue(createUsingDefault);
        if (jsonParser.hasTokenId(5)) {
            String currentName = jsonParser.getCurrentName();
            do {
                jsonParser.nextToken();
                SettableBeanProperty find = this._beanProperties.find(currentName);
                if (find != null) {
                    try {
                        find.deserializeAndSet(jsonParser, deserializationContext, createUsingDefault);
                    } catch (Exception e) {
                        wrapAndThrow((Throwable) e, createUsingDefault, currentName, deserializationContext);
                    }
                } else {
                    handleUnknownVanilla(jsonParser, deserializationContext, createUsingDefault, currentName);
                }
                currentName = jsonParser.nextFieldName();
            } while (currentName != null);
        }
        return createUsingDefault;
    }

    public Object deserializeFromObject(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (this._objectIdReader != null && this._objectIdReader.maySerializeAsObject() && jsonParser.hasTokenId(5) && this._objectIdReader.isValidReferencePropertyName(jsonParser.getCurrentName(), jsonParser)) {
            return deserializeFromObjectId(jsonParser, deserializationContext);
        }
        if (!this._nonStandardCreation) {
            Object createUsingDefault = this._valueInstantiator.createUsingDefault(deserializationContext);
            jsonParser.setCurrentValue(createUsingDefault);
            if (jsonParser.canReadObjectId()) {
                Object objectId = jsonParser.getObjectId();
                if (objectId != null) {
                    _handleTypedObjectId(jsonParser, deserializationContext, createUsingDefault, objectId);
                }
            }
            if (this._injectables != null) {
                injectValues(deserializationContext, createUsingDefault);
            }
            if (this._needViewProcesing) {
                Class activeView = deserializationContext.getActiveView();
                if (activeView != null) {
                    return deserializeWithView(jsonParser, deserializationContext, createUsingDefault, activeView);
                }
            }
            if (jsonParser.hasTokenId(5)) {
                String currentName = jsonParser.getCurrentName();
                do {
                    jsonParser.nextToken();
                    SettableBeanProperty find = this._beanProperties.find(currentName);
                    if (find != null) {
                        try {
                            find.deserializeAndSet(jsonParser, deserializationContext, createUsingDefault);
                        } catch (Exception e) {
                            wrapAndThrow((Throwable) e, createUsingDefault, currentName, deserializationContext);
                        }
                    } else {
                        handleUnknownVanilla(jsonParser, deserializationContext, createUsingDefault, currentName);
                    }
                    currentName = jsonParser.nextFieldName();
                } while (currentName != null);
            }
            return createUsingDefault;
        } else if (this._unwrappedPropertyHandler != null) {
            return deserializeWithUnwrapped(jsonParser, deserializationContext);
        } else {
            if (this._externalTypeIdHandler != null) {
                return deserializeWithExternalTypeId(jsonParser, deserializationContext);
            }
            Object deserializeFromObjectUsingNonDefault = deserializeFromObjectUsingNonDefault(jsonParser, deserializationContext);
            if (this._injectables != null) {
                injectValues(deserializationContext, deserializeFromObjectUsingNonDefault);
            }
            return deserializeFromObjectUsingNonDefault;
        }
    }

    /* access modifiers changed from: protected */
    public Object _deserializeUsingPropertyBased(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Object obj;
        Object obj2;
        PropertyBasedCreator propertyBasedCreator = this._propertyBasedCreator;
        PropertyValueBuffer startBuilding = propertyBasedCreator.startBuilding(jsonParser, deserializationContext, this._objectIdReader);
        JsonToken currentToken = jsonParser.getCurrentToken();
        List<BeanReferring> list = null;
        TokenBuffer tokenBuffer = null;
        while (currentToken == JsonToken.FIELD_NAME) {
            String currentName = jsonParser.getCurrentName();
            jsonParser.nextToken();
            if (!startBuilding.readIdProperty(currentName)) {
                SettableBeanProperty findCreatorProperty = propertyBasedCreator.findCreatorProperty(currentName);
                if (findCreatorProperty == null) {
                    SettableBeanProperty find = this._beanProperties.find(currentName);
                    if (find != null) {
                        try {
                            startBuilding.bufferProperty(find, _deserializeWithErrorWrapping(jsonParser, deserializationContext, find));
                        } catch (UnresolvedForwardReference e) {
                            BeanReferring handleUnresolvedReference = handleUnresolvedReference(deserializationContext, find, startBuilding, e);
                            if (list == null) {
                                list = new ArrayList<>();
                            }
                            list.add(handleUnresolvedReference);
                        }
                    } else if (this._ignorableProps != null && this._ignorableProps.contains(currentName)) {
                        handleIgnoredProperty(jsonParser, deserializationContext, handledType(), currentName);
                    } else if (this._anySetter != null) {
                        try {
                            startBuilding.bufferAnyProperty(this._anySetter, currentName, this._anySetter.deserialize(jsonParser, deserializationContext));
                        } catch (Exception e2) {
                            wrapAndThrow((Throwable) e2, (Object) this._beanType.getRawClass(), currentName, deserializationContext);
                        }
                    } else {
                        if (tokenBuffer == null) {
                            tokenBuffer = new TokenBuffer(jsonParser, deserializationContext);
                        }
                        tokenBuffer.writeFieldName(currentName);
                        tokenBuffer.copyCurrentStructure(jsonParser);
                    }
                } else if (startBuilding.assignParameter(findCreatorProperty, _deserializeWithErrorWrapping(jsonParser, deserializationContext, findCreatorProperty))) {
                    jsonParser.nextToken();
                    try {
                        obj2 = propertyBasedCreator.build(deserializationContext, startBuilding);
                    } catch (Exception e3) {
                        obj2 = wrapInstantiationProblem(e3, deserializationContext);
                    }
                    if (obj2 == null) {
                        return deserializationContext.handleInstantiationProblem(handledType(), null, _creatorReturnedNullException());
                    }
                    jsonParser.setCurrentValue(obj2);
                    if (obj2.getClass() != this._beanType.getRawClass()) {
                        return handlePolymorphic(jsonParser, deserializationContext, obj2, tokenBuffer);
                    }
                    if (tokenBuffer != null) {
                        obj2 = handleUnknownProperties(deserializationContext, obj2, tokenBuffer);
                    }
                    return deserialize(jsonParser, deserializationContext, obj2);
                }
            }
            currentToken = jsonParser.nextToken();
        }
        try {
            obj = propertyBasedCreator.build(deserializationContext, startBuilding);
        } catch (Exception e4) {
            wrapInstantiationProblem(e4, deserializationContext);
            obj = null;
        }
        if (list != null) {
            for (BeanReferring bean : list) {
                bean.setBean(obj);
            }
        }
        if (tokenBuffer == null) {
            return obj;
        }
        if (obj.getClass() != this._beanType.getRawClass()) {
            return handlePolymorphic(null, deserializationContext, obj, tokenBuffer);
        }
        return handleUnknownProperties(deserializationContext, obj, tokenBuffer);
    }

    private BeanReferring handleUnresolvedReference(DeserializationContext deserializationContext, SettableBeanProperty settableBeanProperty, PropertyValueBuffer propertyValueBuffer, UnresolvedForwardReference unresolvedForwardReference) throws JsonMappingException {
        BeanReferring beanReferring = new BeanReferring(deserializationContext, unresolvedForwardReference, settableBeanProperty.getType(), propertyValueBuffer, settableBeanProperty);
        unresolvedForwardReference.getRoid().appendReferring(beanReferring);
        return beanReferring;
    }

    /* access modifiers changed from: protected */
    public final Object _deserializeWithErrorWrapping(JsonParser jsonParser, DeserializationContext deserializationContext, SettableBeanProperty settableBeanProperty) throws IOException {
        try {
            return settableBeanProperty.deserialize(jsonParser, deserializationContext);
        } catch (Exception e) {
            wrapAndThrow((Throwable) e, (Object) this._beanType.getRawClass(), settableBeanProperty.getName(), deserializationContext);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public Object deserializeFromNull(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (!jsonParser.requiresCustomCodec()) {
            return deserializationContext.handleUnexpectedToken(handledType(), jsonParser);
        }
        TokenBuffer tokenBuffer = new TokenBuffer(jsonParser, deserializationContext);
        tokenBuffer.writeEndObject();
        JsonParser asParser = tokenBuffer.asParser(jsonParser);
        asParser.nextToken();
        Object vanillaDeserialize = this._vanillaProcessing ? vanillaDeserialize(asParser, deserializationContext, JsonToken.END_OBJECT) : deserializeFromObject(asParser, deserializationContext);
        asParser.close();
        return vanillaDeserialize;
    }

    /* access modifiers changed from: protected */
    public final Object deserializeWithView(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, Class<?> cls) throws IOException {
        if (jsonParser.hasTokenId(5)) {
            String currentName = jsonParser.getCurrentName();
            do {
                jsonParser.nextToken();
                SettableBeanProperty find = this._beanProperties.find(currentName);
                if (find == null) {
                    handleUnknownVanilla(jsonParser, deserializationContext, obj, currentName);
                } else if (!find.visibleInView(cls)) {
                    jsonParser.skipChildren();
                } else {
                    try {
                        find.deserializeAndSet(jsonParser, deserializationContext, obj);
                    } catch (Exception e) {
                        wrapAndThrow((Throwable) e, obj, currentName, deserializationContext);
                    }
                }
                currentName = jsonParser.nextFieldName();
            } while (currentName != null);
        }
        return obj;
    }

    /* access modifiers changed from: protected */
    public Object deserializeWithUnwrapped(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (this._delegateDeserializer != null) {
            return this._valueInstantiator.createUsingDelegate(deserializationContext, this._delegateDeserializer.deserialize(jsonParser, deserializationContext));
        }
        if (this._propertyBasedCreator != null) {
            return deserializeUsingPropertyBasedWithUnwrapped(jsonParser, deserializationContext);
        }
        TokenBuffer tokenBuffer = new TokenBuffer(jsonParser, deserializationContext);
        tokenBuffer.writeStartObject();
        Object createUsingDefault = this._valueInstantiator.createUsingDefault(deserializationContext);
        jsonParser.setCurrentValue(createUsingDefault);
        if (this._injectables != null) {
            injectValues(deserializationContext, createUsingDefault);
        }
        String str = null;
        Class activeView = this._needViewProcesing ? deserializationContext.getActiveView() : null;
        if (jsonParser.hasTokenId(5)) {
            str = jsonParser.getCurrentName();
        }
        while (str != null) {
            jsonParser.nextToken();
            SettableBeanProperty find = this._beanProperties.find(str);
            if (find != null) {
                if (activeView == null || find.visibleInView(activeView)) {
                    try {
                        find.deserializeAndSet(jsonParser, deserializationContext, createUsingDefault);
                    } catch (Exception e) {
                        wrapAndThrow((Throwable) e, createUsingDefault, str, deserializationContext);
                    }
                } else {
                    jsonParser.skipChildren();
                }
            } else if (this._ignorableProps != null && this._ignorableProps.contains(str)) {
                handleIgnoredProperty(jsonParser, deserializationContext, createUsingDefault, str);
            } else if (this._anySetter == null) {
                tokenBuffer.writeFieldName(str);
                tokenBuffer.copyCurrentStructure(jsonParser);
            } else {
                TokenBuffer tokenBuffer2 = new TokenBuffer(jsonParser, deserializationContext);
                tokenBuffer2.copyCurrentStructure(jsonParser);
                tokenBuffer.writeFieldName(str);
                tokenBuffer.append(tokenBuffer2);
                try {
                    JsonParser asParser = tokenBuffer2.asParser(jsonParser);
                    asParser.nextToken();
                    this._anySetter.deserializeAndSet(asParser, deserializationContext, createUsingDefault, str);
                } catch (Exception e2) {
                    wrapAndThrow((Throwable) e2, createUsingDefault, str, deserializationContext);
                }
            }
            str = jsonParser.nextFieldName();
        }
        tokenBuffer.writeEndObject();
        this._unwrappedPropertyHandler.processUnwrapped(jsonParser, deserializationContext, createUsingDefault, tokenBuffer);
        return createUsingDefault;
    }

    /* access modifiers changed from: protected */
    public Object deserializeWithUnwrapped(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.START_OBJECT) {
            currentToken = jsonParser.nextToken();
        }
        TokenBuffer tokenBuffer = new TokenBuffer(jsonParser, deserializationContext);
        tokenBuffer.writeStartObject();
        Class activeView = this._needViewProcesing ? deserializationContext.getActiveView() : null;
        while (currentToken == JsonToken.FIELD_NAME) {
            String currentName = jsonParser.getCurrentName();
            SettableBeanProperty find = this._beanProperties.find(currentName);
            jsonParser.nextToken();
            if (find != null) {
                if (activeView == null || find.visibleInView(activeView)) {
                    try {
                        find.deserializeAndSet(jsonParser, deserializationContext, obj);
                    } catch (Exception e) {
                        wrapAndThrow((Throwable) e, obj, currentName, deserializationContext);
                    }
                } else {
                    jsonParser.skipChildren();
                }
            } else if (this._ignorableProps != null && this._ignorableProps.contains(currentName)) {
                handleIgnoredProperty(jsonParser, deserializationContext, obj, currentName);
            } else if (this._anySetter == null) {
                tokenBuffer.writeFieldName(currentName);
                tokenBuffer.copyCurrentStructure(jsonParser);
            } else {
                TokenBuffer tokenBuffer2 = new TokenBuffer(jsonParser, deserializationContext);
                tokenBuffer2.copyCurrentStructure(jsonParser);
                tokenBuffer.writeFieldName(currentName);
                tokenBuffer.append(tokenBuffer2);
                try {
                    JsonParser asParser = tokenBuffer2.asParser(jsonParser);
                    asParser.nextToken();
                    this._anySetter.deserializeAndSet(asParser, deserializationContext, obj, currentName);
                } catch (Exception e2) {
                    wrapAndThrow((Throwable) e2, obj, currentName, deserializationContext);
                }
            }
            currentToken = jsonParser.nextToken();
        }
        tokenBuffer.writeEndObject();
        this._unwrappedPropertyHandler.processUnwrapped(jsonParser, deserializationContext, obj, tokenBuffer);
        return obj;
    }

    /* access modifiers changed from: protected */
    public Object deserializeUsingPropertyBasedWithUnwrapped(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Object obj;
        PropertyBasedCreator propertyBasedCreator = this._propertyBasedCreator;
        PropertyValueBuffer startBuilding = propertyBasedCreator.startBuilding(jsonParser, deserializationContext, this._objectIdReader);
        TokenBuffer tokenBuffer = new TokenBuffer(jsonParser, deserializationContext);
        tokenBuffer.writeStartObject();
        JsonToken currentToken = jsonParser.getCurrentToken();
        while (currentToken == JsonToken.FIELD_NAME) {
            String currentName = jsonParser.getCurrentName();
            jsonParser.nextToken();
            SettableBeanProperty findCreatorProperty = propertyBasedCreator.findCreatorProperty(currentName);
            if (findCreatorProperty != null) {
                if (startBuilding.assignParameter(findCreatorProperty, _deserializeWithErrorWrapping(jsonParser, deserializationContext, findCreatorProperty))) {
                    JsonToken nextToken = jsonParser.nextToken();
                    try {
                        obj = propertyBasedCreator.build(deserializationContext, startBuilding);
                    } catch (Exception e) {
                        obj = wrapInstantiationProblem(e, deserializationContext);
                    }
                    jsonParser.setCurrentValue(obj);
                    while (nextToken == JsonToken.FIELD_NAME) {
                        jsonParser.nextToken();
                        tokenBuffer.copyCurrentStructure(jsonParser);
                        nextToken = jsonParser.nextToken();
                    }
                    tokenBuffer.writeEndObject();
                    if (obj.getClass() == this._beanType.getRawClass()) {
                        return this._unwrappedPropertyHandler.processUnwrapped(jsonParser, deserializationContext, obj, tokenBuffer);
                    }
                    tokenBuffer.close();
                    deserializationContext.reportMappingException("Can not create polymorphic instances with unwrapped values", new Object[0]);
                    return null;
                }
            } else if (!startBuilding.readIdProperty(currentName)) {
                SettableBeanProperty find = this._beanProperties.find(currentName);
                if (find != null) {
                    startBuilding.bufferProperty(find, _deserializeWithErrorWrapping(jsonParser, deserializationContext, find));
                } else if (this._ignorableProps != null && this._ignorableProps.contains(currentName)) {
                    handleIgnoredProperty(jsonParser, deserializationContext, handledType(), currentName);
                } else if (this._anySetter == null) {
                    tokenBuffer.writeFieldName(currentName);
                    tokenBuffer.copyCurrentStructure(jsonParser);
                } else {
                    TokenBuffer tokenBuffer2 = new TokenBuffer(jsonParser, deserializationContext);
                    tokenBuffer2.copyCurrentStructure(jsonParser);
                    tokenBuffer.writeFieldName(currentName);
                    tokenBuffer.append(tokenBuffer2);
                    try {
                        JsonParser asParser = tokenBuffer2.asParser(jsonParser);
                        asParser.nextToken();
                        startBuilding.bufferAnyProperty(this._anySetter, currentName, this._anySetter.deserialize(asParser, deserializationContext));
                    } catch (Exception e2) {
                        wrapAndThrow((Throwable) e2, (Object) this._beanType.getRawClass(), currentName, deserializationContext);
                    }
                }
            }
            currentToken = jsonParser.nextToken();
        }
        try {
            return this._unwrappedPropertyHandler.processUnwrapped(jsonParser, deserializationContext, propertyBasedCreator.build(deserializationContext, startBuilding), tokenBuffer);
        } catch (Exception e3) {
            wrapInstantiationProblem(e3, deserializationContext);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public Object deserializeWithExternalTypeId(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (this._propertyBasedCreator != null) {
            return deserializeUsingPropertyBasedWithExternalTypeId(jsonParser, deserializationContext);
        }
        if (this._delegateDeserializer != null) {
            return this._valueInstantiator.createUsingDelegate(deserializationContext, this._delegateDeserializer.deserialize(jsonParser, deserializationContext));
        }
        return deserializeWithExternalTypeId(jsonParser, deserializationContext, this._valueInstantiator.createUsingDefault(deserializationContext));
    }

    /* access modifiers changed from: protected */
    public Object deserializeWithExternalTypeId(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        Class activeView = this._needViewProcesing ? deserializationContext.getActiveView() : null;
        ExternalTypeHandler start = this._externalTypeIdHandler.start();
        JsonToken currentToken = jsonParser.getCurrentToken();
        while (currentToken == JsonToken.FIELD_NAME) {
            String currentName = jsonParser.getCurrentName();
            JsonToken nextToken = jsonParser.nextToken();
            SettableBeanProperty find = this._beanProperties.find(currentName);
            if (find != null) {
                if (nextToken.isScalarValue()) {
                    start.handleTypePropertyValue(jsonParser, deserializationContext, currentName, obj);
                }
                if (activeView == null || find.visibleInView(activeView)) {
                    try {
                        find.deserializeAndSet(jsonParser, deserializationContext, obj);
                    } catch (Exception e) {
                        wrapAndThrow((Throwable) e, obj, currentName, deserializationContext);
                    }
                } else {
                    jsonParser.skipChildren();
                }
            } else if (this._ignorableProps != null && this._ignorableProps.contains(currentName)) {
                handleIgnoredProperty(jsonParser, deserializationContext, obj, currentName);
            } else if (!start.handlePropertyValue(jsonParser, deserializationContext, currentName, obj)) {
                if (this._anySetter != null) {
                    try {
                        this._anySetter.deserializeAndSet(jsonParser, deserializationContext, obj, currentName);
                    } catch (Exception e2) {
                        wrapAndThrow((Throwable) e2, obj, currentName, deserializationContext);
                    }
                } else {
                    handleUnknownProperty(jsonParser, deserializationContext, obj, currentName);
                }
            }
            currentToken = jsonParser.nextToken();
        }
        return start.complete(jsonParser, deserializationContext, obj);
    }

    /* access modifiers changed from: protected */
    public Object deserializeUsingPropertyBasedWithExternalTypeId(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ExternalTypeHandler start = this._externalTypeIdHandler.start();
        PropertyBasedCreator propertyBasedCreator = this._propertyBasedCreator;
        PropertyValueBuffer startBuilding = propertyBasedCreator.startBuilding(jsonParser, deserializationContext, this._objectIdReader);
        TokenBuffer tokenBuffer = new TokenBuffer(jsonParser, deserializationContext);
        tokenBuffer.writeStartObject();
        JsonToken currentToken = jsonParser.getCurrentToken();
        while (currentToken == JsonToken.FIELD_NAME) {
            String currentName = jsonParser.getCurrentName();
            jsonParser.nextToken();
            SettableBeanProperty findCreatorProperty = propertyBasedCreator.findCreatorProperty(currentName);
            if (findCreatorProperty != null) {
                if (!start.handlePropertyValue(jsonParser, deserializationContext, currentName, null) && startBuilding.assignParameter(findCreatorProperty, _deserializeWithErrorWrapping(jsonParser, deserializationContext, findCreatorProperty))) {
                    JsonToken nextToken = jsonParser.nextToken();
                    try {
                        Object build = propertyBasedCreator.build(deserializationContext, startBuilding);
                        while (nextToken == JsonToken.FIELD_NAME) {
                            jsonParser.nextToken();
                            tokenBuffer.copyCurrentStructure(jsonParser);
                            nextToken = jsonParser.nextToken();
                        }
                        if (build.getClass() == this._beanType.getRawClass()) {
                            return start.complete(jsonParser, deserializationContext, build);
                        }
                        deserializationContext.reportMappingException("Can not create polymorphic instances with external type ids", new Object[0]);
                        return null;
                    } catch (Exception e) {
                        wrapAndThrow((Throwable) e, (Object) this._beanType.getRawClass(), currentName, deserializationContext);
                    }
                }
            } else if (!startBuilding.readIdProperty(currentName)) {
                SettableBeanProperty find = this._beanProperties.find(currentName);
                if (find != null) {
                    startBuilding.bufferProperty(find, find.deserialize(jsonParser, deserializationContext));
                } else if (!start.handlePropertyValue(jsonParser, deserializationContext, currentName, null)) {
                    if (this._ignorableProps != null && this._ignorableProps.contains(currentName)) {
                        handleIgnoredProperty(jsonParser, deserializationContext, handledType(), currentName);
                    } else if (this._anySetter != null) {
                        startBuilding.bufferAnyProperty(this._anySetter, currentName, this._anySetter.deserialize(jsonParser, deserializationContext));
                    }
                }
            }
            currentToken = jsonParser.nextToken();
        }
        try {
            return start.complete(jsonParser, deserializationContext, startBuilding, propertyBasedCreator);
        } catch (Exception e2) {
            return wrapInstantiationProblem(e2, deserializationContext);
        }
    }

    /* access modifiers changed from: protected */
    public Exception _creatorReturnedNullException() {
        if (this._nullFromCreator == null) {
            this._nullFromCreator = new NullPointerException("JSON Creator returned null");
        }
        return this._nullFromCreator;
    }
}

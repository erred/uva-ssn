package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId.Referring;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

public class SettableAnyProperty implements Serializable {
    private static final long serialVersionUID = 1;
    protected final BeanProperty _property;
    protected final AnnotatedMember _setter;
    final boolean _setterIsField;
    protected final JavaType _type;
    protected JsonDeserializer<Object> _valueDeserializer;
    protected final TypeDeserializer _valueTypeDeserializer;

    private static class AnySetterReferring extends Referring {
        private final SettableAnyProperty _parent;
        private final Object _pojo;
        private final String _propName;

        public AnySetterReferring(SettableAnyProperty settableAnyProperty, UnresolvedForwardReference unresolvedForwardReference, Class<?> cls, Object obj, String str) {
            super(unresolvedForwardReference, cls);
            this._parent = settableAnyProperty;
            this._pojo = obj;
            this._propName = str;
        }

        public void handleResolvedForwardReference(Object obj, Object obj2) throws IOException {
            if (hasId(obj)) {
                this._parent.set(this._pojo, this._propName, obj2);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Trying to resolve a forward reference with id [");
            sb.append(obj.toString());
            sb.append("] that wasn't previously registered.");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public SettableAnyProperty(BeanProperty beanProperty, AnnotatedMember annotatedMember, JavaType javaType, JsonDeserializer<Object> jsonDeserializer, TypeDeserializer typeDeserializer) {
        this._property = beanProperty;
        this._setter = annotatedMember;
        this._type = javaType;
        this._valueDeserializer = jsonDeserializer;
        this._valueTypeDeserializer = typeDeserializer;
        this._setterIsField = annotatedMember instanceof AnnotatedField;
    }

    protected SettableAnyProperty(SettableAnyProperty settableAnyProperty) {
        this._property = settableAnyProperty._property;
        this._setter = settableAnyProperty._setter;
        this._type = settableAnyProperty._type;
        this._valueDeserializer = settableAnyProperty._valueDeserializer;
        this._valueTypeDeserializer = settableAnyProperty._valueTypeDeserializer;
        this._setterIsField = settableAnyProperty._setterIsField;
    }

    public SettableAnyProperty withValueDeserializer(JsonDeserializer<Object> jsonDeserializer) {
        SettableAnyProperty settableAnyProperty = new SettableAnyProperty(this._property, this._setter, this._type, jsonDeserializer, this._valueTypeDeserializer);
        return settableAnyProperty;
    }

    public void fixAccess(DeserializationConfig deserializationConfig) {
        this._setter.fixAccess(deserializationConfig.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
    }

    /* access modifiers changed from: 0000 */
    public Object readResolve() {
        if (this._setter != null && this._setter.getAnnotated() != null) {
            return this;
        }
        throw new IllegalArgumentException("Missing method (broken JDK (de)serialization?)");
    }

    public BeanProperty getProperty() {
        return this._property;
    }

    public boolean hasValueDeserializer() {
        return this._valueDeserializer != null;
    }

    public JavaType getType() {
        return this._type;
    }

    public final void deserializeAndSet(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, String str) throws IOException {
        try {
            set(obj, str, deserialize(jsonParser, deserializationContext));
        } catch (UnresolvedForwardReference e) {
            if (this._valueDeserializer.getObjectIdReader() != null) {
                AnySetterReferring anySetterReferring = new AnySetterReferring(this, e, this._type.getRawClass(), obj, str);
                e.getRoid().appendReferring(anySetterReferring);
                return;
            }
            throw JsonMappingException.from(jsonParser, "Unresolved forward reference but no identity info.", (Throwable) e);
        }
    }

    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (jsonParser.getCurrentToken() == JsonToken.VALUE_NULL) {
            return this._valueDeserializer.getNullValue(deserializationContext);
        }
        if (this._valueTypeDeserializer != null) {
            return this._valueDeserializer.deserializeWithType(jsonParser, deserializationContext, this._valueTypeDeserializer);
        }
        return this._valueDeserializer.deserialize(jsonParser, deserializationContext);
    }

    public void set(Object obj, String str, Object obj2) throws IOException {
        try {
            if (this._setterIsField) {
                Map map = (Map) ((AnnotatedField) this._setter).getValue(obj);
                if (map != null) {
                    map.put(str, obj2);
                    return;
                }
                return;
            }
            ((AnnotatedMethod) this._setter).callOnWith(obj, str, obj2);
        } catch (Exception e) {
            _throwAsIOE(e, str, obj2);
        }
    }

    /* JADX WARNING: type inference failed for: r4v3, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r4v4, types: [java.lang.Throwable] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void _throwAsIOE(java.lang.Exception r4, java.lang.String r5, java.lang.Object r6) throws java.io.IOException {
        /*
            r3 = this;
            boolean r0 = r4 instanceof java.lang.IllegalArgumentException
            r1 = 0
            if (r0 == 0) goto L_0x0069
            if (r6 != 0) goto L_0x000a
            java.lang.String r6 = "[NULL]"
            goto L_0x0012
        L_0x000a:
            java.lang.Class r6 = r6.getClass()
            java.lang.String r6 = r6.getName()
        L_0x0012:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Problem deserializing \"any\" property '"
            r0.<init>(r2)
            r0.append(r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r2 = "' of class "
            r5.append(r2)
            java.lang.String r2 = r3.getClassName()
            r5.append(r2)
            java.lang.String r2 = " (expected type: "
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            r0.append(r5)
            com.fasterxml.jackson.databind.JavaType r5 = r3._type
            r0.append(r5)
            java.lang.String r5 = "; actual type: "
            r0.append(r5)
            r0.append(r6)
            java.lang.String r5 = ")"
            r0.append(r5)
            java.lang.String r5 = r4.getMessage()
            if (r5 == 0) goto L_0x005a
            java.lang.String r6 = ", problem: "
            r0.append(r6)
            r0.append(r5)
            goto L_0x005f
        L_0x005a:
            java.lang.String r5 = " (no error message provided)"
            r0.append(r5)
        L_0x005f:
            com.fasterxml.jackson.databind.JsonMappingException r5 = new com.fasterxml.jackson.databind.JsonMappingException
            java.lang.String r6 = r0.toString()
            r5.<init>(r1, r6, r4)
            throw r5
        L_0x0069:
            boolean r5 = r4 instanceof java.io.IOException
            if (r5 != 0) goto L_0x0089
            boolean r5 = r4 instanceof java.lang.RuntimeException
            if (r5 != 0) goto L_0x0086
        L_0x0071:
            java.lang.Throwable r5 = r4.getCause()
            if (r5 == 0) goto L_0x007c
            java.lang.Throwable r4 = r4.getCause()
            goto L_0x0071
        L_0x007c:
            com.fasterxml.jackson.databind.JsonMappingException r5 = new com.fasterxml.jackson.databind.JsonMappingException
            java.lang.String r6 = r4.getMessage()
            r5.<init>(r1, r6, r4)
            throw r5
        L_0x0086:
            java.lang.RuntimeException r4 = (java.lang.RuntimeException) r4
            throw r4
        L_0x0089:
            java.io.IOException r4 = (java.io.IOException) r4
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.SettableAnyProperty._throwAsIOE(java.lang.Exception, java.lang.String, java.lang.Object):void");
    }

    private String getClassName() {
        return this._setter.getDeclaringClass().getName();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[any property on class ");
        sb.append(getClassName());
        sb.append("]");
        return sb.toString();
    }
}

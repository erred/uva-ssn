package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceSerializer extends ReferenceTypeSerializer<AtomicReference<?>> {
    private static final long serialVersionUID = 1;

    public AtomicReferenceSerializer(ReferenceType referenceType, boolean z, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        super(referenceType, z, typeSerializer, jsonSerializer);
    }

    protected AtomicReferenceSerializer(AtomicReferenceSerializer atomicReferenceSerializer, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, NameTransformer nameTransformer, Include include) {
        super(atomicReferenceSerializer, beanProperty, typeSerializer, jsonSerializer, nameTransformer, include);
    }

    /* access modifiers changed from: protected */
    public AtomicReferenceSerializer withResolved(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, NameTransformer nameTransformer, Include include) {
        if (this._property == beanProperty && include == this._contentInclusion && this._valueTypeSerializer == typeSerializer && this._valueSerializer == jsonSerializer && this._unwrapper == nameTransformer) {
            return this;
        }
        AtomicReferenceSerializer atomicReferenceSerializer = new AtomicReferenceSerializer(this, beanProperty, typeSerializer, jsonSerializer, nameTransformer, include);
        return atomicReferenceSerializer;
    }

    /* access modifiers changed from: protected */
    public boolean _isValueEmpty(AtomicReference<?> atomicReference) {
        return atomicReference.get() == null;
    }

    /* access modifiers changed from: protected */
    public Object _getReferenced(AtomicReference<?> atomicReference) {
        return atomicReference.get();
    }

    /* access modifiers changed from: protected */
    public Object _getReferencedIfPresent(AtomicReference<?> atomicReference) {
        return atomicReference.get();
    }
}

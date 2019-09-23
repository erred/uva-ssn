package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

@JacksonStdImpl
public class StdValueInstantiator extends ValueInstantiator implements Serializable {
    private static final long serialVersionUID = 1;
    protected SettableBeanProperty[] _arrayDelegateArguments;
    protected AnnotatedWithParams _arrayDelegateCreator;
    protected JavaType _arrayDelegateType;
    protected SettableBeanProperty[] _constructorArguments;
    protected AnnotatedWithParams _defaultCreator;
    protected SettableBeanProperty[] _delegateArguments;
    protected AnnotatedWithParams _delegateCreator;
    protected JavaType _delegateType;
    protected AnnotatedWithParams _fromBooleanCreator;
    protected AnnotatedWithParams _fromDoubleCreator;
    protected AnnotatedWithParams _fromIntCreator;
    protected AnnotatedWithParams _fromLongCreator;
    protected AnnotatedWithParams _fromStringCreator;
    protected AnnotatedParameter _incompleteParameter;
    protected final Class<?> _valueClass;
    protected final String _valueTypeDesc;
    protected AnnotatedWithParams _withArgsCreator;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Class<?>, code=java.lang.Class, for r2v0, types: [java.lang.Class<?>, java.lang.Class] */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public StdValueInstantiator(com.fasterxml.jackson.databind.DeserializationConfig r1, java.lang.Class r2) {
        /*
            r0 = this;
            r0.<init>()
            if (r2 != 0) goto L_0x0008
            java.lang.String r1 = "UNKNOWN TYPE"
            goto L_0x000c
        L_0x0008:
            java.lang.String r1 = r2.getName()
        L_0x000c:
            r0._valueTypeDesc = r1
            if (r2 != 0) goto L_0x0012
            java.lang.Class<java.lang.Object> r2 = java.lang.Object.class
        L_0x0012:
            r0._valueClass = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.StdValueInstantiator.<init>(com.fasterxml.jackson.databind.DeserializationConfig, java.lang.Class):void");
    }

    public StdValueInstantiator(DeserializationConfig deserializationConfig, JavaType javaType) {
        String str;
        if (javaType == null) {
            str = "UNKNOWN TYPE";
        } else {
            str = javaType.toString();
        }
        this._valueTypeDesc = str;
        this._valueClass = javaType == null ? Object.class : javaType.getRawClass();
    }

    protected StdValueInstantiator(StdValueInstantiator stdValueInstantiator) {
        this._valueTypeDesc = stdValueInstantiator._valueTypeDesc;
        this._valueClass = stdValueInstantiator._valueClass;
        this._defaultCreator = stdValueInstantiator._defaultCreator;
        this._constructorArguments = stdValueInstantiator._constructorArguments;
        this._withArgsCreator = stdValueInstantiator._withArgsCreator;
        this._delegateType = stdValueInstantiator._delegateType;
        this._delegateCreator = stdValueInstantiator._delegateCreator;
        this._delegateArguments = stdValueInstantiator._delegateArguments;
        this._arrayDelegateType = stdValueInstantiator._arrayDelegateType;
        this._arrayDelegateCreator = stdValueInstantiator._arrayDelegateCreator;
        this._arrayDelegateArguments = stdValueInstantiator._arrayDelegateArguments;
        this._fromStringCreator = stdValueInstantiator._fromStringCreator;
        this._fromIntCreator = stdValueInstantiator._fromIntCreator;
        this._fromLongCreator = stdValueInstantiator._fromLongCreator;
        this._fromDoubleCreator = stdValueInstantiator._fromDoubleCreator;
        this._fromBooleanCreator = stdValueInstantiator._fromBooleanCreator;
    }

    public void configureFromObjectSettings(AnnotatedWithParams annotatedWithParams, AnnotatedWithParams annotatedWithParams2, JavaType javaType, SettableBeanProperty[] settableBeanPropertyArr, AnnotatedWithParams annotatedWithParams3, SettableBeanProperty[] settableBeanPropertyArr2) {
        this._defaultCreator = annotatedWithParams;
        this._delegateCreator = annotatedWithParams2;
        this._delegateType = javaType;
        this._delegateArguments = settableBeanPropertyArr;
        this._withArgsCreator = annotatedWithParams3;
        this._constructorArguments = settableBeanPropertyArr2;
    }

    public void configureFromArraySettings(AnnotatedWithParams annotatedWithParams, JavaType javaType, SettableBeanProperty[] settableBeanPropertyArr) {
        this._arrayDelegateCreator = annotatedWithParams;
        this._arrayDelegateType = javaType;
        this._arrayDelegateArguments = settableBeanPropertyArr;
    }

    public void configureFromStringCreator(AnnotatedWithParams annotatedWithParams) {
        this._fromStringCreator = annotatedWithParams;
    }

    public void configureFromIntCreator(AnnotatedWithParams annotatedWithParams) {
        this._fromIntCreator = annotatedWithParams;
    }

    public void configureFromLongCreator(AnnotatedWithParams annotatedWithParams) {
        this._fromLongCreator = annotatedWithParams;
    }

    public void configureFromDoubleCreator(AnnotatedWithParams annotatedWithParams) {
        this._fromDoubleCreator = annotatedWithParams;
    }

    public void configureFromBooleanCreator(AnnotatedWithParams annotatedWithParams) {
        this._fromBooleanCreator = annotatedWithParams;
    }

    public void configureIncompleteParameter(AnnotatedParameter annotatedParameter) {
        this._incompleteParameter = annotatedParameter;
    }

    public String getValueTypeDesc() {
        return this._valueTypeDesc;
    }

    public Class<?> getValueClass() {
        return this._valueClass;
    }

    public boolean canCreateFromString() {
        return this._fromStringCreator != null;
    }

    public boolean canCreateFromInt() {
        return this._fromIntCreator != null;
    }

    public boolean canCreateFromLong() {
        return this._fromLongCreator != null;
    }

    public boolean canCreateFromDouble() {
        return this._fromDoubleCreator != null;
    }

    public boolean canCreateFromBoolean() {
        return this._fromBooleanCreator != null;
    }

    public boolean canCreateUsingDefault() {
        return this._defaultCreator != null;
    }

    public boolean canCreateUsingDelegate() {
        return this._delegateType != null;
    }

    public boolean canCreateUsingArrayDelegate() {
        return this._arrayDelegateType != null;
    }

    public boolean canCreateFromObjectWith() {
        return this._withArgsCreator != null;
    }

    public boolean canInstantiate() {
        return canCreateUsingDefault() || canCreateUsingDelegate() || canCreateUsingArrayDelegate() || canCreateFromObjectWith() || canCreateFromString() || canCreateFromInt() || canCreateFromLong() || canCreateFromDouble() || canCreateFromBoolean();
    }

    public JavaType getDelegateType(DeserializationConfig deserializationConfig) {
        return this._delegateType;
    }

    public JavaType getArrayDelegateType(DeserializationConfig deserializationConfig) {
        return this._arrayDelegateType;
    }

    public SettableBeanProperty[] getFromObjectArguments(DeserializationConfig deserializationConfig) {
        return this._constructorArguments;
    }

    public Object createUsingDefault(DeserializationContext deserializationContext) throws IOException {
        if (this._defaultCreator == null) {
            return super.createUsingDefault(deserializationContext);
        }
        try {
            return this._defaultCreator.call();
        } catch (Throwable th) {
            return deserializationContext.handleInstantiationProblem(this._defaultCreator.getDeclaringClass(), null, rewrapCtorProblem(deserializationContext, th));
        }
    }

    public Object createFromObjectWith(DeserializationContext deserializationContext, Object[] objArr) throws IOException {
        if (this._withArgsCreator == null) {
            return super.createFromObjectWith(deserializationContext, objArr);
        }
        try {
            return this._withArgsCreator.call(objArr);
        } catch (Throwable th) {
            return deserializationContext.handleInstantiationProblem(this._withArgsCreator.getDeclaringClass(), objArr, rewrapCtorProblem(deserializationContext, th));
        }
    }

    public Object createUsingDelegate(DeserializationContext deserializationContext, Object obj) throws IOException {
        if (this._delegateCreator != null || this._arrayDelegateCreator == null) {
            return _createUsingDelegate(this._delegateCreator, this._delegateArguments, deserializationContext, obj);
        }
        return _createUsingDelegate(this._arrayDelegateCreator, this._arrayDelegateArguments, deserializationContext, obj);
    }

    public Object createUsingArrayDelegate(DeserializationContext deserializationContext, Object obj) throws IOException {
        if (this._arrayDelegateCreator != null || this._delegateCreator == null) {
            return _createUsingDelegate(this._arrayDelegateCreator, this._arrayDelegateArguments, deserializationContext, obj);
        }
        return createUsingDelegate(deserializationContext, obj);
    }

    public Object createFromString(DeserializationContext deserializationContext, String str) throws IOException {
        if (this._fromStringCreator == null) {
            return _createFromStringFallbacks(deserializationContext, str);
        }
        try {
            return this._fromStringCreator.call1(str);
        } catch (Throwable th) {
            return deserializationContext.handleInstantiationProblem(this._fromStringCreator.getDeclaringClass(), str, rewrapCtorProblem(deserializationContext, th));
        }
    }

    public Object createFromInt(DeserializationContext deserializationContext, int i) throws IOException {
        if (this._fromIntCreator != null) {
            Integer valueOf = Integer.valueOf(i);
            try {
                return this._fromIntCreator.call1(valueOf);
            } catch (Throwable th) {
                return deserializationContext.handleInstantiationProblem(this._fromIntCreator.getDeclaringClass(), valueOf, rewrapCtorProblem(deserializationContext, th));
            }
        } else if (this._fromLongCreator == null) {
            return super.createFromInt(deserializationContext, i);
        } else {
            Long valueOf2 = Long.valueOf((long) i);
            try {
                return this._fromLongCreator.call1(valueOf2);
            } catch (Throwable th2) {
                return deserializationContext.handleInstantiationProblem(this._fromLongCreator.getDeclaringClass(), valueOf2, rewrapCtorProblem(deserializationContext, th2));
            }
        }
    }

    public Object createFromLong(DeserializationContext deserializationContext, long j) throws IOException {
        if (this._fromLongCreator == null) {
            return super.createFromLong(deserializationContext, j);
        }
        Long valueOf = Long.valueOf(j);
        try {
            return this._fromLongCreator.call1(valueOf);
        } catch (Throwable th) {
            return deserializationContext.handleInstantiationProblem(this._fromLongCreator.getDeclaringClass(), valueOf, rewrapCtorProblem(deserializationContext, th));
        }
    }

    public Object createFromDouble(DeserializationContext deserializationContext, double d) throws IOException {
        if (this._fromDoubleCreator == null) {
            return super.createFromDouble(deserializationContext, d);
        }
        Double valueOf = Double.valueOf(d);
        try {
            return this._fromDoubleCreator.call1(valueOf);
        } catch (Throwable th) {
            return deserializationContext.handleInstantiationProblem(this._fromDoubleCreator.getDeclaringClass(), valueOf, rewrapCtorProblem(deserializationContext, th));
        }
    }

    public Object createFromBoolean(DeserializationContext deserializationContext, boolean z) throws IOException {
        if (this._fromBooleanCreator == null) {
            return super.createFromBoolean(deserializationContext, z);
        }
        Boolean valueOf = Boolean.valueOf(z);
        try {
            return this._fromBooleanCreator.call1(valueOf);
        } catch (Throwable th) {
            return deserializationContext.handleInstantiationProblem(this._fromBooleanCreator.getDeclaringClass(), valueOf, rewrapCtorProblem(deserializationContext, th));
        }
    }

    public AnnotatedWithParams getDelegateCreator() {
        return this._delegateCreator;
    }

    public AnnotatedWithParams getArrayDelegateCreator() {
        return this._arrayDelegateCreator;
    }

    public AnnotatedWithParams getDefaultCreator() {
        return this._defaultCreator;
    }

    public AnnotatedWithParams getWithArgsCreator() {
        return this._withArgsCreator;
    }

    public AnnotatedParameter getIncompleteParameter() {
        return this._incompleteParameter;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public JsonMappingException wrapException(Throwable th) {
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof JsonMappingException) {
                return (JsonMappingException) th2;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Instantiation of ");
        sb.append(getValueTypeDesc());
        sb.append(" value failed: ");
        sb.append(th.getMessage());
        return new JsonMappingException((Closeable) null, sb.toString(), th);
    }

    /* access modifiers changed from: protected */
    public JsonMappingException unwrapAndWrapException(DeserializationContext deserializationContext, Throwable th) {
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof JsonMappingException) {
                return (JsonMappingException) th2;
            }
        }
        return deserializationContext.instantiationException(getValueClass(), th);
    }

    /* access modifiers changed from: protected */
    public JsonMappingException wrapAsJsonMappingException(DeserializationContext deserializationContext, Throwable th) {
        if (th instanceof JsonMappingException) {
            return (JsonMappingException) th;
        }
        return deserializationContext.instantiationException(getValueClass(), th);
    }

    /* access modifiers changed from: protected */
    public JsonMappingException rewrapCtorProblem(DeserializationContext deserializationContext, Throwable th) {
        if ((th instanceof ExceptionInInitializerError) || (th instanceof InvocationTargetException)) {
            Throwable cause = th.getCause();
            if (cause != null) {
                th = cause;
            }
        }
        return wrapAsJsonMappingException(deserializationContext, th);
    }

    private Object _createUsingDelegate(AnnotatedWithParams annotatedWithParams, SettableBeanProperty[] settableBeanPropertyArr, DeserializationContext deserializationContext, Object obj) throws IOException {
        if (annotatedWithParams == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("No delegate constructor for ");
            sb.append(getValueTypeDesc());
            throw new IllegalStateException(sb.toString());
        } else if (settableBeanPropertyArr == null) {
            try {
                return annotatedWithParams.call1(obj);
            } catch (Throwable th) {
                throw rewrapCtorProblem(deserializationContext, th);
            }
        } else {
            int length = settableBeanPropertyArr.length;
            Object[] objArr = new Object[length];
            for (int i = 0; i < length; i++) {
                SettableBeanProperty settableBeanProperty = settableBeanPropertyArr[i];
                if (settableBeanProperty == null) {
                    objArr[i] = obj;
                } else {
                    objArr[i] = deserializationContext.findInjectableValue(settableBeanProperty.getInjectableValueId(), settableBeanProperty, null);
                }
            }
            return annotatedWithParams.call(objArr);
        }
    }
}

package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public abstract class ContainerDeserializerBase<T> extends StdDeserializer<T> {
    public abstract JsonDeserializer<Object> getContentDeserializer();

    public abstract JavaType getContentType();

    protected ContainerDeserializerBase(JavaType javaType) {
        super(javaType);
    }

    public SettableBeanProperty findBackReference(String str) {
        JsonDeserializer contentDeserializer = getContentDeserializer();
        if (contentDeserializer != null) {
            return contentDeserializer.findBackReference(str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can not handle managed/back reference '");
        sb.append(str);
        sb.append("': type: container deserializer of type ");
        sb.append(getClass().getName());
        sb.append(" returned null for 'getContentDeserializer()'");
        throw new IllegalArgumentException(sb.toString());
    }

    /* access modifiers changed from: protected */
    public void wrapAndThrow(Throwable th, Object obj, String str) throws IOException {
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        if (th instanceof Error) {
            throw ((Error) th);
        } else if (!(th instanceof IOException) || (th instanceof JsonMappingException)) {
            if (str == null) {
                str = "N/A";
            }
            throw JsonMappingException.wrapWithPath(th, obj, str);
        } else {
            throw ((IOException) th);
        }
    }
}

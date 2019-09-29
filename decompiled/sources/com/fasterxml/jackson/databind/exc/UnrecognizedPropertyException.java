package com.fasterxml.jackson.databind.exc;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import java.util.Collection;

public class UnrecognizedPropertyException extends PropertyBindingException {
    private static final long serialVersionUID = 1;

    public UnrecognizedPropertyException(JsonParser jsonParser, String str, JsonLocation jsonLocation, Class<?> cls, String str2, Collection<Object> collection) {
        super(jsonParser, str, jsonLocation, cls, str2, collection);
    }

    @Deprecated
    public UnrecognizedPropertyException(String str, JsonLocation jsonLocation, Class<?> cls, String str2, Collection<Object> collection) {
        super(str, jsonLocation, cls, str2, collection);
    }

    public static UnrecognizedPropertyException from(JsonParser jsonParser, Object obj, String str, Collection<Object> collection) {
        Class cls;
        if (obj != null) {
            if (obj instanceof Class) {
                cls = (Class) obj;
            } else {
                cls = obj.getClass();
            }
            Class cls2 = cls;
            StringBuilder sb = new StringBuilder();
            sb.append("Unrecognized field \"");
            sb.append(str);
            sb.append("\" (class ");
            sb.append(cls2.getName());
            sb.append("), not marked as ignorable");
            UnrecognizedPropertyException unrecognizedPropertyException = new UnrecognizedPropertyException(jsonParser, sb.toString(), jsonParser.getCurrentLocation(), cls2, str, collection);
            unrecognizedPropertyException.prependPath(obj, str);
            return unrecognizedPropertyException;
        }
        throw new IllegalArgumentException();
    }
}

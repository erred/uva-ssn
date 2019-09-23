package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.ser.Serializers;
import java.io.Serializable;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class OptionalHandlerFactory implements Serializable {
    private static final Class<?> CLASS_DOM_DOCUMENT;
    private static final Class<?> CLASS_DOM_NODE = Node.class;
    private static final String DESERIALIZERS_FOR_JAVAX_XML = "com.fasterxml.jackson.databind.ext.CoreXMLDeserializers";
    private static final String DESERIALIZER_FOR_DOM_DOCUMENT = "com.fasterxml.jackson.databind.ext.DOMDeserializer$DocumentDeserializer";
    private static final String DESERIALIZER_FOR_DOM_NODE = "com.fasterxml.jackson.databind.ext.DOMDeserializer$NodeDeserializer";
    private static final String PACKAGE_PREFIX_JAVAX_XML = "javax.xml.";
    private static final String SERIALIZERS_FOR_JAVAX_XML = "com.fasterxml.jackson.databind.ext.CoreXMLSerializers";
    private static final String SERIALIZER_FOR_DOM_NODE = "com.fasterxml.jackson.databind.ext.DOMSerializer";
    private static final Java7Support _jdk7Helper;
    public static final OptionalHandlerFactory instance = new OptionalHandlerFactory();
    private static final long serialVersionUID = 1;

    static {
        Java7Support java7Support = null;
        Class<Document> cls = Document.class;
        CLASS_DOM_DOCUMENT = cls;
        try {
            java7Support = Java7Support.instance();
        } catch (Throwable unused) {
        }
        _jdk7Helper = java7Support;
    }

    protected OptionalHandlerFactory() {
    }

    public JsonSerializer<?> findSerializer(SerializationConfig serializationConfig, JavaType javaType, BeanDescription beanDescription) {
        Class rawClass = javaType.getRawClass();
        if (_jdk7Helper != null) {
            JsonSerializer<?> serializerForJavaNioFilePath = _jdk7Helper.getSerializerForJavaNioFilePath(rawClass);
            if (serializerForJavaNioFilePath != null) {
                return serializerForJavaNioFilePath;
            }
        }
        if (CLASS_DOM_NODE != null && CLASS_DOM_NODE.isAssignableFrom(rawClass)) {
            return (JsonSerializer) instantiate(SERIALIZER_FOR_DOM_NODE);
        }
        if (!rawClass.getName().startsWith(PACKAGE_PREFIX_JAVAX_XML) && !hasSuperClassStartingWith(rawClass, PACKAGE_PREFIX_JAVAX_XML)) {
            return null;
        }
        Object instantiate = instantiate(SERIALIZERS_FOR_JAVAX_XML);
        if (instantiate == null) {
            return null;
        }
        return ((Serializers) instantiate).findSerializer(serializationConfig, javaType, beanDescription);
    }

    public JsonDeserializer<?> findDeserializer(JavaType javaType, DeserializationConfig deserializationConfig, BeanDescription beanDescription) throws JsonMappingException {
        Class rawClass = javaType.getRawClass();
        if (_jdk7Helper != null) {
            JsonDeserializer<?> deserializerForJavaNioFilePath = _jdk7Helper.getDeserializerForJavaNioFilePath(rawClass);
            if (deserializerForJavaNioFilePath != null) {
                return deserializerForJavaNioFilePath;
            }
        }
        if (CLASS_DOM_NODE != null && CLASS_DOM_NODE.isAssignableFrom(rawClass)) {
            return (JsonDeserializer) instantiate(DESERIALIZER_FOR_DOM_NODE);
        }
        if (CLASS_DOM_DOCUMENT != null && CLASS_DOM_DOCUMENT.isAssignableFrom(rawClass)) {
            return (JsonDeserializer) instantiate(DESERIALIZER_FOR_DOM_DOCUMENT);
        }
        if (!rawClass.getName().startsWith(PACKAGE_PREFIX_JAVAX_XML) && !hasSuperClassStartingWith(rawClass, PACKAGE_PREFIX_JAVAX_XML)) {
            return null;
        }
        Object instantiate = instantiate(DESERIALIZERS_FOR_JAVAX_XML);
        if (instantiate == null) {
            return null;
        }
        return ((Deserializers) instantiate).findBeanDeserializer(javaType, deserializationConfig, beanDescription);
    }

    private Object instantiate(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Exception | LinkageError unused) {
            return null;
        }
    }

    private boolean hasSuperClassStartingWith(Class<?> cls, String str) {
        do {
            cls = cls.getSuperclass();
            if (cls == null || cls == Object.class) {
                return false;
            }
        } while (!cls.getName().startsWith(str));
        return true;
    }
}

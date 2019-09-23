package com.google.api.client.http;

import com.google.api.client.util.ArrayValueMap;
import com.google.api.client.util.Charsets;
import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.Data;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Throwables;
import com.google.api.client.util.Types;
import com.google.api.client.util.escape.CharEscapers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class UrlEncodedParser implements ObjectParser {
    public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
    public static final String MEDIA_TYPE = new HttpMediaType(CONTENT_TYPE).setCharsetParameter(Charsets.UTF_8).build();

    public static void parse(String str, Object obj) {
        if (str != null) {
            try {
                parse((Reader) new StringReader(str), obj);
            } catch (IOException e) {
                throw Throwables.propagate(e);
            }
        }
    }

    public static void parse(Reader reader, Object obj) throws IOException {
        int read;
        Object obj2 = obj;
        Class cls = obj.getClass();
        ClassInfo of = ClassInfo.m8627of(cls);
        List asList = Arrays.asList(new Type[]{cls});
        GenericData genericData = GenericData.class.isAssignableFrom(cls) ? (GenericData) obj2 : null;
        Map map = Map.class.isAssignableFrom(cls) ? (Map) obj2 : null;
        ArrayValueMap arrayValueMap = new ArrayValueMap(obj2);
        StringWriter stringWriter = new StringWriter();
        StringWriter stringWriter2 = new StringWriter();
        do {
            StringWriter stringWriter3 = stringWriter2;
            StringWriter stringWriter4 = stringWriter;
            boolean z = true;
            while (true) {
                read = reader.read();
                if (read == -1 || read == 38) {
                    String decodeUri = CharEscapers.decodeUri(stringWriter4.toString());
                } else if (read == 61) {
                    z = false;
                } else if (z) {
                    stringWriter4.write(read);
                } else {
                    stringWriter3.write(read);
                }
            }
            String decodeUri2 = CharEscapers.decodeUri(stringWriter4.toString());
            if (decodeUri2.length() != 0) {
                String decodeUri3 = CharEscapers.decodeUri(stringWriter3.toString());
                FieldInfo fieldInfo = of.getFieldInfo(decodeUri2);
                if (fieldInfo != null) {
                    Type resolveWildcardTypeOrTypeVariable = Data.resolveWildcardTypeOrTypeVariable(asList, fieldInfo.getGenericType());
                    if (Types.isArray(resolveWildcardTypeOrTypeVariable)) {
                        Class rawArrayComponentType = Types.getRawArrayComponentType(asList, Types.getArrayComponentType(resolveWildcardTypeOrTypeVariable));
                        arrayValueMap.put(fieldInfo.getField(), rawArrayComponentType, parseValue(rawArrayComponentType, asList, decodeUri3));
                    } else if (Types.isAssignableToOrFrom(Types.getRawArrayComponentType(asList, resolveWildcardTypeOrTypeVariable), Iterable.class)) {
                        Collection collection = (Collection) fieldInfo.getValue(obj2);
                        if (collection == null) {
                            collection = Data.newCollectionInstance(resolveWildcardTypeOrTypeVariable);
                            fieldInfo.setValue(obj2, collection);
                        }
                        collection.add(parseValue(resolveWildcardTypeOrTypeVariable == Object.class ? null : Types.getIterableParameter(resolveWildcardTypeOrTypeVariable), asList, decodeUri3));
                    } else {
                        fieldInfo.setValue(obj2, parseValue(resolveWildcardTypeOrTypeVariable, asList, decodeUri3));
                    }
                } else if (map != null) {
                    ArrayList arrayList = (ArrayList) map.get(decodeUri2);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        if (genericData != null) {
                            genericData.set(decodeUri2, arrayList);
                        } else {
                            map.put(decodeUri2, arrayList);
                        }
                    }
                    arrayList.add(decodeUri3);
                }
            }
            stringWriter = new StringWriter();
            stringWriter2 = new StringWriter();
        } while (read != -1);
        arrayValueMap.setValues();
    }

    private static Object parseValue(Type type, List<Type> list, String str) {
        return Data.parsePrimitiveValue(Data.resolveWildcardTypeOrTypeVariable(list, type), str);
    }

    public <T> T parseAndClose(InputStream inputStream, Charset charset, Class<T> cls) throws IOException {
        return parseAndClose((Reader) new InputStreamReader(inputStream, charset), cls);
    }

    public Object parseAndClose(InputStream inputStream, Charset charset, Type type) throws IOException {
        return parseAndClose((Reader) new InputStreamReader(inputStream, charset), type);
    }

    public <T> T parseAndClose(Reader reader, Class<T> cls) throws IOException {
        return parseAndClose(reader, (Type) cls);
    }

    public Object parseAndClose(Reader reader, Type type) throws IOException {
        Preconditions.checkArgument(type instanceof Class, "dataType has to be of type Class<?>");
        Object newInstance = Types.newInstance((Class) type);
        parse((Reader) new BufferedReader(reader), newInstance);
        return newInstance;
    }
}

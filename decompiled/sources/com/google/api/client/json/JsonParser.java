package com.google.api.client.json;

import com.google.api.client.json.JsonPolymorphicTypeMap.TypeDef;
import com.google.api.client.util.Beta;
import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.Data;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sets;
import com.google.api.client.util.Types;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class JsonParser {
    private static WeakHashMap<Class<?>, Field> cachedTypemapFields = new WeakHashMap<>();
    private static final Lock lock = new ReentrantLock();

    public abstract void close() throws IOException;

    public abstract BigInteger getBigIntegerValue() throws IOException;

    public abstract byte getByteValue() throws IOException;

    public abstract String getCurrentName() throws IOException;

    public abstract JsonToken getCurrentToken();

    public abstract BigDecimal getDecimalValue() throws IOException;

    public abstract double getDoubleValue() throws IOException;

    public abstract JsonFactory getFactory();

    public abstract float getFloatValue() throws IOException;

    public abstract int getIntValue() throws IOException;

    public abstract long getLongValue() throws IOException;

    public abstract short getShortValue() throws IOException;

    public abstract String getText() throws IOException;

    public abstract JsonToken nextToken() throws IOException;

    public abstract JsonParser skipChildren() throws IOException;

    public final <T> T parseAndClose(Class<T> cls) throws IOException {
        return parseAndClose(cls, (CustomizeJsonParser) null);
    }

    @Beta
    public final <T> T parseAndClose(Class<T> cls, CustomizeJsonParser customizeJsonParser) throws IOException {
        try {
            return parse(cls, customizeJsonParser);
        } finally {
            close();
        }
    }

    public final void skipToKey(String str) throws IOException {
        skipToKey(Collections.singleton(str));
    }

    public final String skipToKey(Set<String> set) throws IOException {
        JsonToken startParsingObjectOrArray = startParsingObjectOrArray();
        while (startParsingObjectOrArray == JsonToken.FIELD_NAME) {
            String text = getText();
            nextToken();
            if (set.contains(text)) {
                return text;
            }
            skipChildren();
            startParsingObjectOrArray = nextToken();
        }
        return null;
    }

    private JsonToken startParsing() throws IOException {
        JsonToken currentToken = getCurrentToken();
        if (currentToken == null) {
            currentToken = nextToken();
        }
        Preconditions.checkArgument(currentToken != null, "no JSON input found");
        return currentToken;
    }

    private JsonToken startParsingObjectOrArray() throws IOException {
        JsonToken startParsing = startParsing();
        switch (startParsing) {
            case START_OBJECT:
                JsonToken nextToken = nextToken();
                Preconditions.checkArgument(nextToken == JsonToken.FIELD_NAME || nextToken == JsonToken.END_OBJECT, nextToken);
                return nextToken;
            case START_ARRAY:
                return nextToken();
            default:
                return startParsing;
        }
    }

    public final void parseAndClose(Object obj) throws IOException {
        parseAndClose(obj, (CustomizeJsonParser) null);
    }

    @Beta
    public final void parseAndClose(Object obj, CustomizeJsonParser customizeJsonParser) throws IOException {
        try {
            parse(obj, customizeJsonParser);
        } finally {
            close();
        }
    }

    public final <T> T parse(Class<T> cls) throws IOException {
        return parse(cls, (CustomizeJsonParser) null);
    }

    @Beta
    public final <T> T parse(Class<T> cls, CustomizeJsonParser customizeJsonParser) throws IOException {
        return parse((Type) cls, false, customizeJsonParser);
    }

    public Object parse(Type type, boolean z) throws IOException {
        return parse(type, z, (CustomizeJsonParser) null);
    }

    @Beta
    public Object parse(Type type, boolean z, CustomizeJsonParser customizeJsonParser) throws IOException {
        try {
            if (!Void.class.equals(type)) {
                startParsing();
            }
            return parseValue(null, type, new ArrayList(), null, customizeJsonParser, true);
        } finally {
            if (z) {
                close();
            }
        }
    }

    public final void parse(Object obj) throws IOException {
        parse(obj, (CustomizeJsonParser) null);
    }

    @Beta
    public final void parse(Object obj, CustomizeJsonParser customizeJsonParser) throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(obj.getClass());
        parse(arrayList, obj, customizeJsonParser);
    }

    private void parse(ArrayList<Type> arrayList, Object obj, CustomizeJsonParser customizeJsonParser) throws IOException {
        if (obj instanceof GenericJson) {
            ((GenericJson) obj).setFactory(getFactory());
        }
        JsonToken startParsingObjectOrArray = startParsingObjectOrArray();
        Class cls = obj.getClass();
        ClassInfo of = ClassInfo.m8627of(cls);
        boolean isAssignableFrom = GenericData.class.isAssignableFrom(cls);
        if (isAssignableFrom || !Map.class.isAssignableFrom(cls)) {
            while (startParsingObjectOrArray == JsonToken.FIELD_NAME) {
                String text = getText();
                nextToken();
                if (customizeJsonParser == null || !customizeJsonParser.stopAt(obj, text)) {
                    FieldInfo fieldInfo = of.getFieldInfo(text);
                    if (fieldInfo != null) {
                        if (!fieldInfo.isFinal() || fieldInfo.isPrimitive()) {
                            Field field = fieldInfo.getField();
                            int size = arrayList.size();
                            arrayList.add(field.getGenericType());
                            Object parseValue = parseValue(field, fieldInfo.getGenericType(), arrayList, obj, customizeJsonParser, true);
                            arrayList.remove(size);
                            fieldInfo.setValue(obj, parseValue);
                        } else {
                            throw new IllegalArgumentException("final array/object fields are not supported");
                        }
                    } else if (isAssignableFrom) {
                        ((GenericData) obj).set(text, parseValue(null, null, arrayList, obj, customizeJsonParser, true));
                    } else {
                        if (customizeJsonParser != null) {
                            customizeJsonParser.handleUnrecognizedKey(obj, text);
                        }
                        skipChildren();
                    }
                    startParsingObjectOrArray = nextToken();
                } else {
                    return;
                }
            }
            return;
        }
        parseMap(null, (Map) obj, Types.getMapValueParameter(cls), arrayList, customizeJsonParser);
    }

    public final <T> Collection<T> parseArrayAndClose(Class<?> cls, Class<T> cls2) throws IOException {
        return parseArrayAndClose(cls, cls2, (CustomizeJsonParser) null);
    }

    @Beta
    public final <T> Collection<T> parseArrayAndClose(Class<?> cls, Class<T> cls2, CustomizeJsonParser customizeJsonParser) throws IOException {
        try {
            return parseArray(cls, cls2, customizeJsonParser);
        } finally {
            close();
        }
    }

    public final <T> void parseArrayAndClose(Collection<? super T> collection, Class<T> cls) throws IOException {
        parseArrayAndClose(collection, cls, (CustomizeJsonParser) null);
    }

    @Beta
    public final <T> void parseArrayAndClose(Collection<? super T> collection, Class<T> cls, CustomizeJsonParser customizeJsonParser) throws IOException {
        try {
            parseArray(collection, cls, customizeJsonParser);
        } finally {
            close();
        }
    }

    public final <T> Collection<T> parseArray(Class<?> cls, Class<T> cls2) throws IOException {
        return parseArray(cls, cls2, (CustomizeJsonParser) null);
    }

    @Beta
    public final <T> Collection<T> parseArray(Class<?> cls, Class<T> cls2, CustomizeJsonParser customizeJsonParser) throws IOException {
        Collection<T> newCollectionInstance = Data.newCollectionInstance(cls);
        parseArray(newCollectionInstance, cls2, customizeJsonParser);
        return newCollectionInstance;
    }

    public final <T> void parseArray(Collection<? super T> collection, Class<T> cls) throws IOException {
        parseArray(collection, cls, (CustomizeJsonParser) null);
    }

    @Beta
    public final <T> void parseArray(Collection<? super T> collection, Class<T> cls, CustomizeJsonParser customizeJsonParser) throws IOException {
        parseArray(null, collection, cls, new ArrayList(), customizeJsonParser);
    }

    private <T> void parseArray(Field field, Collection<T> collection, Type type, ArrayList<Type> arrayList, CustomizeJsonParser customizeJsonParser) throws IOException {
        JsonToken startParsingObjectOrArray = startParsingObjectOrArray();
        while (startParsingObjectOrArray != JsonToken.END_ARRAY) {
            collection.add(parseValue(field, type, arrayList, collection, customizeJsonParser, true));
            startParsingObjectOrArray = nextToken();
        }
    }

    private void parseMap(Field field, Map<String, Object> map, Type type, ArrayList<Type> arrayList, CustomizeJsonParser customizeJsonParser) throws IOException {
        JsonToken startParsingObjectOrArray = startParsingObjectOrArray();
        while (startParsingObjectOrArray == JsonToken.FIELD_NAME) {
            String text = getText();
            nextToken();
            if (customizeJsonParser == null || !customizeJsonParser.stopAt(map, text)) {
                map.put(text, parseValue(field, type, arrayList, map, customizeJsonParser, true));
                startParsingObjectOrArray = nextToken();
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:128:0x01bc A[Catch:{ IllegalArgumentException -> 0x0335 }] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x01bf A[Catch:{ IllegalArgumentException -> 0x0335 }] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x01ed A[Catch:{ IllegalArgumentException -> 0x0335 }] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01f3 A[Catch:{ IllegalArgumentException -> 0x0335 }] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01f8 A[ADDED_TO_REGION, Catch:{ IllegalArgumentException -> 0x0335 }] */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0215 A[Catch:{ IllegalArgumentException -> 0x0335 }] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x021e A[Catch:{ IllegalArgumentException -> 0x0335 }, RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object parseValue(java.lang.reflect.Field r8, java.lang.reflect.Type r9, java.util.ArrayList<java.lang.reflect.Type> r10, java.lang.Object r11, com.google.api.client.json.CustomizeJsonParser r12, boolean r13) throws java.io.IOException {
        /*
            r7 = this;
            java.lang.reflect.Type r9 = com.google.api.client.util.Data.resolveWildcardTypeOrTypeVariable(r10, r9)
            boolean r0 = r9 instanceof java.lang.Class
            r1 = 0
            if (r0 == 0) goto L_0x000d
            r0 = r9
            java.lang.Class r0 = (java.lang.Class) r0
            goto L_0x000e
        L_0x000d:
            r0 = r1
        L_0x000e:
            boolean r2 = r9 instanceof java.lang.reflect.ParameterizedType
            if (r2 == 0) goto L_0x0019
            r0 = r9
            java.lang.reflect.ParameterizedType r0 = (java.lang.reflect.ParameterizedType) r0
            java.lang.Class r0 = com.google.api.client.util.Types.getRawClass(r0)
        L_0x0019:
            java.lang.Class<java.lang.Void> r2 = java.lang.Void.class
            if (r0 != r2) goto L_0x0021
            r7.skipChildren()
            return r1
        L_0x0021:
            com.google.api.client.json.JsonToken r2 = r7.getCurrentToken()
            int[] r3 = com.google.api.client.json.JsonParser.C22771.$SwitchMap$com$google$api$client$json$JsonToken     // Catch:{ IllegalArgumentException -> 0x0335 }
            com.google.api.client.json.JsonToken r4 = r7.getCurrentToken()     // Catch:{ IllegalArgumentException -> 0x0335 }
            int r4 = r4.ordinal()     // Catch:{ IllegalArgumentException -> 0x0335 }
            r3 = r3[r4]     // Catch:{ IllegalArgumentException -> 0x0335 }
            r4 = 0
            r5 = 1
            switch(r3) {
                case 1: goto L_0x021f;
                case 2: goto L_0x01c2;
                case 3: goto L_0x01c2;
                case 4: goto L_0x021f;
                case 5: goto L_0x021f;
                case 6: goto L_0x019b;
                case 7: goto L_0x019b;
                case 8: goto L_0x00de;
                case 9: goto L_0x00de;
                case 10: goto L_0x0085;
                case 11: goto L_0x003a;
                default: goto L_0x0036;
            }     // Catch:{ IllegalArgumentException -> 0x0335 }
        L_0x0036:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0335 }
            goto L_0x0312
        L_0x003a:
            if (r0 == 0) goto L_0x0042
            boolean r11 = r0.isPrimitive()     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r11 != 0) goto L_0x0043
        L_0x0042:
            r4 = 1
        L_0x0043:
            java.lang.String r11 = "primitive number field but found a JSON null"
            com.google.api.client.util.Preconditions.checkArgument(r4, r11)     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r0 == 0) goto L_0x007c
            int r11 = r0.getModifiers()     // Catch:{ IllegalArgumentException -> 0x0335 }
            r11 = r11 & 1536(0x600, float:2.152E-42)
            if (r11 == 0) goto L_0x007c
            java.lang.Class<java.util.Collection> r11 = java.util.Collection.class
            boolean r11 = com.google.api.client.util.Types.isAssignableToOrFrom(r0, r11)     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r11 == 0) goto L_0x0067
            java.util.Collection r9 = com.google.api.client.util.Data.newCollectionInstance(r9)     // Catch:{ IllegalArgumentException -> 0x0335 }
            java.lang.Class r9 = r9.getClass()     // Catch:{ IllegalArgumentException -> 0x0335 }
            java.lang.Object r9 = com.google.api.client.util.Data.nullOf(r9)     // Catch:{ IllegalArgumentException -> 0x0335 }
            return r9
        L_0x0067:
            java.lang.Class<java.util.Map> r11 = java.util.Map.class
            boolean r11 = com.google.api.client.util.Types.isAssignableToOrFrom(r0, r11)     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r11 == 0) goto L_0x007c
            java.util.Map r9 = com.google.api.client.util.Data.newMapInstance(r0)     // Catch:{ IllegalArgumentException -> 0x0335 }
            java.lang.Class r9 = r9.getClass()     // Catch:{ IllegalArgumentException -> 0x0335 }
            java.lang.Object r9 = com.google.api.client.util.Data.nullOf(r9)     // Catch:{ IllegalArgumentException -> 0x0335 }
            return r9
        L_0x007c:
            java.lang.Class r9 = com.google.api.client.util.Types.getRawArrayComponentType(r10, r9)     // Catch:{ IllegalArgumentException -> 0x0335 }
            java.lang.Object r9 = com.google.api.client.util.Data.nullOf(r9)     // Catch:{ IllegalArgumentException -> 0x0335 }
            return r9
        L_0x0085:
            java.lang.String r10 = r7.getText()     // Catch:{ IllegalArgumentException -> 0x0335 }
            java.lang.String r10 = r10.trim()     // Catch:{ IllegalArgumentException -> 0x0335 }
            java.util.Locale r11 = java.util.Locale.US     // Catch:{ IllegalArgumentException -> 0x0335 }
            java.lang.String r10 = r10.toLowerCase(r11)     // Catch:{ IllegalArgumentException -> 0x0335 }
            java.lang.Class r11 = java.lang.Float.TYPE     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r0 == r11) goto L_0x00a3
            java.lang.Class<java.lang.Float> r11 = java.lang.Float.class
            if (r0 == r11) goto L_0x00a3
            java.lang.Class r11 = java.lang.Double.TYPE     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r0 == r11) goto L_0x00a3
            java.lang.Class<java.lang.Double> r11 = java.lang.Double.class
            if (r0 != r11) goto L_0x00bb
        L_0x00a3:
            java.lang.String r11 = "nan"
            boolean r11 = r10.equals(r11)     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r11 != 0) goto L_0x00d5
            java.lang.String r11 = "infinity"
            boolean r11 = r10.equals(r11)     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r11 != 0) goto L_0x00d5
            java.lang.String r11 = "-infinity"
            boolean r10 = r10.equals(r11)     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r10 != 0) goto L_0x00d5
        L_0x00bb:
            if (r0 == 0) goto L_0x00cf
            java.lang.Class<java.lang.Number> r10 = java.lang.Number.class
            boolean r10 = r10.isAssignableFrom(r0)     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r10 == 0) goto L_0x00cf
            if (r8 == 0) goto L_0x00d0
            java.lang.Class<com.google.api.client.json.JsonString> r10 = com.google.api.client.json.JsonString.class
            java.lang.annotation.Annotation r10 = r8.getAnnotation(r10)     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r10 == 0) goto L_0x00d0
        L_0x00cf:
            r4 = 1
        L_0x00d0:
            java.lang.String r10 = "number field formatted as a JSON string must use the @JsonString annotation"
            com.google.api.client.util.Preconditions.checkArgument(r4, r10)     // Catch:{ IllegalArgumentException -> 0x0335 }
        L_0x00d5:
            java.lang.String r10 = r7.getText()     // Catch:{ IllegalArgumentException -> 0x0335 }
            java.lang.Object r9 = com.google.api.client.util.Data.parsePrimitiveValue(r9, r10)     // Catch:{ IllegalArgumentException -> 0x0335 }
            return r9
        L_0x00de:
            if (r8 == 0) goto L_0x00e8
            java.lang.Class<com.google.api.client.json.JsonString> r10 = com.google.api.client.json.JsonString.class
            java.lang.annotation.Annotation r10 = r8.getAnnotation(r10)     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r10 != 0) goto L_0x00e9
        L_0x00e8:
            r4 = 1
        L_0x00e9:
            java.lang.String r10 = "number type formatted as a JSON number cannot use @JsonString annotation"
            com.google.api.client.util.Preconditions.checkArgument(r4, r10)     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r0 == 0) goto L_0x0196
            java.lang.Class<java.math.BigDecimal> r10 = java.math.BigDecimal.class
            boolean r10 = r0.isAssignableFrom(r10)     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r10 == 0) goto L_0x00fa
            goto L_0x0196
        L_0x00fa:
            java.lang.Class<java.math.BigInteger> r10 = java.math.BigInteger.class
            if (r0 != r10) goto L_0x0103
            java.math.BigInteger r9 = r7.getBigIntegerValue()     // Catch:{ IllegalArgumentException -> 0x0335 }
            return r9
        L_0x0103:
            java.lang.Class<java.lang.Double> r10 = java.lang.Double.class
            if (r0 == r10) goto L_0x018d
            java.lang.Class r10 = java.lang.Double.TYPE     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r0 != r10) goto L_0x010d
            goto L_0x018d
        L_0x010d:
            java.lang.Class<java.lang.Long> r10 = java.lang.Long.class
            if (r0 == r10) goto L_0x0184
            java.lang.Class r10 = java.lang.Long.TYPE     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r0 != r10) goto L_0x0117
            goto L_0x0184
        L_0x0117:
            java.lang.Class<java.lang.Float> r10 = java.lang.Float.class
            if (r0 == r10) goto L_0x017b
            java.lang.Class r10 = java.lang.Float.TYPE     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r0 != r10) goto L_0x0120
            goto L_0x017b
        L_0x0120:
            java.lang.Class<java.lang.Integer> r10 = java.lang.Integer.class
            if (r0 == r10) goto L_0x0172
            java.lang.Class r10 = java.lang.Integer.TYPE     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r0 != r10) goto L_0x0129
            goto L_0x0172
        L_0x0129:
            java.lang.Class<java.lang.Short> r10 = java.lang.Short.class
            if (r0 == r10) goto L_0x0169
            java.lang.Class r10 = java.lang.Short.TYPE     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r0 != r10) goto L_0x0132
            goto L_0x0169
        L_0x0132:
            java.lang.Class<java.lang.Byte> r10 = java.lang.Byte.class
            if (r0 == r10) goto L_0x0160
            java.lang.Class r10 = java.lang.Byte.TYPE     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r0 != r10) goto L_0x013b
            goto L_0x0160
        L_0x013b:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0335 }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ IllegalArgumentException -> 0x0335 }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ IllegalArgumentException -> 0x0335 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x0335 }
            int r12 = r9.length()     // Catch:{ IllegalArgumentException -> 0x0335 }
            int r12 = r12 + 30
            r11.<init>(r12)     // Catch:{ IllegalArgumentException -> 0x0335 }
            java.lang.String r12 = "expected numeric type but got "
            r11.append(r12)     // Catch:{ IllegalArgumentException -> 0x0335 }
            r11.append(r9)     // Catch:{ IllegalArgumentException -> 0x0335 }
            java.lang.String r9 = r11.toString()     // Catch:{ IllegalArgumentException -> 0x0335 }
            r10.<init>(r9)     // Catch:{ IllegalArgumentException -> 0x0335 }
            throw r10     // Catch:{ IllegalArgumentException -> 0x0335 }
        L_0x0160:
            byte r9 = r7.getByteValue()     // Catch:{ IllegalArgumentException -> 0x0335 }
            java.lang.Byte r9 = java.lang.Byte.valueOf(r9)     // Catch:{ IllegalArgumentException -> 0x0335 }
            return r9
        L_0x0169:
            short r9 = r7.getShortValue()     // Catch:{ IllegalArgumentException -> 0x0335 }
            java.lang.Short r9 = java.lang.Short.valueOf(r9)     // Catch:{ IllegalArgumentException -> 0x0335 }
            return r9
        L_0x0172:
            int r9 = r7.getIntValue()     // Catch:{ IllegalArgumentException -> 0x0335 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ IllegalArgumentException -> 0x0335 }
            return r9
        L_0x017b:
            float r9 = r7.getFloatValue()     // Catch:{ IllegalArgumentException -> 0x0335 }
            java.lang.Float r9 = java.lang.Float.valueOf(r9)     // Catch:{ IllegalArgumentException -> 0x0335 }
            return r9
        L_0x0184:
            long r9 = r7.getLongValue()     // Catch:{ IllegalArgumentException -> 0x0335 }
            java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch:{ IllegalArgumentException -> 0x0335 }
            return r9
        L_0x018d:
            double r9 = r7.getDoubleValue()     // Catch:{ IllegalArgumentException -> 0x0335 }
            java.lang.Double r9 = java.lang.Double.valueOf(r9)     // Catch:{ IllegalArgumentException -> 0x0335 }
            return r9
        L_0x0196:
            java.math.BigDecimal r9 = r7.getDecimalValue()     // Catch:{ IllegalArgumentException -> 0x0335 }
            return r9
        L_0x019b:
            if (r9 == 0) goto L_0x01ae
            java.lang.Class r10 = java.lang.Boolean.TYPE     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r0 == r10) goto L_0x01ae
            if (r0 == 0) goto L_0x01ac
            java.lang.Class<java.lang.Boolean> r10 = java.lang.Boolean.class
            boolean r10 = r0.isAssignableFrom(r10)     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r10 == 0) goto L_0x01ac
            goto L_0x01ae
        L_0x01ac:
            r10 = 0
            goto L_0x01af
        L_0x01ae:
            r10 = 1
        L_0x01af:
            java.lang.String r11 = "expected type Boolean or boolean but got %s"
            java.lang.Object[] r12 = new java.lang.Object[r5]     // Catch:{ IllegalArgumentException -> 0x0335 }
            r12[r4] = r9     // Catch:{ IllegalArgumentException -> 0x0335 }
            com.google.api.client.util.Preconditions.checkArgument(r10, r11, r12)     // Catch:{ IllegalArgumentException -> 0x0335 }
            com.google.api.client.json.JsonToken r9 = com.google.api.client.json.JsonToken.VALUE_TRUE     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r2 != r9) goto L_0x01bf
            java.lang.Boolean r9 = java.lang.Boolean.TRUE     // Catch:{ IllegalArgumentException -> 0x0335 }
            goto L_0x01c1
        L_0x01bf:
            java.lang.Boolean r9 = java.lang.Boolean.FALSE     // Catch:{ IllegalArgumentException -> 0x0335 }
        L_0x01c1:
            return r9
        L_0x01c2:
            boolean r13 = com.google.api.client.util.Types.isArray(r9)     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r9 == 0) goto L_0x01d7
            if (r13 != 0) goto L_0x01d7
            if (r0 == 0) goto L_0x01d5
            java.lang.Class<java.util.Collection> r2 = java.util.Collection.class
            boolean r2 = com.google.api.client.util.Types.isAssignableToOrFrom(r0, r2)     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r2 == 0) goto L_0x01d5
            goto L_0x01d7
        L_0x01d5:
            r2 = 0
            goto L_0x01d8
        L_0x01d7:
            r2 = 1
        L_0x01d8:
            java.lang.String r3 = "expected collection or array type but got %s"
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ IllegalArgumentException -> 0x0335 }
            r5[r4] = r9     // Catch:{ IllegalArgumentException -> 0x0335 }
            com.google.api.client.util.Preconditions.checkArgument(r2, r3, r5)     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r12 == 0) goto L_0x01ea
            if (r8 == 0) goto L_0x01ea
            java.util.Collection r11 = r12.newInstanceForArray(r11, r8)     // Catch:{ IllegalArgumentException -> 0x0335 }
            goto L_0x01eb
        L_0x01ea:
            r11 = r1
        L_0x01eb:
            if (r11 != 0) goto L_0x01f1
            java.util.Collection r11 = com.google.api.client.util.Data.newCollectionInstance(r9)     // Catch:{ IllegalArgumentException -> 0x0335 }
        L_0x01f1:
            if (r13 == 0) goto L_0x01f8
            java.lang.reflect.Type r1 = com.google.api.client.util.Types.getArrayComponentType(r9)     // Catch:{ IllegalArgumentException -> 0x0335 }
            goto L_0x0206
        L_0x01f8:
            if (r0 == 0) goto L_0x0206
            java.lang.Class<java.lang.Iterable> r2 = java.lang.Iterable.class
            boolean r0 = r2.isAssignableFrom(r0)     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r0 == 0) goto L_0x0206
            java.lang.reflect.Type r1 = com.google.api.client.util.Types.getIterableParameter(r9)     // Catch:{ IllegalArgumentException -> 0x0335 }
        L_0x0206:
            java.lang.reflect.Type r9 = com.google.api.client.util.Data.resolveWildcardTypeOrTypeVariable(r10, r1)     // Catch:{ IllegalArgumentException -> 0x0335 }
            r0 = r7
            r1 = r8
            r2 = r11
            r3 = r9
            r4 = r10
            r5 = r12
            r0.parseArray(r1, r2, r3, r4, r5)     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r13 == 0) goto L_0x021e
            java.lang.Class r9 = com.google.api.client.util.Types.getRawArrayComponentType(r10, r9)     // Catch:{ IllegalArgumentException -> 0x0335 }
            java.lang.Object r9 = com.google.api.client.util.Types.toArray(r11, r9)     // Catch:{ IllegalArgumentException -> 0x0335 }
            return r9
        L_0x021e:
            return r11
        L_0x021f:
            boolean r2 = com.google.api.client.util.Types.isArray(r9)     // Catch:{ IllegalArgumentException -> 0x0335 }
            r2 = r2 ^ r5
            java.lang.String r3 = "expected object or map type but got %s"
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ IllegalArgumentException -> 0x0335 }
            r6[r4] = r9     // Catch:{ IllegalArgumentException -> 0x0335 }
            com.google.api.client.util.Preconditions.checkArgument(r2, r3, r6)     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r13 == 0) goto L_0x0234
            java.lang.reflect.Field r13 = getCachedTypemapFieldFor(r0)     // Catch:{ IllegalArgumentException -> 0x0335 }
            goto L_0x0235
        L_0x0234:
            r13 = r1
        L_0x0235:
            if (r0 == 0) goto L_0x023e
            if (r12 == 0) goto L_0x023e
            java.lang.Object r11 = r12.newInstanceForObject(r11, r0)     // Catch:{ IllegalArgumentException -> 0x0335 }
            goto L_0x023f
        L_0x023e:
            r11 = r1
        L_0x023f:
            if (r0 == 0) goto L_0x024b
            java.lang.Class<java.util.Map> r2 = java.util.Map.class
            boolean r2 = com.google.api.client.util.Types.isAssignableToOrFrom(r0, r2)     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r2 == 0) goto L_0x024b
            r2 = 1
            goto L_0x024c
        L_0x024b:
            r2 = 0
        L_0x024c:
            if (r13 == 0) goto L_0x0254
            com.google.api.client.json.GenericJson r11 = new com.google.api.client.json.GenericJson     // Catch:{ IllegalArgumentException -> 0x0335 }
            r11.<init>()     // Catch:{ IllegalArgumentException -> 0x0335 }
            goto L_0x0264
        L_0x0254:
            if (r11 != 0) goto L_0x0264
            if (r2 != 0) goto L_0x0260
            if (r0 != 0) goto L_0x025b
            goto L_0x0260
        L_0x025b:
            java.lang.Object r11 = com.google.api.client.util.Types.newInstance(r0)     // Catch:{ IllegalArgumentException -> 0x0335 }
            goto L_0x0264
        L_0x0260:
            java.util.Map r11 = com.google.api.client.util.Data.newMapInstance(r0)     // Catch:{ IllegalArgumentException -> 0x0335 }
        L_0x0264:
            int r3 = r10.size()     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r9 == 0) goto L_0x026d
            r10.add(r9)     // Catch:{ IllegalArgumentException -> 0x0335 }
        L_0x026d:
            if (r2 == 0) goto L_0x0294
            java.lang.Class<com.google.api.client.util.GenericData> r2 = com.google.api.client.util.GenericData.class
            boolean r2 = r2.isAssignableFrom(r0)     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r2 != 0) goto L_0x0294
            java.lang.Class<java.util.Map> r2 = java.util.Map.class
            boolean r0 = r2.isAssignableFrom(r0)     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r0 == 0) goto L_0x0285
            java.lang.reflect.Type r0 = com.google.api.client.util.Types.getMapValueParameter(r9)     // Catch:{ IllegalArgumentException -> 0x0335 }
            r6 = r0
            goto L_0x0286
        L_0x0285:
            r6 = r1
        L_0x0286:
            if (r6 == 0) goto L_0x0294
            r2 = r11
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ IllegalArgumentException -> 0x0335 }
            r0 = r7
            r1 = r8
            r3 = r6
            r4 = r10
            r5 = r12
            r0.parseMap(r1, r2, r3, r4, r5)     // Catch:{ IllegalArgumentException -> 0x0335 }
            return r11
        L_0x0294:
            r7.parse(r10, r11, r12)     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r9 == 0) goto L_0x029c
            r10.remove(r3)     // Catch:{ IllegalArgumentException -> 0x0335 }
        L_0x029c:
            if (r13 != 0) goto L_0x029f
            return r11
        L_0x029f:
            r9 = r11
            com.google.api.client.json.GenericJson r9 = (com.google.api.client.json.GenericJson) r9     // Catch:{ IllegalArgumentException -> 0x0335 }
            java.lang.String r12 = r13.getName()     // Catch:{ IllegalArgumentException -> 0x0335 }
            java.lang.Object r9 = r9.get(r12)     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r9 == 0) goto L_0x02ae
            r12 = 1
            goto L_0x02af
        L_0x02ae:
            r12 = 0
        L_0x02af:
            java.lang.String r0 = "No value specified for @JsonPolymorphicTypeMap field"
            com.google.api.client.util.Preconditions.checkArgument(r12, r0)     // Catch:{ IllegalArgumentException -> 0x0335 }
            java.lang.String r9 = r9.toString()     // Catch:{ IllegalArgumentException -> 0x0335 }
            java.lang.Class<com.google.api.client.json.JsonPolymorphicTypeMap> r12 = com.google.api.client.json.JsonPolymorphicTypeMap.class
            java.lang.annotation.Annotation r12 = r13.getAnnotation(r12)     // Catch:{ IllegalArgumentException -> 0x0335 }
            com.google.api.client.json.JsonPolymorphicTypeMap r12 = (com.google.api.client.json.JsonPolymorphicTypeMap) r12     // Catch:{ IllegalArgumentException -> 0x0335 }
            com.google.api.client.json.JsonPolymorphicTypeMap$TypeDef[] r12 = r12.typeDefinitions()     // Catch:{ IllegalArgumentException -> 0x0335 }
            int r13 = r12.length     // Catch:{ IllegalArgumentException -> 0x0335 }
            r0 = 0
        L_0x02c6:
            if (r0 >= r13) goto L_0x02dc
            r2 = r12[r0]     // Catch:{ IllegalArgumentException -> 0x0335 }
            java.lang.String r3 = r2.key()     // Catch:{ IllegalArgumentException -> 0x0335 }
            boolean r3 = r3.equals(r9)     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r3 == 0) goto L_0x02d9
            java.lang.Class r1 = r2.ref()     // Catch:{ IllegalArgumentException -> 0x0335 }
            goto L_0x02dc
        L_0x02d9:
            int r0 = r0 + 1
            goto L_0x02c6
        L_0x02dc:
            r2 = r1
            if (r2 == 0) goto L_0x02e0
            r4 = 1
        L_0x02e0:
            java.lang.String r12 = "No TypeDef annotation found with key: "
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ IllegalArgumentException -> 0x0335 }
            int r13 = r9.length()     // Catch:{ IllegalArgumentException -> 0x0335 }
            if (r13 == 0) goto L_0x02f1
            java.lang.String r9 = r12.concat(r9)     // Catch:{ IllegalArgumentException -> 0x0335 }
            goto L_0x02f6
        L_0x02f1:
            java.lang.String r9 = new java.lang.String     // Catch:{ IllegalArgumentException -> 0x0335 }
            r9.<init>(r12)     // Catch:{ IllegalArgumentException -> 0x0335 }
        L_0x02f6:
            com.google.api.client.util.Preconditions.checkArgument(r4, r9)     // Catch:{ IllegalArgumentException -> 0x0335 }
            com.google.api.client.json.JsonFactory r9 = r7.getFactory()     // Catch:{ IllegalArgumentException -> 0x0335 }
            java.lang.String r11 = r9.toString(r11)     // Catch:{ IllegalArgumentException -> 0x0335 }
            com.google.api.client.json.JsonParser r0 = r9.createJsonParser(r11)     // Catch:{ IllegalArgumentException -> 0x0335 }
            r0.startParsing()     // Catch:{ IllegalArgumentException -> 0x0335 }
            r4 = 0
            r5 = 0
            r6 = 0
            r1 = r8
            r3 = r10
            java.lang.Object r9 = r0.parseValue(r1, r2, r3, r4, r5, r6)     // Catch:{ IllegalArgumentException -> 0x0335 }
            return r9
        L_0x0312:
            java.lang.String r10 = java.lang.String.valueOf(r2)     // Catch:{ IllegalArgumentException -> 0x0335 }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ IllegalArgumentException -> 0x0335 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x0335 }
            int r12 = r10.length()     // Catch:{ IllegalArgumentException -> 0x0335 }
            int r12 = r12 + 27
            r11.<init>(r12)     // Catch:{ IllegalArgumentException -> 0x0335 }
            java.lang.String r12 = "unexpected JSON node type: "
            r11.append(r12)     // Catch:{ IllegalArgumentException -> 0x0335 }
            r11.append(r10)     // Catch:{ IllegalArgumentException -> 0x0335 }
            java.lang.String r10 = r11.toString()     // Catch:{ IllegalArgumentException -> 0x0335 }
            r9.<init>(r10)     // Catch:{ IllegalArgumentException -> 0x0335 }
            throw r9     // Catch:{ IllegalArgumentException -> 0x0335 }
        L_0x0335:
            r9 = move-exception
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = r7.getCurrentName()
            if (r11 == 0) goto L_0x0349
            java.lang.String r12 = "key "
            r10.append(r12)
            r10.append(r11)
        L_0x0349:
            if (r8 == 0) goto L_0x035a
            if (r11 == 0) goto L_0x0352
            java.lang.String r11 = ", "
            r10.append(r11)
        L_0x0352:
            java.lang.String r11 = "field "
            r10.append(r11)
            r10.append(r8)
        L_0x035a:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r10 = r10.toString()
            r8.<init>(r10, r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.api.client.json.JsonParser.parseValue(java.lang.reflect.Field, java.lang.reflect.Type, java.util.ArrayList, java.lang.Object, com.google.api.client.json.CustomizeJsonParser, boolean):java.lang.Object");
    }

    private static Field getCachedTypemapFieldFor(Class<?> cls) {
        Field field = null;
        if (cls == null) {
            return null;
        }
        lock.lock();
        try {
            if (cachedTypemapFields.containsKey(cls)) {
                return (Field) cachedTypemapFields.get(cls);
            }
            for (FieldInfo field2 : ClassInfo.m8627of(cls).getFieldInfos()) {
                Field field3 = field2.getField();
                JsonPolymorphicTypeMap jsonPolymorphicTypeMap = (JsonPolymorphicTypeMap) field3.getAnnotation(JsonPolymorphicTypeMap.class);
                if (jsonPolymorphicTypeMap != null) {
                    Preconditions.checkArgument(field == null, "Class contains more than one field with @JsonPolymorphicTypeMap annotation: %s", cls);
                    Preconditions.checkArgument(Data.isPrimitive(field3.getType()), "Field which has the @JsonPolymorphicTypeMap, %s, is not a supported type: %s", cls, field3.getType());
                    TypeDef[] typeDefinitions = jsonPolymorphicTypeMap.typeDefinitions();
                    HashSet newHashSet = Sets.newHashSet();
                    Preconditions.checkArgument(typeDefinitions.length > 0, "@JsonPolymorphicTypeMap must have at least one @TypeDef");
                    for (TypeDef typeDef : typeDefinitions) {
                        Preconditions.checkArgument(newHashSet.add(typeDef.key()), "Class contains two @TypeDef annotations with identical key: %s", typeDef.key());
                    }
                    field = field3;
                }
            }
            cachedTypemapFields.put(cls, field);
            lock.unlock();
            return field;
        } finally {
            lock.unlock();
        }
    }
}

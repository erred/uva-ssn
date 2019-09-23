package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonMapFormatVisitor;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.SerializerAndMapResult;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

@JacksonStdImpl
public class MapSerializer extends ContainerSerializer<Map<?, ?>> implements ContextualSerializer {
    protected static final JavaType UNSPECIFIED_TYPE = TypeFactory.unknownType();
    private static final long serialVersionUID = 1;
    protected PropertySerializerMap _dynamicValueSerializers;
    protected final Object _filterId;
    protected final Set<String> _ignoredEntries;
    protected JsonSerializer<Object> _keySerializer;
    protected final JavaType _keyType;
    protected final BeanProperty _property;
    protected final boolean _sortKeys;
    protected final Object _suppressableValue;
    protected JsonSerializer<Object> _valueSerializer;
    protected final JavaType _valueType;
    protected final boolean _valueTypeIsStatic;
    protected final TypeSerializer _valueTypeSerializer;

    protected MapSerializer(Set<String> set, JavaType javaType, JavaType javaType2, boolean z, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, JsonSerializer<?> jsonSerializer2) {
        super(Map.class, false);
        if (set == null || set.isEmpty()) {
            set = null;
        }
        this._ignoredEntries = set;
        this._keyType = javaType;
        this._valueType = javaType2;
        this._valueTypeIsStatic = z;
        this._valueTypeSerializer = typeSerializer;
        this._keySerializer = jsonSerializer;
        this._valueSerializer = jsonSerializer2;
        this._dynamicValueSerializers = PropertySerializerMap.emptyForProperties();
        this._property = null;
        this._filterId = null;
        this._sortKeys = false;
        this._suppressableValue = null;
    }

    /* access modifiers changed from: protected */
    public void _ensureOverride() {
        if (getClass() != MapSerializer.class) {
            StringBuilder sb = new StringBuilder();
            sb.append("Missing override in class ");
            sb.append(getClass().getName());
            throw new IllegalStateException(sb.toString());
        }
    }

    protected MapSerializer(MapSerializer mapSerializer, BeanProperty beanProperty, JsonSerializer<?> jsonSerializer, JsonSerializer<?> jsonSerializer2, Set<String> set) {
        super(Map.class, false);
        if (set == null || set.isEmpty()) {
            set = null;
        }
        this._ignoredEntries = set;
        this._keyType = mapSerializer._keyType;
        this._valueType = mapSerializer._valueType;
        this._valueTypeIsStatic = mapSerializer._valueTypeIsStatic;
        this._valueTypeSerializer = mapSerializer._valueTypeSerializer;
        this._keySerializer = jsonSerializer;
        this._valueSerializer = jsonSerializer2;
        this._dynamicValueSerializers = mapSerializer._dynamicValueSerializers;
        this._property = beanProperty;
        this._filterId = mapSerializer._filterId;
        this._sortKeys = mapSerializer._sortKeys;
        this._suppressableValue = mapSerializer._suppressableValue;
    }

    @Deprecated
    protected MapSerializer(MapSerializer mapSerializer, TypeSerializer typeSerializer) {
        this(mapSerializer, typeSerializer, mapSerializer._suppressableValue);
    }

    protected MapSerializer(MapSerializer mapSerializer, TypeSerializer typeSerializer, Object obj) {
        super(Map.class, false);
        this._ignoredEntries = mapSerializer._ignoredEntries;
        this._keyType = mapSerializer._keyType;
        this._valueType = mapSerializer._valueType;
        this._valueTypeIsStatic = mapSerializer._valueTypeIsStatic;
        this._valueTypeSerializer = typeSerializer;
        this._keySerializer = mapSerializer._keySerializer;
        this._valueSerializer = mapSerializer._valueSerializer;
        this._dynamicValueSerializers = mapSerializer._dynamicValueSerializers;
        this._property = mapSerializer._property;
        this._filterId = mapSerializer._filterId;
        this._sortKeys = mapSerializer._sortKeys;
        if (obj == Include.NON_ABSENT) {
            obj = this._valueType.isReferenceType() ? Include.NON_EMPTY : Include.NON_NULL;
        }
        this._suppressableValue = obj;
    }

    protected MapSerializer(MapSerializer mapSerializer, Object obj, boolean z) {
        super(Map.class, false);
        this._ignoredEntries = mapSerializer._ignoredEntries;
        this._keyType = mapSerializer._keyType;
        this._valueType = mapSerializer._valueType;
        this._valueTypeIsStatic = mapSerializer._valueTypeIsStatic;
        this._valueTypeSerializer = mapSerializer._valueTypeSerializer;
        this._keySerializer = mapSerializer._keySerializer;
        this._valueSerializer = mapSerializer._valueSerializer;
        this._dynamicValueSerializers = mapSerializer._dynamicValueSerializers;
        this._property = mapSerializer._property;
        this._filterId = obj;
        this._sortKeys = z;
        this._suppressableValue = mapSerializer._suppressableValue;
    }

    public MapSerializer _withValueTypeSerializer(TypeSerializer typeSerializer) {
        if (this._valueTypeSerializer == typeSerializer) {
            return this;
        }
        _ensureOverride();
        return new MapSerializer(this, typeSerializer, (Object) null);
    }

    public MapSerializer withResolved(BeanProperty beanProperty, JsonSerializer<?> jsonSerializer, JsonSerializer<?> jsonSerializer2, Set<String> set, boolean z) {
        _ensureOverride();
        MapSerializer mapSerializer = new MapSerializer(this, beanProperty, jsonSerializer, jsonSerializer2, set);
        return z != mapSerializer._sortKeys ? new MapSerializer(mapSerializer, this._filterId, z) : mapSerializer;
    }

    public MapSerializer withFilterId(Object obj) {
        if (this._filterId == obj) {
            return this;
        }
        _ensureOverride();
        return new MapSerializer(this, obj, this._sortKeys);
    }

    public MapSerializer withContentInclusion(Object obj) {
        if (obj == this._suppressableValue) {
            return this;
        }
        _ensureOverride();
        return new MapSerializer(this, this._valueTypeSerializer, obj);
    }

    @Deprecated
    public static MapSerializer construct(String[] strArr, JavaType javaType, boolean z, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer, JsonSerializer<Object> jsonSerializer2, Object obj) {
        return construct((Set<String>) (strArr == null || strArr.length == 0) ? null : ArrayBuilders.arrayToSet(strArr), javaType, z, typeSerializer, jsonSerializer, jsonSerializer2, obj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.fasterxml.jackson.databind.ser.std.MapSerializer construct(java.util.Set<java.lang.String> r9, com.fasterxml.jackson.databind.JavaType r10, boolean r11, com.fasterxml.jackson.databind.jsontype.TypeSerializer r12, com.fasterxml.jackson.databind.JsonSerializer<java.lang.Object> r13, com.fasterxml.jackson.databind.JsonSerializer<java.lang.Object> r14, java.lang.Object r15) {
        /*
            if (r10 != 0) goto L_0x0007
            com.fasterxml.jackson.databind.JavaType r10 = UNSPECIFIED_TYPE
            r3 = r10
            r4 = r3
            goto L_0x0011
        L_0x0007:
            com.fasterxml.jackson.databind.JavaType r0 = r10.getKeyType()
            com.fasterxml.jackson.databind.JavaType r10 = r10.getContentType()
            r4 = r10
            r3 = r0
        L_0x0011:
            r10 = 0
            if (r11 != 0) goto L_0x0021
            if (r4 == 0) goto L_0x001f
            boolean r11 = r4.isFinal()
            if (r11 == 0) goto L_0x001f
            r10 = 1
            r11 = 1
            goto L_0x002b
        L_0x001f:
            r11 = 0
            goto L_0x002b
        L_0x0021:
            java.lang.Class r0 = r4.getRawClass()
            java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
            if (r0 != r1) goto L_0x002b
            r5 = 0
            goto L_0x002c
        L_0x002b:
            r5 = r11
        L_0x002c:
            com.fasterxml.jackson.databind.ser.std.MapSerializer r10 = new com.fasterxml.jackson.databind.ser.std.MapSerializer
            r1 = r10
            r2 = r9
            r6 = r12
            r7 = r13
            r8 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            if (r15 == 0) goto L_0x003c
            com.fasterxml.jackson.databind.ser.std.MapSerializer r10 = r10.withFilterId(r15)
        L_0x003c:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.MapSerializer.construct(java.util.Set, com.fasterxml.jackson.databind.JavaType, boolean, com.fasterxml.jackson.databind.jsontype.TypeSerializer, com.fasterxml.jackson.databind.JsonSerializer, com.fasterxml.jackson.databind.JsonSerializer, java.lang.Object):com.fasterxml.jackson.databind.ser.std.MapSerializer");
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.JsonSerializer<?> createContextual(com.fasterxml.jackson.databind.SerializerProvider r12, com.fasterxml.jackson.databind.BeanProperty r13) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            r11 = this;
            com.fasterxml.jackson.databind.AnnotationIntrospector r0 = r12.getAnnotationIntrospector()
            r1 = 0
            if (r13 != 0) goto L_0x0009
            r2 = r1
            goto L_0x000d
        L_0x0009:
            com.fasterxml.jackson.databind.introspect.AnnotatedMember r2 = r13.getMember()
        L_0x000d:
            java.lang.Object r3 = r11._suppressableValue
            if (r2 == 0) goto L_0x002a
            if (r0 == 0) goto L_0x002a
            java.lang.Object r4 = r0.findKeySerializer(r2)
            if (r4 == 0) goto L_0x001e
            com.fasterxml.jackson.databind.JsonSerializer r4 = r12.serializerInstance(r2, r4)
            goto L_0x001f
        L_0x001e:
            r4 = r1
        L_0x001f:
            java.lang.Object r5 = r0.findContentSerializer(r2)
            if (r5 == 0) goto L_0x002b
            com.fasterxml.jackson.databind.JsonSerializer r1 = r12.serializerInstance(r2, r5)
            goto L_0x002b
        L_0x002a:
            r4 = r1
        L_0x002b:
            java.lang.Class<java.util.Map> r5 = java.util.Map.class
            com.fasterxml.jackson.annotation.JsonInclude$Value r5 = r11.findIncludeOverrides(r12, r13, r5)
            com.fasterxml.jackson.annotation.JsonInclude$Include r5 = r5.getContentInclusion()
            if (r5 == 0) goto L_0x003c
            com.fasterxml.jackson.annotation.JsonInclude$Include r6 = com.fasterxml.jackson.annotation.JsonInclude.Include.USE_DEFAULTS
            if (r5 == r6) goto L_0x003c
            r3 = r5
        L_0x003c:
            if (r1 != 0) goto L_0x0040
            com.fasterxml.jackson.databind.JsonSerializer<java.lang.Object> r1 = r11._valueSerializer
        L_0x0040:
            com.fasterxml.jackson.databind.JsonSerializer r1 = r11.findConvertingContentSerializer(r12, r13, r1)
            if (r1 != 0) goto L_0x005a
            boolean r5 = r11._valueTypeIsStatic
            if (r5 == 0) goto L_0x0058
            com.fasterxml.jackson.databind.JavaType r5 = r11._valueType
            boolean r5 = r5.isJavaLangObject()
            if (r5 != 0) goto L_0x0058
            com.fasterxml.jackson.databind.JavaType r1 = r11._valueType
            com.fasterxml.jackson.databind.JsonSerializer r1 = r12.findValueSerializer(r1, r13)
        L_0x0058:
            r8 = r1
            goto L_0x005f
        L_0x005a:
            com.fasterxml.jackson.databind.JsonSerializer r1 = r12.handleSecondaryContextualization(r1, r13)
            goto L_0x0058
        L_0x005f:
            if (r4 != 0) goto L_0x0063
            com.fasterxml.jackson.databind.JsonSerializer<java.lang.Object> r4 = r11._keySerializer
        L_0x0063:
            if (r4 != 0) goto L_0x006d
            com.fasterxml.jackson.databind.JavaType r1 = r11._keyType
            com.fasterxml.jackson.databind.JsonSerializer r1 = r12.findKeySerializer(r1, r13)
        L_0x006b:
            r7 = r1
            goto L_0x0072
        L_0x006d:
            com.fasterxml.jackson.databind.JsonSerializer r1 = r12.handleSecondaryContextualization(r4, r13)
            goto L_0x006b
        L_0x0072:
            java.util.Set<java.lang.String> r1 = r11._ignoredEntries
            r4 = 0
            if (r0 == 0) goto L_0x00bb
            if (r2 == 0) goto L_0x00bb
            com.fasterxml.jackson.annotation.JsonIgnoreProperties$Value r5 = r0.findPropertyIgnorals(r2)
            if (r5 == 0) goto L_0x00ad
            java.util.Set r5 = r5.findIgnoredForSerialization()
            if (r5 == 0) goto L_0x00ad
            boolean r6 = r5.isEmpty()
            if (r6 != 0) goto L_0x00ad
            if (r1 != 0) goto L_0x0093
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            goto L_0x0099
        L_0x0093:
            java.util.HashSet r6 = new java.util.HashSet
            r6.<init>(r1)
            r1 = r6
        L_0x0099:
            java.util.Iterator r5 = r5.iterator()
        L_0x009d:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00ad
            java.lang.Object r6 = r5.next()
            java.lang.String r6 = (java.lang.String) r6
            r1.add(r6)
            goto L_0x009d
        L_0x00ad:
            java.lang.Boolean r2 = r0.findSerializationSortAlphabetically(r2)
            if (r2 == 0) goto L_0x00bb
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x00bb
            r2 = 1
            r4 = 1
        L_0x00bb:
            r9 = r1
            java.lang.Class<java.util.Map> r1 = java.util.Map.class
            com.fasterxml.jackson.annotation.JsonFormat$Value r12 = r11.findFormatOverrides(r12, r13, r1)
            if (r12 == 0) goto L_0x00d2
            com.fasterxml.jackson.annotation.JsonFormat$Feature r1 = com.fasterxml.jackson.annotation.JsonFormat.Feature.WRITE_SORTED_MAP_ENTRIES
            java.lang.Boolean r12 = r12.getFeature(r1)
            if (r12 == 0) goto L_0x00d2
            boolean r12 = r12.booleanValue()
            r10 = r12
            goto L_0x00d3
        L_0x00d2:
            r10 = r4
        L_0x00d3:
            r5 = r11
            r6 = r13
            com.fasterxml.jackson.databind.ser.std.MapSerializer r12 = r5.withResolved(r6, r7, r8, r9, r10)
            java.lang.Object r1 = r11._suppressableValue
            if (r3 == r1) goto L_0x00e1
            com.fasterxml.jackson.databind.ser.std.MapSerializer r12 = r12.withContentInclusion(r3)
        L_0x00e1:
            if (r13 == 0) goto L_0x00f3
            com.fasterxml.jackson.databind.introspect.AnnotatedMember r13 = r13.getMember()
            if (r13 == 0) goto L_0x00f3
            java.lang.Object r13 = r0.findFilterId(r13)
            if (r13 == 0) goto L_0x00f3
            com.fasterxml.jackson.databind.ser.std.MapSerializer r12 = r12.withFilterId(r13)
        L_0x00f3:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.MapSerializer.createContextual(com.fasterxml.jackson.databind.SerializerProvider, com.fasterxml.jackson.databind.BeanProperty):com.fasterxml.jackson.databind.JsonSerializer");
    }

    public JavaType getContentType() {
        return this._valueType;
    }

    public JsonSerializer<?> getContentSerializer() {
        return this._valueSerializer;
    }

    public boolean isEmpty(SerializerProvider serializerProvider, Map<?, ?> map) {
        if (map == null || map.isEmpty()) {
            return true;
        }
        Object obj = this._suppressableValue;
        if (obj == null || obj == Include.ALWAYS) {
            return false;
        }
        JsonSerializer<Object> jsonSerializer = this._valueSerializer;
        if (jsonSerializer != null) {
            for (Object next : map.values()) {
                if (next != null && !jsonSerializer.isEmpty(serializerProvider, next)) {
                    return false;
                }
            }
            return true;
        }
        PropertySerializerMap propertySerializerMap = this._dynamicValueSerializers;
        for (Object next2 : map.values()) {
            if (next2 != null) {
                Class cls = next2.getClass();
                JsonSerializer serializerFor = propertySerializerMap.serializerFor(cls);
                if (serializerFor == null) {
                    try {
                        serializerFor = _findAndAddDynamic(propertySerializerMap, cls, serializerProvider);
                        propertySerializerMap = this._dynamicValueSerializers;
                    } catch (JsonMappingException unused) {
                        return false;
                    }
                }
                if (!serializerFor.isEmpty(serializerProvider, next2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasSingleElement(Map<?, ?> map) {
        return map.size() == 1;
    }

    public JsonSerializer<?> getKeySerializer() {
        return this._keySerializer;
    }

    public void serialize(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject(map);
        if (!map.isEmpty()) {
            Object obj = this._suppressableValue;
            if (obj == Include.ALWAYS) {
                obj = null;
            } else if (obj == null && !serializerProvider.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES)) {
                obj = Include.NON_NULL;
            }
            Object obj2 = obj;
            if (this._sortKeys || serializerProvider.isEnabled(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS)) {
                map = _orderEntries(map, jsonGenerator, serializerProvider, obj2);
            }
            Map<?, ?> map2 = map;
            if (this._filterId != null) {
                PropertyFilter findPropertyFilter = findPropertyFilter(serializerProvider, this._filterId, map2);
                if (findPropertyFilter != null) {
                    serializeFilteredFields(map2, jsonGenerator, serializerProvider, findPropertyFilter, obj2);
                }
            }
            if (obj2 != null) {
                serializeOptionalFields(map2, jsonGenerator, serializerProvider, obj2);
            } else if (this._valueSerializer != null) {
                serializeFieldsUsing(map2, jsonGenerator, serializerProvider, this._valueSerializer);
            } else {
                serializeFields(map2, jsonGenerator, serializerProvider);
            }
        }
        jsonGenerator.writeEndObject();
    }

    public void serializeWithType(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        typeSerializer.writeTypePrefixForObject(map, jsonGenerator);
        jsonGenerator.setCurrentValue(map);
        if (!map.isEmpty()) {
            Object obj = this._suppressableValue;
            if (obj == Include.ALWAYS) {
                obj = null;
            } else if (obj == null && !serializerProvider.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES)) {
                obj = Include.NON_NULL;
            }
            Object obj2 = obj;
            if (this._sortKeys || serializerProvider.isEnabled(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS)) {
                map = _orderEntries(map, jsonGenerator, serializerProvider, obj2);
            }
            if (this._filterId != null) {
                PropertyFilter findPropertyFilter = findPropertyFilter(serializerProvider, this._filterId, map);
                if (findPropertyFilter != null) {
                    serializeFilteredFields(map, jsonGenerator, serializerProvider, findPropertyFilter, obj2);
                }
            }
            if (obj2 != null) {
                serializeOptionalFields(map, jsonGenerator, serializerProvider, obj2);
            } else if (this._valueSerializer != null) {
                serializeFieldsUsing(map, jsonGenerator, serializerProvider, this._valueSerializer);
            } else {
                serializeFields(map, jsonGenerator, serializerProvider);
            }
        }
        typeSerializer.writeTypeSuffixForObject(map, jsonGenerator);
    }

    public void serializeFields(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        JsonSerializer<Object> _findAndAddDynamic;
        if (this._valueTypeSerializer != null) {
            serializeTypedFields(map, jsonGenerator, serializerProvider, null);
            return;
        }
        JsonSerializer<Object> jsonSerializer = this._keySerializer;
        Set<String> set = this._ignoredEntries;
        PropertySerializerMap propertySerializerMap = this._dynamicValueSerializers;
        for (Entry entry : map.entrySet()) {
            Object value = entry.getValue();
            Object key = entry.getKey();
            if (key == null) {
                serializerProvider.findNullKeySerializer(this._keyType, this._property).serialize(null, jsonGenerator, serializerProvider);
            } else if (set == null || !set.contains(key)) {
                jsonSerializer.serialize(key, jsonGenerator, serializerProvider);
            }
            if (value == null) {
                serializerProvider.defaultSerializeNull(jsonGenerator);
            } else {
                JsonSerializer<Object> jsonSerializer2 = this._valueSerializer;
                if (jsonSerializer2 == null) {
                    Class cls = value.getClass();
                    JsonSerializer<Object> serializerFor = propertySerializerMap.serializerFor(cls);
                    if (serializerFor == null) {
                        if (this._valueType.hasGenericTypes()) {
                            _findAndAddDynamic = _findAndAddDynamic(propertySerializerMap, serializerProvider.constructSpecializedType(this._valueType, cls), serializerProvider);
                        } else {
                            _findAndAddDynamic = _findAndAddDynamic(propertySerializerMap, cls, serializerProvider);
                        }
                        jsonSerializer2 = _findAndAddDynamic;
                        propertySerializerMap = this._dynamicValueSerializers;
                    } else {
                        jsonSerializer2 = serializerFor;
                    }
                }
                try {
                    jsonSerializer2.serialize(value, jsonGenerator, serializerProvider);
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(key);
                    wrapAndThrow(serializerProvider, (Throwable) e, (Object) map, sb.toString());
                }
            }
        }
    }

    public void serializeOptionalFields(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, Object obj) throws IOException {
        JsonSerializer<Object> jsonSerializer;
        JsonSerializer jsonSerializer2;
        JsonSerializer jsonSerializer3;
        if (this._valueTypeSerializer != null) {
            serializeTypedFields(map, jsonGenerator, serializerProvider, obj);
            return;
        }
        Set<String> set = this._ignoredEntries;
        PropertySerializerMap propertySerializerMap = this._dynamicValueSerializers;
        for (Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            if (key == null) {
                jsonSerializer = serializerProvider.findNullKeySerializer(this._keyType, this._property);
            } else if (set == null || !set.contains(key)) {
                jsonSerializer = this._keySerializer;
            }
            Object value = entry.getValue();
            if (value != null) {
                jsonSerializer2 = this._valueSerializer;
                if (jsonSerializer2 == null) {
                    Class cls = value.getClass();
                    JsonSerializer serializerFor = propertySerializerMap.serializerFor(cls);
                    if (serializerFor == null) {
                        if (this._valueType.hasGenericTypes()) {
                            jsonSerializer3 = _findAndAddDynamic(propertySerializerMap, serializerProvider.constructSpecializedType(this._valueType, cls), serializerProvider);
                        } else {
                            jsonSerializer3 = _findAndAddDynamic(propertySerializerMap, cls, serializerProvider);
                        }
                        jsonSerializer2 = jsonSerializer3;
                        propertySerializerMap = this._dynamicValueSerializers;
                    } else {
                        jsonSerializer2 = serializerFor;
                    }
                }
                if (obj == Include.NON_EMPTY && jsonSerializer2.isEmpty(serializerProvider, value)) {
                }
            } else if (obj == null) {
                jsonSerializer2 = serializerProvider.getDefaultNullValueSerializer();
            }
            try {
                jsonSerializer.serialize(key, jsonGenerator, serializerProvider);
                jsonSerializer2.serialize(value, jsonGenerator, serializerProvider);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(key);
                wrapAndThrow(serializerProvider, (Throwable) e, (Object) map, sb.toString());
            }
        }
    }

    public void serializeFieldsUsing(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, JsonSerializer<Object> jsonSerializer) throws IOException {
        JsonSerializer<Object> jsonSerializer2 = this._keySerializer;
        Set<String> set = this._ignoredEntries;
        TypeSerializer typeSerializer = this._valueTypeSerializer;
        for (Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            if (set == null || !set.contains(key)) {
                if (key == null) {
                    serializerProvider.findNullKeySerializer(this._keyType, this._property).serialize(null, jsonGenerator, serializerProvider);
                } else {
                    jsonSerializer2.serialize(key, jsonGenerator, serializerProvider);
                }
                Object value = entry.getValue();
                if (value == null) {
                    serializerProvider.defaultSerializeNull(jsonGenerator);
                } else if (typeSerializer == null) {
                    try {
                        jsonSerializer.serialize(value, jsonGenerator, serializerProvider);
                    } catch (Exception e) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("");
                        sb.append(key);
                        wrapAndThrow(serializerProvider, (Throwable) e, (Object) map, sb.toString());
                    }
                } else {
                    jsonSerializer.serializeWithType(value, jsonGenerator, serializerProvider, typeSerializer);
                }
            }
        }
    }

    public void serializeFilteredFields(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, PropertyFilter propertyFilter, Object obj) throws IOException {
        JsonSerializer<Object> jsonSerializer;
        JsonSerializer jsonSerializer2;
        JsonSerializer jsonSerializer3;
        Set<String> set = this._ignoredEntries;
        PropertySerializerMap propertySerializerMap = this._dynamicValueSerializers;
        MapProperty mapProperty = new MapProperty(this._valueTypeSerializer, this._property);
        for (Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            if (set == null || !set.contains(key)) {
                if (key == null) {
                    jsonSerializer = serializerProvider.findNullKeySerializer(this._keyType, this._property);
                } else {
                    jsonSerializer = this._keySerializer;
                }
                Object value = entry.getValue();
                if (value != null) {
                    jsonSerializer2 = this._valueSerializer;
                    if (jsonSerializer2 == null) {
                        Class cls = value.getClass();
                        JsonSerializer serializerFor = propertySerializerMap.serializerFor(cls);
                        if (serializerFor == null) {
                            if (this._valueType.hasGenericTypes()) {
                                jsonSerializer3 = _findAndAddDynamic(propertySerializerMap, serializerProvider.constructSpecializedType(this._valueType, cls), serializerProvider);
                            } else {
                                jsonSerializer3 = _findAndAddDynamic(propertySerializerMap, cls, serializerProvider);
                            }
                            jsonSerializer2 = jsonSerializer3;
                            propertySerializerMap = this._dynamicValueSerializers;
                        } else {
                            jsonSerializer2 = serializerFor;
                        }
                    }
                    if (obj == Include.NON_EMPTY && jsonSerializer2.isEmpty(serializerProvider, value)) {
                    }
                } else if (obj == null) {
                    jsonSerializer2 = serializerProvider.getDefaultNullValueSerializer();
                }
                mapProperty.reset(key, jsonSerializer, jsonSerializer2);
                try {
                    propertyFilter.serializeAsField(value, jsonGenerator, serializerProvider, mapProperty);
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(key);
                    wrapAndThrow(serializerProvider, (Throwable) e, (Object) map, sb.toString());
                }
            }
        }
    }

    @Deprecated
    public void serializeFilteredFields(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, PropertyFilter propertyFilter) throws IOException {
        serializeFilteredFields(map, jsonGenerator, serializerProvider, propertyFilter, serializerProvider.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES) ? null : Include.NON_NULL);
    }

    public void serializeTypedFields(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, Object obj) throws IOException {
        JsonSerializer<Object> jsonSerializer;
        JsonSerializer jsonSerializer2;
        JsonSerializer jsonSerializer3;
        Set<String> set = this._ignoredEntries;
        PropertySerializerMap propertySerializerMap = this._dynamicValueSerializers;
        for (Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            if (key == null) {
                jsonSerializer = serializerProvider.findNullKeySerializer(this._keyType, this._property);
            } else if (set == null || !set.contains(key)) {
                jsonSerializer = this._keySerializer;
            }
            Object value = entry.getValue();
            if (value != null) {
                JsonSerializer<Object> jsonSerializer4 = this._valueSerializer;
                Class cls = value.getClass();
                JsonSerializer serializerFor = propertySerializerMap.serializerFor(cls);
                if (serializerFor == null) {
                    if (this._valueType.hasGenericTypes()) {
                        jsonSerializer3 = _findAndAddDynamic(propertySerializerMap, serializerProvider.constructSpecializedType(this._valueType, cls), serializerProvider);
                    } else {
                        jsonSerializer3 = _findAndAddDynamic(propertySerializerMap, cls, serializerProvider);
                    }
                    jsonSerializer2 = jsonSerializer3;
                    propertySerializerMap = this._dynamicValueSerializers;
                } else {
                    jsonSerializer2 = serializerFor;
                }
                if (obj == Include.NON_EMPTY && jsonSerializer2.isEmpty(serializerProvider, value)) {
                }
            } else if (obj == null) {
                jsonSerializer2 = serializerProvider.getDefaultNullValueSerializer();
            }
            jsonSerializer.serialize(key, jsonGenerator, serializerProvider);
            try {
                jsonSerializer2.serializeWithType(value, jsonGenerator, serializerProvider, this._valueTypeSerializer);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(key);
                wrapAndThrow(serializerProvider, (Throwable) e, (Object) map, sb.toString());
            }
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void serializeTypedFields(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        serializeTypedFields(map, jsonGenerator, serializerProvider, serializerProvider.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES) ? null : Include.NON_NULL);
    }

    public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
        return createSchemaNode("object", true);
    }

    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) throws JsonMappingException {
        JsonMapFormatVisitor expectMapFormat = jsonFormatVisitorWrapper == null ? null : jsonFormatVisitorWrapper.expectMapFormat(javaType);
        if (expectMapFormat != null) {
            expectMapFormat.keyFormat(this._keySerializer, this._keyType);
            JsonSerializer<Object> jsonSerializer = this._valueSerializer;
            if (jsonSerializer == null) {
                jsonSerializer = _findAndAddDynamic(this._dynamicValueSerializers, this._valueType, jsonFormatVisitorWrapper.getProvider());
            }
            expectMapFormat.valueFormat(jsonSerializer, this._valueType);
        }
    }

    /* access modifiers changed from: protected */
    public final JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap propertySerializerMap, Class<?> cls, SerializerProvider serializerProvider) throws JsonMappingException {
        SerializerAndMapResult findAndAddSecondarySerializer = propertySerializerMap.findAndAddSecondarySerializer(cls, serializerProvider, this._property);
        if (propertySerializerMap != findAndAddSecondarySerializer.map) {
            this._dynamicValueSerializers = findAndAddSecondarySerializer.map;
        }
        return findAndAddSecondarySerializer.serializer;
    }

    /* access modifiers changed from: protected */
    public final JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap propertySerializerMap, JavaType javaType, SerializerProvider serializerProvider) throws JsonMappingException {
        SerializerAndMapResult findAndAddSecondarySerializer = propertySerializerMap.findAndAddSecondarySerializer(javaType, serializerProvider, this._property);
        if (propertySerializerMap != findAndAddSecondarySerializer.map) {
            this._dynamicValueSerializers = findAndAddSecondarySerializer.map;
        }
        return findAndAddSecondarySerializer.serializer;
    }

    /* access modifiers changed from: protected */
    public Map<?, ?> _orderEntries(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, Object obj) throws IOException {
        if (map instanceof SortedMap) {
            return map;
        }
        if (!_hasNullKey(map)) {
            return new TreeMap(map);
        }
        TreeMap treeMap = new TreeMap();
        for (Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            if (key == null) {
                _writeNullKeyedEntry(jsonGenerator, serializerProvider, obj, entry.getValue());
            } else {
                treeMap.put(key, entry.getValue());
            }
        }
        return treeMap;
    }

    /* access modifiers changed from: protected */
    public boolean _hasNullKey(Map<?, ?> map) {
        return (map instanceof HashMap) && map.containsKey(null);
    }

    /* access modifiers changed from: protected */
    public void _writeNullKeyedEntry(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, Object obj, Object obj2) throws IOException {
        JsonSerializer jsonSerializer;
        JsonSerializer findNullKeySerializer = serializerProvider.findNullKeySerializer(this._keyType, this._property);
        if (obj2 != null) {
            JsonSerializer jsonSerializer2 = this._valueSerializer;
            if (jsonSerializer2 == null) {
                Class cls = obj2.getClass();
                JsonSerializer serializerFor = this._dynamicValueSerializers.serializerFor(cls);
                jsonSerializer2 = serializerFor == null ? this._valueType.hasGenericTypes() ? _findAndAddDynamic(this._dynamicValueSerializers, serializerProvider.constructSpecializedType(this._valueType, cls), serializerProvider) : _findAndAddDynamic(this._dynamicValueSerializers, cls, serializerProvider) : serializerFor;
            }
            if (obj != Include.NON_EMPTY || !jsonSerializer2.isEmpty(serializerProvider, obj2)) {
                jsonSerializer = jsonSerializer2;
            } else {
                return;
            }
        } else if (obj == null) {
            jsonSerializer = serializerProvider.getDefaultNullValueSerializer();
        } else {
            return;
        }
        try {
            findNullKeySerializer.serialize(null, jsonGenerator, serializerProvider);
            jsonSerializer.serialize(obj2, jsonGenerator, serializerProvider);
        } catch (Exception e) {
            wrapAndThrow(serializerProvider, (Throwable) e, obj2, "");
        }
    }
}

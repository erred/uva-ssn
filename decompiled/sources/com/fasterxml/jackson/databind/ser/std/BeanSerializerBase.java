package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonMappingException.Reference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitable;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import com.fasterxml.jackson.databind.jsonschema.SchemaAware;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.AnyGetterWriter;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerBuilder;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.ResolvableSerializer;
import com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import com.fasterxml.jackson.databind.ser.impl.WritableObjectId;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.Converter;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public abstract class BeanSerializerBase extends StdSerializer<Object> implements JsonFormatVisitable, SchemaAware, ContextualSerializer, ResolvableSerializer {
    protected static final PropertyName NAME_FOR_OBJECT_REF = new PropertyName("#object-ref");
    protected static final BeanPropertyWriter[] NO_PROPS = new BeanPropertyWriter[0];
    protected final AnyGetterWriter _anyGetterWriter;
    protected final BeanPropertyWriter[] _filteredProps;
    protected final ObjectIdWriter _objectIdWriter;
    protected final Object _propertyFilterId;
    protected final BeanPropertyWriter[] _props;
    protected final Shape _serializationShape;
    protected final AnnotatedMember _typeId;

    /* access modifiers changed from: protected */
    public abstract BeanSerializerBase asArraySerializer();

    public abstract void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException;

    public abstract BeanSerializerBase withFilterId(Object obj);

    /* access modifiers changed from: protected */
    public abstract BeanSerializerBase withIgnorals(Set<String> set);

    public abstract BeanSerializerBase withObjectIdWriter(ObjectIdWriter objectIdWriter);

    protected BeanSerializerBase(JavaType javaType, BeanSerializerBuilder beanSerializerBuilder, BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2) {
        super(javaType);
        this._props = beanPropertyWriterArr;
        this._filteredProps = beanPropertyWriterArr2;
        Shape shape = null;
        if (beanSerializerBuilder == null) {
            this._typeId = null;
            this._anyGetterWriter = null;
            this._propertyFilterId = null;
            this._objectIdWriter = null;
            this._serializationShape = null;
            return;
        }
        this._typeId = beanSerializerBuilder.getTypeId();
        this._anyGetterWriter = beanSerializerBuilder.getAnyGetter();
        this._propertyFilterId = beanSerializerBuilder.getFilterId();
        this._objectIdWriter = beanSerializerBuilder.getObjectIdWriter();
        Value findExpectedFormat = beanSerializerBuilder.getBeanDescription().findExpectedFormat(null);
        if (findExpectedFormat != null) {
            shape = findExpectedFormat.getShape();
        }
        this._serializationShape = shape;
    }

    public BeanSerializerBase(BeanSerializerBase beanSerializerBase, BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2) {
        super(beanSerializerBase._handledType);
        this._props = beanPropertyWriterArr;
        this._filteredProps = beanPropertyWriterArr2;
        this._typeId = beanSerializerBase._typeId;
        this._anyGetterWriter = beanSerializerBase._anyGetterWriter;
        this._objectIdWriter = beanSerializerBase._objectIdWriter;
        this._propertyFilterId = beanSerializerBase._propertyFilterId;
        this._serializationShape = beanSerializerBase._serializationShape;
    }

    protected BeanSerializerBase(BeanSerializerBase beanSerializerBase, ObjectIdWriter objectIdWriter) {
        this(beanSerializerBase, objectIdWriter, beanSerializerBase._propertyFilterId);
    }

    protected BeanSerializerBase(BeanSerializerBase beanSerializerBase, ObjectIdWriter objectIdWriter, Object obj) {
        super(beanSerializerBase._handledType);
        this._props = beanSerializerBase._props;
        this._filteredProps = beanSerializerBase._filteredProps;
        this._typeId = beanSerializerBase._typeId;
        this._anyGetterWriter = beanSerializerBase._anyGetterWriter;
        this._objectIdWriter = objectIdWriter;
        this._propertyFilterId = obj;
        this._serializationShape = beanSerializerBase._serializationShape;
    }

    @Deprecated
    protected BeanSerializerBase(BeanSerializerBase beanSerializerBase, String[] strArr) {
        this(beanSerializerBase, (Set<String>) ArrayBuilders.arrayToSet(strArr));
    }

    protected BeanSerializerBase(BeanSerializerBase beanSerializerBase, Set<String> set) {
        ArrayList arrayList;
        super(beanSerializerBase._handledType);
        BeanPropertyWriter[] beanPropertyWriterArr = beanSerializerBase._props;
        BeanPropertyWriter[] beanPropertyWriterArr2 = beanSerializerBase._filteredProps;
        int length = beanPropertyWriterArr.length;
        ArrayList arrayList2 = new ArrayList(length);
        BeanPropertyWriter[] beanPropertyWriterArr3 = null;
        if (beanPropertyWriterArr2 == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(length);
        }
        for (int i = 0; i < length; i++) {
            BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr[i];
            if (set == null || !set.contains(beanPropertyWriter.getName())) {
                arrayList2.add(beanPropertyWriter);
                if (beanPropertyWriterArr2 != null) {
                    arrayList.add(beanPropertyWriterArr2[i]);
                }
            }
        }
        this._props = (BeanPropertyWriter[]) arrayList2.toArray(new BeanPropertyWriter[arrayList2.size()]);
        if (arrayList != null) {
            beanPropertyWriterArr3 = (BeanPropertyWriter[]) arrayList.toArray(new BeanPropertyWriter[arrayList.size()]);
        }
        this._filteredProps = beanPropertyWriterArr3;
        this._typeId = beanSerializerBase._typeId;
        this._anyGetterWriter = beanSerializerBase._anyGetterWriter;
        this._objectIdWriter = beanSerializerBase._objectIdWriter;
        this._propertyFilterId = beanSerializerBase._propertyFilterId;
        this._serializationShape = beanSerializerBase._serializationShape;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public BeanSerializerBase withIgnorals(String[] strArr) {
        return withIgnorals((Set<String>) ArrayBuilders.arrayToSet(strArr));
    }

    protected BeanSerializerBase(BeanSerializerBase beanSerializerBase) {
        this(beanSerializerBase, beanSerializerBase._props, beanSerializerBase._filteredProps);
    }

    protected BeanSerializerBase(BeanSerializerBase beanSerializerBase, NameTransformer nameTransformer) {
        this(beanSerializerBase, rename(beanSerializerBase._props, nameTransformer), rename(beanSerializerBase._filteredProps, nameTransformer));
    }

    private static final BeanPropertyWriter[] rename(BeanPropertyWriter[] beanPropertyWriterArr, NameTransformer nameTransformer) {
        if (beanPropertyWriterArr == null || beanPropertyWriterArr.length == 0 || nameTransformer == null || nameTransformer == NameTransformer.NOP) {
            return beanPropertyWriterArr;
        }
        int length = beanPropertyWriterArr.length;
        BeanPropertyWriter[] beanPropertyWriterArr2 = new BeanPropertyWriter[length];
        for (int i = 0; i < length; i++) {
            BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr[i];
            if (beanPropertyWriter != null) {
                beanPropertyWriterArr2[i] = beanPropertyWriter.rename(nameTransformer);
            }
        }
        return beanPropertyWriterArr2;
    }

    public void resolve(SerializerProvider serializerProvider) throws JsonMappingException {
        int length = this._filteredProps == null ? 0 : this._filteredProps.length;
        int length2 = this._props.length;
        for (int i = 0; i < length2; i++) {
            BeanPropertyWriter beanPropertyWriter = this._props[i];
            if (!beanPropertyWriter.willSuppressNulls() && !beanPropertyWriter.hasNullSerializer()) {
                JsonSerializer findNullValueSerializer = serializerProvider.findNullValueSerializer(beanPropertyWriter);
                if (findNullValueSerializer != null) {
                    beanPropertyWriter.assignNullSerializer(findNullValueSerializer);
                    if (i < length) {
                        BeanPropertyWriter beanPropertyWriter2 = this._filteredProps[i];
                        if (beanPropertyWriter2 != null) {
                            beanPropertyWriter2.assignNullSerializer(findNullValueSerializer);
                        }
                    }
                }
            }
            if (!beanPropertyWriter.hasSerializer()) {
                JsonSerializer findConvertingSerializer = findConvertingSerializer(serializerProvider, beanPropertyWriter);
                if (findConvertingSerializer == null) {
                    JavaType serializationType = beanPropertyWriter.getSerializationType();
                    if (serializationType == null) {
                        serializationType = beanPropertyWriter.getType();
                        if (!serializationType.isFinal()) {
                            if (serializationType.isContainerType() || serializationType.containedTypeCount() > 0) {
                                beanPropertyWriter.setNonTrivialBaseType(serializationType);
                            }
                        }
                    }
                    JsonSerializer findValueSerializer = serializerProvider.findValueSerializer(serializationType, (BeanProperty) beanPropertyWriter);
                    if (serializationType.isContainerType()) {
                        TypeSerializer typeSerializer = (TypeSerializer) serializationType.getContentType().getTypeHandler();
                        if (typeSerializer != null && (findValueSerializer instanceof ContainerSerializer)) {
                            findConvertingSerializer = ((ContainerSerializer) findValueSerializer).withValueTypeSerializer(typeSerializer);
                        }
                    }
                    findConvertingSerializer = findValueSerializer;
                }
                beanPropertyWriter.assignSerializer(findConvertingSerializer);
                if (i < length) {
                    BeanPropertyWriter beanPropertyWriter3 = this._filteredProps[i];
                    if (beanPropertyWriter3 != null) {
                        beanPropertyWriter3.assignSerializer(findConvertingSerializer);
                    }
                }
            }
        }
        if (this._anyGetterWriter != null) {
            this._anyGetterWriter.resolve(serializerProvider);
        }
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<Object> findConvertingSerializer(SerializerProvider serializerProvider, BeanPropertyWriter beanPropertyWriter) throws JsonMappingException {
        AnnotationIntrospector annotationIntrospector = serializerProvider.getAnnotationIntrospector();
        JsonSerializer jsonSerializer = null;
        if (annotationIntrospector != null) {
            AnnotatedMember member = beanPropertyWriter.getMember();
            if (member != null) {
                Object findSerializationConverter = annotationIntrospector.findSerializationConverter(member);
                if (findSerializationConverter != null) {
                    Converter converterInstance = serializerProvider.converterInstance(beanPropertyWriter.getMember(), findSerializationConverter);
                    JavaType outputType = converterInstance.getOutputType(serializerProvider.getTypeFactory());
                    if (!outputType.isJavaLangObject()) {
                        jsonSerializer = serializerProvider.findValueSerializer(outputType, (BeanProperty) beanPropertyWriter);
                    }
                    return new StdDelegatingSerializer(converterInstance, outputType, jsonSerializer);
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x017a A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.JsonSerializer<?> createContextual(com.fasterxml.jackson.databind.SerializerProvider r14, com.fasterxml.jackson.databind.BeanProperty r15) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            r13 = this;
            com.fasterxml.jackson.databind.AnnotationIntrospector r0 = r14.getAnnotationIntrospector()
            r1 = 0
            if (r15 == 0) goto L_0x000f
            if (r0 != 0) goto L_0x000a
            goto L_0x000f
        L_0x000a:
            com.fasterxml.jackson.databind.introspect.AnnotatedMember r2 = r15.getMember()
            goto L_0x0010
        L_0x000f:
            r2 = r1
        L_0x0010:
            com.fasterxml.jackson.databind.SerializationConfig r3 = r14.getConfig()
            java.lang.Class r4 = r13.handledType()
            com.fasterxml.jackson.annotation.JsonFormat$Value r4 = r13.findFormatOverrides(r14, r15, r4)
            if (r4 == 0) goto L_0x0059
            boolean r5 = r4.hasShape()
            if (r5 == 0) goto L_0x0059
            com.fasterxml.jackson.annotation.JsonFormat$Shape r5 = r4.getShape()
            com.fasterxml.jackson.annotation.JsonFormat$Shape r6 = com.fasterxml.jackson.annotation.JsonFormat.Shape.ANY
            if (r5 == r6) goto L_0x005a
            com.fasterxml.jackson.annotation.JsonFormat$Shape r6 = r13._serializationShape
            if (r5 == r6) goto L_0x005a
            java.lang.Class r6 = r13._handledType
            boolean r6 = r6.isEnum()
            if (r6 == 0) goto L_0x005a
            int[] r6 = com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.C19811.$SwitchMap$com$fasterxml$jackson$annotation$JsonFormat$Shape
            int r7 = r5.ordinal()
            r6 = r6[r7]
            switch(r6) {
                case 1: goto L_0x0044;
                case 2: goto L_0x0044;
                case 3: goto L_0x0044;
                default: goto L_0x0043;
            }
        L_0x0043:
            goto L_0x005a
        L_0x0044:
            java.lang.Class r0 = r13._handledType
            com.fasterxml.jackson.databind.BeanDescription r0 = r3.introspectClassAnnotations(r0)
            java.lang.Class r1 = r13._handledType
            com.fasterxml.jackson.databind.SerializationConfig r2 = r14.getConfig()
            com.fasterxml.jackson.databind.ser.std.EnumSerializer r0 = com.fasterxml.jackson.databind.ser.std.EnumSerializer.construct(r1, r2, r0, r4)
            com.fasterxml.jackson.databind.JsonSerializer r14 = r14.handlePrimaryContextualization(r0, r15)
            return r14
        L_0x0059:
            r5 = r1
        L_0x005a:
            com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter r3 = r13._objectIdWriter
            if (r2 == 0) goto L_0x0144
            com.fasterxml.jackson.annotation.JsonIgnoreProperties$Value r4 = r0.findPropertyIgnorals(r2)
            if (r4 == 0) goto L_0x0069
            java.util.Set r4 = r4.findIgnoredForSerialization()
            goto L_0x006a
        L_0x0069:
            r4 = r1
        L_0x006a:
            com.fasterxml.jackson.databind.introspect.ObjectIdInfo r6 = r0.findObjectIdInfo(r2)
            if (r6 != 0) goto L_0x0084
            if (r3 == 0) goto L_0x0130
            com.fasterxml.jackson.databind.introspect.ObjectIdInfo r6 = r0.findObjectReferenceInfo(r2, r1)
            if (r6 == 0) goto L_0x0130
            com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter r3 = r13._objectIdWriter
            boolean r6 = r6.getAlwaysAsId()
            com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter r3 = r3.withAlwaysAsId(r6)
            goto L_0x0130
        L_0x0084:
            com.fasterxml.jackson.databind.introspect.ObjectIdInfo r3 = r0.findObjectReferenceInfo(r2, r6)
            java.lang.Class r6 = r3.getGeneratorType()
            com.fasterxml.jackson.databind.JavaType r7 = r14.constructType(r6)
            com.fasterxml.jackson.databind.type.TypeFactory r8 = r14.getTypeFactory()
            java.lang.Class<com.fasterxml.jackson.annotation.ObjectIdGenerator> r9 = com.fasterxml.jackson.annotation.ObjectIdGenerator.class
            com.fasterxml.jackson.databind.JavaType[] r7 = r8.findTypeParameters(r7, r9)
            r8 = 0
            r7 = r7[r8]
            java.lang.Class<com.fasterxml.jackson.annotation.ObjectIdGenerators$PropertyGenerator> r9 = com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator.class
            if (r6 != r9) goto L_0x0120
            com.fasterxml.jackson.databind.PropertyName r6 = r3.getPropertyName()
            java.lang.String r6 = r6.getSimpleName()
            com.fasterxml.jackson.databind.ser.BeanPropertyWriter[] r7 = r13._props
            int r7 = r7.length
            r9 = 0
        L_0x00ad:
            if (r9 == r7) goto L_0x00f6
            com.fasterxml.jackson.databind.ser.BeanPropertyWriter[] r10 = r13._props
            r10 = r10[r9]
            java.lang.String r11 = r10.getName()
            boolean r11 = r6.equals(r11)
            if (r11 == 0) goto L_0x00f3
            if (r9 <= 0) goto L_0x00de
            com.fasterxml.jackson.databind.ser.BeanPropertyWriter[] r6 = r13._props
            com.fasterxml.jackson.databind.ser.BeanPropertyWriter[] r7 = r13._props
            r11 = 1
            java.lang.System.arraycopy(r6, r8, r7, r11, r9)
            com.fasterxml.jackson.databind.ser.BeanPropertyWriter[] r6 = r13._props
            r6[r8] = r10
            com.fasterxml.jackson.databind.ser.BeanPropertyWriter[] r6 = r13._filteredProps
            if (r6 == 0) goto L_0x00de
            com.fasterxml.jackson.databind.ser.BeanPropertyWriter[] r6 = r13._filteredProps
            r6 = r6[r9]
            com.fasterxml.jackson.databind.ser.BeanPropertyWriter[] r7 = r13._filteredProps
            com.fasterxml.jackson.databind.ser.BeanPropertyWriter[] r12 = r13._filteredProps
            java.lang.System.arraycopy(r7, r8, r12, r11, r9)
            com.fasterxml.jackson.databind.ser.BeanPropertyWriter[] r7 = r13._filteredProps
            r7[r8] = r6
        L_0x00de:
            com.fasterxml.jackson.databind.JavaType r6 = r10.getType()
            com.fasterxml.jackson.databind.ser.impl.PropertyBasedObjectIdGenerator r7 = new com.fasterxml.jackson.databind.ser.impl.PropertyBasedObjectIdGenerator
            r7.<init>(r3, r10)
            r8 = r1
            com.fasterxml.jackson.databind.PropertyName r8 = (com.fasterxml.jackson.databind.PropertyName) r8
            boolean r3 = r3.getAlwaysAsId()
            com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter r3 = com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter.construct(r6, r8, r7, r3)
            goto L_0x0130
        L_0x00f3:
            int r9 = r9 + 1
            goto L_0x00ad
        L_0x00f6:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r0 = "Invalid Object Id definition for "
            r15.append(r0)
            java.lang.Class r0 = r13._handledType
            java.lang.String r0 = r0.getName()
            r15.append(r0)
            java.lang.String r0 = ": can not find property with name '"
            r15.append(r0)
            r15.append(r6)
            java.lang.String r0 = "'"
            r15.append(r0)
            java.lang.String r15 = r15.toString()
            r14.<init>(r15)
            throw r14
        L_0x0120:
            com.fasterxml.jackson.annotation.ObjectIdGenerator r6 = r14.objectIdGeneratorInstance(r2, r3)
            com.fasterxml.jackson.databind.PropertyName r8 = r3.getPropertyName()
            boolean r3 = r3.getAlwaysAsId()
            com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter r3 = com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter.construct(r7, r8, r6, r3)
        L_0x0130:
            java.lang.Object r0 = r0.findFilterId(r2)
            if (r0 == 0) goto L_0x0145
            java.lang.Object r2 = r13._propertyFilterId
            if (r2 == 0) goto L_0x0142
            java.lang.Object r2 = r13._propertyFilterId
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x0145
        L_0x0142:
            r1 = r0
            goto L_0x0145
        L_0x0144:
            r4 = r1
        L_0x0145:
            if (r3 == 0) goto L_0x015a
            com.fasterxml.jackson.databind.JavaType r0 = r3.idType
            com.fasterxml.jackson.databind.JsonSerializer r14 = r14.findValueSerializer(r0, r15)
            com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter r14 = r3.withSerializer(r14)
            com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter r15 = r13._objectIdWriter
            if (r14 == r15) goto L_0x015a
            com.fasterxml.jackson.databind.ser.std.BeanSerializerBase r14 = r13.withObjectIdWriter(r14)
            goto L_0x015b
        L_0x015a:
            r14 = r13
        L_0x015b:
            if (r4 == 0) goto L_0x0167
            boolean r15 = r4.isEmpty()
            if (r15 != 0) goto L_0x0167
            com.fasterxml.jackson.databind.ser.std.BeanSerializerBase r14 = r14.withIgnorals(r4)
        L_0x0167:
            if (r1 == 0) goto L_0x016d
            com.fasterxml.jackson.databind.ser.std.BeanSerializerBase r14 = r14.withFilterId(r1)
        L_0x016d:
            if (r5 != 0) goto L_0x0171
            com.fasterxml.jackson.annotation.JsonFormat$Shape r5 = r13._serializationShape
        L_0x0171:
            com.fasterxml.jackson.annotation.JsonFormat$Shape r15 = com.fasterxml.jackson.annotation.JsonFormat.Shape.ARRAY
            if (r5 != r15) goto L_0x017a
            com.fasterxml.jackson.databind.ser.std.BeanSerializerBase r14 = r14.asArraySerializer()
            return r14
        L_0x017a:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.createContextual(com.fasterxml.jackson.databind.SerializerProvider, com.fasterxml.jackson.databind.BeanProperty):com.fasterxml.jackson.databind.JsonSerializer");
    }

    public Iterator<PropertyWriter> properties() {
        return Arrays.asList(this._props).iterator();
    }

    public boolean usesObjectId() {
        return this._objectIdWriter != null;
    }

    public void serializeWithType(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        if (this._objectIdWriter != null) {
            jsonGenerator.setCurrentValue(obj);
            _serializeWithObjectId(obj, jsonGenerator, serializerProvider, typeSerializer);
            return;
        }
        String _customTypeId = this._typeId == null ? null : _customTypeId(obj);
        if (_customTypeId == null) {
            typeSerializer.writeTypePrefixForObject(obj, jsonGenerator);
        } else {
            typeSerializer.writeCustomTypePrefixForObject(obj, jsonGenerator, _customTypeId);
        }
        jsonGenerator.setCurrentValue(obj);
        if (this._propertyFilterId != null) {
            serializeFieldsFiltered(obj, jsonGenerator, serializerProvider);
        } else {
            serializeFields(obj, jsonGenerator, serializerProvider);
        }
        if (_customTypeId == null) {
            typeSerializer.writeTypeSuffixForObject(obj, jsonGenerator);
        } else {
            typeSerializer.writeCustomTypeSuffixForObject(obj, jsonGenerator, _customTypeId);
        }
    }

    /* access modifiers changed from: protected */
    public final void _serializeWithObjectId(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, boolean z) throws IOException {
        ObjectIdWriter objectIdWriter = this._objectIdWriter;
        WritableObjectId findObjectId = serializerProvider.findObjectId(obj, objectIdWriter.generator);
        if (!findObjectId.writeAsId(jsonGenerator, serializerProvider, objectIdWriter)) {
            Object generateId = findObjectId.generateId(obj);
            if (objectIdWriter.alwaysAsId) {
                objectIdWriter.serializer.serialize(generateId, jsonGenerator, serializerProvider);
                return;
            }
            if (z) {
                jsonGenerator.writeStartObject(obj);
            }
            findObjectId.writeAsField(jsonGenerator, serializerProvider, objectIdWriter);
            if (this._propertyFilterId != null) {
                serializeFieldsFiltered(obj, jsonGenerator, serializerProvider);
            } else {
                serializeFields(obj, jsonGenerator, serializerProvider);
            }
            if (z) {
                jsonGenerator.writeEndObject();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void _serializeWithObjectId(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        ObjectIdWriter objectIdWriter = this._objectIdWriter;
        WritableObjectId findObjectId = serializerProvider.findObjectId(obj, objectIdWriter.generator);
        if (!findObjectId.writeAsId(jsonGenerator, serializerProvider, objectIdWriter)) {
            Object generateId = findObjectId.generateId(obj);
            if (objectIdWriter.alwaysAsId) {
                objectIdWriter.serializer.serialize(generateId, jsonGenerator, serializerProvider);
            } else {
                _serializeObjectId(obj, jsonGenerator, serializerProvider, typeSerializer, findObjectId);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void _serializeObjectId(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer, WritableObjectId writableObjectId) throws IOException {
        ObjectIdWriter objectIdWriter = this._objectIdWriter;
        String _customTypeId = this._typeId == null ? null : _customTypeId(obj);
        if (_customTypeId == null) {
            typeSerializer.writeTypePrefixForObject(obj, jsonGenerator);
        } else {
            typeSerializer.writeCustomTypePrefixForObject(obj, jsonGenerator, _customTypeId);
        }
        writableObjectId.writeAsField(jsonGenerator, serializerProvider, objectIdWriter);
        if (this._propertyFilterId != null) {
            serializeFieldsFiltered(obj, jsonGenerator, serializerProvider);
        } else {
            serializeFields(obj, jsonGenerator, serializerProvider);
        }
        if (_customTypeId == null) {
            typeSerializer.writeTypeSuffixForObject(obj, jsonGenerator);
        } else {
            typeSerializer.writeCustomTypeSuffixForObject(obj, jsonGenerator, _customTypeId);
        }
    }

    /* access modifiers changed from: protected */
    public final String _customTypeId(Object obj) {
        Object value = this._typeId.getValue(obj);
        if (value == null) {
            return "";
        }
        return value instanceof String ? (String) value : value.toString();
    }

    /* access modifiers changed from: protected */
    public void serializeFields(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        BeanPropertyWriter[] beanPropertyWriterArr;
        if (this._filteredProps == null || serializerProvider.getActiveView() == null) {
            beanPropertyWriterArr = this._props;
        } else {
            beanPropertyWriterArr = this._filteredProps;
        }
        try {
            for (BeanPropertyWriter beanPropertyWriter : beanPropertyWriterArr) {
                if (beanPropertyWriter != null) {
                    beanPropertyWriter.serializeAsField(obj, jsonGenerator, serializerProvider);
                }
            }
            if (this._anyGetterWriter != null) {
                this._anyGetterWriter.getAndSerialize(obj, jsonGenerator, serializerProvider);
            }
        } catch (Exception e) {
            wrapAndThrow(serializerProvider, (Throwable) e, obj, 0 == beanPropertyWriterArr.length ? "[anySetter]" : beanPropertyWriterArr[0].getName());
        } catch (StackOverflowError e2) {
            JsonMappingException jsonMappingException = new JsonMappingException((Closeable) jsonGenerator, "Infinite recursion (StackOverflowError)", (Throwable) e2);
            jsonMappingException.prependPath(new Reference(obj, 0 == beanPropertyWriterArr.length ? "[anySetter]" : beanPropertyWriterArr[0].getName()));
            throw jsonMappingException;
        }
    }

    /* access modifiers changed from: protected */
    public void serializeFieldsFiltered(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
        BeanPropertyWriter[] beanPropertyWriterArr;
        if (this._filteredProps == null || serializerProvider.getActiveView() == null) {
            beanPropertyWriterArr = this._props;
        } else {
            beanPropertyWriterArr = this._filteredProps;
        }
        PropertyFilter findPropertyFilter = findPropertyFilter(serializerProvider, this._propertyFilterId, obj);
        if (findPropertyFilter == null) {
            serializeFields(obj, jsonGenerator, serializerProvider);
            return;
        }
        try {
            for (BeanPropertyWriter beanPropertyWriter : beanPropertyWriterArr) {
                if (beanPropertyWriter != null) {
                    findPropertyFilter.serializeAsField(obj, jsonGenerator, serializerProvider, beanPropertyWriter);
                }
            }
            if (this._anyGetterWriter != null) {
                this._anyGetterWriter.getAndFilter(obj, jsonGenerator, serializerProvider, findPropertyFilter);
            }
        } catch (Exception e) {
            wrapAndThrow(serializerProvider, (Throwable) e, obj, 0 == beanPropertyWriterArr.length ? "[anySetter]" : beanPropertyWriterArr[0].getName());
        } catch (StackOverflowError e2) {
            JsonMappingException jsonMappingException = new JsonMappingException((Closeable) jsonGenerator, "Infinite recursion (StackOverflowError)", (Throwable) e2);
            jsonMappingException.prependPath(new Reference(obj, 0 == beanPropertyWriterArr.length ? "[anySetter]" : beanPropertyWriterArr[0].getName()));
            throw jsonMappingException;
        }
    }

    @Deprecated
    public JsonNode getSchema(SerializerProvider serializerProvider, Type type) throws JsonMappingException {
        ObjectNode createSchemaNode = createSchemaNode("object", true);
        JsonSerializableSchema jsonSerializableSchema = (JsonSerializableSchema) this._handledType.getAnnotation(JsonSerializableSchema.class);
        if (jsonSerializableSchema != null) {
            String id = jsonSerializableSchema.mo10827id();
            if (id != null && id.length() > 0) {
                createSchemaNode.put("id", id);
            }
        }
        ObjectNode objectNode = createSchemaNode.objectNode();
        PropertyFilter propertyFilter = null;
        if (this._propertyFilterId != null) {
            propertyFilter = findPropertyFilter(serializerProvider, this._propertyFilterId, null);
        }
        for (BeanPropertyWriter beanPropertyWriter : this._props) {
            if (propertyFilter == null) {
                beanPropertyWriter.depositSchemaProperty(objectNode, serializerProvider);
            } else {
                propertyFilter.depositSchemaProperty((PropertyWriter) beanPropertyWriter, objectNode, serializerProvider);
            }
        }
        createSchemaNode.set("properties", objectNode);
        return createSchemaNode;
    }

    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) throws JsonMappingException {
        BeanPropertyWriter[] beanPropertyWriterArr;
        if (jsonFormatVisitorWrapper != null) {
            JsonObjectFormatVisitor expectObjectFormat = jsonFormatVisitorWrapper.expectObjectFormat(javaType);
            if (expectObjectFormat != null) {
                SerializerProvider provider = jsonFormatVisitorWrapper.getProvider();
                int i = 0;
                Class cls = null;
                if (this._propertyFilterId != null) {
                    PropertyFilter findPropertyFilter = findPropertyFilter(jsonFormatVisitorWrapper.getProvider(), this._propertyFilterId, null);
                    int length = this._props.length;
                    while (i < length) {
                        findPropertyFilter.depositSchemaProperty((PropertyWriter) this._props[i], expectObjectFormat, provider);
                        i++;
                    }
                } else {
                    if (!(this._filteredProps == null || provider == null)) {
                        cls = provider.getActiveView();
                    }
                    if (cls != null) {
                        beanPropertyWriterArr = this._filteredProps;
                    } else {
                        beanPropertyWriterArr = this._props;
                    }
                    int length2 = beanPropertyWriterArr.length;
                    while (i < length2) {
                        BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr[i];
                        if (beanPropertyWriter != null) {
                            beanPropertyWriter.depositSchemaProperty(expectObjectFormat, provider);
                        }
                        i++;
                    }
                }
            }
        }
    }
}

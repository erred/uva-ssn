package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JsonInclude.Value;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class POJOPropertyBuilder extends BeanPropertyDefinition implements Comparable<POJOPropertyBuilder> {
    protected final AnnotationIntrospector _annotationIntrospector;
    protected final MapperConfig<?> _config;
    protected Linked<AnnotatedParameter> _ctorParameters;
    protected Linked<AnnotatedField> _fields;
    protected final boolean _forSerialization;
    protected Linked<AnnotatedMethod> _getters;
    protected final PropertyName _internalName;
    protected final PropertyName _name;
    protected Linked<AnnotatedMethod> _setters;

    protected static final class Linked<T> {
        public final boolean isMarkedIgnored;
        public final boolean isNameExplicit;
        public final boolean isVisible;
        public final PropertyName name;
        public final Linked<T> next;
        public final T value;

        public Linked(T t, Linked<T> linked, PropertyName propertyName, boolean z, boolean z2, boolean z3) {
            this.value = t;
            this.next = linked;
            this.name = (propertyName == null || propertyName.isEmpty()) ? null : propertyName;
            if (z) {
                if (this.name == null) {
                    throw new IllegalArgumentException("Can not pass true for 'explName' if name is null/empty");
                } else if (!propertyName.hasSimpleName()) {
                    z = false;
                }
            }
            this.isNameExplicit = z;
            this.isVisible = z2;
            this.isMarkedIgnored = z3;
        }

        public Linked<T> withoutNext() {
            if (this.next == null) {
                return this;
            }
            Linked linked = new Linked(this.value, null, this.name, this.isNameExplicit, this.isVisible, this.isMarkedIgnored);
            return linked;
        }

        public Linked<T> withValue(T t) {
            if (t == this.value) {
                return this;
            }
            Linked linked = new Linked(t, this.next, this.name, this.isNameExplicit, this.isVisible, this.isMarkedIgnored);
            return linked;
        }

        public Linked<T> withNext(Linked<T> linked) {
            if (linked == this.next) {
                return this;
            }
            Linked linked2 = new Linked(this.value, linked, this.name, this.isNameExplicit, this.isVisible, this.isMarkedIgnored);
            return linked2;
        }

        public Linked<T> withoutIgnored() {
            if (this.isMarkedIgnored) {
                return this.next == null ? null : this.next.withoutIgnored();
            }
            if (this.next != null) {
                Linked<T> withoutIgnored = this.next.withoutIgnored();
                if (withoutIgnored != this.next) {
                    return withNext(withoutIgnored);
                }
            }
            return this;
        }

        public Linked<T> withoutNonVisible() {
            Linked<T> withoutNonVisible = this.next == null ? null : this.next.withoutNonVisible();
            return this.isVisible ? withNext(withoutNonVisible) : withoutNonVisible;
        }

        /* access modifiers changed from: protected */
        public Linked<T> append(Linked<T> linked) {
            if (this.next == null) {
                return withNext(linked);
            }
            return withNext(this.next.append(linked));
        }

        public Linked<T> trimByVisibility() {
            if (this.next == null) {
                return this;
            }
            Linked<T> trimByVisibility = this.next.trimByVisibility();
            if (this.name != null) {
                if (trimByVisibility.name == null) {
                    return withNext(null);
                }
                return withNext(trimByVisibility);
            } else if (trimByVisibility.name != null) {
                return trimByVisibility;
            } else {
                if (this.isVisible == trimByVisibility.isVisible) {
                    return withNext(trimByVisibility);
                }
                if (this.isVisible) {
                    trimByVisibility = withNext(null);
                }
                return trimByVisibility;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.value.toString());
            sb.append("[visible=");
            sb.append(this.isVisible);
            sb.append(",ignore=");
            sb.append(this.isMarkedIgnored);
            sb.append(",explicitName=");
            sb.append(this.isNameExplicit);
            sb.append("]");
            String sb2 = sb.toString();
            if (this.next == null) {
                return sb2;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append(", ");
            sb3.append(this.next.toString());
            return sb3.toString();
        }
    }

    protected static class MemberIterator<T extends AnnotatedMember> implements Iterator<T> {
        private Linked<T> next;

        public MemberIterator(Linked<T> linked) {
            this.next = linked;
        }

        public boolean hasNext() {
            return this.next != null;
        }

        public T next() {
            if (this.next != null) {
                T t = (AnnotatedMember) this.next.value;
                this.next = this.next.next;
                return t;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private interface WithMember<T> {
        T withMember(AnnotatedMember annotatedMember);
    }

    public POJOPropertyBuilder(MapperConfig<?> mapperConfig, AnnotationIntrospector annotationIntrospector, boolean z, PropertyName propertyName) {
        this(mapperConfig, annotationIntrospector, z, propertyName, propertyName);
    }

    protected POJOPropertyBuilder(MapperConfig<?> mapperConfig, AnnotationIntrospector annotationIntrospector, boolean z, PropertyName propertyName, PropertyName propertyName2) {
        this._config = mapperConfig;
        this._annotationIntrospector = annotationIntrospector;
        this._internalName = propertyName;
        this._name = propertyName2;
        this._forSerialization = z;
    }

    public POJOPropertyBuilder(POJOPropertyBuilder pOJOPropertyBuilder, PropertyName propertyName) {
        this._config = pOJOPropertyBuilder._config;
        this._annotationIntrospector = pOJOPropertyBuilder._annotationIntrospector;
        this._internalName = pOJOPropertyBuilder._internalName;
        this._name = propertyName;
        this._fields = pOJOPropertyBuilder._fields;
        this._ctorParameters = pOJOPropertyBuilder._ctorParameters;
        this._getters = pOJOPropertyBuilder._getters;
        this._setters = pOJOPropertyBuilder._setters;
        this._forSerialization = pOJOPropertyBuilder._forSerialization;
    }

    public POJOPropertyBuilder withName(PropertyName propertyName) {
        return new POJOPropertyBuilder(this, propertyName);
    }

    public POJOPropertyBuilder withSimpleName(String str) {
        PropertyName withSimpleName = this._name.withSimpleName(str);
        return withSimpleName == this._name ? this : new POJOPropertyBuilder(this, withSimpleName);
    }

    public int compareTo(POJOPropertyBuilder pOJOPropertyBuilder) {
        if (this._ctorParameters != null) {
            if (pOJOPropertyBuilder._ctorParameters == null) {
                return -1;
            }
        } else if (pOJOPropertyBuilder._ctorParameters != null) {
            return 1;
        }
        return getName().compareTo(pOJOPropertyBuilder.getName());
    }

    public String getName() {
        if (this._name == null) {
            return null;
        }
        return this._name.getSimpleName();
    }

    public PropertyName getFullName() {
        return this._name;
    }

    public boolean hasName(PropertyName propertyName) {
        return this._name.equals(propertyName);
    }

    public String getInternalName() {
        return this._internalName.getSimpleName();
    }

    public PropertyName getWrapperName() {
        AnnotatedMember primaryMember = getPrimaryMember();
        if (primaryMember == null || this._annotationIntrospector == null) {
            return null;
        }
        return this._annotationIntrospector.findWrapperName(primaryMember);
    }

    public boolean isExplicitlyIncluded() {
        return _anyExplicits(this._fields) || _anyExplicits(this._getters) || _anyExplicits(this._setters) || _anyExplicitNames(this._ctorParameters);
    }

    public boolean isExplicitlyNamed() {
        return _anyExplicitNames(this._fields) || _anyExplicitNames(this._getters) || _anyExplicitNames(this._setters) || _anyExplicitNames(this._ctorParameters);
    }

    public boolean hasGetter() {
        return this._getters != null;
    }

    public boolean hasSetter() {
        return this._setters != null;
    }

    public boolean hasField() {
        return this._fields != null;
    }

    public boolean hasConstructorParameter() {
        return this._ctorParameters != null;
    }

    public boolean couldDeserialize() {
        return (this._ctorParameters == null && this._setters == null && this._fields == null) ? false : true;
    }

    public boolean couldSerialize() {
        return (this._getters == null && this._fields == null) ? false : true;
    }

    public AnnotatedMethod getGetter() {
        Linked linked = this._getters;
        if (linked == null) {
            return null;
        }
        Linked linked2 = linked.next;
        if (linked2 == null) {
            return (AnnotatedMethod) linked.value;
        }
        while (linked2 != null) {
            Class declaringClass = ((AnnotatedMethod) linked.value).getDeclaringClass();
            Class declaringClass2 = ((AnnotatedMethod) linked2.value).getDeclaringClass();
            if (declaringClass != declaringClass2) {
                if (!declaringClass.isAssignableFrom(declaringClass2)) {
                    if (declaringClass2.isAssignableFrom(declaringClass)) {
                        continue;
                        linked2 = linked2.next;
                    }
                }
                linked = linked2;
                linked2 = linked2.next;
            }
            int _getterPriority = _getterPriority((AnnotatedMethod) linked2.value);
            int _getterPriority2 = _getterPriority((AnnotatedMethod) linked.value);
            if (_getterPriority != _getterPriority2) {
                if (_getterPriority >= _getterPriority2) {
                    linked2 = linked2.next;
                }
                linked = linked2;
                linked2 = linked2.next;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Conflicting getter definitions for property \"");
                sb.append(getName());
                sb.append("\": ");
                sb.append(((AnnotatedMethod) linked.value).getFullName());
                sb.append(" vs ");
                sb.append(((AnnotatedMethod) linked2.value).getFullName());
                throw new IllegalArgumentException(sb.toString());
            }
        }
        this._getters = linked.withoutNext();
        return (AnnotatedMethod) linked.value;
    }

    public AnnotatedMethod getSetter() {
        Linked linked = this._setters;
        if (linked == null) {
            return null;
        }
        Linked linked2 = linked.next;
        if (linked2 == null) {
            return (AnnotatedMethod) linked.value;
        }
        while (linked2 != null) {
            Class declaringClass = ((AnnotatedMethod) linked.value).getDeclaringClass();
            Class declaringClass2 = ((AnnotatedMethod) linked2.value).getDeclaringClass();
            if (declaringClass != declaringClass2) {
                if (!declaringClass.isAssignableFrom(declaringClass2)) {
                    if (declaringClass2.isAssignableFrom(declaringClass)) {
                        continue;
                        linked2 = linked2.next;
                    }
                }
                linked = linked2;
                linked2 = linked2.next;
            }
            AnnotatedMethod annotatedMethod = (AnnotatedMethod) linked2.value;
            AnnotatedMethod annotatedMethod2 = (AnnotatedMethod) linked.value;
            int _setterPriority = _setterPriority(annotatedMethod);
            int _setterPriority2 = _setterPriority(annotatedMethod2);
            if (_setterPriority != _setterPriority2) {
                if (_setterPriority >= _setterPriority2) {
                    linked2 = linked2.next;
                }
                linked = linked2;
                linked2 = linked2.next;
            } else {
                if (this._annotationIntrospector != null) {
                    AnnotatedMethod resolveSetterConflict = this._annotationIntrospector.resolveSetterConflict(this._config, annotatedMethod2, annotatedMethod);
                    if (resolveSetterConflict != annotatedMethod2) {
                        if (resolveSetterConflict != annotatedMethod) {
                        }
                        linked = linked2;
                        linked2 = linked2.next;
                    } else {
                        continue;
                        linked2 = linked2.next;
                    }
                }
                throw new IllegalArgumentException(String.format("Conflicting setter definitions for property \"%s\": %s vs %s", new Object[]{getName(), ((AnnotatedMethod) linked.value).getFullName(), ((AnnotatedMethod) linked2.value).getFullName()}));
            }
        }
        this._setters = linked.withoutNext();
        return (AnnotatedMethod) linked.value;
    }

    public AnnotatedField getField() {
        if (this._fields == null) {
            return null;
        }
        AnnotatedField annotatedField = (AnnotatedField) this._fields.value;
        Linked<T> linked = this._fields.next;
        while (linked != null) {
            AnnotatedField annotatedField2 = (AnnotatedField) linked.value;
            Class declaringClass = annotatedField.getDeclaringClass();
            Class declaringClass2 = annotatedField2.getDeclaringClass();
            if (declaringClass != declaringClass2) {
                if (declaringClass.isAssignableFrom(declaringClass2)) {
                    annotatedField = annotatedField2;
                } else if (declaringClass2.isAssignableFrom(declaringClass)) {
                }
                linked = linked.next;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Multiple fields representing property \"");
            sb.append(getName());
            sb.append("\": ");
            sb.append(annotatedField.getFullName());
            sb.append(" vs ");
            sb.append(annotatedField2.getFullName());
            throw new IllegalArgumentException(sb.toString());
        }
        return annotatedField;
    }

    public AnnotatedParameter getConstructorParameter() {
        if (this._ctorParameters == null) {
            return null;
        }
        Linked linked = this._ctorParameters;
        while (!(((AnnotatedParameter) linked.value).getOwner() instanceof AnnotatedConstructor)) {
            linked = linked.next;
            if (linked == null) {
                return (AnnotatedParameter) this._ctorParameters.value;
            }
        }
        return (AnnotatedParameter) linked.value;
    }

    public Iterator<AnnotatedParameter> getConstructorParameters() {
        if (this._ctorParameters == null) {
            return ClassUtil.emptyIterator();
        }
        return new MemberIterator(this._ctorParameters);
    }

    public AnnotatedMember getAccessor() {
        AnnotatedMethod getter = getGetter();
        return getter == null ? getField() : getter;
    }

    public AnnotatedMember getMutator() {
        AnnotatedParameter constructorParameter = getConstructorParameter();
        if (constructorParameter != null) {
            return constructorParameter;
        }
        AnnotatedMethod setter = getSetter();
        return setter == null ? getField() : setter;
    }

    public AnnotatedMember getNonConstructorMutator() {
        AnnotatedMethod setter = getSetter();
        return setter == null ? getField() : setter;
    }

    public AnnotatedMember getPrimaryMember() {
        if (this._forSerialization) {
            return getAccessor();
        }
        return getMutator();
    }

    /* access modifiers changed from: protected */
    public int _getterPriority(AnnotatedMethod annotatedMethod) {
        String name = annotatedMethod.getName();
        if (name.startsWith("get") && name.length() > 3) {
            return 1;
        }
        if (!name.startsWith("is") || name.length() <= 2) {
            return 3;
        }
        return 2;
    }

    /* access modifiers changed from: protected */
    public int _setterPriority(AnnotatedMethod annotatedMethod) {
        String name = annotatedMethod.getName();
        return (!name.startsWith("set") || name.length() <= 3) ? 2 : 1;
    }

    public Class<?>[] findViews() {
        return (Class[]) fromMemberAnnotations(new WithMember<Class<?>[]>() {
            public Class<?>[] withMember(AnnotatedMember annotatedMember) {
                return POJOPropertyBuilder.this._annotationIntrospector.findViews(annotatedMember);
            }
        });
    }

    public ReferenceProperty findReferenceType() {
        return (ReferenceProperty) fromMemberAnnotations(new WithMember<ReferenceProperty>() {
            public ReferenceProperty withMember(AnnotatedMember annotatedMember) {
                return POJOPropertyBuilder.this._annotationIntrospector.findReferenceType(annotatedMember);
            }
        });
    }

    public boolean isTypeId() {
        Boolean bool = (Boolean) fromMemberAnnotations(new WithMember<Boolean>() {
            public Boolean withMember(AnnotatedMember annotatedMember) {
                return POJOPropertyBuilder.this._annotationIntrospector.isTypeId(annotatedMember);
            }
        });
        return bool != null && bool.booleanValue();
    }

    public PropertyMetadata getMetadata() {
        Boolean _findRequired = _findRequired();
        String _findDescription = _findDescription();
        Integer _findIndex = _findIndex();
        String _findDefaultValue = _findDefaultValue();
        if (_findRequired != null || _findIndex != null || _findDefaultValue != null) {
            return PropertyMetadata.construct(_findRequired, _findDescription, _findIndex, _findDefaultValue);
        }
        return _findDescription == null ? PropertyMetadata.STD_REQUIRED_OR_OPTIONAL : PropertyMetadata.STD_REQUIRED_OR_OPTIONAL.withDescription(_findDescription);
    }

    /* access modifiers changed from: protected */
    public Boolean _findRequired() {
        return (Boolean) fromMemberAnnotations(new WithMember<Boolean>() {
            public Boolean withMember(AnnotatedMember annotatedMember) {
                return POJOPropertyBuilder.this._annotationIntrospector.hasRequiredMarker(annotatedMember);
            }
        });
    }

    /* access modifiers changed from: protected */
    public String _findDescription() {
        return (String) fromMemberAnnotations(new WithMember<String>() {
            public String withMember(AnnotatedMember annotatedMember) {
                return POJOPropertyBuilder.this._annotationIntrospector.findPropertyDescription(annotatedMember);
            }
        });
    }

    /* access modifiers changed from: protected */
    public Integer _findIndex() {
        return (Integer) fromMemberAnnotations(new WithMember<Integer>() {
            public Integer withMember(AnnotatedMember annotatedMember) {
                return POJOPropertyBuilder.this._annotationIntrospector.findPropertyIndex(annotatedMember);
            }
        });
    }

    /* access modifiers changed from: protected */
    public String _findDefaultValue() {
        return (String) fromMemberAnnotations(new WithMember<String>() {
            public String withMember(AnnotatedMember annotatedMember) {
                return POJOPropertyBuilder.this._annotationIntrospector.findPropertyDefaultValue(annotatedMember);
            }
        });
    }

    public ObjectIdInfo findObjectIdInfo() {
        return (ObjectIdInfo) fromMemberAnnotations(new WithMember<ObjectIdInfo>() {
            public ObjectIdInfo withMember(AnnotatedMember annotatedMember) {
                ObjectIdInfo findObjectIdInfo = POJOPropertyBuilder.this._annotationIntrospector.findObjectIdInfo(annotatedMember);
                return findObjectIdInfo != null ? POJOPropertyBuilder.this._annotationIntrospector.findObjectReferenceInfo(annotatedMember, findObjectIdInfo) : findObjectIdInfo;
            }
        });
    }

    public Value findInclusion() {
        Value findPropertyInclusion = this._annotationIntrospector == null ? null : this._annotationIntrospector.findPropertyInclusion(getAccessor());
        return findPropertyInclusion == null ? Value.empty() : findPropertyInclusion;
    }

    public Access findAccess() {
        return (Access) fromMemberAnnotationsExcept(new WithMember<Access>() {
            public Access withMember(AnnotatedMember annotatedMember) {
                return POJOPropertyBuilder.this._annotationIntrospector.findPropertyAccess(annotatedMember);
            }
        }, Access.AUTO);
    }

    public void addField(AnnotatedField annotatedField, PropertyName propertyName, boolean z, boolean z2, boolean z3) {
        Linked linked = new Linked(annotatedField, this._fields, propertyName, z, z2, z3);
        this._fields = linked;
    }

    public void addCtor(AnnotatedParameter annotatedParameter, PropertyName propertyName, boolean z, boolean z2, boolean z3) {
        Linked linked = new Linked(annotatedParameter, this._ctorParameters, propertyName, z, z2, z3);
        this._ctorParameters = linked;
    }

    public void addGetter(AnnotatedMethod annotatedMethod, PropertyName propertyName, boolean z, boolean z2, boolean z3) {
        Linked linked = new Linked(annotatedMethod, this._getters, propertyName, z, z2, z3);
        this._getters = linked;
    }

    public void addSetter(AnnotatedMethod annotatedMethod, PropertyName propertyName, boolean z, boolean z2, boolean z3) {
        Linked linked = new Linked(annotatedMethod, this._setters, propertyName, z, z2, z3);
        this._setters = linked;
    }

    public void addAll(POJOPropertyBuilder pOJOPropertyBuilder) {
        this._fields = merge(this._fields, pOJOPropertyBuilder._fields);
        this._ctorParameters = merge(this._ctorParameters, pOJOPropertyBuilder._ctorParameters);
        this._getters = merge(this._getters, pOJOPropertyBuilder._getters);
        this._setters = merge(this._setters, pOJOPropertyBuilder._setters);
    }

    private static <T> Linked<T> merge(Linked<T> linked, Linked<T> linked2) {
        if (linked == null) {
            return linked2;
        }
        return linked2 == null ? linked : linked.append(linked2);
    }

    public void removeIgnored() {
        this._fields = _removeIgnored(this._fields);
        this._getters = _removeIgnored(this._getters);
        this._setters = _removeIgnored(this._setters);
        this._ctorParameters = _removeIgnored(this._ctorParameters);
    }

    public Access removeNonVisible(boolean z) {
        Access findAccess = findAccess();
        if (findAccess == null) {
            findAccess = Access.AUTO;
        }
        switch (findAccess) {
            case READ_ONLY:
                this._setters = null;
                this._ctorParameters = null;
                if (!this._forSerialization) {
                    this._fields = null;
                    break;
                }
                break;
            case READ_WRITE:
                break;
            case WRITE_ONLY:
                this._getters = null;
                if (this._forSerialization) {
                    this._fields = null;
                    break;
                }
                break;
            default:
                this._getters = _removeNonVisible(this._getters);
                this._ctorParameters = _removeNonVisible(this._ctorParameters);
                if (!z || this._getters == null) {
                    this._fields = _removeNonVisible(this._fields);
                    this._setters = _removeNonVisible(this._setters);
                    break;
                }
        }
        return findAccess;
    }

    public void removeConstructors() {
        this._ctorParameters = null;
    }

    public void trimByVisibility() {
        this._fields = _trimByVisibility(this._fields);
        this._getters = _trimByVisibility(this._getters);
        this._setters = _trimByVisibility(this._setters);
        this._ctorParameters = _trimByVisibility(this._ctorParameters);
    }

    public void mergeAnnotations(boolean z) {
        if (z) {
            if (this._getters != null) {
                this._getters = _applyAnnotations(this._getters, _mergeAnnotations(0, this._getters, this._fields, this._ctorParameters, this._setters));
            } else if (this._fields != null) {
                this._fields = _applyAnnotations(this._fields, _mergeAnnotations(0, this._fields, this._ctorParameters, this._setters));
            }
        } else if (this._ctorParameters != null) {
            this._ctorParameters = _applyAnnotations(this._ctorParameters, _mergeAnnotations(0, this._ctorParameters, this._setters, this._fields, this._getters));
        } else if (this._setters != null) {
            this._setters = _applyAnnotations(this._setters, _mergeAnnotations(0, this._setters, this._fields, this._getters));
        } else if (this._fields != null) {
            this._fields = _applyAnnotations(this._fields, _mergeAnnotations(0, this._fields, this._getters));
        }
    }

    private AnnotationMap _mergeAnnotations(int i, Linked<? extends AnnotatedMember>... linkedArr) {
        AnnotationMap _getAllAnnotations = _getAllAnnotations(linkedArr[i]);
        do {
            i++;
            if (i >= linkedArr.length) {
                return _getAllAnnotations;
            }
        } while (linkedArr[i] == null);
        return AnnotationMap.merge(_getAllAnnotations, _mergeAnnotations(i, linkedArr));
    }

    private <T extends AnnotatedMember> AnnotationMap _getAllAnnotations(Linked<T> linked) {
        AnnotationMap allAnnotations = ((AnnotatedMember) linked.value).getAllAnnotations();
        return linked.next != null ? AnnotationMap.merge(allAnnotations, _getAllAnnotations(linked.next)) : allAnnotations;
    }

    private <T extends AnnotatedMember> Linked<T> _applyAnnotations(Linked<T> linked, AnnotationMap annotationMap) {
        AnnotatedMember annotatedMember = (AnnotatedMember) ((AnnotatedMember) linked.value).withAnnotations(annotationMap);
        if (linked.next != null) {
            linked = linked.withNext(_applyAnnotations(linked.next, annotationMap));
        }
        return linked.withValue(annotatedMember);
    }

    private <T> Linked<T> _removeIgnored(Linked<T> linked) {
        return linked == null ? linked : linked.withoutIgnored();
    }

    private <T> Linked<T> _removeNonVisible(Linked<T> linked) {
        return linked == null ? linked : linked.withoutNonVisible();
    }

    private <T> Linked<T> _trimByVisibility(Linked<T> linked) {
        return linked == null ? linked : linked.trimByVisibility();
    }

    private <T> boolean _anyExplicits(Linked<T> linked) {
        while (linked != null) {
            if (linked.name != null && linked.name.hasSimpleName()) {
                return true;
            }
            linked = linked.next;
        }
        return false;
    }

    private <T> boolean _anyExplicitNames(Linked<T> linked) {
        while (linked != null) {
            if (linked.name != null && linked.isNameExplicit) {
                return true;
            }
            linked = linked.next;
        }
        return false;
    }

    public boolean anyVisible() {
        return _anyVisible(this._fields) || _anyVisible(this._getters) || _anyVisible(this._setters) || _anyVisible(this._ctorParameters);
    }

    private <T> boolean _anyVisible(Linked<T> linked) {
        while (linked != null) {
            if (linked.isVisible) {
                return true;
            }
            linked = linked.next;
        }
        return false;
    }

    public boolean anyIgnorals() {
        return _anyIgnorals(this._fields) || _anyIgnorals(this._getters) || _anyIgnorals(this._setters) || _anyIgnorals(this._ctorParameters);
    }

    private <T> boolean _anyIgnorals(Linked<T> linked) {
        while (linked != null) {
            if (linked.isMarkedIgnored) {
                return true;
            }
            linked = linked.next;
        }
        return false;
    }

    public Set<PropertyName> findExplicitNames() {
        Set<PropertyName> _findExplicitNames = _findExplicitNames(this._ctorParameters, _findExplicitNames(this._setters, _findExplicitNames(this._getters, _findExplicitNames(this._fields, null))));
        return _findExplicitNames == null ? Collections.emptySet() : _findExplicitNames;
    }

    public Collection<POJOPropertyBuilder> explode(Collection<PropertyName> collection) {
        HashMap hashMap = new HashMap();
        _explode(collection, hashMap, this._fields);
        _explode(collection, hashMap, this._getters);
        _explode(collection, hashMap, this._setters);
        _explode(collection, hashMap, this._ctorParameters);
        return hashMap.values();
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<?>, code=com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked, for r12v0, types: [com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<?>, com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void _explode(java.util.Collection<com.fasterxml.jackson.databind.PropertyName> r10, java.util.Map<com.fasterxml.jackson.databind.PropertyName, com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder> r11, com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.Linked r12) {
        /*
            r9 = this;
            r0 = r12
        L_0x0001:
            if (r0 == 0) goto L_0x00a1
            com.fasterxml.jackson.databind.PropertyName r7 = r0.name
            boolean r1 = r0.isNameExplicit
            if (r1 == 0) goto L_0x0071
            if (r7 != 0) goto L_0x000c
            goto L_0x0071
        L_0x000c:
            java.lang.Object r1 = r11.get(r7)
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder r1 = (com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder) r1
            if (r1 != 0) goto L_0x0026
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder r8 = new com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder
            com.fasterxml.jackson.databind.cfg.MapperConfig<?> r2 = r9._config
            com.fasterxml.jackson.databind.AnnotationIntrospector r3 = r9._annotationIntrospector
            boolean r4 = r9._forSerialization
            com.fasterxml.jackson.databind.PropertyName r5 = r9._internalName
            r1 = r8
            r6 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            r11.put(r7, r8)
        L_0x0026:
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<com.fasterxml.jackson.databind.introspect.AnnotatedField> r2 = r9._fields
            if (r12 != r2) goto L_0x0033
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<com.fasterxml.jackson.databind.introspect.AnnotatedField> r2 = r1._fields
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked r2 = r0.withNext(r2)
            r1._fields = r2
            goto L_0x0075
        L_0x0033:
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<com.fasterxml.jackson.databind.introspect.AnnotatedMethod> r2 = r9._getters
            if (r12 != r2) goto L_0x0040
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<com.fasterxml.jackson.databind.introspect.AnnotatedMethod> r2 = r1._getters
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked r2 = r0.withNext(r2)
            r1._getters = r2
            goto L_0x0075
        L_0x0040:
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<com.fasterxml.jackson.databind.introspect.AnnotatedMethod> r2 = r9._setters
            if (r12 != r2) goto L_0x004d
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<com.fasterxml.jackson.databind.introspect.AnnotatedMethod> r2 = r1._setters
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked r2 = r0.withNext(r2)
            r1._setters = r2
            goto L_0x0075
        L_0x004d:
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<com.fasterxml.jackson.databind.introspect.AnnotatedParameter> r2 = r9._ctorParameters
            if (r12 != r2) goto L_0x005a
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<com.fasterxml.jackson.databind.introspect.AnnotatedParameter> r2 = r1._ctorParameters
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked r2 = r0.withNext(r2)
            r1._ctorParameters = r2
            goto L_0x0075
        L_0x005a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Internal error: mismatched accessors, property: "
            r11.append(r12)
            r11.append(r9)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x0071:
            boolean r1 = r0.isVisible
            if (r1 != 0) goto L_0x0078
        L_0x0075:
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<T> r0 = r0.next
            goto L_0x0001
        L_0x0078:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r1 = "Conflicting/ambiguous property name definitions (implicit name '"
            r12.append(r1)
            com.fasterxml.jackson.databind.PropertyName r1 = r9._name
            r12.append(r1)
            java.lang.String r1 = "'): found multiple explicit names: "
            r12.append(r1)
            r12.append(r10)
            java.lang.String r10 = ", but also implicit accessor: "
            r12.append(r10)
            r12.append(r0)
            java.lang.String r10 = r12.toString()
            r11.<init>(r10)
            throw r11
        L_0x00a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder._explode(java.util.Collection, java.util.Map, com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked):void");
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<? extends com.fasterxml.jackson.databind.introspect.AnnotatedMember>, code=com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked, for r2v0, types: [com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<? extends com.fasterxml.jackson.databind.introspect.AnnotatedMember>, com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Set<com.fasterxml.jackson.databind.PropertyName> _findExplicitNames(com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.Linked r2, java.util.Set<com.fasterxml.jackson.databind.PropertyName> r3) {
        /*
            r1 = this;
        L_0x0000:
            if (r2 == 0) goto L_0x001a
            boolean r0 = r2.isNameExplicit
            if (r0 == 0) goto L_0x0017
            com.fasterxml.jackson.databind.PropertyName r0 = r2.name
            if (r0 != 0) goto L_0x000b
            goto L_0x0017
        L_0x000b:
            if (r3 != 0) goto L_0x0012
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
        L_0x0012:
            com.fasterxml.jackson.databind.PropertyName r0 = r2.name
            r3.add(r0)
        L_0x0017:
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<T> r2 = r2.next
            goto L_0x0000
        L_0x001a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder._findExplicitNames(com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked, java.util.Set):java.util.Set");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Property '");
        sb.append(this._name);
        sb.append("'; ctors: ");
        sb.append(this._ctorParameters);
        sb.append(", field(s): ");
        sb.append(this._fields);
        sb.append(", getter(s): ");
        sb.append(this._getters);
        sb.append(", setter(s): ");
        sb.append(this._setters);
        sb.append("]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T fromMemberAnnotations(com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.WithMember<T> r3) {
        /*
            r2 = this;
            com.fasterxml.jackson.databind.AnnotationIntrospector r0 = r2._annotationIntrospector
            r1 = 0
            if (r0 == 0) goto L_0x0048
            boolean r0 = r2._forSerialization
            if (r0 == 0) goto L_0x0019
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<com.fasterxml.jackson.databind.introspect.AnnotatedMethod> r0 = r2._getters
            if (r0 == 0) goto L_0x0038
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<com.fasterxml.jackson.databind.introspect.AnnotatedMethod> r0 = r2._getters
            T r0 = r0.value
            com.fasterxml.jackson.databind.introspect.AnnotatedMember r0 = (com.fasterxml.jackson.databind.introspect.AnnotatedMember) r0
            java.lang.Object r0 = r3.withMember(r0)
        L_0x0017:
            r1 = r0
            goto L_0x0038
        L_0x0019:
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<com.fasterxml.jackson.databind.introspect.AnnotatedParameter> r0 = r2._ctorParameters
            if (r0 == 0) goto L_0x0027
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<com.fasterxml.jackson.databind.introspect.AnnotatedParameter> r0 = r2._ctorParameters
            T r0 = r0.value
            com.fasterxml.jackson.databind.introspect.AnnotatedMember r0 = (com.fasterxml.jackson.databind.introspect.AnnotatedMember) r0
            java.lang.Object r1 = r3.withMember(r0)
        L_0x0027:
            if (r1 != 0) goto L_0x0038
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<com.fasterxml.jackson.databind.introspect.AnnotatedMethod> r0 = r2._setters
            if (r0 == 0) goto L_0x0038
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<com.fasterxml.jackson.databind.introspect.AnnotatedMethod> r0 = r2._setters
            T r0 = r0.value
            com.fasterxml.jackson.databind.introspect.AnnotatedMember r0 = (com.fasterxml.jackson.databind.introspect.AnnotatedMember) r0
            java.lang.Object r0 = r3.withMember(r0)
            goto L_0x0017
        L_0x0038:
            if (r1 != 0) goto L_0x0048
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<com.fasterxml.jackson.databind.introspect.AnnotatedField> r0 = r2._fields
            if (r0 == 0) goto L_0x0048
            com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$Linked<com.fasterxml.jackson.databind.introspect.AnnotatedField> r0 = r2._fields
            T r0 = r0.value
            com.fasterxml.jackson.databind.introspect.AnnotatedMember r0 = (com.fasterxml.jackson.databind.introspect.AnnotatedMember) r0
            java.lang.Object r1 = r3.withMember(r0)
        L_0x0048:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.fromMemberAnnotations(com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder$WithMember):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public <T> T fromMemberAnnotationsExcept(WithMember<T> withMember, T t) {
        if (this._annotationIntrospector == null) {
            return null;
        }
        if (this._forSerialization) {
            if (this._getters != null) {
                T withMember2 = withMember.withMember((AnnotatedMember) this._getters.value);
                if (!(withMember2 == null || withMember2 == t)) {
                    return withMember2;
                }
            }
            if (this._fields != null) {
                T withMember3 = withMember.withMember((AnnotatedMember) this._fields.value);
                if (!(withMember3 == null || withMember3 == t)) {
                    return withMember3;
                }
            }
            if (this._ctorParameters != null) {
                T withMember4 = withMember.withMember((AnnotatedMember) this._ctorParameters.value);
                if (!(withMember4 == null || withMember4 == t)) {
                    return withMember4;
                }
            }
            if (this._setters != null) {
                T withMember5 = withMember.withMember((AnnotatedMember) this._setters.value);
                if (withMember5 == null || withMember5 == t) {
                    return null;
                }
                return withMember5;
            }
            return null;
        }
        if (this._ctorParameters != null) {
            T withMember6 = withMember.withMember((AnnotatedMember) this._ctorParameters.value);
            if (!(withMember6 == null || withMember6 == t)) {
                return withMember6;
            }
        }
        if (this._setters != null) {
            T withMember7 = withMember.withMember((AnnotatedMember) this._setters.value);
            if (!(withMember7 == null || withMember7 == t)) {
                return withMember7;
            }
        }
        if (this._fields != null) {
            T withMember8 = withMember.withMember((AnnotatedMember) this._fields.value);
            if (!(withMember8 == null || withMember8 == t)) {
                return withMember8;
            }
        }
        if (this._getters != null) {
            T withMember9 = withMember.withMember((AnnotatedMember) this._getters.value);
            if (withMember9 == null || withMember9 == t) {
                return null;
            }
            return withMember9;
        }
        return null;
    }
}

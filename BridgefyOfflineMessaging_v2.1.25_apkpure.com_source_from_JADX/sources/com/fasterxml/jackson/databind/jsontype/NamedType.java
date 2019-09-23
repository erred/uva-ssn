package com.fasterxml.jackson.databind.jsontype;

import java.io.Serializable;

public final class NamedType implements Serializable {
    private static final long serialVersionUID = 1;
    protected final Class<?> _class;
    protected final int _hashCode;
    protected String _name;

    public NamedType(Class<?> cls) {
        this(cls, null);
    }

    public NamedType(Class<?> cls, String str) {
        this._class = cls;
        this._hashCode = cls.getName().hashCode();
        setName(str);
    }

    public Class<?> getType() {
        return this._class;
    }

    public String getName() {
        return this._name;
    }

    public void setName(String str) {
        if (str == null || str.length() == 0) {
            str = null;
        }
        this._name = str;
    }

    public boolean hasName() {
        return this._name != null;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (this._class != ((NamedType) obj)._class) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this._hashCode;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("[NamedType, class ");
        sb.append(this._class.getName());
        sb.append(", name: ");
        if (this._name == null) {
            str = "null";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("'");
            sb2.append(this._name);
            sb2.append("'");
            str = sb2.toString();
        }
        sb.append(str);
        sb.append("]");
        return sb.toString();
    }
}

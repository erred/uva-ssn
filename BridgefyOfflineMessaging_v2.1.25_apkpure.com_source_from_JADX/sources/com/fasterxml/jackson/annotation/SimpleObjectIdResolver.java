package com.fasterxml.jackson.annotation;

import com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey;
import java.util.HashMap;
import java.util.Map;

public class SimpleObjectIdResolver implements ObjectIdResolver {
    protected Map<IdKey, Object> _items;

    public void bindItem(IdKey idKey, Object obj) {
        if (this._items == null) {
            this._items = new HashMap();
        } else if (this._items.containsKey(idKey)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Already had POJO for id (");
            sb.append(idKey.key.getClass().getName());
            sb.append(") [");
            sb.append(idKey);
            sb.append("]");
            throw new IllegalStateException(sb.toString());
        }
        this._items.put(idKey, obj);
    }

    public Object resolveId(IdKey idKey) {
        if (this._items == null) {
            return null;
        }
        return this._items.get(idKey);
    }

    public boolean canUseFor(ObjectIdResolver objectIdResolver) {
        return objectIdResolver.getClass() == getClass();
    }

    public ObjectIdResolver newForDeserialization(Object obj) {
        return new SimpleObjectIdResolver();
    }
}

package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Iterator;
import java.util.Map.Entry;

abstract class NodeCursor extends JsonStreamContext {
    protected String _currentName;
    protected Object _currentValue;
    protected final NodeCursor _parent;

    protected static final class ArrayCursor extends NodeCursor {
        protected Iterator<JsonNode> _contents;
        protected JsonNode _currentNode;

        public /* bridge */ /* synthetic */ JsonStreamContext getParent() {
            return NodeCursor.super.getParent();
        }

        public ArrayCursor(JsonNode jsonNode, NodeCursor nodeCursor) {
            super(1, nodeCursor);
            this._contents = jsonNode.elements();
        }

        public JsonToken nextToken() {
            if (!this._contents.hasNext()) {
                this._currentNode = null;
                return null;
            }
            this._currentNode = (JsonNode) this._contents.next();
            return this._currentNode.asToken();
        }

        public JsonToken nextValue() {
            return nextToken();
        }

        public JsonToken endToken() {
            return JsonToken.END_ARRAY;
        }

        public JsonNode currentNode() {
            return this._currentNode;
        }

        public boolean currentHasChildren() {
            return ((ContainerNode) currentNode()).size() > 0;
        }
    }

    protected static final class ObjectCursor extends NodeCursor {
        protected Iterator<Entry<String, JsonNode>> _contents;
        protected Entry<String, JsonNode> _current;
        protected boolean _needEntry = true;

        public /* bridge */ /* synthetic */ JsonStreamContext getParent() {
            return NodeCursor.super.getParent();
        }

        public ObjectCursor(JsonNode jsonNode, NodeCursor nodeCursor) {
            super(2, nodeCursor);
            this._contents = ((ObjectNode) jsonNode).fields();
        }

        public JsonToken nextToken() {
            if (this._needEntry) {
                String str = null;
                if (!this._contents.hasNext()) {
                    this._currentName = null;
                    this._current = null;
                    return null;
                }
                this._needEntry = false;
                this._current = (Entry) this._contents.next();
                if (this._current != null) {
                    str = (String) this._current.getKey();
                }
                this._currentName = str;
                return JsonToken.FIELD_NAME;
            }
            this._needEntry = true;
            return ((JsonNode) this._current.getValue()).asToken();
        }

        public JsonToken nextValue() {
            JsonToken nextToken = nextToken();
            return nextToken == JsonToken.FIELD_NAME ? nextToken() : nextToken;
        }

        public JsonToken endToken() {
            return JsonToken.END_OBJECT;
        }

        public JsonNode currentNode() {
            if (this._current == null) {
                return null;
            }
            return (JsonNode) this._current.getValue();
        }

        public boolean currentHasChildren() {
            return ((ContainerNode) currentNode()).size() > 0;
        }
    }

    protected static final class RootCursor extends NodeCursor {
        protected boolean _done = false;
        protected JsonNode _node;

        public boolean currentHasChildren() {
            return false;
        }

        public JsonToken endToken() {
            return null;
        }

        public void overrideCurrentName(String str) {
        }

        public /* bridge */ /* synthetic */ JsonStreamContext getParent() {
            return NodeCursor.super.getParent();
        }

        public RootCursor(JsonNode jsonNode, NodeCursor nodeCursor) {
            super(0, nodeCursor);
            this._node = jsonNode;
        }

        public JsonToken nextToken() {
            if (!this._done) {
                this._done = true;
                return this._node.asToken();
            }
            this._node = null;
            return null;
        }

        public JsonToken nextValue() {
            return nextToken();
        }

        public JsonNode currentNode() {
            return this._node;
        }
    }

    public abstract boolean currentHasChildren();

    public abstract JsonNode currentNode();

    public abstract JsonToken endToken();

    public abstract JsonToken nextToken();

    public abstract JsonToken nextValue();

    public NodeCursor(int i, NodeCursor nodeCursor) {
        this._type = i;
        this._index = -1;
        this._parent = nodeCursor;
    }

    public final NodeCursor getParent() {
        return this._parent;
    }

    public final String getCurrentName() {
        return this._currentName;
    }

    public void overrideCurrentName(String str) {
        this._currentName = str;
    }

    public Object getCurrentValue() {
        return this._currentValue;
    }

    public void setCurrentValue(Object obj) {
        this._currentValue = obj;
    }

    public final NodeCursor iterateChildren() {
        JsonNode currentNode = currentNode();
        if (currentNode == null) {
            throw new IllegalStateException("No current node");
        } else if (currentNode.isArray()) {
            return new ArrayCursor(currentNode, this);
        } else {
            if (currentNode.isObject()) {
                return new ObjectCursor(currentNode, this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Current node of type ");
            sb.append(currentNode.getClass().getName());
            throw new IllegalStateException(sb.toString());
        }
    }
}

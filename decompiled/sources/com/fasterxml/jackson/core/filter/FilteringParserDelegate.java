package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public class FilteringParserDelegate extends JsonParserDelegate {
    protected boolean _allowMultipleMatches;
    protected JsonToken _currToken;
    protected TokenFilterContext _exposedContext;
    protected TokenFilterContext _headContext;
    @Deprecated
    protected boolean _includeImmediateParent;
    protected boolean _includePath;
    protected TokenFilter _itemFilter;
    protected JsonToken _lastClearedToken;
    protected int _matchCount;
    protected TokenFilter rootFilter;

    public FilteringParserDelegate(JsonParser jsonParser, TokenFilter tokenFilter, boolean z, boolean z2) {
        super(jsonParser);
        this.rootFilter = tokenFilter;
        this._itemFilter = tokenFilter;
        this._headContext = TokenFilterContext.createRootContext(tokenFilter);
        this._includePath = z;
        this._allowMultipleMatches = z2;
    }

    public TokenFilter getFilter() {
        return this.rootFilter;
    }

    public int getMatchCount() {
        return this._matchCount;
    }

    public JsonToken getCurrentToken() {
        return this._currToken;
    }

    public JsonToken currentToken() {
        return this._currToken;
    }

    public final int getCurrentTokenId() {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == null) {
            return 0;
        }
        return jsonToken.mo8239id();
    }

    public final int currentTokenId() {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == null) {
            return 0;
        }
        return jsonToken.mo8239id();
    }

    public boolean hasCurrentToken() {
        return this._currToken != null;
    }

    public boolean hasTokenId(int i) {
        JsonToken jsonToken = this._currToken;
        boolean z = false;
        if (jsonToken == null) {
            if (i == 0) {
                z = true;
            }
            return z;
        }
        if (jsonToken.mo8239id() == i) {
            z = true;
        }
        return z;
    }

    public final boolean hasToken(JsonToken jsonToken) {
        return this._currToken == jsonToken;
    }

    public boolean isExpectedStartArrayToken() {
        return this._currToken == JsonToken.START_ARRAY;
    }

    public boolean isExpectedStartObjectToken() {
        return this._currToken == JsonToken.START_OBJECT;
    }

    public JsonLocation getCurrentLocation() {
        return this.delegate.getCurrentLocation();
    }

    public JsonStreamContext getParsingContext() {
        return _filterContext();
    }

    public String getCurrentName() throws IOException {
        String str;
        JsonStreamContext _filterContext = _filterContext();
        if (this._currToken != JsonToken.START_OBJECT && this._currToken != JsonToken.START_ARRAY) {
            return _filterContext.getCurrentName();
        }
        JsonStreamContext parent = _filterContext.getParent();
        if (parent == null) {
            str = null;
        } else {
            str = parent.getCurrentName();
        }
        return str;
    }

    public void clearCurrentToken() {
        if (this._currToken != null) {
            this._lastClearedToken = this._currToken;
            this._currToken = null;
        }
    }

    public JsonToken getLastClearedToken() {
        return this._lastClearedToken;
    }

    public void overrideCurrentName(String str) {
        throw new UnsupportedOperationException("Can not currently override name during filtering read");
    }

    public JsonToken nextToken() throws IOException {
        if (!this._allowMultipleMatches && this._currToken != null && this._exposedContext == null) {
            if (this._currToken.isStructEnd() && this._headContext.isStartHandled()) {
                this._currToken = null;
                return null;
            } else if (this._currToken.isScalarValue() && !this._headContext.isStartHandled() && !this._includePath && this._itemFilter == TokenFilter.INCLUDE_ALL) {
                this._currToken = null;
                return null;
            }
        }
        TokenFilterContext tokenFilterContext = this._exposedContext;
        if (tokenFilterContext != null) {
            do {
                JsonToken nextTokenToRead = tokenFilterContext.nextTokenToRead();
                if (nextTokenToRead != null) {
                    this._currToken = nextTokenToRead;
                    return nextTokenToRead;
                } else if (tokenFilterContext == this._headContext) {
                    this._exposedContext = null;
                    if (tokenFilterContext.inArray()) {
                        JsonToken currentToken = this.delegate.getCurrentToken();
                        this._currToken = currentToken;
                        return currentToken;
                    }
                } else {
                    tokenFilterContext = this._headContext.findChildOf(tokenFilterContext);
                    this._exposedContext = tokenFilterContext;
                }
            } while (tokenFilterContext != null);
            throw _constructError("Unexpected problem: chain of filtered context broken");
        }
        JsonToken nextToken = this.delegate.nextToken();
        if (nextToken == null) {
            this._currToken = nextToken;
            return nextToken;
        }
        switch (nextToken.mo8239id()) {
            case 1:
                TokenFilter tokenFilter = this._itemFilter;
                if (tokenFilter == TokenFilter.INCLUDE_ALL) {
                    this._headContext = this._headContext.createChildObjectContext(tokenFilter, true);
                    this._currToken = nextToken;
                    return nextToken;
                } else if (tokenFilter == null) {
                    this.delegate.skipChildren();
                    break;
                } else {
                    TokenFilter checkValue = this._headContext.checkValue(tokenFilter);
                    if (checkValue == null) {
                        this.delegate.skipChildren();
                        break;
                    } else {
                        if (checkValue != TokenFilter.INCLUDE_ALL) {
                            checkValue = checkValue.filterStartObject();
                        }
                        this._itemFilter = checkValue;
                        if (checkValue == TokenFilter.INCLUDE_ALL) {
                            this._headContext = this._headContext.createChildObjectContext(checkValue, true);
                            this._currToken = nextToken;
                            return nextToken;
                        }
                        this._headContext = this._headContext.createChildObjectContext(checkValue, false);
                        if (this._includePath) {
                            JsonToken _nextTokenWithBuffering = _nextTokenWithBuffering(this._headContext);
                            if (_nextTokenWithBuffering != null) {
                                this._currToken = _nextTokenWithBuffering;
                                return _nextTokenWithBuffering;
                            }
                        }
                    }
                }
                break;
            case 2:
            case 4:
                boolean isStartHandled = this._headContext.isStartHandled();
                TokenFilter filter = this._headContext.getFilter();
                if (!(filter == null || filter == TokenFilter.INCLUDE_ALL)) {
                    filter.filterFinishArray();
                }
                this._headContext = this._headContext.getParent();
                this._itemFilter = this._headContext.getFilter();
                if (isStartHandled) {
                    this._currToken = nextToken;
                    return nextToken;
                }
                break;
            case 3:
                TokenFilter tokenFilter2 = this._itemFilter;
                if (tokenFilter2 == TokenFilter.INCLUDE_ALL) {
                    this._headContext = this._headContext.createChildArrayContext(tokenFilter2, true);
                    this._currToken = nextToken;
                    return nextToken;
                } else if (tokenFilter2 == null) {
                    this.delegate.skipChildren();
                    break;
                } else {
                    TokenFilter checkValue2 = this._headContext.checkValue(tokenFilter2);
                    if (checkValue2 == null) {
                        this.delegate.skipChildren();
                        break;
                    } else {
                        if (checkValue2 != TokenFilter.INCLUDE_ALL) {
                            checkValue2 = checkValue2.filterStartArray();
                        }
                        this._itemFilter = checkValue2;
                        if (checkValue2 == TokenFilter.INCLUDE_ALL) {
                            this._headContext = this._headContext.createChildArrayContext(checkValue2, true);
                            this._currToken = nextToken;
                            return nextToken;
                        }
                        this._headContext = this._headContext.createChildArrayContext(checkValue2, false);
                        if (this._includePath) {
                            JsonToken _nextTokenWithBuffering2 = _nextTokenWithBuffering(this._headContext);
                            if (_nextTokenWithBuffering2 != null) {
                                this._currToken = _nextTokenWithBuffering2;
                                return _nextTokenWithBuffering2;
                            }
                        }
                    }
                }
                break;
            case 5:
                String currentName = this.delegate.getCurrentName();
                TokenFilter fieldName = this._headContext.setFieldName(currentName);
                if (fieldName == TokenFilter.INCLUDE_ALL) {
                    this._itemFilter = fieldName;
                    if (!this._includePath && this._includeImmediateParent && !this._headContext.isStartHandled()) {
                        nextToken = this._headContext.nextTokenToRead();
                        this._exposedContext = this._headContext;
                    }
                    this._currToken = nextToken;
                    return nextToken;
                } else if (fieldName == null) {
                    this.delegate.nextToken();
                    this.delegate.skipChildren();
                    break;
                } else {
                    TokenFilter includeProperty = fieldName.includeProperty(currentName);
                    if (includeProperty == null) {
                        this.delegate.nextToken();
                        this.delegate.skipChildren();
                        break;
                    } else {
                        this._itemFilter = includeProperty;
                        if (includeProperty == TokenFilter.INCLUDE_ALL && this._includePath) {
                            this._currToken = nextToken;
                            return nextToken;
                        } else if (this._includePath) {
                            JsonToken _nextTokenWithBuffering3 = _nextTokenWithBuffering(this._headContext);
                            if (_nextTokenWithBuffering3 != null) {
                                this._currToken = _nextTokenWithBuffering3;
                                return _nextTokenWithBuffering3;
                            }
                        }
                    }
                }
                break;
            default:
                TokenFilter tokenFilter3 = this._itemFilter;
                if (tokenFilter3 == TokenFilter.INCLUDE_ALL) {
                    this._currToken = nextToken;
                    return nextToken;
                } else if (tokenFilter3 != null) {
                    TokenFilter checkValue3 = this._headContext.checkValue(tokenFilter3);
                    if (checkValue3 == TokenFilter.INCLUDE_ALL || (checkValue3 != null && checkValue3.includeValue(this.delegate))) {
                        this._currToken = nextToken;
                        return nextToken;
                    }
                }
                break;
        }
        return _nextToken2();
    }

    /* access modifiers changed from: protected */
    public final JsonToken _nextToken2() throws IOException {
        JsonToken nextToken;
        while (true) {
            nextToken = this.delegate.nextToken();
            if (nextToken == null) {
                this._currToken = nextToken;
                return nextToken;
            }
            switch (nextToken.mo8239id()) {
                case 1:
                    TokenFilter tokenFilter = this._itemFilter;
                    if (tokenFilter == TokenFilter.INCLUDE_ALL) {
                        this._headContext = this._headContext.createChildObjectContext(tokenFilter, true);
                        this._currToken = nextToken;
                        return nextToken;
                    } else if (tokenFilter == null) {
                        this.delegate.skipChildren();
                        break;
                    } else {
                        TokenFilter checkValue = this._headContext.checkValue(tokenFilter);
                        if (checkValue == null) {
                            this.delegate.skipChildren();
                            break;
                        } else {
                            if (checkValue != TokenFilter.INCLUDE_ALL) {
                                checkValue = checkValue.filterStartObject();
                            }
                            this._itemFilter = checkValue;
                            if (checkValue == TokenFilter.INCLUDE_ALL) {
                                this._headContext = this._headContext.createChildObjectContext(checkValue, true);
                                this._currToken = nextToken;
                                return nextToken;
                            }
                            this._headContext = this._headContext.createChildObjectContext(checkValue, false);
                            if (this._includePath) {
                                JsonToken _nextTokenWithBuffering = _nextTokenWithBuffering(this._headContext);
                                if (_nextTokenWithBuffering == null) {
                                    break;
                                } else {
                                    this._currToken = _nextTokenWithBuffering;
                                    return _nextTokenWithBuffering;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                case 2:
                case 4:
                    boolean isStartHandled = this._headContext.isStartHandled();
                    TokenFilter filter = this._headContext.getFilter();
                    if (!(filter == null || filter == TokenFilter.INCLUDE_ALL)) {
                        filter.filterFinishArray();
                    }
                    this._headContext = this._headContext.getParent();
                    this._itemFilter = this._headContext.getFilter();
                    if (!isStartHandled) {
                        break;
                    } else {
                        this._currToken = nextToken;
                        return nextToken;
                    }
                case 3:
                    TokenFilter tokenFilter2 = this._itemFilter;
                    if (tokenFilter2 == TokenFilter.INCLUDE_ALL) {
                        this._headContext = this._headContext.createChildArrayContext(tokenFilter2, true);
                        this._currToken = nextToken;
                        return nextToken;
                    } else if (tokenFilter2 == null) {
                        this.delegate.skipChildren();
                        break;
                    } else {
                        TokenFilter checkValue2 = this._headContext.checkValue(tokenFilter2);
                        if (checkValue2 == null) {
                            this.delegate.skipChildren();
                            break;
                        } else {
                            if (checkValue2 != TokenFilter.INCLUDE_ALL) {
                                checkValue2 = checkValue2.filterStartArray();
                            }
                            this._itemFilter = checkValue2;
                            if (checkValue2 == TokenFilter.INCLUDE_ALL) {
                                this._headContext = this._headContext.createChildArrayContext(checkValue2, true);
                                this._currToken = nextToken;
                                return nextToken;
                            }
                            this._headContext = this._headContext.createChildArrayContext(checkValue2, false);
                            if (this._includePath) {
                                JsonToken _nextTokenWithBuffering2 = _nextTokenWithBuffering(this._headContext);
                                if (_nextTokenWithBuffering2 == null) {
                                    break;
                                } else {
                                    this._currToken = _nextTokenWithBuffering2;
                                    return _nextTokenWithBuffering2;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                case 5:
                    String currentName = this.delegate.getCurrentName();
                    TokenFilter fieldName = this._headContext.setFieldName(currentName);
                    if (fieldName == TokenFilter.INCLUDE_ALL) {
                        this._itemFilter = fieldName;
                        this._currToken = nextToken;
                        return nextToken;
                    } else if (fieldName == null) {
                        this.delegate.nextToken();
                        this.delegate.skipChildren();
                        break;
                    } else {
                        TokenFilter includeProperty = fieldName.includeProperty(currentName);
                        if (includeProperty == null) {
                            this.delegate.nextToken();
                            this.delegate.skipChildren();
                            break;
                        } else {
                            this._itemFilter = includeProperty;
                            if (includeProperty == TokenFilter.INCLUDE_ALL) {
                                if (!this._includePath) {
                                    break;
                                } else {
                                    this._currToken = nextToken;
                                    return nextToken;
                                }
                            } else if (this._includePath) {
                                JsonToken _nextTokenWithBuffering3 = _nextTokenWithBuffering(this._headContext);
                                if (_nextTokenWithBuffering3 == null) {
                                    break;
                                } else {
                                    this._currToken = _nextTokenWithBuffering3;
                                    return _nextTokenWithBuffering3;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                default:
                    TokenFilter tokenFilter3 = this._itemFilter;
                    if (tokenFilter3 == TokenFilter.INCLUDE_ALL) {
                        this._currToken = nextToken;
                        return nextToken;
                    } else if (tokenFilter3 != null) {
                        TokenFilter checkValue3 = this._headContext.checkValue(tokenFilter3);
                        if (checkValue3 == TokenFilter.INCLUDE_ALL || (checkValue3 != null && checkValue3.includeValue(this.delegate))) {
                            this._currToken = nextToken;
                            break;
                        }
                    } else {
                        continue;
                    }
            }
        }
        this._currToken = nextToken;
        return nextToken;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0134, code lost:
        return _nextBuffered(r6);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.fasterxml.jackson.core.JsonToken _nextTokenWithBuffering(com.fasterxml.jackson.core.filter.TokenFilterContext r6) throws java.io.IOException {
        /*
            r5 = this;
        L_0x0000:
            com.fasterxml.jackson.core.JsonParser r0 = r5.delegate
            com.fasterxml.jackson.core.JsonToken r0 = r0.nextToken()
            if (r0 != 0) goto L_0x0009
            return r0
        L_0x0009:
            int r1 = r0.mo8239id()
            r2 = 0
            r3 = 1
            switch(r1) {
                case 1: goto L_0x00ce;
                case 2: goto L_0x0092;
                case 3: goto L_0x005d;
                case 4: goto L_0x0092;
                case 5: goto L_0x001d;
                default: goto L_0x0012;
            }
        L_0x0012:
            com.fasterxml.jackson.core.filter.TokenFilter r0 = r5._itemFilter
            com.fasterxml.jackson.core.filter.TokenFilter r1 = com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL
            if (r0 != r1) goto L_0x011a
            com.fasterxml.jackson.core.JsonToken r6 = r5._nextBuffered(r6)
            return r6
        L_0x001d:
            com.fasterxml.jackson.core.JsonParser r0 = r5.delegate
            java.lang.String r0 = r0.getCurrentName()
            com.fasterxml.jackson.core.filter.TokenFilterContext r1 = r5._headContext
            com.fasterxml.jackson.core.filter.TokenFilter r1 = r1.setFieldName(r0)
            com.fasterxml.jackson.core.filter.TokenFilter r2 = com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL
            if (r1 != r2) goto L_0x0034
            r5._itemFilter = r1
            com.fasterxml.jackson.core.JsonToken r6 = r5._nextBuffered(r6)
            return r6
        L_0x0034:
            if (r1 != 0) goto L_0x0041
            com.fasterxml.jackson.core.JsonParser r0 = r5.delegate
            r0.nextToken()
            com.fasterxml.jackson.core.JsonParser r0 = r5.delegate
            r0.skipChildren()
            goto L_0x0000
        L_0x0041:
            com.fasterxml.jackson.core.filter.TokenFilter r0 = r1.includeProperty(r0)
            if (r0 != 0) goto L_0x0052
            com.fasterxml.jackson.core.JsonParser r0 = r5.delegate
            r0.nextToken()
            com.fasterxml.jackson.core.JsonParser r0 = r5.delegate
            r0.skipChildren()
            goto L_0x0000
        L_0x0052:
            r5._itemFilter = r0
            com.fasterxml.jackson.core.filter.TokenFilter r1 = com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL
            if (r0 != r1) goto L_0x0000
            com.fasterxml.jackson.core.JsonToken r6 = r5._nextBuffered(r6)
            return r6
        L_0x005d:
            com.fasterxml.jackson.core.filter.TokenFilterContext r0 = r5._headContext
            com.fasterxml.jackson.core.filter.TokenFilter r1 = r5._itemFilter
            com.fasterxml.jackson.core.filter.TokenFilter r0 = r0.checkValue(r1)
            if (r0 != 0) goto L_0x006d
            com.fasterxml.jackson.core.JsonParser r0 = r5.delegate
            r0.skipChildren()
            goto L_0x0000
        L_0x006d:
            com.fasterxml.jackson.core.filter.TokenFilter r1 = com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL
            if (r0 == r1) goto L_0x0075
            com.fasterxml.jackson.core.filter.TokenFilter r0 = r0.filterStartArray()
        L_0x0075:
            r5._itemFilter = r0
            com.fasterxml.jackson.core.filter.TokenFilter r1 = com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL
            if (r0 != r1) goto L_0x0088
            com.fasterxml.jackson.core.filter.TokenFilterContext r1 = r5._headContext
            com.fasterxml.jackson.core.filter.TokenFilterContext r0 = r1.createChildArrayContext(r0, r3)
            r5._headContext = r0
            com.fasterxml.jackson.core.JsonToken r6 = r5._nextBuffered(r6)
            return r6
        L_0x0088:
            com.fasterxml.jackson.core.filter.TokenFilterContext r1 = r5._headContext
            com.fasterxml.jackson.core.filter.TokenFilterContext r0 = r1.createChildArrayContext(r0, r2)
            r5._headContext = r0
            goto L_0x0000
        L_0x0092:
            com.fasterxml.jackson.core.filter.TokenFilterContext r1 = r5._headContext
            com.fasterxml.jackson.core.filter.TokenFilter r1 = r1.getFilter()
            if (r1 == 0) goto L_0x00a1
            com.fasterxml.jackson.core.filter.TokenFilter r4 = com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL
            if (r1 == r4) goto L_0x00a1
            r1.filterFinishArray()
        L_0x00a1:
            com.fasterxml.jackson.core.filter.TokenFilterContext r1 = r5._headContext
            if (r1 != r6) goto L_0x00a7
            r1 = 1
            goto L_0x00a8
        L_0x00a7:
            r1 = 0
        L_0x00a8:
            if (r1 == 0) goto L_0x00b3
            com.fasterxml.jackson.core.filter.TokenFilterContext r4 = r5._headContext
            boolean r4 = r4.isStartHandled()
            if (r4 == 0) goto L_0x00b3
            r2 = 1
        L_0x00b3:
            com.fasterxml.jackson.core.filter.TokenFilterContext r3 = r5._headContext
            com.fasterxml.jackson.core.filter.TokenFilterContext r3 = r3.getParent()
            r5._headContext = r3
            com.fasterxml.jackson.core.filter.TokenFilterContext r3 = r5._headContext
            com.fasterxml.jackson.core.filter.TokenFilter r3 = r3.getFilter()
            r5._itemFilter = r3
            if (r2 == 0) goto L_0x00c6
            return r0
        L_0x00c6:
            if (r1 != 0) goto L_0x00cc
            com.fasterxml.jackson.core.filter.TokenFilterContext r0 = r5._headContext
            if (r0 != r6) goto L_0x0000
        L_0x00cc:
            r6 = 0
            return r6
        L_0x00ce:
            com.fasterxml.jackson.core.filter.TokenFilter r1 = r5._itemFilter
            com.fasterxml.jackson.core.filter.TokenFilter r4 = com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL
            if (r1 != r4) goto L_0x00dd
            com.fasterxml.jackson.core.filter.TokenFilterContext r6 = r5._headContext
            com.fasterxml.jackson.core.filter.TokenFilterContext r6 = r6.createChildObjectContext(r1, r3)
            r5._headContext = r6
            return r0
        L_0x00dd:
            if (r1 != 0) goto L_0x00e6
            com.fasterxml.jackson.core.JsonParser r0 = r5.delegate
            r0.skipChildren()
            goto L_0x0000
        L_0x00e6:
            com.fasterxml.jackson.core.filter.TokenFilterContext r0 = r5._headContext
            com.fasterxml.jackson.core.filter.TokenFilter r0 = r0.checkValue(r1)
            if (r0 != 0) goto L_0x00f5
            com.fasterxml.jackson.core.JsonParser r0 = r5.delegate
            r0.skipChildren()
            goto L_0x0000
        L_0x00f5:
            com.fasterxml.jackson.core.filter.TokenFilter r1 = com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL
            if (r0 == r1) goto L_0x00fd
            com.fasterxml.jackson.core.filter.TokenFilter r0 = r0.filterStartObject()
        L_0x00fd:
            r5._itemFilter = r0
            com.fasterxml.jackson.core.filter.TokenFilter r1 = com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL
            if (r0 != r1) goto L_0x0110
            com.fasterxml.jackson.core.filter.TokenFilterContext r1 = r5._headContext
            com.fasterxml.jackson.core.filter.TokenFilterContext r0 = r1.createChildObjectContext(r0, r3)
            r5._headContext = r0
            com.fasterxml.jackson.core.JsonToken r6 = r5._nextBuffered(r6)
            return r6
        L_0x0110:
            com.fasterxml.jackson.core.filter.TokenFilterContext r1 = r5._headContext
            com.fasterxml.jackson.core.filter.TokenFilterContext r0 = r1.createChildObjectContext(r0, r2)
            r5._headContext = r0
            goto L_0x0000
        L_0x011a:
            if (r0 == 0) goto L_0x0000
            com.fasterxml.jackson.core.filter.TokenFilterContext r1 = r5._headContext
            com.fasterxml.jackson.core.filter.TokenFilter r0 = r1.checkValue(r0)
            com.fasterxml.jackson.core.filter.TokenFilter r1 = com.fasterxml.jackson.core.filter.TokenFilter.INCLUDE_ALL
            if (r0 == r1) goto L_0x0130
            if (r0 == 0) goto L_0x0000
            com.fasterxml.jackson.core.JsonParser r1 = r5.delegate
            boolean r0 = r0.includeValue(r1)
            if (r0 == 0) goto L_0x0000
        L_0x0130:
            com.fasterxml.jackson.core.JsonToken r6 = r5._nextBuffered(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.filter.FilteringParserDelegate._nextTokenWithBuffering(com.fasterxml.jackson.core.filter.TokenFilterContext):com.fasterxml.jackson.core.JsonToken");
    }

    private JsonToken _nextBuffered(TokenFilterContext tokenFilterContext) throws IOException {
        this._exposedContext = tokenFilterContext;
        JsonToken nextTokenToRead = tokenFilterContext.nextTokenToRead();
        if (nextTokenToRead != null) {
            return nextTokenToRead;
        }
        while (tokenFilterContext != this._headContext) {
            tokenFilterContext = this._exposedContext.findChildOf(tokenFilterContext);
            this._exposedContext = tokenFilterContext;
            if (tokenFilterContext != null) {
                JsonToken nextTokenToRead2 = this._exposedContext.nextTokenToRead();
                if (nextTokenToRead2 != null) {
                    return nextTokenToRead2;
                }
            } else {
                throw _constructError("Unexpected problem: chain of filtered context broken");
            }
        }
        throw _constructError("Internal error: failed to locate expected buffered tokens");
    }

    public JsonToken nextValue() throws IOException {
        JsonToken nextToken = nextToken();
        return nextToken == JsonToken.FIELD_NAME ? nextToken() : nextToken;
    }

    public JsonParser skipChildren() throws IOException {
        if (this._currToken != JsonToken.START_OBJECT && this._currToken != JsonToken.START_ARRAY) {
            return this;
        }
        int i = 1;
        while (true) {
            JsonToken nextToken = nextToken();
            if (nextToken == null) {
                return this;
            }
            if (nextToken.isStructStart()) {
                i++;
            } else if (nextToken.isStructEnd()) {
                i--;
                if (i == 0) {
                    return this;
                }
            } else {
                continue;
            }
        }
    }

    public String getText() throws IOException {
        return this.delegate.getText();
    }

    public boolean hasTextCharacters() {
        return this.delegate.hasTextCharacters();
    }

    public char[] getTextCharacters() throws IOException {
        return this.delegate.getTextCharacters();
    }

    public int getTextLength() throws IOException {
        return this.delegate.getTextLength();
    }

    public int getTextOffset() throws IOException {
        return this.delegate.getTextOffset();
    }

    public BigInteger getBigIntegerValue() throws IOException {
        return this.delegate.getBigIntegerValue();
    }

    public boolean getBooleanValue() throws IOException {
        return this.delegate.getBooleanValue();
    }

    public byte getByteValue() throws IOException {
        return this.delegate.getByteValue();
    }

    public short getShortValue() throws IOException {
        return this.delegate.getShortValue();
    }

    public BigDecimal getDecimalValue() throws IOException {
        return this.delegate.getDecimalValue();
    }

    public double getDoubleValue() throws IOException {
        return this.delegate.getDoubleValue();
    }

    public float getFloatValue() throws IOException {
        return this.delegate.getFloatValue();
    }

    public int getIntValue() throws IOException {
        return this.delegate.getIntValue();
    }

    public long getLongValue() throws IOException {
        return this.delegate.getLongValue();
    }

    public NumberType getNumberType() throws IOException {
        return this.delegate.getNumberType();
    }

    public Number getNumberValue() throws IOException {
        return this.delegate.getNumberValue();
    }

    public int getValueAsInt() throws IOException {
        return this.delegate.getValueAsInt();
    }

    public int getValueAsInt(int i) throws IOException {
        return this.delegate.getValueAsInt(i);
    }

    public long getValueAsLong() throws IOException {
        return this.delegate.getValueAsLong();
    }

    public long getValueAsLong(long j) throws IOException {
        return this.delegate.getValueAsLong(j);
    }

    public double getValueAsDouble() throws IOException {
        return this.delegate.getValueAsDouble();
    }

    public double getValueAsDouble(double d) throws IOException {
        return this.delegate.getValueAsDouble(d);
    }

    public boolean getValueAsBoolean() throws IOException {
        return this.delegate.getValueAsBoolean();
    }

    public boolean getValueAsBoolean(boolean z) throws IOException {
        return this.delegate.getValueAsBoolean(z);
    }

    public String getValueAsString() throws IOException {
        return this.delegate.getValueAsString();
    }

    public String getValueAsString(String str) throws IOException {
        return this.delegate.getValueAsString(str);
    }

    public Object getEmbeddedObject() throws IOException {
        return this.delegate.getEmbeddedObject();
    }

    public byte[] getBinaryValue(Base64Variant base64Variant) throws IOException {
        return this.delegate.getBinaryValue(base64Variant);
    }

    public int readBinaryValue(Base64Variant base64Variant, OutputStream outputStream) throws IOException {
        return this.delegate.readBinaryValue(base64Variant, outputStream);
    }

    public JsonLocation getTokenLocation() {
        return this.delegate.getTokenLocation();
    }

    /* access modifiers changed from: protected */
    public JsonStreamContext _filterContext() {
        if (this._exposedContext != null) {
            return this._exposedContext;
        }
        return this._headContext;
    }
}

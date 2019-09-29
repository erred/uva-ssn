package com.twitter.sdk.android.core;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.twitter.sdk.android.core.internal.oauth.C3194a;
import com.twitter.sdk.android.core.internal.oauth.C3198e;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.twitter.sdk.android.core.b */
/* compiled from: AuthTokenAdapter */
public class C3127b implements JsonDeserializer<C3102a>, JsonSerializer<C3102a> {

    /* renamed from: a */
    static final Map<String, Class<? extends C3102a>> f8261a = new HashMap();

    /* renamed from: b */
    private final Gson f8262b = new Gson();

    static {
        f8261a.put("oauth1a", C3262s.class);
        f8261a.put("oauth2", C3198e.class);
        f8261a.put("guest", C3194a.class);
    }

    /* renamed from: a */
    public JsonElement serialize(C3102a aVar, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("auth_type", m9136a(aVar.getClass()));
        jsonObject.add("auth_token", this.f8262b.toJsonTree(aVar));
        return jsonObject;
    }

    /* renamed from: a */
    public C3102a deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        String asString = asJsonObject.getAsJsonPrimitive("auth_type").getAsString();
        return (C3102a) this.f8262b.fromJson(asJsonObject.get("auth_token"), (Class) f8261a.get(asString));
    }

    /* renamed from: a */
    static String m9136a(Class<? extends C3102a> cls) {
        for (Entry entry : f8261a.entrySet()) {
            if (((Class) entry.getValue()).equals(cls)) {
                return (String) entry.getKey();
            }
        }
        return "";
    }
}

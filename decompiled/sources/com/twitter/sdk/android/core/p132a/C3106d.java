package com.twitter.sdk.android.core.p132a;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.twitter.sdk.android.core.a.d */
/* compiled from: BindingValuesAdapter */
public class C3106d implements JsonDeserializer<C3105c>, JsonSerializer<C3105c> {
    /* renamed from: a */
    public JsonElement serialize(C3105c cVar, Type type, JsonSerializationContext jsonSerializationContext) {
        return null;
    }

    /* renamed from: a */
    public C3105c deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (!jsonElement.isJsonObject()) {
            return new C3105c();
        }
        Set<Entry> entrySet = jsonElement.getAsJsonObject().entrySet();
        HashMap hashMap = new HashMap(32);
        for (Entry entry : entrySet) {
            hashMap.put((String) entry.getKey(), mo27594a(((JsonElement) entry.getValue()).getAsJsonObject(), jsonDeserializationContext));
        }
        return new C3105c(hashMap);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Object mo27594a(JsonObject jsonObject, JsonDeserializationContext jsonDeserializationContext) {
        JsonElement jsonElement = jsonObject.get(Param.TYPE);
        if (jsonElement == null || !jsonElement.isJsonPrimitive()) {
            return null;
        }
        String asString = jsonElement.getAsString();
        char c = 65535;
        int hashCode = asString.hashCode();
        if (hashCode != -1838656495) {
            if (hashCode != 2614219) {
                if (hashCode != 69775675) {
                    if (hashCode == 782694408 && asString.equals("BOOLEAN")) {
                        c = 3;
                    }
                } else if (asString.equals("IMAGE")) {
                    c = 1;
                }
            } else if (asString.equals("USER")) {
                c = 2;
            }
        } else if (asString.equals("STRING")) {
            c = 0;
        }
        switch (c) {
            case 0:
                return jsonDeserializationContext.deserialize(jsonObject.get("string_value"), String.class);
            case 1:
                return jsonDeserializationContext.deserialize(jsonObject.get("image_value"), C3110h.class);
            case 2:
                return jsonDeserializationContext.deserialize(jsonObject.get("user_value"), C3124t.class);
            case 3:
                return jsonDeserializationContext.deserialize(jsonObject.get("boolean_value"), Boolean.class);
            default:
                return null;
        }
    }
}

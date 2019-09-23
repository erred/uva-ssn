package com.twitter.sdk.android.core.p132a;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/* renamed from: com.twitter.sdk.android.core.a.n */
/* compiled from: SafeMapAdapter */
public class C3117n implements TypeAdapterFactory {
    public <T> TypeAdapter<T> create(Gson gson, final TypeToken<T> typeToken) {
        final TypeAdapter delegateAdapter = gson.getDelegateAdapter(this, typeToken);
        return new TypeAdapter<T>() {
            public void write(JsonWriter jsonWriter, T t) throws IOException {
                delegateAdapter.write(jsonWriter, t);
            }

            public T read(JsonReader jsonReader) throws IOException {
                T read = delegateAdapter.read(jsonReader);
                if (!Map.class.isAssignableFrom(typeToken.getRawType())) {
                    return read;
                }
                if (read == null) {
                    return Collections.EMPTY_MAP;
                }
                return Collections.unmodifiableMap((Map) read);
            }
        };
    }
}

package com.twitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;

/* renamed from: com.twitter.a */
/* compiled from: Extractor */
public class C3088a {

    /* renamed from: a */
    protected boolean f8125a = true;

    /* renamed from: com.twitter.a$a */
    /* compiled from: Extractor */
    public static class C3089a {

        /* renamed from: a */
        protected int f8126a;

        /* renamed from: b */
        protected int f8127b;

        /* renamed from: c */
        protected final String f8128c;

        /* renamed from: d */
        protected final String f8129d;

        /* renamed from: e */
        protected final C3090a f8130e;

        /* renamed from: f */
        protected String f8131f;

        /* renamed from: g */
        protected String f8132g;

        /* renamed from: com.twitter.a$a$a */
        /* compiled from: Extractor */
        public enum C3090a {
            URL,
            HASHTAG,
            MENTION,
            CASHTAG
        }

        public C3089a(int i, int i2, String str, String str2, C3090a aVar) {
            this.f8131f = null;
            this.f8132g = null;
            this.f8126a = i;
            this.f8127b = i2;
            this.f8128c = str;
            this.f8129d = str2;
            this.f8130e = aVar;
        }

        public C3089a(int i, int i2, String str, C3090a aVar) {
            this(i, i2, str, null, aVar);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C3089a)) {
                return false;
            }
            C3089a aVar = (C3089a) obj;
            return this.f8130e.equals(aVar.f8130e) && this.f8126a == aVar.f8126a && this.f8127b == aVar.f8127b && this.f8128c.equals(aVar.f8128c);
        }

        public int hashCode() {
            return this.f8130e.hashCode() + this.f8128c.hashCode() + this.f8126a + this.f8127b;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f8128c);
            sb.append("(");
            sb.append(this.f8130e);
            sb.append(") [");
            sb.append(this.f8126a);
            sb.append(",");
            sb.append(this.f8127b);
            sb.append("]");
            return sb.toString();
        }
    }

    /* renamed from: a */
    public List<C3089a> mo27586a(String str) {
        int i;
        if (!(str == null || str.length() == 0)) {
            if (this.f8125a) {
                i = 46;
            } else {
                i = 58;
            }
            if (str.indexOf(i) != -1) {
                ArrayList arrayList = new ArrayList();
                Matcher matcher = C3091b.f8145h.matcher(str);
                while (matcher.find()) {
                    if (matcher.group(4) != null || (this.f8125a && !C3091b.f8147j.matcher(matcher.group(2)).matches())) {
                        String group = matcher.group(3);
                        int start = matcher.start(3);
                        int end = matcher.end(3);
                        Matcher matcher2 = C3091b.f8146i.matcher(group);
                        if (matcher2.find()) {
                            group = matcher2.group();
                            end = group.length() + start;
                        }
                        arrayList.add(new C3089a(start, end, group, C3090a.URL));
                    }
                }
                return arrayList;
            }
        }
        return Collections.emptyList();
    }
}

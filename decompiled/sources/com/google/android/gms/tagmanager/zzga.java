package com.google.android.gms.tagmanager;

import java.util.Map;

final class zzga implements zzb {
    private final /* synthetic */ TagManager zzbgr;

    zzga(TagManager tagManager) {
        this.zzbgr = tagManager;
    }

    public final void zzd(Map<String, Object> map) {
        Object obj = map.get(DataLayer.EVENT_KEY);
        if (obj != null) {
            this.zzbgr.zzeb(obj.toString());
        }
    }
}

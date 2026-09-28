package com.google.android.gms.internal.nearby;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzns {
    private final Map zza = new WeakHashMap();

    public final Object zza(Object obj) {
        WeakReference weakReference = (WeakReference) this.zza.get(obj);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final void zzb() {
        this.zza.clear();
    }

    public final void zzc(Object obj, Object obj2) {
        this.zza.put(obj, new WeakReference(obj2));
    }

    public final void zzd(Object obj) {
        this.zza.remove(obj);
    }

    public final boolean zze(Object obj) {
        return zza(obj) != null;
    }
}

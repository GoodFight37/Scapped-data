package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zznr {
    public static final zznr zza = new zznq().zza();
    private final Map<String, String> zzb;

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    public final String toString() {
        return this.zzb.toString();
    }

    public final Map<String, String> zza() {
        return this.zzb;
    }

    private zznr(Map<String, String> map) {
        this.zzb = map;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zznr) {
            return this.zzb.equals(((zznr) obj).zzb);
        }
        return false;
    }
}

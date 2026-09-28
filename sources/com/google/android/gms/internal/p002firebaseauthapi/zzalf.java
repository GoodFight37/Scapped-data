package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzalf<K, V> {
    static <K, V> int zza(zzale<K, V> zzaleVar, K k, V v) {
        return zzajy.zza(zzaleVar.zza, 1, k) + zzajy.zza(zzaleVar.zzc, 2, v);
    }

    static <K, V> void zza(zzajo zzajoVar, zzale<K, V> zzaleVar, K k, V v) throws IOException {
        zzajy.zza(zzajoVar, zzaleVar.zza, 1, k);
        zzajy.zza(zzajoVar, zzaleVar.zzc, 2, v);
    }
}

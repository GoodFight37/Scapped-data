package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zznq {
    private HashMap<String, String> zza = new HashMap<>();

    public final zznr zza() {
        if (this.zza == null) {
            throw new IllegalStateException("cannot call build() twice");
        }
        zznr zznrVar = new zznr(Collections.unmodifiableMap(this.zza));
        this.zza = null;
        return zznrVar;
    }
}

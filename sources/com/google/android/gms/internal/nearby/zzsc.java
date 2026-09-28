package com.google.android.gms.internal.nearby;

import java.io.Serializable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzsc implements Serializable {
    zzsc() {
    }

    public static zzsc zzc() {
        return zzrz.zza;
    }

    public static zzsc zzd(Object obj) {
        obj.getClass();
        return new zzsh(obj);
    }

    public abstract Object zza();

    public abstract boolean zzb();
}

package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.core.internal.view.SupportMenu;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzaju {
    private final Object zza;
    private final int zzb;

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * SupportMenu.USER_MASK) + this.zzb;
    }

    zzaju(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzaju)) {
            return false;
        }
        zzaju zzajuVar = (zzaju) obj;
        return this.zza == zzajuVar.zza && this.zzb == zzajuVar.zzb;
    }
}

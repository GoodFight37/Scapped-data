package com.google.android.gms.internal.measurement;

import androidx.core.internal.view.SupportMenu;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.4.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzlo {
    private final Object zza;
    private final int zzb;

    zzlo(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzlo)) {
            return false;
        }
        zzlo zzloVar = (zzlo) obj;
        return this.zza == zzloVar.zza && this.zzb == zzloVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * SupportMenu.USER_MASK) + this.zzb;
    }
}

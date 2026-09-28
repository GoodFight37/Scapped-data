package com.google.android.gms.internal.play_billing;

import androidx.core.internal.view.SupportMenu;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.0.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzet {
    private final Object zza;
    private final int zzb;

    zzet(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzet)) {
            return false;
        }
        zzet zzetVar = (zzet) obj;
        return this.zza == zzetVar.zza && this.zzb == zzetVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * SupportMenu.USER_MASK) + this.zzb;
    }
}

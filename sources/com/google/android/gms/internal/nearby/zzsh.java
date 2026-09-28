package com.google.android.gms.internal.nearby;

import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzsh extends zzsc {
    private final Object zza;

    zzsh(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzsh) {
            return this.zza.equals(((zzsh) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        return "Optional.of(" + this.zza + ")";
    }

    @Override // com.google.android.gms.internal.nearby.zzsc
    public final Object zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.nearby.zzsc
    public final boolean zzb() {
        return true;
    }
}

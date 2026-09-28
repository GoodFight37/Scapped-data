package com.google.android.gms.internal.nearby;

import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzrz extends zzsc {
    static final zzrz zza = new zzrz();

    private zzrz() {
    }

    public final boolean equals(@CheckForNull Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return 2040732332;
    }

    public final String toString() {
        return "Optional.absent()";
    }

    @Override // com.google.android.gms.internal.nearby.zzsc
    public final Object zza() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // com.google.android.gms.internal.nearby.zzsc
    public final boolean zzb() {
        return false;
    }
}

package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzeg extends zzcr {
    private final zza zza;

    public final int hashCode() {
        return Objects.hash(zzeg.class, this.zza);
    }

    public final zza zzb() {
        return this.zza;
    }

    public static zzeg zza(zza zzaVar) {
        return new zzeg(zzaVar);
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza {
        public static final zza zza = new zza("TINK");
        public static final zza zzb = new zza("CRUNCHY");
        public static final zza zzc = new zza("NO_PREFIX");
        private final String zzd;

        public final String toString() {
            return this.zzd;
        }

        private zza(String str) {
            this.zzd = str;
        }
    }

    public final String toString() {
        return "ChaCha20Poly1305 Parameters (variant: " + String.valueOf(this.zza) + ")";
    }

    private zzeg(zza zzaVar) {
        this.zza = zzaVar;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzeg) && ((zzeg) obj).zza == this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcg
    public final boolean zza() {
        return this.zza != zza.zzc;
    }
}

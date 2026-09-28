package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzfy extends zzcr {
    private final zza zza;

    public final int hashCode() {
        return Objects.hash(zzfy.class, this.zza);
    }

    public final zza zzb() {
        return this.zza;
    }

    public static zzfy zzc() {
        return new zzfy(zza.zzc);
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

    public static zzfy zza(zza zzaVar) {
        return new zzfy(zzaVar);
    }

    public final String toString() {
        return "XChaCha20Poly1305 Parameters (variant: " + String.valueOf(this.zza) + ")";
    }

    private zzfy(zza zzaVar) {
        this.zza = zzaVar;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzfy) && ((zzfy) obj).zza == this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcg
    public final boolean zza() {
        return this.zza != zza.zzc;
    }
}

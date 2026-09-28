package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzft extends zzcr {
    private final zza zza;
    private final int zzb;

    public final int zzb() {
        return this.zzb;
    }

    public final int hashCode() {
        return Objects.hash(zzft.class, this.zza, Integer.valueOf(this.zzb));
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza {
        public static final zza zza = new zza("TINK");
        public static final zza zzb = new zza("NO_PREFIX");
        private final String zzc;

        public final String toString() {
            return this.zzc;
        }

        private zza(String str) {
            this.zzc = str;
        }
    }

    public final zza zzc() {
        return this.zza;
    }

    public static zzft zza(zza zzaVar, int i) throws GeneralSecurityException {
        if (i < 8 || i > 12) {
            throw new GeneralSecurityException("Salt size must be between 8 and 12 bytes");
        }
        return new zzft(zzaVar, i);
    }

    public final String toString() {
        return "X-AES-GCM Parameters (variant: " + String.valueOf(this.zza) + "salt_size_bytes: " + this.zzb + ")";
    }

    private zzft(zza zzaVar, int i) {
        this.zza = zzaVar;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzft)) {
            return false;
        }
        zzft zzftVar = (zzft) obj;
        return zzftVar.zza == this.zza && zzftVar.zzb == this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcg
    public final boolean zza() {
        return this.zza != zza.zzb;
    }
}

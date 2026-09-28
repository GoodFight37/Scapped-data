package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzqf extends zzqy {
    private final int zza;
    private final int zzb;
    private final zza zzc;

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zzb {

        @Nullable
        private Integer zza;

        @Nullable
        private Integer zzb;
        private zza zzc;

        public final zzb zza(int i) throws GeneralSecurityException {
            if (i != 16 && i != 32) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit AES keys are supported", Integer.valueOf(i << 3)));
            }
            this.zza = Integer.valueOf(i);
            return this;
        }

        public final zzb zzb(int i) throws GeneralSecurityException {
            if (i < 10 || 16 < i) {
                throw new GeneralSecurityException("Invalid tag size for AesCmacParameters: " + i);
            }
            this.zzb = Integer.valueOf(i);
            return this;
        }

        public final zzb zza(zza zzaVar) {
            this.zzc = zzaVar;
            return this;
        }

        public final zzqf zza() throws GeneralSecurityException {
            if (this.zza == null) {
                throw new GeneralSecurityException("key size not set");
            }
            if (this.zzb == null) {
                throw new GeneralSecurityException("tag size not set");
            }
            if (this.zzc == null) {
                throw new GeneralSecurityException("variant not set");
            }
            return new zzqf(this.zza.intValue(), this.zzb.intValue(), this.zzc);
        }

        private zzb() {
            this.zza = null;
            this.zzb = null;
            this.zzc = zza.zzd;
        }
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    private final int zzf() {
        if (this.zzc == zza.zzd) {
            return this.zzb;
        }
        if (this.zzc == zza.zza || this.zzc == zza.zzb || this.zzc == zza.zzc) {
            int i = this.zzb;
            return i + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza {
        public static final zza zza = new zza("TINK");
        public static final zza zzb = new zza("CRUNCHY");
        public static final zza zzc = new zza("LEGACY");
        public static final zza zzd = new zza("NO_PREFIX");
        private final String zze;

        public final String toString() {
            return this.zze;
        }

        private zza(String str) {
            this.zze = str;
        }
    }

    public final int hashCode() {
        return Objects.hash(zzqf.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc);
    }

    public static zzb zzd() {
        return new zzb();
    }

    public final zza zze() {
        return this.zzc;
    }

    public final String toString() {
        return "AES-CMAC Parameters (variant: " + String.valueOf(this.zzc) + ", " + this.zzb + "-byte tags, and " + this.zza + "-byte key)";
    }

    private zzqf(int i, int i2, zza zzaVar) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzaVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzqf)) {
            return false;
        }
        zzqf zzqfVar = (zzqf) obj;
        return zzqfVar.zza == this.zza && zzqfVar.zzf() == zzf() && zzqfVar.zzc == this.zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcg
    public final boolean zza() {
        return this.zzc != zza.zzd;
    }
}

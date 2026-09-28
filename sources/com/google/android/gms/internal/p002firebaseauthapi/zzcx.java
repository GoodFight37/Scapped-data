package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzcx extends zzcp {
    private final zzdc zza;
    private final zzzo zzb;
    private final zzzo zzc;
    private final zzzn zzd;

    @Nullable
    private final Integer zze;

    public static zza zzb() {
        return new zza();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static class zza {

        @Nullable
        private zzdc zza;

        @Nullable
        private zzzo zzb;

        @Nullable
        private zzzo zzc;

        @Nullable
        private Integer zzd;

        public final zza zza(zzzo zzzoVar) {
            this.zzb = zzzoVar;
            return this;
        }

        public final zza zzb(zzzo zzzoVar) {
            this.zzc = zzzoVar;
            return this;
        }

        public final zza zza(@Nullable Integer num) {
            this.zzd = num;
            return this;
        }

        public final zza zza(zzdc zzdcVar) {
            this.zza = zzdcVar;
            return this;
        }

        public final zzcx zza() throws GeneralSecurityException {
            zzzn zzznVarZzb;
            zzdc zzdcVar = this.zza;
            if (zzdcVar == null) {
                throw new GeneralSecurityException("Cannot build without parameters");
            }
            if (this.zzb == null || this.zzc == null) {
                throw new GeneralSecurityException("Cannot build without key material");
            }
            if (zzdcVar.zzb() != this.zzb.zza()) {
                throw new GeneralSecurityException("AES key size mismatch");
            }
            if (this.zza.zzc() != this.zzc.zza()) {
                throw new GeneralSecurityException("HMAC key size mismatch");
            }
            if (this.zza.zza() && this.zzd == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            }
            if (!this.zza.zza() && this.zzd != null) {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            if (this.zza.zzh() == zzdc.zzc.zzc) {
                zzznVarZzb = zzor.zza;
            } else if (this.zza.zzh() == zzdc.zzc.zzb) {
                zzznVarZzb = zzor.zza(this.zzd.intValue());
            } else if (this.zza.zzh() == zzdc.zzc.zza) {
                zzznVarZzb = zzor.zzb(this.zzd.intValue());
            } else {
                throw new IllegalStateException("Unknown AesCtrHmacAeadParameters.Variant: " + String.valueOf(this.zza.zzh()));
            }
            return new zzcx(this.zza, this.zzb, this.zzc, zzznVarZzb, this.zzd);
        }

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
            this.zzd = null;
        }
    }

    public final zzdc zzc() {
        return this.zza;
    }

    public final zzzn zzd() {
        return this.zzd;
    }

    public final zzzo zze() {
        return this.zzb;
    }

    public final zzzo zzf() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbo
    @Nullable
    public final Integer zza() {
        return this.zze;
    }

    private zzcx(zzdc zzdcVar, zzzo zzzoVar, zzzo zzzoVar2, zzzn zzznVar, @Nullable Integer num) {
        this.zza = zzdcVar;
        this.zzb = zzzoVar;
        this.zzc = zzzoVar2;
        this.zzd = zzznVar;
        this.zze = num;
    }
}

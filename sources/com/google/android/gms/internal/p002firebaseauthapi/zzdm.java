package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzdm extends zzcp {
    private final zzdr zza;
    private final zzzo zzb;
    private final zzzn zzc;

    @Nullable
    private final Integer zzd;

    public static zza zzb() {
        return new zza();
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static class zza {

        @Nullable
        private zzdr zza;

        @Nullable
        private zzzo zzb;

        @Nullable
        private Integer zzc;

        public final zza zza(@Nullable Integer num) {
            this.zzc = num;
            return this;
        }

        public final zza zza(zzzo zzzoVar) {
            this.zzb = zzzoVar;
            return this;
        }

        public final zza zza(zzdr zzdrVar) {
            this.zza = zzdrVar;
            return this;
        }

        public final zzdm zza() throws GeneralSecurityException {
            zzzn zzznVarZzb;
            zzdr zzdrVar = this.zza;
            if (zzdrVar == null || this.zzb == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            }
            if (zzdrVar.zzc() != this.zzb.zza()) {
                throw new GeneralSecurityException("Key size mismatch");
            }
            if (this.zza.zza() && this.zzc == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            }
            if (!this.zza.zza() && this.zzc != null) {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            if (this.zza.zzf() == zzdr.zza.zzc) {
                zzznVarZzb = zzor.zza;
            } else if (this.zza.zzf() == zzdr.zza.zzb) {
                zzznVarZzb = zzor.zza(this.zzc.intValue());
            } else if (this.zza.zzf() == zzdr.zza.zza) {
                zzznVarZzb = zzor.zzb(this.zzc.intValue());
            } else {
                throw new IllegalStateException("Unknown AesGcmParameters.Variant: " + String.valueOf(this.zza.zzf()));
            }
            return new zzdm(this.zza, this.zzb, zzznVarZzb, this.zzc);
        }

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
        }
    }

    public final zzdr zzc() {
        return this.zza;
    }

    public final zzzn zzd() {
        return this.zzc;
    }

    public final zzzo zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbo
    @Nullable
    public final Integer zza() {
        return this.zzd;
    }

    private zzdm(zzdr zzdrVar, zzzo zzzoVar, zzzn zzznVar, @Nullable Integer num) {
        this.zza = zzdrVar;
        this.zzb = zzzoVar;
        this.zzc = zzznVar;
        this.zzd = num;
    }
}

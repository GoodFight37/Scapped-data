package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzdf extends zzcp {
    private final zzdk zza;
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
        private zzdk zza;

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

        public final zza zza(zzdk zzdkVar) {
            this.zza = zzdkVar;
            return this;
        }

        public final zzdf zza() throws GeneralSecurityException {
            zzzn zzznVarZzb;
            zzdk zzdkVar = this.zza;
            if (zzdkVar == null || this.zzb == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            }
            if (zzdkVar.zzc() != this.zzb.zza()) {
                throw new GeneralSecurityException("Key size mismatch");
            }
            if (this.zza.zza() && this.zzc == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            }
            if (!this.zza.zza() && this.zzc != null) {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            if (this.zza.zzf() == zzdk.zzb.zzc) {
                zzznVarZzb = zzor.zza;
            } else if (this.zza.zzf() == zzdk.zzb.zzb) {
                zzznVarZzb = zzor.zza(this.zzc.intValue());
            } else if (this.zza.zzf() == zzdk.zzb.zza) {
                zzznVarZzb = zzor.zzb(this.zzc.intValue());
            } else {
                throw new IllegalStateException("Unknown AesEaxParameters.Variant: " + String.valueOf(this.zza.zzf()));
            }
            return new zzdf(this.zza, this.zzb, zzznVarZzb, this.zzc);
        }

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
        }
    }

    public final zzdk zzc() {
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

    private zzdf(zzdk zzdkVar, zzzo zzzoVar, zzzn zzznVar, @Nullable Integer num) {
        this.zza = zzdkVar;
        this.zzb = zzzoVar;
        this.zzc = zzznVar;
        this.zzd = num;
    }
}

package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzdt extends zzcp {
    private final zzea zza;
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
        private zzea zza;

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

        public final zza zza(zzea zzeaVar) {
            this.zza = zzeaVar;
            return this;
        }

        public final zzdt zza() throws GeneralSecurityException {
            zzzn zzznVarZzb;
            zzea zzeaVar = this.zza;
            if (zzeaVar == null || this.zzb == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            }
            if (zzeaVar.zzb() != this.zzb.zza()) {
                throw new GeneralSecurityException("Key size mismatch");
            }
            if (this.zza.zza() && this.zzc == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            }
            if (!this.zza.zza() && this.zzc != null) {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            if (this.zza.zzd() == zzea.zzb.zzc) {
                zzznVarZzb = zzor.zza;
            } else if (this.zza.zzd() == zzea.zzb.zzb) {
                zzznVarZzb = zzor.zza(this.zzc.intValue());
            } else if (this.zza.zzd() == zzea.zzb.zza) {
                zzznVarZzb = zzor.zzb(this.zzc.intValue());
            } else {
                throw new IllegalStateException("Unknown AesGcmSivParameters.Variant: " + String.valueOf(this.zza.zzd()));
            }
            return new zzdt(this.zza, this.zzb, zzznVarZzb, this.zzc);
        }

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
        }
    }

    public final zzea zzc() {
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

    private zzdt(zzea zzeaVar, zzzo zzzoVar, zzzn zzznVar, @Nullable Integer num) {
        this.zza = zzeaVar;
        this.zzb = zzzoVar;
        this.zzc = zzznVar;
        this.zzd = num;
    }
}

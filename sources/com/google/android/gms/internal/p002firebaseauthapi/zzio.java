package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzio extends zziy {
    private final zzit zza;
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
        private zzit zza;

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

        public final zza zza(zzit zzitVar) {
            this.zza = zzitVar;
            return this;
        }

        public final zzio zza() throws GeneralSecurityException {
            zzzn zzznVarZzb;
            zzit zzitVar = this.zza;
            if (zzitVar == null || this.zzb == null) {
                throw new IllegalArgumentException("Cannot build without parameters and/or key material");
            }
            if (zzitVar.zzb() != this.zzb.zza()) {
                throw new GeneralSecurityException("Key size mismatch");
            }
            if (this.zza.zza() && this.zzc == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            }
            if (!this.zza.zza() && this.zzc != null) {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            if (this.zza.zzd() == zzit.zza.zzc) {
                zzznVarZzb = zzor.zza;
            } else if (this.zza.zzd() == zzit.zza.zzb) {
                zzznVarZzb = zzor.zza(this.zzc.intValue());
            } else if (this.zza.zzd() == zzit.zza.zza) {
                zzznVarZzb = zzor.zzb(this.zzc.intValue());
            } else {
                throw new IllegalStateException("Unknown AesSivParameters.Variant: " + String.valueOf(this.zza.zzd()));
            }
            return new zzio(this.zza, this.zzb, zzznVarZzb, this.zzc);
        }

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
        }
    }

    public final zzit zzc() {
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

    private zzio(zzit zzitVar, zzzo zzzoVar, zzzn zzznVar, @Nullable Integer num) {
        this.zza = zzitVar;
        this.zzb = zzzoVar;
        this.zzc = zzznVar;
        this.zzd = num;
    }
}

package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public class zzen extends zzcp {
    private final zzep zza;
    private final zzzn zzb;

    @Nullable
    private final Integer zzc;

    public static zzen zza(zzep zzepVar, @Nullable Integer num) throws GeneralSecurityException {
        zzzn zzznVarZza;
        if (zzepVar.zzb() == zzep.zza.zza) {
            if (num == null) {
                throw new GeneralSecurityException("For given Variant TINK the value of idRequirement must be non-null");
            }
            zzznVarZza = zzzn.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
        } else {
            if (zzepVar.zzb() != zzep.zza.zzb) {
                throw new GeneralSecurityException("Unknown Variant: " + String.valueOf(zzepVar.zzb()));
            }
            if (num != null) {
                throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
            }
            zzznVarZza = zzzn.zza(new byte[0]);
        }
        return new zzen(zzepVar, zzznVarZza, num);
    }

    public final zzep zzb() {
        return this.zza;
    }

    public final zzzn zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbo
    public final Integer zza() {
        return this.zzc;
    }

    private zzen(zzep zzepVar, zzzn zzznVar, @Nullable Integer num) {
        this.zza = zzepVar;
        this.zzb = zzznVar;
        this.zzc = num;
    }
}

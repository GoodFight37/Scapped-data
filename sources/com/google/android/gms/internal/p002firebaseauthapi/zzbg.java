package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbg implements zzbz {
    private final OutputStream zza;

    public static zzbz zza(OutputStream outputStream) {
        return new zzbg(outputStream);
    }

    private zzbg(OutputStream outputStream) {
        this.zza = outputStream;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbz
    public final void zza(zzuz zzuzVar) throws IOException {
        try {
            zzuz.zza zzaVarZzn = zzuzVar.zzn();
            zzuz.zza zzaVar = zzaVarZzn;
            ((zzuz) ((zzakg) zzaVarZzn.zza().zze())).zza(this.zza);
        } finally {
            this.zza.close();
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbz
    public final void zza(zzwl zzwlVar) throws IOException {
        try {
            zzwlVar.zza(this.zza);
        } finally {
            this.zza.close();
        }
    }
}

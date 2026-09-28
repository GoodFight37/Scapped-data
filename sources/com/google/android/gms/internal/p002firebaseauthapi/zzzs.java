package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.internal.zzbk;
import com.google.firebase.auth.zzc;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzzs {
    private String zza;
    private List<zzagz> zzb;
    private zzc zzc;

    public final zzc zza() {
        return this.zzc;
    }

    public final String zzb() {
        return this.zza;
    }

    public final List<MultiFactorInfo> zzc() {
        return zzbk.zza(this.zzb);
    }

    public zzzs(String str, List<zzagz> list, zzc zzcVar) {
        this.zza = str;
        this.zzb = list;
        this.zzc = zzcVar;
    }
}

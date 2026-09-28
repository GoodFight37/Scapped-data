package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzabf implements zzaew<zzagm> {
    private final /* synthetic */ zzaew zza;
    private final /* synthetic */ zzadp zzb;
    private final /* synthetic */ zzagw zzc;

    zzabf(zzabc zzabcVar, zzaew zzaewVar, zzadp zzadpVar, zzagw zzagwVar) {
        this.zza = zzaewVar;
        this.zzb = zzadpVar;
        this.zzc = zzagwVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaet
    public final void zza(String str) {
        this.zza.zza(str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaew
    public final /* synthetic */ void zza(zzagm zzagmVar) {
        List<zzagl> listZza = zzagmVar.zza();
        if (listZza == null || listZza.isEmpty()) {
            this.zza.zza("No users");
        } else {
            this.zzb.zza(this.zzc, listZza.get(0));
        }
    }
}

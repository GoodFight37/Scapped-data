package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzaab implements zzaew<zzagm> {
    private final /* synthetic */ zzaet zza;
    private final /* synthetic */ zzadp zzb;
    private final /* synthetic */ zzagw zzc;
    private final /* synthetic */ zzahm zzd;
    private final /* synthetic */ zzzv zze;

    zzaab(zzzv zzzvVar, zzaet zzaetVar, zzadp zzadpVar, zzagw zzagwVar, zzahm zzahmVar) {
        this.zza = zzaetVar;
        this.zzb = zzadpVar;
        this.zzc = zzagwVar;
        this.zzd = zzahmVar;
        this.zze = zzzvVar;
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
            zzzv.zza(this.zze, this.zzb, this.zzc, listZza.get(0), this.zzd, this.zza);
        }
    }
}

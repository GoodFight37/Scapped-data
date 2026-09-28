package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzaat implements zzaew<zzagm> {
    private final /* synthetic */ zzaew zza;
    private final /* synthetic */ zzagw zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzadp zzd;
    private final /* synthetic */ zzaaq zze;

    zzaat(zzaaq zzaaqVar, zzaew zzaewVar, zzagw zzagwVar, String str, zzadp zzadpVar) {
        this.zza = zzaewVar;
        this.zzb = zzagwVar;
        this.zzc = str;
        this.zzd = zzadpVar;
        this.zze = zzaaqVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaet
    public final void zza(String str) {
        this.zzd.zza(zzao.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaew
    public final /* synthetic */ void zza(zzagm zzagmVar) {
        List<zzagl> listZza = zzagmVar.zza();
        if (listZza == null || listZza.isEmpty()) {
            this.zza.zza("No users.");
            return;
        }
        zzagl zzaglVar = listZza.get(0);
        zzahm zzahmVar = new zzahm();
        zzahmVar.zzd(this.zzb.zzc()).zza(this.zzc);
        zzzv.zza(this.zze.zza, this.zzd, this.zzb, zzaglVar, zzahmVar, this.zza);
    }
}

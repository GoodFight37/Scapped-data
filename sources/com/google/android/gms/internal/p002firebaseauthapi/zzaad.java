package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.firebase.auth.zzc;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzaad implements zzaew<zzagm> {
    private final /* synthetic */ zzaet zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ Boolean zzd;
    private final /* synthetic */ zzc zze;
    private final /* synthetic */ zzadp zzf;
    private final /* synthetic */ zzagw zzg;

    zzaad(zzzv zzzvVar, zzaet zzaetVar, String str, String str2, Boolean bool, zzc zzcVar, zzadp zzadpVar, zzagw zzagwVar) {
        this.zza = zzaetVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bool;
        this.zze = zzcVar;
        this.zzf = zzadpVar;
        this.zzg = zzagwVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaet
    public final void zza(String str) {
        this.zza.zza(str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaew
    public final /* synthetic */ void zza(zzagm zzagmVar) {
        List<zzagl> listZza = zzagmVar.zza();
        if (listZza == null || listZza.isEmpty()) {
            this.zza.zza("No users.");
            return;
        }
        zzagl zzaglVar = listZza.get(0);
        zzahb zzahbVarZzf = zzaglVar.zzf();
        List<zzahc> listZza2 = zzahbVarZzf != null ? zzahbVarZzf.zza() : null;
        if (listZza2 != null && !listZza2.isEmpty()) {
            if (!TextUtils.isEmpty(this.zzb)) {
                for (int i = 0; i < listZza2.size(); i++) {
                    if (listZza2.get(i).zzf().equals(this.zzb)) {
                        listZza2.get(i).zza(this.zzc);
                        break;
                    }
                }
            } else {
                listZza2.get(0).zza(this.zzc);
            }
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            zzaglVar.zza(bool.booleanValue());
        } else {
            zzaglVar.zza(zzaglVar.zzb() - zzaglVar.zza() < 1000);
        }
        zzaglVar.zza(this.zze);
        this.zzf.zza(this.zzg, zzaglVar);
    }
}

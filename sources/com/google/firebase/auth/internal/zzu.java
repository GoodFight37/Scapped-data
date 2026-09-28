package com.google.firebase.auth.internal;

import com.google.android.gms.internal.p002firebaseauthapi.zzahg;
import com.google.firebase.auth.ActionCodeInfo;
import com.google.firebase.auth.ActionCodeResult;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzu implements ActionCodeResult {
    private final int zza;
    private final String zzb;
    private final String zzc;
    private final ActionCodeInfo zzd;

    @Override // com.google.firebase.auth.ActionCodeResult
    public final int getOperation() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.ActionCodeResult
    public final ActionCodeInfo getInfo() {
        return this.zzd;
    }

    @Override // com.google.firebase.auth.ActionCodeResult
    public final String getData(int i) {
        if (this.zza == 4) {
            return null;
        }
        if (i == 0) {
            return this.zzb;
        }
        if (i != 1) {
            return null;
        }
        return this.zzc;
    }

    public zzu(zzahg zzahgVar) {
        this.zzb = zzahgVar.zzg() ? zzahgVar.zzc() : zzahgVar.zzb();
        this.zzc = zzahgVar.zzb();
        ActionCodeInfo zzsVar = null;
        if (!zzahgVar.zzh()) {
            this.zza = 3;
            this.zzd = null;
            return;
        }
        String strZzd = zzahgVar.zzd();
        strZzd.hashCode();
        int i = 5;
        switch (strZzd) {
            case "REVERT_SECOND_FACTOR_ADDITION":
                i = 6;
                break;
            case "PASSWORD_RESET":
                i = 0;
                break;
            case "VERIFY_EMAIL":
                i = 1;
                break;
            case "VERIFY_AND_CHANGE_EMAIL":
                break;
            case "EMAIL_SIGNIN":
                i = 4;
                break;
            case "RECOVER_EMAIL":
                i = 2;
                break;
            default:
                i = 3;
                break;
        }
        this.zza = i;
        if (i == 4 || i == 3) {
            this.zzd = null;
            return;
        }
        if (zzahgVar.zzf()) {
            zzsVar = new zzv(zzahgVar.zzb(), zzbk.zza(zzahgVar.zza()));
        } else if (zzahgVar.zzg()) {
            zzsVar = new zzt(zzahgVar.zzc(), zzahgVar.zzb());
        } else if (zzahgVar.zze()) {
            zzsVar = new zzs(zzahgVar.zzb());
        }
        this.zzd = zzsVar;
    }
}

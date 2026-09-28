package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzpi extends zzoz {
    zzpi(zzpv zzpvVar) {
        super(zzpvVar);
    }

    private final String zzf(String str) {
        String strZzm = this.zzg.zzr().zzm(str);
        if (TextUtils.isEmpty(strZzm)) {
            return (String) zzgi.zzq.zza(null);
        }
        Uri uri = Uri.parse((String) zzgi.zzq.zza(null));
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.authority(strZzm + "." + uri.getAuthority());
        return builderBuildUpon.build().toString();
    }

    private final boolean zzh(String str, String str2) {
        zzh zzhVarZzl;
        zzpv zzpvVar = this.zzg;
        com.google.android.gms.internal.measurement.zzgo zzgoVarZzj = zzpvVar.zzr().zzj(str);
        if (zzgoVarZzj == null || (zzhVarZzl = zzpvVar.zzj().zzl(str)) == null) {
            return false;
        }
        if ((zzgoVarZzj.zzv() && zzgoVarZzj.zzi().zza() == 100) || this.zzu.zzw().zzak(str, zzhVarZzl.zzM())) {
            return true;
        }
        return !TextUtils.isEmpty(str2) && Math.abs(str2.hashCode() % 100) < zzgoVarZzj.zzi().zza();
    }

    private static final boolean zzi(String str) {
        String str2 = (String) zzgi.zzs.zza(null);
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        for (String str3 : str2.split(",")) {
            if (str.equalsIgnoreCase(str3.trim())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x01b4  */
    public final zzph zza(String str) {
        zzph zzphVar;
        zzio zzioVar = this.zzu;
        zzam zzamVarZzf = zzioVar.zzf();
        zzgg zzggVar = zzgi.zzaP;
        zzph zzphVar2 = null;
        if (!zzamVarZzf.zzx(null, zzggVar)) {
            zzpv zzpvVar = this.zzg;
            zzh zzhVarZzl = zzpvVar.zzj().zzl(str);
            if (zzhVarZzl == null) {
                return new zzph(zzf(str), Collections.emptyMap(), zzmf.GOOGLE_ANALYTICS, null);
            }
            if (!zzh(str, zzhVarZzl.zzD())) {
                return new zzph(zzf(str), Collections.emptyMap(), zzmf.GOOGLE_ANALYTICS, null);
            }
            if (zzhVarZzl.zzaL()) {
                zzioVar.zzaW().zzj().zza("sgtm upload enabled in manifest.");
                com.google.android.gms.internal.measurement.zzgo zzgoVarZzj = zzpvVar.zzr().zzj(zzhVarZzl.zzC());
                if (zzgoVarZzj == null || !zzgoVarZzj.zzv()) {
                    zzphVar = null;
                } else {
                    String strZzf = zzgoVarZzj.zzi().zzf();
                    if (TextUtils.isEmpty(strZzf)) {
                        zzphVar = null;
                    } else {
                        String strZzd = zzgoVarZzj.zzi().zzd();
                        zzioVar.zzaW().zzj().zzc("sgtm configured with upload_url, server_info", strZzf, true != TextUtils.isEmpty(strZzd) ? "N" : "Y");
                        if (TextUtils.isEmpty(strZzd)) {
                            zzioVar.zzaV();
                            zzphVar = new zzph(strZzf, Collections.emptyMap(), zzmf.SGTM, null);
                        } else {
                            HashMap map = new HashMap();
                            map.put("x-sgtm-server-info", strZzd);
                            if (!TextUtils.isEmpty(zzhVarZzl.zzM())) {
                                map.put("x-gtm-server-preview", zzhVarZzl.zzM());
                            }
                            zzphVar = new zzph(strZzf, map, zzmf.SGTM, null);
                        }
                    }
                }
            } else {
                zzphVar = null;
            }
            if (zzphVar != null) {
                return zzphVar;
            }
            return new zzph(zzf(str), Collections.emptyMap(), zzmf.GOOGLE_ANALYTICS, null);
        }
        zzpv zzpvVar2 = this.zzg;
        zzh zzhVarZzl2 = zzpvVar2.zzj().zzl(str);
        if (zzhVarZzl2 == null || !zzhVarZzl2.zzaL()) {
            return new zzph(zzf(str), Collections.emptyMap(), zzmf.GOOGLE_ANALYTICS, null);
        }
        com.google.android.gms.internal.measurement.zzif zzifVarZza = com.google.android.gms.internal.measurement.zzim.zza();
        zzifVarZza.zzc(2);
        zzifVarZza.zza((com.google.android.gms.internal.measurement.zzih) Preconditions.checkNotNull(com.google.android.gms.internal.measurement.zzih.zzb(zzhVarZzl2.zzb())));
        if (!zzh(str, zzhVarZzl2.zzD())) {
            zzifVarZza.zzb(3);
            return new zzph(zzf(str), Collections.emptyMap(), zzmf.GOOGLE_ANALYTICS, (com.google.android.gms.internal.measurement.zzim) zzifVarZza.zzba());
        }
        String strZzC = zzhVarZzl2.zzC();
        zzifVarZza.zzc(2);
        com.google.android.gms.internal.measurement.zzgo zzgoVarZzj2 = zzpvVar2.zzr().zzj(zzhVarZzl2.zzC());
        if (zzgoVarZzj2 == null || !zzgoVarZzj2.zzv()) {
            zzioVar.zzaW().zzj().zzb("[sgtm] Missing sgtm_setting in remote config. appId", strZzC);
            zzifVarZza.zzb(4);
        } else {
            HashMap map2 = new HashMap();
            if (!TextUtils.isEmpty(zzhVarZzl2.zzM())) {
                map2.put("x-gtm-server-preview", zzhVarZzl2.zzM());
            }
            String strZze = zzgoVarZzj2.zzi().zze();
            com.google.android.gms.internal.measurement.zzih zzihVarZzb = com.google.android.gms.internal.measurement.zzih.zzb(zzhVarZzl2.zzb());
            if (zzihVarZzb != null && zzihVarZzb != com.google.android.gms.internal.measurement.zzih.CLIENT_UPLOAD_ELIGIBLE) {
                zzifVarZza.zza(zzihVarZzb);
            } else if (!zzioVar.zzf().zzx(null, zzggVar)) {
                zzifVarZza.zza(com.google.android.gms.internal.measurement.zzih.SERVICE_FLAG_OFF);
            } else if (zzi(zzhVarZzl2.zzC())) {
                zzifVarZza.zza(com.google.android.gms.internal.measurement.zzih.PINNED_TO_SERVICE_UPLOAD);
            } else if (TextUtils.isEmpty(strZze)) {
                zzifVarZza.zza(com.google.android.gms.internal.measurement.zzih.MISSING_SGTM_SERVER_URL);
            } else {
                zzioVar.zzaW().zzj().zzb("[sgtm] Eligible for client side upload. appId", strZzC);
                zzifVarZza.zzc(3);
                zzifVarZza.zza(com.google.android.gms.internal.measurement.zzih.CLIENT_UPLOAD_ELIGIBLE);
                zzphVar2 = new zzph(strZze, map2, zzmf.SGTM_CLIENT, (com.google.android.gms.internal.measurement.zzim) zzifVarZza.zzba());
            }
            zzgoVarZzj2.zzi().zzf();
            zzgoVarZzj2.zzi().zzd();
            zzioVar.zzaV();
            if (TextUtils.isEmpty(strZze)) {
                zzifVarZza.zzb(6);
                zzioVar.zzaW().zzj().zzb("[sgtm] Local service, missing sgtm_server_url", zzhVarZzl2.zzC());
            } else {
                zzioVar.zzaW().zzj().zzb("[sgtm] Eligible for local service direct upload. appId", strZzC);
                zzifVarZza.zzc(5);
                zzifVarZza.zzb(2);
                zzphVar2 = new zzph(strZze, map2, zzmf.SGTM, (com.google.android.gms.internal.measurement.zzim) zzifVarZza.zzba());
            }
        }
        return zzphVar2 != null ? zzphVar2 : new zzph(zzf(str), Collections.emptyMap(), zzmf.GOOGLE_ANALYTICS, (com.google.android.gms.internal.measurement.zzim) zzifVarZza.zzba());
    }

    final boolean zzd(String str, com.google.android.gms.internal.measurement.zzih zzihVar) {
        com.google.android.gms.internal.measurement.zzgo zzgoVarZzj;
        zzg();
        return this.zzu.zzf().zzx(null, zzgi.zzaP) && zzihVar == com.google.android.gms.internal.measurement.zzih.CLIENT_UPLOAD_ELIGIBLE && !zzi(str) && (zzgoVarZzj = this.zzg.zzr().zzj(str)) != null && zzgoVarZzj.zzv() && !zzgoVarZzj.zzi().zze().isEmpty();
    }
}

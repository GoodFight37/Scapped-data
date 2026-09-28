package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzl extends zzam {
    private final zzab zzb;

    public zzl(zzab zzabVar) {
        this.zzb = zzabVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:23:0x0051  */
    @Override // com.google.android.gms.internal.measurement.zzam, com.google.android.gms.internal.measurement.zzap
    public final zzap zzcz(String str, zzg zzgVar, List list) {
        byte b;
        switch (str) {
            case "getEventName":
                b = 0;
                break;
            case "getTimestamp":
                b = 3;
                break;
            case "getParamValue":
                b = 1;
                break;
            case "getParams":
                b = 2;
                break;
            case "setParamValue":
                b = 5;
                break;
            case "setEventName":
                b = 4;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            zzh.zzh("getEventName", 0, list);
            return new zzat(this.zzb.zzb().zze());
        }
        if (b == 1) {
            zzh.zzh("getParamValue", 1, list);
            return zzi.zzb(this.zzb.zzb().zzc(zzgVar.zzb((zzap) list.get(0)).zzi()));
        }
        if (b == 2) {
            zzh.zzh("getParams", 0, list);
            Map mapZzf = this.zzb.zzb().zzf();
            zzam zzamVar = new zzam();
            for (String str2 : mapZzf.keySet()) {
                zzamVar.zzr(str2, zzi.zzb(mapZzf.get(str2)));
            }
            return zzamVar;
        }
        if (b == 3) {
            zzh.zzh("getTimestamp", 0, list);
            return new zzah(Double.valueOf(this.zzb.zzb().zza()));
        }
        if (b != 4) {
            if (b != 5) {
                return super.zzcz(str, zzgVar, list);
            }
            zzh.zzh("setParamValue", 2, list);
            String strZzi = zzgVar.zzb((zzap) list.get(0)).zzi();
            zzap zzapVarZzb = zzgVar.zzb((zzap) list.get(1));
            this.zzb.zzb().zzh(strZzi, zzh.zzf(zzapVarZzb));
            return zzapVarZzb;
        }
        zzh.zzh("setEventName", 1, list);
        zzap zzapVarZzb2 = zzgVar.zzb((zzap) list.get(0));
        if (zzf.equals(zzapVarZzb2) || zzg.equals(zzapVarZzb2)) {
            throw new IllegalArgumentException("Illegal event name");
        }
        this.zzb.zzb().zzg(zzapVarZzb2.zzi());
        return new zzat(zzapVarZzb2.zzi());
    }
}

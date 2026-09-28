package com.google.android.gms.measurement.internal;

import java.util.EnumMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzao {
    private final EnumMap zza;

    zzao() {
        this.zza = new EnumMap(zzjw.class);
    }

    public static zzao zzb(String str) {
        EnumMap enumMap = new EnumMap(zzjw.class);
        if (str.length() >= zzjw.values().length) {
            int i = 0;
            if (str.charAt(0) == '1') {
                zzjw[] zzjwVarArrValues = zzjw.values();
                int length = zzjwVarArrValues.length;
                int i2 = 1;
                while (i < length) {
                    enumMap.put(zzjwVarArrValues[i], zzan.zzb(str.charAt(i2)));
                    i++;
                    i2++;
                }
                return new zzao(enumMap);
            }
        }
        return new zzao();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("1");
        for (zzjw zzjwVar : zzjw.values()) {
            zzan zzanVar = (zzan) this.zza.get(zzjwVar);
            if (zzanVar == null) {
                zzanVar = zzan.UNSET;
            }
            sb.append(zzanVar.zzl);
        }
        return sb.toString();
    }

    public final zzan zza(zzjw zzjwVar) {
        zzan zzanVar = (zzan) this.zza.get(zzjwVar);
        return zzanVar == null ? zzan.UNSET : zzanVar;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x001b  */
    public final void zzc(zzjw zzjwVar, int i) {
        zzan zzanVar = zzan.UNSET;
        if (i == -30) {
            zzanVar = zzan.TCF;
        } else if (i == -20) {
            zzanVar = zzan.API;
        } else if (i == -10) {
            zzanVar = zzan.MANIFEST;
        } else if (i == 0) {
            zzanVar = zzan.API;
        } else if (i == 30) {
            zzanVar = zzan.INITIALIZATION;
        }
        this.zza.put(zzjwVar, zzanVar);
    }

    public final void zzd(zzjw zzjwVar, zzan zzanVar) {
        this.zza.put(zzjwVar, zzanVar);
    }

    private zzao(EnumMap enumMap) {
        EnumMap enumMap2 = new EnumMap(zzjw.class);
        this.zza = enumMap2;
        enumMap2.putAll(enumMap);
    }
}

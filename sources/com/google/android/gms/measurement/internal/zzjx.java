package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzjx {
    public static final zzjx zza = new zzjx(null, null, 100);
    private final EnumMap zzb;
    private final int zzc;

    public zzjx(Boolean bool, Boolean bool2, int i) {
        EnumMap enumMap = new EnumMap(zzjw.class);
        this.zzb = enumMap;
        enumMap.put(zzjw.AD_STORAGE, zzh(null));
        enumMap.put(zzjw.ANALYTICS_STORAGE, zzh(null));
        this.zzc = i;
    }

    static char zza(zzju zzjuVar) {
        if (zzjuVar == null) {
            return '-';
        }
        int iOrdinal = zzjuVar.ordinal();
        if (iOrdinal == 1) {
            return '+';
        }
        if (iOrdinal != 2) {
            return iOrdinal != 3 ? '-' : '1';
        }
        return '0';
    }

    static zzju zzd(String str) {
        if (str == null) {
            return zzju.UNINITIALIZED;
        }
        if (str.equals("granted")) {
            return zzju.GRANTED;
        }
        return str.equals("denied") ? zzju.DENIED : zzju.UNINITIALIZED;
    }

    static zzju zzh(Boolean bool) {
        if (bool == null) {
            return zzju.UNINITIALIZED;
        }
        return bool.booleanValue() ? zzju.GRANTED : zzju.DENIED;
    }

    public static zzjx zzi(Bundle bundle, int i) {
        if (bundle == null) {
            return new zzjx(null, null, i);
        }
        EnumMap enumMap = new EnumMap(zzjw.class);
        for (zzjw zzjwVar : zzjv.STORAGE.zzd) {
            enumMap.put(zzjwVar, zzd(bundle.getString(zzjwVar.zze)));
        }
        return new zzjx(enumMap, i);
    }

    public static zzjx zzj(zzju zzjuVar, zzju zzjuVar2, int i) {
        EnumMap enumMap = new EnumMap(zzjw.class);
        enumMap.put(zzjw.AD_STORAGE, zzjuVar);
        enumMap.put(zzjw.ANALYTICS_STORAGE, zzjuVar2);
        return new zzjx(enumMap, -10);
    }

    public static zzjx zzk(String str, int i) {
        EnumMap enumMap = new EnumMap(zzjw.class);
        zzjw[] zzjwVarArrZzb = zzjv.STORAGE.zzb();
        for (int i2 = 0; i2 < zzjwVarArrZzb.length; i2++) {
            String str2 = str == null ? "" : str;
            zzjw zzjwVar = zzjwVarArrZzb[i2];
            int i3 = i2 + 2;
            if (i3 < str2.length()) {
                enumMap.put(zzjwVar, zzg(str2.charAt(i3)));
            } else {
                enumMap.put(zzjwVar, zzju.UNINITIALIZED);
            }
        }
        return new zzjx(enumMap, i);
    }

    static String zzn(int i) {
        if (i == -30) {
            return "TCF";
        }
        if (i == -20) {
            return "API";
        }
        if (i == -10) {
            return "MANIFEST";
        }
        if (i == 0) {
            return "1P_API";
        }
        if (i == 30) {
            return "1P_INIT";
        }
        if (i != 90) {
            return i != 100 ? "OTHER" : "UNKNOWN";
        }
        return "REMOTE_CONFIG";
    }

    static String zzo(zzju zzjuVar) {
        int iOrdinal = zzjuVar.ordinal();
        if (iOrdinal == 2) {
            return "denied";
        }
        if (iOrdinal != 3) {
            return null;
        }
        return "granted";
    }

    public static boolean zzs(int i, int i2) {
        int i3 = -30;
        if (i == -20) {
            if (i2 == -30) {
                return true;
            }
            i = -20;
        }
        if (i != -30) {
            i3 = i;
        } else if (i2 == -20) {
            return true;
        }
        return i3 == i2 || i < i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzjx)) {
            return false;
        }
        zzjx zzjxVar = (zzjx) obj;
        for (zzjw zzjwVar : zzjv.STORAGE.zzd) {
            if (this.zzb.get(zzjwVar) != zzjxVar.zzb.get(zzjwVar)) {
                return false;
            }
        }
        return this.zzc == zzjxVar.zzc;
    }

    public final int hashCode() {
        Iterator it = this.zzb.values().iterator();
        int iHashCode = this.zzc * 17;
        while (it.hasNext()) {
            iHashCode = (iHashCode * 31) + ((zzju) it.next()).hashCode();
        }
        return iHashCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(zzn(this.zzc));
        for (zzjw zzjwVar : zzjv.STORAGE.zzd) {
            sb.append(",");
            sb.append(zzjwVar.zze);
            sb.append("=");
            zzju zzjuVar = (zzju) this.zzb.get(zzjwVar);
            if (zzjuVar == null) {
                zzjuVar = zzju.UNINITIALIZED;
            }
            sb.append(zzjuVar);
        }
        return sb.toString();
    }

    public final int zzb() {
        return this.zzc;
    }

    public final Bundle zzc() {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : this.zzb.entrySet()) {
            String strZzo = zzo((zzju) entry.getValue());
            if (strZzo != null) {
                bundle.putString(((zzjw) entry.getKey()).zze, strZzo);
            }
        }
        return bundle;
    }

    public final zzju zze() {
        zzju zzjuVar = (zzju) this.zzb.get(zzjw.AD_STORAGE);
        return zzjuVar == null ? zzju.UNINITIALIZED : zzjuVar;
    }

    public final zzju zzf() {
        zzju zzjuVar = (zzju) this.zzb.get(zzjw.ANALYTICS_STORAGE);
        return zzjuVar == null ? zzju.UNINITIALIZED : zzjuVar;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0033  */
    public final zzjx zzl(zzjx zzjxVar) {
        EnumMap enumMap = new EnumMap(zzjw.class);
        for (zzjw zzjwVar : zzjv.STORAGE.zzd) {
            zzju zzjuVar = (zzju) this.zzb.get(zzjwVar);
            zzju zzjuVar2 = (zzju) zzjxVar.zzb.get(zzjwVar);
            if (zzjuVar == null) {
                zzjuVar = zzjuVar2;
            } else if (zzjuVar2 != null) {
                zzju zzjuVar3 = zzju.UNINITIALIZED;
                if (zzjuVar == zzjuVar3) {
                    zzjuVar = zzjuVar2;
                } else if (zzjuVar2 != zzjuVar3) {
                    zzju zzjuVar4 = zzju.POLICY;
                    if (zzjuVar == zzjuVar4) {
                        zzjuVar = zzjuVar2;
                    } else if (zzjuVar2 != zzjuVar4) {
                        zzju zzjuVar5 = zzju.DENIED;
                        zzjuVar = (zzjuVar == zzjuVar5 || zzjuVar2 == zzjuVar5) ? zzjuVar5 : zzju.GRANTED;
                    }
                }
            }
            if (zzjuVar != null) {
                enumMap.put(zzjwVar, zzjuVar);
            }
        }
        return new zzjx(enumMap, 100);
    }

    public final zzjx zzm(zzjx zzjxVar) {
        EnumMap enumMap = new EnumMap(zzjw.class);
        for (zzjw zzjwVar : zzjv.STORAGE.zzd) {
            zzju zzjuVar = (zzju) this.zzb.get(zzjwVar);
            if (zzjuVar == zzju.UNINITIALIZED) {
                zzjuVar = (zzju) zzjxVar.zzb.get(zzjwVar);
            }
            if (zzjuVar != null) {
                enumMap.put(zzjwVar, zzjuVar);
            }
        }
        return new zzjx(enumMap, this.zzc);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0032  */
    public final String zzp() {
        int iOrdinal;
        StringBuilder sb = new StringBuilder("G1");
        for (zzjw zzjwVar : zzjv.STORAGE.zzb()) {
            zzju zzjuVar = (zzju) this.zzb.get(zzjwVar);
            char c = '-';
            if (zzjuVar != null && (iOrdinal = zzjuVar.ordinal()) != 0) {
                if (iOrdinal == 1) {
                    c = '1';
                } else if (iOrdinal == 2) {
                    c = '0';
                } else if (iOrdinal == 3) {
                    c = '1';
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public final String zzq() {
        StringBuilder sb = new StringBuilder("G1");
        for (zzjw zzjwVar : zzjv.STORAGE.zzb()) {
            sb.append(zza((zzju) this.zzb.get(zzjwVar)));
        }
        return sb.toString();
    }

    public final boolean zzr(zzjw zzjwVar) {
        return ((zzju) this.zzb.get(zzjwVar)) != zzju.DENIED;
    }

    public final boolean zzt() {
        Iterator it = this.zzb.values().iterator();
        while (it.hasNext()) {
            if (((zzju) it.next()) != zzju.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public final boolean zzu(zzjx zzjxVar) {
        EnumMap enumMap = this.zzb;
        for (zzjw zzjwVar : (zzjw[]) enumMap.keySet().toArray(new zzjw[0])) {
            zzju zzjuVar = (zzju) enumMap.get(zzjwVar);
            zzju zzjuVar2 = (zzju) zzjxVar.zzb.get(zzjwVar);
            if (zzjuVar == zzju.DENIED && zzjuVar2 != zzju.DENIED) {
                return true;
            }
        }
        return false;
    }

    private zzjx(EnumMap enumMap, int i) {
        EnumMap enumMap2 = new EnumMap(zzjw.class);
        this.zzb = enumMap2;
        enumMap2.putAll(enumMap);
        this.zzc = i;
    }

    static zzju zzg(char c) {
        if (c == '+') {
            return zzju.POLICY;
        }
        if (c != '0') {
            return c != '1' ? zzju.UNINITIALIZED : zzju.GRANTED;
        }
        return zzju.DENIED;
    }
}

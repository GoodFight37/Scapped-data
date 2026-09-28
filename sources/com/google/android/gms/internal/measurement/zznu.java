package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.4.0 */
/* JADX INFO: loaded from: classes.dex */
final class zznu {
    public static final /* synthetic */ int zza = 0;
    private static final zzoe zzb;

    static {
        int i = zznp.zza;
        zzb = new zzog();
    }

    public static void zzA(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzC(i, list, z);
    }

    public static void zzB(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzE(i, list, z);
    }

    public static void zzC(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzJ(i, list, z);
    }

    public static void zzD(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzL(i, list, z);
    }

    static boolean zzE(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static int zza(List list) {
        int iZzA;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzme) {
            zzme zzmeVar = (zzme) list;
            iZzA = 0;
            while (i < size) {
                iZzA += zzlk.zzA(zzmeVar.zze(i));
                i++;
            }
        } else {
            iZzA = 0;
            while (i < size) {
                iZzA += zzlk.zzA(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzA;
    }

    static int zzb(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzlk.zzz(i << 3) + 4);
    }

    static int zzc(List list) {
        return list.size() * 4;
    }

    static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzlk.zzz(i << 3) + 8);
    }

    static int zze(List list) {
        return list.size() * 8;
    }

    static int zzf(List list) {
        int iZzA;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzme) {
            zzme zzmeVar = (zzme) list;
            iZzA = 0;
            while (i < size) {
                iZzA += zzlk.zzA(zzmeVar.zze(i));
                i++;
            }
        } else {
            iZzA = 0;
            while (i < size) {
                iZzA += zzlk.zzA(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzA;
    }

    static int zzg(List list) {
        int iZzA;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzmw) {
            zzmw zzmwVar = (zzmw) list;
            iZzA = 0;
            while (i < size) {
                iZzA += zzlk.zzA(zzmwVar.zza(i));
                i++;
            }
        } else {
            iZzA = 0;
            while (i < size) {
                iZzA += zzlk.zzA(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iZzA;
    }

    static int zzh(int i, Object obj, zzns zznsVar) {
        int i2 = i << 3;
        if (!(obj instanceof zzms)) {
            return zzlk.zzz(i2) + zzlk.zzx((zznh) obj, zznsVar);
        }
        int iZzz = zzlk.zzz(i2);
        int iZza = ((zzms) obj).zza();
        return iZzz + zzlk.zzz(iZza) + iZza;
    }

    static int zzi(List list) {
        int iZzz;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzme) {
            zzme zzmeVar = (zzme) list;
            iZzz = 0;
            while (i < size) {
                int iZze = zzmeVar.zze(i);
                iZzz += zzlk.zzz((iZze >> 31) ^ (iZze + iZze));
                i++;
            }
        } else {
            iZzz = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iZzz += zzlk.zzz((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
        }
        return iZzz;
    }

    static int zzj(List list) {
        int iZzA;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzmw) {
            zzmw zzmwVar = (zzmw) list;
            iZzA = 0;
            while (i < size) {
                long jZza = zzmwVar.zza(i);
                iZzA += zzlk.zzA((jZza >> 63) ^ (jZza + jZza));
                i++;
            }
        } else {
            iZzA = 0;
            while (i < size) {
                long jLongValue = ((Long) list.get(i)).longValue();
                iZzA += zzlk.zzA((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i++;
            }
        }
        return iZzA;
    }

    static int zzk(List list) {
        int iZzz;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzme) {
            zzme zzmeVar = (zzme) list;
            iZzz = 0;
            while (i < size) {
                iZzz += zzlk.zzz(zzmeVar.zze(i));
                i++;
            }
        } else {
            iZzz = 0;
            while (i < size) {
                iZzz += zzlk.zzz(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzz;
    }

    static int zzl(List list) {
        int iZzA;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzmw) {
            zzmw zzmwVar = (zzmw) list;
            iZzA = 0;
            while (i < size) {
                iZzA += zzlk.zzA(zzmwVar.zza(i));
                i++;
            }
        } else {
            iZzA = 0;
            while (i < size) {
                iZzA += zzlk.zzA(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iZzA;
    }

    public static zzoe zzm() {
        return zzb;
    }

    static Object zzn(Object obj, int i, int i2, Object obj2, zzoe zzoeVar) {
        zzmd zzmdVar;
        zzof zzofVar;
        Object obj3 = obj2;
        if (obj2 == null && (zzofVar = (zzmdVar = (zzmd) obj).zzc) == zzof.zzc()) {
            obj3 = zzofVar;
            zzof zzofVarZzf = zzof.zzf();
            zzmdVar.zzc = zzofVarZzf;
            obj3 = zzofVarZzf;
        }
        obj3 = zzofVar;
        ((zzof) obj3).zzj(i << 3, Long.valueOf(i2));
        return obj3;
    }

    static void zzo(zzlq zzlqVar, Object obj, Object obj2) {
        if (((zzma) obj2).zzb.zza.isEmpty()) {
            return;
        }
        throw null;
    }

    static void zzp(zzoe zzoeVar, Object obj, Object obj2) {
        zzmd zzmdVar = (zzmd) obj;
        zzof zzofVarZze = zzmdVar.zzc;
        zzof zzofVar = ((zzmd) obj2).zzc;
        if (!zzof.zzc().equals(zzofVar)) {
            if (zzof.zzc().equals(zzofVarZze)) {
                zzofVarZze = zzof.zze(zzofVarZze, zzofVar);
            } else {
                zzofVarZze.zzd(zzofVar);
            }
        }
        zzmdVar.zzc = zzofVarZze;
    }

    public static void zzq(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzc(i, list, z);
    }

    public static void zzr(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzg(i, list, z);
    }

    public static void zzs(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzj(i, list, z);
    }

    public static void zzt(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzl(i, list, z);
    }

    public static void zzu(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzn(i, list, z);
    }

    public static void zzv(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzp(i, list, z);
    }

    public static void zzw(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzs(i, list, z);
    }

    public static void zzx(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzu(i, list, z);
    }

    public static void zzy(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzy(i, list, z);
    }

    public static void zzz(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzA(i, list, z);
    }
}

package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzame {
    private static final zzamv<?, ?> zza = new zzamx();

    static int zza(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzajo.zza(i, true);
    }

    static int zza(List<?> list) {
        return list.size();
    }

    static int zza(int i, List<zzaiw> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzg = size * zzajo.zzg(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            iZzg += zzajo.zza(list.get(i2));
        }
        return iZzg;
    }

    static int zzb(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzajo.zzg(i));
    }

    static int zzb(List<Integer> list) {
        int iZza;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzakj) {
            zzakj zzakjVar = (zzakj) list;
            iZza = 0;
            while (i < size) {
                iZza += zzajo.zza(zzakjVar.zzb(i));
                i++;
            }
        } else {
            iZza = 0;
            while (i < size) {
                iZza += zzajo.zza(list.get(i).intValue());
                i++;
            }
        }
        return iZza;
    }

    static int zzc(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzajo.zzb(i, 0);
    }

    static int zzc(List<?> list) {
        return list.size() << 2;
    }

    static int zzd(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzajo.zza(i, 0L);
    }

    static int zzd(List<?> list) {
        return list.size() << 3;
    }

    static int zza(int i, List<zzaln> list, zzamc<?> zzamcVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZza = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZza += zzajo.zza(i, list.get(i2), zzamcVar);
        }
        return iZza;
    }

    static int zze(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzajo.zzg(i));
    }

    static int zze(List<Integer> list) {
        int iZzc;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzakj) {
            zzakj zzakjVar = (zzakj) list;
            iZzc = 0;
            while (i < size) {
                iZzc += zzajo.zzc(zzakjVar.zzb(i));
                i++;
            }
        } else {
            iZzc = 0;
            while (i < size) {
                iZzc += zzajo.zzc(list.get(i).intValue());
                i++;
            }
        }
        return iZzc;
    }

    static int zzf(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzf(list) + (list.size() * zzajo.zzg(i));
    }

    static int zzf(List<Long> list) {
        int iZzb;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaky) {
            zzaky zzakyVar = (zzaky) list;
            iZzb = 0;
            while (i < size) {
                iZzb += zzajo.zzb(zzakyVar.zzb(i));
                i++;
            }
        } else {
            iZzb = 0;
            while (i < size) {
                iZzb += zzajo.zzb(list.get(i).longValue());
                i++;
            }
        }
        return iZzb;
    }

    static int zza(int i, Object obj, zzamc<?> zzamcVar) {
        if (obj instanceof zzakv) {
            return zzajo.zzb(i, (zzakv) obj);
        }
        return zzajo.zzb(i, (zzaln) obj, zzamcVar);
    }

    static int zzb(int i, List<?> list, zzamc<?> zzamcVar) {
        int iZza;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzg = zzajo.zzg(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzakv) {
                iZza = zzajo.zza((zzakv) obj);
            } else {
                iZza = zzajo.zza((zzaln) obj, zzamcVar);
            }
            iZzg += iZza;
        }
        return iZzg;
    }

    static int zzg(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzajo.zzg(i));
    }

    static int zzg(List<Integer> list) {
        int iZzf;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzakj) {
            zzakj zzakjVar = (zzakj) list;
            iZzf = 0;
            while (i < size) {
                iZzf += zzajo.zzf(zzakjVar.zzb(i));
                i++;
            }
        } else {
            iZzf = 0;
            while (i < size) {
                iZzf += zzajo.zzf(list.get(i).intValue());
                i++;
            }
        }
        return iZzf;
    }

    static int zzh(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzh(list) + (size * zzajo.zzg(i));
    }

    static int zzh(List<Long> list) {
        int iZzd;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaky) {
            zzaky zzakyVar = (zzaky) list;
            iZzd = 0;
            while (i < size) {
                iZzd += zzajo.zzd(zzakyVar.zzb(i));
                i++;
            }
        } else {
            iZzd = 0;
            while (i < size) {
                iZzd += zzajo.zzd(list.get(i).longValue());
                i++;
            }
        }
        return iZzd;
    }

    static int zzb(int i, List<?> list) {
        int iZza;
        int iZza2;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int iZzg = zzajo.zzg(i) * size;
        if (list instanceof zzaku) {
            zzaku zzakuVar = (zzaku) list;
            while (i2 < size) {
                Object objZza = zzakuVar.zza(i2);
                if (objZza instanceof zzaiw) {
                    iZza2 = zzajo.zza((zzaiw) objZza);
                } else {
                    iZza2 = zzajo.zza((String) objZza);
                }
                iZzg += iZza2;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzaiw) {
                    iZza = zzajo.zza((zzaiw) obj);
                } else {
                    iZza = zzajo.zza((String) obj);
                }
                iZzg += iZza;
                i2++;
            }
        }
        return iZzg;
    }

    static int zzi(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzi(list) + (size * zzajo.zzg(i));
    }

    static int zzi(List<Integer> list) {
        int iZzh;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzakj) {
            zzakj zzakjVar = (zzakj) list;
            iZzh = 0;
            while (i < size) {
                iZzh += zzajo.zzh(zzakjVar.zzb(i));
                i++;
            }
        } else {
            iZzh = 0;
            while (i < size) {
                iZzh += zzajo.zzh(list.get(i).intValue());
                i++;
            }
        }
        return iZzh;
    }

    static int zzj(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzj(list) + (size * zzajo.zzg(i));
    }

    static int zzj(List<Long> list) {
        int iZze;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaky) {
            zzaky zzakyVar = (zzaky) list;
            iZze = 0;
            while (i < size) {
                iZze += zzajo.zze(zzakyVar.zzb(i));
                i++;
            }
        } else {
            iZze = 0;
            while (i < size) {
                iZze += zzajo.zze(list.get(i).longValue());
                i++;
            }
        }
        return iZze;
    }

    public static zzamv<?, ?> zza() {
        return zza;
    }

    static <UT, UB> UB zza(Object obj, int i, List<Integer> list, zzakk zzakkVar, UB ub, zzamv<UT, UB> zzamvVar) {
        if (zzakkVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int iIntValue = list.get(i3).intValue();
                if (zzakkVar.zza(iIntValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(iIntValue));
                    }
                    i2++;
                } else {
                    ub = (UB) zza(obj, i, iIntValue, ub, zzamvVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = it.next().intValue();
                if (!zzakkVar.zza(iIntValue2)) {
                    ub = (UB) zza(obj, i, iIntValue2, ub, zzamvVar);
                    it.remove();
                }
            }
        }
        return ub;
    }

    static <UT, UB> UB zza(Object obj, int i, int i2, UB ub, zzamv<UT, UB> zzamvVar) {
        if (ub == null) {
            ub = zzamvVar.zzc(obj);
        }
        zzamvVar.zzb(ub, i, i2);
        return ub;
    }

    static <T, FT extends zzaka<FT>> void zza(zzajx<FT> zzajxVar, T t, T t2) {
        zzajy<T> zzajyVarZza = zzajxVar.zza(t2);
        if (zzajyVarZza.zza.isEmpty()) {
            return;
        }
        zzajxVar.zzb(t).zza((zzajy) zzajyVarZza);
    }

    static <T> void zza(zzalg zzalgVar, T t, T t2, long j) {
        zzana.zza(t, j, zzalgVar.zza(zzana.zze(t, j), zzana.zze(t2, j)));
    }

    static <T, UT, UB> void zza(zzamv<UT, UB> zzamvVar, T t, T t2) {
        zzamvVar.zzc(t, zzamvVar.zza(zzamvVar.zzd(t), zzamvVar.zzd(t2)));
    }

    public static void zza(Class<?> cls) {
        zzakg.class.isAssignableFrom(cls);
    }

    public static void zza(int i, List<Boolean> list, zzanm zzanmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zza(i, list, z);
    }

    public static void zza(int i, List<zzaiw> list, zzanm zzanmVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zza(i, list);
    }

    public static void zzb(int i, List<Double> list, zzanm zzanmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zzb(i, list, z);
    }

    public static void zzc(int i, List<Integer> list, zzanm zzanmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zzc(i, list, z);
    }

    public static void zzd(int i, List<Integer> list, zzanm zzanmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zzd(i, list, z);
    }

    public static void zze(int i, List<Long> list, zzanm zzanmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zze(i, list, z);
    }

    public static void zzf(int i, List<Float> list, zzanm zzanmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zzf(i, list, z);
    }

    public static void zza(int i, List<?> list, zzanm zzanmVar, zzamc<?> zzamcVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zza(i, list, (zzamc) zzamcVar);
    }

    public static void zzg(int i, List<Integer> list, zzanm zzanmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zzg(i, list, z);
    }

    public static void zzh(int i, List<Long> list, zzanm zzanmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zzh(i, list, z);
    }

    public static void zzb(int i, List<?> list, zzanm zzanmVar, zzamc<?> zzamcVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zzb(i, list, (zzamc) zzamcVar);
    }

    public static void zzi(int i, List<Integer> list, zzanm zzanmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zzi(i, list, z);
    }

    public static void zzj(int i, List<Long> list, zzanm zzanmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zzj(i, list, z);
    }

    public static void zzk(int i, List<Integer> list, zzanm zzanmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zzk(i, list, z);
    }

    public static void zzl(int i, List<Long> list, zzanm zzanmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zzl(i, list, z);
    }

    public static void zzb(int i, List<String> list, zzanm zzanmVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zzb(i, list);
    }

    public static void zzm(int i, List<Integer> list, zzanm zzanmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zzm(i, list, z);
    }

    public static void zzn(int i, List<Long> list, zzanm zzanmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzanmVar.zzn(i, list, z);
    }

    static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}

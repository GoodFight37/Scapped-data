package com.google.android.gms.internal.measurement;

import com.adjust.sdk.Constants;
import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbb {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x0036  */
    /* JADX WARN: Code duplicated, block: B:63:0x0101 A[PHI: r4
  0x0101: PHI (r4v3 java.lang.String) = (r4v2 java.lang.String), (r4v4 java.lang.String) binds: [B:61:0x00fb, B:58:0x00ed] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v124, types: [com.google.android.gms.internal.measurement.zzap] */
    /* JADX WARN: Type inference failed for: r1v25, types: [com.google.android.gms.internal.measurement.zzat] */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.google.android.gms.internal.measurement.zzae] */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v43, types: [com.google.android.gms.internal.measurement.zzap] */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.google.android.gms.internal.measurement.zzae] */
    public static zzap zza(String str, zzae zzaeVar, zzg zzgVar, List list) {
        String str2;
        String str3;
        byte b;
        ?? zzaeVar2;
        String strZzi;
        double dZzc;
        zzae zzaeVar3;
        zzai zzaiVar;
        switch (str.hashCode()) {
            case -1776922004:
                str2 = "toString";
                str3 = "filter";
                b = str.equals(str2) ? Ascii.DC2 : (byte) -1;
                break;
            case -1354795244:
                str3 = "filter";
                if (str.equals("concat")) {
                    str2 = "toString";
                    b = 0;
                } else {
                    str2 = "toString";
                }
                break;
            case -1274492040:
                str3 = "filter";
                if (str.equals(str3)) {
                    str2 = "toString";
                    b = 2;
                } else {
                    str2 = "toString";
                }
                break;
            case -934873754:
                if (str.equals("reduce")) {
                    b = 10;
                    str2 = "toString";
                    str3 = "filter";
                }
                str2 = "toString";
                str3 = "filter";
                break;
            case -895859076:
                if (str.equals("splice")) {
                    b = 17;
                    str2 = "toString";
                    str3 = "filter";
                }
                str2 = "toString";
                str3 = "filter";
                break;
            case -678635926:
                if (str.equals("forEach")) {
                    b = 3;
                    str2 = "toString";
                    str3 = "filter";
                }
                str2 = "toString";
                str3 = "filter";
                break;
            case -467511597:
                if (str.equals("lastIndexOf")) {
                    b = 6;
                    str2 = "toString";
                    str3 = "filter";
                }
                str2 = "toString";
                str3 = "filter";
                break;
            case -277637751:
                if (str.equals("unshift")) {
                    b = 19;
                    str2 = "toString";
                    str3 = "filter";
                }
                str2 = "toString";
                str3 = "filter";
                break;
            case 107868:
                if (str.equals("map")) {
                    b = 7;
                    str2 = "toString";
                    str3 = "filter";
                }
                str2 = "toString";
                str3 = "filter";
                break;
            case 111185:
                if (str.equals("pop")) {
                    b = 8;
                    str2 = "toString";
                    str3 = "filter";
                }
                str2 = "toString";
                str3 = "filter";
                break;
            case 3267882:
                if (str.equals("join")) {
                    b = 5;
                    str2 = "toString";
                    str3 = "filter";
                }
                str2 = "toString";
                str3 = "filter";
                break;
            case 3452698:
                if (str.equals(Constants.PUSH)) {
                    b = 9;
                    str2 = "toString";
                    str3 = "filter";
                }
                str2 = "toString";
                str3 = "filter";
                break;
            case 3536116:
                if (str.equals("some")) {
                    b = Ascii.SI;
                    str2 = "toString";
                    str3 = "filter";
                }
                str2 = "toString";
                str3 = "filter";
                break;
            case 3536286:
                if (str.equals("sort")) {
                    b = Ascii.DLE;
                    str2 = "toString";
                    str3 = "filter";
                }
                str2 = "toString";
                str3 = "filter";
                break;
            case 96891675:
                if (str.equals("every")) {
                    str2 = "toString";
                    str3 = "filter";
                    b = 1;
                } else {
                    str2 = "toString";
                    str3 = "filter";
                }
                break;
            case 109407362:
                if (str.equals("shift")) {
                    b = Ascii.CR;
                    str2 = "toString";
                    str3 = "filter";
                }
                str2 = "toString";
                str3 = "filter";
                break;
            case 109526418:
                if (str.equals("slice")) {
                    b = Ascii.SO;
                    str2 = "toString";
                    str3 = "filter";
                }
                str2 = "toString";
                str3 = "filter";
                break;
            case 965561430:
                if (str.equals("reduceRight")) {
                    b = Ascii.VT;
                    str2 = "toString";
                    str3 = "filter";
                }
                str2 = "toString";
                str3 = "filter";
                break;
            case 1099846370:
                if (str.equals("reverse")) {
                    b = Ascii.FF;
                    str2 = "toString";
                    str3 = "filter";
                }
                str2 = "toString";
                str3 = "filter";
                break;
            case 1943291465:
                if (str.equals("indexOf")) {
                    b = 4;
                    str2 = "toString";
                    str3 = "filter";
                }
                str2 = "toString";
                str3 = "filter";
                break;
            default:
                str2 = "toString";
                str3 = "filter";
                break;
        }
        String str4 = str2;
        String str5 = str3;
        double dZzc2 = 0.0d;
        switch (b) {
            case 0:
                zzaeVar2 = (zzae) zzaeVar.zzd();
                if (!list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        zzap zzapVarZzb = zzgVar.zzb((zzap) it.next());
                        if (zzapVarZzb instanceof zzag) {
                            throw new IllegalStateException("Failed evaluation of arguments");
                        }
                        int iZzc = zzaeVar2.zzc();
                        if (zzapVarZzb instanceof zzae) {
                            zzae zzaeVar4 = (zzae) zzapVarZzb;
                            Iterator itZzk = zzaeVar4.zzk();
                            while (itZzk.hasNext()) {
                                Integer num = (Integer) itZzk.next();
                                zzaeVar2.zzq(num.intValue() + iZzc, zzaeVar4.zze(num.intValue()));
                            }
                        } else {
                            zzaeVar2.zzq(iZzc, zzapVarZzb);
                        }
                    }
                }
                return zzaeVar2;
            case 1:
                zzh.zzh("every", 1, list);
                zzap zzapVarZzb2 = zzgVar.zzb((zzap) list.get(0));
                if (!(zzapVarZzb2 instanceof zzao)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (zzaeVar.zzc() != 0 && zzb(zzaeVar, zzgVar, (zzao) zzapVarZzb2, false, true).zzc() != zzaeVar.zzc()) {
                    return zzap.zzl;
                }
                return zzap.zzk;
            case 2:
                zzh.zzh(str5, 1, list);
                zzap zzapVarZzb3 = zzgVar.zzb((zzap) list.get(0));
                if (!(zzapVarZzb3 instanceof zzao)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (zzaeVar.zzb() == 0) {
                    return new zzae();
                }
                zzae zzaeVar5 = (zzae) zzaeVar.zzd();
                zzae zzaeVarZzb = zzb(zzaeVar, zzgVar, (zzao) zzapVarZzb3, null, true);
                zzaeVar2 = new zzae();
                Iterator itZzk2 = zzaeVarZzb.zzk();
                while (itZzk2.hasNext()) {
                    zzaeVar2.zzq(zzaeVar2.zzc(), zzaeVar5.zze(((Integer) itZzk2.next()).intValue()));
                }
                return zzaeVar2;
            case 3:
                zzh.zzh("forEach", 1, list);
                zzap zzapVarZzb4 = zzgVar.zzb((zzap) list.get(0));
                if (!(zzapVarZzb4 instanceof zzao)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (zzaeVar.zzb() == 0) {
                    return zzap.zzf;
                }
                zzb(zzaeVar, zzgVar, (zzao) zzapVarZzb4, null, null);
                return zzap.zzf;
            case 4:
                zzh.zzj("indexOf", 2, list);
                zzap zzapVarZzb5 = zzap.zzf;
                if (!list.isEmpty()) {
                    zzapVarZzb5 = zzgVar.zzb((zzap) list.get(0));
                }
                if (list.size() > 1) {
                    double dZza = zzh.zza(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue());
                    if (dZza >= zzaeVar.zzc()) {
                        return new zzah(Double.valueOf(-1.0d));
                    }
                    dZzc2 = dZza < 0.0d ? ((double) zzaeVar.zzc()) + dZza : dZza;
                }
                Iterator itZzk3 = zzaeVar.zzk();
                while (itZzk3.hasNext()) {
                    int iIntValue = ((Integer) itZzk3.next()).intValue();
                    double d = iIntValue;
                    if (d >= dZzc2 && zzh.zzl(zzaeVar.zze(iIntValue), zzapVarZzb5)) {
                        return new zzah(Double.valueOf(d));
                    }
                }
                return new zzah(Double.valueOf(-1.0d));
            case 5:
                zzh.zzj("join", 1, list);
                if (zzaeVar.zzc() == 0) {
                    return zzap.zzm;
                }
                if (list.isEmpty()) {
                    strZzi = ",";
                } else {
                    zzap zzapVarZzb6 = zzgVar.zzb((zzap) list.get(0));
                    strZzi = ((zzapVarZzb6 instanceof zzan) || (zzapVarZzb6 instanceof zzau)) ? "" : zzapVarZzb6.zzi();
                }
                zzaeVar2 = new zzat(zzaeVar.zzj(strZzi));
                return zzaeVar2;
            case 6:
                zzh.zzj("lastIndexOf", 2, list);
                zzap zzapVarZzb7 = zzap.zzf;
                if (!list.isEmpty()) {
                    zzapVarZzb7 = zzgVar.zzb((zzap) list.get(0));
                }
                int iZzc2 = zzaeVar.zzc() - 1;
                if (list.size() > 1) {
                    zzap zzapVarZzb8 = zzgVar.zzb((zzap) list.get(1));
                    dZzc = Double.isNaN(zzapVarZzb8.zzh().doubleValue()) ? zzaeVar.zzc() - 1 : zzh.zza(zzapVarZzb8.zzh().doubleValue());
                    if (dZzc < 0.0d) {
                        dZzc += (double) zzaeVar.zzc();
                    }
                } else {
                    dZzc = iZzc2;
                }
                if (dZzc < 0.0d) {
                    return new zzah(Double.valueOf(-1.0d));
                }
                for (int iMin = (int) Math.min(zzaeVar.zzc(), dZzc); iMin >= 0; iMin--) {
                    if (zzaeVar.zzs(iMin) && zzh.zzl(zzaeVar.zze(iMin), zzapVarZzb7)) {
                        return new zzah(Double.valueOf(iMin));
                    }
                }
                return new zzah(Double.valueOf(-1.0d));
            case 7:
                zzh.zzh("map", 1, list);
                zzap zzapVarZzb9 = zzgVar.zzb((zzap) list.get(0));
                if (zzapVarZzb9 instanceof zzao) {
                    return zzaeVar.zzc() == 0 ? new zzae() : zzb(zzaeVar, zzgVar, (zzao) zzapVarZzb9, null, null);
                }
                throw new IllegalArgumentException("Callback should be a method");
            case 8:
                zzh.zzh("pop", 0, list);
                int iZzc3 = zzaeVar.zzc();
                if (iZzc3 == 0) {
                    return zzap.zzf;
                }
                int i = iZzc3 - 1;
                zzaeVar2 = zzaeVar.zze(i);
                zzaeVar.zzp(i);
                return zzaeVar2;
            case 9:
                if (!list.isEmpty()) {
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        zzaeVar.zzq(zzaeVar.zzc(), zzgVar.zzb((zzap) it2.next()));
                    }
                }
                return new zzah(Double.valueOf(zzaeVar.zzc()));
            case 10:
                return zzc(zzaeVar, zzgVar, list, true);
            case 11:
                return zzc(zzaeVar, zzgVar, list, false);
            case 12:
                zzaeVar3 = zzaeVar;
                zzh.zzh("reverse", 0, list);
                int iZzc4 = zzaeVar.zzc();
                if (iZzc4 != 0) {
                    for (int i2 = 0; i2 < iZzc4 / 2; i2++) {
                        if (zzaeVar3.zzs(i2)) {
                            zzap zzapVarZze = zzaeVar3.zze(i2);
                            zzaeVar3.zzq(i2, null);
                            int i3 = (iZzc4 - 1) - i2;
                            if (zzaeVar3.zzs(i3)) {
                                zzaeVar3.zzq(i2, zzaeVar3.zze(i3));
                            }
                            zzaeVar3.zzq(i3, zzapVarZze);
                        }
                    }
                }
                return zzaeVar3;
            case 13:
                zzh.zzh("shift", 0, list);
                if (zzaeVar.zzc() == 0) {
                    return zzap.zzf;
                }
                zzap zzapVarZze2 = zzaeVar.zze(0);
                zzaeVar.zzp(0);
                return zzapVarZze2;
            case 14:
                zzh.zzj("slice", 2, list);
                if (list.isEmpty()) {
                    return zzaeVar.zzd();
                }
                double dZzc3 = zzaeVar.zzc();
                double dZza2 = zzh.zza(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue());
                double dMax = dZza2 < 0.0d ? Math.max(dZza2 + dZzc3, 0.0d) : Math.min(dZza2, dZzc3);
                if (list.size() == 2) {
                    double dZza3 = zzh.zza(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue());
                    dZzc3 = dZza3 < 0.0d ? Math.max(dZzc3 + dZza3, 0.0d) : Math.min(dZzc3, dZza3);
                }
                zzae zzaeVar6 = new zzae();
                for (int i4 = (int) dMax; i4 < dZzc3; i4++) {
                    zzaeVar6.zzq(zzaeVar6.zzc(), zzaeVar.zze(i4));
                }
                return zzaeVar6;
            case 15:
                zzh.zzh("some", 1, list);
                zzap zzapVarZzb10 = zzgVar.zzb((zzap) list.get(0));
                if (!(zzapVarZzb10 instanceof zzai)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (zzaeVar.zzc() == 0) {
                    return zzap.zzl;
                }
                zzai zzaiVar2 = (zzai) zzapVarZzb10;
                Iterator itZzk4 = zzaeVar.zzk();
                while (itZzk4.hasNext()) {
                    int iIntValue2 = ((Integer) itZzk4.next()).intValue();
                    if (zzaeVar.zzs(iIntValue2) && zzaiVar2.zza(zzgVar, Arrays.asList(zzaeVar.zze(iIntValue2), new zzah(Double.valueOf(iIntValue2)), zzaeVar)).zzg().booleanValue()) {
                        return zzap.zzk;
                    }
                }
                return zzap.zzl;
            case 16:
                zzaeVar3 = zzaeVar;
                zzh.zzj("sort", 1, list);
                if (zzaeVar.zzc() >= 2) {
                    List listZzm = zzaeVar.zzm();
                    if (list.isEmpty()) {
                        zzaiVar = null;
                    } else {
                        zzap zzapVarZzb11 = zzgVar.zzb((zzap) list.get(0));
                        if (!(zzapVarZzb11 instanceof zzai)) {
                            throw new IllegalArgumentException("Comparator should be a method");
                        }
                        zzaiVar = (zzai) zzapVarZzb11;
                    }
                    Collections.sort(listZzm, new zzba(zzaiVar, zzgVar));
                    zzaeVar.zzn();
                    Iterator it3 = listZzm.iterator();
                    int i5 = 0;
                    while (it3.hasNext()) {
                        zzaeVar3.zzq(i5, (zzap) it3.next());
                        i5++;
                    }
                }
                return zzaeVar3;
            case 17:
                if (list.isEmpty()) {
                    return new zzae();
                }
                int iZza = (int) zzh.zza(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue());
                if (iZza < 0) {
                    iZza = Math.max(0, iZza + zzaeVar.zzc());
                } else if (iZza > zzaeVar.zzc()) {
                    iZza = zzaeVar.zzc();
                }
                int iZzc5 = zzaeVar.zzc();
                zzae zzaeVar7 = new zzae();
                if (list.size() > 1) {
                    int iMax = Math.max(0, (int) zzh.zza(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue()));
                    if (iMax > 0) {
                        for (int i6 = iZza; i6 < Math.min(iZzc5, iZza + iMax); i6++) {
                            zzaeVar7.zzq(zzaeVar7.zzc(), zzaeVar.zze(iZza));
                            zzaeVar.zzp(iZza);
                        }
                    }
                    if (list.size() > 2) {
                        for (int i7 = 2; i7 < list.size(); i7++) {
                            zzap zzapVarZzb12 = zzgVar.zzb((zzap) list.get(i7));
                            if (zzapVarZzb12 instanceof zzag) {
                                throw new IllegalArgumentException("Failed to parse elements to add");
                            }
                            zzaeVar.zzo((iZza + i7) - 2, zzapVarZzb12);
                        }
                    }
                } else {
                    while (iZza < iZzc5) {
                        zzaeVar7.zzq(zzaeVar7.zzc(), zzaeVar.zze(iZza));
                        zzaeVar.zzq(iZza, null);
                        iZza++;
                    }
                }
                return zzaeVar7;
            case 18:
                zzh.zzh(str4, 0, list);
                return new zzat(zzaeVar.zzj(","));
            case 19:
                if (!list.isEmpty()) {
                    zzae zzaeVar8 = new zzae();
                    Iterator it4 = list.iterator();
                    while (it4.hasNext()) {
                        zzap zzapVarZzb13 = zzgVar.zzb((zzap) it4.next());
                        if (zzapVarZzb13 instanceof zzag) {
                            throw new IllegalStateException("Argument evaluation failed");
                        }
                        zzaeVar8.zzq(zzaeVar8.zzc(), zzapVarZzb13);
                    }
                    int iZzc6 = zzaeVar8.zzc();
                    Iterator itZzk5 = zzaeVar.zzk();
                    while (itZzk5.hasNext()) {
                        Integer num2 = (Integer) itZzk5.next();
                        zzaeVar8.zzq(num2.intValue() + iZzc6, zzaeVar.zze(num2.intValue()));
                    }
                    zzaeVar.zzn();
                    Iterator itZzk6 = zzaeVar8.zzk();
                    while (itZzk6.hasNext()) {
                        Integer num3 = (Integer) itZzk6.next();
                        zzaeVar.zzq(num3.intValue(), zzaeVar8.zze(num3.intValue()));
                    }
                }
                return new zzah(Double.valueOf(zzaeVar.zzc()));
            default:
                throw new IllegalArgumentException("Command not supported");
        }
    }

    private static zzae zzb(zzae zzaeVar, zzg zzgVar, zzai zzaiVar, Boolean bool, Boolean bool2) {
        zzae zzaeVar2 = new zzae();
        Iterator itZzk = zzaeVar.zzk();
        while (itZzk.hasNext()) {
            int iIntValue = ((Integer) itZzk.next()).intValue();
            if (zzaeVar.zzs(iIntValue)) {
                zzap zzapVarZza = zzaiVar.zza(zzgVar, Arrays.asList(zzaeVar.zze(iIntValue), new zzah(Double.valueOf(iIntValue)), zzaeVar));
                if (zzapVarZza.zzg().equals(bool)) {
                    break;
                }
                if (bool2 == null || zzapVarZza.zzg().equals(bool2)) {
                    zzaeVar2.zzq(iIntValue, zzapVarZza);
                }
            }
        }
        return zzaeVar2;
    }

    private static zzap zzc(zzae zzaeVar, zzg zzgVar, List list, boolean z) {
        zzap zzapVarZza;
        zzh.zzi("reduce", 1, list);
        zzh.zzj("reduce", 2, list);
        zzap zzapVarZzb = zzgVar.zzb((zzap) list.get(0));
        if (!(zzapVarZzb instanceof zzai)) {
            throw new IllegalArgumentException("Callback should be a method");
        }
        if (list.size() == 2) {
            zzapVarZza = zzgVar.zzb((zzap) list.get(1));
            if (zzapVarZza instanceof zzag) {
                throw new IllegalArgumentException("Failed to parse initial value");
            }
        } else {
            if (zzaeVar.zzc() == 0) {
                throw new IllegalStateException("Empty array with no initial value error");
            }
            zzapVarZza = null;
        }
        zzai zzaiVar = (zzai) zzapVarZzb;
        int iZzc = zzaeVar.zzc();
        int i = z ? 0 : iZzc - 1;
        int i2 = z ? iZzc - 1 : 0;
        int i3 = true == z ? 1 : -1;
        if (zzapVarZza == null) {
            zzapVarZza = zzaeVar.zze(i);
            i += i3;
        }
        while ((i2 - i) * i3 >= 0) {
            if (zzaeVar.zzs(i)) {
                zzapVarZza = zzaiVar.zza(zzgVar, Arrays.asList(zzapVarZza, zzaeVar.zze(i), new zzah(Double.valueOf(i)), zzaeVar));
                if (zzapVarZza instanceof zzag) {
                    throw new IllegalStateException("Reduce operation failed");
                }
                i += i3;
            } else {
                i += i3;
            }
        }
        return zzapVarZza;
    }
}

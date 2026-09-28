package com.google.android.gms.internal.measurement;

import com.google.common.base.Ascii;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzat implements Iterable, zzap {
    private final String zza;

    public zzat(String str) {
        if (str == null) {
            throw new IllegalArgumentException("StringValue cannot be null.");
        }
        this.zza = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzat) {
            return this.zza.equals(((zzat) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new zzas(this);
    }

    public final String toString() {
        return "\"" + this.zza + "\"";
    }

    /* JADX WARN: Code duplicated, block: B:102:0x017f  */
    /* JADX WARN: Code duplicated, block: B:104:0x0189  */
    /* JADX WARN: Code duplicated, block: B:105:0x019e  */
    /* JADX WARN: Code duplicated, block: B:106:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:107:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:108:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:109:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:110:0x0201  */
    /* JADX WARN: Code duplicated, block: B:112:0x0212  */
    /* JADX WARN: Code duplicated, block: B:113:0x022c  */
    /* JADX WARN: Code duplicated, block: B:116:0x0236  */
    /* JADX WARN: Code duplicated, block: B:117:0x024e  */
    /* JADX WARN: Code duplicated, block: B:119:0x027e  */
    /* JADX WARN: Code duplicated, block: B:121:0x0290  */
    /* JADX WARN: Code duplicated, block: B:122:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:124:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:125:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:127:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:128:0x02de  */
    /* JADX WARN: Code duplicated, block: B:131:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:132:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:138:0x0315  */
    /* JADX WARN: Code duplicated, block: B:141:0x031c  */
    /* JADX WARN: Code duplicated, block: B:143:0x0320 A[LOOP:0: B:142:0x031e->B:143:0x0320, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:145:0x0334  */
    /* JADX WARN: Code duplicated, block: B:147:0x0346  */
    /* JADX WARN: Code duplicated, block: B:148:0x035a  */
    /* JADX WARN: Code duplicated, block: B:151:0x0366  */
    /* JADX WARN: Code duplicated, block: B:152:0x0371  */
    /* JADX WARN: Code duplicated, block: B:155:0x0381  */
    /* JADX WARN: Code duplicated, block: B:156:0x0394  */
    /* JADX WARN: Code duplicated, block: B:159:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:160:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:162:0x03cc  */
    /* JADX WARN: Code duplicated, block: B:164:0x03dd  */
    /* JADX WARN: Code duplicated, block: B:167:0x03fb  */
    /* JADX WARN: Code duplicated, block: B:168:0x040b  */
    /* JADX WARN: Code duplicated, block: B:169:0x0418  */
    /* JADX WARN: Code duplicated, block: B:171:0x042a  */
    /* JADX WARN: Code duplicated, block: B:173:0x0440  */
    /* JADX WARN: Code duplicated, block: B:176:0x0454  */
    /* JADX WARN: Code duplicated, block: B:178:0x0458  */
    /* JADX WARN: Code duplicated, block: B:181:0x04a9  */
    /* JADX WARN: Code duplicated, block: B:183:0x04bb  */
    /* JADX WARN: Code duplicated, block: B:184:0x04be  */
    /* JADX WARN: Code duplicated, block: B:187:0x04db  */
    /* JADX WARN: Code duplicated, block: B:188:0x04f5  */
    /* JADX WARN: Code duplicated, block: B:189:0x04f9  */
    /* JADX WARN: Code duplicated, block: B:192:0x050d  */
    /* JADX WARN: Code duplicated, block: B:195:0x0523  */
    /* JADX WARN: Code duplicated, block: B:196:0x0526  */
    /* JADX WARN: Code duplicated, block: B:199:0x053f  */
    /* JADX WARN: Code duplicated, block: B:200:0x0542  */
    /* JADX WARN: Code duplicated, block: B:202:0x0557  */
    /* JADX WARN: Code duplicated, block: B:205:0x056c  */
    /* JADX WARN: Code duplicated, block: B:208:0x0583  */
    /* JADX WARN: Code duplicated, block: B:209:0x0585  */
    /* JADX WARN: Code duplicated, block: B:211:0x05ad  */
    /* JADX WARN: Code duplicated, block: B:213:0x05d2  */
    /* JADX WARN: Code duplicated, block: B:214:0x05d6  */
    /* JADX WARN: Code duplicated, block: B:222:0x05f7  */
    /* JADX WARN: Code duplicated, block: B:224:0x0603  */
    /* JADX WARN: Code duplicated, block: B:227:0x0611 A[LOOP:1: B:225:0x060b->B:227:0x0611, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:230:0x0631  */
    /* JADX WARN: Code duplicated, block: B:232:0x0643  */
    /* JADX WARN: Code duplicated, block: B:233:0x065c  */
    /* JADX WARN: Code duplicated, block: B:245:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:246:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:247:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:248:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:249:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:250:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:251:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:252:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:253:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:254:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:255:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:256:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:257:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b8 A[PHI: r4
  0x00b8: PHI (r4v79 java.lang.String) = 
  (r4v5 java.lang.String)
  (r4v6 java.lang.String)
  (r4v7 java.lang.String)
  (r4v9 java.lang.String)
  (r4v10 java.lang.String)
  (r4v11 java.lang.String)
  (r4v12 java.lang.String)
  (r4v13 java.lang.String)
  (r4v15 java.lang.String)
  (r4v16 java.lang.String)
  (r4v17 java.lang.String)
  (r4v18 java.lang.String)
  (r4v19 java.lang.String)
  (r4v20 java.lang.String)
  (r4v23 java.lang.String)
  (r4v80 java.lang.String)
 binds: [B:89:0x014c, B:86:0x013e, B:257:?, B:256:?, B:255:?, B:254:?, B:253:?, B:252:?, B:251:?, B:250:?, B:249:?, B:248:?, B:247:?, B:246:?, B:245:?, B:43:0x00b6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:45:0x00be  */
    /* JADX WARN: Code duplicated, block: B:47:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:48:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:50:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:51:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:53:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:56:0x00de  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:59:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:62:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:63:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:65:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:66:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:68:0x0103  */
    /* JADX WARN: Code duplicated, block: B:69:0x0106  */
    /* JADX WARN: Code duplicated, block: B:71:0x010c  */
    /* JADX WARN: Code duplicated, block: B:72:0x010e  */
    /* JADX WARN: Code duplicated, block: B:74:0x0114  */
    /* JADX WARN: Code duplicated, block: B:75:0x0117  */
    /* JADX WARN: Code duplicated, block: B:77:0x011d  */
    /* JADX WARN: Code duplicated, block: B:78:0x011f  */
    /* JADX WARN: Code duplicated, block: B:80:0x0125  */
    /* JADX WARN: Code duplicated, block: B:82:0x012a  */
    /* JADX WARN: Code duplicated, block: B:84:0x0130  */
    /* JADX WARN: Code duplicated, block: B:85:0x0138  */
    /* JADX WARN: Code duplicated, block: B:87:0x0140  */
    /* JADX WARN: Code duplicated, block: B:88:0x0146  */
    /* JADX WARN: Code duplicated, block: B:90:0x014e  */
    /* JADX WARN: Code duplicated, block: B:92:0x0155  */
    /* JADX WARN: Code duplicated, block: B:94:0x015f  */
    /* JADX WARN: Code duplicated, block: B:95:0x0164  */
    /* JADX WARN: Code duplicated, block: B:96:0x0167  */
    /* JADX WARN: Code duplicated, block: B:98:0x0173  */
    /* JADX WARN: Code duplicated, block: B:99:0x0175 A[PHI: r3 r4 r6
  0x0175: PHI (r3v63 java.lang.String) = (r3v2 java.lang.String), (r3v3 java.lang.String), (r3v64 java.lang.String) binds: [B:97:0x0171, B:95:0x0164, B:44:0x00b8] A[DONT_GENERATE, DONT_INLINE]
  0x0175: PHI (r4v78 java.lang.String) = (r4v3 java.lang.String), (r4v4 java.lang.String), (r4v79 java.lang.String) binds: [B:97:0x0171, B:95:0x0164, B:44:0x00b8] A[DONT_GENERATE, DONT_INLINE]
  0x0175: PHI (r6v37 java.lang.String) = (r6v1 java.lang.String), (r6v2 java.lang.String), (r6v38 java.lang.String) binds: [B:97:0x0171, B:95:0x0164, B:44:0x00b8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzcz(String str, zzg zzgVar, List list) {
        String str2;
        String str3;
        String str4;
        String str5;
        byte b;
        String strZzi;
        String str6;
        String str7;
        int iZza;
        zzat zzatVar;
        StringBuilder sb;
        int i;
        String str8;
        zzap zzapVarZzb;
        int i2;
        double dDoubleValue;
        double dDoubleValue2;
        double dZza;
        String strZzi2;
        zzap zzapVarZza;
        String str9;
        String str10;
        int iIndexOf;
        zzat zzatVar2;
        String str11;
        double dDoubleValue3;
        double dZza2;
        double dMin;
        double length;
        double dZza3;
        double dMin2;
        String str12;
        ArrayList arrayList;
        String strZzi3;
        long jZzd;
        String[] strArrSplit;
        int length2;
        int i3;
        int i4;
        boolean zIsEmpty;
        String str13;
        zzg zzgVar2;
        int iZza2;
        int length3;
        if (!"charAt".equals(str) && !"concat".equals(str) && !"hasOwnProperty".equals(str) && !"indexOf".equals(str) && !"lastIndexOf".equals(str) && !"match".equals(str) && !"replace".equals(str) && !FirebaseAnalytics.Event.SEARCH.equals(str) && !"slice".equals(str) && !"split".equals(str) && !"substring".equals(str) && !"toLowerCase".equals(str) && !"toLocaleLowerCase".equals(str) && !"toString".equals(str) && !"toUpperCase".equals(str)) {
            str2 = "toLocaleUpperCase";
            if (!str2.equals(str)) {
                if (!"trim".equals(str)) {
                    throw new IllegalArgumentException(String.format("%s is not a String function", str));
                }
            }
            switch (str.hashCode()) {
                case -1789698943:
                    str3 = "charAt";
                    str4 = r4;
                    str5 = "toString";
                    if (str.equals(str4)) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                    break;
                case -1776922004:
                    str3 = "charAt";
                    str5 = "toString";
                    if (str.equals(str5)) {
                        b = Ascii.SO;
                        str4 = r4;
                    } else {
                        str4 = r4;
                        b = -1;
                    }
                    break;
                case -1464939364:
                    str3 = "charAt";
                    if (str.equals("toLocaleLowerCase")) {
                        b = Ascii.FF;
                        str4 = r4;
                        str5 = "toString";
                    }
                    str4 = "hasOwnProperty";
                    str5 = "toString";
                    b = -1;
                    break;
                case -1361633751:
                    str3 = "charAt";
                    if (str.equals(str3)) {
                        str4 = r4;
                        str5 = "toString";
                        b = 0;
                    } else {
                        str4 = "hasOwnProperty";
                        str5 = "toString";
                        b = -1;
                    }
                    break;
                case -1354795244:
                    if (str.equals("concat")) {
                        str3 = "charAt";
                        str4 = r4;
                        str5 = "toString";
                        b = 1;
                    } else {
                        str3 = "charAt";
                        str4 = "hasOwnProperty";
                        str5 = "toString";
                        b = -1;
                    }
                    break;
                case -1137582698:
                    if (str.equals("toLowerCase")) {
                        b = Ascii.CR;
                        str3 = "charAt";
                        str4 = r4;
                        str5 = "toString";
                    } else {
                        str3 = "charAt";
                        str4 = "hasOwnProperty";
                        str5 = "toString";
                        b = -1;
                    }
                    break;
                case -906336856:
                    if (str.equals(FirebaseAnalytics.Event.SEARCH)) {
                        b = 7;
                        str3 = "charAt";
                        str4 = r4;
                        str5 = "toString";
                    } else {
                        str3 = "charAt";
                        str4 = "hasOwnProperty";
                        str5 = "toString";
                        b = -1;
                    }
                    break;
                case -726908483:
                    if (str.equals(str2)) {
                        b = Ascii.VT;
                        str3 = "charAt";
                        str4 = r4;
                        str5 = "toString";
                    } else {
                        str3 = "charAt";
                        str4 = "hasOwnProperty";
                        str5 = "toString";
                        b = -1;
                    }
                    break;
                case -467511597:
                    if (str.equals("lastIndexOf")) {
                        b = 4;
                        str3 = "charAt";
                        str4 = r4;
                        str5 = "toString";
                    } else {
                        str3 = "charAt";
                        str4 = "hasOwnProperty";
                        str5 = "toString";
                        b = -1;
                    }
                    break;
                case -399551817:
                    if (str.equals("toUpperCase")) {
                        b = Ascii.SI;
                        str3 = "charAt";
                        str4 = r4;
                        str5 = "toString";
                    } else {
                        str3 = "charAt";
                        str4 = "hasOwnProperty";
                        str5 = "toString";
                        b = -1;
                    }
                    break;
                case 3568674:
                    if (str.equals("trim")) {
                        b = Ascii.DLE;
                        str3 = "charAt";
                        str4 = r4;
                        str5 = "toString";
                    } else {
                        str3 = "charAt";
                        str4 = "hasOwnProperty";
                        str5 = "toString";
                        b = -1;
                    }
                    break;
                case 103668165:
                    if (str.equals("match")) {
                        b = 5;
                        str3 = "charAt";
                        str4 = r4;
                        str5 = "toString";
                    } else {
                        str3 = "charAt";
                        str4 = "hasOwnProperty";
                        str5 = "toString";
                        b = -1;
                    }
                    break;
                case 109526418:
                    if (str.equals("slice")) {
                        b = 8;
                        str3 = "charAt";
                        str4 = r4;
                        str5 = "toString";
                    } else {
                        str3 = "charAt";
                        str4 = "hasOwnProperty";
                        str5 = "toString";
                        b = -1;
                    }
                    break;
                case 109648666:
                    if (str.equals("split")) {
                        b = 9;
                        str3 = "charAt";
                        str4 = r4;
                        str5 = "toString";
                    } else {
                        str3 = "charAt";
                        str4 = "hasOwnProperty";
                        str5 = "toString";
                        b = -1;
                    }
                    break;
                case 530542161:
                    if (str.equals("substring")) {
                        b = 10;
                        str3 = "charAt";
                        str4 = r4;
                        str5 = "toString";
                    } else {
                        str3 = "charAt";
                        str4 = "hasOwnProperty";
                        str5 = "toString";
                        b = -1;
                    }
                    break;
                case 1094496948:
                    if (str.equals("replace")) {
                        b = 6;
                        str3 = "charAt";
                        str4 = r4;
                        str5 = "toString";
                    } else {
                        str3 = "charAt";
                        str4 = "hasOwnProperty";
                        str5 = "toString";
                        b = -1;
                    }
                    break;
                case 1943291465:
                    if (str.equals("indexOf")) {
                        b = 3;
                        str3 = "charAt";
                        str4 = r4;
                        str5 = "toString";
                    } else {
                        str3 = "charAt";
                        str4 = "hasOwnProperty";
                        str5 = "toString";
                        b = -1;
                    }
                    break;
                default:
                    str3 = "charAt";
                    str4 = "hasOwnProperty";
                    str5 = "toString";
                    b = -1;
                    break;
            }
            strZzi = "undefined";
            str6 = str4;
            str7 = str3;
            switch (b) {
                case 0:
                    zzh.zzj(str7, 1, list);
                    if (list.isEmpty()) {
                        iZza = 0;
                    } else {
                        iZza = (int) zzh.zza(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue());
                    }
                    String str14 = this.zza;
                    return (iZza >= 0 || iZza >= str14.length()) ? zzap.zzm : new zzat(String.valueOf(str14.charAt(iZza)));
                case 1:
                    zzatVar = this;
                    if (!list.isEmpty()) {
                        sb = new StringBuilder(zzatVar.zza);
                        for (i = 0; i < list.size(); i++) {
                            sb.append(zzgVar.zzb((zzap) list.get(i)).zzi());
                        }
                        return new zzat(sb.toString());
                    }
                    return zzatVar;
                case 2:
                    zzh.zzh(str6, 1, list);
                    str8 = this.zza;
                    zzapVarZzb = zzgVar.zzb((zzap) list.get(0));
                    if ("length".equals(zzapVarZzb.zzi())) {
                        return zzaf.zzk;
                    }
                    double dDoubleValue4 = zzapVarZzb.zzh().doubleValue();
                    return (dDoubleValue4 == Math.floor(dDoubleValue4) || (i2 = (int) dDoubleValue4) < 0 || i2 >= str8.length()) ? zzaf.zzl : zzaf.zzk;
                case 3:
                    zzh.zzj("indexOf", 2, list);
                    String str15 = this.zza;
                    String strZzi4 = list.size() > 0 ? zzgVar.zzb((zzap) list.get(0)).zzi() : "undefined";
                    if (list.size() < 2) {
                        dDoubleValue = 0.0d;
                    } else {
                        dDoubleValue = zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue();
                    }
                    return new zzah(Double.valueOf(str15.indexOf(strZzi4, (int) zzh.zza(dDoubleValue))));
                case 4:
                    zzh.zzj("lastIndexOf", 2, list);
                    String str16 = this.zza;
                    String strZzi5 = list.size() > 0 ? zzgVar.zzb((zzap) list.get(0)).zzi() : "undefined";
                    if (list.size() < 2) {
                        dDoubleValue2 = Double.NaN;
                    } else {
                        dDoubleValue2 = zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue();
                    }
                    if (Double.isNaN(dDoubleValue2)) {
                        dZza = Double.POSITIVE_INFINITY;
                    } else {
                        dZza = zzh.zza(dDoubleValue2);
                    }
                    return new zzah(Double.valueOf(str16.lastIndexOf(strZzi5, (int) dZza)));
                case 5:
                    zzh.zzj("match", 1, list);
                    String str17 = this.zza;
                    if (list.size() <= 0) {
                        strZzi2 = "";
                    } else {
                        strZzi2 = zzgVar.zzb((zzap) list.get(0)).zzi();
                    }
                    Matcher matcher = Pattern.compile(strZzi2).matcher(str17);
                    return matcher.find() ? new zzae(Arrays.asList(new zzat(matcher.group()))) : zzap.zzg;
                case 6:
                    zzatVar = this;
                    zzh.zzj("replace", 2, list);
                    zzapVarZza = zzap.zzf;
                    if (!list.isEmpty()) {
                        strZzi = zzgVar.zzb((zzap) list.get(0)).zzi();
                        if (list.size() > 1) {
                            zzapVarZza = zzgVar.zzb((zzap) list.get(1));
                        }
                    }
                    str9 = strZzi;
                    str10 = zzatVar.zza;
                    iIndexOf = str10.indexOf(str9);
                    if (iIndexOf >= 0) {
                        if (zzapVarZza instanceof zzai) {
                            zzapVarZza = ((zzai) zzapVarZza).zza(zzgVar, Arrays.asList(new zzat(str9), new zzah(Double.valueOf(iIndexOf)), zzatVar));
                        }
                        zzatVar2 = new zzat(str10.substring(0, iIndexOf) + zzapVarZza.zzi() + str10.substring(iIndexOf + str9.length()));
                        return zzatVar2;
                    }
                    return zzatVar;
                case 7:
                    zzh.zzj(FirebaseAnalytics.Event.SEARCH, 1, list);
                    Matcher matcher2 = Pattern.compile(list.isEmpty() ? "undefined" : zzgVar.zzb((zzap) list.get(0)).zzi()).matcher(this.zza);
                    return matcher2.find() ? new zzah(Double.valueOf(matcher2.start())) : new zzah(Double.valueOf(-1.0d));
                case 8:
                    zzh.zzj("slice", 2, list);
                    str11 = this.zza;
                    if (list.isEmpty()) {
                        dDoubleValue3 = 0.0d;
                    } else {
                        dDoubleValue3 = zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue();
                    }
                    dZza2 = zzh.zza(dDoubleValue3);
                    if (dZza2 < 0.0d) {
                        dMin = Math.max(((double) str11.length()) + dZza2, 0.0d);
                    } else {
                        dMin = Math.min(dZza2, str11.length());
                    }
                    if (list.size() > 1) {
                        length = zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue();
                    } else {
                        length = str11.length();
                    }
                    dZza3 = zzh.zza(length);
                    if (dZza3 < 0.0d) {
                        dMin2 = Math.max(((double) str11.length()) + dZza3, 0.0d);
                    } else {
                        dMin2 = Math.min(dZza3, str11.length());
                    }
                    int i5 = (int) dMin;
                    return new zzat(str11.substring(i5, Math.max(0, ((int) dMin2) - i5) + i5));
                case 9:
                    zzh.zzj("split", 2, list);
                    str12 = this.zza;
                    if (str12.length() == 0) {
                        return new zzae(Arrays.asList(this));
                    }
                    arrayList = new ArrayList();
                    if (list.isEmpty()) {
                        arrayList.add(this);
                    } else {
                        strZzi3 = zzgVar.zzb((zzap) list.get(0)).zzi();
                        if (list.size() > 1) {
                            jZzd = zzh.zzd(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue());
                        } else {
                            jZzd = 2147483647L;
                        }
                        if (jZzd == 0) {
                            return new zzae();
                        }
                        strArrSplit = str12.split(Pattern.quote(strZzi3), ((int) jZzd) + 1);
                        length2 = strArrSplit.length;
                        if (strZzi3.isEmpty() || length2 <= 0) {
                            i3 = length2;
                            i4 = 0;
                        } else {
                            zIsEmpty = strArrSplit[0].isEmpty();
                            i3 = length2 - 1;
                            if (!strArrSplit[i3].isEmpty()) {
                                i4 = zIsEmpty;
                                i3 = length2;
                                i4 = zIsEmpty;
                            }
                        }
                        i4 = zIsEmpty;
                        if (length2 > jZzd) {
                            i3--;
                        }
                        while (i4 < i3) {
                            arrayList.add(new zzat(strArrSplit[i4]));
                            i4++;
                        }
                    }
                    return new zzae(arrayList);
                case 10:
                    zzh.zzj("substring", 2, list);
                    str13 = this.zza;
                    if (list.isEmpty()) {
                        zzgVar2 = zzgVar;
                        iZza2 = 0;
                    } else {
                        zzgVar2 = zzgVar;
                        iZza2 = (int) zzh.zza(zzgVar2.zzb((zzap) list.get(0)).zzh().doubleValue());
                    }
                    if (list.size() > 1) {
                        length3 = (int) zzh.zza(zzgVar2.zzb((zzap) list.get(1)).zzh().doubleValue());
                    } else {
                        length3 = str13.length();
                    }
                    int iMin = Math.min(Math.max(iZza2, 0), str13.length());
                    int iMin2 = Math.min(Math.max(length3, 0), str13.length());
                    zzatVar2 = new zzat(str13.substring(Math.min(iMin, iMin2), Math.max(iMin, iMin2)));
                    return zzatVar2;
                case 11:
                    zzh.zzh(str2, 0, list);
                    return new zzat(this.zza.toUpperCase());
                case 12:
                    zzh.zzh("toLocaleLowerCase", 0, list);
                    return new zzat(this.zza.toLowerCase());
                case 13:
                    zzh.zzh("toLowerCase", 0, list);
                    return new zzat(this.zza.toLowerCase(Locale.ENGLISH));
                case 14:
                    zzatVar = this;
                    zzh.zzh(str5, 0, list);
                    return zzatVar;
                case 15:
                    zzh.zzh("toUpperCase", 0, list);
                    return new zzat(this.zza.toUpperCase(Locale.ENGLISH));
                case 16:
                    zzh.zzh("toUpperCase", 0, list);
                    return new zzat(this.zza.trim());
                default:
                    throw new IllegalArgumentException("Command not supported");
            }
        }
        str2 = "toLocaleUpperCase";
        switch (str.hashCode()) {
            case -1789698943:
                str3 = "charAt";
                str4 = r4;
                str5 = "toString";
                if (str.equals(str4)) {
                    b = 2;
                } else {
                    b = -1;
                }
                break;
            case -1776922004:
                str3 = "charAt";
                str5 = "toString";
                if (str.equals(str5)) {
                    b = Ascii.SO;
                    str4 = r4;
                } else {
                    str4 = r4;
                    b = -1;
                }
                break;
            case -1464939364:
                str3 = "charAt";
                if (str.equals("toLocaleLowerCase")) {
                    b = Ascii.FF;
                    str4 = r4;
                    str5 = "toString";
                }
                str4 = "hasOwnProperty";
                str5 = "toString";
                b = -1;
                break;
            case -1361633751:
                str3 = "charAt";
                if (str.equals(str3)) {
                    str4 = r4;
                    str5 = "toString";
                    b = 0;
                } else {
                    str4 = "hasOwnProperty";
                    str5 = "toString";
                    b = -1;
                }
                break;
            case -1354795244:
                if (str.equals("concat")) {
                    str3 = "charAt";
                    str4 = r4;
                    str5 = "toString";
                    b = 1;
                } else {
                    str3 = "charAt";
                    str4 = "hasOwnProperty";
                    str5 = "toString";
                    b = -1;
                }
                break;
            case -1137582698:
                if (str.equals("toLowerCase")) {
                    b = Ascii.CR;
                    str3 = "charAt";
                    str4 = r4;
                    str5 = "toString";
                } else {
                    str3 = "charAt";
                    str4 = "hasOwnProperty";
                    str5 = "toString";
                    b = -1;
                }
                break;
            case -906336856:
                if (str.equals(FirebaseAnalytics.Event.SEARCH)) {
                    b = 7;
                    str3 = "charAt";
                    str4 = r4;
                    str5 = "toString";
                } else {
                    str3 = "charAt";
                    str4 = "hasOwnProperty";
                    str5 = "toString";
                    b = -1;
                }
                break;
            case -726908483:
                if (str.equals(str2)) {
                    b = Ascii.VT;
                    str3 = "charAt";
                    str4 = r4;
                    str5 = "toString";
                } else {
                    str3 = "charAt";
                    str4 = "hasOwnProperty";
                    str5 = "toString";
                    b = -1;
                }
                break;
            case -467511597:
                if (str.equals("lastIndexOf")) {
                    b = 4;
                    str3 = "charAt";
                    str4 = r4;
                    str5 = "toString";
                } else {
                    str3 = "charAt";
                    str4 = "hasOwnProperty";
                    str5 = "toString";
                    b = -1;
                }
                break;
            case -399551817:
                if (str.equals("toUpperCase")) {
                    b = Ascii.SI;
                    str3 = "charAt";
                    str4 = r4;
                    str5 = "toString";
                } else {
                    str3 = "charAt";
                    str4 = "hasOwnProperty";
                    str5 = "toString";
                    b = -1;
                }
                break;
            case 3568674:
                if (str.equals("trim")) {
                    b = Ascii.DLE;
                    str3 = "charAt";
                    str4 = r4;
                    str5 = "toString";
                } else {
                    str3 = "charAt";
                    str4 = "hasOwnProperty";
                    str5 = "toString";
                    b = -1;
                }
                break;
            case 103668165:
                if (str.equals("match")) {
                    b = 5;
                    str3 = "charAt";
                    str4 = r4;
                    str5 = "toString";
                } else {
                    str3 = "charAt";
                    str4 = "hasOwnProperty";
                    str5 = "toString";
                    b = -1;
                }
                break;
            case 109526418:
                if (str.equals("slice")) {
                    b = 8;
                    str3 = "charAt";
                    str4 = r4;
                    str5 = "toString";
                } else {
                    str3 = "charAt";
                    str4 = "hasOwnProperty";
                    str5 = "toString";
                    b = -1;
                }
                break;
            case 109648666:
                if (str.equals("split")) {
                    b = 9;
                    str3 = "charAt";
                    str4 = r4;
                    str5 = "toString";
                } else {
                    str3 = "charAt";
                    str4 = "hasOwnProperty";
                    str5 = "toString";
                    b = -1;
                }
                break;
            case 530542161:
                if (str.equals("substring")) {
                    b = 10;
                    str3 = "charAt";
                    str4 = r4;
                    str5 = "toString";
                } else {
                    str3 = "charAt";
                    str4 = "hasOwnProperty";
                    str5 = "toString";
                    b = -1;
                }
                break;
            case 1094496948:
                if (str.equals("replace")) {
                    b = 6;
                    str3 = "charAt";
                    str4 = r4;
                    str5 = "toString";
                } else {
                    str3 = "charAt";
                    str4 = "hasOwnProperty";
                    str5 = "toString";
                    b = -1;
                }
                break;
            case 1943291465:
                if (str.equals("indexOf")) {
                    b = 3;
                    str3 = "charAt";
                    str4 = r4;
                    str5 = "toString";
                } else {
                    str3 = "charAt";
                    str4 = "hasOwnProperty";
                    str5 = "toString";
                    b = -1;
                }
                break;
            default:
                str3 = "charAt";
                str4 = "hasOwnProperty";
                str5 = "toString";
                b = -1;
                break;
        }
        strZzi = "undefined";
        str6 = str4;
        str7 = str3;
        switch (b) {
            case 0:
                zzh.zzj(str7, 1, list);
                if (list.isEmpty()) {
                    iZza = (int) zzh.zza(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue());
                } else {
                    iZza = 0;
                }
                String str18 = this.zza;
                if (iZza >= 0) {
                }
                break;
            case 1:
                zzatVar = this;
                if (!list.isEmpty()) {
                    sb = new StringBuilder(zzatVar.zza);
                    while (i < list.size()) {
                        sb.append(zzgVar.zzb((zzap) list.get(i)).zzi());
                    }
                    return new zzat(sb.toString());
                }
                return zzatVar;
            case 2:
                zzh.zzh(str6, 1, list);
                str8 = this.zza;
                zzapVarZzb = zzgVar.zzb((zzap) list.get(0));
                if ("length".equals(zzapVarZzb.zzi())) {
                    return zzaf.zzk;
                }
                double dDoubleValue5 = zzapVarZzb.zzh().doubleValue();
                if (dDoubleValue5 == Math.floor(dDoubleValue5)) {
                }
                break;
            case 3:
                zzh.zzj("indexOf", 2, list);
                String str19 = this.zza;
                String strZzi6 = list.size() > 0 ? zzgVar.zzb((zzap) list.get(0)).zzi() : "undefined";
                if (list.size() < 2) {
                    dDoubleValue = 0.0d;
                } else {
                    dDoubleValue = zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue();
                }
                return new zzah(Double.valueOf(str19.indexOf(strZzi6, (int) zzh.zza(dDoubleValue))));
            case 4:
                zzh.zzj("lastIndexOf", 2, list);
                String str110 = this.zza;
                String strZzi7 = list.size() > 0 ? zzgVar.zzb((zzap) list.get(0)).zzi() : "undefined";
                if (list.size() < 2) {
                    dDoubleValue2 = Double.NaN;
                } else {
                    dDoubleValue2 = zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue();
                }
                if (Double.isNaN(dDoubleValue2)) {
                    dZza = Double.POSITIVE_INFINITY;
                } else {
                    dZza = zzh.zza(dDoubleValue2);
                }
                return new zzah(Double.valueOf(str110.lastIndexOf(strZzi7, (int) dZza)));
            case 5:
                zzh.zzj("match", 1, list);
                String str111 = this.zza;
                if (list.size() <= 0) {
                    strZzi2 = "";
                } else {
                    strZzi2 = zzgVar.zzb((zzap) list.get(0)).zzi();
                }
                Matcher matcher3 = Pattern.compile(strZzi2).matcher(str111);
                if (matcher3.find()) {
                }
            case 6:
                zzatVar = this;
                zzh.zzj("replace", 2, list);
                zzapVarZza = zzap.zzf;
                if (!list.isEmpty()) {
                    strZzi = zzgVar.zzb((zzap) list.get(0)).zzi();
                    if (list.size() > 1) {
                        zzapVarZza = zzgVar.zzb((zzap) list.get(1));
                    }
                }
                str9 = strZzi;
                str10 = zzatVar.zza;
                iIndexOf = str10.indexOf(str9);
                if (iIndexOf >= 0) {
                    if (zzapVarZza instanceof zzai) {
                        zzapVarZza = ((zzai) zzapVarZza).zza(zzgVar, Arrays.asList(new zzat(str9), new zzah(Double.valueOf(iIndexOf)), zzatVar));
                    }
                    zzatVar2 = new zzat(str10.substring(0, iIndexOf) + zzapVarZza.zzi() + str10.substring(iIndexOf + str9.length()));
                    return zzatVar2;
                }
                return zzatVar;
            case 7:
                zzh.zzj(FirebaseAnalytics.Event.SEARCH, 1, list);
                Matcher matcher4 = Pattern.compile(list.isEmpty() ? "undefined" : zzgVar.zzb((zzap) list.get(0)).zzi()).matcher(this.zza);
                if (matcher4.find()) {
                }
            case 8:
                zzh.zzj("slice", 2, list);
                str11 = this.zza;
                if (list.isEmpty()) {
                    dDoubleValue3 = zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue();
                } else {
                    dDoubleValue3 = 0.0d;
                }
                dZza2 = zzh.zza(dDoubleValue3);
                if (dZza2 < 0.0d) {
                    dMin = Math.max(((double) str11.length()) + dZza2, 0.0d);
                } else {
                    dMin = Math.min(dZza2, str11.length());
                }
                if (list.size() > 1) {
                    length = zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue();
                } else {
                    length = str11.length();
                }
                dZza3 = zzh.zza(length);
                if (dZza3 < 0.0d) {
                    dMin2 = Math.max(((double) str11.length()) + dZza3, 0.0d);
                } else {
                    dMin2 = Math.min(dZza3, str11.length());
                }
                int i6 = (int) dMin;
                return new zzat(str11.substring(i6, Math.max(0, ((int) dMin2) - i6) + i6));
            case 9:
                zzh.zzj("split", 2, list);
                str12 = this.zza;
                if (str12.length() == 0) {
                    return new zzae(Arrays.asList(this));
                }
                arrayList = new ArrayList();
                if (list.isEmpty()) {
                    arrayList.add(this);
                } else {
                    strZzi3 = zzgVar.zzb((zzap) list.get(0)).zzi();
                    if (list.size() > 1) {
                        jZzd = zzh.zzd(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue());
                    } else {
                        jZzd = 2147483647L;
                    }
                    if (jZzd == 0) {
                        return new zzae();
                    }
                    strArrSplit = str12.split(Pattern.quote(strZzi3), ((int) jZzd) + 1);
                    length2 = strArrSplit.length;
                    if (strZzi3.isEmpty()) {
                        i3 = length2;
                        i4 = 0;
                    } else {
                        i3 = length2;
                        i4 = 0;
                    }
                    i4 = zIsEmpty;
                    if (length2 > jZzd) {
                        i3--;
                    }
                    while (i4 < i3) {
                        arrayList.add(new zzat(strArrSplit[i4]));
                        i4++;
                    }
                }
                return new zzae(arrayList);
            case 10:
                zzh.zzj("substring", 2, list);
                str13 = this.zza;
                if (list.isEmpty()) {
                    zzgVar2 = zzgVar;
                    iZza2 = (int) zzh.zza(zzgVar2.zzb((zzap) list.get(0)).zzh().doubleValue());
                } else {
                    zzgVar2 = zzgVar;
                    iZza2 = 0;
                }
                if (list.size() > 1) {
                    length3 = (int) zzh.zza(zzgVar2.zzb((zzap) list.get(1)).zzh().doubleValue());
                } else {
                    length3 = str13.length();
                }
                int iMin3 = Math.min(Math.max(iZza2, 0), str13.length());
                int iMin4 = Math.min(Math.max(length3, 0), str13.length());
                zzatVar2 = new zzat(str13.substring(Math.min(iMin3, iMin4), Math.max(iMin3, iMin4)));
                return zzatVar2;
            case 11:
                zzh.zzh(str2, 0, list);
                return new zzat(this.zza.toUpperCase());
            case 12:
                zzh.zzh("toLocaleLowerCase", 0, list);
                return new zzat(this.zza.toLowerCase());
            case 13:
                zzh.zzh("toLowerCase", 0, list);
                return new zzat(this.zza.toLowerCase(Locale.ENGLISH));
            case 14:
                zzatVar = this;
                zzh.zzh(str5, 0, list);
                return zzatVar;
            case 15:
                zzh.zzh("toUpperCase", 0, list);
                return new zzat(this.zza.toUpperCase(Locale.ENGLISH));
            case 16:
                zzh.zzh("toUpperCase", 0, list);
                return new zzat(this.zza.trim());
            default:
                throw new IllegalArgumentException("Command not supported");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzd() {
        return new zzat(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Boolean zzg() {
        return Boolean.valueOf(!this.zza.isEmpty());
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Double zzh() {
        String str = this.zza;
        if (str.isEmpty()) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final String zzi() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Iterator zzl() {
        return new zzar(this);
    }
}

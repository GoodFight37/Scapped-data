package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzae extends zzpg {
    private String zza;
    private Set zzb;
    private Map zzc;
    private Long zzd;
    private Long zze;

    zzae(zzpv zzpvVar) {
        super(zzpvVar);
    }

    private final zzy zzd(Integer num) {
        if (this.zzc.containsKey(num)) {
            return (zzy) this.zzc.get(num);
        }
        zzy zzyVar = new zzy(this, this.zza, null);
        this.zzc.put(num, zzyVar);
        return zzyVar;
    }

    private final boolean zzf(int i, int i2) {
        zzy zzyVar = (zzy) this.zzc.get(Integer.valueOf(i));
        if (zzyVar == null) {
            return false;
        }
        return zzyVar.zze.get(i2);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x028e A[Catch: all -> 0x02c6, SQLiteException -> 0x02c9, LOOP:11: B:102:0x028e->B:520:?, LOOP_START, TryCatch #22 {all -> 0x02c6, blocks: (B:100:0x0288, B:102:0x028e, B:104:0x029f, B:105:0x02a7, B:109:0x02bf, B:120:0x02d1), top: B:462:0x027e }] */
    /* JADX WARN: Code duplicated, block: B:104:0x029f A[Catch: all -> 0x02c6, SQLiteException -> 0x02c9, TryCatch #22 {all -> 0x02c6, blocks: (B:100:0x0288, B:102:0x028e, B:104:0x029f, B:105:0x02a7, B:109:0x02bf, B:120:0x02d1), top: B:462:0x027e }] */
    /* JADX WARN: Code duplicated, block: B:108:0x02bb A[PHI: r0 r5
  0x02bb: PHI (r0v57 java.util.Map) = (r0v43 java.util.Map), (r0v59 java.util.Map), (r0v37 java.util.Map) binds: [B:121:0x02e8, B:110:0x02c3, B:107:0x02b9] A[DONT_GENERATE, DONT_INLINE]
  0x02bb: PHI (r5v21 android.database.Cursor) = (r5v9 android.database.Cursor), (r5v22 android.database.Cursor), (r5v22 android.database.Cursor) binds: [B:121:0x02e8, B:110:0x02c3, B:107:0x02b9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:109:0x02bf A[Catch: all -> 0x02c6, SQLiteException -> 0x02c9, TRY_ENTER, TRY_LEAVE, TryCatch #22 {all -> 0x02c6, blocks: (B:100:0x0288, B:102:0x028e, B:104:0x029f, B:105:0x02a7, B:109:0x02bf, B:120:0x02d1), top: B:462:0x027e }] */
    /* JADX WARN: Code duplicated, block: B:126:0x0300  */
    /* JADX WARN: Code duplicated, block: B:129:0x030e  */
    /* JADX WARN: Code duplicated, block: B:131:0x032a  */
    /* JADX WARN: Code duplicated, block: B:155:0x03ff  */
    /* JADX WARN: Code duplicated, block: B:157:0x0403  */
    /* JADX WARN: Code duplicated, block: B:161:0x0410  */
    /* JADX WARN: Code duplicated, block: B:163:0x0435  */
    /* JADX WARN: Code duplicated, block: B:169:0x044a  */
    /* JADX WARN: Code duplicated, block: B:173:0x0464  */
    /* JADX WARN: Code duplicated, block: B:174:0x046d  */
    /* JADX WARN: Code duplicated, block: B:178:0x0479  */
    /* JADX WARN: Code duplicated, block: B:184:0x048e  */
    /* JADX WARN: Code duplicated, block: B:191:0x04c2  */
    /* JADX WARN: Code duplicated, block: B:194:0x04cb  */
    /* JADX WARN: Code duplicated, block: B:196:0x04d5  */
    /* JADX WARN: Code duplicated, block: B:198:0x04fb  */
    /* JADX WARN: Code duplicated, block: B:199:0x04ff  */
    /* JADX WARN: Code duplicated, block: B:204:0x051c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:229:0x05b2  */
    /* JADX WARN: Code duplicated, block: B:232:0x05c7  */
    /* JADX WARN: Code duplicated, block: B:238:0x05fc  */
    /* JADX WARN: Code duplicated, block: B:248:0x0644  */
    /* JADX WARN: Code duplicated, block: B:255:0x066c  */
    /* JADX WARN: Code duplicated, block: B:257:0x0677  */
    /* JADX WARN: Code duplicated, block: B:264:0x069b  */
    /* JADX WARN: Code duplicated, block: B:266:0x06a0 A[LOOP:8: B:249:0x0646->B:266:0x06a0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:269:0x06a5  */
    /* JADX WARN: Code duplicated, block: B:272:0x06af  */
    /* JADX WARN: Code duplicated, block: B:295:0x06ed  */
    /* JADX WARN: Code duplicated, block: B:299:0x06f7  */
    /* JADX WARN: Code duplicated, block: B:301:0x06fb  */
    /* JADX WARN: Code duplicated, block: B:305:0x0711  */
    /* JADX WARN: Code duplicated, block: B:311:0x0746  */
    /* JADX WARN: Code duplicated, block: B:313:0x0771 A[LOOP:10: B:309:0x0740->B:313:0x0771, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:319:0x079e  */
    /* JADX WARN: Code duplicated, block: B:322:0x07a6  */
    /* JADX WARN: Code duplicated, block: B:325:0x07b5  */
    /* JADX WARN: Code duplicated, block: B:327:0x07c8  */
    /* JADX WARN: Code duplicated, block: B:335:0x0808 A[Catch: SQLiteException -> 0x0869, all -> 0x0891, LOOP:3: B:335:0x0808->B:490:?, LOOP_START, TRY_LEAVE, TryCatch #13 {SQLiteException -> 0x0869, blocks: (B:333:0x0802, B:335:0x0808, B:336:0x080d), top: B:449:0x0802 }] */
    /* JADX WARN: Code duplicated, block: B:340:0x082e A[Catch: SQLiteException -> 0x0867, all -> 0x0891, TryCatch #11 {SQLiteException -> 0x0867, blocks: (B:338:0x081e, B:340:0x082e, B:341:0x0836, B:344:0x084f, B:343:0x083b, B:350:0x085d), top: B:447:0x081e }] */
    /* JADX WARN: Code duplicated, block: B:347:0x0857  */
    /* JADX WARN: Code duplicated, block: B:349:0x085c  */
    /* JADX WARN: Code duplicated, block: B:352:0x0863 A[PHI: r0 r9
  0x0863: PHI (r0v143 java.util.Map) = (r0v145 java.util.Map), (r0v152 java.util.Map) binds: [B:365:0x088a, B:351:0x0861] A[DONT_GENERATE, DONT_INLINE]
  0x0863: PHI (r9v24 android.database.Cursor) = (r9v25 android.database.Cursor), (r9v29 android.database.Cursor) binds: [B:365:0x088a, B:351:0x0861] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:373:0x0899  */
    /* JADX WARN: Code duplicated, block: B:377:0x08a8  */
    /* JADX WARN: Code duplicated, block: B:380:0x08cd  */
    /* JADX WARN: Code duplicated, block: B:383:0x08de  */
    /* JADX WARN: Code duplicated, block: B:385:0x08f5  */
    /* JADX WARN: Code duplicated, block: B:387:0x0907  */
    /* JADX WARN: Code duplicated, block: B:388:0x0912  */
    /* JADX WARN: Code duplicated, block: B:390:0x093e  */
    /* JADX WARN: Code duplicated, block: B:393:0x0946  */
    /* JADX WARN: Code duplicated, block: B:402:0x0996  */
    /* JADX WARN: Code duplicated, block: B:403:0x099f  */
    /* JADX WARN: Code duplicated, block: B:407:0x09ae A[PHI: r30
  0x09ae: PHI (r30v7 java.util.Map) = (r30v8 java.util.Map), (r0v124 java.util.Map) binds: [B:406:0x09ac, B:404:0x09a0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:412:0x09d6  */
    /* JADX WARN: Code duplicated, block: B:417:0x0a38 A[Catch: SQLiteException -> 0x0a4c, TRY_LEAVE, TryCatch #32 {SQLiteException -> 0x0a4c, blocks: (B:415:0x0a2e, B:417:0x0a38), top: B:472:0x0a2e }] */
    /* JADX WARN: Code duplicated, block: B:426:0x0a6a  */
    /* JADX WARN: Code duplicated, block: B:485:0x08be A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:492:0x09b7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:493:0x0982 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:496:0x09aa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:499:0x0a63 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:502:0x05d5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:503:0x05ee A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:505:0x05c1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:506:0x05c1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:508:0x0699 A[EDGE_INSN: B:508:0x0699->B:263:0x0699 BREAK  A[LOOP:8: B:249:0x0646->B:266:0x06a0], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:510:0x0735 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:511:0x0727 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:512:0x0788 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:514:0x070b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:518:0x077d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:522:0x057a A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:529:0x0456 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:531:0x0444 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:534:0x049a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:537:0x0488 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:549:0x03ea A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:563:0x0212 A[EDGE_INSN: B:563:0x0212->B:77:0x0212 BREAK  A[LOOP:20: B:68:0x01ca->B:80:0x021a], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x017b  */
    /* JADX WARN: Code duplicated, block: B:63:0x01b7 A[Catch: SQLiteException -> 0x0222, all -> 0x0a70, TRY_LEAVE, TryCatch #6 {SQLiteException -> 0x0222, blocks: (B:61:0x01b1, B:63:0x01b7, B:67:0x01c5, B:68:0x01ca, B:69:0x01d4, B:70:0x01e4, B:72:0x01f1), top: B:440:0x01b1 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:67:0x01c5 A[Catch: SQLiteException -> 0x0222, all -> 0x0a70, TRY_ENTER, TryCatch #6 {SQLiteException -> 0x0222, blocks: (B:61:0x01b1, B:63:0x01b7, B:67:0x01c5, B:68:0x01ca, B:69:0x01d4, B:70:0x01e4, B:72:0x01f1), top: B:440:0x01b1 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x0214  */
    /* JADX WARN: Code duplicated, block: B:80:0x021a A[LOOP:20: B:68:0x01ca->B:80:0x021a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:95:0x0251  */
    /* JADX WARN: Code duplicated, block: B:96:0x0257  */
    /* JADX WARN: Code duplicated, block: B:98:0x0262  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v195, types: [android.content.ContentValues] */
    /* JADX WARN: Type inference failed for: r4v30, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v5, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v62 */
    /* JADX WARN: Type inference failed for: r5v64, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v68, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r5v69 */
    /* JADX WARN: Type inference failed for: r5v70, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v71 */
    /* JADX WARN: Type inference failed for: r5v72 */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.database.Cursor] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    final List zza(String str, List list, List list2, Long l, Long l2, boolean z) throws Throwable {
        int i;
        int i2;
        boolean z2;
        ?? r5;
        Map map;
        Cursor cursor;
        Cursor cursorQuery;
        Map map2;
        String str2;
        Map map3;
        Iterator it;
        String str3;
        String str4;
        int iIntValue;
        com.google.android.gms.internal.measurement.zzic zzicVar;
        BitSet bitSet;
        BitSet bitSet2;
        ArrayMap arrayMap;
        List<com.google.android.gms.internal.measurement.zzfj> list3;
        int i3;
        String str5;
        Long lValueOf;
        String str6;
        Map arrayMap2;
        ?? Zzj;
        Cursor cursorRawQuery;
        ArrayMap arrayMap3;
        Iterator it2;
        com.google.android.gms.internal.measurement.zzic zzicVar2;
        List list4;
        Map map4;
        Iterator it3;
        String str7;
        Integer numValueOf;
        List arrayList;
        zzz zzzVar;
        ArrayMap arrayMap4;
        Iterator it4;
        com.google.android.gms.internal.measurement.zzhm zzhmVar;
        com.google.android.gms.internal.measurement.zzhm zzhmVarZza;
        zzpv zzpvVar;
        zzbd zzbdVarZzr;
        long j;
        String strZzh;
        Map mapEmptyMap;
        String str8;
        Iterator it5;
        int iIntValue2;
        Set set;
        Integer numValueOf2;
        boolean zZzd;
        zzaa zzaaVar;
        String str9;
        ArrayMap arrayMap5;
        Cursor cursor2;
        String str10;
        Cursor cursorQuery2;
        Integer numValueOf3;
        List list5;
        List arrayList2;
        String str11;
        ArrayList arrayList3;
        Iterator it6;
        zzaw zzawVarZzj;
        String str12;
        ContentValues contentValues;
        ArrayMap arrayMap6;
        Iterator it7;
        String strZzg;
        Map mapEmptyMap2;
        Iterator it8;
        int iIntValue3;
        Set set2;
        Integer numValueOf4;
        Iterator it9;
        boolean zZzd2;
        com.google.android.gms.internal.measurement.zzfr zzfrVar;
        zzio zzioVar;
        Integer numValueOf5;
        zzac zzacVar;
        Integer numValueOf6;
        String str13;
        ArrayMap arrayMap7;
        Cursor cursor3;
        Cursor cursorQuery3;
        Integer numValueOf7;
        List arrayList4;
        ArrayMap arrayMap8;
        int i4;
        Cursor cursorQuery4;
        List arrayList5;
        String str14 = "current_results";
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(list2);
        this.zza = str;
        this.zzb = new HashSet();
        this.zzc = new ArrayMap();
        this.zzd = l;
        this.zze = l2;
        Iterator it10 = list.iterator();
        while (true) {
            i = 0;
            i2 = 1;
            if (!it10.hasNext()) {
                z2 = false;
                break;
            }
            if ("_s".equals(((com.google.android.gms.internal.measurement.zzhm) it10.next()).zzh())) {
                z2 = true;
                break;
            }
        }
        com.google.android.gms.internal.measurement.zzpq.zzb();
        zzio zzioVar2 = this.zzu;
        boolean zZzx = zzioVar2.zzf().zzx(this.zza, zzgi.zzaE);
        com.google.android.gms.internal.measurement.zzpq.zzb();
        boolean zZzx2 = zzioVar2.zzf().zzx(this.zza, zzgi.zzaD);
        if (z2) {
            zzaw zzawVarZzj2 = this.zzg.zzj();
            String str15 = this.zza;
            zzawVarZzj2.zzav();
            zzawVarZzj2.zzg();
            Preconditions.checkNotEmpty(str15);
            ?? contentValues2 = new ContentValues();
            ?? r6 = 0;
            contentValues2.put("current_session_count", r6);
            try {
                r6 = "events";
                zzawVarZzj2.zzj().update("events", contentValues2, "app_id = ?", new String[]{str15});
                r5 = "events";
            } catch (SQLiteException e) {
                zzawVarZzj2.zzu.zzaW().zze().zzc("Error resetting session-scoped event counts. appId", zzhe.zzn(str15), e);
                r5 = r6;
            }
        }
        Map mapEmptyMap3 = Collections.emptyMap();
        String str16 = "Failed to merge filter. appId";
        String str17 = "Database error querying filters. appId";
        String str18 = "audience_id";
        if (zZzx2 && zZzx) {
            zzaw zzawVarZzj3 = this.zzg.zzj();
            String str19 = this.zza;
            Preconditions.checkNotEmpty(str19);
            ArrayMap arrayMap9 = new ArrayMap();
            try {
                try {
                    cursorQuery4 = zzawVarZzj3.zzj().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str19}, null, null, null);
                    try {
                        if (cursorQuery4.moveToFirst()) {
                            while (true) {
                                try {
                                    com.google.android.gms.internal.measurement.zzfj zzfjVar = (com.google.android.gms.internal.measurement.zzfj) ((com.google.android.gms.internal.measurement.zzfi) zzqa.zzp(com.google.android.gms.internal.measurement.zzfj.zzc(), cursorQuery4.getBlob(i2))).zzba();
                                    if (zzfjVar.zzo()) {
                                        Integer numValueOf8 = Integer.valueOf(cursorQuery4.getInt(i));
                                        List list6 = (List) arrayMap9.get(numValueOf8);
                                        if (list6 == null) {
                                            arrayList5 = new ArrayList();
                                            arrayMap9.put(numValueOf8, arrayList5);
                                        } else {
                                            arrayList5 = list6;
                                        }
                                        arrayList5.add(zzfjVar);
                                    }
                                } catch (IOException e2) {
                                    zzawVarZzj3.zzu.zzaW().zze().zzc("Failed to merge filter. appId", zzhe.zzn(str19), e2);
                                }
                                if (!cursorQuery4.moveToNext()) {
                                    break;
                                }
                                i = 0;
                                i2 = 1;
                            }
                            if (cursorQuery4 != null) {
                                cursorQuery4.close();
                            }
                            map = arrayMap9;
                        } else {
                            mapEmptyMap3 = Collections.emptyMap();
                            if (cursorQuery4 != null) {
                                cursorQuery4.close();
                            }
                            map = mapEmptyMap3;
                        }
                    } catch (SQLiteException e3) {
                        e = e3;
                        zzawVarZzj3.zzu.zzaW().zze().zzc("Database error querying filters. appId", zzhe.zzn(str19), e);
                        mapEmptyMap3 = Collections.emptyMap();
                        if (cursorQuery4 != null) {
                        }
                        map = mapEmptyMap3;
                        zzaw zzawVarZzj4 = this.zzg.zzj();
                        String str20 = this.zza;
                        zzawVarZzj4.zzav();
                        zzawVarZzj4.zzg();
                        Preconditions.checkNotEmpty(str20);
                        cursorQuery = zzawVarZzj4.zzj().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str20}, null, null, null);
                        try {
                            if (cursorQuery.moveToFirst()) {
                                arrayMap8 = new ArrayMap();
                                while (true) {
                                    i4 = cursorQuery.getInt(0);
                                    try {
                                        arrayMap8.put(Integer.valueOf(i4), (com.google.android.gms.internal.measurement.zzic) ((com.google.android.gms.internal.measurement.zzib) zzqa.zzp(com.google.android.gms.internal.measurement.zzic.zze(), cursorQuery.getBlob(1))).zzba());
                                    } catch (IOException e4) {
                                        zzawVarZzj4.zzu.zzaW().zze().zzd("Failed to merge filter results. appId, audienceId, error", zzhe.zzn(str20), Integer.valueOf(i4), e4);
                                    }
                                    try {
                                        if (!cursorQuery.moveToNext()) {
                                            break;
                                        }
                                        arrayMap8 = arrayMap8;
                                        str18 = str18;
                                    } catch (SQLiteException e5) {
                                        e = e5;
                                        zzawVarZzj4.zzu.zzaW().zze().zzc("Database error querying filter results. appId", zzhe.zzn(str20), e);
                                        Map mapEmptyMap4 = Collections.emptyMap();
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        map2 = mapEmptyMap4;
                                    }
                                }
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                map2 = arrayMap8;
                            } else {
                                Map mapEmptyMap5 = Collections.emptyMap();
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                map2 = mapEmptyMap5;
                                str18 = "audience_id";
                            }
                            if (map2.isEmpty()) {
                                str4 = "Database error querying filters. appId";
                                str3 = "Failed to merge filter. appId";
                            } else {
                                HashSet hashSet = new HashSet(map2.keySet());
                                if (z2) {
                                    String str21 = this.zza;
                                    zzaw zzawVarZzj5 = this.zzg.zzj();
                                    str6 = this.zza;
                                    zzawVarZzj5.zzav();
                                    zzawVarZzj5.zzg();
                                    Preconditions.checkNotEmpty(str6);
                                    arrayMap2 = new ArrayMap();
                                    Zzj = zzawVarZzj5.zzj();
                                    try {
                                        try {
                                            cursorRawQuery = Zzj.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str6, str6});
                                            try {
                                                if (cursorRawQuery.moveToFirst()) {
                                                    do {
                                                        numValueOf = Integer.valueOf(cursorRawQuery.getInt(0));
                                                        arrayList = (List) arrayMap2.get(numValueOf);
                                                        if (arrayList == null) {
                                                            arrayList = new ArrayList();
                                                            arrayMap2.put(numValueOf, arrayList);
                                                        }
                                                        arrayList.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                                                    } while (cursorRawQuery.moveToNext());
                                                    if (cursorRawQuery != null) {
                                                        cursorRawQuery.close();
                                                    }
                                                } else {
                                                    arrayMap2 = Collections.emptyMap();
                                                    if (cursorRawQuery != null) {
                                                        cursorRawQuery.close();
                                                    }
                                                }
                                            } catch (SQLiteException e6) {
                                                e = e6;
                                                zzawVarZzj5.zzu.zzaW().zze().zzc("Database error querying scoped filters. appId", zzhe.zzn(str6), e);
                                                arrayMap2 = Collections.emptyMap();
                                                if (cursorRawQuery != null) {
                                                }
                                                Preconditions.checkNotEmpty(str21);
                                                Preconditions.checkNotNull(map2);
                                                arrayMap3 = new ArrayMap();
                                                if (!map2.isEmpty()) {
                                                    it2 = map2.keySet().iterator();
                                                    while (it2.hasNext()) {
                                                        int iIntValue4 = ((Integer) it2.next()).intValue();
                                                        Integer numValueOf9 = Integer.valueOf(iIntValue4);
                                                        zzicVar2 = (com.google.android.gms.internal.measurement.zzic) map2.get(numValueOf9);
                                                        list4 = (List) arrayMap2.get(numValueOf9);
                                                        if (list4 != null) {
                                                        }
                                                        map4 = arrayMap2;
                                                        it3 = it2;
                                                        str7 = str17;
                                                        arrayMap3.put(numValueOf9, zzicVar2);
                                                        arrayMap2 = map4;
                                                        it2 = it3;
                                                        str17 = str7;
                                                    }
                                                }
                                                str2 = str17;
                                                map3 = arrayMap3;
                                                it = hashSet.iterator();
                                                while (it.hasNext()) {
                                                    iIntValue = ((Integer) it.next()).intValue();
                                                    zzicVar = (com.google.android.gms.internal.measurement.zzic) map3.get(Integer.valueOf(iIntValue));
                                                    bitSet = new BitSet();
                                                    bitSet2 = new BitSet();
                                                    arrayMap = new ArrayMap();
                                                    if (zzicVar != null) {
                                                        for (com.google.android.gms.internal.measurement.zzhk zzhkVar : zzicVar.zzh()) {
                                                            if (zzhkVar.zzh()) {
                                                                Integer numValueOf10 = Integer.valueOf(zzhkVar.zza());
                                                                if (zzhkVar.zzg()) {
                                                                    lValueOf = Long.valueOf(zzhkVar.zzb());
                                                                } else {
                                                                    lValueOf = null;
                                                                }
                                                                arrayMap.put(numValueOf10, lValueOf);
                                                            }
                                                        }
                                                    }
                                                    ArrayMap arrayMap10 = new ArrayMap();
                                                    if (zzicVar != null) {
                                                        for (com.google.android.gms.internal.measurement.zzie zzieVar : zzicVar.zzj()) {
                                                            if (!zzieVar.zzi()) {
                                                            }
                                                        }
                                                    }
                                                    Map map5 = map3;
                                                    if (zzicVar != null) {
                                                        i3 = 0;
                                                        while (i3 < zzicVar.zzd() * 64) {
                                                            if (zzqa.zzy(zzicVar.zzk(), i3)) {
                                                                str5 = str16;
                                                                this.zzu.zzaW().zzj().zzc("Filter already evaluated. audience ID, filter ID", Integer.valueOf(iIntValue), Integer.valueOf(i3));
                                                                bitSet2.set(i3);
                                                                if (zzqa.zzy(zzicVar.zzi(), i3)) {
                                                                    bitSet.set(i3);
                                                                }
                                                                i3++;
                                                                str16 = str5;
                                                            } else {
                                                                str5 = str16;
                                                            }
                                                            arrayMap.remove(Integer.valueOf(i3));
                                                            i3++;
                                                            str16 = str5;
                                                        }
                                                    }
                                                    String str22 = str16;
                                                    Integer numValueOf11 = Integer.valueOf(iIntValue);
                                                    com.google.android.gms.internal.measurement.zzic zzicVar3 = (com.google.android.gms.internal.measurement.zzic) map2.get(numValueOf11);
                                                    if (!zZzx2) {
                                                    }
                                                    this.zzc.put(Integer.valueOf(iIntValue), new zzy(this, this.zza, zzicVar3, bitSet, bitSet2, arrayMap, arrayMap10, null));
                                                    str16 = str22;
                                                    map = map;
                                                    map3 = map5;
                                                    map2 = map2;
                                                }
                                                str3 = str16;
                                                str4 = str2;
                                                if (!list.isEmpty()) {
                                                    zzzVar = new zzz(this, null);
                                                    arrayMap4 = new ArrayMap();
                                                    it4 = list.iterator();
                                                    while (it4.hasNext()) {
                                                        zzhmVar = (com.google.android.gms.internal.measurement.zzhm) it4.next();
                                                        zzhmVarZza = zzzVar.zza(this.zza, zzhmVar);
                                                        if (zzhmVarZza != null) {
                                                            zzpvVar = this.zzg;
                                                            zzbdVarZzr = zzpvVar.zzj().zzr(this.zza, zzhmVar, zzhmVarZza.zzh());
                                                            zzpvVar.zzj().zzV(zzbdVarZzr);
                                                            if (z) {
                                                                continue;
                                                            } else {
                                                                j = zzbdVarZzr.zzc;
                                                                strZzh = zzhmVarZza.zzh();
                                                                mapEmptyMap = (Map) arrayMap4.get(strZzh);
                                                                if (mapEmptyMap == null) {
                                                                    zzaw zzawVarZzj6 = zzpvVar.zzj();
                                                                    str9 = this.zza;
                                                                    zzawVarZzj6.zzav();
                                                                    zzawVarZzj6.zzg();
                                                                    Preconditions.checkNotEmpty(str9);
                                                                    Preconditions.checkNotEmpty(strZzh);
                                                                    arrayMap5 = new ArrayMap();
                                                                    SQLiteDatabase sQLiteDatabaseZzj = zzawVarZzj6.zzj();
                                                                    try {
                                                                        try {
                                                                            String[] strArr = new String[2];
                                                                            str10 = str18;
                                                                            try {
                                                                                strArr[0] = str10;
                                                                                strArr[1] = "data";
                                                                                str8 = str14;
                                                                                try {
                                                                                    cursorQuery2 = sQLiteDatabaseZzj.query("event_filters", strArr, "app_id=? AND event_name=?", new String[]{str9, strZzh}, null, null, null);
                                                                                    try {
                                                                                        try {
                                                                                            if (cursorQuery2.moveToFirst()) {
                                                                                                str18 = str10;
                                                                                                while (true) {
                                                                                                    try {
                                                                                                        try {
                                                                                                            com.google.android.gms.internal.measurement.zzfj zzfjVar2 = (com.google.android.gms.internal.measurement.zzfj) ((com.google.android.gms.internal.measurement.zzfi) zzqa.zzp(com.google.android.gms.internal.measurement.zzfj.zzc(), cursorQuery2.getBlob(1))).zzba();
                                                                                                            numValueOf3 = Integer.valueOf(cursorQuery2.getInt(0));
                                                                                                            list5 = (List) arrayMap5.get(numValueOf3);
                                                                                                            if (list5 == null) {
                                                                                                                zzbdVarZzr = zzbdVarZzr;
                                                                                                                try {
                                                                                                                    arrayList2 = new ArrayList();
                                                                                                                    arrayMap5.put(numValueOf3, arrayList2);
                                                                                                                } catch (SQLiteException e7) {
                                                                                                                    e = e7;
                                                                                                                    cursor2 = cursorQuery2;
                                                                                                                    try {
                                                                                                                        zzawVarZzj6.zzu.zzaW().zze().zzc(str4, zzhe.zzn(str9), e);
                                                                                                                        mapEmptyMap = Collections.emptyMap();
                                                                                                                        if (cursor2 != null) {
                                                                                                                            cursor2.close();
                                                                                                                        }
                                                                                                                    } catch (Throwable th) {
                                                                                                                        th = th;
                                                                                                                        if (cursor2 != null) {
                                                                                                                            cursor2.close();
                                                                                                                        }
                                                                                                                        throw th;
                                                                                                                    }
                                                                                                                }
                                                                                                            } else {
                                                                                                                zzbdVarZzr = zzbdVarZzr;
                                                                                                                arrayList2 = list5;
                                                                                                            }
                                                                                                            arrayList2.add(zzfjVar2);
                                                                                                        } catch (IOException e8) {
                                                                                                            zzbdVarZzr = zzbdVarZzr;
                                                                                                            zzawVarZzj6.zzu.zzaW().zze().zzc(str3, zzhe.zzn(str9), e8);
                                                                                                        }
                                                                                                        if (!cursorQuery2.moveToNext()) {
                                                                                                            break;
                                                                                                        }
                                                                                                        zzbdVarZzr = zzbdVarZzr;
                                                                                                    } catch (SQLiteException e9) {
                                                                                                        e = e9;
                                                                                                        zzbdVarZzr = zzbdVarZzr;
                                                                                                        cursor2 = cursorQuery2;
                                                                                                        zzawVarZzj6.zzu.zzaW().zze().zzc(str4, zzhe.zzn(str9), e);
                                                                                                        mapEmptyMap = Collections.emptyMap();
                                                                                                        if (cursor2 != null) {
                                                                                                            cursor2.close();
                                                                                                        }
                                                                                                        arrayMap4.put(strZzh, mapEmptyMap);
                                                                                                        it5 = mapEmptyMap.keySet().iterator();
                                                                                                        while (it5.hasNext()) {
                                                                                                            iIntValue2 = ((Integer) it5.next()).intValue();
                                                                                                            set = this.zzb;
                                                                                                            numValueOf2 = Integer.valueOf(iIntValue2);
                                                                                                            if (set.contains(numValueOf2)) {
                                                                                                                this.zzu.zzaW().zzj().zzb("Skipping failed audience ID", numValueOf2);
                                                                                                            } else {
                                                                                                                zZzd = true;
                                                                                                                for (com.google.android.gms.internal.measurement.zzfj zzfjVar3 : (List) mapEmptyMap.get(numValueOf2)) {
                                                                                                                    zzaaVar = new zzaa(this, this.zza, iIntValue2, zzfjVar3);
                                                                                                                    zZzd = zzaaVar.zzd(this.zzd, this.zze, zzhmVarZza, j, zzbdVarZzr, zzf(iIntValue2, zzfjVar3.zzb()));
                                                                                                                    if (zZzd) {
                                                                                                                        this.zzb.add(Integer.valueOf(iIntValue2));
                                                                                                                        break;
                                                                                                                    }
                                                                                                                    zzd(Integer.valueOf(iIntValue2)).zzc(zzaaVar);
                                                                                                                }
                                                                                                                if (!zZzd) {
                                                                                                                    this.zzb.add(Integer.valueOf(iIntValue2));
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                        zzzVar = zzzVar;
                                                                                                        it4 = it4;
                                                                                                        str14 = str8;
                                                                                                    }
                                                                                                }
                                                                                                if (cursorQuery2 != null) {
                                                                                                    cursorQuery2.close();
                                                                                                }
                                                                                                mapEmptyMap = arrayMap5;
                                                                                            } else {
                                                                                                str18 = str10;
                                                                                                zzbdVarZzr = zzbdVarZzr;
                                                                                                mapEmptyMap = Collections.emptyMap();
                                                                                                if (cursorQuery2 != null) {
                                                                                                    cursorQuery2.close();
                                                                                                }
                                                                                            }
                                                                                        } catch (SQLiteException e10) {
                                                                                            e = e10;
                                                                                            str18 = str10;
                                                                                        }
                                                                                        arrayMap4.put(strZzh, mapEmptyMap);
                                                                                    } catch (Throwable th2) {
                                                                                        th = th2;
                                                                                        cursor2 = cursorQuery2;
                                                                                        if (cursor2 != null) {
                                                                                            cursor2.close();
                                                                                        }
                                                                                        throw th;
                                                                                    }
                                                                                } catch (SQLiteException e11) {
                                                                                    e = e11;
                                                                                    str18 = str10;
                                                                                    cursor2 = null;
                                                                                    zzawVarZzj6.zzu.zzaW().zze().zzc(str4, zzhe.zzn(str9), e);
                                                                                    mapEmptyMap = Collections.emptyMap();
                                                                                    if (cursor2 != null) {
                                                                                        cursor2.close();
                                                                                    }
                                                                                    arrayMap4.put(strZzh, mapEmptyMap);
                                                                                    it5 = mapEmptyMap.keySet().iterator();
                                                                                    while (it5.hasNext()) {
                                                                                        iIntValue2 = ((Integer) it5.next()).intValue();
                                                                                        set = this.zzb;
                                                                                        numValueOf2 = Integer.valueOf(iIntValue2);
                                                                                        if (set.contains(numValueOf2)) {
                                                                                            this.zzu.zzaW().zzj().zzb("Skipping failed audience ID", numValueOf2);
                                                                                        } else {
                                                                                            zZzd = true;
                                                                                            while (r5.hasNext()) {
                                                                                                zzaaVar = new zzaa(this, this.zza, iIntValue2, zzfjVar3);
                                                                                                zZzd = zzaaVar.zzd(this.zzd, this.zze, zzhmVarZza, j, zzbdVarZzr, zzf(iIntValue2, zzfjVar3.zzb()));
                                                                                                if (zZzd) {
                                                                                                    this.zzb.add(Integer.valueOf(iIntValue2));
                                                                                                    break;
                                                                                                }
                                                                                                zzd(Integer.valueOf(iIntValue2)).zzc(zzaaVar);
                                                                                            }
                                                                                            if (!zZzd) {
                                                                                                this.zzb.add(Integer.valueOf(iIntValue2));
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    zzzVar = zzzVar;
                                                                                    it4 = it4;
                                                                                    str14 = str8;
                                                                                }
                                                                            } catch (SQLiteException e12) {
                                                                                e = e12;
                                                                                str18 = str10;
                                                                                str8 = str14;
                                                                                cursor2 = null;
                                                                                zzawVarZzj6.zzu.zzaW().zze().zzc(str4, zzhe.zzn(str9), e);
                                                                                mapEmptyMap = Collections.emptyMap();
                                                                                if (cursor2 != null) {
                                                                                    cursor2.close();
                                                                                }
                                                                                arrayMap4.put(strZzh, mapEmptyMap);
                                                                                it5 = mapEmptyMap.keySet().iterator();
                                                                                while (it5.hasNext()) {
                                                                                    iIntValue2 = ((Integer) it5.next()).intValue();
                                                                                    set = this.zzb;
                                                                                    numValueOf2 = Integer.valueOf(iIntValue2);
                                                                                    if (set.contains(numValueOf2)) {
                                                                                        this.zzu.zzaW().zzj().zzb("Skipping failed audience ID", numValueOf2);
                                                                                    } else {
                                                                                        zZzd = true;
                                                                                        while (r5.hasNext()) {
                                                                                            zzaaVar = new zzaa(this, this.zza, iIntValue2, zzfjVar3);
                                                                                            zZzd = zzaaVar.zzd(this.zzd, this.zze, zzhmVarZza, j, zzbdVarZzr, zzf(iIntValue2, zzfjVar3.zzb()));
                                                                                            if (zZzd) {
                                                                                                this.zzb.add(Integer.valueOf(iIntValue2));
                                                                                                break;
                                                                                            }
                                                                                            zzd(Integer.valueOf(iIntValue2)).zzc(zzaaVar);
                                                                                        }
                                                                                        if (!zZzd) {
                                                                                            this.zzb.add(Integer.valueOf(iIntValue2));
                                                                                        }
                                                                                    }
                                                                                }
                                                                                zzzVar = zzzVar;
                                                                                it4 = it4;
                                                                                str14 = str8;
                                                                            }
                                                                        } catch (SQLiteException e13) {
                                                                            e = e13;
                                                                        }
                                                                    } catch (Throwable th3) {
                                                                        th = th3;
                                                                        cursor2 = null;
                                                                    }
                                                                } else {
                                                                    zzbdVarZzr = zzbdVarZzr;
                                                                    str8 = str14;
                                                                }
                                                                it5 = mapEmptyMap.keySet().iterator();
                                                                while (it5.hasNext()) {
                                                                    iIntValue2 = ((Integer) it5.next()).intValue();
                                                                    set = this.zzb;
                                                                    numValueOf2 = Integer.valueOf(iIntValue2);
                                                                    if (set.contains(numValueOf2)) {
                                                                        this.zzu.zzaW().zzj().zzb("Skipping failed audience ID", numValueOf2);
                                                                    } else {
                                                                        zZzd = true;
                                                                        while (r5.hasNext()) {
                                                                            zzaaVar = new zzaa(this, this.zza, iIntValue2, zzfjVar3);
                                                                            zZzd = zzaaVar.zzd(this.zzd, this.zze, zzhmVarZza, j, zzbdVarZzr, zzf(iIntValue2, zzfjVar3.zzb()));
                                                                            if (zZzd) {
                                                                                this.zzb.add(Integer.valueOf(iIntValue2));
                                                                                break;
                                                                            }
                                                                            zzd(Integer.valueOf(iIntValue2)).zzc(zzaaVar);
                                                                        }
                                                                        if (!zZzd) {
                                                                            this.zzb.add(Integer.valueOf(iIntValue2));
                                                                        }
                                                                    }
                                                                }
                                                                zzzVar = zzzVar;
                                                                it4 = it4;
                                                                str14 = str8;
                                                            }
                                                        }
                                                    }
                                                }
                                                str11 = str14;
                                                if (z) {
                                                    return new ArrayList();
                                                }
                                                if (!list2.isEmpty()) {
                                                    arrayMap6 = new ArrayMap();
                                                    it7 = list2.iterator();
                                                    while (it7.hasNext()) {
                                                        com.google.android.gms.internal.measurement.zzio zzioVar3 = (com.google.android.gms.internal.measurement.zzio) it7.next();
                                                        strZzg = zzioVar3.zzg();
                                                        mapEmptyMap2 = (Map) arrayMap6.get(strZzg);
                                                        if (mapEmptyMap2 == null) {
                                                            zzaw zzawVarZzj7 = this.zzg.zzj();
                                                            str13 = this.zza;
                                                            zzawVarZzj7.zzav();
                                                            zzawVarZzj7.zzg();
                                                            Preconditions.checkNotEmpty(str13);
                                                            Preconditions.checkNotEmpty(strZzg);
                                                            arrayMap7 = new ArrayMap();
                                                            SQLiteDatabase sQLiteDatabaseZzj2 = zzawVarZzj7.zzj();
                                                            try {
                                                                try {
                                                                    String[] strArr2 = new String[2];
                                                                    try {
                                                                        strArr2[0] = str18;
                                                                        strArr2[1] = "data";
                                                                        cursorQuery3 = sQLiteDatabaseZzj2.query("property_filters", strArr2, "app_id=? AND property_name=?", new String[]{str13, strZzg}, null, null, null);
                                                                        try {
                                                                            try {
                                                                                if (cursorQuery3.moveToFirst()) {
                                                                                    do {
                                                                                        try {
                                                                                            com.google.android.gms.internal.measurement.zzfr zzfrVar2 = (com.google.android.gms.internal.measurement.zzfr) ((com.google.android.gms.internal.measurement.zzfq) zzqa.zzp(com.google.android.gms.internal.measurement.zzfr.zzc(), cursorQuery3.getBlob(1))).zzba();
                                                                                            try {
                                                                                                numValueOf7 = Integer.valueOf(cursorQuery3.getInt(0));
                                                                                                arrayList4 = (List) arrayMap7.get(numValueOf7);
                                                                                                if (arrayList4 == null) {
                                                                                                    arrayList4 = new ArrayList();
                                                                                                    arrayMap7.put(numValueOf7, arrayList4);
                                                                                                }
                                                                                                arrayList4.add(zzfrVar2);
                                                                                            } catch (SQLiteException e14) {
                                                                                                e = e14;
                                                                                                zzawVarZzj7.zzu.zzaW().zze().zzc(str4, zzhe.zzn(str13), e);
                                                                                                mapEmptyMap2 = Collections.emptyMap();
                                                                                                if (cursorQuery3 != null) {
                                                                                                    cursorQuery3.close();
                                                                                                }
                                                                                            }
                                                                                        } catch (IOException e15) {
                                                                                            zzawVarZzj7.zzu.zzaW().zze().zzc("Failed to merge filter", zzhe.zzn(str13), e15);
                                                                                        }
                                                                                    } while (cursorQuery3.moveToNext());
                                                                                    if (cursorQuery3 != null) {
                                                                                        cursorQuery3.close();
                                                                                    }
                                                                                    mapEmptyMap2 = arrayMap7;
                                                                                } else {
                                                                                    mapEmptyMap2 = Collections.emptyMap();
                                                                                    if (cursorQuery3 != null) {
                                                                                        cursorQuery3.close();
                                                                                    }
                                                                                }
                                                                            } catch (Throwable th4) {
                                                                                th = th4;
                                                                                cursor3 = cursorQuery3;
                                                                                if (cursor3 != null) {
                                                                                    cursor3.close();
                                                                                }
                                                                                throw th;
                                                                            }
                                                                        } catch (SQLiteException e16) {
                                                                            e = e16;
                                                                        }
                                                                    } catch (SQLiteException e17) {
                                                                        e = e17;
                                                                        cursorQuery3 = null;
                                                                        zzawVarZzj7.zzu.zzaW().zze().zzc(str4, zzhe.zzn(str13), e);
                                                                        mapEmptyMap2 = Collections.emptyMap();
                                                                        if (cursorQuery3 != null) {
                                                                            cursorQuery3.close();
                                                                        }
                                                                        arrayMap6.put(strZzg, mapEmptyMap2);
                                                                        it8 = mapEmptyMap2.keySet().iterator();
                                                                        while (it8.hasNext()) {
                                                                            iIntValue3 = ((Integer) it8.next()).intValue();
                                                                            set2 = this.zzb;
                                                                            numValueOf4 = Integer.valueOf(iIntValue3);
                                                                            if (set2.contains(numValueOf4)) {
                                                                                this.zzu.zzaW().zzj().zzb("Skipping failed audience ID", numValueOf4);
                                                                                break;
                                                                            }
                                                                            it9 = ((List) mapEmptyMap2.get(numValueOf4)).iterator();
                                                                            zZzd2 = true;
                                                                            while (true) {
                                                                                if (it9.hasNext()) {
                                                                                    zzfrVar = (com.google.android.gms.internal.measurement.zzfr) it9.next();
                                                                                    zzioVar = this.zzu;
                                                                                    if (Log.isLoggable(zzioVar.zzaW().zzr(), 2)) {
                                                                                        zzhc zzhcVarZzj = zzioVar.zzaW().zzj();
                                                                                        Integer numValueOf12 = Integer.valueOf(iIntValue3);
                                                                                        if (zzfrVar.zzj()) {
                                                                                            numValueOf6 = Integer.valueOf(zzfrVar.zza());
                                                                                        } else {
                                                                                            numValueOf6 = null;
                                                                                        }
                                                                                        zzhcVarZzj.zzd("Evaluating filter. audience, filter, property", numValueOf12, numValueOf6, zzioVar.zzj().zzf(zzfrVar.zze()));
                                                                                        zzioVar.zzaW().zzj().zzb("Filter definition", this.zzg.zzA().zzs(zzfrVar));
                                                                                    }
                                                                                    if (zzfrVar.zzj()) {
                                                                                    }
                                                                                    zzhc zzhcVarZzk = zzioVar.zzaW().zzk();
                                                                                    Object objZzn = zzhe.zzn(this.zza);
                                                                                    if (zzfrVar.zzj()) {
                                                                                        numValueOf5 = Integer.valueOf(zzfrVar.zza());
                                                                                    } else {
                                                                                        numValueOf5 = null;
                                                                                    }
                                                                                    zzhcVarZzk.zzc("Invalid property filter ID. appId, id", objZzn, String.valueOf(numValueOf5));
                                                                                    this.zzb.add(Integer.valueOf(iIntValue3));
                                                                                    mapEmptyMap2 = mapEmptyMap2;
                                                                                } else {
                                                                                    mapEmptyMap2 = mapEmptyMap2;
                                                                                }
                                                                                if (!zZzd2) {
                                                                                    this.zzb.add(Integer.valueOf(iIntValue3));
                                                                                }
                                                                                mapEmptyMap2 = mapEmptyMap2;
                                                                                zzd(Integer.valueOf(iIntValue3)).zzc(zzacVar);
                                                                                mapEmptyMap2 = mapEmptyMap2;
                                                                            }
                                                                        }
                                                                    }
                                                                } catch (SQLiteException e18) {
                                                                    e = e18;
                                                                }
                                                                arrayMap6.put(strZzg, mapEmptyMap2);
                                                            } catch (Throwable th5) {
                                                                th = th5;
                                                                cursor3 = null;
                                                            }
                                                        }
                                                        it8 = mapEmptyMap2.keySet().iterator();
                                                        while (it8.hasNext()) {
                                                            iIntValue3 = ((Integer) it8.next()).intValue();
                                                            set2 = this.zzb;
                                                            numValueOf4 = Integer.valueOf(iIntValue3);
                                                            if (set2.contains(numValueOf4)) {
                                                                this.zzu.zzaW().zzj().zzb("Skipping failed audience ID", numValueOf4);
                                                                break;
                                                                break;
                                                            }
                                                            it9 = ((List) mapEmptyMap2.get(numValueOf4)).iterator();
                                                            zZzd2 = true;
                                                            while (true) {
                                                                if (it9.hasNext()) {
                                                                    zzfrVar = (com.google.android.gms.internal.measurement.zzfr) it9.next();
                                                                    zzioVar = this.zzu;
                                                                    if (Log.isLoggable(zzioVar.zzaW().zzr(), 2)) {
                                                                        zzhc zzhcVarZzj2 = zzioVar.zzaW().zzj();
                                                                        Integer numValueOf13 = Integer.valueOf(iIntValue3);
                                                                        if (zzfrVar.zzj()) {
                                                                            numValueOf6 = Integer.valueOf(zzfrVar.zza());
                                                                        } else {
                                                                            numValueOf6 = null;
                                                                        }
                                                                        zzhcVarZzj2.zzd("Evaluating filter. audience, filter, property", numValueOf13, numValueOf6, zzioVar.zzj().zzf(zzfrVar.zze()));
                                                                        zzioVar.zzaW().zzj().zzb("Filter definition", this.zzg.zzA().zzs(zzfrVar));
                                                                    }
                                                                    if (zzfrVar.zzj()) {
                                                                    }
                                                                    zzhc zzhcVarZzk2 = zzioVar.zzaW().zzk();
                                                                    Object objZzn2 = zzhe.zzn(this.zza);
                                                                    if (zzfrVar.zzj()) {
                                                                        numValueOf5 = Integer.valueOf(zzfrVar.zza());
                                                                    } else {
                                                                        numValueOf5 = null;
                                                                    }
                                                                    zzhcVarZzk2.zzc("Invalid property filter ID. appId, id", objZzn2, String.valueOf(numValueOf5));
                                                                    this.zzb.add(Integer.valueOf(iIntValue3));
                                                                    mapEmptyMap2 = mapEmptyMap2;
                                                                } else {
                                                                    mapEmptyMap2 = mapEmptyMap2;
                                                                }
                                                                if (!zZzd2) {
                                                                    this.zzb.add(Integer.valueOf(iIntValue3));
                                                                }
                                                                mapEmptyMap2 = mapEmptyMap2;
                                                                zzd(Integer.valueOf(iIntValue3)).zzc(zzacVar);
                                                                mapEmptyMap2 = mapEmptyMap2;
                                                            }
                                                        }
                                                    }
                                                }
                                                arrayList3 = new ArrayList();
                                                Set setKeySet = this.zzc.keySet();
                                                setKeySet.removeAll(this.zzb);
                                                it6 = setKeySet.iterator();
                                                while (it6.hasNext()) {
                                                    int iIntValue5 = ((Integer) it6.next()).intValue();
                                                    Map map6 = this.zzc;
                                                    Integer numValueOf14 = Integer.valueOf(iIntValue5);
                                                    zzy zzyVar = (zzy) map6.get(numValueOf14);
                                                    Preconditions.checkNotNull(zzyVar);
                                                    com.google.android.gms.internal.measurement.zzhi zzhiVarZza = zzyVar.zza(iIntValue5);
                                                    arrayList3.add(zzhiVarZza);
                                                    zzawVarZzj = this.zzg.zzj();
                                                    str12 = this.zza;
                                                    com.google.android.gms.internal.measurement.zzic zzicVarZzd = zzhiVarZza.zzd();
                                                    zzawVarZzj.zzav();
                                                    zzawVarZzj.zzg();
                                                    Preconditions.checkNotEmpty(str12);
                                                    Preconditions.checkNotNull(zzicVarZzd);
                                                    byte[] bArrZzcd = zzicVarZzd.zzcd();
                                                    contentValues = new ContentValues();
                                                    contentValues.put("app_id", str12);
                                                    String str23 = str18;
                                                    contentValues.put(str23, numValueOf14);
                                                    String str24 = str11;
                                                    contentValues.put(str24, bArrZzcd);
                                                    try {
                                                        try {
                                                            if (zzawVarZzj.zzj().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                                                                zzawVarZzj.zzu.zzaW().zze().zzb("Failed to insert filter results (got -1). appId", zzhe.zzn(str12));
                                                            }
                                                        } catch (SQLiteException e19) {
                                                            e = e19;
                                                            zzawVarZzj.zzu.zzaW().zze().zzc("Error storing filter results. appId", zzhe.zzn(str12), e);
                                                        }
                                                    } catch (SQLiteException e20) {
                                                        e = e20;
                                                    }
                                                    str11 = str24;
                                                    str18 = str23;
                                                }
                                                return arrayList3;
                                            }
                                        } catch (SQLiteException e21) {
                                            e = e21;
                                            cursorRawQuery = null;
                                        } catch (Throwable th6) {
                                            th = th6;
                                            Zzj = 0;
                                            if (Zzj != 0) {
                                                Zzj.close();
                                            }
                                            throw th;
                                        }
                                        Preconditions.checkNotEmpty(str21);
                                        Preconditions.checkNotNull(map2);
                                        arrayMap3 = new ArrayMap();
                                        if (!map2.isEmpty()) {
                                            it2 = map2.keySet().iterator();
                                            while (it2.hasNext()) {
                                                int iIntValue6 = ((Integer) it2.next()).intValue();
                                                Integer numValueOf15 = Integer.valueOf(iIntValue6);
                                                zzicVar2 = (com.google.android.gms.internal.measurement.zzic) map2.get(numValueOf15);
                                                list4 = (List) arrayMap2.get(numValueOf15);
                                                if (list4 != null) {
                                                }
                                                map4 = arrayMap2;
                                                it3 = it2;
                                                str7 = str17;
                                                arrayMap3.put(numValueOf15, zzicVar2);
                                                arrayMap2 = map4;
                                                it2 = it3;
                                                str17 = str7;
                                            }
                                        }
                                        str2 = str17;
                                        map3 = arrayMap3;
                                    } catch (Throwable th7) {
                                        th = th7;
                                        if (Zzj != 0) {
                                            Zzj.close();
                                        }
                                        throw th;
                                    }
                                } else {
                                    str2 = "Database error querying filters. appId";
                                    map3 = map2;
                                }
                                it = hashSet.iterator();
                                while (it.hasNext()) {
                                    iIntValue = ((Integer) it.next()).intValue();
                                    zzicVar = (com.google.android.gms.internal.measurement.zzic) map3.get(Integer.valueOf(iIntValue));
                                    bitSet = new BitSet();
                                    bitSet2 = new BitSet();
                                    arrayMap = new ArrayMap();
                                    if (zzicVar != null) {
                                        while (r2.hasNext()) {
                                            if (zzhkVar.zzh()) {
                                                Integer numValueOf16 = Integer.valueOf(zzhkVar.zza());
                                                if (zzhkVar.zzg()) {
                                                    lValueOf = Long.valueOf(zzhkVar.zzb());
                                                } else {
                                                    lValueOf = null;
                                                }
                                                arrayMap.put(numValueOf16, lValueOf);
                                            }
                                        }
                                    }
                                    ArrayMap arrayMap11 = new ArrayMap();
                                    if (zzicVar != null) {
                                        while (r2.hasNext()) {
                                            if (!zzieVar.zzi()) {
                                            }
                                        }
                                    }
                                    Map map7 = map3;
                                    if (zzicVar != null) {
                                        i3 = 0;
                                        while (i3 < zzicVar.zzd() * 64) {
                                            if (zzqa.zzy(zzicVar.zzk(), i3)) {
                                                str5 = str16;
                                                this.zzu.zzaW().zzj().zzc("Filter already evaluated. audience ID, filter ID", Integer.valueOf(iIntValue), Integer.valueOf(i3));
                                                bitSet2.set(i3);
                                                if (zzqa.zzy(zzicVar.zzi(), i3)) {
                                                    bitSet.set(i3);
                                                }
                                                i3++;
                                                str16 = str5;
                                            } else {
                                                str5 = str16;
                                            }
                                            arrayMap.remove(Integer.valueOf(i3));
                                            i3++;
                                            str16 = str5;
                                        }
                                    }
                                    String str25 = str16;
                                    Integer numValueOf17 = Integer.valueOf(iIntValue);
                                    com.google.android.gms.internal.measurement.zzic zzicVar4 = (com.google.android.gms.internal.measurement.zzic) map2.get(numValueOf17);
                                    if (!zZzx2) {
                                    }
                                    this.zzc.put(Integer.valueOf(iIntValue), new zzy(this, this.zza, zzicVar4, bitSet, bitSet2, arrayMap, arrayMap11, null));
                                    str16 = str25;
                                    map = map;
                                    map3 = map7;
                                    map2 = map2;
                                }
                                str3 = str16;
                                str4 = str2;
                            }
                            if (!list.isEmpty()) {
                                zzzVar = new zzz(this, null);
                                arrayMap4 = new ArrayMap();
                                it4 = list.iterator();
                                while (it4.hasNext()) {
                                    zzhmVar = (com.google.android.gms.internal.measurement.zzhm) it4.next();
                                    zzhmVarZza = zzzVar.zza(this.zza, zzhmVar);
                                    if (zzhmVarZza != null) {
                                        zzpvVar = this.zzg;
                                        zzbdVarZzr = zzpvVar.zzj().zzr(this.zza, zzhmVar, zzhmVarZza.zzh());
                                        zzpvVar.zzj().zzV(zzbdVarZzr);
                                        if (z) {
                                            j = zzbdVarZzr.zzc;
                                            strZzh = zzhmVarZza.zzh();
                                            mapEmptyMap = (Map) arrayMap4.get(strZzh);
                                            if (mapEmptyMap == null) {
                                                zzaw zzawVarZzj8 = zzpvVar.zzj();
                                                str9 = this.zza;
                                                zzawVarZzj8.zzav();
                                                zzawVarZzj8.zzg();
                                                Preconditions.checkNotEmpty(str9);
                                                Preconditions.checkNotEmpty(strZzh);
                                                arrayMap5 = new ArrayMap();
                                                SQLiteDatabase sQLiteDatabaseZzj3 = zzawVarZzj8.zzj();
                                                String[] strArr3 = new String[2];
                                                str10 = str18;
                                                strArr3[0] = str10;
                                                strArr3[1] = "data";
                                                str8 = str14;
                                                cursorQuery2 = sQLiteDatabaseZzj3.query("event_filters", strArr3, "app_id=? AND event_name=?", new String[]{str9, strZzh}, null, null, null);
                                                if (cursorQuery2.moveToFirst()) {
                                                    str18 = str10;
                                                    while (true) {
                                                        com.google.android.gms.internal.measurement.zzfj zzfjVar4 = (com.google.android.gms.internal.measurement.zzfj) ((com.google.android.gms.internal.measurement.zzfi) zzqa.zzp(com.google.android.gms.internal.measurement.zzfj.zzc(), cursorQuery2.getBlob(1))).zzba();
                                                        numValueOf3 = Integer.valueOf(cursorQuery2.getInt(0));
                                                        list5 = (List) arrayMap5.get(numValueOf3);
                                                        if (list5 == null) {
                                                            zzbdVarZzr = zzbdVarZzr;
                                                            arrayList2 = new ArrayList();
                                                            arrayMap5.put(numValueOf3, arrayList2);
                                                        } else {
                                                            zzbdVarZzr = zzbdVarZzr;
                                                            arrayList2 = list5;
                                                        }
                                                        arrayList2.add(zzfjVar4);
                                                        if (!cursorQuery2.moveToNext()) {
                                                            break;
                                                            break;
                                                        }
                                                        zzbdVarZzr = zzbdVarZzr;
                                                    }
                                                    if (cursorQuery2 != null) {
                                                        cursorQuery2.close();
                                                    }
                                                    mapEmptyMap = arrayMap5;
                                                } else {
                                                    str18 = str10;
                                                    zzbdVarZzr = zzbdVarZzr;
                                                    mapEmptyMap = Collections.emptyMap();
                                                    if (cursorQuery2 != null) {
                                                        cursorQuery2.close();
                                                    }
                                                }
                                                arrayMap4.put(strZzh, mapEmptyMap);
                                            } else {
                                                zzbdVarZzr = zzbdVarZzr;
                                                str8 = str14;
                                            }
                                            it5 = mapEmptyMap.keySet().iterator();
                                            while (it5.hasNext()) {
                                                iIntValue2 = ((Integer) it5.next()).intValue();
                                                set = this.zzb;
                                                numValueOf2 = Integer.valueOf(iIntValue2);
                                                if (set.contains(numValueOf2)) {
                                                    this.zzu.zzaW().zzj().zzb("Skipping failed audience ID", numValueOf2);
                                                } else {
                                                    zZzd = true;
                                                    while (r5.hasNext()) {
                                                        zzaaVar = new zzaa(this, this.zza, iIntValue2, zzfjVar3);
                                                        zZzd = zzaaVar.zzd(this.zzd, this.zze, zzhmVarZza, j, zzbdVarZzr, zzf(iIntValue2, zzfjVar3.zzb()));
                                                        if (zZzd) {
                                                            this.zzb.add(Integer.valueOf(iIntValue2));
                                                            break;
                                                        }
                                                        zzd(Integer.valueOf(iIntValue2)).zzc(zzaaVar);
                                                    }
                                                    if (!zZzd) {
                                                        this.zzb.add(Integer.valueOf(iIntValue2));
                                                    }
                                                }
                                            }
                                            zzzVar = zzzVar;
                                            it4 = it4;
                                            str14 = str8;
                                        } else {
                                            continue;
                                        }
                                    }
                                }
                            }
                            str11 = str14;
                            if (z) {
                                return new ArrayList();
                            }
                            if (!list2.isEmpty()) {
                                arrayMap6 = new ArrayMap();
                                it7 = list2.iterator();
                                while (it7.hasNext()) {
                                    com.google.android.gms.internal.measurement.zzio zzioVar4 = (com.google.android.gms.internal.measurement.zzio) it7.next();
                                    strZzg = zzioVar4.zzg();
                                    mapEmptyMap2 = (Map) arrayMap6.get(strZzg);
                                    if (mapEmptyMap2 == null) {
                                        zzaw zzawVarZzj9 = this.zzg.zzj();
                                        str13 = this.zza;
                                        zzawVarZzj9.zzav();
                                        zzawVarZzj9.zzg();
                                        Preconditions.checkNotEmpty(str13);
                                        Preconditions.checkNotEmpty(strZzg);
                                        arrayMap7 = new ArrayMap();
                                        SQLiteDatabase sQLiteDatabaseZzj4 = zzawVarZzj9.zzj();
                                        String[] strArr4 = new String[2];
                                        strArr4[0] = str18;
                                        strArr4[1] = "data";
                                        cursorQuery3 = sQLiteDatabaseZzj4.query("property_filters", strArr4, "app_id=? AND property_name=?", new String[]{str13, strZzg}, null, null, null);
                                        if (cursorQuery3.moveToFirst()) {
                                            do {
                                                com.google.android.gms.internal.measurement.zzfr zzfrVar3 = (com.google.android.gms.internal.measurement.zzfr) ((com.google.android.gms.internal.measurement.zzfq) zzqa.zzp(com.google.android.gms.internal.measurement.zzfr.zzc(), cursorQuery3.getBlob(1))).zzba();
                                                numValueOf7 = Integer.valueOf(cursorQuery3.getInt(0));
                                                arrayList4 = (List) arrayMap7.get(numValueOf7);
                                                if (arrayList4 == null) {
                                                    arrayList4 = new ArrayList();
                                                    arrayMap7.put(numValueOf7, arrayList4);
                                                }
                                                arrayList4.add(zzfrVar3);
                                            } while (cursorQuery3.moveToNext());
                                            if (cursorQuery3 != null) {
                                                cursorQuery3.close();
                                            }
                                            mapEmptyMap2 = arrayMap7;
                                        } else {
                                            mapEmptyMap2 = Collections.emptyMap();
                                            if (cursorQuery3 != null) {
                                                cursorQuery3.close();
                                            }
                                        }
                                        arrayMap6.put(strZzg, mapEmptyMap2);
                                    }
                                    it8 = mapEmptyMap2.keySet().iterator();
                                    while (it8.hasNext()) {
                                        iIntValue3 = ((Integer) it8.next()).intValue();
                                        set2 = this.zzb;
                                        numValueOf4 = Integer.valueOf(iIntValue3);
                                        if (set2.contains(numValueOf4)) {
                                            this.zzu.zzaW().zzj().zzb("Skipping failed audience ID", numValueOf4);
                                            break;
                                            break;
                                        }
                                        it9 = ((List) mapEmptyMap2.get(numValueOf4)).iterator();
                                        zZzd2 = true;
                                        while (true) {
                                            if (it9.hasNext()) {
                                                zzfrVar = (com.google.android.gms.internal.measurement.zzfr) it9.next();
                                                zzioVar = this.zzu;
                                                if (Log.isLoggable(zzioVar.zzaW().zzr(), 2)) {
                                                    zzhc zzhcVarZzj3 = zzioVar.zzaW().zzj();
                                                    Integer numValueOf18 = Integer.valueOf(iIntValue3);
                                                    if (zzfrVar.zzj()) {
                                                        numValueOf6 = Integer.valueOf(zzfrVar.zza());
                                                    } else {
                                                        numValueOf6 = null;
                                                    }
                                                    zzhcVarZzj3.zzd("Evaluating filter. audience, filter, property", numValueOf18, numValueOf6, zzioVar.zzj().zzf(zzfrVar.zze()));
                                                    zzioVar.zzaW().zzj().zzb("Filter definition", this.zzg.zzA().zzs(zzfrVar));
                                                }
                                                if (zzfrVar.zzj()) {
                                                }
                                                zzhc zzhcVarZzk3 = zzioVar.zzaW().zzk();
                                                Object objZzn3 = zzhe.zzn(this.zza);
                                                if (zzfrVar.zzj()) {
                                                    numValueOf5 = Integer.valueOf(zzfrVar.zza());
                                                } else {
                                                    numValueOf5 = null;
                                                }
                                                zzhcVarZzk3.zzc("Invalid property filter ID. appId, id", objZzn3, String.valueOf(numValueOf5));
                                                this.zzb.add(Integer.valueOf(iIntValue3));
                                                mapEmptyMap2 = mapEmptyMap2;
                                            } else {
                                                mapEmptyMap2 = mapEmptyMap2;
                                            }
                                            if (!zZzd2) {
                                                this.zzb.add(Integer.valueOf(iIntValue3));
                                            }
                                            mapEmptyMap2 = mapEmptyMap2;
                                            zzd(Integer.valueOf(iIntValue3)).zzc(zzacVar);
                                            mapEmptyMap2 = mapEmptyMap2;
                                        }
                                    }
                                }
                            }
                            arrayList3 = new ArrayList();
                            Set setKeySet2 = this.zzc.keySet();
                            setKeySet2.removeAll(this.zzb);
                            it6 = setKeySet2.iterator();
                            while (it6.hasNext()) {
                                int iIntValue7 = ((Integer) it6.next()).intValue();
                                Map map8 = this.zzc;
                                Integer numValueOf19 = Integer.valueOf(iIntValue7);
                                zzy zzyVar2 = (zzy) map8.get(numValueOf19);
                                Preconditions.checkNotNull(zzyVar2);
                                com.google.android.gms.internal.measurement.zzhi zzhiVarZza2 = zzyVar2.zza(iIntValue7);
                                arrayList3.add(zzhiVarZza2);
                                zzawVarZzj = this.zzg.zzj();
                                str12 = this.zza;
                                com.google.android.gms.internal.measurement.zzic zzicVarZzd2 = zzhiVarZza2.zzd();
                                zzawVarZzj.zzav();
                                zzawVarZzj.zzg();
                                Preconditions.checkNotEmpty(str12);
                                Preconditions.checkNotNull(zzicVarZzd2);
                                byte[] bArrZzcd2 = zzicVarZzd2.zzcd();
                                contentValues = new ContentValues();
                                contentValues.put("app_id", str12);
                                String str26 = str18;
                                contentValues.put(str26, numValueOf19);
                                String str27 = str11;
                                contentValues.put(str27, bArrZzcd2);
                                if (zzawVarZzj.zzj().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                                    zzawVarZzj.zzu.zzaW().zze().zzb("Failed to insert filter results (got -1). appId", zzhe.zzn(str12));
                                }
                                str11 = str27;
                                str18 = str26;
                            }
                            return arrayList3;
                        } catch (Throwable th8) {
                            th = th8;
                            cursor = cursorQuery;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                } catch (SQLiteException e22) {
                    e = e22;
                    cursorQuery4 = null;
                } catch (Throwable th9) {
                    th = th9;
                    r5 = 0;
                    if (r5 != 0) {
                        r5.close();
                    }
                    throw th;
                }
            } catch (Throwable th10) {
                th = th10;
                if (r5 != 0) {
                    r5.close();
                }
                throw th;
            }
        } else {
            map = mapEmptyMap3;
        }
        zzaw zzawVarZzj10 = this.zzg.zzj();
        String str28 = this.zza;
        zzawVarZzj10.zzav();
        zzawVarZzj10.zzg();
        Preconditions.checkNotEmpty(str28);
        try {
            cursorQuery = zzawVarZzj10.zzj().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str28}, null, null, null);
            try {
                if (cursorQuery.moveToFirst()) {
                    Map mapEmptyMap6 = Collections.emptyMap();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    map2 = mapEmptyMap6;
                    str18 = "audience_id";
                } else {
                    arrayMap8 = new ArrayMap();
                    while (true) {
                        i4 = cursorQuery.getInt(0);
                        arrayMap8.put(Integer.valueOf(i4), (com.google.android.gms.internal.measurement.zzic) ((com.google.android.gms.internal.measurement.zzib) zzqa.zzp(com.google.android.gms.internal.measurement.zzic.zze(), cursorQuery.getBlob(1))).zzba());
                        if (!cursorQuery.moveToNext()) {
                            break;
                            break;
                        }
                        arrayMap8 = arrayMap8;
                        str18 = str18;
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    map2 = arrayMap8;
                }
            } catch (SQLiteException e23) {
                e = e23;
                str18 = "audience_id";
            }
        } catch (SQLiteException e24) {
            e = e24;
            str18 = "audience_id";
            cursorQuery = null;
        } catch (Throwable th11) {
            th = th11;
            cursor = null;
        }
        if (map2.isEmpty()) {
            str4 = "Database error querying filters. appId";
            str3 = "Failed to merge filter. appId";
        } else {
            HashSet hashSet2 = new HashSet(map2.keySet());
            if (z2) {
                String str29 = this.zza;
                zzaw zzawVarZzj11 = this.zzg.zzj();
                str6 = this.zza;
                zzawVarZzj11.zzav();
                zzawVarZzj11.zzg();
                Preconditions.checkNotEmpty(str6);
                arrayMap2 = new ArrayMap();
                Zzj = zzawVarZzj11.zzj();
                cursorRawQuery = Zzj.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str6, str6});
                if (cursorRawQuery.moveToFirst()) {
                    do {
                        numValueOf = Integer.valueOf(cursorRawQuery.getInt(0));
                        arrayList = (List) arrayMap2.get(numValueOf);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            arrayMap2.put(numValueOf, arrayList);
                        }
                        arrayList.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                    } while (cursorRawQuery.moveToNext());
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                } else {
                    arrayMap2 = Collections.emptyMap();
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                }
                Preconditions.checkNotEmpty(str29);
                Preconditions.checkNotNull(map2);
                arrayMap3 = new ArrayMap();
                if (!map2.isEmpty()) {
                    it2 = map2.keySet().iterator();
                    while (it2.hasNext()) {
                        int iIntValue8 = ((Integer) it2.next()).intValue();
                        Integer numValueOf110 = Integer.valueOf(iIntValue8);
                        zzicVar2 = (com.google.android.gms.internal.measurement.zzic) map2.get(numValueOf110);
                        list4 = (List) arrayMap2.get(numValueOf110);
                        if (list4 != null || list4.isEmpty()) {
                            map4 = arrayMap2;
                            it3 = it2;
                            str7 = str17;
                            arrayMap3.put(numValueOf110, zzicVar2);
                            arrayMap2 = map4;
                            it2 = it3;
                            str17 = str7;
                        } else {
                            zzpv zzpvVar2 = this.zzg;
                            map4 = arrayMap2;
                            it3 = it2;
                            List listZzt = zzpvVar2.zzA().zzt(zzicVar2.zzi(), list4);
                            if (listZzt.isEmpty()) {
                                arrayMap2 = map4;
                                it2 = it3;
                            } else {
                                com.google.android.gms.internal.measurement.zzib zzibVar = (com.google.android.gms.internal.measurement.zzib) zzicVar2.zzch();
                                zzibVar.zzf();
                                zzibVar.zzb(listZzt);
                                List listZzt2 = zzpvVar2.zzA().zzt(zzicVar2.zzk(), list4);
                                zzibVar.zzh();
                                zzibVar.zzd(listZzt2);
                                ArrayList arrayList6 = new ArrayList();
                                Iterator it11 = zzicVar2.zzh().iterator();
                                while (it11.hasNext()) {
                                    Iterator it12 = it11;
                                    com.google.android.gms.internal.measurement.zzhk zzhkVar2 = (com.google.android.gms.internal.measurement.zzhk) it11.next();
                                    String str30 = str17;
                                    if (!list4.contains(Integer.valueOf(zzhkVar2.zza()))) {
                                        arrayList6.add(zzhkVar2);
                                    }
                                    it11 = it12;
                                    str17 = str30;
                                }
                                str7 = str17;
                                zzibVar.zze();
                                zzibVar.zza(arrayList6);
                                ArrayList arrayList7 = new ArrayList();
                                for (com.google.android.gms.internal.measurement.zzie zzieVar2 : zzicVar2.zzj()) {
                                    if (!list4.contains(Integer.valueOf(zzieVar2.zzb()))) {
                                        arrayList7.add(zzieVar2);
                                    }
                                }
                                zzibVar.zzg();
                                zzibVar.zzc(arrayList7);
                                arrayMap3.put(Integer.valueOf(iIntValue8), (com.google.android.gms.internal.measurement.zzic) zzibVar.zzba());
                                arrayMap2 = map4;
                                it2 = it3;
                                str17 = str7;
                            }
                        }
                    }
                }
                str2 = str17;
                map3 = arrayMap3;
            } else {
                str2 = "Database error querying filters. appId";
                map3 = map2;
            }
            it = hashSet2.iterator();
            while (it.hasNext()) {
                iIntValue = ((Integer) it.next()).intValue();
                zzicVar = (com.google.android.gms.internal.measurement.zzic) map3.get(Integer.valueOf(iIntValue));
                bitSet = new BitSet();
                bitSet2 = new BitSet();
                arrayMap = new ArrayMap();
                if (zzicVar != null && zzicVar.zza() != 0) {
                    while (r2.hasNext()) {
                        if (zzhkVar.zzh()) {
                            Integer numValueOf111 = Integer.valueOf(zzhkVar.zza());
                            if (zzhkVar.zzg()) {
                                lValueOf = Long.valueOf(zzhkVar.zzb());
                            } else {
                                lValueOf = null;
                            }
                            arrayMap.put(numValueOf111, lValueOf);
                        }
                    }
                }
                ArrayMap arrayMap12 = new ArrayMap();
                if (zzicVar != null && zzicVar.zzc() != 0) {
                    while (r2.hasNext()) {
                        if (!zzieVar.zzi() && zzieVar.zza() > 0) {
                            arrayMap12.put(Integer.valueOf(zzieVar.zzb()), Long.valueOf(zzieVar.zzc(zzieVar.zza() - 1)));
                            map3 = map3;
                        }
                    }
                }
                Map map9 = map3;
                if (zzicVar != null) {
                    i3 = 0;
                    while (i3 < zzicVar.zzd() * 64) {
                        if (zzqa.zzy(zzicVar.zzk(), i3)) {
                            str5 = str16;
                            this.zzu.zzaW().zzj().zzc("Filter already evaluated. audience ID, filter ID", Integer.valueOf(iIntValue), Integer.valueOf(i3));
                            bitSet2.set(i3);
                            if (zzqa.zzy(zzicVar.zzi(), i3)) {
                                bitSet.set(i3);
                            }
                            i3++;
                            str16 = str5;
                        } else {
                            str5 = str16;
                        }
                        arrayMap.remove(Integer.valueOf(i3));
                        i3++;
                        str16 = str5;
                    }
                }
                String str210 = str16;
                Integer numValueOf112 = Integer.valueOf(iIntValue);
                com.google.android.gms.internal.measurement.zzic zzicVar5 = (com.google.android.gms.internal.measurement.zzic) map2.get(numValueOf112);
                if (!zZzx2 && zZzx && (list3 = (List) map.get(numValueOf112)) != null && this.zze != null && this.zzd != null) {
                    for (com.google.android.gms.internal.measurement.zzfj zzfjVar5 : list3) {
                        int iZzb = zzfjVar5.zzb();
                        long jLongValue = this.zze.longValue() / 1000;
                        if (zzfjVar5.zzm()) {
                            jLongValue = this.zzd.longValue() / 1000;
                        }
                        Integer numValueOf20 = Integer.valueOf(iZzb);
                        if (arrayMap.containsKey(numValueOf20)) {
                            arrayMap.put(numValueOf20, Long.valueOf(jLongValue));
                        }
                        if (arrayMap12.containsKey(numValueOf20)) {
                            arrayMap12.put(numValueOf20, Long.valueOf(jLongValue));
                        }
                    }
                }
                this.zzc.put(Integer.valueOf(iIntValue), new zzy(this, this.zza, zzicVar5, bitSet, bitSet2, arrayMap, arrayMap12, null));
                str16 = str210;
                map = map;
                map3 = map9;
                map2 = map2;
            }
            str3 = str16;
            str4 = str2;
        }
        if (!list.isEmpty()) {
            zzzVar = new zzz(this, null);
            arrayMap4 = new ArrayMap();
            it4 = list.iterator();
            while (it4.hasNext()) {
                zzhmVar = (com.google.android.gms.internal.measurement.zzhm) it4.next();
                zzhmVarZza = zzzVar.zza(this.zza, zzhmVar);
                if (zzhmVarZza != null) {
                    zzpvVar = this.zzg;
                    zzbdVarZzr = zzpvVar.zzj().zzr(this.zza, zzhmVar, zzhmVarZza.zzh());
                    zzpvVar.zzj().zzV(zzbdVarZzr);
                    if (z) {
                        j = zzbdVarZzr.zzc;
                        strZzh = zzhmVarZza.zzh();
                        mapEmptyMap = (Map) arrayMap4.get(strZzh);
                        if (mapEmptyMap == null) {
                            zzaw zzawVarZzj12 = zzpvVar.zzj();
                            str9 = this.zza;
                            zzawVarZzj12.zzav();
                            zzawVarZzj12.zzg();
                            Preconditions.checkNotEmpty(str9);
                            Preconditions.checkNotEmpty(strZzh);
                            arrayMap5 = new ArrayMap();
                            SQLiteDatabase sQLiteDatabaseZzj5 = zzawVarZzj12.zzj();
                            String[] strArr5 = new String[2];
                            str10 = str18;
                            strArr5[0] = str10;
                            strArr5[1] = "data";
                            str8 = str14;
                            cursorQuery2 = sQLiteDatabaseZzj5.query("event_filters", strArr5, "app_id=? AND event_name=?", new String[]{str9, strZzh}, null, null, null);
                            if (cursorQuery2.moveToFirst()) {
                                str18 = str10;
                                while (true) {
                                    com.google.android.gms.internal.measurement.zzfj zzfjVar6 = (com.google.android.gms.internal.measurement.zzfj) ((com.google.android.gms.internal.measurement.zzfi) zzqa.zzp(com.google.android.gms.internal.measurement.zzfj.zzc(), cursorQuery2.getBlob(1))).zzba();
                                    numValueOf3 = Integer.valueOf(cursorQuery2.getInt(0));
                                    list5 = (List) arrayMap5.get(numValueOf3);
                                    if (list5 == null) {
                                        zzbdVarZzr = zzbdVarZzr;
                                        arrayList2 = new ArrayList();
                                        arrayMap5.put(numValueOf3, arrayList2);
                                    } else {
                                        zzbdVarZzr = zzbdVarZzr;
                                        arrayList2 = list5;
                                    }
                                    arrayList2.add(zzfjVar6);
                                    if (!cursorQuery2.moveToNext()) {
                                        break;
                                        break;
                                    }
                                    zzbdVarZzr = zzbdVarZzr;
                                }
                                if (cursorQuery2 != null) {
                                    cursorQuery2.close();
                                }
                                mapEmptyMap = arrayMap5;
                            } else {
                                str18 = str10;
                                zzbdVarZzr = zzbdVarZzr;
                                mapEmptyMap = Collections.emptyMap();
                                if (cursorQuery2 != null) {
                                    cursorQuery2.close();
                                }
                            }
                            arrayMap4.put(strZzh, mapEmptyMap);
                        } else {
                            zzbdVarZzr = zzbdVarZzr;
                            str8 = str14;
                        }
                        it5 = mapEmptyMap.keySet().iterator();
                        while (it5.hasNext()) {
                            iIntValue2 = ((Integer) it5.next()).intValue();
                            set = this.zzb;
                            numValueOf2 = Integer.valueOf(iIntValue2);
                            if (set.contains(numValueOf2)) {
                                this.zzu.zzaW().zzj().zzb("Skipping failed audience ID", numValueOf2);
                            } else {
                                zZzd = true;
                                while (r5.hasNext()) {
                                    zzaaVar = new zzaa(this, this.zza, iIntValue2, zzfjVar3);
                                    zZzd = zzaaVar.zzd(this.zzd, this.zze, zzhmVarZza, j, zzbdVarZzr, zzf(iIntValue2, zzfjVar3.zzb()));
                                    if (zZzd) {
                                        this.zzb.add(Integer.valueOf(iIntValue2));
                                        break;
                                    }
                                    zzd(Integer.valueOf(iIntValue2)).zzc(zzaaVar);
                                }
                                if (!zZzd) {
                                    this.zzb.add(Integer.valueOf(iIntValue2));
                                }
                            }
                        }
                        zzzVar = zzzVar;
                        it4 = it4;
                        str14 = str8;
                    } else {
                        continue;
                    }
                }
            }
        }
        str11 = str14;
        if (z) {
            return new ArrayList();
        }
        if (!list2.isEmpty()) {
            arrayMap6 = new ArrayMap();
            it7 = list2.iterator();
            while (it7.hasNext()) {
                com.google.android.gms.internal.measurement.zzio zzioVar5 = (com.google.android.gms.internal.measurement.zzio) it7.next();
                strZzg = zzioVar5.zzg();
                mapEmptyMap2 = (Map) arrayMap6.get(strZzg);
                if (mapEmptyMap2 == null) {
                    zzaw zzawVarZzj13 = this.zzg.zzj();
                    str13 = this.zza;
                    zzawVarZzj13.zzav();
                    zzawVarZzj13.zzg();
                    Preconditions.checkNotEmpty(str13);
                    Preconditions.checkNotEmpty(strZzg);
                    arrayMap7 = new ArrayMap();
                    SQLiteDatabase sQLiteDatabaseZzj6 = zzawVarZzj13.zzj();
                    String[] strArr6 = new String[2];
                    strArr6[0] = str18;
                    strArr6[1] = "data";
                    cursorQuery3 = sQLiteDatabaseZzj6.query("property_filters", strArr6, "app_id=? AND property_name=?", new String[]{str13, strZzg}, null, null, null);
                    if (cursorQuery3.moveToFirst()) {
                        do {
                            com.google.android.gms.internal.measurement.zzfr zzfrVar4 = (com.google.android.gms.internal.measurement.zzfr) ((com.google.android.gms.internal.measurement.zzfq) zzqa.zzp(com.google.android.gms.internal.measurement.zzfr.zzc(), cursorQuery3.getBlob(1))).zzba();
                            numValueOf7 = Integer.valueOf(cursorQuery3.getInt(0));
                            arrayList4 = (List) arrayMap7.get(numValueOf7);
                            if (arrayList4 == null) {
                                arrayList4 = new ArrayList();
                                arrayMap7.put(numValueOf7, arrayList4);
                            }
                            arrayList4.add(zzfrVar4);
                        } while (cursorQuery3.moveToNext());
                        if (cursorQuery3 != null) {
                            cursorQuery3.close();
                        }
                        mapEmptyMap2 = arrayMap7;
                    } else {
                        mapEmptyMap2 = Collections.emptyMap();
                        if (cursorQuery3 != null) {
                            cursorQuery3.close();
                        }
                    }
                    arrayMap6.put(strZzg, mapEmptyMap2);
                }
                it8 = mapEmptyMap2.keySet().iterator();
                while (it8.hasNext()) {
                    iIntValue3 = ((Integer) it8.next()).intValue();
                    set2 = this.zzb;
                    numValueOf4 = Integer.valueOf(iIntValue3);
                    if (set2.contains(numValueOf4)) {
                        this.zzu.zzaW().zzj().zzb("Skipping failed audience ID", numValueOf4);
                        break;
                        break;
                    }
                    it9 = ((List) mapEmptyMap2.get(numValueOf4)).iterator();
                    zZzd2 = true;
                    while (true) {
                        if (it9.hasNext()) {
                            zzfrVar = (com.google.android.gms.internal.measurement.zzfr) it9.next();
                            zzioVar = this.zzu;
                            if (Log.isLoggable(zzioVar.zzaW().zzr(), 2)) {
                                zzhc zzhcVarZzj4 = zzioVar.zzaW().zzj();
                                Integer numValueOf113 = Integer.valueOf(iIntValue3);
                                if (zzfrVar.zzj()) {
                                    numValueOf6 = Integer.valueOf(zzfrVar.zza());
                                } else {
                                    numValueOf6 = null;
                                }
                                zzhcVarZzj4.zzd("Evaluating filter. audience, filter, property", numValueOf113, numValueOf6, zzioVar.zzj().zzf(zzfrVar.zze()));
                                zzioVar.zzaW().zzj().zzb("Filter definition", this.zzg.zzA().zzs(zzfrVar));
                            }
                            if (zzfrVar.zzj() || zzfrVar.zza() > 256) {
                                zzhc zzhcVarZzk4 = zzioVar.zzaW().zzk();
                                Object objZzn4 = zzhe.zzn(this.zza);
                                if (zzfrVar.zzj()) {
                                    numValueOf5 = Integer.valueOf(zzfrVar.zza());
                                } else {
                                    numValueOf5 = null;
                                }
                                zzhcVarZzk4.zzc("Invalid property filter ID. appId, id", objZzn4, String.valueOf(numValueOf5));
                                this.zzb.add(Integer.valueOf(iIntValue3));
                                mapEmptyMap2 = mapEmptyMap2;
                            } else {
                                zzacVar = new zzac(this, this.zza, iIntValue3, zzfrVar);
                                zZzd2 = zzacVar.zzd(this.zzd, this.zze, zzioVar5, zzf(iIntValue3, zzfrVar.zza()));
                                if (zZzd2) {
                                    zzd(Integer.valueOf(iIntValue3)).zzc(zzacVar);
                                    mapEmptyMap2 = mapEmptyMap2;
                                } else {
                                    this.zzb.add(Integer.valueOf(iIntValue3));
                                }
                            }
                        } else {
                            mapEmptyMap2 = mapEmptyMap2;
                        }
                        if (!zZzd2) {
                            this.zzb.add(Integer.valueOf(iIntValue3));
                        }
                        mapEmptyMap2 = mapEmptyMap2;
                    }
                }
            }
        }
        arrayList3 = new ArrayList();
        Set setKeySet3 = this.zzc.keySet();
        setKeySet3.removeAll(this.zzb);
        it6 = setKeySet3.iterator();
        while (it6.hasNext()) {
            int iIntValue9 = ((Integer) it6.next()).intValue();
            Map map10 = this.zzc;
            Integer numValueOf114 = Integer.valueOf(iIntValue9);
            zzy zzyVar3 = (zzy) map10.get(numValueOf114);
            Preconditions.checkNotNull(zzyVar3);
            com.google.android.gms.internal.measurement.zzhi zzhiVarZza3 = zzyVar3.zza(iIntValue9);
            arrayList3.add(zzhiVarZza3);
            zzawVarZzj = this.zzg.zzj();
            str12 = this.zza;
            com.google.android.gms.internal.measurement.zzic zzicVarZzd3 = zzhiVarZza3.zzd();
            zzawVarZzj.zzav();
            zzawVarZzj.zzg();
            Preconditions.checkNotEmpty(str12);
            Preconditions.checkNotNull(zzicVarZzd3);
            byte[] bArrZzcd3 = zzicVarZzd3.zzcd();
            contentValues = new ContentValues();
            contentValues.put("app_id", str12);
            String str211 = str18;
            contentValues.put(str211, numValueOf114);
            String str212 = str11;
            contentValues.put(str212, bArrZzcd3);
            if (zzawVarZzj.zzj().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                zzawVarZzj.zzu.zzaW().zze().zzb("Failed to insert filter results (got -1). appId", zzhe.zzn(str12));
            }
            str11 = str212;
            str18 = str211;
        }
        return arrayList3;
    }

    @Override // com.google.android.gms.measurement.internal.zzpg
    protected final boolean zzb() {
        return false;
    }
}

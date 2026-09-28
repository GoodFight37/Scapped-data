package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzz {
    final /* synthetic */ zzae zza;
    private com.google.android.gms.internal.measurement.zzhm zzb;
    private Long zzc;
    private long zzd;

    /* synthetic */ zzz(zzae zzaeVar, zzad zzadVar) {
        this.zza = zzaeVar;
    }

    /* JADX WARN: Code duplicated, block: B:71:0x01dd  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v7 */
    final com.google.android.gms.internal.measurement.zzhm zza(String str, com.google.android.gms.internal.measurement.zzhm zzhmVar) {
        ?? r7;
        Cursor cursorRawQuery;
        Pair pairCreate;
        String strZzh = zzhmVar.zzh();
        List listZzi = zzhmVar.zzi();
        zzae zzaeVar = this.zza;
        zzpv zzpvVar = zzaeVar.zzg;
        zzpvVar.zzA();
        Long l = (Long) zzqa.zzH(zzhmVar, "_eid");
        if (l != null) {
            if (strZzh.equals("_ep")) {
                Preconditions.checkNotNull(l);
                zzpvVar.zzA();
                String str2 = (String) zzqa.zzH(zzhmVar, "_en");
                if (TextUtils.isEmpty(str2)) {
                    zzaeVar.zzu.zzaW().zzh().zzb("Extra parameter without an event name. eventId", l);
                    return null;
                }
                if (this.zzb == null || this.zzc == null || l.longValue() != this.zzc.longValue()) {
                    zzaw zzawVarZzj = zzpvVar.zzj();
                    zzawVarZzj.zzg();
                    zzawVarZzj.zzav();
                    try {
                        try {
                            cursorRawQuery = zzawVarZzj.zzj().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, l.toString()});
                            try {
                                if (cursorRawQuery.moveToFirst()) {
                                    try {
                                        pairCreate = Pair.create((com.google.android.gms.internal.measurement.zzhm) ((com.google.android.gms.internal.measurement.zzhl) zzqa.zzp(com.google.android.gms.internal.measurement.zzhm.zze(), cursorRawQuery.getBlob(0))).zzba(), Long.valueOf(cursorRawQuery.getLong(1)));
                                        if (cursorRawQuery != null) {
                                            cursorRawQuery.close();
                                        }
                                    } catch (IOException e) {
                                        zzawVarZzj.zzu.zzaW().zze().zzd("Failed to merge main event. appId, eventId", zzhe.zzn(str), l, e);
                                        if (cursorRawQuery != null) {
                                            cursorRawQuery.close();
                                        }
                                        pairCreate = null;
                                    }
                                } else {
                                    zzawVarZzj.zzu.zzaW().zzj().zza("Main event not found");
                                    if (cursorRawQuery != null) {
                                        cursorRawQuery.close();
                                    }
                                    pairCreate = null;
                                }
                            } catch (SQLiteException e2) {
                                e = e2;
                                zzawVarZzj.zzu.zzaW().zze().zzb("Error selecting main event", e);
                                if (cursorRawQuery != null) {
                                }
                                pairCreate = null;
                                if (pairCreate != null) {
                                }
                                this.zza.zzu.zzaW().zzh().zzc("Extra parameter without existing main event. eventName, eventId", str2, l);
                                return null;
                            }
                        } catch (SQLiteException e3) {
                            e = e3;
                            cursorRawQuery = null;
                        } catch (Throwable th) {
                            th = th;
                            r7 = 0;
                            if (r7 != 0) {
                                r7.close();
                            }
                            throw th;
                        }
                        if (pairCreate != null || pairCreate.first == null) {
                            this.zza.zzu.zzaW().zzh().zzc("Extra parameter without existing main event. eventName, eventId", str2, l);
                            return null;
                        }
                        this.zzb = (com.google.android.gms.internal.measurement.zzhm) pairCreate.first;
                        this.zzd = ((Long) pairCreate.second).longValue();
                        this.zza.zzg.zzA();
                        this.zzc = (Long) zzqa.zzH(this.zzb, "_eid");
                    } catch (Throwable th2) {
                        th = th2;
                        r7 = zzpvVar;
                        if (r7 != 0) {
                            r7.close();
                        }
                        throw th;
                    }
                }
                long j = this.zzd - 1;
                this.zzd = j;
                if (j <= 0) {
                    zzaw zzawVarZzj2 = this.zza.zzg.zzj();
                    zzawVarZzj2.zzg();
                    zzawVarZzj2.zzu.zzaW().zzj().zzb("Clearing complex main event info. appId", str);
                    try {
                        zzawVarZzj2.zzj().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                    } catch (SQLiteException e4) {
                        zzawVarZzj2.zzu.zzaW().zze().zzb("Error clearing complex main event", e4);
                    }
                } else {
                    this.zza.zzg.zzj().zzaf(str, l, this.zzd, this.zzb);
                }
                ArrayList arrayList = new ArrayList();
                for (com.google.android.gms.internal.measurement.zzhq zzhqVar : this.zzb.zzi()) {
                    this.zza.zzg.zzA();
                    if (zzqa.zzG(zzhmVar, zzhqVar.zzg()) == null) {
                        arrayList.add(zzhqVar);
                    }
                }
                if (arrayList.isEmpty()) {
                    this.zza.zzu.zzaW().zzh().zzb("No unique parameters in main event. eventName", str2);
                } else {
                    arrayList.addAll(listZzi);
                    listZzi = arrayList;
                }
                strZzh = str2;
            } else {
                this.zzc = l;
                this.zzb = zzhmVar;
                zzpvVar.zzA();
                long jLongValue = ((Long) zzqa.zzI(zzhmVar, "_epc", 0L)).longValue();
                this.zzd = jLongValue;
                if (jLongValue <= 0) {
                    zzaeVar.zzu.zzaW().zzh().zzb("Complex event with zero extra param count. eventName", strZzh);
                } else {
                    zzpvVar.zzj().zzaf(str, (Long) Preconditions.checkNotNull(l), this.zzd, zzhmVar);
                }
            }
        }
        com.google.android.gms.internal.measurement.zzhl zzhlVar = (com.google.android.gms.internal.measurement.zzhl) zzhmVar.zzch();
        zzhlVar.zzi(strZzh);
        zzhlVar.zzg();
        zzhlVar.zzd(listZzi);
        return (com.google.android.gms.internal.measurement.zzhm) zzhlVar.zzba();
    }
}

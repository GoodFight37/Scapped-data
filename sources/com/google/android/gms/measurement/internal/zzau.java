package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzau {
    final /* synthetic */ zzaw zza;
    private final String zzb;
    private long zzc;

    public zzau(zzaw zzawVar, String str) {
        this.zza = zzawVar;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = -1L;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00fc  */
    /* JADX WARN: Multi-variable type inference failed */
    public final List zza() throws Throwable {
        Cursor cursor;
        Cursor cursorQuery;
        List arrayList = new ArrayList();
        try {
            int i = 0;
            cursorQuery = this.zza.zzj().query("raw_events", new String[]{"rowid", AppMeasurementSdk.ConditionalUserProperty.NAME, "timestamp", "metadata_fingerprint", "data", "realtime"}, "app_id = ? and rowid > ?", new String[]{this.zzb, String.valueOf(this.zzc)}, null, null, "rowid", "1000");
            try {
                if (cursorQuery.moveToFirst()) {
                    while (true) {
                        long j = cursorQuery.getLong(i);
                        long j2 = cursorQuery.getLong(3);
                        boolean z = cursorQuery.getLong(5) == 1 ? 1 : i;
                        byte[] blob = cursorQuery.getBlob(4);
                        if (j > this.zzc) {
                            this.zzc = j;
                        }
                        try {
                            com.google.android.gms.internal.measurement.zzhl zzhlVar = (com.google.android.gms.internal.measurement.zzhl) zzqa.zzp(com.google.android.gms.internal.measurement.zzhm.zze(), blob);
                            String string = cursorQuery.getString(1);
                            if (string == null) {
                                string = "";
                            }
                            zzhlVar.zzi(string);
                            zzhlVar.zzm(cursorQuery.getLong(2));
                            arrayList.add(new zzat(j, j2, z, (com.google.android.gms.internal.measurement.zzhm) zzhlVar.zzba()));
                        } catch (IOException e) {
                            this.zza.zzu.zzaW().zze().zzc("Data loss. Failed to merge raw event. appId", zzhe.zzn(this.zzb), e);
                        }
                        if (!cursorQuery.moveToNext()) {
                            break;
                        }
                        i = 0;
                    }
                } else {
                    arrayList = Collections.emptyList();
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursor = cursorQuery;
                try {
                    this.zza.zzu.zzaW().zze().zzc("Data loss. Error querying raw events batch. appId", zzhe.zzn(this.zzb), e);
                    cursorQuery = cursor;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return arrayList;
    }

    public zzau(zzaw zzawVar, String str, long j) {
        this.zza = zzawVar;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = zzawVar.zzaz("select rowid from raw_events where app_id = ? and timestamp < ? order by rowid desc limit 1", new String[]{str, String.valueOf(j)}, -1L);
    }
}

package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzax {
    /* JADX WARN: Code duplicated, block: B:50:0x00e5  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r14v2 */
    static void zza(zzhe zzheVar, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) throws Throwable {
        Cursor cursorQuery;
        if (zzheVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        ?? r14 = 0;
        try {
            try {
                cursorQuery = sQLiteDatabase.query("SQLITE_MASTER", new String[]{AppMeasurementSdk.ConditionalUserProperty.NAME}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean zMoveToFirst = cursorQuery.moveToFirst();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (!zMoveToFirst) {
                        sQLiteDatabase.execSQL(str2);
                    }
                } catch (SQLiteException e) {
                    e = e;
                    zzheVar.zzk().zzc("Error querying for table", str, e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursorQuery = null;
            } catch (Throwable th) {
                th = th;
                if (r14 != 0) {
                    r14.close();
                }
                throw th;
            }
            try {
                HashSet hashSet = new HashSet();
                Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM " + str + " LIMIT 0", null);
                try {
                    Collections.addAll(hashSet, cursorRawQuery.getColumnNames());
                    cursorRawQuery.close();
                    for (String str4 : str3.split(",")) {
                        if (!hashSet.remove(str4)) {
                            throw new SQLiteException("Table " + str + " is missing required column: " + str4);
                        }
                    }
                    if (strArr != null) {
                        for (int i = 0; i < strArr.length; i += 2) {
                            if (!hashSet.remove(strArr[i])) {
                                sQLiteDatabase.execSQL(strArr[i + 1]);
                            }
                        }
                    }
                    if (hashSet.isEmpty()) {
                        return;
                    }
                    zzheVar.zzk().zzc("Table has extra columns. table, columns", str, TextUtils.join(", ", hashSet));
                } catch (Throwable th2) {
                    cursorRawQuery.close();
                    throw th2;
                }
            } catch (SQLiteException e3) {
                zzheVar.zze().zzb("Failed to verify columns on table that was just created", str);
                throw e3;
            }
        } catch (Throwable th3) {
            th = th3;
            r14 = str2;
            if (r14 != 0) {
                r14.close();
            }
            throw th;
        }
    }

    static void zzb(zzhe zzheVar, SQLiteDatabase sQLiteDatabase) {
        if (zzheVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        com.google.android.gms.internal.measurement.zzbx.zza();
        String path = sQLiteDatabase.getPath();
        int i = com.google.android.gms.internal.measurement.zzcc.zzb;
        File file = new File(path);
        if (!file.setReadable(false, false)) {
            zzheVar.zzk().zza("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            zzheVar.zzk().zza("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            zzheVar.zzk().zza("Failed to turn on database read permission for owner");
        }
        if (file.setWritable(true, true)) {
            return;
        }
        zzheVar.zzk().zza("Failed to turn on database write permission for owner");
    }
}

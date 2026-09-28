package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzgv extends zzg {
    private static final String[] zza = {"app_version", "ALTER TABLE messages ADD COLUMN app_version TEXT;", "app_version_int", "ALTER TABLE messages ADD COLUMN app_version_int INTEGER;"};
    private final zzgt zzb;
    private boolean zzc;

    zzgv(zzio zzioVar) {
        super(zzioVar);
        Context contextZzaT = this.zzu.zzaT();
        this.zzu.zzf();
        this.zzb = new zzgt(this, contextZzaT, "google_app_measurement_local.db");
    }

    /* JADX WARN: Code duplicated, block: B:68:0x012a A[PHI: r8 r10
  0x012a: PHI (r8v3 int) = (r8v1 int), (r8v1 int), (r8v4 int) binds: [B:59:0x0118, B:74:0x0147, B:67:0x0128] A[DONT_GENERATE, DONT_INLINE]
  0x012a: PHI (r10v8 android.database.sqlite.SQLiteDatabase) = 
  (r10v6 android.database.sqlite.SQLiteDatabase)
  (r10v7 android.database.sqlite.SQLiteDatabase)
  (r10v9 android.database.sqlite.SQLiteDatabase)
 binds: [B:59:0x0118, B:74:0x0147, B:67:0x0128] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:80:0x0154  */
    /* JADX WARN: Code duplicated, block: B:82:0x0159  */
    private final boolean zzs(int i, byte[] bArr) throws Throwable {
        SQLiteDatabase sQLiteDatabaseZzh;
        Cursor cursorRawQuery;
        zzg();
        boolean z = false;
        z = false;
        if (!this.zzc) {
            zzio zzioVar = this.zzu;
            Cursor cursor = null;
            cursor = null;
            zzr zzrVarZzk = zzioVar.zzf().zzx(null, zzgi.zzbl) ? this.zzu.zzh().zzk(null) : null;
            ContentValues contentValues = new ContentValues();
            contentValues.put("type", Integer.valueOf(i));
            contentValues.put("entry", bArr);
            if (zzioVar.zzf().zzx(null, zzgi.zzbl) && zzrVarZzk != null) {
                contentValues.put("app_version", zzrVarZzk.zzc);
                contentValues.put("app_version_int", Long.valueOf(zzrVarZzk.zzj));
            }
            zzioVar.zzf();
            int i2 = 0;
            int i3 = 5;
            for (int i4 = 5; i2 < i4; i4 = 5) {
                try {
                    sQLiteDatabaseZzh = zzh();
                    if (sQLiteDatabaseZzh == null) {
                        this.zzc = true;
                    } else {
                        try {
                            sQLiteDatabaseZzh.beginTransaction();
                            cursorRawQuery = sQLiteDatabaseZzh.rawQuery("select count(1) from messages", null);
                            long j = 0;
                            if (cursorRawQuery != null) {
                                try {
                                    if (cursorRawQuery.moveToFirst()) {
                                        j = cursorRawQuery.getLong(z ? 1 : 0);
                                    }
                                } catch (SQLiteDatabaseLockedException unused) {
                                    SystemClock.sleep(i3);
                                    i3 += 20;
                                    if (cursorRawQuery != null) {
                                        cursorRawQuery.close();
                                    }
                                    if (sQLiteDatabaseZzh != null) {
                                        sQLiteDatabaseZzh.close();
                                    }
                                    i2++;
                                    z = false;
                                } catch (SQLiteFullException e) {
                                    e = e;
                                    this.zzu.zzaW().zze().zzb("Error writing entry; local database full", e);
                                    this.zzc = true;
                                    if (cursorRawQuery != null) {
                                        cursorRawQuery.close();
                                    }
                                    if (sQLiteDatabaseZzh != null) {
                                        sQLiteDatabaseZzh.close();
                                    }
                                    i2++;
                                    z = false;
                                } catch (SQLiteException e2) {
                                    e = e2;
                                    if (sQLiteDatabaseZzh != null) {
                                        try {
                                            if (sQLiteDatabaseZzh.inTransaction()) {
                                                sQLiteDatabaseZzh.endTransaction();
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            cursor = cursorRawQuery;
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                            if (sQLiteDatabaseZzh != null) {
                                                sQLiteDatabaseZzh.close();
                                            }
                                            throw th;
                                        }
                                    }
                                    this.zzu.zzaW().zze().zzb("Error writing entry to local database", e);
                                    this.zzc = true;
                                    if (cursorRawQuery != null) {
                                        cursorRawQuery.close();
                                    }
                                    if (sQLiteDatabaseZzh != null) {
                                        sQLiteDatabaseZzh.close();
                                    }
                                    i2++;
                                    z = false;
                                }
                            }
                            if (j >= 100000) {
                                zzioVar.zzaW().zze().zza("Data loss, local db full");
                                String[] strArr = new String[1];
                                long j2 = 100001 - j;
                                strArr[z ? 1 : 0] = Long.toString(j2);
                                long jDelete = sQLiteDatabaseZzh.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", strArr);
                                if (jDelete != j2) {
                                    zzioVar.zzaW().zze().zzd("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j2), Long.valueOf(jDelete), Long.valueOf(j2 - jDelete));
                                }
                            }
                            sQLiteDatabaseZzh.insertOrThrow("messages", null, contentValues);
                            sQLiteDatabaseZzh.setTransactionSuccessful();
                            sQLiteDatabaseZzh.endTransaction();
                            if (cursorRawQuery != null) {
                                cursorRawQuery.close();
                            }
                            sQLiteDatabaseZzh.close();
                            return true;
                        } catch (SQLiteDatabaseLockedException unused2) {
                            cursorRawQuery = null;
                        } catch (SQLiteFullException e3) {
                            e = e3;
                            cursorRawQuery = null;
                        } catch (SQLiteException e4) {
                            e = e4;
                            cursorRawQuery = null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (sQLiteDatabaseZzh != null) {
                                sQLiteDatabaseZzh.close();
                            }
                            throw th;
                        }
                    }
                } catch (SQLiteDatabaseLockedException unused3) {
                    sQLiteDatabaseZzh = null;
                    cursorRawQuery = null;
                } catch (SQLiteFullException e5) {
                    e = e5;
                    sQLiteDatabaseZzh = null;
                    cursorRawQuery = null;
                } catch (SQLiteException e6) {
                    e = e6;
                    sQLiteDatabaseZzh = null;
                    cursorRawQuery = null;
                } catch (Throwable th3) {
                    th = th3;
                    sQLiteDatabaseZzh = null;
                }
            }
            this.zzu.zzaW().zzj().zza("Failed to write entry to local database");
            return false;
        }
        return z;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zzf() {
        return false;
    }

    final SQLiteDatabase zzh() throws SQLiteException {
        if (this.zzc) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zzb.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzc = true;
        return null;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 8781. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final java.util.List zzi(int r30) {
        /*
            Method dump skipped, instruction units count: 878
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgv.zzi(int):java.util.List");
    }

    public final void zzj() {
        int iDelete;
        zzg();
        try {
            SQLiteDatabase sQLiteDatabaseZzh = zzh();
            if (sQLiteDatabaseZzh == null || (iDelete = sQLiteDatabaseZzh.delete("messages", null, null)) <= 0) {
                return;
            }
            this.zzu.zzaW().zzj().zzb("Reset local analytics data. records", Integer.valueOf(iDelete));
        } catch (SQLiteException e) {
            this.zzu.zzaW().zze().zzb("Error resetting local analytics data. error", e);
        }
    }

    public final boolean zzk() {
        return zzs(3, new byte[0]);
    }

    final boolean zzl() {
        zzio zzioVar = this.zzu;
        Context contextZzaT = zzioVar.zzaT();
        zzioVar.zzf();
        return contextZzaT.getDatabasePath("google_app_measurement_local.db").exists();
    }

    /* JADX WARN: Code duplicated, block: B:32:0x006b A[PHI: r4
  0x006b: PHI (r4v3 int) = (r4v1 int), (r4v1 int), (r4v4 int) binds: [B:34:0x007e, B:28:0x0062, B:31:0x0069] A[DONT_GENERATE, DONT_INLINE]] */
    public final boolean zzm() {
        zzg();
        if (!this.zzc && zzl()) {
            int i = 5;
            for (int i2 = 0; i2 < 5; i2++) {
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    try {
                        try {
                            SQLiteDatabase sQLiteDatabaseZzh = zzh();
                            if (sQLiteDatabaseZzh != null) {
                                sQLiteDatabaseZzh.beginTransaction();
                                sQLiteDatabaseZzh.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                                sQLiteDatabaseZzh.setTransactionSuccessful();
                                sQLiteDatabaseZzh.endTransaction();
                                sQLiteDatabaseZzh.close();
                                return true;
                            }
                            this.zzc = true;
                        } catch (SQLiteFullException e) {
                            this.zzu.zzaW().zze().zzb("Error deleting app launch break from local database", e);
                            this.zzc = true;
                            if (0 != 0) {
                                sQLiteDatabase.close();
                            }
                        }
                    } catch (SQLiteException e2) {
                        if (0 != 0) {
                            try {
                                if (sQLiteDatabase.inTransaction()) {
                                    sQLiteDatabase.endTransaction();
                                }
                            } catch (Throwable th) {
                                if (0 != 0) {
                                    sQLiteDatabase.close();
                                }
                                throw th;
                            }
                        }
                        this.zzu.zzaW().zze().zzb("Error deleting app launch break from local database", e2);
                        this.zzc = true;
                        if (0 != 0) {
                            sQLiteDatabase.close();
                        }
                    }
                } catch (SQLiteDatabaseLockedException unused) {
                    SystemClock.sleep(i);
                    i += 20;
                    if (0 != 0) {
                        sQLiteDatabase.close();
                    }
                }
            }
            this.zzu.zzaW().zzk().zza("Error deleting app launch break from local database in reasonable time");
        }
        return false;
    }

    public final boolean zzn(zzai zzaiVar) {
        zzio zzioVar = this.zzu;
        byte[] bArrZzay = zzioVar.zzw().zzay(zzaiVar);
        if (bArrZzay.length <= 131072) {
            return zzs(2, bArrZzay);
        }
        zzioVar.zzaW().zzh().zza("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean zzo(zzbf zzbfVar) {
        zzio zzioVar = this.zzu;
        byte[] bArrZzay = zzioVar.zzw().zzay(zzbfVar);
        if (bArrZzay == null) {
            zzioVar.zzaW().zzh().zza("Null default event parameters; not writing to database");
            return false;
        }
        if (bArrZzay.length <= 131072) {
            return zzs(4, bArrZzay);
        }
        zzioVar.zzaW().zzh().zza("Default event parameters too long for local database. Sending directly to service");
        return false;
    }

    public final boolean zzp(zzbh zzbhVar) {
        Parcel parcelObtain = Parcel.obtain();
        zzbi.zza(zzbhVar, parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length <= 131072) {
            return zzs(0, bArrMarshall);
        }
        this.zzu.zzaW().zzh().zza("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zzq(zzqb zzqbVar) {
        Parcel parcelObtain = Parcel.obtain();
        zzqc.zza(zzqbVar, parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length <= 131072) {
            return zzs(1, bArrMarshall);
        }
        this.zzu.zzaW().zzh().zza("User property too long for local database. Sending directly to service");
        return false;
    }
}

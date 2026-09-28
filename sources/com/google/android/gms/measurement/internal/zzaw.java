package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.credentials.CredentialOption;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzqr;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzaw extends zzpg {
    private final zzav zzm;
    private final zzou zzn;
    private static final String[] zzb = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    static final String[] zza = {"associated_row_id", "ALTER TABLE upload_queue ADD COLUMN associated_row_id INTEGER;", "last_upload_timestamp", "ALTER TABLE upload_queue ADD COLUMN last_upload_timestamp INTEGER;"};
    private static final String[] zzc = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzd = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;", "unmatched_pfo", "ALTER TABLE apps ADD COLUMN unmatched_pfo INTEGER;", "unmatched_uwa", "ALTER TABLE apps ADD COLUMN unmatched_uwa INTEGER;", "ad_campaign_info", "ALTER TABLE apps ADD COLUMN ad_campaign_info BLOB;", "daily_registered_triggers_count", "ALTER TABLE apps ADD COLUMN daily_registered_triggers_count INTEGER;", "client_upload_eligibility", "ALTER TABLE apps ADD COLUMN client_upload_eligibility INTEGER;"};
    private static final String[] zze = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] zzf = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] zzh = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzi = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzj = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private static final String[] zzk = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;", "storage_consent_at_bundling", "ALTER TABLE consent_settings ADD COLUMN storage_consent_at_bundling TEXT;"};
    private static final String[] zzl = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};

    zzaw(zzpv zzpvVar) {
        super(zzpvVar);
        this.zzn = new zzou(this.zzu.zzaU());
        this.zzu.zzf();
        this.zzm = new zzav(this, this.zzu.zzaT(), "google_app_measurement.db");
    }

    /* JADX WARN: Code duplicated, block: B:53:0x0131  */
    private final zzbd zzaA(String str, String str2, String str3) throws Throwable {
        Cursor cursorQuery;
        Boolean boolValueOf;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        zzg();
        zzav();
        Cursor cursor = null;
        try {
            cursorQuery = zzj().query(str, (String[]) new ArrayList(Arrays.asList("lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling", "current_session_count")).toArray(new String[0]), "app_id=? and name=?", new String[]{str2, str3}, null, null, null);
            try {
                try {
                    if (cursorQuery.moveToFirst()) {
                        long j = cursorQuery.getLong(0);
                        long j2 = cursorQuery.getLong(1);
                        long j3 = cursorQuery.getLong(2);
                        long j4 = cursorQuery.isNull(3) ? 0L : cursorQuery.getLong(3);
                        Long lValueOf = cursorQuery.isNull(4) ? null : Long.valueOf(cursorQuery.getLong(4));
                        Long lValueOf2 = cursorQuery.isNull(5) ? null : Long.valueOf(cursorQuery.getLong(5));
                        Long lValueOf3 = cursorQuery.isNull(6) ? null : Long.valueOf(cursorQuery.getLong(6));
                        if (cursorQuery.isNull(7)) {
                            boolValueOf = null;
                        } else {
                            boolValueOf = Boolean.valueOf(cursorQuery.getLong(7) == 1);
                        }
                        zzbd zzbdVar = new zzbd(str2, str3, j, j2, cursorQuery.isNull(8) ? 0L : cursorQuery.getLong(8), j3, j4, lValueOf, lValueOf2, lValueOf3, boolValueOf);
                        if (cursorQuery.moveToNext()) {
                            this.zzu.zzaW().zze().zzb("Got multiple records for event aggregates, expected one. appId", zzhe.zzn(str2));
                        }
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return zzbdVar;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e) {
                e = e;
                zzio zzioVar = this.zzu;
                zzioVar.zzaW().zze().zzd("Error querying events. appId", zzhe.zzn(str2), zzioVar.zzj().zzd(str3), e);
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    private final zzpz zzaB(String str, long j, byte[] bArr, String str2, String str3, int i, int i2, long j2, long j3, long j4) {
        if (TextUtils.isEmpty(str2)) {
            this.zzu.zzaW().zzd().zza("Upload uri is null or empty. Destination is unknown. Dropping batch. ");
            return null;
        }
        try {
            com.google.android.gms.internal.measurement.zzht zzhtVar = (com.google.android.gms.internal.measurement.zzht) zzqa.zzp(com.google.android.gms.internal.measurement.zzhv.zzb(), bArr);
            zzmf zzmfVarZzb = zzmf.zzb(i);
            if (zzmfVarZzb != zzmf.GOOGLE_SIGNAL && zzmfVarZzb != zzmf.GOOGLE_SIGNAL_PENDING && i2 > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator it = zzhtVar.zzj().iterator();
                while (it.hasNext()) {
                    com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) ((com.google.android.gms.internal.measurement.zzhx) it.next()).zzch();
                    zzhwVar.zzat(i2);
                    arrayList.add((com.google.android.gms.internal.measurement.zzhx) zzhwVar.zzba());
                }
                zzhtVar.zzd();
                zzhtVar.zzb(arrayList);
            }
            HashMap map = new HashMap();
            if (str3 != null) {
                for (String str4 : str3.split("\r\n")) {
                    if (str4.isEmpty()) {
                        break;
                    }
                    String[] strArrSplit = str4.split("=", 2);
                    if (strArrSplit.length != 2) {
                        this.zzu.zzaW().zze().zzb("Invalid upload header: ", str4);
                        break;
                    }
                    map.put(strArrSplit[0], strArrSplit[1]);
                }
            }
            zzpx zzpxVar = new zzpx();
            zzpxVar.zzf(j);
            zzpxVar.zzd((com.google.android.gms.internal.measurement.zzhv) zzhtVar.zzba());
            zzpxVar.zzi(str2);
            zzpxVar.zzg(map);
            zzpxVar.zzh(zzmfVarZzb);
            zzpxVar.zzb(j2);
            zzpxVar.zza(j3);
            zzpxVar.zzc(j4);
            zzpxVar.zze(i2);
            return zzpxVar.zzj();
        } catch (IOException e) {
            this.zzu.zzaW().zze().zzc("Failed to queued MeasurementBatch from upload_queue. appId", str, e);
            return null;
        }
    }

    private final String zzaC() {
        zzio zzioVar = this.zzu;
        long jCurrentTimeMillis = zzioVar.zzaU().currentTimeMillis();
        Locale locale = Locale.US;
        zzmf zzmfVar = zzmf.GOOGLE_SIGNAL;
        Integer numValueOf = Integer.valueOf(zzmfVar.zza());
        Long lValueOf = Long.valueOf(jCurrentTimeMillis);
        zzioVar.zzf();
        String str = String.format(locale, "(upload_type = %d AND ABS(creation_timestamp - %d) > %d)", numValueOf, lValueOf, Long.valueOf(((Long) zzgi.zzR.zza(null)).longValue()));
        Locale locale2 = Locale.US;
        Integer numValueOf2 = Integer.valueOf(zzmfVar.zza());
        zzioVar.zzf();
        return "(" + str + " OR " + String.format(locale2, "(upload_type != %d AND ABS(creation_timestamp - %d) > %d)", numValueOf2, lValueOf, Long.valueOf(zzam.zzI())) + ")";
    }

    private final String zzaD(String str, String[] strArr, String str2) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = zzj().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    String string = cursorRawQuery.getString(0);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return string;
                }
                if (cursorRawQuery == null) {
                    return "";
                }
                cursorRawQuery.close();
                return "";
            } catch (SQLiteException e) {
                this.zzu.zzaW().zze().zzc("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    private final void zzaE(String str, String str2) {
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzav();
        try {
            zzj().delete(str, "app_id=?", new String[]{str2});
        } catch (SQLiteException e) {
            this.zzu.zzaW().zze().zzc("Error deleting snapshot. appId", zzhe.zzn(str2), e);
        }
    }

    private final void zzaF(String str, zzbd zzbdVar) {
        Preconditions.checkNotNull(zzbdVar);
        zzg();
        zzav();
        ContentValues contentValues = new ContentValues();
        String str2 = zzbdVar.zza;
        contentValues.put("app_id", str2);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzbdVar.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzbdVar.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzbdVar.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzbdVar.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzbdVar.zzg));
        contentValues.put("last_bundled_day", zzbdVar.zzh);
        contentValues.put("last_sampled_complex_event_id", zzbdVar.zzi);
        contentValues.put("last_sampling_rate", zzbdVar.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzbdVar.zze));
        Boolean bool = zzbdVar.zzk;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (zzj().insertWithOnConflict(str, null, contentValues, 5) == -1) {
                this.zzu.zzaW().zze().zzb("Failed to insert/update event aggregates (got -1). appId", zzhe.zzn(str2));
            }
        } catch (SQLiteException e) {
            this.zzu.zzaW().zze().zzc("Error storing event aggregates. appId", zzhe.zzn(zzbdVar.zza), e);
        }
    }

    private final void zzaG(String str, String str2, ContentValues contentValues) {
        try {
            SQLiteDatabase sQLiteDatabaseZzj = zzj();
            String asString = contentValues.getAsString("app_id");
            if (asString == null) {
                this.zzu.zzaW().zzf().zzb("Value of the primary key is not set.", zzhe.zzn("app_id"));
            } else if (sQLiteDatabaseZzj.update("consent_settings", contentValues, "app_id = ?", new String[]{asString}) == 0 && sQLiteDatabaseZzj.insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                this.zzu.zzaW().zze().zzc("Failed to insert/update table (got -1). key", zzhe.zzn("consent_settings"), zzhe.zzn("app_id"));
            }
        } catch (SQLiteException e) {
            this.zzu.zzaW().zze().zzd("Error storing into table. key", zzhe.zzn("consent_settings"), zzhe.zzn("app_id"), e);
        }
    }

    private static final String zzaH(List list) {
        return list.isEmpty() ? "" : String.format(" AND (upload_type IN (%s))", TextUtils.join(", ", list));
    }

    static final void zzau(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty("value");
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put("value", (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else {
            if (!(obj instanceof Double)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            contentValues.put("value", (Double) obj);
        }
    }

    private final long zzay(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = zzj().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j = cursorRawQuery.getLong(0);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return j;
            } catch (SQLiteException e) {
                this.zzu.zzaW().zze().zzc("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zzaz(String str, String[] strArr, long j) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = zzj().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    j = cursorRawQuery.getLong(0);
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return j;
            } catch (SQLiteException e) {
                this.zzu.zzaW().zze().zzc("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x003e  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final String zzA() throws Throwable {
        SQLiteException e;
        Cursor cursorRawQuery;
        SQLiteDatabase sQLiteDatabaseZzj = zzj();
        ?? r1 = 0;
        try {
            try {
                cursorRawQuery = sQLiteDatabaseZzj.rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        String string = cursorRawQuery.getString(0);
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        return string;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    this.zzu.zzaW().zze().zzb("Database error getting next bundle app id", e);
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursorRawQuery = null;
            } catch (Throwable th) {
                th = th;
                if (r1 != 0) {
                    r1.close();
                }
                throw th;
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return null;
        } catch (Throwable th2) {
            r1 = sQLiteDatabaseZzj;
            th = th2;
            if (r1 != 0) {
                r1.close();
            }
            throw th;
        }
    }

    public final List zzB(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzav();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return zzC(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0163  */
    public final List zzC(String str, String[] strArr) throws Throwable {
        Cursor cursor;
        Cursor cursorQuery;
        zzg();
        zzav();
        List arrayList = new ArrayList();
        try {
            SQLiteDatabase sQLiteDatabaseZzj = zzj();
            String[] strArr2 = {"app_id", "origin", AppMeasurementSdk.ConditionalUserProperty.NAME, "value", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"};
            zzio zzioVar = this.zzu;
            zzioVar.zzf();
            cursorQuery = sQLiteDatabaseZzj.query("conditional_properties", strArr2, str, strArr, null, null, "rowid", "1001");
            try {
                if (cursorQuery.moveToFirst()) {
                    do {
                        int size = arrayList.size();
                        zzioVar.zzf();
                        if (size >= 1000) {
                            zzhc zzhcVarZze = zzioVar.zzaW().zze();
                            zzioVar.zzf();
                            zzhcVarZze.zzb("Read more than the max allowed conditional properties, ignoring extra", 1000);
                            break;
                        }
                        String string = cursorQuery.getString(0);
                        String string2 = cursorQuery.getString(1);
                        String string3 = cursorQuery.getString(2);
                        Object objZzz = zzz(cursorQuery, 3);
                        boolean z = cursorQuery.getInt(4) != 0;
                        String string4 = cursorQuery.getString(5);
                        long j = cursorQuery.getLong(6);
                        zzpv zzpvVar = this.zzg;
                        arrayList.add(new zzai(string, string2, new zzqb(string3, cursorQuery.getLong(10), objZzz, string2), cursorQuery.getLong(8), z, string4, (zzbh) zzpvVar.zzA().zzi(cursorQuery.getBlob(7), zzbh.CREATOR), j, (zzbh) zzpvVar.zzA().zzi(cursorQuery.getBlob(9), zzbh.CREATOR), cursorQuery.getLong(11), (zzbh) zzpvVar.zzA().zzi(cursorQuery.getBlob(12), zzbh.CREATOR)));
                    } while (cursorQuery.moveToNext());
                }
            } catch (SQLiteException e) {
                e = e;
                cursor = cursorQuery;
                try {
                    this.zzu.zzaW().zze().zzb("Error querying conditional user property value", e);
                    arrayList = Collections.emptyList();
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
        } catch (SQLiteException e2) {
            e = e2;
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

    /* JADX WARN: Code duplicated, block: B:39:0x013f  */
    /* JADX WARN: Code duplicated, block: B:43:0x0146  */
    public final List zzD(String str, zzpc zzpcVar, int i) {
        Cursor cursor;
        Cursor cursorQuery;
        List listEmptyList;
        Cursor cursor2;
        if (!this.zzu.zzf().zzx(null, zzgi.zzaP)) {
            return Collections.emptyList();
        }
        Preconditions.checkNotEmpty(str);
        zzg();
        zzav();
        try {
            int i2 = 0;
            int i3 = 2;
            int i4 = 3;
            int i5 = 5;
            int i6 = 4;
            cursorQuery = zzj().query("upload_queue", new String[]{"rowId", "app_id", "measurement_batch", "upload_uri", "upload_headers", "upload_type", "retry_count", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "associated_row_id", "last_upload_timestamp"}, "app_id=?" + zzaH(zzpcVar.zza) + " AND NOT " + zzaC(), new String[]{str}, null, null, "creation_timestamp ASC", i > 0 ? String.valueOf(i) : null);
            try {
                listEmptyList = new ArrayList();
                while (cursorQuery.moveToNext()) {
                    long j = cursorQuery.getLong(i2);
                    byte[] blob = cursorQuery.getBlob(i3);
                    String string = cursorQuery.getString(i4);
                    String string2 = cursorQuery.getString(i6);
                    int i7 = cursorQuery.getInt(i5);
                    int i8 = i6;
                    int i9 = i4;
                    List list = listEmptyList;
                    cursor2 = cursorQuery;
                    int i10 = i3;
                    int i11 = i2;
                    try {
                        zzpz zzpzVarZzaB = zzaB(str, j, blob, string, string2, i7, cursorQuery.getInt(6), cursorQuery.getLong(7), cursorQuery.getLong(8), cursorQuery.getLong(9));
                        if (zzpzVarZzaB != null) {
                            list.add(zzpzVarZzaB);
                        }
                        listEmptyList = list;
                        cursorQuery = cursor2;
                        i3 = i10;
                        i6 = i8;
                        i2 = i11;
                        i4 = i9;
                        i5 = 5;
                    } catch (SQLiteException e) {
                        e = e;
                        cursor = cursor2;
                        try {
                            this.zzu.zzaW().zze().zzc("Error to querying MeasurementBatch from upload_queue. appId", str, e);
                            listEmptyList = Collections.emptyList();
                            cursorQuery = cursor;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return listEmptyList;
                        } catch (Throwable th) {
                            th = th;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = cursor2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursor2 = cursorQuery;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursorQuery;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return listEmptyList;
    }

    public final List zzE(String str) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzav();
        List arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseZzj = zzj();
                String[] strArr = {AppMeasurementSdk.ConditionalUserProperty.NAME, "origin", "set_timestamp", "value"};
                zzio zzioVar = this.zzu;
                zzioVar.zzf();
                cursorQuery = sQLiteDatabaseZzj.query("user_attributes", strArr, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(0);
                        String string2 = cursorQuery.getString(1);
                        if (string2 == null) {
                            string2 = "";
                        }
                        String str2 = string2;
                        long j = cursorQuery.getLong(2);
                        Object objZzz = zzz(cursorQuery, 3);
                        if (objZzz == null) {
                            zzioVar.zzaW().zze().zzb("Read invalid user property value, ignoring it. appId", zzhe.zzn(str));
                        } else {
                            arrayList.add(new zzqd(str, str2, string, j, objZzz));
                        }
                    } while (cursorQuery.moveToNext());
                }
            } catch (SQLiteException e) {
                this.zzu.zzaW().zze().zzc("Error querying user properties. appId", zzhe.zzn(str), e);
                arrayList = Collections.emptyList();
            }
            return arrayList;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0135  */
    /* JADX WARN: Code duplicated, block: B:48:0x013c  */
    public final List zzF(String str, String str2, String str3) throws Throwable {
        Cursor cursor;
        String string;
        Cursor cursorQuery;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzav();
        List arrayList = new ArrayList();
        try {
            try {
                ArrayList arrayList2 = new ArrayList(3);
                try {
                    arrayList2.add(str);
                    StringBuilder sb = new StringBuilder("app_id=?");
                    if (TextUtils.isEmpty(str2)) {
                        string = str2;
                    } else {
                        string = str2;
                        try {
                            arrayList2.add(string);
                            sb.append(" and origin=?");
                        } catch (SQLiteException e) {
                            e = e;
                            cursor = null;
                            try {
                                this.zzu.zzaW().zze().zzd("(2)Error querying user properties", zzhe.zzn(str), string, e);
                                arrayList = Collections.emptyList();
                                cursorQuery = cursor;
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                return arrayList;
                            } catch (Throwable th) {
                                th = th;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th;
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        arrayList2.add(str3 + "*");
                        sb.append(" and name glob ?");
                    }
                    String[] strArr = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
                    SQLiteDatabase sQLiteDatabaseZzj = zzj();
                    String[] strArr2 = {AppMeasurementSdk.ConditionalUserProperty.NAME, "set_timestamp", "value", "origin"};
                    String string2 = sb.toString();
                    zzio zzioVar = this.zzu;
                    zzioVar.zzf();
                    cursorQuery = sQLiteDatabaseZzj.query("user_attributes", strArr2, string2, strArr, null, null, "rowid", "1001");
                    try {
                        if (cursorQuery.moveToFirst()) {
                            do {
                                int size = arrayList.size();
                                zzioVar.zzf();
                                if (size >= 1000) {
                                    zzhc zzhcVarZze = zzioVar.zzaW().zze();
                                    zzioVar.zzf();
                                    zzhcVarZze.zzb("Read more than the max allowed user properties, ignoring excess", 1000);
                                    break;
                                }
                                String string3 = cursorQuery.getString(0);
                                long j = cursorQuery.getLong(1);
                                Object objZzz = zzz(cursorQuery, 2);
                                string = cursorQuery.getString(3);
                                if (objZzz == null) {
                                    zzioVar.zzaW().zze().zzd("(2)Read invalid user property value, ignoring it", zzhe.zzn(str), string, str3);
                                } else {
                                    arrayList.add(new zzqd(str, string, string3, j, objZzz));
                                }
                            } while (cursorQuery.moveToNext());
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        cursor = cursorQuery;
                        this.zzu.zzaW().zze().zzd("(2)Error querying user properties", zzhe.zzn(str), string, e);
                        arrayList = Collections.emptyList();
                        cursorQuery = cursor;
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
                    string = str2;
                    cursor = null;
                    this.zzu.zzaW().zze().zzd("(2)Error querying user properties", zzhe.zzn(str), string, e);
                    arrayList = Collections.emptyList();
                    cursorQuery = cursor;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return arrayList;
                }
            } catch (SQLiteException e4) {
                e = e4;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0095  */
    /* JADX WARN: Code duplicated, block: B:30:0x00ce A[PHI: r2 r3
  0x00ce: PHI (r2v16 android.database.Cursor) = (r2v15 android.database.Cursor), (r2v23 android.database.Cursor) binds: [B:44:0x0106, B:29:0x00cc] A[DONT_GENERATE, DONT_INLINE]
  0x00ce: PHI (r3v6 java.lang.Object) = (r3v19 java.lang.Object), (r3v20 java.lang.Object) binds: [B:44:0x0106, B:29:0x00cc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    public final void zzG(String str, Long l, String str2, Bundle bundle) {
        zzio zzioVar;
        zzbc zzbcVar;
        long j;
        String str3;
        ContentValues contentValues;
        Cursor cursorQuery;
        Object obj;
        Object obj2;
        com.google.android.gms.internal.measurement.zzhx zzhxVar;
        Preconditions.checkNotNull(bundle);
        zzg();
        zzav();
        zzio zzioVar2 = this.zzu;
        Cursor cursor = null;
        zzau zzauVar = (!zzioVar2.zzf().zzx(null, zzgi.zzbe) || l == null) ? new zzau(this, str) : new zzau(this, str, l.longValue());
        List<zzat> listZza = zzauVar.zza();
        while (!listZza.isEmpty()) {
            for (zzat zzatVar : listZza) {
                try {
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            cursorQuery = zzj().query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{str, Long.toString(zzatVar.zzb)}, null, null, "rowid", "2");
                            try {
                                try {
                                    if (cursorQuery.moveToFirst()) {
                                        try {
                                            obj = (com.google.android.gms.internal.measurement.zzhx) ((com.google.android.gms.internal.measurement.zzhw) zzqa.zzp(com.google.android.gms.internal.measurement.zzhx.zzz(), cursorQuery.getBlob(0))).zzba();
                                            try {
                                                if (cursorQuery.moveToNext()) {
                                                    this.zzu.zzaW().zzk().zzb("Get multiple raw event metadata records, expected one. appId", zzhe.zzn(str));
                                                }
                                                cursorQuery.close();
                                                zzhxVar = obj;
                                                obj2 = obj;
                                                if (cursorQuery != null) {
                                                    cursorQuery.close();
                                                    zzhxVar = obj2;
                                                }
                                            } catch (SQLiteException e) {
                                                e = e;
                                                this.zzu.zzaW().zze().zzc("Data loss. Error selecting raw event. appId", zzhe.zzn(str), e);
                                                zzhxVar = obj;
                                                obj2 = obj;
                                                if (cursorQuery != null) {
                                                    cursorQuery.close();
                                                    zzhxVar = obj2;
                                                }
                                            }
                                        } catch (IOException e2) {
                                            this.zzu.zzaW().zze().zzc("Data loss. Failed to merge raw event metadata. appId", zzhe.zzn(str), e2);
                                            if (cursorQuery != null) {
                                                cursorQuery.close();
                                            }
                                            zzhxVar = cursor;
                                        }
                                    } else {
                                        zzioVar2.zzaW().zze().zzb("Raw event metadata record is missing. appId", zzhe.zzn(str));
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        zzhxVar = cursor;
                                    }
                                } catch (SQLiteException e3) {
                                    e = e3;
                                    obj = cursor;
                                }
                                if (zzhxVar != 0) {
                                    Iterator it = zzhxVar.zzY().iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            if (((com.google.android.gms.internal.measurement.zzio) it.next()).zzg().equals(str2)) {
                                            }
                                        }
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                cursor = cursorQuery;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th;
                            }
                        } catch (SQLiteException e4) {
                            e = e4;
                            cursorQuery = cursor;
                            obj = cursorQuery;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    long jUpdate = zzj().update("raw_events", contentValues, "rowid = ?", new String[]{String.valueOf(j)});
                    if (jUpdate != 1) {
                        zzioVar.zzaW().zze().zzc("Failed to update raw event. appId, updatedRows", zzhe.zzn(str3), Long.valueOf(jUpdate));
                    }
                } catch (SQLiteException e5) {
                    this.zzu.zzaW().zze().zzc("Error updating raw event. appId", zzhe.zzn(zzbcVar.zza), e5);
                }
                zzpv zzpvVar = this.zzg;
                zzqa zzqaVarZzA = zzpvVar.zzA();
                com.google.android.gms.internal.measurement.zzhm zzhmVar = zzatVar.zzd;
                Bundle bundle2 = new Bundle();
                for (com.google.android.gms.internal.measurement.zzhq zzhqVar : zzhmVar.zzi()) {
                    if (zzhqVar.zzu()) {
                        bundle2.putDouble(zzhqVar.zzg(), zzhqVar.zza());
                    } else if (zzhqVar.zzv()) {
                        bundle2.putFloat(zzhqVar.zzg(), zzhqVar.zzb());
                    } else if (zzhqVar.zzw()) {
                        bundle2.putLong(zzhqVar.zzg(), zzhqVar.zzd());
                    } else if (zzhqVar.zzy()) {
                        bundle2.putString(zzhqVar.zzg(), zzhqVar.zzh());
                    } else if (zzhqVar.zzi().isEmpty()) {
                        zzqaVarZzA.zzu.zzaW().zze().zzb("Unexpected parameter type for parameter", zzhqVar);
                    } else {
                        bundle2.putParcelableArray(zzhqVar.zzg(), zzqa.zzC(zzhqVar.zzi()));
                    }
                }
                String string = bundle2.getString("_o");
                bundle2.remove("_o");
                String strZzh = zzhmVar.zzh();
                if (string == null) {
                    string = "";
                }
                zzhf zzhfVar = new zzhf(strZzh, string, bundle2, zzhmVar.zzd());
                zzioVar = this.zzu;
                Bundle bundle3 = zzhfVar.zzd;
                zzioVar.zzw().zzO(bundle3, bundle);
                zzbcVar = new zzbc(this.zzu, zzhfVar.zzb, str, zzhmVar.zzh(), zzhmVar.zzd(), zzhmVar.zzc(), bundle3);
                j = zzatVar.zza;
                long j2 = zzatVar.zzb;
                boolean z = zzatVar.zzc;
                zzg();
                zzav();
                Preconditions.checkNotNull(zzbcVar);
                str3 = zzbcVar.zza;
                Preconditions.checkNotEmpty(str3);
                byte[] bArrZzcd = zzpvVar.zzA().zzm(zzbcVar).zzcd();
                contentValues = new ContentValues();
                contentValues.put("app_id", str3);
                contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzbcVar.zzb);
                contentValues.put("timestamp", Long.valueOf(zzbcVar.zzd));
                contentValues.put("metadata_fingerprint", Long.valueOf(j2));
                contentValues.put("data", bArrZzcd);
                contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
                cursor = null;
            }
            listZza = zzauVar.zza();
            cursor = null;
        }
    }

    public final void zzH() {
        zzav();
        zzj().beginTransaction();
    }

    public final void zzI(String str) {
        zzbd zzbdVarZzaA;
        zzaE("events_snapshot", str);
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = zzj().query("events", (String[]) Collections.singletonList(AppMeasurementSdk.ConditionalUserProperty.NAME).toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(0);
                        if (string != null && (zzbdVarZzaA = zzaA("events", str, string)) != null) {
                            zzaF("events_snapshot", zzbdVarZzaA);
                        }
                    } while (cursorQuery.moveToNext());
                }
            } catch (SQLiteException e) {
                this.zzu.zzaW().zze().zzc("Error creating snapshot. appId", zzhe.zzn(str), e);
            }
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    public final void zzJ(List list) {
        Preconditions.checkNotNull(list);
        zzg();
        zzav();
        StringBuilder sb = new StringBuilder("rowid in (");
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(((Long) list.get(i)).longValue());
        }
        sb.append(")");
        int iDelete = zzj().delete("raw_events", sb.toString(), null);
        if (iDelete != list.size()) {
            this.zzu.zzaW().zze().zzc("Deleted fewer rows from raw events table than expected", Integer.valueOf(iDelete), Integer.valueOf(list.size()));
        }
    }

    public final void zzK(Long l) {
        zzg();
        zzav();
        Preconditions.checkNotNull(l);
        zzio zzioVar = this.zzu;
        if (zzioVar.zzf().zzx(null, zzgi.zzaM)) {
            try {
                if (zzj().delete("upload_queue", "rowid=?", new String[]{l.toString()}) != 1) {
                    zzioVar.zzaW().zzk().zza("Deleted fewer rows from upload_queue than expected");
                }
            } catch (SQLiteException e) {
                this.zzu.zzaW().zze().zzb("Failed to delete a MeasurementBatch in a upload_queue table", e);
                throw e;
            }
        }
    }

    public final void zzL() {
        zzav();
        zzj().endTransaction();
    }

    final void zzM(List list) {
        zzg();
        zzav();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzae()) {
            String str = "(" + TextUtils.join(",", list) + ")";
            if (zzay("SELECT COUNT(1) FROM queue WHERE rowid IN " + str + " AND retry_count =  2147483647 LIMIT 1", null) > 0) {
                this.zzu.zzaW().zzk().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                zzj().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + str + " AND (retry_count IS NULL OR retry_count < 2147483647)");
            } catch (SQLiteException e) {
                this.zzu.zzaW().zze().zzb("Error incrementing retry count. error", e);
            }
        }
    }

    final void zzN(Long l) {
        String str;
        zzg();
        zzav();
        Preconditions.checkNotNull(l);
        zzio zzioVar = this.zzu;
        if (zzioVar.zzf().zzx(null, zzgi.zzaM) && zzae()) {
            if (zzay("SELECT COUNT(1) FROM upload_queue WHERE rowid = " + l + " AND retry_count =  2147483647 LIMIT 1", null) > 0) {
                zzioVar.zzaW().zzk().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase sQLiteDatabaseZzj = zzj();
                if (zzioVar.zzf().zzx(null, zzgi.zzaP)) {
                    str = " SET retry_count = retry_count + 1, last_upload_timestamp = " + zzioVar.zzaU().currentTimeMillis();
                } else {
                    str = " SET retry_count = retry_count + 1 ";
                }
                sQLiteDatabaseZzj.execSQL("UPDATE upload_queue" + str + " WHERE rowid = " + l + " AND retry_count < 2147483647");
            } catch (SQLiteException e) {
                this.zzu.zzaW().zze().zzb("Error incrementing retry count. error", e);
            }
        }
    }

    final void zzO() {
        zzg();
        zzav();
        if (zzae()) {
            zzpv zzpvVar = this.zzg;
            long jZza = zzpvVar.zzw().zza.zza();
            zzio zzioVar = this.zzu;
            long jElapsedRealtime = zzioVar.zzaU().elapsedRealtime();
            long jAbs = Math.abs(jElapsedRealtime - jZza);
            zzioVar.zzf();
            if (jAbs > zzam.zzJ()) {
                zzpvVar.zzw().zza.zzb(jElapsedRealtime);
                zzg();
                zzav();
                if (zzae()) {
                    SQLiteDatabase sQLiteDatabaseZzj = zzj();
                    String strValueOf = String.valueOf(zzioVar.zzaU().currentTimeMillis());
                    zzioVar.zzf();
                    int iDelete = sQLiteDatabaseZzj.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{strValueOf, String.valueOf(zzam.zzI())});
                    if (iDelete > 0) {
                        zzioVar.zzaW().zzj().zzb("Deleted stale rows. rowsDeleted", Integer.valueOf(iDelete));
                    }
                }
            }
        }
    }

    public final void zzP(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzav();
        try {
            zzj().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzio zzioVar = this.zzu;
            zzioVar.zzaW().zze().zzd("Error deleting user property. appId", zzhe.zzn(str), zzioVar.zzj().zzf(str2), e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:44:0x00be  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x00d6 A[ADDED_TO_REGION] */
    public final void zzQ(String str) throws Throwable {
        boolean z;
        zzbd zzbdVarZzaA;
        ArrayList arrayList = new ArrayList(Arrays.asList(AppMeasurementSdk.ConditionalUserProperty.NAME, "lifetime_count"));
        zzbd zzbdVarZzaA2 = zzaA("events", str, "_f");
        zzbd zzbdVarZzaA3 = zzaA("events", str, "_v");
        zzaE("events", str);
        Cursor cursorQuery = null;
        boolean z2 = false;
        try {
            cursorQuery = zzj().query("events_snapshot", (String[]) arrayList.toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
            if (cursorQuery.moveToFirst()) {
                boolean z3 = false;
                z = false;
                do {
                    try {
                        String string = cursorQuery.getString(0);
                        if (cursorQuery.getLong(1) >= 1) {
                            if ("_f".equals(string)) {
                                z3 = true;
                            } else if ("_v".equals(string)) {
                                z = true;
                            }
                        }
                        if (string != null && (zzbdVarZzaA = zzaA("events_snapshot", str, string)) != null) {
                            zzaF("events", zzbdVarZzaA);
                        }
                    } catch (SQLiteException e) {
                        e = e;
                        z2 = z3;
                        try {
                            this.zzu.zzaW().zze().zzc("Error querying snapshot. appId", zzhe.zzn(str), e);
                            z3 = z2;
                        } catch (Throwable th) {
                            th = th;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            if (z2 && zzbdVarZzaA2 != null) {
                                zzaF("events", zzbdVarZzaA2);
                            } else if (!z && zzbdVarZzaA3 != null) {
                                zzaF("events", zzbdVarZzaA3);
                            }
                            zzaE("events_snapshot", str);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        z2 = z3;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        if (z2) {
                            if (!z) {
                                zzaF("events", zzbdVarZzaA3);
                            }
                        } else if (!z) {
                            zzaF("events", zzbdVarZzaA3);
                        }
                        zzaE("events_snapshot", str);
                        throw th;
                    }
                } while (cursorQuery.moveToNext());
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (!z3 && zzbdVarZzaA2 != null) {
                    zzaF("events", zzbdVarZzaA2);
                } else if (!z && zzbdVarZzaA3 != null) {
                    zzaF("events", zzbdVarZzaA3);
                }
            } else {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (zzbdVarZzaA2 != null) {
                    zzaF("events", zzbdVarZzaA2);
                } else if (zzbdVarZzaA3 != null) {
                    zzaF("events", zzbdVarZzaA3);
                }
            }
        } catch (SQLiteException e2) {
            e = e2;
            z = false;
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
        zzaE("events_snapshot", str);
    }

    final void zzR(String str, List list) {
        Iterator it;
        boolean z;
        String str2 = "app_id=? and audience_id=?";
        Preconditions.checkNotNull(list);
        int i = 0;
        while (i < list.size()) {
            com.google.android.gms.internal.measurement.zzfg zzfgVar = (com.google.android.gms.internal.measurement.zzfg) ((com.google.android.gms.internal.measurement.zzfh) list.get(i)).zzch();
            if (zzfgVar.zza() != 0) {
                int i2 = 0;
                while (i2 < zzfgVar.zza()) {
                    com.google.android.gms.internal.measurement.zzfi zzfiVar = (com.google.android.gms.internal.measurement.zzfi) zzfgVar.zze(i2).zzch();
                    com.google.android.gms.internal.measurement.zzfi zzfiVar2 = (com.google.android.gms.internal.measurement.zzfi) zzfiVar.clone();
                    String strZzb = zzjy.zzb(zzfiVar.zze());
                    if (strZzb != null) {
                        zzfiVar2.zzb(strZzb);
                        z = true;
                    } else {
                        z = false;
                    }
                    int i3 = 0;
                    while (i3 < zzfiVar.zza()) {
                        com.google.android.gms.internal.measurement.zzfl zzflVarZzd = zzfiVar.zzd(i3);
                        com.google.android.gms.internal.measurement.zzfi zzfiVar3 = zzfiVar;
                        String str3 = str2;
                        String strZzb2 = zzmg.zzb(zzflVarZzd.zze(), zzjz.zza, zzjz.zzb);
                        if (strZzb2 != null) {
                            com.google.android.gms.internal.measurement.zzfk zzfkVar = (com.google.android.gms.internal.measurement.zzfk) zzflVarZzd.zzch();
                            zzfkVar.zza(strZzb2);
                            zzfiVar2.zzc(i3, (com.google.android.gms.internal.measurement.zzfl) zzfkVar.zzba());
                            z = true;
                        }
                        i3++;
                        zzfiVar = zzfiVar3;
                        str2 = str3;
                    }
                    String str4 = str2;
                    if (z) {
                        zzfgVar.zzc(i2, zzfiVar2);
                        list.set(i, (com.google.android.gms.internal.measurement.zzfh) zzfgVar.zzba());
                    }
                    i2++;
                    str2 = str4;
                }
            }
            String str5 = str2;
            if (zzfgVar.zzb() != 0) {
                for (int i4 = 0; i4 < zzfgVar.zzb(); i4++) {
                    com.google.android.gms.internal.measurement.zzfr zzfrVarZzf = zzfgVar.zzf(i4);
                    String strZzb3 = zzmg.zzb(zzfrVarZzf.zze(), zzka.zza, zzka.zzb);
                    if (strZzb3 != null) {
                        com.google.android.gms.internal.measurement.zzfq zzfqVar = (com.google.android.gms.internal.measurement.zzfq) zzfrVarZzf.zzch();
                        zzfqVar.zza(strZzb3);
                        zzfgVar.zzd(i4, zzfqVar);
                        list.set(i, (com.google.android.gms.internal.measurement.zzfh) zzfgVar.zzba());
                    }
                }
            }
            i++;
            str2 = str5;
        }
        String str6 = str2;
        zzav();
        zzg();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        SQLiteDatabase sQLiteDatabaseZzj = zzj();
        sQLiteDatabaseZzj.beginTransaction();
        try {
            zzav();
            zzg();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase sQLiteDatabaseZzj2 = zzj();
            sQLiteDatabaseZzj2.delete("property_filters", "app_id=?", new String[]{str});
            sQLiteDatabaseZzj2.delete("event_filters", "app_id=?", new String[]{str});
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                com.google.android.gms.internal.measurement.zzfh zzfhVar = (com.google.android.gms.internal.measurement.zzfh) it2.next();
                zzav();
                zzg();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zzfhVar);
                if (zzfhVar.zzk()) {
                    int iZza = zzfhVar.zza();
                    Iterator it3 = zzfhVar.zzg().iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            if (!((com.google.android.gms.internal.measurement.zzfj) it3.next()).zzp()) {
                                this.zzu.zzaW().zzk().zzc("Event filter with no ID. Audience definition ignored. appId, audienceId", zzhe.zzn(str), Integer.valueOf(iZza));
                                break;
                            }
                        } else {
                            Iterator it4 = zzfhVar.zzh().iterator();
                            while (true) {
                                if (!it4.hasNext()) {
                                    Iterator it5 = zzfhVar.zzg().iterator();
                                    while (true) {
                                        if (!it5.hasNext()) {
                                            it = it2;
                                            Iterator it6 = zzfhVar.zzh().iterator();
                                            while (it6.hasNext()) {
                                                com.google.android.gms.internal.measurement.zzfr zzfrVar = (com.google.android.gms.internal.measurement.zzfr) it6.next();
                                                zzav();
                                                zzg();
                                                Preconditions.checkNotEmpty(str);
                                                Preconditions.checkNotNull(zzfrVar);
                                                if (zzfrVar.zze().isEmpty()) {
                                                    this.zzu.zzaW().zzk().zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzhe.zzn(str), Integer.valueOf(iZza), String.valueOf(zzfrVar.zzj() ? Integer.valueOf(zzfrVar.zza()) : null));
                                                } else {
                                                    byte[] bArrZzcd = zzfrVar.zzcd();
                                                    ContentValues contentValues = new ContentValues();
                                                    contentValues.put("app_id", str);
                                                    contentValues.put("audience_id", Integer.valueOf(iZza));
                                                    contentValues.put("filter_id", zzfrVar.zzj() ? Integer.valueOf(zzfrVar.zza()) : null);
                                                    Iterator it7 = it6;
                                                    contentValues.put("property_name", zzfrVar.zze());
                                                    contentValues.put("session_scoped", zzfrVar.zzk() ? Boolean.valueOf(zzfrVar.zzi()) : null);
                                                    contentValues.put("data", bArrZzcd);
                                                    try {
                                                        if (zzj().insertWithOnConflict("property_filters", null, contentValues, 5) == -1) {
                                                            this.zzu.zzaW().zze().zzb("Failed to insert property filter (got -1). appId", zzhe.zzn(str));
                                                        } else {
                                                            it6 = it7;
                                                        }
                                                    } catch (SQLiteException e) {
                                                        this.zzu.zzaW().zze().zzc("Error storing property filter. appId", zzhe.zzn(str), e);
                                                    }
                                                }
                                            }
                                            break;
                                        }
                                        com.google.android.gms.internal.measurement.zzfj zzfjVar = (com.google.android.gms.internal.measurement.zzfj) it5.next();
                                        zzav();
                                        zzg();
                                        Preconditions.checkNotEmpty(str);
                                        Preconditions.checkNotNull(zzfjVar);
                                        if (!zzfjVar.zzg().isEmpty()) {
                                            byte[] bArrZzcd2 = zzfjVar.zzcd();
                                            it = it2;
                                            ContentValues contentValues2 = new ContentValues();
                                            contentValues2.put("app_id", str);
                                            contentValues2.put("audience_id", Integer.valueOf(iZza));
                                            contentValues2.put("filter_id", zzfjVar.zzp() ? Integer.valueOf(zzfjVar.zzb()) : null);
                                            contentValues2.put("event_name", zzfjVar.zzg());
                                            contentValues2.put("session_scoped", zzfjVar.zzq() ? Boolean.valueOf(zzfjVar.zzn()) : null);
                                            contentValues2.put("data", bArrZzcd2);
                                            try {
                                                if (zzj().insertWithOnConflict("event_filters", null, contentValues2, 5) == -1) {
                                                    this.zzu.zzaW().zze().zzb("Failed to insert event filter (got -1). appId", zzhe.zzn(str));
                                                }
                                                it2 = it;
                                            } catch (SQLiteException e2) {
                                                this.zzu.zzaW().zze().zzc("Error storing event filter. appId", zzhe.zzn(str), e2);
                                                zzav();
                                                zzg();
                                                Preconditions.checkNotEmpty(str);
                                                SQLiteDatabase sQLiteDatabaseZzj3 = zzj();
                                                String str7 = str6;
                                                sQLiteDatabaseZzj3.delete("property_filters", str7, new String[]{str, String.valueOf(iZza)});
                                                sQLiteDatabaseZzj3.delete("event_filters", str7, new String[]{str, String.valueOf(iZza)});
                                                str6 = str7;
                                                it2 = it;
                                                break;
                                            }
                                        } else {
                                            this.zzu.zzaW().zzk().zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzhe.zzn(str), Integer.valueOf(iZza), String.valueOf(zzfjVar.zzp() ? Integer.valueOf(zzfjVar.zzb()) : null));
                                            it = it2;
                                        }
                                        zzav();
                                        zzg();
                                        Preconditions.checkNotEmpty(str);
                                        SQLiteDatabase sQLiteDatabaseZzj4 = zzj();
                                        String str8 = str6;
                                        sQLiteDatabaseZzj4.delete("property_filters", str8, new String[]{str, String.valueOf(iZza)});
                                        sQLiteDatabaseZzj4.delete("event_filters", str8, new String[]{str, String.valueOf(iZza)});
                                        str6 = str8;
                                        break;
                                    }
                                    it2 = it;
                                    break;
                                }
                                if (!((com.google.android.gms.internal.measurement.zzfr) it4.next()).zzj()) {
                                    this.zzu.zzaW().zzk().zzc("Property filter with no ID. Audience definition ignored. appId, audienceId", zzhe.zzn(str), Integer.valueOf(iZza));
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    this.zzu.zzaW().zzk().zzb("Audience with no ID. appId", zzhe.zzn(str));
                }
            }
            ArrayList arrayList = new ArrayList();
            Iterator it8 = list.iterator();
            while (it8.hasNext()) {
                com.google.android.gms.internal.measurement.zzfh zzfhVar2 = (com.google.android.gms.internal.measurement.zzfh) it8.next();
                arrayList.add(zzfhVar2.zzk() ? Integer.valueOf(zzfhVar2.zza()) : null);
            }
            Preconditions.checkNotEmpty(str);
            zzav();
            zzg();
            SQLiteDatabase sQLiteDatabaseZzj5 = zzj();
            try {
                long jZzay = zzay("select count(1) from audience_filter_values where app_id=?", new String[]{str});
                int iMax = Math.max(0, Math.min(CredentialOption.PRIORITY_DEFAULT, this.zzu.zzf().zzh(str, zzgi.zzT)));
                if (jZzay > iMax) {
                    ArrayList arrayList2 = new ArrayList();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= arrayList.size()) {
                            sQLiteDatabaseZzj5.delete("audience_filter_values", "audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in " + ("(" + TextUtils.join(",", arrayList2) + ")") + " order by rowid desc limit -1 offset ?)", new String[]{str, Integer.toString(iMax)});
                            break;
                        }
                        Integer num = (Integer) arrayList.get(i5);
                        if (num == null) {
                            break;
                        }
                        arrayList2.add(Integer.toString(num.intValue()));
                        i5++;
                    }
                }
            } catch (SQLiteException e3) {
                this.zzu.zzaW().zze().zzc("Database error querying filters. appId", zzhe.zzn(str), e3);
            }
            sQLiteDatabaseZzj.setTransactionSuccessful();
            sQLiteDatabaseZzj.endTransaction();
        } catch (Throwable th) {
            sQLiteDatabaseZzj.endTransaction();
            throw th;
        }
    }

    public final void zzS() {
        zzav();
        zzj().setTransactionSuccessful();
    }

    public final void zzT(zzh zzhVar, boolean z, boolean z2) {
        Preconditions.checkNotNull(zzhVar);
        zzg();
        zzav();
        String strZzC = zzhVar.zzC();
        Preconditions.checkNotNull(strZzC);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", strZzC);
        if (z) {
            contentValues.put("app_instance_id", (String) null);
        } else if (this.zzg.zzu(strZzC).zzr(zzjw.ANALYTICS_STORAGE)) {
            contentValues.put("app_instance_id", zzhVar.zzD());
        }
        contentValues.put("gmp_app_id", zzhVar.zzH());
        zzpv zzpvVar = this.zzg;
        if (zzpvVar.zzu(strZzC).zzr(zzjw.AD_STORAGE)) {
            contentValues.put("resettable_device_id_hash", zzhVar.zzJ());
        }
        contentValues.put("last_bundle_index", Long.valueOf(zzhVar.zzt()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzhVar.zzu()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzhVar.zzs()));
        contentValues.put("app_version", zzhVar.zzF());
        contentValues.put("app_store", zzhVar.zzE());
        contentValues.put("gmp_version", Long.valueOf(zzhVar.zzq()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzhVar.zzn()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzhVar.zzaJ()));
        contentValues.put("day", Long.valueOf(zzhVar.zzm()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzhVar.zzk()));
        contentValues.put("daily_events_count", Long.valueOf(zzhVar.zzj()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzhVar.zzh()));
        contentValues.put("config_fetched_time", Long.valueOf(zzhVar.zzg()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzhVar.zzp()));
        contentValues.put("app_version_int", Long.valueOf(zzhVar.zze()));
        contentValues.put("firebase_instance_id", zzhVar.zzG());
        contentValues.put("daily_error_events_count", Long.valueOf(zzhVar.zzi()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzhVar.zzl()));
        contentValues.put("health_monitor_sample", zzhVar.zzI());
        contentValues.put("android_id", (Long) 0L);
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzhVar.zzaI()));
        contentValues.put("admob_app_id", zzhVar.zzA());
        contentValues.put("dynamite_version", Long.valueOf(zzhVar.zzo()));
        if (zzpvVar.zzu(strZzC).zzr(zzjw.ANALYTICS_STORAGE)) {
            contentValues.put("session_stitching_token", zzhVar.zzL());
        }
        contentValues.put("sgtm_upload_enabled", Boolean.valueOf(zzhVar.zzaL()));
        contentValues.put("target_os_version", Long.valueOf(zzhVar.zzw()));
        contentValues.put("session_stitching_token_hash", Long.valueOf(zzhVar.zzv()));
        zzqr.zzb();
        zzio zzioVar = this.zzu;
        if (zzioVar.zzf().zzx(strZzC, zzgi.zzaV)) {
            contentValues.put("ad_services_version", Integer.valueOf(zzhVar.zza()));
            contentValues.put("attribution_eligibility_status", Long.valueOf(zzhVar.zzf()));
        }
        contentValues.put("unmatched_first_open_without_ad_id", Boolean.valueOf(zzhVar.zzaM()));
        contentValues.put("npa_metadata_value", zzhVar.zzx());
        contentValues.put("bundle_delivery_index", Long.valueOf(zzhVar.zzr()));
        contentValues.put("sgtm_preview_key", zzhVar.zzM());
        contentValues.put("dma_consent_state", Integer.valueOf(zzhVar.zzd()));
        contentValues.put("daily_realtime_dcu_count", Integer.valueOf(zzhVar.zzc()));
        contentValues.put("serialized_npa_metadata", zzhVar.zzK());
        if (zzioVar.zzf().zzx(strZzC, zzgi.zzaP)) {
            contentValues.put("client_upload_eligibility", Integer.valueOf(zzhVar.zzb()));
        }
        List listZzN = zzhVar.zzN();
        if (listZzN != null) {
            if (listZzN.isEmpty()) {
                zzioVar.zzaW().zzk().zzb("Safelisted events should not be an empty list. appId", strZzC);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", listZzN));
            }
        }
        com.google.android.gms.internal.measurement.zzpn.zzb();
        if (zzioVar.zzf().zzx(null, zzgi.zzaJ) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        contentValues.put("unmatched_pfo", zzhVar.zzy());
        contentValues.put("unmatched_uwa", zzhVar.zzz());
        contentValues.put("ad_campaign_info", zzhVar.zzaN());
        try {
            SQLiteDatabase sQLiteDatabaseZzj = zzj();
            if (sQLiteDatabaseZzj.update("apps", contentValues, "app_id = ?", new String[]{strZzC}) == 0 && sQLiteDatabaseZzj.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzioVar.zzaW().zze().zzb("Failed to insert/update app (got -1). appId", zzhe.zzn(strZzC));
            }
        } catch (SQLiteException e) {
            this.zzu.zzaW().zze().zzc("Error storing app. appId", zzhe.zzn(strZzC), e);
        }
    }

    public final void zzU(String str, zzba zzbaVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzbaVar);
        zzg();
        zzav();
        if (zzu(str) == zzjx.zza) {
            zzX(str, zzjx.zza);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("dma_consent_settings", zzbaVar.zzj());
        zzaG("consent_settings", "app_id", contentValues);
    }

    public final void zzV(zzbd zzbdVar) {
        zzaF("events", zzbdVar);
    }

    public final void zzW(String str, zzjx zzjxVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzjxVar);
        zzg();
        zzav();
        zzX(str, zzu(str));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("storage_consent_at_bundling", zzjxVar.zzq());
        zzaG("consent_settings", "app_id", contentValues);
    }

    public final void zzX(String str, zzjx zzjxVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzjxVar);
        zzg();
        zzav();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzjxVar.zzq());
        contentValues.put("consent_source", Integer.valueOf(zzjxVar.zzb()));
        zzaG("consent_settings", "app_id", contentValues);
    }

    public final boolean zzY(String str) {
        zzio zzioVar = this.zzu;
        if (zzioVar.zzf().zzx(null, zzgi.zzaM)) {
            if (zzioVar.zzf().zzx(null, zzgi.zzaP)) {
                zzmf[] zzmfVarArr = {zzmf.GOOGLE_SIGNAL};
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(Integer.valueOf(zzmfVarArr[0].zza()));
                String strZzaH = zzaH(arrayList);
                String strZzaC = zzaC();
                StringBuilder sb = new StringBuilder("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=?");
                sb.append(strZzaH);
                sb.append(" AND NOT ");
                sb.append(strZzaC);
                return zzay(sb.toString(), new String[]{str}) != 0;
            }
            if (zzay("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=? AND NOT ".concat(zzaC()), new String[]{str}) != 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean zzZ(String str, String str2) {
        return zzay("select count(1) from raw_events where app_id = ? and name = ?", new String[]{str, str2}) > 0;
    }

    public final int zza(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzav();
        try {
            return zzj().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzio zzioVar = this.zzu;
            zzioVar.zzaW().zze().zzd("Error deleting conditional property", zzhe.zzn(str), zzioVar.zzj().zzf(str2), e);
            return 0;
        }
    }

    public final boolean zzaa() {
        return zzay("select count(1) > 0 from raw_events", null) != 0;
    }

    public final boolean zzab() {
        return zzay("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    public final boolean zzac() {
        return zzay("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    public final boolean zzad(String str, zzov zzovVar) {
        zzg();
        zzav();
        Preconditions.checkNotNull(zzovVar);
        Preconditions.checkNotEmpty(str);
        zzio zzioVar = this.zzu;
        long jCurrentTimeMillis = zzioVar.zzaU().currentTimeMillis();
        long jLongValue = jCurrentTimeMillis - ((Long) zzgi.zzau.zza(null)).longValue();
        long j = zzovVar.zzb;
        if (j < jLongValue || j > ((Long) zzgi.zzau.zza(null)).longValue() + jCurrentTimeMillis) {
            zzioVar.zzaW().zzk().zzd("Storing trigger URI outside of the max retention time span. appId, now, timestamp", zzhe.zzn(str), Long.valueOf(jCurrentTimeMillis), Long.valueOf(j));
        }
        zzioVar.zzaW().zzj().zza("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("trigger_uri", zzovVar.zza);
        contentValues.put("source", Integer.valueOf(zzovVar.zzc));
        contentValues.put("timestamp_millis", Long.valueOf(j));
        try {
            if (zzj().insert("trigger_uris", null, contentValues) != -1) {
                return true;
            }
            zzioVar.zzaW().zze().zzb("Failed to insert trigger URI (got -1). appId", zzhe.zzn(str));
            return false;
        } catch (SQLiteException e) {
            this.zzu.zzaW().zze().zzc("Error storing trigger URI. appId", zzhe.zzn(str), e);
            return false;
        }
    }

    protected final boolean zzae() {
        zzio zzioVar = this.zzu;
        Context contextZzaT = zzioVar.zzaT();
        zzioVar.zzf();
        return contextZzaT.getDatabasePath("google_app_measurement.db").exists();
    }

    public final boolean zzaf(String str, Long l, long j, com.google.android.gms.internal.measurement.zzhm zzhmVar) {
        zzg();
        zzav();
        Preconditions.checkNotNull(zzhmVar);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        zzio zzioVar = this.zzu;
        byte[] bArrZzcd = zzhmVar.zzcd();
        zzioVar.zzaW().zzj().zzc("Saving complex main event, appId, data size", zzioVar.zzj().zzd(str), Integer.valueOf(bArrZzcd.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", bArrZzcd);
        try {
            if (zzj().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzioVar.zzaW().zze().zzb("Failed to insert complex main event (got -1). appId", zzhe.zzn(str));
            return false;
        } catch (SQLiteException e) {
            this.zzu.zzaW().zze().zzc("Error storing complex main event. appId", zzhe.zzn(str), e);
            return false;
        }
    }

    final boolean zzag(String str, long j) {
        zzio zzioVar = this.zzu;
        if (!zzioVar.zzf().zzx(null, zzgi.zzbe) && zzioVar.zzaU().currentTimeMillis() > 15000 + j) {
            return false;
        }
        try {
            return zzaz("select count(*) from raw_events where app_id=? and timestamp >= ? and name not like '!_%' escape '!' limit 1;", new String[]{str, String.valueOf(j)}, 0L) <= 0 && zzaz("select count(*) from raw_events where app_id=? and timestamp >= ? and name like '!_%' escape '!' limit 1;", new String[]{str, String.valueOf(j)}, 0L) > 0;
        } catch (SQLiteException e) {
            this.zzu.zzaW().zze().zzb("Error checking backfill conditions", e);
            return false;
        }
    }

    public final boolean zzah(zzai zzaiVar) {
        Preconditions.checkNotNull(zzaiVar);
        zzg();
        zzav();
        String str = zzaiVar.zza;
        Preconditions.checkNotNull(str);
        if (zzy(str, zzaiVar.zzc.zzb) == null) {
            long jZzay = zzay("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            this.zzu.zzf();
            if (jZzay >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzaiVar.zzb);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzaiVar.zzc.zzb);
        zzau(contentValues, "value", Preconditions.checkNotNull(zzaiVar.zzc.zza()));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.valueOf(zzaiVar.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzaiVar.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzaiVar.zzh));
        zzio zzioVar = this.zzu;
        contentValues.put("timed_out_event", zzioVar.zzw().zzay(zzaiVar.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzaiVar.zzd));
        contentValues.put("triggered_event", zzioVar.zzw().zzay(zzaiVar.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzaiVar.zzc.zzc));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzaiVar.zzj));
        contentValues.put("expired_event", zzioVar.zzw().zzay(zzaiVar.zzk));
        try {
            if (zzj().insertWithOnConflict("conditional_properties", null, contentValues, 5) != -1) {
                return true;
            }
            zzioVar.zzaW().zze().zzb("Failed to insert/update conditional user property (got -1)", zzhe.zzn(str));
            return true;
        } catch (SQLiteException e) {
            this.zzu.zzaW().zze().zzc("Error storing conditional user property", zzhe.zzn(str), e);
            return true;
        }
    }

    public final boolean zzai(zzqd zzqdVar) {
        Preconditions.checkNotNull(zzqdVar);
        zzg();
        zzav();
        String str = zzqdVar.zza;
        String str2 = zzqdVar.zzc;
        if (zzy(str, str2) == null) {
            if (zzqf.zzaq(str2)) {
                if (zzay("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{str}) >= this.zzu.zzf().zzi(str, zzgi.zzU, 25, 100)) {
                    return false;
                }
            } else if (!"_npa".equals(str2)) {
                long jZzay = zzay("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{str, zzqdVar.zzb});
                this.zzu.zzf();
                if (jZzay >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzqdVar.zzb);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, str2);
        contentValues.put("set_timestamp", Long.valueOf(zzqdVar.zzd));
        zzau(contentValues, "value", zzqdVar.zze);
        try {
            if (zzj().insertWithOnConflict("user_attributes", null, contentValues, 5) != -1) {
                return true;
            }
            this.zzu.zzaW().zze().zzb("Failed to insert/update user property (got -1). appId", zzhe.zzn(str));
            return true;
        } catch (SQLiteException e) {
            this.zzu.zzaW().zze().zzc("Error storing user property. appId", zzhe.zzn(zzqdVar.zza), e);
            return true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00d5 A[Catch: SQLiteException -> 0x006b, all -> 0x006e, TryCatch #3 {SQLiteException -> 0x006b, blocks: (B:16:0x0063, B:33:0x00ae, B:35:0x00d5, B:36:0x00ea, B:37:0x00ee, B:38:0x00fe, B:40:0x0104, B:41:0x0117, B:43:0x0126, B:45:0x0143, B:47:0x0172, B:48:0x017a, B:50:0x0185, B:55:0x01b7, B:54:0x01a2, B:58:0x01be, B:44:0x0139, B:60:0x01d3), top: B:76:0x0063 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00ea A[Catch: SQLiteException -> 0x006b, all -> 0x006e, TRY_LEAVE, TryCatch #3 {SQLiteException -> 0x006b, blocks: (B:16:0x0063, B:33:0x00ae, B:35:0x00d5, B:36:0x00ea, B:37:0x00ee, B:38:0x00fe, B:40:0x0104, B:41:0x0117, B:43:0x0126, B:45:0x0143, B:47:0x0172, B:48:0x017a, B:50:0x0185, B:55:0x01b7, B:54:0x01a2, B:58:0x01be, B:44:0x0139, B:60:0x01d3), top: B:76:0x0063 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x0104 A[Catch: SQLiteException -> 0x006b, all -> 0x006e, TryCatch #3 {SQLiteException -> 0x006b, blocks: (B:16:0x0063, B:33:0x00ae, B:35:0x00d5, B:36:0x00ea, B:37:0x00ee, B:38:0x00fe, B:40:0x0104, B:41:0x0117, B:43:0x0126, B:45:0x0143, B:47:0x0172, B:48:0x017a, B:50:0x0185, B:55:0x01b7, B:54:0x01a2, B:58:0x01be, B:44:0x0139, B:60:0x01d3), top: B:76:0x0063 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x0126 A[Catch: SQLiteException -> 0x006b, all -> 0x006e, TryCatch #3 {SQLiteException -> 0x006b, blocks: (B:16:0x0063, B:33:0x00ae, B:35:0x00d5, B:36:0x00ea, B:37:0x00ee, B:38:0x00fe, B:40:0x0104, B:41:0x0117, B:43:0x0126, B:45:0x0143, B:47:0x0172, B:48:0x017a, B:50:0x0185, B:55:0x01b7, B:54:0x01a2, B:58:0x01be, B:44:0x0139, B:60:0x01d3), top: B:76:0x0063 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x0139 A[Catch: SQLiteException -> 0x006b, all -> 0x006e, TryCatch #3 {SQLiteException -> 0x006b, blocks: (B:16:0x0063, B:33:0x00ae, B:35:0x00d5, B:36:0x00ea, B:37:0x00ee, B:38:0x00fe, B:40:0x0104, B:41:0x0117, B:43:0x0126, B:45:0x0143, B:47:0x0172, B:48:0x017a, B:50:0x0185, B:55:0x01b7, B:54:0x01a2, B:58:0x01be, B:44:0x0139, B:60:0x01d3), top: B:76:0x0063 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x0172 A[Catch: SQLiteException -> 0x006b, all -> 0x006e, LOOP:0: B:47:0x0172->B:79:?, LOOP_START, TRY_LEAVE, TryCatch #3 {SQLiteException -> 0x006b, blocks: (B:16:0x0063, B:33:0x00ae, B:35:0x00d5, B:36:0x00ea, B:37:0x00ee, B:38:0x00fe, B:40:0x0104, B:41:0x0117, B:43:0x0126, B:45:0x0143, B:47:0x0172, B:48:0x017a, B:50:0x0185, B:55:0x01b7, B:54:0x01a2, B:58:0x01be, B:44:0x0139, B:60:0x01d3), top: B:76:0x0063 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x01b7 A[Catch: SQLiteException -> 0x006b, all -> 0x006e, TryCatch #3 {SQLiteException -> 0x006b, blocks: (B:16:0x0063, B:33:0x00ae, B:35:0x00d5, B:36:0x00ea, B:37:0x00ee, B:38:0x00fe, B:40:0x0104, B:41:0x0117, B:43:0x0126, B:45:0x0143, B:47:0x0172, B:48:0x017a, B:50:0x0185, B:55:0x01b7, B:54:0x01a2, B:58:0x01be, B:44:0x0139, B:60:0x01d3), top: B:76:0x0063 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x01be A[Catch: SQLiteException -> 0x006b, all -> 0x006e, TryCatch #3 {SQLiteException -> 0x006b, blocks: (B:16:0x0063, B:33:0x00ae, B:35:0x00d5, B:36:0x00ea, B:37:0x00ee, B:38:0x00fe, B:40:0x0104, B:41:0x0117, B:43:0x0126, B:45:0x0143, B:47:0x0172, B:48:0x017a, B:50:0x0185, B:55:0x01b7, B:54:0x01a2, B:58:0x01be, B:44:0x0139, B:60:0x01d3), top: B:76:0x0063 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x01a0 A[SYNTHETIC] */
    public final void zzat(String str, long j, long j2, zzpr zzprVar) {
        String string;
        String string2;
        char c;
        char c2;
        String[] strArr;
        String str2;
        long j3;
        com.google.android.gms.internal.measurement.zzhl zzhlVar;
        Preconditions.checkNotNull(zzprVar);
        zzg();
        zzav();
        Cursor cursorRawQuery = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseZzj = zzj();
                if (TextUtils.isEmpty(str)) {
                    cursorRawQuery = sQLiteDatabaseZzj.rawQuery("select app_id, metadata_fingerprint from raw_events where " + (j2 != -1 ? "rowid <= ? and " : "") + "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;", j2 != -1 ? new String[]{String.valueOf(j2), String.valueOf(j)} : new String[]{String.valueOf(j)});
                    if (cursorRawQuery.moveToFirst()) {
                        string = cursorRawQuery.getString(0);
                        try {
                            string2 = cursorRawQuery.getString(1);
                            cursorRawQuery.close();
                            cursorRawQuery = sQLiteDatabaseZzj.query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{string, string2}, null, null, "rowid", "2");
                            if (cursorRawQuery.moveToFirst()) {
                                try {
                                    com.google.android.gms.internal.measurement.zzhx zzhxVar = (com.google.android.gms.internal.measurement.zzhx) ((com.google.android.gms.internal.measurement.zzhw) zzqa.zzp(com.google.android.gms.internal.measurement.zzhx.zzz(), cursorRawQuery.getBlob(0))).zzba();
                                    if (cursorRawQuery.moveToNext()) {
                                        this.zzu.zzaW().zzk().zzb("Get multiple raw event metadata records, expected one. appId", zzhe.zzn(string));
                                    }
                                    cursorRawQuery.close();
                                    Preconditions.checkNotNull(zzhxVar);
                                    zzprVar.zza = zzhxVar;
                                    if (j2 != -1) {
                                        c2 = 1;
                                        c = 2;
                                        str2 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
                                        strArr = new String[]{string, string2, String.valueOf(j2)};
                                    } else {
                                        c = 2;
                                        c2 = 1;
                                        strArr = new String[]{string, string2};
                                        str2 = "app_id = ? and metadata_fingerprint = ?";
                                    }
                                    String[] strArr2 = new String[4];
                                    strArr2[0] = "rowid";
                                    strArr2[c2] = AppMeasurementSdk.ConditionalUserProperty.NAME;
                                    strArr2[c] = "timestamp";
                                    strArr2[3] = "data";
                                    cursorRawQuery = sQLiteDatabaseZzj.query("raw_events", strArr2, str2, strArr, null, null, "rowid", null);
                                    if (cursorRawQuery.moveToFirst()) {
                                        do {
                                            j3 = cursorRawQuery.getLong(0);
                                            try {
                                                zzhlVar = (com.google.android.gms.internal.measurement.zzhl) zzqa.zzp(com.google.android.gms.internal.measurement.zzhm.zze(), cursorRawQuery.getBlob(3));
                                                zzhlVar.zzi(cursorRawQuery.getString(1));
                                                zzhlVar.zzm(cursorRawQuery.getLong(2));
                                                if (!zzprVar.zza(j3, (com.google.android.gms.internal.measurement.zzhm) zzhlVar.zzba())) {
                                                    break;
                                                }
                                            } catch (IOException e) {
                                                this.zzu.zzaW().zze().zzc("Data loss. Failed to merge raw event. appId", zzhe.zzn(string), e);
                                            }
                                        } while (cursorRawQuery.moveToNext());
                                    } else {
                                        this.zzu.zzaW().zzk().zzb("Raw event data disappeared while in transaction. appId", zzhe.zzn(string));
                                    }
                                } catch (IOException e2) {
                                    this.zzu.zzaW().zze().zzc("Data loss. Failed to merge raw event metadata. appId", zzhe.zzn(string), e2);
                                }
                            } else {
                                this.zzu.zzaW().zze().zzb("Raw event metadata record is missing. appId", zzhe.zzn(string));
                            }
                        } catch (SQLiteException e3) {
                            e = e3;
                            this.zzu.zzaW().zze().zzc("Data loss. Error selecting raw event. appId", zzhe.zzn(string), e);
                        }
                    }
                } else {
                    cursorRawQuery = sQLiteDatabaseZzj.rawQuery("select metadata_fingerprint from raw_events where app_id = ?" + (j2 != -1 ? " and rowid <= ?" : "") + " order by rowid limit 1;", j2 != -1 ? new String[]{str, String.valueOf(j2)} : new String[]{str});
                    if (cursorRawQuery.moveToFirst()) {
                        string2 = cursorRawQuery.getString(0);
                        cursorRawQuery.close();
                        string = str;
                        cursorRawQuery = sQLiteDatabaseZzj.query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{string, string2}, null, null, "rowid", "2");
                        if (cursorRawQuery.moveToFirst()) {
                            this.zzu.zzaW().zze().zzb("Raw event metadata record is missing. appId", zzhe.zzn(string));
                        } else {
                            com.google.android.gms.internal.measurement.zzhx zzhxVar2 = (com.google.android.gms.internal.measurement.zzhx) ((com.google.android.gms.internal.measurement.zzhw) zzqa.zzp(com.google.android.gms.internal.measurement.zzhx.zzz(), cursorRawQuery.getBlob(0))).zzba();
                            if (cursorRawQuery.moveToNext()) {
                                this.zzu.zzaW().zzk().zzb("Get multiple raw event metadata records, expected one. appId", zzhe.zzn(string));
                            }
                            cursorRawQuery.close();
                            Preconditions.checkNotNull(zzhxVar2);
                            zzprVar.zza = zzhxVar2;
                            if (j2 != -1) {
                                c2 = 1;
                                c = 2;
                                str2 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
                                strArr = new String[]{string, string2, String.valueOf(j2)};
                            } else {
                                c = 2;
                                c2 = 1;
                                strArr = new String[]{string, string2};
                                str2 = "app_id = ? and metadata_fingerprint = ?";
                            }
                            String[] strArr3 = new String[4];
                            strArr3[0] = "rowid";
                            strArr3[c2] = AppMeasurementSdk.ConditionalUserProperty.NAME;
                            strArr3[c] = "timestamp";
                            strArr3[3] = "data";
                            cursorRawQuery = sQLiteDatabaseZzj.query("raw_events", strArr3, str2, strArr, null, null, "rowid", null);
                            if (cursorRawQuery.moveToFirst()) {
                                do {
                                    j3 = cursorRawQuery.getLong(0);
                                    zzhlVar = (com.google.android.gms.internal.measurement.zzhl) zzqa.zzp(com.google.android.gms.internal.measurement.zzhm.zze(), cursorRawQuery.getBlob(3));
                                    zzhlVar.zzi(cursorRawQuery.getString(1));
                                    zzhlVar.zzm(cursorRawQuery.getLong(2));
                                    if (!zzprVar.zza(j3, (com.google.android.gms.internal.measurement.zzhm) zzhlVar.zzba())) {
                                        break;
                                        break;
                                    }
                                } while (cursorRawQuery.moveToNext());
                            } else {
                                this.zzu.zzaW().zzk().zzb("Raw event data disappeared while in transaction. appId", zzhe.zzn(string));
                            }
                        }
                    }
                }
            } finally {
                if (0 != 0) {
                    cursorRawQuery.close();
                }
            }
        } catch (SQLiteException e4) {
            e = e4;
            string = str;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzpg
    protected final boolean zzb() {
        return false;
    }

    public final long zzd(String str, com.google.android.gms.internal.measurement.zzhv zzhvVar, String str2, Map map, zzmf zzmfVar, Long l) {
        int iDelete;
        zzg();
        zzav();
        Preconditions.checkNotNull(zzhvVar);
        Preconditions.checkNotEmpty(str);
        zzio zzioVar = this.zzu;
        if (zzioVar.zzf().zzx(null, zzgi.zzaM)) {
            zzg();
            zzav();
            if (zzae()) {
                zzpv zzpvVar = this.zzg;
                long jZza = zzpvVar.zzw().zzb.zza();
                long jElapsedRealtime = zzioVar.zzaU().elapsedRealtime();
                long jAbs = Math.abs(jElapsedRealtime - jZza);
                zzioVar.zzf();
                if (jAbs > zzam.zzJ()) {
                    zzpvVar.zzw().zzb.zzb(jElapsedRealtime);
                    zzg();
                    zzav();
                    if (zzae() && (iDelete = zzj().delete("upload_queue", zzaC(), new String[0])) > 0) {
                        zzioVar.zzaW().zzj().zzb("Deleted stale MeasurementBatch rows from upload_queue. rowsDeleted", Integer.valueOf(iDelete));
                    }
                    if (zzioVar.zzf().zzx(null, zzgi.zzaP)) {
                        Preconditions.checkNotEmpty(str);
                        zzg();
                        zzav();
                        try {
                            int iZzh = zzioVar.zzf().zzh(str, zzgi.zzz);
                            if (iZzh > 0) {
                                zzj().delete("upload_queue", "rowid in (SELECT rowid FROM upload_queue WHERE app_id=? ORDER BY rowid DESC LIMIT -1 OFFSET ?)", new String[]{str, String.valueOf(iZzh)});
                            }
                        } catch (SQLiteException e) {
                            this.zzu.zzaW().zze().zzc("Error deleting over the limit queued batches. appId", zzhe.zzn(str), e);
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(((String) entry.getKey()) + "=" + ((String) entry.getValue()));
            }
            byte[] bArrZzcd = zzhvVar.zzcd();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("measurement_batch", bArrZzcd);
            contentValues.put("upload_uri", str2);
            StringBuilder sb = new StringBuilder();
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                while (true) {
                    sb.append((CharSequence) it.next());
                    if (!it.hasNext()) {
                        break;
                    }
                    sb.append((CharSequence) "\r\n");
                }
            }
            contentValues.put("upload_headers", sb.toString());
            contentValues.put("upload_type", Integer.valueOf(zzmfVar.zza()));
            zzio zzioVar2 = this.zzu;
            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzioVar2.zzaU().currentTimeMillis()));
            contentValues.put("retry_count", (Integer) 0);
            if (l != null) {
                contentValues.put("associated_row_id", l);
            }
            try {
                long jInsert = zzj().insert("upload_queue", null, contentValues);
                if (jInsert != -1) {
                    return jInsert;
                }
                zzioVar2.zzaW().zze().zzb("Failed to insert MeasurementBatch (got -1) to upload_queue. appId", str);
                return -1L;
            } catch (SQLiteException e2) {
                this.zzu.zzaW().zze().zzc("Error storing MeasurementBatch to upload_queue. appId", str, e2);
            }
        }
        return -1L;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0080 A[Catch: SQLiteException -> 0x0098, all -> 0x00b6, TryCatch #0 {SQLiteException -> 0x0098, blocks: (B:11:0x005f, B:13:0x0080, B:14:0x0094), top: B:27:0x005f }] */
    /* JADX WARN: Code duplicated, block: B:14:0x0094 A[Catch: SQLiteException -> 0x0098, all -> 0x00b6, TRY_LEAVE, TryCatch #0 {SQLiteException -> 0x0098, blocks: (B:11:0x005f, B:13:0x0080, B:14:0x0094), top: B:27:0x005f }] */
    protected final long zze(String str, String str2) {
        SQLiteException e;
        long jZzaz;
        long j;
        ContentValues contentValues;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty("first_open_count");
        zzg();
        zzav();
        SQLiteDatabase sQLiteDatabaseZzj = zzj();
        sQLiteDatabaseZzj.beginTransaction();
        try {
            try {
                j = -1;
                jZzaz = zzaz("select first_open_count from app2 where app_id=?", new String[]{str}, -1L);
                if (jZzaz == -1) {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("app_id", str);
                    contentValues2.put("first_open_count", (Integer) 0);
                    contentValues2.put("previous_install_count", (Integer) 0);
                    if (sQLiteDatabaseZzj.insertWithOnConflict("app2", null, contentValues2, 5) == -1) {
                        this.zzu.zzaW().zze().zzc("Failed to insert column (got -1). appId", zzhe.zzn(str), "first_open_count");
                    } else {
                        jZzaz = 0;
                        try {
                            contentValues = new ContentValues();
                            contentValues.put("app_id", str);
                            contentValues.put("first_open_count", Long.valueOf(1 + jZzaz));
                            if (sQLiteDatabaseZzj.update("app2", contentValues, "app_id = ?", new String[]{str}) == 0) {
                                this.zzu.zzaW().zze().zzc("Failed to update column (got 0). appId", zzhe.zzn(str), "first_open_count");
                            } else {
                                sQLiteDatabaseZzj.setTransactionSuccessful();
                                j = jZzaz;
                            }
                        } catch (SQLiteException e2) {
                            e = e2;
                            this.zzu.zzaW().zze().zzd("Error inserting column. appId", zzhe.zzn(str), "first_open_count", e);
                        }
                    }
                } else {
                    contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("first_open_count", Long.valueOf(1 + jZzaz));
                    if (sQLiteDatabaseZzj.update("app2", contentValues, "app_id = ?", new String[]{str}) == 0) {
                        this.zzu.zzaW().zze().zzc("Failed to update column (got 0). appId", zzhe.zzn(str), "first_open_count");
                    } else {
                        sQLiteDatabaseZzj.setTransactionSuccessful();
                        j = jZzaz;
                    }
                }
            } finally {
                sQLiteDatabaseZzj.endTransaction();
            }
        } catch (SQLiteException e3) {
            e = e3;
            jZzaz = 0;
        }
        return j;
    }

    public final long zzf() {
        return zzaz("select max(bundle_end_timestamp) from queue", null, 0L);
    }

    public final long zzh() {
        return zzaz("select max(timestamp) from raw_events", null, 0L);
    }

    public final long zzi(String str) {
        Preconditions.checkNotEmpty(str);
        return zzaz("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    final SQLiteDatabase zzj() {
        zzg();
        try {
            return this.zzm.getWritableDatabase();
        } catch (SQLiteException e) {
            this.zzu.zzaW().zzk().zzb("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0087  */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0084: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:27:0x0084 */
    public final Bundle zzk(String str) throws Throwable {
        Cursor cursorRawQuery;
        Cursor cursor;
        zzg();
        zzav();
        Cursor cursor2 = null;
        try {
            try {
                cursorRawQuery = zzj().rawQuery("select parameters from default_event_params where app_id=?", new String[]{str});
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        try {
                            com.google.android.gms.internal.measurement.zzhm zzhmVar = (com.google.android.gms.internal.measurement.zzhm) ((com.google.android.gms.internal.measurement.zzhl) zzqa.zzp(com.google.android.gms.internal.measurement.zzhm.zze(), cursorRawQuery.getBlob(0))).zzba();
                            this.zzg.zzA();
                            Bundle bundleZzF = zzqa.zzF(zzhmVar.zzi());
                            if (cursorRawQuery != null) {
                                cursorRawQuery.close();
                            }
                            return bundleZzF;
                        } catch (IOException e) {
                            this.zzu.zzaW().zze().zzc("Failed to retrieve default event parameters. appId", zzhe.zzn(str), e);
                        }
                    } else {
                        this.zzu.zzaW().zzj().zza("Default event parameters not found");
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    this.zzu.zzaW().zze().zzb("Error selecting default event parameters", e);
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursorRawQuery = null;
            } catch (Throwable th) {
                th = th;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor2 = cursor;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:98:0x03d2  */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x03cf: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:96:0x03cf */
    public final zzh zzl(String str) throws Throwable {
        Cursor cursor;
        Cursor cursorQuery;
        Cursor cursor2;
        Boolean boolValueOf;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzav();
        try {
            try {
                cursorQuery = zzj().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count", "daily_realtime_events_count", "health_monitor_sample", "android_id", "adid_reporting_enabled", "admob_app_id", "dynamite_version", "safelisted_events", "ga_app_id", "session_stitching_token", "sgtm_upload_enabled", "target_os_version", "session_stitching_token_hash", "ad_services_version", "unmatched_first_open_without_ad_id", "npa_metadata_value", "attribution_eligibility_status", "sgtm_preview_key", "dma_consent_state", "daily_realtime_dcu_count", "bundle_delivery_index", "serialized_npa_metadata", "unmatched_pfo", "unmatched_uwa", "ad_campaign_info", "client_upload_eligibility"}, "app_id=?", new String[]{str}, null, null, null);
                try {
                    if (cursorQuery.moveToFirst()) {
                        zzpv zzpvVar = this.zzg;
                        zzh zzhVar = new zzh(zzpvVar.zzt(), str);
                        zzjx zzjxVarZzu = zzpvVar.zzu(str);
                        zzjw zzjwVar = zzjw.ANALYTICS_STORAGE;
                        if (zzjxVarZzu.zzr(zzjwVar)) {
                            zzhVar.zzV(cursorQuery.getString(0));
                        }
                        zzhVar.zzao(cursorQuery.getString(1));
                        if (zzpvVar.zzu(str).zzr(zzjw.AD_STORAGE)) {
                            zzhVar.zzax(cursorQuery.getString(2));
                        }
                        zzhVar.zzat(cursorQuery.getLong(3));
                        zzhVar.zzau(cursorQuery.getLong(4));
                        zzhVar.zzas(cursorQuery.getLong(5));
                        zzhVar.zzX(cursorQuery.getString(6));
                        zzhVar.zzW(cursorQuery.getString(7));
                        zzhVar.zzap(cursorQuery.getLong(8));
                        zzhVar.zzaj(cursorQuery.getLong(9));
                        zzhVar.zzav(cursorQuery.isNull(10) || cursorQuery.getInt(10) != 0);
                        zzhVar.zzai(cursorQuery.getLong(11));
                        zzhVar.zzaf(cursorQuery.getLong(12));
                        zzhVar.zzae(cursorQuery.getLong(13));
                        zzhVar.zzac(cursorQuery.getLong(14));
                        zzhVar.zzab(cursorQuery.getLong(15));
                        zzhVar.zzam(cursorQuery.getLong(16));
                        zzhVar.zzY(cursorQuery.isNull(17) ? -2147483648L : cursorQuery.getInt(17));
                        zzhVar.zzan(cursorQuery.getString(18));
                        zzhVar.zzad(cursorQuery.getLong(19));
                        zzhVar.zzah(cursorQuery.getLong(20));
                        zzhVar.zzaq(cursorQuery.getString(21));
                        zzhVar.zzU(cursorQuery.isNull(23) || cursorQuery.getInt(23) != 0);
                        zzhVar.zzS(cursorQuery.getString(24));
                        zzhVar.zzal(cursorQuery.isNull(25) ? 0L : cursorQuery.getLong(25));
                        if (!cursorQuery.isNull(26)) {
                            zzhVar.zzay(Arrays.asList(cursorQuery.getString(26).split(",", -1)));
                        }
                        if (zzpvVar.zzu(str).zzr(zzjwVar)) {
                            zzhVar.zzaA(cursorQuery.getString(28));
                        }
                        zzhVar.zzaD((cursorQuery.isNull(29) || cursorQuery.getInt(29) == 0) ? false : true);
                        zzhVar.zzar(cursorQuery.getLong(39));
                        zzhVar.zzaC(cursorQuery.getString(36));
                        zzhVar.zzaE(cursorQuery.getLong(30));
                        zzhVar.zzaB(cursorQuery.getLong(31));
                        zzqr.zzb();
                        zzio zzioVar = this.zzu;
                        if (zzioVar.zzf().zzx(str, zzgi.zzaV)) {
                            zzhVar.zzT(cursorQuery.getInt(32));
                            zzhVar.zzZ(cursorQuery.getLong(35));
                        }
                        zzhVar.zzaF((cursorQuery.isNull(33) || cursorQuery.getInt(33) == 0) ? false : true);
                        if (cursorQuery.isNull(34)) {
                            boolValueOf = null;
                        } else {
                            boolValueOf = Boolean.valueOf(cursorQuery.getInt(34) != 0);
                        }
                        zzhVar.zzaw(boolValueOf);
                        zzhVar.zzak(cursorQuery.getInt(37));
                        zzhVar.zzag(cursorQuery.getInt(38));
                        zzhVar.zzaz(cursorQuery.isNull(40) ? "" : (String) Preconditions.checkNotNull(cursorQuery.getString(40)));
                        if (!cursorQuery.isNull(41)) {
                            zzhVar.zzaG(Long.valueOf(cursorQuery.getLong(41)));
                        }
                        if (!cursorQuery.isNull(42)) {
                            zzhVar.zzaH(Long.valueOf(cursorQuery.getLong(42)));
                        }
                        zzhVar.zzR(cursorQuery.getBlob(43));
                        if (zzioVar.zzf().zzx(str, zzgi.zzaP) && !cursorQuery.isNull(44)) {
                            zzhVar.zzaa(cursorQuery.getInt(44));
                        }
                        zzhVar.zzO();
                        if (cursorQuery.moveToNext()) {
                            zzioVar.zzaW().zze().zzb("Got multiple records for app, expected one. appId", zzhe.zzn(str));
                        }
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return zzhVar;
                    }
                } catch (SQLiteException e) {
                    e = e;
                    this.zzu.zzaW().zze().zzc("Error querying app. appId", zzhe.zzn(str), e);
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursorQuery = null;
            } catch (Throwable th) {
                th = th;
                cursor = null;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
            if (cursorQuery == null) {
                return null;
            }
            cursorQuery.close();
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = cursor2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x014c  */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0149: MOVE (r9 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]), block:B:32:0x0149 */
    public final zzai zzm(String str, String str2) throws Throwable {
        Cursor cursor;
        Cursor cursorQuery;
        Cursor cursor2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzav();
        try {
            try {
                cursorQuery = zzj().query("conditional_properties", new String[]{"origin", "value", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(0);
                        if (string == null) {
                            string = "";
                        }
                        String str3 = string;
                        Object objZzz = zzz(cursorQuery, 1);
                        boolean z = cursorQuery.getInt(2) != 0;
                        String string2 = cursorQuery.getString(3);
                        long j = cursorQuery.getLong(4);
                        zzpv zzpvVar = this.zzg;
                        zzai zzaiVar = new zzai(str, str3, new zzqb(str2, cursorQuery.getLong(8), objZzz, str3), cursorQuery.getLong(6), z, string2, (zzbh) zzpvVar.zzA().zzi(cursorQuery.getBlob(5), zzbh.CREATOR), j, (zzbh) zzpvVar.zzA().zzi(cursorQuery.getBlob(7), zzbh.CREATOR), cursorQuery.getLong(9), (zzbh) zzpvVar.zzA().zzi(cursorQuery.getBlob(10), zzbh.CREATOR));
                        if (cursorQuery.moveToNext()) {
                            zzio zzioVar = this.zzu;
                            zzioVar.zzaW().zze().zzc("Got multiple records for conditional property, expected one", zzhe.zzn(str), zzioVar.zzj().zzf(str2));
                        }
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return zzaiVar;
                    }
                } catch (SQLiteException e) {
                    e = e;
                    zzio zzioVar2 = this.zzu;
                    zzioVar2.zzaW().zze().zzd("Error querying conditional property", zzhe.zzn(str), zzioVar2.zzj().zzf(str2), e);
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursorQuery = null;
            } catch (Throwable th) {
                th = th;
                cursor = null;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
            if (cursorQuery == null) {
                return null;
            }
            cursorQuery.close();
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = cursor2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x008d  */
    public final zzar zzn(String str) throws Throwable {
        SQLiteException e;
        Cursor cursorQuery;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzav();
        Cursor cursor = null;
        try {
            cursorQuery = zzj().query("apps", new String[]{"remote_config", "config_last_modified_time", "e_tag"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                try {
                    if (cursorQuery.moveToFirst()) {
                        byte[] blob = cursorQuery.getBlob(0);
                        String string = cursorQuery.getString(1);
                        String string2 = cursorQuery.getString(2);
                        if (cursorQuery.moveToNext()) {
                            this.zzu.zzaW().zze().zzb("Got multiple records for app config, expected one. appId", zzhe.zzn(str));
                        }
                        if (blob != null) {
                            zzar zzarVar = new zzar(blob, string, string2);
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return zzarVar;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                e = e2;
                this.zzu.zzaW().zze().zzc("Error querying remote config. appId", zzhe.zzn(str), e);
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    public final zzas zzo(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        return zzp(j, str, 1L, false, false, z3, false, z5, z6, z7);
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0169  */
    public final zzas zzp(long j, String str, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) throws Throwable {
        Cursor cursor;
        Cursor cursorQuery;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzav();
        String[] strArr = {str};
        zzas zzasVar = new zzas();
        try {
            SQLiteDatabase sQLiteDatabaseZzj = zzj();
            cursorQuery = sQLiteDatabaseZzj.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count", "daily_realtime_dcu_count", "daily_registered_triggers_count"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (cursorQuery.moveToFirst()) {
                    if (cursorQuery.getLong(0) == j) {
                        zzasVar.zzb = cursorQuery.getLong(1);
                        zzasVar.zza = cursorQuery.getLong(2);
                        zzasVar.zzc = cursorQuery.getLong(3);
                        zzasVar.zzd = cursorQuery.getLong(4);
                        zzasVar.zze = cursorQuery.getLong(5);
                        zzasVar.zzf = cursorQuery.getLong(6);
                        zzasVar.zzg = cursorQuery.getLong(7);
                    }
                    if (z) {
                        zzasVar.zzb += j2;
                    }
                    if (z2) {
                        zzasVar.zza += j2;
                    }
                    if (z3) {
                        zzasVar.zzc += j2;
                    }
                    if (z4) {
                        zzasVar.zzd += j2;
                    }
                    if (z5) {
                        zzasVar.zze += j2;
                    }
                    if (z6) {
                        zzasVar.zzf += j2;
                    }
                    if (z7) {
                        zzasVar.zzg += j2;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("day", Long.valueOf(j));
                    contentValues.put("daily_public_events_count", Long.valueOf(zzasVar.zza));
                    contentValues.put("daily_events_count", Long.valueOf(zzasVar.zzb));
                    contentValues.put("daily_conversions_count", Long.valueOf(zzasVar.zzc));
                    contentValues.put("daily_error_events_count", Long.valueOf(zzasVar.zzd));
                    contentValues.put("daily_realtime_events_count", Long.valueOf(zzasVar.zze));
                    contentValues.put("daily_realtime_dcu_count", Long.valueOf(zzasVar.zzf));
                    contentValues.put("daily_registered_triggers_count", Long.valueOf(zzasVar.zzg));
                    sQLiteDatabaseZzj.update("apps", contentValues, "app_id=?", strArr);
                } else {
                    this.zzu.zzaW().zzk().zzb("Not updating daily counts, app is not known. appId", zzhe.zzn(str));
                }
            } catch (SQLiteException e) {
                e = e;
                cursor = cursorQuery;
                try {
                    this.zzu.zzaW().zze().zzc("Error updating daily counts. appId", zzhe.zzn(str), e);
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
        } catch (SQLiteException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return zzasVar;
    }

    public final zzba zzq(String str) {
        Preconditions.checkNotNull(str);
        zzg();
        zzav();
        return zzba.zze(zzaD("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    final zzbd zzr(String str, com.google.android.gms.internal.measurement.zzhm zzhmVar, String str2) throws Throwable {
        zzbd zzbdVarZzaA = zzaA("events", str, zzhmVar.zzh());
        if (zzbdVarZzaA == null) {
            zzio zzioVar = this.zzu;
            zzioVar.zzaW().zzk().zzc("Event aggregate wasn't created during raw event logging. appId, event", zzhe.zzn(str), zzioVar.zzj().zzd(str2));
            return new zzbd(str, zzhmVar.zzh(), 1L, 1L, 1L, zzhmVar.zzd(), 0L, null, null, null, null);
        }
        long j = zzbdVarZzaA.zze + 1;
        long j2 = zzbdVarZzaA.zzd + 1;
        return new zzbd(zzbdVarZzaA.zza, zzbdVarZzaA.zzb, zzbdVarZzaA.zzc + 1, j2, j, zzbdVarZzaA.zzf, zzbdVarZzaA.zzg, zzbdVarZzaA.zzh, zzbdVarZzaA.zzi, zzbdVarZzaA.zzj, zzbdVarZzaA.zzk);
    }

    public final zzbd zzs(String str, String str2) {
        return zzaA("events", str, str2);
    }

    public final zzjx zzt(String str) {
        Preconditions.checkNotNull(str);
        zzg();
        zzav();
        return zzjx.zzk(zzaD("select storage_consent_at_bundling from consent_settings where app_id=? limit 1;", new String[]{str}, ""), 100);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0062  */
    /* JADX WARN: Code duplicated, block: B:25:0x0065 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x006a  */
    /* JADX WARN: Code duplicated, block: B:33:0x005d A[ExcSplitCross -> B:21:0x005d, PHI: r1
  0x005d: PHI (r1v8 com.google.android.gms.measurement.internal.zzjx) = (r1v7 com.google.android.gms.measurement.internal.zzjx), (r1v11 com.google.android.gms.measurement.internal.zzjx) binds: [B:10:0x003e, B:7:0x002d] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v8, types: [com.google.android.gms.measurement.internal.zzjx] */
    public final zzjx zzu(String str) throws Throwable {
        Throwable th;
        SQLiteException e;
        Cursor cursorRawQuery;
        Preconditions.checkNotNull(str);
        zzg();
        zzav();
        zzjx zzjxVar = {str};
        ?? r1 = 0;
        zzjxVarZzk = null;
        zzjxVarZzk = null;
        zzjxVarZzk = null;
        zzjx zzjxVarZzk = null;
        try {
            try {
                cursorRawQuery = zzj().rawQuery("select consent_state, consent_source from consent_settings where app_id=? limit 1;", zzjxVar);
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        zzjxVarZzk = zzjx.zzk(cursorRawQuery.getString(0), cursorRawQuery.getInt(1));
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                    } else {
                        this.zzu.zzaW().zzj().zza("No data found");
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    this.zzu.zzaW().zze().zzb("Error querying database.", e);
                    if (cursorRawQuery != null) {
                    }
                    zzjxVar = zzjxVarZzk;
                    if (zzjxVarZzk == null) {
                        return zzjx.zza;
                    }
                    return zzjxVarZzk;
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursorRawQuery = null;
            } catch (Throwable th2) {
                th = th2;
                if (r1 != 0) {
                    r1.close();
                }
                throw th;
            }
            zzjxVar = zzjxVarZzk;
            if (zzjxVarZzk == null) {
                return zzjx.zza;
            }
            return zzjxVarZzk;
        } catch (Throwable th3) {
            th = th3;
            r1 = zzjxVar;
            if (r1 != 0) {
                r1.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0131  */
    /* JADX WARN: Code duplicated, block: B:42:0x0138  */
    public final zzpz zzw(String str) throws Throwable {
        Cursor cursor;
        Cursor cursor2;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzav();
        zzio zzioVar = this.zzu;
        zzpz zzpzVar = null;
        if (!zzioVar.zzf().zzx(null, zzgi.zzaM)) {
            return null;
        }
        if (zzioVar.zzf().zzx(null, zzgi.zzaP)) {
            List listZzD = zzD(str, zzpc.zza(zzmf.GOOGLE_SIGNAL), 1);
            if (listZzD.isEmpty()) {
                return null;
            }
            return (zzpz) listZzD.get(0);
        }
        try {
            Cursor cursorQuery = zzj().query("upload_queue", new String[]{"rowId", "app_id", "measurement_batch", "upload_uri", "upload_headers", "upload_type", "retry_count", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "associated_row_id", "last_upload_timestamp"}, "app_id=? AND NOT " + zzaC(), new String[]{str}, null, null, "creation_timestamp ASC", "1");
            try {
                try {
                    if (!cursorQuery.moveToFirst()) {
                        zzpzVar = null;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return zzpzVar;
                    }
                    cursor2 = cursorQuery;
                    try {
                        zzpz zzpzVarZzaB = zzaB(str, cursorQuery.getLong(0), cursorQuery.getBlob(2), cursorQuery.getString(3), cursorQuery.getString(4), cursorQuery.getInt(5), cursorQuery.getInt(6), cursorQuery.getLong(7), cursorQuery.getLong(8), cursorQuery.getLong(9));
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        return zzpzVarZzaB;
                    } catch (SQLiteException e) {
                        e = e;
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursor2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                    this.zzu.zzaW().zze().zzc("Error to querying MeasurementBatch from upload_queue. appId", str, e);
                    cursorQuery = cursor;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return zzpzVar;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursor2 = cursorQuery;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursorQuery;
            }
            cursor = cursor2;
        } catch (SQLiteException e3) {
            e = e3;
            zzpzVar = null;
            cursor = null;
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x010e  */
    /* JADX WARN: Code duplicated, block: B:45:0x0115  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v5 */
    public final zzpz zzx(long j) throws Throwable {
        Object obj;
        zzpz zzpzVar;
        ?? r15;
        ?? r9;
        Cursor cursor;
        if (!this.zzu.zzf().zzx(null, zzgi.zzaP)) {
            return null;
        }
        zzg();
        zzav();
        try {
            try {
                Cursor cursorQuery = zzj().query("upload_queue", new String[]{"rowId", "app_id", "measurement_batch", "upload_uri", "upload_headers", "upload_type", "retry_count", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "associated_row_id", "last_upload_timestamp"}, "rowId=?", new String[]{String.valueOf(j)}, null, null, null, "1");
                try {
                    try {
                        if (!cursorQuery.moveToFirst()) {
                            zzpzVar = null;
                            if (r9 != 0) {
                                r9 = cursorQuery;
                                r9.close();
                            }
                            r9 = cursorQuery;
                            return zzpzVar;
                        }
                        cursor = cursorQuery;
                        zzpzVar = null;
                        try {
                            zzpz zzpzVarZzaB = zzaB((String) Preconditions.checkNotNull(cursorQuery.getString(1)), j, cursorQuery.getBlob(2), cursorQuery.getString(3), cursorQuery.getString(4), cursorQuery.getInt(5), cursorQuery.getInt(6), cursorQuery.getLong(7), cursorQuery.getLong(8), cursorQuery.getLong(9));
                            if (cursor != null) {
                                cursor.close();
                            }
                            return zzpzVarZzaB;
                        } catch (SQLiteException e) {
                            e = e;
                        } catch (Throwable th) {
                            th = th;
                            r15 = cursor;
                            if (r15 != 0) {
                                r15.close();
                            }
                            throw th;
                        }
                        this.zzu.zzaW().zze().zzc("Error to querying MeasurementBatch from upload_queue. rowId", Long.valueOf(j), e);
                        r9 = r15;
                        if (r9 != 0) {
                            r9 = cursorQuery;
                            r9.close();
                        }
                        r9 = cursorQuery;
                        return zzpzVar;
                    } catch (Throwable th2) {
                        th = th2;
                        if (r15 != 0) {
                            r15.close();
                        }
                        throw th;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    cursor = cursorQuery;
                    zzpzVar = null;
                } catch (Throwable th3) {
                    th = th3;
                    cursor = cursorQuery;
                }
                r15 = cursor;
            } catch (SQLiteException e3) {
                e = e3;
                zzpzVar = null;
                r15 = zzpzVar;
            } catch (Throwable th4) {
                th = th4;
                obj = null;
                r15 = obj;
                if (r15 != 0) {
                    r15.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            zzpzVar = null;
        } catch (Throwable th5) {
            th = th5;
            obj = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x009e  */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x009b: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:27:0x009b */
    public final zzqd zzy(String str, String str2) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzav();
        Cursor cursor2 = null;
        try {
            try {
                cursorQuery = zzj().query("user_attributes", new String[]{"set_timestamp", "value", "origin"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (cursorQuery.moveToFirst()) {
                        long j = cursorQuery.getLong(0);
                        Object objZzz = zzz(cursorQuery, 1);
                        if (objZzz != null) {
                            zzqd zzqdVar = new zzqd(str, cursorQuery.getString(2), str2, j, objZzz);
                            if (cursorQuery.moveToNext()) {
                                this.zzu.zzaW().zze().zzb("Got multiple records for user property, expected one. appId", zzhe.zzn(str));
                            }
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return zzqdVar;
                        }
                    }
                } catch (SQLiteException e) {
                    e = e;
                    zzio zzioVar = this.zzu;
                    zzioVar.zzaW().zze().zzd("Error querying user property. appId", zzhe.zzn(str), zzioVar.zzj().zzf(str2), e);
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursorQuery = null;
            } catch (Throwable th) {
                th = th;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor2 = cursor;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    final Object zzz(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            this.zzu.zzaW().zze().zza("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i));
        }
        if (type == 3) {
            return cursor.getString(i);
        }
        if (type != 4) {
            this.zzu.zzaW().zze().zzb("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
            return null;
        }
        this.zzu.zzaW().zze().zza("Loaded invalid blob type value, ignoring it");
        return null;
    }
}

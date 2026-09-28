package com.google.android.gms.internal.nearby;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzry {
    static HashMap zze;
    private static Object zzl;
    private static boolean zzm;
    public static final Uri zza = Uri.parse("content://com.google.android.gsf.gservices");
    public static final Uri zzb = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern zzc = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern zzd = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final AtomicBoolean zzk = new AtomicBoolean();
    static final HashMap zzf = new HashMap();
    static final HashMap zzg = new HashMap();
    static final HashMap zzh = new HashMap();
    static final HashMap zzi = new HashMap();
    static final String[] zzj = new String[0];

    public static boolean zzb(ContentResolver contentResolver, String str, boolean z) {
        Object obj;
        String str2;
        Object obj2;
        synchronized (zzry.class) {
            zzc(contentResolver);
            obj = zzl;
        }
        HashMap map = zzf;
        boolean z2 = true;
        Boolean bool = true;
        synchronized (zzry.class) {
            str2 = null;
            if (map.containsKey("gms:nearby:requires_gms_check")) {
                obj2 = map.get("gms:nearby:requires_gms_check");
                if (obj2 == null) {
                    obj2 = bool;
                }
            } else {
                obj2 = null;
            }
        }
        Boolean bool2 = (Boolean) obj2;
        if (bool2 != null) {
            return bool2.booleanValue();
        }
        synchronized (zzry.class) {
            zzc(contentResolver);
            Object obj3 = zzl;
            if (zze.containsKey("gms:nearby:requires_gms_check")) {
                String str3 = (String) zze.get("gms:nearby:requires_gms_check");
                if (str3 != null) {
                    str2 = str3;
                }
            } else {
                int length = zzj.length;
                Cursor cursorQuery = contentResolver.query(zza, null, null, new String[]{"gms:nearby:requires_gms_check"}, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            String string = cursorQuery.getString(1);
                            if (string != null && string.equals(null)) {
                                string = null;
                            }
                            zzd(obj3, "gms:nearby:requires_gms_check", string);
                            if (string != null) {
                                str2 = string;
                            }
                        } else {
                            zzd(obj3, "gms:nearby:requires_gms_check", null);
                        }
                        cursorQuery.close();
                    } catch (Throwable th) {
                        cursorQuery.close();
                        throw th;
                    }
                }
            }
        }
        if (str2 == null || str2.equals("")) {
            bool = bool2;
        } else if (!zzc.matcher(str2).matches()) {
            if (zzd.matcher(str2).matches()) {
                z2 = false;
                bool = false;
            } else {
                Log.w("Gservices", "attempt to read gservices key gms:nearby:requires_gms_check (value \"" + str2 + "\") as boolean");
                bool = bool2;
            }
        }
        synchronized (zzry.class) {
            if (obj == zzl) {
                map.put("gms:nearby:requires_gms_check", bool);
                zze.remove("gms:nearby:requires_gms_check");
            }
        }
        return z2;
    }

    private static void zzc(ContentResolver contentResolver) {
        if (zze == null) {
            zzk.set(false);
            zze = new HashMap();
            zzl = new Object();
            zzm = false;
            contentResolver.registerContentObserver(zza, true, new zzrx(null));
            return;
        }
        if (zzk.getAndSet(false)) {
            zze.clear();
            zzf.clear();
            zzg.clear();
            zzh.clear();
            zzi.clear();
            zzl = new Object();
            zzm = false;
        }
    }

    private static void zzd(Object obj, String str, String str2) {
        synchronized (zzry.class) {
            if (obj == zzl) {
                zze.put("gms:nearby:requires_gms_check", str2);
            }
        }
    }
}

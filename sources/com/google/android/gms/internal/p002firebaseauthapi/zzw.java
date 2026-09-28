package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzw {
    public static int zza(int i, int i2) {
        String strZza;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            strZza = zzae.zza("%s (%s) must not be negative", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i));
        } else if (i2 >= 0) {
            strZza = zzae.zza("%s (%s) must be less than size (%s)", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i), Integer.valueOf(i2));
        } else {
            throw new IllegalArgumentException("negative size: " + i2);
        }
        throw new IndexOutOfBoundsException(strZza);
    }

    public static int zzb(int i, int i2) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(zzb(i, i2, FirebaseAnalytics.Param.INDEX));
        }
        return i;
    }

    public static int zza(int i, int i2, String str) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(zzb(i, i2, str));
        }
        return i;
    }

    public static <T> T zza(T t) {
        t.getClass();
        return t;
    }

    private static String zzb(int i, int i2, String str) {
        if (i < 0) {
            return zzae.zza("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("negative size: " + i2);
        }
        return zzae.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public static void zza(int i, int i2, int i3) {
        String strZzb;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                strZzb = zzb(i, i3, "start index");
            } else if (i2 < 0 || i2 > i3) {
                strZzb = zzb(i2, i3, "end index");
            } else {
                strZzb = zzae.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(strZzb);
        }
    }
}

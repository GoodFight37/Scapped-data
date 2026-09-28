package com.nintendo.npf.sdk.internal.util;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class SDKLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f884a = false;
    private static boolean b = false;

    public static void d(String str, String str2) {
        if (f884a && b) {
            Log.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (f884a) {
            Log.e(str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (f884a) {
            Log.i(str, str2);
        }
    }

    public static void setup(boolean z, boolean z2) {
        f884a = z;
        b = z2;
    }

    public static void w(String str, String str2) {
        if (f884a) {
            Log.w(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (f884a && b) {
            Log.d(str, str2, th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (f884a) {
            Log.e(str, str2, th);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (f884a) {
            Log.i(str, str2, th);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (f884a) {
            Log.w(str, str2, th);
        }
    }
}

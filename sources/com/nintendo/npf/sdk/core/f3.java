package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.internal.util.SDKLog;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f458a = 0;
    private static long b = 0;
    private static boolean c = false;

    public static void a() {
        c = true;
    }

    public static long b() {
        return f458a;
    }

    public static long c() {
        return b;
    }

    public static void a(long j) {
        if (!c || j <= 0) {
            return;
        }
        f458a += j;
        SDKLog.d("NPFCommunication", "RequestDataSize: " + f458a);
    }

    public static void b(long j) {
        if (!c || j <= 0) {
            return;
        }
        b += j;
        SDKLog.d("NPFCommunication", "ResponseDataSize: " + b);
    }
}

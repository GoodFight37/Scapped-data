package com.nintendo.npf.sdk.core;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
public final class q3 {
    public static final a b = new a(null);
    private static final int c = b(6908);
    private static final int d = b(6909);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f548a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return q3.c;
        }

        public final int b() {
            return q3.d;
        }

        private a() {
        }

        public final q3 a(int i) {
            if (i == a()) {
                return q3.a(a());
            }
            if (i == b()) {
                return q3.a(b());
            }
            return null;
        }
    }

    private /* synthetic */ q3(int i) {
        this.f548a = i;
    }

    public static final /* synthetic */ q3 a(int i) {
        return new q3(i);
    }

    public static final boolean a(int i, int i2) {
        return i == i2;
    }

    private static int b(int i) {
        return i;
    }

    public static int c(int i) {
        return Integer.hashCode(i);
    }

    public static String d(int i) {
        return "NaAuthorizationRequestCode(code=" + i + ')';
    }

    public boolean equals(Object obj) {
        return a(this.f548a, obj);
    }

    public int hashCode() {
        return c(this.f548a);
    }

    public String toString() {
        return d(this.f548a);
    }

    public static boolean a(int i, Object obj) {
        return (obj instanceof q3) && i == ((q3) obj).c();
    }

    public final /* synthetic */ int c() {
        return this.f548a;
    }
}

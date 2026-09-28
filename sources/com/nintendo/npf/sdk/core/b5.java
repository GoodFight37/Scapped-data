package com.nintendo.npf.sdk.core;

import android.content.Context;
import android.content.SharedPreferences;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b5 {
    public static final a b = new a(null);
    private static final String c = "b5";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f420a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public b5(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f420a = context;
    }

    public final String a() {
        return b("deviceAccount:", "deviceAccount");
    }

    public final String b() {
        return b("deviceAccount:", "devicePassword");
    }

    public final String c() {
        return b("deviceAccount:", "idToken");
    }

    public final String d() {
        return b("npfDefaultLanguage", "language");
    }

    public final String e() {
        return b("deviceAccount:", "sessionToken");
    }

    public final Boolean f() {
        return a("deviceAccount:", "isDisabledUsingGoogleAdvertisingId");
    }

    public final void a(String str) {
        a("deviceAccount:", "deviceAccount", str);
    }

    public final void b(String str) {
        a("deviceAccount:", "devicePassword", str);
    }

    public final void c(String str) {
        a("deviceAccount:", "idToken", str);
    }

    public final void d(String str) {
        a("npfDefaultLanguage", "language", str);
    }

    public final void e(String str) {
        a("deviceAccount:", "sessionToken", str);
    }

    public final void a(Boolean bool) {
        a("deviceAccount:", "isDisabledUsingGoogleAdvertisingId", bool);
    }

    public final String b(String name, String key) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            return this.f420a.getSharedPreferences(name, 0).getString(key, null);
        } catch (Exception e) {
            SDKLog.e(c, e.toString());
            throw new IllegalStateException(e);
        }
    }

    public final void a(String name, String key, String str) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences.Editor editorEdit = this.f420a.getSharedPreferences(name, 0).edit();
        editorEdit.putString(key, str);
        editorEdit.apply();
    }

    public final Boolean a(String name, String key) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            SharedPreferences sharedPreferences = this.f420a.getSharedPreferences(name, 0);
            if (sharedPreferences.contains(key)) {
                return Boolean.valueOf(sharedPreferences.getBoolean(key, false));
            }
            return null;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public final void a(String name, String key, Boolean bool) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            SharedPreferences.Editor editorEdit = this.f420a.getSharedPreferences(name, 0).edit();
            if (bool != null) {
                editorEdit.putBoolean(key, bool.booleanValue());
            } else {
                editorEdit.remove(key);
            }
            editorEdit.apply();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}

package com.nintendo.npf.sdk.core;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.core.os.EnvironmentCompat;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
public final class l1 {
    public static final a c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f515a;
    private final c4 b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public l1(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f515a = context;
        this.b = j();
    }

    private final c4 j() throws Exception {
        try {
            String packageName = this.f515a.getPackageName();
            PackageManager packageManager = this.f515a.getPackageManager();
            String str = packageManager.getPackageInfo(packageName, 1).versionName;
            if (str == null) {
                str = "";
            }
            Signature[] signatureArr = packageManager.getPackageInfo(packageName, 64).signatures;
            if (signatureArr == null) {
                throw new IllegalArgumentException("PackageInfo.signatures is null");
            }
            Intrinsics.checkNotNullExpressionValue(signatureArr, "requireNotNull(packageMa…es is null\"\n            }");
            byte[] byteArray = signatureArr[0].toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "signature.toByteArray()");
            String strA = a(byteArray);
            int identifier = this.f515a.getResources().getIdentifier("app_name", "string", packageName);
            String string = identifier != 0 ? this.f515a.getResources().getString(identifier) : "";
            Intrinsics.checkNotNullExpressionValue(string, "if (id != 0) {\n         …         \"\"\n            }");
            Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
            return new c4(packageName, str, strA, string);
        } catch (Exception e) {
            if (e instanceof PackageManager.NameNotFoundException) {
                e.printStackTrace();
                throw new IllegalStateException("Application is not managed in package manager.");
            }
            if (e instanceof NoSuchAlgorithmException) {
                e.printStackTrace();
                throw new IllegalStateException("SHA-1 algorithm is not supported.");
            }
            if (!(e instanceof NoSuchMethodException) && !(e instanceof IllegalAccessException) && !(e instanceof InvocationTargetException) && !(e instanceof IllegalArgumentException)) {
                throw e;
            }
            e.printStackTrace();
            throw new IllegalStateException("Failed to reflect the methods in old android version.");
        }
    }

    public final String a() {
        Object systemService = this.f515a.getSystemService("phone");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        String carrier = ((TelephonyManager) systemService).getNetworkOperatorName();
        if (carrier == null || carrier.length() == 0) {
            carrier = "UNKNOWN";
        }
        Intrinsics.checkNotNullExpressionValue(carrier, "carrier");
        return carrier;
    }

    public final String b() {
        String MODEL = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        return MODEL;
    }

    public final String c() {
        String MANUFACTURER = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
        return MANUFACTURER;
    }

    public final String d() {
        Object systemService = this.f515a.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
        return activeNetworkInfo.getType() == 1 ? "wifi" : "wwan";
    }

    public final String e() {
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
        return RELEASE;
    }

    public final c4 f() {
        return this.b;
    }

    public final String g() {
        return "Unity-3.13.1-c55a4366e";
    }

    public final String h() {
        String id = TimeZone.getDefault().getID();
        Intrinsics.checkNotNullExpressionValue(id, "getDefault().id");
        return id;
    }

    public final int i() {
        return TimeZone.getDefault().getRawOffset() + TimeZone.getDefault().getDSTSavings();
    }

    private final String a(byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        Intrinsics.checkNotNullExpressionValue(messageDigest, "getInstance(ALGORITHM_SHA_1)");
        messageDigest.reset();
        messageDigest.update(bArr);
        byte[] bArrDigest = messageDigest.digest();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%040x", Arrays.copyOf(new Object[]{new BigInteger(1, bArrDigest)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        return str;
    }
}

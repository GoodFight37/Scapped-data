package com.nintendo.npf.sdk.core;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c1 f422a = new c1();

    private c1() {
    }

    private final boolean b(Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> listQueryIntentActivities = packageManager != null ? packageManager.queryIntentActivities(intent, 0) : null;
        if (listQueryIntentActivities == null || listQueryIntentActivities.isEmpty()) {
            SDKLog.d("CustomTabsLauncher", "Activity not found.");
            return false;
        }
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", uri));
            return true;
        } catch (ActivityNotFoundException e) {
            SDKLog.d("CustomTabsLauncher", "startActivity failed.", e);
            return false;
        }
    }

    public final boolean a(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        String strA = a(context);
        if (strA != null) {
            CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder().build();
            Intrinsics.checkNotNullExpressionValue(customTabsIntentBuild, "Builder().build()");
            customTabsIntentBuild.intent.setPackage(strA);
            try {
                customTabsIntentBuild.launchUrl(context, uri);
                return true;
            } catch (ActivityNotFoundException e) {
                SDKLog.d("CustomTabsLauncher", "launchUrl failed. packageName:" + strA, e);
            }
        }
        return b(context, uri);
    }

    private final String a(Context context) {
        return CustomTabsClient.getPackageName(context, null);
    }
}

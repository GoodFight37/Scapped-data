package com.unity3d.player;

import android.app.Activity;
import android.content.pm.ApplicationInfo;

/* JADX INFO: renamed from: com.unity3d.player.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0111k {
    public static boolean a(Activity activity) {
        try {
            ApplicationInfo applicationInfo = activity.getPackageManager().getApplicationInfo(activity.getPackageName(), 128);
            if (applicationInfo != null) {
                return applicationInfo.metaData.getBoolean("unity.render-outside-safearea");
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x001b  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public static void b(Activity activity) {
        ?? A;
        if (activity == null || activity.getWindow() == null || !PlatformSupport.PIE_SUPPORT) {
            return;
        }
        if (PlatformSupport.VANILLA_ICE_CREAM_SUPPORT) {
            A = 3;
        } else if (PlatformSupport.RED_VELVET_CAKE_SUPPORT) {
            if (a(activity)) {
                A = 3;
            } else {
                A = 0;
            }
        } else {
            A = a(activity);
        }
        activity.getWindow().getAttributes().layoutInDisplayCutoutMode = A;
    }
}

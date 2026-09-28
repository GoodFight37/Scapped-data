package com.google.api.client.extensions.android;

import android.os.Build;
import com.google.api.client.util.Preconditions;

/* JADX INFO: loaded from: classes2.dex */
public class AndroidUtils {
    public static boolean isMinimumSdkLevel(int i) {
        return Build.VERSION.SDK_INT >= i;
    }

    public static void checkMinimumSdkLevel(int i) {
        Preconditions.checkArgument(isMinimumSdkLevel(i), "running on Android SDK level %s but requires minimum %s", Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(i));
    }

    private AndroidUtils() {
    }
}

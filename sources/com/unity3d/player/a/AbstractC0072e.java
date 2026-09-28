package com.unity3d.player.a;

import android.app.Activity;
import android.app.Dialog;
import android.window.OnBackInvokedDispatcher;

/* JADX INFO: renamed from: com.unity3d.player.a.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0072e {
    public static OnBackInvokedDispatcher a(Object obj) {
        if (obj instanceof Activity) {
            return ((Activity) obj).getOnBackInvokedDispatcher();
        }
        if (obj instanceof Dialog) {
            return ((Dialog) obj).getOnBackInvokedDispatcher();
        }
        throw new IllegalArgumentException("Unsupported context type when getting '" + obj.getClass().getName() + "' OnBackInvokedDispatcher");
    }

    public static void a(OnBackInvokedDispatcher onBackInvokedDispatcher, int i, C0071d c0071d) {
        onBackInvokedDispatcher.registerOnBackInvokedCallback(i, c0071d);
    }

    public static void a(OnBackInvokedDispatcher onBackInvokedDispatcher, C0071d c0071d) {
        onBackInvokedDispatcher.unregisterOnBackInvokedCallback(c0071d);
    }
}

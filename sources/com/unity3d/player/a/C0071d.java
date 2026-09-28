package com.unity3d.player.a;

import android.window.OnBackInvokedCallback;

/* JADX INFO: renamed from: com.unity3d.player.a.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0071d implements OnBackInvokedCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0090x f1074a;

    public C0071d(C0090x c0090x) {
        this.f1074a = c0090x;
    }

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        Runnable runnable = this.f1074a.f1090a;
        if (runnable != null) {
            runnable.run();
        }
    }
}

package com.unity3d.player;

import android.view.WindowManager;

/* JADX INFO: loaded from: classes2.dex */
public final class U implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f1042a;
    public final /* synthetic */ UnityPlayer b;

    public U(UnityPlayer unityPlayer, float f) {
        this.b = unityPlayer;
        this.f1042a = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WindowManager.LayoutParams attributes = this.b.m_Window.getAttributes();
        attributes.screenBrightness = this.f1042a;
        this.b.m_Window.setAttributes(attributes);
    }
}

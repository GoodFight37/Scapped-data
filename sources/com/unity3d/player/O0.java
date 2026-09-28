package com.unity3d.player;

import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class O0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityPlayerForGameActivity f1031a;

    public O0(UnityPlayerForGameActivity unityPlayerForGameActivity) {
        this.f1031a = unityPlayerForGameActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UnityPlayerForGameActivity unityPlayerForGameActivity = this.f1031a;
        com.unity3d.player.a.D d = unityPlayerForGameActivity.m_PersistentUnitySurface;
        FrameLayout frameLayout = unityPlayerForGameActivity.getFrameLayout();
        com.unity3d.player.a.C c = d.b;
        if (c != null && c.getParent() != null) {
            frameLayout.removeView(d.b);
        }
        this.f1031a.m_PersistentUnitySurface.b = null;
    }
}

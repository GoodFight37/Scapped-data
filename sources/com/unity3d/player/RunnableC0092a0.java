package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.a0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class RunnableC0092a0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityPlayer f1092a;

    public RunnableC0092a0(UnityPlayer unityPlayer) {
        this.f1092a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1092a.getFrameLayout().removeView(this.f1092a.m_SplashScreen);
        this.f1092a.m_SplashScreen = null;
    }
}

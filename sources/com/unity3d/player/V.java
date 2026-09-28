package com.unity3d.player;

/* JADX INFO: loaded from: classes2.dex */
public final class V implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityPlayer f1046a;

    public V(UnityPlayer unityPlayer) {
        this.f1046a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1046a.setupUnityToBePaused();
        this.f1046a.windowFocusChanged(false);
        this.f1046a.m_UnityPlayerLifecycleEvents.onUnityPlayerUnloaded();
    }
}

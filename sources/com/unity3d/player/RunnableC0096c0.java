package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.c0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class RunnableC0096c0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f1095a;
    public final /* synthetic */ UnityPlayer b;

    public RunnableC0096c0(UnityPlayer unityPlayer, boolean z) {
        this.b = unityPlayer;
        this.f1095a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z = this.b.m_RunWithoutFocus;
        boolean z2 = this.f1095a;
        if (z == z2) {
            return;
        }
        this.b.m_RunWithoutFocus = z2;
        if (this.b.shouldRunWithoutFocus()) {
            return;
        }
        UnityPlayer unityPlayer = this.b;
        com.unity3d.player.a.Q q = unityPlayer.mState;
        if (q.f1065a || q.c) {
            return;
        }
        unityPlayer.setupUnityToBePaused();
    }
}

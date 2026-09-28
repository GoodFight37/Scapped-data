package com.unity3d.player;

import android.app.Activity;

/* JADX INFO: renamed from: com.unity3d.player.f0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class RunnableC0102f0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityPlayer f1101a;

    public RunnableC0102f0(UnityPlayer unityPlayer) {
        this.f1101a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UnityPlayer unityPlayer;
        Activity activity;
        if (!this.f1101a.nativeIsAutorotationOn() || (activity = (unityPlayer = this.f1101a).mActivity) == null) {
            return;
        }
        activity.setRequestedOrientation(unityPlayer.mInitialScreenOrientation);
    }
}

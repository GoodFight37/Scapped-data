package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.d0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class RunnableC0098d0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1097a;

    public RunnableC0098d0(String str) {
        this.f1097a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UnityPlayer.nativeSetLaunchURL(this.f1097a);
    }
}

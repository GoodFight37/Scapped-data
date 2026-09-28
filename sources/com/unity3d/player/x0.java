package com.unity3d.player;

/* JADX INFO: loaded from: classes2.dex */
public final class x0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityPlayerForActivityOrService f1126a;

    public x0(UnityPlayerForActivityOrService unityPlayerForActivityOrService) {
        this.f1126a = unityPlayerForActivityOrService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1126a.destroy();
    }
}

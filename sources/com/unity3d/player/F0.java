package com.unity3d.player;

/* JADX INFO: loaded from: classes2.dex */
public final class F0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityPlayerForActivityOrService f1019a;

    public F0(UnityPlayerForActivityOrService unityPlayerForActivityOrService) {
        this.f1019a = unityPlayerForActivityOrService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1019a.nativeResume();
    }
}

package com.unity3d.player;

/* JADX INFO: loaded from: classes2.dex */
public final class C0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityPlayerForActivityOrService f1014a;

    public C0(UnityPlayerForActivityOrService unityPlayerForActivityOrService) {
        this.f1014a = unityPlayerForActivityOrService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1014a.nativeSendSurfaceChangedEvent();
    }
}

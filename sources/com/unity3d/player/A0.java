package com.unity3d.player;

import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes2.dex */
public final class A0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Semaphore f1010a;
    public final /* synthetic */ UnityPlayerForActivityOrService b;

    public A0(UnityPlayerForActivityOrService unityPlayerForActivityOrService, Semaphore semaphore) {
        this.b = unityPlayerForActivityOrService;
        this.f1010a = semaphore;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.b.nativePause()) {
            UnityPlayerForActivityOrService unityPlayerForActivityOrService = this.b;
            unityPlayerForActivityOrService.mQuitting = true;
            unityPlayerForActivityOrService.shutdown();
            this.b.queueDestroy();
        }
        this.f1010a.release();
    }
}

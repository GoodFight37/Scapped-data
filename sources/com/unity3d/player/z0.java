package com.unity3d.player;

import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes2.dex */
public final class z0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Semaphore f1129a;
    public final /* synthetic */ UnityPlayerForActivityOrService b;

    public z0(UnityPlayerForActivityOrService unityPlayerForActivityOrService, Semaphore semaphore) {
        this.b = unityPlayerForActivityOrService;
        this.f1129a = semaphore;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.shutdown();
        this.f1129a.release();
    }
}

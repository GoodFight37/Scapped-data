package com.unity3d.player;

import android.view.Surface;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes2.dex */
public final class D0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1017a;
    public final /* synthetic */ Surface b;
    public final /* synthetic */ Semaphore c;
    public final /* synthetic */ UnityPlayerForActivityOrService d;

    public D0(UnityPlayerForActivityOrService unityPlayerForActivityOrService, int i, Surface surface, Semaphore semaphore) {
        this.d = unityPlayerForActivityOrService;
        this.f1017a = i;
        this.b = surface;
        this.c = semaphore;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.d.nativeRecreateGfxState(this.f1017a, this.b);
        this.c.release();
    }
}

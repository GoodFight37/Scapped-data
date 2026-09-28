package com.unity3d.player;

import java.util.concurrent.Semaphore;

/* JADX INFO: renamed from: com.unity3d.player.o0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class RunnableC0120o0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1112a = false;
    public boolean b = false;
    public final /* synthetic */ Semaphore c;
    public final /* synthetic */ UnityPlayerForActivityOrService d;
    public final /* synthetic */ UnityPlayerForActivityOrService e;

    public RunnableC0120o0(UnityPlayerForActivityOrService unityPlayerForActivityOrService, Semaphore semaphore, UnityPlayerForActivityOrService unityPlayerForActivityOrService2) {
        this.e = unityPlayerForActivityOrService;
        this.c = semaphore;
        this.d = unityPlayerForActivityOrService2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.e.mSoftInput != null) {
            this.d.setOnHandleFocusListener(new C0116m0(this));
            UnityPlayerForActivityOrService unityPlayerForActivityOrService = this.e;
            unityPlayerForActivityOrService.mSoftInput.g = new C0118n0(this);
            unityPlayerForActivityOrService.dismissSoftInput();
        }
    }
}

package com.unity3d.player;

/* JADX INFO: loaded from: classes2.dex */
public final class P0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ S0 f1034a;

    public P0(S0 s0) {
        this.f1034a = s0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1034a.destroyPlayer();
        this.f1034a.a(3);
    }
}

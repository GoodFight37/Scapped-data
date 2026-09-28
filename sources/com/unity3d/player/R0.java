package com.unity3d.player;

/* JADX INFO: loaded from: classes2.dex */
public final class R0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S0 f1037a;
    public boolean b = false;

    public R0(S0 s0) {
        this.f1037a = s0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        if (this.b) {
            return;
        }
        int i = S0.A;
        this.f1037a.cancelOnPrepare();
    }
}

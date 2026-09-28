package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class RunnableC0133w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0135y f1124a;

    public RunnableC0133w(C0135y c0135y) {
        this.f1124a = c0135y;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1124a.c.requestFocus();
        this.f1124a.e();
    }
}

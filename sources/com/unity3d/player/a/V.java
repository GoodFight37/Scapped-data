package com.unity3d.player.a;

/* JADX INFO: loaded from: classes2.dex */
public final class V implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Y f1069a;

    public V(Y y) {
        this.f1069a = y;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1069a.f1072a.onPause();
    }
}

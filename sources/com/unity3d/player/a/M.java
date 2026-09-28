package com.unity3d.player.a;

/* JADX INFO: loaded from: classes2.dex */
public final class M implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ O f1061a;

    public M(O o) {
        this.f1061a = o;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1061a.f1063a.getView().requestPointerCapture();
    }
}

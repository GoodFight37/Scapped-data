package com.unity3d.player.a;

/* JADX INFO: loaded from: classes2.dex */
public final class N implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ O f1062a;

    public N(O o) {
        this.f1062a = o;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1062a.f1063a.getView().releasePointerCapture();
    }
}

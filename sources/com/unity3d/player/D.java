package com.unity3d.player;

/* JADX INFO: loaded from: classes2.dex */
public final class D implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1016a;
    public final /* synthetic */ int b;
    public final /* synthetic */ UnityAccessibilityDelegate c;

    public D(UnityAccessibilityDelegate unityAccessibilityDelegate, int i, int i2) {
        this.c = unityAccessibilityDelegate;
        this.f1016a = i;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.sendEventForVirtualViewId(this.f1016a, this.b);
    }
}

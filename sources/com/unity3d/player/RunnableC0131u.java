package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class RunnableC0131u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DialogC0132v f1122a;

    public RunnableC0131u(DialogC0132v dialogC0132v) {
        this.f1122a = dialogC0132v;
    }

    @Override // java.lang.Runnable
    public final void run() {
        A a2 = this.f1122a.d;
        a2.a(a2.a(), true);
    }
}

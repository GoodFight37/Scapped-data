package com.unity3d.player.a;

import com.unity3d.player.S0;

/* JADX INFO: loaded from: classes2.dex */
public final class W implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Y f1070a;

    public W(Y y) {
        this.f1070a = y;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Y y = this.f1070a;
        S0 s0 = y.f;
        if (s0 != null) {
            y.f1072a.addViewToPlayer(s0, true);
            Y y2 = this.f1070a;
            y2.i = true;
            y2.f.requestFocus();
        }
    }
}

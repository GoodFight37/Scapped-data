package com.unity3d.player.a;

import com.unity3d.player.C0100e0;
import com.unity3d.player.S0;

/* JADX INFO: loaded from: classes2.dex */
public final class X implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Y f1071a;

    public X(Y y) {
        this.f1071a = y;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Y y = this.f1071a;
        S0 s0 = y.f;
        if (s0 != null) {
            y.f1072a.removeViewFromPlayer(s0);
            y.i = false;
            y.f.destroyPlayer();
            y.f = null;
            C0100e0 c0100e0 = y.c;
            if (c0100e0 != null) {
                c0100e0.a();
            }
        }
        this.f1071a.f1072a.onResume();
    }
}

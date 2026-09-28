package com.unity3d.player.a;

import com.unity3d.player.C0100e0;
import com.unity3d.player.S0;

/* JADX INFO: loaded from: classes2.dex */
public final class S implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ T f1066a;

    public S(T t) {
        this.f1066a = t;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Y y = this.f1066a.f1067a.h;
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
        this.f1066a.f1067a.h.f1072a.onResume();
    }
}

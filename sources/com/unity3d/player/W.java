package com.unity3d.player;

import com.unity3d.player.a.AbstractC0070c;
import com.unity3d.player.a.AbstractC0086t;

/* JADX INFO: loaded from: classes2.dex */
public final class W implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1047a;
    public final /* synthetic */ UnityPlayer b;

    public W(UnityPlayer unityPlayer, int i) {
        this.b = unityPlayer;
        this.f1047a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            UnityPlayer unityPlayer = this.b;
            AbstractC0070c.a(unityPlayer.mActivity, unityPlayer.getFrameLayout(), this.f1047a);
        } catch (Exception e) {
            AbstractC0086t.Log(6, "Exception when opening Activity Indicator " + e);
        }
    }
}

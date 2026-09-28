package com.unity3d.player.a;

import android.app.Activity;
import android.content.Context;
import com.unity3d.player.C0100e0;
import com.unity3d.player.S0;
import com.unity3d.player.UnityPlayer;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public final class Y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UnityPlayer f1072a;
    public C0100e0 c;
    public Context b = null;
    public final Semaphore d = new Semaphore(0);
    public final ReentrantLock e = new ReentrantLock();
    public S0 f = null;
    public int g = 2;
    public boolean h = false;
    public boolean i = false;

    public Y(UnityPlayer unityPlayer) {
        this.f1072a = null;
        this.f1072a = unityPlayer;
    }

    public void runOnUiThread(Runnable runnable) {
        Context context = this.b;
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(runnable);
        } else {
            AbstractC0086t.Log(5, "Not running from an Activity; Ignoring execution request...");
        }
    }
}

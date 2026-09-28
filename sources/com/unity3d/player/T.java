package com.unity3d.player;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
public final class T extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UnityPlayerForActivityOrService f1041a;
    public Handler c;
    public int h;
    public int i;
    public final CountDownLatch b = new CountDownLatch(1);
    public boolean d = false;
    public boolean e = false;
    public int f = 2;
    public int g = 0;
    public int j = 5;

    public T(UnityPlayerForActivityOrService unityPlayerForActivityOrService) {
        this.f1041a = unityPlayerForActivityOrService;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        setName("UnityMain");
        Looper.prepare();
        this.c = new Handler(Looper.myLooper(), new Q(this));
        this.b.countDown();
        Looper.loop();
    }
}

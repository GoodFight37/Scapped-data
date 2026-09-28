package com.unity3d.player;

import android.content.res.Configuration;

/* JADX INFO: loaded from: classes2.dex */
public final class B0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Configuration f1013a;
    public final /* synthetic */ UnityPlayerForActivityOrService b;

    public B0(UnityPlayerForActivityOrService unityPlayerForActivityOrService, Configuration configuration) {
        this.b = unityPlayerForActivityOrService;
        this.f1013a = configuration;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.nativeConfigurationChanged(this.f1013a);
    }
}

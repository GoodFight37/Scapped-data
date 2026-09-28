package com.unity3d.player;

import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: loaded from: classes2.dex */
public final class y0 implements View.OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityPlayerForActivityOrService f1127a;

    public y0(UnityPlayerForActivityOrService unityPlayerForActivityOrService) {
        this.f1127a = unityPlayerForActivityOrService;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        this.f1127a.invokeOnMainThread((Runnable) new C0114l0(this, windowInsets));
        return windowInsets;
    }
}

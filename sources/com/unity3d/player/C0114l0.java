package com.unity3d.player;

import android.view.WindowInsets;

/* JADX INFO: renamed from: com.unity3d.player.l0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0114l0 extends UnityPlayer.a {
    public final /* synthetic */ WindowInsets b;
    public final /* synthetic */ y0 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0114l0(y0 y0Var, WindowInsets windowInsets) {
        super();
        this.c = y0Var;
        this.b = windowInsets;
    }

    @Override // com.unity3d.player.UnityPlayer.a
    public final void a() {
        this.c.f1127a.nativeOnApplyWindowInsets(this.b);
    }
}

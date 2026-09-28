package com.unity3d.player.a;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes2.dex */
public final class H implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.unity3d.player.A f1056a;

    public H(com.unity3d.player.A a2) {
        this.f1056a = a2;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f1056a.reportSoftInputArea();
    }
}

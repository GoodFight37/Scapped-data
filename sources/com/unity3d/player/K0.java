package com.unity3d.player;

import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class K0 implements SurfaceHolder.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityPlayerForGameActivity f1027a;

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public K0(UnityPlayerForGameActivity unityPlayerForGameActivity) {
        this.f1027a = unityPlayerForGameActivity;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        UnityPlayerForGameActivity unityPlayerForGameActivity = this.f1027a;
        com.unity3d.player.a.D d = unityPlayerForGameActivity.m_PersistentUnitySurface;
        FrameLayout frameLayout = unityPlayerForGameActivity.getFrameLayout();
        com.unity3d.player.a.C c = d.b;
        if (c == null || c.getParent() != null) {
            return;
        }
        frameLayout.addView(d.b);
        frameLayout.bringChildToFront(d.b);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        UnityPlayerForGameActivity unityPlayerForGameActivity = this.f1027a;
        com.unity3d.player.a.D d = unityPlayerForGameActivity.m_PersistentUnitySurface;
        SurfaceView surfaceView = unityPlayerForGameActivity.m_SurfaceView;
        d.getClass();
        if (PlatformSupport.NOUGAT_SUPPORT && d.f1053a != null) {
            if (d.b == null) {
                d.b = new com.unity3d.player.a.C(d, d.f1053a);
            }
            d.b.a(surfaceView);
        }
        this.f1027a.handleDeferredPauseOnSurfaceDestroyed();
    }
}

package com.unity3d.player;

import android.view.SurfaceHolder;
import android.widget.FrameLayout;
import com.unity3d.player.a.C0073f;

/* JADX INFO: loaded from: classes2.dex */
public final class O implements SurfaceHolder.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ P f1030a;

    public O(P p) {
        this.f1030a = p;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f1030a.b.updateGLDisplay(0, surfaceHolder.getSurface());
        P p = this.f1030a;
        com.unity3d.player.a.D d = p.c;
        FrameLayout frameLayout = p.b.getFrameLayout();
        com.unity3d.player.a.C c = d.b;
        if (c == null || c.getParent() != null) {
            return;
        }
        frameLayout.addView(d.b);
        frameLayout.bringChildToFront(d.b);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.f1030a.b.updateGLDisplay(0, surfaceHolder.getSurface());
        this.f1030a.b.sendSurfaceChangedEvent();
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        P p = this.f1030a;
        com.unity3d.player.a.D d = p.c;
        C0073f c0073f = p.f1033a;
        d.getClass();
        if (PlatformSupport.NOUGAT_SUPPORT && d.f1053a != null) {
            if (d.b == null) {
                d.b = new com.unity3d.player.a.C(d, d.f1053a);
            }
            d.b.a(c0073f);
        }
        this.f1030a.b.handleDeferredPauseOnSurfaceDestroyed();
        this.f1030a.b.updateGLDisplay(0, null);
    }
}

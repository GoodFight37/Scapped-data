package com.unity3d.player.a;

import android.graphics.SurfaceTexture;
import com.unity3d.player.Camera2Wrapper;

/* JADX INFO: renamed from: com.unity3d.player.a.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0081n implements SurfaceTexture.OnFrameAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0083p f1082a;

    public C0081n(C0083p c0083p) {
        this.f1082a = c0083p;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        ((Camera2Wrapper) this.f1082a.f1084a).a(surfaceTexture);
    }
}

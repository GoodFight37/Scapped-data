package com.unity3d.player;

import android.view.ViewGroup;
import com.unity3d.player.a.C0073f;

/* JADX INFO: loaded from: classes2.dex */
public final class H0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f1021a;
    public final /* synthetic */ UnityPlayerForActivityOrService b;

    public H0(UnityPlayerForActivityOrService unityPlayerForActivityOrService, float f) {
        this.b = unityPlayerForActivityOrService;
        this.f1021a = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        P view = this.b.getView();
        if (view != null) {
            float f = this.f1021a;
            C0073f c0073f = view.f1033a;
            c0073f.f1075a = f;
            ViewGroup.LayoutParams layoutParams = c0073f.getLayoutParams();
            if (f <= 0.0f) {
                layoutParams.width = -1;
                layoutParams.height = -1;
            } else {
                layoutParams.width = -2;
                layoutParams.height = -2;
            }
            c0073f.setLayoutParams(layoutParams);
        }
    }
}

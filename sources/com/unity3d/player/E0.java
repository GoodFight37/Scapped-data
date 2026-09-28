package com.unity3d.player;

import com.unity3d.player.a.AbstractC0086t;

/* JADX INFO: loaded from: classes2.dex */
public final class E0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityPlayerForActivityOrService f1018a;

    public E0(UnityPlayerForActivityOrService unityPlayerForActivityOrService) {
        this.f1018a = unityPlayerForActivityOrService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UnityPlayerForActivityOrService unityPlayerForActivityOrService = this.f1018a;
        if (unityPlayerForActivityOrService.mMainDisplayOverride) {
            unityPlayerForActivityOrService.getFrameLayout().removeView(this.f1018a.getView());
        } else if (unityPlayerForActivityOrService.getView().getParent() == null) {
            this.f1018a.getFrameLayout().addView(this.f1018a.getView());
        } else {
            AbstractC0086t.Log(5, "Couldn't add view, because it's already assigned to another parent");
        }
    }
}

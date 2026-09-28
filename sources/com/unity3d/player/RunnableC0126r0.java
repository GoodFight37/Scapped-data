package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.r0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class RunnableC0126r0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f1118a;
    public final /* synthetic */ UnityPlayerForActivityOrService b;

    public RunnableC0126r0(UnityPlayerForActivityOrService unityPlayerForActivityOrService, boolean z) {
        this.b = unityPlayerForActivityOrService;
        this.f1118a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AbstractC0129t abstractC0129t = this.b.mSoftInput;
        if (abstractC0129t != null) {
            abstractC0129t.a(this.f1118a);
        }
    }
}

package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class RunnableC0099e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IAssetPackManagerMobileDataConfirmationCallback f1098a;
    public final boolean b;

    public RunnableC0099e(IAssetPackManagerMobileDataConfirmationCallback iAssetPackManagerMobileDataConfirmationCallback, boolean z) {
        this.f1098a = iAssetPackManagerMobileDataConfirmationCallback;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1098a.onMobileDataConfirmationResult(this.b);
    }
}

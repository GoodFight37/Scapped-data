package com.unity3d.player;

import com.google.android.gms.tasks.OnSuccessListener;

/* JADX INFO: renamed from: com.unity3d.player.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0101f implements OnSuccessListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IAssetPackManagerMobileDataConfirmationCallback f1100a;
    public final UnityPlayer b;

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        Integer num = (Integer) obj;
        IAssetPackManagerMobileDataConfirmationCallback iAssetPackManagerMobileDataConfirmationCallback = this.f1100a;
        if (iAssetPackManagerMobileDataConfirmationCallback != null) {
            this.b.invokeOnMainThread(new RunnableC0099e(iAssetPackManagerMobileDataConfirmationCallback, num.intValue() == -1));
        }
    }

    public C0101f(UnityPlayer unityPlayer, IAssetPackManagerMobileDataConfirmationCallback iAssetPackManagerMobileDataConfirmationCallback) {
        this.b = unityPlayer;
        this.f1100a = iAssetPackManagerMobileDataConfirmationCallback;
    }
}

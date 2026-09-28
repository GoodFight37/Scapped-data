package com.unity3d.player;

import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.assetpacks.AssetPackStateUpdateListener;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: renamed from: com.unity3d.player.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0097d implements AssetPackStateUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet f1096a;
    public final UnityPlayer b;
    public final /* synthetic */ C0109j c;

    @Override // com.google.android.play.core.listener.StateUpdatedListener
    public final void onStateUpdate(AssetPackState assetPackState) {
        AssetPackState assetPackState2 = assetPackState;
        synchronized (this) {
            if (assetPackState2.status() == 4 || assetPackState2.status() == 5 || assetPackState2.status() == 0) {
                synchronized (C0109j.e) {
                    this.c.c.remove(assetPackState2.name());
                    if (this.c.c.isEmpty()) {
                        C0109j c0109j = this.c;
                        C0097d c0097d = c0109j.d;
                        if (c0097d instanceof C0097d) {
                            c0109j.b.unregisterListener(c0097d);
                        }
                        this.c.d = null;
                    }
                }
            }
            if (this.f1096a.size() == 0) {
                return;
            }
            this.b.invokeOnMainThread(new RunnableC0095c((Set) this.f1096a.clone(), assetPackState2.name(), assetPackState2.status(), assetPackState2.totalBytesToDownload(), assetPackState2.bytesDownloaded(), assetPackState2.transferProgressPercentage(), assetPackState2.errorCode()));
        }
    }

    public C0097d(C0109j c0109j, UnityPlayer unityPlayer, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        this.c = c0109j;
        this.b = unityPlayer;
        HashSet hashSet = new HashSet();
        this.f1096a = hashSet;
        hashSet.add(iAssetPackManagerDownloadStatusCallback);
    }

    public final synchronized void a(IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        this.f1096a.add(iAssetPackManagerDownloadStatusCallback);
    }
}

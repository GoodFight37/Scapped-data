package com.unity3d.player;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.assetpacks.AssetPackException;
import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.assetpacks.AssetPackStates;
import java.util.Collections;
import java.util.Map;
import java.util.Vector;

/* JADX INFO: renamed from: com.unity3d.player.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0103g implements OnCompleteListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IAssetPackManagerDownloadStatusCallback f1102a;
    public final UnityPlayer b;
    public final String[] c;

    public C0103g(UnityPlayer unityPlayer, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback, String[] strArr) {
        this.b = unityPlayer;
        this.f1102a = iAssetPackManagerDownloadStatusCallback;
        this.c = strArr;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        int errorCode;
        try {
            AssetPackStates assetPackStates = (AssetPackStates) task.getResult();
            Map<String, AssetPackState> mapPackStates = assetPackStates.packStates();
            if (mapPackStates.size() == 0) {
                return;
            }
            Vector vector = new Vector();
            for (AssetPackState assetPackState : mapPackStates.values()) {
                if (assetPackState.errorCode() != 0 || assetPackState.status() == 4 || assetPackState.status() == 5 || assetPackState.status() == 0) {
                    String strName = assetPackState.name();
                    int iStatus = assetPackState.status();
                    int iErrorCode = assetPackState.errorCode();
                    long j = assetPackStates.totalBytes();
                    this.b.invokeOnMainThread(new RunnableC0095c(Collections.singleton(this.f1102a), strName, iStatus, j, iStatus == 4 ? j : 0L, 0, iErrorCode));
                } else {
                    vector.add(assetPackState.name());
                }
            }
            if (vector.size() > 0) {
                C0109j c0109j = C0109j.e;
                UnityPlayer unityPlayer = this.b;
                IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback = this.f1102a;
                c0109j.getClass();
                synchronized (C0109j.e) {
                    C0097d c0097d = c0109j.d;
                    if (c0097d == null) {
                        C0097d c0097d2 = new C0097d(c0109j, unityPlayer, iAssetPackManagerDownloadStatusCallback);
                        c0109j.b.registerListener(c0097d2);
                        c0109j.d = c0097d2;
                    } else {
                        c0097d.a(iAssetPackManagerDownloadStatusCallback);
                    }
                    c0109j.c.addAll(vector);
                    c0109j.b.fetch(vector);
                }
            }
        } catch (RuntimeExecutionException e) {
            e = e;
            String[] strArr = this.c;
            if (strArr.length != 1) {
                C0109j c0109j2 = C0109j.e;
                IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback2 = this.f1102a;
                c0109j2.getClass();
                for (String str : strArr) {
                    c0109j2.b.getPackStates(Collections.singletonList(str)).addOnCompleteListener(new C0103g(c0109j2.f1106a, iAssetPackManagerDownloadStatusCallback2, new String[]{str}));
                }
                return;
            }
            String str2 = strArr[0];
            while (true) {
                if (e instanceof AssetPackException) {
                    errorCode = ((AssetPackException) e).getErrorCode();
                    break;
                }
                e = e.getCause();
                if (e == null) {
                    errorCode = -100;
                    break;
                }
            }
            this.b.invokeOnMainThread(new RunnableC0095c(Collections.singleton(this.f1102a), str2, 0, 0L, 0L, 0, errorCode));
        }
    }
}

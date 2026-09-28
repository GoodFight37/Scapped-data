package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import com.google.android.play.core.assetpacks.AssetPackLocation;
import com.unity3d.player.a.AbstractC0086t;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class PlayAssetDeliveryUnityWrapper {
    private static PlayAssetDeliveryUnityWrapper b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0109j f1035a;

    private PlayAssetDeliveryUnityWrapper(UnityPlayer unityPlayer, Context context) {
        this.f1035a = null;
        if (b != null) {
            throw new RuntimeException("PlayAssetDeliveryUnityWrapper should be created only once. Use getInstance() instead.");
        }
        try {
            if (getClass().getClassLoader().loadClass("com.google.android.play.core.assetpacks.AssetPackManager").getMethod("getPackStates", List.class).getReturnType().getName().equals("com.google.android.gms.tasks.Task")) {
                this.f1035a = a(unityPlayer, context);
            }
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException unused) {
        }
    }

    public static synchronized PlayAssetDeliveryUnityWrapper getInstance() {
        PlayAssetDeliveryUnityWrapper playAssetDeliveryUnityWrapper;
        while (true) {
            playAssetDeliveryUnityWrapper = b;
            if (playAssetDeliveryUnityWrapper != null) {
                break;
            }
            try {
                PlayAssetDeliveryUnityWrapper.class.wait(3000L);
            } catch (InterruptedException e) {
                AbstractC0086t.Log(6, e.getMessage());
            }
            throw th;
        }
        if (playAssetDeliveryUnityWrapper == null) {
            throw new RuntimeException("PlayAssetDeliveryUnityWrapper is not yet initialised.");
        }
        return playAssetDeliveryUnityWrapper;
    }

    private static C0109j a(UnityPlayer unityPlayer, Context context) {
        if (C0109j.e == null) {
            C0109j.e = new C0109j(unityPlayer, context);
        }
        return C0109j.e;
    }

    public static synchronized PlayAssetDeliveryUnityWrapper init(UnityPlayer unityPlayer, Context context) {
        if (b != null) {
            throw new RuntimeException("PlayAssetDeliveryUnityWrapper.init() should be called only once. Use getInstance() instead.");
        }
        b = new PlayAssetDeliveryUnityWrapper(unityPlayer, context);
        PlayAssetDeliveryUnityWrapper.class.notifyAll();
        return b;
    }

    public void getAssetPackState(String str, IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback) {
        getAssetPackStates(new String[]{str}, iAssetPackManagerStatusQueryCallback);
    }

    public void getAssetPackStates(String[] strArr, IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback) {
        a();
        C0109j c0109j = this.f1035a;
        c0109j.b.getPackStates(Arrays.asList(strArr)).addOnCompleteListener(new C0107i(c0109j.f1106a, iAssetPackManagerStatusQueryCallback, strArr));
    }

    public void downloadAssetPack(String str, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        downloadAssetPacks(new String[]{str}, iAssetPackManagerDownloadStatusCallback);
    }

    public void downloadAssetPacks(String[] strArr, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        a();
        C0109j c0109j = this.f1035a;
        c0109j.getClass();
        if (strArr == null || strArr.length == 0) {
            return;
        }
        c0109j.b.getPackStates(Arrays.asList(strArr)).addOnCompleteListener(new C0103g(c0109j.f1106a, iAssetPackManagerDownloadStatusCallback, strArr));
    }

    public Object registerDownloadStatusListener(IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        a();
        C0109j c0109j = this.f1035a;
        C0097d c0097d = new C0097d(c0109j, c0109j.f1106a, iAssetPackManagerDownloadStatusCallback);
        c0109j.b.registerListener(c0097d);
        return c0097d;
    }

    public void unregisterDownloadStatusListener(Object obj) {
        a();
        C0109j c0109j = this.f1035a;
        c0109j.getClass();
        if (obj instanceof C0097d) {
            c0109j.b.unregisterListener((C0097d) obj);
        }
    }

    public void requestToUseMobileData(Activity activity, IAssetPackManagerMobileDataConfirmationCallback iAssetPackManagerMobileDataConfirmationCallback) {
        a();
        C0109j c0109j = this.f1035a;
        c0109j.b.showCellularDataConfirmation(activity).addOnSuccessListener(new C0101f(c0109j.f1106a, iAssetPackManagerMobileDataConfirmationCallback));
    }

    public String getAssetPackPath(String str) {
        a();
        AssetPackLocation packLocation = this.f1035a.b.getPackLocation(str);
        if (packLocation == null) {
            return "";
        }
        return packLocation.assetsPath();
    }

    public void cancelAssetPackDownload(String str) {
        cancelAssetPackDownloads(new String[]{str});
    }

    public void cancelAssetPackDownloads(String[] strArr) {
        a();
        this.f1035a.b.cancel(Arrays.asList(strArr));
    }

    public void removeAssetPack(String str) {
        a();
        this.f1035a.b.removePack(str);
    }

    public boolean playCoreApiMissing() {
        return this.f1035a == null;
    }

    private void a() {
        if (playCoreApiMissing()) {
            throw new RuntimeException("AssetPackManager API is not available! Make sure your gradle project includes 'com.google.android.play:asset-delivery' dependency.");
        }
    }
}

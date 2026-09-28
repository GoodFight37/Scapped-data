package com.unity3d.player;

import android.content.Context;
import com.google.android.play.core.assetpacks.AssetPackManager;
import com.google.android.play.core.assetpacks.AssetPackManagerFactory;
import java.util.HashSet;

/* JADX INFO: renamed from: com.unity3d.player.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0109j {
    public static C0109j e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UnityPlayer f1106a;
    public final AssetPackManager b;
    public final HashSet c;
    public C0097d d;

    public C0109j(UnityPlayer unityPlayer, Context context) {
        if (e != null) {
            throw new RuntimeException("AssetPackManagerWrapper should be created only once. Use getInstance() instead.");
        }
        this.f1106a = unityPlayer;
        this.b = AssetPackManagerFactory.getInstance(context);
        this.c = new HashSet();
    }
}

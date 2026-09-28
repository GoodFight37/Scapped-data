package com.unity3d.player;

import android.content.Context;
import android.view.OrientationEventListener;

/* JADX INFO: renamed from: com.unity3d.player.g0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0104g0 extends OrientationEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityPlayer f1103a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0104g0(UnityPlayer unityPlayer, Context context, int i) {
        super(context, i);
        this.f1103a = unityPlayer;
    }

    @Override // android.view.OrientationEventListener
    public final void onOrientationChanged(int i) {
        UnityPlayer unityPlayer = this.f1103a;
        unityPlayer.onOrientationChanged(unityPlayer.mNaturalOrientation, i);
    }
}

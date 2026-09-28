package com.unity3d.player;

import android.telephony.PhoneStateListener;

/* JADX INFO: renamed from: com.unity3d.player.k0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0112k0 extends PhoneStateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityPlayer f1108a;

    public C0112k0(UnityPlayer unityPlayer) {
        this.f1108a = unityPlayer;
    }

    @Override // android.telephony.PhoneStateListener
    public final void onCallStateChanged(int i, String str) {
        this.f1108a.nativeMuteMasterAudio(i == 1);
    }
}

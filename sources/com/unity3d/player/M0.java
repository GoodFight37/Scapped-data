package com.unity3d.player;

/* JADX INFO: loaded from: classes2.dex */
public final class M0 extends UnityPlayer.a {
    public final /* synthetic */ UnityPlayerForGameActivity b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M0(UnityPlayerForGameActivity unityPlayerForGameActivity) {
        super();
        this.b = unityPlayerForGameActivity;
    }

    @Override // com.unity3d.player.UnityPlayer.a
    public final void a() {
        this.b.nativeUnityPlayerSetRunning(false);
    }
}

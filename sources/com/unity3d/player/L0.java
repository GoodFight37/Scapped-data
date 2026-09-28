package com.unity3d.player;

/* JADX INFO: loaded from: classes2.dex */
public final class L0 extends UnityPlayer.a {
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ UnityPlayerForGameActivity d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L0(UnityPlayerForGameActivity unityPlayerForGameActivity, int i, int i2) {
        super();
        this.d = unityPlayerForGameActivity;
        this.b = i;
        this.c = i2;
    }

    @Override // com.unity3d.player.UnityPlayer.a
    public final void a() {
        this.d.nativeOrientationChanged(this.b, this.c);
    }
}

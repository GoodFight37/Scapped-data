package com.unity3d.player;

/* JADX INFO: loaded from: classes2.dex */
public final class u0 extends UnityPlayer.a {
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ UnityPlayerForActivityOrService d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u0(UnityPlayerForActivityOrService unityPlayerForActivityOrService, int i, int i2) {
        super();
        this.d = unityPlayerForActivityOrService;
        this.b = i;
        this.c = i2;
    }

    @Override // com.unity3d.player.UnityPlayer.a
    public final void a() {
        this.d.nativeSetInputSelection(this.b, this.c);
    }
}

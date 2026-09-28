package com.unity3d.player;

/* JADX INFO: loaded from: classes2.dex */
public final class w0 extends UnityPlayer.a {
    public final /* synthetic */ boolean b;
    public final /* synthetic */ UnityPlayerForActivityOrService c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w0(UnityPlayerForActivityOrService unityPlayerForActivityOrService, boolean z) {
        super();
        this.c = unityPlayerForActivityOrService;
        this.b = z;
    }

    @Override // com.unity3d.player.UnityPlayer.a
    public final void a() {
        this.c.nativeSetKeyboardIsVisible(this.b);
    }
}

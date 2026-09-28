package com.unity3d.player;

import android.graphics.Rect;

/* JADX INFO: loaded from: classes2.dex */
public final class v0 extends UnityPlayer.a {
    public final /* synthetic */ Rect b;
    public final /* synthetic */ UnityPlayerForActivityOrService c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v0(UnityPlayerForActivityOrService unityPlayerForActivityOrService, Rect rect) {
        super();
        this.c = unityPlayerForActivityOrService;
        this.b = rect;
    }

    @Override // com.unity3d.player.UnityPlayer.a
    public final void a() {
        UnityPlayerForActivityOrService unityPlayerForActivityOrService = this.c;
        Rect rect = this.b;
        unityPlayerForActivityOrService.nativeSetInputArea(rect.left, rect.top, rect.right, rect.bottom);
    }
}

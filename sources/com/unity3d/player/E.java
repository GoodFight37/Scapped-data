package com.unity3d.player;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class E extends UnityPlayer.a {
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public E(UnityPlayer unityPlayer, int i) {
        super();
        this.b = i;
        Objects.requireNonNull(unityPlayer);
    }

    @Override // com.unity3d.player.UnityPlayer.a
    public final void a() {
        UnityAccessibilityDelegate.onNodeFocusChanged(this.b, true);
    }
}

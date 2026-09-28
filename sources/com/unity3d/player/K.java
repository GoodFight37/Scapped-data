package com.unity3d.player;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class K extends UnityPlayer.a {
    public final /* synthetic */ boolean b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(UnityPlayer unityPlayer, boolean z) {
        super();
        this.b = z;
        Objects.requireNonNull(unityPlayer);
    }

    @Override // com.unity3d.player.UnityPlayer.a
    public final void a() {
        UnityAccessibilityDelegate.sendScreenReaderStatusChangedNotification(this.b);
    }
}

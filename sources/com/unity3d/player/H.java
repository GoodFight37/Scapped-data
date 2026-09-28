package com.unity3d.player;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class H extends UnityPlayer.a {
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ J d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H(J j, UnityPlayer unityPlayer, int i, int i2) {
        super();
        this.d = j;
        this.b = i;
        this.c = i2;
        Objects.requireNonNull(unityPlayer);
    }

    @Override // com.unity3d.player.UnityPlayer.a
    public final void a() {
        if (this.b == 4096) {
            UnityAccessibilityDelegate.onNodeIncremented(this.c);
        } else {
            UnityAccessibilityDelegate.onNodeDecremented(this.c);
        }
        this.d.f1025a.sendEventForVirtualViewId(this.c, 4);
    }
}

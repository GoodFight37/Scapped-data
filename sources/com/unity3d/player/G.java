package com.unity3d.player;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class G extends UnityPlayer.a {
    public final /* synthetic */ int b;
    public final /* synthetic */ J c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public G(J j, UnityPlayer unityPlayer, int i) {
        super();
        this.c = j;
        this.b = i;
        Objects.requireNonNull(unityPlayer);
    }

    @Override // com.unity3d.player.UnityPlayer.a
    public final void a() {
        if (UnityAccessibilityDelegate.onNodeSelected(this.b)) {
            this.c.f1025a.sendEventForVirtualViewId(this.b, 1);
        }
    }
}

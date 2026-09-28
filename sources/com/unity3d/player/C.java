package com.unity3d.player;

import android.content.res.Configuration;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class C extends UnityPlayer.a {
    public final /* synthetic */ Configuration b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C(UnityPlayer unityPlayer, Configuration configuration) {
        super();
        this.b = configuration;
        Objects.requireNonNull(unityPlayer);
    }

    @Override // com.unity3d.player.UnityPlayer.a
    public final void a() {
        UnityAccessibilityDelegate.sendFontScaleChangedNotification(this.b.fontScale);
    }
}

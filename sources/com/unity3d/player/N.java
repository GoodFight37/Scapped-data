package com.unity3d.player;

import android.view.accessibility.CaptioningManager;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class N extends CaptioningManager.CaptioningChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityAccessibilityDelegate f1029a;

    public N(UnityAccessibilityDelegate unityAccessibilityDelegate) {
        this.f1029a = unityAccessibilityDelegate;
        unityAccessibilityDelegate.e.addCaptioningChangeListener(this);
        onEnabledChanged(unityAccessibilityDelegate.e.isEnabled());
    }

    @Override // android.view.accessibility.CaptioningManager.CaptioningChangeListener
    public final void onEnabledChanged(boolean z) {
        UnityPlayer unityPlayer = this.f1029a.f1043a;
        Objects.requireNonNull(unityPlayer);
        this.f1029a.f1043a.invokeOnMainThread((Runnable) new M(unityPlayer, z));
    }

    public void cleanup() {
        this.f1029a.e.removeCaptioningChangeListener(this);
    }
}

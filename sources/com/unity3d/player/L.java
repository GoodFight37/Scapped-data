package com.unity3d.player;

import android.view.accessibility.AccessibilityManager;
import com.unity3d.player.UnityAccessibilityDelegate.a;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class L implements AccessibilityManager.AccessibilityStateChangeListener, AccessibilityManager.TouchExplorationStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityAccessibilityDelegate f1028a;

    public L(UnityAccessibilityDelegate unityAccessibilityDelegate) {
        this.f1028a = unityAccessibilityDelegate;
        unityAccessibilityDelegate.c.addAccessibilityStateChangeListener(this);
        unityAccessibilityDelegate.c.addTouchExplorationStateChangeListener(this);
        if (unityAccessibilityDelegate.c.isEnabled()) {
            onAccessibilityStateChanged(true);
        }
    }

    public void cleanup() {
        this.f1028a.c.removeAccessibilityStateChangeListener(this);
        this.f1028a.c.removeTouchExplorationStateChangeListener(this);
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public final void onAccessibilityStateChanged(boolean z) {
        if (z) {
            UnityAccessibilityDelegate unityAccessibilityDelegate = this.f1028a;
            unityAccessibilityDelegate.b.setAccessibilityDelegate(unityAccessibilityDelegate);
            this.f1028a.b.setWillNotDraw(false);
            onTouchExplorationStateChanged(this.f1028a.c.isTouchExplorationEnabled());
            return;
        }
        this.f1028a.b.setAccessibilityDelegate(null);
        this.f1028a.b.setWillNotDraw(true);
        onTouchExplorationStateChanged(false);
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z) {
        boolean z2 = this.f1028a.c.isEnabled() && z;
        if (z2) {
            UnityAccessibilityDelegate unityAccessibilityDelegate = this.f1028a;
            unityAccessibilityDelegate.b.setOnHoverListener(unityAccessibilityDelegate.new a());
        } else {
            this.f1028a.b.setOnHoverListener(null);
        }
        UnityAccessibilityDelegate unityAccessibilityDelegate2 = this.f1028a;
        if (unityAccessibilityDelegate2.i == z2) {
            return;
        }
        unityAccessibilityDelegate2.i = z2;
        UnityPlayer unityPlayer = unityAccessibilityDelegate2.f1043a;
        Objects.requireNonNull(unityPlayer);
        this.f1028a.f1043a.invokeOnMainThread((Runnable) new K(unityPlayer, z2));
    }
}

package com.unity3d.player;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class J extends AccessibilityNodeProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityAccessibilityDelegate f1025a;

    public J(UnityAccessibilityDelegate unityAccessibilityDelegate) {
        this.f1025a = unityAccessibilityDelegate;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        if (i == -1) {
            AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(this.f1025a.b);
            Object parent = this.f1025a.b.getParent();
            if (parent instanceof View) {
                accessibilityNodeInfoObtain.setParent((View) parent);
            }
            int[] rootNodeIds = UnityAccessibilityDelegate.getRootNodeIds();
            if (rootNodeIds != null) {
                for (int i2 : rootNodeIds) {
                    accessibilityNodeInfoObtain.addChild(this.f1025a.b, i2);
                }
            }
            return accessibilityNodeInfoObtain;
        }
        AccessibilityNodeInfo accessibilityNodeInfoObtain2 = AccessibilityNodeInfo.obtain();
        if (UnityAccessibilityDelegate.populateNodeInfo(accessibilityNodeInfoObtain2, i, this.f1025a.b)) {
            return accessibilityNodeInfoObtain2;
        }
        return null;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final boolean performAction(int i, int i2, Bundle bundle) {
        if (i2 == 64) {
            return this.f1025a.sendEventForVirtualViewId(i, 32768);
        }
        if (i2 == 128) {
            return this.f1025a.sendEventForVirtualViewId(i, 65536);
        }
        if (i2 == 16) {
            if (!UnityAccessibilityDelegate.isNodeSelectable(i)) {
                return false;
            }
            UnityPlayer unityPlayer = this.f1025a.f1043a;
            Objects.requireNonNull(unityPlayer);
            this.f1025a.f1043a.invokeOnMainThread((Runnable) new G(this, unityPlayer, i));
            return true;
        }
        if (i2 == 4096 || i2 == 8192) {
            UnityPlayer unityPlayer2 = this.f1025a.f1043a;
            Objects.requireNonNull(unityPlayer2);
            this.f1025a.f1043a.invokeOnMainThread((Runnable) new H(this, unityPlayer2, i2, i));
            return true;
        }
        if (i2 != 1048576 || !UnityAccessibilityDelegate.isNodeDismissable(i)) {
            return false;
        }
        UnityPlayer unityPlayer3 = this.f1025a.f1043a;
        Objects.requireNonNull(unityPlayer3);
        this.f1025a.f1043a.invokeOnMainThread((Runnable) new I(unityPlayer3, i));
        return true;
    }
}

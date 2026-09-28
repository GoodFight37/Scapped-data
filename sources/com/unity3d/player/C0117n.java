package com.unity3d.player;

import android.app.Activity;
import android.app.Dialog;
import android.window.OnBackInvokedDispatcher;
import com.unity3d.player.a.AbstractC0072e;
import com.unity3d.player.a.C0071d;
import com.unity3d.player.a.C0091y;

/* JADX INFO: renamed from: com.unity3d.player.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0117n extends C0091y {
    public C0071d d;
    public final OnBackInvokedDispatcher e;
    public final int f;

    public C0117n(OnBackInvokedDispatcher onBackInvokedDispatcher, int i, Runnable runnable) {
        super(runnable);
        this.d = null;
        this.f = i;
        this.e = onBackInvokedDispatcher;
    }

    public static C0091y a(Object obj, int i, Runnable runnable) {
        C0091y c0091y;
        if (PlatformSupport.TIRAMISU_SUPPORT && ((obj instanceof Activity) || (obj instanceof Dialog))) {
            c0091y = new C0117n(AbstractC0072e.a(obj), i, runnable);
        } else {
            c0091y = new C0091y(runnable);
        }
        c0091y.registerOnBackPressedCallback();
        return c0091y;
    }

    @Override // com.unity3d.player.a.C0091y
    public void registerOnBackPressedCallback() {
        if (this.f1091a != null) {
            return;
        }
        super.registerOnBackPressedCallback();
        if (PlatformSupport.TIRAMISU_SUPPORT) {
            C0071d c0071d = new C0071d(this.f1091a);
            this.d = c0071d;
            AbstractC0072e.a(this.e, this.f, c0071d);
        }
    }

    @Override // com.unity3d.player.a.C0091y
    public void unregisterOnBackPressedCallback() {
        if (this.f1091a != null) {
            if (PlatformSupport.TIRAMISU_SUPPORT) {
                AbstractC0072e.a(this.e, this.d);
                this.d = null;
            }
            super.unregisterOnBackPressedCallback();
        }
    }
}

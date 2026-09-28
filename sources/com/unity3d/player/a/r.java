package com.unity3d.player.a;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.unity3d.player.UnityPlayerForActivityOrService;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UnityPlayerForActivityOrService f1086a;
    public final com.unity3d.player.P b;

    public r(Context context, UnityPlayerForActivityOrService unityPlayerForActivityOrService) {
        super(context);
        this.f1086a = unityPlayerForActivityOrService;
        com.unity3d.player.P p = new com.unity3d.player.P(unityPlayerForActivityOrService);
        this.b = p;
        addView(p);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.f1086a.injectEvent(keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.f1086a.injectEvent(keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return this.f1086a.injectEvent(keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return this.f1086a.injectEvent(keyEvent);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        C0073f c0073f = this.b.f1033a;
        if (c0073f == null || c0073f.f1075a <= 0.0f) {
            return this.f1086a.injectEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        C0073f c0073f = this.b.f1033a;
        if (c0073f == null || c0073f.f1075a <= 0.0f) {
            return this.f1086a.injectEvent(motionEvent);
        }
        return false;
    }
}

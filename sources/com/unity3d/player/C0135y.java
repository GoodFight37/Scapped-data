package com.unity3d.player;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.EditText;
import android.widget.FrameLayout;

/* JADX INFO: renamed from: com.unity3d.player.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0135y extends AbstractC0129t {
    public boolean h;
    public Handler i;
    public RunnableC0133w j;

    @Override // com.unity3d.player.AbstractC0129t
    public final boolean c() {
        return false;
    }

    public C0135y(Context context, UnityPlayerForActivityOrService unityPlayerForActivityOrService) {
        super(context, unityPlayerForActivityOrService);
        this.h = false;
    }

    @Override // com.unity3d.player.AbstractC0129t
    public final void d() {
        if (this.h) {
            return;
        }
        FrameLayout frameLayout = this.b.getFrameLayout();
        frameLayout.addView(this.c);
        frameLayout.bringChildToFront(this.c);
        this.c.setVisibility(0);
        this.c.requestFocus();
        this.j = new RunnableC0133w(this);
        Handler handler = new Handler(Looper.getMainLooper());
        this.i = handler;
        handler.postDelayed(this.j, 400L);
        this.h = true;
    }

    @Override // com.unity3d.player.AbstractC0129t
    public final void b() {
        RunnableC0133w runnableC0133w;
        Handler handler = this.i;
        if (handler != null && (runnableC0133w = this.j) != null) {
            handler.removeCallbacks(runnableC0133w);
        }
        this.b.getFrameLayout().removeView(this.c);
        this.h = false;
        invokeOnClose();
    }

    @Override // com.unity3d.player.AbstractC0129t
    public EditText createEditText(AbstractC0129t abstractC0129t) {
        return new C0134x(this.f1121a, abstractC0129t);
    }

    @Override // com.unity3d.player.AbstractC0129t
    public final void a(boolean z) {
        this.d = z;
        if (z) {
            this.c.setVisibility(4);
        } else {
            this.c.setVisibility(0);
        }
        this.c.invalidate();
        this.c.requestLayout();
    }
}

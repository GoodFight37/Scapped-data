package com.unity3d.player.a;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes2.dex */
public final class A implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ B f1050a;

    public A(B b) {
        this.f1050a = b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1050a.b.setBackground(new LayerDrawable(new Drawable[]{new ColorDrawable(ViewCompat.MEASURED_STATE_MASK), new BitmapDrawable(this.f1050a.b.getResources(), this.f1050a.b.f1052a)}));
    }
}

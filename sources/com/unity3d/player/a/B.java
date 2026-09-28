package com.unity3d.player.a;

import android.app.Activity;
import android.content.Context;
import android.view.PixelCopy;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes2.dex */
public final class B implements PixelCopy.OnPixelCopyFinishedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Semaphore f1051a;
    public final /* synthetic */ C b;

    public B(C c, Semaphore semaphore) {
        this.b = c;
        this.f1051a = semaphore;
    }

    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
    public final void onPixelCopyFinished(int i) {
        this.f1051a.release();
        if (i == 0) {
            Context context = this.b.b.f1053a;
            if (context instanceof Activity) {
                ((Activity) context).runOnUiThread(new A(this));
            }
        }
    }
}

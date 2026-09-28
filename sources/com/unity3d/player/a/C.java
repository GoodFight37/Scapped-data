package com.unity3d.player.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.PixelCopy;
import android.view.SurfaceView;
import android.view.View;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class C extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bitmap f1052a;
    public final /* synthetic */ D b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C(D d, Context context) {
        super(context);
        this.b = d;
    }

    public final void a(SurfaceView surfaceView) {
        this.f1052a = Bitmap.createBitmap(surfaceView.getWidth(), surfaceView.getHeight(), Bitmap.Config.ARGB_8888);
        HandlerThread handlerThread = new HandlerThread("PlaceHolderView");
        handlerThread.start();
        Semaphore semaphore = new Semaphore(0);
        PixelCopy.request(surfaceView, this.f1052a, new B(this, semaphore), new Handler(handlerThread.getLooper()));
        try {
            if (!semaphore.tryAcquire(2000L, TimeUnit.MILLISECONDS)) {
                AbstractC0086t.Log(5, "Timeout while copying surface view.");
            }
        } catch (InterruptedException e) {
            AbstractC0086t.Log(6, e.getMessage());
        }
        handlerThread.quitSafely();
    }
}

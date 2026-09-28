package com.unity3d.player.a;

import android.media.Image;
import android.media.ImageReader;
import com.unity3d.player.Camera2Wrapper;
import java.util.concurrent.Semaphore;

/* JADX INFO: renamed from: com.unity3d.player.a.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0080m implements ImageReader.OnImageAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0083p f1081a;

    public C0080m(C0083p c0083p) {
        this.f1081a = c0083p;
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    public final void onImageAvailable(ImageReader imageReader) {
        Semaphore semaphore = C0083p.D;
        if (semaphore.tryAcquire()) {
            Image imageAcquireNextImage = imageReader.acquireNextImage();
            if (imageAcquireNextImage != null) {
                Image.Plane[] planes = imageAcquireNextImage.getPlanes();
                if (imageAcquireNextImage.getFormat() == 35 && planes != null && planes.length == 3) {
                    ((Camera2Wrapper) this.f1081a.f1084a).a(planes[0].getBuffer(), planes[1].getBuffer(), planes[2].getBuffer(), planes[0].getRowStride(), planes[1].getRowStride(), planes[1].getPixelStride());
                } else {
                    AbstractC0086t.Log(6, "Camera2: Wrong image format.");
                }
                Image image = this.f1081a.p;
                if (image != null) {
                    image.close();
                }
                this.f1081a.p = imageAcquireNextImage;
            }
            semaphore.release();
        }
    }
}

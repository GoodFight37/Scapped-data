package com.unity3d.player.a;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;

/* JADX INFO: renamed from: com.unity3d.player.a.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0078k extends CameraCaptureSession.StateCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0083p f1079a;

    public C0078k(C0083p c0083p) {
        this.f1079a = c0083p;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onConfigured(CameraCaptureSession cameraCaptureSession) {
        C0083p c0083p = this.f1079a;
        if (c0083p.b == null) {
            return;
        }
        synchronized (c0083p.s) {
            C0083p c0083p2 = this.f1079a;
            c0083p2.r = cameraCaptureSession;
            try {
                c0083p2.q = c0083p2.b.createCaptureRequest(1);
                C0083p c0083p3 = this.f1079a;
                c0083p3.q.addTarget(c0083p3.v);
                C0083p c0083p4 = this.f1079a;
                c0083p4.q.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, c0083p4.n);
                this.f1079a.e();
            } catch (CameraAccessException e) {
                AbstractC0086t.Log(6, "Camera2: CameraAccessException " + e);
            } catch (IllegalStateException e2) {
                AbstractC0086t.Log(6, "Camera2: IllegalStateException " + e2);
            }
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        AbstractC0086t.Log(6, "Camera2: CaptureSession configuration failed.");
    }
}

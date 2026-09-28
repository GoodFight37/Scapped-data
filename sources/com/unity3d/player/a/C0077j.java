package com.unity3d.player.a;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;

/* JADX INFO: renamed from: com.unity3d.player.a.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0077j extends CameraCaptureSession.CaptureCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0083p f1078a;

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public final void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int i) {
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public final void onCaptureSequenceCompleted(CameraCaptureSession cameraCaptureSession, int i, long j) {
    }

    public C0077j(C0083p c0083p) {
        this.f1078a = c0083p;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public final void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        this.f1078a.a(captureRequest.getTag());
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public final void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
        AbstractC0086t.Log(5, "Camera2: Capture session failed " + captureRequest.getTag() + " reason " + captureFailure.getReason());
        this.f1078a.a(captureRequest.getTag());
    }
}

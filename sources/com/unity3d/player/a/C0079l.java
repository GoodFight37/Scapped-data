package com.unity3d.player.a;

import android.hardware.camera2.CameraDevice;

/* JADX INFO: renamed from: com.unity3d.player.a.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0079l extends CameraDevice.StateCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0083p f1080a;

    public C0079l(C0083p c0083p) {
        this.f1080a = c0083p;
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onOpened(CameraDevice cameraDevice) {
        this.f1080a.b = cameraDevice;
        C0083p.D.release();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onClosed(CameraDevice cameraDevice) {
        C0083p.D.release();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onDisconnected(CameraDevice cameraDevice) {
        AbstractC0086t.Log(5, "Camera2: CameraDevice disconnected.");
        this.f1080a.a(cameraDevice);
        C0083p.D.release();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onError(CameraDevice cameraDevice, int i) {
        AbstractC0086t.Log(6, "Camera2: Error opeining CameraDevice " + i);
        this.f1080a.a(cameraDevice);
        C0083p.D.release();
    }
}

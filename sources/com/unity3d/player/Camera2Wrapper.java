package com.unity3d.player;

import android.content.Context;
import android.graphics.Rect;
import android.view.Surface;
import com.unity3d.player.a.AbstractC0086t;
import com.unity3d.player.a.C0083p;
import com.unity3d.player.a.InterfaceC0085s;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class Camera2Wrapper implements InterfaceC0085s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1015a;
    public C0083p b = null;

    private final native void initCamera2Jni();

    private final native void nativeFrameReady(Object obj, Object obj2, Object obj3, int i, int i2, int i3);

    private final native void nativeSurfaceTextureReady(Object obj);

    public Camera2Wrapper(Context context) {
        this.f1015a = context;
        initCamera2Jni();
    }

    public int getCamera2Count() {
        return C0083p.a(this.f1015a).length;
    }

    public int getCamera2SensorOrientation(int i) {
        return C0083p.c(this.f1015a, i);
    }

    public boolean isCamera2FrontFacing(int i) {
        return C0083p.e(this.f1015a, i);
    }

    public int getCamera2FocalLengthEquivalent(int i) {
        return C0083p.a(this.f1015a, i);
    }

    public int[] getCamera2Resolutions(int i) {
        return C0083p.b(this.f1015a, i);
    }

    public boolean initializeCamera2(int i, int i2, int i3, int i4, int i5, Surface surface) {
        if (this.b != null || UnityPlayer.currentActivity == null) {
            return false;
        }
        C0083p c0083p = new C0083p(this);
        this.b = c0083p;
        return c0083p.a(this.f1015a, i, i2, i3, i4, i5, surface);
    }

    public boolean isCamera2AutoFocusPointSupported(int i) {
        return C0083p.d(this.f1015a, i);
    }

    public boolean setAutoFocusPoint(float f, float f2) {
        C0083p c0083p = this.b;
        if (c0083p != null && c0083p.h > 0) {
            if (!c0083p.m) {
                c0083p.i = f;
                c0083p.j = f2;
                synchronized (c0083p.s) {
                    if (c0083p.r != null && c0083p.A != 2) {
                        c0083p.d();
                    }
                }
                return true;
            }
            AbstractC0086t.Log(5, "Camera2: Setting manual focus point already started.");
        }
        return false;
    }

    public Rect getFrameSizeCamera2() {
        C0083p c0083p = this.b;
        if (c0083p == null) {
            return new Rect();
        }
        return c0083p.e;
    }

    public void closeCamera2() {
        C0083p c0083p = this.b;
        if (c0083p != null) {
            c0083p.a();
        }
        this.b = null;
    }

    public void startCamera2() {
        C0083p c0083p = this.b;
        if (c0083p != null) {
            c0083p.f();
        }
    }

    public void pauseCamera2() {
        C0083p c0083p = this.b;
        if (c0083p != null) {
            c0083p.c();
        }
    }

    public void stopCamera2() {
        C0083p c0083p = this.b;
        if (c0083p != null) {
            c0083p.g();
        }
    }

    public final void a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, int i2, int i3) {
        nativeFrameReady(byteBuffer, byteBuffer2, byteBuffer3, i, i2, i3);
    }

    public final void a(Object obj) {
        nativeSurfaceTextureReady(obj);
    }
}

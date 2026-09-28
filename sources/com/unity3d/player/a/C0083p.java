package com.unity3d.player.a;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Range;
import android.util.Size;
import android.util.SizeF;
import android.view.Surface;
import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.unity3d.player.a.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0083p {
    public static CameraManager B;
    public static String[] C;
    public static final Semaphore D = new Semaphore(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0085s f1084a;
    public CameraDevice b;
    public HandlerThread c;
    public Handler d;
    public Rect e;
    public Rect f;
    public int g;
    public int h;
    public int k;
    public int l;
    public Range n;
    public Image p;
    public CaptureRequest.Builder q;
    public int t;
    public SurfaceTexture u;
    public float i = -1.0f;
    public float j = -1.0f;
    public boolean m = false;
    public ImageReader o = null;
    public CameraCaptureSession r = null;
    public final Object s = new Object();
    public Surface v = null;
    public int A = 3;
    public C0077j w = new C0077j(this);
    public final C0079l x = new C0079l(this);
    public final C0080m y = new C0080m(this);
    public final C0081n z = new C0081n(this);

    public C0083p(InterfaceC0085s interfaceC0085s) {
        this.f1084a = null;
        this.f1084a = interfaceC0085s;
        HandlerThread handlerThread = new HandlerThread("CameraBackground");
        this.c = handlerThread;
        handlerThread.start();
        this.d = new Handler(this.c.getLooper());
    }

    public static CameraManager b(Context context) {
        if (B == null) {
            B = (CameraManager) context.getSystemService("camera");
        }
        return B;
    }

    public static String[] a(Context context) {
        if (C == null) {
            try {
                C = b(context).getCameraIdList();
            } catch (CameraAccessException e) {
                AbstractC0086t.Log(6, "Camera2: CameraAccessException " + e);
                C = new String[0];
            }
        }
        return C;
    }

    public static int c(Context context, int i) {
        try {
            return ((Integer) b(context).getCameraCharacteristics(a(context)[i]).get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
        } catch (CameraAccessException e) {
            AbstractC0086t.Log(6, "Camera2: CameraAccessException " + e);
            return 0;
        }
    }

    public static boolean e(Context context, int i) {
        try {
            return ((Integer) b(context).getCameraCharacteristics(a(context)[i]).get(CameraCharacteristics.LENS_FACING)).intValue() == 0;
        } catch (CameraAccessException e) {
            AbstractC0086t.Log(6, "Camera2: CameraAccessException " + e);
            return false;
        }
    }

    public static boolean d(Context context, int i) {
        try {
            return ((Integer) b(context).getCameraCharacteristics(a(context)[i]).get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue() > 0;
        } catch (CameraAccessException e) {
            AbstractC0086t.Log(6, "Camera2: CameraAccessException " + e);
            return false;
        }
    }

    public static int a(Context context, int i) {
        try {
            CameraCharacteristics cameraCharacteristics = b(context).getCameraCharacteristics(a(context)[i]);
            float[] fArr = (float[]) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);
            SizeF sizeF = (SizeF) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE);
            if (fArr.length > 0) {
                return (int) ((fArr[0] * 36.0f) / sizeF.getWidth());
            }
        } catch (CameraAccessException e) {
            AbstractC0086t.Log(6, "Camera2: CameraAccessException " + e);
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002f  */
    /* JADX WARN: Code duplicated, block: B:17:0x0038 A[LOOP:0: B:15:0x0035->B:17:0x0038, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:19:0x0050 A[RETURN] */
    public static int[] b(Context context, int i) {
        Size[] outputSizes;
        int[] iArr;
        int i2;
        try {
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) b(context).getCameraCharacteristics(a(context)[i]).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if (streamConfigurationMap == null) {
                AbstractC0086t.Log(6, "Camera2: configuration map is not available.");
            } else {
                outputSizes = streamConfigurationMap.getOutputSizes(35);
                if (outputSizes == null || outputSizes.length == 0) {
                }
                if (outputSizes != null) {
                    return null;
                }
                iArr = new int[outputSizes.length * 2];
                for (i2 = 0; i2 < outputSizes.length; i2++) {
                    int i3 = i2 * 2;
                    iArr[i3] = outputSizes[i2].getWidth();
                    iArr[i3 + 1] = outputSizes[i2].getHeight();
                }
                return iArr;
            }
            outputSizes = null;
            if (outputSizes != null) {
                return null;
            }
            iArr = new int[outputSizes.length * 2];
            while (i2 < outputSizes.length) {
                int i4 = i2 * 2;
                iArr[i4] = outputSizes[i2].getWidth();
                iArr[i4 + 1] = outputSizes[i2].getHeight();
            }
            return iArr;
        } catch (CameraAccessException e) {
            AbstractC0086t.Log(6, "Camera2: CameraAccessException " + e);
            return null;
        }
    }

    public final boolean a(Context context, int i, int i2, int i3, int i4, int i5, Surface surface) {
        int iIntValue = i4;
        try {
            CameraCharacteristics cameraCharacteristics = B.getCameraCharacteristics(a(context)[i]);
            if (((Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue() == 2) {
                AbstractC0086t.Log(5, "Camera2: only LEGACY hardware level is supported.");
            }
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            Size[] sizeArr = null;
            if (streamConfigurationMap == null) {
                AbstractC0086t.Log(6, "Camera2: configuration map is not available.");
            } else {
                Size[] outputSizes = streamConfigurationMap.getOutputSizes(35);
                if (outputSizes != null && outputSizes.length != 0) {
                    sizeArr = outputSizes;
                }
            }
            if (sizeArr == null || sizeArr.length == 0) {
                return false;
            }
            double d = i2;
            double d2 = i3;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            double d3 = Double.MAX_VALUE;
            while (i6 < sizeArr.length) {
                int width = sizeArr[i6].getWidth();
                int height = sizeArr[i6].getHeight();
                CameraCharacteristics cameraCharacteristics2 = cameraCharacteristics;
                double d4 = d;
                double dAbs = Math.abs(Math.log(d2 / ((double) height))) + Math.abs(Math.log(d / ((double) width)));
                if (dAbs < d3) {
                    i7 = height;
                    d3 = dAbs;
                    i8 = width;
                }
                i6++;
                cameraCharacteristics = cameraCharacteristics2;
                d = d4;
            }
            CameraCharacteristics cameraCharacteristics3 = cameraCharacteristics;
            this.e = new Rect(0, 0, i8, i7);
            Range[] rangeArr = (Range[]) cameraCharacteristics3.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
            if (rangeArr == null || rangeArr.length == 0) {
                AbstractC0086t.Log(6, "Camera2: target FPS ranges are not avialable.");
                return false;
            }
            int i9 = -1;
            int i10 = 0;
            double d5 = Double.MAX_VALUE;
            while (true) {
                if (i10 >= rangeArr.length) {
                    iIntValue = ((Integer) (iIntValue > ((Integer) rangeArr[i9].getUpper()).intValue() ? rangeArr[i9].getUpper() : rangeArr[i9].getLower())).intValue();
                    break;
                }
                int iIntValue2 = ((Integer) rangeArr[i10].getLower()).intValue();
                int iIntValue3 = ((Integer) rangeArr[i10].getUpper()).intValue();
                float f = iIntValue;
                if (f + 0.1f > iIntValue2 && f - 0.1f < iIntValue3) {
                    break;
                }
                double dMin = Math.min(Math.abs(iIntValue - iIntValue2), Math.abs(iIntValue - iIntValue3));
                if (dMin < d5) {
                    i9 = i10;
                    d5 = dMin;
                }
                i10++;
            }
            this.n = new Range(Integer.valueOf(iIntValue), Integer.valueOf(iIntValue));
            try {
                if (!D.tryAcquire(4L, TimeUnit.SECONDS)) {
                    AbstractC0086t.Log(5, "Camera2: Timeout waiting to lock camera for opening.");
                    return false;
                }
                try {
                    B.openCamera(a(context)[i], this.x, this.d);
                } catch (CameraAccessException e) {
                    AbstractC0086t.Log(6, "Camera2: CameraAccessException " + e);
                    D.release();
                    return false;
                } catch (IllegalArgumentException e2) {
                    AbstractC0086t.Log(6, "Camera2: IllegalArgumentException " + e2);
                } catch (SecurityException e3) {
                    AbstractC0086t.Log(6, "Camera2: SecurityException " + e3);
                }
                try {
                    Semaphore semaphore = D;
                    if (!semaphore.tryAcquire(4L, TimeUnit.SECONDS)) {
                        AbstractC0086t.Log(5, "Camera2: Timeout waiting to open camera.");
                        return false;
                    }
                    semaphore.release();
                    this.t = i5;
                    this.v = surface;
                    int iIntValue4 = ((Integer) cameraCharacteristics3.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue();
                    this.h = iIntValue4;
                    if (iIntValue4 > 0) {
                        Rect rect = (Rect) cameraCharacteristics3.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
                        this.f = rect;
                        float fWidth = rect.width() / this.f.height();
                        float fWidth2 = this.e.width() / this.e.height();
                        if (fWidth2 > fWidth) {
                            this.k = 0;
                            this.l = (int) ((this.f.height() - (this.f.width() / fWidth2)) / 2.0f);
                        } else {
                            this.l = 0;
                            this.k = (int) ((this.f.width() - (this.f.height() * fWidth2)) / 2.0f);
                        }
                        this.g = Math.min(this.f.width(), this.f.height()) / 20;
                    }
                    return this.b != null;
                } catch (InterruptedException e4) {
                    AbstractC0086t.Log(6, "Camera2: Interrupted while waiting to open camera " + e4);
                }
            } catch (InterruptedException e5) {
                AbstractC0086t.Log(6, "Camera2: Interrupted while trying to lock camera for opening " + e5);
                return false;
            }
        } catch (CameraAccessException e6) {
            AbstractC0086t.Log(6, "Camera2: CameraAccessException " + e6);
            return false;
        }
    }

    public final void a() {
        if (this.b != null) {
            g();
            b();
            this.w = null;
            this.v = null;
            this.u = null;
            Image image = this.p;
            if (image != null) {
                image.close();
                this.p = null;
            }
            ImageReader imageReader = this.o;
            if (imageReader != null) {
                imageReader.close();
                this.o = null;
            }
        }
        this.c.quit();
        try {
            this.c.join(4000L);
            this.c = null;
            this.d = null;
        } catch (InterruptedException e) {
            this.c.interrupt();
            AbstractC0086t.Log(6, "Camera2: Interrupted while waiting for the background thread to finish " + e);
        }
    }

    public final void b() {
        try {
            Semaphore semaphore = D;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            if (!semaphore.tryAcquire(4L, timeUnit)) {
                AbstractC0086t.Log(5, "Camera2: Timeout waiting to lock camera for closing.");
                return;
            }
            this.b.close();
            try {
                if (!semaphore.tryAcquire(4L, timeUnit)) {
                    AbstractC0086t.Log(5, "Camera2: Timeout waiting to close camera.");
                }
            } catch (InterruptedException e) {
                AbstractC0086t.Log(6, "Camera2: Interrupted while waiting to close camera " + e);
            }
            this.b = null;
            D.release();
        } catch (InterruptedException e2) {
            AbstractC0086t.Log(6, "Camera2: Interrupted while trying to lock camera for closing " + e2);
        }
    }

    public final void a(Object obj) {
        if (obj == "Focus") {
            this.m = false;
            synchronized (this.s) {
                if (this.r != null) {
                    try {
                        this.q.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
                        this.q.setTag("Regular");
                        this.r.setRepeatingRequest(this.q.build(), this.w, this.d);
                    } catch (CameraAccessException e) {
                        AbstractC0086t.Log(6, "Camera2: CameraAccessException " + e);
                    }
                }
            }
            return;
        }
        if (obj == "Cancel focus") {
            synchronized (this.s) {
                if (this.r != null) {
                    e();
                }
            }
        }
    }

    public final void e() {
        try {
            if (this.h != 0) {
                float f = this.i;
                if (f >= 0.0f && f <= 1.0f) {
                    float f2 = this.j;
                    if (f2 >= 0.0f && f2 <= 1.0f) {
                        this.m = true;
                        int iWidth = this.f.width();
                        int i = this.k;
                        int i2 = (int) (((iWidth - (i * 2)) * this.i) + i);
                        int iHeight = this.f.height();
                        int i3 = this.l;
                        int i4 = (int) (((1.0d - ((double) this.j)) * ((double) (iHeight - (i3 * 2)))) + ((double) i3));
                        int iMax = Math.max(this.g + 1, Math.min(i2, (this.f.width() - this.g) - 1));
                        int iMax2 = Math.max(this.g + 1, Math.min(i4, (this.f.height() - this.g) - 1));
                        CaptureRequest.Builder builder = this.q;
                        CaptureRequest.Key key = CaptureRequest.CONTROL_AF_REGIONS;
                        int i5 = this.g;
                        int i6 = i5 * 2;
                        builder.set(key, new MeteringRectangle[]{new MeteringRectangle(iMax - i5, iMax2 - i5, i6, i6, 999)});
                        this.q.set(CaptureRequest.CONTROL_AF_MODE, 1);
                        this.q.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
                        this.q.setTag("Focus");
                        this.r.capture(this.q.build(), this.w, this.d);
                        return;
                    }
                }
            }
            this.q.set(CaptureRequest.CONTROL_AF_MODE, 4);
            this.q.setTag("Regular");
            CameraCaptureSession cameraCaptureSession = this.r;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.setRepeatingRequest(this.q.build(), this.w, this.d);
            }
        } catch (CameraAccessException e) {
            AbstractC0086t.Log(6, "Camera2: CameraAccessException " + e);
        }
    }

    public final void d() {
        try {
            CameraCaptureSession cameraCaptureSession = this.r;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.stopRepeating();
                this.q.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
                this.q.set(CaptureRequest.CONTROL_AF_MODE, 0);
                this.q.setTag("Cancel focus");
                this.r.capture(this.q.build(), this.w, this.d);
            }
        } catch (CameraAccessException e) {
            AbstractC0086t.Log(6, "Camera2: CameraAccessException " + e);
        }
    }

    public void f() {
        if (this.t != 0) {
            if (this.v == null) {
                SurfaceTexture surfaceTexture = new SurfaceTexture(this.t);
                this.u = surfaceTexture;
                surfaceTexture.setDefaultBufferSize(this.e.width(), this.e.height());
                this.u.setOnFrameAvailableListener(this.z, this.d);
                this.v = new Surface(this.u);
            }
        } else if (this.v == null && this.o == null) {
            ImageReader imageReaderNewInstance = ImageReader.newInstance(this.e.width(), this.e.height(), 35, 2);
            this.o = imageReaderNewInstance;
            imageReaderNewInstance.setOnImageAvailableListener(this.y, this.d);
            this.p = null;
            this.v = this.o.getSurface();
        }
        try {
            CameraCaptureSession cameraCaptureSession = this.r;
            if (cameraCaptureSession != null) {
                if (this.A == 2) {
                    cameraCaptureSession.setRepeatingRequest(this.q.build(), this.w, this.d);
                }
            } else {
                this.b.createCaptureSession(Arrays.asList(this.v), new C0078k(this), this.d);
            }
            this.A = 1;
        } catch (CameraAccessException e) {
            AbstractC0086t.Log(6, "Camera2: CameraAccessException " + e);
        }
    }

    public final void c() {
        synchronized (this.s) {
            CameraCaptureSession cameraCaptureSession = this.r;
            if (cameraCaptureSession != null) {
                try {
                    cameraCaptureSession.stopRepeating();
                    this.A = 2;
                } catch (CameraAccessException e) {
                    AbstractC0086t.Log(6, "Camera2: CameraAccessException " + e);
                }
            }
        }
    }

    public final void g() {
        synchronized (this.s) {
            CameraCaptureSession cameraCaptureSession = this.r;
            if (cameraCaptureSession != null) {
                try {
                    cameraCaptureSession.abortCaptures();
                } catch (CameraAccessException e) {
                    AbstractC0086t.Log(6, "Camera2: CameraAccessException " + e);
                }
                this.r.close();
                this.r = null;
                this.A = 3;
            }
        }
    }

    public final void a(CameraDevice cameraDevice) {
        synchronized (this.s) {
            this.r = null;
        }
        cameraDevice.close();
        this.b = null;
    }
}

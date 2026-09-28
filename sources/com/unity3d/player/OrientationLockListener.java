package com.unity3d.player;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;

/* JADX INFO: loaded from: classes2.dex */
public class OrientationLockListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.unity3d.player.a.L f1032a;
    public final Context b;

    public final native void nativeUpdateOrientationLockState(int i);

    public OrientationLockListener(Context context) {
        this.b = context;
        this.f1032a = new com.unity3d.player.a.L(context);
        nativeUpdateOrientationLockState(Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", 0));
        com.unity3d.player.a.L l = this.f1032a;
        l.getClass();
        l.b = new com.unity3d.player.a.K(new Handler(Looper.getMainLooper()), this);
        l.f1060a.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), true, l.b);
    }
}

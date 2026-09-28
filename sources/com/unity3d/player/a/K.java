package com.unity3d.player.a;

import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import com.unity3d.player.OrientationLockListener;

/* JADX INFO: loaded from: classes2.dex */
public final class K extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OrientationLockListener f1059a;

    public K(Handler handler, OrientationLockListener orientationLockListener) {
        super(handler);
        this.f1059a = orientationLockListener;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        OrientationLockListener orientationLockListener = this.f1059a;
        if (orientationLockListener != null) {
            orientationLockListener.nativeUpdateOrientationLockState(Settings.System.getInt(orientationLockListener.b.getContentResolver(), "accelerometer_rotation", 0));
        }
    }
}

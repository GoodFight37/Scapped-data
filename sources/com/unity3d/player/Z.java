package com.unity3d.player;

import android.os.SystemClock;
import android.view.KeyEvent;
import androidx.core.view.InputDeviceCompat;

/* JADX INFO: loaded from: classes2.dex */
public final class Z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityPlayer f1049a;

    public Z(UnityPlayer unityPlayer) {
        this.f1049a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        KeyEvent keyEvent = new KeyEvent(jUptimeMillis, jUptimeMillis, 0, 4, 1, 0, -1, 0, 0, InputDeviceCompat.SOURCE_KEYBOARD);
        KeyEvent keyEvent2 = new KeyEvent(jUptimeMillis, jUptimeMillis + 1, 1, 4, 1, 0, -1, 0, 0, InputDeviceCompat.SOURCE_KEYBOARD);
        this.f1049a.getActivity().dispatchKeyEvent(keyEvent);
        this.f1049a.getActivity().dispatchKeyEvent(keyEvent2);
    }
}

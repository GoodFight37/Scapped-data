package com.unity3d.player;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes2.dex */
public final class Q implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ T f1036a;

    public Q(T t) {
        this.f1036a = t;
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00c4  */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 2269) {
            return false;
        }
        S s = (S) message.obj;
        S s2 = S.h;
        if (s == s2) {
            T t = this.f1036a;
            t.g--;
            t.f1041a.executeMainThreadJobs();
            T t2 = this.f1036a;
            if (!t2.d) {
                return true;
            }
            if (t2.f1041a.getHaveAndroidWindowSupport() && !this.f1036a.e) {
                return true;
            }
            T t3 = this.f1036a;
            int i = t3.j;
            if (i >= 0) {
                if (i == 0) {
                    if (t3.f1041a.getSplashEnabled()) {
                        this.f1036a.f1041a.disableStaticSplashScreen();
                    }
                    if (this.f1036a.f1041a.shouldReportFullyDrawn()) {
                        this.f1036a.f1041a.reportFullyDrawn();
                    }
                }
                this.f1036a.j--;
            }
            if (!this.f1036a.f1041a.isFinishing() && !this.f1036a.f1041a.nativeRender()) {
                this.f1036a.f1041a.finish();
            }
        } else if (s == S.c) {
            Looper.myLooper().quit();
        } else if (s == S.b) {
            this.f1036a.d = true;
        } else if (s == S.f1039a) {
            this.f1036a.d = false;
        } else if (s == S.d) {
            this.f1036a.e = false;
        } else if (s == S.e) {
            T t4 = this.f1036a;
            t4.e = true;
            if (t4.f == 3 && (!t4.f1041a.getHaveAndroidWindowSupport() || this.f1036a.e)) {
                this.f1036a.f1041a.nativeFocusChanged(true);
                this.f1036a.f = 1;
            }
        } else if (s == S.f) {
            T t5 = this.f1036a;
            if (t5.f == 1) {
                t5.f1041a.nativeFocusChanged(false);
            }
            this.f1036a.f = 2;
        } else if (s == S.g) {
            T t6 = this.f1036a;
            t6.f = 3;
            if (!t6.f1041a.getHaveAndroidWindowSupport() || this.f1036a.e) {
                this.f1036a.f1041a.nativeFocusChanged(true);
                this.f1036a.f = 1;
            }
        } else if (s == S.i) {
            T t7 = this.f1036a;
            t7.f1041a.nativeOrientationChanged(t7.h, t7.i);
        }
        T t8 = this.f1036a;
        if (t8.d && t8.g <= 0) {
            Message.obtain(t8.c, 2269, s2).sendToTarget();
            this.f1036a.g++;
        }
        return true;
    }
}

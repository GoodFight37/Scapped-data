package com.unity3d.player;

import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes2.dex */
public final class B implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Semaphore f1012a;
    public final /* synthetic */ UnityAccessibilityDelegate b;

    public B(UnityAccessibilityDelegate unityAccessibilityDelegate, Semaphore semaphore) {
        this.b = unityAccessibilityDelegate;
        this.f1012a = semaphore;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            UnityAccessibilityDelegate unityAccessibilityDelegate = this.b;
            if (unityAccessibilityDelegate.c != null) {
                unityAccessibilityDelegate.d = new L(unityAccessibilityDelegate);
            }
            UnityAccessibilityDelegate unityAccessibilityDelegate2 = this.b;
            if (unityAccessibilityDelegate2.e != null) {
                unityAccessibilityDelegate2.f = new N(this.b);
            }
        } finally {
            this.f1012a.release();
        }
    }
}

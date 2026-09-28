package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.r, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class RunnableC0125r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1117a;
    public final long b;

    public RunnableC0125r(long j, long j2) {
        this.f1117a = j;
        this.b = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (ReflectionHelper.beginProxyCall(this.f1117a)) {
            try {
                ReflectionHelper.nativeProxyFinalize(this.b);
            } finally {
                ReflectionHelper.endProxyCall();
            }
        }
    }
}

package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class RunnableC0105h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IAssetPackManagerStatusQueryCallback f1104a;
    public final long b;
    public final String[] c;
    public final int[] d;
    public final int[] e;

    public RunnableC0105h(IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback, long j, String[] strArr, int[] iArr, int[] iArr2) {
        this.f1104a = iAssetPackManagerStatusQueryCallback;
        this.b = j;
        this.c = strArr;
        this.d = iArr;
        this.e = iArr2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1104a.onStatusResult(this.b, this.c, this.d, this.e);
    }
}

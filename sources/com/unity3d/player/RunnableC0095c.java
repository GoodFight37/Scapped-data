package com.unity3d.player;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: renamed from: com.unity3d.player.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class RunnableC0095c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f1094a;
    public final String b;
    public final int c;
    public final long d;
    public final long e;
    public final int f;
    public final int g;

    public RunnableC0095c(Set set, String str, int i, long j, long j2, int i2, int i3) {
        this.f1094a = set;
        this.b = str;
        this.c = i;
        this.d = j;
        this.e = j2;
        this.f = i2;
        this.g = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator it = this.f1094a.iterator();
        while (it.hasNext()) {
            ((IAssetPackManagerDownloadStatusCallback) it.next()).onStatusUpdate(this.b, this.c, this.d, this.e, this.f, this.g);
        }
    }
}

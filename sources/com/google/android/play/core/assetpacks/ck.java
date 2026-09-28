package com.google.android.play.core.assetpacks;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.1.0 */
/* JADX INFO: loaded from: classes.dex */
final class ck extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f218a;

    ck(String str) {
        super(str);
        this.f218a = -1;
    }

    ck(String str, int i) {
        super(str);
        this.f218a = i;
    }

    ck(String str, Exception exc) {
        super(str, exc);
        this.f218a = -1;
    }

    ck(String str, Exception exc, int i) {
        super(str, exc);
        this.f218a = i;
    }
}

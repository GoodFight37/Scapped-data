package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.3.0 */
/* JADX INFO: loaded from: classes.dex */
final class bt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bn f354a;

    bt(bn bnVar) {
        this.f354a = bnVar;
    }

    final /* synthetic */ Task a(long j, long j2, int i, StandardIntegrityManager.StandardIntegrityTokenRequest standardIntegrityTokenRequest) {
        return this.f354a.d(standardIntegrityTokenRequest.a(), j, j2, 0);
    }
}

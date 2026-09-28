package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.3.0 */
/* JADX INFO: loaded from: classes.dex */
final class aa implements IntegrityManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final aj f318a;

    aa(aj ajVar) {
        this.f318a = ajVar;
    }

    @Override // com.google.android.play.core.integrity.IntegrityManager
    public final Task<IntegrityTokenResponse> requestIntegrityToken(IntegrityTokenRequest integrityTokenRequest) {
        return this.f318a.c(integrityTokenRequest);
    }
}

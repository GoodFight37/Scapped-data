package com.google.android.gms.common.api.internal;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
final class zaaz implements ResultCallback {
    final /* synthetic */ StatusPendingResult zaa;
    final /* synthetic */ boolean zab;
    final /* synthetic */ GoogleApiClient zac;
    final /* synthetic */ zabc zad;

    zaaz(zabc zabcVar, StatusPendingResult statusPendingResult, boolean z, GoogleApiClient googleApiClient) {
        this.zaa = statusPendingResult;
        this.zab = z;
        this.zac = googleApiClient;
        this.zad = zabcVar;
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final /* bridge */ /* synthetic */ void onResult(Result result) {
        Status status = (Status) result;
        Storage.getInstance(this.zad.zan).zac();
        if (status.isSuccess() && this.zad.isConnected()) {
            zabc zabcVar = this.zad;
            zabcVar.disconnect();
            zabcVar.connect();
        }
        this.zaa.setResult(status);
        if (this.zab) {
            this.zac.disconnect();
        }
    }
}

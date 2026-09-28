package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
final class zacv implements Runnable {
    final /* synthetic */ Result zaa;
    final /* synthetic */ zacx zab;

    zacv(zacx zacxVar, Result result) {
        this.zaa = result;
        this.zab = zacxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        GoogleApiClient googleApiClient;
        try {
            try {
                BasePendingResult.zaa.set(true);
                PendingResult pendingResultOnSuccess = ((ResultTransform) Preconditions.checkNotNull(this.zab.zaa)).onSuccess(this.zaa);
                zacx zacxVar = this.zab;
                zacxVar.zah.sendMessage(zacxVar.zah.obtainMessage(0, pendingResultOnSuccess));
                BasePendingResult.zaa.set(false);
                zacx zacxVar2 = this.zab;
                zacx.zan(this.zaa);
                googleApiClient = (GoogleApiClient) this.zab.zag.get();
                if (googleApiClient == null) {
                    return;
                }
            } catch (RuntimeException e) {
                zacx zacxVar3 = this.zab;
                zacxVar3.zah.sendMessage(zacxVar3.zah.obtainMessage(1, e));
                BasePendingResult.zaa.set(false);
                zacx zacxVar4 = this.zab;
                zacx.zan(this.zaa);
                googleApiClient = (GoogleApiClient) this.zab.zag.get();
                if (googleApiClient == null) {
                    return;
                }
            }
            googleApiClient.zap(this.zab);
        } catch (Throwable th) {
            BasePendingResult.zaa.set(false);
            zacx zacxVar5 = this.zab;
            zacx.zan(this.zaa);
            GoogleApiClient googleApiClient2 = (GoogleApiClient) this.zab.zag.get();
            if (googleApiClient2 != null) {
                googleApiClient2.zap(this.zab);
            }
            throw th;
        }
    }
}

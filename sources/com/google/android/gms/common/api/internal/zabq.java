package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
final class zabq implements Runnable {
    final /* synthetic */ ConnectionResult zaa;
    final /* synthetic */ zabr zab;

    zabq(zabr zabrVar, ConnectionResult connectionResult) {
        this.zaa = connectionResult;
        this.zab = zabrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zabr zabrVar = this.zab;
        zabo zaboVar = (zabo) zabrVar.zaa.zao.get(zabrVar.zac);
        if (zaboVar == null) {
            return;
        }
        if (!this.zaa.isSuccess()) {
            zaboVar.zar(this.zaa, null);
            return;
        }
        this.zab.zaf = true;
        if (this.zab.zab.requiresSignIn()) {
            this.zab.zah();
            return;
        }
        try {
            zabr zabrVar2 = this.zab;
            zabrVar2.zab.getRemoteService(null, zabrVar2.zab.getScopesForConnectionlessNonSignIn());
        } catch (SecurityException e) {
            Log.e("GoogleApiManager", "Failed to get service from broker. ", e);
            this.zab.zab.disconnect("Failed to get service from broker.");
            zaboVar.zar(new ConnectionResult(10), null);
        }
    }
}

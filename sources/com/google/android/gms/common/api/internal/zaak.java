package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
final class zaak implements BaseGmsClient.ConnectionProgressReportCallbacks {
    private final WeakReference zaa;
    private final Api zab;
    private final boolean zac;

    public zaak(zaau zaauVar, Api api, boolean z) {
        this.zaa = new WeakReference(zaauVar);
        this.zab = api;
        this.zac = z;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
    public final void onReportServiceBinding(ConnectionResult connectionResult) {
        zaau zaauVar = (zaau) this.zaa.get();
        if (zaauVar == null) {
            return;
        }
        Preconditions.checkState(Looper.myLooper() == zaauVar.zaa.zag.getLooper(), "onReportServiceBinding must be called on the GoogleApiClient handler thread");
        zaauVar.zab.lock();
        try {
            if (zaauVar.zaG(0)) {
                if (!connectionResult.isSuccess()) {
                    zaauVar.zaE(connectionResult, this.zab, this.zac);
                }
                if (zaauVar.zaH()) {
                    zaauVar.zaF();
                }
            }
        } finally {
            zaauVar.zab.unlock();
        }
    }
}

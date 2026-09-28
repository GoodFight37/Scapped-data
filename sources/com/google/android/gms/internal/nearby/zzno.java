package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzno extends com.google.android.gms.nearby.messages.internal.zzq {
    private final ListenerHolder zza;
    private boolean zzb = false;

    public zzno(ListenerHolder listenerHolder) {
        this.zza = listenerHolder;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzr
    public final synchronized void zzd(Status status) throws RemoteException {
        if (!this.zzb) {
            this.zza.notifyListener(new zznn(this, status));
            this.zzb = true;
        } else {
            String strValueOf = String.valueOf(String.valueOf(status));
            Log.wtf("NearbyMessagesCallbackWrapper", "Received multiple statuses: ".concat(strValueOf), new Exception());
        }
    }
}

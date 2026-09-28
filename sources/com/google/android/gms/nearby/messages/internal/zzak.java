package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.messages.Message;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzak implements zzbc {
    public final /* synthetic */ Message zza;

    public /* synthetic */ zzak(Message message) {
        this.zza = message;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzbc
    public final void zza(zzai zzaiVar, ListenerHolder listenerHolder) throws RemoteException {
        Message message = this.zza;
        int i = zzbh.zza;
        zzaiVar.zzz(listenerHolder, zzae.zza(message));
    }
}

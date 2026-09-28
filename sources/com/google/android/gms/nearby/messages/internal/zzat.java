package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzat implements zzbc {
    public final /* synthetic */ ListenerHolder zza;

    public /* synthetic */ zzat(ListenerHolder listenerHolder) {
        this.zza = listenerHolder;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzbc
    public final void zza(zzai zzaiVar, ListenerHolder listenerHolder) throws RemoteException {
        ListenerHolder listenerHolder2 = this.zza;
        int i = zzbh.zza;
        zzaiVar.zzC(listenerHolder, listenerHolder2);
    }
}

package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.messages.SubscribeOptions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzaj implements zzbc {
    public final /* synthetic */ zzbh zza;
    public final /* synthetic */ PendingIntent zzb;
    public final /* synthetic */ zzbg zzc;
    public final /* synthetic */ SubscribeOptions zzd;

    public /* synthetic */ zzaj(zzbh zzbhVar, PendingIntent pendingIntent, zzbg zzbgVar, SubscribeOptions subscribeOptions) {
        this.zza = zzbhVar;
        this.zzb = pendingIntent;
        this.zzc = zzbgVar;
        this.zzd = subscribeOptions;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzbc
    public final void zza(zzai zzaiVar, ListenerHolder listenerHolder) throws RemoteException {
        this.zza.zzf(this.zzb, this.zzc, this.zzd, zzaiVar, listenerHolder);
    }
}

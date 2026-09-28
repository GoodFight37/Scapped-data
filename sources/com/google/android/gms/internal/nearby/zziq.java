package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zziq extends zzjh {
    final /* synthetic */ String zza;
    final /* synthetic */ byte[] zzb;
    final /* synthetic */ ListenerHolder zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zziq(zzji zzjiVar, GoogleApiClient googleApiClient, String str, byte[] bArr, ListenerHolder listenerHolder) {
        super(googleApiClient, null);
        this.zza = str;
        this.zzb = bArr;
        this.zzc = listenerHolder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        zzgy zzgyVar = (zzgy) anyClient;
        String str = this.zza;
        byte[] bArr = this.zzb;
        ListenerHolder listenerHolder = this.zzc;
        zzkd zzkdVar = (zzkd) zzgyVar.getService();
        zzfh zzfhVar = new zzfh();
        zzfhVar.zze(new zzgv(this));
        zzfhVar.zzd(str);
        zzfhVar.zzb(bArr);
        zzfhVar.zza(new zzgn(zzgyVar.getContext(), listenerHolder));
        zzkdVar.zzd(zzfhVar.zzf());
    }
}

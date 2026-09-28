package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzip extends zzjh {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ byte[] zzc;
    final /* synthetic */ ListenerHolder zzd;
    final /* synthetic */ ListenerHolder zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzip(zzji zzjiVar, GoogleApiClient googleApiClient, String str, String str2, byte[] bArr, ListenerHolder listenerHolder, ListenerHolder listenerHolder2) {
        super(googleApiClient, null);
        this.zza = str;
        this.zzb = str2;
        this.zzc = bArr;
        this.zzd = listenerHolder;
        this.zze = listenerHolder2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        zzgy zzgyVar = (zzgy) anyClient;
        String str = this.zza;
        String str2 = this.zzb;
        byte[] bArr = this.zzc;
        ListenerHolder listenerHolder = this.zzd;
        ListenerHolder listenerHolder2 = this.zze;
        zzkd zzkdVar = (zzkd) zzgyVar.getService();
        zzmi zzmiVar = new zzmi();
        zzmiVar.zzi(new zzgv(this));
        zzmiVar.zzf(str);
        zzmiVar.zzh(str2);
        zzmiVar.zze(bArr);
        zzmiVar.zza(new zzgn(zzgyVar.getContext(), listenerHolder2));
        zzmiVar.zzc(new zzgb(listenerHolder));
        zzkdVar.zzi(zzmiVar.zzj());
    }
}

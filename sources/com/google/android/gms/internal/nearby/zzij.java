package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.nearby.connection.Payload;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzij extends zzjh {
    final /* synthetic */ List zza;
    final /* synthetic */ Payload zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzij(zzji zzjiVar, GoogleApiClient googleApiClient, List list, Payload payload) {
        super(googleApiClient, null);
        this.zza = list;
        this.zzb = payload;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzgy) anyClient).zzz(this, (String[]) this.zza.toArray(new String[0]), this.zzb, false);
    }
}

package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzir extends zzjh {
    final /* synthetic */ String zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzir(zzji zzjiVar, GoogleApiClient googleApiClient, String str) {
        super(googleApiClient, null);
        this.zza = str;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzgy) anyClient).zzu(this, this.zza);
    }
}

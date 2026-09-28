package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.nearby.connection.Payload;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzit extends zzjh {
    final /* synthetic */ String zza;
    final /* synthetic */ byte[] zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzit(zzji zzjiVar, GoogleApiClient googleApiClient, String str, byte[] bArr) {
        super(googleApiClient, null);
        this.zza = str;
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzgy) anyClient).zzz(this, new String[]{this.zza}, Payload.fromBytes(this.zzb), true);
    }
}

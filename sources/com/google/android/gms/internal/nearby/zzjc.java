package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.nearby.Nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
abstract class zzjc extends BaseImplementation.ApiMethodImpl {
    public zzjc(GoogleApiClient googleApiClient) {
        super(Nearby.CONNECTIONS_API, googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl, com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((Result) obj);
    }
}

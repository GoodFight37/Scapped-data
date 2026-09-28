package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzl implements BaseImplementation.ResultHolder {
    final /* synthetic */ BaseGmsClient.SignOutCallbacks zza;

    zzl(BaseGmsClient.SignOutCallbacks signOutCallbacks) {
        this.zza = signOutCallbacks;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final void setFailedResult(Status status) {
        this.zza.onSignOutComplete();
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        this.zza.onSignOutComplete();
    }
}

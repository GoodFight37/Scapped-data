package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zznn extends zznp {
    final /* synthetic */ Status zza;

    zznn(zzno zznoVar, Status status) {
        this.zza = status;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        BaseImplementation.ResultHolder resultHolder = (BaseImplementation.ResultHolder) obj;
        if (this.zza.isSuccess()) {
            resultHolder.setResult(this.zza);
        } else {
            resultHolder.setFailedResult(this.zza);
        }
    }
}

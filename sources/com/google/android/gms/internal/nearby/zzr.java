package com.google.android.gms.internal.nearby;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzr implements RemoteCall {
    public final /* synthetic */ zzax zza;

    public /* synthetic */ zzr(zzax zzaxVar) {
        this.zza = zzaxVar;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) throws RemoteException {
        zzai zzaiVar = new zzai(this.zza, (TaskCompletionSource) obj2);
        zzdr zzdrVar = (zzdr) ((zzn) obj).getService();
        zzci zzciVar = new zzci();
        zzciVar.zza(zzaiVar);
        zzdrVar.zzm(zzciVar.zzb());
    }
}

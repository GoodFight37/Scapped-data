package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnFailureListener;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzic implements OnFailureListener {
    final /* synthetic */ String zza;
    final /* synthetic */ zzih zzb;

    zzic(zzih zzihVar, String str) {
        this.zzb = zzihVar;
        this.zza = str;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        if ((exc instanceof ApiException) && ((ApiException) exc).getStatusCode() == 8003) {
            return;
        }
        this.zzb.zzk(this.zza);
    }
}

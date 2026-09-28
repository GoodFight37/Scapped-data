package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.OnFailureListener;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzfe implements OnFailureListener {
    final /* synthetic */ GoogleApi zza;
    final /* synthetic */ ListenerHolder.ListenerKey zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ zzfg zzd;

    zzfe(zzfg zzfgVar, GoogleApi googleApi, ListenerHolder.ListenerKey listenerKey, boolean z) {
        this.zzd = zzfgVar;
        this.zza = googleApi;
        this.zzb = listenerKey;
        this.zzc = z;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        int statusCode;
        synchronized (this.zzd) {
            if (!(exc instanceof ApiException) || ((statusCode = ((ApiException) exc).getStatusCode()) != 8001 && statusCode != 8002)) {
                this.zzd.zzg(this.zza, this.zzb);
            } else if (this.zzc) {
                this.zzd.zzc.remove(this.zzb);
            }
        }
    }
}

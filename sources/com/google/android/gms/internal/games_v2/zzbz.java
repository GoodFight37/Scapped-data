package com.google.android.gms.internal.games_v2;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class zzbz implements zzap {
    private final /* synthetic */ String zza;

    /* synthetic */ zzbz(String str) {
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.games_v2.zzap
    public final /* synthetic */ Task zza(GoogleApi googleApi) {
        TaskApiCall.Builder builder = TaskApiCall.builder();
        final String str = this.zza;
        return googleApi.doWrite(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzce
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                ((com.google.android.gms.games.internal.zzah) obj).zzD((TaskCompletionSource) obj2, str);
            }
        }).setMethodKey(6695).build());
    }
}

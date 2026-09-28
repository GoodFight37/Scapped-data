package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class zzdp implements zzap {
    static final /* synthetic */ zzdp zza = new zzdp();

    private /* synthetic */ zzdp() {
    }

    @Override // com.google.android.gms.internal.games_v2.zzap
    public final /* synthetic */ Task zza(GoogleApi googleApi) {
        return googleApi.doRead(TaskApiCall.builder().run(zzdf.zza).setMethodKey(6700).build());
    }
}

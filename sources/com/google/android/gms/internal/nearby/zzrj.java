package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.uwb.UwbComplexChannel;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzrj extends zzpg {
    final /* synthetic */ TaskCompletionSource zza;

    zzrj(zzrs zzrsVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.nearby.zzph
    public final void zzd(zzqv zzqvVar) {
        TaskCompletionSource taskCompletionSource = this.zza;
        UwbComplexChannel.Builder builder = new UwbComplexChannel.Builder();
        builder.setChannel(zzqvVar.zza());
        builder.setPreambleIndex(zzqvVar.zzb());
        taskCompletionSource.setResult(builder.build());
    }
}

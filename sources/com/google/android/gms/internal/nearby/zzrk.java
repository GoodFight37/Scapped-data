package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.uwb.UwbStatusCodes;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzrk extends zzpa {
    final /* synthetic */ TaskCompletionSource zza;

    zzrk(zzrs zzrsVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.nearby.zzpb
    public final void zzd(int i) {
        if (i == 42004) {
            this.zza.setException(new SecurityException("Missing UWB_RANGING permission"));
        } else if (i != 0) {
            this.zza.setException(new ApiException(new Status(i, UwbStatusCodes.zza(i))));
        } else {
            this.zza.setResult(null);
        }
    }
}

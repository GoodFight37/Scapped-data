package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzf implements OnSuccessListener<String> {
    private final /* synthetic */ TaskCompletionSource zza;

    zzf(zzb zzbVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final /* synthetic */ void onSuccess(String str) {
        this.zza.setResult(new zzm().zzb(str).zza());
    }
}

package com.google.firebase.auth.internal;

import android.content.Context;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbd implements OnSuccessListener<AuthResult> {
    private final /* synthetic */ TaskCompletionSource zza;
    private final /* synthetic */ Context zzb;

    zzbd(zzax zzaxVar, TaskCompletionSource taskCompletionSource, Context context) {
        this.zza = taskCompletionSource;
        this.zzb = context;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final /* synthetic */ void onSuccess(AuthResult authResult) {
        this.zza.setResult(authResult);
        zzax.zza(this.zzb);
    }
}

package com.google.android.gms.games.internal.v2.appshortcuts;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzm extends zzn {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzm(zzq zzqVar, TaskCompletionSource taskCompletionSource) {
        super(taskCompletionSource);
        Objects.requireNonNull(zzqVar);
    }

    @Override // com.google.android.gms.games.internal.v2.appshortcuts.zzn, com.google.android.gms.games.internal.v2.appshortcuts.zzx
    public final void zzc(Intent intent) {
        if (intent == null) {
            zzd(new Status(17));
        } else {
            this.zza.trySetResult(intent);
        }
    }
}

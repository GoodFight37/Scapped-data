package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
final class zzfz extends zzjo {
    private final ListenerHolder zza;

    zzfz(ListenerHolder listenerHolder) {
        this.zza = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzjp
    public final void zzb(zzku zzkuVar) {
        this.zza.notifyListener(new zzfy(this, zzkuVar));
    }
}

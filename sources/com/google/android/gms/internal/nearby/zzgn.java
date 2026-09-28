package com.google.android.gms.internal.nearby;

import android.content.Context;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
final class zzgn extends zzjr {
    private final Context zza;
    private final ListenerHolder zzb;

    zzgn(Context context, ListenerHolder listenerHolder) {
        this.zza = (Context) Preconditions.checkNotNull(context);
        this.zzb = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzjs
    public final void zzc(zzla zzlaVar) {
        this.zzb.notifyListener(new zzgm(this, zzlaVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzjs
    public final void zzd(zzli zzliVar) {
        this.zzb.notifyListener(new zzgl(this, zzliVar));
    }
}

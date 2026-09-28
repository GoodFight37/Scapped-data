package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzgj extends zzkb {
    private final ListenerHolder zza;

    zzgj(ListenerHolder listenerHolder) {
        this.zza = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzkc
    public final synchronized void zzb(zzlc zzlcVar) {
    }

    @Override // com.google.android.gms.internal.nearby.zzkc
    public final void zzc(zzle zzleVar) {
        this.zza.notifyListener(new zzgh(this, zzleVar));
    }

    @Override // com.google.android.gms.internal.nearby.zzkc
    public final void zzd(zzlg zzlgVar) {
        this.zza.notifyListener(new zzgi(this, zzlgVar));
    }
}

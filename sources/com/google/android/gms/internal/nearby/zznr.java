package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.ListenerHolder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zznr extends com.google.android.gms.nearby.messages.internal.zzx {
    private final ListenerHolder zza;

    public zznr(ListenerHolder listenerHolder) {
        this.zza = listenerHolder;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzy
    public final void zzd(boolean z) {
        this.zza.notifyListener(new zznq(this, z));
    }
}

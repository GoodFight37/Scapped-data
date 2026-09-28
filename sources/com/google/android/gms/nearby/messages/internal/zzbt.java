package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.internal.nearby.zznp;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzbt extends zzu {
    private static final zznp zza = new zzbs();
    private final ListenerHolder zzb;

    public zzbt(ListenerHolder listenerHolder) {
        this.zzb = listenerHolder;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzv
    public final void zzd() {
        this.zzb.notifyListener(zza);
    }
}

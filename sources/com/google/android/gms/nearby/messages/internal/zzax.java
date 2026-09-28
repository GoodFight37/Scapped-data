package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzax extends zzbg {
    final /* synthetic */ ListenerHolder zza;
    final /* synthetic */ zzbh zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzax(zzbh zzbhVar, ListenerHolder listenerHolder, ListenerHolder listenerHolder2) {
        super(listenerHolder);
        this.zzb = zzbhVar;
        this.zza = listenerHolder2;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzbg, com.google.android.gms.nearby.messages.internal.zzab
    public final void zzd() {
        ListenerHolder.ListenerKey<?> listenerKey = this.zza.getListenerKey();
        if (listenerKey != null) {
            this.zzb.doUnregisterEventListener(listenerKey);
        }
        super.zzd();
    }
}

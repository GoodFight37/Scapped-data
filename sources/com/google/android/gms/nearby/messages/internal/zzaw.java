package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzaw extends zzbe {
    final /* synthetic */ ListenerHolder zza;
    final /* synthetic */ zzbh zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzaw(zzbh zzbhVar, ListenerHolder listenerHolder, ListenerHolder listenerHolder2) {
        super(listenerHolder);
        this.zzb = zzbhVar;
        this.zza = listenerHolder2;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzbe, com.google.android.gms.nearby.messages.internal.zzv
    public final void zzd() {
        ListenerHolder.ListenerKey<?> listenerKey = this.zza.getListenerKey();
        if (listenerKey != null) {
            this.zzb.doUnregisterEventListener(listenerKey);
        }
        super.zzd();
    }
}

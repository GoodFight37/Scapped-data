package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionResolution;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzfs extends zzgp {
    final /* synthetic */ zzky zza;
    final /* synthetic */ Status zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfs(zzfx zzfxVar, zzky zzkyVar, Status status) {
        super(null);
        this.zza = zzkyVar;
        this.zzb = status;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        ((ConnectionLifecycleCallback) obj).onConnectionResult(this.zza.zzb(), new ConnectionResolution(this.zzb));
    }
}

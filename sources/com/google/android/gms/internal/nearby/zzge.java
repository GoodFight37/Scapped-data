package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzge extends zzgp {
    final /* synthetic */ zzlg zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzge(zzgg zzggVar, zzlg zzlgVar) {
        super(null);
        this.zza = zzlgVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        ((EndpointDiscoveryCallback) obj).onEndpointLost(this.zza.zza());
    }
}

package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzgf extends zzgp {
    final /* synthetic */ String zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgf(zzgg zzggVar, String str) {
        super(null);
        this.zza = str;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((EndpointDiscoveryCallback) obj).onEndpointLost(this.zza);
    }
}

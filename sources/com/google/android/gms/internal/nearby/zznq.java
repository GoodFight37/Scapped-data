package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.messages.StatusCallback;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zznq extends zznp {
    final /* synthetic */ boolean zza;

    zznq(zznr zznrVar, boolean z) {
        this.zza = z;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((StatusCallback) obj).onPermissionChanged(this.zza);
    }
}

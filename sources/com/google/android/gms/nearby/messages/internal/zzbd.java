package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.internal.nearby.zznp;
import com.google.android.gms.nearby.messages.PublishCallback;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzbd extends zznp {
    zzbd() {
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((PublishCallback) obj).onExpired();
    }
}

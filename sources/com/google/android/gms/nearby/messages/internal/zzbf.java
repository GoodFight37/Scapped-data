package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.internal.nearby.zznp;
import com.google.android.gms.nearby.messages.SubscribeCallback;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzbf extends zznp {
    zzbf() {
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((SubscribeCallback) obj).onExpired();
    }
}

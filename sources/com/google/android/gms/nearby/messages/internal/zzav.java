package com.google.android.gms.nearby.messages.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.nearby.messages.MessagesOptions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzav extends Api.AbstractClientBuilder {
    zzav() {
    }

    @Override // com.google.android.gms.common.api.Api.AbstractClientBuilder
    public final /* synthetic */ Api.Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return zzai.zzq(context, looper, connectionCallbacks, onConnectionFailedListener, clientSettings, (MessagesOptions) obj);
    }

    @Override // com.google.android.gms.common.api.Api.BaseClientBuilder
    public final int getPriority() {
        return Integer.MAX_VALUE;
    }
}

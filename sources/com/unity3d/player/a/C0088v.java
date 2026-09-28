package com.unity3d.player.a;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* JADX INFO: renamed from: com.unity3d.player.a.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0088v extends ConnectivityManager.NetworkCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0089w f1089a;

    public C0088v(C0089w c0089w) {
        this.f1089a = c0089w;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        super.onCapabilitiesChanged(network, networkCapabilities);
        if (networkCapabilities.hasTransport(0)) {
            this.f1089a.b = 1;
        } else {
            this.f1089a.b = 2;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onUnavailable() {
        super.onUnavailable();
        this.f1089a.b = 0;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        super.onLost(network);
        this.f1089a.b = 0;
    }
}

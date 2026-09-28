package com.unity3d.player.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* JADX INFO: renamed from: com.unity3d.player.a.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0087u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConnectivityManager f1088a;

    public void a() {
    }

    public C0087u(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.f1088a = connectivityManager;
        if (connectivityManager == null) {
            AbstractC0086t.Log(6, "NetworkConnectivity: ConnectivityManager not found");
        }
    }

    public int b() {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager = this.f1088a;
        if (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = this.f1088a.getNetworkCapabilities(activeNetwork)) == null) {
            return 0;
        }
        return networkCapabilities.hasTransport(0) ? 1 : 2;
    }
}

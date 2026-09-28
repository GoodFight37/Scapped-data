package com.unity3d.player.a;

import android.content.Context;
import android.net.ConnectivityManager;

/* JADX INFO: renamed from: com.unity3d.player.a.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0089w extends C0087u {
    public int b;
    public final C0088v c;

    public C0089w(Context context) {
        super(context);
        this.b = 0;
        C0088v c0088v = new C0088v(this);
        this.c = c0088v;
        if (this.f1088a == null) {
            return;
        }
        this.b = super.b();
        this.f1088a.registerDefaultNetworkCallback(c0088v);
    }

    @Override // com.unity3d.player.a.C0087u
    public final int b() {
        return this.b;
    }

    @Override // com.unity3d.player.a.C0087u
    public final void a() {
        ConnectivityManager connectivityManager = this.f1088a;
        if (connectivityManager == null) {
            return;
        }
        connectivityManager.unregisterNetworkCallback(this.c);
    }
}

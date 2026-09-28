package com.google.android.play.core.assetpacks.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.1.0 */
/* JADX INFO: loaded from: classes.dex */
final class y implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ z f298a;

    /* synthetic */ y(z zVar, x xVar) {
        this.f298a = zVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f298a.c.d("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        z zVar = this.f298a;
        zVar.c().post(new v(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f298a.c.d("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        z zVar = this.f298a;
        zVar.c().post(new w(this));
    }
}

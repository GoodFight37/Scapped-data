package com.google.android.play.core.assetpacks.internal;

import android.os.IBinder;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.1.0 */
/* JADX INFO: loaded from: classes.dex */
final class v extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ IBinder f296a;
    final /* synthetic */ y b;

    v(y yVar, IBinder iBinder) {
        this.b = yVar;
        this.f296a = iBinder;
    }

    @Override // com.google.android.play.core.assetpacks.internal.p
    public final void a() {
        this.b.f298a.n = e.b(this.f296a);
        z.q(this.b.f298a);
        this.b.f298a.h = false;
        Iterator it = this.b.f298a.e.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.b.f298a.e.clear();
    }
}

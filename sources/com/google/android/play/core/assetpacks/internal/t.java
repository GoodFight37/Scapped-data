package com.google.android.play.core.assetpacks.internal;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.1.0 */
/* JADX INFO: loaded from: classes.dex */
final class t extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ z f295a;

    t(z zVar) {
        this.f295a = zVar;
    }

    @Override // com.google.android.play.core.assetpacks.internal.p
    public final void a() {
        synchronized (this.f295a.g) {
            if (this.f295a.l.get() > 0 && this.f295a.l.decrementAndGet() > 0) {
                this.f295a.c.d("Leaving the connection open for other ongoing calls.", new Object[0]);
                return;
            }
            z zVar = this.f295a;
            if (zVar.n != null) {
                zVar.c.d("Unbind from service.", new Object[0]);
                z zVar2 = this.f295a;
                zVar2.b.unbindService(zVar2.m);
                this.f295a.h = false;
                this.f295a.n = null;
                this.f295a.m = null;
            }
            this.f295a.w();
        }
    }
}

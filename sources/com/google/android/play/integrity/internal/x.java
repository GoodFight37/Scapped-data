package com.google.android.play.integrity.internal;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.3.0 */
/* JADX INFO: loaded from: classes.dex */
final class x extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ae f385a;

    x(ae aeVar) {
        this.f385a = aeVar;
    }

    @Override // com.google.android.play.integrity.internal.t
    public final void b() {
        synchronized (this.f385a.g) {
            if (this.f385a.m.get() > 0 && this.f385a.m.decrementAndGet() > 0) {
                this.f385a.c.d("Leaving the connection open for other ongoing calls.", new Object[0]);
                return;
            }
            ae aeVar = this.f385a;
            if (aeVar.o != null) {
                aeVar.c.d("Unbind from service.", new Object[0]);
                ae aeVar2 = this.f385a;
                aeVar2.b.unbindService(aeVar2.n);
                this.f385a.h = false;
                this.f385a.o = null;
                this.f385a.n = null;
            }
            this.f385a.x();
        }
    }
}

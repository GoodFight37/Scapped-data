package com.google.android.gms.common.api.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
final class zaaj implements Runnable {
    final /* synthetic */ zaau zaa;

    zaaj(zaau zaauVar) {
        this.zaa = zaauVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zaau zaauVar = this.zaa;
        zaauVar.zad.cancelAvailabilityErrorNotifications(zaauVar.zac);
    }
}

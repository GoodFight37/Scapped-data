package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
final class zaaq extends com.google.android.gms.signin.internal.zac {
    private final WeakReference zaa;

    zaaq(zaau zaauVar) {
        this.zaa = new WeakReference(zaauVar);
    }

    @Override // com.google.android.gms.signin.internal.zac, com.google.android.gms.signin.internal.zae
    public final void zab(com.google.android.gms.signin.internal.zak zakVar) {
        zaau zaauVar = (zaau) this.zaa.get();
        if (zaauVar == null) {
            return;
        }
        zaauVar.zaa.zal(new zaap(this, zaauVar, zaauVar, zakVar));
    }
}

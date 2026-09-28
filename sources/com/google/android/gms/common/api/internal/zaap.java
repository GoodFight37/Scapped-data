package com.google.android.gms.common.api.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
final class zaap extends zabe {
    final /* synthetic */ zaau zaa;
    final /* synthetic */ com.google.android.gms.signin.internal.zak zab;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zaap(zaaq zaaqVar, zabd zabdVar, zaau zaauVar, com.google.android.gms.signin.internal.zak zakVar) {
        super(zabdVar);
        this.zaa = zaauVar;
        this.zab = zakVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabe
    public final void zaa() {
        zaau.zar(this.zaa, this.zab);
    }
}

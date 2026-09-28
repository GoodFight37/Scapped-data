package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
final class zaao extends zaas {
    final /* synthetic */ zaau zaa;
    private final ArrayList zac;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zaao(zaau zaauVar, ArrayList arrayList) {
        super(zaauVar, null);
        this.zaa = zaauVar;
        this.zac = arrayList;
    }

    @Override // com.google.android.gms.common.api.internal.zaas
    public final void zaa() {
        zaau zaauVar = this.zaa;
        zaauVar.zaa.zag.zad = zaau.zao(zaauVar);
        ArrayList arrayList = this.zac;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Api.Client client = (Api.Client) arrayList.get(i);
            zaau zaauVar2 = this.zaa;
            client.getRemoteService(zaauVar2.zao, zaauVar2.zaa.zag.zad);
        }
    }
}

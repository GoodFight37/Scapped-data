package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
final class zaan extends zaas {
    final /* synthetic */ zaau zaa;
    private final Map zac;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zaan(zaau zaauVar, Map map) {
        super(zaauVar, null);
        this.zaa = zaauVar;
        this.zac = map;
    }

    @Override // com.google.android.gms.common.api.internal.zaas
    public final void zaa() {
        com.google.android.gms.common.internal.zal zalVar = new com.google.android.gms.common.internal.zal(this.zaa.zad);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Api.Client client : this.zac.keySet()) {
            if (!client.requiresGooglePlayServices() || ((zaak) this.zac.get(client)).zac) {
                arrayList2.add(client);
            } else {
                arrayList.add(client);
            }
        }
        int i = 0;
        int iZab = -1;
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            while (i < size) {
                iZab = zalVar.zab(this.zaa.zac, (Api.Client) arrayList.get(i));
                i++;
                if (iZab != 0) {
                    break;
                }
            }
        } else {
            int size2 = arrayList2.size();
            while (i < size2) {
                iZab = zalVar.zab(this.zaa.zac, (Api.Client) arrayList2.get(i));
                i++;
                if (iZab == 0) {
                    break;
                }
            }
        }
        if (iZab != 0) {
            ConnectionResult connectionResult = new ConnectionResult(iZab, null);
            zaau zaauVar = this.zaa;
            zaauVar.zaa.zal(new zaal(this, zaauVar, connectionResult));
            return;
        }
        zaau zaauVar2 = this.zaa;
        if (zaauVar2.zam && zaauVar2.zak != null) {
            zaauVar2.zak.zab();
        }
        for (Api.Client client2 : this.zac.keySet()) {
            BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks = (BaseGmsClient.ConnectionProgressReportCallbacks) this.zac.get(client2);
            if (!client2.requiresGooglePlayServices() || zalVar.zab(this.zaa.zac, client2) == 0) {
                client2.connect(connectionProgressReportCallbacks);
            } else {
                zaau zaauVar3 = this.zaa;
                zaauVar3.zaa.zal(new zaam(this, zaauVar3, connectionProgressReportCallbacks));
            }
        }
    }
}

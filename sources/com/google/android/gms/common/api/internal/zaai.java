package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zaai implements zabd {
    private final zabg zaa;
    private boolean zab = false;

    public zaai(zabg zabgVar) {
        this.zaa = zabgVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final BaseImplementation.ApiMethodImpl zaa(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        zab(apiMethodImpl);
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final BaseImplementation.ApiMethodImpl zab(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        try {
            this.zaa.zag.zai.zaa(apiMethodImpl);
            zabc zabcVar = this.zaa.zag;
            Api.Client client = (Api.Client) zabcVar.zac.get(apiMethodImpl.getClientKey());
            Preconditions.checkNotNull(client, "Appropriate Api was not requested.");
            if (client.isConnected() || !this.zaa.zab.containsKey(apiMethodImpl.getClientKey())) {
                apiMethodImpl.run(client);
            } else {
                apiMethodImpl.setFailedResult(new Status(17));
            }
        } catch (DeadObjectException unused) {
            this.zaa.zal(new zaag(this, this));
        }
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void zad() {
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void zae() {
        if (this.zab) {
            this.zab = false;
            this.zaa.zal(new zaah(this, this));
        }
    }

    final void zaf() {
        if (this.zab) {
            this.zab = false;
            this.zaa.zag.zai.zab();
            zaj();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void zag(Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void zah(ConnectionResult connectionResult, Api api, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void zai(int i) {
        this.zaa.zak(null);
        this.zaa.zah.zac(i, this.zab);
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final boolean zaj() {
        if (this.zab) {
            return false;
        }
        Set set = this.zaa.zag.zah;
        if (set == null || set.isEmpty()) {
            this.zaa.zak(null);
            return true;
        }
        this.zab = true;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((zacx) it.next()).zah();
        }
        return false;
    }
}

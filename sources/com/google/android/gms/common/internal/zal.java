package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zal {
    private final SparseIntArray zaa;
    private GoogleApiAvailabilityLight zab;

    public zal() {
        this(GoogleApiAvailability.getInstance());
    }

    public final int zaa(Context context, int i) {
        int i2;
        synchronized (this.zaa) {
            i2 = this.zaa.get(i, -1);
        }
        return i2;
    }

    public final int zab(Context context, Api.Client client) {
        int iIsGooglePlayServicesAvailable;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(client);
        int i = 0;
        if (!client.requiresGooglePlayServices()) {
            return 0;
        }
        int minApkVersion = client.getMinApkVersion();
        int iZaa = zaa(context, minApkVersion);
        if (iZaa != -1) {
            return iZaa;
        }
        synchronized (this.zaa) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.zaa.size()) {
                    i = -1;
                    break;
                }
                int iKeyAt = this.zaa.keyAt(i2);
                if (iKeyAt > minApkVersion && this.zaa.get(iKeyAt) == 0) {
                    break;
                }
                i2++;
            }
            iIsGooglePlayServicesAvailable = i == -1 ? this.zab.isGooglePlayServicesAvailable(context, minApkVersion) : i;
            this.zaa.put(minApkVersion, iIsGooglePlayServicesAvailable);
        }
        return iIsGooglePlayServicesAvailable;
    }

    public final void zac() {
        synchronized (this.zaa) {
            this.zaa.clear();
        }
    }

    public zal(GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        this.zaa = new SparseIntArray();
        Preconditions.checkNotNull(googleApiAvailabilityLight);
        this.zab = googleApiAvailabilityLight;
    }
}

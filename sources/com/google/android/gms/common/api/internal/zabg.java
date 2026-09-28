package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zabg implements zaby, zau {
    final Map zaa;
    final ClientSettings zac;
    final Map zad;
    final Api.AbstractClientBuilder zae;
    int zaf;
    final zabc zag;
    final zabx zah;
    private final Lock zai;
    private final Condition zaj;
    private final Context zak;
    private final GoogleApiAvailabilityLight zal;
    private final zabf zam;
    private volatile zabd zan;
    final Map zab = new HashMap();
    private ConnectionResult zao = null;

    public zabg(Context context, zabc zabcVar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map map, ClientSettings clientSettings, Map map2, Api.AbstractClientBuilder abstractClientBuilder, ArrayList arrayList, zabx zabxVar) {
        this.zak = context;
        this.zai = lock;
        this.zal = googleApiAvailabilityLight;
        this.zaa = map;
        this.zac = clientSettings;
        this.zad = map2;
        this.zae = abstractClientBuilder;
        this.zag = zabcVar;
        this.zah = zabxVar;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((zat) arrayList.get(i)).zaa(this);
        }
        this.zam = new zabf(this, looper);
        this.zaj = lock.newCondition();
        this.zan = new zaav(this);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        this.zai.lock();
        try {
            this.zan.zag(bundle);
        } finally {
            this.zai.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        this.zai.lock();
        try {
            this.zan.zai(i);
        } finally {
            this.zai.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zau
    public final void zaa(ConnectionResult connectionResult, Api api, boolean z) {
        this.zai.lock();
        try {
            this.zan.zah(connectionResult, api, z);
        } finally {
            this.zai.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaby
    public final ConnectionResult zab() {
        zaq();
        while (this.zan instanceof zaau) {
            try {
                this.zaj.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        if (this.zan instanceof zaai) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.zao;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.common.api.internal.zaby
    public final ConnectionResult zac(long j, TimeUnit timeUnit) {
        zaq();
        long nanos = timeUnit.toNanos(j);
        while (this.zan instanceof zaau) {
            if (nanos <= 0) {
                zar();
                return new ConnectionResult(14, null);
            }
            try {
                nanos = this.zaj.awaitNanos(nanos);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
            Thread.currentThread().interrupt();
            return new ConnectionResult(15, null);
        }
        if (this.zan instanceof zaai) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.zao;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.common.api.internal.zaby
    public final ConnectionResult zad(Api api) {
        Map map = this.zaa;
        Api.AnyClientKey anyClientKeyZab = api.zab();
        if (!map.containsKey(anyClientKeyZab)) {
            return null;
        }
        if (((Api.Client) this.zaa.get(anyClientKeyZab)).isConnected()) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        if (this.zab.containsKey(anyClientKeyZab)) {
            return (ConnectionResult) this.zab.get(anyClientKeyZab);
        }
        return null;
    }

    @Override // com.google.android.gms.common.api.internal.zaby
    public final BaseImplementation.ApiMethodImpl zae(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        apiMethodImpl.zak();
        this.zan.zaa(apiMethodImpl);
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zaby
    public final BaseImplementation.ApiMethodImpl zaf(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        apiMethodImpl.zak();
        return this.zan.zab(apiMethodImpl);
    }

    final void zai() {
        this.zai.lock();
        try {
            this.zag.zak();
            this.zan = new zaai(this);
            this.zan.zad();
            this.zaj.signalAll();
        } finally {
            this.zai.unlock();
        }
    }

    final void zaj() {
        this.zai.lock();
        try {
            this.zan = new zaau(this, this.zac, this.zad, this.zal, this.zae, this.zai, this.zak);
            this.zan.zad();
            this.zaj.signalAll();
        } finally {
            this.zai.unlock();
        }
    }

    final void zak(ConnectionResult connectionResult) {
        this.zai.lock();
        try {
            this.zao = connectionResult;
            this.zan = new zaav(this);
            this.zan.zad();
            this.zaj.signalAll();
        } finally {
            this.zai.unlock();
        }
    }

    final void zal(zabe zabeVar) {
        zabf zabfVar = this.zam;
        zabfVar.sendMessage(zabfVar.obtainMessage(1, zabeVar));
    }

    final void zam(RuntimeException runtimeException) {
        zabf zabfVar = this.zam;
        zabfVar.sendMessage(zabfVar.obtainMessage(2, runtimeException));
    }

    @Override // com.google.android.gms.common.api.internal.zaby
    public final void zaq() {
        this.zan.zae();
    }

    @Override // com.google.android.gms.common.api.internal.zaby
    public final void zar() {
        if (this.zan.zaj()) {
            this.zab.clear();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaby
    public final void zas(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("mState=").println(this.zan);
        for (Api api : this.zad.keySet()) {
            String strValueOf = String.valueOf(str);
            printWriter.append((CharSequence) str).append((CharSequence) api.zad()).println(":");
            ((Api.Client) Preconditions.checkNotNull((Api.Client) this.zaa.get(api.zab()))).dump(strValueOf.concat("  "), fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaby
    public final void zat() {
        if (this.zan instanceof zaai) {
            ((zaai) this.zan).zaf();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaby
    public final void zau() {
    }

    @Override // com.google.android.gms.common.api.internal.zaby
    public final boolean zaw() {
        return this.zan instanceof zaai;
    }

    @Override // com.google.android.gms.common.api.internal.zaby
    public final boolean zax() {
        return this.zan instanceof zaau;
    }

    @Override // com.google.android.gms.common.api.internal.zaby
    public final boolean zay(SignInConnectionListener signInConnectionListener) {
        return false;
    }
}

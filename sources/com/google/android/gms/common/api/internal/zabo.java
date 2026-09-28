package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zabo implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zau {
    final /* synthetic */ GoogleApiManager zaa;
    private final Api.Client zac;
    private final ApiKey zad;
    private final zaac zae;
    private final int zah;
    private final zacq zai;
    private boolean zaj;
    private final Queue zab = new LinkedList();
    private final Set zaf = new HashSet();
    private final Map zag = new HashMap();
    private final List zak = new ArrayList();
    private ConnectionResult zal = null;
    private int zam = 0;

    public zabo(GoogleApiManager googleApiManager, GoogleApi googleApi) {
        this.zaa = googleApiManager;
        Api.Client clientZab = googleApi.zab(googleApiManager.zas.getLooper(), this);
        this.zac = clientZab;
        this.zad = googleApi.getApiKey();
        this.zae = new zaac();
        this.zah = googleApi.zaa();
        if (clientZab.requiresSignIn()) {
            this.zai = googleApi.zac(googleApiManager.zaj, googleApiManager.zas);
        } else {
            this.zai = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Feature zaC(Feature[] featureArr) {
        if (featureArr != null && featureArr.length != 0) {
            Feature[] availableFeatures = this.zac.getAvailableFeatures();
            if (availableFeatures == null) {
                availableFeatures = new Feature[0];
            }
            ArrayMap arrayMap = new ArrayMap(availableFeatures.length);
            for (Feature feature : availableFeatures) {
                arrayMap.put(feature.getName(), Long.valueOf(feature.getVersion()));
            }
            for (Feature feature2 : featureArr) {
                Long l = (Long) arrayMap.get(feature2.getName());
                if (l == null || l.longValue() < feature2.getVersion()) {
                    return feature2;
                }
            }
        }
        return null;
    }

    private final void zaD(ConnectionResult connectionResult) {
        Iterator it = this.zaf.iterator();
        while (it.hasNext()) {
            ((zal) it.next()).zac(this.zad, connectionResult, Objects.equal(connectionResult, ConnectionResult.RESULT_SUCCESS) ? this.zac.getEndpointPackageName() : null);
        }
        this.zaf.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zaE(Status status) {
        Preconditions.checkHandlerThread(this.zaa.zas);
        zaF(status, null, false);
    }

    private final void zaF(Status status, Exception exc, boolean z) {
        Preconditions.checkHandlerThread(this.zaa.zas);
        if ((status == null) == (exc == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator it = this.zab.iterator();
        while (it.hasNext()) {
            zai zaiVar = (zai) it.next();
            if (!z || zaiVar.zac == 2) {
                if (status != null) {
                    zaiVar.zad(status);
                } else {
                    zaiVar.zae(exc);
                }
                it.remove();
            }
        }
    }

    private final void zaG() {
        ArrayList arrayList = new ArrayList(this.zab);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            zai zaiVar = (zai) arrayList.get(i);
            if (!this.zac.isConnected()) {
                return;
            }
            if (zaM(zaiVar)) {
                this.zab.remove(zaiVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zaH() {
        zan();
        zaD(ConnectionResult.RESULT_SUCCESS);
        zaL();
        Iterator it = this.zag.values().iterator();
        while (it.hasNext()) {
            zacg zacgVar = (zacg) it.next();
            if (zaC(zacgVar.zaa.getRequiredFeatures()) != null) {
                it.remove();
            } else {
                try {
                    zacgVar.zaa.registerListener(this.zac, new TaskCompletionSource<>());
                } catch (DeadObjectException unused) {
                    onConnectionSuspended(3);
                    this.zac.disconnect("DeadObjectException thrown while calling register listener method.");
                } catch (RemoteException e) {
                    e = e;
                    Log.e("GoogleApiManager", "Failed to register listener on re-connection.", e);
                    it.remove();
                } catch (RuntimeException e2) {
                    e = e2;
                    Log.e("GoogleApiManager", "Failed to register listener on re-connection.", e);
                    it.remove();
                }
            }
        }
        zaG();
        zaJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zaI(int i) {
        zan();
        this.zaj = true;
        this.zae.zae(i, this.zac.getLastDisconnectMessage());
        ApiKey apiKey = this.zad;
        GoogleApiManager googleApiManager = this.zaa;
        googleApiManager.zas.sendMessageDelayed(Message.obtain(googleApiManager.zas, 9, apiKey), 5000L);
        ApiKey apiKey2 = this.zad;
        GoogleApiManager googleApiManager2 = this.zaa;
        googleApiManager2.zas.sendMessageDelayed(Message.obtain(googleApiManager2.zas, 11, apiKey2), 120000L);
        this.zaa.zal.zac();
        Iterator it = this.zag.values().iterator();
        while (it.hasNext()) {
            ((zacg) it.next()).zac.run();
        }
    }

    private final void zaJ() {
        this.zaa.zas.removeMessages(12, this.zad);
        ApiKey apiKey = this.zad;
        GoogleApiManager googleApiManager = this.zaa;
        googleApiManager.zas.sendMessageDelayed(googleApiManager.zas.obtainMessage(12, apiKey), this.zaa.zaf);
    }

    private final void zaK(zai zaiVar) {
        zaiVar.zag(this.zae, zaA());
        try {
            zaiVar.zaf(this);
        } catch (DeadObjectException unused) {
            onConnectionSuspended(1);
            this.zac.disconnect("DeadObjectException thrown while running ApiCallRunner.");
        }
    }

    private final void zaL() {
        if (this.zaj) {
            GoogleApiManager googleApiManager = this.zaa;
            googleApiManager.zas.removeMessages(11, this.zad);
            GoogleApiManager googleApiManager2 = this.zaa;
            googleApiManager2.zas.removeMessages(9, this.zad);
            this.zaj = false;
        }
    }

    private final boolean zaM(zai zaiVar) {
        if (!(zaiVar instanceof zac)) {
            zaK(zaiVar);
            return true;
        }
        zac zacVar = (zac) zaiVar;
        Feature featureZaC = zaC(zacVar.zab(this));
        if (featureZaC == null) {
            zaK(zaiVar);
            return true;
        }
        Log.w("GoogleApiManager", this.zac.getClass().getName() + " could not execute call because it requires feature (" + featureZaC.getName() + ", " + featureZaC.getVersion() + ").");
        if (!this.zaa.zat || !zacVar.zaa(this)) {
            zacVar.zae(new UnsupportedApiCallException(featureZaC));
            return true;
        }
        zabp zabpVar = new zabp(this.zad, featureZaC, null);
        int iIndexOf = this.zak.indexOf(zabpVar);
        if (iIndexOf >= 0) {
            zabp zabpVar2 = (zabp) this.zak.get(iIndexOf);
            this.zaa.zas.removeMessages(15, zabpVar2);
            GoogleApiManager googleApiManager = this.zaa;
            googleApiManager.zas.sendMessageDelayed(Message.obtain(googleApiManager.zas, 15, zabpVar2), 5000L);
            return false;
        }
        this.zak.add(zabpVar);
        GoogleApiManager googleApiManager2 = this.zaa;
        googleApiManager2.zas.sendMessageDelayed(Message.obtain(googleApiManager2.zas, 15, zabpVar), 5000L);
        GoogleApiManager googleApiManager3 = this.zaa;
        googleApiManager3.zas.sendMessageDelayed(Message.obtain(googleApiManager3.zas, 16, zabpVar), 120000L);
        ConnectionResult connectionResult = new ConnectionResult(2, null);
        if (zaN(connectionResult)) {
            return false;
        }
        this.zaa.zaG(connectionResult, this.zah);
        return false;
    }

    private final boolean zaN(ConnectionResult connectionResult) {
        synchronized (GoogleApiManager.zac) {
            GoogleApiManager googleApiManager = this.zaa;
            if (googleApiManager.zap == null || !googleApiManager.zaq.contains(this.zad)) {
                return false;
            }
            this.zaa.zap.zah(connectionResult, this.zah);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zaO(boolean z) {
        Preconditions.checkHandlerThread(this.zaa.zas);
        if (!this.zac.isConnected() || !this.zag.isEmpty()) {
            return false;
        }
        if (!this.zae.zag()) {
            this.zac.disconnect("Timing out service connection.");
            return true;
        }
        if (!z) {
            return false;
        }
        zaJ();
        return false;
    }

    static /* bridge */ /* synthetic */ void zal(zabo zaboVar, zabp zabpVar) {
        if (zaboVar.zak.contains(zabpVar) && !zaboVar.zaj) {
            if (zaboVar.zac.isConnected()) {
                zaboVar.zaG();
            } else {
                zaboVar.zao();
            }
        }
    }

    static /* bridge */ /* synthetic */ void zam(zabo zaboVar, zabp zabpVar) {
        Feature[] featureArrZab;
        if (zaboVar.zak.remove(zabpVar)) {
            zaboVar.zaa.zas.removeMessages(15, zabpVar);
            zaboVar.zaa.zas.removeMessages(16, zabpVar);
            Feature feature = zabpVar.zab;
            ArrayList arrayList = new ArrayList(zaboVar.zab.size());
            for (zai zaiVar : zaboVar.zab) {
                if ((zaiVar instanceof zac) && (featureArrZab = ((zac) zaiVar).zab(zaboVar)) != null && ArrayUtils.contains(featureArrZab, feature)) {
                    arrayList.add(zaiVar);
                }
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zai zaiVar2 = (zai) arrayList.get(i);
                zaboVar.zab.remove(zaiVar2);
                zaiVar2.zae(new UnsupportedApiCallException(feature));
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        if (Looper.myLooper() == this.zaa.zas.getLooper()) {
            zaH();
        } else {
            this.zaa.zas.post(new zabk(this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zar(connectionResult, null);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        if (Looper.myLooper() == this.zaa.zas.getLooper()) {
            zaI(i);
        } else {
            this.zaa.zas.post(new zabl(this, i));
        }
    }

    public final boolean zaA() {
        return this.zac.requiresSignIn();
    }

    public final boolean zaB() {
        return zaO(true);
    }

    @Override // com.google.android.gms.common.api.internal.zau
    public final void zaa(ConnectionResult connectionResult, Api api, boolean z) {
        throw null;
    }

    public final int zab() {
        return this.zah;
    }

    final int zac() {
        return this.zam;
    }

    public final ConnectionResult zad() {
        Preconditions.checkHandlerThread(this.zaa.zas);
        return this.zal;
    }

    public final Api.Client zaf() {
        return this.zac;
    }

    public final Map zah() {
        return this.zag;
    }

    public final void zan() {
        Preconditions.checkHandlerThread(this.zaa.zas);
        this.zal = null;
    }

    public final void zao() {
        Preconditions.checkHandlerThread(this.zaa.zas);
        if (this.zac.isConnected() || this.zac.isConnecting()) {
            return;
        }
        try {
            GoogleApiManager googleApiManager = this.zaa;
            int iZab = googleApiManager.zal.zab(googleApiManager.zaj, this.zac);
            if (iZab != 0) {
                ConnectionResult connectionResult = new ConnectionResult(iZab, null);
                Log.w("GoogleApiManager", "The service for " + this.zac.getClass().getName() + " is not available: " + connectionResult.toString());
                zar(connectionResult, null);
                return;
            }
            GoogleApiManager googleApiManager2 = this.zaa;
            Api.Client client = this.zac;
            zabr zabrVar = new zabr(googleApiManager2, client, this.zad);
            if (client.requiresSignIn()) {
                ((zacq) Preconditions.checkNotNull(this.zai)).zae(zabrVar);
            }
            try {
                this.zac.connect(zabrVar);
            } catch (SecurityException e) {
                zar(new ConnectionResult(10), e);
            }
        } catch (IllegalStateException e2) {
            zar(new ConnectionResult(10), e2);
        }
    }

    public final void zap(zai zaiVar) {
        Preconditions.checkHandlerThread(this.zaa.zas);
        if (this.zac.isConnected()) {
            if (zaM(zaiVar)) {
                zaJ();
                return;
            } else {
                this.zab.add(zaiVar);
                return;
            }
        }
        this.zab.add(zaiVar);
        ConnectionResult connectionResult = this.zal;
        if (connectionResult == null || !connectionResult.hasResolution()) {
            zao();
        } else {
            zar(this.zal, null);
        }
    }

    final void zaq() {
        this.zam++;
    }

    public final void zar(ConnectionResult connectionResult, Exception exc) {
        Preconditions.checkHandlerThread(this.zaa.zas);
        zacq zacqVar = this.zai;
        if (zacqVar != null) {
            zacqVar.zaf();
        }
        zan();
        this.zaa.zal.zac();
        zaD(connectionResult);
        if ((this.zac instanceof com.google.android.gms.common.internal.service.zap) && connectionResult.getErrorCode() != 24) {
            this.zaa.zag = true;
            GoogleApiManager googleApiManager = this.zaa;
            googleApiManager.zas.sendMessageDelayed(googleApiManager.zas.obtainMessage(19), 300000L);
        }
        if (connectionResult.getErrorCode() == 4) {
            zaE(GoogleApiManager.zab);
            return;
        }
        if (connectionResult.getErrorCode() == 25) {
            zaE(GoogleApiManager.zaH(this.zad, connectionResult));
            return;
        }
        if (this.zab.isEmpty()) {
            this.zal = connectionResult;
            return;
        }
        if (exc != null) {
            Preconditions.checkHandlerThread(this.zaa.zas);
            zaF(null, exc, false);
            return;
        }
        if (!this.zaa.zat) {
            zaE(GoogleApiManager.zaH(this.zad, connectionResult));
            return;
        }
        zaF(GoogleApiManager.zaH(this.zad, connectionResult), null, true);
        if (this.zab.isEmpty() || zaN(connectionResult) || this.zaa.zaG(connectionResult, this.zah)) {
            return;
        }
        if (connectionResult.getErrorCode() == 18) {
            this.zaj = true;
        }
        if (!this.zaj) {
            zaE(GoogleApiManager.zaH(this.zad, connectionResult));
            return;
        }
        GoogleApiManager googleApiManager2 = this.zaa;
        googleApiManager2.zas.sendMessageDelayed(Message.obtain(googleApiManager2.zas, 9, this.zad), 5000L);
    }

    public final void zas(ConnectionResult connectionResult) {
        Preconditions.checkHandlerThread(this.zaa.zas);
        Api.Client client = this.zac;
        client.disconnect("onSignInFailed for " + client.getClass().getName() + " with " + String.valueOf(connectionResult));
        zar(connectionResult, null);
    }

    public final void zat(zal zalVar) {
        Preconditions.checkHandlerThread(this.zaa.zas);
        this.zaf.add(zalVar);
    }

    public final void zau() {
        Preconditions.checkHandlerThread(this.zaa.zas);
        if (this.zaj) {
            zao();
        }
    }

    public final void zav() {
        Preconditions.checkHandlerThread(this.zaa.zas);
        zaE(GoogleApiManager.zaa);
        this.zae.zaf();
        for (ListenerHolder.ListenerKey listenerKey : (ListenerHolder.ListenerKey[]) this.zag.keySet().toArray(new ListenerHolder.ListenerKey[0])) {
            zap(new zah(listenerKey, new TaskCompletionSource()));
        }
        zaD(new ConnectionResult(4));
        if (this.zac.isConnected()) {
            this.zac.onUserSignOut(new zabn(this));
        }
    }

    public final void zaw() {
        Preconditions.checkHandlerThread(this.zaa.zas);
        if (this.zaj) {
            zaL();
            GoogleApiManager googleApiManager = this.zaa;
            zaE(googleApiManager.zak.isGooglePlayServicesAvailable(googleApiManager.zaj) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.") : new Status(22, "API failed to connect while resuming due to an unknown error."));
            this.zac.disconnect("Timing out connection while resuming.");
        }
    }

    final boolean zaz() {
        return this.zac.isConnected();
    }
}

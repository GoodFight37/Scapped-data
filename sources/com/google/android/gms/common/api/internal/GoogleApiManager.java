package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLogging;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
public class GoogleApiManager implements Handler.Callback {
    private static GoogleApiManager zad;
    private TelemetryData zah;
    private TelemetryLoggingClient zai;
    private final Context zaj;
    private final GoogleApiAvailability zak;
    private final com.google.android.gms.common.internal.zal zal;
    private final Handler zas;
    private volatile boolean zat;
    public static final Status zaa = new Status(4, "Sign-out occurred while this API call was in progress.");
    private static final Status zab = new Status(4, "The user must be signed in to make this API call.");
    private static final Object zac = new Object();
    private static volatile boolean zae = false;
    private long zaf = 10000;
    private boolean zag = false;
    private final AtomicInteger zam = new AtomicInteger(1);
    private final AtomicInteger zan = new AtomicInteger(0);
    private final Map zao = new ConcurrentHashMap(5, 0.75f, 1);
    private zaad zap = null;
    private final Set zaq = new ArraySet();
    private final Set zar = new ArraySet();

    private GoogleApiManager(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        this.zat = true;
        this.zaj = context;
        com.google.android.gms.internal.base.zaq zaqVar = new com.google.android.gms.internal.base.zaq(looper, this);
        this.zas = zaqVar;
        this.zak = googleApiAvailability;
        this.zal = new com.google.android.gms.common.internal.zal(googleApiAvailability);
        if (DeviceProperties.isAuto(context)) {
            this.zat = false;
        }
        zaqVar.sendMessage(zaqVar.obtainMessage(6));
    }

    public static void reportSignOut() {
        synchronized (zac) {
            GoogleApiManager googleApiManager = zad;
            if (googleApiManager != null) {
                googleApiManager.zan.incrementAndGet();
                Handler handler = googleApiManager.zas;
                handler.sendMessageAtFrontOfQueue(handler.obtainMessage(10));
            }
        }
    }

    public static boolean zaE() {
        return zae;
    }

    public static boolean zaF() {
        synchronized (zac) {
            if (zad != null) {
                return false;
            }
            zae = true;
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Status zaH(ApiKey apiKey, ConnectionResult connectionResult) {
        return new Status(connectionResult, "API: " + apiKey.zaa() + " is not available on this device. Connection failed with: " + String.valueOf(connectionResult));
    }

    private final zabo zaI(GoogleApi googleApi) {
        Map map = this.zao;
        ApiKey apiKey = googleApi.getApiKey();
        zabo zaboVar = (zabo) map.get(apiKey);
        if (zaboVar == null) {
            zaboVar = new zabo(this, googleApi);
            this.zao.put(apiKey, zaboVar);
        }
        if (zaboVar.zaA()) {
            this.zar.add(apiKey);
        }
        zaboVar.zao();
        return zaboVar;
    }

    private final TelemetryLoggingClient zaJ() {
        if (this.zai == null) {
            this.zai = TelemetryLogging.getClient(this.zaj);
        }
        return this.zai;
    }

    private final void zaK() {
        TelemetryData telemetryData = this.zah;
        if (telemetryData != null) {
            if (telemetryData.zaa() > 0 || zaD()) {
                zaJ().log(telemetryData);
            }
            this.zah = null;
        }
    }

    private final void zaL(TaskCompletionSource taskCompletionSource, int i, GoogleApi googleApi) {
        zacb zacbVarZaa;
        if (i == 0 || (zacbVarZaa = zacb.zaa(this, i, googleApi.getApiKey())) == null) {
            return;
        }
        Task task = taskCompletionSource.getTask();
        Handler handler = this.zas;
        Objects.requireNonNull(handler);
        task.addOnCompleteListener(new zabi(handler), zacbVarZaa);
    }

    public static GoogleApiManager zaj() {
        GoogleApiManager googleApiManager;
        synchronized (zac) {
            Preconditions.checkNotNull(zad, "Must guarantee manager is non-null before using getInstance");
            googleApiManager = zad;
        }
        return googleApiManager;
    }

    public static GoogleApiManager zak(Context context) {
        GoogleApiManager googleApiManager;
        synchronized (zac) {
            if (zad == null) {
                zad = new GoogleApiManager(context.getApplicationContext(), GmsClientSupervisor.getOrStartHandlerThread().getLooper(), GoogleApiAvailability.getInstance());
                if (zae) {
                    Handler handler = zad.zas;
                    Objects.requireNonNull(handler);
                    GmsClient.zaf(new zabi(handler));
                }
            }
            googleApiManager = zad;
        }
        return googleApiManager;
    }

    /* JADX WARN: Code duplicated, block: B:63:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:65:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:66:0x021e  */
    /* JADX WARN: Code duplicated, block: B:67:0x022b  */
    /* JADX WARN: Instruction removed from duplicated block: B:65:0x01f0, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:67:0x022b, please report this as an issue */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        zabo zaboVar = null;
        switch (message.what) {
            case 1:
                this.zaf = true == ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                this.zas.removeMessages(12);
                for (ApiKey apiKey : this.zao.keySet()) {
                    Handler handler = this.zas;
                    handler.sendMessageDelayed(handler.obtainMessage(12, apiKey), this.zaf);
                }
                return true;
            case 2:
                zal zalVar = (zal) message.obj;
                for (ApiKey apiKey2 : zalVar.zab()) {
                    zabo zaboVar2 = (zabo) this.zao.get(apiKey2);
                    if (zaboVar2 == null) {
                        zalVar.zac(apiKey2, new ConnectionResult(13), null);
                        return true;
                    }
                    if (zaboVar2.zaz()) {
                        zalVar.zac(apiKey2, ConnectionResult.RESULT_SUCCESS, zaboVar2.zaf().getEndpointPackageName());
                    } else {
                        ConnectionResult connectionResultZad = zaboVar2.zad();
                        if (connectionResultZad != null) {
                            zalVar.zac(apiKey2, connectionResultZad, null);
                        } else {
                            zaboVar2.zat(zalVar);
                            zaboVar2.zao();
                        }
                    }
                }
                return true;
            case 3:
                for (zabo zaboVar3 : this.zao.values()) {
                    zaboVar3.zan();
                    zaboVar3.zao();
                }
                return true;
            case 4:
            case 8:
            case 13:
                zacf zacfVar = (zacf) message.obj;
                zabo zaboVarZaI = (zabo) this.zao.get(zacfVar.zac.getApiKey());
                if (zaboVarZaI == null) {
                    zaboVarZaI = zaI(zacfVar.zac);
                }
                if (!zaboVarZaI.zaA() || this.zan.get() == zacfVar.zab) {
                    zaboVarZaI.zap(zacfVar.zaa);
                } else {
                    zacfVar.zaa.zad(zaa);
                    zaboVarZaI.zav();
                }
                return true;
            case 5:
                int i = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                for (zabo zaboVar4 : this.zao.values()) {
                    if (zaboVar4.zab() == i) {
                        zaboVar = zaboVar4;
                        if (zaboVar != null) {
                            Log.wtf("GoogleApiManager", "Could not find API instance " + i + " while trying to fail enqueued calls.", new Exception());
                        } else if (connectionResult.getErrorCode() == 13) {
                            zaboVar.zaE(new Status(17, "Error resolution was canceled by the user, original error message: " + this.zak.getErrorString(connectionResult.getErrorCode()) + ": " + connectionResult.getErrorMessage()));
                        } else {
                            zaboVar.zaE(zaH(zaboVar.zad, connectionResult));
                        }
                        return true;
                    }
                }
                if (zaboVar != null) {
                    Log.wtf("GoogleApiManager", "Could not find API instance " + i + " while trying to fail enqueued calls.", new Exception());
                } else if (connectionResult.getErrorCode() == 13) {
                    zaboVar.zaE(new Status(17, "Error resolution was canceled by the user, original error message: " + this.zak.getErrorString(connectionResult.getErrorCode()) + ": " + connectionResult.getErrorMessage()));
                } else {
                    zaboVar.zaE(zaH(zaboVar.zad, connectionResult));
                }
                return true;
            case 6:
                if (this.zaj.getApplicationContext() instanceof Application) {
                    BackgroundDetector.initialize((Application) this.zaj.getApplicationContext());
                    BackgroundDetector.getInstance().addListener(new zabj(this));
                    if (!BackgroundDetector.getInstance().readCurrentStateIfPossible(true)) {
                        this.zaf = 300000L;
                    }
                }
                return true;
            case 7:
                zaI((GoogleApi) message.obj);
                return true;
            case 9:
                if (this.zao.containsKey(message.obj)) {
                    ((zabo) this.zao.get(message.obj)).zau();
                }
                return true;
            case 10:
                Iterator it = this.zar.iterator();
                while (it.hasNext()) {
                    zabo zaboVar5 = (zabo) this.zao.remove((ApiKey) it.next());
                    if (zaboVar5 != null) {
                        zaboVar5.zav();
                    }
                }
                this.zar.clear();
                return true;
            case 11:
                if (this.zao.containsKey(message.obj)) {
                    ((zabo) this.zao.get(message.obj)).zaw();
                }
                return true;
            case 12:
                if (this.zao.containsKey(message.obj)) {
                    ((zabo) this.zao.get(message.obj)).zaB();
                }
                return true;
            case 14:
                zaae zaaeVar = (zaae) message.obj;
                ApiKey apiKeyZaa = zaaeVar.zaa();
                if (this.zao.containsKey(apiKeyZaa)) {
                    zaaeVar.zab().setResult(Boolean.valueOf(((zabo) this.zao.get(apiKeyZaa)).zaO(false)));
                } else {
                    zaaeVar.zab().setResult(false);
                }
                return true;
            case 15:
                zabp zabpVar = (zabp) message.obj;
                if (this.zao.containsKey(zabpVar.zaa)) {
                    zabo.zal((zabo) this.zao.get(zabpVar.zaa), zabpVar);
                }
                return true;
            case 16:
                zabp zabpVar2 = (zabp) message.obj;
                if (this.zao.containsKey(zabpVar2.zaa)) {
                    zabo.zam((zabo) this.zao.get(zabpVar2.zaa), zabpVar2);
                }
                return true;
            case 17:
                zaK();
                return true;
            case 18:
                zacc zaccVar = (zacc) message.obj;
                if (zaccVar.zac == 0) {
                    zaJ().log(new TelemetryData(zaccVar.zab, Arrays.asList(zaccVar.zaa)));
                } else {
                    TelemetryData telemetryData = this.zah;
                    if (telemetryData != null) {
                        List listZab = telemetryData.zab();
                        if (telemetryData.zaa() != zaccVar.zab || (listZab != null && listZab.size() >= zaccVar.zad)) {
                            this.zas.removeMessages(17);
                            zaK();
                        } else {
                            this.zah.zac(zaccVar.zaa);
                        }
                    }
                    if (this.zah == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(zaccVar.zaa);
                        this.zah = new TelemetryData(zaccVar.zab, arrayList);
                        Handler handler2 = this.zas;
                        handler2.sendMessageDelayed(handler2.obtainMessage(17), zaccVar.zac);
                    }
                }
                return true;
            case 19:
                this.zag = false;
                return true;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + message.what);
                return false;
        }
    }

    public final void zaA(zaad zaadVar) {
        synchronized (zac) {
            if (this.zap != zaadVar) {
                this.zap = zaadVar;
                this.zaq.clear();
            }
            this.zaq.addAll(zaadVar.zaa());
        }
    }

    final void zaB(zaad zaadVar) {
        synchronized (zac) {
            if (this.zap == zaadVar) {
                this.zap = null;
                this.zaq.clear();
            }
        }
    }

    final boolean zaD() {
        if (this.zag) {
            return false;
        }
        RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
        if (config != null && !config.getMethodInvocationTelemetryEnabled()) {
            return false;
        }
        int iZaa = this.zal.zaa(this.zaj, 203400000);
        return iZaa == -1 || iZaa == 0;
    }

    final boolean zaG(ConnectionResult connectionResult, int i) {
        return this.zak.zah(this.zaj, connectionResult, i);
    }

    public final int zaa() {
        return this.zam.getAndIncrement();
    }

    final zabo zai(ApiKey apiKey) {
        return (zabo) this.zao.get(apiKey);
    }

    public final Task zam(Iterable iterable) {
        zal zalVar = new zal(iterable);
        this.zas.sendMessage(this.zas.obtainMessage(2, zalVar));
        return zalVar.zaa();
    }

    public final Task zan(GoogleApi googleApi) {
        zaae zaaeVar = new zaae(googleApi.getApiKey());
        this.zas.sendMessage(this.zas.obtainMessage(14, zaaeVar));
        return zaaeVar.zab().getTask();
    }

    public final Task zao(GoogleApi googleApi, RegisterListenerMethod registerListenerMethod, UnregisterListenerMethod unregisterListenerMethod, Runnable runnable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zaL(taskCompletionSource, registerListenerMethod.zaa(), googleApi);
        this.zas.sendMessage(this.zas.obtainMessage(8, new zacf(new zaf(new zacg(registerListenerMethod, unregisterListenerMethod, runnable), taskCompletionSource), this.zan.get(), googleApi)));
        return taskCompletionSource.getTask();
    }

    public final Task zap(GoogleApi googleApi, ListenerHolder.ListenerKey listenerKey, int i) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zaL(taskCompletionSource, i, googleApi);
        this.zas.sendMessage(this.zas.obtainMessage(13, new zacf(new zah(listenerKey, taskCompletionSource), this.zan.get(), googleApi)));
        return taskCompletionSource.getTask();
    }

    public final void zau(GoogleApi googleApi, int i, BaseImplementation.ApiMethodImpl apiMethodImpl) {
        this.zas.sendMessage(this.zas.obtainMessage(4, new zacf(new zae(i, apiMethodImpl), this.zan.get(), googleApi)));
    }

    public final void zav(GoogleApi googleApi, int i, TaskApiCall taskApiCall, TaskCompletionSource taskCompletionSource, StatusExceptionMapper statusExceptionMapper) {
        zaL(taskCompletionSource, taskApiCall.zaa(), googleApi);
        this.zas.sendMessage(this.zas.obtainMessage(4, new zacf(new zag(i, taskApiCall, taskCompletionSource, statusExceptionMapper), this.zan.get(), googleApi)));
    }

    final void zaw(MethodInvocation methodInvocation, int i, long j, int i2) {
        this.zas.sendMessage(this.zas.obtainMessage(18, new zacc(methodInvocation, i, j, i2)));
    }

    public final void zax(ConnectionResult connectionResult, int i) {
        if (zaG(connectionResult, i)) {
            return;
        }
        Handler handler = this.zas;
        handler.sendMessage(handler.obtainMessage(5, i, 0, connectionResult));
    }

    public final void zay() {
        Handler handler = this.zas;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final void zaz(GoogleApi googleApi) {
        Handler handler = this.zas;
        handler.sendMessage(handler.obtainMessage(7, googleApi));
    }
}

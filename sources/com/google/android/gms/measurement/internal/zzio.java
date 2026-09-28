package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.app.BroadcastOptions;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.content.ContextCompat;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzqr;
import com.google.api.client.http.HttpStatusCodes;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.DebugKt;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzio implements zzjs {
    private static volatile zzio zzb;
    private Boolean zzB;
    private long zzC;
    private volatile Boolean zzD;
    private volatile boolean zzE;
    private int zzF;
    private int zzG;
    final long zza;
    private final Context zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final boolean zzg;
    private final zzaf zzh;
    private final zzam zzi;
    private final zzht zzj;
    private final zzhe zzk;
    private final zzil zzl;
    private final zzop zzm;
    private final zzqf zzn;
    private final zzgx zzo;
    private final Clock zzp;
    private final zzmo zzq;
    private final zzlw zzr;
    private final zzd zzs;
    private final zzmb zzt;
    private final String zzu;
    private zzgv zzv;
    private zzny zzw;
    private zzbb zzx;
    private zzgs zzy;
    private zzmd zzz;
    private boolean zzA = false;
    private final AtomicInteger zzH = new AtomicInteger(0);

    zzio(zzke zzkeVar) {
        Preconditions.checkNotNull(zzkeVar);
        Context context = zzkeVar.zza;
        zzaf zzafVar = new zzaf(context);
        this.zzh = zzafVar;
        zzgf.zza = zzafVar;
        this.zzc = context;
        this.zzd = zzkeVar.zzb;
        this.zze = zzkeVar.zzc;
        this.zzf = zzkeVar.zzd;
        this.zzg = zzkeVar.zzh;
        this.zzD = zzkeVar.zze;
        this.zzu = zzkeVar.zzj;
        this.zzE = true;
        com.google.android.gms.internal.measurement.zzki.zzd(context);
        Clock defaultClock = DefaultClock.getInstance();
        this.zzp = defaultClock;
        Long l = zzkeVar.zzi;
        this.zza = l != null ? l.longValue() : defaultClock.currentTimeMillis();
        this.zzi = new zzam(this);
        zzht zzhtVar = new zzht(this);
        zzhtVar.zzw();
        this.zzj = zzhtVar;
        zzhe zzheVar = new zzhe(this);
        zzheVar.zzw();
        this.zzk = zzheVar;
        zzqf zzqfVar = new zzqf(this);
        zzqfVar.zzw();
        this.zzn = zzqfVar;
        this.zzo = new zzgx(new zzkd(zzkeVar, this));
        this.zzs = new zzd(this);
        zzmo zzmoVar = new zzmo(this);
        zzmoVar.zzb();
        this.zzq = zzmoVar;
        zzlw zzlwVar = new zzlw(this);
        zzlwVar.zzb();
        this.zzr = zzlwVar;
        zzop zzopVar = new zzop(this);
        zzopVar.zzb();
        this.zzm = zzopVar;
        zzmb zzmbVar = new zzmb(this);
        zzmbVar.zzw();
        this.zzt = zzmbVar;
        zzil zzilVar = new zzil(this);
        zzilVar.zzw();
        this.zzl = zzilVar;
        com.google.android.gms.internal.measurement.zzdh zzdhVar = zzkeVar.zzg;
        boolean z = zzdhVar == null || zzdhVar.zzb == 0;
        if (context.getApplicationContext() instanceof Application) {
            zzS(zzlwVar);
            if (zzlwVar.zzu.zzc.getApplicationContext() instanceof Application) {
                Application application = (Application) zzlwVar.zzu.zzc.getApplicationContext();
                if (zzlwVar.zza == null) {
                    zzlwVar.zza = new zzlv(zzlwVar);
                }
                if (z) {
                    application.unregisterActivityLifecycleCallbacks(zzlwVar.zza);
                    application.registerActivityLifecycleCallbacks(zzlwVar.zza);
                    zzhe zzheVar2 = zzlwVar.zzu.zzk;
                    zzT(zzheVar2);
                    zzheVar2.zzj().zza("Registered activity lifecycle callback");
                }
            }
        } else {
            zzT(zzheVar);
            zzheVar.zzk().zza("Application context is not an Application");
        }
        zzilVar.zzq(new zzin(this, zzkeVar));
    }

    public static /* synthetic */ void zzB(zzio zzioVar, String str, int i, Throwable th, byte[] bArr, Map map) {
        int i2;
        if (i != 200 && i != 204) {
            i2 = HttpStatusCodes.STATUS_CODE_NOT_MODIFIED;
            if (i != 304) {
                i2 = i;
            }
            zzhe zzheVar = zzioVar.zzk;
            zzT(zzheVar);
            zzheVar.zzk().zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i2), th);
        }
        i2 = i;
        if (th == null) {
            zzht zzhtVar = zzioVar.zzj;
            zzR(zzhtVar);
            zzhtVar.zzo.zza(true);
            if (bArr == null || bArr.length == 0) {
                zzhe zzheVar2 = zzioVar.zzk;
                zzT(zzheVar2);
                zzheVar2.zzd().zza("Deferred Deep Link response empty.");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                String strOptString = jSONObject.optString(Constants.DEEPLINK, "");
                if (TextUtils.isEmpty(strOptString)) {
                    zzhe zzheVar3 = zzioVar.zzk;
                    zzT(zzheVar3);
                    zzheVar3.zzd().zza("Deferred Deep Link is empty.");
                    return;
                }
                String strOptString2 = jSONObject.optString("gclid", "");
                String strOptString3 = jSONObject.optString("gbraid", "");
                String strOptString4 = jSONObject.optString("gad_source", "");
                double dOptDouble = jSONObject.optDouble("timestamp", 0.0d);
                Bundle bundle = new Bundle();
                zzqf zzqfVar = zzioVar.zzn;
                zzR(zzqfVar);
                zzio zzioVar2 = zzqfVar.zzu;
                if (!TextUtils.isEmpty(strOptString)) {
                    Context context = zzioVar2.zzc;
                    List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(strOptString)), 0);
                    if (listQueryIntentActivities != null && !listQueryIntentActivities.isEmpty()) {
                        if (!TextUtils.isEmpty(strOptString3)) {
                            bundle.putString("gbraid", strOptString3);
                        }
                        if (!TextUtils.isEmpty(strOptString4)) {
                            bundle.putString("gad_source", strOptString4);
                        }
                        bundle.putString("gclid", strOptString2);
                        bundle.putString("_cis", "ddp");
                        zzioVar.zzr.zzR(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, com.google.firebase.messaging.Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundle);
                        zzR(zzqfVar);
                        if (TextUtils.isEmpty(strOptString)) {
                            return;
                        }
                        try {
                            SharedPreferences.Editor editorEdit = context.getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
                            editorEdit.putString(Constants.DEEPLINK, strOptString);
                            editorEdit.putLong("timestamp", Double.doubleToRawLongBits(dOptDouble));
                            if (editorEdit.commit()) {
                                Intent intent = new Intent("android.google.analytics.action.DEEPLINK_ACTION");
                                Context context2 = zzqfVar.zzu.zzc;
                                if (Build.VERSION.SDK_INT < 34) {
                                    context2.sendBroadcast(intent);
                                    return;
                                } else {
                                    context2.sendBroadcast(intent, null, BroadcastOptions.makeBasic().setShareIdentityEnabled(true).toBundle());
                                    return;
                                }
                            }
                            return;
                        } catch (RuntimeException e) {
                            zzhe zzheVar4 = zzqfVar.zzu.zzk;
                            zzT(zzheVar4);
                            zzheVar4.zze().zzb("Failed to persist Deferred Deep Link. exception", e);
                            return;
                        }
                    }
                }
                zzhe zzheVar5 = zzioVar.zzk;
                zzT(zzheVar5);
                zzheVar5.zzk().zzd("Deferred Deep Link validation failed. gclid, gbraid, deep link", strOptString2, strOptString3, strOptString);
                return;
            } catch (JSONException e2) {
                zzhe zzheVar6 = zzioVar.zzk;
                zzT(zzheVar6);
                zzheVar6.zze().zzb("Failed to parse the Deferred Deep Link response. exception", e2);
                return;
            }
        }
        zzhe zzheVar7 = zzioVar.zzk;
        zzT(zzheVar7);
        zzheVar7.zzk().zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i2), th);
    }

    static /* synthetic */ void zzC(zzio zzioVar, zzke zzkeVar) {
        zzil zzilVar = zzioVar.zzl;
        zzT(zzilVar);
        zzilVar.zzg();
        zzam zzamVar = zzioVar.zzi;
        zzamVar.zzq();
        zzbb zzbbVar = new zzbb(zzioVar);
        zzbbVar.zzw();
        zzioVar.zzx = zzbbVar;
        com.google.android.gms.internal.measurement.zzdh zzdhVar = zzkeVar.zzg;
        zzgs zzgsVar = new zzgs(zzioVar, zzkeVar.zzf, zzdhVar == null ? 0L : zzdhVar.zza);
        zzgsVar.zzb();
        zzioVar.zzy = zzgsVar;
        zzgv zzgvVar = new zzgv(zzioVar);
        zzgvVar.zzb();
        zzioVar.zzv = zzgvVar;
        zzny zznyVar = new zzny(zzioVar);
        zznyVar.zzb();
        zzioVar.zzw = zznyVar;
        zzqf zzqfVar = zzioVar.zzn;
        zzqfVar.zzx();
        zzioVar.zzj.zzx();
        zzioVar.zzy.zzc();
        zzmd zzmdVar = new zzmd(zzioVar);
        zzmdVar.zzb();
        zzioVar.zzz = zzmdVar;
        zzmdVar.zzc();
        zzhe zzheVar = zzioVar.zzk;
        zzT(zzheVar);
        zzhc zzhcVarZzi = zzheVar.zzi();
        zzamVar.zzj();
        zzhcVarZzi.zzb("App measurement initialized, version", 119002L);
        zzT(zzheVar);
        zzheVar.zzi().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String strZzm = zzgsVar.zzm();
        if (TextUtils.isEmpty(zzioVar.zzd)) {
            zzR(zzqfVar);
            if (zzqfVar.zzak(strZzm, zzamVar.zzs())) {
                zzT(zzheVar);
                zzheVar.zzi().zza("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
            } else {
                zzT(zzheVar);
                zzheVar.zzi().zza("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(String.valueOf(strZzm)));
            }
        }
        zzT(zzheVar);
        zzheVar.zzd().zza("Debug-level message logging enabled");
        int i = zzioVar.zzF;
        AtomicInteger atomicInteger = zzioVar.zzH;
        if (i != atomicInteger.get()) {
            zzT(zzheVar);
            zzheVar.zze().zzc("Not all components initialized", Integer.valueOf(zzioVar.zzF), Integer.valueOf(atomicInteger.get()));
        }
        zzioVar.zzA = true;
    }

    static final void zzP() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    private static final void zzQ(zzf zzfVar) {
        if (zzfVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static final void zzR(zzjq zzjqVar) {
        if (zzjqVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static final void zzS(zzg zzgVar) {
        if (zzgVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (!zzgVar.zze()) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(String.valueOf(zzgVar.getClass()))));
        }
    }

    private static final void zzT(zzjr zzjrVar) {
        if (zzjrVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (!zzjrVar.zzy()) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(String.valueOf(zzjrVar.getClass()))));
        }
    }

    public static zzio zzp(Context context, com.google.android.gms.internal.measurement.zzdh zzdhVar, Long l) {
        Bundle bundle;
        if (zzdhVar != null && (zzdhVar.zze == null || zzdhVar.zzf == null)) {
            zzdhVar = new com.google.android.gms.internal.measurement.zzdh(zzdhVar.zza, zzdhVar.zzb, zzdhVar.zzc, zzdhVar.zzd, null, null, zzdhVar.zzg, null);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzio.class) {
                if (zzb == null) {
                    zzb = new zzio(new zzke(context, zzdhVar, l));
                }
            }
        } else if (zzdhVar != null && (bundle = zzdhVar.zzg) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            Preconditions.checkNotNull(zzb);
            zzb.zzD = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled"));
        }
        Preconditions.checkNotNull(zzb);
        return zzb;
    }

    @Pure
    public final String zzA() {
        return this.zzu;
    }

    final void zzD() {
        this.zzH.incrementAndGet();
    }

    final void zzE() {
        this.zzF++;
    }

    final void zzF(boolean z) {
        this.zzD = Boolean.valueOf(z);
    }

    public final void zzG(boolean z) {
        zzil zzilVar = this.zzl;
        zzT(zzilVar);
        zzilVar.zzg();
        this.zzE = z;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:13:0x003c  */
    /* JADX WARN: Code duplicated, block: B:16:0x0059  */
    /* JADX WARN: Code duplicated, block: B:19:0x007b  */
    /* JADX WARN: Code duplicated, block: B:27:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:38:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:40:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:49:0x011c  */
    protected final void zzH(com.google.android.gms.internal.measurement.zzdh zzdhVar) {
        zzjx zzjxVarZzj;
        Bundle bundle;
        Boolean boolZzg;
        Bundle bundle2;
        boolean zZzaw;
        Bundle bundle3;
        IntentFilter intentFilter;
        zzio zzioVar;
        zzil zzilVar = this.zzl;
        zzT(zzilVar);
        zzilVar.zzg();
        zzgg zzggVar = zzgi.zzaR;
        zzam zzamVar = this.zzi;
        boolean z = zzamVar.zzx(null, zzggVar) && zzs().zzi() == com.google.android.gms.internal.measurement.zzih.CLIENT_UPLOAD_ELIGIBLE;
        zzqr.zzb();
        if (zzamVar.zzx(null, zzgi.zzaW)) {
            zzqf zzqfVar = this.zzn;
            zzR(zzqfVar);
            if (zzqfVar.zzan()) {
                zzqf zzqfVar2 = this.zzn;
                zzR(zzqfVar2);
                zzqfVar2.zzg();
                intentFilter = new IntentFilter();
                intentFilter.addAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
                zzioVar = zzqfVar2.zzu;
                if (zzioVar.zzi.zzx(null, zzggVar)) {
                    intentFilter.addAction("com.google.android.gms.measurement.BATCHES_AVAILABLE");
                }
                ContextCompat.registerReceiver(zzioVar.zzc, new zzw(zzqfVar2.zzu), intentFilter, 2);
                zzhe zzheVar = zzioVar.zzk;
                zzT(zzheVar);
                zzheVar.zzd().zza("Registered app receiver");
                if (z) {
                    zzs().zzj(((Long) zzgi.zzB.zza(null)).longValue());
                }
            } else if (z) {
                z = true;
                zzqf zzqfVar3 = this.zzn;
                zzR(zzqfVar3);
                zzqfVar3.zzg();
                intentFilter = new IntentFilter();
                intentFilter.addAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
                zzioVar = zzqfVar3.zzu;
                if (zzioVar.zzi.zzx(null, zzggVar)) {
                    intentFilter.addAction("com.google.android.gms.measurement.BATCHES_AVAILABLE");
                }
                ContextCompat.registerReceiver(zzioVar.zzc, new zzw(zzqfVar3.zzu), intentFilter, 2);
                zzhe zzheVar2 = zzioVar.zzk;
                zzT(zzheVar2);
                zzheVar2.zzd().zza("Registered app receiver");
                if (z) {
                    zzs().zzj(((Long) zzgi.zzB.zza(null)).longValue());
                }
            }
        } else if (z) {
            z = true;
            zzqf zzqfVar4 = this.zzn;
            zzR(zzqfVar4);
            zzqfVar4.zzg();
            intentFilter = new IntentFilter();
            intentFilter.addAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
            zzioVar = zzqfVar4.zzu;
            if (zzioVar.zzi.zzx(null, zzggVar)) {
                intentFilter.addAction("com.google.android.gms.measurement.BATCHES_AVAILABLE");
            }
            ContextCompat.registerReceiver(zzioVar.zzc, new zzw(zzqfVar4.zzu), intentFilter, 2);
            zzhe zzheVar3 = zzioVar.zzk;
            zzT(zzheVar3);
            zzheVar3.zzd().zza("Registered app receiver");
            if (z) {
                zzs().zzj(((Long) zzgi.zzB.zza(null)).longValue());
            }
        }
        zzht zzhtVar = this.zzj;
        zzR(zzhtVar);
        zzjx zzjxVarZzh = zzhtVar.zzh();
        int iZzb = zzjxVarZzh.zzb();
        zzju zzjuVarZzm = zzamVar.zzm("google_analytics_default_allow_ad_storage", false);
        zzju zzjuVarZzm2 = zzamVar.zzm("google_analytics_default_allow_analytics_storage", false);
        zzju zzjuVar = zzju.UNINITIALIZED;
        if (zzjuVarZzm != zzjuVar || zzjuVarZzm2 != zzju.UNINITIALIZED) {
            zzR(zzhtVar);
            if (zzhtVar.zzq(-10)) {
                zzjxVarZzj = zzjx.zzj(zzjuVarZzm, zzjuVarZzm2, -10);
            } else {
                if (TextUtils.isEmpty(zzh().zzo()) && (iZzb == 0 || iZzb == 30 || iZzb == 10 || iZzb == 30 || iZzb == 30 || iZzb == 40)) {
                    zzlw zzlwVar = this.zzr;
                    zzS(zzlwVar);
                    zzlwVar.zzak(new zzjx(null, null, -10), false);
                } else if (zzamVar.zzx(null, zzgi.zzbp) && TextUtils.isEmpty(zzh().zzo()) && zzdhVar != null && (bundle3 = zzdhVar.zzg) != null) {
                    zzR(zzhtVar);
                    if (zzhtVar.zzq(30)) {
                        zzjxVarZzj = zzjx.zzi(bundle3, 30);
                        if (!zzjxVarZzj.zzt()) {
                        }
                    }
                }
                zzjxVarZzj = null;
            }
        } else if (TextUtils.isEmpty(zzh().zzo())) {
            if (zzamVar.zzx(null, zzgi.zzbp)) {
                zzjxVarZzj = null;
            } else {
                zzjxVarZzj = null;
            }
        } else if (zzamVar.zzx(null, zzgi.zzbp)) {
            zzjxVarZzj = null;
        } else {
            zzjxVarZzj = null;
        }
        if (zzjxVarZzj != null) {
            zzlw zzlwVar2 = this.zzr;
            zzS(zzlwVar2);
            zzlwVar2.zzak(zzjxVarZzj, true);
            zzjxVarZzh = zzjxVarZzj;
        }
        zzlw zzlwVar3 = this.zzr;
        zzS(zzlwVar3);
        zzlwVar3.zzaj(zzjxVarZzh);
        zzR(zzhtVar);
        int iZza = zzhtVar.zzf().zza();
        zzju zzjuVarZzm3 = zzamVar.zzm("google_analytics_default_allow_ad_personalization_signals", true);
        if (zzjuVarZzm3 != zzjuVar) {
            zzhe zzheVar4 = this.zzk;
            zzT(zzheVar4);
            zzheVar4.zzj().zzb("Default ad personalization consent from Manifest", zzjuVarZzm3);
        }
        zzju zzjuVarZzm4 = zzamVar.zzm("google_analytics_default_allow_ad_user_data", true);
        if (zzjuVarZzm4 != zzju.UNINITIALIZED && zzjx.zzs(-10, iZza)) {
            zzS(zzlwVar3);
            zzlwVar3.zzag(zzba.zzd(zzjuVarZzm4, -10), true);
        } else if (TextUtils.isEmpty(zzh().zzo()) || !(iZza == 0 || iZza == 30)) {
            if (TextUtils.isEmpty(zzh().zzo()) && zzdhVar != null && (bundle2 = zzdhVar.zzg) != null && zzjx.zzs(30, iZza)) {
                zzba zzbaVarZzc = zzba.zzc(bundle2, 30);
                if (zzbaVarZzc.zzk()) {
                    zzS(zzlwVar3);
                    zzlwVar3.zzag(zzbaVarZzc, true);
                }
            }
            if (TextUtils.isEmpty(zzh().zzo()) && zzdhVar != null && (bundle = zzdhVar.zzg) != null) {
                zzR(zzhtVar);
                if (zzhtVar.zzh.zza() == null && (boolZzg = zzba.zzg(bundle)) != null) {
                    zzS(zzlwVar3);
                    zzlwVar3.zzal(zzdhVar.zze, FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS, boolZzg.toString(), false);
                }
            }
        } else {
            zzS(zzlwVar3);
            zzlwVar3.zzag(new zzba((Boolean) null, -10, (Boolean) null, (String) null), true);
        }
        zzio zzioVar2 = zzamVar.zzu;
        Boolean boolZzn = zzamVar.zzn("google_analytics_tcf_data_enabled");
        if (boolZzn == null || boolZzn.booleanValue()) {
            zzhe zzheVar5 = this.zzk;
            zzT(zzheVar5);
            zzheVar5.zzd().zza("TCF client enabled.");
            zzS(zzlwVar3);
            zzlwVar3.zzW();
            zzS(zzlwVar3);
            zzlwVar3.zzN();
        }
        zzR(zzhtVar);
        zzhp zzhpVar = zzhtVar.zzc;
        if (zzhpVar.zza() == 0) {
            zzhe zzheVar6 = this.zzk;
            zzT(zzheVar6);
            long j = this.zza;
            zzheVar6.zzj().zzb("Persisting first open", Long.valueOf(j));
            zzR(zzhtVar);
            zzhpVar.zzb(j);
        }
        zzS(zzlwVar3);
        zzlwVar3.zzb.zzc();
        if (zzM()) {
            if (!TextUtils.isEmpty(zzh().zzo()) || (!zzamVar.zzx(null, zzgi.zzbp) && !TextUtils.isEmpty(zzh().zzl()))) {
                zzgg zzggVar2 = zzgi.zzbp;
                if (zzamVar.zzx(null, zzggVar2)) {
                    zzqf zzqfVar5 = this.zzn;
                    zzR(zzqfVar5);
                    String strZzo = zzh().zzo();
                    zzR(zzhtVar);
                    zZzaw = zzqfVar5.zzav(strZzo, zzhtVar.zzj());
                } else {
                    zzqf zzqfVar6 = this.zzn;
                    zzR(zzqfVar6);
                    String strZzo2 = zzh().zzo();
                    zzR(zzhtVar);
                    String strZzj = zzhtVar.zzj();
                    String strZzl = zzh().zzl();
                    zzR(zzhtVar);
                    zzhtVar.zzg();
                    zZzaw = zzqfVar6.zzaw(strZzo2, strZzj, strZzl, zzhtVar.zzb().getString("admob_app_id", null));
                }
                if (zZzaw) {
                    zzhe zzheVar7 = this.zzk;
                    zzT(zzheVar7);
                    zzheVar7.zzi().zza("Rechecking which service to use due to a GMP App Id change");
                    zzR(zzhtVar);
                    zzhtVar.zzg();
                    Boolean boolZzi = zzhtVar.zzi();
                    SharedPreferences.Editor editorEdit = zzhtVar.zzb().edit();
                    editorEdit.clear();
                    editorEdit.apply();
                    if (boolZzi != null) {
                        zzhtVar.zzm(boolZzi);
                    }
                    zzi().zzj();
                    this.zzw.zzC();
                    this.zzw.zzB();
                    zzR(zzhtVar);
                    zzhpVar.zzb(this.zza);
                    zzR(zzhtVar);
                    zzhtVar.zze.zzb(null);
                }
                zzR(zzhtVar);
                String strZzo3 = zzh().zzo();
                zzhtVar.zzg();
                SharedPreferences.Editor editorEdit2 = zzhtVar.zzb().edit();
                editorEdit2.putString("gmp_app_id", strZzo3);
                editorEdit2.apply();
                if (zzamVar.zzx(null, zzggVar2)) {
                    zzR(zzhtVar);
                    zzhtVar.zzl(null);
                } else {
                    zzR(zzhtVar);
                    zzhtVar.zzl(zzh().zzl());
                }
            }
            zzR(zzhtVar);
            if (!zzhtVar.zzh().zzr(zzjw.ANALYTICS_STORAGE)) {
                zzR(zzhtVar);
                zzhtVar.zze.zzb(null);
            }
            zzS(zzlwVar3);
            zzR(zzhtVar);
            zzlwVar3.zzac(zzhtVar.zze.zza());
            zzqf zzqfVar7 = this.zzn;
            zzR(zzqfVar7);
            try {
                zzqfVar7.zzu.zzc.getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
            } catch (ClassNotFoundException unused) {
                zzht zzhtVar2 = this.zzj;
                zzR(zzhtVar2);
                zzhr zzhrVar = zzhtVar2.zzq;
                if (!TextUtils.isEmpty(zzhrVar.zza())) {
                    zzhe zzheVar8 = this.zzk;
                    zzT(zzheVar8);
                    zzheVar8.zzk().zza("Remote config removed with active feature rollouts");
                    zzR(zzhtVar2);
                    zzhrVar.zzb(null);
                }
            }
            if (!TextUtils.isEmpty(zzh().zzo()) || (!this.zzi.zzx(null, zzgi.zzbp) && !TextUtils.isEmpty(zzh().zzl()))) {
                boolean zZzJ = zzJ();
                zzht zzhtVar3 = this.zzj;
                zzR(zzhtVar3);
                if (!zzhtVar3.zzo() && !this.zzi.zzA()) {
                    zzR(zzhtVar3);
                    zzhtVar3.zzn(!zZzJ);
                }
                if (zZzJ) {
                    zzlw zzlwVar4 = this.zzr;
                    zzS(zzlwVar4);
                    zzlwVar4.zzH();
                }
                zzop zzopVar = this.zzm;
                zzS(zzopVar);
                zzopVar.zza.zza();
                zzu().zzE(new AtomicReference());
                zzny zznyVarZzu = zzu();
                zzR(zzhtVar3);
                zznyVarZzu.zzT(zzhtVar3.zzt.zza());
            }
        } else if (zzJ()) {
            zzqf zzqfVar8 = this.zzn;
            zzR(zzqfVar8);
            if (!zzqfVar8.zzaj("android.permission.INTERNET")) {
                zzhe zzheVar9 = this.zzk;
                zzT(zzheVar9);
                zzheVar9.zze().zza("App is missing INTERNET permission");
            }
            zzR(zzqfVar8);
            if (!zzqfVar8.zzaj("android.permission.ACCESS_NETWORK_STATE")) {
                zzhe zzheVar10 = this.zzk;
                zzT(zzheVar10);
                zzheVar10.zze().zza("App is missing ACCESS_NETWORK_STATE permission");
            }
            Context context = this.zzc;
            if (!Wrappers.packageManager(context).isCallerInstantApp() && !this.zzi.zzC()) {
                if (!zzqf.zzar(context)) {
                    zzhe zzheVar11 = this.zzk;
                    zzT(zzheVar11);
                    zzheVar11.zze().zza("AppMeasurementReceiver not registered/enabled");
                }
                if (!zzqf.zzat(context, false)) {
                    zzhe zzheVar12 = this.zzk;
                    zzT(zzheVar12);
                    zzheVar12.zze().zza("AppMeasurementService not registered/enabled");
                }
            }
            zzhe zzheVar13 = this.zzk;
            zzT(zzheVar13);
            zzheVar13.zze().zza("Uploading is not possible. App measurement disabled");
        }
        zzqr.zzb();
        if (this.zzi.zzx(null, zzgi.zzaW)) {
            zzqf zzqfVar9 = this.zzn;
            zzR(zzqfVar9);
            if (zzqfVar9.zzan()) {
                long jMax = Math.max(500L, ((((long) ((Integer) zzgi.zzaw.zza(null)).intValue()) * 1000) + ((long) new Random().nextInt(5000))) - this.zzp.elapsedRealtime());
                if (jMax > 500) {
                    zzhe zzheVar14 = this.zzk;
                    zzT(zzheVar14);
                    zzheVar14.zzj().zzb("Waiting to fetch trigger URIs until some time after boot. Delay in millis", Long.valueOf(jMax));
                }
                zzlw zzlwVar5 = this.zzr;
                zzS(zzlwVar5);
                zzlwVar5.zzab(jMax);
            }
        }
        zzht zzhtVar4 = this.zzj;
        zzR(zzhtVar4);
        zzhtVar4.zzj.zza(true);
    }

    public final boolean zzI() {
        return this.zzD != null && this.zzD.booleanValue();
    }

    public final boolean zzJ() {
        return zza() == 0;
    }

    public final boolean zzK() {
        zzil zzilVar = this.zzl;
        zzT(zzilVar);
        zzilVar.zzg();
        return this.zzE;
    }

    @Pure
    public final boolean zzL() {
        return TextUtils.isEmpty(this.zzd);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0075  */
    protected final boolean zzM() {
        boolean z;
        if (!this.zzA) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
        zzil zzilVar = this.zzl;
        zzT(zzilVar);
        zzilVar.zzg();
        Boolean bool = this.zzB;
        if (bool == null || this.zzC == 0 || (!bool.booleanValue() && Math.abs(this.zzp.elapsedRealtime() - this.zzC) > 1000)) {
            this.zzC = this.zzp.elapsedRealtime();
            zzqf zzqfVar = this.zzn;
            zzR(zzqfVar);
            boolean z2 = true;
            if (zzqfVar.zzaj("android.permission.INTERNET")) {
                zzR(zzqfVar);
                if (zzqfVar.zzaj("android.permission.ACCESS_NETWORK_STATE")) {
                    Context context = this.zzc;
                    if (Wrappers.packageManager(context).isCallerInstantApp() || this.zzi.zzC() || (zzqf.zzar(context) && zzqf.zzat(context, false))) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            Boolean boolValueOf = Boolean.valueOf(z);
            this.zzB = boolValueOf;
            if (boolValueOf.booleanValue()) {
                zzR(zzqfVar);
                if (!zzqfVar.zzac(zzh().zzo(), zzh().zzl()) && (this.zzi.zzx(null, zzgi.zzbp) || TextUtils.isEmpty(zzh().zzl()))) {
                    z2 = false;
                }
                this.zzB = Boolean.valueOf(z2);
            }
        }
        return this.zzB.booleanValue();
    }

    @Pure
    public final boolean zzN() {
        return this.zzg;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0089  */
    /* JADX WARN: Code duplicated, block: B:24:0x009d  */
    /* JADX WARN: Code duplicated, block: B:27:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:29:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:32:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:33:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:36:0x00da  */
    /* JADX WARN: Code duplicated, block: B:38:0x010f  */
    public final boolean zzO() {
        NetworkInfo activeNetworkInfo;
        Bundle bundle;
        zzba zzbaVarZzc;
        int i;
        String str;
        zzil zzilVar = this.zzl;
        zzT(zzilVar);
        zzilVar.zzg();
        zzmb zzmbVar = this.zzt;
        zzT(zzmbVar);
        zzT(zzmbVar);
        String strZzm = zzh().zzm();
        if (!this.zzi.zzw()) {
            zzhe zzheVar = this.zzk;
            zzT(zzheVar);
            zzheVar.zzj().zza("ADID collection is disabled from Manifest. Skipping");
            return false;
        }
        zzht zzhtVar = this.zzj;
        zzR(zzhtVar);
        Pair pairZzd = zzhtVar.zzd(strZzm);
        if (((Boolean) pairZzd.second).booleanValue() || TextUtils.isEmpty((CharSequence) pairZzd.first)) {
            zzhe zzheVar2 = this.zzk;
            zzT(zzheVar2);
            zzheVar2.zzj().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return false;
        }
        zzT(zzmbVar);
        zzmbVar.zzv();
        ConnectivityManager connectivityManager = (ConnectivityManager) zzmbVar.zzu.zzc.getSystemService("connectivity");
        if (connectivityManager != null) {
            try {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
                activeNetworkInfo = null;
            }
        } else {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            zzhe zzheVar3 = this.zzk;
            zzT(zzheVar3);
            zzheVar3.zzk().zza("Network is not available for Deferred Deep Link request. Skipping");
            return false;
        }
        StringBuilder sb = new StringBuilder();
        zzny zznyVarZzu = zzu();
        zznyVarZzu.zzg();
        zznyVarZzu.zza();
        if (zznyVarZzu.zzad()) {
            zzqf zzqfVar = zznyVarZzu.zzu.zzn;
            zzR(zzqfVar);
            if (zzqfVar.zzm() >= 234200) {
                zzlw zzlwVar = this.zzr;
                zzS(zzlwVar);
                zzio zzioVar = zzlwVar.zzu;
                zzlwVar.zzg();
                zzap zzapVarZzh = zzioVar.zzu().zzh();
                if (zzapVarZzh != null) {
                }
                if (bundle == null) {
                    i = this.zzG;
                    this.zzG = i + 1;
                    if (i < 10) {
                    }
                    zzhe zzheVar4 = this.zzk;
                    zzT(zzheVar4);
                    zzhc zzhcVarZzd = zzheVar4.zzd();
                    StringBuilder sb2 = new StringBuilder("Failed to retrieve DMA consent from the service, ");
                    if (i < 10) {
                        str = "Retrying.";
                    } else {
                        str = "Skipping.";
                    }
                    sb2.append(str);
                    sb2.append(" retryCount");
                    zzhcVarZzd.zzb(sb2.toString(), Integer.valueOf(this.zzG));
                    return z;
                }
                zzjx zzjxVarZzi = zzjx.zzi(bundle, 100);
                sb.append("&gcs=");
                sb.append(zzjxVarZzi.zzp());
                zzbaVarZzc = zzba.zzc(bundle, 100);
                sb.append("&dma=");
                sb.append(!Objects.equals(zzbaVarZzc.zzh(), false) ? 1 : 0);
                if (!TextUtils.isEmpty(zzbaVarZzc.zzi())) {
                    sb.append("&dma_cps=");
                    sb.append(zzbaVarZzc.zzi());
                }
                int i2 = !Objects.equals(zzba.zzg(bundle), true) ? 1 : 0;
                sb.append("&npa=");
                sb.append(i2);
                zzhe zzheVar5 = this.zzk;
                zzT(zzheVar5);
                zzheVar5.zzj().zzb("Consent query parameters to Bow", sb);
            }
        } else {
            zzlw zzlwVar2 = this.zzr;
            zzS(zzlwVar2);
            zzio zzioVar2 = zzlwVar2.zzu;
            zzlwVar2.zzg();
            zzap zzapVarZzh2 = zzioVar2.zzu().zzh();
            bundle = zzapVarZzh2 != null ? zzapVarZzh2.zza : null;
            if (bundle == null) {
                i = this.zzG;
                this.zzG = i + 1;
                boolean z = i < 10;
                zzhe zzheVar6 = this.zzk;
                zzT(zzheVar6);
                zzhc zzhcVarZzd2 = zzheVar6.zzd();
                StringBuilder sb3 = new StringBuilder("Failed to retrieve DMA consent from the service, ");
                if (i < 10) {
                    str = "Retrying.";
                } else {
                    str = "Skipping.";
                }
                sb3.append(str);
                sb3.append(" retryCount");
                zzhcVarZzd2.zzb(sb3.toString(), Integer.valueOf(this.zzG));
                return z;
            }
            zzjx zzjxVarZzi2 = zzjx.zzi(bundle, 100);
            sb.append("&gcs=");
            sb.append(zzjxVarZzi2.zzp());
            zzbaVarZzc = zzba.zzc(bundle, 100);
            sb.append("&dma=");
            sb.append(!Objects.equals(zzbaVarZzc.zzh(), false) ? 1 : 0);
            if (!TextUtils.isEmpty(zzbaVarZzc.zzi())) {
                sb.append("&dma_cps=");
                sb.append(zzbaVarZzc.zzi());
            }
            int i3 = !Objects.equals(zzba.zzg(bundle), true) ? 1 : 0;
            sb.append("&npa=");
            sb.append(i3);
            zzhe zzheVar7 = this.zzk;
            zzT(zzheVar7);
            zzheVar7.zzj().zzb("Consent query parameters to Bow", sb);
        }
        zzqf zzqfVar2 = this.zzn;
        zzR(zzqfVar2);
        zzh().zzu.zzi.zzj();
        String str2 = (String) pairZzd.first;
        zzht zzhtVar2 = this.zzj;
        zzR(zzhtVar2);
        URL urlZzH = zzqfVar2.zzH(119002L, strZzm, str2, (-1) + zzhtVar2.zzp.zza(), sb.toString());
        if (urlZzH != null) {
            zzmb zzmbVar2 = this.zzt;
            zzT(zzmbVar2);
            zzly zzlyVar = new zzly() { // from class: com.google.android.gms.measurement.internal.zzim
                @Override // com.google.android.gms.measurement.internal.zzly
                public final void zza(String str3, int i4, Throwable th, byte[] bArr, Map map) {
                    zzio.zzB(this.zza, str3, i4, th, bArr, map);
                }
            };
            zzmbVar2.zzv();
            Preconditions.checkNotNull(urlZzH);
            Preconditions.checkNotNull(zzlyVar);
            zzil zzilVar2 = zzmbVar2.zzu.zzl;
            zzT(zzilVar2);
            zzilVar2.zzp(new zzma(zzmbVar2, strZzm, urlZzH, null, null, zzlyVar));
        }
        return false;
    }

    public final int zza() {
        zzil zzilVar = this.zzl;
        zzT(zzilVar);
        zzilVar.zzg();
        zzam zzamVar = this.zzi;
        if (zzamVar.zzA()) {
            return 1;
        }
        zzT(zzilVar);
        zzilVar.zzg();
        if (!this.zzE) {
            return 8;
        }
        zzht zzhtVar = this.zzj;
        zzR(zzhtVar);
        Boolean boolZzi = zzhtVar.zzi();
        if (boolZzi != null) {
            return boolZzi.booleanValue() ? 0 : 3;
        }
        zzaf zzafVar = zzamVar.zzu.zzh;
        Boolean boolZzn = zzamVar.zzn("firebase_analytics_collection_enabled");
        if (boolZzn != null) {
            return boolZzn.booleanValue() ? 0 : 4;
        }
        return (this.zzD == null || this.zzD.booleanValue()) ? 0 : 7;
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    @Pure
    public final Context zzaT() {
        return this.zzc;
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    @Pure
    public final Clock zzaU() {
        return this.zzp;
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    @Pure
    public final zzaf zzaV() {
        return this.zzh;
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    @Pure
    public final zzhe zzaW() {
        zzhe zzheVar = this.zzk;
        zzT(zzheVar);
        return zzheVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    @Pure
    public final zzil zzaX() {
        zzil zzilVar = this.zzl;
        zzT(zzilVar);
        return zzilVar;
    }

    @Pure
    public final zzd zzd() {
        zzd zzdVar = this.zzs;
        zzQ(zzdVar);
        return zzdVar;
    }

    @Pure
    public final zzam zzf() {
        return this.zzi;
    }

    @Pure
    public final zzbb zzg() {
        zzT(this.zzx);
        return this.zzx;
    }

    @Pure
    public final zzgs zzh() {
        zzS(this.zzy);
        return this.zzy;
    }

    @Pure
    public final zzgv zzi() {
        zzS(this.zzv);
        return this.zzv;
    }

    @Pure
    public final zzgx zzj() {
        return this.zzo;
    }

    public final zzhe zzl() {
        zzhe zzheVar = this.zzk;
        if (zzheVar == null || !zzheVar.zzy()) {
            return null;
        }
        return zzheVar;
    }

    @Pure
    public final zzht zzm() {
        zzht zzhtVar = this.zzj;
        zzR(zzhtVar);
        return zzhtVar;
    }

    @SideEffectFree
    final zzil zzo() {
        return this.zzl;
    }

    @Pure
    public final zzlw zzq() {
        zzlw zzlwVar = this.zzr;
        zzS(zzlwVar);
        return zzlwVar;
    }

    @Pure
    public final zzmb zzr() {
        zzmb zzmbVar = this.zzt;
        zzT(zzmbVar);
        return zzmbVar;
    }

    @Pure
    public final zzmd zzs() {
        zzQ(this.zzz);
        return this.zzz;
    }

    @Pure
    public final zzmo zzt() {
        zzmo zzmoVar = this.zzq;
        zzS(zzmoVar);
        return zzmoVar;
    }

    @Pure
    public final zzny zzu() {
        zzS(this.zzw);
        return this.zzw;
    }

    @Pure
    public final zzop zzv() {
        zzop zzopVar = this.zzm;
        zzS(zzopVar);
        return zzopVar;
    }

    @Pure
    public final zzqf zzw() {
        zzqf zzqfVar = this.zzn;
        zzR(zzqfVar);
        return zzqfVar;
    }

    @Pure
    public final String zzx() {
        if (this.zzi.zzx(null, zzgi.zzbp)) {
            return null;
        }
        return this.zzd;
    }

    @Pure
    public final String zzy() {
        if (this.zzi.zzx(null, zzgi.zzbp)) {
            return null;
        }
        return this.zze;
    }

    @Pure
    public final String zzz() {
        return this.zzf;
    }
}

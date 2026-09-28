package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzlv implements Application.ActivityLifecycleCallbacks, zzlt {
    final /* synthetic */ zzlw zza;

    zzlv(zzlw zzlwVar) {
        this.zza = zzlwVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(com.google.android.gms.internal.measurement.zzdj.zza(activity), bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zzb(com.google.android.gms.internal.measurement.zzdj.zza(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zzc(com.google.android.gms.internal.measurement.zzdj.zza(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zzd(com.google.android.gms.internal.measurement.zzdj.zza(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zze(com.google.android.gms.internal.measurement.zzdj.zza(activity), bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // com.google.android.gms.measurement.internal.zzlt
    public final void zza(com.google.android.gms.internal.measurement.zzdj zzdjVar, Bundle bundle) {
        zzio zzioVar;
        Uri uri;
        try {
            try {
                zzlw zzlwVar = this.zza;
                zzio zzioVar2 = zzlwVar.zzu;
                zzioVar2.zzaW().zzj().zza("onActivityCreated");
                Intent intent = zzdjVar.zzc;
                if (intent != null) {
                    Uri data = intent.getData();
                    if (data == null || !data.isHierarchical()) {
                        Bundle extras = intent.getExtras();
                        uri = null;
                        if (extras != null) {
                            String string = extras.getString("com.android.vending.referral_url");
                            if (!TextUtils.isEmpty(string)) {
                                data = Uri.parse(string);
                                uri = data;
                            }
                        }
                    } else {
                        uri = data;
                    }
                    if (uri != null && uri.isHierarchical()) {
                        zzioVar2.zzw();
                        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
                        zzioVar2.zzaX().zzq(new zzlu(this, bundle == null, uri, ("android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra)) ? "gs" : DebugKt.DEBUG_PROPERTY_VALUE_AUTO, uri.getQueryParameter(Constants.REFERRER)));
                        zzioVar = this.zza.zzu;
                    }
                    zzmo zzmoVarZzt = zzioVar.zzt();
                }
                zzioVar = zzlwVar.zzu;
            } catch (RuntimeException e) {
                this.zza.zzu.zzaW().zze().zzb("Throwable caught in onActivityCreated", e);
            }
            zzmo zzmoVarZzt2 = zzioVar.zzt();
        } finally {
            this.zza.zzu.zzt().zzs(zzdjVar, bundle);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzlt
    public final void zzb(com.google.android.gms.internal.measurement.zzdj zzdjVar) {
        this.zza.zzu.zzt().zzt(zzdjVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzlt
    public final void zzc(com.google.android.gms.internal.measurement.zzdj zzdjVar) {
        zzio zzioVar = this.zza.zzu;
        zzioVar.zzt().zzu(zzdjVar);
        zzop zzopVarZzv = zzioVar.zzv();
        zzio zzioVar2 = zzopVarZzv.zzu;
        zzioVar2.zzaX().zzq(new zzoi(zzopVarZzv, zzioVar2.zzaU().elapsedRealtime()));
    }

    @Override // com.google.android.gms.measurement.internal.zzlt
    public final void zzd(com.google.android.gms.internal.measurement.zzdj zzdjVar) {
        zzio zzioVar = this.zza.zzu;
        zzop zzopVarZzv = zzioVar.zzv();
        zzio zzioVar2 = zzopVarZzv.zzu;
        zzioVar2.zzaX().zzq(new zzoh(zzopVarZzv, zzioVar2.zzaU().elapsedRealtime()));
        zzioVar.zzt().zzv(zzdjVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzlt
    public final void zze(com.google.android.gms.internal.measurement.zzdj zzdjVar, Bundle bundle) {
        this.zza.zzu.zzt().zzw(zzdjVar, bundle);
    }
}

package com.google.android.gms.internal.nearby;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzko implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ zzkp zza;
    private final WeakReference zzb;

    zzko(zzkp zzkpVar, WeakReference weakReference) {
        this.zza = zzkpVar;
        this.zzb = weakReference;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (activity == this.zzb.get()) {
            this.zza.zze = true;
            Log.d("NearbyConnections", "Activity is visible.");
            this.zza.zzg();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        if (activity == this.zzb.get()) {
            this.zza.zze = false;
            Log.d("NearbyConnections", "Activity is hidden.");
            this.zza.zzg();
        }
    }
}

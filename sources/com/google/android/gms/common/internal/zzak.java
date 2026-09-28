package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzak {
    private static final Uri zza = new Uri.Builder().scheme(FirebaseAnalytics.Param.CONTENT).authority("com.google.android.gms.chimera").build();

    static Intent zza(Context context, zzo zzoVar) throws zzai {
        Bundle bundleCall;
        String strZzb = zzoVar.zzb();
        if (strZzb == null) {
            return new Intent().setComponent(zzoVar.zza());
        }
        Intent intent = null;
        if (zzoVar.zzd()) {
            Bundle bundle = new Bundle();
            bundle.putString("serviceActionBundleKey", strZzb);
            try {
                ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(zza);
                if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                    throw new RemoteException("Failed to acquire ContentProviderClient");
                }
                try {
                    bundleCall = contentProviderClientAcquireUnstableContentProviderClient.call("serviceIntentCall", null, bundle);
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                    if (bundleCall != null) {
                        Intent intent2 = (Intent) bundleCall.getParcelable("serviceResponseIntentKey");
                        if (intent2 != null) {
                            intent = intent2;
                        } else {
                            PendingIntent pendingIntent = (PendingIntent) bundleCall.getParcelable("serviceMissingResolutionIntentKey");
                            if (pendingIntent != null) {
                                Log.w("ServiceBindIntentUtils", "Dynamic lookup for intent failed for action " + strZzb + " but has possible resolution");
                                throw new zzai(new ConnectionResult(25, pendingIntent));
                            }
                        }
                    }
                    if (intent == null) {
                        Log.w("ServiceBindIntentUtils", "Dynamic lookup for intent failed for action: ".concat(strZzb));
                    }
                } catch (Throwable th) {
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                    throw th;
                }
            } catch (RemoteException | IllegalArgumentException e) {
                Log.w("ServiceBindIntentUtils", "Dynamic intent resolution failed: ".concat(e.toString()));
                bundleCall = null;
            }
        }
        return intent == null ? new Intent(strZzb).setPackage(zzoVar.zzc()) : intent;
    }
}

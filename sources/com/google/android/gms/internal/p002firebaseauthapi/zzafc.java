package com.google.android.gms.internal.p002firebaseauthapi;

import android.app.Activity;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.util.DefaultClock;
import com.google.firebase.auth.PhoneAuthProvider;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzafc {
    private static final Map<String, zzafe> zza = new ArrayMap();

    public static PhoneAuthProvider.OnVerificationStateChangedCallbacks zza(String str, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, zzaeg zzaegVar) {
        zza(str, zzaegVar);
        return new zzafb(onVerificationStateChangedCallbacks, str);
    }

    public static void zza() {
        zza.clear();
    }

    private static void zza(String str, zzaeg zzaegVar) {
        zza.put(str, new zzafe(zzaegVar, DefaultClock.getInstance().currentTimeMillis()));
    }

    public static boolean zza(String str, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor) {
        Map<String, zzafe> map = zza;
        if (map.containsKey(str)) {
            zzafe zzafeVar = map.get(str);
            if (DefaultClock.getInstance().currentTimeMillis() - zzafeVar.zzb < 120000) {
                if (zzafeVar.zza == null) {
                    return true;
                }
                zzafeVar.zza.zza(onVerificationStateChangedCallbacks, activity, executor, str);
                return true;
            }
            zza(str, null);
            return false;
        }
        zza(str, null);
        return false;
    }
}

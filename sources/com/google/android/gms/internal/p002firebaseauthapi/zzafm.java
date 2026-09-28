package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.collection.ArrayMap;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.google.firebase.FirebaseApp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzafm {
    private static final Map<String, zzafl> zza = new ArrayMap();
    private static final Map<String, List<WeakReference<zzafo>>> zzb = new ArrayMap();

    private static String zza(String str, int i, boolean z) {
        return z ? "http://[" + str + "]:" + i + DomExceptionUtils.SEPARATOR : "http://" + str + ":" + i + DomExceptionUtils.SEPARATOR;
    }

    public static String zza(String str) {
        zzafl zzaflVar;
        Map<String, zzafl> map = zza;
        synchronized (map) {
            zzaflVar = map.get(str);
        }
        if (zzaflVar == null) {
            throw new IllegalStateException("Tried to get the emulator widget endpoint, but no emulator endpoint overrides found.");
        }
        return zza(zzaflVar.zzb(), zzaflVar.zza(), zzaflVar.zzb().contains(":")) + "emulator/auth/handler";
    }

    public static String zzb(String str) {
        zzafl zzaflVar;
        String str2;
        Map<String, zzafl> map = zza;
        synchronized (map) {
            zzaflVar = map.get(str);
        }
        if (zzaflVar != null) {
            str2 = "" + zza(zzaflVar.zzb(), zzaflVar.zza(), zzaflVar.zzb().contains(":"));
        } else {
            str2 = "https://";
        }
        return str2 + "www.googleapis.com/identitytoolkit/v3/relyingparty";
    }

    public static String zzc(String str) {
        zzafl zzaflVar;
        String str2;
        Map<String, zzafl> map = zza;
        synchronized (map) {
            zzaflVar = map.get(str);
        }
        if (zzaflVar != null) {
            str2 = "" + zza(zzaflVar.zzb(), zzaflVar.zza(), zzaflVar.zzb().contains(":"));
        } else {
            str2 = "https://";
        }
        return str2 + "identitytoolkit.googleapis.com/v2";
    }

    public static String zzd(String str) {
        zzafl zzaflVar;
        String str2;
        Map<String, zzafl> map = zza;
        synchronized (map) {
            zzaflVar = map.get(str);
        }
        if (zzaflVar != null) {
            str2 = "" + zza(zzaflVar.zzb(), zzaflVar.zza(), zzaflVar.zzb().contains(":"));
        } else {
            str2 = "https://";
        }
        return str2 + "securetoken.googleapis.com/v1";
    }

    public static void zza(String str, zzafo zzafoVar) {
        Map<String, List<WeakReference<zzafo>>> map = zzb;
        synchronized (map) {
            if (map.containsKey(str)) {
                map.get(str).add(new WeakReference<>(zzafoVar));
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new WeakReference<>(zzafoVar));
                map.put(str, arrayList);
            }
        }
    }

    public static void zza(FirebaseApp firebaseApp, String str, int i) {
        String apiKey = firebaseApp.getOptions().getApiKey();
        Map<String, zzafl> map = zza;
        synchronized (map) {
            map.put(apiKey, new zzafl(str, i));
        }
        Map<String, List<WeakReference<zzafo>>> map2 = zzb;
        synchronized (map2) {
            if (map2.containsKey(apiKey)) {
                Iterator<WeakReference<zzafo>> it = map2.get(apiKey).iterator();
                boolean z = false;
                while (it.hasNext()) {
                    zzafo zzafoVar = it.next().get();
                    if (zzafoVar != null) {
                        zzafoVar.zza();
                        z = true;
                    }
                }
                if (!z) {
                    zza.remove(apiKey);
                }
            }
        }
    }

    public static boolean zza(FirebaseApp firebaseApp) {
        return zza.containsKey(firebaseApp.getOptions().getApiKey());
    }
}

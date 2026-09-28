package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzagt;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.android.recaptcha.RecaptchaTasksClient;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbx {
    FirebaseApp zza;
    zzbs zzb;
    private final Object zzc;
    private final Map<String, Task<RecaptchaTasksClient>> zzd;
    private zzagt zze;
    private FirebaseAuth zzf;

    private final Task<RecaptchaTasksClient> zzc(String str) {
        Task<RecaptchaTasksClient> task;
        synchronized (this.zzc) {
            task = this.zzd.get(str);
        }
        return task;
    }

    public final Task<String> zza(String str, Boolean bool, RecaptchaAction recaptchaAction) {
        String strZzd = zzd(str);
        Task<RecaptchaTasksClient> taskZzc = zzc(strZzd);
        if (bool.booleanValue() || taskZzc == null) {
            taskZzc = zza(strZzd, bool);
        }
        return taskZzc.continueWithTask(new zzbz(this, recaptchaAction));
    }

    public final Task<RecaptchaTasksClient> zza(String str, Boolean bool) {
        Task<RecaptchaTasksClient> taskZzc;
        String strZzd = zzd(str);
        return (bool.booleanValue() || (taskZzc = zzc(strZzd)) == null) ? this.zzf.zza("RECAPTCHA_ENTERPRISE").continueWithTask(new zzbw(this, strZzd)) : taskZzc;
    }

    private static String zzd(String str) {
        return com.google.android.gms.internal.p002firebaseauthapi.zzae.zzc(str) ? "*" : str;
    }

    static /* synthetic */ void zza(zzbx zzbxVar, zzagt zzagtVar, Task task, String str) {
        synchronized (zzbxVar.zzc) {
            zzbxVar.zze = zzagtVar;
            zzbxVar.zzd.put(str, task);
        }
    }

    public zzbx(FirebaseApp firebaseApp, FirebaseAuth firebaseAuth) {
        this(firebaseApp, firebaseAuth, new zzbv());
    }

    private zzbx(FirebaseApp firebaseApp, FirebaseAuth firebaseAuth, zzbs zzbsVar) {
        this.zzc = new Object();
        this.zzd = new HashMap();
        this.zza = firebaseApp;
        this.zzf = firebaseAuth;
        this.zzb = zzbsVar;
    }

    public final boolean zza(String str) {
        String strZzb;
        Preconditions.checkNotNull(str);
        zzagt zzagtVar = this.zze;
        if (zzagtVar == null || (strZzb = zzagtVar.zzb(str)) == null) {
            return false;
        }
        return strZzb.equals("AUDIT");
    }

    public final boolean zzb(String str) {
        boolean z;
        synchronized (this.zzc) {
            zzagt zzagtVar = this.zze;
            z = zzagtVar != null && zzagtVar.zzc(str);
        }
        return z;
    }
}

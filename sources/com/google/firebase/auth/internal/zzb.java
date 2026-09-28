package com.google.firebase.auth.internal;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzadr;
import com.google.android.gms.internal.p002firebaseauthapi.zzafa;
import com.google.android.gms.internal.p002firebaseauthapi.zzafm;
import com.google.android.gms.internal.p002firebaseauthapi.zzags;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.integrity.IntegrityManager;
import com.google.android.play.core.integrity.IntegrityManagerFactory;
import com.google.android.play.core.integrity.IntegrityTokenResponse;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthMissingActivityForRecaptchaException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzb {
    private static final String zza = "zzb";
    private static final zzb zzb = new zzb();
    private String zzc;

    public final Task<zzj> zza(final FirebaseAuth firebaseAuth, final String str, final Activity activity, final boolean z, boolean z2, boolean z3, final RecaptchaAction recaptchaAction) {
        zzac zzacVar = (zzac) firebaseAuth.getFirebaseAuthSettings();
        final zzce zzceVarZzc = zzce.zzc();
        if (zzafm.zza(firebaseAuth.getApp()) || zzacVar.zze()) {
            return Tasks.forResult(new zzm().zza());
        }
        String str2 = zza;
        Log.i(str2, "ForceRecaptchaV2Flow from phoneAuthOptions = " + z2 + ", ForceRecaptchav2Flow from firebaseSettings = " + zzacVar.zzc());
        boolean z4 = z2 || zzacVar.zzc();
        final TaskCompletionSource<zzj> taskCompletionSource = new TaskCompletionSource<>();
        Task<String> taskZzb = zzceVarZzc.zzb();
        if (taskZzb != null) {
            if (taskZzb.isSuccessful()) {
                return Tasks.forResult(new zzm().zzc(taskZzb.getResult()).zza());
            }
            Log.e(str2, "Error in previous reCAPTCHAV2 flow: " + taskZzb.getException().getMessage());
            Log.e(str2, "Continuing with application verification as normal");
        }
        if (z4 || z3) {
            zza(firebaseAuth, str, activity, z, z4, zzceVarZzc, taskCompletionSource);
        } else {
            final boolean z5 = false;
            firebaseAuth.initializeRecaptchaConfig().addOnCompleteListener(new OnCompleteListener() { // from class: com.google.firebase.auth.internal.zza
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    zzb.zza(this.zza, taskCompletionSource, firebaseAuth, recaptchaAction, str, activity, z, z5, zzceVarZzc, task);
                }
            });
        }
        return taskCompletionSource.getTask();
    }

    public static zzb zza() {
        return zzb;
    }

    public static /* synthetic */ void zza(zzb zzbVar, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, RecaptchaAction recaptchaAction, String str, Activity activity, boolean z, boolean z2, zzce zzceVar, Task task) {
        if (!task.isSuccessful()) {
            Log.e(zza, "Failed to initialize reCAPTCHA config: " + task.getException().getMessage());
        }
        if (firebaseAuth.zzb() != null && firebaseAuth.zzb().zzb("PHONE_PROVIDER")) {
            firebaseAuth.zzb().zza(firebaseAuth.getTenantId(), false, recaptchaAction).addOnSuccessListener(new zzf(zzbVar, taskCompletionSource)).addOnFailureListener(new zzc(zzbVar, firebaseAuth, str, activity, z, z2, zzceVar, taskCompletionSource));
        } else {
            zzbVar.zza(firebaseAuth, str, activity, z, z2, zzceVar, (TaskCompletionSource<zzj>) taskCompletionSource);
        }
    }

    public static /* synthetic */ void zza(zzb zzbVar, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, zzce zzceVar, Activity activity, Task task) {
        if (task.isSuccessful() && task.getResult() != null && !TextUtils.isEmpty(((IntegrityTokenResponse) task.getResult()).token())) {
            taskCompletionSource.setResult(new zzm().zza(((IntegrityTokenResponse) task.getResult()).token()).zza());
        } else {
            Log.e(zza, "Play Integrity Token fetch failed, falling back to Recaptcha" + (task.getException() == null ? "" : task.getException().getMessage()));
            zzbVar.zza(firebaseAuth, zzceVar, activity, taskCompletionSource);
        }
    }

    private zzb() {
    }

    private final void zza(FirebaseAuth firebaseAuth, zzce zzceVar, Activity activity, TaskCompletionSource<zzj> taskCompletionSource) {
        Task<String> task;
        if (activity == null) {
            taskCompletionSource.setException(new FirebaseAuthMissingActivityForRecaptchaException());
            return;
        }
        zzbl.zza(firebaseAuth.getApp().getApplicationContext(), firebaseAuth);
        Preconditions.checkNotNull(activity);
        TaskCompletionSource<String> taskCompletionSource2 = new TaskCompletionSource<>();
        if (!zzax.zza().zza(activity, taskCompletionSource2)) {
            task = Tasks.forException(zzadr.zza(new Status(17057, "reCAPTCHA flow already in progress")));
        } else {
            new zzafa(firebaseAuth, activity).zza();
            task = taskCompletionSource2.getTask();
        }
        task.addOnSuccessListener(new zzg(this, taskCompletionSource)).addOnFailureListener(new zzh(this, taskCompletionSource));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(final FirebaseAuth firebaseAuth, String str, final Activity activity, boolean z, boolean z2, final zzce zzceVar, final TaskCompletionSource<zzj> taskCompletionSource) {
        Task<zzags> taskZza;
        if (z && !z2) {
            IntegrityManager integrityManagerCreate = IntegrityManagerFactory.create(firebaseAuth.getApp().getApplicationContext());
            if (!TextUtils.isEmpty(this.zzc)) {
                taskZza = Tasks.forResult(new zzags(this.zzc));
            } else {
                taskZza = firebaseAuth.zza();
            }
            taskZza.continueWithTask(firebaseAuth.zzf(), new zze(this, str, integrityManagerCreate)).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.firebase.auth.internal.zzd
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    zzb.zza(this.zza, taskCompletionSource, firebaseAuth, zzceVar, activity, task);
                }
            });
            return;
        }
        zza(firebaseAuth, zzceVar, activity, taskCompletionSource);
    }

    public static boolean zza(Exception exc) {
        if (exc instanceof FirebaseAuthMissingActivityForRecaptchaException) {
            return true;
        }
        return (exc instanceof FirebaseAuthException) && ((FirebaseAuthException) exc).getErrorCode().endsWith("UNAUTHORIZED_DOMAIN");
    }
}

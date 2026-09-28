package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.p002firebaseauthapi.zzadr;
import com.google.android.gms.internal.p002firebaseauthapi.zzaic;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbl {
    private static long zza = 3600000;
    private static final com.google.android.gms.internal.p002firebaseauthapi.zzaj<String> zzb = com.google.android.gms.internal.p002firebaseauthapi.zzaj.zza("firebaseAppName", "firebaseUserUid", "operation", "tenantId", "verifyAssertionRequest", "statusCode", "statusMessage", "timestamp");
    private static final zzbl zzc = new zzbl();
    private Task<AuthResult> zzd;
    private Task<String> zze;
    private long zzf = 0;

    public final Task<AuthResult> zza() {
        if (DefaultClock.getInstance().currentTimeMillis() - this.zzf < zza) {
            return this.zzd;
        }
        return null;
    }

    public final Task<String> zzb() {
        if (DefaultClock.getInstance().currentTimeMillis() - this.zzf < zza) {
            return this.zze;
        }
        return null;
    }

    public static zzbl zzc() {
        return zzc;
    }

    private zzbl() {
    }

    private static void zza(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        com.google.android.gms.internal.p002firebaseauthapi.zzaj<String> zzajVar = zzb;
        int size = zzajVar.size();
        int i = 0;
        while (i < size) {
            String str = zzajVar.get(i);
            i++;
            editorEdit.remove(str);
        }
        editorEdit.commit();
    }

    public final void zza(Context context) {
        Preconditions.checkNotNull(context);
        zza(context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0));
        this.zzd = null;
        this.zzf = 0L;
    }

    public final void zza(FirebaseAuth firebaseAuth) {
        Preconditions.checkNotNull(firebaseAuth);
        byte b = 0;
        SharedPreferences sharedPreferences = firebaseAuth.getApp().getApplicationContext().getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0);
        if (firebaseAuth.getApp().getName().equals(sharedPreferences.getString("firebaseAppName", ""))) {
            if (sharedPreferences.contains("verifyAssertionRequest")) {
                zzaic zzaicVar = (zzaic) SafeParcelableSerializer.deserializeFromString(sharedPreferences.getString("verifyAssertionRequest", ""), zzaic.CREATOR);
                String string = sharedPreferences.getString("operation", "");
                String string2 = sharedPreferences.getString("tenantId", null);
                String string3 = sharedPreferences.getString("firebaseUserUid", "");
                this.zzf = sharedPreferences.getLong("timestamp", 0L);
                if (string2 != null) {
                    firebaseAuth.setTenantId(string2);
                    zzaicVar.zzb(string2);
                }
                string.hashCode();
                switch (string.hashCode()) {
                    case -98509410:
                        if (!string.equals("com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE")) {
                            b = -1;
                        }
                        break;
                    case 175006864:
                        b = !string.equals("com.google.firebase.auth.internal.NONGMSCORE_LINK") ? (byte) -1 : (byte) 1;
                        break;
                    case 1450464913:
                        b = !string.equals("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN") ? (byte) -1 : (byte) 2;
                        break;
                    default:
                        b = -1;
                        break;
                }
                switch (b) {
                    case 0:
                        if (firebaseAuth.getCurrentUser().getUid().equals(string3)) {
                            this.zzd = firebaseAuth.zzc(firebaseAuth.getCurrentUser(), com.google.firebase.auth.zzc.zza(zzaicVar));
                        } else {
                            this.zzd = null;
                        }
                        break;
                    case 1:
                        if (firebaseAuth.getCurrentUser().getUid().equals(string3)) {
                            this.zzd = firebaseAuth.zza(firebaseAuth.getCurrentUser(), com.google.firebase.auth.zzc.zza(zzaicVar));
                        } else {
                            this.zzd = null;
                        }
                        break;
                    case 2:
                        this.zzd = firebaseAuth.signInWithCredential(com.google.firebase.auth.zzc.zza(zzaicVar));
                        break;
                    default:
                        this.zzd = null;
                        break;
                }
                zza(sharedPreferences);
                return;
            }
            if (sharedPreferences.contains("recaptchaToken")) {
                String string4 = sharedPreferences.getString("recaptchaToken", "");
                String string5 = sharedPreferences.getString("operation", "");
                this.zzf = sharedPreferences.getLong("timestamp", 0L);
                string5.hashCode();
                if (string5.equals("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA")) {
                    this.zze = Tasks.forResult(string4);
                } else {
                    this.zze = null;
                }
                zza(sharedPreferences);
                return;
            }
            if (sharedPreferences.contains("statusCode")) {
                Status status = new Status(sharedPreferences.getInt("statusCode", 17062), sharedPreferences.getString("statusMessage", ""));
                this.zzf = sharedPreferences.getLong("timestamp", 0L);
                zza(sharedPreferences);
                this.zzd = Tasks.forException(zzadr.zza(status));
            }
        }
    }

    public static void zza(Context context, Status status) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putInt("statusCode", status.getStatusCode());
        editorEdit.putString("statusMessage", status.getStatusMessage());
        editorEdit.putLong("timestamp", DefaultClock.getInstance().currentTimeMillis());
        editorEdit.commit();
    }

    public static void zza(Context context, FirebaseAuth firebaseAuth) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(firebaseAuth);
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putString("firebaseAppName", firebaseAuth.getApp().getName());
        editorEdit.commit();
    }

    public static void zza(Context context, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(firebaseAuth);
        Preconditions.checkNotNull(firebaseUser);
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putString("firebaseAppName", firebaseAuth.getApp().getName());
        editorEdit.putString("firebaseUserUid", firebaseUser.getUid());
        editorEdit.commit();
    }

    public static void zza(Context context, zzaic zzaicVar, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putString("verifyAssertionRequest", SafeParcelableSerializer.serializeToString(zzaicVar));
        editorEdit.putString("operation", str);
        editorEdit.putString("tenantId", str2);
        editorEdit.putLong("timestamp", DefaultClock.getInstance().currentTimeMillis());
        editorEdit.commit();
    }

    public static void zza(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putString("recaptchaToken", str);
        editorEdit.putString("operation", str2);
        editorEdit.putLong("timestamp", DefaultClock.getInstance().currentTimeMillis());
        editorEdit.commit();
    }
}

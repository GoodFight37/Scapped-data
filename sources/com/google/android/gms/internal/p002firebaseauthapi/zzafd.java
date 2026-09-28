package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Base64;
import androidx.core.content.ContextCompat;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.firebase.auth.PhoneAuthCredential;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzafd {
    private static final Logger zza = new Logger("FirebaseAuth", "SmsRetrieverHelper");
    private final Context zzb;
    private final ScheduledExecutorService zzc;
    private final HashMap<String, zzafk> zzd = new HashMap<>();

    final zzadp zza(zzadp zzadpVar, String str) {
        return new zzafi(this, zzadpVar, str);
    }

    static String zza(String str) {
        Matcher matcher = Pattern.compile("(?<!\\d)\\d{6}(?!\\d)").matcher(str);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    final String zzb() {
        Signature[] apkContentsSigners;
        try {
            String packageName = this.zzb.getPackageName();
            if (Build.VERSION.SDK_INT < 28) {
                apkContentsSigners = Wrappers.packageManager(this.zzb).getPackageInfo(packageName, 64).signatures;
            } else {
                apkContentsSigners = Wrappers.packageManager(this.zzb).getPackageInfo(packageName, 134217728).signingInfo.getApkContentsSigners();
            }
            String strZza = zza(packageName, apkContentsSigners[0].toCharsString());
            if (strZza != null) {
                return strZza;
            }
            zza.e("Hash generation failed.", new Object[0]);
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            zza.e("Unable to find package to obtain hash.", new Object[0]);
            return null;
        }
    }

    private static String zza(String str, String str2) {
        String str3 = str + " " + str2;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str3.getBytes(StandardCharsets.UTF_8));
            String strSubstring = Base64.encodeToString(Arrays.copyOf(messageDigest.digest(), 9), 3).substring(0, 11);
            zza.d("Package: " + str + " -- Hash: " + strSubstring, new Object[0]);
            return strSubstring;
        } catch (NoSuchAlgorithmException e) {
            zza.e("NoSuchAlgorithm: " + e.getMessage(), new Object[0]);
            return null;
        }
    }

    static /* synthetic */ void zzb(zzafd zzafdVar, String str) {
        zzafk zzafkVar = zzafdVar.zzd.get(str);
        if (zzafkVar == null || zzae.zzc(zzafkVar.zzd) || zzae.zzc(zzafkVar.zze) || zzafkVar.zzb.isEmpty()) {
            return;
        }
        Iterator<zzadp> it = zzafkVar.zzb.iterator();
        while (it.hasNext()) {
            it.next().zza(PhoneAuthCredential.zza(zzafkVar.zzd, zzafkVar.zze));
        }
        zzafkVar.zzh = true;
    }

    zzafd(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zzb = context;
        this.zzc = scheduledExecutorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzd(String str) {
        zzafk zzafkVar = this.zzd.get(str);
        if (zzafkVar == null || zzafkVar.zzh || zzae.zzc(zzafkVar.zzd)) {
            return;
        }
        zza.w("Timed out waiting for SMS.", new Object[0]);
        Iterator<zzadp> it = zzafkVar.zzb.iterator();
        while (it.hasNext()) {
            it.next().zza(zzafkVar.zzd);
        }
        zzafkVar.zzi = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zze(String str) {
        zzafk zzafkVar = this.zzd.get(str);
        if (zzafkVar == null) {
            return;
        }
        if (!zzafkVar.zzi) {
            zzd(str);
        }
        zzb(str);
    }

    final void zzb(zzadp zzadpVar, String str) {
        zzafk zzafkVar = this.zzd.get(str);
        if (zzafkVar == null) {
            return;
        }
        zzafkVar.zzb.add(zzadpVar);
        if (zzafkVar.zzg) {
            zzadpVar.zzb(zzafkVar.zzd);
        }
        if (zzafkVar.zzh) {
            zzadpVar.zza(PhoneAuthCredential.zza(zzafkVar.zzd, zzafkVar.zze));
        }
        if (zzafkVar.zzi) {
            zzadpVar.zza(zzafkVar.zzd);
        }
    }

    final void zzb(String str) {
        zzafk zzafkVar = this.zzd.get(str);
        if (zzafkVar == null) {
            return;
        }
        if (zzafkVar.zzf != null && !zzafkVar.zzf.isDone()) {
            zzafkVar.zzf.cancel(false);
        }
        zzafkVar.zzb.clear();
        this.zzd.remove(str);
    }

    final void zza(final String str, zzadp zzadpVar, long j, boolean z) {
        this.zzd.put(str, new zzafk(j, z));
        zzb(zzadpVar, str);
        zzafk zzafkVar = this.zzd.get(str);
        if (zzafkVar.zza <= 0) {
            zza.w("Timeout of 0 specified; SmsRetriever will not start.", new Object[0]);
            return;
        }
        zzafkVar.zzf = this.zzc.schedule(new Runnable() { // from class: com.google.android.gms.internal.firebase-auth-api.zzafg
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zze(str);
            }
        }, zzafkVar.zza, TimeUnit.SECONDS);
        if (!zzafkVar.zzc) {
            zza.w("SMS auto-retrieval unavailable; SmsRetriever will not start.", new Object[0]);
            return;
        }
        zzafh zzafhVar = new zzafh(this, str);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SmsRetriever.SMS_RETRIEVED_ACTION);
        ContextCompat.registerReceiver(this.zzb.getApplicationContext(), zzafhVar, intentFilter, 2);
        SmsRetriever.getClient(this.zzb).startSmsRetriever().addOnFailureListener(new zzaff(this));
    }

    final boolean zzc(String str) {
        return this.zzd.get(str) != null;
    }
}

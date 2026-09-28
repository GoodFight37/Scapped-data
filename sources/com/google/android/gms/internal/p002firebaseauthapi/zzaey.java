package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaey {
    private final String zza;
    private final String zzb;

    public final String zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }

    public zzaey(Context context) {
        this(context, context.getPackageName());
    }

    private zzaey(Context context, String str) {
        Preconditions.checkNotNull(context);
        String strCheckNotEmpty = Preconditions.checkNotEmpty(str);
        this.zza = strCheckNotEmpty;
        try {
            byte[] packageCertificateHashBytes = AndroidUtilsLight.getPackageCertificateHashBytes(context, strCheckNotEmpty);
            if (packageCertificateHashBytes == null) {
                Log.e("FBA-PackageInfo", "single cert required: " + str);
                this.zzb = null;
            } else {
                this.zzb = Hex.bytesToStringUppercase(packageCertificateHashBytes, false);
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("FBA-PackageInfo", "no pkg: " + str);
            this.zzb = null;
        }
    }
}

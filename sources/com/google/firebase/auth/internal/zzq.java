package com.google.firebase.auth.internal;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.adjust.sdk.Constants;
import com.google.android.gms.internal.p002firebaseauthapi.zzke;
import com.google.android.gms.internal.p002firebaseauthapi.zzkh;
import com.google.android.gms.internal.p002firebaseauthapi.zzkq;
import com.google.android.gms.internal.p002firebaseauthapi.zzmi;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzq {
    private static zzq zza;
    private final String zzb;
    private final zzmi zzc;

    public static zzq zza(Context context, String str) {
        zzq zzqVar = zza;
        if (zzqVar == null || !com.google.android.gms.internal.p002firebaseauthapi.zzp.zza(zzqVar.zzb, str)) {
            zza = new zzq(context, str, true);
        }
        return zza;
    }

    public final String zza(String str) {
        String str2;
        zzmi zzmiVar = this.zzc;
        if (zzmiVar == null) {
            Log.e("FirebearCryptoHelper", "KeysetManager failed to initialize - unable to decrypt payload");
            return null;
        }
        try {
            synchronized (zzmiVar) {
                str2 = new String(((com.google.android.gms.internal.p002firebaseauthapi.zzbj) this.zzc.zza().zza(zzkh.zza(), com.google.android.gms.internal.p002firebaseauthapi.zzbj.class)).zza(Base64.decode(str, 8), null), Constants.ENCODING);
            }
            return str2;
        } catch (UnsupportedEncodingException | GeneralSecurityException e) {
            Log.e("FirebearCryptoHelper", "Exception encountered while decrypting bytes:\n" + e.getMessage());
            return null;
        }
    }

    public final String zza() {
        if (this.zzc == null) {
            Log.e("FirebearCryptoHelper", "KeysetManager failed to initialize - unable to get Public key");
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        com.google.android.gms.internal.p002firebaseauthapi.zzbz zzbzVarZza = com.google.android.gms.internal.p002firebaseauthapi.zzbg.zza(byteArrayOutputStream);
        try {
            synchronized (this.zzc) {
                this.zzc.zza().zza().zza(zzbzVarZza);
            }
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 8);
        } catch (IOException | GeneralSecurityException e) {
            Log.e("FirebearCryptoHelper", "Exception encountered when attempting to get Public Key:\n" + e.getMessage());
            return null;
        }
    }

    private zzq(Context context, String str, boolean z) {
        zzmi zzmiVarZza;
        this.zzb = str;
        try {
            zzke.zza();
            zzmi.zza zzaVarZza = new zzmi.zza().zza(context, "GenericIdpKeyset", String.format("com.google.firebase.auth.api.crypto.%s", str)).zza(zzkq.zza);
            zzaVarZza.zza(String.format("android-keystore://firebear_master_key_id.%s", str));
            zzmiVarZza = zzaVarZza.zza();
        } catch (IOException | GeneralSecurityException e) {
            Log.e("FirebearCryptoHelper", "Exception encountered during crypto setup:\n" + e.getMessage());
            zzmiVarZza = null;
        }
        this.zzc = zzmiVarZza;
    }
}

package com.google.android.gms.internal.p002firebaseauthapi;

import android.security.keystore.KeyGenParameterSpec;
import com.google.android.gms.stats.CodePackage;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.KeyGenerator;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzmn implements zzcc {
    private static final Object zza = new Object();

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
    public static final class zza {
        public zza() {
            zzmn.zza();
        }
    }

    static /* synthetic */ boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcc
    public final zzbe zza(String str) throws GeneralSecurityException {
        zzml zzmlVar;
        try {
            synchronized (zza) {
                zzmlVar = new zzml(zzzi.zza("android-keystore://", str));
                byte[] bArrZza = zzpp.zza(10);
                byte[] bArr = new byte[0];
                if (!Arrays.equals(bArrZza, zzmlVar.zza(zzmlVar.zzb(bArrZza, bArr), bArr))) {
                    throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
                }
            }
            return zzmlVar;
        } catch (IOException e) {
            throw new GeneralSecurityException(e);
        }
    }

    public zzmn() throws GeneralSecurityException {
        this(new zza());
    }

    private zzmn(zza zzaVar) {
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcc
    public final boolean zzb(String str) {
        return str.toLowerCase(Locale.US).startsWith("android-keystore://");
    }

    static boolean zzc(String str) throws GeneralSecurityException {
        synchronized (zza) {
            String strZza = zzzi.zza("android-keystore://", str);
            if (zzmj.zzb(strZza)) {
                return false;
            }
            KeyGenParameterSpec keyGenParameterSpecBuild = new KeyGenParameterSpec.Builder(strZza, 3).setKeySize(256).setBlockModes(CodePackage.GCM).setEncryptionPaddings("NoPadding").build();
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            keyGenerator.init(keyGenParameterSpecBuild);
            keyGenerator.generateKey();
            return true;
        }
    }
}

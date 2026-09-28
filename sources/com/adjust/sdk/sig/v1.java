package com.adjust.sdk.sig;

import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public final class v1 implements e1 {
    public final void a(Context context) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        keyStore.deleteEntry("key2");
        context.getSharedPreferences("adjust_keys", 0).edit().remove("encrypted_key").apply();
    }

    public final void b(Context context) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException, NoSuchProviderException, InvalidAlgorithmParameterException {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        if (keyStore.containsAlias("key2")) {
            return;
        }
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256", "AndroidKeyStore");
        keyGenerator.init(new KeyGenParameterSpec.Builder("key2", 4).build());
        keyGenerator.generateKey();
    }

    public final byte[] a(Context context, byte[] bArr) throws NoSuchAlgorithmException, IOException, InvalidKeyException, KeyStoreException, CertificateException {
        Mac mac = Mac.getInstance("HmacSHA256");
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        mac.init(keyStore.getKey("key2", null));
        mac.update(bArr);
        return mac.doFinal();
    }
}

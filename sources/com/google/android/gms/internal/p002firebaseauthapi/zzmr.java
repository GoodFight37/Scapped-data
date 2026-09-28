package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.security.ProviderInstaller;
import java.lang.reflect.InvocationTargetException;
import java.security.Provider;
import java.security.Security;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzmr {
    private static final String[] zza = {ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL", "Conscrypt"};

    @Nullable
    public static Provider zza() {
        for (String str : zza) {
            Provider provider = Security.getProvider(str);
            if (provider != null) {
                return provider;
            }
        }
        return null;
    }

    @Nullable
    public static Provider zzb() {
        try {
            return (Provider) Class.forName("org.conscrypt.Conscrypt").getMethod("newProvider", new Class[0]).invoke(null, new Object[0]);
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }
}

package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzys;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzym<T_WRAPPER extends zzys<JcePrimitiveT>, JcePrimitiveT> {
    public static final zzym<zzyv, Cipher> zza = new zzym<>(new zzyv());
    public static final zzym<zzyz, Mac> zzb = new zzym<>(new zzyz());
    public static final zzym<zzyu, KeyAgreement> zzc;
    public static final zzym<zzyw, KeyPairGenerator> zzd;
    public static final zzym<zzyx, KeyFactory> zze;
    private final zzyq<JcePrimitiveT> zzf;

    public final JcePrimitiveT zza(String str) throws GeneralSecurityException {
        return this.zzf.zza(str);
    }

    public static List<Provider> zza(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Provider provider = Security.getProvider(str);
            if (provider != null) {
                arrayList.add(provider);
            }
        }
        return arrayList;
    }

    static {
        new zzym(new zzzb());
        new zzym(new zzyy());
        zzc = new zzym<>(new zzyu());
        zzd = new zzym<>(new zzyw());
        zze = new zzym<>(new zzyx());
    }

    private zzym(T_WRAPPER t_wrapper) {
        if (zzij.zzb()) {
            this.zzf = new zzyr(t_wrapper);
        } else if (zzzj.zza()) {
            this.zzf = new zzyp(t_wrapper);
        } else {
            this.zzf = new zzyo(t_wrapper);
        }
    }
}

package com.google.android.gms.internal.nearby;

import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzsf {
    private static final Logger zza = Logger.getLogger(zzsf.class.getName());
    private static final zzse zzb = new zzse(null);

    private zzsf() {
    }

    static boolean zza(@CheckForNull String str) {
        return str == null || str.isEmpty();
    }
}

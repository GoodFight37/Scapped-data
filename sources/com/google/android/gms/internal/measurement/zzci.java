package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzci {
    private static final ThreadLocal zza = new zzch();

    public static SharedPreferences zza(Context context, String str, int i, zzcc zzccVar) {
        zzbx.zza();
        zzcg zzcgVar = str.equals("") ? new zzcg() : null;
        if (zzcgVar != null) {
            return zzcgVar;
        }
        ThreadLocal threadLocal = zza;
        Preconditions.checkArgument(((Boolean) threadLocal.get()).booleanValue());
        threadLocal.set(Boolean.FALSE);
        try {
            return context.getSharedPreferences(str, 0);
        } finally {
            zza.set(Boolean.TRUE);
        }
    }
}

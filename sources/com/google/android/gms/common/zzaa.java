package com.google.android.gms.common;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzaa {
    private final String zza;
    private final boolean zzb;
    private final boolean zzc;

    /* synthetic */ zzaa(String str, boolean z, boolean z2, boolean z3, boolean z4, zzr zzrVar, zzz zzzVar) {
        this.zza = str;
        this.zzb = z;
        this.zzc = z4;
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [android.os.IBinder, com.google.android.gms.dynamic.IObjectWrapper] */
    final zzs zza(Context context) {
        return new zzs(this.zza, this.zzb, false, ObjectWrapper.wrap(context), false, true, null);
    }

    final boolean zzb() {
        return this.zzc;
    }
}

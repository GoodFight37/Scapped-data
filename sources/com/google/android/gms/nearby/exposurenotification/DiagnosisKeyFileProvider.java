package com.google.android.gms.nearby.exposurenotification;

import com.google.android.gms.internal.nearby.zzsq;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public class DiagnosisKeyFileProvider {
    private int zza = 0;
    private final List zzb;

    public DiagnosisKeyFileProvider(List<File> list) {
        this.zzb = zzsq.zzk(list);
    }

    public final File zza() {
        int i = this.zza;
        this.zza = i + 1;
        return (File) this.zzb.get(i);
    }

    public final boolean zzb() {
        return this.zzb.size() > this.zza;
    }
}

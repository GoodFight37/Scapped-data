package com.google.android.gms.internal.nearby;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeyFileProvider;
import java.io.FileNotFoundException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzat extends zzcu {
    final /* synthetic */ DiagnosisKeyFileProvider zza;

    zzat(zzax zzaxVar, DiagnosisKeyFileProvider diagnosisKeyFileProvider) {
        this.zza = diagnosisKeyFileProvider;
    }

    @Override // com.google.android.gms.internal.nearby.zzcv
    public final ParcelFileDescriptor zzb() {
        try {
            return ParcelFileDescriptor.open(this.zza.zza(), 268435456);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzcv
    public final boolean zzc() {
        return this.zza.zzb();
    }
}

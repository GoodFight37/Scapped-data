package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzgv extends zzki {
    private final BaseImplementation.ResultHolder zza;

    zzgv(BaseImplementation.ResultHolder resultHolder) {
        this.zza = (BaseImplementation.ResultHolder) Preconditions.checkNotNull(resultHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzkj
    public final void zzb(int i) {
        Status statusZzG = zzgy.zzG(i);
        if (statusZzG.isSuccess()) {
            this.zza.setResult(statusZzG);
        } else {
            this.zza.setFailedResult(statusZzG);
        }
    }
}

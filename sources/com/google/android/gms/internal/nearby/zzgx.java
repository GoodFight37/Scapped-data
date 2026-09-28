package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzgx extends zzkl {
    private final BaseImplementation.ResultHolder zza;

    zzgx(BaseImplementation.ResultHolder resultHolder) {
        this.zza = (BaseImplementation.ResultHolder) Preconditions.checkNotNull(resultHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzkm
    public final void zzb(zzlm zzlmVar) {
        Status statusZzG = zzgy.zzG(zzlmVar.zza());
        if (statusZzG.isSuccess()) {
            this.zza.setResult(new zzgw(statusZzG, zzlmVar.zzb()));
        } else {
            this.zza.setFailedResult(statusZzG);
        }
    }
}

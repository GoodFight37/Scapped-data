package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.ActionCodeMultiFactorInfo;
import com.google.firebase.auth.MultiFactorInfo;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzv extends ActionCodeMultiFactorInfo {
    private final MultiFactorInfo zza;

    @Override // com.google.firebase.auth.ActionCodeMultiFactorInfo
    public final MultiFactorInfo getMultiFactorInfo() {
        return this.zza;
    }

    public zzv(String str, MultiFactorInfo multiFactorInfo) {
        this.email = Preconditions.checkNotEmpty(str);
        this.zza = (MultiFactorInfo) Preconditions.checkNotNull(multiFactorInfo);
    }
}

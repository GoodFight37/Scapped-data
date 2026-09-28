package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.ActionCodeEmailInfo;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzt extends ActionCodeEmailInfo {
    private final String zza;

    @Override // com.google.firebase.auth.ActionCodeEmailInfo
    public final String getPreviousEmail() {
        return this.zza;
    }

    public zzt(String str, String str2) {
        this.email = Preconditions.checkNotEmpty(str);
        this.zza = Preconditions.checkNotEmpty(str2);
    }
}

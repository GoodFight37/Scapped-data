package com.google.firebase.auth.internal;

import com.google.firebase.auth.SignInMethodQueryResult;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzar implements SignInMethodQueryResult {
    private final List<String> zza;

    @Override // com.google.firebase.auth.SignInMethodQueryResult
    public final List<String> getSignInMethods() {
        return this.zza;
    }

    public zzar(List<String> list) {
        this.zza = list;
    }
}

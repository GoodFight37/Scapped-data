package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.ActionCodeInfo;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzs extends ActionCodeInfo {
    public zzs(String str) {
        this.email = Preconditions.checkNotEmpty(str);
    }
}

package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzu implements zzs {
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzs
    public final zzl zza(String str) {
        return new zzn(Pattern.compile(str));
    }

    private zzu() {
    }
}

package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.Serializable;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzn extends zzl implements Serializable {
    private final Pattern zza;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzl
    public final zzm zza(CharSequence charSequence) {
        return new zzq(this.zza.matcher(charSequence));
    }

    public final String toString() {
        return this.zza.toString();
    }

    zzn(Pattern pattern) {
        this.zza = (Pattern) zzw.zza(pattern);
    }
}

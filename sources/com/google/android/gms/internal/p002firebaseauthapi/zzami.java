package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzami extends zzamn {
    private final /* synthetic */ zzamh zza;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamn, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzamj(this.zza);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzami(zzamh zzamhVar) {
        super(zzamhVar);
        this.zza = zzamhVar;
    }
}

package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzal<E> extends zzad<E> {
    private final zzaj<E> zza;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzad
    protected final E zza(int i) {
        return this.zza.get(i);
    }

    zzal(zzaj<E> zzajVar, int i) {
        super(zzajVar.size(), i);
        this.zza = zzajVar;
    }
}

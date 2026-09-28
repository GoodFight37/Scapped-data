package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzaiz extends zzajb {
    private int zza = 0;
    private final int zzb;
    private final /* synthetic */ zzaiw zzc;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajc
    public final byte zza() {
        int i = this.zza;
        if (i >= this.zzb) {
            throw new NoSuchElementException();
        }
        this.zza = i + 1;
        return this.zzc.zzb(i);
    }

    zzaiz(zzaiw zzaiwVar) {
        this.zzc = zzaiwVar;
        this.zzb = zzaiwVar.zzb();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza < this.zzb;
    }
}

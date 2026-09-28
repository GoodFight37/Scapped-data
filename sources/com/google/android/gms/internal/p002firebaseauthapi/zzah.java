package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public class zzah<E> extends zzak<E> {
    Object[] zza;
    int zzb;
    boolean zzc;

    public zzah<E> zza(E e) {
        zzw.zza(e);
        Object[] objArr = this.zza;
        int iZza = zza(objArr.length, this.zzb + 1);
        if (iZza > objArr.length || this.zzc) {
            this.zza = Arrays.copyOf(this.zza, iZza);
            this.zzc = false;
        }
        Object[] objArr2 = this.zza;
        int i = this.zzb;
        this.zzb = i + 1;
        objArr2[i] = e;
        return this;
    }

    zzah(int i) {
        zzag.zza(4, "initialCapacity");
        this.zza = new Object[4];
        this.zzb = 0;
    }
}

package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzx extends zzac {
    private final /* synthetic */ zzf zzb;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzac
    final int zza(int i) {
        return i + 1;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzac
    final int zzb(int i) {
        return this.zzb.zza(this.zza, i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzx(zzy zzyVar, zzv zzvVar, CharSequence charSequence, zzf zzfVar) {
        super(zzvVar, charSequence);
        this.zzb = zzfVar;
    }
}

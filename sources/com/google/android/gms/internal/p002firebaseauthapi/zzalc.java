package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzalc implements zzalk {
    private zzalk[] zza;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalk
    public final zzall zza(Class<?> cls) {
        for (zzalk zzalkVar : this.zza) {
            if (zzalkVar.zzb(cls)) {
                return zzalkVar.zza(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
    }

    zzalc(zzalk... zzalkVarArr) {
        this.zza = zzalkVarArr;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalk
    public final boolean zzb(Class<?> cls) {
        for (zzalk zzalkVar : this.zza) {
            if (zzalkVar.zzb(cls)) {
                return true;
            }
        }
        return false;
    }
}

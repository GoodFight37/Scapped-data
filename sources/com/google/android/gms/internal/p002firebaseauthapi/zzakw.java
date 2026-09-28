package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzakw implements zzakx {
    private static <E> zzakn<E> zzc(Object obj, long j) {
        return (zzakn) zzana.zze(obj, j);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakx
    public final <L> List<L> zza(Object obj, long j) {
        zzakn zzaknVarZzc = zzc(obj, j);
        if (zzaknVarZzc.zzc()) {
            return zzaknVarZzc;
        }
        int size = zzaknVarZzc.size();
        zzakn zzaknVarZza = zzaknVarZzc.zza(size == 0 ? 10 : size << 1);
        zzana.zza(obj, j, zzaknVarZza);
        return zzaknVarZza;
    }

    zzakw() {
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakx
    public final void zzb(Object obj, long j) {
        zzc(obj, j).zzb();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzakx
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzakn zzaknVarZzc = zzc(obj, j);
        zzakn zzaknVarZzc2 = zzc(obj2, j);
        int size = zzaknVarZzc.size();
        int size2 = zzaknVarZzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzaknVarZzc.zzc()) {
                zzaknVarZzc = zzaknVarZzc.zza(size2 + size);
            }
            zzaknVarZzc.addAll(zzaknVarZzc2);
        }
        if (size > 0) {
            zzaknVarZzc2 = zzaknVarZzc;
        }
        zzana.zza(obj, j, zzaknVarZzc2);
    }
}

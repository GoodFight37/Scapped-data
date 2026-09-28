package com.google.android.gms.internal.games_v2;

import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzac {
    private final AtomicReference zza = new AtomicReference();

    protected abstract zzab zza();

    public final void zzb() {
        zzab zzabVar = (zzab) this.zza.get();
        if (zzabVar != null) {
            zzabVar.zzc();
        }
    }

    public final void zzc(String str, int i) {
        AtomicReference atomicReference = this.zza;
        zzab zzabVarZza = (zzab) atomicReference.get();
        if (zzabVarZza == null) {
            zzabVarZza = zza();
            if (!ByteQuadsCanonicalizer$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, zzabVarZza)) {
                zzabVarZza = (zzab) atomicReference.get();
            }
        }
        zzabVarZza.zzb(str, i);
    }
}

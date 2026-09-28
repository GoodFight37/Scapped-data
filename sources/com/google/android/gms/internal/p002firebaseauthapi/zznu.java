package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zznu {
    private final zznr zza;
    private final List<zznw> zzb;

    @Nullable
    private final Integer zzc;

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb);
    }

    public final String toString() {
        return String.format("(annotations=%s, entries=%s, primaryKeyId=%s)", this.zza, this.zzb, this.zzc);
    }

    private zznu(zznr zznrVar, List<zznw> list, Integer num) {
        this.zza = zznrVar;
        this.zzb = list;
        this.zzc = num;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zznu)) {
            return false;
        }
        zznu zznuVar = (zznu) obj;
        return this.zza.equals(zznuVar.zza) && this.zzb.equals(zznuVar.zzb) && Objects.equals(this.zzc, zznuVar.zzc);
    }
}

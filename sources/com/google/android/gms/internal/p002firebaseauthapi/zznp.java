package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zznp extends zzcg {
    private final zzpm zza;

    public final int hashCode() {
        return Objects.hash(this.zza.zza(), this.zza.zzb());
    }

    public final zzpm zzb() {
        return this.zza;
    }

    public final String toString() {
        String str;
        Object[] objArr = new Object[2];
        objArr[0] = this.zza.zza().zzf();
        int i = zzno.zza[this.zza.zza().zzd().ordinal()];
        if (i == 1) {
            str = "TINK";
        } else if (i == 2) {
            str = "LEGACY";
        } else if (i == 3) {
            str = "RAW";
        } else if (i == 4) {
            str = "CRUNCHY";
        } else {
            str = "UNKNOWN";
        }
        objArr[1] = str;
        return String.format("(typeUrl=%s, outputPrefixType=%s)", objArr);
    }

    public zznp(zzpm zzpmVar) {
        this.zza = zzpmVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zznp)) {
            return false;
        }
        zzpm zzpmVar = ((zznp) obj).zza;
        return this.zza.zza().zzd().equals(zzpmVar.zza().zzd()) && this.zza.zza().zzf().equals(zzpmVar.zza().zzf()) && this.zza.zza().zze().equals(zzpmVar.zza().zze());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzcg
    public final boolean zza() {
        return this.zza.zza().zzd() != zzxd.RAW;
    }
}

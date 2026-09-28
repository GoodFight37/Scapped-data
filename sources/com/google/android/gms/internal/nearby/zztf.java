package com.google.android.gms.internal.nearby;

import java.io.IOException;
import java.math.RoundingMode;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zztf extends zzth {
    private final zzth zza;
    private final String zzb = ":";

    zztf(zzth zzthVar, String str, int i) {
        this.zza = zzthVar;
    }

    public final String toString() {
        return this.zza + ".withSeparator(\"" + this.zzb + "\", 2)";
    }

    @Override // com.google.android.gms.internal.nearby.zzth
    final int zza(byte[] bArr, CharSequence charSequence) throws zzte {
        StringBuilder sb = new StringBuilder(charSequence.length());
        for (int i = 0; i < charSequence.length(); i++) {
            char cCharAt = charSequence.charAt(i);
            if (this.zzb.indexOf(cCharAt) < 0) {
                sb.append(cCharAt);
            }
        }
        return this.zza.zza(bArr, sb);
    }

    @Override // com.google.android.gms.internal.nearby.zzth
    final int zzc(int i) {
        return this.zza.zzc(i);
    }

    @Override // com.google.android.gms.internal.nearby.zzth
    final int zzd(int i) {
        int iZzd = this.zza.zzd(i);
        return iZzd + (this.zzb.length() * zztj.zza(Math.max(0, iZzd - 1), 2, RoundingMode.FLOOR));
    }

    @Override // com.google.android.gms.internal.nearby.zzth
    public final zzth zze(String str, int i) {
        throw null;
    }

    @Override // com.google.android.gms.internal.nearby.zzth
    final CharSequence zzf(CharSequence charSequence) {
        return this.zza.zzf(charSequence);
    }

    @Override // com.google.android.gms.internal.nearby.zzth
    final void zzb(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        zzth zzthVar = this.zza;
        String str = this.zzb;
        appendable.getClass();
        zzthVar.zzb(new zzta(2, appendable, str), bArr, 0, i2);
    }
}

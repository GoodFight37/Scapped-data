package com.google.android.gms.internal.nearby;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zztc extends zztg {
    final char[] zza;

    zztc(String str, String str2) {
        zztb zztbVar = new zztb("base16()", "0123456789ABCDEF".toCharArray());
        super(zztbVar, null);
        this.zza = new char[512];
        zzsg.zzd(zztbVar.zzf.length == 16);
        for (int i = 0; i < 256; i++) {
            this.zza[i] = zztbVar.zza(i >>> 4);
            this.zza[i | 256] = zztbVar.zza(i & 15);
        }
    }

    @Override // com.google.android.gms.internal.nearby.zztg, com.google.android.gms.internal.nearby.zzth
    final void zzb(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        appendable.getClass();
        zzsg.zzg(0, i2, bArr.length);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = bArr[i3] & 255;
            appendable.append(this.zza[i4]);
            appendable.append(this.zza[i4 | 256]);
        }
    }

    @Override // com.google.android.gms.internal.nearby.zztg, com.google.android.gms.internal.nearby.zzth
    final int zza(byte[] bArr, CharSequence charSequence) throws zzte {
        bArr.getClass();
        if (charSequence.length() % 2 == 1) {
            throw new zzte("Invalid input length " + charSequence.length());
        }
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            bArr[i2] = (byte) ((this.zzb.zzb(charSequence.charAt(i)) << 4) | this.zzb.zzb(charSequence.charAt(i + 1)));
            i += 2;
            i2++;
        }
        return i2;
    }
}

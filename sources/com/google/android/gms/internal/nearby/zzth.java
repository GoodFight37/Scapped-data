package com.google.android.gms.internal.nearby;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzth {
    private static final zzth zza = new zztd("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
    private static final zzth zzb = new zztd("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');
    private static final zzth zzc = new zztg("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');
    private static final zzth zzd = new zztg("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');
    private static final zzth zze = new zztc("base16()", "0123456789ABCDEF");

    zzth() {
    }

    public static zzth zzh() {
        return zze;
    }

    abstract int zza(byte[] bArr, CharSequence charSequence) throws zzte;

    abstract void zzb(Appendable appendable, byte[] bArr, int i, int i2) throws IOException;

    abstract int zzc(int i);

    abstract int zzd(int i);

    public abstract zzth zze(String str, int i);

    CharSequence zzf(CharSequence charSequence) {
        throw null;
    }

    public final String zzi(byte[] bArr, int i, int i2) {
        zzsg.zzg(0, i2, bArr.length);
        StringBuilder sb = new StringBuilder(zzd(i2));
        try {
            zzb(sb, bArr, 0, i2);
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final byte[] zzj(CharSequence charSequence) {
        try {
            CharSequence charSequenceZzf = zzf(charSequence);
            int iZzc = zzc(charSequenceZzf.length());
            byte[] bArr = new byte[iZzc];
            int iZza = zza(bArr, charSequenceZzf);
            if (iZza == iZzc) {
                return bArr;
            }
            byte[] bArr2 = new byte[iZza];
            System.arraycopy(bArr, 0, bArr2, 0, iZza);
            return bArr2;
        } catch (zzte e) {
            throw new IllegalArgumentException(e);
        }
    }
}

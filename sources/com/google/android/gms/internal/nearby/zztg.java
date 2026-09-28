package com.google.android.gms.internal.nearby;

import java.io.IOException;
import java.math.RoundingMode;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
class zztg extends zzth {
    final zztb zzb;

    @CheckForNull
    final Character zzc;

    zztg(zztb zztbVar, @CheckForNull Character ch) {
        this.zzb = zztbVar;
        boolean z = true;
        if (ch != null && zztbVar.zzd(ch.charValue())) {
            z = false;
        }
        zzsg.zzf(z, "Padding character %s was already in alphabet", ch);
        this.zzc = ch;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zztg) {
            zztg zztgVar = (zztg) obj;
            if (this.zzb.equals(zztgVar.zzb)) {
                Character ch = this.zzc;
                Character ch2 = zztgVar.zzc;
                if (ch == ch2) {
                    return true;
                }
                if (ch != null && ch.equals(ch2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zzb.hashCode();
        Character ch = this.zzc;
        return iHashCode ^ (ch == null ? 0 : ch.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        sb.append(this.zzb);
        if (8 % this.zzb.zzb != 0) {
            if (this.zzc == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(this.zzc);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.nearby.zzth
    final int zzc(int i) {
        return (int) (((((long) this.zzb.zzb) * ((long) i)) + 7) / 8);
    }

    @Override // com.google.android.gms.internal.nearby.zzth
    final int zzd(int i) {
        zztb zztbVar = this.zzb;
        return zztbVar.zzc * zztj.zza(i, zztbVar.zzd, RoundingMode.CEILING);
    }

    @Override // com.google.android.gms.internal.nearby.zzth
    public final zzth zze(String str, int i) {
        for (int i2 = 0; i2 <= 0; i2++) {
            zzsg.zzf(true ^ this.zzb.zzd(":".charAt(i2)), "Separator (%s) cannot contain alphabet characters", ":");
        }
        Character ch = this.zzc;
        if (ch != null) {
            zzsg.zzf(":".indexOf(ch.charValue()) < 0, "Separator (%s) cannot contain padding character", ":");
        }
        return new zztf(this, ":", 2);
    }

    final void zzg(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        zzsg.zzg(i, i + i2, bArr.length);
        int i3 = 0;
        zzsg.zzd(i2 <= this.zzb.zzd);
        long j = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            j = (j | ((long) (bArr[i + i4] & 255))) << 8;
        }
        int i5 = ((i2 + 1) * 8) - this.zzb.zzb;
        while (i3 < i2 * 8) {
            zztb zztbVar = this.zzb;
            appendable.append(zztbVar.zza(zztbVar.zza & ((int) (j >>> (i5 - i3)))));
            i3 += this.zzb.zzb;
        }
        if (this.zzc != null) {
            while (i3 < this.zzb.zzd * 8) {
                appendable.append(this.zzc.charValue());
                i3 += this.zzb.zzb;
            }
        }
    }

    zztg(String str, String str2, @CheckForNull Character ch) {
        this(new zztb(str, str2.toCharArray()), ch);
    }

    @Override // com.google.android.gms.internal.nearby.zzth
    void zzb(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        appendable.getClass();
        int i3 = 0;
        zzsg.zzg(0, i2, bArr.length);
        while (i3 < i2) {
            zzg(appendable, bArr, i3, Math.min(this.zzb.zzd, i2 - i3));
            i3 += this.zzb.zzd;
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzth
    final CharSequence zzf(CharSequence charSequence) {
        charSequence.getClass();
        Character ch = this.zzc;
        if (ch == null) {
            return charSequence;
        }
        char cCharValue = ch.charValue();
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                break;
            }
        } while (charSequence.charAt(length) == cCharValue);
        return charSequence.subSequence(0, length + 1);
    }

    @Override // com.google.android.gms.internal.nearby.zzth
    int zza(byte[] bArr, CharSequence charSequence) throws zzte {
        zztb zztbVar;
        bArr.getClass();
        CharSequence charSequenceZzf = zzf(charSequence);
        if (!this.zzb.zzc(charSequenceZzf.length())) {
            throw new zzte("Invalid input length " + charSequenceZzf.length());
        }
        int i = 0;
        int i2 = 0;
        while (i < charSequenceZzf.length()) {
            long jZzb = 0;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                zztbVar = this.zzb;
                if (i3 >= zztbVar.zzc) {
                    break;
                }
                jZzb <<= zztbVar.zzb;
                if (i + i3 < charSequenceZzf.length()) {
                    jZzb |= (long) this.zzb.zzb(charSequenceZzf.charAt(i4 + i));
                    i4++;
                }
                i3++;
            }
            int i5 = zztbVar.zzd;
            int i6 = i5 * 8;
            int i7 = i4 * zztbVar.zzb;
            int i8 = (i5 - 1) * 8;
            while (i8 >= i6 - i7) {
                bArr[i2] = (byte) ((jZzb >>> i8) & 255);
                i8 -= 8;
                i2++;
            }
            i += this.zzb.zzc;
        }
        return i2;
    }
}

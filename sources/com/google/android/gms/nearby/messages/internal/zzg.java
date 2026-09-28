package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ArrayUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzg extends zzc {
    /* JADX WARN: Illegal instructions before constructor call */
    public zzg(String str, String str2) {
        byte[] bArrZzd = zzd(str);
        byte[] bArrZzd2 = zzd(str2);
        byte[][] bArr = new byte[2][];
        int length = bArrZzd.length;
        Preconditions.checkArgument(length == 10, "Namespace length(" + length + " bytes) must be 10 bytes.");
        bArr[0] = bArrZzd;
        int length2 = bArrZzd2.length;
        Preconditions.checkArgument(length2 == 6, "Instance length(" + length2 + " bytes) must be 6 bytes.");
        bArr[1] = bArrZzd2;
        byte[] bArrConcatByteArrays = ArrayUtils.concatByteArrays(bArr);
        zze(bArrConcatByteArrays);
        super(bArrConcatByteArrays);
    }

    private static byte[] zze(byte[] bArr) {
        int length = bArr.length;
        boolean z = true;
        if (length != 10 && length != 16) {
            z = false;
        }
        Preconditions.checkArgument(z, "Bytes must be a namespace (10 bytes), or a namespace plus instance (16 bytes).");
        return bArr;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzc
    public final String toString() {
        return "EddystoneUidPrefix{bytes=" + zza() + "}";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzg(byte[] bArr) {
        super(bArr);
        zze(bArr);
    }
}

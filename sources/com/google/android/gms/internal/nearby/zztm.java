package com.google.android.gms.internal.nearby;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zztm extends zztn {
    static /* synthetic */ int zza(int[] iArr, int i, int i2, int i3) {
        while (i2 < i3) {
            if (iArr[i2] == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static List zzb(int... iArr) {
        int length = iArr.length;
        return length == 0 ? Collections.emptyList() : new zztl(iArr, 0, length);
    }
}

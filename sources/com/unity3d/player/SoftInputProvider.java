package com.unity3d.player;

import com.unity3d.player.a.AbstractC0082o;

/* JADX INFO: loaded from: classes2.dex */
abstract class SoftInputProvider {
    private static final native int nativeGetSoftInputType();

    public static int a() {
        int iNativeGetSoftInputType = nativeGetSoftInputType();
        int[] iArrB = AbstractC0082o.b(3);
        int length = iArrB.length;
        int i = 0;
        while (true) {
            int i2 = 1;
            if (i >= length) {
                return 1;
            }
            int i3 = iArrB[i];
            if (i3 == 1) {
                i2 = -1;
            } else if (i3 == 2) {
                i2 = 0;
            } else if (i3 != 3) {
                throw null;
            }
            if (i2 == iNativeGetSoftInputType) {
                return i3;
            }
            i++;
        }
    }
}

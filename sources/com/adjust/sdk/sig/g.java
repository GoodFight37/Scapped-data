package com.adjust.sdk.sig;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f130a;

    static {
        Object n2Var;
        int length;
        int i;
        boolean z;
        int i2;
        try {
            String property = System.getProperty("kotlinx.serialization.json.pool.size");
            if (property != null && (length = property.length()) != 0) {
                int i3 = 0;
                char cCharAt = property.charAt(0);
                int i4 = -2147483647;
                if (cCharAt < '0') {
                    z = true;
                    if (length != 1) {
                        if (cCharAt == '+') {
                            i = 1;
                            z = false;
                        } else if (cCharAt == '-') {
                            i4 = Integer.MIN_VALUE;
                            i = 1;
                        }
                    }
                    n2Var = null;
                    break;
                }
                i = 0;
                z = false;
                int i5 = -59652323;
                while (true) {
                    if (i >= length) {
                        if (!z) {
                            n2Var = Integer.valueOf(-i3);
                            break;
                        } else {
                            n2Var = Integer.valueOf(i3);
                            break;
                        }
                    }
                    int iDigit = Character.digit((int) property.charAt(i), 10);
                    if (iDigit >= 0 && ((i3 >= i5 || (i5 == -59652323 && i3 >= (i5 = i4 / 10))) && (i2 = i3 * 10) >= i4 + iDigit)) {
                        i3 = i2 - iDigit;
                        i++;
                    }
                    n2Var = null;
                    break;
                }
            }
            n2Var = null;
            break;
        } catch (Throwable th) {
            n2Var = new n2(th);
        }
        Integer num = (Integer) (n2Var instanceof n2 ? null : n2Var);
        f130a = num != null ? num.intValue() : 2097152;
    }
}

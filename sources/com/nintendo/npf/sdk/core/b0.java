package com.nintendo.npf.sdk.core;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f413a = new char[62];

    static {
        int i = 0;
        char c = 'a';
        while (c <= 'z') {
            f413a[i] = c;
            c = (char) (c + 1);
            i++;
        }
        char c2 = '0';
        while (c2 <= '9') {
            f413a[i] = c2;
            c2 = (char) (c2 + 1);
            i++;
        }
        char c3 = 'A';
        while (c3 <= 'Z') {
            f413a[i] = c3;
            c3 = (char) (c3 + 1);
            i++;
        }
    }

    public static String a(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            char[] cArr = f413a;
            sb.append(cArr[(int) (((double) cArr.length) * Math.random())]);
        }
        return sb.toString();
    }
}

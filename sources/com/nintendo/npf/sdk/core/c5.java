package com.nintendo.npf.sdk.core;

import com.google.common.base.Ascii;
import java.lang.reflect.UndeclaredThrowableException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.util.Calendar;
import java.util.Locale;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.time.DurationKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f425a = {1, 10, 100, 1000, 10000, 100000, DurationKt.NANOS_IN_MILLIS, 10000000, 100000000};

    public static String a(byte[] bArr, int i, int i2, String str) {
        String upperCase = Long.toHexString((Calendar.getInstance().getTimeInMillis() / 1000) / ((long) i)).toUpperCase(Locale.US);
        while (upperCase.length() < 16) {
            upperCase = "0" + upperCase;
        }
        byte[] bArrA = a(str, bArr, a(upperCase));
        int i3 = bArrA[bArrA.length - 1] & Ascii.SI;
        String string = Integer.toString(((bArrA[i3 + 3] & 255) | ((((bArrA[i3] & 127) << 24) | ((bArrA[i3 + 1] & 255) << 16)) | ((bArrA[i3 + 2] & 255) << 8))) % f425a[i2]);
        while (string.length() < i2) {
            string = "0" + string;
        }
        return string;
    }

    private static byte[] a(String str, byte[] bArr, byte[] bArr2) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(bArr, "RAW"));
            return mac.doFinal(bArr2);
        } catch (GeneralSecurityException e) {
            throw new UndeclaredThrowableException(e);
        }
    }

    private static byte[] a(String str) {
        byte[] byteArray = new BigInteger("10" + str, 16).toByteArray();
        int length = byteArray.length - 1;
        byte[] bArr = new byte[length];
        System.arraycopy(byteArray, 1, bArr, 0, length);
        return bArr;
    }
}

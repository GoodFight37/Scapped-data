package com.nintendo.npf.sdk.core;

import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public abstract class v1 {
    public static final byte[] a(byte[] bArr) throws Throwable {
        GZIPOutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream2 = null;
        try {
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(bArr);
                    gZIPOutputStream.flush();
                    gZIPOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                } catch (Exception e) {
                    e = e;
                    gZIPOutputStream2 = gZIPOutputStream;
                    throw new IllegalStateException(e);
                } catch (Throwable th) {
                    th = th;
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                gZIPOutputStream = gZIPOutputStream2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }
}

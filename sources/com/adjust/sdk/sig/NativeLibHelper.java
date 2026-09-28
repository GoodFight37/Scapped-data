package com.adjust.sdk.sig;

import android.content.Context;
import android.util.Log;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public final class NativeLibHelper {
    static {
        try {
            System.loadLibrary("signer");
        } catch (UnsatisfiedLinkError e) {
            Log.e("NativeLibHelper", "Signer Library could not be loaded: " + e.getMessage());
        }
    }

    private final native void nOnResume();

    private final native byte[] nSign(Context context, Object obj, byte[] bArr, int i);

    public final byte[] a(Context context, LinkedHashMap linkedHashMap, byte[] bArr, int i) {
        return nSign(context, linkedHashMap, bArr, i);
    }

    public final void a() {
        nOnResume();
    }
}

package com.adjust.sdk.sig;

import android.content.Context;
import android.util.Log;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public final class Signer implements ISigner {
    public static final x2 Companion = new x2();
    public static final String EXCEPTION_MSG_SDK4 = "This version of Adjust Signature is not compatible with Adjust SDK v4. Please upgrade to SDK v5.";
    public static boolean c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NativeLibHelper f112a = new NativeLibHelper();
    public final v1 b = new v1();

    @Override // com.adjust.sdk.sig.ISigner
    public synchronized void onResume() {
        try {
            if (c) {
                throw new IllegalStateException("sign: Library received error, it has locked down");
            }
            this.f112a.a();
        } catch (IllegalStateException e) {
            String message = e.getMessage();
            if (message == null) {
                message = "sign: Incorrect library state";
            }
            Log.e("Signer", message);
        } catch (Exception e2) {
            Log.e("Signer", "sign: Unhandled exception: " + e2.getMessage());
        }
    }

    @Override // com.adjust.sdk.sig.ISigner
    public void sign(Context context, Map<String, String> map, String str, String str2) {
        Log.e("Signer", EXCEPTION_MSG_SDK4);
        throw new UnsupportedOperationException(EXCEPTION_MSG_SDK4);
    }

    @Override // com.adjust.sdk.sig.ISigner
    public synchronized void sign(Context context, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        try {
            try {
                if (c) {
                    throw new IllegalStateException("sign: Library received error, it has locked down");
                }
                if (context != null) {
                    v1 v1Var = this.b;
                    NativeLibHelper nativeLibHelper = this.f112a;
                    if (map == null) {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                    if (map2 == null) {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                    if (map3 != null) {
                        new y2(context, v1Var, nativeLibHelper, map, map2, o3.a(map3)).a();
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.");
                }
                throw new IllegalArgumentException("Required value was null.");
            } catch (IllegalArgumentException e) {
                String message = e.getMessage();
                if (message == null) {
                    message = "sign: Required parameter is null";
                }
                Log.e("Signer", message);
            } catch (IllegalStateException e2) {
                String message2 = e2.getMessage();
                if (message2 == null) {
                    message2 = "sign: Incorrect library state";
                }
                Log.e("Signer", message2);
            }
        } catch (d2 e3) {
            c = true;
            String message3 = e3.getMessage();
            if (message3 == null) {
                message3 = "sign: Library received error, it has locked down";
            }
            Log.e("Signer", message3);
        } catch (Exception e4) {
            Log.e("Signer", "sign: Unhandled exception: " + e4.getMessage());
        }
    }
}

package com.nintendo.npf.sdk.internal.bridge.cpp;

import android.util.Base64;
import com.google.protobuf.MessageLite;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0083 ¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0012J)\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00132\b\u0010\b\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000f\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/nintendo/npf/sdk/internal/bridge/cpp/BridgeCore;", "", "<init>", "()V", "", "callbackId", "", "arg0", "arg1", "", "onCallback2", "(J[B[B)V", "b0", "b1", "", "a", "(J[B[B)Ljava/lang/String;", "b", "([B)Ljava/lang/String;", "Lcom/google/protobuf/MessageLite;", "(JLcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)V", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BridgeCore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BridgeCore f732a = new BridgeCore();

    private BridgeCore() {
    }

    @JvmStatic
    private static final native void onCallback2(long callbackId, byte[] arg0, byte[] arg1);

    public final void a(long callbackId, MessageLite arg0, MessageLite arg1) {
        byte[] byteArray = arg0 != null ? arg0.toByteArray() : null;
        byte[] byteArray2 = arg1 != null ? arg1.toByteArray() : null;
        SDKLog.d("BridgeCore", a(callbackId, byteArray, byteArray2));
        onCallback2(callbackId, byteArray, byteArray2);
    }

    private final String a(long callbackId, byte[] b0, byte[] b1) {
        return "onCallback2(" + callbackId + ", " + a(b0) + ", " + a(b1) + ')';
    }

    private final String a(byte[] b) {
        if (b != null) {
            return Base64.encodeToString(b, 2);
        }
        return null;
    }
}

package com.nintendo.npf.sdk.internal.bridge.unity;

import android.util.Base64;
import com.google.protobuf.MessageLite;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\"\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R\u001a\u0010\u001c\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012R\u001a\u0010\u001f\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001e\u0010\u0012R\u0017\u0010$\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R+\u0010*\u001a\u0012\u0012\u0002\b\u0003 &*\b\u0012\u0002\b\u0003\u0018\u00010%0%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b\u000f\u0010)R\u001b\u0010\r\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010(\u001a\u0004\b\u0014\u0010-¨\u0006."}, d2 = {"Lcom/nintendo/npf/sdk/internal/bridge/unity/BridgeCore;", "", "<init>", "()V", "", "callbackId", "", "Lcom/google/protobuf/MessageLite;", "params", "", "executeCommand", "(Ljava/lang/String;[Lcom/google/protobuf/MessageLite;)V", MapperConstants.NPF_ERROR_FIELD_MESSAGE, "unitySendMessage", "(Ljava/lang/String;)V", "a", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "b", "getUNITY_PLAYER_CLASS_NAME", "UNITY_PLAYER_CLASS_NAME", "c", "getUNITY_PLAYER_METHOD_NAME", "UNITY_PLAYER_METHOD_NAME", "d", "getUNITY_GAME_OBJECT_NAME", "UNITY_GAME_OBJECT_NAME", "e", "getUNITY_GAME_OBJECT_METHOD_NAME", "UNITY_GAME_OBJECT_METHOD_NAME", "f", "Ljava/lang/Object;", "getPARAM_EXPRESSION_NULL", "()Ljava/lang/Object;", "PARAM_EXPRESSION_NULL", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "g", "Lkotlin/Lazy;", "()Ljava/lang/Class;", "unityPlayerClass", "Ljava/lang/reflect/Method;", "h", "()Ljava/lang/reflect/Method;", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BridgeCore {
    public static final BridgeCore INSTANCE = new BridgeCore();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final String TAG = "BridgeCore";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static final String UNITY_PLAYER_CLASS_NAME = "com.unity3d.player.UnityPlayer";

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private static final String UNITY_PLAYER_METHOD_NAME = "UnitySendMessage";

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private static final String UNITY_GAME_OBJECT_NAME = "NPFSDK";

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private static final String UNITY_GAME_OBJECT_METHOD_NAME = "NativeBridgeCallback2";

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private static final Object PARAM_EXPRESSION_NULL;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private static final Lazy unityPlayerClass;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private static final Lazy unitySendMessage;

    static final class a extends Lambda implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f751a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Class invoke() {
            return Class.forName(BridgeCore.INSTANCE.getUNITY_PLAYER_CLASS_NAME());
        }
    }

    static final class b extends Lambda implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f752a = new b();

        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Method invoke() {
            BridgeCore bridgeCore = BridgeCore.INSTANCE;
            return bridgeCore.a().getMethod(bridgeCore.getUNITY_PLAYER_METHOD_NAME(), String.class, String.class, String.class);
        }
    }

    static {
        Object NULL = JSONObject.NULL;
        Intrinsics.checkNotNullExpressionValue(NULL, "NULL");
        PARAM_EXPRESSION_NULL = NULL;
        unityPlayerClass = LazyKt.lazy(a.f751a);
        unitySendMessage = LazyKt.lazy(b.f752a);
    }

    private BridgeCore() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class a() {
        return (Class) unityPlayerClass.getValue();
    }

    private final Method b() {
        Object value = unitySendMessage.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-unitySendMessage>(...)");
        return (Method) value;
    }

    public final void executeCommand(String callbackId, MessageLite... params) throws IllegalAccessException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(callbackId, "callbackId");
        Intrinsics.checkNotNullParameter(params, "params");
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(callbackId);
        for (MessageLite messageLite : params) {
            if (messageLite == null) {
                jSONArray.put(PARAM_EXPRESSION_NULL);
            } else {
                jSONArray.put(Base64.encodeToString(messageLite.toByteArray(), 2));
            }
        }
        String string = jSONArray.toString();
        Intrinsics.checkNotNullExpressionValue(string, "jsonArray.toString()");
        unitySendMessage(string);
    }

    public final Object getPARAM_EXPRESSION_NULL() {
        return PARAM_EXPRESSION_NULL;
    }

    public final String getTAG() {
        return TAG;
    }

    public final String getUNITY_GAME_OBJECT_METHOD_NAME() {
        return UNITY_GAME_OBJECT_METHOD_NAME;
    }

    public final String getUNITY_GAME_OBJECT_NAME() {
        return UNITY_GAME_OBJECT_NAME;
    }

    public final String getUNITY_PLAYER_CLASS_NAME() {
        return UNITY_PLAYER_CLASS_NAME;
    }

    public final String getUNITY_PLAYER_METHOD_NAME() {
        return UNITY_PLAYER_METHOD_NAME;
    }

    public final void unitySendMessage(String message) throws IllegalAccessException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(message, "message");
        SDKLog.d(TAG, message);
        b().invoke(a(), UNITY_GAME_OBJECT_NAME, UNITY_GAME_OBJECT_METHOD_NAME, message);
    }
}

package com.unity3d.player;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes2.dex */
class FirebaseIdentifiersHelper {
    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnFirebaseAppInstanceIdResult(String str);

    FirebaseIdentifiersHelper() {
    }

    public static void requestFirebaseIdentifiers(Context context) {
        try {
            Class<?> cls = Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
            Method method = cls.getMethod("getInstance", Context.class);
            if (!validateGetInstanceMethod(method, cls)) {
                nativeOnFirebaseAppInstanceIdResult(null);
                return;
            }
            Object objInvoke = method.invoke(null, context);
            if (objInvoke == null) {
                nativeOnFirebaseAppInstanceIdResult(null);
                return;
            }
            Method method2 = cls.getMethod("getAppInstanceId", null);
            if (!validateGetAppInstanceIdMethod(method2)) {
                nativeOnFirebaseAppInstanceIdResult(null);
            } else {
                ((Task) method2.invoke(objInvoke, null)).addOnCompleteListener(new C0113l());
            }
        } catch (Exception unused) {
            nativeOnFirebaseAppInstanceIdResult(null);
        }
    }

    private static boolean validateGetInstanceMethod(Method method, Class cls) {
        return method != null && method.getReturnType() == cls;
    }

    private static boolean validateGetAppInstanceIdMethod(Method method) {
        Type genericReturnType;
        if (method != null && UByte$$ExternalSyntheticBackport0.m(method) == 0 && (genericReturnType = method.getGenericReturnType()) != null && (genericReturnType instanceof ParameterizedType)) {
            ParameterizedType parameterizedType = (ParameterizedType) genericReturnType;
            if (parameterizedType.getRawType() != Task.class) {
                return false;
            }
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            if (actualTypeArguments.length == 1 && actualTypeArguments[0] == String.class) {
                return true;
            }
        }
        return false;
    }
}

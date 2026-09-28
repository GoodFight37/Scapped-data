package com.unity3d.player;

import android.content.Context;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes2.dex */
class AndroidAppSetIdHelper {
    private static Class s_AppSetClass;
    private static Method s_GetClientMethod;
    private static Class s_OnFailureListenerClass;
    private static Class s_OnSuccessListenerClass;

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnAndroidAppSetIdResult(String str);

    AndroidAppSetIdHelper() {
    }

    private static synchronized void ensureReflectionCache() {
        if (s_AppSetClass != null) {
            return;
        }
        Class<?> cls = Class.forName("com.google.android.gms.appset.AppSet");
        s_GetClientMethod = cls.getMethod("getClient", Context.class);
        s_OnSuccessListenerClass = OnSuccessListener.class;
        s_OnFailureListenerClass = OnFailureListener.class;
        s_AppSetClass = cls;
    }

    public static void requestAppSetId(Context context) {
        try {
            ensureReflectionCache();
            Object objInvoke = s_GetClientMethod.invoke(s_AppSetClass, context);
            if (objInvoke == null) {
                nativeOnAndroidAppSetIdResult(null);
                return;
            }
            Object objInvoke2 = objInvoke.getClass().getMethod("getAppSetIdInfo", null).invoke(objInvoke, null);
            if (objInvoke2 == null) {
                nativeOnAndroidAppSetIdResult(null);
                return;
            }
            Object objNewProxyInstance = Proxy.newProxyInstance(AndroidAppSetIdHelper.class.getClassLoader(), new Class[]{s_OnSuccessListenerClass}, new C0067a());
            Object objNewProxyInstance2 = Proxy.newProxyInstance(AndroidAppSetIdHelper.class.getClassLoader(), new Class[]{s_OnFailureListenerClass}, new C0093b());
            Method method = objInvoke2.getClass().getMethod("addOnSuccessListener", s_OnSuccessListenerClass);
            Method method2 = objInvoke2.getClass().getMethod("addOnFailureListener", s_OnFailureListenerClass);
            method.invoke(objInvoke2, objNewProxyInstance);
            method2.invoke(objInvoke2, objNewProxyInstance2);
        } catch (Exception unused) {
            nativeOnAndroidAppSetIdResult(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object defaultProxyResult(Object obj, Method method, Object[] objArr) {
        if ("hashCode".equals(method.getName())) {
            return Integer.valueOf(System.identityHashCode(obj));
        }
        if ("equals".equals(method.getName())) {
            boolean z = false;
            if (objArr != null && objArr.length > 0 && obj == objArr[0]) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
        if ("toString".equals(method.getName())) {
            return "AndroidAppSetIdHelper$Proxy@" + Integer.toHexString(System.identityHashCode(obj));
        }
        return null;
    }
}

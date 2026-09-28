package com.unity3d.player;

import com.adjust.sdk.Constants;
import com.fasterxml.jackson.core.JsonPointer;
import com.unity3d.player.a.AbstractC0086t;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
final class ReflectionHelper {
    protected static boolean LOG = false;
    protected static final boolean LOGV = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C0121p[] f1038a = new C0121p[4096];
    private static long b = 0;
    private static long c = 0;
    private static boolean d = false;

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeProxyFinalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native Object nativeProxyInvoke(long j, String str, Object[] objArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeProxyJNIFreeGCHandle(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeProxyLogJNIInvokeException(long j);

    private static synchronized boolean a(C0121p c0121p) {
        C0121p c0121p2 = f1038a[c0121p.d & 4095];
        if (!c0121p.equals(c0121p2)) {
            return false;
        }
        c0121p.e = c0121p2.e;
        return true;
    }

    protected static Constructor getConstructorID(Class cls, String str) {
        Constructor<?> constructor;
        C0121p c0121p = new C0121p(cls, "", str);
        if (a(c0121p)) {
            constructor = (Constructor) c0121p.e;
        } else {
            Class[] clsArrA = a(str);
            Constructor<?> constructor2 = null;
            float f = 0.0f;
            for (Constructor<?> constructor3 : cls.getConstructors()) {
                float fA = a(Void.TYPE, constructor3.getParameterTypes(), clsArrA);
                if (fA > f) {
                    if (fA == 1.0f) {
                        constructor2 = constructor3;
                        break;
                    }
                    constructor2 = constructor3;
                    f = fA;
                }
            }
            synchronized (ReflectionHelper.class) {
                c0121p.e = constructor2;
                f1038a[c0121p.d & 4095] = c0121p;
            }
            constructor = constructor2;
        }
        if (constructor != null) {
            return constructor;
        }
        throw new NoSuchMethodError("<init>" + str + " in class " + cls.getName());
    }

    protected static Method getMethodID(Class cls, String str, String str2, boolean z) {
        Method method;
        C0121p c0121p = new C0121p(cls, str, str2);
        if (a(c0121p)) {
            method = (Method) c0121p.e;
        } else {
            Class[] clsArrA = a(str2);
            Method method2 = null;
            float f = 0.0f;
            while (cls != null) {
                for (Method method3 : cls.getDeclaredMethods()) {
                    if (z == Modifier.isStatic(method3.getModifiers()) && method3.getName().compareTo(str) == 0) {
                        float fA = a(method3.getReturnType(), method3.getParameterTypes(), clsArrA);
                        if (fA <= f) {
                            continue;
                        } else {
                            if (fA == 1.0f) {
                                method2 = method3;
                                f = fA;
                                break;
                            }
                            method2 = method3;
                            f = fA;
                        }
                    }
                }
                if (f == 1.0f || cls.isPrimitive() || cls.isInterface() || cls.equals(Object.class) || cls.equals(Void.TYPE)) {
                    break;
                }
                cls = cls.getSuperclass();
            }
            synchronized (ReflectionHelper.class) {
                c0121p.e = method2;
                f1038a[c0121p.d & 4095] = c0121p;
            }
            method = method2;
        }
        if (method != null) {
            return method;
        }
        throw new NoSuchMethodError("no " + (z ? "static" : "non-static") + " method with name='" + str + "' signature='" + str2 + "' in class L" + cls.getName() + ";");
    }

    protected static Field getFieldID(Class cls, String str, String str2, boolean z) {
        Field field;
        C0121p c0121p = new C0121p(cls, str, str2);
        if (a(c0121p)) {
            field = (Field) c0121p.e;
        } else {
            Class[] clsArrA = a(str2);
            float f = 0.0f;
            Field field2 = null;
            while (cls != null) {
                for (Field field3 : cls.getDeclaredFields()) {
                    if (z == Modifier.isStatic(field3.getModifiers()) && field3.getName().compareTo(str) == 0) {
                        float fA = a(field3.getType(), null, clsArrA);
                        if (fA > f) {
                            field2 = field3;
                            if (fA == 1.0f) {
                                f = fA;
                                break;
                            }
                            f = fA;
                        } else {
                            continue;
                        }
                    }
                }
                if (f == 1.0f || cls.isPrimitive() || cls.isInterface() || cls.equals(Object.class) || cls.equals(Void.TYPE)) {
                    break;
                }
                cls = cls.getSuperclass();
            }
            synchronized (ReflectionHelper.class) {
                c0121p.e = field2;
                f1038a[c0121p.d & 4095] = c0121p;
            }
            field = field2;
        }
        if (field != null) {
            return field;
        }
        throw new NoSuchFieldError("no " + (z ? "static" : "non-static") + " field with name='" + str + "' signature='" + str2 + "' in class L" + cls.getName() + ";");
    }

    protected static String getFieldSignature(Field field) {
        Class<?> type = field.getType();
        if (type.isPrimitive()) {
            String name = type.getName();
            if ("boolean".equals(name)) {
                return "Z";
            }
            if ("byte".equals(name)) {
                return "B";
            }
            if ("char".equals(name)) {
                return "C";
            }
            if ("double".equals(name)) {
                return "D";
            }
            if ("float".equals(name)) {
                return "F";
            }
            if ("int".equals(name)) {
                return "I";
            }
            if (Constants.LONG.equals(name)) {
                return "J";
            }
            return "short".equals(name) ? "S" : name;
        }
        if (type.isArray()) {
            return type.getName().replace('.', JsonPointer.SEPARATOR);
        }
        return "L" + type.getName().replace('.', JsonPointer.SEPARATOR) + ";";
    }

    private static float a(Class cls, Class cls2) {
        if (cls.equals(cls2)) {
            return 1.0f;
        }
        if (cls.isPrimitive() || cls2.isPrimitive()) {
            return 0.0f;
        }
        try {
            if (cls.asSubclass(cls2) != null) {
                return 0.5f;
            }
        } catch (ClassCastException unused) {
        }
        try {
            return cls2.asSubclass(cls) != null ? 0.1f : 0.0f;
        } catch (ClassCastException unused2) {
            return 0.0f;
        }
    }

    private static float a(Class cls, Class[] clsArr, Class[] clsArr2) {
        if (clsArr2.length == 0) {
            return 0.1f;
        }
        int i = 0;
        if ((clsArr == null ? 0 : clsArr.length) + 1 != clsArr2.length) {
            return 0.0f;
        }
        float f = 1.0f;
        if (clsArr != null) {
            int length = clsArr.length;
            float fA = 1.0f;
            int i2 = 0;
            while (i < length) {
                fA *= a(clsArr[i], clsArr2[i2]);
                i++;
                i2++;
            }
            f = fA;
        }
        return f * a(cls, clsArr2[clsArr2.length - 1]);
    }

    private static Class[] a(String str) {
        Class clsA;
        int i = 0;
        int[] iArr = {0};
        ArrayList arrayList = new ArrayList();
        while (iArr[0] < str.length() && (clsA = a(str, iArr)) != null) {
            arrayList.add(clsA);
        }
        Class[] clsArr = new Class[arrayList.size()];
        int size = arrayList.size();
        int i2 = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            clsArr[i2] = (Class) obj;
            i2++;
        }
        return clsArr;
    }

    private static Class a(String str, int[] iArr) {
        while (iArr[0] < str.length()) {
            int i = iArr[0];
            iArr[0] = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt != '(' && cCharAt != ')') {
                if (cCharAt == 'L') {
                    int iIndexOf = str.indexOf(59, iArr[0]);
                    if (iIndexOf == -1) {
                        return null;
                    }
                    String strSubstring = str.substring(iArr[0], iIndexOf);
                    iArr[0] = iIndexOf + 1;
                    try {
                        return Class.forName(strSubstring.replace(JsonPointer.SEPARATOR, '.'));
                    } catch (ClassNotFoundException unused) {
                        return null;
                    }
                }
                if (cCharAt == 'Z') {
                    return Boolean.TYPE;
                }
                if (cCharAt == 'I') {
                    return Integer.TYPE;
                }
                if (cCharAt == 'F') {
                    return Float.TYPE;
                }
                if (cCharAt == 'V') {
                    return Void.TYPE;
                }
                if (cCharAt == 'B') {
                    return Byte.TYPE;
                }
                if (cCharAt == 'C') {
                    return Character.TYPE;
                }
                if (cCharAt == 'S') {
                    return Short.TYPE;
                }
                if (cCharAt == 'J') {
                    return Long.TYPE;
                }
                if (cCharAt == 'D') {
                    return Double.TYPE;
                }
                if (cCharAt == '[') {
                    return Array.newInstance((Class<?>) a(str, iArr), 0).getClass();
                }
                AbstractC0086t.Log(5, "! parseType; " + cCharAt + " is not known!");
                return null;
            }
        }
        return null;
    }

    protected static synchronized boolean beginProxyCall(long j) {
        if (j != b) {
            return false;
        }
        c++;
        return true;
    }

    protected static synchronized void endProxyCall() {
        long j = c - 1;
        c = j;
        if (0 == j && d) {
            ReflectionHelper.class.notifyAll();
        }
    }

    protected static synchronized void endUnityLaunch() {
        try {
            b++;
            d = true;
            while (c > 0) {
                ReflectionHelper.class.wait();
            }
        } catch (InterruptedException unused) {
            AbstractC0086t.Log(6, "Interrupted while waiting for all proxies to exit.");
        }
        d = false;
    }

    protected static Object newProxyInstance(UnityPlayer unityPlayer, long j, Class cls) {
        return newProxyInstance(unityPlayer, j, new Class[]{cls});
    }

    protected static Object newProxyInstance(UnityPlayer unityPlayer, long j, Class[] clsArr) {
        return Proxy.newProxyInstance(ReflectionHelper.class.getClassLoader(), clsArr, new C0119o(j, unityPlayer));
    }

    protected static Object createInvocationError(long j, boolean z) {
        return new C0123q(j, z);
    }
}

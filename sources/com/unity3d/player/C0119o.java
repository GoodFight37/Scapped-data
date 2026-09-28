package com.unity3d.player;

import com.unity3d.player.a.AbstractC0086t;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: com.unity3d.player.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0119o implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RunnableC0125r f1111a;
    public final UnityPlayer b;
    public final long c;
    public final /* synthetic */ long d;

    public C0119o(long j, UnityPlayer unityPlayer) {
        this.d = j;
        long j2 = ReflectionHelper.b;
        this.f1111a = new RunnableC0125r(j2, j);
        this.b = unityPlayer;
        this.c = j2;
    }

    public static Object a(Object obj, Method method, Object[] objArr, C0123q c0123q) {
        try {
            if (objArr == null) {
                try {
                    objArr = new Object[0];
                } catch (NoClassDefFoundError unused) {
                    AbstractC0086t.Log(6, "Java interface default methods are only supported since Android Oreo");
                    ReflectionHelper.nativeProxyLogJNIInvokeException(c0123q.f1115a);
                    c0123q.f1115a = 0L;
                    return null;
                }
            }
            Class<?> declaringClass = method.getDeclaringClass();
            Constructor declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
            Object objInvokeWithArguments = ((MethodHandles.Lookup) declaredConstructor.newInstance(declaringClass, 2)).in(declaringClass).unreflectSpecial(method, declaringClass).bindTo(obj).invokeWithArguments(objArr);
            long j = c0123q.f1115a;
            if (j != 0) {
                ReflectionHelper.nativeProxyJNIFreeGCHandle(j);
            }
            return objInvokeWithArguments;
        } catch (Throwable th) {
            long j2 = c0123q.f1115a;
            if (j2 != 0) {
                ReflectionHelper.nativeProxyJNIFreeGCHandle(j2);
            }
            throw th;
        }
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        if (!ReflectionHelper.beginProxyCall(this.c)) {
            AbstractC0086t.Log(6, "Scripting proxy object was destroyed, because Unity player was unloaded.");
            return null;
        }
        try {
            Object objNativeProxyInvoke = ReflectionHelper.nativeProxyInvoke(this.d, method.getName(), objArr);
            if (!(objNativeProxyInvoke instanceof C0123q)) {
                return objNativeProxyInvoke;
            }
            C0123q c0123q = (C0123q) objNativeProxyInvoke;
            if (c0123q.b && (method.getModifiers() & 1024) == 0) {
                return a(obj, method, objArr, c0123q);
            }
            ReflectionHelper.nativeProxyLogJNIInvokeException(c0123q.f1115a);
            return null;
        } finally {
            ReflectionHelper.endProxyCall();
        }
    }

    public void finalize() throws Throwable {
        this.b.invokeOnMainThread(this.f1111a);
        super.finalize();
    }
}

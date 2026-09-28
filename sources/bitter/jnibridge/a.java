package bitter.jnibridge;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class a implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f4a = new Object[0];
    public long b;

    public a(long j) {
        this.b = j;
    }

    public static Object a(Object obj, Method method, Object[] objArr) {
        if (objArr == null) {
            objArr = new Object[0];
        }
        try {
            return MethodHandles.lookup().findSpecial(method.getDeclaringClass(), method.getName(), MethodType.methodType(method.getReturnType(), method.getParameterTypes()), obj.getClass()).bindTo(obj).invokeWithArguments(objArr);
        } catch (Exception e) {
            System.err.println("JNIBridge error calling default method: " + e.getMessage());
            return null;
        }
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        synchronized (this.f4a) {
            long j = this.b;
            if (j == 0) {
                return null;
            }
            try {
                return JNIBridge.invoke(j, method.getDeclaringClass(), method, objArr);
            } catch (NoSuchMethodError e) {
                if (method.isDefault()) {
                    return a(obj, method, objArr);
                }
                System.err.println("JNIBridge error: Java interface default methods are only supported since Android Oreo");
                throw e;
            }
        }
    }
}

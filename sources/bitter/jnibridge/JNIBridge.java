package bitter.jnibridge;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes.dex */
public class JNIBridge {
    static native Object invoke(long j, Class cls, Method method, Object[] objArr);

    static Object newInterfaceProxy(long j, Class[] clsArr) {
        return Proxy.newProxyInstance(JNIBridge.class.getClassLoader(), clsArr, new a(j));
    }

    static void disableInterfaceProxy(Object obj) {
        if (obj != null) {
            a aVar = (a) Proxy.getInvocationHandler(obj);
            synchronized (aVar.f4a) {
                aVar.b = 0L;
            }
        }
    }
}

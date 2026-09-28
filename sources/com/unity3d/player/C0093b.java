package com.unity3d.player;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: com.unity3d.player.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0093b implements InvocationHandler {
    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        if (!"onFailure".equals(method.getName())) {
            return AndroidAppSetIdHelper.defaultProxyResult(obj, method, objArr);
        }
        AndroidAppSetIdHelper.nativeOnAndroidAppSetIdResult(null);
        return null;
    }
}

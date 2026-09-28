package com.adjust.sdk.sig;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public abstract class l2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m2 f145a;

    static {
        m2 m2Var;
        try {
            m2Var = (m2) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
            m2Var = null;
        }
        if (m2Var == null) {
            m2Var = new m2();
        }
        f145a = m2Var;
    }
}

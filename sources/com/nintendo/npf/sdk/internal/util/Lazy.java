package com.nintendo.npf.sdk.internal.util;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Lazy<T> {
    private static final Object b = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Object f883a = b;

    public T get() {
        T tInitializeField;
        T t = (T) this.f883a;
        Object obj = b;
        if (t != obj) {
            return t;
        }
        synchronized (this) {
            tInitializeField = (T) this.f883a;
            if (tInitializeField == obj) {
                tInitializeField = initializeField();
                this.f883a = tInitializeField;
            }
        }
        return tInitializeField;
    }

    protected abstract T initializeField();
}

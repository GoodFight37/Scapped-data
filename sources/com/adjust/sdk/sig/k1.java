package com.adjust.sdk.sig;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k1 {
    public static final j1 b = new j1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n1 f141a;

    public k1(n1 n1Var) {
        this.f141a = n1Var;
        new ConcurrentHashMap(16);
    }
}

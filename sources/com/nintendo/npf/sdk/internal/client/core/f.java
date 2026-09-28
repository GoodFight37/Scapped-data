package com.nintendo.npf.sdk.internal.client.core;

import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public interface f {

    public static final class a extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f774a;
        private final String b;

        public a(int i, String str) {
            this.f774a = i;
            this.b = str;
        }

        public final String a() {
            return this.b;
        }

        public final int b() {
            return this.f774a;
        }
    }

    Object a(String str, Continuation continuation);

    boolean a(long j, long j2);
}

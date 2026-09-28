package com.nintendo.npf.sdk.core;

import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public interface h4 {

    public static final class a extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f473a;
        private final String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, String message) {
            super(message);
            Intrinsics.checkNotNullParameter(message, "message");
            this.f473a = i;
            this.b = message;
        }

        public final int a() {
            return this.f473a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f473a == aVar.f473a && Intrinsics.areEqual(this.b, aVar.b);
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.b;
        }

        public int hashCode() {
            return (Integer.hashCode(this.f473a) * 31) + this.b.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "PublishResponseError(code=" + this.f473a + ", message=" + this.b + ')';
        }
    }

    Object a(String str, String str2, List list, Continuation continuation);
}

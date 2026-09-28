package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.NPFError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public interface o1 {

    public static final class a implements o1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final NPFError f532a;

        public a(NPFError value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.f532a = value;
        }

        public final NPFError a() {
            return this.f532a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.areEqual(this.f532a, ((a) obj).f532a);
        }

        public int hashCode() {
            return this.f532a.hashCode();
        }

        public String toString() {
            return "Error(value=" + this.f532a + ')';
        }
    }

    public static final class b implements o1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final p1 f533a;

        public b(p1 value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.f533a = value;
        }

        public final p1 a() {
            return this.f533a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Intrinsics.areEqual(this.f533a, ((b) obj).f533a);
        }

        public int hashCode() {
            return this.f533a.hashCode();
        }

        public String toString() {
            return "Success(value=" + this.f533a + ')';
        }
    }
}

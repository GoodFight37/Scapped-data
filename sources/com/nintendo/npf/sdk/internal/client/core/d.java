package com.nintendo.npf.sdk.internal.client.core;

import com.nintendo.npf.sdk.NPFException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final NPFException f769a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(NPFException exception) {
            super(null);
            Intrinsics.checkNotNullParameter(exception, "exception");
            this.f769a = exception;
        }

        public final NPFException a() {
            return this.f769a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.areEqual(this.f769a, ((a) obj).f769a);
        }

        public int hashCode() {
            return this.f769a.hashCode();
        }

        public String toString() {
            return "Failure(exception=" + this.f769a + ')';
        }
    }

    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f770a;

        public b(Object obj) {
            super(null);
            this.f770a = obj;
        }

        public final Object a() {
            return this.f770a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Intrinsics.areEqual(this.f770a, ((b) obj).f770a);
        }

        public int hashCode() {
            Object obj = this.f770a;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public String toString() {
            return "Success(data=" + this.f770a + ')';
        }
    }

    public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private d() {
    }
}

package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFSDK;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile NPFSDK.EventHandler f440a;
    private final List b = new ArrayList();
    private final Object c = new Object();

    private static abstract class a {

        /* JADX INFO: renamed from: com.nintendo.npf.sdk.core.e4$a$a, reason: collision with other inner class name */
        public static final class C0031a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final NPFError f441a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0031a(NPFError error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.f441a = error;
            }

            public final NPFError a() {
                return this.f441a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0031a) && Intrinsics.areEqual(this.f441a, ((C0031a) obj).f441a);
            }

            public int hashCode() {
                return this.f441a.hashCode();
            }

            public String toString() {
                return "NintendoAccountAuthError(error=" + this.f441a + ')';
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f442a = new b();

            private b() {
                super(null);
            }
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f443a = new c();

            private c() {
                super(null);
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public final NPFSDK.EventHandler a() {
        return this.f440a;
    }

    public final void b() {
        a(a.b.f442a);
    }

    public final void c() {
        a(a.c.f443a);
    }

    public final void a(NPFSDK.EventHandler eventHandler) {
        List<a> listEmptyList;
        synchronized (this.c) {
            this.f440a = eventHandler;
            if (eventHandler != null) {
                listEmptyList = CollectionsKt.toList(this.b);
                this.b.clear();
            } else {
                listEmptyList = CollectionsKt.emptyList();
            }
        }
        for (a aVar : listEmptyList) {
            if (eventHandler != null) {
                a(eventHandler, aVar);
            }
        }
    }

    public final void a(NPFError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        a(new a.C0031a(error));
    }

    private final void a(a aVar) {
        NPFSDK.EventHandler eventHandler;
        NPFSDK.EventHandler eventHandler2 = this.f440a;
        if (eventHandler2 != null) {
            a(eventHandler2, aVar);
            return;
        }
        synchronized (this.c) {
            if (this.f440a == null) {
                this.b.add(aVar);
                eventHandler = null;
            } else {
                eventHandler = this.f440a;
            }
        }
        if (eventHandler != null) {
            a(eventHandler, aVar);
        }
    }

    private final void a(NPFSDK.EventHandler eventHandler, a aVar) {
        if (aVar instanceof a.b) {
            eventHandler.onPendingAuthorizationByNintendoAccount2();
        } else if (aVar instanceof a.c) {
            eventHandler.onPendingSwitchByNintendoAccount2();
        } else if (aVar instanceof a.C0031a) {
            eventHandler.onNintendoAccountAuthError(((a.C0031a) aVar).a());
        }
    }
}

package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.audit.ProfanityWord;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f466a = new a(null);
    private static final String b = "g4";
    private static final List c = new ArrayList();

    public static final class a {

        /* JADX INFO: renamed from: com.nintendo.npf.sdk.core.g4$a$a, reason: collision with other inner class name */
        static final class C0032a extends Lambda implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Function2 f467a;
            final /* synthetic */ List b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0032a(Function2 function2, List list) {
                super(0);
                this.f467a = function2;
                this.b = list;
            }

            public final void a() {
                this.f467a.invoke(this.b, null);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(ProfanityWord profanityWord, Function2 callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            SDKLog.i(g4.b, "echo is called");
            callback.invoke(profanityWord, null);
        }

        private a() {
        }

        public final void a(List list, Function2 callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            SDKLog.i(g4.b, "multiEcho is called");
            g4.c.add(new C0032a(callback, list));
            if (g4.c.size() >= 3) {
                ((Function0) g4.c.get(1)).invoke();
                ((Function0) g4.c.get(2)).invoke();
                ((Function0) g4.c.get(0)).invoke();
                g4.c.clear();
            }
        }
    }
}

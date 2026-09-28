package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.audit.AuditService;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.domain.repository.BaasAccountRepository;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.user.BaaSUser;
import java.util.List;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public final class z implements AuditService {
    public static final a c = new a(null);
    private static final String d = "z";
    private static final f4 e = new f4();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BaasAccountRepository f629a;
    private final ErrorFactory b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ r0 f630a;
        final /* synthetic */ z b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(r0 r0Var, z zVar) {
            super(1);
            this.f630a = r0Var;
            this.b = zVar;
        }

        public final void a(JSONArray jSONArray) {
            try {
                List<Object> listFromJSON = z.e.fromJSON(jSONArray);
                Intrinsics.checkNotNullExpressionValue(listFromJSON, "mapper.fromJSON(response)");
                this.f630a.a(listFromJSON, (NPFError) null);
            } catch (JSONException e) {
                this.f630a.a((Object) null, this.b.b.create_Mapper_InvalidJson_422(e));
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((JSONArray) obj);
            return Unit.INSTANCE;
        }
    }

    static final class c extends Lambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2 f631a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Function2 function2) {
            super(2);
            this.f631a = function2;
        }

        public final void a(List list, NPFError nPFError) {
            Function2 function2 = this.f631a;
            if (function2 != null) {
                function2.invoke(list, nPFError);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((List) obj, (NPFError) obj2);
            return Unit.INSTANCE;
        }
    }

    static final class d implements u2, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function2 f632a;

        d(Function2 function) {
            Intrinsics.checkNotNullParameter(function, "function");
            this.f632a = function;
        }

        @Override // com.nintendo.npf.sdk.core.u2
        public final /* synthetic */ void a(JSONArray jSONArray, NPFError nPFError) {
            this.f632a.invoke(jSONArray, nPFError);
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof u2) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function getFunctionDelegate() {
            return this.f632a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }
    }

    public z(BaasAccountRepository baasAccountRepository, ErrorFactory errorFactory) {
        Intrinsics.checkNotNullParameter(baasAccountRepository, "baasAccountRepository");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        this.f629a = baasAccountRepository;
        this.b = errorFactory;
    }

    @Override // com.nintendo.npf.sdk.audit.AuditService
    public void checkProfanityWord(List list, Function2 function2) {
        SDKLog.i(d, "checkProfanityWord is called");
        BaaSUser currentBaasUser = this.f629a.getCurrentBaasUser();
        if (!h0.c(currentBaasUser)) {
            if (function2 != null) {
                function2.invoke(null, this.b.create_BaasAccount_NotLoggedIn_401());
            }
        } else if (list == null || list.isEmpty()) {
            if (function2 != null) {
                function2.invoke(null, this.b.create_InvalidParameters_400());
            }
        } else {
            JSONArray json = e.toJSON((List<Object>) list);
            Intrinsics.checkNotNullExpressionValue(json, "mapper.toJSON(profanityWords)");
            r0 r0VarA = r0.b.a(new c(function2));
            g0.a().a(currentBaasUser, json, new d(r0VarA.a(new b(r0VarA, this))));
        }
    }
}

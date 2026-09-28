package com.nintendo.npf.sdk.core;

import android.util.Base64;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.user.BaaSUser;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class u implements t {
    public static final a j = new a(null);
    private static final String k = "u";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h4 f578a;
    private final CoroutineDispatcher b;
    private final CoroutineScope c;
    private final Function0 d;
    private final Function2 e;
    private final Function5 f;
    private boolean g;
    private int h;
    private int i;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends SuspendLambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f579a;
        final /* synthetic */ Map c;
        final /* synthetic */ String d;
        final /* synthetic */ i e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Map map, String str, i iVar, Continuation continuation) {
            super(2, continuation);
            this.c = map;
            this.d = str;
            this.e = iVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return u.this.new b(this.c, this.d, this.e, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objA;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f579a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                List listA = u.this.a(this.c, this.d, this.e);
                h4 h4Var = u.this.f578a;
                String strA = this.e.a();
                if (strA == null) {
                    strA = "";
                }
                String strJ = this.e.j();
                if (strJ == null) {
                    strJ = "";
                }
                List list = CollectionsKt.toList(listA);
                this.f579a = 1;
                objA = h4Var.a(strA, strJ, list, this);
                if (objA == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objA = ((Result) obj).getValue();
            }
            u uVar = u.this;
            Map map = this.c;
            if (Result.m255isSuccessimpl(objA)) {
                uVar.e.invoke(uVar, map);
            }
            u uVar2 = u.this;
            Map map2 = this.c;
            i iVar = this.e;
            Throwable thM251exceptionOrNullimpl = Result.m251exceptionOrNullimpl(objA);
            if (thM251exceptionOrNullimpl != null) {
                if (thM251exceptionOrNullimpl instanceof h4.a) {
                    h4.a aVar = (h4.a) thM251exceptionOrNullimpl;
                    uVar2.f.invoke(uVar2, map2, Boxing.boxInt(aVar.a()), aVar.getMessage(), iVar);
                } else if (thM251exceptionOrNullimpl instanceof IOException) {
                    Function5 function5 = uVar2.f;
                    Integer numBoxInt = Boxing.boxInt(0);
                    String message = thM251exceptionOrNullimpl.getMessage();
                    function5.invoke(uVar2, map2, numBoxInt, message == null ? "" : message, iVar);
                }
            }
            return Unit.INSTANCE;
        }
    }

    public u(h4 publishClient, CoroutineDispatcher dispatcher, CoroutineScope scope, Function0 analyticsConfigProvider, Function2 handlePublicationSuccess, Function5 handlePublicationError) {
        Intrinsics.checkNotNullParameter(publishClient, "publishClient");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(analyticsConfigProvider, "analyticsConfigProvider");
        Intrinsics.checkNotNullParameter(handlePublicationSuccess, "handlePublicationSuccess");
        Intrinsics.checkNotNullParameter(handlePublicationError, "handlePublicationError");
        this.f578a = publishClient;
        this.b = dispatcher;
        this.c = scope;
        this.d = analyticsConfigProvider;
        this.e = handlePublicationSuccess;
        this.f = handlePublicationError;
    }

    public final int b() {
        return this.h;
    }

    public final void a(boolean z) {
        this.g = z;
    }

    public final void b(int i) {
        this.h = i;
    }

    public final int a() {
        return this.i;
    }

    public final void a(int i) {
        this.i = i;
    }

    @Override // com.nintendo.npf.sdk.core.t
    public boolean a(Map events, BaaSUser user) {
        String accessToken;
        Intrinsics.checkNotNullParameter(events, "events");
        Intrinsics.checkNotNullParameter(user, "user");
        if (this.g) {
            return false;
        }
        i iVar = (i) this.d.invoke();
        if (!k.a(iVar) || (accessToken = user.getAccessToken()) == null || accessToken.length() == 0) {
            return false;
        }
        this.g = true;
        BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new b(events, accessToken, iVar, null), 3, null);
        return true;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ u(h4 h4Var, CoroutineDispatcher coroutineDispatcher, CoroutineScope coroutineScope, Function0 function0, Function2 function2, Function5 function5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        CoroutineDispatcher coroutineDispatcher2 = (i & 2) != 0 ? Dispatchers.getDefault() : coroutineDispatcher;
        this(h4Var, coroutineDispatcher2, (i & 4) != 0 ? CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(coroutineDispatcher2)) : coroutineScope, function0, function2, function5);
    }

    private final String a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr);
            String strEncodeToString = Base64.encodeToString(messageDigest.digest(), 2);
            Intrinsics.checkNotNullExpressionValue(strEncodeToString, "{\n            val md = M…Base64.NO_WRAP)\n        }");
            return strEncodeToString;
        } catch (NoSuchAlgorithmException e) {
            SDKLog.e(k, "Does not support SHA-256", e);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List a(Map map, String str, i iVar) {
        ArrayList arrayList = new ArrayList(map.size());
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            JSONObject jSONObject = (JSONObject) ((Map.Entry) it.next()).getValue();
            try {
                jSONObject.put("applicationId", iVar.c());
                JSONObject jSONObject2 = jSONObject.getJSONObject("cacheInfo");
                jSONObject2.put("country", iVar.e());
                jSONObject2.put("region", iVar.h());
                jSONObject2.put("city", iVar.d());
            } catch (JSONException e) {
                SDKLog.w(k, e.getMessage());
            }
            String string = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(string, "event.toString()");
            byte[] bytes = string.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            Map mapMapOf = MapsKt.mapOf(TuplesKt.to("ID_LABEL_ANALYTICS_EVENTS_V02", a(bytes)), TuplesKt.to("AUTHORIZATION", str));
            String strEncodeToString = Base64.encodeToString(bytes, 2);
            Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(data, Base64.NO_WRAP)");
            arrayList.add(new k4(strEncodeToString, mapMapOf));
        }
        return arrayList;
    }
}

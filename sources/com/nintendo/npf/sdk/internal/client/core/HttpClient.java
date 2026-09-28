package com.nintendo.npf.sdk.internal.client.core;

import androidx.core.app.FrameMetricsAggregator;
import com.adjust.sdk.Constants;
import com.google.android.gms.actions.SearchIntents;
import com.google.api.client.http.HttpMethods;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFException;
import com.nintendo.npf.sdk.core.b2;
import com.nintendo.npf.sdk.core.c2;
import com.nintendo.npf.sdk.core.d2;
import com.nintendo.npf.sdk.core.e2;
import com.nintendo.npf.sdk.core.r4;
import com.nintendo.npf.sdk.core.u0;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 @2\u00020\u0001:\u0001\u001fBU\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014Jo\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00172\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00172\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001f\u0010 J1\u0010\u001f\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010!2\u0006\u0010\"\u001a\u00020\u001e2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010%J\u001b\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001eH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010&JU\u0010\u001f\u001a\u00020)2\u0006\u0010\u0016\u001a\u00020\u00052\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00172\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00172\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b\u001f\u0010*Jm\u0010\u001f\u001a\u00020)2\u0006\u0010\u0016\u001a\u00020\u00052\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00172\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00172\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b\u001f\u0010+Ja\u0010,\u001a\u00020)2\u0006\u0010\u0016\u001a\u00020\u00052\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00172\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00172\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b,\u0010-Ja\u0010\u001f\u001a\u00020)2\u0006\u0010\u0016\u001a\u00020\u00052\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00172\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00172\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b\u001f\u0010-Ju\u0010\u001f\u001a\u00020.2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00172\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00172\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b\u001f\u0010/Ji\u0010\u001f\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010!2\u0006\u0010\u0016\u001a\u00020\u00052\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00172\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00172\u0006\u0010\u001d\u001a\u00020\u00032\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001f\u00100J\u0081\u0001\u0010\u001f\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010!2\u0006\u0010\u0016\u001a\u00020\u00052\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00172\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00172\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u00032\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001f\u00101J\u0089\u0001\u0010\u001f\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010!2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00172\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00172\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u00032\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001f\u00102R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u00103R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u00103R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006A"}, d2 = {"Lcom/nintendo/npf/sdk/internal/client/core/HttpClient;", "", "Lkotlin/Function0;", "", "isUsingHttp", "", "host", "Lcom/nintendo/npf/sdk/domain/ErrorFactory;", "errorFactory", "Lcom/nintendo/npf/sdk/core/d2;", "httpRequestFactory", "Lcom/nintendo/npf/sdk/domain/datafacade/DeviceDataFacade;", "deviceDataFacade", "Lcom/nintendo/npf/sdk/core/u0;", "configurationDataFacade", "Lcom/nintendo/npf/sdk/internal/client/core/f;", "retryAuth", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/nintendo/npf/sdk/domain/ErrorFactory;Lcom/nintendo/npf/sdk/core/d2;Lcom/nintendo/npf/sdk/domain/datafacade/DeviceDataFacade;Lcom/nintendo/npf/sdk/core/u0;Lcom/nintendo/npf/sdk/internal/client/core/f;Lkotlinx/coroutines/CoroutineScope;)V", FirebaseAnalytics.Param.METHOD, "path", "", "headers", SearchIntents.EXTRA_QUERY, "", "body", "contentType", "retry", "Lcom/nintendo/npf/sdk/internal/client/core/c;", "a", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;[BLjava/lang/String;Z)Lcom/nintendo/npf/sdk/internal/client/core/c;", "T", "requestParams", "Lcom/nintendo/npf/sdk/internal/client/core/e;", "responseConverter", "(Lcom/nintendo/npf/sdk/internal/client/core/c;Lcom/nintendo/npf/sdk/internal/client/core/e;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lcom/nintendo/npf/sdk/internal/client/core/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/nintendo/npf/sdk/core/r4;", "callback", "", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;ZLcom/nintendo/npf/sdk/core/r4;)V", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;[BLjava/lang/String;ZLcom/nintendo/npf/sdk/core/r4;)V", "b", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;[BZLcom/nintendo/npf/sdk/core/r4;)V", "Lkotlinx/coroutines/Job;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;[BLjava/lang/String;ZLcom/nintendo/npf/sdk/core/r4;)Lkotlinx/coroutines/Job;", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;ZLcom/nintendo/npf/sdk/internal/client/core/e;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;[BLjava/lang/String;ZLcom/nintendo/npf/sdk/internal/client/core/e;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;[BLjava/lang/String;ZLcom/nintendo/npf/sdk/internal/client/core/e;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/jvm/functions/Function0;", "c", "Lcom/nintendo/npf/sdk/domain/ErrorFactory;", "d", "Lcom/nintendo/npf/sdk/core/d2;", "e", "Lcom/nintendo/npf/sdk/domain/datafacade/DeviceDataFacade;", "f", "Lcom/nintendo/npf/sdk/core/u0;", "g", "Lcom/nintendo/npf/sdk/internal/client/core/f;", "h", "Lkotlinx/coroutines/CoroutineScope;", "i", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HttpClient {
    private static final String j = "HttpClient";

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Function0 isUsingHttp;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Function0 host;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final ErrorFactory errorFactory;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final d2 httpRequestFactory;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final DeviceDataFacade deviceDataFacade;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final u0 configurationDataFacade;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final f retryAuth;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final CoroutineScope scope;

    static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f761a;
        Object b;
        /* synthetic */ Object c;
        int e;

        b(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return HttpClient.this.a(null, this);
        }
    }

    static final class c extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f762a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        c(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return HttpClient.this.a((com.nintendo.npf.sdk.internal.client.core.c) null, (e) null, this);
        }
    }

    static final class d extends SuspendLambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f763a;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ Map e;
        final /* synthetic */ Map f;
        final /* synthetic */ byte[] g;
        final /* synthetic */ String h;
        final /* synthetic */ boolean i;
        final /* synthetic */ r4 j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, String str2, Map map, Map map2, byte[] bArr, String str3, boolean z, r4 r4Var, Continuation continuation) {
            super(2, continuation);
            this.c = str;
            this.d = str2;
            this.e = map;
            this.f = map2;
            this.g = bArr;
            this.h = str3;
            this.i = z;
            this.j = r4Var;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return HttpClient.this.new d(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f763a;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    HttpClient httpClient = HttpClient.this;
                    String str = this.c;
                    String str2 = this.d;
                    Map map = this.e;
                    Map map2 = this.f;
                    byte[] bArr = this.g;
                    String str3 = this.h;
                    boolean z = this.i;
                    e eVarA = com.nintendo.npf.sdk.internal.client.core.b.a(this.j);
                    this.f763a = 1;
                    obj = httpClient.a(str, str2, map, map2, bArr, str3, z, eVarA, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                com.nintendo.npf.sdk.internal.client.core.b.a(this.j, new com.nintendo.npf.sdk.internal.client.core.d.b(obj));
            } catch (NPFException e) {
                com.nintendo.npf.sdk.internal.client.core.b.a(this.j, new com.nintendo.npf.sdk.internal.client.core.d.a(e));
            }
            return Unit.INSTANCE;
        }
    }

    public HttpClient(Function0 isUsingHttp, Function0 host, ErrorFactory errorFactory, d2 httpRequestFactory, DeviceDataFacade deviceDataFacade, u0 configurationDataFacade, f retryAuth, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(isUsingHttp, "isUsingHttp");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        Intrinsics.checkNotNullParameter(httpRequestFactory, "httpRequestFactory");
        Intrinsics.checkNotNullParameter(deviceDataFacade, "deviceDataFacade");
        Intrinsics.checkNotNullParameter(configurationDataFacade, "configurationDataFacade");
        Intrinsics.checkNotNullParameter(retryAuth, "retryAuth");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.isUsingHttp = isUsingHttp;
        this.host = host;
        this.errorFactory = errorFactory;
        this.httpRequestFactory = httpRequestFactory;
        this.deviceDataFacade = deviceDataFacade;
        this.configurationDataFacade = configurationDataFacade;
        this.retryAuth = retryAuth;
        this.scope = scope;
    }

    public final void b(String path, Map headers, Map query, byte[] body, boolean retry, r4 callback) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(callback, "callback");
        a(HttpMethods.PUT, path, headers, query, body, "application/json", retry, callback);
    }

    public final void a(String path, Map headers, Map query, boolean retry, r4 callback) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(callback, "callback");
        a(this, "GET", path, headers, query, (byte[]) null, (String) null, retry, callback, 48, (Object) null);
    }

    public final void a(String path, Map headers, Map query, byte[] body, String contentType, boolean retry, r4 callback) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(callback, "callback");
        a("POST", path, headers, query, body, contentType, retry, callback);
    }

    public final void a(String path, Map headers, Map query, byte[] body, boolean retry, r4 callback) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(callback, "callback");
        a(HttpMethods.PATCH, path, headers, query, body, "application/json-patch+json", retry, callback);
    }

    public static /* synthetic */ Job a(HttpClient httpClient, String str, String str2, Map map, Map map2, byte[] bArr, String str3, boolean z, r4 r4Var, int i, Object obj) {
        return httpClient.a(str, str2, (i & 4) != 0 ? null : map, (i & 8) != 0 ? null : map2, (i & 16) != 0 ? null : bArr, (i & 32) != 0 ? null : str3, z, r4Var);
    }

    public final Job a(String method, String path, Map headers, Map query, byte[] body, String contentType, boolean retry, r4 callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new d(method, path, headers, query, body, contentType, retry, callback, null), 3, null);
    }

    public final Object a(String str, Map map, Map map2, boolean z, e eVar, Continuation continuation) {
        return a(this, "GET", str, map, map2, null, null, z, eVar, continuation, 48, null);
    }

    public final Object a(String str, Map map, Map map2, byte[] bArr, String str2, boolean z, e eVar, Continuation continuation) {
        return a("POST", str, map, map2, bArr, str2, z, eVar, continuation);
    }

    public static /* synthetic */ Object a(HttpClient httpClient, String str, String str2, Map map, Map map2, byte[] bArr, String str3, boolean z, e eVar, Continuation continuation, int i, Object obj) {
        return httpClient.a(str, str2, (i & 4) != 0 ? null : map, (i & 8) != 0 ? null : map2, (i & 16) != 0 ? null : bArr, (i & 32) != 0 ? null : str3, z, eVar, continuation);
    }

    public final Object a(String str, String str2, Map map, Map map2, byte[] bArr, String str3, boolean z, e eVar, Continuation continuation) {
        return a(a(str, str2, map, map2, bArr, str3, z), eVar, continuation);
    }

    private final com.nintendo.npf.sdk.internal.client.core.c a(String method, String path, Map headers, Map query, byte[] body, String contentType, boolean retry) {
        Map linkedHashMap;
        if (headers == null || (linkedHashMap = MapsKt.toMutableMap(headers)) == null) {
            linkedHashMap = new LinkedHashMap();
        }
        linkedHashMap.putAll(b2.a(this.deviceDataFacade));
        if (!linkedHashMap.containsKey(HttpHeaders.ACCEPT_LANGUAGE)) {
            linkedHashMap.putAll(b2.a(this.deviceDataFacade.getLanguage()));
            SDKLog.d(j, "Accept-Language: " + ((String) linkedHashMap.get(HttpHeaders.ACCEPT_LANGUAGE)));
        }
        return new com.nintendo.npf.sdk.internal.client.core.c.a().c(method).e(((Boolean) this.isUsingHttp.invoke()).booleanValue() ? "http" : Constants.SCHEME).b((String) this.host.invoke()).d(path).a(linkedHashMap).b(query).a(contentType).a(body).a(retry).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:35:0x00cb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    public final Object a(com.nintendo.npf.sdk.internal.client.core.c cVar, e eVar, Continuation continuation) {
        c cVar2;
        Object obj;
        HttpClient httpClient;
        e eVar2;
        HttpClient httpClient2;
        Object objA;
        e2 e2Var;
        int iB;
        e eVar3;
        HttpClient httpClient3;
        com.nintendo.npf.sdk.internal.client.core.c cVar3 = cVar;
        e eVar4 = eVar;
        if (continuation instanceof c) {
            cVar2 = (c) continuation;
            int i = cVar2.f;
            if ((i & Integer.MIN_VALUE) != 0) {
                cVar2.f = i - Integer.MIN_VALUE;
            } else {
                cVar2 = new c(continuation);
            }
        } else {
            cVar2 = new c(continuation);
        }
        Object objA2 = cVar2.d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = cVar2.f;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA2);
            if (this.retryAuth.a(System.currentTimeMillis(), 10000L) && cVar3.j) {
                cVar2.f762a = this;
                cVar2.b = eVar4;
                cVar2.f = 1;
                objA2 = a(cVar3, cVar2);
                if (objA2 != coroutine_suspended) {
                    eVar2 = eVar4;
                    httpClient2 = this;
                    com.nintendo.npf.sdk.internal.client.core.c cVar4 = (com.nintendo.npf.sdk.internal.client.core.c) objA2;
                    com.nintendo.npf.sdk.internal.client.core.c cVarA = cVar4.a((FrameMetricsAggregator.EVERY_DURATION & 1) != 0 ? cVar4.f767a : null, (FrameMetricsAggregator.EVERY_DURATION & 2) != 0 ? cVar4.b : null, (FrameMetricsAggregator.EVERY_DURATION & 4) != 0 ? cVar4.c : null, (FrameMetricsAggregator.EVERY_DURATION & 8) != 0 ? cVar4.d : null, (FrameMetricsAggregator.EVERY_DURATION & 16) != 0 ? cVar4.e : null, (FrameMetricsAggregator.EVERY_DURATION & 32) != 0 ? cVar4.f : null, (FrameMetricsAggregator.EVERY_DURATION & 64) != 0 ? cVar4.g : null, (FrameMetricsAggregator.EVERY_DURATION & 128) != 0 ? cVar4.h : null, (FrameMetricsAggregator.EVERY_DURATION & 256) != 0 ? cVar4.i : null, (FrameMetricsAggregator.EVERY_DURATION & 512) != 0 ? cVar4.j : false);
                    cVar2.f762a = null;
                    cVar2.b = null;
                    cVar2.f = 2;
                    objA = httpClient2.a(cVarA, eVar2, cVar2);
                    if (objA == coroutine_suspended) {
                        return objA;
                    }
                }
            } else {
                c2 c2VarA = this.httpRequestFactory.a(cVar3, this.configurationDataFacade.b(), this.configurationDataFacade.a());
                cVar2.f762a = this;
                cVar2.b = cVar3;
                cVar2.c = eVar4;
                cVar2.f = 3;
                Object objA3 = c2VarA.a(cVar2);
                if (objA3 != coroutine_suspended) {
                    obj = objA3;
                    httpClient = this;
                    e2Var = (e2) obj;
                    if (e2Var.b() != 401) {
                    }
                    iB = e2Var.b();
                    if (200 > iB) {
                    }
                    NPFError nPFErrorCreate_HttpClient_InvalidRequest = httpClient.errorFactory.create_HttpClient_InvalidRequest(e2Var.b(), e2Var.a());
                    Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_HttpClient_InvalidRequest, "errorFactory.create_Http…tatusCode, response.body)");
                    throw new NPFException(nPFErrorCreate_HttpClient_InvalidRequest);
                }
            }
        } else if (i2 == 1) {
            eVar2 = (e) cVar2.b;
            httpClient2 = (HttpClient) cVar2.f762a;
            ResultKt.throwOnFailure(objA2);
            com.nintendo.npf.sdk.internal.client.core.c cVar5 = (com.nintendo.npf.sdk.internal.client.core.c) objA2;
            com.nintendo.npf.sdk.internal.client.core.c cVarA2 = cVar5.a((FrameMetricsAggregator.EVERY_DURATION & 1) != 0 ? cVar5.f767a : null, (FrameMetricsAggregator.EVERY_DURATION & 2) != 0 ? cVar5.b : null, (FrameMetricsAggregator.EVERY_DURATION & 4) != 0 ? cVar5.c : null, (FrameMetricsAggregator.EVERY_DURATION & 8) != 0 ? cVar5.d : null, (FrameMetricsAggregator.EVERY_DURATION & 16) != 0 ? cVar5.e : null, (FrameMetricsAggregator.EVERY_DURATION & 32) != 0 ? cVar5.f : null, (FrameMetricsAggregator.EVERY_DURATION & 64) != 0 ? cVar5.g : null, (FrameMetricsAggregator.EVERY_DURATION & 128) != 0 ? cVar5.h : null, (FrameMetricsAggregator.EVERY_DURATION & 256) != 0 ? cVar5.i : null, (FrameMetricsAggregator.EVERY_DURATION & 512) != 0 ? cVar5.j : false);
            cVar2.f762a = null;
            cVar2.b = null;
            cVar2.f = 2;
            objA = httpClient2.a(cVarA2, eVar2, cVar2);
            if (objA == coroutine_suspended) {
                return objA;
            }
        } else {
            if (i2 == 2) {
                ResultKt.throwOnFailure(objA2);
                return objA2;
            }
            if (i2 == 3) {
                e eVar5 = (e) cVar2.c;
                com.nintendo.npf.sdk.internal.client.core.c cVar6 = (com.nintendo.npf.sdk.internal.client.core.c) cVar2.b;
                HttpClient httpClient4 = (HttpClient) cVar2.f762a;
                ResultKt.throwOnFailure(objA2);
                obj = objA2;
                httpClient = httpClient4;
                eVar4 = eVar5;
                cVar3 = cVar6;
                e2Var = (e2) obj;
                if (e2Var.b() != 401 && cVar3.j) {
                    cVar2.f762a = httpClient;
                    cVar2.b = eVar4;
                    cVar2.c = null;
                    cVar2.f = 4;
                    Object objA4 = httpClient.a(cVar3, cVar2);
                    if (objA4 != coroutine_suspended) {
                        HttpClient httpClient5 = httpClient;
                        objA2 = objA4;
                        eVar3 = eVar4;
                        httpClient3 = httpClient5;
                    }
                } else {
                    iB = e2Var.b();
                    if (200 > iB && iB < 300) {
                        String strA = e2Var.a();
                        if (strA == null || strA.length() == 0) {
                            return null;
                        }
                        try {
                            return eVar4.a(e2Var.a());
                        } catch (JSONException e) {
                            NPFError nPFErrorCreate_Mapper_InvalidJson_422 = httpClient.errorFactory.create_Mapper_InvalidJson_422(e);
                            Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_Mapper_InvalidJson_422, "errorFactory.create_Mapper_InvalidJson_422(e)");
                            throw new NPFException(nPFErrorCreate_Mapper_InvalidJson_422);
                        }
                    }
                    NPFError nPFErrorCreate_HttpClient_InvalidRequest2 = httpClient.errorFactory.create_HttpClient_InvalidRequest(e2Var.b(), e2Var.a());
                    Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_HttpClient_InvalidRequest2, "errorFactory.create_Http…tatusCode, response.body)");
                    throw new NPFException(nPFErrorCreate_HttpClient_InvalidRequest2);
                }
            } else {
                if (i2 != 4) {
                    if (i2 != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(objA2);
                    return objA2;
                }
                eVar3 = (e) cVar2.b;
                httpClient3 = (HttpClient) cVar2.f762a;
                ResultKt.throwOnFailure(objA2);
            }
            com.nintendo.npf.sdk.internal.client.core.c cVar7 = (com.nintendo.npf.sdk.internal.client.core.c) objA2;
            com.nintendo.npf.sdk.internal.client.core.c cVarA3 = cVar7.a((FrameMetricsAggregator.EVERY_DURATION & 1) != 0 ? cVar7.f767a : null, (FrameMetricsAggregator.EVERY_DURATION & 2) != 0 ? cVar7.b : null, (FrameMetricsAggregator.EVERY_DURATION & 4) != 0 ? cVar7.c : null, (FrameMetricsAggregator.EVERY_DURATION & 8) != 0 ? cVar7.d : null, (FrameMetricsAggregator.EVERY_DURATION & 16) != 0 ? cVar7.e : null, (FrameMetricsAggregator.EVERY_DURATION & 32) != 0 ? cVar7.f : null, (FrameMetricsAggregator.EVERY_DURATION & 64) != 0 ? cVar7.g : null, (FrameMetricsAggregator.EVERY_DURATION & 128) != 0 ? cVar7.h : null, (FrameMetricsAggregator.EVERY_DURATION & 256) != 0 ? cVar7.i : null, (FrameMetricsAggregator.EVERY_DURATION & 512) != 0 ? cVar7.j : false);
            cVar2.f762a = null;
            cVar2.b = null;
            cVar2.f = 5;
            Object objA5 = httpClient3.a(cVarA3, eVar3, cVar2);
            if (objA5 != coroutine_suspended) {
                return objA5;
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object a(com.nintendo.npf.sdk.internal.client.core.c cVar, Continuation continuation) {
        b bVar;
        HttpClient httpClient;
        com.nintendo.npf.sdk.internal.client.core.c cVar2;
        Map mapEmptyMap;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i = bVar.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                bVar.e = i - Integer.MIN_VALUE;
            } else {
                bVar = new b(continuation);
            }
        } else {
            bVar = new b(continuation);
        }
        Object objA = bVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = bVar.e;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            try {
                f fVar = this.retryAuth;
                String str = cVar.c;
                bVar.f761a = this;
                bVar.b = cVar;
                bVar.e = 1;
                objA = fVar.a(str, bVar);
                if (objA == coroutine_suspended) {
                    return coroutine_suspended;
                }
                cVar2 = cVar;
                httpClient = this;
            } catch (f.a e) {
                e = e;
                httpClient = this;
                NPFError nPFErrorCreate_HttpClient_InvalidRequest = httpClient.errorFactory.create_HttpClient_InvalidRequest(e.b(), e.a());
                Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_HttpClient_InvalidRequest, "errorFactory.create_Http…atusCode, e.errorMessage)");
                throw new NPFException(nPFErrorCreate_HttpClient_InvalidRequest);
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            com.nintendo.npf.sdk.internal.client.core.c cVar3 = (com.nintendo.npf.sdk.internal.client.core.c) bVar.b;
            httpClient = (HttpClient) bVar.f761a;
            try {
                ResultKt.throwOnFailure(objA);
                cVar2 = cVar3;
            } catch (f.a e2) {
                e = e2;
                NPFError nPFErrorCreate_HttpClient_InvalidRequest2 = httpClient.errorFactory.create_HttpClient_InvalidRequest(e.b(), e.a());
                Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_HttpClient_InvalidRequest2, "errorFactory.create_Http…atusCode, e.errorMessage)");
                throw new NPFException(nPFErrorCreate_HttpClient_InvalidRequest2);
            }
        }
        String str2 = (String) objA;
        if (str2 != null) {
            mapEmptyMap = b2.c(str2);
        } else {
            mapEmptyMap = MapsKt.emptyMap();
        }
        return cVar2.a((FrameMetricsAggregator.EVERY_DURATION & 1) != 0 ? cVar2.f767a : null, (FrameMetricsAggregator.EVERY_DURATION & 2) != 0 ? cVar2.b : null, (FrameMetricsAggregator.EVERY_DURATION & 4) != 0 ? cVar2.c : null, (FrameMetricsAggregator.EVERY_DURATION & 8) != 0 ? cVar2.d : null, (FrameMetricsAggregator.EVERY_DURATION & 16) != 0 ? cVar2.e : null, (FrameMetricsAggregator.EVERY_DURATION & 32) != 0 ? cVar2.f : MapsKt.plus(cVar2.f, mapEmptyMap), (FrameMetricsAggregator.EVERY_DURATION & 64) != 0 ? cVar2.g : null, (FrameMetricsAggregator.EVERY_DURATION & 128) != 0 ? cVar2.h : null, (FrameMetricsAggregator.EVERY_DURATION & 256) != 0 ? cVar2.i : null, (FrameMetricsAggregator.EVERY_DURATION & 512) != 0 ? cVar2.j : false);
    }
}

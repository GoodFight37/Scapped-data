package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade;
import com.nintendo.npf.sdk.internal.client.core.HttpClient;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes2.dex */
public final class a2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a2 f407a = new a2();

    static final class a extends Lambda implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ x4 f408a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(x4 x4Var) {
            super(0);
            this.f408a = x4Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(this.f408a.getHostInformationDataFacade().i());
        }
    }

    private a2() {
    }

    public static final HttpClient a(Function0 host, com.nintendo.npf.sdk.internal.client.core.f retryAuth, x4 locator) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(retryAuth, "retryAuth");
        Intrinsics.checkNotNullParameter(locator, "locator");
        DeviceDataFacade deviceDataFacade = locator.getDeviceDataFacade();
        u0 configurationDataFacade = locator.getConfigurationDataFacade();
        a2 a2Var = f407a;
        a aVar = new a(locator);
        Intrinsics.checkNotNullExpressionValue(deviceDataFacade, "deviceDataFacade");
        Intrinsics.checkNotNullExpressionValue(configurationDataFacade, "configurationDataFacade");
        return a(a2Var, host, aVar, retryAuth, deviceDataFacade, configurationDataFacade, null, null, null, 224, null);
    }

    public static /* synthetic */ HttpClient a(a2 a2Var, Function0 function0, Function0 function1, com.nintendo.npf.sdk.internal.client.core.f fVar, DeviceDataFacade deviceDataFacade, u0 u0Var, ErrorFactory errorFactory, d2 d2Var, CoroutineScope coroutineScope, int i, Object obj) {
        return a2Var.a(function0, function1, fVar, deviceDataFacade, u0Var, (i & 32) != 0 ? new ErrorFactory() : errorFactory, (i & 64) != 0 ? new g1() : d2Var, (i & 128) != 0 ? CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain())) : coroutineScope);
    }

    public final HttpClient a(Function0 host, Function0 isUsingHttp, com.nintendo.npf.sdk.internal.client.core.f retryAuth, DeviceDataFacade deviceDataFacade, u0 configurationDataFacade, ErrorFactory errorFactory, d2 httpRequestFactory, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(isUsingHttp, "isUsingHttp");
        Intrinsics.checkNotNullParameter(retryAuth, "retryAuth");
        Intrinsics.checkNotNullParameter(deviceDataFacade, "deviceDataFacade");
        Intrinsics.checkNotNullParameter(configurationDataFacade, "configurationDataFacade");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        Intrinsics.checkNotNullParameter(httpRequestFactory, "httpRequestFactory");
        Intrinsics.checkNotNullParameter(scope, "scope");
        return new HttpClient(isUsingHttp, host, errorFactory, httpRequestFactory, deviceDataFacade, configurationDataFacade, retryAuth, scope);
    }
}

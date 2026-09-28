package com.nintendo.npf.sdk.core;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes2.dex */
public final class s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0 f558a;
    private final CoroutineDispatcher b;

    static final class a extends SuspendLambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f559a;

        a(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return s1.this.new a(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException, IOException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f559a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo((Context) s1.this.f558a.invoke());
            if (advertisingIdInfo != null) {
                return advertisingIdInfo.getId();
            }
            return null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public s1(Function0 applicationProvider) {
        this(applicationProvider, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(applicationProvider, "applicationProvider");
    }

    public s1(Function0 applicationProvider, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(applicationProvider, "applicationProvider");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.f558a = applicationProvider;
        this.b = ioDispatcher;
    }

    public final Object a(Continuation continuation) {
        return BuildersKt.withContext(this.b, new a(null), continuation);
    }

    public /* synthetic */ s1(Function0 function0, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i & 2) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }
}

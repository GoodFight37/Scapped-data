package com.nintendo.npf.sdk.core;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.batch.BatchRequest;
import com.google.api.client.googleapis.batch.json.JsonBatchCallback;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.pubsub.Pubsub;
import com.google.api.services.pubsub.model.PublishRequest;
import com.google.api.services.pubsub.model.PublishResponse;
import com.google.api.services.pubsub.model.PubsubMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes2.dex */
public final class j4 implements h4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f501a;
    private final CoroutineDispatcher b;

    static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f502a;
        int c;

        a(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.f502a = obj;
            this.c |= Integer.MIN_VALUE;
            Object objA = j4.this.a(null, null, null, this);
            return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Result.m247boximpl(objA);
        }
    }

    static final class b extends SuspendLambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f503a;
        Object b;
        Object c;
        Object d;
        int e;
        final /* synthetic */ List f;
        final /* synthetic */ j4 g;
        final /* synthetic */ String h;
        final /* synthetic */ String i;

        public static final class a extends JsonBatchCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Continuation f504a;

            a(Continuation continuation) {
                this.f504a = continuation;
            }

            @Override // com.google.api.client.googleapis.batch.BatchCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(PublishResponse publishResponse, HttpHeaders httpHeaders) {
                Continuation continuation = this.f504a;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m248constructorimpl(Unit.INSTANCE));
            }

            @Override // com.google.api.client.googleapis.batch.json.JsonBatchCallback
            public void onFailure(GoogleJsonError googleJsonError, HttpHeaders httpHeaders) {
                Continuation continuation = this.f504a;
                int code = googleJsonError != null ? googleJsonError.getCode() : -1;
                String message = googleJsonError != null ? googleJsonError.getMessage() : null;
                if (message == null) {
                    message = "Publish failed. Unknown error returned.";
                }
                h4.a aVar = new h4.a(code, message);
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m248constructorimpl(ResultKt.createFailure(aVar)));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(List list, j4 j4Var, String str, String str2, Continuation continuation) {
            super(2, continuation);
            this.f = list;
            this.g = j4Var;
            this.h = str;
            this.i = str2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new b(this.f, this.g, this.h, this.i, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM248constructorimpl;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.e;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    List<k4> list = this.f;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    for (k4 k4Var : list) {
                        PubsubMessage pubsubMessage = new PubsubMessage();
                        pubsubMessage.setData(k4Var.b());
                        pubsubMessage.setAttributes(k4Var.a());
                        arrayList.add(pubsubMessage);
                    }
                    PublishRequest publishRequest = new PublishRequest();
                    publishRequest.setMessages(arrayList);
                    GoogleCredential googleCredential = new GoogleCredential();
                    googleCredential.setAccessToken(this.h);
                    Pubsub pubsubBuild = new Pubsub.Builder(new NetHttpTransport(), JacksonFactory.getDefaultInstance(), googleCredential).setApplicationName(this.g.f501a).build();
                    BatchRequest batchRequestBatch = pubsubBuild.batch();
                    String str = this.i;
                    this.f503a = publishRequest;
                    this.b = pubsubBuild;
                    this.c = batchRequestBatch;
                    this.d = str;
                    this.e = 1;
                    SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(this));
                    pubsubBuild.projects().topics().publish(str, publishRequest).queue(batchRequestBatch, new a(safeContinuation));
                    batchRequestBatch.execute();
                    Object orThrow = safeContinuation.getOrThrow();
                    if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(this);
                    }
                    if (orThrow == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Result.Companion companion = Result.INSTANCE;
                objM248constructorimpl = Result.m248constructorimpl(Unit.INSTANCE);
            } catch (h4.a e) {
                Result.Companion companion2 = Result.INSTANCE;
                objM248constructorimpl = Result.m248constructorimpl(ResultKt.createFailure(e));
            } catch (IOException e2) {
                Result.Companion companion3 = Result.INSTANCE;
                objM248constructorimpl = Result.m248constructorimpl(ResultKt.createFailure(e2));
            }
            return Result.m247boximpl(objM248constructorimpl);
        }
    }

    public j4(String applicationName, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(applicationName, "applicationName");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.f501a = applicationName;
        this.b = ioDispatcher;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.nintendo.npf.sdk.core.h4
    public Object a(String str, String str2, List list, Continuation continuation) throws Throwable {
        a aVar;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.c;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.c = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object objWithContext = aVar.f502a;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.c;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            CoroutineDispatcher coroutineDispatcher = this.b;
            b bVar = new b(list, this, str, str2, null);
            aVar.c = 1;
            objWithContext = BuildersKt.withContext(coroutineDispatcher, bVar, aVar);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        return ((Result) objWithContext).getValue();
    }

    public /* synthetic */ j4(String str, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }
}

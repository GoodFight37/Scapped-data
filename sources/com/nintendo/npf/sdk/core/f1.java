package com.nintendo.npf.sdk.core;

import com.google.api.client.googleapis.MethodOverride;
import com.google.common.net.HttpHeaders;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.YieldKt;

/* JADX INFO: loaded from: classes2.dex */
public final class f1 implements c2 {
    public static final a f = new a(null);
    private static final String g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.nintendo.npf.sdk.internal.client.core.c f453a;
    private final int b;
    private final int c;
    private final CoroutineDispatcher d;
    private final CoroutineDispatcher e;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    private static final class b extends CancellationException {
    }

    static final class c extends SuspendLambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f454a;
        private /* synthetic */ Object b;

        static final class a extends SuspendLambda implements Function2 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f455a;
            final /* synthetic */ f1 b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(f1 f1Var, Continuation continuation) {
                super(2, continuation);
                this.b = f1Var;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new a(this.b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f455a;
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                f1 f1Var = this.b;
                this.f455a = 1;
                Object objB = f1Var.b(this);
                return objB == coroutine_suspended ? coroutine_suspended : objB;
            }
        }

        static final class b extends SuspendLambda implements Function2 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f456a;
            final /* synthetic */ f1 b;
            final /* synthetic */ Deferred c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(f1 f1Var, Deferred deferred, Continuation continuation) {
                super(2, continuation);
                this.b = f1Var;
                this.c = deferred;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new b(this.b, this.c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f456a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    long j = this.b.b;
                    this.f456a = 1;
                    if (DelayKt.delay(j, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                if (this.c.isActive()) {
                    this.c.cancel((CancellationException) new b());
                }
                return Unit.INSTANCE;
            }
        }

        c(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            c cVar = f1.this.new c(continuation);
            cVar.b = obj;
            return cVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v1, types: [kotlinx.coroutines.Job] */
        /* JADX WARN: Type inference failed for: r0v3 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Job job;
            ?? coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f454a;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.b;
                    Deferred deferredAsync$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new a(f1.this, null), 3, null);
                    Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, f1.this.e, null, new b(f1.this, deferredAsync$default, null), 2, null);
                    try {
                        this.b = jobLaunch$default;
                        this.f454a = 1;
                        Object objAwait = deferredAsync$default.await(this);
                        if (objAwait == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        job = jobLaunch$default;
                        obj = objAwait;
                    } catch (b unused) {
                        job = jobLaunch$default;
                        e2 e2Var = new e2(0, null, "timeout");
                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                        return e2Var;
                    } catch (Throwable th) {
                        coroutine_suspended = jobLaunch$default;
                        th = th;
                        Job.DefaultImpls.cancel$default((Job) coroutine_suspended, (CancellationException) null, 1, (Object) null);
                        throw th;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    job = (Job) this.b;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (b unused2) {
                        e2 e2Var2 = new e2(0, null, "timeout");
                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                        return e2Var2;
                    }
                }
                e2 e2Var3 = (e2) obj;
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                return e2Var3;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    static final class d extends SuspendLambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f457a;
        int b;
        int c;
        private /* synthetic */ Object d;

        d(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            d dVar = f1.this.new d(continuation);
            dVar.d = obj;
            return dVar;
        }

        /* JADX WARN: Code duplicated, block: B:102:0x02cf A[Catch: all -> 0x02f0, TryCatch #0 {all -> 0x02f0, blocks: (B:100:0x02c7, B:102:0x02cf, B:105:0x02dc, B:107:0x02e0, B:109:0x02e5, B:111:0x02eb), top: B:147:0x02c7, outer: #6 }] */
        /* JADX WARN: Code duplicated, block: B:103:0x02d9  */
        /* JADX WARN: Code duplicated, block: B:105:0x02dc A[Catch: all -> 0x02f0, TryCatch #0 {all -> 0x02f0, blocks: (B:100:0x02c7, B:102:0x02cf, B:105:0x02dc, B:107:0x02e0, B:109:0x02e5, B:111:0x02eb), top: B:147:0x02c7, outer: #6 }] */
        /* JADX WARN: Code duplicated, block: B:106:0x02df  */
        /* JADX WARN: Code duplicated, block: B:109:0x02e5 A[Catch: all -> 0x02f0, TryCatch #0 {all -> 0x02f0, blocks: (B:100:0x02c7, B:102:0x02cf, B:105:0x02dc, B:107:0x02e0, B:109:0x02e5, B:111:0x02eb), top: B:147:0x02c7, outer: #6 }] */
        /* JADX WARN: Code duplicated, block: B:110:0x02ea  */
        /* JADX WARN: Code duplicated, block: B:120:0x030c A[Catch: all -> 0x032b, TryCatch #5 {all -> 0x032b, blocks: (B:118:0x0304, B:120:0x030c, B:123:0x0319, B:124:0x031b, B:126:0x0320, B:128:0x0326), top: B:157:0x0304, outer: #6 }] */
        /* JADX WARN: Code duplicated, block: B:121:0x0316  */
        /* JADX WARN: Code duplicated, block: B:123:0x0319 A[Catch: all -> 0x032b, TryCatch #5 {all -> 0x032b, blocks: (B:118:0x0304, B:120:0x030c, B:123:0x0319, B:124:0x031b, B:126:0x0320, B:128:0x0326), top: B:157:0x0304, outer: #6 }] */
        /* JADX WARN: Code duplicated, block: B:126:0x0320 A[Catch: all -> 0x032b, TryCatch #5 {all -> 0x032b, blocks: (B:118:0x0304, B:120:0x030c, B:123:0x0319, B:124:0x031b, B:126:0x0320, B:128:0x0326), top: B:157:0x0304, outer: #6 }] */
        /* JADX WARN: Code duplicated, block: B:127:0x0325  */
        /* JADX WARN: Code duplicated, block: B:135:0x033d A[Catch: IOException -> 0x0370, TryCatch #6 {IOException -> 0x0370, blocks: (B:10:0x0025, B:79:0x026c, B:80:0x0279, B:82:0x027f, B:84:0x0293, B:86:0x0299, B:87:0x02a3, B:89:0x02a9, B:91:0x02b1, B:93:0x02b7, B:95:0x02ba, B:97:0x02bd, B:98:0x02bf, B:115:0x02fb, B:133:0x0337, B:135:0x033d, B:136:0x0340, B:139:0x0347, B:131:0x032c, B:114:0x02f1, B:15:0x003a, B:75:0x023d, B:18:0x0047, B:63:0x01d6, B:65:0x0225, B:72:0x0230, B:70:0x022c, B:71:0x022f, B:21:0x0054, B:35:0x00e2, B:40:0x0119, B:47:0x0146, B:49:0x014c, B:51:0x0158, B:53:0x0166, B:54:0x0173, B:55:0x017b, B:57:0x0181, B:58:0x01a7, B:60:0x01c8, B:46:0x013c, B:39:0x010f, B:24:0x005d, B:30:0x0075, B:31:0x00bf, B:142:0x036a, B:143:0x036f, B:27:0x0069, B:100:0x02c7, B:102:0x02cf, B:105:0x02dc, B:107:0x02e0, B:109:0x02e5, B:111:0x02eb, B:64:0x0217, B:43:0x0122, B:68:0x022a, B:118:0x0304, B:120:0x030c, B:123:0x0319, B:124:0x031b, B:126:0x0320, B:128:0x0326, B:36:0x00fc), top: B:159:0x000f, inners: #0, #1, #2, #3, #4, #5, #7 }] */
        /* JADX WARN: Code duplicated, block: B:138:0x0346  */
        /* JADX WARN: Code duplicated, block: B:153:0x0122 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:157:0x0304 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:49:0x014c A[Catch: IOException -> 0x0370, TryCatch #6 {IOException -> 0x0370, blocks: (B:10:0x0025, B:79:0x026c, B:80:0x0279, B:82:0x027f, B:84:0x0293, B:86:0x0299, B:87:0x02a3, B:89:0x02a9, B:91:0x02b1, B:93:0x02b7, B:95:0x02ba, B:97:0x02bd, B:98:0x02bf, B:115:0x02fb, B:133:0x0337, B:135:0x033d, B:136:0x0340, B:139:0x0347, B:131:0x032c, B:114:0x02f1, B:15:0x003a, B:75:0x023d, B:18:0x0047, B:63:0x01d6, B:65:0x0225, B:72:0x0230, B:70:0x022c, B:71:0x022f, B:21:0x0054, B:35:0x00e2, B:40:0x0119, B:47:0x0146, B:49:0x014c, B:51:0x0158, B:53:0x0166, B:54:0x0173, B:55:0x017b, B:57:0x0181, B:58:0x01a7, B:60:0x01c8, B:46:0x013c, B:39:0x010f, B:24:0x005d, B:30:0x0075, B:31:0x00bf, B:142:0x036a, B:143:0x036f, B:27:0x0069, B:100:0x02c7, B:102:0x02cf, B:105:0x02dc, B:107:0x02e0, B:109:0x02e5, B:111:0x02eb, B:64:0x0217, B:43:0x0122, B:68:0x022a, B:118:0x0304, B:120:0x030c, B:123:0x0319, B:124:0x031b, B:126:0x0320, B:128:0x0326, B:36:0x00fc), top: B:159:0x000f, inners: #0, #1, #2, #3, #4, #5, #7 }] */
        /* JADX WARN: Code duplicated, block: B:51:0x0158 A[Catch: IOException -> 0x0370, TryCatch #6 {IOException -> 0x0370, blocks: (B:10:0x0025, B:79:0x026c, B:80:0x0279, B:82:0x027f, B:84:0x0293, B:86:0x0299, B:87:0x02a3, B:89:0x02a9, B:91:0x02b1, B:93:0x02b7, B:95:0x02ba, B:97:0x02bd, B:98:0x02bf, B:115:0x02fb, B:133:0x0337, B:135:0x033d, B:136:0x0340, B:139:0x0347, B:131:0x032c, B:114:0x02f1, B:15:0x003a, B:75:0x023d, B:18:0x0047, B:63:0x01d6, B:65:0x0225, B:72:0x0230, B:70:0x022c, B:71:0x022f, B:21:0x0054, B:35:0x00e2, B:40:0x0119, B:47:0x0146, B:49:0x014c, B:51:0x0158, B:53:0x0166, B:54:0x0173, B:55:0x017b, B:57:0x0181, B:58:0x01a7, B:60:0x01c8, B:46:0x013c, B:39:0x010f, B:24:0x005d, B:30:0x0075, B:31:0x00bf, B:142:0x036a, B:143:0x036f, B:27:0x0069, B:100:0x02c7, B:102:0x02cf, B:105:0x02dc, B:107:0x02e0, B:109:0x02e5, B:111:0x02eb, B:64:0x0217, B:43:0x0122, B:68:0x022a, B:118:0x0304, B:120:0x030c, B:123:0x0319, B:124:0x031b, B:126:0x0320, B:128:0x0326, B:36:0x00fc), top: B:159:0x000f, inners: #0, #1, #2, #3, #4, #5, #7 }] */
        /* JADX WARN: Code duplicated, block: B:53:0x0166 A[Catch: IOException -> 0x0370, TryCatch #6 {IOException -> 0x0370, blocks: (B:10:0x0025, B:79:0x026c, B:80:0x0279, B:82:0x027f, B:84:0x0293, B:86:0x0299, B:87:0x02a3, B:89:0x02a9, B:91:0x02b1, B:93:0x02b7, B:95:0x02ba, B:97:0x02bd, B:98:0x02bf, B:115:0x02fb, B:133:0x0337, B:135:0x033d, B:136:0x0340, B:139:0x0347, B:131:0x032c, B:114:0x02f1, B:15:0x003a, B:75:0x023d, B:18:0x0047, B:63:0x01d6, B:65:0x0225, B:72:0x0230, B:70:0x022c, B:71:0x022f, B:21:0x0054, B:35:0x00e2, B:40:0x0119, B:47:0x0146, B:49:0x014c, B:51:0x0158, B:53:0x0166, B:54:0x0173, B:55:0x017b, B:57:0x0181, B:58:0x01a7, B:60:0x01c8, B:46:0x013c, B:39:0x010f, B:24:0x005d, B:30:0x0075, B:31:0x00bf, B:142:0x036a, B:143:0x036f, B:27:0x0069, B:100:0x02c7, B:102:0x02cf, B:105:0x02dc, B:107:0x02e0, B:109:0x02e5, B:111:0x02eb, B:64:0x0217, B:43:0x0122, B:68:0x022a, B:118:0x0304, B:120:0x030c, B:123:0x0319, B:124:0x031b, B:126:0x0320, B:128:0x0326, B:36:0x00fc), top: B:159:0x000f, inners: #0, #1, #2, #3, #4, #5, #7 }] */
        /* JADX WARN: Code duplicated, block: B:57:0x0181 A[Catch: IOException -> 0x0370, LOOP:2: B:55:0x017b->B:57:0x0181, LOOP_END, TryCatch #6 {IOException -> 0x0370, blocks: (B:10:0x0025, B:79:0x026c, B:80:0x0279, B:82:0x027f, B:84:0x0293, B:86:0x0299, B:87:0x02a3, B:89:0x02a9, B:91:0x02b1, B:93:0x02b7, B:95:0x02ba, B:97:0x02bd, B:98:0x02bf, B:115:0x02fb, B:133:0x0337, B:135:0x033d, B:136:0x0340, B:139:0x0347, B:131:0x032c, B:114:0x02f1, B:15:0x003a, B:75:0x023d, B:18:0x0047, B:63:0x01d6, B:65:0x0225, B:72:0x0230, B:70:0x022c, B:71:0x022f, B:21:0x0054, B:35:0x00e2, B:40:0x0119, B:47:0x0146, B:49:0x014c, B:51:0x0158, B:53:0x0166, B:54:0x0173, B:55:0x017b, B:57:0x0181, B:58:0x01a7, B:60:0x01c8, B:46:0x013c, B:39:0x010f, B:24:0x005d, B:30:0x0075, B:31:0x00bf, B:142:0x036a, B:143:0x036f, B:27:0x0069, B:100:0x02c7, B:102:0x02cf, B:105:0x02dc, B:107:0x02e0, B:109:0x02e5, B:111:0x02eb, B:64:0x0217, B:43:0x0122, B:68:0x022a, B:118:0x0304, B:120:0x030c, B:123:0x0319, B:124:0x031b, B:126:0x0320, B:128:0x0326, B:36:0x00fc), top: B:159:0x000f, inners: #0, #1, #2, #3, #4, #5, #7 }] */
        /* JADX WARN: Code duplicated, block: B:60:0x01c8 A[Catch: IOException -> 0x0370, TryCatch #6 {IOException -> 0x0370, blocks: (B:10:0x0025, B:79:0x026c, B:80:0x0279, B:82:0x027f, B:84:0x0293, B:86:0x0299, B:87:0x02a3, B:89:0x02a9, B:91:0x02b1, B:93:0x02b7, B:95:0x02ba, B:97:0x02bd, B:98:0x02bf, B:115:0x02fb, B:133:0x0337, B:135:0x033d, B:136:0x0340, B:139:0x0347, B:131:0x032c, B:114:0x02f1, B:15:0x003a, B:75:0x023d, B:18:0x0047, B:63:0x01d6, B:65:0x0225, B:72:0x0230, B:70:0x022c, B:71:0x022f, B:21:0x0054, B:35:0x00e2, B:40:0x0119, B:47:0x0146, B:49:0x014c, B:51:0x0158, B:53:0x0166, B:54:0x0173, B:55:0x017b, B:57:0x0181, B:58:0x01a7, B:60:0x01c8, B:46:0x013c, B:39:0x010f, B:24:0x005d, B:30:0x0075, B:31:0x00bf, B:142:0x036a, B:143:0x036f, B:27:0x0069, B:100:0x02c7, B:102:0x02cf, B:105:0x02dc, B:107:0x02e0, B:109:0x02e5, B:111:0x02eb, B:64:0x0217, B:43:0x0122, B:68:0x022a, B:118:0x0304, B:120:0x030c, B:123:0x0319, B:124:0x031b, B:126:0x0320, B:128:0x0326, B:36:0x00fc), top: B:159:0x000f, inners: #0, #1, #2, #3, #4, #5, #7 }] */
        /* JADX WARN: Code duplicated, block: B:62:0x01d4  */
        /* JADX WARN: Code duplicated, block: B:63:0x01d6 A[Catch: IOException -> 0x0370, PHI: r0 r2
  0x01d6: PHI (r0v13 java.net.HttpURLConnection) = (r0v10 java.net.HttpURLConnection), (r0v21 java.net.HttpURLConnection) binds: [B:61:0x01d2, B:18:0x0047] A[DONT_GENERATE, DONT_INLINE]
  0x01d6: PHI (r2v6 kotlinx.coroutines.CoroutineScope) = (r2v4 kotlinx.coroutines.CoroutineScope), (r2v35 kotlinx.coroutines.CoroutineScope) binds: [B:61:0x01d2, B:18:0x0047] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #6 {IOException -> 0x0370, blocks: (B:10:0x0025, B:79:0x026c, B:80:0x0279, B:82:0x027f, B:84:0x0293, B:86:0x0299, B:87:0x02a3, B:89:0x02a9, B:91:0x02b1, B:93:0x02b7, B:95:0x02ba, B:97:0x02bd, B:98:0x02bf, B:115:0x02fb, B:133:0x0337, B:135:0x033d, B:136:0x0340, B:139:0x0347, B:131:0x032c, B:114:0x02f1, B:15:0x003a, B:75:0x023d, B:18:0x0047, B:63:0x01d6, B:65:0x0225, B:72:0x0230, B:70:0x022c, B:71:0x022f, B:21:0x0054, B:35:0x00e2, B:40:0x0119, B:47:0x0146, B:49:0x014c, B:51:0x0158, B:53:0x0166, B:54:0x0173, B:55:0x017b, B:57:0x0181, B:58:0x01a7, B:60:0x01c8, B:46:0x013c, B:39:0x010f, B:24:0x005d, B:30:0x0075, B:31:0x00bf, B:142:0x036a, B:143:0x036f, B:27:0x0069, B:100:0x02c7, B:102:0x02cf, B:105:0x02dc, B:107:0x02e0, B:109:0x02e5, B:111:0x02eb, B:64:0x0217, B:43:0x0122, B:68:0x022a, B:118:0x0304, B:120:0x030c, B:123:0x0319, B:124:0x031b, B:126:0x0320, B:128:0x0326, B:36:0x00fc), top: B:159:0x000f, inners: #0, #1, #2, #3, #4, #5, #7 }] */
        /* JADX WARN: Code duplicated, block: B:72:0x0230 A[Catch: IOException -> 0x0370, PHI: r0 r2
  0x0230: PHI (r0v12 java.net.HttpURLConnection) = (r0v10 java.net.HttpURLConnection), (r0v13 java.net.HttpURLConnection) binds: [B:59:0x01c6, B:65:0x0225] A[DONT_GENERATE, DONT_INLINE]
  0x0230: PHI (r2v5 kotlinx.coroutines.CoroutineScope) = (r2v4 kotlinx.coroutines.CoroutineScope), (r2v6 kotlinx.coroutines.CoroutineScope) binds: [B:59:0x01c6, B:65:0x0225] A[DONT_GENERATE, DONT_INLINE], TryCatch #6 {IOException -> 0x0370, blocks: (B:10:0x0025, B:79:0x026c, B:80:0x0279, B:82:0x027f, B:84:0x0293, B:86:0x0299, B:87:0x02a3, B:89:0x02a9, B:91:0x02b1, B:93:0x02b7, B:95:0x02ba, B:97:0x02bd, B:98:0x02bf, B:115:0x02fb, B:133:0x0337, B:135:0x033d, B:136:0x0340, B:139:0x0347, B:131:0x032c, B:114:0x02f1, B:15:0x003a, B:75:0x023d, B:18:0x0047, B:63:0x01d6, B:65:0x0225, B:72:0x0230, B:70:0x022c, B:71:0x022f, B:21:0x0054, B:35:0x00e2, B:40:0x0119, B:47:0x0146, B:49:0x014c, B:51:0x0158, B:53:0x0166, B:54:0x0173, B:55:0x017b, B:57:0x0181, B:58:0x01a7, B:60:0x01c8, B:46:0x013c, B:39:0x010f, B:24:0x005d, B:30:0x0075, B:31:0x00bf, B:142:0x036a, B:143:0x036f, B:27:0x0069, B:100:0x02c7, B:102:0x02cf, B:105:0x02dc, B:107:0x02e0, B:109:0x02e5, B:111:0x02eb, B:64:0x0217, B:43:0x0122, B:68:0x022a, B:118:0x0304, B:120:0x030c, B:123:0x0319, B:124:0x031b, B:126:0x0320, B:128:0x0326, B:36:0x00fc), top: B:159:0x000f, inners: #0, #1, #2, #3, #4, #5, #7 }] */
        /* JADX WARN: Code duplicated, block: B:74:0x023c  */
        /* JADX WARN: Code duplicated, block: B:75:0x023d A[Catch: IOException -> 0x0370, PHI: r0 r2
  0x023d: PHI (r0v15 java.net.HttpURLConnection) = (r0v12 java.net.HttpURLConnection), (r0v23 java.net.HttpURLConnection) binds: [B:73:0x023a, B:15:0x003a] A[DONT_GENERATE, DONT_INLINE]
  0x023d: PHI (r2v7 kotlinx.coroutines.CoroutineScope) = (r2v5 kotlinx.coroutines.CoroutineScope), (r2v37 kotlinx.coroutines.CoroutineScope) binds: [B:73:0x023a, B:15:0x003a] A[DONT_GENERATE, DONT_INLINE], TryCatch #6 {IOException -> 0x0370, blocks: (B:10:0x0025, B:79:0x026c, B:80:0x0279, B:82:0x027f, B:84:0x0293, B:86:0x0299, B:87:0x02a3, B:89:0x02a9, B:91:0x02b1, B:93:0x02b7, B:95:0x02ba, B:97:0x02bd, B:98:0x02bf, B:115:0x02fb, B:133:0x0337, B:135:0x033d, B:136:0x0340, B:139:0x0347, B:131:0x032c, B:114:0x02f1, B:15:0x003a, B:75:0x023d, B:18:0x0047, B:63:0x01d6, B:65:0x0225, B:72:0x0230, B:70:0x022c, B:71:0x022f, B:21:0x0054, B:35:0x00e2, B:40:0x0119, B:47:0x0146, B:49:0x014c, B:51:0x0158, B:53:0x0166, B:54:0x0173, B:55:0x017b, B:57:0x0181, B:58:0x01a7, B:60:0x01c8, B:46:0x013c, B:39:0x010f, B:24:0x005d, B:30:0x0075, B:31:0x00bf, B:142:0x036a, B:143:0x036f, B:27:0x0069, B:100:0x02c7, B:102:0x02cf, B:105:0x02dc, B:107:0x02e0, B:109:0x02e5, B:111:0x02eb, B:64:0x0217, B:43:0x0122, B:68:0x022a, B:118:0x0304, B:120:0x030c, B:123:0x0319, B:124:0x031b, B:126:0x0320, B:128:0x0326, B:36:0x00fc), top: B:159:0x000f, inners: #0, #1, #2, #3, #4, #5, #7 }] */
        /* JADX WARN: Code duplicated, block: B:78:0x026a  */
        /* JADX WARN: Code duplicated, block: B:82:0x027f A[Catch: IOException -> 0x0370, TryCatch #6 {IOException -> 0x0370, blocks: (B:10:0x0025, B:79:0x026c, B:80:0x0279, B:82:0x027f, B:84:0x0293, B:86:0x0299, B:87:0x02a3, B:89:0x02a9, B:91:0x02b1, B:93:0x02b7, B:95:0x02ba, B:97:0x02bd, B:98:0x02bf, B:115:0x02fb, B:133:0x0337, B:135:0x033d, B:136:0x0340, B:139:0x0347, B:131:0x032c, B:114:0x02f1, B:15:0x003a, B:75:0x023d, B:18:0x0047, B:63:0x01d6, B:65:0x0225, B:72:0x0230, B:70:0x022c, B:71:0x022f, B:21:0x0054, B:35:0x00e2, B:40:0x0119, B:47:0x0146, B:49:0x014c, B:51:0x0158, B:53:0x0166, B:54:0x0173, B:55:0x017b, B:57:0x0181, B:58:0x01a7, B:60:0x01c8, B:46:0x013c, B:39:0x010f, B:24:0x005d, B:30:0x0075, B:31:0x00bf, B:142:0x036a, B:143:0x036f, B:27:0x0069, B:100:0x02c7, B:102:0x02cf, B:105:0x02dc, B:107:0x02e0, B:109:0x02e5, B:111:0x02eb, B:64:0x0217, B:43:0x0122, B:68:0x022a, B:118:0x0304, B:120:0x030c, B:123:0x0319, B:124:0x031b, B:126:0x0320, B:128:0x0326, B:36:0x00fc), top: B:159:0x000f, inners: #0, #1, #2, #3, #4, #5, #7 }] */
        /* JADX WARN: Code duplicated, block: B:84:0x0293 A[Catch: IOException -> 0x0370, TryCatch #6 {IOException -> 0x0370, blocks: (B:10:0x0025, B:79:0x026c, B:80:0x0279, B:82:0x027f, B:84:0x0293, B:86:0x0299, B:87:0x02a3, B:89:0x02a9, B:91:0x02b1, B:93:0x02b7, B:95:0x02ba, B:97:0x02bd, B:98:0x02bf, B:115:0x02fb, B:133:0x0337, B:135:0x033d, B:136:0x0340, B:139:0x0347, B:131:0x032c, B:114:0x02f1, B:15:0x003a, B:75:0x023d, B:18:0x0047, B:63:0x01d6, B:65:0x0225, B:72:0x0230, B:70:0x022c, B:71:0x022f, B:21:0x0054, B:35:0x00e2, B:40:0x0119, B:47:0x0146, B:49:0x014c, B:51:0x0158, B:53:0x0166, B:54:0x0173, B:55:0x017b, B:57:0x0181, B:58:0x01a7, B:60:0x01c8, B:46:0x013c, B:39:0x010f, B:24:0x005d, B:30:0x0075, B:31:0x00bf, B:142:0x036a, B:143:0x036f, B:27:0x0069, B:100:0x02c7, B:102:0x02cf, B:105:0x02dc, B:107:0x02e0, B:109:0x02e5, B:111:0x02eb, B:64:0x0217, B:43:0x0122, B:68:0x022a, B:118:0x0304, B:120:0x030c, B:123:0x0319, B:124:0x031b, B:126:0x0320, B:128:0x0326, B:36:0x00fc), top: B:159:0x000f, inners: #0, #1, #2, #3, #4, #5, #7 }] */
        /* JADX WARN: Code duplicated, block: B:86:0x0299 A[Catch: IOException -> 0x0370, TryCatch #6 {IOException -> 0x0370, blocks: (B:10:0x0025, B:79:0x026c, B:80:0x0279, B:82:0x027f, B:84:0x0293, B:86:0x0299, B:87:0x02a3, B:89:0x02a9, B:91:0x02b1, B:93:0x02b7, B:95:0x02ba, B:97:0x02bd, B:98:0x02bf, B:115:0x02fb, B:133:0x0337, B:135:0x033d, B:136:0x0340, B:139:0x0347, B:131:0x032c, B:114:0x02f1, B:15:0x003a, B:75:0x023d, B:18:0x0047, B:63:0x01d6, B:65:0x0225, B:72:0x0230, B:70:0x022c, B:71:0x022f, B:21:0x0054, B:35:0x00e2, B:40:0x0119, B:47:0x0146, B:49:0x014c, B:51:0x0158, B:53:0x0166, B:54:0x0173, B:55:0x017b, B:57:0x0181, B:58:0x01a7, B:60:0x01c8, B:46:0x013c, B:39:0x010f, B:24:0x005d, B:30:0x0075, B:31:0x00bf, B:142:0x036a, B:143:0x036f, B:27:0x0069, B:100:0x02c7, B:102:0x02cf, B:105:0x02dc, B:107:0x02e0, B:109:0x02e5, B:111:0x02eb, B:64:0x0217, B:43:0x0122, B:68:0x022a, B:118:0x0304, B:120:0x030c, B:123:0x0319, B:124:0x031b, B:126:0x0320, B:128:0x0326, B:36:0x00fc), top: B:159:0x000f, inners: #0, #1, #2, #3, #4, #5, #7 }] */
        /* JADX WARN: Code duplicated, block: B:89:0x02a9 A[Catch: IOException -> 0x0370, TryCatch #6 {IOException -> 0x0370, blocks: (B:10:0x0025, B:79:0x026c, B:80:0x0279, B:82:0x027f, B:84:0x0293, B:86:0x0299, B:87:0x02a3, B:89:0x02a9, B:91:0x02b1, B:93:0x02b7, B:95:0x02ba, B:97:0x02bd, B:98:0x02bf, B:115:0x02fb, B:133:0x0337, B:135:0x033d, B:136:0x0340, B:139:0x0347, B:131:0x032c, B:114:0x02f1, B:15:0x003a, B:75:0x023d, B:18:0x0047, B:63:0x01d6, B:65:0x0225, B:72:0x0230, B:70:0x022c, B:71:0x022f, B:21:0x0054, B:35:0x00e2, B:40:0x0119, B:47:0x0146, B:49:0x014c, B:51:0x0158, B:53:0x0166, B:54:0x0173, B:55:0x017b, B:57:0x0181, B:58:0x01a7, B:60:0x01c8, B:46:0x013c, B:39:0x010f, B:24:0x005d, B:30:0x0075, B:31:0x00bf, B:142:0x036a, B:143:0x036f, B:27:0x0069, B:100:0x02c7, B:102:0x02cf, B:105:0x02dc, B:107:0x02e0, B:109:0x02e5, B:111:0x02eb, B:64:0x0217, B:43:0x0122, B:68:0x022a, B:118:0x0304, B:120:0x030c, B:123:0x0319, B:124:0x031b, B:126:0x0320, B:128:0x0326, B:36:0x00fc), top: B:159:0x000f, inners: #0, #1, #2, #3, #4, #5, #7 }] */
        /* JADX WARN: Code duplicated, block: B:91:0x02b1 A[Catch: IOException -> 0x0370, TryCatch #6 {IOException -> 0x0370, blocks: (B:10:0x0025, B:79:0x026c, B:80:0x0279, B:82:0x027f, B:84:0x0293, B:86:0x0299, B:87:0x02a3, B:89:0x02a9, B:91:0x02b1, B:93:0x02b7, B:95:0x02ba, B:97:0x02bd, B:98:0x02bf, B:115:0x02fb, B:133:0x0337, B:135:0x033d, B:136:0x0340, B:139:0x0347, B:131:0x032c, B:114:0x02f1, B:15:0x003a, B:75:0x023d, B:18:0x0047, B:63:0x01d6, B:65:0x0225, B:72:0x0230, B:70:0x022c, B:71:0x022f, B:21:0x0054, B:35:0x00e2, B:40:0x0119, B:47:0x0146, B:49:0x014c, B:51:0x0158, B:53:0x0166, B:54:0x0173, B:55:0x017b, B:57:0x0181, B:58:0x01a7, B:60:0x01c8, B:46:0x013c, B:39:0x010f, B:24:0x005d, B:30:0x0075, B:31:0x00bf, B:142:0x036a, B:143:0x036f, B:27:0x0069, B:100:0x02c7, B:102:0x02cf, B:105:0x02dc, B:107:0x02e0, B:109:0x02e5, B:111:0x02eb, B:64:0x0217, B:43:0x0122, B:68:0x022a, B:118:0x0304, B:120:0x030c, B:123:0x0319, B:124:0x031b, B:126:0x0320, B:128:0x0326, B:36:0x00fc), top: B:159:0x000f, inners: #0, #1, #2, #3, #4, #5, #7 }] */
        /* JADX WARN: Code duplicated, block: B:92:0x02b6  */
        /* JADX WARN: Code duplicated, block: B:94:0x02b9  */
        /* JADX WARN: Code duplicated, block: B:96:0x02bc  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            URL url;
            HttpURLConnection httpURLConnection;
            Map mutableMap;
            Object objM248constructorimpl;
            f1 f1Var;
            Throwable thM251exceptionOrNullimpl;
            DataOutputStream dataOutputStream;
            int responseCode;
            HttpURLConnection httpURLConnection2;
            int i;
            Iterator<T> it;
            int i2;
            f1 f1Var2;
            Object objM248constructorimpl2;
            f1 f1Var3;
            Object objM248constructorimpl3;
            InputStream errorStream;
            byte[] bArrA;
            String strA;
            Throwable thM251exceptionOrNullimpl2;
            InputStream inputStream;
            byte[] bArrA2;
            long length;
            String strA2;
            String str;
            List<String> values;
            int i3;
            int i4;
            int length2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.c;
            try {
                try {
                    if (i5 == 0) {
                        ResultKt.throwOnFailure(obj);
                        coroutineScope = (CoroutineScope) this.d;
                        this.d = coroutineScope;
                        this.c = 1;
                        if (YieldKt.yield(this) != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    if (i5 == 1) {
                        coroutineScope = (CoroutineScope) this.d;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i5 == 2) {
                            url = (URL) this.f457a;
                            coroutineScope = (CoroutineScope) this.d;
                            ResultKt.throwOnFailure(obj);
                            URLConnection uRLConnectionOpenConnection = url.openConnection();
                            Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                            httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                            mutableMap = MapsKt.toMutableMap(f1.this.f453a.f);
                            f1 f1Var4 = f1.this;
                            try {
                                Result.Companion companion = Result.INSTANCE;
                                httpURLConnection.setRequestMethod(f1Var4.f453a.f767a);
                                objM248constructorimpl = Result.m248constructorimpl(Unit.INSTANCE);
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.INSTANCE;
                                objM248constructorimpl = Result.m248constructorimpl(ResultKt.createFailure(th));
                            }
                            f1Var = f1.this;
                            if (Result.m251exceptionOrNullimpl(objM248constructorimpl) != null) {
                                try {
                                    Result.Companion companion3 = Result.INSTANCE;
                                    httpURLConnection.setRequestMethod("POST");
                                    mutableMap.put(MethodOverride.HEADER, f1Var.f453a.f767a);
                                    objM248constructorimpl = Result.m248constructorimpl(Unit.INSTANCE);
                                } catch (Throwable th2) {
                                    Result.Companion companion4 = Result.INSTANCE;
                                    objM248constructorimpl = Result.m248constructorimpl(ResultKt.createFailure(th2));
                                }
                            }
                            thM251exceptionOrNullimpl = Result.m251exceptionOrNullimpl(objM248constructorimpl);
                            if (thM251exceptionOrNullimpl != null) {
                                return new e2(500, null, thM251exceptionOrNullimpl.getLocalizedMessage());
                            }
                            if (f1.this.f453a.h.length() > 0) {
                                httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, f1.this.f453a.h);
                            }
                            for (Map.Entry entry : mutableMap.entrySet()) {
                                String str2 = (String) entry.getKey();
                                String str3 = (String) entry.getValue();
                                f3.a(str2.length());
                                f3.a(str3.length());
                                httpURLConnection.setRequestProperty(str2, str3);
                            }
                            httpURLConnection.setUseCaches(true);
                            httpURLConnection.setInstanceFollowRedirects(false);
                            httpURLConnection.setConnectTimeout(10000);
                            httpURLConnection.setReadTimeout(f1.this.c);
                            httpURLConnection.setDoInput(true);
                            if (f1.this.f453a.i != null) {
                                this.d = coroutineScope;
                                this.f457a = httpURLConnection;
                                this.c = 3;
                                if (YieldKt.yield(this) == coroutine_suspended) {
                                    String str4 = f1.g;
                                    StringBuilder sbAppend = new StringBuilder().append("Request Body : ");
                                    f1 f1Var5 = f1.this;
                                    SDKLog.d(str4, sbAppend.append(f1Var5.a(f1Var5.f453a.i)).toString());
                                    f3.a(f1.this.f453a.i.length);
                                    httpURLConnection.setDoOutput(true);
                                    dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                                    dataOutputStream.write(f1.this.f453a.i);
                                    dataOutputStream.flush();
                                    Unit unit = Unit.INSTANCE;
                                    CloseableKt.closeFinally(dataOutputStream, null);
                                    this.d = coroutineScope;
                                    this.f457a = httpURLConnection;
                                    this.c = 4;
                                    if (YieldKt.yield(this) != coroutine_suspended) {
                                        responseCode = httpURLConnection.getResponseCode();
                                        SDKLog.d(f1.g, "Status Code : " + responseCode);
                                        this.d = coroutineScope;
                                        this.f457a = httpURLConnection;
                                        this.b = responseCode;
                                        this.c = 5;
                                        if (YieldKt.yield(this) != coroutine_suspended) {
                                            httpURLConnection2 = httpURLConnection;
                                            i = responseCode;
                                        }
                                    }
                                }
                            } else {
                                this.d = coroutineScope;
                                this.f457a = httpURLConnection;
                                this.c = 4;
                                if (YieldKt.yield(this) != coroutine_suspended) {
                                    responseCode = httpURLConnection.getResponseCode();
                                    SDKLog.d(f1.g, "Status Code : " + responseCode);
                                    this.d = coroutineScope;
                                    this.f457a = httpURLConnection;
                                    this.b = responseCode;
                                    this.c = 5;
                                    if (YieldKt.yield(this) != coroutine_suspended) {
                                        httpURLConnection2 = httpURLConnection;
                                        i = responseCode;
                                    }
                                }
                            }
                            return coroutine_suspended;
                        }
                        if (i5 == 3) {
                            httpURLConnection = (HttpURLConnection) this.f457a;
                            coroutineScope = (CoroutineScope) this.d;
                            ResultKt.throwOnFailure(obj);
                            String str5 = f1.g;
                            StringBuilder sbAppend2 = new StringBuilder().append("Request Body : ");
                            f1 f1Var6 = f1.this;
                            SDKLog.d(str5, sbAppend2.append(f1Var6.a(f1Var6.f453a.i)).toString());
                            f3.a(f1.this.f453a.i.length);
                            httpURLConnection.setDoOutput(true);
                            dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                            try {
                                dataOutputStream.write(f1.this.f453a.i);
                                dataOutputStream.flush();
                                Unit unit2 = Unit.INSTANCE;
                                CloseableKt.closeFinally(dataOutputStream, null);
                                this.d = coroutineScope;
                                this.f457a = httpURLConnection;
                                this.c = 4;
                                if (YieldKt.yield(this) != coroutine_suspended) {
                                    responseCode = httpURLConnection.getResponseCode();
                                    SDKLog.d(f1.g, "Status Code : " + responseCode);
                                    this.d = coroutineScope;
                                    this.f457a = httpURLConnection;
                                    this.b = responseCode;
                                    this.c = 5;
                                    if (YieldKt.yield(this) != coroutine_suspended) {
                                        httpURLConnection2 = httpURLConnection;
                                        i = responseCode;
                                    }
                                }
                                return coroutine_suspended;
                            } catch (Throwable th3) {
                                try {
                                    throw th3;
                                } catch (Throwable th4) {
                                    CloseableKt.closeFinally(dataOutputStream, th3);
                                    throw th4;
                                }
                            }
                        }
                        if (i5 == 4) {
                            httpURLConnection = (HttpURLConnection) this.f457a;
                            coroutineScope = (CoroutineScope) this.d;
                            ResultKt.throwOnFailure(obj);
                            responseCode = httpURLConnection.getResponseCode();
                            SDKLog.d(f1.g, "Status Code : " + responseCode);
                            this.d = coroutineScope;
                            this.f457a = httpURLConnection;
                            this.b = responseCode;
                            this.c = 5;
                            if (YieldKt.yield(this) != coroutine_suspended) {
                                httpURLConnection2 = httpURLConnection;
                                i = responseCode;
                            }
                            return coroutine_suspended;
                        }
                        if (i5 != 5) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        i = this.b;
                        httpURLConnection2 = (HttpURLConnection) this.f457a;
                        ResultKt.throwOnFailure(obj);
                    }
                    Map<String, List<String>> headerFields = httpURLConnection2.getHeaderFields();
                    it = headerFields.entrySet().iterator();
                    i2 = 0;
                    while (it.hasNext()) {
                        Map.Entry entry2 = (Map.Entry) it.next();
                        str = (String) entry2.getKey();
                        values = (List) entry2.getValue();
                        if (str != null) {
                            int length3 = str.length();
                            if (values != null) {
                                Intrinsics.checkNotNullExpressionValue(values, "values");
                                i4 = 0;
                                for (String str6 : values) {
                                    if (str6 != null) {
                                        length2 = str6.length();
                                    } else {
                                        length2 = 0;
                                    }
                                    i4 += length2;
                                }
                            } else {
                                i4 = 0;
                            }
                            i3 = length3 + i4;
                        } else {
                            i3 = 0;
                        }
                        i2 += i3;
                    }
                    f3.b(i2);
                    f1Var2 = f1.this;
                    try {
                        Result.Companion companion5 = Result.INSTANCE;
                        inputStream = httpURLConnection2.getInputStream();
                        if (inputStream != null) {
                            Intrinsics.checkNotNullExpressionValue(inputStream, "inputStream");
                            bArrA2 = f1Var2.a(inputStream);
                        } else {
                            bArrA2 = null;
                        }
                        if (bArrA2 != null) {
                            length = bArrA2.length;
                        } else {
                            length = 0;
                        }
                        f3.b(length);
                        if (bArrA2 != null) {
                            strA2 = f1Var2.a(bArrA2);
                        } else {
                            strA2 = null;
                        }
                        objM248constructorimpl2 = Result.m248constructorimpl(strA2);
                    } catch (Throwable th5) {
                        Result.Companion companion6 = Result.INSTANCE;
                        objM248constructorimpl2 = Result.m248constructorimpl(ResultKt.createFailure(th5));
                    }
                    f1Var3 = f1.this;
                    if (Result.m251exceptionOrNullimpl(objM248constructorimpl2) != null) {
                        try {
                            Result.Companion companion7 = Result.INSTANCE;
                            errorStream = httpURLConnection2.getErrorStream();
                            if (errorStream != null) {
                                Intrinsics.checkNotNullExpressionValue(errorStream, "errorStream");
                                bArrA = f1Var3.a(errorStream);
                            } else {
                                bArrA = null;
                            }
                            f3.b(bArrA != null ? bArrA.length : 0L);
                            if (bArrA != null) {
                                strA = f1Var3.a(bArrA);
                            } else {
                                strA = null;
                            }
                            objM248constructorimpl3 = Result.m248constructorimpl(strA);
                        } catch (Throwable th6) {
                            Result.Companion companion8 = Result.INSTANCE;
                            objM248constructorimpl3 = Result.m248constructorimpl(ResultKt.createFailure(th6));
                        }
                        objM248constructorimpl2 = objM248constructorimpl3;
                    }
                    thM251exceptionOrNullimpl2 = Result.m251exceptionOrNullimpl(objM248constructorimpl2);
                    if (thM251exceptionOrNullimpl2 != null) {
                        thM251exceptionOrNullimpl2.getMessage();
                    }
                    if (Result.m254isFailureimpl(objM248constructorimpl2)) {
                        objM248constructorimpl2 = null;
                    }
                    String str7 = (String) objM248constructorimpl2;
                    SDKLog.d(f1.g, "Response Data : " + str7);
                    return new e2(i, headerFields, str7);
                    URL url2 = new URL(new i5().d(f1.this.f453a.b).b(f1.this.f453a.c).a(f1.this.f453a.d).c(f1.this.f453a.e).a(f1.this.f453a.g).a());
                    SDKLog.d(f1.g, "URL : " + url2);
                    this.d = coroutineScope;
                    this.f457a = url2;
                    this.c = 2;
                    if (YieldKt.yield(this) != coroutine_suspended) {
                        url = url2;
                        URLConnection uRLConnectionOpenConnection2 = url.openConnection();
                        Intrinsics.checkNotNull(uRLConnectionOpenConnection2, "null cannot be cast to non-null type java.net.HttpURLConnection");
                        httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection2;
                        mutableMap = MapsKt.toMutableMap(f1.this.f453a.f);
                        f1 f1Var7 = f1.this;
                        Result.Companion companion9 = Result.INSTANCE;
                        httpURLConnection.setRequestMethod(f1Var7.f453a.f767a);
                        objM248constructorimpl = Result.m248constructorimpl(Unit.INSTANCE);
                        f1Var = f1.this;
                        if (Result.m251exceptionOrNullimpl(objM248constructorimpl) != null) {
                            Result.Companion companion10 = Result.INSTANCE;
                            httpURLConnection.setRequestMethod("POST");
                            mutableMap.put(MethodOverride.HEADER, f1Var.f453a.f767a);
                            objM248constructorimpl = Result.m248constructorimpl(Unit.INSTANCE);
                        }
                        thM251exceptionOrNullimpl = Result.m251exceptionOrNullimpl(objM248constructorimpl);
                        if (thM251exceptionOrNullimpl != null) {
                            return new e2(500, null, thM251exceptionOrNullimpl.getLocalizedMessage());
                        }
                        if (f1.this.f453a.h.length() > 0) {
                            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, f1.this.f453a.h);
                        }
                        while (r14.hasNext()) {
                            String str8 = (String) entry.getKey();
                            String str9 = (String) entry.getValue();
                            f3.a(str8.length());
                            f3.a(str9.length());
                            httpURLConnection.setRequestProperty(str8, str9);
                        }
                        httpURLConnection.setUseCaches(true);
                        httpURLConnection.setInstanceFollowRedirects(false);
                        httpURLConnection.setConnectTimeout(10000);
                        httpURLConnection.setReadTimeout(f1.this.c);
                        httpURLConnection.setDoInput(true);
                        if (f1.this.f453a.i != null) {
                            this.d = coroutineScope;
                            this.f457a = httpURLConnection;
                            this.c = 3;
                            if (YieldKt.yield(this) == coroutine_suspended) {
                                String str10 = f1.g;
                                StringBuilder sbAppend3 = new StringBuilder().append("Request Body : ");
                                f1 f1Var8 = f1.this;
                                SDKLog.d(str10, sbAppend3.append(f1Var8.a(f1Var8.f453a.i)).toString());
                                f3.a(f1.this.f453a.i.length);
                                httpURLConnection.setDoOutput(true);
                                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                                dataOutputStream.write(f1.this.f453a.i);
                                dataOutputStream.flush();
                                Unit unit3 = Unit.INSTANCE;
                                CloseableKt.closeFinally(dataOutputStream, null);
                                this.d = coroutineScope;
                                this.f457a = httpURLConnection;
                                this.c = 4;
                                if (YieldKt.yield(this) != coroutine_suspended) {
                                    responseCode = httpURLConnection.getResponseCode();
                                    SDKLog.d(f1.g, "Status Code : " + responseCode);
                                    this.d = coroutineScope;
                                    this.f457a = httpURLConnection;
                                    this.b = responseCode;
                                    this.c = 5;
                                    if (YieldKt.yield(this) != coroutine_suspended) {
                                        httpURLConnection2 = httpURLConnection;
                                        i = responseCode;
                                        Map<String, List<String>> headerFields2 = httpURLConnection2.getHeaderFields();
                                        it = headerFields2.entrySet().iterator();
                                        i2 = 0;
                                        while (it.hasNext()) {
                                            Map.Entry entry3 = (Map.Entry) it.next();
                                            str = (String) entry3.getKey();
                                            values = (List) entry3.getValue();
                                            if (str != null) {
                                                int length4 = str.length();
                                                if (values != null) {
                                                    Intrinsics.checkNotNullExpressionValue(values, "values");
                                                    i4 = 0;
                                                    while (r4.hasNext()) {
                                                        if (str6 != null) {
                                                            length2 = str6.length();
                                                        } else {
                                                            length2 = 0;
                                                        }
                                                        i4 += length2;
                                                    }
                                                } else {
                                                    i4 = 0;
                                                }
                                                i3 = length4 + i4;
                                            } else {
                                                i3 = 0;
                                            }
                                            i2 += i3;
                                        }
                                        f3.b(i2);
                                        f1Var2 = f1.this;
                                        Result.Companion companion11 = Result.INSTANCE;
                                        inputStream = httpURLConnection2.getInputStream();
                                        if (inputStream != null) {
                                            Intrinsics.checkNotNullExpressionValue(inputStream, "inputStream");
                                            bArrA2 = f1Var2.a(inputStream);
                                        } else {
                                            bArrA2 = null;
                                        }
                                        if (bArrA2 != null) {
                                            length = bArrA2.length;
                                        } else {
                                            length = 0;
                                        }
                                        f3.b(length);
                                        if (bArrA2 != null) {
                                            strA2 = f1Var2.a(bArrA2);
                                        } else {
                                            strA2 = null;
                                        }
                                        objM248constructorimpl2 = Result.m248constructorimpl(strA2);
                                        f1Var3 = f1.this;
                                        if (Result.m251exceptionOrNullimpl(objM248constructorimpl2) != null) {
                                            Result.Companion companion12 = Result.INSTANCE;
                                            errorStream = httpURLConnection2.getErrorStream();
                                            if (errorStream != null) {
                                                Intrinsics.checkNotNullExpressionValue(errorStream, "errorStream");
                                                bArrA = f1Var3.a(errorStream);
                                            } else {
                                                bArrA = null;
                                            }
                                            f3.b(bArrA != null ? bArrA.length : 0L);
                                            if (bArrA != null) {
                                                strA = f1Var3.a(bArrA);
                                            } else {
                                                strA = null;
                                            }
                                            objM248constructorimpl3 = Result.m248constructorimpl(strA);
                                            objM248constructorimpl2 = objM248constructorimpl3;
                                        }
                                        thM251exceptionOrNullimpl2 = Result.m251exceptionOrNullimpl(objM248constructorimpl2);
                                        if (thM251exceptionOrNullimpl2 != null) {
                                            thM251exceptionOrNullimpl2.getMessage();
                                        }
                                        if (Result.m254isFailureimpl(objM248constructorimpl2)) {
                                            objM248constructorimpl2 = null;
                                        }
                                        String str11 = (String) objM248constructorimpl2;
                                        SDKLog.d(f1.g, "Response Data : " + str11);
                                        return new e2(i, headerFields2, str11);
                                    }
                                }
                            }
                        } else {
                            this.d = coroutineScope;
                            this.f457a = httpURLConnection;
                            this.c = 4;
                            if (YieldKt.yield(this) != coroutine_suspended) {
                                responseCode = httpURLConnection.getResponseCode();
                                SDKLog.d(f1.g, "Status Code : " + responseCode);
                                this.d = coroutineScope;
                                this.f457a = httpURLConnection;
                                this.b = responseCode;
                                this.c = 5;
                                if (YieldKt.yield(this) != coroutine_suspended) {
                                    httpURLConnection2 = httpURLConnection;
                                    i = responseCode;
                                    Map<String, List<String>> headerFields3 = httpURLConnection2.getHeaderFields();
                                    it = headerFields3.entrySet().iterator();
                                    i2 = 0;
                                    while (it.hasNext()) {
                                        Map.Entry entry4 = (Map.Entry) it.next();
                                        str = (String) entry4.getKey();
                                        values = (List) entry4.getValue();
                                        if (str != null) {
                                            int length5 = str.length();
                                            if (values != null) {
                                                Intrinsics.checkNotNullExpressionValue(values, "values");
                                                i4 = 0;
                                                while (r4.hasNext()) {
                                                    if (str6 != null) {
                                                        length2 = str6.length();
                                                    } else {
                                                        length2 = 0;
                                                    }
                                                    i4 += length2;
                                                }
                                            } else {
                                                i4 = 0;
                                            }
                                            i3 = length5 + i4;
                                        } else {
                                            i3 = 0;
                                        }
                                        i2 += i3;
                                    }
                                    f3.b(i2);
                                    f1Var2 = f1.this;
                                    Result.Companion companion13 = Result.INSTANCE;
                                    inputStream = httpURLConnection2.getInputStream();
                                    if (inputStream != null) {
                                        Intrinsics.checkNotNullExpressionValue(inputStream, "inputStream");
                                        bArrA2 = f1Var2.a(inputStream);
                                    } else {
                                        bArrA2 = null;
                                    }
                                    if (bArrA2 != null) {
                                        length = bArrA2.length;
                                    } else {
                                        length = 0;
                                    }
                                    f3.b(length);
                                    if (bArrA2 != null) {
                                        strA2 = f1Var2.a(bArrA2);
                                    } else {
                                        strA2 = null;
                                    }
                                    objM248constructorimpl2 = Result.m248constructorimpl(strA2);
                                    f1Var3 = f1.this;
                                    if (Result.m251exceptionOrNullimpl(objM248constructorimpl2) != null) {
                                        Result.Companion companion14 = Result.INSTANCE;
                                        errorStream = httpURLConnection2.getErrorStream();
                                        if (errorStream != null) {
                                            Intrinsics.checkNotNullExpressionValue(errorStream, "errorStream");
                                            bArrA = f1Var3.a(errorStream);
                                        } else {
                                            bArrA = null;
                                        }
                                        f3.b(bArrA != null ? bArrA.length : 0L);
                                        if (bArrA != null) {
                                            strA = f1Var3.a(bArrA);
                                        } else {
                                            strA = null;
                                        }
                                        objM248constructorimpl3 = Result.m248constructorimpl(strA);
                                        objM248constructorimpl2 = objM248constructorimpl3;
                                    }
                                    thM251exceptionOrNullimpl2 = Result.m251exceptionOrNullimpl(objM248constructorimpl2);
                                    if (thM251exceptionOrNullimpl2 != null) {
                                        thM251exceptionOrNullimpl2.getMessage();
                                    }
                                    if (Result.m254isFailureimpl(objM248constructorimpl2)) {
                                        objM248constructorimpl2 = null;
                                    }
                                    String str12 = (String) objM248constructorimpl2;
                                    SDKLog.d(f1.g, "Response Data : " + str12);
                                    return new e2(i, headerFields3, str12);
                                }
                            }
                        }
                    }
                    return coroutine_suspended;
                } catch (MalformedURLException e) {
                    throw new IllegalStateException(e);
                }
            } catch (IOException e2) {
                return new e2(0, null, e2.getLocalizedMessage());
            }
        }
    }

    static {
        Intrinsics.checkNotNullExpressionValue("f1", "DefaultHttpRequest::class.java.simpleName");
        g = "f1";
    }

    public f1(com.nintendo.npf.sdk.internal.client.core.c requestParams, int i, int i2, CoroutineDispatcher ioDispatcher, CoroutineDispatcher timeoutJobDispatcher) {
        Intrinsics.checkNotNullParameter(requestParams, "requestParams");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        Intrinsics.checkNotNullParameter(timeoutJobDispatcher, "timeoutJobDispatcher");
        this.f453a = requestParams;
        this.b = i;
        this.c = i2;
        this.d = ioDispatcher;
        this.e = timeoutJobDispatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object b(Continuation continuation) {
        return BuildersKt.withContext(this.d, new d(null), continuation);
    }

    @Override // com.nintendo.npf.sdk.core.c2
    public Object a(Continuation continuation) {
        return CoroutineScopeKt.coroutineScope(new c(null), continuation);
    }

    public /* synthetic */ f1(com.nintendo.npf.sdk.internal.client.core.c cVar, int i, int i2, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(cVar, i, i2, (i3 & 8) != 0 ? Dispatchers.getIO() : coroutineDispatcher, (i3 & 16) != 0 ? Dispatchers.getIO() : coroutineDispatcher2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] a(InputStream inputStream) throws IOException {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[512];
                while (true) {
                    int i = bufferedInputStream.read(bArr);
                    if (i != -1) {
                        byteArrayOutputStream.write(bArr, 0, i);
                    } else {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        CloseableKt.closeFinally(bufferedInputStream, null);
                        CloseableKt.closeFinally(inputStream, null);
                        Intrinsics.checkNotNullExpressionValue(byteArray, "this.use { inputStream -…)\n            }\n        }");
                        return byteArray;
                    }
                    try {
                        throw th;
                    } catch (Throwable th) {
                        CloseableKt.closeFinally(inputStream, th);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    CloseableKt.closeFinally(bufferedInputStream, th2);
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            throw th4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String a(byte[] bArr) {
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        return new String(bArr, UTF_8);
    }
}

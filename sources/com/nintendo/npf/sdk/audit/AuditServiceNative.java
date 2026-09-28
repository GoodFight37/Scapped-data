package com.nintendo.npf.sdk.audit;

import com.nintendo.npf.sdk.core.y0;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/nintendo/npf/sdk/audit/AuditServiceNative;", "", "Lcom/nintendo/npf/sdk/audit/AuditService;", "auditService", "<init>", "(Lcom/nintendo/npf/sdk/audit/AuditService;)V", "", "Lcom/nintendo/npf/sdk/audit/ProfanityWord;", "profanityWords", "checkProfanityWord", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "Lcom/nintendo/npf/sdk/audit/AuditService;", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AuditServiceNative {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final AuditService auditService;

    static final class a extends Lambda implements Function1 {
        final /* synthetic */ List b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(List list) {
            super(1);
            this.b = list;
        }

        public final void a(Function2 it) {
            Intrinsics.checkNotNullParameter(it, "it");
            AuditServiceNative.this.auditService.checkProfanityWord(this.b, it);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Function2) obj);
            return Unit.INSTANCE;
        }
    }

    public AuditServiceNative(AuditService auditService) {
        Intrinsics.checkNotNullParameter(auditService, "auditService");
        this.auditService = auditService;
    }

    public final Object checkProfanityWord(List<ProfanityWord> list, Continuation<? super List<ProfanityWord>> continuation) {
        a aVar = new a(list);
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        aVar.invoke(new y0(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}

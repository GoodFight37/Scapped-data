package com.nintendo.npf.sdk.domain.service;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.core.r0;
import com.nintendo.npf.sdk.domain.repository.BaasAccountRepository;
import com.nintendo.npf.sdk.domain.repository.PromoCodeBundleRepository;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.promo.PromoCodeBundle;
import com.nintendo.npf.sdk.promo.PromoCodeService;
import com.nintendo.npf.sdk.user.BaaSUser;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 \u00152\u00020\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J3\u0010\u000e\u001a\u00020\f2\"\u0010\r\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f0\bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ3\u0010\u0010\u001a\u00020\f2\"\u0010\r\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f0\bH\u0016¢\u0006\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/nintendo/npf/sdk/domain/service/PromoCodeDefaultService;", "Lcom/nintendo/npf/sdk/promo/PromoCodeService;", "Lcom/nintendo/npf/sdk/domain/repository/BaasAccountRepository;", "baasAccountRepository", "Lcom/nintendo/npf/sdk/domain/repository/PromoCodeBundleRepository;", "promoCodeBundleRepository", "<init>", "(Lcom/nintendo/npf/sdk/domain/repository/BaasAccountRepository;Lcom/nintendo/npf/sdk/domain/repository/PromoCodeBundleRepository;)V", "Lkotlin/Function2;", "", "Lcom/nintendo/npf/sdk/promo/PromoCodeBundle;", "Lcom/nintendo/npf/sdk/NPFError;", "", "block", "checkPromoCodes", "(Lkotlin/jvm/functions/Function2;)V", "exchangePromoCodes", "a", "Lcom/nintendo/npf/sdk/domain/repository/BaasAccountRepository;", "b", "Lcom/nintendo/npf/sdk/domain/repository/PromoCodeBundleRepository;", "Companion", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PromoCodeDefaultService implements PromoCodeService {
    private static final String c = "PromoCodeDefaultService";

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final BaasAccountRepository baasAccountRepository;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final PromoCodeBundleRepository promoCodeBundleRepository;

    static final class b extends Lambda implements Function1 {
        final /* synthetic */ r0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(r0 r0Var) {
            super(1);
            this.b = r0Var;
        }

        public final void a(BaaSUser baaSUser) {
            PromoCodeBundleRepository promoCodeBundleRepository = PromoCodeDefaultService.this.promoCodeBundleRepository;
            Intrinsics.checkNotNull(baaSUser);
            promoCodeBundleRepository.find(baaSUser, this.b.a());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((BaaSUser) obj);
            return Unit.INSTANCE;
        }
    }

    static final class c extends Lambda implements Function1 {
        final /* synthetic */ r0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(r0 r0Var) {
            super(1);
            this.b = r0Var;
        }

        public final void a(BaaSUser baaSUser) {
            PromoCodeBundleRepository promoCodeBundleRepository = PromoCodeDefaultService.this.promoCodeBundleRepository;
            Intrinsics.checkNotNull(baaSUser);
            promoCodeBundleRepository.exchange(baaSUser, this.b.a());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((BaaSUser) obj);
            return Unit.INSTANCE;
        }
    }

    public PromoCodeDefaultService(BaasAccountRepository baasAccountRepository, PromoCodeBundleRepository promoCodeBundleRepository) {
        Intrinsics.checkNotNullParameter(baasAccountRepository, "baasAccountRepository");
        Intrinsics.checkNotNullParameter(promoCodeBundleRepository, "promoCodeBundleRepository");
        this.baasAccountRepository = baasAccountRepository;
        this.promoCodeBundleRepository = promoCodeBundleRepository;
    }

    @Override // com.nintendo.npf.sdk.promo.PromoCodeService
    public void checkPromoCodes(Function2<? super List<PromoCodeBundle>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        SDKLog.i(c, "checkPromoCodes is called");
        r0 r0VarA = r0.b.a(block);
        this.baasAccountRepository.findLoggedInAccount(r0VarA.a(new b(r0VarA)));
    }

    @Override // com.nintendo.npf.sdk.promo.PromoCodeService
    public void exchangePromoCodes(Function2<? super List<PromoCodeBundle>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        SDKLog.i(c, "exchangePromoCodes is called");
        r0 r0VarA = r0.b.a(block);
        this.baasAccountRepository.findLoggedInAccount(r0VarA.a(new c(r0VarA)));
    }
}

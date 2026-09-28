package com.nintendo.npf.sdk.domain.service;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.core.r0;
import com.nintendo.npf.sdk.domain.model.SubscriptionOwnership;
import com.nintendo.npf.sdk.domain.model.SubscriptionReplacement;
import com.nintendo.npf.sdk.domain.repository.BaasAccountRepository;
import com.nintendo.npf.sdk.domain.repository.SubscriptionOwnershipRepository;
import com.nintendo.npf.sdk.domain.repository.SubscriptionProductRepository;
import com.nintendo.npf.sdk.domain.repository.SubscriptionPurchaseRepository;
import com.nintendo.npf.sdk.domain.repository.SubscriptionReplacementRepository;
import com.nintendo.npf.sdk.domain.repository.SubscriptionTransactionRepository;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.subscription.SubscriptionProduct;
import com.nintendo.npf.sdk.subscription.SubscriptionPurchase;
import com.nintendo.npf.sdk.subscription.SubscriptionService;
import com.nintendo.npf.sdk.subscription.SubscriptionTransaction;
import com.nintendo.npf.sdk.user.BaaSUser;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 42\u00020\u0001:\u0001(B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ3\u0010\u0016\u001a\u00020\u00142\"\u0010\u0015\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u00140\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J3\u0010\u0019\u001a\u00020\u00142\"\u0010\u0015\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u00140\u0010H\u0016¢\u0006\u0004\b\u0019\u0010\u0017J3\u0010\u001a\u001a\u00020\u00142\"\u0010\u0015\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u00140\u0010H\u0016¢\u0006\u0004\b\u001a\u0010\u0017J-\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001b2\u0014\u0010\u0015\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u00140\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ3\u0010 \u001a\u00020\u00142\"\u0010\u0015\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u00140\u0010H\u0016¢\u0006\u0004\b \u0010\u0017J1\u0010$\u001a\u00020\u00142 \u0010\u0015\u001a\u001c\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u00140!H\u0016¢\u0006\u0004\b$\u0010%J3\u0010'\u001a\u00020\u00142\"\u0010\u0015\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020&\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u00140\u0010H\u0016¢\u0006\u0004\b'\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00065"}, d2 = {"Lcom/nintendo/npf/sdk/domain/service/SubscriptionDefaultService;", "Lcom/nintendo/npf/sdk/subscription/SubscriptionService;", "Lcom/nintendo/npf/sdk/domain/repository/BaasAccountRepository;", "baasAccountRepository", "Lcom/nintendo/npf/sdk/domain/repository/SubscriptionProductRepository;", "productRepository", "Lcom/nintendo/npf/sdk/domain/repository/SubscriptionPurchaseRepository;", "purchaseRepository", "Lcom/nintendo/npf/sdk/domain/repository/SubscriptionOwnershipRepository;", "ownershipRepository", "Lcom/nintendo/npf/sdk/domain/repository/SubscriptionReplacementRepository;", "replacementRepository", "Lcom/nintendo/npf/sdk/domain/repository/SubscriptionTransactionRepository;", "transactionRepository", "<init>", "(Lcom/nintendo/npf/sdk/domain/repository/BaasAccountRepository;Lcom/nintendo/npf/sdk/domain/repository/SubscriptionProductRepository;Lcom/nintendo/npf/sdk/domain/repository/SubscriptionPurchaseRepository;Lcom/nintendo/npf/sdk/domain/repository/SubscriptionOwnershipRepository;Lcom/nintendo/npf/sdk/domain/repository/SubscriptionReplacementRepository;Lcom/nintendo/npf/sdk/domain/repository/SubscriptionTransactionRepository;)V", "Lkotlin/Function2;", "", "Lcom/nintendo/npf/sdk/subscription/SubscriptionProduct;", "Lcom/nintendo/npf/sdk/NPFError;", "", "block", "getProducts", "(Lkotlin/jvm/functions/Function2;)V", "Lcom/nintendo/npf/sdk/subscription/SubscriptionPurchase;", "getPurchases", "getGlobalPurchases", "", "productId", "Lkotlin/Function1;", "purchase", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "updatePurchases", "Lkotlin/Function3;", "", "", "updateOwnerships", "(Lkotlin/jvm/functions/Function3;)V", "Lcom/nintendo/npf/sdk/subscription/SubscriptionTransaction;", "checkUnprocessedPurchases", "a", "Lcom/nintendo/npf/sdk/domain/repository/BaasAccountRepository;", "b", "Lcom/nintendo/npf/sdk/domain/repository/SubscriptionProductRepository;", "c", "Lcom/nintendo/npf/sdk/domain/repository/SubscriptionPurchaseRepository;", "d", "Lcom/nintendo/npf/sdk/domain/repository/SubscriptionOwnershipRepository;", "e", "Lcom/nintendo/npf/sdk/domain/repository/SubscriptionReplacementRepository;", "f", "Lcom/nintendo/npf/sdk/domain/repository/SubscriptionTransactionRepository;", "Companion", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SubscriptionDefaultService implements SubscriptionService {
    private static final String g = "SubscriptionDefaultService";

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final BaasAccountRepository baasAccountRepository;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final SubscriptionProductRepository productRepository;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final SubscriptionPurchaseRepository purchaseRepository;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final SubscriptionOwnershipRepository ownershipRepository;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final SubscriptionReplacementRepository replacementRepository;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final SubscriptionTransactionRepository transactionRepository;

    static final class b extends Lambda implements Function1 {
        final /* synthetic */ r0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(r0 r0Var) {
            super(1);
            this.b = r0Var;
        }

        public final void a(BaaSUser baaSUser) {
            SubscriptionTransactionRepository subscriptionTransactionRepository = SubscriptionDefaultService.this.transactionRepository;
            Intrinsics.checkNotNull(baaSUser);
            subscriptionTransactionRepository.findUnprocessedList(baaSUser, this.b.a());
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
            SubscriptionPurchaseRepository subscriptionPurchaseRepository = SubscriptionDefaultService.this.purchaseRepository;
            Intrinsics.checkNotNull(baaSUser);
            subscriptionPurchaseRepository.findGlobal(baaSUser, this.b.a());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((BaaSUser) obj);
            return Unit.INSTANCE;
        }
    }

    static final class d extends Lambda implements Function1 {
        final /* synthetic */ r0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(r0 r0Var) {
            super(1);
            this.b = r0Var;
        }

        public final void a(BaaSUser baaSUser) {
            SubscriptionProductRepository subscriptionProductRepository = SubscriptionDefaultService.this.productRepository;
            Intrinsics.checkNotNull(baaSUser);
            subscriptionProductRepository.find(baaSUser, this.b.a());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((BaaSUser) obj);
            return Unit.INSTANCE;
        }
    }

    static final class e extends Lambda implements Function1 {
        final /* synthetic */ r0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(r0 r0Var) {
            super(1);
            this.b = r0Var;
        }

        public final void a(BaaSUser baaSUser) {
            SubscriptionPurchaseRepository subscriptionPurchaseRepository = SubscriptionDefaultService.this.purchaseRepository;
            Intrinsics.checkNotNull(baaSUser);
            subscriptionPurchaseRepository.find(baaSUser, this.b.a());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((BaaSUser) obj);
            return Unit.INSTANCE;
        }
    }

    static final class f extends Lambda implements Function1 {
        final /* synthetic */ String b;
        final /* synthetic */ r0 c;
        final /* synthetic */ Function1 d;

        static final class a extends Lambda implements Function1 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ SubscriptionDefaultService f666a;
            final /* synthetic */ BaaSUser b;
            final /* synthetic */ String c;
            final /* synthetic */ Function1 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(SubscriptionDefaultService subscriptionDefaultService, BaaSUser baaSUser, String str, Function1 function1) {
                super(1);
                this.f666a = subscriptionDefaultService;
                this.b = baaSUser;
                this.c = str;
                this.d = function1;
            }

            public final void a(SubscriptionReplacement subscriptionReplacement) {
                this.f666a.purchaseRepository.create(this.b, this.c, subscriptionReplacement, this.d);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((SubscriptionReplacement) obj);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, r0 r0Var, Function1 function1) {
            super(1);
            this.b = str;
            this.c = r0Var;
            this.d = function1;
        }

        public final void a(BaaSUser baaSUser) {
            SubscriptionReplacementRepository subscriptionReplacementRepository = SubscriptionDefaultService.this.replacementRepository;
            Intrinsics.checkNotNull(baaSUser);
            String str = this.b;
            subscriptionReplacementRepository.find(baaSUser, str, this.c.a(new a(SubscriptionDefaultService.this, baaSUser, str, this.d)));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((BaaSUser) obj);
            return Unit.INSTANCE;
        }
    }

    static final class g extends Lambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function3 f667a;
        final /* synthetic */ SubscriptionDefaultService b;

        static final class a extends Lambda implements Function2 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Function3 f668a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Function3 function3) {
                super(2);
                this.f668a = function3;
            }

            public final void a(SubscriptionOwnership ownership, NPFError nPFError) {
                Intrinsics.checkNotNullParameter(ownership, "ownership");
                if (nPFError != null) {
                    this.f668a.invoke(-1, -1L, nPFError);
                } else {
                    this.f668a.invoke(Integer.valueOf(ownership.getResult()), Long.valueOf(ownership.getAllowedSince()), null);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((SubscriptionOwnership) obj, (NPFError) obj2);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(Function3 function3, SubscriptionDefaultService subscriptionDefaultService) {
            super(2);
            this.f667a = function3;
            this.b = subscriptionDefaultService;
        }

        public final void a(BaaSUser baaSUser, NPFError nPFError) {
            if (nPFError != null) {
                this.f667a.invoke(-1, -1L, nPFError);
                return;
            }
            SubscriptionOwnershipRepository subscriptionOwnershipRepository = this.b.ownershipRepository;
            Intrinsics.checkNotNull(baaSUser);
            subscriptionOwnershipRepository.update(baaSUser, new a(this.f667a));
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((BaaSUser) obj, (NPFError) obj2);
            return Unit.INSTANCE;
        }
    }

    static final class h extends Lambda implements Function1 {
        final /* synthetic */ r0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(r0 r0Var) {
            super(1);
            this.b = r0Var;
        }

        public final void a(BaaSUser baaSUser) {
            SubscriptionPurchaseRepository subscriptionPurchaseRepository = SubscriptionDefaultService.this.purchaseRepository;
            Intrinsics.checkNotNull(baaSUser);
            subscriptionPurchaseRepository.update(baaSUser, this.b.a());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((BaaSUser) obj);
            return Unit.INSTANCE;
        }
    }

    public SubscriptionDefaultService(BaasAccountRepository baasAccountRepository, SubscriptionProductRepository productRepository, SubscriptionPurchaseRepository purchaseRepository, SubscriptionOwnershipRepository ownershipRepository, SubscriptionReplacementRepository replacementRepository, SubscriptionTransactionRepository transactionRepository) {
        Intrinsics.checkNotNullParameter(baasAccountRepository, "baasAccountRepository");
        Intrinsics.checkNotNullParameter(productRepository, "productRepository");
        Intrinsics.checkNotNullParameter(purchaseRepository, "purchaseRepository");
        Intrinsics.checkNotNullParameter(ownershipRepository, "ownershipRepository");
        Intrinsics.checkNotNullParameter(replacementRepository, "replacementRepository");
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        this.baasAccountRepository = baasAccountRepository;
        this.productRepository = productRepository;
        this.purchaseRepository = purchaseRepository;
        this.ownershipRepository = ownershipRepository;
        this.replacementRepository = replacementRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override // com.nintendo.npf.sdk.subscription.SubscriptionService
    public void checkUnprocessedPurchases(Function2<? super List<SubscriptionTransaction>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        SDKLog.i(g, "checkUnprocessedPurchases is called");
        r0 r0VarA = r0.b.a(block);
        this.baasAccountRepository.findLoggedInAccount(r0VarA.a(new b(r0VarA)));
    }

    @Override // com.nintendo.npf.sdk.subscription.SubscriptionService
    public void getGlobalPurchases(Function2<? super List<SubscriptionPurchase>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        SDKLog.i(g, "getGlobalPurchases is called");
        r0 r0VarA = r0.b.a(block);
        this.baasAccountRepository.findLoggedInAccount(r0VarA.a(new c(r0VarA)));
    }

    @Override // com.nintendo.npf.sdk.subscription.SubscriptionService
    public void getProducts(Function2<? super List<SubscriptionProduct>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        SDKLog.i(g, "getProducts is called");
        r0 r0VarA = r0.b.a(block);
        this.baasAccountRepository.findLoggedInAccount(r0VarA.a(new d(r0VarA)));
    }

    @Override // com.nintendo.npf.sdk.subscription.SubscriptionService
    public void getPurchases(Function2<? super List<SubscriptionPurchase>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        SDKLog.i(g, "getPurchases is called");
        r0 r0VarA = r0.b.a(block);
        this.baasAccountRepository.findLoggedInAccount(r0VarA.a(new e(r0VarA)));
    }

    @Override // com.nintendo.npf.sdk.subscription.SubscriptionService
    public void purchase(String productId, Function1<? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(block, "block");
        SDKLog.i(g, "purchase is called");
        r0 r0VarA = r0.b.a(block);
        this.baasAccountRepository.findLoggedInAccount(r0VarA.a(new f(productId, r0VarA, block)));
    }

    @Override // com.nintendo.npf.sdk.subscription.SubscriptionService
    public void updateOwnerships(Function3<? super Integer, ? super Long, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        SDKLog.i(g, "updateOwnerships is called");
        this.baasAccountRepository.findLoggedInAccount(new g(block, this));
    }

    @Override // com.nintendo.npf.sdk.subscription.SubscriptionService
    public void updatePurchases(Function2<? super List<SubscriptionPurchase>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        SDKLog.i(g, "updatePurchases is called");
        r0 r0VarA = r0.b.a(block);
        this.baasAccountRepository.findLoggedInAccount(r0VarA.a(new h(r0VarA)));
    }
}

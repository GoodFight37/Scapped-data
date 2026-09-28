package com.nintendo.npf.sdk.domain.service;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFSDK;
import com.nintendo.npf.sdk.core.h0;
import com.nintendo.npf.sdk.core.r0;
import com.nintendo.npf.sdk.core.v3;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade;
import com.nintendo.npf.sdk.domain.model.VirtualCurrencyPurchaseAbility;
import com.nintendo.npf.sdk.domain.model.VirtualCurrencyPurchases;
import com.nintendo.npf.sdk.domain.repository.BaasAccountRepository;
import com.nintendo.npf.sdk.domain.repository.NintendoAccountRepository;
import com.nintendo.npf.sdk.domain.repository.VirtualCurrencyBundleRepository;
import com.nintendo.npf.sdk.domain.repository.VirtualCurrencyPurchaseAbilityRepository;
import com.nintendo.npf.sdk.domain.repository.VirtualCurrencyPurchaseRepository;
import com.nintendo.npf.sdk.domain.repository.VirtualCurrencyPurchaseSummaryRepository;
import com.nintendo.npf.sdk.domain.repository.VirtualCurrencyTransactionRepository;
import com.nintendo.npf.sdk.domain.repository.VirtualCurrencyWalletRepository;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import com.nintendo.npf.sdk.internal.billing.BillingHelper;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.user.NintendoAccount;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyBundle;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyPurchasedSummary;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyService;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyTransaction;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyWallet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b \u0018\u0000 R2\u00020\u0001:\u0001!Be\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJO\u0010!\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0004\u0012\u00020\u001f0\u001b2\"\u0010 \u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0004\u0012\u00020\u001f0\u001bH\u0002¢\u0006\u0004\b!\u0010\"J3\u0010$\u001a\u00020\u001f2\"\u0010 \u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020#\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0004\u0012\u00020\u001f0\u001bH\u0016¢\u0006\u0004\b$\u0010%JE\u0010)\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010'2\"\u0010 \u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0004\u0012\u00020\u001f0\u001bH\u0016¢\u0006\u0004\b)\u0010*J3\u0010,\u001a\u00020\u001f2\"\u0010 \u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020+\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0004\u0012\u00020\u001f0\u001bH\u0016¢\u0006\u0004\b,\u0010%J3\u0010-\u001a\u00020\u001f2\"\u0010 \u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0004\u0012\u00020\u001f0\u001bH\u0016¢\u0006\u0004\b-\u0010%J3\u0010.\u001a\u00020\u001f2\"\u0010 \u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0004\u0012\u00020\u001f0\u001bH\u0016¢\u0006\u0004\b.\u0010%J3\u0010/\u001a\u00020\u001f2\"\u0010 \u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0004\u0012\u00020\u001f0\u001bH\u0016¢\u0006\u0004\b/\u0010%J3\u00100\u001a\u00020\u001f2\"\u0010 \u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0004\u0012\u00020\u001f0\u001bH\u0016¢\u0006\u0004\b0\u0010%J;\u00104\u001a\u00020\u001f2\u0006\u00102\u001a\u0002012\"\u0010 \u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u000203\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0004\u0012\u00020\u001f0\u001bH\u0016¢\u0006\u0004\b4\u00105JC\u00107\u001a\u00020\u001f2\u0006\u00102\u001a\u0002012\u0006\u00106\u001a\u00020'2\"\u0010 \u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u000203\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0004\u0012\u00020\u001f0\u001bH\u0016¢\u0006\u0004\b7\u00108J;\u00109\u001a\u00020\u001f2\u0006\u00102\u001a\u0002012\"\u0010 \u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u000203\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0004\u0012\u00020\u001f0\u001bH\u0016¢\u0006\u0004\b9\u00105J\u0017\u0010;\u001a\u00020\u001f2\u0006\u0010:\u001a\u00020#H\u0007¢\u0006\u0004\b;\u0010<R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010=R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010Q¨\u0006S"}, d2 = {"Lcom/nintendo/npf/sdk/domain/service/VirtualCurrencyDefaultService;", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyService;", "Lcom/nintendo/npf/sdk/domain/repository/NintendoAccountRepository;", "nintendoAccountRepository", "Lcom/nintendo/npf/sdk/domain/datafacade/DeviceDataFacade;", "deviceDataFacade", "Lcom/nintendo/npf/sdk/domain/repository/BaasAccountRepository;", "baasAccountRepository", "Lcom/nintendo/npf/sdk/domain/repository/VirtualCurrencyBundleRepository;", "bundleRepository", "Lcom/nintendo/npf/sdk/domain/repository/VirtualCurrencyPurchaseAbilityRepository;", "purchaseAbilityRepository", "Lcom/nintendo/npf/sdk/domain/repository/VirtualCurrencyPurchaseRepository;", "purchaseRepository", "Lcom/nintendo/npf/sdk/domain/repository/VirtualCurrencyTransactionRepository;", "transactionRepository", "Lcom/nintendo/npf/sdk/domain/repository/VirtualCurrencyWalletRepository;", "walletRepository", "Lcom/nintendo/npf/sdk/domain/repository/VirtualCurrencyPurchaseSummaryRepository;", "purchaseSummaryRepository", "Lkotlin/Function0;", "Lcom/nintendo/npf/sdk/NPFSDK$EventHandler;", "eventHandlerProvider", "Lcom/nintendo/npf/sdk/domain/ErrorFactory;", "errorFactory", "<init>", "(Lcom/nintendo/npf/sdk/domain/repository/NintendoAccountRepository;Lcom/nintendo/npf/sdk/domain/datafacade/DeviceDataFacade;Lcom/nintendo/npf/sdk/domain/repository/BaasAccountRepository;Lcom/nintendo/npf/sdk/domain/repository/VirtualCurrencyBundleRepository;Lcom/nintendo/npf/sdk/domain/repository/VirtualCurrencyPurchaseAbilityRepository;Lcom/nintendo/npf/sdk/domain/repository/VirtualCurrencyPurchaseRepository;Lcom/nintendo/npf/sdk/domain/repository/VirtualCurrencyTransactionRepository;Lcom/nintendo/npf/sdk/domain/repository/VirtualCurrencyWalletRepository;Lcom/nintendo/npf/sdk/domain/repository/VirtualCurrencyPurchaseSummaryRepository;Lkotlin/jvm/functions/Function0;Lcom/nintendo/npf/sdk/domain/ErrorFactory;)V", "Lkotlin/Function2;", "", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyWallet;", "Lcom/nintendo/npf/sdk/NPFError;", "", "block", "a", "(Lkotlin/jvm/functions/Function2;)Lkotlin/jvm/functions/Function2;", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyBundle;", "getBundles", "(Lkotlin/jvm/functions/Function2;)V", "virtualCurrencyBundle", "", MapperConstants.VIRTUAL_CURRENCY_FIELD_PURCHASE_PRODUCT_INFO, "purchase", "(Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyBundle;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyTransaction;", "checkUnprocessedPurchases", "recoverPurchases", "restorePurchases", "getWallets", "getGlobalWallets", "", "timezoneOffsetInMinutes", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyPurchasedSummary;", "getSummaries", "(ILkotlin/jvm/functions/Function2;)V", "marketName", "getSummariesByMarket", "(ILjava/lang/String;Lkotlin/jvm/functions/Function2;)V", "getGlobalSummaries", "vcBundle", "sendPurchaseEmailToParent", "(Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyBundle;)V", "Lcom/nintendo/npf/sdk/domain/repository/NintendoAccountRepository;", "b", "Lcom/nintendo/npf/sdk/domain/datafacade/DeviceDataFacade;", "c", "Lcom/nintendo/npf/sdk/domain/repository/BaasAccountRepository;", "d", "Lcom/nintendo/npf/sdk/domain/repository/VirtualCurrencyBundleRepository;", "e", "Lcom/nintendo/npf/sdk/domain/repository/VirtualCurrencyPurchaseAbilityRepository;", "f", "Lcom/nintendo/npf/sdk/domain/repository/VirtualCurrencyPurchaseRepository;", "g", "Lcom/nintendo/npf/sdk/domain/repository/VirtualCurrencyTransactionRepository;", "h", "Lcom/nintendo/npf/sdk/domain/repository/VirtualCurrencyWalletRepository;", "i", "Lcom/nintendo/npf/sdk/domain/repository/VirtualCurrencyPurchaseSummaryRepository;", "j", "Lkotlin/jvm/functions/Function0;", "k", "Lcom/nintendo/npf/sdk/domain/ErrorFactory;", "Companion", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VirtualCurrencyDefaultService implements VirtualCurrencyService {
    private static final String l = "VirtualCurrencyDefaultService";

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final NintendoAccountRepository nintendoAccountRepository;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final DeviceDataFacade deviceDataFacade;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final BaasAccountRepository baasAccountRepository;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final VirtualCurrencyBundleRepository bundleRepository;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final VirtualCurrencyPurchaseAbilityRepository purchaseAbilityRepository;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final VirtualCurrencyPurchaseRepository purchaseRepository;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final VirtualCurrencyTransactionRepository transactionRepository;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final VirtualCurrencyWalletRepository walletRepository;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final VirtualCurrencyPurchaseSummaryRepository purchaseSummaryRepository;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final Function0 eventHandlerProvider;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final ErrorFactory errorFactory;

    static final class b extends Lambda implements Function2 {
        final /* synthetic */ Function2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Function2 function2) {
            super(2);
            this.b = function2;
        }

        public final void a(List list, NPFError nPFError) {
            if (nPFError != null) {
                ((NPFSDK.EventHandler) VirtualCurrencyDefaultService.this.eventHandlerProvider.invoke()).onVirtualCurrencyPurchaseProcessError(nPFError);
                this.b.invoke(null, nPFError);
                return;
            }
            NPFSDK.EventHandler eventHandler = (NPFSDK.EventHandler) VirtualCurrencyDefaultService.this.eventHandlerProvider.invoke();
            Intrinsics.checkNotNull(list);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                VirtualCurrencyWallet virtualCurrencyWallet = (VirtualCurrencyWallet) it.next();
                arrayList.add(TuplesKt.to(virtualCurrencyWallet.getVirtualCurrencyName(), virtualCurrencyWallet));
            }
            eventHandler.onVirtualCurrencyPurchaseProcessSuccess(MapsKt.toMap(arrayList));
            this.b.invoke(list, null);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((List) obj, (NPFError) obj2);
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
            VirtualCurrencyTransactionRepository virtualCurrencyTransactionRepository = VirtualCurrencyDefaultService.this.transactionRepository;
            Intrinsics.checkNotNull(baaSUser);
            virtualCurrencyTransactionRepository.findUnprocessedList(baaSUser, this.b.a());
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
            VirtualCurrencyBundleRepository virtualCurrencyBundleRepository = VirtualCurrencyDefaultService.this.bundleRepository;
            Intrinsics.checkNotNull(baaSUser);
            virtualCurrencyBundleRepository.find(baaSUser, this.b.a());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((BaaSUser) obj);
            return Unit.INSTANCE;
        }
    }

    static final class e extends Lambda implements Function1 {
        final /* synthetic */ int b;
        final /* synthetic */ r0 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(int i, r0 r0Var) {
            super(1);
            this.b = i;
            this.c = r0Var;
        }

        public final void a(BaaSUser baaSUser) {
            VirtualCurrencyPurchaseSummaryRepository virtualCurrencyPurchaseSummaryRepository = VirtualCurrencyDefaultService.this.purchaseSummaryRepository;
            Intrinsics.checkNotNull(baaSUser);
            virtualCurrencyPurchaseSummaryRepository.findGlobal(baaSUser, this.b, this.c.a());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((BaaSUser) obj);
            return Unit.INSTANCE;
        }
    }

    static final class f extends Lambda implements Function1 {
        final /* synthetic */ r0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(r0 r0Var) {
            super(1);
            this.b = r0Var;
        }

        public final void a(BaaSUser baaSUser) {
            VirtualCurrencyWalletRepository virtualCurrencyWalletRepository = VirtualCurrencyDefaultService.this.walletRepository;
            Intrinsics.checkNotNull(baaSUser);
            virtualCurrencyWalletRepository.findGlobal(baaSUser, this.b.a());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((BaaSUser) obj);
            return Unit.INSTANCE;
        }
    }

    static final class g extends Lambda implements Function1 {
        final /* synthetic */ String b;
        final /* synthetic */ int c;
        final /* synthetic */ r0 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(String str, int i, r0 r0Var) {
            super(1);
            this.b = str;
            this.c = i;
            this.d = r0Var;
        }

        public final void a(BaaSUser baaSUser) {
            VirtualCurrencyPurchaseSummaryRepository virtualCurrencyPurchaseSummaryRepository = VirtualCurrencyDefaultService.this.purchaseSummaryRepository;
            Intrinsics.checkNotNull(baaSUser);
            virtualCurrencyPurchaseSummaryRepository.find(baaSUser, this.b, this.c, this.d.a());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((BaaSUser) obj);
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
            VirtualCurrencyWalletRepository virtualCurrencyWalletRepository = VirtualCurrencyDefaultService.this.walletRepository;
            Intrinsics.checkNotNull(baaSUser);
            virtualCurrencyWalletRepository.find(baaSUser, this.b.a());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((BaaSUser) obj);
            return Unit.INSTANCE;
        }
    }

    static final class i extends Lambda implements Function1 {
        final /* synthetic */ r0 b;
        final /* synthetic */ VirtualCurrencyBundle c;
        final /* synthetic */ String d;

        static final class a extends Lambda implements Function1 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ VirtualCurrencyDefaultService f679a;
            final /* synthetic */ r0 b;
            final /* synthetic */ BaaSUser c;
            final /* synthetic */ VirtualCurrencyBundle d;
            final /* synthetic */ String e;

            /* JADX INFO: renamed from: com.nintendo.npf.sdk.domain.service.VirtualCurrencyDefaultService$i$a$a, reason: collision with other inner class name */
            static final class C0042a extends Lambda implements Function0 {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ VirtualCurrencyDefaultService f680a;
                final /* synthetic */ BaaSUser b;
                final /* synthetic */ VirtualCurrencyBundle c;
                final /* synthetic */ String d;
                final /* synthetic */ r0 e;

                /* JADX INFO: renamed from: com.nintendo.npf.sdk.domain.service.VirtualCurrencyDefaultService$i$a$a$a, reason: collision with other inner class name */
                static final class C0043a extends Lambda implements Function3 {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final /* synthetic */ VirtualCurrencyDefaultService f681a;
                    final /* synthetic */ VirtualCurrencyBundle b;
                    final /* synthetic */ r0 c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C0043a(VirtualCurrencyDefaultService virtualCurrencyDefaultService, VirtualCurrencyBundle virtualCurrencyBundle, r0 r0Var) {
                        super(3);
                        this.f681a = virtualCurrencyDefaultService;
                        this.b = virtualCurrencyBundle;
                        this.c = r0Var;
                    }

                    public final void a(VirtualCurrencyPurchases purchases, boolean z, NPFError nPFError) {
                        Intrinsics.checkNotNullParameter(purchases, "purchases");
                        if (z) {
                            this.f681a.sendPurchaseEmailToParent(this.b);
                        }
                        this.c.a(purchases.getWallets(), nPFError);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        a((VirtualCurrencyPurchases) obj, ((Boolean) obj2).booleanValue(), (NPFError) obj3);
                        return Unit.INSTANCE;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0042a(VirtualCurrencyDefaultService virtualCurrencyDefaultService, BaaSUser baaSUser, VirtualCurrencyBundle virtualCurrencyBundle, String str, r0 r0Var) {
                    super(0);
                    this.f680a = virtualCurrencyDefaultService;
                    this.b = baaSUser;
                    this.c = virtualCurrencyBundle;
                    this.d = str;
                    this.e = r0Var;
                }

                public final void a() {
                    VirtualCurrencyPurchaseRepository virtualCurrencyPurchaseRepository = this.f680a.purchaseRepository;
                    BaaSUser baaSUser = this.b;
                    VirtualCurrencyBundle virtualCurrencyBundle = this.c;
                    virtualCurrencyPurchaseRepository.create(baaSUser, virtualCurrencyBundle, this.d, new C0043a(this.f680a, virtualCurrencyBundle, this.e));
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    a();
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(VirtualCurrencyDefaultService virtualCurrencyDefaultService, r0 r0Var, BaaSUser baaSUser, VirtualCurrencyBundle virtualCurrencyBundle, String str) {
                super(1);
                this.f679a = virtualCurrencyDefaultService;
                this.b = r0Var;
                this.c = baaSUser;
                this.d = virtualCurrencyBundle;
                this.e = str;
            }

            public final void a(VirtualCurrencyPurchaseAbility purchaseAbility) {
                Intrinsics.checkNotNullParameter(purchaseAbility, "purchaseAbility");
                NPFError nPFErrorCreate_VirtualCurrency_PurchaseForbidden_403 = !purchaseAbility.isEnabled() ? this.f679a.errorFactory.create_VirtualCurrency_PurchaseForbidden_403() : null;
                r0 r0Var = this.b;
                r0Var.a(nPFErrorCreate_VirtualCurrency_PurchaseForbidden_403, new C0042a(this.f679a, this.c, this.d, this.e, r0Var));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((VirtualCurrencyPurchaseAbility) obj);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(r0 r0Var, VirtualCurrencyBundle virtualCurrencyBundle, String str) {
            super(1);
            this.b = r0Var;
            this.c = virtualCurrencyBundle;
            this.d = str;
        }

        public final void a(BaaSUser baaSUser) {
            VirtualCurrencyPurchaseAbilityRepository virtualCurrencyPurchaseAbilityRepository = VirtualCurrencyDefaultService.this.purchaseAbilityRepository;
            Intrinsics.checkNotNull(baaSUser);
            r0 r0Var = this.b;
            virtualCurrencyPurchaseAbilityRepository.find(baaSUser, r0Var.a(new a(VirtualCurrencyDefaultService.this, r0Var, baaSUser, this.c, this.d)));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((BaaSUser) obj);
            return Unit.INSTANCE;
        }
    }

    static final class j extends Lambda implements Function1 {
        final /* synthetic */ r0 b;

        static final class a extends Lambda implements Function2 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ r0 f683a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(r0 r0Var) {
                super(2);
                this.f683a = r0Var;
            }

            public final void a(VirtualCurrencyPurchases purchases, NPFError nPFError) {
                Intrinsics.checkNotNullParameter(purchases, "purchases");
                this.f683a.a(purchases.getWallets(), nPFError);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((VirtualCurrencyPurchases) obj, (NPFError) obj2);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(r0 r0Var) {
            super(1);
            this.b = r0Var;
        }

        public final void a(BaaSUser baaSUser) {
            VirtualCurrencyPurchaseRepository virtualCurrencyPurchaseRepository = VirtualCurrencyDefaultService.this.purchaseRepository;
            Intrinsics.checkNotNull(baaSUser);
            virtualCurrencyPurchaseRepository.recover(baaSUser, new a(this.b));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((BaaSUser) obj);
            return Unit.INSTANCE;
        }
    }

    static final class k extends Lambda implements Function1 {
        final /* synthetic */ r0 b;

        static final class a extends Lambda implements Function2 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ r0 f685a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(r0 r0Var) {
                super(2);
                this.f685a = r0Var;
            }

            public final void a(VirtualCurrencyPurchases purchases, NPFError nPFError) {
                Intrinsics.checkNotNullParameter(purchases, "purchases");
                this.f685a.a(purchases.getWallets(), nPFError);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((VirtualCurrencyPurchases) obj, (NPFError) obj2);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(r0 r0Var) {
            super(1);
            this.b = r0Var;
        }

        public final void a(BaaSUser baaSUser) {
            VirtualCurrencyPurchaseRepository virtualCurrencyPurchaseRepository = VirtualCurrencyDefaultService.this.purchaseRepository;
            Intrinsics.checkNotNull(baaSUser);
            virtualCurrencyPurchaseRepository.restore(baaSUser, new a(this.b));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((BaaSUser) obj);
            return Unit.INSTANCE;
        }
    }

    static final class l extends Lambda implements Function1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f686a = new l();

        l() {
            super(1);
        }

        public final void a(NPFError nPFError) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((NPFError) obj);
            return Unit.INSTANCE;
        }
    }

    public VirtualCurrencyDefaultService(NintendoAccountRepository nintendoAccountRepository, DeviceDataFacade deviceDataFacade, BaasAccountRepository baasAccountRepository, VirtualCurrencyBundleRepository bundleRepository, VirtualCurrencyPurchaseAbilityRepository purchaseAbilityRepository, VirtualCurrencyPurchaseRepository purchaseRepository, VirtualCurrencyTransactionRepository transactionRepository, VirtualCurrencyWalletRepository walletRepository, VirtualCurrencyPurchaseSummaryRepository purchaseSummaryRepository, Function0<? extends NPFSDK.EventHandler> eventHandlerProvider, ErrorFactory errorFactory) {
        Intrinsics.checkNotNullParameter(nintendoAccountRepository, "nintendoAccountRepository");
        Intrinsics.checkNotNullParameter(deviceDataFacade, "deviceDataFacade");
        Intrinsics.checkNotNullParameter(baasAccountRepository, "baasAccountRepository");
        Intrinsics.checkNotNullParameter(bundleRepository, "bundleRepository");
        Intrinsics.checkNotNullParameter(purchaseAbilityRepository, "purchaseAbilityRepository");
        Intrinsics.checkNotNullParameter(purchaseRepository, "purchaseRepository");
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        Intrinsics.checkNotNullParameter(walletRepository, "walletRepository");
        Intrinsics.checkNotNullParameter(purchaseSummaryRepository, "purchaseSummaryRepository");
        Intrinsics.checkNotNullParameter(eventHandlerProvider, "eventHandlerProvider");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        this.nintendoAccountRepository = nintendoAccountRepository;
        this.deviceDataFacade = deviceDataFacade;
        this.baasAccountRepository = baasAccountRepository;
        this.bundleRepository = bundleRepository;
        this.purchaseAbilityRepository = purchaseAbilityRepository;
        this.purchaseRepository = purchaseRepository;
        this.transactionRepository = transactionRepository;
        this.walletRepository = walletRepository;
        this.purchaseSummaryRepository = purchaseSummaryRepository;
        this.eventHandlerProvider = eventHandlerProvider;
        this.errorFactory = errorFactory;
    }

    private final Function2 a(Function2 block) {
        return new b(block);
    }

    @Override // com.nintendo.npf.sdk.vcm.VirtualCurrencyService
    public void checkUnprocessedPurchases(Function2<? super List<VirtualCurrencyTransaction>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        SDKLog.i(l, "checkUnprocessedPurchases is called");
        r0 r0VarA = r0.b.a(block);
        this.baasAccountRepository.findLoggedInAccount(r0VarA.a(new c(r0VarA)));
    }

    @Override // com.nintendo.npf.sdk.vcm.VirtualCurrencyService
    public void getBundles(Function2<? super List<VirtualCurrencyBundle>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        SDKLog.i(l, "getBundles is called");
        r0 r0VarA = r0.b.a(block);
        this.baasAccountRepository.findLoggedInAccount(r0VarA.a(new d(r0VarA)));
    }

    @Override // com.nintendo.npf.sdk.vcm.VirtualCurrencyService
    public void getGlobalSummaries(int timezoneOffsetInMinutes, Function2<? super List<VirtualCurrencyPurchasedSummary>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        SDKLog.i(l, "getGlobalSummaries is called");
        r0 r0VarA = r0.b.a(block);
        this.baasAccountRepository.findLoggedInAccount(r0VarA.a(new e(timezoneOffsetInMinutes, r0VarA)));
    }

    @Override // com.nintendo.npf.sdk.vcm.VirtualCurrencyService
    public void getGlobalWallets(Function2<? super List<VirtualCurrencyWallet>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        SDKLog.i(l, "getGlobalWallets is called");
        r0 r0VarA = r0.b.a(block);
        this.baasAccountRepository.findLoggedInAccount(r0VarA.a(new f(r0VarA)));
    }

    @Override // com.nintendo.npf.sdk.vcm.VirtualCurrencyService
    public void getSummaries(int timezoneOffsetInMinutes, Function2<? super List<VirtualCurrencyPurchasedSummary>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        SDKLog.i(l, "getSummaries is called");
        getSummariesByMarket(timezoneOffsetInMinutes, BillingHelper.getMarket(), block);
    }

    @Override // com.nintendo.npf.sdk.vcm.VirtualCurrencyService
    public void getSummariesByMarket(int timezoneOffsetInMinutes, String marketName, Function2<? super List<VirtualCurrencyPurchasedSummary>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(marketName, "marketName");
        Intrinsics.checkNotNullParameter(block, "block");
        SDKLog.i(l, "getSummariesByMarket is called");
        r0 r0VarA = r0.b.a(block);
        this.baasAccountRepository.findLoggedInAccount(r0VarA.a(new g(marketName, timezoneOffsetInMinutes, r0VarA)));
    }

    @Override // com.nintendo.npf.sdk.vcm.VirtualCurrencyService
    public void getWallets(Function2<? super List<VirtualCurrencyWallet>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        SDKLog.i(l, "getWallets is called");
        r0 r0VarA = r0.b.a(block);
        this.baasAccountRepository.findLoggedInAccount(r0VarA.a(new h(r0VarA)));
    }

    @Override // com.nintendo.npf.sdk.vcm.VirtualCurrencyService
    public void purchase(VirtualCurrencyBundle virtualCurrencyBundle, String purchaseProductInfo, Function2<? super List<VirtualCurrencyWallet>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(virtualCurrencyBundle, "virtualCurrencyBundle");
        Intrinsics.checkNotNullParameter(block, "block");
        SDKLog.i(l, "purchase is called");
        r0 r0VarA = r0.b.a(a(block));
        this.baasAccountRepository.findLoggedInAccount(r0VarA.a(new i(r0VarA, virtualCurrencyBundle, purchaseProductInfo)));
    }

    @Override // com.nintendo.npf.sdk.vcm.VirtualCurrencyService
    public void recoverPurchases(Function2<? super List<VirtualCurrencyWallet>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        SDKLog.i(l, "recoverPurchases is called");
        r0 r0VarA = r0.b.a(a(block));
        this.baasAccountRepository.findLoggedInAccount(r0VarA.a(new j(r0VarA)));
    }

    @Override // com.nintendo.npf.sdk.vcm.VirtualCurrencyService
    public void restorePurchases(Function2<? super List<VirtualCurrencyWallet>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        SDKLog.i(l, "restorePurchases is called");
        r0 r0VarA = r0.b.a(a(block));
        this.baasAccountRepository.findLoggedInAccount(r0VarA.a(new k(r0VarA)));
    }

    public final void sendPurchaseEmailToParent(VirtualCurrencyBundle vcBundle) {
        NintendoAccount nintendoAccount;
        Intrinsics.checkNotNullParameter(vcBundle, "vcBundle");
        SDKLog.i(l, "Send purchase email!");
        BaaSUser currentBaasUser = this.baasAccountRepository.getCurrentBaasUser();
        if (h0.c(currentBaasUser) && (nintendoAccount = currentBaasUser.getNintendoAccount()) != null && v3.a(nintendoAccount)) {
            this.nintendoAccountRepository.sendVcmEmailToParent(nintendoAccount, this.deviceDataFacade.getAppName(), BillingHelper.getMarket(), vcBundle.getTitle(), vcBundle.getDisplayPrice(), l.f686a);
        }
    }
}

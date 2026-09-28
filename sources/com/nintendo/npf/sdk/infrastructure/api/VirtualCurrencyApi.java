package com.nintendo.npf.sdk.infrastructure.api;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.core.b2;
import com.nintendo.npf.sdk.core.q4;
import com.nintendo.npf.sdk.core.r4;
import com.nintendo.npf.sdk.core.u2;
import com.nintendo.npf.sdk.core.v2;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.domain.model.VirtualCurrencyPurchaseAbility;
import com.nintendo.npf.sdk.domain.model.VirtualCurrencyPurchases;
import com.nintendo.npf.sdk.infrastructure.mapper.VirtualCurrencyBundleMapper;
import com.nintendo.npf.sdk.infrastructure.mapper.VirtualCurrencyPurchaseAbilityMapper;
import com.nintendo.npf.sdk.infrastructure.mapper.VirtualCurrencyPurchasedSummaryMapper;
import com.nintendo.npf.sdk.infrastructure.mapper.VirtualCurrencyPurchasesMapper;
import com.nintendo.npf.sdk.infrastructure.mapper.VirtualCurrencyWalletMapper;
import com.nintendo.npf.sdk.internal.client.core.HttpClient;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyBundle;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyPurchasedSummary;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyWallet;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 B2\u00020\u0001:\u00014B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J?\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142 \u0010\u001b\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u001a0\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ1\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00122\u001a\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u001a0\u0016¢\u0006\u0004\b\u001f\u0010 JA\u0010$\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020!2\u001a\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020#\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u001a0\u0016¢\u0006\u0004\b$\u0010%JO\u0010(\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u000e\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140&2 \u0010\u001b\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140&\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u001a0\u0016¢\u0006\u0004\b(\u0010)J?\u0010+\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142 \u0010\u001b\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u001a0\u0016¢\u0006\u0004\b+\u0010\u001dJ7\u0010,\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00122 \u0010\u001b\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u001a0\u0016¢\u0006\u0004\b,\u0010 JO\u00100\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u00142 \u0010\u001b\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u001a0\u0016¢\u0006\u0004\b0\u00101JG\u00102\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u00142 \u0010\u001b\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u001a0\u0016¢\u0006\u0004\b2\u00103R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006C"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/api/VirtualCurrencyApi;", "", "Lcom/nintendo/npf/sdk/internal/client/core/HttpClient;", "client", "Lcom/nintendo/npf/sdk/infrastructure/mapper/VirtualCurrencyBundleMapper;", "bundleMapper", "Lcom/nintendo/npf/sdk/infrastructure/mapper/VirtualCurrencyPurchaseAbilityMapper;", "purchaseAbilityMapper", "Lcom/nintendo/npf/sdk/infrastructure/mapper/VirtualCurrencyPurchasesMapper;", "purchasesMapper", "Lcom/nintendo/npf/sdk/infrastructure/mapper/VirtualCurrencyWalletMapper;", "walletMapper", "Lcom/nintendo/npf/sdk/infrastructure/mapper/VirtualCurrencyPurchasedSummaryMapper;", "purchaseSummaryMapper", "Lcom/nintendo/npf/sdk/domain/ErrorFactory;", "errorFactory", "<init>", "(Lcom/nintendo/npf/sdk/internal/client/core/HttpClient;Lcom/nintendo/npf/sdk/infrastructure/mapper/VirtualCurrencyBundleMapper;Lcom/nintendo/npf/sdk/infrastructure/mapper/VirtualCurrencyPurchaseAbilityMapper;Lcom/nintendo/npf/sdk/infrastructure/mapper/VirtualCurrencyPurchasesMapper;Lcom/nintendo/npf/sdk/infrastructure/mapper/VirtualCurrencyWalletMapper;Lcom/nintendo/npf/sdk/infrastructure/mapper/VirtualCurrencyPurchasedSummaryMapper;Lcom/nintendo/npf/sdk/domain/ErrorFactory;)V", "Lcom/nintendo/npf/sdk/user/BaaSUser;", "user", "", "market", "Lkotlin/Function2;", "", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyBundle;", "Lcom/nintendo/npf/sdk/NPFError;", "", "block", "getBundles", "(Lcom/nintendo/npf/sdk/user/BaaSUser;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "Lcom/nintendo/npf/sdk/domain/model/VirtualCurrencyPurchaseAbility;", "getPurchaseAbility", "(Lcom/nintendo/npf/sdk/user/BaaSUser;Lkotlin/jvm/functions/Function2;)V", "Lorg/json/JSONObject;", "receipt", "Lcom/nintendo/npf/sdk/domain/model/VirtualCurrencyPurchases;", "createPurchases", "(Lcom/nintendo/npf/sdk/user/BaaSUser;Ljava/lang/String;Lorg/json/JSONObject;Lkotlin/jvm/functions/Function2;)V", "", "orderIds", "getOrderIds", "(Lcom/nintendo/npf/sdk/user/BaaSUser;Ljava/lang/String;Ljava/util/Set;Lkotlin/jvm/functions/Function2;)V", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyWallet;", "getWallets", "getGlobalWallets", "timezone", "endpoint", "Lcom/nintendo/npf/sdk/vcm/VirtualCurrencyPurchasedSummary;", "getPurchaseSummaries", "(Lcom/nintendo/npf/sdk/user/BaaSUser;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "getGlobalPurchaseSummaries", "(Lcom/nintendo/npf/sdk/user/BaaSUser;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "a", "Lcom/nintendo/npf/sdk/internal/client/core/HttpClient;", "b", "Lcom/nintendo/npf/sdk/infrastructure/mapper/VirtualCurrencyBundleMapper;", "c", "Lcom/nintendo/npf/sdk/infrastructure/mapper/VirtualCurrencyPurchaseAbilityMapper;", "d", "Lcom/nintendo/npf/sdk/infrastructure/mapper/VirtualCurrencyPurchasesMapper;", "e", "Lcom/nintendo/npf/sdk/infrastructure/mapper/VirtualCurrencyWalletMapper;", "f", "Lcom/nintendo/npf/sdk/infrastructure/mapper/VirtualCurrencyPurchasedSummaryMapper;", "g", "Lcom/nintendo/npf/sdk/domain/ErrorFactory;", "Companion", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VirtualCurrencyApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final HttpClient client;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final VirtualCurrencyBundleMapper bundleMapper;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final VirtualCurrencyPurchaseAbilityMapper purchaseAbilityMapper;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final VirtualCurrencyPurchasesMapper purchasesMapper;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final VirtualCurrencyWalletMapper walletMapper;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final VirtualCurrencyPurchasedSummaryMapper purchaseSummaryMapper;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final ErrorFactory errorFactory;

    public VirtualCurrencyApi(HttpClient client, VirtualCurrencyBundleMapper bundleMapper, VirtualCurrencyPurchaseAbilityMapper purchaseAbilityMapper, VirtualCurrencyPurchasesMapper purchasesMapper, VirtualCurrencyWalletMapper walletMapper, VirtualCurrencyPurchasedSummaryMapper purchaseSummaryMapper, ErrorFactory errorFactory) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(bundleMapper, "bundleMapper");
        Intrinsics.checkNotNullParameter(purchaseAbilityMapper, "purchaseAbilityMapper");
        Intrinsics.checkNotNullParameter(purchasesMapper, "purchasesMapper");
        Intrinsics.checkNotNullParameter(walletMapper, "walletMapper");
        Intrinsics.checkNotNullParameter(purchaseSummaryMapper, "purchaseSummaryMapper");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        this.client = client;
        this.bundleMapper = bundleMapper;
        this.purchaseAbilityMapper = purchaseAbilityMapper;
        this.purchasesMapper = purchasesMapper;
        this.walletMapper = walletMapper;
        this.purchaseSummaryMapper = purchaseSummaryMapper;
        this.errorFactory = errorFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Function2 block, VirtualCurrencyApi this$0, JSONArray jSONArray, NPFError nPFError) {
        Intrinsics.checkNotNullParameter(block, "$block");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (nPFError != null) {
            block.invoke(CollectionsKt.emptyList(), nPFError);
            return;
        }
        try {
            block.invoke(this$0.bundleMapper.fromCustomJSON(jSONArray), null);
        } catch (JSONException e) {
            block.invoke(CollectionsKt.emptyList(), this$0.errorFactory.create_Mapper_InvalidJson_422(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function2 block, VirtualCurrencyApi this$0, JSONObject jSONObject, NPFError nPFError) {
        Intrinsics.checkNotNullParameter(block, "$block");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (nPFError != null) {
            block.invoke(new VirtualCurrencyPurchaseAbility(false), nPFError);
            return;
        }
        try {
            VirtualCurrencyPurchaseAbility virtualCurrencyPurchaseAbilityFromJSON = this$0.purchaseAbilityMapper.fromJSON(jSONObject);
            if (virtualCurrencyPurchaseAbilityFromJSON != null) {
                block.invoke(virtualCurrencyPurchaseAbilityFromJSON, null);
            } else {
                block.invoke(new VirtualCurrencyPurchaseAbility(false), null);
            }
        } catch (JSONException e) {
            block.invoke(new VirtualCurrencyPurchaseAbility(false), this$0.errorFactory.create_Mapper_InvalidJson_422(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Function2 block, VirtualCurrencyApi this$0, JSONArray jSONArray, NPFError nPFError) {
        Intrinsics.checkNotNullParameter(block, "$block");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (nPFError != null) {
            block.invoke(CollectionsKt.emptyList(), nPFError);
            return;
        }
        try {
            List<Object> listFromJSON = this$0.walletMapper.fromJSON(jSONArray);
            Intrinsics.checkNotNullExpressionValue(listFromJSON, "walletMapper.fromJSON(response)");
            block.invoke(listFromJSON, null);
        } catch (JSONException e) {
            block.invoke(CollectionsKt.emptyList(), this$0.errorFactory.create_Mapper_InvalidJson_422(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function2 block, VirtualCurrencyApi this$0, JSONArray jSONArray, NPFError nPFError) {
        Intrinsics.checkNotNullParameter(block, "$block");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (nPFError != null) {
            if (404 == nPFError.getErrorCode()) {
                block.invoke(SetsKt.emptySet(), null);
                return;
            } else {
                block.invoke(SetsKt.emptySet(), nPFError);
                return;
            }
        }
        try {
            block.invoke(this$0.purchasesMapper.orderIdsFromJSON(jSONArray), null);
        } catch (JSONException e) {
            block.invoke(SetsKt.emptySet(), this$0.errorFactory.create_Mapper_InvalidJson_422(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function2 block, VirtualCurrencyApi this$0, JSONArray jSONArray, NPFError nPFError) {
        Intrinsics.checkNotNullParameter(block, "$block");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (nPFError != null) {
            block.invoke(CollectionsKt.emptyList(), nPFError);
            return;
        }
        try {
            List<Object> listFromJSON = this$0.purchaseSummaryMapper.fromJSON(jSONArray);
            Intrinsics.checkNotNullExpressionValue(listFromJSON, "purchaseSummaryMapper.fromJSON(response)");
            block.invoke(listFromJSON, null);
        } catch (JSONException e) {
            block.invoke(CollectionsKt.emptyList(), this$0.errorFactory.create_Mapper_InvalidJson_422(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function2 block, VirtualCurrencyApi this$0, JSONArray jSONArray, NPFError nPFError) {
        Intrinsics.checkNotNullParameter(block, "$block");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (nPFError != null) {
            block.invoke(CollectionsKt.emptyList(), nPFError);
            return;
        }
        try {
            List<Object> listFromJSON = this$0.walletMapper.fromJSON(jSONArray);
            Intrinsics.checkNotNullExpressionValue(listFromJSON, "walletMapper.fromJSON(response)");
            block.invoke(listFromJSON, null);
        } catch (JSONException e) {
            block.invoke(CollectionsKt.emptyList(), this$0.errorFactory.create_Mapper_InvalidJson_422(e));
        }
    }

    public final void createPurchases(BaaSUser user, String market, JSONObject receipt, final Function2<? super VirtualCurrencyPurchases, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(market, "market");
        Intrinsics.checkNotNullParameter(receipt, "receipt");
        Intrinsics.checkNotNullParameter(block, "block");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%1$s/users/%2$s/markets/%3$s/transactions", Arrays.copyOf(new Object[]{"/vcm/v1", user.getUserId(), market}, 3));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        this.client.a(str, b2.c(user.getAccessToken()), (Map) null, q4.a(receipt), "application/json", true, (r4) new v2() { // from class: com.nintendo.npf.sdk.infrastructure.api.VirtualCurrencyApi$$ExternalSyntheticLambda6
            @Override // com.nintendo.npf.sdk.core.v2
            public final void a(JSONObject jSONObject, NPFError nPFError) {
                VirtualCurrencyApi.a(block, this, jSONObject, nPFError);
            }
        });
    }

    public final void getBundles(BaaSUser user, String market, final Function2<? super List<VirtualCurrencyBundle>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(market, "market");
        Intrinsics.checkNotNullParameter(block, "block");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%1$s/markets/%2$s/bundles", Arrays.copyOf(new Object[]{"/vcm/v1", market}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        this.client.a(str, b2.c(user.getAccessToken()), null, true, new u2() { // from class: com.nintendo.npf.sdk.infrastructure.api.VirtualCurrencyApi$$ExternalSyntheticLambda7
            @Override // com.nintendo.npf.sdk.core.u2
            public final void a(JSONArray jSONArray, NPFError nPFError) {
                VirtualCurrencyApi.a(block, this, jSONArray, nPFError);
            }
        });
    }

    public final void getGlobalPurchaseSummaries(BaaSUser user, String timezone, String endpoint, final Function2<? super List<VirtualCurrencyPurchasedSummary>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(timezone, "timezone");
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        Intrinsics.checkNotNullParameter(block, "block");
        String str = String.format(Locale.US, "%1$s/users/%2$s/%3$s/split", "/vcm/v1", user.getUserId(), endpoint);
        Intrinsics.checkNotNullExpressionValue(str, "format(\n            Loca…       endpoint\n        )");
        this.client.a(str, b2.c(user.getAccessToken()), MapsKt.mapOf(TuplesKt.to("timezone", timezone)), true, new u2() { // from class: com.nintendo.npf.sdk.infrastructure.api.VirtualCurrencyApi$$ExternalSyntheticLambda5
            @Override // com.nintendo.npf.sdk.core.u2
            public final void a(JSONArray jSONArray, NPFError nPFError) {
                VirtualCurrencyApi.b(block, this, jSONArray, nPFError);
            }
        });
    }

    public final void getGlobalWallets(BaaSUser user, final Function2<? super List<VirtualCurrencyWallet>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(block, "block");
        String path = String.format(Locale.US, "%1$s/users/%2$s/wallets/split", "/vcm/v1", user.getUserId());
        Map mapC = b2.c(user.getAccessToken());
        HttpClient httpClient = this.client;
        Intrinsics.checkNotNullExpressionValue(path, "path");
        httpClient.a(path, mapC, null, true, new u2() { // from class: com.nintendo.npf.sdk.infrastructure.api.VirtualCurrencyApi$$ExternalSyntheticLambda0
            @Override // com.nintendo.npf.sdk.core.u2
            public final void a(JSONArray jSONArray, NPFError nPFError) {
                VirtualCurrencyApi.c(block, this, jSONArray, nPFError);
            }
        });
    }

    public final void getOrderIds(BaaSUser user, String market, Set<String> orderIds, final Function2<? super Set<String>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(market, "market");
        Intrinsics.checkNotNullParameter(orderIds, "orderIds");
        Intrinsics.checkNotNullParameter(block, "block");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%1$s/users/%2$s/markets/%3$s/transactions", Arrays.copyOf(new Object[]{"/vcm/v1", user.getUserId(), market}, 3));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        Map mapC = b2.c(user.getAccessToken());
        HashMap map = new HashMap();
        if (!orderIds.isEmpty()) {
            map.put("filter.extras.orderId.$in", CollectionsKt.joinToString$default(orderIds, ",", null, null, 0, null, null, 62, null));
        }
        this.client.a(str, mapC, map, true, new u2() { // from class: com.nintendo.npf.sdk.infrastructure.api.VirtualCurrencyApi$$ExternalSyntheticLambda2
            @Override // com.nintendo.npf.sdk.core.u2
            public final void a(JSONArray jSONArray, NPFError nPFError) {
                VirtualCurrencyApi.d(block, this, jSONArray, nPFError);
            }
        });
    }

    public final void getPurchaseAbility(BaaSUser user, final Function2<? super VirtualCurrencyPurchaseAbility, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(block, "block");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%1$s/users/%2$s/ability", Arrays.copyOf(new Object[]{"/vcm/v1", user.getUserId()}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        this.client.a(str, b2.c(user.getAccessToken()), null, true, new v2() { // from class: com.nintendo.npf.sdk.infrastructure.api.VirtualCurrencyApi$$ExternalSyntheticLambda4
            @Override // com.nintendo.npf.sdk.core.v2
            public final void a(JSONObject jSONObject, NPFError nPFError) {
                VirtualCurrencyApi.b(block, this, jSONObject, nPFError);
            }
        });
    }

    public final void getPurchaseSummaries(BaaSUser user, String market, String timezone, String endpoint, final Function2<? super List<VirtualCurrencyPurchasedSummary>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(market, "market");
        Intrinsics.checkNotNullParameter(timezone, "timezone");
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        Intrinsics.checkNotNullParameter(block, "block");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale US = Locale.US;
        String userId = user.getUserId();
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String upperCase = market.toUpperCase(US);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        String str = String.format(US, "%1$s/users/%2$s/markets/%3$s/%4$s", Arrays.copyOf(new Object[]{"/vcm/v1", userId, upperCase, endpoint}, 4));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        this.client.a(str, b2.c(user.getAccessToken()), MapsKt.mapOf(TuplesKt.to("timezone", timezone)), true, new u2() { // from class: com.nintendo.npf.sdk.infrastructure.api.VirtualCurrencyApi$$ExternalSyntheticLambda1
            @Override // com.nintendo.npf.sdk.core.u2
            public final void a(JSONArray jSONArray, NPFError nPFError) {
                VirtualCurrencyApi.e(block, this, jSONArray, nPFError);
            }
        });
    }

    public final void getWallets(BaaSUser user, String market, final Function2<? super List<VirtualCurrencyWallet>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(market, "market");
        Intrinsics.checkNotNullParameter(block, "block");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%1$s/users/%2$s/markets/%3$s/wallets", Arrays.copyOf(new Object[]{"/vcm/v1", user.getUserId(), market}, 3));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        this.client.a(str, b2.c(user.getAccessToken()), null, true, new u2() { // from class: com.nintendo.npf.sdk.infrastructure.api.VirtualCurrencyApi$$ExternalSyntheticLambda3
            @Override // com.nintendo.npf.sdk.core.u2
            public final void a(JSONArray jSONArray, NPFError nPFError) {
                VirtualCurrencyApi.f(block, this, jSONArray, nPFError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Function2 block, VirtualCurrencyApi this$0, JSONObject jSONObject, NPFError nPFError) {
        Intrinsics.checkNotNullParameter(block, "$block");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (nPFError != null) {
            block.invoke(new VirtualCurrencyPurchases(CollectionsKt.emptyList(), CollectionsKt.emptyList()), nPFError);
            return;
        }
        try {
            VirtualCurrencyPurchases virtualCurrencyPurchasesFromJSON = this$0.purchasesMapper.fromJSON(jSONObject);
            if (virtualCurrencyPurchasesFromJSON != null) {
                block.invoke(virtualCurrencyPurchasesFromJSON, null);
            } else {
                block.invoke(new VirtualCurrencyPurchases(CollectionsKt.emptyList(), CollectionsKt.emptyList()), this$0.errorFactory.create_Mapper_InvalidJson_422("Invalid json"));
            }
        } catch (JSONException e) {
            block.invoke(new VirtualCurrencyPurchases(CollectionsKt.emptyList(), CollectionsKt.emptyList()), this$0.errorFactory.create_Mapper_InvalidJson_422(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function2 block, VirtualCurrencyApi this$0, JSONArray jSONArray, NPFError nPFError) {
        Intrinsics.checkNotNullParameter(block, "$block");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (nPFError != null) {
            block.invoke(CollectionsKt.emptyList(), nPFError);
            return;
        }
        try {
            List<Object> listFromJSON = this$0.purchaseSummaryMapper.fromJSON(jSONArray);
            Intrinsics.checkNotNullExpressionValue(listFromJSON, "purchaseSummaryMapper.fromJSON(response)");
            block.invoke(listFromJSON, null);
        } catch (JSONException e) {
            block.invoke(CollectionsKt.emptyList(), this$0.errorFactory.create_Mapper_InvalidJson_422(e));
        }
    }
}

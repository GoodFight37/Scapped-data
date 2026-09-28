package com.nintendo.npf.sdk.infrastructure.api;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.core.b2;
import com.nintendo.npf.sdk.core.m1;
import com.nintendo.npf.sdk.core.q4;
import com.nintendo.npf.sdk.core.r4;
import com.nintendo.npf.sdk.core.u2;
import com.nintendo.npf.sdk.core.v2;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.domain.model.SubscriptionOwnership;
import com.nintendo.npf.sdk.domain.model.SubscriptionReplacement;
import com.nintendo.npf.sdk.infrastructure.mapper.SubscriptionOwnershipMapper;
import com.nintendo.npf.sdk.infrastructure.mapper.SubscriptionProductMapper;
import com.nintendo.npf.sdk.infrastructure.mapper.SubscriptionPurchaseMapper;
import com.nintendo.npf.sdk.infrastructure.mapper.SubscriptionReplacementMapper;
import com.nintendo.npf.sdk.internal.client.core.HttpClient;
import com.nintendo.npf.sdk.subscription.SubscriptionProduct;
import com.nintendo.npf.sdk.subscription.SubscriptionPurchase;
import com.nintendo.npf.sdk.user.BaaSUser;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 82\u00020\u0001:\u0001,B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ?\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122 \u0010\u0019\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00180\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ?\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122 \u0010\u0019\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00180\u0014¢\u0006\u0004\b\u001d\u0010\u001bJ?\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122 \u0010\u0019\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00180\u0014¢\u0006\u0004\b\u001e\u0010\u001bJ;\u0010\"\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u001f2\u0014\u0010\u0019\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00180!¢\u0006\u0004\b\"\u0010#JG\u0010$\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u001f2 \u0010\u0019\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00180\u0014¢\u0006\u0004\b$\u0010%JK\u0010(\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u001f2\u001c\u0010\u0019\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010'\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00180\u0014¢\u0006\u0004\b(\u0010)JA\u0010+\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u001f2\u001a\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020*\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00180\u0014¢\u0006\u0004\b+\u0010%R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107¨\u00069"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/api/SubscriptionApi;", "", "Lcom/nintendo/npf/sdk/internal/client/core/HttpClient;", "client", "Lcom/nintendo/npf/sdk/infrastructure/mapper/SubscriptionProductMapper;", "productMapper", "Lcom/nintendo/npf/sdk/infrastructure/mapper/SubscriptionPurchaseMapper;", "purchaseMapper", "Lcom/nintendo/npf/sdk/infrastructure/mapper/SubscriptionOwnershipMapper;", "ownershipMapper", "Lcom/nintendo/npf/sdk/infrastructure/mapper/SubscriptionReplacementMapper;", "replacementMapper", "Lcom/nintendo/npf/sdk/domain/ErrorFactory;", "errorFactory", "<init>", "(Lcom/nintendo/npf/sdk/internal/client/core/HttpClient;Lcom/nintendo/npf/sdk/infrastructure/mapper/SubscriptionProductMapper;Lcom/nintendo/npf/sdk/infrastructure/mapper/SubscriptionPurchaseMapper;Lcom/nintendo/npf/sdk/infrastructure/mapper/SubscriptionOwnershipMapper;Lcom/nintendo/npf/sdk/infrastructure/mapper/SubscriptionReplacementMapper;Lcom/nintendo/npf/sdk/domain/ErrorFactory;)V", "Lcom/nintendo/npf/sdk/user/BaaSUser;", "user", "", "market", "Lkotlin/Function2;", "", "Lcom/nintendo/npf/sdk/subscription/SubscriptionProduct;", "Lcom/nintendo/npf/sdk/NPFError;", "", "block", "getProducts", "(Lcom/nintendo/npf/sdk/user/BaaSUser;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "Lcom/nintendo/npf/sdk/subscription/SubscriptionPurchase;", "getPurchases", "getGlobalPurchases", "Lorg/json/JSONObject;", "receipt", "Lkotlin/Function1;", "createPurchases", "(Lcom/nintendo/npf/sdk/user/BaaSUser;Ljava/lang/String;Lorg/json/JSONObject;Lkotlin/jvm/functions/Function1;)V", "updatePurchases", "(Lcom/nintendo/npf/sdk/user/BaaSUser;Ljava/lang/String;Lorg/json/JSONObject;Lkotlin/jvm/functions/Function2;)V", "productId", "Lcom/nintendo/npf/sdk/domain/model/SubscriptionReplacement;", "checkPurchaseReplacement", "(Lcom/nintendo/npf/sdk/user/BaaSUser;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lkotlin/jvm/functions/Function2;)V", "Lcom/nintendo/npf/sdk/domain/model/SubscriptionOwnership;", "updateOwnerships", "a", "Lcom/nintendo/npf/sdk/internal/client/core/HttpClient;", "b", "Lcom/nintendo/npf/sdk/infrastructure/mapper/SubscriptionProductMapper;", "c", "Lcom/nintendo/npf/sdk/infrastructure/mapper/SubscriptionPurchaseMapper;", "d", "Lcom/nintendo/npf/sdk/infrastructure/mapper/SubscriptionOwnershipMapper;", "e", "Lcom/nintendo/npf/sdk/infrastructure/mapper/SubscriptionReplacementMapper;", "f", "Lcom/nintendo/npf/sdk/domain/ErrorFactory;", "Companion", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SubscriptionApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final HttpClient client;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final SubscriptionProductMapper productMapper;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final SubscriptionPurchaseMapper purchaseMapper;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final SubscriptionOwnershipMapper ownershipMapper;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final SubscriptionReplacementMapper replacementMapper;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final ErrorFactory errorFactory;

    public SubscriptionApi(HttpClient client, SubscriptionProductMapper productMapper, SubscriptionPurchaseMapper purchaseMapper, SubscriptionOwnershipMapper ownershipMapper, SubscriptionReplacementMapper replacementMapper, ErrorFactory errorFactory) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(productMapper, "productMapper");
        Intrinsics.checkNotNullParameter(purchaseMapper, "purchaseMapper");
        Intrinsics.checkNotNullParameter(ownershipMapper, "ownershipMapper");
        Intrinsics.checkNotNullParameter(replacementMapper, "replacementMapper");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        this.client = client;
        this.productMapper = productMapper;
        this.purchaseMapper = purchaseMapper;
        this.ownershipMapper = ownershipMapper;
        this.replacementMapper = replacementMapper;
        this.errorFactory = errorFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Function2 block, SubscriptionApi this$0, JSONArray jSONArray, NPFError nPFError) {
        Intrinsics.checkNotNullParameter(block, "$block");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (nPFError != null) {
            block.invoke(CollectionsKt.emptyList(), nPFError);
            return;
        }
        try {
            List<Object> listFromJSON = this$0.purchaseMapper.fromJSON(jSONArray);
            Intrinsics.checkNotNullExpressionValue(listFromJSON, "purchaseMapper.fromJSON(response)");
            block.invoke(listFromJSON, null);
        } catch (JSONException e) {
            block.invoke(CollectionsKt.emptyList(), this$0.errorFactory.create_Mapper_InvalidJson_422(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function2 block, SubscriptionApi this$0, JSONArray jSONArray, NPFError nPFError) {
        Intrinsics.checkNotNullParameter(block, "$block");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (nPFError != null) {
            block.invoke(CollectionsKt.emptyList(), nPFError);
            return;
        }
        try {
            List<Object> listFromJSON = this$0.productMapper.fromJSON(jSONArray);
            Intrinsics.checkNotNullExpressionValue(listFromJSON, "productMapper.fromJSON(response)");
            block.invoke(listFromJSON, null);
        } catch (JSONException e) {
            block.invoke(CollectionsKt.emptyList(), this$0.errorFactory.create_Mapper_InvalidJson_422(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Function2 block, SubscriptionApi this$0, JSONArray jSONArray, NPFError nPFError) {
        Intrinsics.checkNotNullParameter(block, "$block");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (nPFError != null) {
            block.invoke(CollectionsKt.emptyList(), nPFError);
            return;
        }
        try {
            List<Object> listFromJSON = this$0.purchaseMapper.fromJSON(jSONArray);
            Intrinsics.checkNotNullExpressionValue(listFromJSON, "purchaseMapper.fromJSON(response)");
            block.invoke(listFromJSON, null);
        } catch (JSONException e) {
            block.invoke(CollectionsKt.emptyList(), this$0.errorFactory.create_Mapper_InvalidJson_422(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function2 block, SubscriptionApi this$0, JSONArray jSONArray, NPFError nPFError) {
        Intrinsics.checkNotNullParameter(block, "$block");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (nPFError != null) {
            block.invoke(CollectionsKt.emptyList(), nPFError);
            return;
        }
        try {
            List<Object> listFromJSON = this$0.purchaseMapper.fromJSON(jSONArray);
            Intrinsics.checkNotNullExpressionValue(listFromJSON, "purchaseMapper.fromJSON(response)");
            block.invoke(listFromJSON, null);
        } catch (JSONException e) {
            block.invoke(CollectionsKt.emptyList(), this$0.errorFactory.create_Mapper_InvalidJson_422(e));
        }
    }

    public final void checkPurchaseReplacement(BaaSUser user, String market, String productId, JSONObject receipt, final Function2<? super SubscriptionReplacement, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(market, "market");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(receipt, "receipt");
        Intrinsics.checkNotNullParameter(block, "block");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%1$s/users/%2$s/markets/%3$s/products/%4$s/replacement", Arrays.copyOf(new Object[]{"/subs/v1", user.getUserId(), market, productId}, 4));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        this.client.a(str, b2.c(user.getAccessToken()), (Map) null, q4.a(receipt), "application/json", true, (r4) new v2() { // from class: com.nintendo.npf.sdk.infrastructure.api.SubscriptionApi$$ExternalSyntheticLambda1
            @Override // com.nintendo.npf.sdk.core.v2
            public final void a(JSONObject jSONObject, NPFError nPFError) {
                SubscriptionApi.a(block, this, jSONObject, nPFError);
            }
        });
    }

    public final void createPurchases(BaaSUser user, String market, JSONObject receipt, final Function1<? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(market, "market");
        Intrinsics.checkNotNullParameter(receipt, "receipt");
        Intrinsics.checkNotNullParameter(block, "block");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%1$s/users/%2$s/markets/%3$s/purchases", Arrays.copyOf(new Object[]{"/subs/v1", user.getUserId(), market}, 3));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        this.client.a(str, b2.c(user.getAccessToken()), (Map) null, q4.a(receipt), "application/json", true, (r4) new m1() { // from class: com.nintendo.npf.sdk.infrastructure.api.SubscriptionApi$$ExternalSyntheticLambda0
            @Override // com.nintendo.npf.sdk.core.m1
            public final void onComplete(NPFError nPFError) {
                SubscriptionApi.a(block, nPFError);
            }
        });
    }

    public final void getGlobalPurchases(BaaSUser user, String market, final Function2<? super List<SubscriptionPurchase>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(market, "market");
        Intrinsics.checkNotNullParameter(block, "block");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%1$s/users/%2$s/purchases", Arrays.copyOf(new Object[]{"/subs/v1", user.getUserId()}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        this.client.a(str, b2.c(user.getAccessToken()), MapsKt.mapOf(TuplesKt.to("clientMarket", market)), true, new u2() { // from class: com.nintendo.npf.sdk.infrastructure.api.SubscriptionApi$$ExternalSyntheticLambda4
            @Override // com.nintendo.npf.sdk.core.u2
            public final void a(JSONArray jSONArray, NPFError nPFError) {
                SubscriptionApi.a(block, this, jSONArray, nPFError);
            }
        });
    }

    public final void getProducts(BaaSUser user, String market, final Function2<? super List<SubscriptionProduct>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(market, "market");
        Intrinsics.checkNotNullParameter(block, "block");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%1$s/markets/%2$s/products", Arrays.copyOf(new Object[]{"/subs/v1", market}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        this.client.a(str, b2.c(user.getAccessToken()), null, true, new u2() { // from class: com.nintendo.npf.sdk.infrastructure.api.SubscriptionApi$$ExternalSyntheticLambda3
            @Override // com.nintendo.npf.sdk.core.u2
            public final void a(JSONArray jSONArray, NPFError nPFError) {
                SubscriptionApi.b(block, this, jSONArray, nPFError);
            }
        });
    }

    public final void getPurchases(BaaSUser user, String market, final Function2<? super List<SubscriptionPurchase>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(market, "market");
        Intrinsics.checkNotNullParameter(block, "block");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%1$s/users/%2$s/markets/%3$s/purchases", Arrays.copyOf(new Object[]{"/subs/v1", user.getUserId(), market}, 3));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        this.client.a(str, b2.c(user.getAccessToken()), null, true, new u2() { // from class: com.nintendo.npf.sdk.infrastructure.api.SubscriptionApi$$ExternalSyntheticLambda2
            @Override // com.nintendo.npf.sdk.core.u2
            public final void a(JSONArray jSONArray, NPFError nPFError) {
                SubscriptionApi.c(block, this, jSONArray, nPFError);
            }
        });
    }

    public final void updateOwnerships(BaaSUser user, String market, JSONObject receipt, final Function2<? super SubscriptionOwnership, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(market, "market");
        Intrinsics.checkNotNullParameter(receipt, "receipt");
        Intrinsics.checkNotNullParameter(block, "block");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%1$s/users/%2$s/markets/%3$s/ownerships", Arrays.copyOf(new Object[]{"/subs/v1", user.getUserId(), market}, 3));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        this.client.b(str, b2.c(user.getAccessToken()), null, q4.a(receipt), true, new v2() { // from class: com.nintendo.npf.sdk.infrastructure.api.SubscriptionApi$$ExternalSyntheticLambda6
            @Override // com.nintendo.npf.sdk.core.v2
            public final void a(JSONObject jSONObject, NPFError nPFError) {
                SubscriptionApi.b(block, this, jSONObject, nPFError);
            }
        });
    }

    public final void updatePurchases(BaaSUser user, String market, JSONObject receipt, final Function2<? super List<SubscriptionPurchase>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(market, "market");
        Intrinsics.checkNotNullParameter(receipt, "receipt");
        Intrinsics.checkNotNullParameter(block, "block");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%1$s/users/%2$s/markets/%3$s/purchases", Arrays.copyOf(new Object[]{"/subs/v1", user.getUserId(), market}, 3));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        this.client.b(str, b2.c(user.getAccessToken()), null, q4.a(receipt), true, new u2() { // from class: com.nintendo.npf.sdk.infrastructure.api.SubscriptionApi$$ExternalSyntheticLambda5
            @Override // com.nintendo.npf.sdk.core.u2
            public final void a(JSONArray jSONArray, NPFError nPFError) {
                SubscriptionApi.d(block, this, jSONArray, nPFError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Function1 block, NPFError nPFError) {
        Intrinsics.checkNotNullParameter(block, "$block");
        block.invoke(nPFError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function2 block, SubscriptionApi this$0, JSONObject jSONObject, NPFError nPFError) {
        Intrinsics.checkNotNullParameter(block, "$block");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (nPFError != null) {
            block.invoke(new SubscriptionOwnership(-1, -1L), nPFError);
            return;
        }
        try {
            SubscriptionOwnership subscriptionOwnershipFromJSON = this$0.ownershipMapper.fromJSON(jSONObject);
            if (subscriptionOwnershipFromJSON != null) {
                block.invoke(subscriptionOwnershipFromJSON, null);
            } else {
                block.invoke(new SubscriptionOwnership(-1, -1L), this$0.errorFactory.create_Mapper_InvalidJson_422("Invalid json"));
            }
        } catch (JSONException e) {
            block.invoke(new SubscriptionOwnership(-1, -1L), this$0.errorFactory.create_Mapper_InvalidJson_422(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Function2 block, SubscriptionApi this$0, JSONObject jSONObject, NPFError nPFError) {
        Intrinsics.checkNotNullParameter(block, "$block");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (nPFError != null) {
            block.invoke(null, nPFError);
            return;
        }
        try {
            block.invoke(this$0.replacementMapper.fromJSON(jSONObject), null);
        } catch (JSONException e) {
            block.invoke(null, this$0.errorFactory.create_Mapper_InvalidJson_422(e));
        }
    }
}

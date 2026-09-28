package com.nintendo.npf.sdk.infrastructure.api;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.core.b2;
import com.nintendo.npf.sdk.core.q4;
import com.nintendo.npf.sdk.core.r4;
import com.nintendo.npf.sdk.core.u2;
import com.nintendo.npf.sdk.core.v2;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.domain.model.PromoCodePurchases;
import com.nintendo.npf.sdk.infrastructure.mapper.PromoCodeBundleMapper;
import com.nintendo.npf.sdk.infrastructure.mapper.PromoCodePurchasesMapper;
import com.nintendo.npf.sdk.internal.client.core.HttpClient;
import com.nintendo.npf.sdk.promo.PromoCodeBundle;
import com.nintendo.npf.sdk.user.BaaSUser;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 %2\u00020\u0001:\u0001\u001dB'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ?\u0010\u0016\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2 \u0010\u0015\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u00140\u0010¢\u0006\u0004\b\u0016\u0010\u0017JA\u0010\u001b\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00182\u001a\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u00140\u0010¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/api/PromoCodeApi;", "", "Lcom/nintendo/npf/sdk/internal/client/core/HttpClient;", "client", "Lcom/nintendo/npf/sdk/infrastructure/mapper/PromoCodeBundleMapper;", "bundleMapper", "Lcom/nintendo/npf/sdk/infrastructure/mapper/PromoCodePurchasesMapper;", "purchasesMapper", "Lcom/nintendo/npf/sdk/domain/ErrorFactory;", "errorFactory", "<init>", "(Lcom/nintendo/npf/sdk/internal/client/core/HttpClient;Lcom/nintendo/npf/sdk/infrastructure/mapper/PromoCodeBundleMapper;Lcom/nintendo/npf/sdk/infrastructure/mapper/PromoCodePurchasesMapper;Lcom/nintendo/npf/sdk/domain/ErrorFactory;)V", "Lcom/nintendo/npf/sdk/user/BaaSUser;", "user", "", "market", "Lkotlin/Function2;", "", "Lcom/nintendo/npf/sdk/promo/PromoCodeBundle;", "Lcom/nintendo/npf/sdk/NPFError;", "", "block", "getBundles", "(Lcom/nintendo/npf/sdk/user/BaaSUser;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "Lorg/json/JSONObject;", "receipt", "Lcom/nintendo/npf/sdk/domain/model/PromoCodePurchases;", "createPurchases", "(Lcom/nintendo/npf/sdk/user/BaaSUser;Ljava/lang/String;Lorg/json/JSONObject;Lkotlin/jvm/functions/Function2;)V", "a", "Lcom/nintendo/npf/sdk/internal/client/core/HttpClient;", "b", "Lcom/nintendo/npf/sdk/infrastructure/mapper/PromoCodeBundleMapper;", "c", "Lcom/nintendo/npf/sdk/infrastructure/mapper/PromoCodePurchasesMapper;", "d", "Lcom/nintendo/npf/sdk/domain/ErrorFactory;", "Companion", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PromoCodeApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final HttpClient client;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final PromoCodeBundleMapper bundleMapper;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final PromoCodePurchasesMapper purchasesMapper;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final ErrorFactory errorFactory;

    public PromoCodeApi(HttpClient client, PromoCodeBundleMapper bundleMapper, PromoCodePurchasesMapper purchasesMapper, ErrorFactory errorFactory) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(bundleMapper, "bundleMapper");
        Intrinsics.checkNotNullParameter(purchasesMapper, "purchasesMapper");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        this.client = client;
        this.bundleMapper = bundleMapper;
        this.purchasesMapper = purchasesMapper;
        this.errorFactory = errorFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Function2 block, PromoCodeApi this$0, JSONArray jSONArray, NPFError nPFError) {
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

    public final void createPurchases(BaaSUser user, String market, JSONObject receipt, final Function2<? super PromoCodePurchases, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(market, "market");
        Intrinsics.checkNotNullParameter(receipt, "receipt");
        Intrinsics.checkNotNullParameter(block, "block");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%s/users/%s/markets/%s/transactions", Arrays.copyOf(new Object[]{"/vcm/v1", user.getUserId(), market}, 3));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        this.client.a(str, b2.c(user.getAccessToken()), (Map) null, q4.a(receipt), "application/json", true, (r4) new v2() { // from class: com.nintendo.npf.sdk.infrastructure.api.PromoCodeApi$$ExternalSyntheticLambda1
            @Override // com.nintendo.npf.sdk.core.v2
            public final void a(JSONObject jSONObject, NPFError nPFError) {
                PromoCodeApi.a(block, this, jSONObject, nPFError);
            }
        });
    }

    public final void getBundles(BaaSUser user, String market, final Function2<? super List<PromoCodeBundle>, ? super NPFError, Unit> block) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(market, "market");
        Intrinsics.checkNotNullParameter(block, "block");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%s/markets/%s/promo_bundles", Arrays.copyOf(new Object[]{"/vcm/v1", market}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        this.client.a(str, b2.c(user.getAccessToken()), null, true, new u2() { // from class: com.nintendo.npf.sdk.infrastructure.api.PromoCodeApi$$ExternalSyntheticLambda0
            @Override // com.nintendo.npf.sdk.core.u2
            public final void a(JSONArray jSONArray, NPFError nPFError) {
                PromoCodeApi.a(block, this, jSONArray, nPFError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Function2 block, PromoCodeApi this$0, JSONObject jSONObject, NPFError nPFError) {
        Intrinsics.checkNotNullParameter(block, "$block");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (nPFError != null) {
            block.invoke(new PromoCodePurchases(CollectionsKt.emptyList()), nPFError);
            return;
        }
        try {
            PromoCodePurchases promoCodePurchasesFromJSON = this$0.purchasesMapper.fromJSON(jSONObject);
            if (promoCodePurchasesFromJSON != null) {
                block.invoke(promoCodePurchasesFromJSON, null);
            } else {
                block.invoke(new PromoCodePurchases(CollectionsKt.emptyList()), null);
            }
        } catch (JSONException e) {
            block.invoke(new PromoCodePurchases(CollectionsKt.emptyList()), this$0.errorFactory.create_Mapper_InvalidJson_422(e));
        }
    }
}

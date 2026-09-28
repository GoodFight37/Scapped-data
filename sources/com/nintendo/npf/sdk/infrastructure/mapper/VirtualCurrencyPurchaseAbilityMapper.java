package com.nintendo.npf.sdk.infrastructure.mapper;

import com.nintendo.npf.sdk.core.l0;
import com.nintendo.npf.sdk.domain.model.VirtualCurrencyPurchaseAbility;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/nintendo/npf/sdk/infrastructure/mapper/VirtualCurrencyPurchaseAbilityMapper;", "Lcom/nintendo/npf/sdk/core/l0;", "Lcom/nintendo/npf/sdk/domain/model/VirtualCurrencyPurchaseAbility;", "<init>", "()V", "Lorg/json/JSONObject;", "jsonObject", "fromJSON", "(Lorg/json/JSONObject;)Lcom/nintendo/npf/sdk/domain/model/VirtualCurrencyPurchaseAbility;", "item", "toJSON", "(Lcom/nintendo/npf/sdk/domain/model/VirtualCurrencyPurchaseAbility;)Lorg/json/JSONObject;", "Companion", "a", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VirtualCurrencyPurchaseAbilityMapper extends l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f701a = {MapperConstants.VIRTUAL_CURRENCY_FIELD_PURCHASABLE};

    @Override // com.nintendo.npf.sdk.core.l0
    public VirtualCurrencyPurchaseAbility fromJSON(JSONObject jsonObject) throws JSONException {
        if (jsonObject != null && a(jsonObject, f701a)) {
            return new VirtualCurrencyPurchaseAbility(jsonObject.getBoolean(MapperConstants.VIRTUAL_CURRENCY_FIELD_PURCHASABLE));
        }
        return null;
    }

    @Override // com.nintendo.npf.sdk.core.l0
    public JSONObject toJSON(VirtualCurrencyPurchaseAbility item) {
        throw new UnsupportedOperationException("Not implemented");
    }
}

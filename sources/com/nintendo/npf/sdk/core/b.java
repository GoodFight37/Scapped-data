package com.nintendo.npf.sdk.core;

import com.adjust.sdk.Constants;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import com.nintendo.npf.sdk.internal.client.core.HttpClient;
import com.nintendo.npf.sdk.user.NintendoAccount;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements com.nintendo.npf.sdk.core.a {
    public static final a d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HttpClient f412a;
    private final String b;
    private final boolean c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public b(HttpClient client, String clientId, boolean z) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        this.f412a = client;
        this.b = clientId;
        this.c = z;
    }

    @Override // com.nintendo.npf.sdk.core.a
    public Object a(String str, Continuation continuation) throws JSONException {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str2 = String.format(Locale.US, "%s/gateway/sdk/token", Arrays.copyOf(new Object[]{"/1.0.0"}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(locale, format, *args)");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("client_id", this.b);
        jSONObject.put(MapperConstants.NINTENDO_ACCOUNT_FIELD_SESSION_TOKEN, str);
        return this.f412a.a(str2, (6 & 2) != 0 ? null : null, (6 & 4) != 0 ? null : null, (6 & 8) != 0 ? null : q4.a(jSONObject), (6 & 16) != 0 ? null : "application/json", false, (com.nintendo.npf.sdk.internal.client.core.e) com.nintendo.npf.sdk.internal.client.core.e.b.f772a, continuation);
    }

    @Override // com.nintendo.npf.sdk.core.a
    public void a(NintendoAccount nintendoAccount, long j, v2 callback) {
        Intrinsics.checkNotNullParameter(nintendoAccount, "nintendoAccount");
        Intrinsics.checkNotNullParameter(callback, "callback");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.US;
        String nintendoAccountId = nintendoAccount.getNintendoAccountId();
        if (nintendoAccountId == null) {
            nintendoAccountId = "";
        }
        String str = String.format(locale, "%s/users/%s/mission_statuses", Arrays.copyOf(new Object[]{"/1.0.0", nintendoAccountId}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        mapCreateMapBuilder.putAll(b2.c(nintendoAccount.getAccessToken()));
        if (this.c && j > 0) {
            mapCreateMapBuilder.put("Debug-Current-Timestamp", String.valueOf(j));
        }
        Map mapBuild = MapsKt.build(mapCreateMapBuilder);
        Pair pair = TuplesKt.to("filter.mission.clientId.$eq", this.b);
        String country = nintendoAccount.getCountry();
        this.f412a.a(str, mapBuild, MapsKt.mapOf(pair, TuplesKt.to("filter.mission.countries.$contains", country != null ? country : ""), TuplesKt.to("filter.visible.$eq", "1")), true, callback);
    }

    @Override // com.nintendo.npf.sdk.core.a
    public void a(NintendoAccount nintendoAccount, Set set, long j, m1 callback) {
        Intrinsics.checkNotNullParameter(nintendoAccount, "nintendoAccount");
        Intrinsics.checkNotNullParameter(callback, "callback");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.US;
        String nintendoAccountId = nintendoAccount.getNintendoAccountId();
        if (nintendoAccountId == null) {
            nintendoAccountId = "";
        }
        String str = String.format(locale, "%s/users/%s/gifts/receive", Arrays.copyOf(new Object[]{"/1.0.0", nintendoAccountId}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        mapCreateMapBuilder.putAll(b2.c(nintendoAccount.getAccessToken()));
        if (this.c && j > 0) {
            mapCreateMapBuilder.put("Debug-Current-Timestamp", String.valueOf(j));
        }
        Map mapBuild = MapsKt.build(mapCreateMapBuilder);
        Map mapCreateMapBuilder2 = MapsKt.createMapBuilder();
        mapCreateMapBuilder2.put("pointFlags", Constants.REFERRER_API_GOOGLE);
        if (set != null && !set.isEmpty()) {
            mapCreateMapBuilder2.put("userGiftIds", CollectionsKt.joinToString$default(set, ",", null, null, 0, null, null, 62, null));
        }
        this.f412a.a(str, (4 & 2) != 0 ? null : mapBuild, (4 & 4) != 0 ? null : MapsKt.build(mapCreateMapBuilder2), (4 & 8) != 0 ? null : null, (4 & 16) != 0 ? null : "application/json", true, (r4) callback);
    }
}

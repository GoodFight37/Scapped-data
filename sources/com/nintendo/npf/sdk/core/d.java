package com.nintendo.npf.sdk.core;

import com.adjust.sdk.Constants;
import com.nintendo.npf.sdk.internal.client.core.HttpClient;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.user.NintendoAccount;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements c {
    public static final a c = new a(null);
    private static final String d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HttpClient f426a;
    private final String b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static {
        Intrinsics.checkNotNullExpressionValue("d", "AccountHttpClient::class.java.getSimpleName()");
        d = "d";
    }

    public d(HttpClient client, String clientId) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        this.f426a = client;
        this.b = clientId;
    }

    @Override // com.nintendo.npf.sdk.core.c
    public Object a(String str, String str2, Continuation continuation) {
        try {
            String str3 = (("client_id=" + URLEncoder.encode(this.b, Constants.ENCODING)) + "&session_token_code=" + URLEncoder.encode(str, Constants.ENCODING)) + "&session_token_code_verifier=" + URLEncoder.encode(str2, Constants.ENCODING);
            HttpClient httpClient = this.f426a;
            byte[] bytes = str3.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return httpClient.a("/connect/1.0.0/api/session_token", (6 & 2) != 0 ? null : null, (6 & 4) != 0 ? null : null, (6 & 8) != 0 ? null : bytes, (6 & 16) != 0 ? null : "application/x-www-form-urlencoded", false, (com.nintendo.npf.sdk.internal.client.core.e) com.nintendo.npf.sdk.internal.client.core.e.b.f772a, continuation);
        } catch (UnsupportedEncodingException e) {
            SDKLog.e(d, "connect", e);
            throw new IllegalStateException(e);
        }
    }

    @Override // com.nintendo.npf.sdk.core.c
    public void a(NintendoAccount nintendoAccount, String applicationName, String market, String str, String str2, m1 callback) {
        Intrinsics.checkNotNullParameter(nintendoAccount, "nintendoAccount");
        Intrinsics.checkNotNullParameter(applicationName, "applicationName");
        Intrinsics.checkNotNullParameter(market, "market");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Map mapC = b2.c(nintendoAccount.getAccessToken());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("userId", nintendoAccount.getNintendoAccountId());
            jSONObject.put("appName", applicationName);
            jSONObject.put("market", market);
            jSONObject.put("title", str);
            jSONObject.put("displayPrice", str2);
            this.f426a.a("/api/1.0.0/email/send_purchased_to_parent", (4 & 2) != 0 ? null : mapC, (4 & 4) != 0 ? null : null, (4 & 8) != 0 ? null : q4.a(jSONObject), (4 & 16) != 0 ? null : "application/json", true, (r4) callback);
        } catch (JSONException e) {
            SDKLog.e(d, "Failed making request JSON object", e);
            throw new IllegalArgumentException(e);
        }
    }
}

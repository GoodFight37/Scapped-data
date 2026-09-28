package com.nintendo.npf.sdk.core;

import android.text.TextUtils;
import com.nintendo.npf.sdk.internal.client.core.HttpClient;
import com.nintendo.npf.sdk.user.BaaSUser;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class x0 implements w0 {
    public static final a b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HttpClient f615a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public x0(HttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.f615a = client;
    }

    @Override // com.nintendo.npf.sdk.core.w0
    public Object a(BaaSUser baaSUser, JSONObject jSONObject, Continuation continuation) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%s/users/%s/transfer_code", Arrays.copyOf(new Object[]{"/core/v1", baaSUser.getUserId()}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        return this.f615a.a(str, b2.c(baaSUser.getAccessToken()), (Map) null, q4.a(jSONObject), "application/json", true, (com.nintendo.npf.sdk.internal.client.core.e) com.nintendo.npf.sdk.internal.client.core.e.b.f772a, continuation);
    }

    @Override // com.nintendo.npf.sdk.core.w0
    public void b(JSONObject jsonObject, v2 callback) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(callback, "callback");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%s/gateway/sdk/federation", Arrays.copyOf(new Object[]{"/core/v1"}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        this.f615a.a(str, (Map) null, (Map) null, q4.a(jsonObject), "application/json", false, (r4) callback);
    }

    @Override // com.nintendo.npf.sdk.core.w0
    public Object a(BaaSUser baaSUser, Continuation continuation) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%s/users/%s/transfer_code", Arrays.copyOf(new Object[]{"/core/v1", baaSUser.getUserId()}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        return this.f615a.a(str, b2.c(baaSUser.getAccessToken()), (Map) null, true, (com.nintendo.npf.sdk.internal.client.core.e) com.nintendo.npf.sdk.internal.client.core.e.b.f772a, continuation);
    }

    @Override // com.nintendo.npf.sdk.core.w0
    public Object a(JSONObject jSONObject, Continuation continuation) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%s/gateway/sdk/transfer_code", Arrays.copyOf(new Object[]{"/core/v1"}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        return this.f615a.a(str, (Map) null, (Map) null, q4.a(jSONObject), "application/json", false, (com.nintendo.npf.sdk.internal.client.core.e) com.nintendo.npf.sdk.internal.client.core.e.b.f772a, continuation);
    }

    @Override // com.nintendo.npf.sdk.core.w0
    public void a(JSONObject jsonObject, v2 callback) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(callback, "callback");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%s/gateway/sdk/login", Arrays.copyOf(new Object[]{"/core/v1"}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        this.f615a.a(str, (Map) null, (Map) null, q4.a(jsonObject), "application/json", false, (r4) callback);
    }

    @Override // com.nintendo.npf.sdk.core.w0
    public void a(BaaSUser user, v2 callback) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(callback, "callback");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%s/users/%s", Arrays.copyOf(new Object[]{"/core/v1", user.getUserId()}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        this.f615a.a(str, b2.c(user.getAccessToken()), (Map) null, q4.a(a(user)), true, (r4) callback);
    }

    @Override // com.nintendo.npf.sdk.core.w0
    public void a(BaaSUser user, List list, v2 callback) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(callback, "callback");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%s/users", Arrays.copyOf(new Object[]{"/core/v1"}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        Map mapC = b2.c(user.getAccessToken());
        HashMap map = new HashMap();
        map.put("embed_link_userinfo", "1");
        if (list != null && !list.isEmpty()) {
            String strJoin = TextUtils.join(",", list);
            Intrinsics.checkNotNullExpressionValue(strJoin, "join(\",\", userIds)");
            map.put("filter.id.$in", strJoin);
        }
        this.f615a.a(str, mapC, map, true, callback);
    }

    @Override // com.nintendo.npf.sdk.core.w0
    public void a(BaaSUser user, String providerId, String idToken, v2 callback) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(providerId, "providerId");
        Intrinsics.checkNotNullParameter(idToken, "idToken");
        Intrinsics.checkNotNullParameter(callback, "callback");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.US;
        String str = String.format(locale, "%s/users/%s/link", Arrays.copyOf(new Object[]{"/core/v1", user.getUserId()}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        Map mapC = b2.c(user.getAccessToken());
        String str2 = String.format(locale, "idp=%s&idToken=%s", Arrays.copyOf(new Object[]{providerId, idToken}, 2));
        Intrinsics.checkNotNullExpressionValue(str2, "format(locale, format, *args)");
        byte[] bytes = str2.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        this.f615a.a(str, mapC, (Map) null, bytes, "application/x-www-form-urlencoded", true, (r4) callback);
    }

    private final JSONArray a(BaaSUser baaSUser) {
        JSONArray jSONArray = new JSONArray();
        try {
            String nickname = !TextUtils.isEmpty(baaSUser.getNickname()) ? baaSUser.getNickname() : "";
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("op", "replace");
            jSONObject.put("path", "/nickname");
            jSONObject.put("value", nickname);
            jSONArray.put(jSONObject);
            String country = TextUtils.isEmpty(baaSUser.getCountry()) ? "" : baaSUser.getCountry();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("op", "replace");
            jSONObject2.put("path", "/country");
            jSONObject2.put("value", country);
            jSONArray.put(jSONObject2);
            String lowerCase = baaSUser.getGender().toString().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("op", "replace");
            jSONObject3.put("path", "/gender");
            jSONObject3.put("value", lowerCase);
            jSONArray.put(jSONObject3);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(Locale.US, "%04d-%02d-%02d", Arrays.copyOf(new Object[]{Integer.valueOf(baaSUser.getBirthdayYear()), Integer.valueOf(baaSUser.getBirthdayMonth()), Integer.valueOf(baaSUser.getBirthdayDay())}, 3));
            Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("op", "replace");
            jSONObject4.put("path", "/birthday");
            jSONObject4.put("value", str);
            jSONArray.put(jSONObject4);
        } catch (JSONException unused) {
        }
        return jSONArray;
    }
}

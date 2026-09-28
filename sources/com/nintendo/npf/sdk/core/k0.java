package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.inquiry.InquiryStatus;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.user.Gender;
import com.nintendo.npf.sdk.user.LinkedAccount;
import com.unity.androidnotifications.UnityNotificationManager;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class k0 extends l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f505a = new a(null);

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f506a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(JSONObject jSONObject) {
            super(1);
            this.f506a = jSONObject;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Pair invoke(String str) {
            return new Pair(str, this.f506a.getJSONObject(str));
        }
    }

    static final class c extends Lambda implements Function1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f507a = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Pair pair) {
            Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
            return Boolean.valueOf(l0.hasField((JSONObject) pair.component2(), UnityNotificationManager.KEY_ID));
        }
    }

    static final class d extends Lambda implements Function1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f508a = new d();

        d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Pair invoke(Pair pair) throws JSONException {
            Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
            String providerId = (String) pair.component1();
            JSONObject jSONObject = (JSONObject) pair.component2();
            Intrinsics.checkNotNullExpressionValue(providerId, "providerId");
            String string = jSONObject.getString(UnityNotificationManager.KEY_ID);
            Intrinsics.checkNotNullExpressionValue(string, "link.getString(FIELD_LINK_OBJECT_ID)");
            return TuplesKt.to(providerId, new LinkedAccount(providerId, string));
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00de  */
    @Override // com.nintendo.npf.sdk.core.l0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public BaaSUser fromJSON(JSONObject jSONObject) throws JSONException {
        long j;
        long j2;
        boolean z;
        boolean z2;
        int i;
        int i2;
        int i3;
        Map mapEmptyMap;
        if (jSONObject == null) {
            return null;
        }
        String userId = jSONObject.getString(UnityNotificationManager.KEY_ID);
        if (l0.hasField(jSONObject, "permissions")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("permissions");
            z = jSONObject2.getBoolean("personalAnalytics");
            z2 = jSONObject2.getBoolean("personalNotification");
            j = jSONObject2.getLong("personalAnalyticsUpdatedAt");
            j2 = jSONObject2.getLong("personalNotificationUpdatedAt");
        } else {
            j = 0;
            j2 = 0;
            z = false;
            z2 = false;
        }
        long j3 = jSONObject.getLong("createdAt");
        String string = (!l0.hasField(jSONObject, "nickname") || jSONObject.getString("nickname").length() <= 0) ? null : jSONObject.getString("nickname");
        String string2 = (!l0.hasField(jSONObject, "country") || jSONObject.getString("country").length() <= 0) ? null : jSONObject.getString("country");
        Gender gender = Gender.UNKNOWN;
        if (l0.hasField(jSONObject, "gender")) {
            String string3 = jSONObject.getString("gender");
            if (Intrinsics.areEqual(string3, "male")) {
                gender = Gender.MALE;
            } else if (Intrinsics.areEqual(string3, "female")) {
                gender = Gender.FEMALE;
            }
        }
        Gender gender2 = gender;
        if (l0.hasField(jSONObject, "birthday")) {
            String birthday = jSONObject.getString("birthday");
            Intrinsics.checkNotNullExpressionValue(birthday, "birthday");
            String[] strArr = (String[]) StringsKt.split$default((CharSequence) birthday, new String[]{"-"}, false, 0, 6, (Object) null).toArray(new String[0]);
            if (strArr.length >= 3) {
                int i4 = Integer.parseInt(strArr[0]);
                int i5 = Integer.parseInt(strArr[1]);
                i3 = Integer.parseInt(strArr[2]);
                i2 = i5;
                i = i4;
            } else {
                i = 0;
                i2 = 0;
                i3 = 0;
            }
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
        }
        InquiryStatus inquiryStatus = l0.hasField(jSONObject, "hasUnreadCsComment") ? new InquiryStatus(jSONObject.getBoolean("hasUnreadCsComment")) : null;
        if (l0.hasField(jSONObject, "links")) {
            JSONObject jSONObject3 = jSONObject.getJSONObject("links");
            Iterator<String> itKeys = jSONObject3.keys();
            Intrinsics.checkNotNullExpressionValue(itKeys, "links.keys()");
            mapEmptyMap = MapsKt.toMap(SequencesKt.map(SequencesKt.filter(SequencesKt.map(SequencesKt.asSequence(itKeys), new b(jSONObject3)), c.f507a), d.f508a));
        } else {
            mapEmptyMap = MapsKt.emptyMap();
        }
        Intrinsics.checkNotNullExpressionValue(userId, "userId");
        return new BaaSUser(userId, string, string2, gender2, i, i2, i3, z, z2, j, j2, inquiryStatus, j3, mapEmptyMap);
    }

    @Override // com.nintendo.npf.sdk.core.l0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public JSONObject toJSON(BaaSUser baaSUser) {
        throw new UnsupportedOperationException("Not implemented");
    }
}

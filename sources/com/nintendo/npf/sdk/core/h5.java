package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.user.TransferCode;
import com.unity.androidnotifications.UnityNotificationManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class h5 extends l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f474a = new a(null);

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    @Override // com.nintendo.npf.sdk.core.l0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public TransferCode fromJSON(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            throw new JSONException("JSON Object is null");
        }
        String string = jSONObject.getString(UnityNotificationManager.KEY_ID);
        Intrinsics.checkNotNullExpressionValue(string, "json.getString(FIELD_ID)");
        String string2 = jSONObject.getString("code");
        Intrinsics.checkNotNullExpressionValue(string2, "json.getString(FIELD_CODE)");
        return new TransferCode(string, string2);
    }

    @Override // com.nintendo.npf.sdk.core.l0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public JSONObject toJSON(TransferCode transferCode) {
        throw new UnsupportedOperationException("Not implemented");
    }
}

package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.inquiry.InquiryStatus;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class p2 extends l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f543a = new a(null);

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    @Override // com.nintendo.npf.sdk.core.l0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public InquiryStatus fromJSON(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return l0.hasField(jSONObject, "hasUnreadCsComment") ? new InquiryStatus(jSONObject.getBoolean("hasUnreadCsComment")) : new InquiryStatus(false, 1, null);
    }

    @Override // com.nintendo.npf.sdk.core.l0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public JSONObject toJSON(InquiryStatus inquiryStatus) {
        throw new UnsupportedOperationException("Not implemented");
    }
}

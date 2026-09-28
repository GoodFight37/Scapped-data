package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.user.BaaSUser;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0 f520a;
    private final l b;
    private final ErrorFactory c;

    public m0(Function0 bigdataClientProvider, l analyticsConfigMapper, ErrorFactory errorFactory) {
        Intrinsics.checkNotNullParameter(bigdataClientProvider, "bigdataClientProvider");
        Intrinsics.checkNotNullParameter(analyticsConfigMapper, "analyticsConfigMapper");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        this.f520a = bigdataClientProvider;
        this.b = analyticsConfigMapper;
        this.c = errorFactory;
    }

    public final void a(BaaSUser user, JSONArray events, final Function1 callback) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(events, "events");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((n0) this.f520a.invoke()).a(user, events, new m1() { // from class: com.nintendo.npf.sdk.core.m0$$ExternalSyntheticLambda0
            @Override // com.nintendo.npf.sdk.core.m1
            public final void onComplete(NPFError nPFError) {
                m0.a(callback, nPFError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Function1 callback, NPFError nPFError) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke(nPFError);
    }

    public final void a(BaaSUser user, final Function2 callback) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((n0) this.f520a.invoke()).a(user, new v2() { // from class: com.nintendo.npf.sdk.core.m0$$ExternalSyntheticLambda1
            @Override // com.nintendo.npf.sdk.core.v2
            public final void a(JSONObject jSONObject, NPFError nPFError) {
                m0.a(callback, this, jSONObject, nPFError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Function2 callback, m0 this$0, JSONObject jSONObject, NPFError nPFError) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (nPFError != null) {
            callback.invoke(null, nPFError);
            return;
        }
        if (jSONObject != null) {
            try {
                callback.invoke(this$0.b.fromJSON(jSONObject), null);
                return;
            } catch (JSONException e) {
                callback.invoke(null, this$0.c.create_Mapper_InvalidJson_422(e));
                return;
            }
        }
        callback.invoke(null, this$0.c.create_Mapper_InvalidJson_422("response Json null."));
    }
}

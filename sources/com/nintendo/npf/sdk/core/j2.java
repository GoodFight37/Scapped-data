package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.user.BaaSUser;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class j2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0 f497a;
    private final p2 b;
    private final ErrorFactory c;

    public j2(Function0 inquiryClientProvider, p2 mapper, ErrorFactory errorFactory) {
        Intrinsics.checkNotNullParameter(inquiryClientProvider, "inquiryClientProvider");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        this.f497a = inquiryClientProvider;
        this.b = mapper;
        this.c = errorFactory;
    }

    public final void a(BaaSUser baasUser, final Function2 callback) {
        Intrinsics.checkNotNullParameter(baasUser, "baasUser");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((k2) this.f497a.invoke()).a(baasUser, new v2() { // from class: com.nintendo.npf.sdk.core.j2$$ExternalSyntheticLambda0
            @Override // com.nintendo.npf.sdk.core.v2
            public final void a(JSONObject jSONObject, NPFError nPFError) {
                j2.a(callback, this, jSONObject, nPFError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Function2 callback, j2 this$0, JSONObject jSONObject, NPFError nPFError) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (nPFError != null) {
            callback.invoke(null, nPFError);
            return;
        }
        try {
            callback.invoke(this$0.b.fromJSON(jSONObject), null);
        } catch (JSONException e) {
            callback.invoke(null, this$0.c.create_Mapper_InvalidJson_422(e));
        }
    }
}

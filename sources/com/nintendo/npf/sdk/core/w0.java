package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.user.BaaSUser;
import java.util.List;
import kotlin.coroutines.Continuation;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface w0 {
    Object a(BaaSUser baaSUser, Continuation continuation);

    Object a(BaaSUser baaSUser, JSONObject jSONObject, Continuation continuation);

    Object a(JSONObject jSONObject, Continuation continuation);

    void a(BaaSUser baaSUser, v2 v2Var);

    void a(BaaSUser baaSUser, String str, String str2, v2 v2Var);

    void a(BaaSUser baaSUser, List list, v2 v2Var);

    void a(JSONObject jSONObject, v2 v2Var);

    void b(JSONObject jSONObject, v2 v2Var);
}

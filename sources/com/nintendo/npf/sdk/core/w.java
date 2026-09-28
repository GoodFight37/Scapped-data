package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.user.BaaSUser;
import java.util.Set;
import kotlin.collections.SetsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface w {

    public static final class a {
        public static /* synthetic */ NPFError a(w wVar, BaaSUser baaSUser, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, s sVar, Set set, boolean z, int i, Object obj) {
            if (obj == null) {
                return wVar.a(baaSUser, str, str2, jSONObject, jSONObject2, (i & 32) != 0 ? null : sVar, (i & 64) != 0 ? SetsKt.emptySet() : set, (i & 128) != 0 ? false : z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveEvent");
        }
    }

    NPFError a(BaaSUser baaSUser, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, s sVar, Set set, boolean z);

    void a();

    void a(i iVar);

    boolean isSuspended();

    void suspend();
}

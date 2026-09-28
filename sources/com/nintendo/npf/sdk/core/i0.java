package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.NPFError;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class i0 implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f477a;
    private final String b;
    private final JSONObject c;
    private final JSONObject d;

    public i0(String eventCategory, String eventId, JSONObject jSONObject, JSONObject jSONObject2) {
        Intrinsics.checkNotNullParameter(eventCategory, "eventCategory");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        this.f477a = eventCategory;
        this.b = eventId;
        this.c = jSONObject;
        this.d = jSONObject2;
    }

    @Override // com.nintendo.npf.sdk.core.p
    public String a() {
        return this.f477a;
    }

    @Override // com.nintendo.npf.sdk.core.p
    public String b() {
        return this.b;
    }

    @Override // com.nintendo.npf.sdk.core.p
    public NPFError c() {
        return p.a.b(this);
    }

    public NPFError d() {
        return p.a.a(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i0)) {
            return false;
        }
        i0 i0Var = (i0) obj;
        return Intrinsics.areEqual(this.f477a, i0Var.f477a) && Intrinsics.areEqual(this.b, i0Var.b) && Intrinsics.areEqual(this.c, i0Var.c) && Intrinsics.areEqual(this.d, i0Var.d);
    }

    public int hashCode() {
        int iHashCode = ((this.f477a.hashCode() * 31) + this.b.hashCode()) * 31;
        JSONObject jSONObject = this.c;
        int iHashCode2 = (iHashCode + (jSONObject == null ? 0 : jSONObject.hashCode())) * 31;
        JSONObject jSONObject2 = this.d;
        return iHashCode2 + (jSONObject2 != null ? jSONObject2.hashCode() : 0);
    }

    public String toString() {
        return "BaasUserIdEventRequest(eventCategory=" + this.f477a + ", eventId=" + this.b + ", playerState=" + this.c + ", payload=" + this.d + ')';
    }
}

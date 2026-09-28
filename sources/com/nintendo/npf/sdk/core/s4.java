package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.NPFError;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class s4 implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f563a;
    private final String b;
    private final List c;
    private final JSONObject d;
    private final JSONObject e;

    public s4(String eventCategory, String eventId, List resettableIdTypes, JSONObject jSONObject, JSONObject jSONObject2) {
        Intrinsics.checkNotNullParameter(eventCategory, "eventCategory");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(resettableIdTypes, "resettableIdTypes");
        this.f563a = eventCategory;
        this.b = eventId;
        this.c = resettableIdTypes;
        this.d = jSONObject;
        this.e = jSONObject2;
    }

    @Override // com.nintendo.npf.sdk.core.p
    public String a() {
        return this.f563a;
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
        NPFError nPFErrorC = c();
        if (nPFErrorC != null) {
            return nPFErrorC;
        }
        if (this.c.isEmpty()) {
            return new NPFError(NPFError.ErrorType.NPF_ERROR, 400, "Invalid parameters");
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s4)) {
            return false;
        }
        s4 s4Var = (s4) obj;
        return Intrinsics.areEqual(this.f563a, s4Var.f563a) && Intrinsics.areEqual(this.b, s4Var.b) && Intrinsics.areEqual(this.c, s4Var.c) && Intrinsics.areEqual(this.d, s4Var.d) && Intrinsics.areEqual(this.e, s4Var.e);
    }

    public int hashCode() {
        int iHashCode = ((((this.f563a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        JSONObject jSONObject = this.d;
        int iHashCode2 = (iHashCode + (jSONObject == null ? 0 : jSONObject.hashCode())) * 31;
        JSONObject jSONObject2 = this.e;
        return iHashCode2 + (jSONObject2 != null ? jSONObject2.hashCode() : 0);
    }

    public String toString() {
        return "ResettableIdEventRequest(eventCategory=" + this.f563a + ", eventId=" + this.b + ", resettableIdTypes=" + this.c + ", playerState=" + this.d + ", payload=" + this.e + ')';
    }
}

package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.user.NintendoAccount;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f519a;
    private final String b;

    public m(String str, String str2) {
        this.f519a = str;
        this.b = str2;
    }

    public final boolean a(BaaSUser user) {
        Intrinsics.checkNotNullParameter(user, "user");
        if (!Intrinsics.areEqual(user.getUserId(), this.f519a)) {
            return false;
        }
        NintendoAccount nintendoAccount = user.getNintendoAccount();
        return Intrinsics.areEqual(nintendoAccount != null ? nintendoAccount.getNintendoAccountId() : null, this.b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return Intrinsics.areEqual(this.f519a, mVar.f519a) && Intrinsics.areEqual(this.b, mVar.b);
    }

    public int hashCode() {
        String str = this.f519a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "AnalyticsConfigOwner(baasUserId=" + this.f519a + ", nintendoAccountId=" + this.b + ')';
    }

    public /* synthetic */ m(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public m(BaaSUser baaSUser) {
        Intrinsics.checkNotNullParameter(baaSUser, "baaSUser");
        String userId = baaSUser.getUserId();
        NintendoAccount nintendoAccount = baaSUser.getNintendoAccount();
        this(userId, nintendoAccount != null ? nintendoAccount.getNintendoAccountId() : null);
    }
}

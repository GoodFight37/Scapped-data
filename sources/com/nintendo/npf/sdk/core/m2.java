package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.domain.repository.BaasAccountRepository;
import com.nintendo.npf.sdk.inquiry.InquiryService;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.user.BaaSUser;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class m2 implements InquiryService {
    public static final a d = new a(null);
    private static final String e = "m2";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BaasAccountRepository f521a;
    private final o2 b;
    private final ErrorFactory c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public m2(BaasAccountRepository baasAccountRepository, o2 inquiryRepository, ErrorFactory errorFactory) {
        Intrinsics.checkNotNullParameter(baasAccountRepository, "baasAccountRepository");
        Intrinsics.checkNotNullParameter(inquiryRepository, "inquiryRepository");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        this.f521a = baasAccountRepository;
        this.b = inquiryRepository;
        this.c = errorFactory;
    }

    @Override // com.nintendo.npf.sdk.inquiry.InquiryService
    public void check(Function2 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        SDKLog.i(e, "check is called");
        BaaSUser currentBaasUser = this.f521a.getCurrentBaasUser();
        if (h0.c(currentBaasUser)) {
            this.b.a(currentBaasUser, callback);
        } else {
            callback.invoke(null, this.c.create_BaasAccount_NotLoggedIn_401());
        }
    }
}

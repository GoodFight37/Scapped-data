package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.user.LinkedAccount;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public final class w2 implements y2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d0 f603a;
    private final ErrorFactory b;

    static final class a extends Lambda implements Function2 {
        final /* synthetic */ Function2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Function2 function2) {
            super(2);
            this.b = function2;
        }

        public final void a(o1 o1Var, NPFError nPFError) {
            NPFError nPFErrorCreate_LinkedAccount_NotLinkedToAnyone_5200;
            if (nPFError != null) {
                if (nPFError.getErrorCode() == 400) {
                    nPFError = w2.this.b.create_LinkedAccount_InvalidIdToken_5400(nPFError.getErrorMessage());
                }
                this.b.invoke(null, nPFError);
            } else {
                if (o1Var == null) {
                    return;
                }
                if (!(o1Var instanceof o1.a)) {
                    if (o1Var instanceof o1.b) {
                        this.b.invoke(((o1.b) o1Var).a(), null);
                    }
                } else {
                    o1.a aVar = (o1.a) o1Var;
                    int errorCode = aVar.a().getErrorCode();
                    if (errorCode != -1) {
                        nPFErrorCreate_LinkedAccount_NotLinkedToAnyone_5200 = errorCode != 400 ? aVar.a() : w2.this.b.create_LinkedAccount_InvalidIdToken_5400(aVar.a().getErrorMessage());
                    } else {
                        nPFErrorCreate_LinkedAccount_NotLinkedToAnyone_5200 = w2.this.b.create_LinkedAccount_NotLinkedToAnyone_5200(aVar.a().getErrorMessage());
                    }
                    this.b.invoke(null, nPFErrorCreate_LinkedAccount_NotLinkedToAnyone_5200);
                }
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((o1) obj, (NPFError) obj2);
            return Unit.INSTANCE;
        }
    }

    static final class b extends Lambda implements Function2 {
        final /* synthetic */ Function2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Function2 function2) {
            super(2);
            this.b = function2;
        }

        public final void a(BaaSUser baaSUser, NPFError nPFError) {
            if (nPFError == null) {
                this.b.invoke(baaSUser, null);
                return;
            }
            int errorCode = nPFError.getErrorCode();
            if (errorCode == 400) {
                nPFError = w2.this.b.create_LinkedAccount_InvalidIdToken_5400(nPFError.getErrorMessage());
            } else if (errorCode == 409) {
                nPFError = w2.this.b.create_LinkedAccount_LinkToAnotherUser_5409(nPFError.getErrorMessage());
            }
            this.b.invoke(null, nPFError);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((BaaSUser) obj, (NPFError) obj2);
            return Unit.INSTANCE;
        }
    }

    public w2(d0 baasAccountApi, ErrorFactory errorFactory) {
        Intrinsics.checkNotNullParameter(baasAccountApi, "baasAccountApi");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        this.f603a = baasAccountApi;
        this.b = errorFactory;
    }

    @Override // com.nintendo.npf.sdk.core.y2
    public void link(BaaSUser currentBaasUser, LinkedAccount linkTarget, Function2 callback) {
        Intrinsics.checkNotNullParameter(currentBaasUser, "currentBaasUser");
        Intrinsics.checkNotNullParameter(linkTarget, "linkTarget");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f603a.a(currentBaasUser, linkTarget, new b(callback));
    }

    @Override // com.nintendo.npf.sdk.core.y2
    public void a(String currentBaasUserId, LinkedAccount linkedAccount, Function2 callback) throws JSONException {
        Intrinsics.checkNotNullParameter(currentBaasUserId, "currentBaasUserId");
        Intrinsics.checkNotNullParameter(linkedAccount, "linkedAccount");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f603a.a(currentBaasUserId, linkedAccount, (String) null, new a(callback));
    }
}

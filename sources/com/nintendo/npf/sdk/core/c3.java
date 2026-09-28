package com.nintendo.npf.sdk.core;

import android.app.Activity;
import android.content.Intent;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFSDK;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.domain.repository.NintendoAccountRepository;
import com.nintendo.npf.sdk.internal.app.MiiStudioActivity;
import com.nintendo.npf.sdk.user.NintendoAccount;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0 f423a;
    private final q b;
    private final ErrorFactory c;
    private NPFSDK.NPFErrorCallback d;

    public c3(Function0 nintendoAccountRepositoryProvider, q analyticsHelper, ErrorFactory errorFactory) {
        Intrinsics.checkNotNullParameter(nintendoAccountRepositoryProvider, "nintendoAccountRepositoryProvider");
        Intrinsics.checkNotNullParameter(analyticsHelper, "analyticsHelper");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        this.f423a = nintendoAccountRepositoryProvider;
        this.b = analyticsHelper;
        this.c = errorFactory;
    }

    public final void a(Activity activity, NPFSDK.NPFErrorCallback callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(callback, "callback");
        NintendoAccount currentNintendoAccount = ((NintendoAccountRepository) this.f423a.invoke()).getCurrentNintendoAccount();
        if (!v3.a(currentNintendoAccount)) {
            NPFError nPFErrorCreate_NintendoAccount_NotAuthorized_4001 = this.c.create_NintendoAccount_NotAuthorized_4001();
            Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_NintendoAccount_NotAuthorized_4001, "errorFactory.create_Nint…ount_NotAuthorized_4001()");
            this.b.a("mii_studio_error", "MiiStudio#NintendoAccountNotAuthorized", nPFErrorCreate_NintendoAccount_NotAuthorized_4001);
            callback.onComplete(nPFErrorCreate_NintendoAccount_NotAuthorized_4001);
            return;
        }
        if (this.d != null) {
            callback.onComplete(new NPFError(NPFError.ErrorType.PROCESS_CANCEL, -1, "openMiiStudio can't run multiply"));
            return;
        }
        this.d = callback;
        Intent intent = new Intent(activity, (Class<?>) MiiStudioActivity.class);
        intent.putExtra("requestCode", 452);
        intent.putExtra("naIdToken", currentNintendoAccount.getIdToken());
        activity.startActivity(intent);
    }

    public final void a(NPFError nPFError) {
        NPFSDK.NPFErrorCallback nPFErrorCallback = this.d;
        if (nPFErrorCallback != null) {
            this.d = null;
            nPFErrorCallback.onComplete(nPFError);
        }
    }
}

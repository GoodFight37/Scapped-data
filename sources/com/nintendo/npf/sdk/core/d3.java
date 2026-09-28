package com.nintendo.npf.sdk.core;

import com.google.api.client.http.HttpStatusCodes;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.mynintendo.MissionStatus;
import com.nintendo.npf.sdk.mynintendo.PointProgramService;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.user.NintendoAccount;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d3 {
    private static final String d = "d3";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e3 f431a = new e3();
    private final x4 b = x4.a.a();
    private final ErrorFactory c;

    class a implements v2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MissionStatus.RetrievingCallback f432a;

        a(MissionStatus.RetrievingCallback retrievingCallback) {
            this.f432a = retrievingCallback;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.nintendo.npf.sdk.core.v2
        public void a(JSONObject jSONObject, NPFError nPFError) {
            if (nPFError != null) {
                if (nPFError.getErrorCode() == 403) {
                    nPFError = nPFError.copy(NPFError.ErrorType.INVALID_NA_TOKEN);
                }
                this.f432a.onComplete(null, nPFError);
            } else {
                try {
                    this.f432a.onComplete(d3.this.f431a.fromPagedJSON(jSONObject), null);
                } catch (JSONException e) {
                    this.f432a.onComplete(null, d3.this.c.create_Mapper_InvalidJson_422(e));
                }
            }
        }
    }

    class b implements m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MissionStatus.ReceivingGiftsCallback f433a;

        b(MissionStatus.ReceivingGiftsCallback receivingGiftsCallback) {
            this.f433a = receivingGiftsCallback;
        }

        @Override // com.nintendo.npf.sdk.core.m1
        public void onComplete(NPFError nPFError) {
            if (nPFError != null && nPFError.getErrorCode() == 403) {
                nPFError = nPFError.copy(NPFError.ErrorType.INVALID_NA_TOKEN);
            }
            this.f433a.onComplete(nPFError);
        }
    }

    public d3(ErrorFactory errorFactory) {
        this.c = errorFactory;
    }

    public void a(MissionStatus.RetrievingCallback retrievingCallback) {
        SDKLog.i(d, "getAll is called");
        BaaSUser baaSUserC = this.b.getNPFSDK().c();
        if (!h0.c(baaSUserC)) {
            retrievingCallback.onComplete(null, this.c.create_BaasAccount_NotLoggedIn_401());
            return;
        }
        NintendoAccount nintendoAccount = baaSUserC.getNintendoAccount();
        if (nintendoAccount == null) {
            retrievingCallback.onComplete(null, new NPFError(NPFError.ErrorType.NPF_ERROR, HttpStatusCodes.STATUS_CODE_FORBIDDEN, "Current BaaS User doesn't link with Nintendo Account."));
        } else if (nintendoAccount.getCountry() == null) {
            retrievingCallback.onComplete(null, new NPFError(NPFError.ErrorType.INVALID_NA_TOKEN, HttpStatusCodes.STATUS_CODE_FORBIDDEN, "country code of Nintendo Account is unauthorized."));
        } else {
            r3.a().a(nintendoAccount, PointProgramService.getDebugCurrentTimestamp(), new a(retrievingCallback));
        }
    }

    public void a(Map map, MissionStatus.ReceivingGiftsCallback receivingGiftsCallback) {
        SDKLog.i(d, "receiveAvailableGifts is called");
        if (!h0.c(this.b.getNPFSDK().c())) {
            receivingGiftsCallback.onComplete(this.c.create_BaasAccount_NotLoggedIn_401());
            return;
        }
        NintendoAccount nintendoAccount = this.b.getNPFSDK().c().getNintendoAccount();
        if (nintendoAccount == null) {
            receivingGiftsCallback.onComplete(new NPFError(NPFError.ErrorType.NPF_ERROR, HttpStatusCodes.STATUS_CODE_FORBIDDEN, "Current BaaS User doesn't link with Nintendo Account."));
            return;
        }
        if (nintendoAccount.getCountry() == null) {
            receivingGiftsCallback.onComplete(new NPFError(NPFError.ErrorType.INVALID_NA_TOKEN, HttpStatusCodes.STATUS_CODE_FORBIDDEN, "country code of Nintendo Account is unauthorized."));
        } else if (map != null && map.keySet().size() != 0) {
            r3.a().a(nintendoAccount, map.keySet(), PointProgramService.getDebugCurrentTimestamp(), new b(receivingGiftsCallback));
        } else {
            receivingGiftsCallback.onComplete(new NPFError(NPFError.ErrorType.NPF_ERROR, HttpStatusCodes.STATUS_CODE_NOT_FOUND, "This mission doesn't have available gifts"));
        }
    }
}

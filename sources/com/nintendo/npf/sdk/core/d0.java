package com.nintendo.npf.sdk.core;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFException;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.user.LinkedAccount;
import com.nintendo.npf.sdk.user.TransferCode;
import com.unity.androidnotifications.UnityNotificationManager;
import java.util.Calendar;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d0 {
    public static final a j = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DeviceDataFacade f427a;
    private final Function0 b;
    private final ErrorFactory c;
    private final a1 d;
    private final k0 e;
    private final b4 f;
    private final x1 g;
    private final h5 h;
    private final y1 i;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f428a;
        /* synthetic */ Object b;
        int d;

        b(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return d0.this.a((BaaSUser) null, (String) null, this);
        }
    }

    static final class c extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f429a;
        /* synthetic */ Object b;
        int d;

        c(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return d0.this.a((BaaSUser) null, this);
        }
    }

    static final class d extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f430a;
        /* synthetic */ Object b;
        int d;

        d(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return d0.this.a((TransferCode) null, this);
        }
    }

    public d0(DeviceDataFacade deviceDataFacade, Function0 coreClientProvider, ErrorFactory errorFactory, a1 credentialsDataFacade, k0 baasUserMapper, b4 otherUserMapper, x1 hostConfigurationMapper, h5 transferCodeMapper, y1 hostInformationDataFacade) {
        Intrinsics.checkNotNullParameter(deviceDataFacade, "deviceDataFacade");
        Intrinsics.checkNotNullParameter(coreClientProvider, "coreClientProvider");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        Intrinsics.checkNotNullParameter(credentialsDataFacade, "credentialsDataFacade");
        Intrinsics.checkNotNullParameter(baasUserMapper, "baasUserMapper");
        Intrinsics.checkNotNullParameter(otherUserMapper, "otherUserMapper");
        Intrinsics.checkNotNullParameter(hostConfigurationMapper, "hostConfigurationMapper");
        Intrinsics.checkNotNullParameter(transferCodeMapper, "transferCodeMapper");
        Intrinsics.checkNotNullParameter(hostInformationDataFacade, "hostInformationDataFacade");
        this.f427a = deviceDataFacade;
        this.b = coreClientProvider;
        this.c = errorFactory;
        this.d = credentialsDataFacade;
        this.e = baasUserMapper;
        this.f = otherUserMapper;
        this.g = hostConfigurationMapper;
        this.h = transferCodeMapper;
        this.i = hostInformationDataFacade;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function2 callback, d0 this$0, JSONObject jSONObject, NPFError nPFError) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (nPFError != null) {
            callback.invoke(null, nPFError);
            return;
        }
        try {
            callback.invoke(this$0.f.fromPagedJSON(jSONObject), null);
        } catch (JSONException e) {
            callback.invoke(null, this$0.c.create_Mapper_InvalidJson_422(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Function2 callback, d0 this$0, JSONObject jSONObject, NPFError nPFError) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (nPFError != null) {
            callback.invoke(null, nPFError);
            return;
        }
        try {
            Intrinsics.checkNotNull(jSONObject);
            callback.invoke(this$0.c(jSONObject), null);
        } catch (JSONException e) {
            callback.invoke(null, this$0.c.create_Mapper_InvalidJson_422(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function2 callback, d0 this$0, JSONObject jSONObject, NPFError nPFError) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (nPFError != null) {
            callback.invoke(null, nPFError);
            return;
        }
        if (jSONObject == null) {
            callback.invoke(null, this$0.c.create_Mapper_InvalidJson_422("response Json null."));
            return;
        }
        try {
            callback.invoke(this$0.d(jSONObject), null);
        } catch (JSONException e) {
            callback.invoke(null, this$0.c.create_Mapper_InvalidJson_422(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function2 callback, d0 this$0, JSONObject jSONObject, NPFError nPFError) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (nPFError != null) {
            callback.invoke(null, nPFError);
            return;
        }
        if (jSONObject == null) {
            callback.invoke(null, this$0.c.create_Mapper_InvalidJson_422("response Json null."));
            return;
        }
        try {
            callback.invoke(this$0.d(jSONObject), null);
        } catch (JSONException e) {
            callback.invoke(null, this$0.c.create_Mapper_InvalidJson_422(e));
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(BaaSUser baaSUser, String str, Continuation continuation) throws JSONException {
        b bVar;
        d0 d0Var;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i = bVar.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                bVar.d = i - Integer.MIN_VALUE;
            } else {
                bVar = new b(continuation);
            }
        } else {
            bVar = new b(continuation);
        }
        Object objA = bVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = bVar.d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(UnityNotificationManager.KEY_ID, str);
            w0 w0Var = (w0) this.b.invoke();
            bVar.f428a = this;
            bVar.d = 1;
            objA = w0Var.a(baaSUser, jSONObject, bVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
            d0Var = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d0Var = (d0) bVar.f428a;
            ResultKt.throwOnFailure(objA);
        }
        try {
            return d0Var.h.fromJSON((JSONObject) objA);
        } catch (JSONException e) {
            NPFError nPFErrorCreate_Mapper_InvalidJson_422 = d0Var.c.create_Mapper_InvalidJson_422(e);
            Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_Mapper_InvalidJson_422, "errorFactory.create_Mapper_InvalidJson_422(e)");
            throw new NPFException(nPFErrorCreate_Mapper_InvalidJson_422);
        }
    }

    private final void b(JSONObject jSONObject) throws JSONException {
        String str = this.f427a.getPackageName() + ':' + this.f427a.getSignatureSHA1();
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        String strA = c5.a(bytes, 600, 8, "HmacSHA1");
        SDKLog.d("d0", "Key : " + str);
        SDKLog.d("d0", "Secret : " + strA);
        jSONObject.put("assertion", t2.a(this.i.f(), strA, str));
    }

    private final BaaSUser c(JSONObject jSONObject) throws JSONException {
        BaaSUser baaSUserFromJSON = this.e.fromJSON(jSONObject);
        if (baaSUserFromJSON == null) {
            return null;
        }
        if (this.i.h()) {
            baaSUserFromJSON.setDevicePassword$NPFSDK_release(this.d.a());
        }
        return baaSUserFromJSON;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(BaaSUser baaSUser, Continuation continuation) {
        c cVar;
        d0 d0Var;
        if (continuation instanceof c) {
            cVar = (c) continuation;
            int i = cVar.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                cVar.d = i - Integer.MIN_VALUE;
            } else {
                cVar = new c(continuation);
            }
        } else {
            cVar = new c(continuation);
        }
        Object objA = cVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = cVar.d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            w0 w0Var = (w0) this.b.invoke();
            cVar.f429a = this;
            cVar.d = 1;
            objA = w0Var.a(baaSUser, cVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
            d0Var = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d0Var = (d0) cVar.f429a;
            ResultKt.throwOnFailure(objA);
        }
        try {
            return d0Var.h.fromJSON((JSONObject) objA);
        } catch (JSONException e) {
            NPFError nPFErrorCreate_Mapper_InvalidJson_422 = d0Var.c.create_Mapper_InvalidJson_422(e);
            Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_Mapper_InvalidJson_422, "errorFactory.create_Mapper_InvalidJson_422(e)");
            throw new NPFException(nPFErrorCreate_Mapper_InvalidJson_422);
        }
    }

    private final o1 d(JSONObject jSONObject) throws JSONException {
        NPFError nPFError;
        j1 j1Var;
        String strC;
        String strA;
        String string = null;
        if (!jSONObject.has("error") || jSONObject.isNull("error")) {
            nPFError = null;
        } else {
            JSONObject jSONObject2 = jSONObject.getJSONObject("error");
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.getJSONObject(FIELD_ERROR)");
            NPFError.ErrorType errorType = NPFError.ErrorType.NPF_ERROR;
            String string2 = jSONObject2.getJSONObject("errorMessage").toString();
            Intrinsics.checkNotNullExpressionValue(string2, "error.getJSONObject(FIEL…ERROR_MESSAGE).toString()");
            nPFError = new NPFError(errorType, jSONObject2.getInt("errorCode"), string2);
        }
        if (nPFError != null) {
            return new o1.a(nPFError);
        }
        if (!jSONObject.has("createdDeviceAccount") || jSONObject.isNull("createdDeviceAccount")) {
            j1Var = null;
        } else {
            JSONObject jSONObject3 = jSONObject.getJSONObject("createdDeviceAccount");
            String string3 = jSONObject3.getString(UnityNotificationManager.KEY_ID);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(FIELD_DEVICE_ACCOUNT_ID)");
            String string4 = jSONObject3.getString("password");
            Intrinsics.checkNotNullExpressionValue(string4, "getString(FIELD_DEVICE_ACCOUNT_PASSWORD)");
            j1Var = new j1(string3, string4);
        }
        if (j1Var == null || (strC = j1Var.a()) == null) {
            strC = this.d.c();
        }
        String str = strC;
        if (j1Var == null || (strA = j1Var.b()) == null) {
            strA = this.d.a();
        }
        String str2 = strA;
        long timeInMillis = Calendar.getInstance().getTimeInMillis() + ((long) (jSONObject.getInt("expiresIn") * 1000));
        BaaSUser baaSUserC = c(jSONObject.getJSONObject("user"));
        if (baaSUserC == null) {
            NPFError nPFErrorCreate_Mapper_InvalidJson_422 = this.c.create_Mapper_InvalidJson_422("Baas user is null");
            Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_Mapper_InvalidJson_422, "errorFactory.create_Mapp…_422(\"Baas user is null\")");
            return new o1.a(nPFErrorCreate_Mapper_InvalidJson_422);
        }
        String string5 = jSONObject.getString("accessToken");
        Intrinsics.checkNotNullExpressionValue(string5, "json.getString(FIELD_ACCESS_TOKEN)");
        String string6 = jSONObject.getString("idToken");
        Intrinsics.checkNotNullExpressionValue(string6, "json.getString(FIELD_ID_TOKEN)");
        h0.a(baaSUserC, str, str2, string5, string6, timeInMillis, this.i.h());
        w1 w1VarFromJSON = jSONObject.has("capability") ? this.g.fromJSON(jSONObject.getJSONObject("capability")) : null;
        String string7 = s2.a(jSONObject, "sessionId") ? jSONObject.getString("sessionId") : null;
        if (jSONObject.has("market") && !jSONObject.isNull("market")) {
            string = jSONObject.getString("market");
        }
        return new o1.b(new p1(j1Var, baaSUserC, w1VarFromJSON, string7, string));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(TransferCode transferCode, Continuation continuation) throws JSONException {
        d dVar;
        d0 d0Var;
        if (continuation instanceof d) {
            dVar = (d) continuation;
            int i = dVar.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                dVar.d = i - Integer.MIN_VALUE;
            } else {
                dVar = new d(continuation);
            }
        } else {
            dVar = new d(continuation);
        }
        Object objA = dVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = dVar.d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            JSONObject jSONObjectCreateDeviceInfo = this.f427a.createDeviceInfo();
            b(jSONObjectCreateDeviceInfo);
            a(jSONObjectCreateDeviceInfo);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(UnityNotificationManager.KEY_ID, transferCode.getIdentifier());
            jSONObject.put("code", transferCode.getCode());
            Unit unit = Unit.INSTANCE;
            jSONObjectCreateDeviceInfo.put("transferCode", jSONObject);
            w0 w0Var = (w0) this.b.invoke();
            dVar.f430a = this;
            dVar.d = 1;
            objA = w0Var.a(jSONObjectCreateDeviceInfo, dVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
            d0Var = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d0Var = (d0) dVar.f430a;
            ResultKt.throwOnFailure(objA);
        }
        JSONObject jSONObject2 = (JSONObject) objA;
        if (jSONObject2 != null) {
            try {
                return d0Var.d(jSONObject2);
            } catch (JSONException e) {
                NPFError nPFErrorCreate_Mapper_InvalidJson_422 = d0Var.c.create_Mapper_InvalidJson_422(e);
                Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_Mapper_InvalidJson_422, "errorFactory.create_Mapper_InvalidJson_422(e)");
                throw new NPFException(nPFErrorCreate_Mapper_InvalidJson_422);
            }
        }
        NPFError nPFErrorCreate_Mapper_InvalidJson_423 = d0Var.c.create_Mapper_InvalidJson_422("JSON Object is null.");
        Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_Mapper_InvalidJson_423, "errorFactory.create_Mapp…2(\"JSON Object is null.\")");
        throw new NPFException(nPFErrorCreate_Mapper_InvalidJson_423);
    }

    public final void a(String str, final Function2 callback) throws JSONException {
        Intrinsics.checkNotNullParameter(callback, "callback");
        JSONObject jSONObjectCreateDeviceInfo = this.f427a.createDeviceInfo();
        b(jSONObjectCreateDeviceInfo);
        a(jSONObjectCreateDeviceInfo);
        a(jSONObjectCreateDeviceInfo, str);
        ((w0) this.b.invoke()).a(jSONObjectCreateDeviceInfo, new v2() { // from class: com.nintendo.npf.sdk.core.d0$$ExternalSyntheticLambda5
            @Override // com.nintendo.npf.sdk.core.v2
            public final void a(JSONObject jSONObject, NPFError nPFError) {
                d0.d(callback, this, jSONObject, nPFError);
            }
        });
    }

    public final void a(final Function2 callback) throws JSONException {
        Intrinsics.checkNotNullParameter(callback, "callback");
        JSONObject jSONObjectCreateDeviceInfo = this.f427a.createDeviceInfo();
        b(jSONObjectCreateDeviceInfo);
        ((w0) this.b.invoke()).a(jSONObjectCreateDeviceInfo, new v2() { // from class: com.nintendo.npf.sdk.core.d0$$ExternalSyntheticLambda4
            @Override // com.nintendo.npf.sdk.core.v2
            public final void a(JSONObject jSONObject, NPFError nPFError) {
                d0.e(callback, this, jSONObject, nPFError);
            }
        });
    }

    public final void a(String currentBaasUserId, LinkedAccount linkedAccount, String str, final Function2 callback) throws JSONException {
        Intrinsics.checkNotNullParameter(currentBaasUserId, "currentBaasUserId");
        Intrinsics.checkNotNullParameter(linkedAccount, "linkedAccount");
        Intrinsics.checkNotNullParameter(callback, "callback");
        JSONObject jSONObjectCreateDeviceInfo = this.f427a.createDeviceInfo();
        b(jSONObjectCreateDeviceInfo);
        a(jSONObjectCreateDeviceInfo);
        a(jSONObjectCreateDeviceInfo, linkedAccount, currentBaasUserId);
        a(jSONObjectCreateDeviceInfo, str);
        ((w0) this.b.invoke()).b(jSONObjectCreateDeviceInfo, new v2() { // from class: com.nintendo.npf.sdk.core.d0$$ExternalSyntheticLambda0
            @Override // com.nintendo.npf.sdk.core.v2
            public final void a(JSONObject jSONObject, NPFError nPFError) {
                d0.a(callback, this, jSONObject, nPFError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Function2 callback, d0 this$0, JSONObject jSONObject, NPFError nPFError) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (nPFError != null) {
            callback.invoke(null, nPFError);
            return;
        }
        if (jSONObject != null) {
            try {
                callback.invoke(this$0.d(jSONObject), null);
                return;
            } catch (JSONException e) {
                callback.invoke(null, this$0.c.create_Mapper_InvalidJson_422(e));
                return;
            }
        }
        callback.invoke(null, this$0.c.create_Mapper_InvalidJson_422("response Json null."));
    }

    public final void a(BaaSUser currentBaasUser, LinkedAccount linkTarget, final Function2 callback) {
        Intrinsics.checkNotNullParameter(currentBaasUser, "currentBaasUser");
        Intrinsics.checkNotNullParameter(linkTarget, "linkTarget");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((w0) this.b.invoke()).a(currentBaasUser, linkTarget.getProviderId(), linkTarget.getFederatedId(), new v2() { // from class: com.nintendo.npf.sdk.core.d0$$ExternalSyntheticLambda3
            @Override // com.nintendo.npf.sdk.core.v2
            public final void a(JSONObject jSONObject, NPFError nPFError) {
                d0.c(callback, this, jSONObject, nPFError);
            }
        });
    }

    public final void a(BaaSUser currentBaasUser, List userIds, final Function2 callback) {
        Intrinsics.checkNotNullParameter(currentBaasUser, "currentBaasUser");
        Intrinsics.checkNotNullParameter(userIds, "userIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((w0) this.b.invoke()).a(currentBaasUser, userIds, new v2() { // from class: com.nintendo.npf.sdk.core.d0$$ExternalSyntheticLambda1
            @Override // com.nintendo.npf.sdk.core.v2
            public final void a(JSONObject jSONObject, NPFError nPFError) {
                d0.b(callback, this, jSONObject, nPFError);
            }
        });
    }

    public final void a(final BaaSUser user, final Function2 callback) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((w0) this.b.invoke()).a(user, new v2() { // from class: com.nintendo.npf.sdk.core.d0$$ExternalSyntheticLambda2
            @Override // com.nintendo.npf.sdk.core.v2
            public final void a(JSONObject jSONObject, NPFError nPFError) {
                d0.a(callback, this, user, jSONObject, nPFError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Function2 callback, d0 this$0, BaaSUser user, JSONObject jSONObject, NPFError nPFError) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(user, "$user");
        if (nPFError != null) {
            callback.invoke(null, nPFError);
            return;
        }
        try {
            BaaSUser baaSUserC = this$0.c(jSONObject);
            if (baaSUserC == null) {
                callback.invoke(null, this$0.c.create_Mapper_InvalidJson_422("Baas user is null"));
            } else {
                baaSUserC.setNintendoAccount$NPFSDK_release(user.getNintendoAccount());
                callback.invoke(baaSUserC, null);
            }
        } catch (JSONException e) {
            callback.invoke(null, this$0.c.create_Mapper_InvalidJson_422(e));
        }
    }

    private final void a(JSONObject jSONObject) throws JSONException {
        String strA;
        String strC = this.d.c();
        if (strC == null || strC.length() == 0 || (strA = this.d.a()) == null || strA.length() == 0) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(UnityNotificationManager.KEY_ID, this.d.c());
        jSONObject2.put("password", this.d.a());
        Unit unit = Unit.INSTANCE;
        jSONObject.put("deviceAccount", jSONObject2);
    }

    private final void a(JSONObject jSONObject, String str) throws JSONException {
        if (str == null) {
            return;
        }
        jSONObject.put("naCountry", str);
    }

    private final void a(JSONObject jSONObject, LinkedAccount linkedAccount, String str) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("idp", linkedAccount.getProviderId());
        jSONObject2.put("idToken", linkedAccount.getFederatedId());
        Unit unit = Unit.INSTANCE;
        jSONObject.put("idpAccount", jSONObject2);
        jSONObject.put("previousUserId", str);
    }
}

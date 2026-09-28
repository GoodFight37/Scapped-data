package com.nintendo.npf.sdk.core;

import android.text.TextUtils;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFException;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import com.nintendo.npf.sdk.user.NintendoAccount;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class s3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0 f560a;
    private final Function0 b;
    private final x3 c;
    private final Function0 d;
    private final ErrorFactory e;

    static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f561a;
        Object b;
        /* synthetic */ Object c;
        int e;

        a(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return s3.this.a((String) null, this);
        }
    }

    static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f562a;
        /* synthetic */ Object b;
        int d;

        b(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return s3.this.a(null, null, this);
        }
    }

    public s3(Function0 accountApiClientProvider, Function0 accountClientProvider, x3 nintendoAccountMapper, Function0 nintendoAccountHelperProvider, ErrorFactory errorFactory) {
        Intrinsics.checkNotNullParameter(accountApiClientProvider, "accountApiClientProvider");
        Intrinsics.checkNotNullParameter(accountClientProvider, "accountClientProvider");
        Intrinsics.checkNotNullParameter(nintendoAccountMapper, "nintendoAccountMapper");
        Intrinsics.checkNotNullParameter(nintendoAccountHelperProvider, "nintendoAccountHelperProvider");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        this.f560a = accountApiClientProvider;
        this.b = accountClientProvider;
        this.c = nintendoAccountMapper;
        this.d = nintendoAccountHelperProvider;
        this.e = errorFactory;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0064 A[Catch: JSONException -> 0x0039, NPFException -> 0x003c, TryCatch #3 {NPFException -> 0x003c, JSONException -> 0x0039, blocks: (B:12:0x0035, B:25:0x0060, B:27:0x0064, B:29:0x006c, B:31:0x0072, B:33:0x0089, B:36:0x009a, B:37:0x00a5, B:38:0x00a6, B:41:0x00ae, B:44:0x00b9, B:45:0x00c4, B:46:0x00c5, B:48:0x00cb, B:51:0x00d6, B:52:0x00e1, B:53:0x00e2, B:58:0x00f4, B:60:0x00fa, B:61:0x0103, B:62:0x0104, B:64:0x0110, B:65:0x011f, B:66:0x0120, B:67:0x0131), top: B:87:0x0035 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x006c A[Catch: JSONException -> 0x0039, NPFException -> 0x003c, TryCatch #3 {NPFException -> 0x003c, JSONException -> 0x0039, blocks: (B:12:0x0035, B:25:0x0060, B:27:0x0064, B:29:0x006c, B:31:0x0072, B:33:0x0089, B:36:0x009a, B:37:0x00a5, B:38:0x00a6, B:41:0x00ae, B:44:0x00b9, B:45:0x00c4, B:46:0x00c5, B:48:0x00cb, B:51:0x00d6, B:52:0x00e1, B:53:0x00e2, B:58:0x00f4, B:60:0x00fa, B:61:0x0103, B:62:0x0104, B:64:0x0110, B:65:0x011f, B:66:0x0120, B:67:0x0131), top: B:87:0x0035 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0072 A[Catch: JSONException -> 0x0039, NPFException -> 0x003c, TryCatch #3 {NPFException -> 0x003c, JSONException -> 0x0039, blocks: (B:12:0x0035, B:25:0x0060, B:27:0x0064, B:29:0x006c, B:31:0x0072, B:33:0x0089, B:36:0x009a, B:37:0x00a5, B:38:0x00a6, B:41:0x00ae, B:44:0x00b9, B:45:0x00c4, B:46:0x00c5, B:48:0x00cb, B:51:0x00d6, B:52:0x00e1, B:53:0x00e2, B:58:0x00f4, B:60:0x00fa, B:61:0x0103, B:62:0x0104, B:64:0x0110, B:65:0x011f, B:66:0x0120, B:67:0x0131), top: B:87:0x0035 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0089 A[Catch: JSONException -> 0x0039, NPFException -> 0x003c, TryCatch #3 {NPFException -> 0x003c, JSONException -> 0x0039, blocks: (B:12:0x0035, B:25:0x0060, B:27:0x0064, B:29:0x006c, B:31:0x0072, B:33:0x0089, B:36:0x009a, B:37:0x00a5, B:38:0x00a6, B:41:0x00ae, B:44:0x00b9, B:45:0x00c4, B:46:0x00c5, B:48:0x00cb, B:51:0x00d6, B:52:0x00e1, B:53:0x00e2, B:58:0x00f4, B:60:0x00fa, B:61:0x0103, B:62:0x0104, B:64:0x0110, B:65:0x011f, B:66:0x0120, B:67:0x0131), top: B:87:0x0035 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0099  */
    /* JADX WARN: Code duplicated, block: B:36:0x009a A[Catch: JSONException -> 0x0039, NPFException -> 0x003c, TryCatch #3 {NPFException -> 0x003c, JSONException -> 0x0039, blocks: (B:12:0x0035, B:25:0x0060, B:27:0x0064, B:29:0x006c, B:31:0x0072, B:33:0x0089, B:36:0x009a, B:37:0x00a5, B:38:0x00a6, B:41:0x00ae, B:44:0x00b9, B:45:0x00c4, B:46:0x00c5, B:48:0x00cb, B:51:0x00d6, B:52:0x00e1, B:53:0x00e2, B:58:0x00f4, B:60:0x00fa, B:61:0x0103, B:62:0x0104, B:64:0x0110, B:65:0x011f, B:66:0x0120, B:67:0x0131), top: B:87:0x0035 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:56:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:58:0x00f4 A[Catch: JSONException -> 0x0039, NPFException -> 0x003c, TryCatch #3 {NPFException -> 0x003c, JSONException -> 0x0039, blocks: (B:12:0x0035, B:25:0x0060, B:27:0x0064, B:29:0x006c, B:31:0x0072, B:33:0x0089, B:36:0x009a, B:37:0x00a5, B:38:0x00a6, B:41:0x00ae, B:44:0x00b9, B:45:0x00c4, B:46:0x00c5, B:48:0x00cb, B:51:0x00d6, B:52:0x00e1, B:53:0x00e2, B:58:0x00f4, B:60:0x00fa, B:61:0x0103, B:62:0x0104, B:64:0x0110, B:65:0x011f, B:66:0x0120, B:67:0x0131), top: B:87:0x0035 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:62:0x0104 A[Catch: JSONException -> 0x0039, NPFException -> 0x003c, TryCatch #3 {NPFException -> 0x003c, JSONException -> 0x0039, blocks: (B:12:0x0035, B:25:0x0060, B:27:0x0064, B:29:0x006c, B:31:0x0072, B:33:0x0089, B:36:0x009a, B:37:0x00a5, B:38:0x00a6, B:41:0x00ae, B:44:0x00b9, B:45:0x00c4, B:46:0x00c5, B:48:0x00cb, B:51:0x00d6, B:52:0x00e1, B:53:0x00e2, B:58:0x00f4, B:60:0x00fa, B:61:0x0103, B:62:0x0104, B:64:0x0110, B:65:0x011f, B:66:0x0120, B:67:0x0131), top: B:87:0x0035 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x0110 A[Catch: JSONException -> 0x0039, NPFException -> 0x003c, TryCatch #3 {NPFException -> 0x003c, JSONException -> 0x0039, blocks: (B:12:0x0035, B:25:0x0060, B:27:0x0064, B:29:0x006c, B:31:0x0072, B:33:0x0089, B:36:0x009a, B:37:0x00a5, B:38:0x00a6, B:41:0x00ae, B:44:0x00b9, B:45:0x00c4, B:46:0x00c5, B:48:0x00cb, B:51:0x00d6, B:52:0x00e1, B:53:0x00e2, B:58:0x00f4, B:60:0x00fa, B:61:0x0103, B:62:0x0104, B:64:0x0110, B:65:0x011f, B:66:0x0120, B:67:0x0131), top: B:87:0x0035 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0120 A[Catch: JSONException -> 0x0039, NPFException -> 0x003c, TryCatch #3 {NPFException -> 0x003c, JSONException -> 0x0039, blocks: (B:12:0x0035, B:25:0x0060, B:27:0x0064, B:29:0x006c, B:31:0x0072, B:33:0x0089, B:36:0x009a, B:37:0x00a5, B:38:0x00a6, B:41:0x00ae, B:44:0x00b9, B:45:0x00c4, B:46:0x00c5, B:48:0x00cb, B:51:0x00d6, B:52:0x00e1, B:53:0x00e2, B:58:0x00f4, B:60:0x00fa, B:61:0x0103, B:62:0x0104, B:64:0x0110, B:65:0x011f, B:66:0x0120, B:67:0x0131), top: B:87:0x0035 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code duplicated, block: B:82:0x016f  */
    /* JADX WARN: Code duplicated, block: B:83:0x0192  */
    public final Object a(String str, Continuation continuation) {
        a aVar;
        s3 s3Var;
        JSONObject jSONObject;
        int i;
        JSONObject errorMessage;
        Integer numBoxInt;
        int iIntValue;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i2 = aVar.e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                aVar.e = i2 - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object objA = aVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = aVar.e;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) aVar.b;
            s3Var = (s3) aVar.f561a;
            try {
                ResultKt.throwOnFailure(objA);
                jSONObject = (JSONObject) objA;
                if (jSONObject != null) {
                    NPFError nPFErrorCreate_Mapper_InvalidJson_422 = s3Var.e.create_Mapper_InvalidJson_422("No value for response json");
                    Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_Mapper_InvalidJson_422, "errorFactory.create_Mapp…value for response json\")");
                    throw h3.a(nPFErrorCreate_Mapper_InvalidJson_422);
                }
                if (!r2.a(jSONObject, MapperConstants.NINTENDO_ACCOUNT_FIELD_TERMS_AGREEMENT)) {
                    NPFError nPFErrorCreate_NintendoAccount_NaEulaUpdate_Minus1 = s3Var.e.create_NintendoAccount_NaEulaUpdate_Minus1();
                    Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_NintendoAccount_NaEulaUpdate_Minus1, "errorFactory.create_Nint…unt_NaEulaUpdate_Minus1()");
                    throw h3.a(nPFErrorCreate_NintendoAccount_NaEulaUpdate_Minus1);
                }
                if (r2.a(jSONObject, "error")) {
                    NintendoAccount nintendoAccountA = s3Var.c.a(jSONObject, str);
                    Intrinsics.checkNotNullExpressionValue(nintendoAccountA, "nintendoAccountMapper.fr…N(response, sessionToken)");
                    return nintendoAccountA;
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject("error");
                i = jSONObject2.getInt("errorCode");
                errorMessage = jSONObject2.getJSONObject("errorMessage");
                Intrinsics.checkNotNullExpressionValue(errorMessage, "errorMessage");
                if (r2.a(errorMessage, MapperConstants.NINTENDO_ACCOUNT_FIELD_USER_STATUS)) {
                    if (!MapperConstants.INSTANCE.getNintendoAccountInvalidUserStatuses().contains(errorMessage.getString(MapperConstants.NINTENDO_ACCOUNT_FIELD_USER_STATUS))) {
                        throw new NPFException(NPFError.ErrorType.INVALID_NA_USER, i, errorMessage.toString());
                    }
                }
                if (r2.a(errorMessage, "error") && Intrinsics.areEqual(errorMessage.getString("error"), MapperConstants.NINTENDO_ACCOUNT_FIELD_INVALID_GRANT)) {
                    throw new NPFException(NPFError.ErrorType.INVALID_NA_TOKEN, i, errorMessage.toString());
                }
                if (r2.a(errorMessage, "error") && Intrinsics.areEqual(errorMessage.getString("error"), MapperConstants.NINTENDO_ACCOUNT_FIELD_INVALID_GRANT)) {
                    throw new NPFException(NPFError.ErrorType.INVALID_NA_TOKEN, i, errorMessage.toString());
                }
                NPFError.ErrorType errorType = NPFError.ErrorType.NPF_ERROR;
                numBoxInt = Boxing.boxInt(i);
                if (numBoxInt.intValue() != 401) {
                    numBoxInt = null;
                }
                if (numBoxInt != null) {
                    iIntValue = numBoxInt.intValue();
                } else {
                    iIntValue = 400;
                }
                throw new NPFException(errorType, iIntValue, errorMessage.toString());
            } catch (NPFException e) {
                e = e;
                if (e.getErrorCode() != 400) {
                }
                if (e.getErrorCode() == 409) {
                    throw h3.a(e.getError());
                }
                ((w3) s3Var.d.invoke()).a("naauth_error", "NAAuth#DuplicatedKeyDBNAServer", e.getError());
                throw new NPFException(e.getErrorType(), 500, e.getErrorMessage());
            } catch (JSONException e2) {
                e = e2;
                NPFError nPFErrorCreate_Mapper_InvalidJson_423 = s3Var.e.create_Mapper_InvalidJson_422(e);
                Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_Mapper_InvalidJson_423, "errorFactory.create_Mapper_InvalidJson_422(e)");
                throw h3.a(nPFErrorCreate_Mapper_InvalidJson_423);
            }
        }
        ResultKt.throwOnFailure(objA);
        try {
            com.nintendo.npf.sdk.core.a aVar2 = (com.nintendo.npf.sdk.core.a) this.f560a.invoke();
            aVar.f561a = this;
            aVar.b = str;
            aVar.e = 1;
            objA = aVar2.a(str, aVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
            s3Var = this;
            jSONObject = (JSONObject) objA;
            if (jSONObject != null) {
                NPFError nPFErrorCreate_Mapper_InvalidJson_424 = s3Var.e.create_Mapper_InvalidJson_422("No value for response json");
                Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_Mapper_InvalidJson_424, "errorFactory.create_Mapp…value for response json\")");
                throw h3.a(nPFErrorCreate_Mapper_InvalidJson_424);
            }
            if (!r2.a(jSONObject, MapperConstants.NINTENDO_ACCOUNT_FIELD_TERMS_AGREEMENT)) {
                NPFError nPFErrorCreate_NintendoAccount_NaEulaUpdate_Minus2 = s3Var.e.create_NintendoAccount_NaEulaUpdate_Minus1();
                Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_NintendoAccount_NaEulaUpdate_Minus2, "errorFactory.create_Nint…unt_NaEulaUpdate_Minus1()");
                throw h3.a(nPFErrorCreate_NintendoAccount_NaEulaUpdate_Minus2);
            }
            if (r2.a(jSONObject, "error")) {
                NintendoAccount nintendoAccountA2 = s3Var.c.a(jSONObject, str);
                Intrinsics.checkNotNullExpressionValue(nintendoAccountA2, "nintendoAccountMapper.fr…N(response, sessionToken)");
                return nintendoAccountA2;
            }
            JSONObject jSONObject3 = jSONObject.getJSONObject("error");
            i = jSONObject3.getInt("errorCode");
            errorMessage = jSONObject3.getJSONObject("errorMessage");
            Intrinsics.checkNotNullExpressionValue(errorMessage, "errorMessage");
            if (r2.a(errorMessage, MapperConstants.NINTENDO_ACCOUNT_FIELD_USER_STATUS)) {
                if (!MapperConstants.INSTANCE.getNintendoAccountInvalidUserStatuses().contains(errorMessage.getString(MapperConstants.NINTENDO_ACCOUNT_FIELD_USER_STATUS))) {
                    throw new NPFException(NPFError.ErrorType.INVALID_NA_USER, i, errorMessage.toString());
                }
            }
            if (r2.a(errorMessage, "error")) {
                throw new NPFException(NPFError.ErrorType.INVALID_NA_TOKEN, i, errorMessage.toString());
            }
            if (r2.a(errorMessage, "error")) {
                throw new NPFException(NPFError.ErrorType.INVALID_NA_TOKEN, i, errorMessage.toString());
            }
            NPFError.ErrorType errorType2 = NPFError.ErrorType.NPF_ERROR;
            numBoxInt = Boxing.boxInt(i);
            if (numBoxInt.intValue() != 401) {
                numBoxInt = null;
            }
            if (numBoxInt != null) {
                iIntValue = numBoxInt.intValue();
            } else {
                iIntValue = 400;
            }
            throw new NPFException(errorType2, iIntValue, errorMessage.toString());
        } catch (NPFException e3) {
            e = e3;
            s3Var = this;
            if (e.getErrorCode() != 400 && TextUtils.isEmpty(str)) {
                NPFError nPFErrorCreate_NintendoAccount_InvalidNaToken_400 = s3Var.e.create_NintendoAccount_InvalidNaToken_400(e.getErrorMessage());
                Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_NintendoAccount_InvalidNaToken_400, "errorFactory.create_Nint…Token_400(e.errorMessage)");
                throw h3.a(nPFErrorCreate_NintendoAccount_InvalidNaToken_400);
            }
            if (e.getErrorCode() == 409) {
                throw h3.a(e.getError());
            }
            ((w3) s3Var.d.invoke()).a("naauth_error", "NAAuth#DuplicatedKeyDBNAServer", e.getError());
            throw new NPFException(e.getErrorType(), 500, e.getErrorMessage());
        } catch (JSONException e4) {
            e = e4;
            s3Var = this;
            NPFError nPFErrorCreate_Mapper_InvalidJson_425 = s3Var.e.create_Mapper_InvalidJson_422(e);
            Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_Mapper_InvalidJson_425, "errorFactory.create_Mapper_InvalidJson_422(e)");
            throw h3.a(nPFErrorCreate_Mapper_InvalidJson_425);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(String str, String str2, Continuation continuation) {
        b bVar;
        s3 s3Var;
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
            c cVar = (c) this.b.invoke();
            bVar.f562a = this;
            bVar.d = 1;
            objA = cVar.a(str, str2, bVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
            s3Var = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            s3Var = (s3) bVar.f562a;
            ResultKt.throwOnFailure(objA);
        }
        JSONObject jSONObject = (JSONObject) objA;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(MapperConstants.NINTENDO_ACCOUNT_FIELD_SESSION_TOKEN);
                Intrinsics.checkNotNullExpressionValue(string, "{\n            response.g…_SESSION_TOKEN)\n        }");
                return string;
            } catch (JSONException e) {
                NPFError nPFErrorCreate_Mapper_InvalidJson_422 = s3Var.e.create_Mapper_InvalidJson_422(e);
                Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_Mapper_InvalidJson_422, "errorFactory.create_Mapper_InvalidJson_422(e)");
                throw h3.a(nPFErrorCreate_Mapper_InvalidJson_422);
            }
        }
        NPFError nPFErrorCreate_Mapper_InvalidJson_423 = s3Var.e.create_Mapper_InvalidJson_422("No value for response json");
        Intrinsics.checkNotNullExpressionValue(nPFErrorCreate_Mapper_InvalidJson_423, "errorFactory.create_Mapp…value for response json\")");
        throw h3.a(nPFErrorCreate_Mapper_InvalidJson_423);
    }

    public final void a(NintendoAccount nintendoAccount, String applicationName, String market, String str, String str2, final Function1 block) {
        Intrinsics.checkNotNullParameter(nintendoAccount, "nintendoAccount");
        Intrinsics.checkNotNullParameter(applicationName, "applicationName");
        Intrinsics.checkNotNullParameter(market, "market");
        Intrinsics.checkNotNullParameter(block, "block");
        ((c) this.b.invoke()).a(nintendoAccount, applicationName, market, str, str2, new m1() { // from class: com.nintendo.npf.sdk.core.s3$$ExternalSyntheticLambda0
            @Override // com.nintendo.npf.sdk.core.m1
            public final void onComplete(NPFError nPFError) {
                s3.a(block, nPFError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Function1 block, NPFError nPFError) {
        Intrinsics.checkNotNullParameter(block, "$block");
        block.invoke(nPFError);
    }
}

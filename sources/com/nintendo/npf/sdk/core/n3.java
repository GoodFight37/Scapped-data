package com.nintendo.npf.sdk.core;

import android.util.Base64;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.Scopes;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade;
import com.nintendo.npf.sdk.domain.repository.NintendoAccountRepository;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.user.NintendoAccount;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes2.dex */
public final class n3 implements p3 {
    public static final a g = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NintendoAccountRepository f528a;
    private final y1 b;
    private final DeviceDataFacade c;
    private final q d;
    private k3 e;
    private q3 f;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f529a;
        /* synthetic */ Object b;
        int d;

        b(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return n3.this.a(this);
        }
    }

    public n3(NintendoAccountRepository naRepository, y1 hostInformationDataFacade, DeviceDataFacade deviceDataFacade, q analyticsHelper) {
        Intrinsics.checkNotNullParameter(naRepository, "naRepository");
        Intrinsics.checkNotNullParameter(hostInformationDataFacade, "hostInformationDataFacade");
        Intrinsics.checkNotNullParameter(deviceDataFacade, "deviceDataFacade");
        Intrinsics.checkNotNullParameter(analyticsHelper, "analyticsHelper");
        this.f528a = naRepository;
        this.b = hostInformationDataFacade;
        this.c = deviceDataFacade;
        this.d = analyticsHelper;
    }

    private final void c() {
        this.f = null;
        this.e = null;
    }

    @Override // com.nintendo.npf.sdk.core.p3
    public k3 a() {
        return this.e;
    }

    @Override // com.nintendo.npf.sdk.core.p3
    public q3 b() {
        return this.f;
    }

    @Override // com.nintendo.npf.sdk.core.p3
    public String a(List list, String state, String verifier, String str, Map optionalQuery) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(verifier, "verifier");
        Intrinsics.checkNotNullParameter(optionalQuery, "optionalQuery");
        try {
            String str2 = "npf" + this.b.g() + "://auth";
            String strG = this.b.g();
            String language = this.c.getLanguage();
            String strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.filterNotNull(CollectionsKt.union(list == null ? CollectionsKt.emptyList() : list, CollectionsKt.listOf(Scopes.OPEN_ID))), " ", null, null, 0, null, null, 62, null);
            String strA = a(verifier);
            LinkedHashMap linkedHashMap = new LinkedHashMap(optionalQuery);
            linkedHashMap.put(MapperConstants.SUBSCRIPTION_FIELD_STATE, state);
            linkedHashMap.put("redirect_uri", str2);
            linkedHashMap.put("client_id", strG);
            linkedHashMap.put("lang", language);
            linkedHashMap.put("scope", strJoinToString$default);
            linkedHashMap.put("response_type", "session_token_code");
            linkedHashMap.put("session_token_code_challenge", strA);
            linkedHashMap.put("session_token_code_challenge_method", "S256");
            if (str != null && str.length() != 0) {
                linkedHashMap.put("prompt", FirebaseAnalytics.Event.LOGIN);
                linkedHashMap.put("id_token_hint", str);
            }
            ArrayList arrayList = new ArrayList(linkedHashMap.size());
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                arrayList.add(URLEncoder.encode((String) entry.getKey(), Constants.ENCODING) + '=' + URLEncoder.encode((String) entry.getValue(), Constants.ENCODING));
            }
            return CollectionsKt.joinToString$default(arrayList, "&", null, null, 0, null, null, 62, null);
        } catch (UnsupportedEncodingException e) {
            SDKLog.d("NaAuthorizationDefaultRepository", "Failed to generate query parameter", e);
            throw new IllegalStateException(e);
        } catch (NoSuchAlgorithmException e2) {
            SDKLog.d("NaAuthorizationDefaultRepository", "Failed to generate query parameter", e2);
            throw new IllegalStateException(e2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.nintendo.npf.sdk.core.p3
    public Object a(Continuation continuation) throws Throwable {
        b bVar;
        n3 n3Var;
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
        Object nintendoAccountFromSessionTokenCode = bVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = bVar.d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(nintendoAccountFromSessionTokenCode);
            k3 k3VarA = a();
            if (k3VarA instanceof k3.d) {
                try {
                    NintendoAccountRepository nintendoAccountRepository = this.f528a;
                    String strC = ((k3.d) k3VarA).c();
                    String strC2 = ((k3.d) k3VarA).b().c();
                    String strB = ((k3.d) k3VarA).b().b();
                    bVar.f529a = this;
                    bVar.d = 1;
                    nintendoAccountFromSessionTokenCode = nintendoAccountRepository.getNintendoAccountFromSessionTokenCode(strC, strC2, strB, bVar);
                    if (nintendoAccountFromSessionTokenCode == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    n3Var = this;
                } catch (Throwable th) {
                    th = th;
                    n3Var = this;
                    n3Var.c();
                    throw th;
                }
            } else {
                if (k3VarA instanceof k3.c) {
                    k3.c cVar = (k3.c) k3VarA;
                    a(cVar);
                    c();
                    throw cVar.h();
                }
                k3.c cVar2 = new k3.c(NPFError.ErrorType.USER_CANCEL, -1, "Failed to retrieve session token code", "NAAuth3#ResultIsNull", "Result is null.", false, 32, null);
                a(cVar2);
                c();
                throw cVar2.h();
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            n3Var = (n3) bVar.f529a;
            try {
                ResultKt.throwOnFailure(nintendoAccountFromSessionTokenCode);
            } catch (Throwable th2) {
                th = th2;
                n3Var.c();
                throw th;
            }
        }
        NintendoAccount nintendoAccount = (NintendoAccount) nintendoAccountFromSessionTokenCode;
        n3Var.c();
        return nintendoAccount;
    }

    @Override // com.nintendo.npf.sdk.core.p3
    public void a(int i, k3 result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.f = q3.a(i);
        this.e = result;
    }

    private final String a(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        String strEncodeToString = Base64.encodeToString(messageDigest.digest(bytes), 27);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(hash, Bas…DDING or Base64.NO_CLOSE)");
        return strEncodeToString;
    }

    private final void a(k3.c cVar) {
        if (cVar.f()) {
            q qVar = this.d;
            String strC = cVar.c();
            if (strC == null) {
                strC = "";
            }
            qVar.a("naauth_error", strC, new NPFError(cVar.e(), cVar.b(), cVar.d()));
        }
    }
}

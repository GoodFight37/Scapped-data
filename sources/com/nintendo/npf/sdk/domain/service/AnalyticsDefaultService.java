package com.nintendo.npf.sdk.domain.service;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.analytics.AnalyticsService;
import com.nintendo.npf.sdk.analytics.ResettableIdType;
import com.nintendo.npf.sdk.core.h0;
import com.nintendo.npf.sdk.core.i;
import com.nintendo.npf.sdk.core.i0;
import com.nintendo.npf.sdk.core.k;
import com.nintendo.npf.sdk.core.m;
import com.nintendo.npf.sdk.core.n;
import com.nintendo.npf.sdk.core.s;
import com.nintendo.npf.sdk.core.s4;
import com.nintendo.npf.sdk.core.w;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade;
import com.nintendo.npf.sdk.domain.repository.BaasAccountRepository;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.user.BaaSUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u0000 62\u00020\u0001:\u0001*B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ3\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0017Je\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00122\"\u0010\u001d\u001a\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0004\u0012\u00020\u00150\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJI\u0010!\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0014\u0010\u001d\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0004\u0012\u00020\u00150 H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0015H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0015H\u0016¢\u0006\u0004\b%\u0010$J\u0017\u0010(\u001a\u00020\u00152\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00104\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00105¨\u00067"}, d2 = {"Lcom/nintendo/npf/sdk/domain/service/AnalyticsDefaultService;", "Lcom/nintendo/npf/sdk/analytics/AnalyticsService;", "Lcom/nintendo/npf/sdk/domain/repository/BaasAccountRepository;", "baasAccountRepository", "Lcom/nintendo/npf/sdk/domain/datafacade/DeviceDataFacade;", "deviceDataFacade", "Lkotlin/Function0;", "Lcom/nintendo/npf/sdk/core/w;", "analyticsRepositoryProvider", "Lcom/nintendo/npf/sdk/core/n;", "analyticsConfigRepository", "Lcom/nintendo/npf/sdk/domain/ErrorFactory;", "errorFactory", "<init>", "(Lcom/nintendo/npf/sdk/domain/repository/BaasAccountRepository;Lcom/nintendo/npf/sdk/domain/datafacade/DeviceDataFacade;Lkotlin/jvm/functions/Function0;Lcom/nintendo/npf/sdk/core/n;Lcom/nintendo/npf/sdk/domain/ErrorFactory;)V", "", "eventCategory", "eventId", "Lorg/json/JSONObject;", "playerState", "payload", "", "reportEvent", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;)V", "", "Lcom/nintendo/npf/sdk/analytics/ResettableIdType;", "resettableIdTypes", "Lkotlin/Function2;", "Lcom/nintendo/npf/sdk/NPFError;", "callback", "enqueueResettableIdEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lorg/json/JSONObject;Lorg/json/JSONObject;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/Function1;", "enqueueBaasUserIdEvent", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Lkotlin/jvm/functions/Function1;)V", "suspend", "()V", "resume", "", "enabled", "enableGoogleAdvertisingId", "(Z)V", "a", "Lcom/nintendo/npf/sdk/domain/repository/BaasAccountRepository;", "b", "Lcom/nintendo/npf/sdk/domain/datafacade/DeviceDataFacade;", "c", "Lkotlin/jvm/functions/Function0;", "d", "Lcom/nintendo/npf/sdk/core/n;", "e", "Lcom/nintendo/npf/sdk/domain/ErrorFactory;", "isSuspended", "()Z", "Companion", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AnalyticsDefaultService implements AnalyticsService {
    private static final String f = "AnalyticsDefaultService";

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final BaasAccountRepository baasAccountRepository;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final DeviceDataFacade deviceDataFacade;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final Function0 analyticsRepositoryProvider;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final n analyticsConfigRepository;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final ErrorFactory errorFactory;

    static final class b extends Lambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2 f653a;
        final /* synthetic */ AnalyticsDefaultService b;
        final /* synthetic */ List c;
        final /* synthetic */ BaaSUser d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;
        final /* synthetic */ JSONObject g;
        final /* synthetic */ JSONObject h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Function2 function2, AnalyticsDefaultService analyticsDefaultService, List list, BaaSUser baaSUser, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
            super(2);
            this.f653a = function2;
            this.b = analyticsDefaultService;
            this.c = list;
            this.d = baaSUser;
            this.e = str;
            this.f = str2;
            this.g = jSONObject;
            this.h = jSONObject2;
        }

        public final void a(i iVar, NPFError nPFError) {
            if (nPFError != null) {
                this.f653a.invoke(null, nPFError);
            } else if (iVar != null) {
                AnalyticsDefaultService.a(this.f653a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, iVar);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((i) obj, (NPFError) obj2);
            return Unit.INSTANCE;
        }
    }

    static final class c extends Lambda implements Function1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f654a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Map map) {
            super(1);
            this.f654a = map;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final s invoke(ResettableIdType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return (s) this.f654a.get(type);
        }
    }

    static final class d extends Lambda implements Function1 {
        final /* synthetic */ BaaSUser b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ JSONObject e;
        final /* synthetic */ JSONObject f;
        final /* synthetic */ Map g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(BaaSUser baaSUser, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, Map map) {
            super(1);
            this.b = baaSUser;
            this.c = str;
            this.d = str2;
            this.e = jSONObject;
            this.f = jSONObject2;
            this.g = map;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(s permission) {
            Intrinsics.checkNotNullParameter(permission, "permission");
            return Boolean.valueOf(((w) AnalyticsDefaultService.this.analyticsRepositoryProvider.invoke()).a(this.b, this.c, this.d, this.e, this.f, permission, this.g.keySet(), false) == null);
        }
    }

    static final class e extends Lambda implements Function1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f656a = new e();

        e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ResettableIdType invoke(s permission) {
            Intrinsics.checkNotNullParameter(permission, "permission");
            return permission.b();
        }
    }

    public AnalyticsDefaultService(BaasAccountRepository baasAccountRepository, DeviceDataFacade deviceDataFacade, Function0<? extends w> analyticsRepositoryProvider, n analyticsConfigRepository, ErrorFactory errorFactory) {
        Intrinsics.checkNotNullParameter(baasAccountRepository, "baasAccountRepository");
        Intrinsics.checkNotNullParameter(deviceDataFacade, "deviceDataFacade");
        Intrinsics.checkNotNullParameter(analyticsRepositoryProvider, "analyticsRepositoryProvider");
        Intrinsics.checkNotNullParameter(analyticsConfigRepository, "analyticsConfigRepository");
        Intrinsics.checkNotNullParameter(errorFactory, "errorFactory");
        this.baasAccountRepository = baasAccountRepository;
        this.deviceDataFacade = deviceDataFacade;
        this.analyticsRepositoryProvider = analyticsRepositoryProvider;
        this.analyticsConfigRepository = analyticsConfigRepository;
        this.errorFactory = errorFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Function2 function2, AnalyticsDefaultService analyticsDefaultService, List list, BaaSUser baaSUser, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, i iVar) {
        Map mapB = iVar.b();
        if (mapB == null) {
            function2.invoke(null, analyticsDefaultService.errorFactory.create_Analytics_DisabledUsingResettableId_6403());
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapB.entrySet()) {
            String strA = ((s) entry.getValue()).a();
            if (strA != null && strA.length() != 0) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        List list2 = SequencesKt.toList(SequencesKt.map(SequencesKt.filter(SequencesKt.mapNotNull(CollectionsKt.asSequence(list), new c(linkedHashMap)), analyticsDefaultService.new d(baaSUser, str, str2, jSONObject, jSONObject2, linkedHashMap)), e.f656a));
        if (iVar.k()) {
            ((w) analyticsDefaultService.analyticsRepositoryProvider.invoke()).a();
        }
        function2.invoke(list2, null);
    }

    @Override // com.nintendo.npf.sdk.analytics.AnalyticsService
    public void enableGoogleAdvertisingId(boolean enabled) {
        this.deviceDataFacade.saveIsDisabledUsingGoogleAdvertisingId(!enabled);
    }

    @Override // com.nintendo.npf.sdk.analytics.AnalyticsService
    public void enqueueBaasUserIdEvent(String eventCategory, String eventId, JSONObject playerState, JSONObject payload, Function1<? super NPFError, Unit> callback) {
        Intrinsics.checkNotNullParameter(eventCategory, "eventCategory");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String str = f;
        SDKLog.i(str, "Start enqueueBaasUserIdEvent");
        NPFError nPFErrorD = new i0(eventCategory, eventId, playerState, payload).d();
        if (nPFErrorD != null) {
            SDKLog.w(str, "Validation failed: " + nPFErrorD.getErrorMessage());
            callback.invoke(nPFErrorD);
            return;
        }
        BaaSUser currentBaasUser = this.baasAccountRepository.getCurrentBaasUser();
        if (!h0.c(currentBaasUser)) {
            SDKLog.w(str, "User is not logged in");
            callback.invoke(this.errorFactory.create_BaasAccount_NotLoggedIn_401());
            return;
        }
        NPFError nPFErrorA = ((w) this.analyticsRepositoryProvider.invoke()).a(currentBaasUser, eventCategory, eventId, playerState, payload, null, SetsKt.emptySet(), true);
        if (nPFErrorA != null) {
            SDKLog.w(str, "Failed to save event: " + nPFErrorA.getErrorMessage());
            callback.invoke(nPFErrorA);
        } else {
            if (this.analyticsConfigRepository.a().k()) {
                ((w) this.analyticsRepositoryProvider.invoke()).a();
            }
            callback.invoke(null);
        }
    }

    @Override // com.nintendo.npf.sdk.analytics.AnalyticsService
    public void enqueueResettableIdEvent(String eventCategory, String eventId, List<? extends ResettableIdType> resettableIdTypes, JSONObject playerState, JSONObject payload, Function2<? super List<? extends ResettableIdType>, ? super NPFError, Unit> callback) {
        Intrinsics.checkNotNullParameter(eventCategory, "eventCategory");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(resettableIdTypes, "resettableIdTypes");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SDKLog.i(f, "Start enqueueResettableIdEvent");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(resettableIdTypes, 10));
        Iterator<T> it = resettableIdTypes.iterator();
        while (it.hasNext()) {
            arrayList.add(((ResettableIdType) it.next()).getValue());
        }
        NPFError nPFErrorD = new s4(eventCategory, eventId, arrayList, playerState, payload).d();
        if (nPFErrorD != null) {
            SDKLog.w(f, "Validation failed: " + nPFErrorD.getErrorMessage());
            callback.invoke(null, nPFErrorD);
            return;
        }
        BaaSUser currentBaasUser = this.baasAccountRepository.getCurrentBaasUser();
        if (!h0.c(currentBaasUser)) {
            SDKLog.w(f, "User is not logged in");
            callback.invoke(null, this.errorFactory.create_BaasAccount_NotLoggedIn_401());
            return;
        }
        i iVarA = this.analyticsConfigRepository.a();
        m mVarB = this.analyticsConfigRepository.b();
        if (k.a(iVarA) && mVarB.a(currentBaasUser)) {
            a(callback, this, resettableIdTypes, currentBaasUser, eventCategory, eventId, playerState, payload, iVarA);
        } else {
            this.analyticsConfigRepository.a(currentBaasUser, true, new b(callback, this, resettableIdTypes, currentBaasUser, eventCategory, eventId, playerState, payload));
        }
    }

    @Override // com.nintendo.npf.sdk.analytics.AnalyticsService
    public boolean isSuspended() {
        return ((w) this.analyticsRepositoryProvider.invoke()).isSuspended();
    }

    @Override // com.nintendo.npf.sdk.analytics.AnalyticsService
    public void reportEvent(String eventCategory, String eventId, JSONObject playerState, JSONObject payload) {
        Intrinsics.checkNotNullParameter(eventCategory, "eventCategory");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        String str = f;
        SDKLog.i(str, "Start reportEvent");
        if (eventCategory.length() == 0) {
            SDKLog.w(str, "Event category is empty");
            return;
        }
        if (eventId.length() == 0) {
            SDKLog.w(str, "Event id is empty");
            return;
        }
        BaaSUser currentBaasUser = this.baasAccountRepository.getCurrentBaasUser();
        if (!h0.c(currentBaasUser)) {
            SDKLog.w(str, "User is not logged in");
        } else if (w.a.a((w) this.analyticsRepositoryProvider.invoke(), currentBaasUser, eventCategory, eventId, playerState, payload, null, null, false, 96, null) == null && this.analyticsConfigRepository.a().k()) {
            ((w) this.analyticsRepositoryProvider.invoke()).a();
        }
    }

    @Override // com.nintendo.npf.sdk.analytics.AnalyticsService
    public void resume() {
        ((w) this.analyticsRepositoryProvider.invoke()).a(this.analyticsConfigRepository.a());
    }

    @Override // com.nintendo.npf.sdk.analytics.AnalyticsService
    public void suspend() {
        ((w) this.analyticsRepositoryProvider.invoke()).suspend();
    }
}

package com.nintendo.npf.sdk.internal.impl;

import android.app.Activity;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.MotionEventCompat;
import com.google.common.base.Ascii;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFSDK;
import com.nintendo.npf.sdk.audit.ProfanityWord;
import com.nintendo.npf.sdk.core.g4;
import com.nintendo.npf.sdk.core.x4;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.inquiry.InquiryStatus;
import com.nintendo.npf.sdk.internal.util.Lazy;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.mynintendo.MissionStatus;
import com.nintendo.npf.sdk.mynintendo.PointProgramService;
import com.nintendo.npf.sdk.user.BaaSUser;
import com.nintendo.npf.sdk.user.Gender;
import com.nintendo.npf.sdk.user.LinkToBaasUserCallback;
import com.nintendo.npf.sdk.user.LinkedAccount;
import com.nintendo.npf.sdk.user.NintendoAccount;
import com.nintendo.npf.sdk.user.OtherUser;
import com.nintendo.npf.sdk.user.SwitchBaasUserCallback;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyBundle;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyWallet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class UnityBridge implements NPFSDK.EventHandler, PointProgramService.EventCallback {
    private static Lazy f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map f780a = new HashMap();
    private Object b = new Object();
    private List c = null;
    private PointProgramService d = null;
    private NintendoAccount e = null;

    class a extends Lazy {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nintendo.npf.sdk.internal.util.Lazy
        /* JADX INFO: renamed from: initializeField */
        public UnityBridge initializeField2() {
            return new UnityBridge();
        }
    }

    private static class a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f781a;
        private final JSONArray b;
        private final ErrorFactory c;

        class a implements Function1 {
            a() {
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(NPFError nPFError) {
                try {
                    UnityBridge.getInstance().a(a0.this.f781a, NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
                    return Unit.INSTANCE;
                } catch (JSONException e) {
                    throw new IllegalStateException(e);
                }
            }
        }

        a0(String str, JSONArray jSONArray, ErrorFactory errorFactory) {
            this.f781a = str;
            this.b = jSONArray;
            this.c = errorFactory;
        }

        public void a() throws JSONException {
            String string = this.b.getString(0);
            if (string == null) {
                UnityBridge.getInstance().a(this.f781a, NativeBridgeUtil.toJsonFromNPFError(this.c.create_InvalidParameters_400()));
            } else {
                NPFSDK.getSubscriptionService().purchase(string, new a());
            }
        }
    }

    class b implements BaaSUser.AuthorizationCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f783a;

        b(String str) {
            this.f783a = str;
        }

        @Override // com.nintendo.npf.sdk.user.BaaSUser.AuthorizationCallback
        public void onComplete(BaaSUser baaSUser, NPFError nPFError) {
            try {
                UnityBridge.this.a(this.f783a, NativeBridgeUtil.toNullableJsonFromBaaSUser(baaSUser), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
            } catch (JSONException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private static class b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f784a;
        private final JSONArray b;

        class a implements Function2 {
            a() {
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(List list, NPFError nPFError) {
                try {
                    UnityBridge.getInstance().a(b0.this.f784a, NativeBridgeUtil.toNullableJsonFromSubscriptionPurchases(list), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
                    return Unit.INSTANCE;
                } catch (JSONException e) {
                    throw new IllegalStateException(e);
                }
            }
        }

        b0(String str, JSONArray jSONArray) {
            this.f784a = str;
            this.b = jSONArray;
        }

        public void a() {
            NPFSDK.getSubscriptionService().getGlobalPurchases(new a());
        }
    }

    private static class c0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f787a;
        private final JSONArray b;

        class a implements Function2 {
            a() {
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(List list, NPFError nPFError) {
                try {
                    UnityBridge.getInstance().a(c0.this.f787a, NativeBridgeUtil.toNullableJsonFromSubscriptionPurchases(list), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
                    return Unit.INSTANCE;
                } catch (JSONException e) {
                    throw new IllegalStateException(e);
                }
            }
        }

        c0(String str, JSONArray jSONArray) {
            this.f787a = str;
            this.b = jSONArray;
        }

        public void a() {
            NPFSDK.getSubscriptionService().getPurchases(new a());
        }
    }

    private static class d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f790a;
        private final JSONArray b;

        class a implements Function3 {
            a() {
            }

            @Override // kotlin.jvm.functions.Function3
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(Integer num, Long l, NPFError nPFError) {
                try {
                    UnityBridge.getInstance().a(d0.this.f790a, num, l, NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
                    return Unit.INSTANCE;
                } catch (JSONException e) {
                    throw new IllegalStateException(e);
                }
            }
        }

        d0(String str, JSONArray jSONArray) {
            this.f790a = str;
            this.b = jSONArray;
        }

        public void a() {
            NPFSDK.getSubscriptionService().updateOwnerships(new a());
        }
    }

    private static class e implements OtherUser.RetrievingCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f792a;
        JSONArray b;

        e(String str, JSONArray jSONArray) {
            this.f792a = str;
            this.b = jSONArray;
        }

        public void a() throws JSONException {
            JSONArray jSONArray = this.b.getJSONArray(0);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
            OtherUser.getAsList(arrayList, this);
        }

        @Override // com.nintendo.npf.sdk.user.OtherUser.RetrievingCallback
        public void onComplete(List list, NPFError nPFError) {
            try {
                UnityBridge.getInstance().a(this.f792a, NativeBridgeUtil.toNullableJsonFromOtherUsers(list), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
            } catch (JSONException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private static class e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f793a;
        private final JSONArray b;

        class a implements Function2 {
            a() {
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(List list, NPFError nPFError) {
                try {
                    UnityBridge.getInstance().a(e0.this.f793a, NativeBridgeUtil.toNullableJsonFromSubscriptionPurchases(list), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
                    return Unit.INSTANCE;
                } catch (JSONException e) {
                    throw new IllegalStateException(e);
                }
            }
        }

        e0(String str, JSONArray jSONArray) {
            this.f793a = str;
            this.b = jSONArray;
        }

        public void a() {
            NPFSDK.getSubscriptionService().updatePurchases(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f795a;
        JSONArray b;

        f(String str, JSONArray jSONArray) {
            this.f795a = str;
            this.b = jSONArray;
        }

        public void a() {
            NPFSDK.getInquiryService().check(new Function2() { // from class: com.nintendo.npf.sdk.internal.impl.UnityBridge$f$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return this.f$0.a((InquiryStatus) obj, (NPFError) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit a(InquiryStatus inquiryStatus, NPFError nPFError) {
            try {
                UnityBridge.getInstance().a(this.f795a, NativeBridgeUtil.toNullableJsonFromInquiryStatus(inquiryStatus), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
                return Unit.INSTANCE;
            } catch (JSONException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private static class f0 implements BaaSUser.SwitchByNintendoAccountCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f796a;
        JSONArray b;

        f0(String str, JSONArray jSONArray) {
            this.f796a = str;
            this.b = jSONArray;
        }

        public void a() throws JSONException {
            ArrayList arrayList = new ArrayList();
            if (!this.b.isNull(0)) {
                JSONArray jSONArray = this.b.getJSONArray(0);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            }
            g.f797a.getBaasUser().a(UnityBridge.d(), arrayList, this);
        }

        @Override // com.nintendo.npf.sdk.user.BaaSUser.SwitchByNintendoAccountCallback
        public void onComplete(String str, String str2, NintendoAccount nintendoAccount, NPFError nPFError) {
            if (nintendoAccount != null) {
                UnityBridge.getInstance().e = nintendoAccount;
            }
            try {
                UnityBridge.getInstance().a(this.f796a, str, str2, NativeBridgeUtil.toNullableJsonFromBaaSUser(NPFSDK.getCurrentBaaSUser()), NativeBridgeUtil.toNullableJsonFromNintendoAccount(nintendoAccount), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
            } catch (JSONException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static x4 f797a = x4.a.a();
    }

    private static class g0 implements BaaSUser.SwitchByNintendoAccountCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f798a;
        JSONArray b;

        g0(String str, JSONArray jSONArray) {
            this.f798a = str;
            this.b = jSONArray;
        }

        public void a() throws JSONException {
            ArrayList arrayList = new ArrayList();
            if (!this.b.isNull(0)) {
                JSONArray jSONArray = this.b.getJSONArray(0);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            }
            g.f797a.getBaasUser().a(g.f797a.getNPFSDK().c(), UnityBridge.d(), arrayList, this);
        }

        @Override // com.nintendo.npf.sdk.user.BaaSUser.SwitchByNintendoAccountCallback
        public void onComplete(String str, String str2, NintendoAccount nintendoAccount, NPFError nPFError) {
            if (nintendoAccount != null) {
                UnityBridge.getInstance().e = nintendoAccount;
            }
            try {
                UnityBridge.getInstance().a(this.f798a, str, str2, NativeBridgeUtil.toNullableJsonFromBaaSUser(g.f797a.getNPFSDK().c()), NativeBridgeUtil.toNullableJsonFromNintendoAccount(nintendoAccount), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
            } catch (JSONException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private static class h0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f800a;
        private final JSONArray b;

        class a implements Function2 {
            a() {
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(List list, NPFError nPFError) {
                try {
                    UnityBridge.getInstance().a(h0.this.f800a, NativeBridgeUtil.toNullableJsonFromVCTransactions(list), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
                    return Unit.INSTANCE;
                } catch (JSONException e) {
                    throw new IllegalStateException(e);
                }
            }
        }

        h0(String str, JSONArray jSONArray) {
            this.f800a = str;
            this.b = jSONArray;
        }

        public void a() {
            NPFSDK.getVirtualCurrencyService().checkUnprocessedPurchases(new a());
        }
    }

    private static class i implements LinkToBaasUserCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f802a;
        JSONArray b;

        i(String str, JSONArray jSONArray) {
            this.f802a = str;
            this.b = jSONArray;
        }

        public void a() throws JSONException {
            NPFSDK.getLinkedAppleAccountService().linkToBaasUser(this.b.getString(0), this);
        }

        @Override // com.nintendo.npf.sdk.user.LinkToBaasUserCallback
        public void onComplete(NPFError nPFError) {
            try {
                UnityBridge.getInstance().a(this.f802a, NativeBridgeUtil.toNullableJsonFromBaaSUser(g.f797a.getNPFSDK().c()), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
            } catch (JSONException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private static class i0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f803a;
        private final JSONArray b;

        class a implements Function2 {
            a() {
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(List list, NPFError nPFError) {
                if (list != null) {
                    UnityBridge.getInstance().a(list);
                }
                try {
                    UnityBridge.getInstance().a(i0.this.f803a, NativeBridgeUtil.toNullableJsonFromVCBundles(list), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
                    return Unit.INSTANCE;
                } catch (JSONException e) {
                    throw new IllegalStateException(e);
                }
            }
        }

        i0(String str, JSONArray jSONArray) {
            this.f803a = str;
            this.b = jSONArray;
        }

        public void a() {
            NPFSDK.getVirtualCurrencyService().getBundles(new a());
        }
    }

    private static class j implements SwitchBaasUserCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f805a;
        JSONArray b;

        j(String str, JSONArray jSONArray) {
            this.f805a = str;
            this.b = jSONArray;
        }

        public void a() throws JSONException {
            NPFSDK.getLinkedAppleAccountService().switchBaasUser(this.b.getString(0), this);
        }

        @Override // com.nintendo.npf.sdk.user.SwitchBaasUserCallback
        public void onComplete(String str, String str2, LinkedAccount linkedAccount, NPFError nPFError) {
            try {
                UnityBridge.getInstance().a(this.f805a, str, str2, NativeBridgeUtil.toNullableJsonFromBaaSUser(g.f797a.getNPFSDK().c()), NativeBridgeUtil.toNullableJsonFromNintendoAccount(g.f797a.getNPFSDK().d()), NativeBridgeUtil.toNullableJsonFromLinkedAccount(linkedAccount), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
            } catch (JSONException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private static class j0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f806a;
        private final JSONArray b;

        class a implements Function2 {
            a() {
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(List list, NPFError nPFError) {
                try {
                    UnityBridge.getInstance().a(j0.this.f806a, NativeBridgeUtil.toNullableJsonFromVCWallets(list), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
                    return Unit.INSTANCE;
                } catch (JSONException e) {
                    throw new IllegalStateException(e);
                }
            }
        }

        j0(String str, JSONArray jSONArray) {
            this.f806a = str;
            this.b = jSONArray;
        }

        public void a() throws JSONException {
            String string = this.b.getString(0);
            if (string == null || string.isEmpty()) {
                UnityBridge.getInstance().a(this.f806a, null, NativeBridgeUtil.toJsonFromNPFError(new NPFError(NPFError.ErrorType.NPF_ERROR, 400, "Sku parameter null or empty in bridge")));
                return;
            }
            String string2 = this.b.isNull(1) ? null : this.b.getString(1);
            VirtualCurrencyBundle virtualCurrencyBundleA = UnityBridge.getInstance().a(string);
            if (virtualCurrencyBundleA == null) {
                UnityBridge.getInstance().a(this.f806a, null, NativeBridgeUtil.toJsonFromNPFError(new NPFError(NPFError.ErrorType.NPF_ERROR, 500, "Virtual currency bundle could not be find in cache: " + string)));
            } else {
                NPFSDK.getVirtualCurrencyService().purchase(virtualCurrencyBundleA, string2, new a());
            }
        }
    }

    private static class k implements LinkToBaasUserCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f808a;
        JSONArray b;

        k(String str, JSONArray jSONArray) {
            this.f808a = str;
            this.b = jSONArray;
        }

        public void a() throws JSONException {
            NPFSDK.getLinkedFacebookAccountService().linkToBaasUser(this.b.getString(0), this);
        }

        @Override // com.nintendo.npf.sdk.user.LinkToBaasUserCallback
        public void onComplete(NPFError nPFError) {
            try {
                UnityBridge.getInstance().a(this.f808a, NativeBridgeUtil.toNullableJsonFromBaaSUser(g.f797a.getNPFSDK().c()), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
            } catch (JSONException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private static class k0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f809a;
        private final JSONArray b;

        class a implements Function2 {
            a() {
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(List list, NPFError nPFError) {
                try {
                    UnityBridge.getInstance().a(k0.this.f809a, NativeBridgeUtil.toNullableJsonFromVCWallets(list), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
                    return Unit.INSTANCE;
                } catch (JSONException e) {
                    throw new IllegalStateException(e);
                }
            }
        }

        k0(String str, JSONArray jSONArray) {
            this.f809a = str;
            this.b = jSONArray;
        }

        public void a() {
            NPFSDK.getVirtualCurrencyService().recoverPurchases(new a());
        }
    }

    private static class l implements SwitchBaasUserCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f811a;
        JSONArray b;

        l(String str, JSONArray jSONArray) {
            this.f811a = str;
            this.b = jSONArray;
        }

        public void a() throws JSONException {
            NPFSDK.getLinkedFacebookAccountService().switchBaasUser(this.b.getString(0), this);
        }

        @Override // com.nintendo.npf.sdk.user.SwitchBaasUserCallback
        public void onComplete(String str, String str2, LinkedAccount linkedAccount, NPFError nPFError) {
            try {
                UnityBridge.getInstance().a(this.f811a, str, str2, NativeBridgeUtil.toNullableJsonFromBaaSUser(g.f797a.getNPFSDK().c()), NativeBridgeUtil.toNullableJsonFromNintendoAccount(g.f797a.getNPFSDK().d()), NativeBridgeUtil.toNullableJsonFromLinkedAccount(linkedAccount), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
            } catch (JSONException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private static class l0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f812a;
        private final JSONArray b;

        class a implements Function2 {
            a() {
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(List list, NPFError nPFError) {
                try {
                    UnityBridge.getInstance().a(l0.this.f812a, NativeBridgeUtil.toNullableJsonFromVCWallets(list), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
                    return Unit.INSTANCE;
                } catch (JSONException e) {
                    throw new IllegalStateException(e);
                }
            }
        }

        l0(String str, JSONArray jSONArray) {
            this.f812a = str;
            this.b = jSONArray;
        }

        public void a() {
            NPFSDK.getVirtualCurrencyService().restorePurchases(new a());
        }
    }

    private static class m implements LinkToBaasUserCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f814a;
        JSONArray b;

        m(String str, JSONArray jSONArray) {
            this.f814a = str;
            this.b = jSONArray;
        }

        public void a() throws JSONException {
            NPFSDK.getLinkedGoogleAccountService().linkToBaasUser(this.b.getString(0), this);
        }

        @Override // com.nintendo.npf.sdk.user.LinkToBaasUserCallback
        public void onComplete(NPFError nPFError) {
            try {
                UnityBridge.getInstance().a(this.f814a, NativeBridgeUtil.toNullableJsonFromBaaSUser(g.f797a.getNPFSDK().c()), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
            } catch (JSONException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private static class m0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f815a;
        private final JSONArray b;

        class a implements Function2 {
            a() {
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(List list, NPFError nPFError) {
                try {
                    UnityBridge.getInstance().a(m0.this.f815a, NativeBridgeUtil.toNullableJsonFromVCPurchaseSummaries(list), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
                    return Unit.INSTANCE;
                } catch (JSONException e) {
                    throw new IllegalStateException(e);
                }
            }
        }

        m0(String str, JSONArray jSONArray) {
            this.f815a = str;
            this.b = jSONArray;
        }

        public void a() throws JSONException {
            NPFSDK.getVirtualCurrencyService().getSummaries(this.b.getInt(0), new a());
        }
    }

    private static class n implements SwitchBaasUserCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f817a;
        JSONArray b;

        n(String str, JSONArray jSONArray) {
            this.f817a = str;
            this.b = jSONArray;
        }

        public void a() throws JSONException {
            NPFSDK.getLinkedGoogleAccountService().switchBaasUser(this.b.getString(0), this);
        }

        @Override // com.nintendo.npf.sdk.user.SwitchBaasUserCallback
        public void onComplete(String str, String str2, LinkedAccount linkedAccount, NPFError nPFError) {
            try {
                UnityBridge.getInstance().a(this.f817a, str, str2, NativeBridgeUtil.toNullableJsonFromBaaSUser(g.f797a.getNPFSDK().c()), NativeBridgeUtil.toNullableJsonFromNintendoAccount(g.f797a.getNPFSDK().d()), NativeBridgeUtil.toNullableJsonFromLinkedAccount(linkedAccount), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
            } catch (JSONException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private static class n0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f818a;
        private final JSONArray b;

        class a implements Function2 {
            a() {
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(List list, NPFError nPFError) {
                try {
                    UnityBridge.getInstance().a(n0.this.f818a, NativeBridgeUtil.toNullableJsonFromVCPurchaseSummaries(list), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
                    return Unit.INSTANCE;
                } catch (JSONException e) {
                    throw new IllegalStateException(e);
                }
            }
        }

        n0(String str, JSONArray jSONArray) {
            this.f818a = str;
            this.b = jSONArray;
        }

        public void a() throws JSONException {
            NPFSDK.getVirtualCurrencyService().getSummariesByMarket(this.b.getInt(0), this.b.getString(1), new a());
        }
    }

    private static class o implements MissionStatus.RetrievingCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f820a;
        JSONArray b;

        o(String str, JSONArray jSONArray) {
            this.f820a = str;
            this.b = jSONArray;
        }

        public void a() {
            MissionStatus.getAll(this);
        }

        @Override // com.nintendo.npf.sdk.mynintendo.MissionStatus.RetrievingCallback
        public void onComplete(List list, NPFError nPFError) {
            if (list != null) {
                UnityBridge.getInstance().c = list;
            }
            try {
                UnityBridge.getInstance().a(this.f820a, NativeBridgeUtil.toNullableJsonFromMissionStatuses(list), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
            } catch (JSONException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private static class o0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f821a;
        private final JSONArray b;

        class a implements Function2 {
            a() {
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(List list, NPFError nPFError) {
                try {
                    UnityBridge.getInstance().a(o0.this.f821a, NativeBridgeUtil.toNullableJsonFromVCPurchaseSummaries(list), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
                    return Unit.INSTANCE;
                } catch (JSONException e) {
                    throw new IllegalStateException(e);
                }
            }
        }

        o0(String str, JSONArray jSONArray) {
            this.f821a = str;
            this.b = jSONArray;
        }

        public void a() throws JSONException {
            NPFSDK.getVirtualCurrencyService().getGlobalSummaries(this.b.getInt(0), new a());
        }
    }

    private static class p implements MissionStatus.ReceivingGiftsCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f823a;
        JSONArray b;

        p(String str, JSONArray jSONArray) {
            this.f823a = str;
            this.b = jSONArray;
        }

        public void a() throws JSONException {
            MissionStatus missionStatus;
            String string = this.b.getString(0);
            List list = UnityBridge.getInstance().c;
            if (string != null && list != null) {
                Iterator it = list.iterator();
                do {
                    if (!it.hasNext()) {
                        missionStatus = null;
                        break;
                    }
                    missionStatus = (MissionStatus) it.next();
                } while (!string.equals(missionStatus.getMissionId()));
            } else {
                missionStatus = null;
                break;
            }
            if (missionStatus != null) {
                missionStatus.receiveAvailableGifts(this);
            } else {
                UnityBridge.getInstance().a(this.f823a, NativeBridgeUtil.toJsonFromNPFError(new NPFError(NPFError.ErrorType.NPF_ERROR, 500, "Can't find the MissionStatus! (missionId : " + string + ")")));
            }
        }

        @Override // com.nintendo.npf.sdk.mynintendo.MissionStatus.ReceivingGiftsCallback
        public void onComplete(NPFError nPFError) {
            try {
                UnityBridge.getInstance().a(this.f823a, NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
            } catch (JSONException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private static class p0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f824a;
        private final JSONArray b;

        class a implements Function2 {
            a() {
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(List list, NPFError nPFError) {
                try {
                    UnityBridge.getInstance().a(p0.this.f824a, NativeBridgeUtil.toNullableJsonFromVCWallets(list), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
                    return Unit.INSTANCE;
                } catch (JSONException e) {
                    throw new IllegalStateException(e);
                }
            }
        }

        p0(String str, JSONArray jSONArray) {
            this.f824a = str;
            this.b = jSONArray;
        }

        public void a() {
            NPFSDK.getVirtualCurrencyService().getGlobalWallets(new a());
        }
    }

    private static class q implements NPFSDK.NPFErrorCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f826a;

        q(String str, JSONArray jSONArray) {
            this.f826a = str;
        }

        public void a() {
            g.f797a.getMiiStudioService().a(UnityBridge.d(), this);
        }

        @Override // com.nintendo.npf.sdk.NPFSDK.NPFErrorCallback
        public void onComplete(NPFError nPFError) {
            try {
                UnityBridge.getInstance().a(this.f826a, NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
            } catch (JSONException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private static class q0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f827a;
        private final JSONArray b;

        class a implements Function2 {
            a() {
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(List list, NPFError nPFError) {
                try {
                    UnityBridge.getInstance().a(q0.this.f827a, NativeBridgeUtil.toNullableJsonFromVCWallets(list), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
                    return Unit.INSTANCE;
                } catch (JSONException e) {
                    throw new IllegalStateException(e);
                }
            }
        }

        q0(String str, JSONArray jSONArray) {
            this.f827a = str;
            this.b = jSONArray;
        }

        public void a() {
            NPFSDK.getVirtualCurrencyService().getWallets(new a());
        }
    }

    private static class r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f829a;
        private final JSONArray b;

        class a implements Function2 {
            a() {
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(List list, NPFError nPFError) {
                try {
                    UnityBridge.getInstance().a(r.this.f829a, NativeBridgeUtil.toNullableJsonFromPromoCodeBundle(list), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
                    return Unit.INSTANCE;
                } catch (JSONException e) {
                    throw new IllegalStateException(e);
                }
            }
        }

        r(String str, JSONArray jSONArray) {
            this.f829a = str;
            this.b = jSONArray;
        }

        public void a() {
            NPFSDK.getPromoCodeService().checkPromoCodes(new a());
        }
    }

    private static class s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f831a;
        private final JSONArray b;

        class a implements Function2 {
            a() {
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(List list, NPFError nPFError) {
                try {
                    UnityBridge.getInstance().a(s.this.f831a, NativeBridgeUtil.toNullableJsonFromPromoCodeBundle(list), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
                    return Unit.INSTANCE;
                } catch (JSONException e) {
                    throw new IllegalStateException(e);
                }
            }
        }

        s(String str, JSONArray jSONArray) {
            this.f831a = str;
            this.b = jSONArray;
        }

        public void a() {
            NPFSDK.getPromoCodeService().exchangePromoCodes(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f834a;
        JSONArray b;

        u(String str, JSONArray jSONArray) {
            this.f834a = str;
            this.b = jSONArray;
        }

        public void a() {
            NPFSDK.getPushNotificationChannelService().getDeviceToken(new Function2() { // from class: com.nintendo.npf.sdk.internal.impl.UnityBridge$u$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return this.f$0.a((String) obj, (NPFError) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit a(String str, NPFError nPFError) {
            try {
                UnityBridge.getInstance().a(this.f834a, str != null ? str : JSONObject.NULL, NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
                return Unit.INSTANCE;
            } catch (JSONException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f836a;
        JSONArray b;

        w(String str, JSONArray jSONArray) {
            this.f836a = str;
            this.b = jSONArray;
        }

        public void a() {
            NPFSDK.retryPendingAuthorizationByNintendoAccount2(new Function2() { // from class: com.nintendo.npf.sdk.internal.impl.UnityBridge$w$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return this.f$0.a((NintendoAccount) obj, (NPFError) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit a(NintendoAccount nintendoAccount, NPFError nPFError) {
            if (nintendoAccount != null) {
                UnityBridge.getInstance().e = nintendoAccount;
            }
            try {
                UnityBridge.getInstance().a(this.f836a, NativeBridgeUtil.toNullableJsonFromNintendoAccount(nintendoAccount), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
                return Unit.INSTANCE;
            } catch (JSONException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private static class x implements BaaSUser.SwitchByNintendoAccountCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f837a;
        JSONArray b;

        x(String str, JSONArray jSONArray) {
            this.f837a = str;
            this.b = jSONArray;
        }

        public void a() {
            g.f797a.getBaasUser().a(this);
        }

        @Override // com.nintendo.npf.sdk.user.BaaSUser.SwitchByNintendoAccountCallback
        public void onComplete(String str, String str2, NintendoAccount nintendoAccount, NPFError nPFError) {
            if (nintendoAccount != null) {
                UnityBridge.getInstance().e = nintendoAccount;
            }
            try {
                UnityBridge.getInstance().a(this.f837a, str, str2, NativeBridgeUtil.toNullableJsonFromBaaSUser(NPFSDK.getCurrentBaaSUser()), NativeBridgeUtil.toNullableJsonFromNintendoAccount(nintendoAccount), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
            } catch (JSONException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private static class y implements BaaSUser.SaveCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f838a;
        JSONArray b;

        y(String str, JSONArray jSONArray) {
            this.f838a = str;
            this.b = jSONArray;
        }

        public void a() throws JSONException {
            BaaSUser baaSUserC = g.f797a.getNPFSDK().c();
            baaSUserC.setNickname(!this.b.isNull(0) ? this.b.getString(0) : null);
            baaSUserC.setCountry(this.b.isNull(1) ? null : this.b.getString(1));
            Gender gender = Gender.UNKNOWN;
            if (!this.b.isNull(2)) {
                String string = this.b.getString(2);
                if (string.equals("male")) {
                    gender = Gender.MALE;
                } else if (string.equals("female")) {
                    gender = Gender.FEMALE;
                }
            }
            baaSUserC.setGender(gender);
            baaSUserC.setBirthdayYear(!this.b.isNull(3) ? this.b.getInt(3) : 0);
            baaSUserC.setBirthdayMonth(!this.b.isNull(4) ? this.b.getInt(4) : 0);
            baaSUserC.setBirthdayDay(this.b.isNull(5) ? 0 : this.b.getInt(5));
            baaSUserC.save(this);
        }

        @Override // com.nintendo.npf.sdk.user.BaaSUser.SaveCallback
        public void onComplete(NPFError nPFError) {
            try {
                UnityBridge.getInstance().a(this.f838a, NativeBridgeUtil.toNullableJsonFromBaaSUser(g.f797a.getNPFSDK().c()), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
            } catch (JSONException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f839a;
        private final JSONArray b;

        class a implements Function2 {
            a() {
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(List list, NPFError nPFError) {
                try {
                    UnityBridge.getInstance().a(z.this.f839a, NativeBridgeUtil.toNullableJsonFromSubscriptionProductsForUnity(list), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
                    return Unit.INSTANCE;
                } catch (JSONException e) {
                    throw new IllegalStateException(e);
                }
            }
        }

        z(String str, JSONArray jSONArray) {
            this.f839a = str;
            this.b = jSONArray;
        }

        public void a() {
            NPFSDK.getSubscriptionService().getProducts(new a());
        }
    }

    public static boolean analyticsIsSuspended() {
        return NPFSDK.getAnalyticsService().isSuspended();
    }

    private void c() {
        NPFSDK.getAnalyticsService().suspend();
    }

    private void d(String str, JSONArray jSONArray) throws JSONException {
        PointProgramService.showMissionUI(d(), (float) jSONArray.getDouble(0), jSONArray.getString(1), this);
    }

    private void e(String str, JSONArray jSONArray) throws JSONException {
        PointProgramService.showRewardUI(d(), (float) jSONArray.getDouble(0), jSONArray.getString(1), this);
    }

    /* JADX WARN: Code duplicated, block: B:168:0x02b1  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static void execute(String str) {
        byte b2;
        try {
            SDKLog.d("UnityBridge", "JSON message : " + str);
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(FirebaseAnalytics.Param.METHOD);
            JSONArray jSONArray = jSONObject.getJSONArray("params");
            String string2 = jSONObject.getString("callback");
            Locale locale = Locale.US;
            String lowerCase = string.toLowerCase(locale);
            switch (lowerCase.hashCode()) {
                case -1915630780:
                    if (!lowerCase.equals("virtualcurrencyservicegetglobalsummaries")) {
                        b2 = -1;
                    } else {
                        b2 = Ascii.NAK;
                    }
                    break;
                case -1870530008:
                    if (!lowerCase.equals("resetdeviceaccount")) {
                        b2 = -1;
                    } else {
                        b2 = 1;
                    }
                    break;
                case -1790762726:
                    if (!lowerCase.equals("subscriptionpurchasegetpurchases")) {
                        b2 = -1;
                    } else {
                        b2 = 41;
                    }
                    break;
                case -1678005140:
                    if (!lowerCase.equals("virtualcurrencybundlecheckunprocessedpurchase")) {
                        b2 = -1;
                    } else {
                        b2 = Ascii.DLE;
                    }
                    break;
                case -1628775998:
                    if (!lowerCase.equals("pushnotificationchannelregisterdevicetoken")) {
                        b2 = -1;
                    } else {
                        b2 = 36;
                    }
                    break;
                case -1496333175:
                    if (!lowerCase.equals("missionstatusgetall")) {
                        b2 = -1;
                    } else {
                        b2 = Ascii.SUB;
                    }
                    break;
                case -1253308769:
                    if (!lowerCase.equals("virtualcurrencybundlepurchase")) {
                        b2 = -1;
                    } else {
                        b2 = Ascii.CR;
                    }
                    break;
                case -1244316881:
                    if (!lowerCase.equals("pointprogramservicesetdebugcurrenttimestamp")) {
                        b2 = -1;
                    } else {
                        b2 = 33;
                    }
                    break;
                case -1099859166:
                    if (!lowerCase.equals("pointprogramserviceshowmissionui")) {
                        b2 = -1;
                    } else {
                        b2 = Ascii.FS;
                    }
                    break;
                case -973433286:
                    if (!lowerCase.equals("linkedappleaccountservicelinktobaasuser")) {
                        b2 = -1;
                    } else {
                        b2 = 47;
                    }
                    break;
                case -869374015:
                    if (!lowerCase.equals("pointprogramserviceshowrewardui")) {
                        b2 = -1;
                    } else {
                        b2 = Ascii.GS;
                    }
                    break;
                case -855116167:
                    if (!lowerCase.equals("linkedappleaccountserviceswitchbaasuser")) {
                        b2 = -1;
                    } else {
                        b2 = 48;
                    }
                    break;
                case -686675866:
                    if (!lowerCase.equals("protobuftestservicemultiecho")) {
                        b2 = -1;
                    } else {
                        b2 = 53;
                    }
                    break;
                case -375085443:
                    if (!lowerCase.equals("analyticsenablegoogleadvertisingid")) {
                        b2 = -1;
                    } else {
                        b2 = Ascii.ETB;
                    }
                    break;
                case -247290216:
                    if (!lowerCase.equals("subscriptionpurchaseexecutepurchase")) {
                        b2 = -1;
                    } else {
                        b2 = 40;
                    }
                    break;
                case -223236578:
                    if (!lowerCase.equals("linknintendoaccount")) {
                        b2 = -1;
                    } else {
                        b2 = 7;
                    }
                    break;
                case -178174433:
                    if (!lowerCase.equals("promocodeexchangepromotionpurchased")) {
                        b2 = -1;
                    } else {
                        b2 = 35;
                    }
                    break;
                case 2007083:
                    if (!lowerCase.equals("pushnotificationchannelgetdevicetoken")) {
                        b2 = -1;
                    } else {
                        b2 = 37;
                    }
                    break;
                case 178682030:
                    if (!lowerCase.equals("pointprogramserviceresume")) {
                        b2 = -1;
                    } else {
                        b2 = 32;
                    }
                    break;
                case 195316819:
                    if (!lowerCase.equals("virtualcurrencybundlerestorepurchased")) {
                        b2 = -1;
                    } else {
                        b2 = Ascii.SI;
                    }
                    break;
                case 196549483:
                    if (!lowerCase.equals("linkedgoogleaccountservicelinktobaasuser")) {
                        b2 = -1;
                    } else {
                        b2 = 49;
                    }
                    break;
                case 228609281:
                    if (!lowerCase.equals("nintendoaccountopenmiistudio")) {
                        b2 = -1;
                    } else {
                        b2 = Ascii.VT;
                    }
                    break;
                case 261430401:
                    if (!lowerCase.equals("retrybaasauth")) {
                        b2 = -1;
                    } else {
                        b2 = 0;
                    }
                    break;
                case 293606232:
                    if (!lowerCase.equals("authorizebynintendoaccount")) {
                        b2 = -1;
                    } else {
                        b2 = 4;
                    }
                    break;
                case 314866602:
                    if (!lowerCase.equals("linkedgoogleaccountserviceswitchbaasuser")) {
                        b2 = -1;
                    } else {
                        b2 = 50;
                    }
                    break;
                case 323452458:
                    if (!lowerCase.equals("virtualcurrencypurchasedsummarygetall")) {
                        b2 = -1;
                    } else {
                        b2 = Ascii.DC2;
                    }
                    break;
                case 353473634:
                    if (!lowerCase.equals("subscriptionpurchaseopenlink")) {
                        b2 = -1;
                    } else {
                        b2 = 45;
                    }
                    break;
                case 480636954:
                    if (!lowerCase.equals("virtualcurrencyservicegetglobalwallets")) {
                        b2 = -1;
                    } else {
                        b2 = Ascii.DC4;
                    }
                    break;
                case 493592392:
                    if (!lowerCase.equals("promocodecheckremainexchangepurchased")) {
                        b2 = -1;
                    } else {
                        b2 = 34;
                    }
                    break;
                case 511858650:
                    if (!lowerCase.equals("authorizebynintendoaccount2")) {
                        b2 = -1;
                    } else {
                        b2 = 5;
                    }
                    break;
                case 526925527:
                    if (!lowerCase.equals("subscriptionpurchasegetglobalpurchases")) {
                        b2 = -1;
                    } else {
                        b2 = 42;
                    }
                    break;
                case 667886070:
                    if (!lowerCase.equals("analyticssuspend")) {
                        b2 = -1;
                    } else {
                        b2 = Ascii.CAN;
                    }
                    break;
                case 762558859:
                    if (!lowerCase.equals("subscriptionpurchaseupdateownerships")) {
                        b2 = -1;
                    } else {
                        b2 = 44;
                    }
                    break;
                case 772261710:
                    if (!lowerCase.equals("subscriptionpurchaseopendeeplink")) {
                        b2 = -1;
                    } else {
                        b2 = 46;
                    }
                    break;
                case 839816191:
                    if (!lowerCase.equals("missionstatusreceiveavailablegifts")) {
                        b2 = -1;
                    } else {
                        b2 = Ascii.ESC;
                    }
                    break;
                case 869900335:
                    if (!lowerCase.equals("inquirystatuscheck")) {
                        b2 = -1;
                    } else {
                        b2 = 38;
                    }
                    break;
                case 931588709:
                    if (!lowerCase.equals("switchbynintendoaccount2")) {
                        b2 = -1;
                    } else {
                        b2 = 9;
                    }
                    break;
                case 979083320:
                    if (!lowerCase.equals("linkedfacebookaccountservicelinktobaasuser")) {
                        b2 = -1;
                    } else {
                        b2 = 51;
                    }
                    break;
                case 1070339227:
                    if (!lowerCase.equals("retrypendingauthorizationbynintendoaccount2")) {
                        b2 = -1;
                    } else {
                        b2 = 6;
                    }
                    break;
                case 1097400439:
                    if (!lowerCase.equals("linkedfacebookaccountserviceswitchbaasuser")) {
                        b2 = -1;
                    } else {
                        b2 = 52;
                    }
                    break;
                case 1122652832:
                    if (!lowerCase.equals("analyticsreportevent")) {
                        b2 = -1;
                    } else {
                        b2 = Ascii.SYN;
                    }
                    break;
                case 1262560267:
                    if (!lowerCase.equals("subscriptionpurchaseupdatepurchases")) {
                        b2 = -1;
                    } else {
                        b2 = 43;
                    }
                    break;
                case 1363617587:
                    if (!lowerCase.equals("analyticsresume")) {
                        b2 = -1;
                    } else {
                        b2 = Ascii.EM;
                    }
                    break;
                case 1395769917:
                    if (!lowerCase.equals("virtualcurrencybundlerecoverpurchased")) {
                        b2 = -1;
                    } else {
                        b2 = Ascii.SO;
                    }
                    break;
                case 1447934467:
                    if (!lowerCase.equals("pointprogramservicehide")) {
                        b2 = -1;
                    } else {
                        b2 = Ascii.US;
                    }
                    break;
                case 1656059773:
                    if (!lowerCase.equals("virtualcurrencypurchasedsummarygetallbymarket")) {
                        b2 = -1;
                    } else {
                        b2 = 19;
                    }
                    break;
                case 1668900692:
                    if (!lowerCase.equals("retrypendingswitchbynintendoaccount2")) {
                        b2 = -1;
                    } else {
                        b2 = 10;
                    }
                    break;
                case 1744167392:
                    if (!lowerCase.equals("virtualcurrencywalletgetall")) {
                        b2 = -1;
                    } else {
                        b2 = 17;
                    }
                    break;
                case 1817932713:
                    if (!lowerCase.equals("virtualcurrencybundlegetall")) {
                        b2 = -1;
                    } else {
                        b2 = Ascii.FF;
                    }
                    break;
                case 1818300969:
                    if (!lowerCase.equals("pointprogramservicedismiss")) {
                        b2 = -1;
                    } else {
                        b2 = Ascii.RS;
                    }
                    break;
                case 1841812686:
                    if (!lowerCase.equals("getotherusers")) {
                        b2 = -1;
                    } else {
                        b2 = 3;
                    }
                    break;
                case 1943020665:
                    if (!lowerCase.equals("savebaasuser")) {
                        b2 = -1;
                    } else {
                        b2 = 2;
                    }
                    break;
                case 1983835720:
                    if (!lowerCase.equals("subscriptionproductgetproducts")) {
                        b2 = -1;
                    } else {
                        b2 = 39;
                    }
                    break;
                case 2108261229:
                    if (!lowerCase.equals("switchbynintendoaccount")) {
                        b2 = -1;
                    } else {
                        b2 = 8;
                    }
                    break;
                default:
                    b2 = -1;
                    break;
            }
            switch (b2) {
                case 0:
                    getInstance().a(jSONArray, string2);
                    return;
                case 1:
                    NPFSDK.resetDeviceAccount();
                    return;
                case 2:
                    new y(string2, jSONArray).a();
                    return;
                case 3:
                    new e(string2, jSONArray).a();
                    return;
                case 4:
                    new d(string2, jSONArray).a();
                    return;
                case 5:
                    new c(string2, jSONArray).a();
                    return;
                case 6:
                    new w(string2, jSONArray).a();
                    return;
                case 7:
                    new h(string2, jSONArray).a();
                    return;
                case 8:
                    new g0(string2, jSONArray).a();
                    return;
                case 9:
                    new f0(string2, jSONArray).a();
                    return;
                case 10:
                    new x(string2, jSONArray).a();
                    return;
                case 11:
                    new q(string2, jSONArray).a();
                    return;
                case 12:
                    new i0(string2, jSONArray).a();
                    return;
                case 13:
                    new j0(string2, jSONArray).a();
                    return;
                case 14:
                    new k0(string2, jSONArray).a();
                    return;
                case 15:
                    new l0(string2, jSONArray).a();
                    return;
                case 16:
                    new h0(string2, jSONArray).a();
                    return;
                case 17:
                    new q0(string2, jSONArray).a();
                    return;
                case 18:
                    new m0(string2, jSONArray).a();
                    return;
                case 19:
                    new n0(string2, jSONArray).a();
                    return;
                case 20:
                    new p0(string2, jSONArray).a();
                    return;
                case 21:
                    new o0(string2, jSONArray).a();
                    return;
                case 22:
                    getInstance().b(jSONArray);
                    return;
                case 23:
                    getInstance().a(jSONArray);
                    return;
                case 24:
                    getInstance().c();
                    return;
                case 25:
                    getInstance().b();
                    return;
                case 26:
                    new o(string2, jSONArray).a();
                    return;
                case MotionEventCompat.AXIS_RELATIVE_X /* 27 */:
                    new p(string2, jSONArray).a();
                    return;
                case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
                    getInstance().d(string2, jSONArray);
                    return;
                case 29:
                    getInstance().e(string2, jSONArray);
                    return;
                case 30:
                    getInstance().a(string2, jSONArray);
                    return;
                case 31:
                    getInstance().b(string2, jSONArray);
                    return;
                case 32:
                    getInstance().c(string2, jSONArray);
                    return;
                case 33:
                    getInstance().c(jSONArray);
                    return;
                case MotionEventCompat.AXIS_GENERIC_3 /* 34 */:
                    new r(string2, jSONArray).a();
                    return;
                case MotionEventCompat.AXIS_GENERIC_4 /* 35 */:
                    new s(string2, jSONArray).a();
                    return;
                case 36:
                    new v(string2, jSONArray).a();
                    return;
                case MotionEventCompat.AXIS_GENERIC_6 /* 37 */:
                    new u(string2, jSONArray).a();
                    return;
                case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                    new f(string2, jSONArray).a();
                    return;
                case MotionEventCompat.AXIS_GENERIC_8 /* 39 */:
                    new z(string2, jSONArray).a();
                    return;
                case MotionEventCompat.AXIS_GENERIC_9 /* 40 */:
                    new a0(string2, jSONArray, new ErrorFactory()).a();
                    return;
                case MotionEventCompat.AXIS_GENERIC_10 /* 41 */:
                    new c0(string2, jSONArray).a();
                    return;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    new b0(string2, jSONArray).a();
                    return;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    new e0(string2, jSONArray).a();
                    return;
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    new d0(string2, jSONArray).a();
                    return;
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    getInstance().e();
                    return;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    getInstance().d(jSONArray);
                    return;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    new i(string2, jSONArray).a();
                    return;
                case 48:
                    new j(string2, jSONArray).a();
                    return;
                case 49:
                    new m(string2, jSONArray).a();
                    return;
                case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH /* 50 */:
                    new n(string2, jSONArray).a();
                    return;
                case 51:
                    new k(string2, jSONArray).a();
                    return;
                case 52:
                    new l(string2, jSONArray).a();
                    return;
                case 53:
                    new t(string2, jSONArray).a();
                    return;
                default:
                    throw new IllegalStateException(String.format(locale, "UnityBridge.Execute: Unknown method [%s].", string));
            }
        } catch (JSONException e2) {
            throw new IllegalStateException("UnityBridge.Execute: Could not parse JSON.", e2);
        }
    }

    public static String getAppVersion() {
        return g.f797a.getCapabilities().getAppVersion();
    }

    public static String getDeviceName() {
        return g.f797a.getCapabilities().getDeviceName();
    }

    public static UnityBridge getInstance() {
        return (UnityBridge) f.get();
    }

    public static String getMarket() {
        return NativeBridgeUtil.getMarket();
    }

    public static long getPointProgramServiceDebugCurrentTimestamp() {
        return PointProgramService.getDebugCurrentTimestamp();
    }

    public static boolean getPointProgramServiceIsShowing() {
        if (getInstance().d != null) {
            return getInstance().d.isShowing();
        }
        return false;
    }

    public static String getRuntimeOSVersion() {
        return NativeBridgeUtil.getRuntimeOSVersion();
    }

    public static String getTargetedOS() {
        return NativeBridgeUtil.getTargetedOS();
    }

    public static String getTimeZone() {
        return g.f797a.getCapabilities().getTimeZoneName();
    }

    public static int getTimeZoneOffsetMin() {
        return NativeBridgeUtil.getTimeZoneOffsetMin();
    }

    public static void init(boolean z2) {
        NPFSDK.init(d().getApplication(), getInstance(), z2);
        NPFSDK.setActivity(d());
    }

    public static void setIABNonConsumable(boolean z2) {
        g.f797a.getCapabilities().setIABNonConsumable(z2);
    }

    @Override // com.nintendo.npf.sdk.mynintendo.PointProgramService.EventCallback
    public void onAppeared(PointProgramService pointProgramService) {
        SDKLog.d("UnityBridge", "onAppeared");
        this.d = pointProgramService;
        try {
            a("PointProgramServiceOnAppeared", new Object[0]);
        } catch (JSONException e2) {
            throw new IllegalStateException(e2);
        }
    }

    @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
    public void onBaaSAuthError(NPFError nPFError) {
        try {
            a("onBaaSAuthError", NativeBridgeUtil.toJsonFromNPFError(nPFError));
        } catch (JSONException e2) {
            throw new IllegalStateException(e2);
        }
    }

    @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
    public void onBaaSAuthStart() {
        try {
            a("onBaaSAuthStart", new Object[0]);
        } catch (JSONException e2) {
            throw new IllegalStateException(e2);
        }
    }

    @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
    public void onBaaSAuthUpdate(BaaSUser baaSUser) {
        try {
            a("onBaaSAuthUpdate", NativeBridgeUtil.toJsonFromBaaSUser(baaSUser));
        } catch (JSONException e2) {
            throw new IllegalStateException(e2);
        }
    }

    @Override // com.nintendo.npf.sdk.mynintendo.PointProgramService.EventCallback
    public void onDismiss(NPFError nPFError) {
        SDKLog.d("UnityBridge", "onDismiss");
        this.d = null;
        try {
            a("PointProgramServiceOnDismiss", NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
        } catch (JSONException e2) {
            throw new IllegalStateException(e2);
        }
    }

    @Override // com.nintendo.npf.sdk.mynintendo.PointProgramService.EventCallback
    public void onHide(PointProgramService pointProgramService) {
        SDKLog.d("UnityBridge", "onHide");
        this.d = pointProgramService;
        try {
            a("PointProgramServiceOnHide", new Object[0]);
        } catch (JSONException e2) {
            throw new IllegalStateException(e2);
        }
    }

    @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
    public void onNintendoAccountAuthError(NPFError nPFError) {
        try {
            a("onNintendoAccountAuthError", NativeBridgeUtil.toJsonFromNPFError(nPFError));
        } catch (JSONException e2) {
            throw new IllegalStateException(e2);
        }
    }

    @Override // com.nintendo.npf.sdk.mynintendo.PointProgramService.EventCallback
    public void onNintendoAccountLogin(PointProgramService pointProgramService) {
        SDKLog.d("UnityBridge", "onNintendoAccountLogin");
        this.d = pointProgramService;
        try {
            a("PointProgramServiceOnNintendoAccountLogin", new Object[0]);
        } catch (JSONException e2) {
            throw new IllegalStateException(e2);
        }
    }

    @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
    public void onPendingAuthorizationByNintendoAccount2() {
        try {
            a("onPendingAuthorizationByNintendoAccount2", new Object[0]);
        } catch (JSONException e2) {
            throw new IllegalStateException(e2);
        }
    }

    @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
    public void onPendingSwitchByNintendoAccount2() {
        try {
            a("onPendingSwitchByNintendoAccount2", new Object[0]);
        } catch (JSONException e2) {
            throw new IllegalStateException(e2);
        }
    }

    @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
    public void onVirtualCurrencyPurchaseProcessError(NPFError nPFError) {
        try {
            a("onVirtualCurrencyPurchaseProcessError", NativeBridgeUtil.toJsonFromNPFError(nPFError));
        } catch (JSONException e2) {
            throw new IllegalStateException(e2);
        }
    }

    @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
    public void onVirtualCurrencyPurchaseProcessSuccess(Map<String, VirtualCurrencyWallet> map) {
        try {
            a("onVirtualCurrencyPurchaseProcessSuccess", NativeBridgeUtil.toJsonFromVCWallets(map.values()));
        } catch (JSONException e2) {
            throw new IllegalStateException(e2);
        }
    }

    @Override // com.nintendo.npf.sdk.NPFSDK.EventHandler
    public void onVirtualCurrencyPurchasesUpdated() {
        try {
            a("onVirtualCurrencyPurchasesUpdated", new Object[0]);
        } catch (JSONException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private void c(String str, JSONArray jSONArray) throws JSONException {
        if (this.d != null) {
            this.d.resume(jSONArray.getBoolean(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f835a;
        JSONArray b;

        v(String str, JSONArray jSONArray) {
            this.f835a = str;
            this.b = jSONArray;
        }

        public void a() {
            NPFSDK.getPushNotificationChannelService().registerDeviceToken(!this.b.isNull(0) ? this.b.getString(0) : null, new Function1() { // from class: com.nintendo.npf.sdk.internal.impl.UnityBridge$v$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return this.f$0.a((NPFError) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit a(NPFError nPFError) {
            try {
                UnityBridge.getInstance().a(this.f835a, NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
                return Unit.INSTANCE;
            } catch (JSONException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private void b(JSONArray jSONArray) {
        String string;
        JSONObject jSONObject;
        String string2 = "";
        if (jSONArray.isNull(0)) {
            string = "";
        } else {
            try {
                string = jSONArray.getString(0);
            } catch (JSONException e2) {
                SDKLog.w("UnityBridge", e2.getMessage());
                string = "";
            }
        }
        if (!jSONArray.isNull(1)) {
            try {
                string2 = jSONArray.getString(1);
            } catch (JSONException e3) {
                SDKLog.w("UnityBridge", e3.getMessage());
            }
        }
        JSONObject jSONObject2 = null;
        if (jSONArray.isNull(2)) {
            jSONObject = null;
        } else {
            try {
                jSONObject = jSONArray.getJSONObject(2);
            } catch (JSONException e4) {
                SDKLog.w("UnityBridge", e4.getMessage());
                jSONObject = null;
            }
        }
        if (!jSONArray.isNull(3)) {
            try {
                jSONObject2 = jSONArray.getJSONObject(3);
            } catch (JSONException e5) {
                SDKLog.w("UnityBridge", e5.getMessage());
            }
        }
        NPFSDK.getAnalyticsService().reportEvent(string, string2, jSONObject, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Activity d() {
        try {
            Class<?> cls = Class.forName("com.unity3d.player.UnityPlayer");
            return (Activity) cls.getField("currentActivity").get(cls);
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }

    private void e() {
        NPFSDK.getSubscriptionController().openLink();
    }

    private void c(JSONArray jSONArray) {
        if (jSONArray.length() == 1) {
            PointProgramService.setDebugCurrentTimestamp(jSONArray.getLong(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Object... objArr) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object obj : objArr) {
            jSONArray.put(obj);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("callback", str);
        jSONObject.put("params", jSONArray);
        b(jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f786a;
        JSONArray b;

        c(String str, JSONArray jSONArray) {
            this.f786a = str;
            this.b = jSONArray;
        }

        public void a() throws JSONException {
            ArrayList arrayList = new ArrayList();
            if (!this.b.isNull(0)) {
                JSONArray jSONArray = this.b.getJSONArray(0);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            }
            NPFSDK.authorizeByNintendoAccount2(UnityBridge.d(), arrayList, null, new Function2() { // from class: com.nintendo.npf.sdk.internal.impl.UnityBridge$c$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return this.f$0.a((NintendoAccount) obj, (NPFError) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit a(NintendoAccount nintendoAccount, NPFError nPFError) {
            if (nintendoAccount != null) {
                UnityBridge.getInstance().e = nintendoAccount;
            }
            try {
                UnityBridge.getInstance().a(this.f786a, NativeBridgeUtil.toNullableJsonFromNintendoAccount(nintendoAccount), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
                return Unit.INSTANCE;
            } catch (JSONException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f789a;
        JSONArray b;

        d(String str, JSONArray jSONArray) {
            this.f789a = str;
            this.b = jSONArray;
        }

        public void a() throws JSONException {
            ArrayList arrayList = new ArrayList();
            if (!this.b.isNull(0)) {
                JSONArray jSONArray = this.b.getJSONArray(0);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            }
            NPFSDK.authorizeByNintendoAccount(UnityBridge.d(), arrayList, null, new Function2() { // from class: com.nintendo.npf.sdk.internal.impl.UnityBridge$d$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return this.f$0.a((NintendoAccount) obj, (NPFError) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit a(NintendoAccount nintendoAccount, NPFError nPFError) {
            if (nintendoAccount != null) {
                UnityBridge.getInstance().e = nintendoAccount;
            }
            try {
                UnityBridge.getInstance().a(this.f789a, NativeBridgeUtil.toNullableJsonFromNintendoAccount(nintendoAccount), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
                return Unit.INSTANCE;
            } catch (JSONException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private void d(JSONArray jSONArray) throws JSONException {
        String string = jSONArray.getString(0);
        if (string != null && !string.isEmpty()) {
            NPFSDK.getSubscriptionController().openDeepLink(string);
        } else {
            SDKLog.w("UnityBridge", "Product id is null or empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class h implements BaaSUser.LinkNintendoAccountCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f799a;
        JSONArray b;

        h(String str, JSONArray jSONArray) {
            this.f799a = str;
            this.b = jSONArray;
        }

        public void a() throws JSONException {
            String string = this.b.getString(0);
            NintendoAccount nintendoAccount = UnityBridge.getInstance().e;
            if (nintendoAccount == null || !string.equals(nintendoAccount.getNintendoAccountId())) {
                onComplete(new NPFError(NPFError.ErrorType.NPF_ERROR, 400, "parameter nintendoAccount is invalid"));
            } else {
                NPFSDK.getBaasAccountService().linkNintendoAccount(nintendoAccount, new Function1() { // from class: com.nintendo.npf.sdk.internal.impl.UnityBridge$h$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return this.f$0.a((NPFError) obj);
                    }
                });
            }
        }

        @Override // com.nintendo.npf.sdk.user.BaaSUser.LinkNintendoAccountCallback
        public void onComplete(NPFError nPFError) {
            try {
                UnityBridge.getInstance().a(this.f799a, NativeBridgeUtil.toNullableJsonFromBaaSUser(g.f797a.getNPFSDK().c()), NativeBridgeUtil.toNullableJsonFromNintendoAccount(g.f797a.getNPFSDK().c().getNintendoAccount()), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
            } catch (JSONException e) {
                throw new IllegalStateException(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit a(NPFError nPFError) {
            onComplete(nPFError);
            return Unit.INSTANCE;
        }
    }

    private void a(JSONArray jSONArray) {
        try {
            NPFSDK.getAnalyticsService().enableGoogleAdvertisingId(jSONArray.getBoolean(0));
        } catch (JSONException e2) {
            SDKLog.w("UnityBridge", e2.getMessage());
        }
    }

    private void a(String str, JSONArray jSONArray) {
        PointProgramService pointProgramService = this.d;
        if (pointProgramService != null) {
            pointProgramService.dismiss();
        }
    }

    private void a(JSONArray jSONArray, String str) {
        b bVar = new b(str);
        if (jSONArray.length() == 1) {
            NPFSDK.retryBaaSAuth(jSONArray.getBoolean(0), bVar);
        } else {
            if (jSONArray.length() == 2) {
                NPFSDK.retryBaaSAuth(jSONArray.getString(0), jSONArray.getString(1), bVar);
                return;
            }
            throw new IllegalStateException("UnityBridge.RetryBaaSAuth: Bad params[" + jSONArray.toString() + "]");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f833a;
        JSONArray b;

        t(String str, JSONArray jSONArray) {
            this.f833a = str;
            this.b = jSONArray;
        }

        public void a() throws JSONException {
            JSONArray jSONArray = this.b.getJSONArray(0);
            final ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString("language");
                String string2 = jSONObject.getString("text");
                String string3 = jSONObject.getString("dictionaryType");
                String string4 = jSONObject.getString("checkStatus");
                arrayList.add(new ProfanityWord(string, string2, string3.equals("nickname") ? ProfanityWord.ProfanityDictionaryType.NICKNAME : ProfanityWord.ProfanityDictionaryType.COMMON, string4.equals("valid") ? ProfanityWord.ProfanityCheckStatus.VALID : string4.equals("invalid") ? ProfanityWord.ProfanityCheckStatus.INVALID : ProfanityWord.ProfanityCheckStatus.UNCHECKED));
            }
            g4.f466a.a(arrayList, new Function2() { // from class: com.nintendo.npf.sdk.internal.impl.UnityBridge$t$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return this.f$0.a(arrayList, (List) obj, (NPFError) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit a(ArrayList arrayList, List list, NPFError nPFError) {
            try {
                UnityBridge.getInstance().a(this.f833a, NativeBridgeUtil.toNullableJsonFromProfanityWords(arrayList), NativeBridgeUtil.toNullableJsonFromNPFError(nPFError));
                return Unit.INSTANCE;
            } catch (JSONException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private void b() {
        NPFSDK.getAnalyticsService().resume();
    }

    private void b(String str, JSONArray jSONArray) {
        PointProgramService pointProgramService = this.d;
        if (pointProgramService != null) {
            pointProgramService.hide();
        }
    }

    private synchronized void b(String str) {
        try {
            SDKLog.d("UnityBridge", str);
            Class<?> cls = Class.forName("com.unity3d.player.UnityPlayer");
            cls.getMethod("UnitySendMessage", String.class, String.class, String.class).invoke(cls, "NPFSDK", "NativeBridgeCallback", str);
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List list) {
        synchronized (this.b) {
            this.f780a.clear();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                VirtualCurrencyBundle virtualCurrencyBundle = (VirtualCurrencyBundle) it.next();
                this.f780a.put(virtualCurrencyBundle.getSku(), virtualCurrencyBundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VirtualCurrencyBundle a(String str) {
        VirtualCurrencyBundle virtualCurrencyBundle;
        synchronized (this.b) {
            virtualCurrencyBundle = (VirtualCurrencyBundle) this.f780a.get(str);
        }
        return virtualCurrencyBundle;
    }
}

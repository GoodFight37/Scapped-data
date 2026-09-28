package com.nintendo.npf.sdk.internal.impl.cpp;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFSDK;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.internal.impl.NativeBridgeUtil;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public class SubscriptionServiceEventHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f865a = "SubscriptionServiceEventHandler";

    class a implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f866a;
        final /* synthetic */ long b;

        a(long j, long j2) {
            this.f866a = j;
            this.b = j2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(List list, NPFError nPFError) {
            String str;
            String string;
            String str2;
            String string2 = null;
            if (list != null) {
                try {
                    string = NativeBridgeUtil.toJsonFromSubscriptionProducts(list).toString();
                } catch (JSONException e) {
                    e = e;
                    str = null;
                    e.printStackTrace();
                    str2 = str;
                    SubscriptionServiceEventHandler.onCallback2(this.f866a, this.b, str2, string2);
                    return Unit.INSTANCE;
                }
            } else {
                string = null;
            }
            if (nPFError != null) {
                try {
                    string2 = NativeBridgeUtil.toJsonFromNPFError(nPFError).toString();
                } catch (JSONException e2) {
                    str = string;
                    e = e2;
                    e.printStackTrace();
                    str2 = str;
                }
            }
            str2 = string;
            SubscriptionServiceEventHandler.onCallback2(this.f866a, this.b, str2, string2);
            return Unit.INSTANCE;
        }
    }

    class b implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f867a;
        final /* synthetic */ long b;

        b(long j, long j2) {
            this.f867a = j;
            this.b = j2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(List list, NPFError nPFError) {
            String str;
            String string;
            String str2;
            String string2 = null;
            if (list != null) {
                try {
                    string = NativeBridgeUtil.toJsonFromSubscriptionPurchases(list).toString();
                } catch (JSONException e) {
                    e = e;
                    str = null;
                    e.printStackTrace();
                    str2 = str;
                    SubscriptionServiceEventHandler.onCallback2(this.f867a, this.b, str2, string2);
                    return Unit.INSTANCE;
                }
            } else {
                string = null;
            }
            if (nPFError != null) {
                try {
                    string2 = NativeBridgeUtil.toJsonFromNPFError(nPFError).toString();
                } catch (JSONException e2) {
                    str = string;
                    e = e2;
                    e.printStackTrace();
                    str2 = str;
                }
            }
            str2 = string;
            SubscriptionServiceEventHandler.onCallback2(this.f867a, this.b, str2, string2);
            return Unit.INSTANCE;
        }
    }

    class c implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f868a;
        final /* synthetic */ long b;

        c(long j, long j2) {
            this.f868a = j;
            this.b = j2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(List list, NPFError nPFError) {
            String str;
            String string;
            String str2;
            String string2 = null;
            if (list != null) {
                try {
                    string = NativeBridgeUtil.toJsonFromSubscriptionPurchases(list).toString();
                } catch (JSONException e) {
                    e = e;
                    str = null;
                    e.printStackTrace();
                    str2 = str;
                    SubscriptionServiceEventHandler.onCallback2(this.f868a, this.b, str2, string2);
                    return Unit.INSTANCE;
                }
            } else {
                string = null;
            }
            if (nPFError != null) {
                try {
                    string2 = NativeBridgeUtil.toJsonFromNPFError(nPFError).toString();
                } catch (JSONException e2) {
                    str = string;
                    e = e2;
                    e.printStackTrace();
                    str2 = str;
                }
            }
            str2 = string;
            SubscriptionServiceEventHandler.onCallback2(this.f868a, this.b, str2, string2);
            return Unit.INSTANCE;
        }
    }

    class d implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f869a;
        final /* synthetic */ long b;

        d(long j, long j2) {
            this.f869a = j;
            this.b = j2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(List list, NPFError nPFError) {
            String str;
            String string;
            String str2;
            String string2 = null;
            if (list != null) {
                try {
                    string = NativeBridgeUtil.toJsonFromSubscriptionPurchases(list).toString();
                } catch (JSONException e) {
                    e = e;
                    str = null;
                    e.printStackTrace();
                    str2 = str;
                    SubscriptionServiceEventHandler.onCallback2(this.f869a, this.b, str2, string2);
                    return Unit.INSTANCE;
                }
            } else {
                string = null;
            }
            if (nPFError != null) {
                try {
                    string2 = NativeBridgeUtil.toJsonFromNPFError(nPFError).toString();
                } catch (JSONException e2) {
                    str = string;
                    e = e2;
                    e.printStackTrace();
                    str2 = str;
                }
            }
            str2 = string;
            SubscriptionServiceEventHandler.onCallback2(this.f869a, this.b, str2, string2);
            return Unit.INSTANCE;
        }
    }

    class e implements Function3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f870a;
        final /* synthetic */ long b;

        e(long j, long j2) {
            this.f870a = j;
            this.b = j2;
        }

        @Override // kotlin.jvm.functions.Function3
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Integer num, Long l, NPFError nPFError) {
            String string;
            if (nPFError != null) {
                try {
                    string = NativeBridgeUtil.toJsonFromNPFError(nPFError).toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                    string = null;
                }
            } else {
                string = null;
            }
            SubscriptionServiceEventHandler.onOwnershipsCallback(this.f870a, this.b, num.intValue(), l.longValue(), string);
            return Unit.INSTANCE;
        }
    }

    class f implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f871a;
        final /* synthetic */ long b;

        f(long j, long j2) {
            this.f871a = j;
            this.b = j2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(List list, NPFError nPFError) {
            String str;
            String string;
            String str2;
            String string2 = null;
            if (list != null) {
                try {
                    string = NativeBridgeUtil.toJsonFromSubscriptionTransactions(list).toString();
                } catch (JSONException e) {
                    e = e;
                    str = null;
                    e.printStackTrace();
                    str2 = str;
                    SubscriptionServiceEventHandler.onCallback2(this.f871a, this.b, str2, string2);
                    return Unit.INSTANCE;
                }
            } else {
                string = null;
            }
            if (nPFError != null) {
                try {
                    string2 = NativeBridgeUtil.toJsonFromNPFError(nPFError).toString();
                } catch (JSONException e2) {
                    str = string;
                    e = e2;
                    e.printStackTrace();
                    str2 = str;
                }
            }
            str2 = string;
            SubscriptionServiceEventHandler.onCallback2(this.f871a, this.b, str2, string2);
            return Unit.INSTANCE;
        }
    }

    class g implements Function1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f872a;
        final /* synthetic */ long b;

        g(long j, long j2) {
            this.f872a = j;
            this.b = j2;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(NPFError nPFError) {
            String string;
            if (nPFError != null) {
                try {
                    string = NativeBridgeUtil.toJsonFromNPFError(nPFError).toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                    string = null;
                }
            } else {
                string = null;
            }
            SubscriptionServiceEventHandler.onCallback1(this.f872a, this.b, string);
            return Unit.INSTANCE;
        }
    }

    public static void checkUnprocessedPurchases(long j, long j2) {
        NPFSDK.getSubscriptionService().checkUnprocessedPurchases(new f(j, j2));
    }

    public static void getGlobalPurchases(long j, long j2) {
        NPFSDK.getSubscriptionService().getGlobalPurchases(new c(j, j2));
    }

    public static void getProducts(long j, long j2) {
        NPFSDK.getSubscriptionService().getProducts(new a(j, j2));
    }

    public static void getPurchases(long j, long j2) {
        NPFSDK.getSubscriptionService().getPurchases(new b(j, j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void onCallback1(long j, long j2, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void onCallback2(long j, long j2, String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void onOwnershipsCallback(long j, long j2, int i, long j3, String str);

    public static void openDeepLink(String str) {
        if (str == null || str.isEmpty()) {
            SDKLog.w(f865a, "Product id is null or empty");
        } else {
            NPFSDK.getSubscriptionController().openDeepLink(str);
        }
    }

    public static void openLink() {
        NPFSDK.getSubscriptionController().openLink();
    }

    public static void purchase(long j, long j2, String str) {
        String string;
        if (str != null) {
            NPFSDK.getSubscriptionService().purchase(str, new g(j, j2));
            return;
        }
        try {
            string = NativeBridgeUtil.toJsonFromNPFError(new ErrorFactory().create_InvalidParameters_400()).toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            string = null;
        }
        onCallback1(j, j2, string);
    }

    public static void updateOwnerships(long j, long j2) {
        NPFSDK.getSubscriptionService().updateOwnerships(new e(j, j2));
    }

    public static void updatePurchases(long j, long j2) {
        NPFSDK.getSubscriptionService().updatePurchases(new d(j, j2));
    }
}

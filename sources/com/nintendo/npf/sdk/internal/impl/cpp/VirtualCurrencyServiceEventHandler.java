package com.nintendo.npf.sdk.internal.impl.cpp;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFSDK;
import com.nintendo.npf.sdk.internal.impl.NativeBridgeUtil;
import com.nintendo.npf.sdk.vcm.VirtualCurrencyBundle;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public class VirtualCurrencyServiceEventHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map f877a = new HashMap();

    class a implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f878a;
        final /* synthetic */ long b;

        a(long j, long j2) {
            this.f878a = j;
            this.b = j2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(List list, NPFError nPFError) {
            String string;
            String string2 = null;
            if (list != null) {
                try {
                    string = NativeBridgeUtil.toJsonFromVCBundles(list).toString();
                    try {
                        VirtualCurrencyServiceEventHandler.b(list);
                    } catch (JSONException e) {
                        e = e;
                        e.printStackTrace();
                    }
                } catch (JSONException e2) {
                    e = e2;
                    string = null;
                    e.printStackTrace();
                }
            } else {
                string = null;
            }
            if (nPFError != null) {
                string2 = NativeBridgeUtil.toJsonFromNPFError(nPFError).toString();
            }
            VirtualCurrencyServiceEventHandler.onCallback(this.f878a, this.b, string, string2);
            return Unit.INSTANCE;
        }
    }

    class b implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f879a;
        final /* synthetic */ long b;

        b(long j, long j2) {
            this.f879a = j;
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
                    string = NativeBridgeUtil.toJsonFromVCTransactions(list).toString();
                } catch (JSONException e) {
                    e = e;
                    str = null;
                    e.printStackTrace();
                    str2 = str;
                    VirtualCurrencyServiceEventHandler.onCallback(this.f879a, this.b, str2, string2);
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
            VirtualCurrencyServiceEventHandler.onCallback(this.f879a, this.b, str2, string2);
            return Unit.INSTANCE;
        }
    }

    class c implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f880a;
        final /* synthetic */ long b;

        c(long j, long j2) {
            this.f880a = j;
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
                    string = NativeBridgeUtil.toJsonFromVCWallets(list).toString();
                } catch (JSONException e) {
                    e = e;
                    str = null;
                    e.printStackTrace();
                    str2 = str;
                    VirtualCurrencyServiceEventHandler.onCallback(this.f880a, this.b, str2, string2);
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
            VirtualCurrencyServiceEventHandler.onCallback(this.f880a, this.b, str2, string2);
            return Unit.INSTANCE;
        }
    }

    class d implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f881a;
        final /* synthetic */ long b;

        d(long j, long j2) {
            this.f881a = j;
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
                    string = NativeBridgeUtil.toJsonFromVCPurchaseSummaries(list).toString();
                } catch (JSONException e) {
                    e = e;
                    str = null;
                    e.printStackTrace();
                    str2 = str;
                    VirtualCurrencyServiceEventHandler.onCallback(this.f881a, this.b, str2, string2);
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
            VirtualCurrencyServiceEventHandler.onCallback(this.f881a, this.b, str2, string2);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(List list) {
        synchronized (VirtualCurrencyServiceEventHandler.class) {
            f877a.clear();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                VirtualCurrencyBundle virtualCurrencyBundle = (VirtualCurrencyBundle) it.next();
                f877a.put(virtualCurrencyBundle.getSku(), virtualCurrencyBundle);
            }
        }
    }

    public static void checkUnprocessedPurchases(long j, long j2) {
        NPFSDK.getVirtualCurrencyService().checkUnprocessedPurchases(new b(j, j2));
    }

    public static void getBundles(long j, long j2) {
        NPFSDK.getVirtualCurrencyService().getBundles(new a(j, j2));
    }

    public static void getGlobalSummaries(long j, long j2, int i) {
        NPFSDK.getVirtualCurrencyService().getGlobalSummaries(i, a(j, j2));
    }

    public static void getGlobalWallets(long j, long j2) {
        NPFSDK.getVirtualCurrencyService().getGlobalWallets(b(j, j2));
    }

    public static void getSummaries(long j, long j2, int i) {
        NPFSDK.getVirtualCurrencyService().getSummaries(i, a(j, j2));
    }

    public static void getSummariesByMarket(long j, long j2, int i, String str) {
        NPFSDK.getVirtualCurrencyService().getSummariesByMarket(i, str, a(j, j2));
    }

    public static void getWallets(long j, long j2) {
        NPFSDK.getVirtualCurrencyService().getWallets(b(j, j2));
    }

    public static native void onCallback(long j, long j2, String str, String str2);

    public static void purchase(long j, long j2, byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length == 0) {
            try {
                onCallback(j, j2, null, NativeBridgeUtil.toJsonFromNPFError(new NPFError(NPFError.ErrorType.NPF_ERROR, 400, "Sku parameter null or empty in bridge")).toString());
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        String str = new String(bArr);
        VirtualCurrencyBundle virtualCurrencyBundleA = a(str);
        if (virtualCurrencyBundleA != null) {
            NPFSDK.getVirtualCurrencyService().purchase(virtualCurrencyBundleA, bArr2 == null ? null : new String(bArr2), b(j, j2));
            return;
        }
        try {
            onCallback(j, j2, null, NativeBridgeUtil.toJsonFromNPFError(new NPFError(NPFError.ErrorType.NPF_ERROR, 500, "Virtual currency bundle could not be find in cache: ".concat(str))).toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void recoverPurchases(long j, long j2) {
        NPFSDK.getVirtualCurrencyService().recoverPurchases(b(j, j2));
    }

    public static void restorePurchases(long j, long j2) {
        NPFSDK.getVirtualCurrencyService().restorePurchases(b(j, j2));
    }

    private static VirtualCurrencyBundle a(String str) {
        VirtualCurrencyBundle virtualCurrencyBundle;
        synchronized (VirtualCurrencyServiceEventHandler.class) {
            virtualCurrencyBundle = (VirtualCurrencyBundle) f877a.get(str);
        }
        return virtualCurrencyBundle;
    }

    private static Function2 a(long j, long j2) {
        return new d(j, j2);
    }

    private static Function2 b(long j, long j2) {
        return new c(j, j2);
    }
}

package com.nintendo.npf.sdk.internal.impl.cpp;

import android.app.Activity;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFSDK;
import com.nintendo.npf.sdk.internal.impl.NativeBridgeUtil;
import com.nintendo.npf.sdk.user.NintendoAccount;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public class NintendoAccountEventHandler implements NPFSDK.NPFErrorCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f855a;
    private long b;

    public NintendoAccountEventHandler() {
        this.f855a = -1L;
        this.b = -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit a(long j, long j2, NintendoAccount nintendoAccount, NPFError nPFError) {
        String str;
        String string;
        String str2;
        if (nintendoAccount != null) {
            BaaSUserLinkEventHandler.c = nintendoAccount;
        }
        String string2 = null;
        if (nintendoAccount != null) {
            try {
                string = NativeBridgeUtil.toJsonFromNintendoAccount(nintendoAccount).toString();
            } catch (JSONException e) {
                e = e;
                str = null;
                e.printStackTrace();
                str2 = str;
                onAuthorizedByNintendoAccountCallback(j, j2, str2, string2);
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
        onAuthorizedByNintendoAccountCallback(j, j2, str2, string2);
        return Unit.INSTANCE;
    }

    public static void authorizeByNintendoAccount(final long j, final long j2, Activity activity, byte[] bArr) {
        NPFSDK.authorizeByNintendoAccount(activity, parseScope(new String(bArr)), null, new Function2() { // from class: com.nintendo.npf.sdk.internal.impl.cpp.NintendoAccountEventHandler$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return NintendoAccountEventHandler.a(j, j2, (NintendoAccount) obj, (NPFError) obj2);
            }
        });
    }

    public static void authorizeByNintendoAccount2(final long j, final long j2, Activity activity, byte[] bArr) {
        NPFSDK.authorizeByNintendoAccount2(activity, parseScope(new String(bArr)), null, new Function2() { // from class: com.nintendo.npf.sdk.internal.impl.cpp.NintendoAccountEventHandler$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return NintendoAccountEventHandler.b(j, j2, (NintendoAccount) obj, (NPFError) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit b(long j, long j2, NintendoAccount nintendoAccount, NPFError nPFError) {
        String str;
        String string;
        String str2;
        if (nintendoAccount != null) {
            BaaSUserLinkEventHandler.c = nintendoAccount;
        }
        String string2 = null;
        if (nintendoAccount != null) {
            try {
                string = NativeBridgeUtil.toJsonFromNintendoAccount(nintendoAccount).toString();
            } catch (JSONException e) {
                e = e;
                str = null;
                e.printStackTrace();
                str2 = str;
                onAuthorizedByNintendoAccountCallback(j, j2, str2, string2);
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
        onAuthorizedByNintendoAccountCallback(j, j2, str2, string2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit c(long j, long j2, NintendoAccount nintendoAccount, NPFError nPFError) {
        String str;
        String string;
        String str2;
        if (nintendoAccount != null) {
            BaaSUserLinkEventHandler.c = nintendoAccount;
        }
        String string2 = null;
        if (nintendoAccount != null) {
            try {
                string = NativeBridgeUtil.toJsonFromNintendoAccount(nintendoAccount).toString();
            } catch (JSONException e) {
                e = e;
                str = null;
                e.printStackTrace();
                str2 = str;
                onAuthorizedByNintendoAccountCallback(j, j2, str2, string2);
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
        onAuthorizedByNintendoAccountCallback(j, j2, str2, string2);
        return Unit.INSTANCE;
    }

    private static native void onAuthorizedByNintendoAccountCallback(long j, long j2, String str, String str2);

    private static native void onOpenMiiStudioCallback(long j, long j2, String str);

    public static void openMiiStudio(long j, long j2, Activity activity) {
        NintendoAccount.openMiiStudio(activity, new NintendoAccountEventHandler(j, j2));
    }

    public static List<String> parseScope(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static void retryPendingAuthorizationByNintendoAccount2(final long j, final long j2, Activity activity) {
        NPFSDK.retryPendingAuthorizationByNintendoAccount2(new Function2() { // from class: com.nintendo.npf.sdk.internal.impl.cpp.NintendoAccountEventHandler$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return NintendoAccountEventHandler.c(j, j2, (NintendoAccount) obj, (NPFError) obj2);
            }
        });
    }

    @Override // com.nintendo.npf.sdk.NPFSDK.NPFErrorCallback
    public void onComplete(NPFError nPFError) {
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
        onOpenMiiStudioCallback(this.f855a, this.b, string);
    }

    public NintendoAccountEventHandler(long j, long j2) {
        this.f855a = j;
        this.b = j2;
    }
}

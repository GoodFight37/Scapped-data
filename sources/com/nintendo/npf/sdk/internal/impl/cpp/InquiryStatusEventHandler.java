package com.nintendo.npf.sdk.internal.impl.cpp;

import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFSDK;
import com.nintendo.npf.sdk.inquiry.InquiryStatus;
import com.nintendo.npf.sdk.internal.impl.NativeBridgeUtil;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public class InquiryStatusEventHandler {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit a(long j, long j2, InquiryStatus inquiryStatus, NPFError nPFError) {
        String str;
        String string;
        String str2;
        String string2 = null;
        if (inquiryStatus != null) {
            try {
                string = NativeBridgeUtil.toJsonFromInquiryStatus(inquiryStatus).toString();
            } catch (JSONException e) {
                e = e;
                str = null;
                e.printStackTrace();
                str2 = str;
                onRetrieveCallback(j, j2, str2, string2);
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
        onRetrieveCallback(j, j2, str2, string2);
        return Unit.INSTANCE;
    }

    public static void check(final long j, final long j2) {
        NPFSDK.getInquiryService().check(new Function2() { // from class: com.nintendo.npf.sdk.internal.impl.cpp.InquiryStatusEventHandler$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return InquiryStatusEventHandler.a(j, j2, (InquiryStatus) obj, (NPFError) obj2);
            }
        });
    }

    private static native void onRetrieveCallback(long j, long j2, String str, String str2);
}

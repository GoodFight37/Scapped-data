package com.nintendo.npf.sdk.internal.impl.cpp;

import android.app.Activity;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFSDK;
import com.nintendo.npf.sdk.internal.impl.NativeBridgeUtil;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public class PromoCodeEventHandler {

    class a implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f859a;
        final /* synthetic */ long b;

        a(long j, long j2) {
            this.f859a = j;
            this.b = j2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(List list, NPFError nPFError) {
            String string;
            String string2;
            try {
                if (nPFError != null) {
                    string2 = NativeBridgeUtil.toJsonFromNPFError(nPFError).toString();
                    string = null;
                } else {
                    string = NativeBridgeUtil.toJsonFromPromoCodeBundle(list).toString();
                    string2 = null;
                }
            } catch (JSONException e) {
                e.printStackTrace();
                string = null;
                string2 = null;
            }
            PromoCodeEventHandler.onCheckRemainExchangePromotionPurchasedCallback(this.f859a, this.b, string, string2);
            return Unit.INSTANCE;
        }
    }

    class b implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f860a;
        final /* synthetic */ long b;

        b(long j, long j2) {
            this.f860a = j;
            this.b = j2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(List list, NPFError nPFError) {
            String string;
            String string2;
            try {
                if (nPFError != null) {
                    string2 = NativeBridgeUtil.toJsonFromNPFError(nPFError).toString();
                    string = null;
                } else {
                    string = NativeBridgeUtil.toJsonFromPromoCodeBundle(list).toString();
                    string2 = null;
                }
            } catch (JSONException e) {
                e.printStackTrace();
                string = null;
                string2 = null;
            }
            PromoCodeEventHandler.onExchangePromotionPurchasedCallback(this.f860a, this.b, string, string2);
            return Unit.INSTANCE;
        }
    }

    public static void checkRemainExchangePromotionPurchased(long j, long j2, Activity activity) {
        NPFSDK.getPromoCodeService().checkPromoCodes(new a(j, j2));
    }

    public static void exchangePromotionPurchased(long j, long j2, Activity activity) {
        NPFSDK.getPromoCodeService().exchangePromoCodes(new b(j, j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void onCheckRemainExchangePromotionPurchasedCallback(long j, long j2, String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void onExchangePromotionPurchasedCallback(long j, long j2, String str, String str2);
}

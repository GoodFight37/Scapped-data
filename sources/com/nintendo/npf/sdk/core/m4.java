package com.nintendo.npf.sdk.core;

import com.adjust.sdk.Constants;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.NPFSDK;
import com.nintendo.npf.sdk.domain.ErrorFactory;
import com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.notification.PushNotificationChannel;
import com.nintendo.npf.sdk.user.BaaSUser;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m4 {
    private static final String e = "m4";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final x4 f523a = x4.a.a();
    private final ErrorFactory b;
    private final DeviceDataFacade c;
    private String d;

    class a implements m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f524a;
        final /* synthetic */ PushNotificationChannel.RegisterDeviceTokenCallback b;

        a(String str, PushNotificationChannel.RegisterDeviceTokenCallback registerDeviceTokenCallback) {
            this.f524a = str;
            this.b = registerDeviceTokenCallback;
        }

        @Override // com.nintendo.npf.sdk.core.m1
        public void onComplete(NPFError nPFError) {
            if (nPFError == null) {
                m4.this.d = this.f524a;
            }
            this.b.onRegisterDeviceTokenComplete(nPFError);
        }
    }

    class b implements v2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PushNotificationChannel.GetDeviceTokenCallback f525a;

        b(PushNotificationChannel.GetDeviceTokenCallback getDeviceTokenCallback) {
            this.f525a = getDeviceTokenCallback;
        }

        @Override // com.nintendo.npf.sdk.core.v2
        public void a(JSONObject jSONObject, NPFError nPFError) {
            if (nPFError != null) {
                this.f525a.onGetDeviceTokenCallbackComplete(null, nPFError);
                return;
            }
            if (jSONObject != null) {
                try {
                    m4.this.d = jSONObject.getString("deviceToken");
                } catch (JSONException e) {
                    this.f525a.onGetDeviceTokenCallbackComplete(null, m4.this.b.create_Mapper_InvalidJson_422(e));
                    return;
                }
            }
            this.f525a.onGetDeviceTokenCallbackComplete(m4.this.d, null);
        }
    }

    public m4(ErrorFactory errorFactory, DeviceDataFacade deviceDataFacade) {
        this.b = errorFactory;
        this.c = deviceDataFacade;
    }

    public void b() {
        this.d = null;
    }

    public void a(String str, PushNotificationChannel.RegisterDeviceTokenCallback registerDeviceTokenCallback) {
        SDKLog.i(e, "registerDeviceToken is called");
        BaaSUser baaSUserC = this.f523a.getNPFSDK().c();
        if (!h0.c(baaSUserC)) {
            registerDeviceTokenCallback.onRegisterDeviceTokenComplete(this.b.create_BaasAccount_NotLoggedIn_401());
            return;
        }
        if (str != null && !str.isEmpty()) {
            if (str.equals(this.d)) {
                registerDeviceTokenCallback.onRegisterDeviceTokenComplete(null);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("language", b2.b(this.c.getLanguage()));
                jSONObject2.put("zoneinfo", a());
                jSONObject2.put("osName", "Android");
                jSONObject2.put("osVersion", this.f523a.getCapabilities().getOSVersion());
                jSONObject2.put("appVersion", this.f523a.getCapabilities().getAppVersion());
                jSONObject.put("deviceAttributes", jSONObject2);
                jSONObject.put("deviceToken", str);
                jSONObject.put("market", NPFSDK.getMarket());
                g0.e().a(baaSUserC, jSONObject, new a(str, registerDeviceTokenCallback));
                return;
            } catch (JSONException e2) {
                registerDeviceTokenCallback.onRegisterDeviceTokenComplete(this.b.create_Mapper_InvalidJson_422(e2));
                return;
            }
        }
        registerDeviceTokenCallback.onRegisterDeviceTokenComplete(new NPFError(NPFError.ErrorType.PROCESS_CANCEL, 0, "argument error"));
    }

    public void a(PushNotificationChannel.GetDeviceTokenCallback getDeviceTokenCallback) {
        SDKLog.i(e, "getDeviceToken is called");
        BaaSUser baaSUserC = this.f523a.getNPFSDK().c();
        if (!h0.c(baaSUserC)) {
            getDeviceTokenCallback.onGetDeviceTokenCallbackComplete(null, this.b.create_BaasAccount_NotLoggedIn_401());
        } else {
            g0.e().a(baaSUserC, new b(getDeviceTokenCallback));
        }
    }

    private static String a() {
        String str;
        int rawOffset = TimeZone.getDefault().getRawOffset() + TimeZone.getDefault().getDSTSavings();
        if (rawOffset >= 0) {
            str = "+";
        } else {
            rawOffset = -rawOffset;
            str = "-";
        }
        int i = rawOffset / Constants.ONE_HOUR;
        Locale locale = Locale.US;
        return str + String.format(locale, "%1$02d", Integer.valueOf(i)) + ":" + String.format(locale, "%1$02d", Integer.valueOf((rawOffset % Constants.ONE_HOUR) / 60000));
    }
}

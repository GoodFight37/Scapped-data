package com.nintendo.npf.sdk.domain.datafacade;

import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u000200H&J\u0010\u00101\u001a\u0002002\u0006\u0010\u0015\u001a\u00020\u0013H&J\u0010\u00102\u001a\u0002002\u0006\u0010\u0016\u001a\u00020\u0003H&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0012\u0010\f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0012\u0010\u000e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0012\u0010\u0010\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u0012\u0010\u0015\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0014R\u0012\u0010\u0016\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0005R\u0012\u0010\u0018\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0005R\u0012\u0010\u001a\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0005R\u0012\u0010\u001c\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0005R\u0012\u0010\u001e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0005R\u0012\u0010 \u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0005R\u001a\u0010\"\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b#\u0010\u0005\"\u0004\b$\u0010\u0007R\u0012\u0010%\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0005R\u0012\u0010'\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0005R\u0012\u0010)\u001a\u00020*X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u00063"}, d2 = {"Lcom/nintendo/npf/sdk/domain/datafacade/DeviceDataFacade;", "", "advertisingId", "", "getAdvertisingId", "()Ljava/lang/String;", "setAdvertisingId", "(Ljava/lang/String;)V", "appName", "getAppName", "appVersion", "getAppVersion", "carrier", "getCarrier", "deviceAnalyticsId", "getDeviceAnalyticsId", "deviceName", "getDeviceName", "isDisabledUsingDeviceAnalyticsId", "", "()Z", "isDisabledUsingGoogleAdvertisingId", "language", "getLanguage", "manufacturer", "getManufacturer", "networkType", "getNetworkType", "osVersion", "getOsVersion", "packageName", "getPackageName", "sdkVersion", "getSdkVersion", "sessionId", "getSessionId", "setSessionId", "signatureSHA1", "getSignatureSHA1", "timeZone", "getTimeZone", "timeZoneOffset", "", "getTimeZoneOffset", "()I", "createDeviceInfo", "Lorg/json/JSONObject;", "generateSessionId", "", "saveIsDisabledUsingGoogleAdvertisingId", "saveLanguage", "NPFSDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface DeviceDataFacade {

    public static final class a {
        public static JSONObject a(DeviceDataFacade deviceDataFacade) throws JSONException {
            String advertisingId;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("locale", deviceDataFacade.getLanguage());
            jSONObject.put("timeZone", deviceDataFacade.getTimeZone());
            jSONObject.put("timeZoneOffset", deviceDataFacade.getTimeZoneOffset());
            jSONObject.put("manufacturer", deviceDataFacade.getManufacturer());
            jSONObject.put("deviceName", deviceDataFacade.getDeviceName());
            jSONObject.put("osType", "Android");
            jSONObject.put("osVersion", deviceDataFacade.getOsVersion());
            jSONObject.put("networkType", deviceDataFacade.getNetworkType());
            jSONObject.put("carrier", deviceDataFacade.getCarrier());
            String sessionId = deviceDataFacade.getSessionId();
            if (sessionId != null && sessionId.length() != 0) {
                jSONObject.put("sessionId", deviceDataFacade.getSessionId());
            }
            if (!deviceDataFacade.isDisabledUsingGoogleAdvertisingId() && (advertisingId = deviceDataFacade.getAdvertisingId()) != null && advertisingId.length() != 0) {
                jSONObject.put("advertisingId", deviceDataFacade.getAdvertisingId());
            }
            if (!deviceDataFacade.isDisabledUsingDeviceAnalyticsId() && deviceDataFacade.getDeviceAnalyticsId().length() > 0) {
                jSONObject.put("deviceAnalyticsId", deviceDataFacade.getDeviceAnalyticsId());
            }
            jSONObject.put("appVersion", deviceDataFacade.getAppVersion());
            jSONObject.put("sdkVersion", deviceDataFacade.getSdkVersion());
            return jSONObject;
        }
    }

    JSONObject createDeviceInfo() throws JSONException;

    void generateSessionId();

    String getAdvertisingId();

    String getAppName();

    String getAppVersion();

    String getCarrier();

    String getDeviceAnalyticsId();

    String getDeviceName();

    String getLanguage();

    String getManufacturer();

    String getNetworkType();

    String getOsVersion();

    String getPackageName();

    String getSdkVersion();

    String getSessionId();

    String getSignatureSHA1();

    String getTimeZone();

    int getTimeZoneOffset();

    boolean isDisabledUsingDeviceAnalyticsId();

    boolean isDisabledUsingGoogleAdvertisingId();

    void saveIsDisabledUsingGoogleAdvertisingId(boolean isDisabledUsingGoogleAdvertisingId);

    void saveLanguage(String language);

    void setAdvertisingId(String str);

    void setSessionId(String str);
}

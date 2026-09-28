package com.nintendo.npf.sdk.internal.model;

import com.nintendo.npf.sdk.core.d1;
import com.nintendo.npf.sdk.core.s0;
import com.nintendo.npf.sdk.core.u0;
import com.nintendo.npf.sdk.core.w1;
import com.nintendo.npf.sdk.core.y1;
import com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class Capabilities {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u0 f882a;
    private final d1 b;
    private final DeviceDataFacade c;
    private final y1 d;
    private final s0 e;

    public Capabilities(u0 u0Var, d1 d1Var, DeviceDataFacade deviceDataFacade, y1 y1Var, s0 s0Var) {
        this.f882a = u0Var;
        this.b = d1Var;
        this.c = deviceDataFacade;
        this.d = y1Var;
        this.e = s0Var;
    }

    public String getAccountApiHost() {
        return this.d.d();
    }

    public String getAccountHost() {
        return this.d.e();
    }

    public String getAppVersion() {
        return this.c.getAppVersion();
    }

    public String getBaasHost() {
        return this.d.f();
    }

    public String getBasicAuthPass() {
        return this.b.c();
    }

    public String getBasicAuthUser() {
        return this.b.e();
    }

    public String getClientId() {
        return this.d.g();
    }

    public JSONObject getDeviceInfo() throws JSONException {
        return this.c.createDeviceInfo();
    }

    public String getDeviceName() {
        return this.c.getDeviceName();
    }

    public String getMarketSandbox() {
        return this.d.b();
    }

    public String getOSVersion() {
        return this.c.getOsVersion();
    }

    public String getPackageName() {
        return this.c.getPackageName();
    }

    public String getPointProgramHost() {
        return this.d.a();
    }

    public int getReadTimeout() {
        return this.f882a.a();
    }

    public int getRequestTimeout() {
        return this.f882a.b();
    }

    public String getSDKVersion() {
        return this.c.getSdkVersion();
    }

    public int getSessionUpdateInterval() {
        return this.d.c();
    }

    public String getSignatureSHA1() {
        return this.c.getSignatureSHA1();
    }

    public String getTimeZoneName() {
        return this.c.getTimeZone();
    }

    public boolean isDebugLog() {
        return this.b.b();
    }

    public Boolean isIABNonConsumable() {
        return Boolean.valueOf(this.f882a.c());
    }

    public Boolean isPrintLog() {
        return Boolean.valueOf(this.b.a());
    }

    public boolean isPurchaseMock() {
        return this.b.d();
    }

    public boolean isSandbox() {
        return this.d.h();
    }

    public boolean isUsingHttp() {
        return this.d.i();
    }

    public void setIABNonConsumable(boolean z) {
        this.f882a.a(z);
    }

    public void setReadTimeout(int i) {
        this.f882a.b(i);
    }

    public void setRequestTimeout(int i) {
        this.f882a.a(i);
    }

    public JSONObject toJson() throws JSONException {
        return this.e.a(this.c, this, getDeviceInfo());
    }

    public void updateHostConfiguration(w1 w1Var) {
        this.d.a(w1Var);
    }
}

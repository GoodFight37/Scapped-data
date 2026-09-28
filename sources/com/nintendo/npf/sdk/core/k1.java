package com.nintendo.npf.sdk.core;

import android.media.MediaDrm;
import android.os.Build;
import android.util.Base64;
import com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class k1 implements DeviceDataFacade {
    public static final b j = new b(null);
    private static final String k = "k1";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n1 f509a;
    private final b5 b;
    private final l1 c;
    private final h1 d;
    private final a1 e;
    private final Function0 f;
    private String g;
    private String h;
    private final Lazy i;

    static final class a extends Lambda implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f510a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Long invoke() {
            return Long.valueOf(System.currentTimeMillis());
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private b() {
        }
    }

    static final class c extends Lambda implements Function0 {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return k1.this.a();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k1(n1 fileDataSource, b5 sharedPreferencesDataSource, l1 deviceInformationDataSource, h1 defaultLanguageFactory, a1 credentialsDataFacade) {
        this(fileDataSource, sharedPreferencesDataSource, deviceInformationDataSource, defaultLanguageFactory, credentialsDataFacade, null, 32, null);
        Intrinsics.checkNotNullParameter(fileDataSource, "fileDataSource");
        Intrinsics.checkNotNullParameter(sharedPreferencesDataSource, "sharedPreferencesDataSource");
        Intrinsics.checkNotNullParameter(deviceInformationDataSource, "deviceInformationDataSource");
        Intrinsics.checkNotNullParameter(defaultLanguageFactory, "defaultLanguageFactory");
        Intrinsics.checkNotNullParameter(credentialsDataFacade, "credentialsDataFacade");
    }

    private final String b() {
        return (String) this.i.getValue();
    }

    @Override // com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade
    public JSONObject createDeviceInfo() {
        return DeviceDataFacade.a.a(this);
    }

    @Override // com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade
    public void generateSessionId() {
        String strC = this.e.c();
        if (strC == null || strC.length() == 0) {
            return;
        }
        setSessionId(this.e.c() + '-' + ((Number) this.f.invoke()).longValue());
    }

    @Override // com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade
    public String getAdvertisingId() {
        return this.h;
    }

    @Override // com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade
    public String getAppName() {
        return this.c.f().a();
    }

    @Override // com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade
    public String getAppVersion() {
        return this.c.f().b();
    }

    @Override // com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade
    public String getCarrier() {
        return this.c.a();
    }

    @Override // com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade
    public String getDeviceAnalyticsId() {
        return isDisabledUsingDeviceAnalyticsId() ? "" : b();
    }

    @Override // com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade
    public String getDeviceName() {
        return this.c.b();
    }

    @Override // com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade
    public String getLanguage() {
        String strD = this.b.d();
        return (strD == null || strD.length() == 0) ? this.d.a() : strD;
    }

    @Override // com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade
    public String getManufacturer() {
        return this.c.c();
    }

    @Override // com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade
    public String getNetworkType() {
        return this.c.d();
    }

    @Override // com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade
    public String getOsVersion() {
        return this.c.e();
    }

    @Override // com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade
    public String getPackageName() {
        return this.c.f().c();
    }

    @Override // com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade
    public String getSdkVersion() {
        return this.c.g();
    }

    @Override // com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade
    public String getSessionId() {
        return this.g;
    }

    @Override // com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade
    public String getSignatureSHA1() {
        return this.c.f().d();
    }

    @Override // com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade
    public String getTimeZone() {
        return this.c.h();
    }

    @Override // com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade
    public int getTimeZoneOffset() {
        return this.c.i();
    }

    @Override // com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade
    public boolean isDisabledUsingDeviceAnalyticsId() {
        return this.f509a.a().j();
    }

    @Override // com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade
    public boolean isDisabledUsingGoogleAdvertisingId() {
        Boolean boolF = this.b.f();
        return boolF != null ? boolF.booleanValue() : this.f509a.a().k();
    }

    @Override // com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade
    public void saveIsDisabledUsingGoogleAdvertisingId(boolean z) {
        this.b.a(Boolean.valueOf(z));
    }

    @Override // com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade
    public void saveLanguage(String language) {
        Intrinsics.checkNotNullParameter(language, "language");
        this.b.d(language);
    }

    @Override // com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade
    public void setAdvertisingId(String str) {
        this.h = str;
    }

    @Override // com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade
    public void setSessionId(String str) {
        this.g = str;
    }

    public k1(n1 fileDataSource, b5 sharedPreferencesDataSource, l1 deviceInformationDataSource, h1 defaultLanguageFactory, a1 credentialsDataFacade, Function0 currentTimeMillis) {
        Intrinsics.checkNotNullParameter(fileDataSource, "fileDataSource");
        Intrinsics.checkNotNullParameter(sharedPreferencesDataSource, "sharedPreferencesDataSource");
        Intrinsics.checkNotNullParameter(deviceInformationDataSource, "deviceInformationDataSource");
        Intrinsics.checkNotNullParameter(defaultLanguageFactory, "defaultLanguageFactory");
        Intrinsics.checkNotNullParameter(credentialsDataFacade, "credentialsDataFacade");
        Intrinsics.checkNotNullParameter(currentTimeMillis, "currentTimeMillis");
        this.f509a = fileDataSource;
        this.b = sharedPreferencesDataSource;
        this.c = deviceInformationDataSource;
        this.d = defaultLanguageFactory;
        this.e = credentialsDataFacade;
        this.f = currentTimeMillis;
        this.i = LazyKt.lazy(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String a() {
        UUID uuidFromString = UUID.fromString("edef8ba9-79d6-4ace-a3c8-27dcd51d21ed");
        if (!MediaDrm.isCryptoSchemeSupported(uuidFromString)) {
            SDKLog.e(k, "Failed getting widevineId: this uuid is not supported");
            return "";
        }
        MediaDrm mediaDrm = new MediaDrm(uuidFromString);
        try {
            byte[] propertyByteArray = mediaDrm.getPropertyByteArray("deviceUniqueId");
            Intrinsics.checkNotNullExpressionValue(propertyByteArray, "wvDrm.getPropertyByteArr…ROPERTY_DEVICE_UNIQUE_ID)");
            String strEncodeToString = Base64.encodeToString(propertyByteArray, 2);
            Intrinsics.checkNotNullExpressionValue(strEncodeToString, "{\n            val wideVi…Base64.NO_WRAP)\n        }");
        } catch (Exception e) {
            SDKLog.e(k, "Failed getting widevineId ", e);
            return "";
        } finally {
            if (Build.VERSION.SDK_INT >= 28) {
                mediaDrm.release();
            } else {
                mediaDrm.release();
            }
        }
    }

    public /* synthetic */ k1(n1 n1Var, b5 b5Var, l1 l1Var, h1 h1Var, a1 a1Var, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(n1Var, b5Var, l1Var, h1Var, a1Var, (i & 32) != 0 ? a.f510a : function0);
    }
}

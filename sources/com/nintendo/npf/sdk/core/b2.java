package com.nintendo.npf.sdk.core;

import com.fasterxml.jackson.core.JsonPointer;
import com.google.common.net.HttpHeaders;
import com.nintendo.npf.sdk.domain.datafacade.DeviceDataFacade;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b2 f415a = new b2();

    private b2() {
    }

    public static final Map a(DeviceDataFacade deviceDataFacade) {
        Intrinsics.checkNotNullParameter(deviceDataFacade, "deviceDataFacade");
        return MapsKt.mapOf(TuplesKt.to(HttpHeaders.USER_AGENT, deviceDataFacade.getPackageName() + JsonPointer.SEPARATOR + deviceDataFacade.getAppVersion() + ' ' + deviceDataFacade.getDeviceName() + JsonPointer.SEPARATOR + deviceDataFacade.getOsVersion() + " NPFSDK/" + deviceDataFacade.getSdkVersion()));
    }

    public static final String b(String language) {
        Intrinsics.checkNotNullParameter(language, "language");
        String str = (String) a(language).get(HttpHeaders.ACCEPT_LANGUAGE);
        return str == null ? "" : str;
    }

    public static final Map c(String str) {
        return str == null ? MapsKt.emptyMap() : MapsKt.mapOf(TuplesKt.to(HttpHeaders.AUTHORIZATION, "Bearer " + str));
    }

    public static final Map d(String contentEncoding) {
        Intrinsics.checkNotNullParameter(contentEncoding, "contentEncoding");
        return MapsKt.mapOf(TuplesKt.to(HttpHeaders.CONTENT_ENCODING, contentEncoding));
    }

    public static final Map a(String language) {
        Intrinsics.checkNotNullParameter(language, "language");
        String str = language + "; q=1";
        if (StringsKt.contains$default((CharSequence) language, (CharSequence) "-", false, 2, (Object) null)) {
            str = str + ", " + ((String) CollectionsKt.first(StringsKt.split$default((CharSequence) language, new char[]{'-'}, false, 0, 6, (Object) null))) + "; q=0.5";
        }
        return MapsKt.mapOf(TuplesKt.to(HttpHeaders.ACCEPT_LANGUAGE, str + ", *; q=0.001"));
    }
}

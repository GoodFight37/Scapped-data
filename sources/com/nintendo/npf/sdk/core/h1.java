package com.nintendo.npf.sdk.core;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Locale f472a;

    public h1(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.f472a = locale;
    }

    public final String a() {
        String language = this.f472a.getLanguage();
        String country = this.f472a.getCountry();
        Intrinsics.checkNotNullExpressionValue(language, "language");
        Intrinsics.checkNotNullExpressionValue(country, "country");
        return a(language, country);
    }

    private final String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str.length() == 0 && str2.length() == 0) {
            return "en-US";
        }
        sb.append(str);
        if (str2.length() > 0) {
            sb.append("-").append(str2);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }
}

package com.adjust.sdk.sig;

import com.adjust.sdk.Constants;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f140a = Charset.forName(Constants.ENCODING);

    static {
        Charset.forName("UTF-16");
        Charset.forName("UTF-16BE");
        Charset.forName("UTF-16LE");
        Charset.forName("US-ASCII");
        Charset.forName("ISO-8859-1");
    }
}

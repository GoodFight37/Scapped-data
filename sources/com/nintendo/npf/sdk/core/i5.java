package com.nintendo.npf.sdk.core;

import com.adjust.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class i5 {
    private Integer d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f486a = "";
    private String b = "";
    private String c = "";
    private final Map e = new LinkedHashMap();

    public final i5 a(Integer num) {
        this.d = num;
        return this;
    }

    public final i5 b(String host) {
        Intrinsics.checkNotNullParameter(host, "host");
        this.b = host;
        return this;
    }

    public final i5 c(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.c = path;
        return this;
    }

    public final i5 d(String scheme) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        this.f486a = scheme;
        return this;
    }

    public final i5 a(Map queryParams) {
        Intrinsics.checkNotNullParameter(queryParams, "queryParams");
        this.e.putAll(queryParams);
        return this;
    }

    public final String a() {
        StringBuilder sb = new StringBuilder(this.c);
        if (!this.e.isEmpty()) {
            sb.append("?");
            Map map = this.e;
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(a((String) entry.getKey()) + '=' + a((String) entry.getValue()));
            }
            sb.append(CollectionsKt.joinToString$default(arrayList, "&", null, null, 0, null, null, 62, null));
        }
        return this.f486a + "://" + this.b + (this.d != null ? ":" + this.d : "") + ((Object) sb);
    }

    private final String a(String str) throws UnsupportedEncodingException {
        String strEncode = URLEncoder.encode(str, Constants.ENCODING);
        Intrinsics.checkNotNullExpressionValue(strEncode, "encode(this, \"UTF-8\")");
        return strEncode;
    }
}

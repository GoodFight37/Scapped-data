package com.google.api.client.extensions.android.http;

import com.google.api.client.extensions.android.AndroidUtils;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.apache.ApacheHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

/* JADX INFO: loaded from: classes2.dex */
public class AndroidHttp {
    public static HttpTransport newCompatibleTransport() {
        return AndroidUtils.isMinimumSdkLevel(9) ? new NetHttpTransport() : new ApacheHttpTransport();
    }

    private AndroidHttp() {
    }
}

package com.nintendo.npf.sdk.internal.web;

import android.content.Context;
import android.content.res.Configuration;
import android.webkit.WebView;
import com.nintendo.npf.sdk.internal.util.SDKLog;

/* JADX INFO: loaded from: classes2.dex */
public class SDKWebView extends WebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f885a = "SDKWebView";

    public SDKWebView(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        setVerticalScrollbarOverlay(true);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setLightTouchEnabled(true);
        getSettings().setDomStorageEnabled(true);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        if (b(context)) {
            getSettings().setLoadWithOverviewMode(true);
            getSettings().setUseWideViewPort(true);
        }
    }

    public static boolean b(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    @Override // android.webkit.WebView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        String str = "javascript:onOrientationScreen(\"" + configuration.orientation + "\");";
        SDKLog.d(f885a, str);
        loadUrl(str);
    }
}

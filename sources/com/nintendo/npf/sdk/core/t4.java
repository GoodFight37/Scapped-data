package com.nintendo.npf.sdk.core;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.api.client.http.HttpStatusCodes;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class t4 extends WebViewClient {
    private static final String f = "t4";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Timer f575a;
    private u4 c;
    private boolean d;
    private boolean b = false;
    private final x4 e = x4.a.a();

    private class a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Activity f576a;

        /* JADX INFO: renamed from: com.nintendo.npf.sdk.core.t4$a$a, reason: collision with other inner class name */
        class RunnableC0036a implements Runnable {
            RunnableC0036a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (t4.this.b) {
                    return;
                }
                NPFError.ErrorType errorType = NPFError.ErrorType.NETWORK_ERROR;
                SDKLog.w(t4.f, "Timeout occurs while getting web content");
                t4.this.e.getSdkWebViewManager().a(new NPFError(errorType, 0, "Timeout occurs while getting web content"));
            }
        }

        a(Activity activity) {
            this.f576a = activity;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f576a.runOnUiThread(new RunnableC0036a());
        }
    }

    public t4(Activity activity, u4 u4Var) {
        this.c = u4Var;
        Timer timer = new Timer();
        this.f575a = timer;
        timer.schedule(new a(activity), 20000L);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        SDKLog.d(f, "onPageFinished : " + str);
        b();
        this.e.getSdkWebViewManager().d();
        this.b = true;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        if (this.b) {
            return;
        }
        NPFError.ErrorType errorType = NPFError.ErrorType.NETWORK_ERROR;
        String str3 = str2 + " | " + i + " | " + str;
        SDKLog.w(f, str3);
        this.e.getSdkWebViewManager().a(new NPFError(errorType, 0, str3));
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        httpAuthHandler.proceed(this.e.getCapabilities().getBasicAuthUser(), this.e.getCapabilities().getBasicAuthPass());
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        onReceivedError(webView, HttpStatusCodes.STATUS_CODE_UNAUTHORIZED, "SSL certification error", sslError.getUrl());
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String str2 = f;
        SDKLog.d(str2, "url: " + str);
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if (scheme == null) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        SDKLog.d(str2, "scheme: " + scheme);
        if (!scheme.equals("npf" + this.e.getCapabilities().getClientId())) {
            if (scheme.indexOf("http") != 0) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.putExtra("com.android.browser.application_id", this.c.getContext().getPackageName());
            this.c.getContext().startActivity(intent);
            return true;
        }
        String host = uri.getHost();
        if (host == null) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        SDKLog.d(str2, "method: " + host);
        host.hashCode();
        switch (host) {
            case "launchBrowser":
                try {
                    Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(new JSONObject(uri.getQueryParameter("params")).getString(ImagesContract.URL)));
                    intent2.putExtra("com.android.browser.application_id", this.c.getContext().getPackageName());
                    if (this.c.getContext().getPackageManager().queryIntentActivities(intent2, 0).size() > 0) {
                        this.c.getContext().startActivity(intent2);
                    } else {
                        SDKLog.d(str2, "Browser is not available");
                    }
                    break;
                } catch (JSONException unused) {
                    break;
                }
                break;
            case "closeWebView":
                this.c.a(true, true);
                break;
            case "authorize":
                if (!this.d) {
                    this.d = true;
                    if (uri.getPath() != null) {
                        uri.getPath().getClass();
                    }
                    this.e.getSdkWebViewManager().a(webView.getUrl());
                    this.c.a(false, true);
                    break;
                }
                break;
        }
        SDKLog.d(f, "shouldOverrideUrlLoading: true");
        return true;
    }

    public void b() {
        Timer timer = this.f575a;
        if (timer != null) {
            timer.cancel();
            this.f575a = null;
        }
    }

    public void a(boolean z) {
        this.d = z;
    }
}

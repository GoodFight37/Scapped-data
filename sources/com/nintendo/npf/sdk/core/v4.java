package com.nintendo.npf.sdk.core;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.mynintendo.PointProgramService;
import com.nintendo.npf.sdk.user.BaaSUser;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
public class v4 extends PointProgramService {
    private static final String n = "v4";
    private u4 d;
    private float e;
    private String f;
    private PointProgramService.EventCallback g;
    private String h;
    private Activity j;
    private String k;
    private Dialog l;
    private boolean i = false;
    private final x4 m = x4.a.a();

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f592a;
        final /* synthetic */ String b;
        final /* synthetic */ Activity c;
        final /* synthetic */ PointProgramService.EventCallback d;

        /* JADX INFO: renamed from: com.nintendo.npf.sdk.core.v4$a$a, reason: collision with other inner class name */
        class C0037a extends TimerTask {

            /* JADX INFO: renamed from: com.nintendo.npf.sdk.core.v4$a$a$a, reason: collision with other inner class name */
            class RunnableC0038a implements Runnable {
                RunnableC0038a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (v4.this.d == null || !v4.this.d.isShowing()) {
                        return;
                    }
                    v4.this.d.a(true);
                }
            }

            C0037a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                a.this.c.runOnUiThread(new RunnableC0038a());
            }
        }

        a(float f, String str, Activity activity, PointProgramService.EventCallback eventCallback) {
            this.f592a = f;
            this.b = str;
            this.c = activity;
            this.d = eventCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            v4.this.e = this.f592a;
            v4.this.f = this.b;
            v4 v4Var = v4.this;
            v4Var.h = v4Var.m.getNPFSDK().d().getAccessToken();
            v4.this.d = new u4(this.c, this.f592a, this.b, v4.this.k);
            v4.this.d.show();
            if (this.d != null) {
                v4.this.f();
            }
            new Timer().schedule(new C0037a(), 100L);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (v4.this.d == null) {
                v4.this.a((NPFError) null);
            } else if (v4.this.i) {
                v4.this.d.a(true, true);
            } else {
                v4.this.d.b();
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (v4.this.i) {
                v4.this.d.a(false, false);
            }
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f597a;
        final /* synthetic */ boolean b;

        class a extends TimerTask {

            /* JADX INFO: renamed from: com.nintendo.npf.sdk.core.v4$d$a$a, reason: collision with other inner class name */
            class RunnableC0039a implements Runnable {
                RunnableC0039a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    v4.this.d.a(d.this.b);
                }
            }

            a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                v4.this.j.runOnUiThread(new RunnableC0039a());
            }
        }

        d(boolean z, boolean z2) {
            this.f597a = z;
            this.b = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f597a) {
                v4.this.d.show();
                v4.this.d.a(this.b);
                return;
            }
            if (v4.this.f != null && v4.this.h != null) {
                v4 v4Var = v4.this;
                v4Var.f = v4.b(v4Var.f, "access_token", v4.this.h);
            }
            v4.this.d = new u4(v4.this.j, v4.this.e, v4.this.f, v4.this.k);
            v4.this.d.show();
            v4.this.f();
            new Timer().schedule(new a(), 100L);
        }
    }

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (v4.this.l == null) {
                RelativeLayout relativeLayout = new RelativeLayout(v4.this.j);
                ProgressBar progressBar = new ProgressBar(v4.this.j, null, android.R.attr.progressBarStyleLarge);
                progressBar.setIndeterminate(true);
                progressBar.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(128, 128);
                layoutParams.addRule(13);
                relativeLayout.addView(progressBar, layoutParams);
                v4.this.l = new Dialog(v4.this.j);
                v4.this.l.setCancelable(false);
                v4.this.l.setCanceledOnTouchOutside(false);
                v4.this.l.requestWindowFeature(1);
                v4.this.l.setContentView(relativeLayout);
                Window window = v4.this.l.getWindow();
                if (window != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                }
            }
            v4.this.l.show();
        }
    }

    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (v4.this.l != null) {
                v4.this.l.dismiss();
                v4.this.l = null;
            }
        }
    }

    @Override // com.nintendo.npf.sdk.mynintendo.PointProgramService
    public void dismiss() {
        this.j.runOnUiThread(new b());
    }

    @Override // com.nintendo.npf.sdk.mynintendo.PointProgramService
    public void hide() {
        this.j.runOnUiThread(new c());
    }

    @Override // com.nintendo.npf.sdk.mynintendo.PointProgramService
    public boolean isShowing() {
        return this.d != null && this.i;
    }

    @Override // com.nintendo.npf.sdk.mynintendo.PointProgramService
    public void resume(final boolean z) {
        SDKLog.d(n, "Members WebView resume!");
        if (this.m.getNPFSDK().c().getNintendoAccount() == null) {
            this.h = null;
            a(z, false);
            return;
        }
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        long j = this.m.getNPFSDK().d().expiresTime;
        long retryAuthLimitTime = PointProgramService.getRetryAuthLimitTime();
        if (j != 0 && j - timeInMillis < retryAuthLimitTime) {
            this.m.getLoginHandler().a(false, new Function2() { // from class: com.nintendo.npf.sdk.core.v4$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return this.f$0.a(z, (BaaSUser) obj, (NPFError) obj2);
                }
            });
        } else {
            this.h = this.m.getNPFSDK().d().getAccessToken();
            a(z, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.j.isFinishing()) {
            return;
        }
        this.j.runOnUiThread(new e());
    }

    public void c() {
        this.i = false;
        this.g.onHide(this);
    }

    public void d() {
        String str = n;
        SDKLog.d(str, "SDKWebViewManager.onLoadingFinished");
        if (this.g != null) {
            a();
        } else {
            SDKLog.d(str, "SDKWebViewManager.onLoadingFinished callback null");
        }
    }

    public void e() {
        this.i = false;
        this.g.onNintendoAccountLogin(this);
    }

    public void b(Activity activity, float f2, String str, String str2, PointProgramService.EventCallback eventCallback) {
        if (this.g != null) {
            NPFError nPFError = new NPFError(NPFError.ErrorType.PROCESS_CANCEL, -1, "WebView can't run multiply");
            SDKLog.w(n, "WebView is running");
            eventCallback.onDismiss(nPFError);
        } else {
            this.j = activity;
            this.g = eventCallback;
            this.k = str2;
            activity.runOnUiThread(new a(f2, str, activity, eventCallback));
        }
    }

    public void a(String str) {
        this.f = str;
    }

    private void a(boolean z, boolean z2) {
        this.j.runOnUiThread(new d(z2, z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit a(boolean z, BaaSUser baaSUser, NPFError nPFError) {
        this.h = this.m.getNPFSDK().d().getAccessToken();
        a(z, true);
        return Unit.INSTANCE;
    }

    public void a(NPFError nPFError) {
        a();
        u4 u4Var = this.d;
        if (u4Var != null) {
            u4Var.c();
        }
        PointProgramService.EventCallback eventCallback = this.g;
        if (eventCallback != null) {
            eventCallback.onDismiss(nPFError);
        }
        this.d = null;
        this.e = 1.0f;
        this.f = null;
        this.g = null;
        this.j = null;
    }

    public void b() {
        this.i = true;
        this.g.onAppeared(this);
    }

    public static String b(String str, String str2, String str3) {
        Uri uri = Uri.parse(str);
        CharSequence queryParameter = uri.getQueryParameter(str2);
        if (queryParameter != null) {
            return str.replace(queryParameter, str3);
        }
        String query = uri.getQuery();
        if (query != null) {
            return str.replace(query, query + "&" + str2 + "=" + str3);
        }
        try {
            return new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), str2 + "=" + str3, uri.getFragment()).toString();
        } catch (URISyntaxException unused) {
            SDKLog.w(n, "The parameter could not be added or replaced in the query string");
            return str;
        }
    }

    private void a() {
        if (this.j.isFinishing()) {
            return;
        }
        this.j.runOnUiThread(new f());
    }
}

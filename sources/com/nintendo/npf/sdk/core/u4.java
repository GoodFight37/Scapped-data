package com.nintendo.npf.sdk.core;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.util.Base64;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.activity.ComponentDialog;
import androidx.activity.OnBackPressedCallback;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.nintendo.npf.sdk.NPFError;
import com.nintendo.npf.sdk.internal.util.SDKLog;
import com.nintendo.npf.sdk.internal.web.SDKWebView;

/* JADX INFO: loaded from: classes2.dex */
public class u4 extends ComponentDialog {
    private static final String s = "u4";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FrameLayout f581a;
    private final LinearLayout b;
    private RelativeLayout c;
    private View d;
    private ImageButton e;
    private ImageView f;
    private SDKWebView g;
    private final t4 h;
    private final String i;
    private final float j;
    private final String k;
    private final boolean l;
    private Size m;
    private Size n;
    private Size o;
    private boolean p;
    private boolean q;
    private final x4 r;

    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            u4.this.q = true;
            u4.this.p = false;
            u4.this.h.a(false);
            u4.this.r.getSdkWebViewManager().b();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    class b extends OnBackPressedCallback {
        b(boolean z) {
            super(z);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            u4.this.a(true, true);
        }
    }

    class c implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f584a;
        final /* synthetic */ boolean b;

        c(boolean z, boolean z2) {
            this.f584a = z;
            this.b = z2;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SDKLog.d(u4.s, "onAnimationEnd!");
            if (this.f584a) {
                u4.this.b();
                return;
            }
            if (this.b) {
                u4.this.r.getSdkWebViewManager().e();
            } else {
                u4.this.r.getSdkWebViewManager().c();
            }
            u4.this.hide();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ((ViewGroup) u4.this.g.getParent()).removeView(u4.this.g);
            u4.this.g.removeAllViews();
            u4.this.g.destroy();
            u4.this.g = null;
            u4.this.dismiss();
        }
    }

    public u4(Activity activity, float f, String str, String str2) {
        super(activity, R.style.NpfSdk_FullScreen_Dialog);
        this.p = false;
        this.q = false;
        this.r = x4.a.a();
        requestWindowFeature(1);
        this.l = (activity.getWindow().getAttributes().flags & 1024) != 0;
        d();
        e();
        this.j = f;
        this.i = str;
        this.k = str2;
        this.m = new Size(0, 0);
        this.h = new t4(activity, this);
        setCancelable(false);
        Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        View view = new View(activity);
        FrameLayout frameLayout = new FrameLayout(activity);
        this.f581a = frameLayout;
        frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.nintendo.npf.sdk.core.u4$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                this.f$0.i();
            }
        });
        LinearLayout linearLayout = new LinearLayout(activity);
        this.b = linearLayout;
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 1;
        frameLayout.addView(linearLayout, layoutParams);
        ViewCompat.setOnApplyWindowInsetsListener(frameLayout, new OnApplyWindowInsetsListener() { // from class: com.nintendo.npf.sdk.core.u4$$ExternalSyntheticLambda1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                return this.f$0.a(view2, windowInsetsCompat);
            }
        });
        setContentView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
    }

    private float a(float f) {
        return f * 44.0f;
    }

    private float a(int i) {
        return i / 320.0f;
    }

    private float b(float f) {
        return f * 0.42666668f;
    }

    private void d() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        WindowCompat.setDecorFitsSystemWindows(window, false);
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            int i2 = i >= 30 ? 3 : 1;
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes.layoutInDisplayCutoutMode != i2) {
                attributes.layoutInDisplayCutoutMode = i2;
                window.setAttributes(attributes);
            }
        }
    }

    private void e() {
        Window window;
        if (this.l && (window = getWindow()) != null) {
            window.addFlags(1024);
            WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(window, window.getDecorView());
            insetsController.setSystemBarsBehavior(2);
            insetsController.hide(WindowInsetsCompat.Type.systemBars());
        }
    }

    private Bitmap f() {
        byte[] bArrDecode = Base64.decode("iVBORw0KGgoAAAANSUhEUgAAAB0AAAAdCAYAAABWk2cPAAAA2ElEQVR42sWXQQqDMBBFIz2AuOgmqyx7QnFdpGQptndybS/0m4QINcQS/KHzYHZxHppkZlQeABcXxsXNxVVVxOeLeY33fAtX7Hm6aEhZE/LseQcxAI08L1I6I49W4bWPsSeFFscYv6DFbywpTGm3hX2RmBf26QNDgZgRDipCiAkhISaEhPiEkBYvhJAQ80JenApZ8R1ljKomBXu41BaOKONBqvg9FTu9YvdUrCKJ1V6xLiPWT0UmB5EZSWwa1Mgzk4VlQh797wl/TX8tdPzUXeVm0cW8ehN+AJ2wl1hYrZCxAAAAAElFTkSuQmCC", 0);
        return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
    }

    private Bitmap g() {
        byte[] bArrDecode = Base64.decode("iVBORw0KGgoAAAANSUhEUgAAAXEAAAA7CAMAAAC67UooAAAC+lBMVEUAAAD///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////86i/ucAAAA/nRSTlMAEkh8qsno9f/x2b6VaS0CInvF/e2hTwVV6YYZAVjW95ITLsTwd/vBHA+5+sOOYEIoIBs1eKfn7EXS+AuD4fxm3e6BFANSzxHTXnKzOql0bjIhsgZM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", 0);
        return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
    }

    private void h() {
        if (this.g == null) {
            SDKWebView sDKWebView = new SDKWebView(getContext());
            this.g = sDKWebView;
            sDKWebView.setWebViewClient(this.h);
            this.g.setBackgroundColor(-1);
            this.b.addView(this.g, new LinearLayout.LayoutParams(-1, -1));
            this.g.loadUrl(this.i, b2.a(this.k));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Size size = new Size(this.f581a.getWidth(), this.f581a.getHeight());
        if (this.m.equals(size)) {
            return;
        }
        this.m = size;
        int width = (int) (size.getWidth() * this.j);
        float fA = a(width);
        float fB = b(fA);
        float fA2 = a(fA);
        c(fA2);
        a(fB, fA2);
        b(fB, fA2);
        h();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams.width = width;
        this.f581a.updateViewLayout(this.b, layoutParams);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            d();
            e();
        }
    }

    private void c(float f) {
        RelativeLayout relativeLayout = this.c;
        if (relativeLayout != null) {
            relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) f));
            return;
        }
        RelativeLayout relativeLayout2 = new RelativeLayout(getContext());
        this.c = relativeLayout2;
        relativeLayout2.setBackgroundColor(Color.rgb(230, 0, 18));
        this.c.setPadding(0, 0, 0, 0);
        this.b.addView(this.c, new LinearLayout.LayoutParams(-1, (int) f));
    }

    private void b(int i) {
        if (this.d == null) {
            View view = new View(getContext());
            this.d = view;
            view.setBackgroundColor(Color.rgb(230, 0, 18));
            this.b.addView(this.d);
        }
        this.d.setLayoutParams(new LinearLayout.LayoutParams(-1, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
        int iDisplayCutout;
        if (this.l) {
            iDisplayCutout = WindowInsetsCompat.Type.displayCutout();
        } else {
            iDisplayCutout = WindowInsetsCompat.Type.displayCutout() | WindowInsetsCompat.Type.systemBars();
        }
        Insets insets = windowInsetsCompat.getInsets(iDisplayCutout);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams.leftMargin = insets.left;
        layoutParams.bottomMargin = insets.bottom;
        layoutParams.rightMargin = insets.right;
        this.f581a.updateViewLayout(this.b, layoutParams);
        b(insets.top);
        return WindowInsetsCompat.CONSUMED;
    }

    public void c() {
        new Handler().post(new d());
    }

    private void b(float f, float f2) {
        if (this.f == null) {
            this.f = new ImageView(getContext());
            Bitmap bitmapG = g();
            this.f.setImageBitmap(bitmapG);
            this.o = new Size(bitmapG.getWidth(), bitmapG.getHeight());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.c.addView(this.f, layoutParams);
        }
        int height = (int) ((f2 - (this.o.getHeight() * f)) / 2.0f);
        this.f.setPadding(0, height, 0, height);
    }

    private void a(float f, float f2) {
        if (this.e == null) {
            Bitmap bitmapF = f();
            ImageButton imageButton = new ImageButton(getContext());
            this.e = imageButton;
            int i = (int) f2;
            imageButton.setLayoutParams(new RelativeLayout.LayoutParams(i, i));
            this.e.setImageBitmap(bitmapF);
            this.n = new Size(bitmapF.getWidth(), bitmapF.getHeight());
            this.e.setBackgroundColor(Color.argb(0, 0, 0, 0));
            this.e.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.e.setOnClickListener(new View.OnClickListener() { // from class: com.nintendo.npf.sdk.core.u4$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.a(view);
                }
            });
            this.c.addView(this.e);
        }
        float width = this.n.getWidth() * f;
        float height = this.n.getHeight() * f;
        float f3 = (f2 - width) / 2.0f;
        float f4 = (f2 - height) / 2.0f;
        int i2 = (int) f2;
        this.e.setLayoutParams(new RelativeLayout.LayoutParams(i2, i2));
        int i3 = (int) f3;
        int i4 = (int) f4;
        this.e.setPadding(i3, i4, i3, i4);
    }

    public void b() {
        this.h.b();
        this.r.getSdkWebViewManager().a((NPFError) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a(true, true);
    }

    public void a(boolean z) {
        this.b.setVisibility(0);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(new TranslateAnimation(this.b.getWidth(), 0.0f, 0.0f, 0.0f));
        animationSet.setAnimationListener(new a());
        if (z) {
            animationSet.setDuration(400L);
        } else {
            animationSet.setDuration(0L);
        }
        this.b.startAnimation(animationSet);
        getOnBackPressedDispatcher().addCallback(this, new b(true));
    }

    public void a(boolean z, boolean z2) {
        SDKLog.d(s, "hideWebView : " + z + " : " + z2);
        if (this.p) {
            return;
        }
        this.p = true;
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(new TranslateAnimation(0.0f, this.b.getWidth(), 0.0f, 0.0f));
        animationSet.setAnimationListener(new c(z, z2));
        if (z2 && this.q) {
            animationSet.setDuration(400L);
        } else {
            animationSet.setDuration(0L);
        }
        this.b.startAnimation(animationSet);
    }
}

package com.unity3d.player;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.unity3d.player.a.C0090x;
import com.unity3d.player.a.C0091y;
import kotlin.time.DurationKt;

/* JADX INFO: renamed from: com.unity3d.player.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class DialogC0132v extends Dialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1123a;
    public final UnityPlayerForActivityOrService b;
    public com.unity3d.player.a.E c;
    public A d;
    public C0091y e;

    public DialogC0132v(Context context, UnityPlayerForActivityOrService unityPlayerForActivityOrService) {
        super(context);
        this.c = null;
        this.d = null;
        this.e = null;
        this.f1123a = context;
        this.b = unityPlayerForActivityOrService;
    }

    public final void a(A a2, boolean z, boolean z2) {
        this.d = a2;
        Window window = getWindow();
        window.requestFeature(1);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        attributes.x = 0;
        attributes.y = 0;
        window.setAttributes(attributes);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.c = createSoftInputView(this.d.c);
        window.setLayout(-1, -2);
        window.clearFlags(2);
        window.clearFlags(134217728);
        window.clearFlags(67108864);
        if (!z2) {
            window.addFlags(32);
            window.addFlags(262144);
        }
        a(z);
        getWindow().setSoftInputMode(5);
        this.e = C0117n.a(this, DurationKt.NANOS_IN_MILLIS, new RunnableC0131u(this));
    }

    public final Rect a() {
        Rect rect = new Rect();
        FrameLayout frameLayout = this.b.getFrameLayout();
        frameLayout.getWindowVisibleDisplayFrame(rect);
        int[] iArr = new int[2];
        frameLayout.getLocationOnScreen(iArr);
        Point point = new Point(rect.left - iArr[0], rect.height() - this.c.getHeight());
        Point point2 = new Point();
        getWindow().getWindowManager().getDefaultDisplay().getSize(point2);
        int height = frameLayout.getHeight();
        int i = height - point2.y;
        int i2 = height - point.y;
        if (i2 != this.c.getHeight() + i) {
            this.b.reportSoftInputIsVisible(true);
        } else {
            this.b.reportSoftInputIsVisible(false);
        }
        return new Rect(point.x, point.y, this.c.getWidth(), i2);
    }

    public final void a(boolean z) {
        com.unity3d.player.a.E e = this.c;
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) e.b.getLayoutParams();
            layoutParams.height = 1;
            e.b.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) e.f1054a.getLayoutParams();
            layoutParams2.height = 1;
            e.f1054a.setLayoutParams(layoutParams2);
            Rect rect = e.e;
            e.setPadding(rect.left, rect.top, rect.right, rect.bottom);
            e.b.setBackgroundColor(0);
            e.setBackgroundColor(0);
        } else {
            e.setVisibility(0);
            Rect rect2 = e.d;
            e.setPadding(rect2.left, rect2.top, rect2.right, rect2.bottom);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) e.b.getLayoutParams();
            layoutParams3.height = -2;
            e.b.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) e.f1054a.getLayoutParams();
            layoutParams4.height = -2;
            e.f1054a.setLayoutParams(layoutParams4);
        }
        e.invalidate();
        e.requestLayout();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        A a2 = this.d;
        a2.a(a2.a(), false);
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        C0090x c0090x;
        Runnable runnable;
        C0091y c0091y = this.e;
        if (c0091y == null || (c0090x = c0091y.f1091a) == null || (runnable = c0090x.f1090a) == null) {
            return;
        }
        runnable.run();
    }

    @Override // android.app.Dialog
    public final void onStop() {
        C0091y c0091y = this.e;
        if (c0091y != null) {
            c0091y.unregisterOnBackPressedCallback();
            this.e = null;
        }
        super.onStop();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.d.e || !(motionEvent.getAction() == 4 || this.d.d)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public com.unity3d.player.a.E createSoftInputView(EditText editText) {
        com.unity3d.player.a.E e = new com.unity3d.player.a.E(this.f1123a, editText);
        e.f1054a.setOnClickListener(this);
        setContentView(e);
        return e;
    }
}

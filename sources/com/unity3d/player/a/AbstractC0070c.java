package com.unity3d.player.a;

import android.R;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

/* JADX INFO: renamed from: com.unity3d.player.a.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0070c {
    public static ProgressBar b;
    public static View c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f1073a = {R.attr.progressBarStyleLarge, R.attr.progressBarStyleLargeInverse, R.attr.progressBarStyleSmall, R.attr.progressBarStyleSmallInverse};
    public static int d = -1;

    public static void a(Activity activity, FrameLayout frameLayout, int i) {
        if (i >= 0) {
            int[] iArr = f1073a;
            if (i >= 4) {
                return;
            }
            if (frameLayout == null) {
                throw new IllegalArgumentException("ViewGroup cannot be null.");
            }
            if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            ProgressBar progressBar = b;
            if (progressBar != null) {
                if (d == i) {
                    return;
                }
                if (progressBar != null) {
                    if (c != null) {
                        ViewGroup viewGroup = (ViewGroup) progressBar.getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(b);
                            viewGroup.removeView(c);
                        }
                        b = null;
                        c = null;
                    }
                    d = -1;
                }
            }
            d = i;
            ProgressBar progressBar2 = new ProgressBar(activity, null, iArr[i]);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            progressBar2.setLayoutParams(layoutParams);
            progressBar2.setBackground(new ColorDrawable(0));
            progressBar2.setIndeterminate(true);
            b = progressBar2;
            View view = new View(activity);
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            view.setBackgroundColor(0);
            view.setFocusableInTouchMode(true);
            view.requestFocus();
            view.setOnTouchListener(new ViewOnTouchListenerC0068a());
            view.setOnKeyListener(new ViewOnKeyListenerC0069b());
            c = view;
            frameLayout.addView(view);
            frameLayout.addView(b);
        }
    }
}

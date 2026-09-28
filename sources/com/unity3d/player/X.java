package com.unity3d.player;

import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.unity3d.player.a.AbstractC0070c;
import com.unity3d.player.a.AbstractC0086t;

/* JADX INFO: loaded from: classes2.dex */
public final class X implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        try {
            ProgressBar progressBar = AbstractC0070c.b;
            if (progressBar != null) {
                if (AbstractC0070c.c != null) {
                    ViewGroup viewGroup = (ViewGroup) progressBar.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(AbstractC0070c.b);
                        viewGroup.removeView(AbstractC0070c.c);
                    }
                    AbstractC0070c.b = null;
                    AbstractC0070c.c = null;
                }
                AbstractC0070c.d = -1;
            }
        } catch (Exception e) {
            AbstractC0086t.Log(6, "Exception when hiding Activity Indicator " + e);
        }
    }
}

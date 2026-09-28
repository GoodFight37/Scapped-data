package com.unity3d.player;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.EditText;
import com.unity3d.player.a.C0090x;
import com.unity3d.player.a.C0091y;

/* JADX INFO: renamed from: com.unity3d.player.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0136z extends EditText {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC0129t f1128a;
    public final /* synthetic */ A b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0136z(A a2, Context context, AbstractC0129t abstractC0129t) {
        super(context);
        this.b = a2;
        this.f1128a = abstractC0129t;
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        C0091y c0091y;
        C0090x c0090x;
        Runnable runnable;
        if (i == 4) {
            if (keyEvent.getAction() == 1 && (c0091y = this.b.h.e) != null && (c0090x = c0091y.f1091a) != null && (runnable = c0090x.f1090a) != null) {
                runnable.run();
            }
            return true;
        }
        if (i == 84) {
            return true;
        }
        if (i == 66 && keyEvent.getAction() == 0 && (getInputType() & 131072) == 0) {
            AbstractC0129t abstractC0129t = this.f1128a;
            abstractC0129t.a(abstractC0129t.a(), false);
            return true;
        }
        if (i == 111 && keyEvent.getAction() == 0) {
            AbstractC0129t abstractC0129t2 = this.f1128a;
            abstractC0129t2.a(abstractC0129t2.a(), true);
            return true;
        }
        return super.onKeyPreIme(i, keyEvent);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            requestFocus();
            this.f1128a.e();
        }
    }

    @Override // android.widget.TextView
    public void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        this.f1128a.b.reportSoftInputSelection(i, i2 - i);
    }
}

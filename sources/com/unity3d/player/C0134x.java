package com.unity3d.player;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.EditText;

/* JADX INFO: renamed from: com.unity3d.player.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0134x extends EditText {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC0129t f1125a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0134x(Context context, AbstractC0129t abstractC0129t) {
        super(context);
        this.f1125a = abstractC0129t;
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (keyEvent.getAction() == 1) {
                AbstractC0129t abstractC0129t = this.f1125a;
                abstractC0129t.a(abstractC0129t.a(), false);
            }
            return true;
        }
        if (i == 84) {
            return true;
        }
        if (i == 66 && keyEvent.getAction() == 0 && (getInputType() & 131072) == 0) {
            AbstractC0129t abstractC0129t2 = this.f1125a;
            abstractC0129t2.a(abstractC0129t2.a(), false);
            return true;
        }
        return super.onKeyPreIme(i, keyEvent);
    }

    @Override // android.widget.TextView
    public final void onEditorAction(int i) {
        if (i == 6) {
            AbstractC0129t abstractC0129t = this.f1125a;
            abstractC0129t.a(abstractC0129t.a(), false);
        }
    }

    @Override // android.widget.TextView
    public void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        this.f1125a.b.reportSoftInputSelection(i, i2 - i);
    }
}

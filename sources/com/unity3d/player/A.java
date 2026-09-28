package com.unity3d.player;

import android.content.Context;
import android.widget.EditText;

/* JADX INFO: loaded from: classes2.dex */
public final class A extends AbstractC0129t {
    public DialogC0132v h;

    @Override // com.unity3d.player.AbstractC0129t
    public final void a(boolean z) {
        this.d = z;
        this.h.a(z);
    }

    public A(Context context, UnityPlayerForActivityOrService unityPlayerForActivityOrService) {
        super(context, unityPlayerForActivityOrService);
    }

    @Override // com.unity3d.player.AbstractC0129t
    public final void a(String str, int i, boolean z, boolean z2, boolean z3, boolean z4, String str2, int i2, boolean z5, boolean z6) {
        DialogC0132v dialogC0132v = new DialogC0132v(this.f1121a, this.b);
        this.h = dialogC0132v;
        dialogC0132v.a(this, z5, z6);
        this.h.setOnDismissListener(new com.unity3d.player.a.G(this));
        this.e = z6;
        setupTextInput(str, i, z, z2, z3, z4, str2, i2);
        a(z5);
        this.b.getFrameLayout().getViewTreeObserver().addOnGlobalLayoutListener(new com.unity3d.player.a.H(this));
        this.c.requestFocus();
        this.h.setOnCancelListener(new com.unity3d.player.a.I(this));
    }

    public void reportSoftInputArea() {
        if (this.h.isShowing()) {
            this.b.reportSoftInputArea(this.h.a());
        }
    }

    @Override // com.unity3d.player.AbstractC0129t
    public final void d() {
        this.h.show();
    }

    @Override // com.unity3d.player.AbstractC0129t
    public final void b() {
        this.h.dismiss();
    }

    @Override // com.unity3d.player.AbstractC0129t
    public EditText createEditText(AbstractC0129t abstractC0129t) {
        return new C0136z(this, this.f1121a, abstractC0129t);
    }
}

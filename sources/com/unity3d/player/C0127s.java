package com.unity3d.player;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: renamed from: com.unity3d.player.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0127s implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC0129t f1119a;

    public C0127s(AbstractC0129t abstractC0129t) {
        this.f1119a = abstractC0129t;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6) {
            AbstractC0129t abstractC0129t = this.f1119a;
            abstractC0129t.a(abstractC0129t.a(), false);
        }
        return false;
    }
}

package com.unity3d.player;

import android.widget.EditText;

/* JADX INFO: renamed from: com.unity3d.player.p0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class RunnableC0122p0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1114a;
    public final /* synthetic */ UnityPlayerForActivityOrService b;

    public RunnableC0122p0(UnityPlayerForActivityOrService unityPlayerForActivityOrService, String str) {
        this.b = unityPlayerForActivityOrService;
        this.f1114a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        EditText editText;
        AbstractC0129t abstractC0129t = this.b.mSoftInput;
        if (abstractC0129t == null || (str = this.f1114a) == null || (editText = abstractC0129t.c) == null) {
            return;
        }
        editText.setText(str);
        abstractC0129t.c.setSelection(str.length());
    }
}

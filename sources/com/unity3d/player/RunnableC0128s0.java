package com.unity3d.player;

import android.widget.EditText;

/* JADX INFO: renamed from: com.unity3d.player.s0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class RunnableC0128s0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1120a;
    public final /* synthetic */ int b;
    public final /* synthetic */ UnityPlayerForActivityOrService c;

    public RunnableC0128s0(UnityPlayerForActivityOrService unityPlayerForActivityOrService, int i, int i2) {
        this.c = unityPlayerForActivityOrService;
        this.f1120a = i;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        AbstractC0129t abstractC0129t = this.c.mSoftInput;
        if (abstractC0129t != null) {
            int i2 = this.f1120a;
            int i3 = this.b;
            EditText editText = abstractC0129t.c;
            if (editText == null || editText.getText().length() < (i = i3 + i2)) {
                return;
            }
            abstractC0129t.c.setSelection(i2, i);
        }
    }
}

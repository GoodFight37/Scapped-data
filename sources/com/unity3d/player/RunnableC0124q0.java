package com.unity3d.player;

import android.text.InputFilter;
import android.widget.EditText;

/* JADX INFO: renamed from: com.unity3d.player.q0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class RunnableC0124q0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1116a;
    public final /* synthetic */ UnityPlayerForActivityOrService b;

    public RunnableC0124q0(UnityPlayerForActivityOrService unityPlayerForActivityOrService, int i) {
        this.b = unityPlayerForActivityOrService;
        this.f1116a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AbstractC0129t abstractC0129t = this.b.mSoftInput;
        if (abstractC0129t != null) {
            int i = this.f1116a;
            EditText editText = abstractC0129t.c;
            if (editText != null) {
                if (i > 0) {
                    editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
                } else {
                    editText.setFilters(new InputFilter[0]);
                }
            }
        }
    }
}

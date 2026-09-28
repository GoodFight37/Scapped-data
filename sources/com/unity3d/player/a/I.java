package com.unity3d.player.a;

import android.content.DialogInterface;
import com.unity3d.player.I0;

/* JADX INFO: loaded from: classes2.dex */
public final class I implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.unity3d.player.A f1057a;

    public I(com.unity3d.player.A a2) {
        this.f1057a = a2;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        I0 i0 = this.f1057a.f;
        if (i0 != null) {
            i0.a();
        }
    }
}

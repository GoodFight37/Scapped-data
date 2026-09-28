package com.unity3d.player.a;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes2.dex */
public final class G implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.unity3d.player.A f1055a;

    public G(com.unity3d.player.A a2) {
        this.f1055a = a2;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.f1055a.invokeOnClose();
    }
}

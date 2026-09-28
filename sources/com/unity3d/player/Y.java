package com.unity3d.player;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes2.dex */
public final class Y implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityPlayer f1048a;

    public Y(UnityPlayer unityPlayer) {
        this.f1048a = unityPlayer;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f1048a.finish();
    }
}

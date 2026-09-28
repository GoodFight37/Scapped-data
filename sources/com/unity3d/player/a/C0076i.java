package com.unity3d.player.a;

import android.content.Context;
import android.media.AudioManager;

/* JADX INFO: renamed from: com.unity3d.player.a.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0076i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1077a;
    public final AudioManager b;
    public C0074g c;

    public C0076i(Context context) {
        this.f1077a = context;
        this.b = (AudioManager) context.getSystemService("audio");
    }
}

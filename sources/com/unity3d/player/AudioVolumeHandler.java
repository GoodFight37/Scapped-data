package com.unity3d.player;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import com.unity3d.player.a.C0074g;
import com.unity3d.player.a.C0076i;
import com.unity3d.player.a.InterfaceC0075h;

/* JADX INFO: loaded from: classes2.dex */
public class AudioVolumeHandler implements InterfaceC0075h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0076i f1011a;

    @Override // com.unity3d.player.a.InterfaceC0075h
    public final native void onAudioVolumeChanged(int i);

    public AudioVolumeHandler(Context context) {
        C0076i c0076i = new C0076i(context);
        this.f1011a = c0076i;
        c0076i.c = new C0074g(new Handler(Looper.getMainLooper()), c0076i.b, this);
        context.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, c0076i.c);
    }
}

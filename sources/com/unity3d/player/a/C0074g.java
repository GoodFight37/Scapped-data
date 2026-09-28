package com.unity3d.player.a;

import android.database.ContentObserver;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import com.unity3d.player.AudioVolumeHandler;

/* JADX INFO: renamed from: com.unity3d.player.a.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0074g extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AudioVolumeHandler f1076a;
    public final AudioManager b;
    public final int c;
    public int d;

    public C0074g(Handler handler, AudioManager audioManager, AudioVolumeHandler audioVolumeHandler) {
        super(handler);
        this.b = audioManager;
        this.c = 3;
        this.f1076a = audioVolumeHandler;
        this.d = audioManager.getStreamVolume(3);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z, Uri uri) {
        int streamVolume;
        AudioManager audioManager = this.b;
        if (audioManager == null || this.f1076a == null || (streamVolume = audioManager.getStreamVolume(this.c)) == this.d) {
            return;
        }
        this.d = streamVolume;
        this.f1076a.onAudioVolumeChanged(streamVolume);
    }
}

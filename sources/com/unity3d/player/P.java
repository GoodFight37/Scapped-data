package com.unity3d.player;

import android.content.Context;
import android.widget.FrameLayout;
import com.unity.androidnotifications.UnityNotificationManager;
import com.unity3d.player.a.C0073f;

/* JADX INFO: loaded from: classes2.dex */
public final class P extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0073f f1033a;
    public final UnityPlayerForActivityOrService b;
    public final com.unity3d.player.a.D c;

    public P(UnityPlayerForActivityOrService unityPlayerForActivityOrService) {
        super(unityPlayerForActivityOrService.getContext());
        Context context = unityPlayerForActivityOrService.getContext();
        this.c = new com.unity3d.player.a.D(context);
        this.b = unityPlayerForActivityOrService;
        C0073f c0073f = new C0073f(unityPlayerForActivityOrService);
        this.f1033a = c0073f;
        c0073f.setId(context.getResources().getIdentifier("unitySurfaceView", UnityNotificationManager.KEY_ID, context.getPackageName()));
        unityPlayerForActivityOrService.applySurfaceViewSettings(c0073f);
        c0073f.getHolder().addCallback(new O(this));
        c0073f.setFocusable(true);
        c0073f.setFocusableInTouchMode(true);
        c0073f.setContentDescription(context.getResources().getString(context.getResources().getIdentifier("game_view_content_description", "string", context.getPackageName())));
        addView(c0073f, new FrameLayout.LayoutParams(-1, -1, 17));
    }
}

package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import com.unity.androidnotifications.UnityNotificationManager;
import com.unity3d.player.a.AbstractC0086t;
import com.unity3d.player.a.EnumC0084q;

/* JADX INFO: loaded from: classes2.dex */
public class UnityPlayerForGameActivity extends UnityPlayer {
    Thread m_MainThread;
    private com.unity3d.player.a.D m_PersistentUnitySurface;
    SurfaceView m_SurfaceView;

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeOrientationChanged(int i, int i2);

    private final native void nativeUnityPlayerForGameActivityInitialized(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeUnityPlayerSetRunning(boolean z);

    @Override // com.unity3d.player.UnityPlayer
    protected void cleanupResourcesForDestroy() {
    }

    @Override // com.unity3d.player.UnityPlayer
    boolean handleFocus(boolean z) {
        return true;
    }

    public UnityPlayerForGameActivity(Activity activity, FrameLayout frameLayout, SurfaceView surfaceView) {
        this(activity, frameLayout, surfaceView, null);
    }

    public UnityPlayerForGameActivity(Activity activity, FrameLayout frameLayout, SurfaceView surfaceView, IUnityPlayerLifecycleEvents iUnityPlayerLifecycleEvents) {
        super(activity, EnumC0084q.c, iUnityPlayerLifecycleEvents);
        this.m_SurfaceView = surfaceView;
        initialize(frameLayout);
        this.m_MainThread = null;
        nativeUnityPlayerForGameActivityInitialized(!com.unity3d.player.a.Q.e ? 1 : 0);
        applySurfaceViewSettings(this.m_SurfaceView);
        this.m_PersistentUnitySurface = new com.unity3d.player.a.D(activity);
        this.m_SurfaceView.getHolder().addCallback(new K0(this));
    }

    public static int getUnityViewIdentifier(Context context) {
        return context.getResources().getIdentifier("unitySurfaceView", UnityNotificationManager.KEY_ID, context.getPackageName());
    }

    protected void setMainThread() {
        if (this.m_MainThread != null) {
            throw new RuntimeException("Main Thread was already set.");
        }
        this.m_MainThread = Thread.currentThread();
    }

    @Override // com.unity3d.player.UnityPlayer
    public boolean runningOnMainThread() {
        if (this.m_MainThread != null) {
            return Thread.currentThread() == this.m_MainThread;
        }
        throw new RuntimeException("Main Thread was not yet set.");
    }

    @Override // com.unity3d.player.UnityPlayer
    public void setMainSurfaceViewAspectRatio(float f) {
        AbstractC0086t.Log(6, "setMainSurfaceViewAspectRatio is not supported for GameActivity");
    }

    @Override // com.unity3d.player.UnityPlayer
    void onOrientationChanged(int i, int i2) {
        invokeOnMainThread((Runnable) new L0(this, i, i2));
    }

    @Override // com.unity3d.player.UnityPlayer
    void pauseUnity() {
        super.pauseUnity();
        invokeOnMainThread((Runnable) new M0(this));
    }

    @Override // com.unity3d.player.UnityPlayer
    void resumeUnity() {
        super.resumeUnity();
        invokeOnMainThread((Runnable) new N0(this));
    }

    @Override // com.unity3d.player.UnityPlayer
    public SurfaceView getView() {
        return getSurfaceView();
    }

    @Override // com.unity3d.player.UnityPlayer
    public SurfaceView getSurfaceView() {
        return this.m_SurfaceView;
    }

    @Override // com.unity3d.player.UnityPlayer
    void hidePreservedContent() {
        runOnUiThread(new O0(this));
    }
}

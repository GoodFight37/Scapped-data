package net.gree.unitywebview;

import android.content.ContextWrapper;
import android.view.SurfaceView;
import android.view.View;
import com.unity3d.player.UnityPlayer;

/* JADX INFO: loaded from: classes2.dex */
public class CUnityPlayer extends UnityPlayer {
    public CUnityPlayer(ContextWrapper contextWrapper) {
        super(contextWrapper);
    }

    public void addView(View view) {
        if (view instanceof SurfaceView) {
            ((SurfaceView) view).setZOrderOnTop(false);
        }
        super.addView(view);
    }
}

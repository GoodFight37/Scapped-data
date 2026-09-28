package net.gree.unitywebview;

import android.os.Bundle;
import android.view.View;
import com.unity3d.player.UnityPlayerActivity;

/* JADX INFO: loaded from: classes2.dex */
public class CUnityPlayerActivity extends UnityPlayerActivity {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.view.View, com.unity3d.player.UnityPlayer] */
    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().setFormat(2);
        this.mUnityPlayer = new CUnityPlayer(this);
        setContentView((View) this.mUnityPlayer);
        this.mUnityPlayer.requestFocus();
    }
}

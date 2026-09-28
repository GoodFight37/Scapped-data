package com.unity3d.player;

import com.unity3d.player.a.AbstractC0086t;

/* JADX INFO: renamed from: com.unity3d.player.j0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0110j0 implements IPermissionRequestCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1107a;
    public final /* synthetic */ UnityPlayer b;

    public C0110j0(long j, UnityPlayer unityPlayer) {
        this.b = unityPlayer;
        this.f1107a = j;
    }

    @Override // com.unity3d.player.IPermissionRequestCallbacks
    public final void onPermissionResult(String[] strArr, int[] iArr) {
        int length = iArr.length;
        boolean z = false;
        if (length != 0) {
            if (length == 1) {
                if (iArr[0] == 1) {
                    z = true;
                }
            } else {
                AbstractC0086t.Log(6, "Only a single permission request is supported");
                return;
            }
        }
        if (this.f1107a == 0) {
            return;
        }
        this.b.invokeOnMainThread((UnityPlayer.a) new C0108i0(this, z));
    }
}

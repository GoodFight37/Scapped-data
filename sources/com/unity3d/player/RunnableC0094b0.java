package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.b0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class RunnableC0094b0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PermissionRequest f1093a;
    public final /* synthetic */ String[] b;
    public final /* synthetic */ int[] c;

    public RunnableC0094b0(PermissionRequest permissionRequest, String[] strArr, int[] iArr) {
        this.f1093a = permissionRequest;
        this.b = strArr;
        this.c = iArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1093a.permissionResponse(this.b, this.c);
    }
}

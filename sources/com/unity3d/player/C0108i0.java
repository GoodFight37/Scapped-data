package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.i0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0108i0 extends UnityPlayer.a {
    public final /* synthetic */ boolean b;
    public final /* synthetic */ C0110j0 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0108i0(C0110j0 c0110j0, boolean z) {
        super();
        this.c = c0110j0;
        this.b = z;
    }

    @Override // com.unity3d.player.UnityPlayer.a
    public final void a() {
        UnityPlayer.permissionResponseToNative(this.c.f1107a, this.b);
    }
}

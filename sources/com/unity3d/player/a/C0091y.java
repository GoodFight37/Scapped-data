package com.unity3d.player.a;

/* JADX INFO: renamed from: com.unity3d.player.a.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0091y {
    public final Runnable b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0090x f1091a = null;
    public boolean c = true;

    public C0091y(Runnable runnable) {
        this.b = runnable;
    }

    public void unregisterOnBackPressedCallback() {
        this.f1091a = null;
    }

    public void registerOnBackPressedCallback() {
        if (this.f1091a != null) {
            return;
        }
        this.f1091a = new C0090x(this.b);
    }
}

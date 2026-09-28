package com.adjust.sdk.sig;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q1 f164a;
    public boolean b = true;

    public y(q1 q1Var) {
        this.f164a = q1Var;
    }

    public void a() {
        this.b = false;
    }

    public void b() {
    }

    public void c() {
    }

    public final void a(char c) {
        q1 q1Var = this.f164a;
        q1Var.a(q1Var.b, 1);
        char[] cArr = q1Var.f154a;
        int i = q1Var.b;
        q1Var.b = i + 1;
        cArr[i] = c;
    }
}

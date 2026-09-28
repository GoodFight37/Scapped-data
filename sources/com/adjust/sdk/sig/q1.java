package com.adjust.sdk.sig;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-50f36c2f6dbb1f1f4069f6584f1798fc01925cf859372d68181d0fca7f3fe715 */
/* JADX INFO: loaded from: classes.dex */
public final class q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f154a;
    public int b;

    public q1() {
        char[] cArr;
        j jVar = j.c;
        synchronized (jVar) {
            e eVar = jVar.f138a;
            cArr = null;
            char[] cArr2 = (char[]) (eVar.isEmpty() ? null : eVar.removeLast());
            if (cArr2 != null) {
                jVar.b -= cArr2.length;
                cArr = cArr2;
            }
        }
        this.f154a = cArr == null ? new char[128] : cArr;
    }

    public final void a(String str) {
        int length = str.length();
        if (length == 0) {
            return;
        }
        a(this.b, length);
        str.getChars(0, str.length(), this.f154a, this.b);
        this.b += length;
    }

    public final String toString() {
        return new String(this.f154a, 0, this.b);
    }

    public final void a() {
        j jVar = j.c;
        char[] cArr = this.f154a;
        synchronized (jVar) {
            int i = jVar.b;
            if (cArr.length + i < g.f130a) {
                jVar.b = i + cArr.length;
                jVar.f138a.addLast(cArr);
            }
        }
    }

    public final int a(int i, int i2) {
        int i3 = i2 + i;
        char[] cArr = this.f154a;
        if (cArr.length <= i3) {
            int i4 = i * 2;
            if (i3 < i4) {
                i3 = i4;
            }
            this.f154a = Arrays.copyOf(cArr, i3);
        }
        return i;
    }
}

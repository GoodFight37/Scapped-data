package com.unity3d.player;

import java.lang.reflect.AccessibleObject;

/* JADX INFO: renamed from: com.unity3d.player.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0121p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f1113a;
    public final String b;
    public final String c;
    public final int d;
    public volatile AccessibleObject e;

    public C0121p(Class cls, String str, String str2) {
        this.f1113a = cls;
        this.b = str;
        this.c = str2;
        this.d = str2.hashCode() + ((str.hashCode() + ((cls.hashCode() + 527) * 31)) * 31);
    }

    public final int hashCode() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0121p) {
            C0121p c0121p = (C0121p) obj;
            if (this.d == c0121p.d && this.c.equals(c0121p.c) && this.b.equals(c0121p.b) && this.f1113a.equals(c0121p.f1113a)) {
                return true;
            }
        }
        return false;
    }
}

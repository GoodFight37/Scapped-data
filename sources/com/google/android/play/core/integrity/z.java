package com.google.android.play.core.integrity;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.3.0 */
/* JADX INFO: loaded from: classes.dex */
final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static s f369a;

    static synchronized s a(Context context) {
        if (f369a == null) {
            q qVar = new q(null);
            qVar.a(com.google.android.play.integrity.internal.ag.a(context));
            f369a = qVar.b();
        }
        return f369a;
    }
}

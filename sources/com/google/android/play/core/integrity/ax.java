package com.google.android.play.core.integrity;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.3.0 */
/* JADX INFO: loaded from: classes.dex */
final class ax {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static aw f336a;

    static synchronized aw a(Context context) {
        if (f336a == null) {
            u uVar = new u(null);
            uVar.a(com.google.android.play.integrity.internal.ag.a(context));
            f336a = uVar.b();
        }
        return f336a;
    }
}

package com.google.android.play.core.assetpacks;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.1.0 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f233a;

    static synchronized a a(Context context) {
        if (f233a == null) {
            cd cdVar = new cd(null);
            cdVar.b(new p(com.google.android.play.core.assetpacks.internal.ag.a(context)));
            f233a = cdVar.a();
        }
        return f233a;
    }
}

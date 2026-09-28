package com.google.android.play.core.integrity;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.3.0 */
/* JADX INFO: loaded from: classes.dex */
final class u implements av {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f366a;

    private u() {
    }

    /* synthetic */ u(t tVar) {
    }

    public final u a(Context context) {
        context.getClass();
        this.f366a = context;
        return this;
    }

    @Override // com.google.android.play.core.integrity.av
    public final aw b() {
        com.google.android.play.integrity.internal.am.a(this.f366a, Context.class);
        return new w(this.f366a, null);
    }
}

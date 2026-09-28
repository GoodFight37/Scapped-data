package com.google.android.play.core.assetpacks;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.1.0 */
/* JADX INFO: loaded from: classes.dex */
public final class cd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private p f211a;

    private cd() {
    }

    /* synthetic */ cd(cc ccVar) {
    }

    public final cd b(p pVar) {
        this.f211a = pVar;
        return this;
    }

    public final a a() {
        p pVar = this.f211a;
        if (pVar != null) {
            return new cb(pVar, null);
        }
        throw new IllegalStateException(String.valueOf(p.class.getCanonicalName()).concat(" must be set"));
    }
}

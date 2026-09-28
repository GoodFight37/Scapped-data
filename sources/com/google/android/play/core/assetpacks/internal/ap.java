package com.google.android.play.core.assetpacks.internal;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.1.0 */
/* JADX INFO: loaded from: classes.dex */
public final class ap implements as {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private as f285a;

    public static void b(as asVar, as asVar2) {
        ap apVar = (ap) asVar;
        if (apVar.f285a != null) {
            throw new IllegalStateException();
        }
        apVar.f285a = asVar2;
    }

    @Override // com.google.android.play.core.assetpacks.internal.as
    public final Object a() {
        as asVar = this.f285a;
        if (asVar != null) {
            return asVar.a();
        }
        throw new IllegalStateException();
    }
}

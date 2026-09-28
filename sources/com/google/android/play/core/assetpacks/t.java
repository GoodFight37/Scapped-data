package com.google.android.play.core.assetpacks;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.1.0 */
/* JADX INFO: loaded from: classes.dex */
public final class t implements com.google.android.play.core.assetpacks.internal.as {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.play.core.assetpacks.internal.as f310a;
    private final com.google.android.play.core.assetpacks.internal.as b;
    private final com.google.android.play.core.assetpacks.internal.as c;

    public t(com.google.android.play.core.assetpacks.internal.as asVar, com.google.android.play.core.assetpacks.internal.as asVar2, com.google.android.play.core.assetpacks.internal.as asVar3) {
        this.f310a = asVar;
        this.b = asVar2;
        this.c = asVar3;
    }

    @Override // com.google.android.play.core.assetpacks.internal.as
    public final /* bridge */ /* synthetic */ Object a() {
        y yVar = p.b(((u) this.f310a).b()) == null ? (y) com.google.android.play.core.assetpacks.internal.aq.c(this.b).a() : (y) com.google.android.play.core.assetpacks.internal.aq.c(this.c).a();
        com.google.android.play.core.assetpacks.internal.ar.a(yVar);
        return yVar;
    }
}

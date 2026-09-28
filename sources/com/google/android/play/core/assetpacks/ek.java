package com.google.android.play.core.assetpacks;

import java.io.File;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.1.0 */
/* JADX INFO: loaded from: classes.dex */
final class ek {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bh f267a;
    private final de b;
    private final co c;
    private final com.google.android.play.core.assetpacks.internal.aq d;
    private final com.google.android.play.core.assetpacks.internal.aq e;

    ek(bh bhVar, com.google.android.play.core.assetpacks.internal.aq aqVar, de deVar, com.google.android.play.core.assetpacks.internal.aq aqVar2, co coVar) {
        this.f267a = bhVar;
        this.d = aqVar;
        this.b = deVar;
        this.e = aqVar2;
        this.c = coVar;
    }

    public final void a(final ei eiVar) {
        File fileH = this.f267a.h(eiVar.l, eiVar.f265a, eiVar.c);
        if (!fileH.exists()) {
            throw new ck(String.format("Cannot find pack files to promote for pack %s at %s", eiVar.l, fileH.getAbsolutePath()), eiVar.k);
        }
        File fileH2 = this.f267a.h(eiVar.l, eiVar.b, eiVar.c);
        fileH2.mkdirs();
        if (!fileH.renameTo(fileH2)) {
            throw new ck(String.format("Cannot promote pack %s from %s to %s", eiVar.l, fileH.getAbsolutePath(), fileH2.getAbsolutePath()), eiVar.k);
        }
        ((Executor) this.e.a()).execute(new Runnable() { // from class: com.google.android.play.core.assetpacks.ej
            @Override // java.lang.Runnable
            public final void run() {
                this.f266a.b(eiVar);
            }
        });
        this.b.k(eiVar.l, eiVar.b, eiVar.c);
        this.c.c(eiVar.l);
        ((y) this.d.a()).h(eiVar.k, eiVar.l);
    }

    final /* synthetic */ void b(ei eiVar) {
        this.f267a.B(eiVar.l, eiVar.b, eiVar.c);
    }
}

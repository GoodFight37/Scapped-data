package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.1.0 */
/* JADX INFO: loaded from: classes.dex */
final class dy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bh f255a;
    private final de b;
    private final co c;
    private final eb d;
    private final com.google.android.play.core.assetpacks.internal.aq e;
    private final com.google.android.play.core.assetpacks.internal.aq f;

    dy(bh bhVar, com.google.android.play.core.assetpacks.internal.aq aqVar, de deVar, com.google.android.play.core.assetpacks.internal.aq aqVar2, co coVar, eb ebVar) {
        this.f255a = bhVar;
        this.e = aqVar;
        this.b = deVar;
        this.f = aqVar2;
        this.c = coVar;
        this.d = ebVar;
    }

    public final void a(final dw dwVar) throws IllegalAccessException, InvocationTargetException {
        File fileJ = this.f255a.j(dwVar.l, dwVar.f253a, dwVar.b);
        File fileL = this.f255a.l(dwVar.l, dwVar.f253a, dwVar.b);
        if (!fileJ.exists() || !fileL.exists()) {
            throw new ck(String.format("Cannot find pack files to move for pack %s.", dwVar.l), dwVar.k);
        }
        File fileH = this.f255a.h(dwVar.l, dwVar.f253a, dwVar.b);
        fileH.mkdirs();
        if (!fileJ.renameTo(fileH)) {
            throw new ck("Cannot move merged pack files to final location.", dwVar.k);
        }
        new File(this.f255a.h(dwVar.l, dwVar.f253a, dwVar.b), "merge.tmp").delete();
        File fileI = this.f255a.i(dwVar.l, dwVar.f253a, dwVar.b);
        fileI.mkdirs();
        if (!fileL.renameTo(fileI)) {
            throw new ck("Cannot move metadata files to final location.", dwVar.k);
        }
        try {
            this.d.b(dwVar.l, dwVar.f253a, dwVar.b, dwVar.c);
            ((Executor) this.f.a()).execute(new Runnable() { // from class: com.google.android.play.core.assetpacks.dx
                @Override // java.lang.Runnable
                public final void run() {
                    this.f254a.b(dwVar);
                }
            });
            this.b.k(dwVar.l, dwVar.f253a, dwVar.b);
            this.c.c(dwVar.l);
            ((y) this.e.a()).h(dwVar.k, dwVar.l);
        } catch (IOException e) {
            throw new ck(String.format("Could not write asset pack version tag for pack %s: %s", dwVar.l, e.getMessage()), dwVar.k);
        }
    }

    final /* synthetic */ void b(dw dwVar) {
        this.f255a.B(dwVar.l, dwVar.f253a, dwVar.b);
    }
}

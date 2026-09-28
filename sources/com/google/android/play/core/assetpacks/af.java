package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.1.0 */
/* JADX INFO: loaded from: classes.dex */
final class af extends com.google.android.play.core.assetpacks.internal.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f177a;
    final /* synthetic */ Map b;
    final /* synthetic */ TaskCompletionSource c;
    final /* synthetic */ be d;
    final /* synthetic */ aw e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    af(aw awVar, TaskCompletionSource taskCompletionSource, List list, Map map, TaskCompletionSource taskCompletionSource2, be beVar) {
        super(taskCompletionSource);
        this.e = awVar;
        this.f177a = list;
        this.b = map;
        this.c = taskCompletionSource2;
        this.d = beVar;
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [android.os.IInterface, com.google.android.play.core.assetpacks.internal.f] */
    @Override // com.google.android.play.core.assetpacks.internal.p
    protected final void a() {
        ArrayList arrayListV = aw.v(this.f177a);
        try {
            ?? E = this.e.f.e();
            String str = this.e.c;
            Bundle bundleN = aw.n(this.b);
            aw awVar = this.e;
            E.k(str, arrayListV, bundleN, new au(awVar, this.c, awVar.d, awVar.e, this.d));
        } catch (RemoteException e) {
            aw.f184a.c(e, "getPackStates(%s)", this.f177a);
            this.c.trySetException(new RuntimeException(e));
        }
    }
}

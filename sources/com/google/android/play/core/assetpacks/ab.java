package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.1.0 */
/* JADX INFO: loaded from: classes.dex */
final class ab extends com.google.android.play.core.assetpacks.internal.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f173a;
    final /* synthetic */ TaskCompletionSource b;
    final /* synthetic */ aw c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ab(aw awVar, TaskCompletionSource taskCompletionSource, String str, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.c = awVar;
        this.f173a = str;
        this.b = taskCompletionSource2;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.os.IInterface, com.google.android.play.core.assetpacks.internal.f] */
    @Override // com.google.android.play.core.assetpacks.internal.p
    protected final void a() {
        try {
            this.c.f.e().j(this.c.c, aw.z(0, this.f173a), aw.A(), new at(this.c, this.b));
        } catch (RemoteException e) {
            aw.f184a.c(e, "removePack(%s)", this.f173a);
        }
    }
}

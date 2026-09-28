package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.1.0 */
/* JADX INFO: loaded from: classes.dex */
final class ah extends com.google.android.play.core.assetpacks.internal.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f179a;
    final /* synthetic */ String b;
    final /* synthetic */ TaskCompletionSource c;
    final /* synthetic */ int d;
    final /* synthetic */ aw e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ah(aw awVar, TaskCompletionSource taskCompletionSource, int i, String str, TaskCompletionSource taskCompletionSource2, int i2) {
        super(taskCompletionSource);
        this.e = awVar;
        this.f179a = i;
        this.b = str;
        this.c = taskCompletionSource2;
        this.d = i2;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.os.IInterface, com.google.android.play.core.assetpacks.internal.f] */
    @Override // com.google.android.play.core.assetpacks.internal.p
    protected final void a() {
        try {
            this.e.f.e().h(this.e.c, aw.z(this.f179a, this.b), aw.A(), new ar(this.e, this.c, this.f179a, this.b, this.d));
        } catch (RemoteException e) {
            aw.f184a.c(e, "notifyModuleCompleted", new Object[0]);
        }
    }
}

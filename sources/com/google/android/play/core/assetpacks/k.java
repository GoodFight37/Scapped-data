package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.1.0 */
/* JADX INFO: loaded from: classes.dex */
final class k extends ResultReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f301a;
    final /* synthetic */ l b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    k(l lVar, Handler handler, TaskCompletionSource taskCompletionSource) {
        super(handler);
        this.b = lVar;
        this.f301a = taskCompletionSource;
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        if (i == 1) {
            this.f301a.trySetResult(-1);
            this.b.g.b(null);
        } else if (i != 2) {
            this.f301a.trySetException(new AssetPackException(-100));
        } else {
            this.f301a.trySetResult(0);
        }
    }
}

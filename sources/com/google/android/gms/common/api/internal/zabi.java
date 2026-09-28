package com.google.android.gms.common.api.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zabi implements Executor {
    public final /* synthetic */ Handler zaa;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.zaa.post(runnable);
    }
}

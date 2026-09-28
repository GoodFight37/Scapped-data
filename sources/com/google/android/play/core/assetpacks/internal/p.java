package com.google.android.play.core.assetpacks.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.1.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TaskCompletionSource f291a;

    p() {
        this.f291a = null;
    }

    public p(TaskCompletionSource taskCompletionSource) {
        this.f291a = taskCompletionSource;
    }

    protected abstract void a();

    final TaskCompletionSource b() {
        return this.f291a;
    }

    public final void c(Exception exc) {
        TaskCompletionSource taskCompletionSource = this.f291a;
        if (taskCompletionSource != null) {
            taskCompletionSource.trySetException(exc);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (Exception e) {
            c(e);
        }
    }
}

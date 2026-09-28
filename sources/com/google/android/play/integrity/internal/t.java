package com.google.android.play.integrity.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.3.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TaskCompletionSource f381a;

    t() {
        this.f381a = null;
    }

    public t(TaskCompletionSource taskCompletionSource) {
        this.f381a = taskCompletionSource;
    }

    public void a(Exception exc) {
        TaskCompletionSource taskCompletionSource = this.f381a;
        if (taskCompletionSource != null) {
            taskCompletionSource.trySetException(exc);
        }
    }

    protected abstract void b();

    final TaskCompletionSource c() {
        return this.f381a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            b();
        } catch (Exception e) {
            a(e);
        }
    }
}

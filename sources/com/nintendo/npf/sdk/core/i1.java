package com.nintendo.npf.sdk.core;

import java.util.Timer;
import java.util.TimerTask;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class i1 implements d5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Timer f478a;

    public i1(boolean z) {
        this.f478a = new Timer(z);
    }

    @Override // com.nintendo.npf.sdk.core.d5
    public void a(TimerTask timerTask, long j, long j2) {
        Intrinsics.checkNotNullParameter(timerTask, "timerTask");
        this.f478a.schedule(timerTask, j, j2);
    }

    @Override // com.nintendo.npf.sdk.core.d5
    public void cancel() {
        this.f478a.cancel();
    }

    @Override // com.nintendo.npf.sdk.core.d5
    public void a() {
        this.f478a.purge();
    }
}

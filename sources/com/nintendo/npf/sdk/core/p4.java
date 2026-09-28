package com.nintendo.npf.sdk.core;

import java.util.Timer;
import java.util.TimerTask;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class p4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0 f544a;
    private final Object b;
    private Timer c;

    public static final class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            p4.this.f544a.invoke();
        }
    }

    public p4(Function0 task) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.f544a = task;
        this.b = new Object();
    }

    public final void b() {
        synchronized (this.b) {
            c();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void c(i config) {
        Intrinsics.checkNotNullParameter(config, "config");
        synchronized (this.b) {
            a(config);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void c() {
        Timer timer = this.c;
        if (timer != null) {
            timer.cancel();
            timer.purge();
        }
        this.c = null;
    }

    public final boolean a() {
        boolean z;
        synchronized (this.b) {
            z = this.c != null;
            Unit unit = Unit.INSTANCE;
        }
        return z;
    }

    public final void b(i config) {
        Intrinsics.checkNotNullParameter(config, "config");
        synchronized (this.b) {
            if (this.c != null) {
                c();
                a(config);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void a(i iVar) {
        if (this.c == null) {
            a aVar = new a();
            Timer timer = new Timer(true);
            timer.schedule(aVar, iVar.i(), iVar.i());
            this.c = timer;
        }
    }
}

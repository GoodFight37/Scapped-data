package io.opencensus.common;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Clock {
    public abstract Timestamp now();

    public abstract long nowNanos();
}

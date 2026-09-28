package com.google.android.play.integrity.internal;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.3.0 */
/* JADX INFO: loaded from: classes.dex */
final class e extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f379a;
    private final long b;

    e(int i, long j) {
        this.f379a = i;
        this.b = j;
    }

    @Override // com.google.android.play.integrity.internal.f
    public final int a() {
        return this.f379a;
    }

    @Override // com.google.android.play.integrity.internal.f
    public final long b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.f379a == fVar.a() && this.b == fVar.b()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.b;
        return ((int) (j ^ (j >>> 32))) ^ ((this.f379a ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "EventRecord{eventType=" + this.f379a + ", eventTimestamp=" + this.b + "}";
    }
}

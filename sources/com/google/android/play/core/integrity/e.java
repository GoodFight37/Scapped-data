package com.google.android.play.core.integrity;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.3.0 */
/* JADX INFO: loaded from: classes.dex */
final class e extends StandardIntegrityManager.PrepareIntegrityTokenRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f357a;

    /* synthetic */ e(long j, int i, d dVar) {
        this.f357a = j;
    }

    @Override // com.google.android.play.core.integrity.StandardIntegrityManager.PrepareIntegrityTokenRequest
    final int a() {
        return 0;
    }

    @Override // com.google.android.play.core.integrity.StandardIntegrityManager.PrepareIntegrityTokenRequest
    public final long b() {
        return this.f357a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof StandardIntegrityManager.PrepareIntegrityTokenRequest) {
            StandardIntegrityManager.PrepareIntegrityTokenRequest prepareIntegrityTokenRequest = (StandardIntegrityManager.PrepareIntegrityTokenRequest) obj;
            if (this.f357a == prepareIntegrityTokenRequest.b()) {
                prepareIntegrityTokenRequest.a();
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f357a;
        return (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
    }

    public final String toString() {
        return "PrepareIntegrityTokenRequest{cloudProjectNumber=" + this.f357a + ", webViewRequestMode=0}";
    }
}

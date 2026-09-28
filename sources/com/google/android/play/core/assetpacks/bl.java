package com.google.android.play.core.assetpacks;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.1.0 */
/* JADX INFO: loaded from: classes.dex */
final class bl extends AssetLocation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f197a;
    private final long b;
    private final long c;

    bl(String str, long j, long j2) {
        if (str == null) {
            throw new NullPointerException("Null path");
        }
        this.f197a = str;
        this.b = j;
        this.c = j2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetLocation) {
            AssetLocation assetLocation = (AssetLocation) obj;
            if (this.f197a.equals(assetLocation.path()) && this.b == assetLocation.offset() && this.c == assetLocation.size()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f197a.hashCode() ^ 1000003;
        long j = this.b;
        long j2 = j ^ (j >>> 32);
        long j3 = this.c;
        return (((iHashCode * 1000003) ^ ((int) j2)) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3));
    }

    @Override // com.google.android.play.core.assetpacks.AssetLocation
    public final long offset() {
        return this.b;
    }

    @Override // com.google.android.play.core.assetpacks.AssetLocation
    public final String path() {
        return this.f197a;
    }

    @Override // com.google.android.play.core.assetpacks.AssetLocation
    public final long size() {
        return this.c;
    }

    public final String toString() {
        return "AssetLocation{path=" + this.f197a + ", offset=" + this.b + ", size=" + this.c + "}";
    }
}

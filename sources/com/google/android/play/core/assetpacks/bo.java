package com.google.android.play.core.assetpacks;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.1.0 */
/* JADX INFO: loaded from: classes.dex */
final class bo extends AssetPackStates {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f200a;
    private final Map b;

    bo(long j, Map map) {
        this.f200a = j;
        this.b = map;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetPackStates) {
            AssetPackStates assetPackStates = (AssetPackStates) obj;
            if (this.f200a == assetPackStates.totalBytes() && this.b.equals(assetPackStates.packStates())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f200a;
        return ((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackStates
    public final Map<String, AssetPackState> packStates() {
        return this.b;
    }

    public final String toString() {
        return "AssetPackStates{totalBytes=" + this.f200a + ", packStates=" + this.b.toString() + "}";
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackStates
    public final long totalBytes() {
        return this.f200a;
    }
}

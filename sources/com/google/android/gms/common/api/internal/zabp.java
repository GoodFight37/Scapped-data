package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
final class zabp {
    private final ApiKey zaa;
    private final Feature zab;

    /* synthetic */ zabp(ApiKey apiKey, Feature feature, zabs zabsVar) {
        this.zaa = apiKey;
        this.zab = feature;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zabp)) {
            zabp zabpVar = (zabp) obj;
            if (Objects.equal(this.zaa, zabpVar.zaa) && Objects.equal(this.zab, zabpVar.zab)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zaa, this.zab);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("key", this.zaa).add("feature", this.zab).toString();
    }
}

package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzff {
    private final Class zza;

    zzff(GoogleApi googleApi, Api.ApiOptions apiOptions) {
        this.zza = googleApi.getClass();
    }

    public final boolean equals(Object obj) {
        return obj != null && (obj instanceof zzff) && Objects.equal(this.zza, ((zzff) obj).zza) && Objects.equal(null, null);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, null);
    }
}

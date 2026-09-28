package com.google.android.gms.nearby.connection;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public class ConnectionsOptions implements Api.ApiOptions.Optional {
    private final String zza = null;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
    public static class Builder {
        public ConnectionsOptions build() {
            return new ConnectionsOptions(this, null);
        }
    }

    /* synthetic */ ConnectionsOptions(Builder builder, zzm zzmVar) {
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionsOptions)) {
            return false;
        }
        String str = ((ConnectionsOptions) obj).zza;
        return Objects.equal(null, null);
    }

    public final int hashCode() {
        return Objects.hashCode(null);
    }
}

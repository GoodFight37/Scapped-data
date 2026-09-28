package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public class MessagesOptions implements Api.ApiOptions.Optional {
    public final int zzc;
    public final String zza = null;
    public final boolean zzb = false;
    public final String zzd = null;
    public final String zze = null;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
    public static class Builder {
        private int zza = -1;

        public MessagesOptions build() {
            return new MessagesOptions(this, null);
        }

        public Builder setPermissions(int i) {
            this.zza = i;
            return this;
        }
    }

    /* synthetic */ MessagesOptions(Builder builder, zzd zzdVar) {
        this.zzc = builder.zza;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MessagesOptions)) {
            return false;
        }
        MessagesOptions messagesOptions = (MessagesOptions) obj;
        String str = messagesOptions.zza;
        if (Objects.equal(null, null)) {
            boolean z = messagesOptions.zzb;
            String str2 = messagesOptions.zzd;
            if (Objects.equal(null, null)) {
                String str3 = messagesOptions.zze;
                if (Objects.equal(null, null) && this.zzc == messagesOptions.zzc) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(null, false, null, null, Integer.valueOf(this.zzc));
    }
}

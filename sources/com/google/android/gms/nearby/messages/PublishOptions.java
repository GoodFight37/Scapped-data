package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class PublishOptions {
    public static final PublishOptions DEFAULT = new Builder().build();
    private final Strategy zza;
    private final PublishCallback zzb;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
    public static class Builder {
        private Strategy zza = Strategy.DEFAULT;
        private PublishCallback zzb;

        public PublishOptions build() {
            return new PublishOptions(this.zza, this.zzb, null);
        }

        public Builder setCallback(PublishCallback publishCallback) {
            this.zzb = (PublishCallback) Preconditions.checkNotNull(publishCallback);
            return this;
        }

        public Builder setStrategy(Strategy strategy) {
            this.zza = (Strategy) Preconditions.checkNotNull(strategy);
            return this;
        }
    }

    /* synthetic */ PublishOptions(Strategy strategy, PublishCallback publishCallback, zze zzeVar) {
        this.zza = strategy;
        this.zzb = publishCallback;
    }

    public PublishCallback getCallback() {
        return this.zzb;
    }

    public Strategy getStrategy() {
        return this.zza;
    }
}

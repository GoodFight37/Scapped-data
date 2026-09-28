package com.google.android.gms.nearby.uwb;

import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public class UwbComplexChannel {
    private final int zza;
    private final int zzb;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
    public static class Builder {
        private int zza;
        private int zzb;

        public UwbComplexChannel build() {
            return new UwbComplexChannel(this.zza, this.zzb, null);
        }

        public Builder setChannel(int i) {
            this.zza = i;
            return this;
        }

        public Builder setPreambleIndex(int i) {
            this.zzb = i;
            return this;
        }
    }

    /* synthetic */ UwbComplexChannel(int i, int i2, zzb zzbVar) {
        this.zza = i;
        this.zzb = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UwbComplexChannel)) {
            return false;
        }
        UwbComplexChannel uwbComplexChannel = (UwbComplexChannel) obj;
        return this.zza == uwbComplexChannel.zza && this.zzb == uwbComplexChannel.zzb;
    }

    public int getChannel() {
        return this.zza;
    }

    public int getPreambleIndex() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzb));
    }

    public String toString() {
        return "UwbComplexChannel{channel=" + this.zza + ", preambleIndex=" + this.zzb + "}";
    }
}

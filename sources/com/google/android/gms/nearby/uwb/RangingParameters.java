package com.google.android.gms.nearby.uwb;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public class RangingParameters {
    public static final int SESSION_ID_UNSET = 0;
    public static final int SUB_SESSION_ID_UNSET = 0;
    private static final byte[] zza = {7, 8, 1, 2, 3, 4, 5, 6};
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final byte[] zze;
    private final byte[] zzf;
    private final UwbComplexChannel zzg;
    private final List zzh;
    private final int zzi;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
    public static class Builder {
        private byte[] zzf;
        private UwbComplexChannel zzg;
        private int zzb = 0;
        private int zzc = 0;
        private int zzd = 0;
        private byte[] zze = RangingParameters.zza;
        private final List zzh = new ArrayList();
        int zza = 3;

        public Builder addPeerDevice(UwbDevice uwbDevice) {
            Preconditions.checkNotNull(uwbDevice, "peerDevice cannot be null.");
            this.zzh.add(uwbDevice);
            return this;
        }

        public RangingParameters build() {
            int length;
            int length2;
            int length3;
            boolean z = true;
            Preconditions.checkArgument(!this.zzh.isEmpty(), "At least 1 peer device must be set.");
            Preconditions.checkArgument(this.zzb != 0);
            Preconditions.checkArgument(this.zza != 0);
            int i = this.zzb;
            if (i == 1 || i == 2 || i == 3) {
                byte[] bArr = this.zze;
                Preconditions.checkArgument(bArr != null && bArr.length == 8);
                Preconditions.checkArgument(this.zzd == 0);
                Preconditions.checkArgument(this.zzf == null);
            }
            int i2 = this.zzb;
            if (i2 == 4 || i2 == 5 || i2 == 6) {
                byte[] bArr2 = this.zze;
                Preconditions.checkArgument(bArr2 != null && ((length = bArr2.length) == 16 || length == 32));
                Preconditions.checkArgument(this.zzd == 0);
                Preconditions.checkArgument(this.zzf == null);
            }
            if (this.zzb == 7) {
                Preconditions.checkArgument(this.zzd != 0);
                byte[] bArr3 = this.zze;
                Preconditions.checkArgument(bArr3 != null && ((length3 = bArr3.length) == 16 || length3 == 32));
                byte[] bArr4 = this.zzf;
                if (bArr4 == null || ((length2 = bArr4.length) != 16 && length2 != 32)) {
                    z = false;
                }
                Preconditions.checkArgument(z);
            }
            return new RangingParameters(this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zza, this.zzh, null);
        }

        public Builder setComplexChannel(UwbComplexChannel uwbComplexChannel) {
            this.zzg = uwbComplexChannel;
            return this;
        }

        public Builder setRangingUpdateRate(int i) {
            this.zza = i;
            return this;
        }

        public Builder setSessionId(int i) {
            this.zzc = i;
            return this;
        }

        public Builder setSessionKeyInfo(byte[] bArr) {
            this.zze = bArr;
            return this;
        }

        public Builder setSubSessionId(int i) {
            this.zzd = i;
            return this;
        }

        public Builder setSubSessionKeyInfo(byte[] bArr) {
            this.zzf = bArr;
            return this;
        }

        public Builder setUwbConfigId(int i) {
            this.zzb = i;
            return this;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
    public @interface RangingUpdateRate {
        public static final int AUTOMATIC = 1;
        public static final int FREQUENT = 3;
        public static final int INFREQUENT = 2;
        public static final int UNKNOWN = 0;
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
    public @interface UwbConfigId {
        public static final int CONFIG_ID_1 = 1;
        public static final int CONFIG_ID_2 = 2;
        public static final int CONFIG_ID_3 = 3;
        public static final int CONFIG_ID_4 = 4;
        public static final int CONFIG_ID_5 = 5;
        public static final int CONFIG_ID_6 = 6;
        public static final int CONFIG_ID_7 = 7;
    }

    /* synthetic */ RangingParameters(int i, int i2, int i3, byte[] bArr, byte[] bArr2, UwbComplexChannel uwbComplexChannel, int i4, List list, zza zzaVar) {
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = bArr;
        this.zzf = bArr2;
        this.zzg = uwbComplexChannel;
        this.zzi = i4;
        this.zzh = list;
    }

    public UwbComplexChannel getComplexChannel() {
        return this.zzg;
    }

    public List<UwbDevice> getPeerDevices() {
        return this.zzh;
    }

    public int getRangingUpdateRate() {
        return this.zzi;
    }

    public int getSessionId() {
        return this.zzc;
    }

    public byte[] getSessionKeyInfo() {
        return this.zze;
    }

    public int getSubSessionId() {
        return this.zzd;
    }

    public byte[] getSubSessionKeyInfo() {
        return this.zzf;
    }

    public int getUwbConfigId() {
        return this.zzb;
    }
}

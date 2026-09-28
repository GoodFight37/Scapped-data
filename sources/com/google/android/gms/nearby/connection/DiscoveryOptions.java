package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class DiscoveryOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DiscoveryOptions> CREATOR = new zzq();
    private Strategy zza;
    private boolean zzb;
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private ParcelUuid zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private int zzk;
    private int zzl;
    private byte[] zzm;
    private long zzn;
    private int[] zzo;
    private boolean zzp;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
    public static final class Builder {
        private final DiscoveryOptions zza;

        public Builder() {
            this.zza = new DiscoveryOptions((zzp) null);
        }

        public DiscoveryOptions build() {
            int[] iArr = this.zza.zzo;
            if (iArr != null && iArr.length > 0) {
                this.zza.zzd = false;
                this.zza.zzc = false;
                this.zza.zzh = false;
                this.zza.zzi = false;
                this.zza.zzg = false;
                for (int i : iArr) {
                    if (i == 2) {
                        this.zza.zzc = true;
                    } else if (i != 11) {
                        if (i == 4) {
                            this.zza.zzd = true;
                        } else if (i == 5) {
                            this.zza.zzg = true;
                        } else if (i == 6) {
                            this.zza.zzi = true;
                        } else if (i != 7) {
                            Log.d("NearbyConnections", "Illegal discovery medium " + i);
                        } else {
                            this.zza.zzh = true;
                        }
                    }
                }
            }
            return this.zza;
        }

        public Builder setLowPower(boolean z) {
            this.zza.zze = z;
            return this;
        }

        public Builder setStrategy(Strategy strategy) {
            this.zza.zza = strategy;
            return this;
        }

        public Builder(DiscoveryOptions discoveryOptions) {
            DiscoveryOptions discoveryOptions2 = new DiscoveryOptions((zzp) null);
            this.zza = discoveryOptions2;
            discoveryOptions2.zza = discoveryOptions.zza;
            discoveryOptions2.zzb = discoveryOptions.zzb;
            discoveryOptions2.zzc = discoveryOptions.zzc;
            discoveryOptions2.zzd = discoveryOptions.zzd;
            discoveryOptions2.zze = discoveryOptions.zze;
            discoveryOptions2.zzf = discoveryOptions.zzf;
            discoveryOptions2.zzg = discoveryOptions.zzg;
            discoveryOptions2.zzh = discoveryOptions.zzh;
            discoveryOptions2.zzi = discoveryOptions.zzi;
            discoveryOptions2.zzj = discoveryOptions.zzj;
            discoveryOptions2.zzk = discoveryOptions.zzk;
            discoveryOptions2.zzl = discoveryOptions.zzl;
            discoveryOptions2.zzm = discoveryOptions.zzm;
            discoveryOptions2.zzn = discoveryOptions.zzn;
            discoveryOptions2.zzo = discoveryOptions.zzo;
            discoveryOptions2.zzp = discoveryOptions.zzp;
        }
    }

    private DiscoveryOptions() {
        this.zzb = false;
        this.zzc = true;
        this.zzd = true;
        this.zze = false;
        this.zzg = true;
        this.zzh = true;
        this.zzi = true;
        this.zzj = false;
        this.zzk = 0;
        this.zzl = 0;
        this.zzn = 0L;
        this.zzp = true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DiscoveryOptions) {
            DiscoveryOptions discoveryOptions = (DiscoveryOptions) obj;
            if (Objects.equal(this.zza, discoveryOptions.zza) && Objects.equal(Boolean.valueOf(this.zzb), Boolean.valueOf(discoveryOptions.zzb)) && Objects.equal(Boolean.valueOf(this.zzc), Boolean.valueOf(discoveryOptions.zzc)) && Objects.equal(Boolean.valueOf(this.zzd), Boolean.valueOf(discoveryOptions.zzd)) && Objects.equal(Boolean.valueOf(this.zze), Boolean.valueOf(discoveryOptions.zze)) && Objects.equal(this.zzf, discoveryOptions.zzf) && Objects.equal(Boolean.valueOf(this.zzg), Boolean.valueOf(discoveryOptions.zzg)) && Objects.equal(Boolean.valueOf(this.zzh), Boolean.valueOf(discoveryOptions.zzh)) && Objects.equal(Boolean.valueOf(this.zzi), Boolean.valueOf(discoveryOptions.zzi)) && Objects.equal(Boolean.valueOf(this.zzj), Boolean.valueOf(discoveryOptions.zzj)) && Objects.equal(Integer.valueOf(this.zzk), Integer.valueOf(discoveryOptions.zzk)) && Objects.equal(Integer.valueOf(this.zzl), Integer.valueOf(discoveryOptions.zzl)) && Arrays.equals(this.zzm, discoveryOptions.zzm) && Objects.equal(Long.valueOf(this.zzn), Long.valueOf(discoveryOptions.zzn)) && Arrays.equals(this.zzo, discoveryOptions.zzo) && Objects.equal(Boolean.valueOf(this.zzp), Boolean.valueOf(discoveryOptions.zzp))) {
                return true;
            }
        }
        return false;
    }

    public boolean getLowPower() {
        return this.zze;
    }

    public Strategy getStrategy() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, Boolean.valueOf(this.zzb), Boolean.valueOf(this.zzc), Boolean.valueOf(this.zzd), Boolean.valueOf(this.zze), this.zzf, Boolean.valueOf(this.zzg), Boolean.valueOf(this.zzh), Boolean.valueOf(this.zzi), Boolean.valueOf(this.zzj), Integer.valueOf(this.zzk), Integer.valueOf(this.zzl), Integer.valueOf(Arrays.hashCode(this.zzm)), Long.valueOf(this.zzn), Integer.valueOf(Arrays.hashCode(this.zzo)), Boolean.valueOf(this.zzp));
    }

    public String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[15];
        objArr[0] = this.zza;
        objArr[1] = Boolean.valueOf(this.zzb);
        objArr[2] = Boolean.valueOf(this.zzc);
        objArr[3] = Boolean.valueOf(this.zzd);
        objArr[4] = Boolean.valueOf(this.zze);
        objArr[5] = this.zzf;
        objArr[6] = Boolean.valueOf(this.zzg);
        objArr[7] = Boolean.valueOf(this.zzh);
        objArr[8] = Boolean.valueOf(this.zzi);
        objArr[9] = Boolean.valueOf(this.zzj);
        objArr[10] = Integer.valueOf(this.zzk);
        objArr[11] = Integer.valueOf(this.zzl);
        byte[] bArr = this.zzm;
        objArr[12] = bArr == null ? "null" : com.google.android.gms.nearby.messages.internal.zzc.zzb(bArr);
        objArr[13] = Long.valueOf(this.zzn);
        objArr[14] = Boolean.valueOf(this.zzp);
        return String.format(locale, "DiscoveryOptions{strategy: %s, forwardUnrecognizedBluetoothDevices: %s, enableBluetooth: %s, enableBle: %s, lowPower: %s, fastAdvertisementServiceUuid: %s, enableWifiLan: %s, enableNfc: %s, enableWifiAware: %s, enableUwbRanging: %s, uwbChannel: %d, uwbPreambleIndex: %d, uwbAddress: %s, flowId: %d, allowGattConnections: %s}", objArr);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getStrategy(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzb);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 5, getLowPower());
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzg);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzh);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzi);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzj);
        SafeParcelWriter.writeInt(parcel, 12, this.zzk);
        SafeParcelWriter.writeInt(parcel, 13, this.zzl);
        SafeParcelWriter.writeByteArray(parcel, 14, this.zzm, false);
        SafeParcelWriter.writeLong(parcel, 15, this.zzn);
        SafeParcelWriter.writeIntArray(parcel, 16, this.zzo, false);
        SafeParcelWriter.writeBoolean(parcel, 17, this.zzp);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final boolean zzE() {
        return this.zzh;
    }

    /* synthetic */ DiscoveryOptions(zzp zzpVar) {
        this.zzb = false;
        this.zzc = true;
        this.zzd = true;
        this.zze = false;
        this.zzg = true;
        this.zzh = true;
        this.zzi = true;
        this.zzj = false;
        this.zzk = 0;
        this.zzl = 0;
        this.zzn = 0L;
        this.zzp = true;
    }

    @Deprecated
    public DiscoveryOptions(Strategy strategy) {
        this.zzb = false;
        this.zzc = true;
        this.zzd = true;
        this.zze = false;
        this.zzg = true;
        this.zzh = true;
        this.zzi = true;
        this.zzj = false;
        this.zzk = 0;
        this.zzl = 0;
        this.zzn = 0L;
        this.zzp = true;
        this.zza = strategy;
    }

    DiscoveryOptions(Strategy strategy, boolean z, boolean z2, boolean z3, boolean z4, ParcelUuid parcelUuid, boolean z5, boolean z6, boolean z7, boolean z8, int i, int i2, byte[] bArr, long j, int[] iArr, boolean z9) {
        this.zzp = true;
        this.zza = strategy;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = z3;
        this.zze = z4;
        this.zzf = parcelUuid;
        this.zzg = z5;
        this.zzh = z6;
        this.zzi = z7;
        this.zzj = z8;
        this.zzk = i;
        this.zzl = i2;
        this.zzm = bArr;
        this.zzn = j;
        this.zzo = iArr;
    }
}

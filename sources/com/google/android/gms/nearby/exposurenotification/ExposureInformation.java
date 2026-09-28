package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class ExposureInformation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ExposureInformation> CREATOR = new zzf();
    final long zza;
    final int zzb;
    final int zzc;
    final int zzd;
    final int zze;
    final int[] zzf;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
    public static final class ExposureInformationBuilder {
        private long zza = 0;
        private int zzb = 0;
        private int zzc = 0;
        private int zzd = 0;
        private int zze = 0;
        private int[] zzf = {0, 0};

        public ExposureInformation build() {
            return new ExposureInformation(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
        }

        public ExposureInformationBuilder setAttenuationDurations(int[] iArr) {
            int length = iArr.length;
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                Preconditions.checkArgument(i2 >= 0, "attenuationDuration (%s) must be >= 0", Integer.valueOf(i2));
            }
            this.zzf = Arrays.copyOf(iArr, iArr.length);
            return this;
        }

        public ExposureInformationBuilder setAttenuationValue(int i) {
            boolean z = false;
            if (i >= 0 && i <= 255) {
                z = true;
            }
            Preconditions.checkArgument(z, "attenuationValue (%s) must be >= 0 and <= 255", Integer.valueOf(i));
            this.zzc = i;
            return this;
        }

        public ExposureInformationBuilder setDateMillisSinceEpoch(long j) {
            Preconditions.checkArgument(j >= 0, "dateMillisSinceEpoch (%s) must be >= 0", Long.valueOf(j));
            this.zza = j;
            return this;
        }

        public ExposureInformationBuilder setDurationMinutes(int i) {
            Integer numValueOf = Integer.valueOf(i);
            Preconditions.checkArgument(i % 5 == 0, "durationMinutes (%s) must be an increment of 5", numValueOf);
            Preconditions.checkArgument(i <= 30, "durationMinutes (%s) must be <= 30", numValueOf);
            this.zzb = i;
            return this;
        }

        public ExposureInformationBuilder setTotalRiskScore(int i) {
            boolean z = false;
            if (i >= 0 && i <= 4096) {
                z = true;
            }
            Preconditions.checkArgument(z, "totalRiskScore (%s) must be >= 0 and <= 4096", Integer.valueOf(i));
            this.zze = i;
            return this;
        }

        public ExposureInformationBuilder setTransmissionRiskLevel(int i) {
            boolean z = false;
            if (i >= 0 && i <= 8) {
                z = true;
            }
            Preconditions.checkArgument(z, "transmissionRiskLevel (%s) must be >= 0 and <= 8", Integer.valueOf(i));
            this.zzd = i;
            return this;
        }
    }

    ExposureInformation(long j, int i, int i2, int i3, int i4, int[] iArr) {
        this.zza = j;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = iArr;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ExposureInformation) {
            ExposureInformation exposureInformation = (ExposureInformation) obj;
            if (Objects.equal(Long.valueOf(this.zza), Long.valueOf(exposureInformation.getDateMillisSinceEpoch())) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(exposureInformation.getDurationMinutes())) && Objects.equal(Integer.valueOf(this.zzc), Integer.valueOf(exposureInformation.getAttenuationValue())) && Objects.equal(Integer.valueOf(this.zzd), Integer.valueOf(exposureInformation.getTransmissionRiskLevel())) && Objects.equal(Integer.valueOf(this.zze), Integer.valueOf(exposureInformation.getTotalRiskScore())) && Arrays.equals(this.zzf, exposureInformation.getAttenuationDurationsInMinutes())) {
                return true;
            }
        }
        return false;
    }

    public int[] getAttenuationDurationsInMinutes() {
        int[] iArr = this.zzf;
        return Arrays.copyOf(iArr, iArr.length);
    }

    public int getAttenuationValue() {
        return this.zzc;
    }

    public long getDateMillisSinceEpoch() {
        return this.zza;
    }

    public int getDurationMinutes() {
        return this.zzb;
    }

    public int getTotalRiskScore() {
        return this.zze;
    }

    public int getTransmissionRiskLevel() {
        return this.zzd;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), Integer.valueOf(this.zze), this.zzf);
    }

    public String toString() {
        return String.format(Locale.US, "ExposureInformation<date: %s, dateMillisSinceEpoch: %d, durationMinutes: %d, attenuationValue: %d, transmissionRiskLevel: %d, totalRiskScore: %d, attenuationDurations: %s>", new Date(this.zza), Long.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), Integer.valueOf(this.zze), Arrays.toString(this.zzf));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, getDateMillisSinceEpoch());
        SafeParcelWriter.writeInt(parcel, 2, getDurationMinutes());
        SafeParcelWriter.writeInt(parcel, 3, getAttenuationValue());
        SafeParcelWriter.writeInt(parcel, 4, getTransmissionRiskLevel());
        SafeParcelWriter.writeInt(parcel, 5, getTotalRiskScore());
        SafeParcelWriter.writeIntArray(parcel, 6, getAttenuationDurationsInMinutes(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}

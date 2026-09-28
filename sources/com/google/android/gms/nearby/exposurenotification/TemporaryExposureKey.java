package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.os.EnvironmentCompat;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.Hex;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class TemporaryExposureKey extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<TemporaryExposureKey> CREATOR = new zzp();
    public static final int DAYS_SINCE_ONSET_OF_SYMPTOMS_UNKNOWN = Integer.MAX_VALUE;
    final byte[] zza;
    final int zzb;
    final int zzc;
    final int zzd;
    final int zze;
    final int zzf;
    final int zzg;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
    public static final class TemporaryExposureKeyBuilder {
        private byte[] zza = new byte[0];
        private int zzb = 0;
        private int zzc = 0;
        private int zzd = 1;
        private int zze = 0;
        private int zzf = Integer.MAX_VALUE;
        private int zzg = 0;

        public TemporaryExposureKey build() {
            return new TemporaryExposureKey(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg);
        }

        public TemporaryExposureKeyBuilder setDaysSinceOnsetOfSymptoms(int i) {
            boolean z = false;
            if (i >= -14 && i <= 14) {
                z = true;
            }
            Preconditions.checkArgument(z, "daysSinceOnsetOfSymptoms (%d) must be >= -14 and <= 14", Integer.valueOf(i));
            this.zzf = i;
            return this;
        }

        public TemporaryExposureKeyBuilder setKeyData(byte[] bArr) {
            this.zza = Arrays.copyOf(bArr, bArr.length);
            return this;
        }

        public TemporaryExposureKeyBuilder setReportType(int i) {
            boolean z = false;
            if (i >= 0 && i <= 5) {
                z = true;
            }
            Preconditions.checkArgument(z, String.format(Locale.getDefault(), "reportType (%d) is invalid", Integer.valueOf(i)));
            this.zze = i;
            return this;
        }

        public TemporaryExposureKeyBuilder setRollingPeriod(int i) {
            Preconditions.checkArgument(i > 0, "rollingPeriod (%s) must be > 0", Integer.valueOf(i));
            this.zzd = i;
            return this;
        }

        public TemporaryExposureKeyBuilder setRollingStartIntervalNumber(int i) {
            Preconditions.checkArgument(i >= 0, "rollingStartIntervalNumber (%s) must be >= 0", Integer.valueOf(i));
            this.zzb = i;
            return this;
        }

        public TemporaryExposureKeyBuilder setTransmissionRiskLevel(int i) {
            boolean z = false;
            if (i >= 0 && i <= 8) {
                z = true;
            }
            Preconditions.checkArgument(z, "transmissionRiskLevel (%s) must be >= 0 and <= 8", Integer.valueOf(i));
            this.zzc = i;
            return this;
        }

        public TemporaryExposureKeyBuilder setVariantOfConcern(int i) {
            boolean z = false;
            if (i >= 0 && i <= 4) {
                z = true;
            }
            Preconditions.checkArgument(z, String.format(Locale.getDefault(), "variantOfConcern (%d) is not allowed", Integer.valueOf(i)));
            this.zzg = i;
            return this;
        }
    }

    TemporaryExposureKey(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6) {
        this.zza = bArr;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = i5;
        this.zzg = i6;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TemporaryExposureKey) {
            TemporaryExposureKey temporaryExposureKey = (TemporaryExposureKey) obj;
            if (Arrays.equals(this.zza, temporaryExposureKey.getKeyData()) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(temporaryExposureKey.getRollingStartIntervalNumber())) && Objects.equal(Integer.valueOf(this.zzc), Integer.valueOf(temporaryExposureKey.getTransmissionRiskLevel())) && Objects.equal(Integer.valueOf(this.zzd), Integer.valueOf(temporaryExposureKey.getRollingPeriod())) && Objects.equal(Integer.valueOf(this.zze), Integer.valueOf(temporaryExposureKey.getReportType())) && this.zzf == temporaryExposureKey.zzf && this.zzg == temporaryExposureKey.zzg) {
                return true;
            }
        }
        return false;
    }

    public int getDaysSinceOnsetOfSymptoms() {
        return this.zzf;
    }

    public byte[] getKeyData() {
        byte[] bArr = this.zza;
        return Arrays.copyOf(bArr, bArr.length);
    }

    public int getReportType() {
        return this.zze;
    }

    public int getRollingPeriod() {
        return this.zzd;
    }

    public int getRollingStartIntervalNumber() {
        return this.zzb;
    }

    public int getTransmissionRiskLevel() {
        return this.zzc;
    }

    public int getVariantOfConcern() {
        return this.zzg;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(Arrays.hashCode(this.zza)), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), Integer.valueOf(this.zze), Integer.valueOf(this.zzf), Integer.valueOf(this.zzg));
    }

    public String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[6];
        objArr[0] = Hex.bytesToStringLowercase(this.zza);
        objArr[1] = new Date(TimeUnit.MINUTES.toMillis(((long) this.zzb) * 10));
        objArr[2] = Integer.valueOf(this.zzc);
        objArr[3] = Integer.valueOf(this.zzd);
        objArr[4] = Integer.valueOf(this.zze);
        int i = this.zzf;
        objArr[5] = i == Integer.MAX_VALUE ? EnvironmentCompat.MEDIA_UNKNOWN : Integer.valueOf(i);
        return String.format(locale, "TemporaryExposureKey<keyData: %s, rollingStartIntervalNumber: %s, transmissionRiskLevel: %d, rollingPeriod: %d, reportType: %d, daysSinceOnsetOfSymptoms: %s>", objArr);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 1, getKeyData(), false);
        SafeParcelWriter.writeInt(parcel, 2, getRollingStartIntervalNumber());
        SafeParcelWriter.writeInt(parcel, 3, getTransmissionRiskLevel());
        SafeParcelWriter.writeInt(parcel, 4, getRollingPeriod());
        SafeParcelWriter.writeInt(parcel, 5, getReportType());
        SafeParcelWriter.writeInt(parcel, 6, getDaysSinceOnsetOfSymptoms());
        SafeParcelWriter.writeInt(parcel, 7, getVariantOfConcern());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}

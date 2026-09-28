package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class ExposureSummary extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<ExposureSummary> CREATOR = new zzk();
    final int zza;
    final int zzb;
    final int zzc;
    final int[] zzd;
    final int zze;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
    public static final class ExposureSummaryBuilder {
        private int zza = 0;
        private int zzb = 0;
        private int zzc = 0;
        private int[] zzd = {0, 0, 0};
        private int zze = 0;

        public ExposureSummary build() {
            return new ExposureSummary(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
        }

        public ExposureSummaryBuilder setAttenuationDurations(int[] iArr) {
            int length = iArr.length;
            Preconditions.checkArgument(length == 3);
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                Preconditions.checkArgument(i2 >= 0, "attenuationDuration (%s) must be >= 0", Integer.valueOf(i2));
            }
            this.zzd = Arrays.copyOf(iArr, iArr.length);
            return this;
        }

        public ExposureSummaryBuilder setDaysSinceLastExposure(int i) {
            Preconditions.checkArgument(i >= 0, "daysSinceLastExposure (%s) must be >= 0", Integer.valueOf(i));
            this.zza = i;
            return this;
        }

        public ExposureSummaryBuilder setMatchedKeyCount(int i) {
            Preconditions.checkArgument(i >= 0, "matchedKeyCount (%s) must be >= 0", Integer.valueOf(i));
            this.zzb = i;
            return this;
        }

        public ExposureSummaryBuilder setMaximumRiskScore(int i) {
            boolean z = false;
            if (i >= 0 && i <= 4096) {
                z = true;
            }
            Preconditions.checkArgument(z, "maximumRiskScore (%s) must be >= 0 and <= 4096", Integer.valueOf(i));
            this.zzc = i;
            return this;
        }

        public ExposureSummaryBuilder setSummationRiskScore(int i) {
            Preconditions.checkArgument(i >= 0, "summationRiskScore (%s) must be >= 0", Integer.valueOf(i));
            this.zze = i;
            return this;
        }
    }

    ExposureSummary(int i, int i2, int i3, int[] iArr, int i4) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = iArr;
        this.zze = i4;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ExposureSummary) {
            ExposureSummary exposureSummary = (ExposureSummary) obj;
            if (Objects.equal(Integer.valueOf(this.zza), Integer.valueOf(exposureSummary.getDaysSinceLastExposure())) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(exposureSummary.getMatchedKeyCount())) && Objects.equal(Integer.valueOf(this.zzc), Integer.valueOf(exposureSummary.getMaximumRiskScore())) && Arrays.equals(this.zzd, exposureSummary.getAttenuationDurationsInMinutes()) && Objects.equal(Integer.valueOf(this.zze), Integer.valueOf(exposureSummary.getSummationRiskScore()))) {
                return true;
            }
        }
        return false;
    }

    public int[] getAttenuationDurationsInMinutes() {
        int[] iArr = this.zzd;
        return Arrays.copyOf(iArr, iArr.length);
    }

    public int getDaysSinceLastExposure() {
        return this.zza;
    }

    public int getMatchedKeyCount() {
        return this.zzb;
    }

    public int getMaximumRiskScore() {
        return this.zzc;
    }

    public int getSummationRiskScore() {
        return this.zze;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), this.zzd, Integer.valueOf(this.zze));
    }

    public String toString() {
        return String.format(Locale.US, "ExposureSummary<daysSinceLastExposure: %d, matchedKeyCount: %d, maximumRiskScore: %d, attenuationDurations: %s, summationRiskScore: %d>", Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Arrays.toString(this.zzd), Integer.valueOf(this.zze));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getDaysSinceLastExposure());
        SafeParcelWriter.writeInt(parcel, 2, getMatchedKeyCount());
        SafeParcelWriter.writeInt(parcel, 3, getMaximumRiskScore());
        SafeParcelWriter.writeIntArray(parcel, 4, getAttenuationDurationsInMinutes(), false);
        SafeParcelWriter.writeInt(parcel, 5, getSummationRiskScore());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}

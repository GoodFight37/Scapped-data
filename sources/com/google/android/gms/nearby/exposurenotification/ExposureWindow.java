package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.nearby.zzsq;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class ExposureWindow extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ExposureWindow> CREATOR = new zzm();
    final long zza;
    final List zzb;
    final int zzc;
    final int zzd;
    final int zze;
    final String zzf;
    final int zzg;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
    public static class Builder {
        private long zza = 0;
        private List zzb = zzsq.zzl();
        private int zzc = 1;
        private int zzd = 1;
        private int zze = 0;
        private int zzf = 0;

        public ExposureWindow build() {
            return new ExposureWindow(this.zza, this.zzb, this.zzc, this.zzd, this.zze, null, this.zzf);
        }

        public Builder setCalibrationConfidence(int i) {
            Preconditions.checkNotNull(zzh.zza(i), String.format(Locale.getDefault(), "calibrationConfidence (%d) is invalid", Integer.valueOf(i)));
            this.zze = i;
            return this;
        }

        public Builder setDateMillisSinceEpoch(long j) {
            this.zza = j;
            return this;
        }

        public Builder setInfectiousness(int i) {
            Preconditions.checkNotNull(zzj.zza(i), String.format(Locale.getDefault(), "infectiousness (%d) is invalid", Integer.valueOf(i)));
            this.zzd = i;
            return this;
        }

        public Builder setReportType(int i) {
            boolean z = false;
            if (i > 0 && i < 5) {
                z = true;
            }
            Preconditions.checkArgument(z, "reportType (%d) is not allowed", Integer.valueOf(i));
            this.zzc = i;
            return this;
        }

        public Builder setScanInstances(List<ScanInstance> list) {
            this.zzb = (List) Preconditions.checkNotNull(list);
            return this;
        }

        public Builder setVariantOfConcern(int i) {
            boolean z = false;
            if (i >= 0 && i <= 4) {
                z = true;
            }
            Preconditions.checkArgument(z, String.format(Locale.getDefault(), "variantOfConcern (%d) is not allowed", Integer.valueOf(i)));
            this.zzf = i;
            return this;
        }
    }

    ExposureWindow(long j, List list, int i, int i2, int i3, String str, int i4) {
        this.zza = j;
        this.zzb = zzsq.zzk(list);
        this.zzc = i;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = str;
        this.zzg = i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ExposureWindow exposureWindow = (ExposureWindow) obj;
            if (this.zzc == exposureWindow.zzc && this.zza == exposureWindow.zza && this.zzb.equals(exposureWindow.zzb) && this.zzd == exposureWindow.zzd && this.zze == exposureWindow.zze && Objects.equal(this.zzf, exposureWindow.zzf) && this.zzg == exposureWindow.zzg) {
                return true;
            }
        }
        return false;
    }

    public int getCalibrationConfidence() {
        return this.zze;
    }

    public long getDateMillisSinceEpoch() {
        return this.zza;
    }

    public int getInfectiousness() {
        return this.zzd;
    }

    public int getReportType() {
        return this.zzc;
    }

    public List<ScanInstance> getScanInstances() {
        return this.zzb;
    }

    public int getVariantOfConcern() {
        return this.zzg;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), this.zzb, Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), Integer.valueOf(this.zze), this.zzf, Integer.valueOf(this.zzg));
    }

    public String toString() {
        return "ExposureWindow{dateMillisSinceEpoch=" + this.zza + ", reportType=" + this.zzc + ", scanInstances=" + String.valueOf(this.zzb) + ", infectiousness=" + this.zzd + ", calibrationConfidence=" + this.zze + ", deviceName=" + this.zzf + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, getDateMillisSinceEpoch());
        SafeParcelWriter.writeTypedList(parcel, 2, getScanInstances(), false);
        SafeParcelWriter.writeInt(parcel, 3, getReportType());
        SafeParcelWriter.writeInt(parcel, 4, getInfectiousness());
        SafeParcelWriter.writeInt(parcel, 5, getCalibrationConfidence());
        SafeParcelWriter.writeString(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeInt(parcel, 7, getVariantOfConcern());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}

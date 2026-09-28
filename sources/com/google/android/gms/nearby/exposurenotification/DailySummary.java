package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public class DailySummary extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<DailySummary> CREATOR = new zzc();
    final int zza;
    final List zzb;
    final ExposureSummaryData zzc;
    final String zzd;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
    public static class ExposureSummaryData extends AbstractSafeParcelable implements ReflectedParcelable {
        public static final Parcelable.Creator<ExposureSummaryData> CREATOR = new zzl();
        final double zza;
        final double zzb;
        final double zzc;

        ExposureSummaryData(double d, double d2, double d3) {
            this.zza = d;
            this.zzb = d2;
            this.zzc = d3;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ExposureSummaryData) {
                ExposureSummaryData exposureSummaryData = (ExposureSummaryData) obj;
                if (this.zza == exposureSummaryData.zza && this.zzb == exposureSummaryData.zzb && this.zzc == exposureSummaryData.zzc) {
                    return true;
                }
            }
            return false;
        }

        public double getMaximumScore() {
            return this.zza;
        }

        public double getScoreSum() {
            return this.zzb;
        }

        public double getWeightedDurationSum() {
            return this.zzc;
        }

        public int hashCode() {
            return Objects.hashCode(Double.valueOf(this.zza), Double.valueOf(this.zzb), Double.valueOf(this.zzc));
        }

        public String toString() {
            return String.format(Locale.US, "ExposureSummaryData<maximumScore: %.3f, scoreSum: %.3f, weightedDurationSum: %.3f>", Double.valueOf(this.zza), Double.valueOf(this.zzb), Double.valueOf(this.zzc));
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeDouble(parcel, 1, getMaximumScore());
            SafeParcelWriter.writeDouble(parcel, 2, getScoreSum());
            SafeParcelWriter.writeDouble(parcel, 3, getWeightedDurationSum());
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }
    }

    DailySummary(int i, List list, ExposureSummaryData exposureSummaryData, String str) {
        this.zza = i;
        this.zzb = list;
        this.zzc = exposureSummaryData;
        this.zzd = str;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DailySummary) {
            DailySummary dailySummary = (DailySummary) obj;
            if (this.zza == dailySummary.zza && this.zzb.equals(dailySummary.zzb) && Objects.equal(this.zzc, dailySummary.zzc) && Objects.equal(this.zzd, dailySummary.zzd)) {
                return true;
            }
        }
        return false;
    }

    public int getDaysSinceEpoch() {
        return this.zza;
    }

    public ExposureSummaryData getSummaryData() {
        return this.zzc;
    }

    public ExposureSummaryData getSummaryDataForReportType(int i) {
        return (ExposureSummaryData) this.zzb.get(i);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), this.zzb, this.zzc, this.zzd);
    }

    public String toString() {
        return String.format(Locale.US, "DailySummary<daysSinceEpoch: %d, reportSummaries: %s, daySummary: %s, deviceName: %s>", Integer.valueOf(this.zza), this.zzb, this.zzc, this.zzd);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getDaysSinceEpoch());
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 3, getSummaryData(), i, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}

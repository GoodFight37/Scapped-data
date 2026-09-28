package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public class DailySummariesConfig extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<DailySummariesConfig> CREATOR = new zzb();
    final List zza;
    final List zzb;
    final List zzc;
    final List zzd;
    final int zze;
    final double zzf;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
    public static final class DailySummariesConfigBuilder {
        int zza;
        double zzb;
        private final Double[] zzc;
        private final Double[] zzd;
        private List zze;
        private List zzf;

        public DailySummariesConfigBuilder() {
            Double[] dArr = new Double[6];
            this.zzc = dArr;
            Double[] dArr2 = new Double[zzj.values().length];
            this.zzd = dArr2;
            this.zza = 0;
            this.zzb = 0.0d;
            Double dValueOf = Double.valueOf(0.0d);
            Arrays.fill(dArr, dValueOf);
            Arrays.fill(dArr2, dValueOf);
        }

        private static void zza(List list, int i, String str) {
            Preconditions.checkArgument(list != null, String.format(Locale.ENGLISH, "%s must not be null", str));
            int size = list.size();
            Preconditions.checkArgument(size == i, String.format(Locale.ENGLISH, "%s must must contains %d elements", str, Integer.valueOf(i)));
        }

        private static void zzb(double d, String str) {
            boolean z = false;
            if (d >= 0.0d && d <= 2.5d) {
                z = true;
            }
            Preconditions.checkArgument(z, String.format(Locale.ENGLISH, "Element value of %s must between 0 ~ 2.5", str));
        }

        public DailySummariesConfig build() {
            Preconditions.checkArgument(this.zze != null, "Must set attenuationBucketThresholdDb");
            Preconditions.checkArgument(this.zzf != null, "Must set attenuationBucketWeights");
            return new DailySummariesConfig(Arrays.asList(this.zzc), Arrays.asList(this.zzd), this.zze, this.zzf, this.zza, this.zzb);
        }

        public DailySummariesConfigBuilder setAttenuationBuckets(List<Integer> list, List<Double> list2) {
            zza.zza();
            zza(list, 3, "attenuationBucketThresholdDb");
            for (int i = 0; i < list.size(); i++) {
                Preconditions.checkArgument(list.get(i).intValue() >= 0 && list.get(i).intValue() <= 255, "Element of attenuationBucketThreshold must between 0 ~ 255");
                if (i != 0) {
                    int i2 = i - 1;
                    Preconditions.checkArgument(list.get(i2).intValue() < list.get(i).intValue(), String.format(Locale.ENGLISH, "attenuationBucketThresholdDb of index %d must be larger than index %d", Integer.valueOf(i), Integer.valueOf(i2)));
                }
            }
            this.zze = new ArrayList(list);
            zza.zza();
            zza(list2, 4, "attenuationBucketWeights");
            Iterator<Double> it = list2.iterator();
            while (it.hasNext()) {
                zzb(it.next().doubleValue(), "attenuationBucketWeights");
            }
            this.zzf = new ArrayList(list2);
            return this;
        }

        public DailySummariesConfigBuilder setDaysSinceExposureThreshold(int i) {
            Preconditions.checkArgument(i >= 0, "daysSinceExposureThreshold must not be negative");
            this.zza = i;
            return this;
        }

        public DailySummariesConfigBuilder setInfectiousnessWeight(int i, double d) {
            zzj zzjVarZza = zzj.zza(i);
            boolean z = false;
            if (zzjVarZza != null && zzjVarZza != zzj.INFECTIOUSNESS_NONE) {
                z = true;
            }
            Preconditions.checkArgument(z, "Incorrect value of infectiousness");
            zzb(d, "infectiousnessWeights");
            this.zzd[i] = Double.valueOf(d);
            return this;
        }

        public DailySummariesConfigBuilder setMinimumWindowScore(double d) {
            Preconditions.checkArgument(d >= 0.0d, "minimumWindowScore must not be negative");
            this.zzb = d;
            return this;
        }

        public DailySummariesConfigBuilder setReportTypeWeight(int i, double d) {
            boolean z = false;
            if (i > 0 && i < 5) {
                z = true;
            }
            Preconditions.checkArgument(z, "Incorrect value of reportType");
            zzb(d, "reportTypeWeights");
            this.zzc[i] = Double.valueOf(d);
            return this;
        }
    }

    DailySummariesConfig(List list, List list2, List list3, List list4, int i, double d) {
        this.zza = list;
        this.zzb = list2;
        this.zzc = list3;
        this.zzd = list4;
        this.zze = i;
        this.zzf = d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DailySummariesConfig) {
            DailySummariesConfig dailySummariesConfig = (DailySummariesConfig) obj;
            if (this.zza.equals(dailySummariesConfig.zza) && this.zzb.equals(dailySummariesConfig.zzb) && this.zzc.equals(dailySummariesConfig.zzc) && this.zzd.equals(dailySummariesConfig.zzd) && this.zze == dailySummariesConfig.zze && this.zzf == dailySummariesConfig.zzf) {
                return true;
            }
        }
        return false;
    }

    public List<Integer> getAttenuationBucketThresholdDb() {
        return new ArrayList(this.zzc);
    }

    public List<Double> getAttenuationBucketWeights() {
        return new ArrayList(this.zzd);
    }

    public int getDaysSinceExposureThreshold() {
        return this.zze;
    }

    public Map<Integer, Double> getInfectiousnessWeights() {
        HashMap map = new HashMap();
        for (int i = 0; i < this.zzb.size(); i++) {
            if (i != 0) {
                map.put(Integer.valueOf(i), (Double) this.zzb.get(i));
            }
        }
        return map;
    }

    public double getMinimumWindowScore() {
        return this.zzf;
    }

    public Map<Integer, Double> getReportTypeWeights() {
        HashMap map = new HashMap();
        for (int i = 0; i < this.zza.size(); i++) {
            if (i != 0 && i != 5) {
                map.put(Integer.valueOf(i), (Double) this.zza.get(i));
            }
        }
        return map;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, Integer.valueOf(this.zze), Double.valueOf(this.zzf));
    }

    public String toString() {
        return String.format(Locale.US, "DailySummariesConfig<reportTypeWeights: %s, infectiousnessWeights: %s, attenuationBucketThresholdDb: %s, attenuationBucketWeights: %sdaysSinceExposureThreshold: %d,minimumWindowScore: %.3f>", this.zza, this.zzb, this.zzc, this.zzd, Integer.valueOf(this.zze), Double.valueOf(this.zzf));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeDoubleList(parcel, 1, new ArrayList(this.zza), false);
        SafeParcelWriter.writeDoubleList(parcel, 2, new ArrayList(this.zzb), false);
        SafeParcelWriter.writeIntegerList(parcel, 3, getAttenuationBucketThresholdDb(), false);
        SafeParcelWriter.writeDoubleList(parcel, 4, getAttenuationBucketWeights(), false);
        SafeParcelWriter.writeInt(parcel, 5, getDaysSinceExposureThreshold());
        SafeParcelWriter.writeDouble(parcel, 6, getMinimumWindowScore());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}

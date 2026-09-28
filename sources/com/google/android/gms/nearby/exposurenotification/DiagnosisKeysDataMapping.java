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
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public class DiagnosisKeysDataMapping extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<DiagnosisKeysDataMapping> CREATOR = new zzd();
    final List zza;
    final int zzb;
    final int zzc;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
    public static final class DiagnosisKeysDataMappingBuilder {
        private List zza;
        private int zzb = 0;
        private Integer zzc;

        public DiagnosisKeysDataMapping build() {
            Preconditions.checkArgument(this.zza != null, "Must set daysSinceOnsetToInfectiousness");
            Preconditions.checkArgument(this.zzb != 0, "Must set reportTypeWhenMissing");
            Preconditions.checkArgument(this.zzc != null, "Must set infectiousnessWhenDaysSinceOnsetMissing");
            return new DiagnosisKeysDataMapping(this.zza, this.zzb, this.zzc.intValue());
        }

        public DiagnosisKeysDataMappingBuilder setDaysSinceOnsetToInfectiousness(Map<Integer, Integer> map) {
            Preconditions.checkArgument(map != null, "daysSinceOnsetToInfectiousness must not be null.");
            Preconditions.checkArgument(map.size() <= 29, "the size of daysSinceOnsetToInfectiousness exceeds maximum size %d.", 29);
            Integer[] numArr = new Integer[29];
            Arrays.fill((Object[]) numArr, (Object) 0);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                int iIntValue2 = entry.getValue().intValue();
                Preconditions.checkArgument(Math.abs(iIntValue) <= 14, "Invalid day since onset %d", Integer.valueOf(iIntValue));
                boolean z = zzj.zza(iIntValue2) != null;
                Integer numValueOf = Integer.valueOf(iIntValue2);
                Preconditions.checkArgument(z, "Invalid value of Infectiousness %d", numValueOf);
                numArr[iIntValue + 14] = numValueOf;
            }
            this.zza = Arrays.asList(numArr);
            return this;
        }

        public DiagnosisKeysDataMappingBuilder setInfectiousnessWhenDaysSinceOnsetMissing(int i) {
            zzj zzjVarZza = zzj.zza(i);
            Integer numValueOf = Integer.valueOf(i);
            Preconditions.checkArgument(zzjVarZza != null, "Invalid value of Infectiousness %d", numValueOf);
            this.zzc = numValueOf;
            return this;
        }

        public DiagnosisKeysDataMappingBuilder setReportTypeWhenMissing(int i) {
            Preconditions.checkArgument(i != 0, "Invalid reportTypeWhenMissing value");
            Preconditions.checkArgument(i >= 0 && i <= 5, "Invalid value of ReportType %d", Integer.valueOf(i));
            this.zzb = i;
            return this;
        }
    }

    DiagnosisKeysDataMapping(List list, int i, int i2) {
        this.zza = list;
        this.zzb = i;
        this.zzc = i2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DiagnosisKeysDataMapping) {
            DiagnosisKeysDataMapping diagnosisKeysDataMapping = (DiagnosisKeysDataMapping) obj;
            if (this.zza.equals(diagnosisKeysDataMapping.zza) && this.zzb == diagnosisKeysDataMapping.zzb && this.zzc == diagnosisKeysDataMapping.zzc) {
                return true;
            }
        }
        return false;
    }

    public Map<Integer, Integer> getDaysSinceOnsetToInfectiousness() {
        HashMap map = new HashMap((int) Math.ceil(38.666666666666664d));
        for (int i = 0; i < this.zza.size(); i++) {
            map.put(Integer.valueOf(i - 14), (Integer) this.zza.get(i));
        }
        return map;
    }

    public int getInfectiousnessWhenDaysSinceOnsetMissing() {
        return this.zzc;
    }

    public int getReportTypeWhenMissing() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(this.zzb), Integer.valueOf(this.zzc));
    }

    public String toString() {
        return String.format(Locale.US, "DiagnosisKeysDataMapping<daysSinceOnsetToInfectiousness: %s, reportTypeWhenMissing: %d, infectiousnessWhenDaysSinceOnsetMissing: %d>", getDaysSinceOnsetToInfectiousness(), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIntegerList(parcel, 1, new ArrayList(this.zza), false);
        SafeParcelWriter.writeInt(parcel, 2, getReportTypeWhenMissing());
        SafeParcelWriter.writeInt(parcel, 3, getInfectiousnessWhenDaysSinceOnsetMissing());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}

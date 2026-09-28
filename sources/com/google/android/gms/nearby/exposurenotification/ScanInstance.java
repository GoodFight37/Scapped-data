package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class ScanInstance extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ScanInstance> CREATOR = new zzo();
    final int zza;
    final int zzb;
    final int zzc;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
    public static class Builder {
        private int zza = 0;
        private int zzb = 0;
        private int zzc = 0;

        public ScanInstance build() {
            return new ScanInstance(this.zza, this.zzb, this.zzc);
        }

        public Builder setMinAttenuationDb(int i) {
            this.zzb = i;
            return this;
        }

        public Builder setSecondsSinceLastScan(int i) {
            this.zzc = i;
            return this;
        }

        public Builder setTypicalAttenuationDb(int i) {
            this.zza = i;
            return this;
        }
    }

    ScanInstance(int i, int i2, int i3) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ScanInstance scanInstance = (ScanInstance) obj;
            if (this.zza == scanInstance.zza && this.zzb == scanInstance.zzb && this.zzc == scanInstance.zzc) {
                return true;
            }
        }
        return false;
    }

    public int getMinAttenuationDb() {
        return this.zzb;
    }

    public int getSecondsSinceLastScan() {
        return this.zzc;
    }

    public int getTypicalAttenuationDb() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc));
    }

    public String toString() {
        return "ScanInstance{typicalAttenuationDb=" + this.zza + ", minAttenuationDb=" + this.zzb + ", secondsSinceLastScan=" + this.zzc + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getTypicalAttenuationDb());
        SafeParcelWriter.writeInt(parcel, 2, getMinAttenuationDb());
        SafeParcelWriter.writeInt(parcel, 3, getSecondsSinceLastScan());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}

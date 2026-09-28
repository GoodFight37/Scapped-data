package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzu> CREATOR = new zzv();
    private int zza;
    private int zzb;
    private int zzc;
    private boolean zzd;

    private zzu() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzu) {
            zzu zzuVar = (zzu) obj;
            if (Objects.equal(Integer.valueOf(this.zza), Integer.valueOf(zzuVar.zza)) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzuVar.zzb)) && Objects.equal(Integer.valueOf(this.zzc), Integer.valueOf(zzuVar.zzc)) && Objects.equal(Boolean.valueOf(this.zzd), Boolean.valueOf(zzuVar.zzd))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Boolean.valueOf(this.zzd));
    }

    public final String toString() {
        return "UwbRangingData{rawDistance=" + this.zza + ", rawAngleOfArrivalAzimuth=" + this.zzb + ", rawAngleOfArrivalPolar=" + this.zzc + ", isValidAngleOfArrivalData=" + this.zzd + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    zzu(int i, int i2, int i3, boolean z) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = z;
    }
}

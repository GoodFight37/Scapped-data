package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zznh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zznh> CREATOR = new zzni();
    public static final zznh zza = new zznh(1, "", null);
    final int zzb;
    private final String zzc;
    private final String zzd;

    zznh(int i, String str, String str2) {
        this.zzb = ((Integer) Preconditions.checkNotNull(Integer.valueOf(i))).intValue();
        this.zzc = str == null ? "" : str;
        this.zzd = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zznh)) {
            return false;
        }
        zznh zznhVar = (zznh) obj;
        return Objects.equal(this.zzc, zznhVar.zzc) && Objects.equal(this.zzd, zznhVar.zzd);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzc, this.zzd);
    }

    public final String toString() {
        return "NearbyDevice{handle=" + this.zzc + ", bluetoothAddress=" + this.zzd + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzd, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}

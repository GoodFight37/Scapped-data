package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzpu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzpu> CREATOR = new zzpv();
    private int zza;
    private float zzb;

    private zzpu() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzpu) {
            zzpu zzpuVar = (zzpu) obj;
            if (Objects.equal(Integer.valueOf(this.zza), Integer.valueOf(zzpuVar.zza)) && Objects.equal(Float.valueOf(this.zzb), Float.valueOf(zzpuVar.zzb))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Float.valueOf(this.zzb));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeFloat(parcel, 2, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final float zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zza;
    }

    zzpu(int i, float f) {
        this.zza = i;
        this.zzb = f;
    }
}

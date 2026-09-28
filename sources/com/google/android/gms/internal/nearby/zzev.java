package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzev extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzev> CREATOR = new zzew();
    private IStatusCallback zza;
    private ExposureConfiguration zzb;

    private zzev() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzev) {
            zzev zzevVar = (zzev) obj;
            if (Objects.equal(this.zza, zzevVar.zza) && Objects.equal(this.zzb, zzevVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 3, this.zza.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzb, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    zzev(IBinder iBinder, ExposureConfiguration exposureConfiguration) {
        this.zza = IStatusCallback.Stub.asInterface(iBinder);
        this.zzb = exposureConfiguration;
    }

    /* synthetic */ zzev(zzeu zzeuVar) {
    }
}

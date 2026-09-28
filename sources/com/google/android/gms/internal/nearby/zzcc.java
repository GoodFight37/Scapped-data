package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzcc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcc> CREATOR = new zzcd();
    private zzdp zza;

    private zzcc() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzcc) {
            return Objects.equal(this.zza, ((zzcc) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 1, this.zza.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    zzcc(IBinder iBinder) {
        zzdp zzdnVar;
        if (iBinder == null) {
            zzdnVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.ILongCallback");
            zzdnVar = iInterfaceQueryLocalInterface instanceof zzdp ? (zzdp) iInterfaceQueryLocalInterface : new zzdn(iBinder);
        }
        this.zza = zzdnVar;
    }

    /* synthetic */ zzcc(zzcb zzcbVar) {
    }
}

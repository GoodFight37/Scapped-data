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
public final class zzoj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzoj> CREATOR = new zzok();
    private zzpe zza;

    private zzoj() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzoj) {
            return Objects.equal(this.zza, ((zzoj) obj).zza);
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

    zzoj(IBinder iBinder) {
        zzpe zzpcVar;
        if (iBinder == null) {
            zzpcVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.uwb.internal.IUwbAddressResultListener");
            zzpcVar = iInterfaceQueryLocalInterface instanceof zzpe ? (zzpe) iInterfaceQueryLocalInterface : new zzpc(iBinder);
        }
        this.zza = zzpcVar;
    }

    /* synthetic */ zzoj(zzoi zzoiVar) {
    }
}

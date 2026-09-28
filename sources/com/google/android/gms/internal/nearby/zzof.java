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
public final class zzof extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzof> CREATOR = new zzog();
    private zzph zza;

    private zzof() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzof) {
            return Objects.equal(this.zza, ((zzof) obj).zza);
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

    zzof(IBinder iBinder) {
        zzph zzpfVar;
        if (iBinder == null) {
            zzpfVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.uwb.internal.IUwbComplexChannelResultListener");
            zzpfVar = iInterfaceQueryLocalInterface instanceof zzph ? (zzph) iInterfaceQueryLocalInterface : new zzpf(iBinder);
        }
        this.zza = zzpfVar;
    }

    /* synthetic */ zzof(zzoe zzoeVar) {
    }
}

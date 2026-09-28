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
public final class zzon extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzon> CREATOR = new zzoo();
    private zzov zza;

    private zzon() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzon) {
            return Objects.equal(this.zza, ((zzon) obj).zza);
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

    zzon(IBinder iBinder) {
        zzov zzotVar;
        if (iBinder == null) {
            zzotVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.uwb.internal.IRangingCapabilitiesResultListener");
            zzotVar = iInterfaceQueryLocalInterface instanceof zzov ? (zzov) iInterfaceQueryLocalInterface : new zzot(iBinder);
        }
        this.zza = zzotVar;
    }

    /* synthetic */ zzon(zzom zzomVar) {
    }
}

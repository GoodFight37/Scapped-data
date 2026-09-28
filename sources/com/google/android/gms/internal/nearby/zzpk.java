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
public final class zzpk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzpk> CREATOR = new zzpl();
    private zzor zza;

    private zzpk() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzpk) {
            return Objects.equal(this.zza, ((zzpk) obj).zza);
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

    zzpk(IBinder iBinder) {
        zzor zzopVar;
        if (iBinder == null) {
            zzopVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.uwb.internal.IBooleanResultListener");
            zzopVar = iInterfaceQueryLocalInterface instanceof zzor ? (zzor) iInterfaceQueryLocalInterface : new zzop(iBinder);
        }
        this.zza = zzopVar;
    }

    /* synthetic */ zzpk(zzpj zzpjVar) {
    }
}

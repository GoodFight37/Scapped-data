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
public final class zzqe extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzqe> CREATOR = new zzqf();
    private zzpb zza;
    private zzqq zzb;

    private zzqe() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzqe) {
            zzqe zzqeVar = (zzqe) obj;
            if (Objects.equal(this.zza, zzqeVar.zza) && Objects.equal(this.zzb, zzqeVar.zzb)) {
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
        zzpb zzpbVar = this.zza;
        SafeParcelWriter.writeIBinder(parcel, 1, zzpbVar == null ? null : zzpbVar.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    zzqe(IBinder iBinder, zzqq zzqqVar) {
        zzpb zzozVar;
        if (iBinder == null) {
            zzozVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.uwb.internal.IResultListener");
            zzozVar = iInterfaceQueryLocalInterface instanceof zzpb ? (zzpb) iInterfaceQueryLocalInterface : new zzoz(iBinder);
        }
        this.zza = zzozVar;
        this.zzb = zzqqVar;
    }

    /* synthetic */ zzqe(zzqd zzqdVar) {
    }
}

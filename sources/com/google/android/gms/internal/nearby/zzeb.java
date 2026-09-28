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
public final class zzeb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzeb> CREATOR = new zzec();
    private zzco zza;
    private zzcp zzb;

    private zzeb() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzeb) {
            zzeb zzebVar = (zzeb) obj;
            if (Objects.equal(this.zzb, zzebVar.zzb) && Objects.equal(this.zza, zzebVar.zza)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzb, this.zza);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzcp zzcpVar = this.zzb;
        SafeParcelWriter.writeIBinder(parcel, 1, zzcpVar == null ? null : zzcpVar.asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zza.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    zzeb(IBinder iBinder, IBinder iBinder2) {
        zzcp zzcpVar;
        zzco zzcmVar = null;
        if (iBinder == null) {
            zzcpVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IBooleanResultListener");
            zzcpVar = iInterfaceQueryLocalInterface instanceof zzcp ? (zzcp) iInterfaceQueryLocalInterface : new zzcp(iBinder);
        }
        if (iBinder2 != null) {
            IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IBooleanCallback");
            zzcmVar = iInterfaceQueryLocalInterface2 instanceof zzco ? (zzco) iInterfaceQueryLocalInterface2 : new zzcm(iBinder2);
        }
        this.zzb = zzcpVar;
        this.zza = zzcmVar;
    }

    /* synthetic */ zzeb(zzea zzeaVar) {
    }
}

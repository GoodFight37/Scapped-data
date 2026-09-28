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
public final class zzbu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbu> CREATOR = new zzbv();
    private zzdj zza;
    private String zzb;

    private zzbu() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzbu) {
            zzbu zzbuVar = (zzbu) obj;
            if (Objects.equal(this.zza, zzbuVar.zza) && Objects.equal(this.zzb, zzbuVar.zzb)) {
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
        SafeParcelWriter.writeIBinder(parcel, 1, this.zza.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    zzbu(IBinder iBinder, String str) {
        zzdj zzdhVar;
        if (iBinder == null) {
            zzdhVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IExposureWindowListCallback");
            zzdhVar = iInterfaceQueryLocalInterface instanceof zzdj ? (zzdj) iInterfaceQueryLocalInterface : new zzdh(iBinder);
        }
        this.zza = zzdhVar;
        this.zzb = str;
    }

    /* synthetic */ zzbu(zzbt zzbtVar) {
    }
}

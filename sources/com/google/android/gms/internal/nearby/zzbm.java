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
public final class zzbm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbm> CREATOR = new zzbn();
    private zzdb zza;
    private String zzb;
    private zzdc zzc;

    private zzbm() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzbm) {
            zzbm zzbmVar = (zzbm) obj;
            if (Objects.equal(this.zzc, zzbmVar.zzc) && Objects.equal(this.zza, zzbmVar.zza) && Objects.equal(this.zzb, zzbmVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzc, this.zza, this.zzb);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzdc zzdcVar = this.zzc;
        SafeParcelWriter.writeIBinder(parcel, 1, zzdcVar == null ? null : zzdcVar.asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zza.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    zzbm(IBinder iBinder, IBinder iBinder2, String str) {
        zzdc zzdcVar;
        zzdb zzczVar = null;
        if (iBinder == null) {
            zzdcVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IExposureInformationResultListener");
            zzdcVar = iInterfaceQueryLocalInterface instanceof zzdc ? (zzdc) iInterfaceQueryLocalInterface : new zzdc(iBinder);
        }
        if (iBinder2 != null) {
            IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IExposureInformationListCallback");
            zzczVar = iInterfaceQueryLocalInterface2 instanceof zzdb ? (zzdb) iInterfaceQueryLocalInterface2 : new zzcz(iBinder2);
        }
        this.zzc = zzdcVar;
        this.zza = zzczVar;
        this.zzb = str;
    }

    /* synthetic */ zzbm(zzbl zzblVar) {
    }
}

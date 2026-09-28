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
public final class zzbq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbq> CREATOR = new zzbr();
    private zzdf zza;
    private String zzb;
    private zzdg zzc;

    private zzbq() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzbq) {
            zzbq zzbqVar = (zzbq) obj;
            if (Objects.equal(this.zzc, zzbqVar.zzc) && Objects.equal(this.zza, zzbqVar.zza) && Objects.equal(this.zzb, zzbqVar.zzb)) {
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
        zzdg zzdgVar = this.zzc;
        SafeParcelWriter.writeIBinder(parcel, 1, zzdgVar == null ? null : zzdgVar.asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zza.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    zzbq(IBinder iBinder, IBinder iBinder2, String str) {
        zzdg zzdgVar;
        zzdf zzddVar = null;
        if (iBinder == null) {
            zzdgVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IExposureSummaryResultListener");
            zzdgVar = iInterfaceQueryLocalInterface instanceof zzdg ? (zzdg) iInterfaceQueryLocalInterface : new zzdg(iBinder);
        }
        if (iBinder2 != null) {
            IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IExposureSummaryCallback");
            zzddVar = iInterfaceQueryLocalInterface2 instanceof zzdf ? (zzdf) iInterfaceQueryLocalInterface2 : new zzdd(iBinder2);
        }
        this.zzc = zzdgVar;
        this.zza = zzddVar;
        this.zzb = str;
    }

    /* synthetic */ zzbq(zzbp zzbpVar) {
    }
}

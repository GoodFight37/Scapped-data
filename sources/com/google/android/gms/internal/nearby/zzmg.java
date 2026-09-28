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
public final class zzmg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzmg> CREATOR = new zzmh();
    private zzkj zza;
    private String zzb;
    private final int zzc;
    private zznv zzd;
    private com.google.android.gms.nearby.connection.zzk zze;

    private zzmg() {
        this.zzc = 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzmg) {
            zzmg zzmgVar = (zzmg) obj;
            if (Objects.equal(this.zza, zzmgVar.zza) && Objects.equal(this.zzb, zzmgVar.zzb) && Objects.equal(Integer.valueOf(this.zzc), Integer.valueOf(zzmgVar.zzc)) && Objects.equal(this.zzd, zzmgVar.zzd) && Objects.equal(this.zze, zzmgVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Integer.valueOf(this.zzc), this.zzd, this.zze);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzkj zzkjVar = this.zza;
        SafeParcelWriter.writeIBinder(parcel, 1, zzkjVar == null ? null : zzkjVar.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    zzmg(IBinder iBinder, String str, int i, zznv zznvVar, com.google.android.gms.nearby.connection.zzk zzkVar) {
        zzkj zzkhVar;
        if (iBinder == null) {
            zzkhVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            zzkhVar = iInterfaceQueryLocalInterface instanceof zzkj ? (zzkj) iInterfaceQueryLocalInterface : new zzkh(iBinder);
        }
        this.zza = zzkhVar;
        this.zzb = str;
        this.zzc = i;
        this.zzd = zznvVar;
        this.zze = zzkVar;
    }
}

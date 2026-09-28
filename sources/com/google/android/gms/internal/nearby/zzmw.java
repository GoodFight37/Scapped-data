package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.connection.DiscoveryOptions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzmw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzmw> CREATOR = new zzmx();
    private zzkj zza;
    private String zzb;
    private long zzc;
    private DiscoveryOptions zzd;
    private zzkc zze;
    private zzjz zzf;

    private zzmw() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzmw) {
            zzmw zzmwVar = (zzmw) obj;
            if (Objects.equal(this.zza, zzmwVar.zza) && Objects.equal(this.zzf, zzmwVar.zzf) && Objects.equal(this.zzb, zzmwVar.zzb) && Objects.equal(Long.valueOf(this.zzc), Long.valueOf(zzmwVar.zzc)) && Objects.equal(this.zzd, zzmwVar.zzd) && Objects.equal(this.zze, zzmwVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzf, this.zzb, Long.valueOf(this.zzc), this.zzd, this.zze);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzkj zzkjVar = this.zza;
        SafeParcelWriter.writeIBinder(parcel, 1, zzkjVar == null ? null : zzkjVar.asBinder(), false);
        zzjz zzjzVar = this.zzf;
        SafeParcelWriter.writeIBinder(parcel, 2, zzjzVar == null ? null : zzjzVar.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeLong(parcel, 4, this.zzc);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzd, i, false);
        zzkc zzkcVar = this.zze;
        SafeParcelWriter.writeIBinder(parcel, 6, zzkcVar != null ? zzkcVar.asBinder() : null, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    zzmw(IBinder iBinder, IBinder iBinder2, String str, long j, DiscoveryOptions discoveryOptions, IBinder iBinder3) {
        zzkj zzkhVar;
        zzjz zzjzVar;
        zzkc zzkaVar = null;
        if (iBinder == null) {
            zzkhVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            zzkhVar = iInterfaceQueryLocalInterface instanceof zzkj ? (zzkj) iInterfaceQueryLocalInterface : new zzkh(iBinder);
        }
        if (iBinder2 == null) {
            zzjzVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IDiscoveryCallback");
            zzjzVar = iInterfaceQueryLocalInterface2 instanceof zzjz ? (zzjz) iInterfaceQueryLocalInterface2 : new zzjz(iBinder2);
        }
        if (iBinder3 != null) {
            IInterface iInterfaceQueryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IDiscoveryListener");
            zzkaVar = iInterfaceQueryLocalInterface3 instanceof zzkc ? (zzkc) iInterfaceQueryLocalInterface3 : new zzka(iBinder3);
        }
        this.zza = zzkhVar;
        this.zzf = zzjzVar;
        this.zzb = str;
        this.zzc = j;
        this.zzd = discoveryOptions;
        this.zze = zzkaVar;
    }

    /* synthetic */ zzmw(zzmv zzmvVar) {
    }
}

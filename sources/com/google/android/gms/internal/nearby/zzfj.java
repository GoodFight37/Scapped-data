package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzfj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfj> CREATOR = new zzfk();
    private zzkj zza;
    private zzjs zzb;
    private String zzc;
    private byte[] zzd;
    private zzkg zze;
    private final int zzf;
    private zznv zzg;
    private com.google.android.gms.nearby.connection.zzk zzh;

    private zzfj() {
        this.zzf = 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzfj) {
            zzfj zzfjVar = (zzfj) obj;
            if (Objects.equal(this.zza, zzfjVar.zza) && Objects.equal(this.zzb, zzfjVar.zzb) && Objects.equal(this.zzc, zzfjVar.zzc) && Arrays.equals(this.zzd, zzfjVar.zzd) && Objects.equal(this.zze, zzfjVar.zze) && Objects.equal(Integer.valueOf(this.zzf), Integer.valueOf(zzfjVar.zzf)) && Objects.equal(this.zzg, zzfjVar.zzg) && Objects.equal(this.zzh, zzfjVar.zzh)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, Integer.valueOf(Arrays.hashCode(this.zzd)), this.zze, Integer.valueOf(this.zzf), this.zzg, this.zzh);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzkj zzkjVar = this.zza;
        SafeParcelWriter.writeIBinder(parcel, 1, zzkjVar == null ? null : zzkjVar.asBinder(), false);
        zzjs zzjsVar = this.zzb;
        SafeParcelWriter.writeIBinder(parcel, 2, zzjsVar == null ? null : zzjsVar.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeByteArray(parcel, 4, this.zzd, false);
        zzkg zzkgVar = this.zze;
        SafeParcelWriter.writeIBinder(parcel, 5, zzkgVar != null ? zzkgVar.asBinder() : null, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzf);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzh, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    zzfj(IBinder iBinder, IBinder iBinder2, String str, byte[] bArr, IBinder iBinder3, int i, zznv zznvVar, com.google.android.gms.nearby.connection.zzk zzkVar) {
        zzkj zzkhVar;
        zzjs zzjqVar;
        zzkg zzkeVar = null;
        if (iBinder == null) {
            zzkhVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            zzkhVar = iInterfaceQueryLocalInterface instanceof zzkj ? (zzkj) iInterfaceQueryLocalInterface : new zzkh(iBinder);
        }
        if (iBinder2 == null) {
            zzjqVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionEventListener");
            zzjqVar = iInterfaceQueryLocalInterface2 instanceof zzjs ? (zzjs) iInterfaceQueryLocalInterface2 : new zzjq(iBinder2);
        }
        if (iBinder3 != null) {
            IInterface iInterfaceQueryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IPayloadListener");
            zzkeVar = iInterfaceQueryLocalInterface3 instanceof zzkg ? (zzkg) iInterfaceQueryLocalInterface3 : new zzke(iBinder3);
        }
        this.zza = zzkhVar;
        this.zzb = zzjqVar;
        this.zzc = str;
        this.zzd = bArr;
        this.zze = zzkeVar;
        this.zzf = i;
        this.zzg = zznvVar;
        this.zzh = zzkVar;
    }
}

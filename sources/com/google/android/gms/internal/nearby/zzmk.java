package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.connection.ConnectionOptions;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzmk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzmk> CREATOR = new zzml();
    private zzkj zza;
    private zzjs zzb;
    private zzjy zzc;
    private String zzd;
    private String zze;
    private byte[] zzf;
    private zzjv zzg;
    private byte[] zzh;
    private ConnectionOptions zzi;
    private final int zzj;
    private zznv zzk;
    private com.google.android.gms.nearby.connection.zzk zzl;
    private byte[] zzm;
    private String zzn;

    private zzmk() {
        this.zzj = 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzmk) {
            zzmk zzmkVar = (zzmk) obj;
            if (Objects.equal(this.zza, zzmkVar.zza) && Objects.equal(this.zzb, zzmkVar.zzb) && Objects.equal(this.zzc, zzmkVar.zzc) && Objects.equal(this.zzd, zzmkVar.zzd) && Objects.equal(this.zze, zzmkVar.zze) && Arrays.equals(this.zzf, zzmkVar.zzf) && Objects.equal(this.zzg, zzmkVar.zzg) && Arrays.equals(this.zzh, zzmkVar.zzh) && Objects.equal(this.zzi, zzmkVar.zzi) && Objects.equal(Integer.valueOf(this.zzj), Integer.valueOf(zzmkVar.zzj)) && Objects.equal(this.zzk, zzmkVar.zzk) && Objects.equal(this.zzl, zzmkVar.zzl) && Arrays.equals(this.zzm, zzmkVar.zzm) && Objects.equal(this.zzn, zzmkVar.zzn)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, this.zze, Integer.valueOf(Arrays.hashCode(this.zzf)), this.zzg, Integer.valueOf(Arrays.hashCode(this.zzh)), this.zzi, Integer.valueOf(this.zzj), this.zzk, this.zzl, Integer.valueOf(Arrays.hashCode(this.zzm)), this.zzn);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzkj zzkjVar = this.zza;
        SafeParcelWriter.writeIBinder(parcel, 1, zzkjVar == null ? null : zzkjVar.asBinder(), false);
        zzjs zzjsVar = this.zzb;
        SafeParcelWriter.writeIBinder(parcel, 2, zzjsVar == null ? null : zzjsVar.asBinder(), false);
        zzjy zzjyVar = this.zzc;
        SafeParcelWriter.writeIBinder(parcel, 3, zzjyVar == null ? null : zzjyVar.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeByteArray(parcel, 6, this.zzf, false);
        zzjv zzjvVar = this.zzg;
        SafeParcelWriter.writeIBinder(parcel, 7, zzjvVar != null ? zzjvVar.asBinder() : null, false);
        SafeParcelWriter.writeByteArray(parcel, 8, this.zzh, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzi, i, false);
        SafeParcelWriter.writeInt(parcel, 10, this.zzj);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzk, i, false);
        SafeParcelWriter.writeByteArray(parcel, 12, this.zzm, false);
        SafeParcelWriter.writeString(parcel, 13, this.zzn, false);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzl, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    zzmk(IBinder iBinder, IBinder iBinder2, IBinder iBinder3, String str, String str2, byte[] bArr, IBinder iBinder4, byte[] bArr2, ConnectionOptions connectionOptions, int i, zznv zznvVar, com.google.android.gms.nearby.connection.zzk zzkVar, byte[] bArr3, String str3) {
        zzkj zzkhVar;
        zzjs zzjqVar;
        zzjy zzjwVar;
        zzjv zzjtVar = null;
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
        if (iBinder3 == null) {
            zzjwVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionResponseListener");
            zzjwVar = iInterfaceQueryLocalInterface3 instanceof zzjy ? (zzjy) iInterfaceQueryLocalInterface3 : new zzjw(iBinder3);
        }
        if (iBinder4 != null) {
            IInterface iInterfaceQueryLocalInterface4 = iBinder4.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener");
            zzjtVar = iInterfaceQueryLocalInterface4 instanceof zzjv ? (zzjv) iInterfaceQueryLocalInterface4 : new zzjt(iBinder4);
        }
        this.zza = zzkhVar;
        this.zzb = zzjqVar;
        this.zzc = zzjwVar;
        this.zzd = str;
        this.zze = str2;
        this.zzf = bArr;
        this.zzg = zzjtVar;
        this.zzh = bArr2;
        this.zzi = connectionOptions;
        this.zzj = i;
        this.zzk = zznvVar;
        this.zzl = zzkVar;
        this.zzm = bArr3;
        this.zzn = str3;
    }
}

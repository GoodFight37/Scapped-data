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
public final class zzmo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzmo> CREATOR = new zzmp();
    private zzkj zza;
    private String[] zzb;
    private zzmb zzc;
    private boolean zzd;
    private final int zze;
    private zznv zzf;
    private com.google.android.gms.nearby.connection.zzk zzg;

    private zzmo() {
        this.zze = 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzmo) {
            zzmo zzmoVar = (zzmo) obj;
            if (Objects.equal(this.zza, zzmoVar.zza) && Arrays.equals(this.zzb, zzmoVar.zzb) && Objects.equal(this.zzc, zzmoVar.zzc) && Objects.equal(Boolean.valueOf(this.zzd), Boolean.valueOf(zzmoVar.zzd)) && Objects.equal(Integer.valueOf(this.zze), Integer.valueOf(zzmoVar.zze)) && Objects.equal(this.zzf, zzmoVar.zzf) && Objects.equal(this.zzg, zzmoVar.zzg)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(Arrays.hashCode(this.zzb)), this.zzc, Boolean.valueOf(this.zzd), Integer.valueOf(this.zze), this.zzf, this.zzg);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzkj zzkjVar = this.zza;
        SafeParcelWriter.writeIBinder(parcel, 1, zzkjVar == null ? null : zzkjVar.asBinder(), false);
        SafeParcelWriter.writeStringArray(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    zzmo(IBinder iBinder, String[] strArr, zzmb zzmbVar, boolean z, int i, zznv zznvVar, com.google.android.gms.nearby.connection.zzk zzkVar) {
        zzkj zzkhVar;
        if (iBinder == null) {
            zzkhVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            zzkhVar = iInterfaceQueryLocalInterface instanceof zzkj ? (zzkj) iInterfaceQueryLocalInterface : new zzkh(iBinder);
        }
        this.zza = zzkhVar;
        this.zzb = strArr;
        this.zzc = zzmbVar;
        this.zzd = z;
        this.zze = i;
        this.zzf = zznvVar;
        this.zzg = zzkVar;
    }
}

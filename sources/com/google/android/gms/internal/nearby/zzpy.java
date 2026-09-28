package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzpy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzpy> CREATOR = new zzpz();
    private int zza;
    private int zzb;
    private byte[] zzc;
    private zzqv zzd;
    private int zze;
    private zzrv[] zzf;
    private int zzg;
    private byte[] zzh;

    private zzpy() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzpy) {
            zzpy zzpyVar = (zzpy) obj;
            if (Objects.equal(Integer.valueOf(this.zza), Integer.valueOf(zzpyVar.zza)) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzpyVar.zzb)) && Arrays.equals(this.zzc, zzpyVar.zzc) && Objects.equal(this.zzd, zzpyVar.zzd) && Objects.equal(Integer.valueOf(this.zze), Integer.valueOf(zzpyVar.zze)) && Arrays.equals(this.zzf, zzpyVar.zzf) && Objects.equal(Integer.valueOf(this.zzg), Integer.valueOf(zzpyVar.zzg)) && Arrays.equals(this.zzh, zzpyVar.zzh)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(Arrays.hashCode(this.zzc)), this.zzd, Integer.valueOf(this.zze), Integer.valueOf(Arrays.hashCode(this.zzf)), Integer.valueOf(this.zzg), Integer.valueOf(Arrays.hashCode(this.zzh)));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeTypedArray(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.writeInt(parcel, 7, this.zzg);
        SafeParcelWriter.writeByteArray(parcel, 8, this.zzh, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    zzpy(int i, int i2, byte[] bArr, zzqv zzqvVar, int i3, zzrv[] zzrvVarArr, int i4, byte[] bArr2) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = bArr;
        this.zzd = zzqvVar;
        this.zze = i3;
        this.zzf = zzrvVarArr;
        this.zzg = i4;
        this.zzh = bArr2;
    }

    /* synthetic */ zzpy(zzpx zzpxVar) {
    }
}

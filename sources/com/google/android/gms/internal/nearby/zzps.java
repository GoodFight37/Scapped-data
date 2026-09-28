package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzps extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzps> CREATOR = new zzpt();
    private boolean zza;
    private boolean zzb;
    private boolean zzc;
    private int zzd;
    private int zze;
    private int[] zzf;
    private int[] zzg;
    private float zzh;

    private zzps() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzps) {
            zzps zzpsVar = (zzps) obj;
            if (Objects.equal(Boolean.valueOf(this.zza), Boolean.valueOf(zzpsVar.zza)) && Objects.equal(Boolean.valueOf(this.zzb), Boolean.valueOf(zzpsVar.zzb)) && Objects.equal(Boolean.valueOf(this.zzc), Boolean.valueOf(zzpsVar.zzc)) && Objects.equal(Integer.valueOf(this.zzd), Integer.valueOf(zzpsVar.zzd)) && Objects.equal(Integer.valueOf(this.zze), Integer.valueOf(zzpsVar.zze)) && Arrays.equals(this.zzf, zzpsVar.zzf) && Arrays.equals(this.zzg, zzpsVar.zzg) && Objects.equal(Float.valueOf(this.zzh), Float.valueOf(zzpsVar.zzh))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.zza), Boolean.valueOf(this.zzb), Boolean.valueOf(this.zzc), Integer.valueOf(this.zzd), Integer.valueOf(this.zze), Integer.valueOf(Arrays.hashCode(this.zzf)), Integer.valueOf(Arrays.hashCode(this.zzg)), Float.valueOf(this.zzh));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zza);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzb);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeIntArray(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeIntArray(parcel, 7, this.zzg, false);
        SafeParcelWriter.writeFloat(parcel, 8, this.zzh);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final float zza() {
        return this.zzh;
    }

    public final int zzb() {
        return this.zze;
    }

    public final boolean zzc() {
        return this.zzb;
    }

    public final boolean zzd() {
        return this.zza;
    }

    public final boolean zze() {
        return this.zzc;
    }

    public final int[] zzf() {
        return this.zzf;
    }

    zzps(boolean z, boolean z2, boolean z3, int i, int i2, int[] iArr, int[] iArr2, float f) {
        this.zza = z;
        this.zzb = z2;
        this.zzc = z3;
        this.zzd = i;
        this.zze = i2;
        this.zzf = iArr;
        this.zzg = iArr2;
        this.zzh = f;
    }
}

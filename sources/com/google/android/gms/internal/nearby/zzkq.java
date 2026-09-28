package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzkq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzkq> CREATOR = new zzkr();
    private String zza;
    private int zzb;
    private final int zzc;
    private final int zzd;
    private zznv zze;
    private com.google.android.gms.nearby.connection.zzk zzf;

    private zzkq() {
        this.zzc = 0;
        this.zzd = 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzkq) {
            zzkq zzkqVar = (zzkq) obj;
            if (Objects.equal(this.zza, zzkqVar.zza) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzkqVar.zzb)) && Objects.equal(Integer.valueOf(this.zzc), Integer.valueOf(zzkqVar.zzc)) && Objects.equal(Integer.valueOf(this.zzd), Integer.valueOf(zzkqVar.zzd)) && Objects.equal(this.zze, zzkqVar.zze) && Objects.equal(this.zzf, zzkqVar.zzf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), this.zze, this.zzf);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final int zza() {
        return this.zzc;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zza;
    }

    zzkq(String str, int i, int i2, int i3, zznv zznvVar, com.google.android.gms.nearby.connection.zzk zzkVar) {
        this.zza = str;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = zznvVar;
        this.zzf = zzkVar;
    }
}

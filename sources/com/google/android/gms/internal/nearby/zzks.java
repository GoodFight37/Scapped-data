package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzks extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzks> CREATOR = new zzkt();
    private String zza;
    private String zzb;
    private String zzc;
    private boolean zzd;
    private byte[] zze;
    private byte[] zzf;
    private byte[] zzg;
    private boolean zzh;
    private final int zzi;
    private zznv zzj;
    private com.google.android.gms.nearby.connection.zzk zzk;

    private zzks() {
        this.zzi = 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzks) {
            zzks zzksVar = (zzks) obj;
            if (Objects.equal(this.zza, zzksVar.zza) && Objects.equal(this.zzb, zzksVar.zzb) && Objects.equal(this.zzc, zzksVar.zzc) && Objects.equal(Boolean.valueOf(this.zzd), Boolean.valueOf(zzksVar.zzd)) && Arrays.equals(this.zze, zzksVar.zze) && Arrays.equals(this.zzf, zzksVar.zzf) && Arrays.equals(this.zzg, zzksVar.zzg) && Objects.equal(Boolean.valueOf(this.zzh), Boolean.valueOf(zzksVar.zzh)) && Objects.equal(Integer.valueOf(this.zzi), Integer.valueOf(zzksVar.zzi)) && Objects.equal(this.zzj, zzksVar.zzj) && Objects.equal(this.zzk, zzksVar.zzk)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, Boolean.valueOf(this.zzd), Integer.valueOf(Arrays.hashCode(this.zze)), Integer.valueOf(Arrays.hashCode(this.zzf)), Integer.valueOf(Arrays.hashCode(this.zzg)), Boolean.valueOf(this.zzh), Integer.valueOf(this.zzi), this.zzj, this.zzk);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeByteArray(parcel, 5, this.zze, false);
        SafeParcelWriter.writeByteArray(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeByteArray(parcel, 7, this.zzg, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzh);
        SafeParcelWriter.writeInt(parcel, 9, this.zzi);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzj, i, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzk, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final String zza() {
        return this.zzc;
    }

    public final String zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final boolean zzd() {
        return this.zzh;
    }

    public final boolean zze() {
        return this.zzd;
    }

    public final byte[] zzf() {
        return this.zzf;
    }

    public final byte[] zzg() {
        return this.zzg;
    }

    zzks(String str, String str2, String str3, boolean z, byte[] bArr, byte[] bArr2, byte[] bArr3, boolean z2, int i, zznv zznvVar, com.google.android.gms.nearby.connection.zzk zzkVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = z;
        this.zze = bArr;
        this.zzf = bArr2;
        this.zzg = bArr3;
        this.zzh = z2;
        this.zzi = i;
        this.zzj = zznvVar;
        this.zzk = zzkVar;
    }
}

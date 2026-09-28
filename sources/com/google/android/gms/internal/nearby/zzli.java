package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzli extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzli> CREATOR = new zzlj();
    private String zza;
    private zzmb zzb;
    private boolean zzc;
    private final int zzd;
    private zznv zze;
    private com.google.android.gms.nearby.connection.zzk zzf;

    private zzli() {
        this.zzd = 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzli) {
            zzli zzliVar = (zzli) obj;
            if (Objects.equal(this.zza, zzliVar.zza) && Objects.equal(this.zzb, zzliVar.zzb) && Objects.equal(Boolean.valueOf(this.zzc), Boolean.valueOf(zzliVar.zzc)) && Objects.equal(Integer.valueOf(this.zzd), Integer.valueOf(zzliVar.zzd)) && Objects.equal(this.zze, zzliVar.zze) && Objects.equal(this.zzf, zzliVar.zzf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Boolean.valueOf(this.zzc), Integer.valueOf(this.zzd), this.zze, this.zzf);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final zzmb zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }

    public final boolean zzc() {
        return this.zzc;
    }

    zzli(String str, zzmb zzmbVar, boolean z, int i, zznv zznvVar, com.google.android.gms.nearby.connection.zzk zzkVar) {
        this.zza = str;
        this.zzb = zzmbVar;
        this.zzc = z;
        this.zzd = i;
        this.zze = zznvVar;
        this.zzf = zzkVar;
    }
}

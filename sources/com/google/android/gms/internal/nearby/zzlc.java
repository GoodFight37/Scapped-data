package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzlc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzlc> CREATOR = new zzld();
    private String zza;
    private int zzb;
    private com.google.android.gms.nearby.connection.zzu zzc;
    private final int zzd;
    private com.google.android.gms.nearby.connection.zzk zze;

    private zzlc() {
        this.zzd = 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzlc) {
            zzlc zzlcVar = (zzlc) obj;
            if (Objects.equal(this.zza, zzlcVar.zza) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzlcVar.zzb)) && Objects.equal(this.zzc, zzlcVar.zzc) && Objects.equal(Integer.valueOf(this.zzd), Integer.valueOf(zzlcVar.zzd)) && Objects.equal(this.zze, zzlcVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(this.zzb), this.zzc, Integer.valueOf(this.zzd), this.zze);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final int zza() {
        return this.zzb;
    }

    public final com.google.android.gms.nearby.connection.zzu zzb() {
        return this.zzc;
    }

    public final String zzc() {
        return this.zza;
    }

    zzlc(String str, int i, com.google.android.gms.nearby.connection.zzu zzuVar, int i2, com.google.android.gms.nearby.connection.zzk zzkVar) {
        this.zza = str;
        this.zzb = i;
        this.zzc = zzuVar;
        this.zzd = i2;
        this.zze = zzkVar;
    }
}

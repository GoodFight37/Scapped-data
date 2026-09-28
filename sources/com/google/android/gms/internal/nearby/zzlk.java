package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzlk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzlk> CREATOR = new zzll();
    private String zza;
    private PayloadTransferUpdate zzb;
    private final int zzc;
    private zznv zzd;
    private com.google.android.gms.nearby.connection.zzk zze;

    private zzlk() {
        this.zzc = 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzlk) {
            zzlk zzlkVar = (zzlk) obj;
            if (Objects.equal(this.zza, zzlkVar.zza) && Objects.equal(this.zzb, zzlkVar.zzb) && Objects.equal(Integer.valueOf(this.zzc), Integer.valueOf(zzlkVar.zzc)) && Objects.equal(this.zzd, zzlkVar.zzd) && Objects.equal(this.zze, zzlkVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Integer.valueOf(this.zzc), this.zzd, this.zze);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final PayloadTransferUpdate zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }

    zzlk(String str, PayloadTransferUpdate payloadTransferUpdate, int i, zznv zznvVar, com.google.android.gms.nearby.connection.zzk zzkVar) {
        this.zza = str;
        this.zzb = payloadTransferUpdate;
        this.zzc = i;
        this.zzd = zznvVar;
        this.zze = zzkVar;
    }
}

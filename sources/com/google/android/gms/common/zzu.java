package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzu> CREATOR = new zzv();
    private final boolean zza;

    @Nullable
    private final String zzb;
    private final int zzc;
    private final int zzd;
    private final long zze;

    @Nullable
    private final zzu zzf;

    zzu(boolean z, String str, int i, int i2, long j, zzu zzuVar) {
        this.zza = z;
        this.zzb = str;
        this.zzc = zzae.zza(i) - 1;
        this.zzd = zze.zza(i2) - 1;
        this.zze = j;
        this.zzf = zzuVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zza);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeLong(parcel, 5, this.zze);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final long zza() {
        return this.zze;
    }

    @Nullable
    public final zzu zzb() {
        return this.zzf;
    }

    @Nullable
    public final String zzc() {
        return this.zzb;
    }

    public final boolean zzd() {
        return this.zza;
    }

    public final int zze() {
        return zze.zza(this.zzd);
    }

    public final int zzf() {
        return zzae.zza(this.zzc);
    }
}

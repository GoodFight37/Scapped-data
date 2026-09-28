package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class Contents extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Contents> CREATOR = new zza();
    final ParcelFileDescriptor zza;
    final int zzb;
    final int zzc;
    final DriveId zzd;
    final boolean zze;
    final String zzf;

    public Contents(ParcelFileDescriptor parcelFileDescriptor, int i, int i2, DriveId driveId, boolean z, String str) {
        this.zza = parcelFileDescriptor;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = driveId;
        this.zze = z;
        this.zzf = str;
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        return this.zza;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ParcelFileDescriptor parcelFileDescriptor = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, parcelFileDescriptor, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzb);
        SafeParcelWriter.writeInt(parcel, 4, this.zzc);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzd, i, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zze);
        SafeParcelWriter.writeString(parcel, 8, this.zzf, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}

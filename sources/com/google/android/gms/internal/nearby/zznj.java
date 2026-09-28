package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zznj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zznj> CREATOR = new zznk();
    final int zza;
    final int zzb;
    final byte[] zzc;
    final boolean zzd;

    zznj(int i, int i2, byte[] bArr, boolean z) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = bArr;
        this.zzd = z;
    }

    public static zznj zza(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        return new zznj(2, new com.google.android.gms.nearby.messages.internal.zzg(com.google.android.gms.nearby.messages.internal.zzg.zzd(String.valueOf(str).concat(str2))).zzc());
    }

    public static zznj zzb(UUID uuid, Short sh, Short sh2) {
        return new zznj(3, new com.google.android.gms.nearby.messages.internal.zzl(uuid, sh, sh2).zzc());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzb);
        SafeParcelWriter.writeByteArray(parcel, 2, this.zzc, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzd);
        SafeParcelWriter.writeInt(parcel, 1000, this.zza);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    private zznj(int i, byte[] bArr) {
        this(1, i, bArr, false);
    }
}

package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzkw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzkw> CREATOR = new zzkx();
    private String zza;
    private int zzb;
    private byte[] zzc;

    private zzkw() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzkw) {
            zzkw zzkwVar = (zzkw) obj;
            if (Objects.equal(this.zza, zzkwVar.zza) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzkwVar.zzb)) && Arrays.equals(this.zzc, zzkwVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(this.zzb), Integer.valueOf(Arrays.hashCode(this.zzc)));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final int zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }

    public final byte[] zzc() {
        return this.zzc;
    }

    zzkw(String str, int i, byte[] bArr) {
        this.zza = str;
        this.zzb = i;
        this.zzc = bArr;
    }
}

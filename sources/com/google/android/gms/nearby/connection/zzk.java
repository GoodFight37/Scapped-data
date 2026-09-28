package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new zzl();
    final byte[] zza;
    private final String zzb;
    private final byte[] zzc;
    private final byte[] zzd;

    zzk(String str, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.zzb = str;
        this.zzc = bArr;
        this.zzd = bArr2;
        this.zza = bArr3;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzk) {
            zzk zzkVar = (zzk) obj;
            if (Objects.equal(this.zzb, zzkVar.zzb) && Arrays.equals(this.zzc, zzkVar.zzc) && Arrays.equals(this.zzd, zzkVar.zzd) && Arrays.equals(this.zza, zzkVar.zza)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzb, Integer.valueOf(Arrays.hashCode(this.zzc)), Integer.valueOf(Arrays.hashCode(this.zzd)), Integer.valueOf(Arrays.hashCode(this.zza)));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzb, false);
        SafeParcelWriter.writeByteArray(parcel, 2, zzb(), false);
        SafeParcelWriter.writeByteArray(parcel, 3, zza(), false);
        SafeParcelWriter.writeByteArray(parcel, 4, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final byte[] zza() {
        byte[] bArr = this.zzd;
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public final byte[] zzb() {
        byte[] bArr = this.zzc;
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public final String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = this.zzb;
        byte[] bArr = this.zzc;
        objArr[1] = bArr == null ? null : Arrays.toString(bArr);
        byte[] bArr2 = this.zza;
        objArr[2] = bArr2 != null ? Arrays.toString(bArr2) : null;
        return String.format("ConnectionsDevice:<endpointId: %s, endpointInfo: %s, connectivityBytes: %s>", objArr);
    }
}

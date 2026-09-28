package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzw> CREATOR = new zzx();
    private byte[] zza;
    private int zzb;
    private int zzc;

    private zzw() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzw) {
            zzw zzwVar = (zzw) obj;
            if (Arrays.equals(this.zza, zzwVar.zza) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzwVar.zzb)) && Objects.equal(Integer.valueOf(this.zzc), Integer.valueOf(zzwVar.zzc))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(Arrays.hashCode(this.zza)), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc));
    }

    public final String toString() {
        return "UwbSenderInfo{address=" + Arrays.toString(this.zza) + ", channel=" + this.zzb + ", preambleIndex=" + this.zzc + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    zzw(byte[] bArr, int i, int i2) {
        this.zza = bArr;
        this.zzb = i;
        this.zzc = i2;
    }
}

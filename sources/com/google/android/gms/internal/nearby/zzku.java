package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzku extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzku> CREATOR = new zzkv();
    private String zza;
    private String zzb;
    private byte[] zzc;

    private zzku() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzku) {
            zzku zzkuVar = (zzku) obj;
            if (Objects.equal(this.zza, zzkuVar.zza) && Objects.equal(this.zzb, zzkuVar.zzb) && Arrays.equals(this.zzc, zzkuVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Integer.valueOf(Arrays.hashCode(this.zzc)));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final String zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final byte[] zzc() {
        return this.zzc;
    }

    zzku(String str, String str2, byte[] bArr) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = bArr;
    }
}

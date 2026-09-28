package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzqq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzqq> CREATOR = new zzqr();
    private byte[] zza;
    private int zzb;

    private zzqq() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzqq) {
            zzqq zzqqVar = (zzqq) obj;
            if (Arrays.equals(this.zza, zzqqVar.zza) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzqqVar.zzb))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(Arrays.hashCode(this.zza)), Integer.valueOf(this.zzb));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final byte[] zzb() {
        return this.zza;
    }

    /* synthetic */ zzqq(zzqp zzqpVar) {
    }

    zzqq(byte[] bArr, int i) {
        this.zza = bArr;
        this.zzb = i;
    }
}

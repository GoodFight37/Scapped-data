package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzpo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzpo> CREATOR = new zzpp();
    private zzrv zza;
    private zzqa zzb;

    private zzpo() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzpo) {
            zzpo zzpoVar = (zzpo) obj;
            if (Objects.equal(this.zza, zzpoVar.zza) && Objects.equal(this.zzb, zzpoVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final zzqa zza() {
        return this.zzb;
    }

    public final zzrv zzb() {
        return this.zza;
    }

    zzpo(zzrv zzrvVar, zzqa zzqaVar) {
        this.zza = zzrvVar;
        this.zzb = zzqaVar;
    }
}

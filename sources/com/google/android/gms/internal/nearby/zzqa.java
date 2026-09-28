package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.uwb.RangingPosition;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzqa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzqa> CREATOR = new zzqb();
    private zzpu zza;
    private zzpu zzb;
    private zzpu zzc;
    private long zzd;
    private final int zze;

    private zzqa() {
        this.zze = RangingPosition.RSSI_UNKNOWN;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzqa) {
            zzqa zzqaVar = (zzqa) obj;
            if (Objects.equal(this.zza, zzqaVar.zza) && Objects.equal(this.zzb, zzqaVar.zzb) && Objects.equal(this.zzc, zzqaVar.zzc) && Objects.equal(Long.valueOf(this.zzd), Long.valueOf(zzqaVar.zzd)) && Objects.equal(Integer.valueOf(this.zze), Integer.valueOf(zzqaVar.zze))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, Long.valueOf(this.zzd), Integer.valueOf(this.zze));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.writeLong(parcel, 4, this.zzd);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final int zza() {
        return this.zze;
    }

    public final long zzb() {
        return this.zzd;
    }

    public final zzpu zzc() {
        return this.zzb;
    }

    public final zzpu zzd() {
        return this.zza;
    }

    public final zzpu zze() {
        return this.zzc;
    }

    zzqa(zzpu zzpuVar, zzpu zzpuVar2, zzpu zzpuVar3, long j, int i) {
        this.zza = zzpuVar;
        this.zzb = zzpuVar2;
        this.zzc = zzpuVar3;
        this.zzd = j;
        this.zze = i;
    }
}

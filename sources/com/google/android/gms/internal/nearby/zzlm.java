package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzlm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzlm> CREATOR = new zzln();
    private int zza;
    private String zzb;

    private zzlm() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzlm) {
            zzlm zzlmVar = (zzlm) obj;
            if (Objects.equal(Integer.valueOf(this.zza), Integer.valueOf(zzlmVar.zza)) && Objects.equal(this.zzb, zzlmVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), this.zzb);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final int zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    zzlm(int i, String str) {
        this.zza = i;
        this.zzb = str;
    }
}

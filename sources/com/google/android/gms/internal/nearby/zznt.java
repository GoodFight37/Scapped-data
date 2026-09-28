package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zznt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zznt> CREATOR = new zznu();
    private final int zza;

    zznt(int i) {
        this.zza = i;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zznt) && this.zza == ((zznt) obj).zza;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza));
    }

    public final String toString() {
        return "PresenceAction[action=" + this.zza + ']';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}

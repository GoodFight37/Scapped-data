package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzlg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzlg> CREATOR = new zzlh();
    private String zza;
    private final int zzb;
    private com.google.android.gms.nearby.connection.zzk zzc;

    private zzlg() {
        this.zzb = 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzlg) {
            zzlg zzlgVar = (zzlg) obj;
            if (Objects.equal(this.zza, zzlgVar.zza) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzlgVar.zzb)) && Objects.equal(this.zzc, zzlgVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(this.zzb), this.zzc);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final String zza() {
        return this.zza;
    }

    zzlg(String str, int i, com.google.android.gms.nearby.connection.zzk zzkVar) {
        this.zza = str;
        this.zzb = i;
        this.zzc = zzkVar;
    }
}

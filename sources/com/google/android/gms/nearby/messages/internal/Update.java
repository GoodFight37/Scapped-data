package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.ArraySet;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.nearby.zzng;
import com.google.android.gms.internal.nearby.zznh;
import com.google.android.gms.nearby.messages.Message;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public class Update extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Update> CREATOR = new zzci();
    final int zza;
    final int zzb;
    public final Message zzc;
    public final zze zzd;
    public final zza zze;
    public final zznh zzf;
    public final byte[] zzg;

    Update(int i, int i2, Message message, zze zzeVar, zza zzaVar, zznh zznhVar, byte[] bArr) {
        this.zza = i;
        boolean zZzb = zzb(i2, 2);
        this.zzb = true == zZzb ? 2 : i2;
        this.zzc = message;
        this.zzd = true == zZzb ? null : zzeVar;
        this.zze = true == zZzb ? null : zzaVar;
        this.zzf = true == zZzb ? null : zznhVar;
        this.zzg = true == zZzb ? null : bArr;
    }

    public static boolean zzb(int i, int i2) {
        return (i & i2) != 0;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Update)) {
            return false;
        }
        Update update = (Update) obj;
        return this.zzb == update.zzb && Objects.equal(this.zzc, update.zzc) && Objects.equal(this.zzd, update.zzd) && Objects.equal(this.zze, update.zze) && Objects.equal(this.zzf, update.zzf) && Arrays.equals(this.zzg, update.zzg);
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzb), this.zzc, this.zzd, this.zze, this.zzf, this.zzg);
    }

    public final String toString() {
        ArraySet arraySet = new ArraySet();
        if (zzb(this.zzb, 1)) {
            arraySet.add("FOUND");
        }
        if (zzb(this.zzb, 2)) {
            arraySet.add("LOST");
        }
        if (zzb(this.zzb, 4)) {
            arraySet.add("DISTANCE");
        }
        if (zzb(this.zzb, 8)) {
            arraySet.add("BLE_SIGNAL");
        }
        if (zzb(this.zzb, 16)) {
            arraySet.add("DEVICE");
        }
        if (zzb(this.zzb, 32)) {
            arraySet.add("BLE_RECORD");
        }
        return "Update{types=" + arraySet.toString() + ", message=" + String.valueOf(this.zzc) + ", distance=" + String.valueOf(this.zzd) + ", bleSignal=" + String.valueOf(this.zze) + ", device=" + String.valueOf(this.zzf) + ", bleRecord=" + String.valueOf(zzng.zza(this.zzg)) + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.writeByteArray(parcel, 7, this.zzg, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final boolean zza(int i) {
        return zzb(this.zzb, i);
    }
}

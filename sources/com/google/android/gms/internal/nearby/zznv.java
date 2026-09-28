package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zznv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zznv> CREATOR = new zznw();
    private final long zza;
    private final String zzb;
    private final int zzc;
    private final String zzd;
    private final long zze;
    private final String zzf;
    private final byte[] zzg;
    private final byte[] zzh;
    private final List zzi;
    private final int zzj;
    private final byte[] zzk;

    zznv(long j, String str, int i, String str2, long j2, String str3, byte[] bArr, byte[] bArr2, List list, int i2, byte[] bArr3) {
        this.zza = j;
        this.zzb = str;
        this.zzc = i;
        this.zzd = str2;
        this.zze = j2;
        this.zzf = str3;
        this.zzg = bArr;
        this.zzh = bArr2;
        this.zzi = list;
        this.zzj = i2;
        this.zzk = bArr3;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zznv) {
            zznv zznvVar = (zznv) obj;
            if (Objects.equal(Long.valueOf(this.zza), Long.valueOf(zznvVar.zza)) && Objects.equal(this.zzb, zznvVar.zzb) && Objects.equal(Integer.valueOf(this.zzc), Integer.valueOf(zznvVar.zzc)) && Objects.equal(this.zzd, zznvVar.zzd) && Objects.equal(this.zzf, zznvVar.zzf) && Arrays.equals(this.zzg, zznvVar.zzg) && Arrays.equals(this.zzh, zznvVar.zzh) && Objects.equal(this.zzi, zznvVar.zzi) && Objects.equal(Integer.valueOf(this.zzj), Integer.valueOf(zznvVar.zzj)) && Arrays.equals(this.zzk, zznvVar.zzk)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), this.zzb, Integer.valueOf(this.zzc), this.zzd, this.zzf, Integer.valueOf(Arrays.hashCode(this.zzg)), Integer.valueOf(Arrays.hashCode(this.zzh)), this.zzi, Integer.valueOf(this.zzj), Integer.valueOf(Arrays.hashCode(this.zzk)));
    }

    public final String toString() {
        Object[] objArr = new Object[11];
        objArr[0] = Long.valueOf(this.zza);
        objArr[1] = this.zzb;
        objArr[2] = Integer.valueOf(this.zzc);
        objArr[3] = this.zzd;
        objArr[4] = Long.valueOf(this.zze);
        objArr[5] = this.zzf;
        byte[] bArr = this.zzg;
        objArr[6] = bArr == null ? null : Arrays.toString(bArr);
        byte[] bArr2 = this.zzh;
        objArr[7] = bArr2 == null ? null : Integer.valueOf(Arrays.hashCode(bArr2));
        objArr[8] = this.zzi;
        objArr[9] = Integer.valueOf(this.zzj);
        byte[] bArr3 = this.zzk;
        objArr[10] = bArr3 != null ? Arrays.toString(bArr3) : null;
        return String.format("PresenceDevice:<deviceId: %s, deviceName: %s, deviceType: %s, deviceImageUrl: %s, discoveryTimestampMillis: %s, endpointId: %s, endpointInfo: %s, bluetoothMacAddress hash: %s, actions: %s, identityType: %s, connectivityBytes hash: %s>", objArr);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.zza);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zze);
        SafeParcelWriter.writeString(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeByteArray(parcel, 7, zzb(), false);
        SafeParcelWriter.writeByteArray(parcel, 8, zza(), false);
        List list = this.zzi;
        SafeParcelWriter.writeTypedList(parcel, 9, list == null ? zzsq.zzl() : zzsq.zzk(list), false);
        SafeParcelWriter.writeInt(parcel, 10, this.zzj);
        SafeParcelWriter.writeByteArray(parcel, 11, this.zzk, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final byte[] zza() {
        byte[] bArr = this.zzh;
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public final byte[] zzb() {
        byte[] bArr = this.zzg;
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }
}

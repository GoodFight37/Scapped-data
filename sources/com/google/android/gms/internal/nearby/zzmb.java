package com.google.android.gms.internal.nearby;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzmb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzmb> CREATOR = new zzmc();
    private long zza;
    private int zzb;
    private byte[] zzc;
    private ParcelFileDescriptor zzd;
    private String zze;
    private long zzf;
    private ParcelFileDescriptor zzg;
    private Uri zzh;
    private long zzi;
    private boolean zzj;
    private zzlx zzk;
    private long zzl;
    private String zzm;
    private String zzn;

    private zzmb() {
        this.zzf = -1L;
        this.zzi = 0L;
        this.zzj = false;
        this.zzl = 0L;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzmb) {
            zzmb zzmbVar = (zzmb) obj;
            if (Objects.equal(Long.valueOf(this.zza), Long.valueOf(zzmbVar.zza)) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzmbVar.zzb)) && Arrays.equals(this.zzc, zzmbVar.zzc) && Objects.equal(this.zzd, zzmbVar.zzd) && Objects.equal(this.zze, zzmbVar.zze) && Objects.equal(Long.valueOf(this.zzf), Long.valueOf(zzmbVar.zzf)) && Objects.equal(this.zzg, zzmbVar.zzg) && Objects.equal(this.zzh, zzmbVar.zzh) && Objects.equal(Long.valueOf(this.zzi), Long.valueOf(zzmbVar.zzi)) && Objects.equal(Boolean.valueOf(this.zzj), Boolean.valueOf(zzmbVar.zzj)) && Objects.equal(this.zzk, zzmbVar.zzk) && Objects.equal(Long.valueOf(this.zzl), Long.valueOf(zzmbVar.zzl)) && Objects.equal(this.zzm, zzmbVar.zzm) && Objects.equal(this.zzn, zzmbVar.zzn)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(Arrays.hashCode(this.zzc)), this.zzd, this.zze, Long.valueOf(this.zzf), this.zzg, this.zzh, Long.valueOf(this.zzi), Boolean.valueOf(this.zzj), this.zzk, Long.valueOf(this.zzl), this.zzm, this.zzn);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeLong(parcel, 6, this.zzf);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzh, i, false);
        SafeParcelWriter.writeLong(parcel, 9, this.zzi);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzj);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzk, i, false);
        SafeParcelWriter.writeLong(parcel, 12, this.zzl);
        SafeParcelWriter.writeString(parcel, 13, this.zzm, false);
        SafeParcelWriter.writeString(parcel, 14, this.zzn, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final int zza() {
        return this.zzb;
    }

    public final long zzb() {
        return this.zza;
    }

    public final long zzc() {
        return this.zzf;
    }

    public final Uri zzd() {
        return this.zzh;
    }

    public final ParcelFileDescriptor zze() {
        return this.zzd;
    }

    public final ParcelFileDescriptor zzf() {
        return this.zzg;
    }

    public final zzlx zzg() {
        return this.zzk;
    }

    public final String zzh() {
        return this.zze;
    }

    public final byte[] zzv() {
        return this.zzc;
    }

    zzmb(long j, int i, byte[] bArr, ParcelFileDescriptor parcelFileDescriptor, String str, long j2, ParcelFileDescriptor parcelFileDescriptor2, Uri uri, long j3, boolean z, zzlx zzlxVar, long j4, String str2, String str3) {
        this.zza = j;
        this.zzb = i;
        this.zzc = bArr;
        this.zzd = parcelFileDescriptor;
        this.zze = str;
        this.zzf = j2;
        this.zzg = parcelFileDescriptor2;
        this.zzh = uri;
        this.zzi = j3;
        this.zzj = z;
        this.zzk = zzlxVar;
        this.zzl = j4;
        this.zzm = str2;
        this.zzn = str3;
    }

    /* synthetic */ zzmb(zzma zzmaVar) {
        this.zzf = -1L;
        this.zzi = 0L;
        this.zzj = false;
        this.zzl = 0L;
    }
}

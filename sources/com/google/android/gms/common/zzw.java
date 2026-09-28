package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.6.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzw> CREATOR = new zzx();
    private final String zza;

    @Nullable
    private final zzm zzb;
    private final boolean zzc;
    private final boolean zzd;

    zzw(String str, @Nullable IBinder iBinder, boolean z, boolean z2) {
        this.zza = str;
        zzn zznVar = null;
        if (iBinder != null) {
            try {
                IObjectWrapper iObjectWrapperZzd = com.google.android.gms.common.internal.zzy.zzg(iBinder).zzd();
                byte[] bArr = iObjectWrapperZzd == null ? null : (byte[]) ObjectWrapper.unwrap(iObjectWrapperZzd);
                if (bArr != null) {
                    zznVar = new zzn(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e);
            }
        }
        this.zzb = zznVar;
        this.zzc = z;
        this.zzd = z2;
    }

    zzw(String str, @Nullable zzm zzmVar, boolean z, boolean z2) {
        this.zza = str;
        this.zzb = zzmVar;
        this.zzc = z;
        this.zzd = z2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, str, false);
        zzm zzmVar = this.zzb;
        if (zzmVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            zzmVar = null;
        }
        SafeParcelWriter.writeIBinder(parcel, 2, zzmVar, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}

package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzef extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzef> CREATOR = new zzeg();
    private List zza;
    private IStatusCallback zzb;
    private List zzc;
    private ExposureConfiguration zzd;
    private String zze;
    private zzcv zzf;

    private zzef() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzef) {
            zzef zzefVar = (zzef) obj;
            if (Objects.equal(this.zza, zzefVar.zza) && Objects.equal(this.zzb, zzefVar.zzb) && Objects.equal(this.zzc, zzefVar.zzc) && Objects.equal(this.zzd, zzefVar.zzd) && Objects.equal(this.zze, zzefVar.zze) && Objects.equal(this.zzf, zzefVar.zzf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.zza, false);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzb.asBinder(), false);
        SafeParcelWriter.writeTypedList(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        zzcv zzcvVar = this.zzf;
        SafeParcelWriter.writeIBinder(parcel, 6, zzcvVar == null ? null : zzcvVar.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    /* synthetic */ zzef(zzee zzeeVar) {
    }

    zzef(List list, IBinder iBinder, List list2, ExposureConfiguration exposureConfiguration, String str, IBinder iBinder2) {
        zzcv zzctVar;
        IStatusCallback iStatusCallbackAsInterface = IStatusCallback.Stub.asInterface(iBinder);
        if (iBinder2 == null) {
            zzctVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IDiagnosisKeyFileSupplier");
            zzctVar = iInterfaceQueryLocalInterface instanceof zzcv ? (zzcv) iInterfaceQueryLocalInterface : new zzct(iBinder2);
        }
        this.zza = list;
        this.zzb = iStatusCallbackAsInterface;
        this.zzc = list2;
        this.zzd = exposureConfiguration;
        this.zze = str;
        this.zzf = zzctVar;
    }
}

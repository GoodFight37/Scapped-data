package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzy implements Parcelable.Creator<zzz> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzz createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzaf zzafVar = null;
        zzx zzxVar = null;
        com.google.firebase.auth.zzc zzcVar = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 1) {
                zzafVar = (zzaf) SafeParcelReader.createParcelable(parcel, header, zzaf.CREATOR);
            } else if (fieldId == 2) {
                zzxVar = (zzx) SafeParcelReader.createParcelable(parcel, header, zzx.CREATOR);
            } else if (fieldId != 3) {
                SafeParcelReader.skipUnknownField(parcel, header);
            } else {
                zzcVar = (com.google.firebase.auth.zzc) SafeParcelReader.createParcelable(parcel, header, com.google.firebase.auth.zzc.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzz(zzafVar, zzxVar, zzcVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzz[] newArray(int i) {
        return new zzz[i];
    }
}

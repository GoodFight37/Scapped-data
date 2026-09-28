package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzjm implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        com.google.android.gms.nearby.connection.zzk zzkVar = null;
        int i = 0;
        zznv zznvVar = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 1) {
                strCreateString = SafeParcelReader.createString(parcel, header);
            } else if (fieldId == 2) {
                i = SafeParcelReader.readInt(parcel, header);
            } else if (fieldId == 3) {
                zznvVar = (zznv) SafeParcelReader.createParcelable(parcel, header, zznv.CREATOR);
            } else if (fieldId != 4) {
                SafeParcelReader.skipUnknownField(parcel, header);
            } else {
                zzkVar = (com.google.android.gms.nearby.connection.zzk) SafeParcelReader.createParcelable(parcel, header, com.google.android.gms.nearby.connection.zzk.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzjl(strCreateString, i, zznvVar, zzkVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzjl[i];
    }
}

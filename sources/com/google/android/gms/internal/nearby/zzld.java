package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzld implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        com.google.android.gms.nearby.connection.zzu zzuVar = null;
        com.google.android.gms.nearby.connection.zzk zzkVar = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 1) {
                strCreateString = SafeParcelReader.createString(parcel, header);
            } else if (fieldId == 2) {
                i = SafeParcelReader.readInt(parcel, header);
            } else if (fieldId == 3) {
                zzuVar = (com.google.android.gms.nearby.connection.zzu) SafeParcelReader.createParcelable(parcel, header, com.google.android.gms.nearby.connection.zzu.CREATOR);
            } else if (fieldId == 4) {
                i2 = SafeParcelReader.readInt(parcel, header);
            } else if (fieldId != 5) {
                SafeParcelReader.skipUnknownField(parcel, header);
            } else {
                zzkVar = (com.google.android.gms.nearby.connection.zzk) SafeParcelReader.createParcelable(parcel, header, com.google.android.gms.nearby.connection.zzk.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzlc(strCreateString, i, zzuVar, i2, zzkVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzlc[i];
    }
}

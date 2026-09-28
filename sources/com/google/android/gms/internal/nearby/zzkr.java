package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzkr implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        zznv zznvVar = null;
        com.google.android.gms.nearby.connection.zzk zzkVar = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 2:
                    i = SafeParcelReader.readInt(parcel, header);
                    break;
                case 3:
                    i2 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 4:
                    i3 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 5:
                    zznvVar = (zznv) SafeParcelReader.createParcelable(parcel, header, zznv.CREATOR);
                    break;
                case 6:
                    zzkVar = (com.google.android.gms.nearby.connection.zzk) SafeParcelReader.createParcelable(parcel, header, com.google.android.gms.nearby.connection.zzk.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzkq(strCreateString, i, i2, i3, zznvVar, zzkVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzkq[i];
    }
}

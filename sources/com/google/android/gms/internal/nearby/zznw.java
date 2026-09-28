package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zznw implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        byte[] bArrCreateByteArray = null;
        byte[] bArrCreateByteArray2 = null;
        ArrayList arrayListCreateTypedList = null;
        byte[] bArrCreateByteArray3 = null;
        int i = 0;
        int i2 = 0;
        long j = 0;
        long j2 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    j = SafeParcelReader.readLong(parcel, header);
                    break;
                case 2:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 3:
                    i = SafeParcelReader.readInt(parcel, header);
                    break;
                case 4:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    break;
                case 5:
                    j2 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 6:
                    strCreateString3 = SafeParcelReader.createString(parcel, header);
                    break;
                case 7:
                    bArrCreateByteArray = SafeParcelReader.createByteArray(parcel, header);
                    break;
                case 8:
                    bArrCreateByteArray2 = SafeParcelReader.createByteArray(parcel, header);
                    break;
                case 9:
                    arrayListCreateTypedList = SafeParcelReader.createTypedList(parcel, header, zznt.CREATOR);
                    break;
                case 10:
                    i2 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 11:
                    bArrCreateByteArray3 = SafeParcelReader.createByteArray(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zznv(j, strCreateString, i, strCreateString2, j2, strCreateString3, bArrCreateByteArray, bArrCreateByteArray2, arrayListCreateTypedList, i2, bArrCreateByteArray3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zznv[i];
    }
}

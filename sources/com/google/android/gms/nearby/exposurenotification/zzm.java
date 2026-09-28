package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzm implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        ArrayList arrayListCreateTypedList = null;
        String strCreateString = null;
        long j = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    j = SafeParcelReader.readLong(parcel, header);
                    break;
                case 2:
                    arrayListCreateTypedList = SafeParcelReader.createTypedList(parcel, header, ScanInstance.CREATOR);
                    break;
                case 3:
                    i = SafeParcelReader.readInt(parcel, header);
                    break;
                case 4:
                    i2 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 5:
                    i3 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 6:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 7:
                    i4 = SafeParcelReader.readInt(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new ExposureWindow(j, arrayListCreateTypedList, i, i2, i3, strCreateString, i4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new ExposureWindow[i];
    }
}

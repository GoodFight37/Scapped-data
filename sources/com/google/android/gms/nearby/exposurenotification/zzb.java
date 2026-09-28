package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzb implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        double d = 0.0d;
        int i = 0;
        ArrayList<Double> arrayListCreateDoubleList = null;
        ArrayList<Double> arrayListCreateDoubleList2 = null;
        ArrayList<Integer> arrayListCreateIntegerList = null;
        ArrayList<Double> arrayListCreateDoubleList3 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    arrayListCreateDoubleList = SafeParcelReader.createDoubleList(parcel, header);
                    break;
                case 2:
                    arrayListCreateDoubleList2 = SafeParcelReader.createDoubleList(parcel, header);
                    break;
                case 3:
                    arrayListCreateIntegerList = SafeParcelReader.createIntegerList(parcel, header);
                    break;
                case 4:
                    arrayListCreateDoubleList3 = SafeParcelReader.createDoubleList(parcel, header);
                    break;
                case 5:
                    i = SafeParcelReader.readInt(parcel, header);
                    break;
                case 6:
                    d = SafeParcelReader.readDouble(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new DailySummariesConfig(arrayListCreateDoubleList, arrayListCreateDoubleList2, arrayListCreateIntegerList, arrayListCreateDoubleList3, i, d);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new DailySummariesConfig[i];
    }
}

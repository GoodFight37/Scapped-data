package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ArrayList arrayListCreateTypedList = null;
        String strCreateString = null;
        int i = 0;
        DailySummary.ExposureSummaryData exposureSummaryData = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 1) {
                i = SafeParcelReader.readInt(parcel, header);
            } else if (fieldId == 2) {
                arrayListCreateTypedList = SafeParcelReader.createTypedList(parcel, header, DailySummary.ExposureSummaryData.CREATOR);
            } else if (fieldId == 3) {
                exposureSummaryData = (DailySummary.ExposureSummaryData) SafeParcelReader.createParcelable(parcel, header, DailySummary.ExposureSummaryData.CREATOR);
            } else if (fieldId != 4) {
                SafeParcelReader.skipUnknownField(parcel, header);
            } else {
                strCreateString = SafeParcelReader.createString(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new DailySummary(i, arrayListCreateTypedList, exposureSummaryData, strCreateString);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new DailySummary[i];
    }
}

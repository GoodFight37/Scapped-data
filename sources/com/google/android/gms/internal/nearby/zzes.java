package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzes implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        IBinder iBinder = null;
        DiagnosisKeysDataMapping diagnosisKeysDataMapping = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 1) {
                iBinder = SafeParcelReader.readIBinder(parcel, header);
            } else if (fieldId != 2) {
                SafeParcelReader.skipUnknownField(parcel, header);
            } else {
                diagnosisKeysDataMapping = (DiagnosisKeysDataMapping) SafeParcelReader.createParcelable(parcel, header, DiagnosisKeysDataMapping.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzer(iBinder, diagnosisKeysDataMapping);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzer[i];
    }
}

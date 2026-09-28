package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzeg implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ArrayList arrayListCreateTypedList = null;
        IBinder iBinder = null;
        ArrayList arrayListCreateTypedList2 = null;
        ExposureConfiguration exposureConfiguration = null;
        String strCreateString = null;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    arrayListCreateTypedList = SafeParcelReader.createTypedList(parcel, header, TemporaryExposureKey.CREATOR);
                    break;
                case 2:
                    iBinder = SafeParcelReader.readIBinder(parcel, header);
                    break;
                case 3:
                    arrayListCreateTypedList2 = SafeParcelReader.createTypedList(parcel, header, ParcelFileDescriptor.CREATOR);
                    break;
                case 4:
                    exposureConfiguration = (ExposureConfiguration) SafeParcelReader.createParcelable(parcel, header, ExposureConfiguration.CREATOR);
                    break;
                case 5:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 6:
                    iBinder2 = SafeParcelReader.readIBinder(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzef(arrayListCreateTypedList, iBinder, arrayListCreateTypedList2, exposureConfiguration, strCreateString, iBinder2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzef[i];
    }
}

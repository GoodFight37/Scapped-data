package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzfk implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        String strCreateString = null;
        byte[] bArrCreateByteArray = null;
        IBinder iBinder3 = null;
        zznv zznvVar = null;
        com.google.android.gms.nearby.connection.zzk zzkVar = null;
        int i = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    iBinder = SafeParcelReader.readIBinder(parcel, header);
                    break;
                case 2:
                    iBinder2 = SafeParcelReader.readIBinder(parcel, header);
                    break;
                case 3:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 4:
                    bArrCreateByteArray = SafeParcelReader.createByteArray(parcel, header);
                    break;
                case 5:
                    iBinder3 = SafeParcelReader.readIBinder(parcel, header);
                    break;
                case 6:
                    i = SafeParcelReader.readInt(parcel, header);
                    break;
                case 7:
                    zznvVar = (zznv) SafeParcelReader.createParcelable(parcel, header, zznv.CREATOR);
                    break;
                case 8:
                    zzkVar = (com.google.android.gms.nearby.connection.zzk) SafeParcelReader.createParcelable(parcel, header, com.google.android.gms.nearby.connection.zzk.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzfj(iBinder, iBinder2, strCreateString, bArrCreateByteArray, iBinder3, i, zznvVar, zzkVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzfj[i];
    }
}

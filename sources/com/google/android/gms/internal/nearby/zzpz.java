package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzpz implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        byte[] bArrCreateByteArray = null;
        zzqv zzqvVar = null;
        zzrv[] zzrvVarArr = null;
        byte[] bArrCreateByteArray2 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, header);
                    break;
                case 2:
                    i2 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 3:
                    bArrCreateByteArray = SafeParcelReader.createByteArray(parcel, header);
                    break;
                case 4:
                    zzqvVar = (zzqv) SafeParcelReader.createParcelable(parcel, header, zzqv.CREATOR);
                    break;
                case 5:
                    i3 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 6:
                    zzrvVarArr = (zzrv[]) SafeParcelReader.createTypedArray(parcel, header, zzrv.CREATOR);
                    break;
                case 7:
                    i4 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 8:
                    bArrCreateByteArray2 = SafeParcelReader.createByteArray(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzpy(i, i2, bArrCreateByteArray, zzqvVar, i3, zzrvVarArr, i4, bArrCreateByteArray2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzpy[i];
    }
}

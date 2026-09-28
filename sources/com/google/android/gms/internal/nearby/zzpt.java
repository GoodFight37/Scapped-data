package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzpt implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        float f = 0.0f;
        int[] iArrCreateIntArray = null;
        int[] iArrCreateIntArray2 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    z = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 2:
                    z2 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 3:
                    z3 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 4:
                    i = SafeParcelReader.readInt(parcel, header);
                    break;
                case 5:
                    i2 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 6:
                    iArrCreateIntArray = SafeParcelReader.createIntArray(parcel, header);
                    break;
                case 7:
                    iArrCreateIntArray2 = SafeParcelReader.createIntArray(parcel, header);
                    break;
                case 8:
                    f = SafeParcelReader.readFloat(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzps(z, z2, z3, i, i2, iArrCreateIntArray, iArrCreateIntArray2, f);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzps[i];
    }
}

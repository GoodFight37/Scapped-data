package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzmp implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        IBinder iBinder = null;
        String[] strArrCreateStringArray = null;
        zzmb zzmbVar = null;
        zznv zznvVar = null;
        com.google.android.gms.nearby.connection.zzk zzkVar = null;
        boolean z = false;
        int i = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    iBinder = SafeParcelReader.readIBinder(parcel, header);
                    break;
                case 2:
                    strArrCreateStringArray = SafeParcelReader.createStringArray(parcel, header);
                    break;
                case 3:
                    zzmbVar = (zzmb) SafeParcelReader.createParcelable(parcel, header, zzmb.CREATOR);
                    break;
                case 4:
                    z = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 5:
                    i = SafeParcelReader.readInt(parcel, header);
                    break;
                case 6:
                    zznvVar = (zznv) SafeParcelReader.createParcelable(parcel, header, zznv.CREATOR);
                    break;
                case 7:
                    zzkVar = (com.google.android.gms.nearby.connection.zzk) SafeParcelReader.createParcelable(parcel, header, com.google.android.gms.nearby.connection.zzk.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzmo(iBinder, strArrCreateStringArray, zzmbVar, z, i, zznvVar, zzkVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzmo[i];
    }
}

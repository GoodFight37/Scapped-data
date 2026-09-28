package com.google.android.gms.games.internal.v2.appshortcuts;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.PersistableBundle;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzj implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        PersistableBundle persistableBundle = null;
        Boolean booleanObject = null;
        Boolean booleanObject2 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 1) {
                strCreateString = SafeParcelReader.createString(parcel, header);
            } else if (fieldId == 2) {
                persistableBundle = (PersistableBundle) SafeParcelReader.createParcelable(parcel, header, PersistableBundle.CREATOR);
            } else if (fieldId == 3) {
                booleanObject = SafeParcelReader.readBooleanObject(parcel, header);
            } else if (fieldId != 4) {
                SafeParcelReader.skipUnknownField(parcel, header);
            } else {
                booleanObject2 = SafeParcelReader.readBooleanObject(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzi(strCreateString, persistableBundle, booleanObject, booleanObject2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzi[i];
    }
}

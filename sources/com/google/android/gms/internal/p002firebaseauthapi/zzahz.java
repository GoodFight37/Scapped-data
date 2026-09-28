package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzahz implements Parcelable.Creator<zzaia> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaia createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            SafeParcelReader.getFieldId(header);
            SafeParcelReader.skipUnknownField(parcel, header);
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzaia();
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaia[] newArray(int i) {
        return new zzaia[i];
    }
}

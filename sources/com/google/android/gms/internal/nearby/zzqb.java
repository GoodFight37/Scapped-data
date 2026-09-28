package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzqb implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = -128;
        long j = 0;
        zzpu zzpuVar = null;
        zzpu zzpuVar2 = null;
        zzpu zzpuVar3 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 1) {
                zzpuVar = (zzpu) SafeParcelReader.createParcelable(parcel, header, zzpu.CREATOR);
            } else if (fieldId == 2) {
                zzpuVar2 = (zzpu) SafeParcelReader.createParcelable(parcel, header, zzpu.CREATOR);
            } else if (fieldId == 3) {
                zzpuVar3 = (zzpu) SafeParcelReader.createParcelable(parcel, header, zzpu.CREATOR);
            } else if (fieldId == 4) {
                j = SafeParcelReader.readLong(parcel, header);
            } else if (fieldId != 5) {
                SafeParcelReader.skipUnknownField(parcel, header);
            } else {
                i = SafeParcelReader.readInt(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzqa(zzpuVar, zzpuVar2, zzpuVar3, j, i);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzqa[i];
    }
}

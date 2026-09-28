package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.nearby.zznh;
import com.google.android.gms.nearby.messages.Message;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzci implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Message message = null;
        zze zzeVar = null;
        zza zzaVar = null;
        zznh zznhVar = null;
        byte[] bArrCreateByteArray = null;
        int i = 0;
        int i2 = 0;
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
                    message = (Message) SafeParcelReader.createParcelable(parcel, header, Message.CREATOR);
                    break;
                case 4:
                    zzeVar = (zze) SafeParcelReader.createParcelable(parcel, header, zze.CREATOR);
                    break;
                case 5:
                    zzaVar = (zza) SafeParcelReader.createParcelable(parcel, header, zza.CREATOR);
                    break;
                case 6:
                    zznhVar = (zznh) SafeParcelReader.createParcelable(parcel, header, zznh.CREATOR);
                    break;
                case 7:
                    bArrCreateByteArray = SafeParcelReader.createByteArray(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new Update(i, i2, message, zzeVar, zzaVar, zznhVar, bArrCreateByteArray);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new Update[i];
    }
}

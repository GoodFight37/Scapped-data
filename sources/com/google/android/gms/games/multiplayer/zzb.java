package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
public class zzb implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new ParticipantEntity[i];
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public ParticipantEntity createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            SafeParcelReader.getFieldId(header);
            SafeParcelReader.skipUnknownField(parcel, header);
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new ParticipantEntity();
    }
}

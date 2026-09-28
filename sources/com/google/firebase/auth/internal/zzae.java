package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.p002firebaseauthapi.zzagw;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzae implements Parcelable.Creator<zzaf> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaf createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzagw zzagwVar = null;
        zzab zzabVar = null;
        String strCreateString = null;
        String strCreateString2 = null;
        ArrayList arrayListCreateTypedList = null;
        ArrayList<String> arrayListCreateStringList = null;
        String strCreateString3 = null;
        Boolean booleanObject = null;
        zzah zzahVar = null;
        com.google.firebase.auth.zzc zzcVar = null;
        zzbj zzbjVar = null;
        ArrayList arrayListCreateTypedList2 = null;
        boolean z = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    zzagwVar = (zzagw) SafeParcelReader.createParcelable(parcel, header, zzagw.CREATOR);
                    break;
                case 2:
                    zzabVar = (zzab) SafeParcelReader.createParcelable(parcel, header, zzab.CREATOR);
                    break;
                case 3:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 4:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    break;
                case 5:
                    arrayListCreateTypedList = SafeParcelReader.createTypedList(parcel, header, zzab.CREATOR);
                    break;
                case 6:
                    arrayListCreateStringList = SafeParcelReader.createStringList(parcel, header);
                    break;
                case 7:
                    strCreateString3 = SafeParcelReader.createString(parcel, header);
                    break;
                case 8:
                    booleanObject = SafeParcelReader.readBooleanObject(parcel, header);
                    break;
                case 9:
                    zzahVar = (zzah) SafeParcelReader.createParcelable(parcel, header, zzah.CREATOR);
                    break;
                case 10:
                    z = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 11:
                    zzcVar = (com.google.firebase.auth.zzc) SafeParcelReader.createParcelable(parcel, header, com.google.firebase.auth.zzc.CREATOR);
                    break;
                case 12:
                    zzbjVar = (zzbj) SafeParcelReader.createParcelable(parcel, header, zzbj.CREATOR);
                    break;
                case 13:
                    arrayListCreateTypedList2 = SafeParcelReader.createTypedList(parcel, header, com.google.firebase.auth.zzal.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzaf(zzagwVar, zzabVar, strCreateString, strCreateString2, arrayListCreateTypedList, arrayListCreateStringList, strCreateString3, booleanObject, zzahVar, z, zzcVar, zzbjVar, arrayListCreateTypedList2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaf[] newArray(int i) {
        return new zzaf[i];
    }
}

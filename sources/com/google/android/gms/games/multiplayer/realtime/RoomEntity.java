package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class RoomEntity extends GamesDowngradeableSafeParcel {
    public static final Parcelable.Creator<RoomEntity> CREATOR = new zzc();

    RoomEntity() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        if (!shouldDowngrade()) {
            SafeParcelWriter.finishObjectHeader(parcel, SafeParcelWriter.beginObjectHeader(parcel));
            return;
        }
        parcel.writeString("unsupported");
        parcel.writeString("unsupported");
        parcel.writeLong(0L);
        parcel.writeInt(0);
        parcel.writeString("unsupported");
        parcel.writeInt(-1);
        parcel.writeBundle(null);
        parcel.writeInt(0);
    }
}

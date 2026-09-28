package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.nintendo.npf.sdk.infrastructure.MapperConstants;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class EventRef extends DataBufferRef implements Event {
    EventRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object obj) {
        return EventEntity.zzb(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ Event freeze() {
        return new EventEntity(this);
    }

    @Override // com.google.android.gms.games.event.Event
    public final String getDescription() {
        return getString(MapperConstants.SUBSCRIPTION_FIELD_DESCRIPTION);
    }

    @Override // com.google.android.gms.games.event.Event
    public final String getEventId() {
        return getString("external_event_id");
    }

    @Override // com.google.android.gms.games.event.Event
    public final String getFormattedValue() {
        return getString("formatted_value");
    }

    @Override // com.google.android.gms.games.event.Event
    public final Uri getIconImageUri() {
        return parseUri("icon_image_uri");
    }

    @Override // com.google.android.gms.games.event.Event
    public String getIconImageUrl() {
        return getString("icon_image_url");
    }

    @Override // com.google.android.gms.games.event.Event
    public final String getName() {
        return getString(AppMeasurementSdk.ConditionalUserProperty.NAME);
    }

    @Override // com.google.android.gms.games.event.Event
    public final Player getPlayer() {
        return new PlayerRef(this.mDataHolder, this.mDataRow, null);
    }

    @Override // com.google.android.gms.games.event.Event
    public final long getValue() {
        return getLong("value");
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return EventEntity.zza(this);
    }

    @Override // com.google.android.gms.games.event.Event
    public final boolean isVisible() {
        return getBoolean("visibility");
    }

    public final String toString() {
        return EventEntity.zzc(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        new EventEntity(this).writeToParcel(parcel, i);
    }

    @Override // com.google.android.gms.games.event.Event
    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        copyToBuffer(MapperConstants.SUBSCRIPTION_FIELD_DESCRIPTION, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.event.Event
    public final void getFormattedValue(CharArrayBuffer charArrayBuffer) {
        copyToBuffer("formatted_value", charArrayBuffer);
    }

    @Override // com.google.android.gms.games.event.Event
    public final void getName(CharArrayBuffer charArrayBuffer) {
        copyToBuffer(AppMeasurementSdk.ConditionalUserProperty.NAME, charArrayBuffer);
    }
}

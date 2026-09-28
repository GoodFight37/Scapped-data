package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Player;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
public interface Event extends Freezable<Event>, Parcelable {
    String getDescription();

    void getDescription(CharArrayBuffer charArrayBuffer);

    String getEventId();

    String getFormattedValue();

    void getFormattedValue(CharArrayBuffer charArrayBuffer);

    Uri getIconImageUri();

    @Deprecated
    String getIconImageUrl();

    String getName();

    void getName(CharArrayBuffer charArrayBuffer);

    Player getPlayer();

    long getValue();

    boolean isVisible();
}

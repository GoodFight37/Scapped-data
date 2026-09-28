package com.google.android.gms.games.snapshot;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
public interface Snapshot extends Freezable<Snapshot>, Parcelable {
    SnapshotMetadata getMetadata();

    SnapshotContents getSnapshotContents();
}

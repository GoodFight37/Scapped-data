package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.internal.zzg;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class SnapshotEntity extends zzg implements Snapshot {
    public static final Parcelable.Creator<SnapshotEntity> CREATOR = new zzb();
    private final SnapshotMetadataEntity zza;
    private final SnapshotContentsEntity zzb;

    public SnapshotEntity(SnapshotMetadata snapshotMetadata, SnapshotContentsEntity snapshotContentsEntity) {
        this.zza = new SnapshotMetadataEntity(snapshotMetadata);
        this.zzb = snapshotContentsEntity;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Snapshot)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Snapshot snapshot = (Snapshot) obj;
        return Objects.equal(snapshot.getMetadata(), getMetadata()) && Objects.equal(snapshot.getSnapshotContents(), getSnapshotContents());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.common.data.Freezable
    public Snapshot freeze() {
        return this;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ Snapshot freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.snapshot.Snapshot
    public SnapshotMetadata getMetadata() {
        return this.zza;
    }

    @Override // com.google.android.gms.games.snapshot.Snapshot
    public SnapshotContents getSnapshotContents() {
        SnapshotContentsEntity snapshotContentsEntity = this.zzb;
        if (snapshotContentsEntity.isClosed()) {
            return null;
        }
        return snapshotContentsEntity;
    }

    public int hashCode() {
        return Objects.hashCode(getMetadata(), getSnapshotContents());
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("Metadata", getMetadata()).add("HasContents", Boolean.valueOf(getSnapshotContents() != null)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getMetadata(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, getSnapshotContents(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}

package com.google.api.services.pubsub.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class ListSnapshotsResponse extends GenericJson {

    @Key
    private String nextPageToken;

    @Key
    private List<Snapshot> snapshots;

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public ListSnapshotsResponse setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    public List<Snapshot> getSnapshots() {
        return this.snapshots;
    }

    public ListSnapshotsResponse setSnapshots(List<Snapshot> list) {
        this.snapshots = list;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ListSnapshotsResponse set(String str, Object obj) {
        return (ListSnapshotsResponse) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ListSnapshotsResponse clone() {
        return (ListSnapshotsResponse) super.clone();
    }
}

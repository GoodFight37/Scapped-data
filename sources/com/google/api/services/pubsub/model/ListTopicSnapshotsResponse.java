package com.google.api.services.pubsub.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class ListTopicSnapshotsResponse extends GenericJson {

    @Key
    private String nextPageToken;

    @Key
    private List<String> snapshots;

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public ListTopicSnapshotsResponse setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    public List<String> getSnapshots() {
        return this.snapshots;
    }

    public ListTopicSnapshotsResponse setSnapshots(List<String> list) {
        this.snapshots = list;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ListTopicSnapshotsResponse set(String str, Object obj) {
        return (ListTopicSnapshotsResponse) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ListTopicSnapshotsResponse clone() {
        return (ListTopicSnapshotsResponse) super.clone();
    }
}

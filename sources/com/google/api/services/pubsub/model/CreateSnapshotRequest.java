package com.google.api.services.pubsub.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class CreateSnapshotRequest extends GenericJson {

    @Key
    private Map<String, String> labels;

    @Key
    private String subscription;

    public Map<String, String> getLabels() {
        return this.labels;
    }

    public CreateSnapshotRequest setLabels(Map<String, String> map) {
        this.labels = map;
        return this;
    }

    public String getSubscription() {
        return this.subscription;
    }

    public CreateSnapshotRequest setSubscription(String str) {
        this.subscription = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public CreateSnapshotRequest set(String str, Object obj) {
        return (CreateSnapshotRequest) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public CreateSnapshotRequest clone() {
        return (CreateSnapshotRequest) super.clone();
    }
}

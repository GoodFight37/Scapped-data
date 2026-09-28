package com.google.api.services.pubsub.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes2.dex */
public final class SeekRequest extends GenericJson {

    @Key
    private String snapshot;

    @Key
    private String time;

    public String getSnapshot() {
        return this.snapshot;
    }

    public SeekRequest setSnapshot(String str) {
        this.snapshot = str;
        return this;
    }

    public String getTime() {
        return this.time;
    }

    public SeekRequest setTime(String str) {
        this.time = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public SeekRequest set(String str, Object obj) {
        return (SeekRequest) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public SeekRequest clone() {
        return (SeekRequest) super.clone();
    }
}

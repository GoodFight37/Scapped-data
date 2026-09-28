package com.google.api.services.pubsub.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class Snapshot extends GenericJson {

    @Key
    private String expireTime;

    @Key
    private Map<String, String> labels;

    @Key
    private String name;

    @Key
    private String topic;

    public String getExpireTime() {
        return this.expireTime;
    }

    public Snapshot setExpireTime(String str) {
        this.expireTime = str;
        return this;
    }

    public Map<String, String> getLabels() {
        return this.labels;
    }

    public Snapshot setLabels(Map<String, String> map) {
        this.labels = map;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Snapshot setName(String str) {
        this.name = str;
        return this;
    }

    public String getTopic() {
        return this.topic;
    }

    public Snapshot setTopic(String str) {
        this.topic = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Snapshot set(String str, Object obj) {
        return (Snapshot) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Snapshot clone() {
        return (Snapshot) super.clone();
    }
}

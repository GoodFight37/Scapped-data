package com.google.api.services.pubsub.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class Topic extends GenericJson {

    @Key
    private String kmsKeyName;

    @Key
    private Map<String, String> labels;

    @Key
    private MessageStoragePolicy messageStoragePolicy;

    @Key
    private String name;

    @Key
    private Boolean satisfiesPzs;

    @Key
    private SchemaSettings schemaSettings;

    public String getKmsKeyName() {
        return this.kmsKeyName;
    }

    public Topic setKmsKeyName(String str) {
        this.kmsKeyName = str;
        return this;
    }

    public Map<String, String> getLabels() {
        return this.labels;
    }

    public Topic setLabels(Map<String, String> map) {
        this.labels = map;
        return this;
    }

    public MessageStoragePolicy getMessageStoragePolicy() {
        return this.messageStoragePolicy;
    }

    public Topic setMessageStoragePolicy(MessageStoragePolicy messageStoragePolicy) {
        this.messageStoragePolicy = messageStoragePolicy;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Topic setName(String str) {
        this.name = str;
        return this;
    }

    public Boolean getSatisfiesPzs() {
        return this.satisfiesPzs;
    }

    public Topic setSatisfiesPzs(Boolean bool) {
        this.satisfiesPzs = bool;
        return this;
    }

    public SchemaSettings getSchemaSettings() {
        return this.schemaSettings;
    }

    public Topic setSchemaSettings(SchemaSettings schemaSettings) {
        this.schemaSettings = schemaSettings;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Topic set(String str, Object obj) {
        return (Topic) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Topic clone() {
        return (Topic) super.clone();
    }
}

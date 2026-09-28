package com.google.api.services.pubsub.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes2.dex */
public final class SchemaSettings extends GenericJson {

    @Key
    private String encoding;

    @Key
    private String schema;

    public String getEncoding() {
        return this.encoding;
    }

    public SchemaSettings setEncoding(String str) {
        this.encoding = str;
        return this;
    }

    public String getSchema() {
        return this.schema;
    }

    public SchemaSettings setSchema(String str) {
        this.schema = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public SchemaSettings set(String str, Object obj) {
        return (SchemaSettings) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public SchemaSettings clone() {
        return (SchemaSettings) super.clone();
    }
}

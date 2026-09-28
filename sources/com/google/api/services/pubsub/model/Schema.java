package com.google.api.services.pubsub.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes2.dex */
public final class Schema extends GenericJson {

    @Key
    private String definition;

    @Key
    private String name;

    @Key
    private String type;

    public String getDefinition() {
        return this.definition;
    }

    public Schema setDefinition(String str) {
        this.definition = str;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Schema setName(String str) {
        this.name = str;
        return this;
    }

    public String getType() {
        return this.type;
    }

    public Schema setType(String str) {
        this.type = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Schema set(String str, Object obj) {
        return (Schema) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Schema clone() {
        return (Schema) super.clone();
    }
}

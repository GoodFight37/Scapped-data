package com.google.api.services.pubsub.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes2.dex */
public final class ValidateSchemaRequest extends GenericJson {

    @Key
    private Schema schema;

    public Schema getSchema() {
        return this.schema;
    }

    public ValidateSchemaRequest setSchema(Schema schema) {
        this.schema = schema;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ValidateSchemaRequest set(String str, Object obj) {
        return (ValidateSchemaRequest) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ValidateSchemaRequest clone() {
        return (ValidateSchemaRequest) super.clone();
    }
}

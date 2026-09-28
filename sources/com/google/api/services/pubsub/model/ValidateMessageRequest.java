package com.google.api.services.pubsub.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Base64;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes2.dex */
public final class ValidateMessageRequest extends GenericJson {

    @Key
    private String encoding;

    @Key
    private String message;

    @Key
    private String name;

    @Key
    private Schema schema;

    public String getEncoding() {
        return this.encoding;
    }

    public ValidateMessageRequest setEncoding(String str) {
        this.encoding = str;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public byte[] decodeMessage() {
        return Base64.decodeBase64(this.message);
    }

    public ValidateMessageRequest setMessage(String str) {
        this.message = str;
        return this;
    }

    public ValidateMessageRequest encodeMessage(byte[] bArr) {
        this.message = Base64.encodeBase64URLSafeString(bArr);
        return this;
    }

    public String getName() {
        return this.name;
    }

    public ValidateMessageRequest setName(String str) {
        this.name = str;
        return this;
    }

    public Schema getSchema() {
        return this.schema;
    }

    public ValidateMessageRequest setSchema(Schema schema) {
        this.schema = schema;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ValidateMessageRequest set(String str, Object obj) {
        return (ValidateMessageRequest) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ValidateMessageRequest clone() {
        return (ValidateMessageRequest) super.clone();
    }
}

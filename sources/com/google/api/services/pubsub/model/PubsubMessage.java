package com.google.api.services.pubsub.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Base64;
import com.google.api.client.util.Key;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class PubsubMessage extends GenericJson {

    @Key
    private Map<String, String> attributes;

    @Key
    private String data;

    @Key
    private String messageId;

    @Key
    private String orderingKey;

    @Key
    private String publishTime;

    public Map<String, String> getAttributes() {
        return this.attributes;
    }

    public PubsubMessage setAttributes(Map<String, String> map) {
        this.attributes = map;
        return this;
    }

    public String getData() {
        return this.data;
    }

    public byte[] decodeData() {
        return Base64.decodeBase64(this.data);
    }

    public PubsubMessage setData(String str) {
        this.data = str;
        return this;
    }

    public PubsubMessage encodeData(byte[] bArr) {
        this.data = Base64.encodeBase64URLSafeString(bArr);
        return this;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public PubsubMessage setMessageId(String str) {
        this.messageId = str;
        return this;
    }

    public String getOrderingKey() {
        return this.orderingKey;
    }

    public PubsubMessage setOrderingKey(String str) {
        this.orderingKey = str;
        return this;
    }

    public String getPublishTime() {
        return this.publishTime;
    }

    public PubsubMessage setPublishTime(String str) {
        this.publishTime = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public PubsubMessage set(String str, Object obj) {
        return (PubsubMessage) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public PubsubMessage clone() {
        return (PubsubMessage) super.clone();
    }
}

package com.google.api.services.pubsub.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes2.dex */
public final class ReceivedMessage extends GenericJson {

    @Key
    private String ackId;

    @Key
    private Integer deliveryAttempt;

    @Key
    private PubsubMessage message;

    public String getAckId() {
        return this.ackId;
    }

    public ReceivedMessage setAckId(String str) {
        this.ackId = str;
        return this;
    }

    public Integer getDeliveryAttempt() {
        return this.deliveryAttempt;
    }

    public ReceivedMessage setDeliveryAttempt(Integer num) {
        this.deliveryAttempt = num;
        return this;
    }

    public PubsubMessage getMessage() {
        return this.message;
    }

    public ReceivedMessage setMessage(PubsubMessage pubsubMessage) {
        this.message = pubsubMessage;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ReceivedMessage set(String str, Object obj) {
        return (ReceivedMessage) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ReceivedMessage clone() {
        return (ReceivedMessage) super.clone();
    }
}

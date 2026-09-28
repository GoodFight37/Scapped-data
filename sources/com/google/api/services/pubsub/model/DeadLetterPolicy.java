package com.google.api.services.pubsub.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes2.dex */
public final class DeadLetterPolicy extends GenericJson {

    @Key
    private String deadLetterTopic;

    @Key
    private Integer maxDeliveryAttempts;

    public String getDeadLetterTopic() {
        return this.deadLetterTopic;
    }

    public DeadLetterPolicy setDeadLetterTopic(String str) {
        this.deadLetterTopic = str;
        return this;
    }

    public Integer getMaxDeliveryAttempts() {
        return this.maxDeliveryAttempts;
    }

    public DeadLetterPolicy setMaxDeliveryAttempts(Integer num) {
        this.maxDeliveryAttempts = num;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public DeadLetterPolicy set(String str, Object obj) {
        return (DeadLetterPolicy) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public DeadLetterPolicy clone() {
        return (DeadLetterPolicy) super.clone();
    }
}

package com.google.api.services.pubsub.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes2.dex */
public final class PullRequest extends GenericJson {

    @Key
    private Integer maxMessages;

    @Key
    private Boolean returnImmediately;

    public Integer getMaxMessages() {
        return this.maxMessages;
    }

    public PullRequest setMaxMessages(Integer num) {
        this.maxMessages = num;
        return this;
    }

    public Boolean getReturnImmediately() {
        return this.returnImmediately;
    }

    public PullRequest setReturnImmediately(Boolean bool) {
        this.returnImmediately = bool;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public PullRequest set(String str, Object obj) {
        return (PullRequest) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public PullRequest clone() {
        return (PullRequest) super.clone();
    }
}

package com.google.api.services.pubsub.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes2.dex */
public final class RetryPolicy extends GenericJson {

    @Key
    private String maximumBackoff;

    @Key
    private String minimumBackoff;

    public String getMaximumBackoff() {
        return this.maximumBackoff;
    }

    public RetryPolicy setMaximumBackoff(String str) {
        this.maximumBackoff = str;
        return this;
    }

    public String getMinimumBackoff() {
        return this.minimumBackoff;
    }

    public RetryPolicy setMinimumBackoff(String str) {
        this.minimumBackoff = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public RetryPolicy set(String str, Object obj) {
        return (RetryPolicy) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public RetryPolicy clone() {
        return (RetryPolicy) super.clone();
    }
}

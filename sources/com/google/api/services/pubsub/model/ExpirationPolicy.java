package com.google.api.services.pubsub.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* JADX INFO: loaded from: classes2.dex */
public final class ExpirationPolicy extends GenericJson {

    @Key
    private String ttl;

    public String getTtl() {
        return this.ttl;
    }

    public ExpirationPolicy setTtl(String str) {
        this.ttl = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ExpirationPolicy set(String str, Object obj) {
        return (ExpirationPolicy) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ExpirationPolicy clone() {
        return (ExpirationPolicy) super.clone();
    }
}

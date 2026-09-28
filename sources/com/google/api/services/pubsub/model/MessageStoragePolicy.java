package com.google.api.services.pubsub.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class MessageStoragePolicy extends GenericJson {

    @Key
    private List<String> allowedPersistenceRegions;

    public List<String> getAllowedPersistenceRegions() {
        return this.allowedPersistenceRegions;
    }

    public MessageStoragePolicy setAllowedPersistenceRegions(List<String> list) {
        this.allowedPersistenceRegions = list;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public MessageStoragePolicy set(String str, Object obj) {
        return (MessageStoragePolicy) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public MessageStoragePolicy clone() {
        return (MessageStoragePolicy) super.clone();
    }
}

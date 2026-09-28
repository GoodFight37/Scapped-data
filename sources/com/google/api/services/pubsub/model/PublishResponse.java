package com.google.api.services.pubsub.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class PublishResponse extends GenericJson {

    @Key
    private List<String> messageIds;

    public List<String> getMessageIds() {
        return this.messageIds;
    }

    public PublishResponse setMessageIds(List<String> list) {
        this.messageIds = list;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public PublishResponse set(String str, Object obj) {
        return (PublishResponse) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public PublishResponse clone() {
        return (PublishResponse) super.clone();
    }
}

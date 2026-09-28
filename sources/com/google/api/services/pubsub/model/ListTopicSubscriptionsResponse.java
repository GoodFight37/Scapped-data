package com.google.api.services.pubsub.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class ListTopicSubscriptionsResponse extends GenericJson {

    @Key
    private String nextPageToken;

    @Key
    private List<String> subscriptions;

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public ListTopicSubscriptionsResponse setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    public List<String> getSubscriptions() {
        return this.subscriptions;
    }

    public ListTopicSubscriptionsResponse setSubscriptions(List<String> list) {
        this.subscriptions = list;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ListTopicSubscriptionsResponse set(String str, Object obj) {
        return (ListTopicSubscriptionsResponse) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ListTopicSubscriptionsResponse clone() {
        return (ListTopicSubscriptionsResponse) super.clone();
    }
}
